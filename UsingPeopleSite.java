//radix is the base
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.net.*;
import java.util.regex.*;
public class UsingPeopleSite {
    public static void main(String[] args) {
        System.out.print("Type an input ");
        BufferedReader brInp=new BufferedReader(new InputStreamReader(System.in));
        String username;
        try{
            username=brInp.readLine();
        } catch (IOException ioe) {
            username="";
        }
        String newurl= "https://www.ecs.soton.ac.uk/people/";
        
        
        System.out.println(newurl);
        try {
            URL fetcher= new URL(newurl); //url object created
            System.out.println(fetcher.getContent());
            URLConnection connection=fetcher.openConnection();
            BufferedReader contents=new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String html;
            String finalStr="";
            while ((html=contents.readLine())!=null) {
                
                finalStr+=html;
            }
            String theregex= "<tr>.*people.*\">([\\D]*)<\\/a>.*position.*("+username;
            theregex=theregex+")";
            Pattern rgx=Pattern.compile(theregex);
            Matcher results=rgx.matcher(finalStr);
            results.find();
            System.out.println(results.group(1));


        } catch (MalformedURLException mue) {
            ;
        } catch (IOException ioe){
            ;
        }
        
        
        


    }
}