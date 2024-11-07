import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

//converted strings to binary and added cancelling if doubles were found early

//79.6 seconds
//0.0219 hours

public class FinderThree {
    private static final int WORDLENGTH = 5;
    String[]words;
    int[]bin;
    private HashMap<Character,Integer>cMap;
    HashMap<Integer,String[]> map = new HashMap<Integer,String[]>();
    public FinderThree(){
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
        bin = removeDuplicateInts(bin);
        System.out.println(bin.length);
        //System.out.println(stringToBin(words[0]));
        long start = System.currentTimeMillis();
        search();
        
        for(int i=0;i<answerCount;i++){
            printAnswer(answerList[i]);
        }
        System.out.println(answerCount+" solutions found");
        System.out.println("Runtime: "+(System.currentTimeMillis()-start)+"ms");
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

    public int[] removeDuplicateInts(int[]list){
        int t1,t2;
        boolean t = false;
        int count = 0;
        int[]newList = new int[list.length];
        for(int i=0;i<list.length;i++){
            t1 = list[i];
            t=false;
            String[]temp = map.get(t1);
            if(temp==null){temp=new String[]{};}
            String[]temp2 = new String[temp.length+1];
            for(int i3=0;i3<temp.length;i3++){
                temp2[i3]=temp[i3];
            }temp2[temp.length] = words[i];
            map.put(t1, temp2);

            for(int i2=0;i2<list.length;i2++){
                t2 = list[i2];
                if(t1==t2&&i!=i2){
                    //System.out.println(t1+" "+t2+" "+i+" "+i2);
                    t=true;

                    break;
                }
            }
            if(t==false){
                newList[count]=t1;
                //map.put(t1, new String[]{words[i]});
                count++;
            }
        }
        int[]finalList = new int[count];
        for(int i=0;i<finalList.length;i++){
            finalList[i]=newList[i];
        }
        return finalList;
    }

    int temp = 0;
    int answerCount = 0;
    int[][]answerList;
    public void search(){
        temp = 0;
        answerList = new int[bin.length][];
        for(int a=0;a<bin.length;a++){
            if((a+1)%200==0||(a+1)==bin.length){
                System.out.println((a+1)+"/"+bin.length);
            }
            for(int b=a+1;b<bin.length;b++){
                temp = bin[a];
                if((temp&bin[b])!=0){
                    continue;
                }
                for(int c=b+1;c<bin.length;c++){
                    temp = bin[a]+bin[b];
                    if((temp&bin[c])!=0){
                        continue;
                    }
                    for(int d=c+1;d<bin.length;d++){
                        temp = bin[a]+bin[b]+bin[c];
                        if((temp&bin[d])!=0){
                            continue;
                        }
                        for(int e=d+1;e<bin.length;e++){
                            temp = bin[a]+bin[b]+bin[c]+bin[d];
                            if((temp&bin[e])!=0){
                                continue;
                            }
                            answerList[answerCount]=new int[]{a,b,c,d,e};
                            answerCount++;
                            

                        }
                    }
                }
            }
        }
    }

    public void printAnswer(int[]indexList){
        for(int i=0;i<indexList.length;i++){
            System.out.print(Arrays.toString(map.get(bin[indexList[i]]))+" ");
        }
        System.out.println("");
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
        new FinderThree();
    }
    
}
