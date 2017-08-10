package General;

import java.util.ArrayList;

/**
 * Created by PC - MeiR on 12/15/2016.
 */
public interface Rejester {

    public abstract ArrayList<Student> generateid(ArrayList<String> names, int level);

    public abstract ArrayList<Student> divideclasses(int level, ArrayList<Student> list) ;

    public abstract void writestuinfo(int level, ArrayList<Student> opj) ;

    public abstract void rejest_student(ArrayList<String> names, int level) ;

    public abstract String rejest_teacher(ArrayList<String> names , String group,String sub);
}
