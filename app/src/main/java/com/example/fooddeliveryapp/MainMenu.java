package com.example.fooddeliveryapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainMenu extends AppCompatActivity {
    Button signWithEmail,signWithPhone,signup;
    ImageView bgimage;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_menu);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.back2), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        final Animation Zoomin = AnimationUtils.loadAnimation(this,R.anim.zoomin);
        final Animation Zoomout = AnimationUtils.loadAnimation(this,R.anim.zoomout);
        //final Animation Move = AnimationUtils.loadAnimation(this,R.anim.move);
        bgimage = findViewById(R.id.back2);
        bgimage.setAnimation(Zoomin);
        //bgimage.setAnimation(Zoomout);

        Zoomout.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                bgimage.startAnimation((Zoomin));
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        Zoomin.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                bgimage.startAnimation((Zoomout));
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        signWithEmail = (Button) findViewById(R.id.SignWithEmail);
        signWithPhone = (Button) findViewById(R.id.SignWithPhone);
        signup = (Button) findViewById(R.id.Signup);

        signWithEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signWithEmail = new Intent(MainMenu.this,ChooseOne.class);
                signWithEmail.putExtra("Home","Email");
                startActivity(signWithEmail);
                finish();

            }
        });

        signWithPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signWihtPhone = new Intent(MainMenu.this,ChooseOne.class);
                signWihtPhone.putExtra("Home","Phone");
                startActivity(signWihtPhone);
                finish();
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signup = new Intent(MainMenu.this,ChooseOne.class);
                signup.putExtra("Home","Signup");
                startActivity(signup);
                finish();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //System.gc();
    }
}