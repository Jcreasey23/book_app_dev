package source;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/*
 * Books activity allows the user to see the different bookshelves available to them as well as the option to look for a new book
 */
public class Books_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);
    }

    public void goalsClicked(View view) {
        startActivity(new Intent(Books_Activity.this, Goals_Activity.class));
    }

    public void homeClicked(View view) {
        startActivity(new Intent(Books_Activity.this, MainActivity.class));
    }

    public void statsClicked(View view) {
        startActivity(new Intent(Books_Activity.this, Stats_Activity.class));
    }

    public void booksClicked(View view) {
        startActivity(new Intent(Books_Activity.this, Books_Activity.class));
    }

    public void currentBooksClick(View view) {
        startActivity(new Intent(Books_Activity.this, Current_Books.class));
    }

    public void pastBooksClick(View view) {
        startActivity(new Intent(Books_Activity.this, Past_Books.class));
    }

    public void futureBooksClick(View view) {
        startActivity(new Intent(Books_Activity.this, Future_Books.class));
    }

    public void searchClicked(View view){
        startActivity(new Intent(Books_Activity.this, Search_Book.class));

    }
}
