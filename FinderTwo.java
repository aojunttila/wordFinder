import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

//converted strings to binary and added cancelling if doubles were found early

public class FinderTwo {
    private static final int WORDLENGTH = 5;
    String[]words;
    int[]binaryWords;
    private HashMap<Character,Integer>cMap;
    public FinderTwo(){
        cMap = new LetterMap().getMap();
        FileReader f = new FileReader();
        words = f.getWordsOfLength(WORDLENGTH);
        System.out.println(words.length);
        words = removeDuplicateLetters(words);
        System.out.println(words.length);
        binaryWords = new int[words.length];
        for(int i=0;i<words.length;i++){
            binaryWords[i]=stringToBin(words[i]);
        }
        System.out.println(stringToBin(words[0]));
        //search();
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

    public void search(){
        String[]tempList = new String[5];
        for(int a=0;a<words.length;a++){
            System.out.println(a);
            tempList[0]=words[a];
            for(int b=0;b<words.length;b++){
                System.out.println(b);
                tempList[1]=words[b];
                for(int c=0;c<words.length;c++){
                    System.out.println(c);
                    tempList[2]=words[c];
                    for(int d=0;d<words.length;d++){
                        tempList[3]=words[d];
                        for(int e=0;e<words.length;e++){
                            tempList[4]=words[e];
                            checkDuplicates(tempList);
                        }
                    }
                }
            }   
        }
    }

    public boolean checkDuplicates(String[]temp){
        String s = temp[0]+temp[1]+temp[2]+temp[3]+temp[4];
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(s.indexOf(c)!=c){
                return false;
            }
        }
        System.out.println(s);
        return true;
    }

    String d = "abcdefghijklmnopqrstuvwxyz";
    public int stringToBin(String s){
        int t=0;
        for(int i=0;i<s.length();i++){
            System.out.println(s.charAt(i));
            t+=cMap.get(s.charAt(i));
        }
        return t;
    }

    public static void main(String[] args) {
        new FinderTwo();
    }
    
}
