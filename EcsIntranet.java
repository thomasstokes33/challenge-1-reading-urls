//radix is the base
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.net.*;
import java.util.regex.*;
public class EcsIntranet {
    public static void main(String[] args) {
        System.out.print("Type an input ");
        BufferedReader brInp=new BufferedReader(new InputStreamReader(System.in));
        String username;
        try{
            username=brInp.readLine();
        } catch (IOException ioe) {
            username="";
        }
        String newurl= "https://www.secure.ecs.soton.ac.uk/people/";//different address
        newurl=newurl+username;
        
        System.out.println(newurl);
        try {
            URL fetcher= new URL(newurl);
            System.out.println(fetcher.getContent()); //This doesn't affect the final result but it displays the type of connection
            URLConnection connection=fetcher.openConnection();
            BufferedReader contents=new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String html;
            String finalStr="";
            while ((html=contents.readLine())!=null) {
                
                finalStr+=html;
            }
           


        } catch (MalformedURLException mue) {
            System.out.println("malformed");
        } catch (IOException ioe){
            System.out.println("malformed");
        }
        
        
        


    }
}
