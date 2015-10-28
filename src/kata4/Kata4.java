package kata4;

import java.io.File;

public class Kata4 {
 
    public static void main(String[] args) {
        String path = "C:\\Users\\usuario\\Documents";
        File file = new File(path);
        
        print(file.listFiles(), "");
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
