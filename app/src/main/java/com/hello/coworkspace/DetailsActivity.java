package com.hello.coworkspace;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class DetailsActivity extends AppCompatActivity {
    ImageView photo;
    TextView name, description, hours, address;
String spaceName, spacePhoto ,spaceDescription, spaceHours, spaceAddress;
int image;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_details);
        photo=findViewById(R.id.spacePhoto);
        name=findViewById(R.id.spaceName);
//        description=findViewById(R.id.spaceDescription);
        hours=findViewById(R.id.spaceHours);
        address=findViewById(R.id.spaceAddress);

        spaceName= getIntent().getStringExtra("spaceName");
        spaceDescription= getIntent().getStringExtra("spaceDesription");
        spaceAddress= getIntent().getStringExtra("spaceAddress");
        spacePhoto= getIntent().getStringExtra("spacePhoto");
        spaceHours= getIntent().getStringExtra("spaceHours");


        name.setText(spaceName);
        address.setText(spaceAddress);
        hours.setText("Opens at : "+spaceHours);
        Glide.with(photo).load(Uri.parse(getIntent().getStringExtra("spacePhoto"))).into(photo);



    }
}
