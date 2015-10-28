package kata4;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class Kata4 {
 
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String path = "C:\\Users\\usuario\\Documents";
        File file = new File(path);
        
        String from ="C:\\Users\\Public\\Pictures\\Sample Pictures\\Koala.jpg";
        String to ="C:\\Users\\Public\\Pictures\\Sample Pictures\\Koala(1).jpg";
        
        BufferedInputStream input = new BufferedInputStream(new FileInputStream( new File (from)));
        BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(new File(to)));
        Date date = new Date();
        
        byte[] buffer = new byte[1024];
        
        while(true){
            int read = input.read(buffer);
            if (read < 0) break;
            output.write(buffer);
        }
        
        System.out.println(new Date().getTime() - date.getTime() + "msg");
        input.close();
        output.flush();
        output.close();
               
        
        //print(file.listFiles(), "");
    }
    
    private static void print(File[] listFiles, String ident){
       if (listFiles == null){
           return;
       }
        for (File file : listFiles) {
            System.out.println(ident + (file.isDirectory()? "+":"") + file.getName());
            if(!file.isDirectory()||file.isHidden()) continue;
            print(file.listFiles(), ident + " ");
        }
    } 
}
