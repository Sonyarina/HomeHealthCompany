package com.example.android.homehealthcompany;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    TextView nurseHoursTextView;
    TextView moreInfoTextView;
    TextView lessInfoTextView;
    LinearLayout hoursLinearLayoutView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nurseHoursTextView = findViewById(R.id.nurseHours);
        hoursLinearLayoutView = findViewById(R.id.dailyHours);
        moreInfoTextView = findViewById(R.id.moreDetails);
        lessInfoTextView = findViewById(R.id.lessDetails);

        moreInfoTextView.setVisibility(View.VISIBLE);

        //Hide Views Until User Requests More Info
        nurseHoursTextView.setVisibility(View.GONE);
        hoursLinearLayoutView.setVisibility(View.GONE);
        lessInfoTextView.setVisibility(View.GONE);
    }

    /**
     * If User Requests More Information on Hours of Operation
     */
    public void viewAllHours(View view) {

        //Hide text view that says "More Details"
        moreInfoTextView.setVisibility(View.GONE);

        //Make the views that contain information about Hours of Operation visible
        nurseHoursTextView.setVisibility(View.VISIBLE);
        hoursLinearLayoutView.setVisibility(View.VISIBLE);
        lessInfoTextView.setVisibility(View.VISIBLE);
    }

    /**
     * If User Requests Less Information on Hours of Operation
     */
    public void viewLessHours(View view) {

        //Make the views that contain information about Hours of Operation invisible
        nurseHoursTextView.setVisibility(View.GONE);
        hoursLinearLayoutView.setVisibility(View.GONE);
        lessInfoTextView.setVisibility(View.GONE);

        //Hide text view that says "More Details"
        moreInfoTextView.setVisibility(View.VISIBLE);
    }

    /**
     * If User Clicks Button to Send Message
     */
    public void sendMessage(View view) {

        //Retrieve email address and subject line from strings resource
        String emailAddress = getString(R.string.send_message_to);
        String subject = getString(R.string.email_subject);

        //Send Intent to compose email to with the inputs referenced above
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // message to be sent through an email app
        intent.putExtra(Intent.EXTRA_EMAIL, emailAddress);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /**
     * If User Clicks Text to Visit Website
     */
    public void visitWebsite(View view) {

        TextView urlTextView = findViewById(R.id.website);
        urlTextView.setTextColor(Color.parseColor("#9FA8DA"));

        String url = getString(R.string.url_website);
        //Send Intent to open website
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /**
     * If User Clicks Text to View More Locations
     */
    public void viewLocations(View view) {

        String url = getString(R.string.url_locations);

        //Send Intent to open website
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /**
     * If User Clicks Address
     */
    public void getDirections(View view) {

        String location = getString(R.string.geolocation);
        //Send Intent to open website
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(location));

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /**
     * If User Clicks Text to Call
     */
    public void callNumber(View view) {

        String number = getString(R.string.phone);

        //Send Intent to call number
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse(number));

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
