package com.example.thick124_ltdd03_v2l;



import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button buttonViewProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonViewProfile = findViewById(R.id.buttonViewProfile);
        buttonViewProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Khi nút được nhấn, chuyển sang giao diện MemberActivity
                Intent intent = new Intent(MainActivity.this, MemberActivity.class);
                startActivity(intent);
            }
        });
    }
}
