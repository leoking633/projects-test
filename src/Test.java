import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
       List<Integer> list = Arrays.asList(new Integer[]{1,2,3,4,5,6});
       int count = 4;
       List<List<Integer>> groups = new ArrayList<>();
       for(int i = 0;i<count;i++){
           List<Integer> l = new ArrayList<>();
           groups.add(l);
       }
       for(int i=0;i<list.size();i++){
           List<Integer> l = groups.get((i%count));
           l.add(list.get(i));
       }
       groups.forEach(e->{
           System.out.println(e);
       });
    }

}
