public class Subtask extends Task {
    public Integer idEpic;
    public Subtask (String name, String description, Integer id, Progress status, Integer idEpic){
        super(name, description, id, status);
        this.idEpic = idEpic;
    }


    @Override
    public String toString(){
        return "Subtask{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", status='" + status + '\'' +
                ", epicId=" + idEpic +
                '}';
    }
}
