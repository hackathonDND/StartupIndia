package in.gov.startupindia.activity;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import in.gov.startupindia.R;

public class feedback extends AppCompatActivity {
    FeedbackDatabase db;
    EditText fname, lname, city, address, email, contact, comment;
    Spinner state, feedback;
    Button submit, reset;
    String ifname, ilname, istate, icity, iaddress, iemail, icontact, ifeedback, icomment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feedback);
        db = new FeedbackDatabase(this);
        fname = (EditText) findViewById(R.id.efname);
        lname = (EditText) findViewById(R.id.elname);
        state = (Spinner) findViewById(R.id.sstate);
        city = (EditText) findViewById(R.id.ecity);
        address = (EditText) findViewById(R.id.eaddress);
        email = (EditText) findViewById(R.id.eemail);
        contact = (EditText) findViewById(R.id.econtact);
        feedback = (Spinner) findViewById(R.id.sfeedback);
        comment = (EditText) findViewById(R.id.ecomment);
        submit = (Button) findViewById(R.id.submit);
        ifname = fname.getText().toString().trim();
        ilname = lname.getText().toString().trim();
        istate = String.valueOf(state.getSelectedItem());
        icity = city.getText().toString().trim();
        iaddress = address.getText().toString().trim();
        iemail = email.getText().toString().trim();
        icontact = contact.getText().toString().trim();
        ifeedback = String.valueOf(feedback.getSelectedItem());
        icomment = comment.getText().toString().trim();
        LinearLayout layout = (LinearLayout) findViewById(R.id.ll);
        onTapOutsideBehaviour(layout);

    }


    public void onSubmit(View view) {

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isInserted = db.insertData(ifname, ilname, istate, icity, iaddress, iemail, icontact, ifeedback, icomment);
                if (isInserted == true) {
                    Toast.makeText(feedback.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                    onReset(view);
                } else
                    Toast.makeText(feedback.this, "Data not inserted", Toast.LENGTH_SHORT).show();
            }
        });


    }

    public void onReset(View v) {

        fname.setText("");
        lname.setText("");
        state.setSelection(0);
        city.setText("");
        address.setText("");
        email.setText("");
        contact.setText("");
        feedback.setSelection(0);
        comment.setText("");
    }

    private void onTapOutsideBehaviour(View view) {
        if (!(view instanceof EditText) || !(view instanceof Button)) {
            view.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {
                    hideSoftKeyboard(feedback.this);
                    return false;
                }

            });
        }
    }

    private static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
    }
}
