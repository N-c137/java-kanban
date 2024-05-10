import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class TaskManager {
    public static int Id;

    HashMap<Integer, Task> tasks = new HashMap<>();
    HashMap<Integer, Subtask> subtasks = new HashMap<>();
    HashMap<Integer, Epic> epics = new HashMap<>();


    // счетчик
    public Integer idCounter() {
        Id++;
        return Id;
    }


    // Связать сабтаск и эпик
    public ArrayList<Subtask> getSubtasksOfEpic(Epic epic) {
        ArrayList<Subtask> subtasksOfEpic = new ArrayList<>();
        for (Subtask subtask : subtasks.values()) {
            if (subtask.idEpic == epic.id) {
                subtasksOfEpic.add(subtask);
            }
        }
        return subtasksOfEpic;
    }

    public ArrayList<Integer> getSubtaskIdOfEpic(Epic epic) {
        ArrayList<Integer> subtaskIdsOfEpic = new ArrayList<>();
        for (Subtask subtask : getSubtasksOfEpic(epic)) {
            subtaskIdsOfEpic.add(subtask.id);
        }
        return subtaskIdsOfEpic;
    }

    public Epic getEpicOfSubtask(Subtask subtask) {
        return epics.get(subtask.idEpic);
    }

    public Progress getEpicStatus(Epic epic) {
        if (getSubtasksOfEpic(epic).equals(Collections.emptyList())) {
            return Progress.NEW;
        }
        Progress status;
        boolean isStatusNew = false;
        boolean isStatusInProgress = false;
        boolean isStatusDone = false;
        for (Subtask subtask : getSubtasksOfEpic(epic)) {
            switch (subtask.status){
                case NEW :
                    isStatusNew = true;
                case IN_PROGRESS:
                    isStatusInProgress = true;
                case DONE:
                    isStatusDone = true;
            }
        }

        if (isStatusNew && !isStatusInProgress && !isStatusDone) {
            status = Progress.NEW;
        } else if (isStatusDone && !isStatusNew && !isStatusInProgress) {
            status = Progress.DONE;
        } else if (isStatusDone && !isStatusNew && isStatusInProgress){
            status = Progress.IN_PROGRESS;
        } else {
            status = Progress.IN_PROGRESS;
        }
        return status;
    }


    // получение списка всех задач
    public ArrayList<Task> getListTask(){
        ArrayList<Task> taskList = new ArrayList<>();
        for (Task task : tasks.values()){
            taskList.add(task);
        }
        return taskList;
    }

    public ArrayList<Subtask> getListSubtask(){
        ArrayList<Subtask> subtaskList = new ArrayList<>();
        for (Subtask subtask : subtasks.values()){
            subtaskList.add(subtask);
        }
        return subtaskList;
    }

    public ArrayList<Epic> getListEpic(){
        ArrayList<Epic> epicList = new ArrayList<>();
        for (Epic epic : epics.values()){
            epicList.add(epic);
        }
        return epicList;
    }


    // Удаление всех задач
    public void delAllTasks(){
        tasks.clear();
    }

    public void delAllSubtasks(){
        subtasks.clear();
    }

    public void delAllEpics(){
        epics.clear();
    }


    //Получение по идентификатору
    public Task getTaskById(Integer Id){
        return tasks.get(Id);
    }

    public Subtask getSubtaskById(Integer Id){
        return subtasks.get(Id);
    }

    public Epic getEpicById(Integer Id){
        return epics.get(Id);
    }

    // a. Получение списка всех подзадач определённого эпика
    public ArrayList<Subtask> getSubtasksEpic(Integer Id){
        ArrayList<Subtask> subtaskList = new ArrayList<>();
        for (Subtask subtask : subtasks.values()){
            if(subtask.idEpic == Id){
                subtaskList.add(subtask);
            }
        }
        return subtaskList;
    }


    //  Создание. Сам объект должен передаваться в качестве параметра
    public void addTask(Task task){
        tasks.put(task.id, task);
    }

    public void addSubtask(Subtask subtask){
        subtasks.put(subtask.id, subtask);
        updateEpic(getEpicOfSubtask(subtask));
    }

    public void addEpic (Epic epic){
        epics.put(epic.id, epic);
    }


    // Обновление
    public void updateTask(Task task){
        addTask(task);
    }

    public void updateSubtask(Subtask subtask){
        addSubtask(subtask);
        updateEpic(getEpicOfSubtask(subtask));
    }

    public void updateEpic(Epic epic){
        epic.idSubTask = getSubtaskIdOfEpic(epic);
        epic.status = getEpicStatus(epic);
        addEpic(epic);
    }

    //Удаление по идентификатору
    public void delTaskById(Integer Id){
        tasks.remove(Id);
    }

    public void delSubtaskById(Integer Id){
        Epic epic = getEpicOfSubtask(getSubtaskById(Id));
        subtasks.remove(Id);
        updateEpic(epic);
    }

    public void delEpicById(Integer Id){
        for (Subtask subtask : getSubtasksOfEpic(getEpicById(Id))) {
            delSubtaskById(subtask.id);
        }
        epics.remove(Id);
    }
    
}





