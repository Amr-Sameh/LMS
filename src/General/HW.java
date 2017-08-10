package General;

import javax.xml.crypto.Data;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TreeMap;

/* *
 * Created by MeGaCrazy on 12/16/2016.
 */
public class HW implements Serializable {


    private ArrayList<String> assig;
    private TreeMap<String, ArrayList<String>> solution;
    private TreeMap<String, String> Grade;
    private ArrayList<String> Empty;
   private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public HW() {
        this.solution = new TreeMap<>();
        this.assig = null;
        this.Grade = new TreeMap<>();
        this.Empty = new ArrayList<>();
        Empty.add("No Information uploaded ... !");
    }

    public void Set_Assig(ArrayList<String> TheAssig) {
        this.assig = TheAssig;
    }

    public ArrayList<String> Get_Assig() {
        return this.assig;
    }

    public void Set_solu(String id, ArrayList<String> solu) {
        this.solution.put(id, solu);
    }

    //will send messege to client


    public ArrayList<String> Get_Solu(String id) {
        if (!solution.containsKey(id)) return this.Empty;
        return this.solution.get(id);
    }

    public void Set_Grade(String id, String grade, String comment) {
        if (comment == null||comment=="") this.Grade.put(id, grade);
        else {
            String s = grade + "   " + comment;

            this.Grade.put(id, s);
        }
    }

    public String Get_Grade(String id) {
        if (!Grade.containsKey(id)) return Empty.get(0);
        else return Grade.get(id);
    }

    public TreeMap<String, String> gettreeGrade() {
        return this.Grade;
    }


}



