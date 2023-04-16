package source;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/*
 * Not Implemented yet
 */
public class Monthly_Goals extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monthlt_goals);
    }

    public void goalsClicked(View view) {
        startActivity(new Intent(Monthly_Goals.this, Goals_Activity.class));
    }

    public void homeClicked(View view) {
        startActivity(new Intent(Monthly_Goals.this, MainActivity.class));
    }

    public void statsClicked(View view) {
        startActivity(new Intent(Monthly_Goals.this, Stats_Activity.class));
    }

    public void booksClicked(View view) {
        startActivity(new Intent(Monthly_Goals.this, Books_Activity.class));
    }
}
