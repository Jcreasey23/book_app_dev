package source;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/*
 * Not yet implemented page
 */
public class Stats_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);
    }

    public void goalsClicked(View view) {
        startActivity(new Intent(Stats_Activity.this, Goals_Activity.class));
    }

    public void homeClicked(View view) {
        startActivity(new Intent(Stats_Activity.this, MainActivity.class));
    }

    public void statsClicked(View view) {
        startActivity(new Intent(Stats_Activity.this, Stats_Activity.class));
    }

    public void booksClicked(View view) {
        startActivity(new Intent(Stats_Activity.this, Books_Activity.class));
    }
}