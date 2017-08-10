package GUI;

import Connection.Connection_methods;
import General.Admin;
import General.General_Persone;
import General.Student;
import General.Teacher;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;

/**
 * Created by Omer on 12/7/2016.
 */
public class TimeTable extends GridPane {
    General_Persone s;
    Admin a;
    Teacher t;
    Student stu;
    public TimeTable(General_Persone s){
        this.s=s;
        Home home;
        this.setHgap(50);
        this.setVgap(20);
        Connection_methods.sendorder("$table!");
        String[][][][]table= (String[][][][]) Connection_methods.rciveobj();
        if(s.getId().equals("#0000")){
            a=(Admin)s;
            int z=0;
            for(int i=0;i<12;i++){
                for (int i1=0;i1<4;i1++){
                    int x=i+1;
                    String classs="";
                    if(i1==0){
                        classs="a";
                    }else if(i1==1){
                        classs="b";
                    }else if(i1==2){
                        classs="c";
                    }else if(i1==3){
                        classs="d";
                    }

                    this.add(new Label("Level "+x+" Class "+classs),0,z);
                    this.add(new Label("day/Lesson"),0,z+1);
                    this.add(new Label("sunday"),0,z+2);
                    this.add(new Label("monday"),0,z+3);
                    this.add(new Label("tuesday"),0,z+4);
                    this.add(new Label("wednesday"),0,z+5);
                    this.add(new Label("thursday"),0,z+6);
                    this.add(new Label("1"),1,z+1);
                    this.add(new Label("2"),2,z+1);
                    this.add(new Label("3"),3,z+1);
                    this.add(new Label("4"),4,z+1);
                    this.add(new Label("5"),5,z+1);
                    this.add(new Label("6"),6,z+1);
                    this.add(new Label("7"),7,z+1);
                    this.add(new Label("8"),8,z+1);
                    int d=z;
                    for (int i2=0;i2<5;i2++){
                        for (int i3=0;i3<8;i3++){
                            this.add(new Label(table[i][i1][i2][i3]),i3+1,d+2);
                        }
                        d++;
                    }
                    z+=10;
                }
            }
        }else if (s.getId().contains("a")||s.getId().contains("b")||s.getId().contains("c")){
            t=(Teacher)s;
            this.add(new Label("day/Lesson"),0,0);
            this.add(new Label("sunday"),0,1);
            this.add(new Label("monday"),0,2);
            this.add(new Label("tuesday"),0,3);
            this.add(new Label("wednesday"),0,4);
            this.add(new Label("thursday"),0,5);
            this.add(new Label("1"),1,0);
            this.add(new Label("2"),2,0);
            this.add(new Label("3"),3,0);
            this.add(new Label("4"),4,0);
            this.add(new Label("5"),5,0);
            this.add(new Label("6"),6,0);
            this.add(new Label("7"),7,0);
            this.add(new Label("8"),8,0);

            for (int i=0;i<5;i++){
                for (int j=0;j<8;j++){
                    if(t.getTimetable()[i][j]!=0)
                        if(Integer.toString(t.getTimetable()[i][j]).length()==2){
                            String e="";
                            if(Integer.toString(t.getTimetable()[i][j]).substring(1).equals("1")){
                                e="a";
                            }else  if(Integer.toString(t.getTimetable()[i][j]).substring(1).equals("2")){
                                e="b";
                            }else if(Integer.toString(t.getTimetable()[i][j]).substring(1).equals("3")){
                                e="c";
                            }else if(Integer.toString(t.getTimetable()[i][j]).substring(1).equals("4")){
                                e="d";
                            }
                            this.add(new Label(Integer.toString(t.getTimetable()[i][j]).charAt(0)+e),j+1,i+1);
                        }else if(Integer.toString(t.getTimetable()[i][j]).length()==3){
                            String e="";
                            if(Integer.toString(t.getTimetable()[i][j]).substring(2).equals("1")){
                                e="a";
                            }else  if(Integer.toString(t.getTimetable()[i][j]).substring(2).equals("2")){
                                e="b";
                            }else if(Integer.toString(t.getTimetable()[i][j]).substring(2).equals("3")){
                                e="c";
                            }else if(Integer.toString(t.getTimetable()[i][j]).substring(2).equals("4")){
                                e="d";
                            }
                            this.add(new Label(Integer.toString(t.getTimetable()[i][j]).charAt(0)+""+Integer.toString(t.getTimetable()[i][j]).charAt(1)+e),j+1,i+1);
                        }

                }
            }
        }else {
            stu=(Student)s;
            this.add(new Label("day/Lesson"),0,0);
            this.add(new Label("sunday"),0,1);
            this.add(new Label("monday"),0,2);
            this.add(new Label("tuesday"),0,3);
            this.add(new Label("wednesday"),0,4);
            this.add(new Label("thursday"),0,5);
            this.add(new Label("1"),1,0);
            this.add(new Label("2"),2,0);
            this.add(new Label("3"),3,0);
            this.add(new Label("4"),4,0);
            this.add(new Label("5"),5,0);
            this.add(new Label("6"),6,0);
            this.add(new Label("7"),7,0);
            this.add(new Label("8"),8,0);

            int x=0;
            if(stu.getClasses().equals("a")){
                x=0;
            }else if (stu.getClasses().equals("b")){
                x=1;
            }else if (stu.getClasses().equals("c")){
                x=2;
            }else if (stu.getClasses().equals("d")){
                x=3;
            }

            for (int i=0;i<5;i++){
                for (int j=0;j<8;j++){
                    this.add(new Label(table[stu.getLevel()-1][x][i][j]),j+1,i+1);
                }
            }
        }

    }
}
