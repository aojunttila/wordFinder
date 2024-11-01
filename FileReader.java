import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class FileReader {
    String[] wordList;
    File f;
    int[]wordLengths = new int[50];

    public FileReader(){
        int count = 0;
        File f = new File("words.txt");
        Scanner sc;
        try{
            sc = new Scanner(f);
        }catch(Exception e){
            sc = new Scanner("words.txt");
        }
        while (sc.hasNext()) {
            String s = sc.nextLine();
            wordLengths[s.length()]+=1;
            count++;    
        }
        sc.close();
        System.out.println("linecount: "+count);
        System.out.print(Arrays.toString(wordLengths));
        wordList = new String[count];
        count = 0;
        try{
            sc = new Scanner(f);
        }catch(Exception e){
            sc = new Scanner("words.txt");
        }
        while (sc.hasNext()) {
            wordList[count] = sc.nextLine().toLowerCase();
            count++;
        }
    }

    public String[] getWordsOfLength(int length){
        if(length<0||length>49||wordLengths[length]==0){
            System.out.println("No words of that length");
            return null;
        }
        String[] stringList = new String[wordLengths[length]];
        int index=0;
        for(int i=0;i<wordList.length;i++){
            if(wordList[i].length()==length){
                stringList[index]=wordList[i];
                index++;
            }
        }
        return stringList;
    }

    public static void main(String[] args) {
        new FileReader();
    }
}
