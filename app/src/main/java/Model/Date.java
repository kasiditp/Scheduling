package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Warata on 5/5/16 AD.
 */
public class Date {
    private List<Schedule> scheduleList;

    public Date(){
        scheduleList = new ArrayList<Schedule>();
        for(int i = 1 ; i < 25; i++){
            scheduleList.add(new Schedule(i,"No schedule"));
        }
    }

    public List<Schedule> getScheduleList(){
        return this.scheduleList;
    }

}
