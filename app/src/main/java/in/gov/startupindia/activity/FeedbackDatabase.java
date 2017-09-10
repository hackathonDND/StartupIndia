package in.gov.startupindia.activity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by hp on 02-04-2017.
 */

public class FeedbackDatabase extends SQLiteOpenHelper {
    private static final String DbName="Feedback";
    private static final int DbVersion=1;
    static int a;
    public FeedbackDatabase(Context context)
    {
        super(context,DbName,null,DbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db)

    {

        db.execSQL("CREATE TABLE FEEDBACK"+"(_id INTEGER PRIMARY KEY AUTOINCREMENT,FNAME TEXT,LNAME TEXT,STATE TEXT," +
                "CITY TEXT,ADDRESS TEXT,EMAIL TEXT,CONTACT INTEGER,FEEDBACK TEXT,COMMENTS TEXT);");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS"+"FEEDBACK");
        onCreate(db);
    }

    public boolean insertData(String fname, String lname,String state, String city, String address, String email, String contact, String feedback, String comment)
{
     SQLiteDatabase db=this.getWritableDatabase();
    ContentValues contentValues=new ContentValues();
    contentValues.put("FNAME",fname);
    contentValues.put("LNAME",lname);
    contentValues.put("STATE",state);
    contentValues.put("CITY",city);
    contentValues.put("ADDRESS",address);
    contentValues.put("EMAIL",email);
    contentValues.put("CONTACT",contact);
    contentValues.put("FEEDBACK",feedback);
    contentValues.put("COMMENTS",comment);
    long result=db.insert("FEEDBACK",null,contentValues);
    if(result==-1)
    {
        return false;

    }
    else
        return true;
}
}
