import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
//        HomeWork home = new HomeWork();
        //home.first();
        //home.secondHomeWork();
        //home.thirdHoweWork();
//        home.classWork();
//        home.phoneBook();
        MySet<Integer> st = new MySet<>();
        st.add(78);
        st.add(13);
        st.add(78);
        st.add(14);
        st.add(44);
        st.remove(13);
        st.remove(13);
        System.out.println("size = " + st.size());
        System.out.println("to string = " + st.toString());
        Iterator<Integer> iterator = st.iterator();
        while (iterator.hasNext()) {
            System.out.println("iterator = " + iterator.next());
        }

    }
}