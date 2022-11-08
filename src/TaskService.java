import java.time.LocalDate;
import java.util.*;

public class TaskService {

    private final Map<Integer,Task> map = new HashMap<>();
    private final Map<Integer,Task> archive = new HashMap<>();

    public void addTask(Task task){
        map.put(task.getId(),task);
    }

    public void removeTask(int id){
        if(map.containsKey(id)){
            map.get(id).setTitle("УДАЛЕНО "+map.get(id).getTitle());
            map.replace(id,map.get(id));
            archive.put(id,map.get(id));}
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

    public void printArchive(){
        System.out.println("Архив удаленных задач: ");
        for (Map.Entry<Integer,Task> pair: archive.entrySet()) {
            System.out.println("id: " + pair.getKey() + " " + pair.getValue());
        }
    }

    public void printTest(){
        System.out.println("Список задач: ");
        for (Map.Entry<Integer,Task> pair: map.entrySet()) {
            System.out.println("id: " + pair.getKey() + " " + pair.getValue());
        }
    }

    public Map<Integer, Task> getMap() {
        return map;
    }

    public void sortTask(int days){
        LocalDate startDate = LocalDate.now();
        for(int i = 0 ; i < days; i++){
            System.out.println(" < " + startDate.plusDays(i) + " > ");
            for (Integer id: map.keySet()) {
                if(map.get(id).appearTask(startDate.plusDays(i)) == true){
                    System.out.println(map.get(id));
                }
            }
        }
    }

    @Override
    public String toString() {
        return map.toString();
    }
}
