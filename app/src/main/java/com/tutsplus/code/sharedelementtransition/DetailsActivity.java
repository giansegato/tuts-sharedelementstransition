package com.tutsplus.code.sharedelementtransition;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class DetailsActivity extends Activity {

    public final static String ID = "ID";
    public Contact mContact;

    public TextView mName, mPhone, mEmail, mCity;
    public View mCircle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        // Retrieve data
        mContact = Contact.getItem(getIntent().getIntExtra(ID, 0));

        // Views
        mName = (TextView) findViewById(R.id.DETAILS_name);
        mPhone = (TextView) findViewById(R.id.DETAILS_phone);
        mCity = (TextView) findViewById(R.id.DETAILS_city);
        mEmail = (TextView) findViewById(R.id.DETAILS_email);
        mCircle = findViewById(R.id.DETAILS_circle);

        // Data population
        mName.setText(mContact.get(Contact.Field.NAME));
        mPhone.setText(mContact.get(Contact.Field.PHONE));
        mCity.setText(mContact.get(Contact.Field.CITY));
        mEmail.setText(mContact.get(Contact.Field.EMAIL));
        GradientDrawable bgShape = (GradientDrawable) mCircle.getBackground();
        bgShape.setColor(Color.parseColor(mContact.get(Contact.Field.COLOR)));

    }

}
