import java.util.HashMap;

public class LetterMap {
    private HashMap<Character,Integer>h;
    public LetterMap(){
        h = new HashMap<>();
        h.put('a', 33554432);
        h.put('b', 16777216);
        h.put('c', 8388608 );
        h.put('d', 4194304 );
        h.put('e', 2097152 );
        h.put('f', 1048576 );
        h.put('g', 524288  );
        h.put('h', 262144  );
        h.put('i', 131072  );
        h.put('j', 65536   );
        h.put('k', 32768   );
        h.put('l', 16384   );
        h.put('m', 8192    );
        h.put('n', 4096    );
        h.put('o', 2048    );
        h.put('p', 1024    );
        h.put('q', 512     );
        h.put('r', 256     );
        h.put('s', 128     );
        h.put('t', 64      );
        h.put('u', 32      );
        h.put('v', 16      );
        h.put('w', 8       );
        h.put('x', 4       );
        h.put('y', 2       );
        h.put('z', 1       );
        //00000,00000,00000,00000,00000,0
    }
    public HashMap<Character,Integer> getMap(){
        return h;
    }
}
