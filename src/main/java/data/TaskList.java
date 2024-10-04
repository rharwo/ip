package data;

import tasks.Task;
import ui.Ui;

import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private final int DEFAULT_TASKS = 100;
    private final ArrayList<Task> taskList;

    public TaskList() {
        taskList = new ArrayList<>(DEFAULT_TASKS);
    }

    public TaskList(ArrayList<Task> taskList){
        this.taskList = taskList;
    }

    public int getTaskCount() {
        return taskList.size();
    }

    public void deleteTask(int idx) {
        int zeroIndexedIdx = idx - 1;
        Task toDelete = taskList.get(zeroIndexedIdx);
        taskList.remove(zeroIndexedIdx);
        System.out.println(Ui.DIVIDER + "Noted. I've removed this task: \n" + toDelete.toString() + "\nNow you have "
                + taskList.size() + " tasks in this list.\n" + Ui.DIVIDER);
    }

    public void printList() {
        System.out.print(Ui.DIVIDER);
        int curIdx = 0;
        System.out.println("Here are the tasks in your list:");
        while (curIdx != taskList.size()) {
            Task curTask = taskList.get(curIdx);
            int oneIndexedIdx = curIdx + 1;
            System.out.println(oneIndexedIdx + ". " + curTask.toString());
            curIdx++;
        }
        System.out.print(Ui.DIVIDER);

    }

    public void addToList(Task toAdd) {
        taskList.add(toAdd);
        System.out.print(Ui.DIVIDER + "added: " + toAdd + "\n" + Ui.DIVIDER);
    }

    public ArrayList<Task> getTaskListCopy() {
        return new ArrayList<Task>(taskList);
    }

    public Task getTask(int idx){
        return taskList.get(idx);
    }

    public ArrayList<ArrayList<Object>> findTasks(String keyword){
        ArrayList<ArrayList<Object>> taskAndIdxList = new ArrayList<>();
        int i = 0;
        for (Task curTask : taskList) {
            i++;
            if (curTask.toString().contains(keyword)) {
                Object[] taskAndIdx = {curTask, i};
                taskAndIdxList.add(new ArrayList<Object>(List.of(taskAndIdx)));
            }
        }
        return taskAndIdxList;
    }
}