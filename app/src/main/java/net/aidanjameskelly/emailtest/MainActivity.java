package net.aidanjameskelly.emailtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button send;
    TextView senderTextView;
    TextView passwordTextView;
    TextView recipientTextView;
    TextView subjectTextView;
    TextView bodyTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        senderTextView = findViewById(R.id.senderTextView);
        passwordTextView = findViewById(R.id.passwordTextView);
        recipientTextView = findViewById(R.id.recipientTextView);
        subjectTextView = findViewById(R.id.subjectTextView);
        bodyTextView = findViewById(R.id.emailTextView);


    }

    public void sendEmail(View view){
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    GMailSender sender = new GMailSender(senderTextView.getText().toString(),
                            passwordTextView.getText().toString());
                    sender.sendMail(subjectTextView.getText().toString(), bodyTextView.getText().toString(),
                            senderTextView.getText().toString(), recipientTextView.getText().toString());
                } catch (Exception e) {
                    Log.e("SendMail", e.getMessage(), e);
                }
            }



        }).start();
        Toast.makeText(this, "Email sent!", Toast.LENGTH_SHORT).show();
    }



}
