package com.ahnelson.csce4623.myinternetproject;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private final String LOGTAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btnBrowsePage).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                browsePage();
            }
        });
        findViewById(R.id.btnNextActivity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextActivity();
            }
        });
        findViewById(R.id.btnHttpActivity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startHttpActivity();
            }
        });
    }

    protected void browsePage(){
        String myWebpage;
        EditText myEditText = (EditText) findViewById(R.id.etWebsite);
        myWebpage = myEditText.getText().toString();
        if(!myWebpage.startsWith("http://")){
            if(!myWebpage.startsWith("https://")){
                myWebpage = "https://" + myWebpage;
            }
        }
        Intent myBrowseIntent = new Intent();
        myBrowseIntent.setAction(Intent.ACTION_VIEW);
        myBrowseIntent.addCategory(Intent.CATEGORY_BROWSABLE);
        myBrowseIntent.setData(Uri.parse(myWebpage));
        if(this.getPackageManager().resolveActivity(myBrowseIntent,0) != null){
            startActivity(myBrowseIntent);
        }
        else{
            Log.e(LOGTAG,"No Activity can Resolve");
        }

        return;
    }

    protected void nextActivity(){
        String myWebpage;
        EditText myEditText = (EditText) findViewById(R.id.etWebsite);
        myWebpage = myEditText.getText().toString();
        if(!myWebpage.startsWith("http://")){
            if(!myWebpage.startsWith("https://")){
                myWebpage = "https://" + myWebpage;
            }
        }
        Intent myWebViewActivity = new Intent(this,WebViewActivity.class);
        myWebViewActivity.putExtra("webpage",myWebpage);
        this.startActivity(myWebViewActivity);
    }

    protected void startHttpActivity(){
        String myWebpage;
        EditText myEditText = (EditText) findViewById(R.id.etWebsite);
        myWebpage = myEditText.getText().toString();
        if(!myWebpage.startsWith("http://")){
            if(!myWebpage.startsWith("https://")){
                myWebpage = "https://" + myWebpage;
            }
        }
        Intent myWebViewActivity = new Intent(this,HTTPClientActivity.class);
        myWebViewActivity.putExtra("webpage",myWebpage);
        this.startActivity(myWebViewActivity);
    }
}
