import java.time.LocalDate;
import java.util.*;

public class TaskService {

    private final Map<Integer,Task> map = new HashMap<>();

    public void addTask(Task task){
        map.put(task.getId(),task);
    }

    public void removeTask(int id){
        map.remove(id);
    }


    public List<Task> getTaskForDay(LocalDate date){
        List<Task> list = new LinkedList<>();
        for (Integer id: map.keySet()) {
            if(map.get(id).appearTask(date) == true){
                list.add(map.get(id));
            }
        }
        return list;
    }

    public void printTest(){
        for (Map.Entry<Integer,Task> pair: map.entrySet()) {
            System.out.println("id: " + pair.getKey() + " " + pair.getValue() + " ");
        }
    }

    @Override
    public String toString() {
        return map.toString();
    }
}
