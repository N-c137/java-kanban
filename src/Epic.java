import java.util.ArrayList;
public class Epic extends Task{
    ArrayList<Integer> idSubTask;

    public Epic (String taskName, String taskDescription, Integer id, Progress status, ArrayList<Integer> idSubTask){
        super(taskName, taskDescription, id, status);
        this.idSubTask = idSubTask;
    }


    @Override
    public String toString(){
        return "Epic{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", status='" + status + '\'' +
                ", subtaskId=" + idSubTask +
                '}';
    }

}
