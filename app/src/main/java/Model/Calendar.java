package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Warata on 5/9/16 AD.
 */
public class Calendar {
    private List<Date> dateList;
    private String name;

    public Calendar(String name){
        dateList = new ArrayList<Date>();
        for(int i = 1 ; i < 31 ; i++){
            dateList.add(new Date());
        }
        this.name = name;
    }

    public Date getDate(int index){
        return dateList.get(index-1);
    }
}
