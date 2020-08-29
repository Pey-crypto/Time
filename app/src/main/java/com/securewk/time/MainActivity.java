package com.securewk.time;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        datefind();
    }

    private void datefind() {

        Instant jam = Instant.now();
        ZoneId dart = ZoneId.of("Asia/Kolkata");
        ZonedDateTime dart2 = ZonedDateTime.ofInstant(jam, dart);
        DateTimeFormatter dart3 = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm a");
        final String fi = dart2.format(dart3);
        Log.e("Date", fi);
        SNTPClient.getDate(TimeZone.getTimeZone("Asia/Kolkata"), new SNTPClient.Listener() {
            @Override
            public void onTimeReceived(String rawDate) {
                Log.e("Entered","Entered");
                DateCheck(fi, rawDate);
            }

            @Override
            public void onError(Exception ex) {

            }
        });

    }
    private void DateCheck(String fi, String rawDate){
        Log.e("Find",fi);
        Log.e("raw",rawDate);
        if(fi.equals(rawDate)){
            Log.e("Done","Fin");
        }
    }
}
