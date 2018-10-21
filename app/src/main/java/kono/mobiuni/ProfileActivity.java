package kono.mobiuni;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.FileOutputStream;

import kono.mobiuni.View.BottomActionFragment;
import kono.mobiuni.View.LogInActivity;

public class ProfileActivity extends AppCompatActivity implements BottomActionFragment.onButtonMenuPressedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Button btnlogout = findViewById(R.id.Profile_Logout_button);
        final ProfileActivity that = this;
        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FileOutputStream outputStream;
                String saveContent = "";

                try {
                    outputStream = openFileOutput("savedusr", Context.MODE_PRIVATE);
                    outputStream.write(saveContent.getBytes());
                    outputStream.close();
                    Toast.makeText(that, R.string.Message_LogoutSuccesfull, Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(getApplicationContext(), LogInActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onButtonMenuPressed(int index) {

        switch (index) {
            case 0:
                Intent intent0 = new Intent(this, MainMenu.class);
                startActivity(intent0);
            case 1:
                Intent intent1 = new Intent(this, MainMenu.class);
                startActivity(intent1);
            case 2:
                break;
        }
    }
}
