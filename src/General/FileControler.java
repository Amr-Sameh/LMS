package General;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by PC - MeiR on 11/30/2016.
 */
public class FileControler {

    /**
     * This for validate path
     */
    static String checkpath(String path) {
        if (path.charAt(path.length() - 1) != '\\')
            path = path + "\\";
        return path;
    }
//_______________________________________________________________________________

// _______________________________________________________________________________

    public static boolean folderExist(String path, String folderName) {
        path = checkpath(path);
        return new File(path + folderName).exists();
    }
//______________________________________________________________________________

//______________________________________________________________________________

    public synchronized static boolean folderCreat(String path, String folderName) {
        path = checkpath(path);
        boolean q = new File(path + folderName).mkdir();
        if (q)
            return true;
        return false;

    }

//_______________________________________________________________________________

    // _______________________________________________________________________________
    public static boolean removeFolder(String path, String folderName) {
        path = checkpath(path);
        boolean q = new File(path + folderName).delete();
        if (q)
            return true;
        else
            return false;
    }
//________________________________________________________________________

//_________________________________________________________________________

    public static boolean fileExist(String path, String fileName) {
        path = checkpath(path);
        return new File(path + fileName).exists();
    }
//_____________________________________________________________________________________

    //_______________________________________________________________________________________
    public synchronized static boolean filecreat(String path, String fileName) {
        path = checkpath(path);
        try {
            return new File(path + fileName).createNewFile();
        } catch (IOException e) {
            return false;
        }
    }
//__________________________________________________________________________________

//__________________________________________________________________________________

    public static boolean removefile(String path, String filename) {
        path = checkpath(path);
        return new File(path + filename).delete();
    }
//_______________________________________________________________________________

    //__________________________________________________________________________________
    public synchronized static boolean writeInFile(String path, String filename, String data) {
        path = checkpath(path);
        try {
            BufferedWriter Input = new BufferedWriter(new FileWriter(path + filename));
            Input.write(data);
            Input.newLine();
            Input.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

//_______________________________________________________________________

    //_______________________________________________________________________
    public synchronized static boolean appInFile(String path, String filename, String data) {
        path = checkpath(path);
        try {
            BufferedWriter Input = new BufferedWriter(new FileWriter(path + filename, true));
            Input.write(data);
            Input.newLine();
            Input.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
//_______________________________________________________________________

    //_______________________________________________________________________
    public static String returnline(String path, String filename, int line_num) {
        path = checkpath(path);
        String line;
        int i = 1;
        try {
            BufferedReader Output = new BufferedReader(new FileReader(path + filename));
            try {
                while (Output.ready()) {

                    line = Output.readLine();
                    if (i == line_num)
                        return line;
                    i++;
                }
            } catch (IOException e) {
                return null;
            }

        } catch (FileNotFoundException e) {
            return null;

        }
        return null;

    }

//__________________________________________________________________________________

//__________________________________________________________________________________


    public synchronized static boolean appendOb(Object obj, String path, String Filename) {


        try {
            if (new BufferedReader(new FileReader(path + Filename)).readLine() == null) {

                ObjectOutputStream ab = new ObjectOutputStream(new FileOutputStream(path + Filename));
                ArrayList<Object> arr = new ArrayList<Object>();
                arr.add(obj);
                ab.writeObject(arr);
                ab.close();
                return true;
            } else {
                try {
                    ObjectInputStream s = new ObjectInputStream(new FileInputStream(path + Filename));
                    ArrayList<Object> d;
                    try {
                        d = (ArrayList<Object>) s.readObject();
                        d.add(obj);
                        ObjectOutputStream ab = new ObjectOutputStream(new FileOutputStream(path + Filename));
                        ab.writeObject(d);
                        ab.close();
                        return true;

                    } catch (ClassNotFoundException e) {

                        return false;
                    }
                } catch (IOException e) {

                    return false;
                }


            }
        } catch (IOException e) {
            return false;
        }


    }

    public static ArrayList<Object> readobjArraylist(String path, String Filename) {
        try {
            ObjectInputStream ro = new ObjectInputStream(new FileInputStream(path + Filename));
            ArrayList<Object> f = new ArrayList<Object>();
            try {
                f = (ArrayList<Object>) ro.readObject();
                return f;
            } catch (ClassNotFoundException e) {
                return null;
            }

        } catch (IOException e) {
            return null;
        }


    }

    public static Object readobj(String path, String Filename) {
        try {
            ObjectInputStream ro = new ObjectInputStream(new FileInputStream(path + Filename));
            Object f = new Object();
            try {
                f = (Object) ro.readObject();
                return f;
            } catch (ClassNotFoundException e) {
                return null;
            }

        } catch (IOException e) {
            return null;
        }


    }

    public synchronized static boolean writeobj(Object obj, String path, String filename) {
        try {
            ObjectOutputStream wl = new ObjectOutputStream(new FileOutputStream(path + filename));
            wl.writeObject(obj);
            wl.close();
            return true;

        } catch (IOException e) {
            return false;
        }

    }


    public synchronized static boolean writelist(ArrayList<Object> list, String path, String filename) {
        try {
            ObjectOutputStream wl = new ObjectOutputStream(new FileOutputStream(path + filename));
            wl.writeObject(list);
            wl.close();
            return true;

        } catch (IOException e) {
            return false;
        }

    }

    public synchronized static boolean replacpbjct(Object oldObj, Object newObj, ArrayList<Object> list, String path, String filename) {
        boolean check = false;

        while (list.indexOf(oldObj) != -1) {
            list.set(list.indexOf(oldObj), newObj);
            check = true;
        }

        writelist(list, path, filename);
        return check;
    }

    public synchronized static boolean removeobject(Object obj, ArrayList<Object> list, String path, String filename) {
        boolean check = false;
        while (list.indexOf(obj) != -1) {
            list.remove(list.indexOf(obj));
        }

        writelist(list, path, filename);
        return check;
    }

    public static String findFile(String dir, String name) {
        String result = null;
        if (FileControler.fileExist(dir,"")){
            File omer = new File(dir);
            File[] dirlist  = omer.listFiles();

            for(int i = 0; i < dirlist.length; i++) {
                if(dirlist[i].isDirectory()) {
                    result = findFile(String.valueOf(dirlist[i]), name);
                    if (result!=null) break;
                } else if(dirlist[i].getName().matches(name)) {
                    return dirlist[i].toString();
                }
            }
            return result;
        }return null;
    }
    public static ArrayList<String> readlinetolist(String path){
        try {
            BufferedReader bufferedReader=new BufferedReader(new FileReader(path));
            ArrayList<String> list=new ArrayList<>();
            while (bufferedReader.ready())
                list.add(bufferedReader.readLine());
            return list;
        } catch (FileNotFoundException e) {
            return null;
        } catch (IOException e) {
            return null;
        }

    }


    public static void main(String[] args) {


    }

}



