package com.example.graduationproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.hanks.passcodeview.PasscodeView;

public class Passcode extends AppCompatActivity {
    PasscodeView passcodeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passcode);

        passcodeView =findViewById(R.id.passcode_view);
        passcodeView.setPasscodeLength(4)
                .setLocalPasscode("7331")
                .setListener(new PasscodeView.PasscodeViewListener() {
                    @Override
                    public void onFail() {
                        Toast.makeText(getApplicationContext(),"Passcode is Wrong", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onSuccess(String number) {
                        Intent intent=new Intent(Passcode.this,Colors.class);
                        startActivity(intent);
                        finish();
                    }
                });
    }
}