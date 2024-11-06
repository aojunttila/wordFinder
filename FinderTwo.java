import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

//converted strings to binary and added cancelling if doubles were found early

public class FinderTwo {
    private static final int WORDLENGTH = 5;
    String[]words;
    int[]bin;
    private HashMap<Character,Integer>cMap;
    public FinderTwo(){
        cMap = new LetterMap().getMap();
        FileReader f = new FileReader();
        words = f.getWordsOfLength(WORDLENGTH);
        System.out.println(words.length);
        words = removeDuplicateLetters(words);
        System.out.println(words.length);
        bin = new int[words.length];
        for(int i=0;i<words.length;i++){
            bin[i]=stringToBin(words[i]);
        }
        System.out.println(stringToBin(words[0]));
        search();
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

    int temp = 0;
    public void search(){
        temp = 0;
        for(int a=0;a<bin.length;a++){
            temp = bin[a];
            //System.out.println("a");
            for(int b=0;b<bin.length;b++){
                if((temp&bin[b])!=0){
                    continue;
                }
                //System.out.println("b");
                temp = bin[a]+bin[b];
                for(int c=0;c<bin.length;c++){
                    if((temp&bin[c])!=0){
                        //System.out.println(temp);
                        //System.out.println(words[a]+" "+words[b]+" "+words[c]);
                        continue;
                    }
                    //System.out.println("c");
                    temp = bin[a]+bin[b]+bin[c];
                    for(int d=0;d<bin.length;d++){
                        if((temp&bin[d])!=0){
                            
                            continue;
                        }
                        temp = bin[a]+bin[b]+bin[c]+bin[d];
                        for(int e=0;e<bin.length;e++){
                            //System.out.println((temp&bin[e]));
                            if((temp&bin[e])!=0){
                                //System.out.println(words[a]+" "+words[b]+" "+words[c]+" "+words[d]+" "+words[e]);
                                continue;
                            }
                            temp = bin[a]+bin[b]+bin[c]+bin[d]+bin[e];
                            System.out.println(words[a]+" "+words[b]+" "+words[c]+" "+words[d]+" "+words[e]);
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
            //System.out.println(s.charAt(i));
            t+=cMap.get(s.charAt(i));
        }
        return t;
    }

    public static void main(String[] args) {
        new FinderTwo();
    }
    
}
