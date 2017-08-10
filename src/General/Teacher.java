package General;

import java.util.ArrayList;

/**
 * Created by PC - MeiR on 12/3/2016.
 */
public class Teacher extends General_Persone{
    private String stage;
    private String subject;

    private ArrayList<Integer> levels = new ArrayList<>();
    private ArrayList<String> classes = new ArrayList<>();
    private int timetable[][] = new int[5][8];

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }


    public ArrayList<Integer> getLevels() {
        return levels;
    }

    public void setLevels(ArrayList<Integer> levels) {
        this.levels = levels;
    }


    public String getStage() {
        return stage;
    }

    public ArrayList<String> getClasses() {
        return classes;
    }


    public void setTimetable(int timetable[][]) {

        this.timetable = timetable;

    }

    public int[][] getTimetable() {
        return timetable;
    }

    public void setClasses(ArrayList<String> classes) {
        this.classes = classes;
    }

    public void setClassesAndlevels(int value) {
        int temp = 10;
        if (value > 100)
            temp = 100;
        if (!this.levels.contains((value / 10))&&(value/10)!=0) {
            this.levels.add(value / 10);
            if (!this.classes.contains((value / 10) + "" + (char) (96 + (value % temp)) + ""))
                this.classes.add((value / 10) + "" + (char) (96 + (value % temp)) + "");
        }

    }

    public void setStage(String stage) {
        this.stage = stage;
    }


}