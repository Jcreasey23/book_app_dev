package source;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.squareup.picasso.Picasso;

/*
 * Intended use for update progress is change reading progress for current books
 * Not yet implemented as this is currently acting as the set goal button seen on the home screen
 * This will need to be changed
 */
public class Update_Progress extends AppCompatActivity {

    EditText input;
    Book book;
    String temp;
    LinearProgressIndicator progBar;
    int holder;
    ImageView imageView;
    int imagevalue;
    TextView mTextview;

    Book incomingBook = new Book();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_progress);

        String imgurl;

        mTextview = (TextView)findViewById(R.id.Book_Title);
        mTextview.setText(getIntent().getStringExtra("Title")); // set textview labeled Title to title of book

        imageView = (ImageView)findViewById(R.id.img);
        imgurl = getIntent().getStringExtra("image");
        Picasso.get().load(imgurl).into(imageView);

    }
    public void submitUpdate(View view){
        input = (EditText) findViewById(R.id.updated_progress);
        //book.setProgress(Integer.parseInt(input.getText().toString()));
        holder = Integer.parseInt(input.getText().toString());
        //progBar.setProgress(hol);
        Intent sendProg = new Intent(Update_Progress.this, MainActivity.class);
        sendProg.putExtra("update_prog", holder);
        startActivity(new Intent(Update_Progress.this, MainActivity.class));
    }
}