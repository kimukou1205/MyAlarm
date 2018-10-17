package ararm3.jackn.opengl.com.myalarm4;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sub);

        Button returnButton = findViewById(R.id.return_button);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // 低ボタンが押された時
        Button rowButton = findViewById(R.id.row_button);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences data = getSharedPreferences("DataSave", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = data.edit();
                editor.putInt("LevelSave", 1); // 1:低、2:中、3:高の３段階があるとする。
                editor.apply();
            }
        });

        // 中ボタンが押された時
        Button normalButton = findViewById(R.id.normal_button);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences data = getSharedPreferences("DataSave", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = data.edit();
                editor.putInt("LevelSave", 2); // 1:低、2:中、3:高の３段階があるとする。
                editor.apply();
            }
        });

        // 高ボタンが押された時
        Button highButton = findViewById(R.id.high_button);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences data = getSharedPreferences("DataSave", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = data.edit();
                editor.putInt("LevelSave", 3); // 1:低、2:中、3:高の３段階があるとする。
                editor.apply();
            }
        });

    }
}