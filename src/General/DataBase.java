package General;

import java.util.ArrayList;

/**
 * Created by PC - MeiR on 12/8/2016.
 */
public class DataBase {
    public static boolean generate_database() {

        ArrayList<String> lvl1_3=new ArrayList<>();
        lvl1_3.add("arabic");
        lvl1_3.add("math");
        lvl1_3.add("english");
        lvl1_3.add("religion");
        ArrayList <String> lvl4_6=new ArrayList<>();
        lvl4_6.addAll(lvl1_3);
        lvl4_6.add("computer");
        lvl4_6.add("science");
        lvl4_6.add("social stadies");
        ArrayList<String> lvl7_9=new ArrayList<>();
        lvl7_9.addAll(lvl4_6);
        lvl7_9.add("second language");
        lvl7_9.add("patriotism");
        ArrayList<String> lvl10_12=new ArrayList<>();
        lvl10_12.addAll(lvl1_3);
        lvl10_12.add("computer");
        lvl10_12.add("second language");
        lvl10_12.add("patriotism");
        lvl10_12.add("history");
        lvl10_12.add("physics");
        lvl10_12.add("philosophy");
        lvl10_12.add("biology");
        lvl10_12.add("geography");
        lvl10_12.add("chimistry");

        ArrayList<ArrayList<String>> levels_subjects=new ArrayList<ArrayList<String>>();
        levels_subjects.add(lvl1_3);
        levels_subjects.add(lvl1_3);
        levels_subjects.add(lvl1_3);
        levels_subjects.add(lvl4_6);
        levels_subjects.add(lvl4_6);
        levels_subjects.add(lvl4_6);
        levels_subjects.add(lvl7_9);
        levels_subjects.add(lvl7_9);
        levels_subjects.add(lvl7_9);
        levels_subjects.add(lvl10_12);
        levels_subjects.add(lvl10_12);
        levels_subjects.add(lvl10_12);
        //main folder
        if (!FileControler.folderExist("c:\\", "LMS"))
            FileControler.folderCreat("c:\\", "LMS");
        // FileControler.filecreat("c:\\LMS","stu-last.txt");
        //  FileControler.filecreat("c:\\LMS","teach-last-id.txt");
        FileControler.filecreat("c:\\LMS","login.txt");
        FileControler.filecreat("c:\\LMS","allstudents.txt");
        FileControler.filecreat("c:\\LMS","admin.txt");
        FileControler.filecreat("c:\\LMS","allteachers.txt");
        FileControler.filecreat("c:\\LMS","timetable.txt");
        // the main three departments
        for (int i = 1; i <= 3; i++) {
            if (!FileControler.folderExist("c:\\LMS\\", (char) (97 + i-1) + ""))
                FileControler.folderCreat("c:\\LMS\\", (char) (97 + i-1) + "");
            FileControler.filecreat("c:\\LMS\\" + (char) (97 + i-1) +"\\","allteachers.txt");
            FileControler.filecreat("c:\\LMS\\" + (char) (97 + i-1) +"\\","allstudents.txt");
            int lvlnum;
            if (i == 1)
                lvlnum = 6;
            else lvlnum = 3;
            int lvlname = 0;
            if (i == 2) lvlname = 6;
            else if (i == 3) lvlname = 9;
            //the levels
            for (int j = 1; j <= lvlnum; j++) {
                if (!FileControler.folderExist("c:\\LMS\\" + (char) (97 + i-1), "lvl" + (j + lvlname)))
                    FileControler.folderCreat("c:\\LMS\\" + (char) (97 + i-1), "lvl" + (j + lvlname));
                FileControler.filecreat("c:\\LMS\\" + (char) (97 + i-1) +"\\lvl" + (j + lvlname),"classes-obj.txt");
                FileControler.filecreat("c:\\LMS\\" + (char) (97 + i-1) +"\\lvl" + (j + lvlname),"allstudents.txt");
                FileControler.filecreat("c:\\LMS\\" + (char) (97 + i-1) +"\\lvl" + (j + lvlname),"allteachers.txt");
                // the classes
                for (int k = 0; k < 4; k++) {
                    if (!FileControler.folderExist("c:\\LMS\\" +  (char) (97 + i-1) + "\\lvl" + (j + lvlname), "class-" + (char) (97 + k)))
                        FileControler.folderCreat("c:\\LMS\\" +  (char) (97 + i-1) + "\\lvl" + (j + lvlname), "class-" + (char) (97 + k));
                    FileControler.folderCreat("c:\\LMS\\" +  (char) (97 + i-1) + "\\lvl" + (j + lvlname) +"\\class-" + (char) (97 + k),"students");
                    FileControler.folderCreat("c:\\LMS\\" +  (char) (97 + i-1) + "\\lvl" + (j + lvlname) +"\\class-" + (char) (97 + k),"subjects");
                    FileControler.folderCreat("c:\\LMS\\" +  (char) (97 + i-1) + "\\lvl" + (j + lvlname) +"\\class-" + (char) (97 + k),"teachers");
                    FileControler.filecreat("c:\\LMS\\" +  (char) (97 + i-1) + "\\lvl" + (j + lvlname) +"\\class-" + (char) (97 + k),"name+id.txt");
                    FileControler.filecreat("c:\\LMS\\" +  (char) (97 + i-1) + "\\lvl" + (j + lvlname) +"\\class-" + (char) (97 + k),"timetable.txt");
                    FileControler.filecreat("c:\\LMS\\" +  (char) (97 + i-1) + "\\lvl" + (j + lvlname) +"\\class-" + (char) (97 + k),"allstudents.txt");
                    FileControler.filecreat("c:\\LMS\\" +  (char) (97 + i-1) + "\\lvl" + (j + lvlname) +"\\class-" + (char) (97 + k),"allteachers.txt");




                }

            }


        }


        return true;
    }

    public static void main(String[] args) {

        generate_database();
    }
}
