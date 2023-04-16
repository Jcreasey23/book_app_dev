import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/*
 * Book Details allows google api to pull and store all information found when a book is selected from scroll view of results
 * UPDATES Home Screen with current reads info
 * Documentation can be found here https://www.geeksforgeeks.org/how-to-build-a-book-library-app-using-google-books-api-in-android/
 */
public class BookDetails extends AppCompatActivity {

    // creating variables for strings,text view, image views and button.
    String title, subtitle, publisher, publishedDate, description, thumbnail, previewLink, infoLink, buyLink;
    int pageCount;
    private ArrayList<String> authors;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    TextView titleTV, subtitleTV, publisherTV, descTV, pageTV, publishDateTV;
    Button previewBtn, buyBtn;
    private ImageView bookIV;
    Future_Books shelf = new Future_Books();
    public static Drawable drawimage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = sharedPreferences.edit();

        // initializing our views..
        titleTV = findViewById(R.id.idTVTitle);
        subtitleTV = findViewById(R.id.idTVSubTitle);
        publisherTV = findViewById(R.id.idTVpublisher);
        descTV = findViewById(R.id.idTVDescription);
        pageTV = findViewById(R.id.idTVNoOfPages);
        publishDateTV = findViewById(R.id.idTVPublishDate);
        previewBtn = findViewById(R.id.idBtnPreview);
        buyBtn = findViewById(R.id.idBtnBuy);
        bookIV = findViewById(R.id.idIVbook);

        // getting the data which we have passed from our adapter class.
        title = getIntent().getStringExtra("title");
        subtitle = getIntent().getStringExtra("subtitle");
        publisher = getIntent().getStringExtra("publisher");
        publishedDate = getIntent().getStringExtra("publishedDate");
        description = getIntent().getStringExtra("description");
        pageCount = getIntent().getIntExtra("pageCount", 0);
        thumbnail = getIntent().getStringExtra("thumbnail");
        editor.putString(getString(R.string.currentReadingimg),thumbnail);
        editor.commit();
        previewLink = getIntent().getStringExtra("previewLink");
        infoLink = getIntent().getStringExtra("infoLink");
        buyLink = getIntent().getStringExtra("buyLink");

        // after getting the data we are setting
        // that data to our text views and image view.
        titleTV.setText(title);
        subtitleTV.setText(subtitle);
        publisherTV.setText(publisher);
        publishDateTV.setText("Published On : " + publishedDate);
        descTV.setText(description);
        pageTV.setText("No Of Pages : " + pageCount);
        Picasso.get().load(thumbnail).into(bookIV);

        // adding on click listener for our add to future reads button.
        previewBtn = findViewById(R.id.idBtnPreview);
        previewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // On click of button, we will copy the current Book to the future reads page
                // add photo of cover, title, page count, and progress = not started
                //Book b = new Book(bookIV,authors,title, pageCount, description, publisher, publishedDate, "Future Reads", false, 0,0);

//                shelf.futureShelf.add(b);
                // add the image in putExtra
                // and send the data in next activity
                Intent sendTitle = new Intent(BookDetails.this, Future_Books.class);
                //sendTitle.putExtra("img",byteArray);
                sendTitle.putExtra("image",thumbnail);
//                editor.putString(getString(R.string.currentReadingimg),thumbnail);
//                editor.commit();
                sendTitle.putExtra("Title", title);
//                editor.putString(getString(R.string.bookTitle),title);
//                editor.commit();
                sendTitle.putExtra("Pages", pageCount);
//                editor.putInt(getString(R.string.numPages),pageCount);
//                editor.commit();
                sendTitle.putExtra("publisher",publisher);
//                editor.putString(getString(R.string.bookPublisher),publisher);
//                editor.commit();
                sendTitle.putExtra("author",authors);
                sendTitle.putExtra("description", description);
//                editor.putString(getString(R.string.description),description);
//                editor.commit();
                sendTitle.putExtra("publishedDate",publishedDate);
//                editor.putString(getString(R.string.datePublished),publishedDate);
//                editor.commit();
                //sendTitle.putExtra("cardView",b);
                startActivity(sendTitle);
            }
        }); // end of future reads button click

        // initializing on click listener for Start Reading button.
        buyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendtoCurrent = new Intent(BookDetails.this, Current_Books.class);
                Intent sendtoHome = new Intent(BookDetails.this, MainActivity.class);
                //sendTitle.putExtra("img",byteArray);
                sendtoCurrent.putExtra("image",thumbnail);
                sendtoHome.putExtra("image",thumbnail);
                editor.putString(getString(R.string.currentReadingimg),thumbnail);
                editor.commit();
                sendtoCurrent.putExtra("Title", title);
                //sendtoHome.putExtra("Title", title);
                editor.putString(getString(R.string.bookTitle),title);
                editor.commit();
                sendtoCurrent.putExtra("Pages", pageCount);
                sendtoHome.putExtra("Pages", pageCount);
                editor.putInt("pageCount",pageCount);
                editor.commit();
                sendtoCurrent.putExtra("publisher",publisher);
                sendtoHome.putExtra("publisher",publisher);
//                sendtoCurrent.putExtra("author",authors);
//                sendtoHome.putExtra("author",authors);
                sendtoCurrent.putExtra("description", description);
                sendtoHome.putExtra("description", description);
                sendtoCurrent.putExtra("publishedDate",publishedDate);
                sendtoHome.putExtra("publishedDate",publishedDate);
                //sendTitle.putExtra("cardView",b);
                startActivity(sendtoCurrent);
                startActivity(sendtoHome);


            }
        }); // end of start reading button click
    }
}