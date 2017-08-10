package General;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

/**
 * Created by PC - MeiR on 12/4/2016.
 */
public class Admin extends General_Persone implements Rejester {


    /* this functions set id for students*/
    @Override
    public ArrayList<Student> generateid(ArrayList<String> names, int level) {
        String group = "";
        if (level > 0 && level <= 6)
            group = "a";
        else if (level >= 7 && level <= 9)
            group = "b";
        else if (level >= 10 && level <= 12)
            group = "c";
        int NOstudents = 0;
        if (FileControler.readobjArraylist("c:\\LMS\\" + group + "\\lvl" + level + "\\", "allstudents.txt") != null)
            NOstudents = FileControler.readobjArraylist("c:\\LMS\\" + group + "\\lvl" + level + "\\", "allstudents.txt").size();
        int x = Calendar.getInstance().get(Calendar.YEAR);
        int firstId = ((x - level + 1) * 10000) + NOstudents + 1;
        ArrayList<Student> list = new ArrayList<Student>();
        Student newone;
        for (String t : names) {
            if (NOstudents <= 200) {
                newone = new Student();
                newone.setName(t);
                String id = Integer.toString(firstId);
                newone.setId(id);
                newone.setPassword("12345");
                newone.setLevel(level);
                list.add(newone);
                firstId++;
                NOstudents++;
            }
        }

        return list;
    }

    @Override
    public ArrayList<Student> divideclasses(int level, ArrayList<Student> list) {
        int no_stu = list.size(), count = 0, stu_count = 0;
        String group = "";
        if (level > 0 || level <= 6)
            group = "a";
        else if (level >= 7 || level <= 9)
            group = "b";
        else if (level >= 10 || level <= 12)
            group = "c";
        int no_lvl_student = 0, no_class_a_student = 0, no_class_b_student = 0, no_class_c_student = 0, no_class_d_student = 0;
        if (FileControler.readobjArraylist("c:\\LMS\\" + group + "\\lvl" + level + "\\", "allstudents.txt") != null)
            no_lvl_student = FileControler.readobjArraylist("c:\\LMS\\" + group + "\\lvl" + level + "\\", "allstudents.txt").size();
        if (list.size() + no_lvl_student <= 200) {
            if (FileControler.readobjArraylist("c:\\LMS\\" + group + "\\lvl" + level + "\\class-a\\", "allstudents.txt") != null)
                no_class_a_student = FileControler.readobjArraylist("c:\\LMS\\" + group + "\\lvl" + level + "\\class-a\\", "allstudents.txt").size();
            if (FileControler.readobjArraylist("c:\\LMS\\" + group + "\\lvl" + level + "\\class-b\\", "allstudents.txt") != null)
                no_class_b_student = FileControler.readobjArraylist("c:\\LMS\\" + group + "\\lvl" + level + "\\class-b\\", "allstudents.txt").size();
            if (FileControler.readobjArraylist("c:\\LMS\\" + group + "\\lvl" + level + "\\class-c\\", "allstudents.txt") != null)
                no_class_c_student = FileControler.readobjArraylist("c:\\LMS\\" + group + "\\lvl" + level + "\\class-c\\", "allstudents.txt").size();
            if (FileControler.readobjArraylist("c:\\LMS\\" + group + "\\lvl" + level + "\\class-d\\", "allstudents.txt") != null)
                no_class_d_student = FileControler.readobjArraylist("c:\\LMS\\" + group + "\\lvl" + level + "\\class-d\\", "allstudents.txt").size();

            ArrayList<Integer> classes_list = new ArrayList<>();
            classes_list.add(no_class_a_student);
            classes_list.add(no_class_b_student);
            classes_list.add(no_class_c_student);
            classes_list.add(no_class_d_student);
            ArrayList<Integer> copy = classes_list;
            while (no_stu > 0) {
                Collections.sort(copy);
                classes_list.set(classes_list.indexOf(copy.get(0)), classes_list.get(classes_list.indexOf(copy.get(0))) + 1);
                no_stu--;

            }
            no_class_a_student = classes_list.get(0) - no_class_a_student;
            no_class_b_student = classes_list.get(1) - no_class_b_student;
            no_class_c_student = classes_list.get(2) - no_class_c_student;
            no_class_d_student = classes_list.get(3) - no_class_d_student;
            while (count < no_class_a_student) {
                list.get(stu_count).setClasses("class-a");
                count++;
                stu_count++;

            }
            count = 0;
            while (count < no_class_b_student) {
                list.get(stu_count).setClasses("class-b");
                count++;
                stu_count++;

            }
            count = 0;

            while (count < no_class_c_student) {
                list.get(stu_count).setClasses("class-c");
                count++;
                stu_count++;

            }
            count = 0;

            while (count < no_class_d_student) {
                list.get(stu_count).setClasses("class-d");
                count++;
                stu_count++;

            }


            return list;
        } else {
            return null;
        }
    }

    @Override
    public void writestuinfo(int level, ArrayList<Student> opj) {

        String group = "";
        String levelFolder = "lvl" + level;
        if (level > 0 || level <= 6)
            group = "a";
        else if (level >= 7 || level <= 9)
            group = "b";
        else if (level >= 10 || level <= 12)
            group = "c";

        for (int i = 0; i < opj.size(); i++) {
            if (!FileControler.fileExist("c:\\LMS\\" + group + '\\' + levelFolder + '\\' + opj.get(i).getClasses() + '\\', opj.get(i).getId())) {
                FileControler.folderCreat("c:\\LMS\\" + group + '\\' + levelFolder + '\\' + opj.get(i).getClasses() + '\\' + "students\\", opj.get(i).getId());
                if (!FileControler.fileExist("c:\\LMS\\" + group + '\\' + levelFolder + '\\' + opj.get(i).getClasses() + '\\' + "students\\" + opj.get(i).getId() + '\\', opj.get(i).getId() + ".txt"))
                    FileControler.filecreat("c:\\LMS\\" + group + '\\' + levelFolder + '\\' + opj.get(i).getClasses() + '\\' + "students\\" + opj.get(i).getId() + '\\', opj.get(i).getId() + ".txt");
                if (FileControler.fileExist("c:\\LMS\\" + group + '\\' + levelFolder + '\\' + opj.get(i).getClasses() + '\\' + "students\\" + opj.get(i).getId() + '\\', opj.get(i).getId() + ".txt"))
                    FileControler.appendOb(opj.get(i), "c:\\LMS\\" + group + '\\' + levelFolder + '\\' + opj.get(i).getClasses() + '\\' + "students\\" + opj.get(i).getId() + '\\', opj.get(i).getId() + ".txt");
                if (FileControler.fileExist("c:\\LMS\\" + group + '\\' + levelFolder + '\\' + opj.get(i).getClasses() + '\\', "allstudents.txt"))
                    FileControler.appendOb(opj.get(i), "c:\\LMS\\" + group + '\\' + levelFolder + '\\' + opj.get(i).getClasses() + '\\', "allstudents.txt");
                FileControler.appendOb(opj.get(i), "c:\\LMS\\" + group + '\\' + levelFolder + '\\', "allstudents.txt");
                if (FileControler.fileExist("c:\\LMS\\" + group + '\\', "allstudents.txt"))
                    FileControler.appendOb(opj.get(i), "c:\\LMS\\" + group + '\\', "allstudents.txt");
                if (FileControler.fileExist("c:\\LMS\\", "allstudents.txt"))
                    FileControler.appendOb(opj.get(i), "c:\\LMS\\", "allstudents.txt");
                if (FileControler.fileExist("c:\\LMS\\","login.txt"))
                    FileControler.appInFile("c:\\LMS\\","login.txt",opj.get(i).getId()+"#"+opj.get(i).getPassword());
            }

        }
    }

    @Override
    public void rejest_student(ArrayList<String> names, int level) {
        ArrayList<Student> list = generateid(names, level);
        list = divideclasses(level, list);
        writestuinfo(level, list);
    }

    /* this functions set id for reachers*/
    @Override
    public String rejest_teacher(ArrayList<String> names, String group,String sub) {
        int NOteach = 0;
        if(group.equals("Primary"))
            group="a";
        else if (group.equals("middle"))
            group="b";
        else
            group="c";
        if (group.equals("a")) {
            if (FileControler.readobjArraylist("c:\\LMS\\a\\", "allteachers.txt") != null)
                NOteach = FileControler.readobjArraylist("c:\\LMS\\a\\", "allteachers.txt").size();

        } else if (group.equals("b")) {
            if (FileControler.readobjArraylist("c:\\LMS\\b\\", "allteachers.txt") != null)
                NOteach = FileControler.readobjArraylist("c:\\LMS\\b\\", "allteachers.txt").size();
        } else if (group.equals("c")) {
            if (FileControler.readobjArraylist("c:\\LMS\\c\\", "allteachers.txt") != null)
                NOteach = FileControler.readobjArraylist("c:\\LMS\\c\\", "allteachers.txt").size();
        }

        Teacher teacher;
        for (String t : names) {

            teacher = new Teacher();
            teacher.setName(t);
            teacher.setId(group + (NOteach + 1));
            teacher.setStage(group);
            teacher.setSubject(sub);
            teacher.setPassword("12345");
            if(FileControler.fileExist("c:\\LMS\\","allteachers.txt")&&FileControler.fileExist("c:\\LMS\\","login.txt")){
                FileControler.appendOb(teacher, "c:\\LMS\\", "allteachers.txt");
                if (FileControler.fileExist("c:\\LMS\\"+group+"\\","allteachers.txt"))
                    FileControler.appendOb(teacher, "c:\\LMS\\"+group+"\\", "allteachers.txt");

                FileControler.appInFile("c:\\LMS\\","login.txt",teacher.getId()+"#"+teacher.getPassword());

            }
            else return "some error happend";
        }
        return "Done Succesfuly";

    }


}
