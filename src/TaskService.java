import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class TaskService {

   public Map<Integer, Task> taskMap;
    public Collection<Task> removedTasks;

    public TaskService() {
        this.taskMap = new HashMap<>();
        this.removedTasks = new ArrayList<>();
    }

    public void add(Task task) {
        taskMap.put(task.getId(), task);
    }

    public Task remove(int id) {
        Task task = taskMap.get(id);
        if(task == null) {
            throw new TaskNotFoundException();
        }
        removedTasks.add(task);
        taskMap.remove(id);
        return task;
    }

    public Collection<Task> getAllByDate(LocalDate localDate) {
        return taskMap.values().stream().filter(task -> task.appearsIn(localDate)).collect(Collectors.toList());
    }


    public Collection<Task> getRemovedTasks() {
        return removedTasks;
    }

    public Task updateDescription(int id, String description) {
        taskMap.get(id).setDescription(description);
        return taskMap.get(id);
    }

    public Task updateTitle(int id, String title) {
        taskMap.get(id).setTitle(title);
        return taskMap.get(id);
    }

    public Map<LocalDate, Collection<Task>> getAllGropeByDate() {
        return taskMap.values().stream().collect(Collectors.groupingBy(task -> task.getDateTime().toLocalDate(), Collectors.toCollection(ArrayList::new)));
    }
}
