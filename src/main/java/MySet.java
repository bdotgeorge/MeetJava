import  java.util.HashMap;
import java.util.Iterator;
public class MySet <E>{
    private HashMap<E, Object> mp = new HashMap<>();
    private static final Object OBJ = new Object();
    public boolean add(E num){
        return mp.put(num, OBJ) == null;
    }
    public boolean remove(E num){
        return mp.remove(num) != null;
    }
    public int size(){
        return mp.size();
    }
    public Iterator<E> iterator(){
        return mp.keySet().iterator();
    }
    public String toString(){
        return mp.keySet().toString();
    }
}
