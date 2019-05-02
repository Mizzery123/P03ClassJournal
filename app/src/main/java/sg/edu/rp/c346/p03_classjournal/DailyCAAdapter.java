package sg.edu.rp.c346.p03_classjournal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DailyCAAdapter extends ArrayAdapter<DailyCA> {

    private ArrayList<DailyCA> dailyCA;
    private Context context;
    private TextView tvWeek;
    private TextView tvDG;
    private TextView tvGrade;
    private ImageView ivGrade;

    public DailyCAAdapter(Context context, int resource, ArrayList<DailyCA> objects) {
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        dailyCA = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row, parent, false);

        // Get the TextView object
        tvWeek = rowView.findViewById(R.id.textViewWeek);
        tvDG = rowView.findViewById(R.id.textViewDG);
        tvGrade = rowView.findViewById(R.id.textViewGrade);
        // Get the ImageView object
        ivGrade = rowView.findViewById(R.id.ivGrade);


        // The parameter "position" is the index of the
        //  row ListView is requesting.
        //  We get back the food at the same index.
        DailyCA currentDaily = dailyCA.get(position);
        // Set the TextView to show the food

        tvDG.setText("DG");
        tvWeek.setText("Week " + currentDaily.getWeek());
        tvGrade.setText(currentDaily.getDgGrade());
        ivGrade.setImageResource(R.drawable.dg);

        return rowView;
    }
}
