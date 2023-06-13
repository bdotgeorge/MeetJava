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
    public void secondHomeWork() {
        System.out.println(requestsString());
        StringBuilder data = new StringBuilder("{фамилия:Иванов оценка: 5 предмет: Математика} {фамилия: Петрова оценка: 4 предмет: Информатика} {фамилия: Краснов оценка: 5 предмет: Физика}");
        System.out.println(stringBuilderToStringList(data));
        System.out.println(stringBuilderToStringListShort(data));
    }

    public void thirdHoweWork(){
        third();
    }

    private ArrayList<String> stringBuilderToStringListShort(StringBuilder data) {

        ArrayList<String> s = new ArrayList<>(Arrays.asList(data.toString()
                .replaceAll("фамилия:", "Студент ")
                .replaceAll("оценка:", "получил ")
                .replaceAll("предмет:", "по предмету ")
                .replaceAll("\\p{P}", "\n")
                .split("\n")));
        s.removeAll(Collections.singleton(""));
        s.removeAll(Collections.singleton(" "));
        return s;
    }

    private ArrayList<String> stringBuilderToStringList(StringBuilder data) {
        ArrayList<String> result = new ArrayList<String>();
        int start = 0;
        int end = start;
        ArrayList<String> seporator = new ArrayList<>(Arrays.asList("фамилия:", "оценка:", "предмет:"));
        ArrayList<String> newValue = new ArrayList<>(Arrays.asList("Студент ", "получил ", "по предмету "));
        while (end != -1) {
            String person = "";
            for (int j = 0, first = 0; j < seporator.size(); j++) {
                start = data.indexOf(seporator.get(j), start);
                if (j + 1 < seporator.size()) end = data.indexOf(seporator.get(j + 1), start);
                else end = data.indexOf(seporator.get(first), start);
                person += newValue.get(j);
                if (end != -1)
                    person += data.substring(start + seporator.get(j).length(), end);
                else person += data.substring(start + seporator.get(j).length());
            }
            result.add(person.replaceAll("\\p{P}", ""));
        }
        return result;
    }

    private String requestsString() {
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
        for (Map.Entry<String, String> p : paramsReq.entrySet()) {
            if (p.getValue() != null) {
                sb.append(p.getKey() + ": " + p.getValue() + " and ");
            }
        }
        int size = sb.toString().length();
        sb.delete(size - 5, size);
        return sb.toString();
    }

    private ArrayList<String> parsingStrBuilder(StringBuilder value, String sep) {
        ArrayList<String> result = new ArrayList<String>();
        int start = 0;
        int extra = 0;
        int end;
        while ((end = value.indexOf(sep, start + extra)) != -1) {
            if (start != end) {
                result.add(value.substring(start, end));
            }
            start = end + sep.length();
            extra = (sep.length() == 0 ? 1 : 0);
        }
        if (start != value.length())
            result.add(value.substring(start));
        return result;
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

    private void third(){
        ArrayList<Integer> values = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            values.add(generateIntInRange(1, 1000));

        Iterator<Integer> iterator = values.listIterator();
        while (iterator.hasNext())
            if(iterator.next() % 2 == 0)
                iterator.remove();
        //use sorting
        values.sort(Comparator.naturalOrder());
        System.out.println(values.get(0));
        System.out.println(values.get(values.size() - 1));
        //without sorting
        System.out.println(Collections.min(values));
        System.out.println(Collections.max(values));
        int sum = 0;
        for (int elems: values) {
            sum += elems;
        }
        System.out.println(sum / values.size());
        System.out.println(values);

    }
}
