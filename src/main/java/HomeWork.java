import java.util.*;
import java.sql.*;

public class HomeWork {
    public void first() {
        int i = generateIntInRange(0, 2000);
        int n = highBitNumber(i);
        int[] m1 = multiplicity(i, n, true);
        int[] m2 = multiplicity(i, n, false);

        System.out.println("Number bit = " + n + '\n' + "Number = " + i + '\n');
        for (int j : m1) {
            System.out.print("m1 = " + j + " ");
        }
        System.out.println('\n');
        for (int j : m2) {
            System.out.print("m2 = " + j + " ");
        }
    }

    public void secondHomeWork(){
        //requestsString();


        StringBuilder data = new StringBuilder("{фамилия:Иванов оценка: 5 предмет: Математика} {фамилия: Петрова оценка: 4 предмет: Информатика} {фамилия: Краснов оценка: 5 предмет: Физика}");
        int start = 0;
        int end = start;
        String sep = "фамилия:";
        List<String> result = new ArrayList<String>();
        while (end != - 1){
            String person = "Студент ";
            start = data.indexOf(sep, start);
            end = data.indexOf("оценка:", start);
            person += data.substring(start + sep.length(), end);
            person += "получил ";
            sep = "оценка:";
            start = data.indexOf(sep, start);
            end = data.indexOf("предмет:", start);
            person += data.substring(start + sep.length(), end);
            person += "по предмету ";
            sep = "предмет:";
            start = data.indexOf(sep, start);
            end = data.indexOf("фамилия:", start);
            sep = "фамилия:";
            if (end != -1)
                person += data.substring(start, end);
            else person += data.substring(start);
            
            result.add(person);
        }
    }
    private void connectionDataBase(StringBuilder request){
//        Connection db = DriverManager.getConnection("DB");
//        PreparedStatement ps = db.prepareStatement(request.toString());
        //"name:""Ivanov", "country":"Russia", "city":"Moscow", "age":"null"
    }
    private String requestsString(){
        String name = "Ivanov";
        String country = "Russia";
        String city = "Moscow";
        String age = null;
        StringBuilder sb = new StringBuilder("SELECT* FROM students WHERE ");
        HashMap<String, String> paramsReq = new HashMap<String, String>();
        paramsReq.put("name", name);
        paramsReq.put("country", country);
        paramsReq.put("city", city);
        paramsReq.put("age", age);
        for (Map.Entry<String, String> p: paramsReq.entrySet()){
            if (p.getValue() != null){
                sb.append(p.getKey() + ": " + p.getValue() + " and ");
            }
        }
        int size = sb.toString().length();
        sb.delete(size - 5, size);
        return sb.toString();
    }
    private List<String> parsingStrBuilder(StringBuilder value, String sep){
        List<String> result = new ArrayList<String>();
        int start = 0;
        int extra = 0;
        int end;
        while ((end = value.indexOf(sep,start + extra)) != -1){
            if(start != end){
                result.add(value.substring(start, end));
            }
            start = end + sep.length();
            extra = (sep.length() == 0 ? 1 : 0);
        }
        if (start != value.length())
            result.add(value.substring(start));
        return  result;
    }
    private int generateIntInRange(int min, int max) {
        return new Random().nextInt(min, max);
    }

    private int highBitNumber(int value) {
        int c = 0;
        while (1 < value) {
            value >>= 1;
            c++;
        }
        return c;
    }

    private int[] multiplicity(int from, int n, boolean multiples) {
        ArrayList<Integer> result = new ArrayList<>();
        if (multiples) {
            for (int i = from; i < Short.MAX_VALUE; i++) {
                if (i % n == 0) result.add(i);
            }
        } else {
            for (int j = Short.MIN_VALUE; j < from; j++) {
                if (j % n != 0) result.add(j);
            }
        }
        int[] value = result.stream().mapToInt(Integer::intValue).toArray();
        return value;
    }
}
