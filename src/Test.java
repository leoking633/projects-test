import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;


public class Test {


    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        Student s = new Student();
        s.setId(1);
        s.setName("leo");
        Student s1 = new Student();
        s1.setId(2);
        s1.setName("king");
        list.add(s1);
        list.add(s);
        List<CompletableFuture<Student>> futrues = list.stream().map(e->CompletableFuture.completedFuture(e).thenApplyAsync(ss->{
            ss.setName(ss.getName()+"hhhh");
            return ss;
        })).collect(Collectors.toList());
        CompletableFuture.allOf(futrues.toArray(new CompletableFuture[futrues.size()])).join();
        futrues.forEach(e->{
            try {
                Student st = e.get();
                System.out.println(st.getName());
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            } catch (ExecutionException ex) {
                ex.printStackTrace();
            }
        });
    }

}
