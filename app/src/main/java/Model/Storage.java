package Model;

/**
 * Created by Warata on 5/5/16 AD.
 */
public class Storage {

    private Calendar calendar;
    private static Storage instance;

    private Storage(){
        calendar = new Calendar("March");
    }

    public static Storage getInstance(){
        if(instance == null){
            instance = new Storage();
        }
        return instance;
    }

    public Date getDate(int index){
        return calendar.getDate(index);
    }

    public void editSchedule(int date, int schedule, String title){
        calendar.getDate(date).getScheduleList().get(schedule).setTitle(title);
    }
}
