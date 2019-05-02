package sg.edu.rp.c346.p03_classjournal;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.sql.Array;
import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
int requestCodeForAdd = 1;
    ListView lv;
    Button btnInfo, btnAdd, btnEmail;
    ArrayAdapter aa;
    ArrayList<DailyCA> dailyCA;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        lv = findViewById(R.id.listViewGrade);
        btnAdd = findViewById(R.id.buttonAdd);
        btnInfo = findViewById(R.id.buttonInfo);
        btnEmail = findViewById(R.id.buttonEmail);

        dailyCA = new ArrayList<DailyCA>();

        Intent i = getIntent();
        final String type = i.getStringExtra("type");
this.setTitle("Info for " + type);

if(type.equals("C347")) {
    dailyCA.add(new DailyCA("B", "C347", 1));
    dailyCA.add(new DailyCA("C", "C347", 2));
} else {
    dailyCA.add(new DailyCA("C", "C302", 1));
    dailyCA.add(new DailyCA("A", "C302", 2));
    dailyCA.add(new DailyCA("A", "C302", 3));
}
        aa = new DailyCAAdapter(this, R.layout.row, dailyCA);
        lv.setAdapter(aa);


        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // Intent to display data
                Intent rpIntent = new Intent(Intent.ACTION_VIEW);
                // Set the URL to be used.
                if(type.equals("C347")) {
                    rpIntent.setData(Uri.parse("https://www.rp.edu.sg/schools-courses/courses/full-time-diplomas/full-time-courses/modules/index/C347"));
                } else {
                    rpIntent.setData(Uri.parse("https://www.rp.edu.sg/schools-courses/courses/full-time-diplomas/full-time-courses/modules/index/C302"));
                }

                startActivity(rpIntent);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent i = new Intent(SecondActivity.this, AddActivity.class);
                i.putExtra("week", lv.getAdapter().getCount()+1);
                startActivityForResult(i, requestCodeForAdd);

            }
        });

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                StringBuilder sb = new StringBuilder();
                for (DailyCA s : dailyCA) {
                    sb.append("Week " + s.getWeek() + ": DG: " + s.getDgGrade());
                    sb.append("\n");
                }

                    // The action you want this intent to do;
                    // ACTION_SEND is used to indicate sending text
                    Intent email = new Intent(Intent.ACTION_SEND);
                    // Put essentials like email address, subject & body text
                    email.putExtra(Intent.EXTRA_EMAIL,
                            new String[]{"jason_lim@rp.edu.sg"});
                    email.putExtra(Intent.EXTRA_SUBJECT,
                            "");


                    email.putExtra(Intent.EXTRA_TEXT,
                            "Hi Faci \n I am ... \n Please see my remarks so far, thank you! \n " + sb.toString());

                    // This MIME type indicates email
                    email.setType("message/rfc822");
                    // createChooser shows user a list of app that can handle
                    // this MIME type, which is, email
                    startActivity(Intent.createChooser(email,
                            "Choose an Email client :"));

                }


        });




    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Only handle when 2nd activity closed normally
        //  and data contains something
        if(resultCode == RESULT_OK){
            if (data != null) {
                // Get data passed back from 2nd activity

                String newGrade = data.getStringExtra("grade");

                dailyCA.add(new DailyCA(newGrade, "C302", lv.getAdapter().getCount()+1));


                // If it is activity started by clicking 				//  Superman, create corresponding String
                aa.notifyDataSetChanged();



            }
        }
    }

}
