package kono.mobiuni.View;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import kono.mobiuni.MainMenu;
import kono.mobiuni.R;

public class LogInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        final LogInActivity that = this;
        File file = new File(getFilesDir(), "savedusr");
        if (file != null) {
            try {
                String savedInstance="";
                FileInputStream inputStream = openFileInput("savedusr");
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                StringBuffer stringBuffer = new StringBuffer();
                savedInstance = bufferedReader.readLine();
                String[] helper = savedInstance.split(":");
                if(validate(helper[0], helper[1]))
                {
                    Toast.makeText(this, "Succesful", Toast.LENGTH_SHORT).show();
                    Intent intentToMainMenu = new Intent(this, MainMenu.class);
                    startActivity(intentToMainMenu);
                }
                else
                    Toast.makeText(this, "UnSuccesfull", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        Button registrationButton = findViewById(R.id.Login_Register_button);

        registrationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentToReg = new Intent(that, RegistrationActivity.class);

                startActivity(intentToReg);
            }
        });

        Button logInButton = findViewById(R.id.Login_Login_button);
        logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText etUsername = findViewById(R.id.Login_UserName_text);
                String username = etUsername.getText().toString();
                EditText etRegister = findViewById(R.id.Login_Password_text);
                String password = etRegister.getText().toString();
                if (validate(username, password)) {
                    Toast.makeText(that, "Succesful", Toast.LENGTH_SHORT).show();
                    FileOutputStream outputStream;
                    String saveContent = etUsername.getText().toString() + ":" + etRegister.getText().toString();

                    try {
                        outputStream = openFileOutput("savedusr", Context.MODE_PRIVATE);
                        outputStream.write(saveContent.getBytes());
                        outputStream.close();
                        Toast.makeText(that, "Saved the username and the password", Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                    Intent intentToMainMenu = new Intent(that, MainMenu.class);
                    startActivity(intentToMainMenu);
                }

                Toast.makeText(that, "Error", Toast.LENGTH_SHORT);

            }
        });
    }

    private boolean validate(String usrname, String password) {
        if (usrname.equals("a") && password.equals("a"))
            return true;
        return false;
    }

}
