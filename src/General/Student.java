package General;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by PC - MeiR on 12/3/2016.
 */
public class Student extends General_Persone {
    String imagename = getId();
    private int level;
    private String classes;

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    static final long serialVersionUID=1007;
}

