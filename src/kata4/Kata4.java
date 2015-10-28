package kata4;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Kata4 {
 
    public static void main(String[] args) throws FileNotFoundException, IOException{
        String nameFile = "C:\\Users\\usuario\\Documents\\NetBeansProjects\\kata4\\emails.txt";
        
        ArrayList<String> mailList = MailListReader.read(nameFile);
        
        Histogram<String> histogram = MailHistogramBuilder.build(mailList);
        
        new HistogramDisplay(histogram).execute();
    }
    
}
