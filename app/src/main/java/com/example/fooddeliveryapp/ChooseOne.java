package com.example.fooddeliveryapp;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ChooseOne extends AppCompatActivity {


    Button chef,customer,deliveryman;
    Intent intent;
    String type;
    ConstraintLayout bgimage;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_choose_one);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.back3), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        AnimationDrawable animationDrawable = new AnimationDrawable();
        //animationDrawable.addFrame(getResources().getDrawable(R.drawable.bg2),3000);
        //animationDrawable.addFrame(getResources().getDrawable(R.drawable.img2),3000);
        //animationDrawable.addFrame(getResources().getDrawable(R.drawable.img3),3000);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img4),3000);
        //animationDrawable.addFrame(getResources().getDrawable(R.drawable.img5),3000);
        //animationDrawable.addFrame(getResources().getDrawable(R.drawable.img6),3000);
        //animationDrawable.addFrame(getResources().getDrawable(R.drawable.img7),3000);
        //animationDrawable.addFrame(getResources().getDrawable(R.drawable.img8),3000);
        //animationDrawable.addFrame(getResources().getDrawable(R.drawable.img9),3000);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img10),3000);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img11),3000);

        animationDrawable.setOneShot(false);
        animationDrawable.setEnterFadeDuration(850);
        animationDrawable.setExitFadeDuration(1600);

        bgimage = findViewById(R.id.back3);
        bgimage.setBackgroundDrawable(animationDrawable);
        animationDrawable.start();

        intent = getIntent();
        type = intent.getStringExtra("Home").toString().trim();

        chef = findViewById(R.id.chef);
        deliveryman = (Button) findViewById(R.id.delivery);
        customer = (Button) findViewById(R.id.customer);

        chef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(type.equals("Email")){
                    Intent loginemail = new Intent(ChooseOne.this,ChefLoginEmail.class);
                    startActivity(loginemail);
                    finish();
                }
                if(type.equals("Phone")){
                    Intent loginphone = new Intent(ChooseOne.this,ChefLoginPhone.class);
                    startActivity(loginphone);
                    finish();
                }
                if(type.equals("Signup")){
                    Intent register = new Intent(ChooseOne.this,ChefRegistration.class);
                    startActivity(register);
                    //finish();
                }
            }
        });

        customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(type.equals("Email")){
                    Intent loginemailcustomer = new Intent(ChooseOne.this,CustomerLoginEmail.class);
                    startActivity(loginemailcustomer);
                    finish();
                }
                if(type.equals("Phone")){
                    Intent loginphonecustomer = new Intent(ChooseOne.this,CustomerLoginPhone.class);
                    startActivity(loginphonecustomer);
                    finish();
                }
                if(type.equals("Signup")){
                    Intent registercustomer = new Intent(ChooseOne.this,CustomerLoginRegistration.class);
                    startActivity(registercustomer);
                    //finish();
                }
            }
        });

        deliveryman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(type.equals("Email")){
                    Intent loginemaildeliveryman = new Intent(ChooseOne.this,DeliveryLoginEmail.class);
                    startActivity(loginemaildeliveryman);
                    finish();
                }
                if(type.equals("Phone")){
                    Intent loginphonedeliveryman = new Intent(ChooseOne.this,DeliveryLoginPhone.class);
                    startActivity(loginphonedeliveryman);
                    finish();
                }
                if(type.equals("Signup")){
                    Intent registerdeliveryman = new Intent(ChooseOne.this,DeliveryLoginRegistration.class);
                    startActivity(registerdeliveryman);
                    //finish();
                }
            }
        });







    }
}