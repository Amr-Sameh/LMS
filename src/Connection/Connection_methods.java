package Connection;

import General.General_Persone;
import General.Student;
import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by mostafa saleh on 12/13/2016.
 */
public class Connection_methods {

    static Socket soc;


    static public void setSoc(Socket s) {
        soc = s;

    }

    public static void sendorder(String order) {

            sendobj(order);


    }
    public static void sendobj(Object obj){

        try {
            ObjectOutputStream  re = new ObjectOutputStream(soc.getOutputStream());
            re.writeObject(obj);
            re.flush();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,"Can Not Connect To The Server","Connection Erroe",JOptionPane.ERROR_MESSAGE);
        }


    }

    public static Object rciveobj(){
        try {
            ObjectInputStream in=new ObjectInputStream(soc.getInputStream());
            Object obj=(Object)in.readObject();
            return obj;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,"Can Not Connect To The Server","Connection Erroe",JOptionPane.ERROR_MESSAGE);
            return null;
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null,"Can Not Connect To The Server","Connection Erroe",JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }


}
