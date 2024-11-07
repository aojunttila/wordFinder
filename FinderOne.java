import java.util.ArrayList;

//62,886,400,000,000 seconds
//17,468,444,444 hours
//1,994,114 years

public class FinderOne {
    private static final int WORDLENGTH = 5;
    String[]words;
    public FinderOne(){
        FileReader f = new FileReader();
        words = f.getWordsOfLength(WORDLENGTH);
        System.out.println(words.length);
        words = removeDuplicateLetters(words);
        System.out.println(words.length);
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

    public static void main(String[] args) {
        new FinderOne();
    }
    
}
