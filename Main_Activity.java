package source;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Vector;

/*
 * Main activity acts as the home screen for this application
 * Holds Current reads and goal reminders and current read streak as well as navigation bar
 */
public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    TextView mTextTitle;
    LinearProgressIndicator progbar;

    Vector<Book> currentReads;
    Vector<Book>  goalReads;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String imgurl;
    Book incomingBook = new Book();
    TextView mTextGoalTitle, mTextGoalPages, mTextGoalDate, mTextGoalReadTod;
    ImageView Goalimg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextTitle = (TextView)findViewById(R.id.Title);    // location of book Title
        imageView = (ImageView)findViewById(R.id.img);      // location of image

        // To add Goal Reminder Info
//        mTextGoalTitle = (TextView)findViewById(R.id.Title1);
//        mTextGoalPages = (TextView)findViewById(R.id.Pages1);
//        mTextGoalDate = (TextView)findViewById(R.id.Goal_set1);
//        mTextGoalReadTod = (TextView)findViewById(R.id.read_today1);


        // Setting up shared preferences for local storage
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = sharedPreferences.edit();

        // check for previously saved info
        checkSharedPref();
        // access the image of the cover
        String image = sharedPreferences.getString(getString(R.string.currentReadingimg),"");
        Picasso.get().load(image).into(imageView);  // load stored image into "Picasso" draws cover

        ///////////
        // To Do: update progress bar
        ///////////

        // Possibly Unnecessary but may be useful for future use
        progbar = (LinearProgressIndicator) findViewById(R.id.prog_bar);
        progbar.setProgress(getIntent().getIntExtra("update_prog",0));
        incomingBook.setTitle(getIntent().getStringExtra("Title"));
        incomingBook.setPageCount(getIntent().getIntExtra("Pages",0));
        incomingBook.setShelf_Status("Future Books");
        incomingBook.setGoal_set(false);
        incomingBook.setProgress(getIntent().getIntExtra("update_prog",0));
        incomingBook.setPublisher(getIntent().getStringExtra("publisher"));
        incomingBook.setDescription(getIntent().getStringExtra("description"));
        incomingBook.setPublishDate(getIntent().getStringExtra("publishedDate"));

    }

    // Goals Button is Clicked
    public void goalsClicked(View view) {
        startActivity(new Intent(MainActivity.this, Goals_Activity.class));
    }

    // Home Button is Clicked
    public void homeClicked(View view) {
        startActivity(new Intent(MainActivity.this, MainActivity.class));
    }

    // Statistics Button Clicked
    public void statsClicked(View view) {
        startActivity(new Intent(MainActivity.this, Stats_Activity.class));
    }

    // Books Button is Clicked
    public void booksClicked(View view) {
        startActivity(new Intent(MainActivity.this, Books_Activity.class));
    }


    // Opens Book Search w/ google booknAPI
//    public void searchClicked(View view){
//        startActivity(new Intent(MainActivity.this, Search_Book.class));
//
//    }

    // This acts as the setGoal Button press... needs to be update progress.
    // set goal will be in current books tab
    public void updateProgressClicked(View view){

        //sendTitle.putExtra("img",byteArray);

        startActivity(new Intent(MainActivity.this, Calendar_Activity.class));
    }

    // Check Shared Preferences
    private void checkSharedPref(){
        String currentReadingimg = sharedPreferences.getString(getString(R.string.currentReadingimg), "");
        String bookTitle = sharedPreferences.getString(getString(R.string.bookTitle), "");
        //String numPages = sharedPreferences.getString(getString(R.string.numPages),"");
        String bookPublisher = sharedPreferences.getString(getString(R.string.bookPublisher), "");
        String description = sharedPreferences.getString(getString(R.string.description), "");
        String datePublished = sharedPreferences.getString(getString(R.string.datePublished), "");

        mTextTitle.setText(bookTitle);
    }
}
