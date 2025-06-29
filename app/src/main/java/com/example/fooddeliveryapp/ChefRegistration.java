package com.example.fooddeliveryapp;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.hbb20.CountryCodePicker;

import java.util.ArrayList;

public class ChefRegistration extends AppCompatActivity {
    String[] Dhaka = {
            "Dhaka", "Faridpur", "Gazipur", "Gopalganj", "Kishoreganj",
            "Madaripur", "Manikganj", "Munshiganj", "Narayanganj",
            "Narsingdi", "Rajbari", "Shariatpur", "Tangail"
    };

    String[] Chattogram = {
            "Bandarban", "Brahmanbaria", "Chandpur", "Chattogram",
            "Cumilla", "Cox's Bazar", "Feni", "Khagrachari",
            "Lakshmipur", "Noakhali", "Rangamati"
    };

    String[] Rajshahi = {
            "Bogura", "Chapainawabganj", "Joypurhat", "Naogaon",
            "Natore", "Pabna", "Rajshahi", "Sirajganj"
    };

    String[] Khulna = {
            "Bagerhat", "Chuadanga", "Jashore", "Jhenaidah",
            "Khulna", "Kushtia", "Magura", "Meherpur",
            "Narail", "Satkhira"
    };

    String[] Barisal = {
            "Barguna", "Barishal", "Bhola", "Jhalokathi",
            "Patuakhali", "Pirojpur"
    };

    String[] Sylhet = {
            "Habiganj", "Moulvibazar", "Sunamganj", "Sylhet"
    };

    String[] Rangpur = {
            "Dinajpur", "Gaibandha", "Kurigram", "Lalmonirhat",
            "Nilphamari", "Panchagarh", "Rangpur", "Thakurgaon"
    };

    String[] Mymensingh = {
            "Jamalpur", "Mymensingh", "Netrokona", "Sherpur"
    };

    TextInputLayout Fname, Lname, Email, mobileno, Pass, cpass, houseno, area, pincode;
    Spinner Statespin, Cityspin;
    Button signup, Emaill, phone;
    CountryCodePicker Cpp;
    FirebaseAuth FAuth;
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;
    String fname, lname, emailid, mobile, password, confpassword, house, Area, Pincode, role = "Chef", statee, cityy;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chef_registration);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Fname = (TextInputLayout) findViewById(R.id.Firstname);
        Lname = (TextInputLayout) findViewById(R.id.Lastname);
        Email = (TextInputLayout) findViewById(R.id.Email);
        mobileno = (TextInputLayout) findViewById(R.id.Mobileno);
        Pass = (TextInputLayout) findViewById(R.id.Pwd);
        cpass = (TextInputLayout) findViewById(R.id.Cpass);
        houseno = (TextInputLayout) findViewById(R.id.HouseNo);
        area = (TextInputLayout) findViewById(R.id.Area);
        pincode = (TextInputLayout) findViewById(R.id.PostCode);
        Statespin = (Spinner) findViewById(R.id.state);
        Cityspin = (Spinner) findViewById(R.id.city);

        signup = (Button) findViewById(R.id.Signup);
        Emaill = (Button) findViewById(R.id.email);
        phone = (Button) findViewById(R.id.phone);

        Cpp = (CountryCodePicker) findViewById(R.id.CountryCode);

        Statespin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Object value = parent.getItemAtPosition(position);
                statee = value.toString().trim();

                if (statee.equals("Dhaka")) {
                    ArrayList<String> list = new ArrayList<>();
                    for (String cities : Dhaka) {
                        list.add(cities);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(ChefRegistration.this, android.R.layout.simple_spinner_item, list);
                    Cityspin.setAdapter(arrayAdapter);
                } else if (statee.equals("Chattogram")) {
                    ArrayList<String> list = new ArrayList<>();
                    for (String cities : Chattogram) {
                        list.add(cities);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(ChefRegistration.this, android.R.layout.simple_spinner_item, list);
                    Cityspin.setAdapter(arrayAdapter);
                } else if (statee.equals("Rajshahi")) {
                    ArrayList<String> list = new ArrayList<>();
                    for (String cities : Rajshahi) {
                        list.add(cities);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(ChefRegistration.this, android.R.layout.simple_spinner_item, list);
                    Cityspin.setAdapter(arrayAdapter);
                } else if (statee.equals("Khulna")) {
                    ArrayList<String> list = new ArrayList<>();
                    for (String cities : Khulna) {
                        list.add(cities);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(ChefRegistration.this, android.R.layout.simple_spinner_item, list);
                    Cityspin.setAdapter(arrayAdapter);
                } else if (statee.equals("Barisal")) {
                    ArrayList<String> list = new ArrayList<>();
                    for (String cities : Barisal) {
                        list.add(cities);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(ChefRegistration.this, android.R.layout.simple_spinner_item, list);
                    Cityspin.setAdapter(arrayAdapter);
                } else if (statee.equals("Sylhet")) {
                    ArrayList<String> list = new ArrayList<>();
                    for (String cities : Sylhet) {
                        list.add(cities);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(ChefRegistration.this, android.R.layout.simple_spinner_item, list);
                    Cityspin.setAdapter(arrayAdapter);
                } else if (statee.equals("Rangpur")) {
                    ArrayList<String> list = new ArrayList<>();
                    for (String cities : Rangpur) {
                        list.add(cities);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(ChefRegistration.this, android.R.layout.simple_spinner_item, list);
                    Cityspin.setAdapter(arrayAdapter);
                } else if (statee.equals("Mymensingh")) {
                    ArrayList<String> list = new ArrayList<>();
                    for (String cities : Mymensingh) {
                        list.add(cities);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(ChefRegistration.this, android.R.layout.simple_spinner_item, list);
                    Cityspin.setAdapter(arrayAdapter);
                }
            }

        });

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getInstance().getReference("Chef");
        FAuth = FirebaseAuth.getInstance();
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fname = Fname.getEditText().getText().toString().trim();
                lname = Lname.getEditText().getText().toString().trim();
                emailid = Email.getEditText().getText().toString().trim();
                mobile = mobileno.getEditText().getText().toString().trim();
                password = Pass.getEditText().getText().toString().trim();
                confpassword = cpass.getEditText().getText().toString().trim();
                house = houseno.getEditText().getText().toString().trim();
                Area = area.getEditText().getText().toString().trim();
                Pincode = pincode.getEditText().getText().toString().trim();
                cityy = Cityspin.getSelectedItem().toString().trim();
            }
        });

        if(isValid())
        {
            //WorkWillStartFromHereGoodNight
        }


    }

    String emailpattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    public boolean isValid() {
        Email.setErrorEnabled(false);
        Email.setError("");
        Fname.setErrorEnabled(false);
        Fname.setError("");
        Lname.setErrorEnabled(false);
        Lname.setError("");
        Pass.setErrorEnabled(false);
        Pass.setError("");
        mobileno.setErrorEnabled(false);
        mobileno.setError("");
        cpass.setErrorEnabled(false);
        cpass.setError("");
        area.setErrorEnabled(false);
        area.setError("");
        houseno.setErrorEnabled(false);
        houseno.setError("");
        pincode.setErrorEnabled(false);
        pincode.setError("");

        boolean isValidname=false,isValidemail=false,isValidpassword=false,isValidconfpassword=false,isvalidmobileno=false,isvalidarea=false,isvalidhouseno=false,isvalidpincode=false;
        if(TextUtils.isEmpty(fname))
        {
            Fname.setErrorEnabled(true);
            Fname.setError("Enter First Name");
        }
        else
        {
            isValidname=true;
        }
        if(TextUtils.isEmpty(lname))
        {
            Lname.setErrorEnabled(true);
            Lname.setError("Enter Last Name");
        }
        else
        {
            isValidname=true;
        }
        if(TextUtils.isEmpty(emailid))
        {
            Email.setErrorEnabled(true);
            Email.setError("Enter Email Id");
        }
        else
        {
            if(emailid.matches(emailpattern))
            {
                isValidemail = true;
            }
            else
            {
                Email.setErrorEnabled(true);
                Email.setError("Invalid Email Id");
            }
        }
        if(TextUtils.isEmpty(password))
        {
            Pass.setErrorEnabled(true);
            Pass.setError("Enter Password");
        }
        else
        {
            if(password.length()<8)
            {
                Pass.setErrorEnabled(true);
                Pass.setError("Password Must Be 8 Character");
            }
            else
            {
                isValidpassword=true;
            }

        }
        if(TextUtils.isEmpty(confpassword))
        {
            cpass.setErrorEnabled(true);
            cpass.setError("Enter Confirm Password");
        }
        else
        {
            if(!password.equals(confpassword))
            {
                cpass.setErrorEnabled(true);
                cpass.setError("Password Does Not Match");
            }
            else
            {
                isValidconfpassword=true;
            }
        }
        if(TextUtils.isEmpty(mobile))
        {
            mobileno.setErrorEnabled(true);
            mobileno.setError("Enter Mobile Number");
        }
        else
        {
            if(mobile.length()<10)
            {
                mobileno.setErrorEnabled(true);
                mobileno.setError("Invalid Mobile Number");
            }
            else
            {
                isvalidmobileno=true;
            }
        }
        if(TextUtils.isEmpty(Area))
        {
            area.setErrorEnabled(true);
            area.setError("Enter Area");
        }
        else
        {
            isvalidarea=true;
        }
        if(TextUtils.isEmpty(house))
        {
            houseno.setErrorEnabled(true);
            houseno.setError("Enter House No");
        }
        else
        {
            isvalidhouseno=true;
        }
        if(TextUtils.isEmpty(Pincode))
        {
            pincode.setErrorEnabled(true);
            pincode.setError("Enter Pincode");
        }
        else
        {
            isvalidpincode=true;
        }
        if(isValidname&&isValidemail&&isValidpassword&&isValidconfpassword&&isvalidmobileno&&isvalidarea&&isvalidhouseno&&isvalidpincode)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}