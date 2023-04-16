package source;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/*
 * User's completed reads
 * Not yet implemented
 */
public class Past_Books extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_past_books);
    }

    public void goalsClicked(View view) {
        startActivity(new Intent(Past_Books.this, Goals_Activity.class));
    }

    public void homeClicked(View view) {
        startActivity(new Intent(Past_Books.this, MainActivity.class));
    }

    public void statsClicked(View view) {
        startActivity(new Intent(Past_Books.this, Stats_Activity.class));
    }

    public void booksClicked(View view) {
        startActivity(new Intent(Past_Books.this, Books_Activity.class));
    }
}