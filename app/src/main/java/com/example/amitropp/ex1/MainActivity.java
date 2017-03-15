package com.example.amitropp.ex1;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    EditText msg;
    ScrollView scrollView;
    Calendar cal = Calendar.getInstance();
    SimpleDateFormat date = new SimpleDateFormat("HH:mm");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button sendButton = (Button) findViewById(R.id.button);
        msg = (EditText) findViewById(R.id.editText);
        textView = (TextView) findViewById(R.id.textView);
        scrollView = (ScrollView) findViewById(R.id.scrollView);

        //set an onClick listener
        sendButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            public void onClick(View v)
            {
                String msgStr = msg.getText().toString();
                String dateStr = date.format(cal.getTime());
                textView.append("\n" + dateStr + "\t\t" + msgStr);
                msg.setText("");
                //scroll down on each new message
                scrollView.post(new Runnable()
                {
                    public void run()
                    {
                        scrollView.fullScroll(View.FOCUS_DOWN);
                    }
                });
            }
        });
    }
}

