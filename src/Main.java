import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        System.out.println("Поехали!");

        TaskManager taskManager = new TaskManager();

        // Создание Task
        Task task1 = new Task("Обычная таск1", "описание", taskManager.idCounter(), Progress.NEW);
        Task task2 = new Task("Обычная таск2", "описание", taskManager.idCounter(), Progress.NEW);

        // Создание Epic
        Epic epic1 = new Epic("эпик1", "описание", taskManager.idCounter(), Progress.NEW, new ArrayList<Integer>());
        Subtask epic1sub1 = new Subtask("сабтаск1", "описание", taskManager.idCounter(), Progress.NEW, epic1.id);
        Subtask epic1sub2 = new Subtask("сабтаск2", "описание", taskManager.idCounter(), Progress.NEW, epic1.id);

        Epic epic2 = new Epic("эпик2", "описание", taskManager.idCounter(), Progress.NEW, new ArrayList<Integer>());
        Subtask epic2sub1 = new Subtask("сабтаск1", "описание", taskManager.idCounter(), Progress.NEW, epic2.id);

        // Добавление
        taskManager.addTask(task1);
        taskManager.addTask(task2);

        taskManager.addEpic(epic1);
        taskManager.addSubtask(epic1sub1);
        taskManager.addSubtask(epic1sub2);

        taskManager.addEpic(epic2);
        taskManager.addSubtask(epic2sub1);

        // Печать списков
        System.out.println(taskManager.getListTask());
        System.out.println(taskManager.getListSubtask());
        System.out.println(taskManager.getListEpic());


        // Обновление
        Task task1upd1 = new Task("обновленная таска1", "описание", task1.id, Progress.DONE);
        Task task2upd1 = new Task("обновленная таска2", "описание", task2.id, Progress.DONE);

        Subtask epic1sub1upd1 = new Subtask("обновленная субтаска1", "описание", epic1sub1.id, Progress.DONE, epic1.id);
        Subtask epic1sub2upd1 = new Subtask("обновленная субтаска2", "описание", epic1sub2.id, Progress.DONE, epic1.id);

        Subtask epic2sub1upd1 = new Subtask("обновленная сабтаск12", "описание", epic2sub1.id, Progress.IN_PROGRESS, epic2.id);

        // Добавление обновлений
        taskManager.updateTask(task1upd1);
        taskManager.updateTask(task2upd1);

        taskManager.updateSubtask(epic1sub1upd1);
        taskManager.updateSubtask(epic1sub2upd1);

        taskManager.updateSubtask(epic2sub1upd1);

        // Вывод обновленных списков
        System.out.println(taskManager.getListTask());
        System.out.println(taskManager.getListSubtask());
        System.out.println(taskManager.getListEpic());

        // Удаление задачи
        taskManager.delTaskById(1);

        // Удаление субтаски
        taskManager.delSubtaskById(4);

        // Удаление эпика
        taskManager.delEpicById(3);

        // Получение списка всех подзадач определённого эпика
        System.out.println(taskManager.getSubtasksEpic(6));


    }
}
