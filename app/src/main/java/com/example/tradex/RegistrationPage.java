package com.example.tradex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.poovam.pinedittextfield.PinField;
import java.util.Locale;

public class RegistrationPage extends AppCompatActivity {

    TextView textView;
    private static final long TIMER_DURATION = 30000L;
    private static final long TIMER_INTERVAL = 1000L;
    public SharedPreferences sharedPreferences;

    private CountDownTimer mCountDownTimer;

    FirebaseAuth mAuth;

    String verificationId,mobilenumber;
    private long mTimeRemaining;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_page);
        mAuth = FirebaseAuth.getInstance();
        textView = (TextView)findViewById(R.id.textView); // Define in xml layout.
        verificationId = getIntent().getStringExtra("token");
        mobilenumber = getIntent().getStringExtra("phone");
        mCountDownTimer = new CountDownTimer(TIMER_DURATION, TIMER_INTERVAL) {

            @Override
            public void onTick(long millisUntilFinished) {
                String  ss=(String.format(Locale.getDefault(), "OTP resends in %d seconds", millisUntilFinished / 1000L));
                SpannableString spannableString=new SpannableString(ss);
                ForegroundColorSpan foregroundColorSpan=new ForegroundColorSpan(Color.GREEN);
                spannableString.setSpan(foregroundColorSpan,15,17, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                textView.setText(spannableString);
                mTimeRemaining = millisUntilFinished;
            }

            @Override
            public void onFinish() {
                String text="Done.";
                SpannableString last=new SpannableString(text);
                ForegroundColorSpan ff=new ForegroundColorSpan(Color.BLACK);
                last.setSpan(ff,0,5,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                textView.setText(last);
            }
        }.start();
        PinField circlePinField=findViewById(R.id.circleField);
        circlePinField.setOnTextCompleteListener(new PinField.OnTextCompleteListener() {
            @Override
            public boolean onTextComplete (String enteredText) {
                checkOTP(enteredText);

                return false;
            }
        });
    }
    public void checkOTP(String code) {

        if(verificationId != null) {
            PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId, code);
            mAuth.signInWithCredential(credential)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {

                                //FirebaseUser user = task.getResult().getUser();
                                sharedPreferences= getSharedPreferences("PREFERENCE", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor=sharedPreferences.edit();
                                editor.putString("FirstTimeInstall","yes");
                                editor.putString("number",mobilenumber);
                                editor.apply();
                                Toast.makeText(RegistrationPage.this,mobilenumber, Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(RegistrationPage.this,Home.class);
                                startActivity(intent);
                                finish();
                            } else {

                                if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                    Toast.makeText(RegistrationPage.this, "Verification Entered is wrong !", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    });
        }
    }
}
