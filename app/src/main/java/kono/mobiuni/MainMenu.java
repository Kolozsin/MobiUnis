package kono.mobiuni;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import kono.mobiuni.View.BottomActionFragment;

public class MainMenu extends AppCompatActivity implements BottomActionFragment.onButtonMenuPressedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main_menu);
    }

    @Override
    public void onButtonMenuPressed(int index) {
        switch (index) {
            case 0:
                Intent intent0 = new Intent(this, MainMenu.class);
                startActivity(intent0);
            case 1:
               break;
            case 2:
                Intent intent1 = new Intent(this, ProfileActivity.class);
                startActivity(intent1);
        }
    }
}


