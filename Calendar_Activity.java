package source;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Calendar Class allows user to select dates from calendar view
 */
public class Calendar_Activity extends AppCompatActivity {
    EditText date,dateto,days;  // text fields
    DatePickerDialog datePickerDialog;  // date picker dialog
    Button save_btn;    // save goal
    Calendar c1,c2; // two calendars for two dates

    // shared preferences allows for short term data storage
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_calendar);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = sharedPreferences.edit();

        date = findViewById (R.id.tvDate);
        dateto = findViewById (R.id.tvDateFinish);
        //days = findViewById (R.id.days);
        save_btn = findViewById (R.id.save_btn);

        // click listener for save button
        save_btn.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {


                try {
                    // convert to string
                    String d1 = date.getText ().toString ();
                    String d2 = dateto.getText ().toString ();

                    // java date formatting dd - mm -yyyy
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
                    Date date1 = simpleDateFormat.parse(d1);    // parse date
                    Date date2 = simpleDateFormat.parse(d2);    // parse date
                    long difference = Math.abs(date1.getTime() - date2.getTime());  // calculate days between

                    long difftDays = difference / (24 * 60 * 60 * 1000);
                    // store value to calculate pages to read per day
                    editor.putLong("daysToGoal",difftDays);
                    editor.commit();

                    // open current books with new goal set
                    startActivity(new Intent(Calendar_Activity.this, Current_Books.class));

                }
                catch(Exception ex)
                {

                    ex.printStackTrace();
                }
            }
        });


        // display calendar
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calender class's instance and get current date , month and year from calender
                c1 = Calendar.getInstance();
                int mYear = c1.get(Calendar.YEAR); // current year
                int mMonth = c1.get(Calendar.MONTH); // current month
                int mDay = c1.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                datePickerDialog = new DatePickerDialog(Calendar_Activity.this,new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        // set day of month , month and year value in the edit text

                        String[] MONTHS = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
                        String mon=MONTHS[monthOfYear];

                        date.setText(dayOfMonth + "-"
                                + (mon) + "-" + year);

                    }
                }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        // display calendar
        dateto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calender class's instance and get current date , month and year from calender
                c2 = Calendar.getInstance();
                int mYear = c2.get(Calendar.YEAR); // current year
                int mMonth = c2.get(Calendar.MONTH); // current month
                int mDay = c2.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                datePickerDialog = new DatePickerDialog(Calendar_Activity.this, new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        // set day of month , month and year value in the edit text
                        String[] MONTHS = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
                        String mon=MONTHS[monthOfYear];
                        dateto.setText(dayOfMonth + "-" + (mon) + "-" + year);



                    }
                }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });
    }
}
