package in.gov.startupindia.fragments;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import in.gov.startupindia.R;

public class WebViewActivity extends AppCompatActivity {
    WebView browser;
    String url = null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        browser = (WebView) findViewById(R.id.webView);
        browser.getSettings().setJavaScriptEnabled(true);
        browser.setWebViewClient(new WebViewClient());

        final URLassignment ur = new URLassignment();

        int id = ur.getId();

        if (id == R.id.next2) {
            browser.loadUrl("http://www.startupindia.gov.in/startup-registration.php");
        }
        if (id == R.id.card_ir1) {
            browser.loadUrl("http://docs.google.com/gview?embedded=true&url=http://www.startupindia.gov.in/uploads/Guidelines.docx");
        }
        if (id == R.id.card8) {
            browser.loadUrl("https://m.youtube.com/watch?v=Ai4eEarCTGw&list=PL3eSrq6SV06twHoubuK_2PaF1HH6UX4jL");
        }
    }
}