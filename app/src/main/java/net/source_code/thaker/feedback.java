package net.source_code.thaker;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class feedback extends AppCompatActivity {
    private EditText subject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        subject = (EditText) findViewById(R.id.editText);
        Button sendbtn = (Button)findViewById(R.id.Send);

sendbtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        sendEmail();
    }
});

    }
    protected void sendEmail() {





        Intent email = new Intent(Intent.ACTION_SEND, Uri.parse("mailto:"));

        email.setType("message/rfc822");



        email.putExtra(Intent.EXTRA_EMAIL, new String[]{"warrior259@gmail.com"});

        email.putExtra(Intent.EXTRA_SUBJECT, "Thaker_app");

        email.putExtra(Intent.EXTRA_TEXT, subject.getText().toString());



        try {

            // the user can choose the email client

            startActivity(Intent.createChooser(email, "Choose an email client from..."));



        } catch (android.content.ActivityNotFoundException ex) {

            Toast.makeText(this, "No email client installed.", Toast.LENGTH_LONG).show();

        }

    }



}



