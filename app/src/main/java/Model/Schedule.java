package Model;

/**
 * Created by Warata on 5/5/16 AD.
 */
public class Schedule {
    private int time;
    private String title;

    public Schedule(int time, String title){
        this.time = time;
        this.title = title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public int getTime(){
        return time;
    }

    public String getTitle(){
        return title;
    }

}
