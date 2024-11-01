import java.util.Arrays;

public class FinderOne {
    public FinderOne(){
        FileReader f = new FileReader();
        String[]words = f.getWordsOfLength(5);
        System.out.println(Arrays.toString(words));
    }

    public static void main(String[] args) {
        new FinderOne();
    }
    
}
