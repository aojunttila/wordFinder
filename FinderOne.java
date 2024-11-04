import java.util.ArrayList;
import java.util.Arrays;

public class FinderOne {
    private static final int WORDLENGTH = 5;
    public FinderOne(){
        FileReader f = new FileReader();
        String[]words = f.getWordsOfLength(WORDLENGTH);
        System.out.println(words.length);
        words = removeDuplicateLetters(words);
        System.out.println(words.length);
    }

    public String[] removeDuplicateLetters(String[]s){
        ArrayList<String> stringList=new ArrayList<String>();
        for(int i=0;i<s.length;i++){
            boolean same = false;
            for(int b=0;b<WORDLENGTH;b++){
                char c = s[i].charAt(b);
                if(s[i].indexOf(c) != b){
                    same = true;
                }
            }
            if(!same){
                stringList.add(s[i]);
            }
            
        } 
        return stringList.toArray(new String[0]);
    }

    public static void main(String[] args) {
        new FinderOne();
    }
    
}
