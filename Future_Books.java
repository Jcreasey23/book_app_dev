package source;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Future Books class holds the user's future reads
 * Not quite functional as of 1.24.23
 */
public class Future_Books extends AppCompatActivity {

    ImageView imageView;    // cover image
    int imagevalue;
    TextView mTextview; // Title

    Book incomingBook = new Book();
    Vector<Book> futureShelf;

    Button Start_Reading;   // begin reading saved book
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_future_books);


        ArrayList<String> a = new ArrayList<>();
        String imgurl;

        // set textfields and image
        mTextview = (TextView)findViewById(R.id.Title);
        mTextview.setText(getIntent().getStringExtra("Title")); // set textview labeled Title to title of book
        incomingBook.setTitle(getIntent().getStringExtra("Title"));
        mTextview = (TextView)findViewById(R.id.Pages);
        imageView = (ImageView)findViewById(R.id.img);
        imgurl = getIntent().getStringExtra("image");
        Picasso.get().load(imgurl).into(imageView);
        mTextview.setText("Pages: " + String.valueOf(getIntent().getIntExtra("Pages",0)));  // set pages in book to string


        incomingBook.setPageCount(getIntent().getIntExtra("Pages",0));
        incomingBook.setShelf_Status("Future Books");
        incomingBook.setGoal_set(false);
        incomingBook.setProgress(0);
        incomingBook.setPublisher(getIntent().getStringExtra("publisher"));
        incomingBook.setDescription(getIntent().getStringExtra("description"));
        incomingBook.setPublishDate(getIntent().getStringExtra("publishedDate"));
        incomingBook.setAuthors(getIntent().getStringArrayListExtra("author"));
        incomingBook.setCover(imgurl);

        // initializing on click listener for Start Reading button.
        Start_Reading = findViewById(R.id.Start_Reading);
        Start_Reading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendtoCurrent = new Intent(Future_Books.this, Current_Books.class);
                Intent sendtoHome = new Intent(Future_Books.this, MainActivity.class);
                //sendTitle.putExtra("img",byteArray);
                sendtoCurrent.putExtra("image",incomingBook.getCover());
                sendtoHome.putExtra("image",incomingBook.getCover());
                sendtoCurrent.putExtra("Title", incomingBook.getTitle());
                sendtoHome.putExtra("Title", incomingBook.getTitle());
                sendtoCurrent.putExtra("Pages", incomingBook.getPageCount());
                sendtoHome.putExtra("Pages", incomingBook.getPageCount());
                sendtoCurrent.putExtra("publisher",incomingBook.getPublisher());
                sendtoHome.putExtra("publisher",incomingBook.getPublisher());
                sendtoCurrent.putExtra("author",incomingBook.getAuthors());
                sendtoHome.putExtra("author",incomingBook.getAuthors());
                sendtoCurrent.putExtra("description", incomingBook.getDescription());
                sendtoHome.putExtra("description", incomingBook.getDescription());
                sendtoCurrent.putExtra("publishedDate",incomingBook.getPublishDate());
                sendtoHome.putExtra("publishedDate",incomingBook.getPublishDate());
                //sendTitle.putExtra("cardView",b);
                startActivity(sendtoCurrent);
                startActivity(sendtoHome);


            }
        }); // end of start reading button click
    }

    public void goalsClicked(View view) {
        startActivity(new Intent(Future_Books.this, Goals_Activity.class));
    }

    public void homeClicked(View view) {
        startActivity(new Intent(Future_Books.this, MainActivity.class));
    }

    public void statsClicked(View view) {
        startActivity(new Intent(Future_Books.this, Stats_Activity.class));
    }

    public void booksClicked(View view) {
        startActivity(new Intent(Future_Books.this, Books_Activity.class));
    }

}
