package source;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/*
 * This class allows for the user to set goals... Eventually
 * Yearly/ monthly goals
 * Current goals in progress that need to be completed
 * Completed goals
 */
public class Goals_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goals);
    }

    public void goalsClicked(View view) {
        startActivity(new Intent(Goals_Activity.this, Goals_Activity.class));
    }

    public void homeClicked(View view) {
        startActivity(new Intent(Goals_Activity.this, MainActivity.class));
    }

    public void statsClicked(View view) {
        startActivity(new Intent(Goals_Activity.this, Stats_Activity.class));
    }

    public void booksClicked(View view) {
        startActivity(new Intent(Goals_Activity.this, Books_Activity.class));
    }

    public void yearGoalsClicked(View view) {
        startActivity(new Intent(Goals_Activity.this, Yearly_Goals.class));
    }

    public void monthGoalsClicked(View view) {
        startActivity(new Intent(Goals_Activity.this, Monthly_Goals.class));
    }
}
