package GUI;

import Connection.Connection_methods;
import General.*;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

/**
 * Created by PC - MeiR on 12/17/2016.
 */
public class Managegui {

    public static void runhome(String id) {
        if (id.contains("a") || id.contains("b") || id.contains("c")) {
            Connection_methods.sendorder("$getteacher(" + id + ")");
            Teacher teacher = (Teacher) Connection_methods.rciveobj();
            if (teacher == null)
                JOptionPane.showMessageDialog(null, "Error in User DataBase communicate with Admin ", "Error 404 Not Found", JOptionPane.ERROR_MESSAGE);
            else {
                TeacherPage teacherPage = new TeacherPage(teacher);
            }
        } else if (id.contains("#")) {

            Connection_methods.sendorder("$getobj(" + id + ")");
            Admin person = (Admin) Connection_methods.rciveobj();

            if (person == null)
                JOptionPane.showMessageDialog(null, "Error in User DataBase communicate with Admin ", "Error 404 Not Found", JOptionPane.ERROR_MESSAGE);
            else {
                AdminPage home = new AdminPage(person);
                home.home.name.setText(person.getName());

            }


        } else {
            Connection_methods.sendorder("$getobj(" + id + ")");
            Student person = (Student) Connection_methods.rciveobj();

            if (person == null)
                JOptionPane.showMessageDialog(null, "Error in User DataBase communicate with Admin ", "Error 404 Not Found", JOptionPane.ERROR_MESSAGE);
            else {

                StudentPage home = new StudentPage(person);

            }
        }

    }

    public static void viewgrade(String level, String clas, String sub, String id, String hw_num) {
        Connection_methods.sendorder("$viewgrade(" + level + "," + clas + "&" + sub + "@" + id + "*" + hw_num + ")");
        String re = (String) Connection_methods.rciveobj();
        JOptionPane.showMessageDialog(null, re, "HW " + hw_num + " Grade", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void download_hws(String lvl, String classs, String sub, String hw_num, String path) {
        Connection_methods.sendorder("$downhw(" + lvl + "," + classs + "&" + sub + "*" + hw_num + ")");
        ArrayList<String> assig = (ArrayList<String>) Connection_methods.rciveobj();
        if (assig != null) {
            int length = assig.size();

            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(path + ".txt", true));

                for (int i = 0; i < length; i++) {
                    bw.write(assig.get(i));
                    bw.newLine();
                }
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else
            JOptionPane.showMessageDialog(null, "Error In Download HW File", "Eror 404 Not Found", JOptionPane.ERROR_MESSAGE);

    }


    public static void download_ans(String lvl, String classs, String sub, String hw_num, String path,String id) {
        Connection_methods.sendorder("$viewsolu(" + lvl + "," + classs + "&" + sub + "@"+ id+"*"+ hw_num + ")");
        ArrayList<String> assig = (ArrayList<String>) Connection_methods.rciveobj();
        if (assig != null) {
            int length = assig.size();

            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(path + ".txt", true));

                for (int i = 0; i < length; i++) {
                    bw.write(assig.get(i));
                    bw.newLine();
                }
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else
            JOptionPane.showMessageDialog(null, "Error In Download Seloutin File", "Eror 404 Not Found", JOptionPane.ERROR_MESSAGE);

    }






    public static String add_hw(String lvl, String classs, String sub, File f) {
        String s;
        ArrayList<String> lines = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            while ((s = br.readLine()) != null) {
                lines.add(s);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Connection_methods.sendorder("$addhw(" + lvl + "," + classs + "&" + sub + ")");
        Connection_methods.sendobj(lines);
        s = (String) Connection_methods.rciveobj();
        return s;
    }

    public static String add_solu(String lvl, String classs, String sub, String id, String hw_num, File f) {
        String s;
        if (f != null && f.getAbsolutePath() != "") {
            ArrayList<String> lines = new ArrayList<>();
            try {
                BufferedReader br = new BufferedReader(new FileReader(f));
                while ((s = br.readLine()) != null) {
                    lines.add(s);
                }
                br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            Connection_methods.sendorder("$addsolu(" + lvl + "," + classs + "&" + sub + "@" + id + "*" + hw_num + ")");
            Connection_methods.sendobj(lines);
            s = (String) Connection_methods.rciveobj();
            return s;
        } else return "Chose a File ";
    }

    public static int hw_no(String lvl, String classs, String sub) {
        Connection_methods.sendorder("$hwnumber(" + lvl + "," + classs + "&" + sub + ")");
        int a = (int) Connection_methods.rciveobj(); // 4of lw lzm yrg3 String mmkn t3ml parse int ana 4ofto birg3 int ;
        return a;
    }

    public static String set_grade(String lvl, String classs, String sub, String id, String hw_num, String grade, String comment) {
        Connection_methods.sendorder("$setgrade(" + lvl + "," + classs + "&" + sub + "@" + id + "*" + hw_num + "^" + grade + "%" + comment + ")");
        String msg = (String) Connection_methods.rciveobj();
        return msg;
    }

    public static String edit_hw(String lvl, String classs, String sub, String hw_num, File f) {
        String s;
        ArrayList<String> lines = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            while ((s = br.readLine()) != null) {
                lines.add(s);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Connection_methods.sendorder("$edithw(" + lvl + "," + classs + "&" + sub + "@" + hw_num + ")");
        Connection_methods.sendobj(lines);
        String w = (String) Connection_methods.rciveobj();
        return w;
    }

public static void report(ArrayList<String> list,String path){

    FileControler.filecreat(path,".txt");
    try {
        BufferedWriter w=new BufferedWriter(new FileWriter(path+".txt",true));
        for (String g:list){
            w.write(g);
            w.newLine();

        }
        w.close();
    } catch (IOException e) {
        e.printStackTrace();
    }


}

}
