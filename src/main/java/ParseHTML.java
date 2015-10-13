import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by thook on 10/13/15.
 */
public class ParseHTML {

    private String htmlData;

    public ParseHTML(){

        this.htmlData = loadFile();
    }

    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("Content.html").getFile());
        StringBuilder result = new StringBuilder("");

        try{
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }
            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public String getHtmlData(){
        return htmlData;
    }

    public static void main(String[] args){
        ParseHTML parseHTML = new ParseHTML();
        System.out.println(parseHTML.getHtmlData());
    }
}
