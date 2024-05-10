public class Task {
    public String name;
    public String description;
    public Integer id;
    public Progress status;


    public Task(String taskName, String taskDescription, Integer id, Progress status){
        this.name = taskName;
        this.description = taskDescription;
        this.id = id;
        this.status = status;
    }

    @Override
    public String toString(){
        return "Task{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", status='" + status + '\'' +
                '}';
    }

}

