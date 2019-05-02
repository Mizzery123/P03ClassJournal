package sg.edu.rp.c346.p03_classjournal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class AddActivity extends AppCompatActivity {

    TextView tvWeek, tvDG;
    ImageView ivGrade;
    Button btnSubmit;
    RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        tvWeek = findViewById(R.id.textViewWeek);
        tvDG = findViewById(R.id.textViewDG);
        ivGrade = findViewById(R.id.ivGrade);
        btnSubmit = findViewById(R.id.buttonSubmit);
rg = findViewById(R.id.rg);

        Intent i = getIntent();
        int week = i.getIntExtra("week",0);

        tvWeek.setText("Week " + week);
        tvDG.setText("DG");

        btnSubmit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                // Create intent & pass in String data
                int genid=rg.getCheckedRadioButtonId();
                RadioButton radioButton = (RadioButton) findViewById(genid);
                String grade =radioButton.getText().toString();

                Intent i = new Intent();
                i.putExtra("grade", grade);



                // Set result to RESULT_OK to indicate normal			// response and pass in the intent containing the 		// like
                setResult(RESULT_OK, i);
                finish();
            }});

    }
}
