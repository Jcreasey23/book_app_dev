package source;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/*
 * Current Books holds the books the user is currently reading
 * This activity is of my own design implementing the code used for google books API access
 * A little messy right now... sorry
 */
public class Current_Books extends AppCompatActivity {


    ImageView imageView;
    int imagevalue;
    TextView mTextview;
    TextView mTextTitle, mTextGoalDate, mTextPgRemain, mTextReadTod, mTextPages;


    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    int pgsremain;
    int pgstoday;
    Book incomingBook = new Book();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_books);

        mTextTitle = (TextView)findViewById(R.id.Title);
        mTextGoalDate = (TextView)findViewById(R.id.Goal_set);
        mTextPgRemain = (TextView)findViewById(R.id.num_to_goal);
        mTextReadTod = (TextView)findViewById(R.id.read_today);
        mTextPages = (TextView)findViewById(R.id.Pages);
        imageView = (ImageView)findViewById(R.id.img);

        //mTextview = (TextView)findViewById(R.id.Title);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = sharedPreferences.edit();



        mTextTitle.setText(sharedPreferences.getString(getString(R.string.bookTitle),""));
        mTextGoalDate.setText("Complete by: " + sharedPreferences.getString(getString(R.string.goalDate),""));

        // Read Today takes total pages / days
        pgstoday = Math.toIntExact(sharedPreferences.getInt("pageCount", 0) / sharedPreferences.getLong("daysToGoal", 0));
        mTextReadTod.setText("Read Today: " + pgstoday + "pgs");

        // pages remaining === total pages sharedPreferences.getInt("pageCount",0) - current page (For now 0)

        mTextPgRemain.setText("Pages Remaining" + sharedPreferences.getInt("pageCount",0));
        String pages = String.valueOf(sharedPreferences.getInt("pageCount",0));
        mTextPages.setText("Pages:" + pages);

        //checkSharedPref();

        String image = sharedPreferences.getString(getString(R.string.currentReadingimg), "");
        Picasso.get().load(image).into(imageView);  // load stored image into "Picasso" draws cover


        //mTextview.setText(getIntent().getStringExtra("Title")); // set textview labeled Title to title of book
        incomingBook.setTitle(getIntent().getStringExtra("Title"));
//        mTextview = (TextView)findViewById(R.id.Pages);
//        imageView = (ImageView)findViewById(R.id.img);
//        imgurl = getIntent().getStringExtra("image");
//        Picasso.get().load(imgurl).into(imageView);
//        mTextview = (TextView) findViewById(R.id.Goal_set);
//        mTextview.setText("Complete by " + getIntent().getStringExtra("date"));
//        //mTextview.setText("Pages: " + String.valueOf(getIntent().getIntExtra("Pages",0)));  // set pages in book to string
        incomingBook.setPageCount(getIntent().getIntExtra("Pages",0));
        incomingBook.setShelf_Status("Future Books");
        incomingBook.setGoal_set(false);
        incomingBook.setProgress(0);
        incomingBook.setPublisher(getIntent().getStringExtra("publisher"));
        incomingBook.setDescription(getIntent().getStringExtra("description"));
        incomingBook.setPublishDate(getIntent().getStringExtra("publishedDate"));
        incomingBook.setAuthors(getIntent().getStringArrayListExtra("author"));
    }

    public void goalsClicked(View view) {
        startActivity(new Intent(Current_Books.this, Goals_Activity.class));
    }

    public void homeClicked(View view) {
        startActivity(new Intent(Current_Books.this, MainActivity.class));
    }

    public void statsClicked(View view) {
        startActivity(new Intent(Current_Books.this, Stats_Activity.class));
    }

    public void booksClicked(View view) {
        startActivity(new Intent(Current_Books.this, Books_Activity.class));
    }

//    private void checkSharedPref(){
//        String currentReadingimg = sharedPreferences.getString(getString(R.string.currentReadingimg), "");
//        String bookTitle = sharedPreferences.getString(getString(R.string.bookTitle), "");
//        //String numPages = sharedPreferences.getString(getString(R.string.numPages),"");
//        String bookPublisher = sharedPreferences.getString(getString(R.string.bookPublisher), "");
//        String description = sharedPreferences.getString(getString(R.string.description), "");
//        String datePublished = sharedPreferences.getString(getString(R.string.datePublished), "");
//        //String goalDate = sharedPreferences.getString(getString(R.string.goalDate),"Goal Here");
//
//        mTextTitle.setText(bookTitle);
//        //mTextPgRemain.setText(numPages);
//        mTextPgRemain.setText("Remaining Pages:");
//        mTextReadTod.setText("Pages to Read Today");
//        //mTextGoalDate.setText(goalDate);
//        //imgurl = currentReadingimg;
//        //Picasso.get().load(currentReadingimg).into(imageView);
//
//    }
}
