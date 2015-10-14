import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by thook on 10/13/15.
 * Modified by David Ginzberg 10/13/2015
 */
public class ParsePhoneNumbers {

    private String documentText;

    public ParsePhoneNumbers(){

        this.documentText = loadFile();
    }

    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("Content.txt").getFile());
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

    public String getDocumentText(){
        return documentText;
    }

    public static void main(String[] args){
        ParsePhoneNumbers parsePhoneNumbers = new ParsePhoneNumbers();
        System.out.println(parsePhoneNumbers.getDocumentText());
    }
}
