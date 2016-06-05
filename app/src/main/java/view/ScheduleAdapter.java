package view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.ske.scheduling.R;

import java.util.List;

import Model.Schedule;

/**
 * Created by Warata on 5/5/16 AD.
 */
public class ScheduleAdapter extends ArrayAdapter<Schedule>{

    public ScheduleAdapter(Context context, int resource, List<Schedule> objects) {
        super(context, resource, objects);

    }

    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if(v == null){
            LayoutInflater vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.schedule_cell,null);
        }

        TextView time = (TextView) v.findViewById(R.id.time);
        TextView title = (TextView) v.findViewById(R.id.title);

        Schedule sch = getItem(position);
        time.setText(sch.getTime()+":00 - "+(sch.getTime()+1)+":00");
        title.setText(sch.getTitle());
        System.out.println("test : " + v);

        return v;
    }
}
