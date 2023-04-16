import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
/*
 * Book Class stores info about a particular book... this may not be necessary
 *
 */
public class Book {
    public String Coverurl;

    public String title;
    public int pageCount;
    public ArrayList<String> authors;;
    public String description;

    public String publisher;
    public String publishDate;

    // Addtional Attributes
    public double progress; // progress made through book
    public String shelf_Status;

    public boolean goal_set;
    public int remainingPages;
    public int pagesToday;

    // Book Constructor
    Book(){
        this.setCover(null);
        this.setAuthors(null);
        this.setPageCount(0);
        this.setDescription("No Description");
        this.setPublisher("No Publisher");
        this.setPublishDate("No Publish Date");
        this.setProgress(0);
        this.setShelf_Status("No Shelf");
        this.setGoal_set(false);
        this.setPagesToday(0);
        this.setRemainingPages(0);
    }
    Book(String image, ArrayList<String> auth,String title, int pgct, String desc, String pub, String pubdat, String shelf, boolean goal, int pgtoday, int remainpg){
        this.setCover(image);
        this.setTitle(title);
        this.setAuthors(auth);
        this.setPageCount(pgct);
        this.setDescription(desc);
        this.setPublisher(pub);
        this.setPublishDate(pubdat);
        this.setProgress(0);
        this.setShelf_Status(shelf);
        this.setGoal_set(goal);
        this.setPagesToday(0);
        this.setRemainingPages(0);
    }

    public String getCover(){
        return Coverurl;
    }
    public void setCover(String cover){
        this.Coverurl = cover;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String t){
        this.title = t;
    }

    public int getPageCount(){
        return pageCount;
    }
    public void setPageCount(int pg){
        this.pageCount = pg;
    }

    public ArrayList<String> getAuthors(){
        return authors;
    }
    public void setAuthors(ArrayList<String> a){
        this.authors = a;
    }

    public String getDescription(){
        return description;
    }
    public void setDescription(String des){
        this.description = des;
    }

    public String getPublisher(){
        return publisher;
    }
    public void setPublisher(String pub){
        this.publisher = pub;
    }

    public String getPublishDate(){
        return publishDate;
    }
    public void setPublishDate(String pubd){
        this.publishDate = pubd;
    }

    public int getRemainingPages(){
        return remainingPages;
    }
    public void setRemainingPages(int pgr){
        this.remainingPages = pgr;
    }

    public String getShelf_Status(){
        return shelf_Status;
    }
    public void setShelf_Status(String shelf){
        this.shelf_Status = shelf;
    }

    public double getProgress(){
        return progress;
    }
    public void setProgress(double p){
        this.progress = p;
    }

    public int getPagesToday(){
        return pagesToday;
    }
    public void setPagesToday(int pgt){
        this.pagesToday = pgt;
    }

    public boolean isGoal_set(){
        return goal_set;
    }
    public void setGoal_set(boolean b){
        this.goal_set = b;
    }

}
