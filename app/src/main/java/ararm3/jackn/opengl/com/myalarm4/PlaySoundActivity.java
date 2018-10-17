package ararm3.jackn.opengl.com.myalarm4;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;
import java.util.logging.Level;

import orz.kassy.shakegesture.ShakeGestureManager;
import ararm3.jackn.opengl.com.myalarm4.util.PreferenceUtil;

public class PlaySoundActivity extends AppCompatActivity {
    Button stop;
    int randnum;
    TextView textView;
    TextView textView3;
    EditText editText;
    int count = 0;

     @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getAction()==KeyEvent.ACTION_DOWN) {
            switch (event.getKeyCode()) {
                case KeyEvent.KEYCODE_BACK:
                    // ダイアログ表示など特定の処理を行いたい場合はここに記述
                    // 親クラスのdispatchKeyEvent()を呼び出さずにtrueを返す
                    return true;
            }
        }
        return super.dispatchKeyEvent(event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_sound);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD |
                WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED |
                WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON |
                WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        Button sendButton = findViewById(R.id.nextButton2);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), SecondActivity.class);
                startActivity(intent);
            }
        });

        SharedPreferences data = getSharedPreferences("DataSave", Context.MODE_PRIVATE);
        final int Level = data.getInt("LevelSave", 1); // 第２引数は値がなかったときのデフォルト

        ShakeGestureManager mGestureManager = new ShakeGestureManager(this, mListener);
        mGestureManager.startSensing();

        startService(new Intent(this, PlaySoundService.class));
        //Random rand = new Random();
       // randnum = rand.nextInt(10);
        randnum = Level;
        textView3 = findViewById(R.id.textView3);
        textView = findViewById(R.id.textView2);
        editText=findViewById(R.id.editText);
      /*  if(randnum==0){
            textView.setText("１１×１１");
        }else if(randnum==1){
            textView.setText("９×８＋６");
        }else if(randnum==2){
            textView.setText("１２×１２");
        }else if(randnum==3){
            textView.setText("６０÷３×５");
        }else if(randnum==4){
            textView.setText("１２８÷４×２");
        }else if(randnum==5){
            textView.setText("１＋２＋３＋４＋５＋６＋７＋８＋９");
        }else if(randnum==6){
            textView.setText("５６×２＋２３");
        }else if(randnum==7){
            textView.setText("９９×(８＋２８７－２２)×０");
        }else if(randnum==8){
            textView.setText("１１×１１÷１２１");
        }else if(randnum==9){
            textView.setText("５０×３÷２");
        }*/
        if(Level == 1){
            // 低の問題
            if(randnum==0){
                textView.setText("11×11");
            }else if(randnum==1){
                textView.setText("22×22");
            }
            // 問題省略
        }

        if(Level == 2){
            // 中の問題
            if(randnum==0){
                textView.setText("111×111");
            }else if(randnum==1){
                textView.setText("222×222");
            }
            // 問題省略
        }

        if(Level == 3){
            // 高の問題
            if(randnum==0){
                textView.setText("1111×1111");
            }else if(randnum==1){
                textView.setText("2222×2222");
            }
            // 問題省略
        }
        final Intent intent = new Intent(this, MainActivity.class);

        if(count==10){
            stopsound();
        }
        stop = (Button) findViewById(R.id.stop);
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* if(randnum==0&&editText.getText().toString().equals("121")){
                    stopsound();
                    textView3.setText("正解!!");
                    finish();
                }else if(randnum==1&&editText.getText().toString().equals("78")){
                    stopsound();
                    textView3.setText("正解!!");
                    finish();
                }else if(randnum==2&&editText.getText().toString().equals("144")){
                    stopsound();
                    textView3.setText("正解!!");
                    finish();
                }else if(randnum==3&&editText.getText().toString().equals("100")){
                    stopsound();
                    textView3.setText("正解!!");
                    finish();
                }else if(randnum==4&&editText.getText().toString().equals("64")){
                    stopsound();
                    textView3.setText("正解!!");
                    finish();
                }else if(randnum==5&&editText.getText().toString().equals("45")){
                    stopsound();
                    textView3.setText("正解!!");
                    finish();
                }else if(randnum==6&&editText.getText().toString().equals("135")){
                    stopsound();
                    textView3.setText("正解!!");
                    finish();
                }else if(randnum==7&&editText.getText().toString().equals("0")){
                    stopsound();
                    textView3.setText("正解!!");
                    finish();
                }else if(randnum==8&&editText.getText().toString().equals("1")){
                    stopsound();
                    textView3.setText("正解!!");
                    finish();
                }else if(randnum==9&&editText.getText().toString().equals("75")){
                    stopsound();
                    textView3.setText("正解!!");
                    finish();

                }*/
                if (Level == 1) {
                    // 低の問題
                    if (randnum == 0 && editText.getText().toString().equals("121")) {
                        stopsound();
                        textView3.setText("正解!!");
                        finish();
                    } else if (randnum == 1 && editText.getText().toString().equals("484")) {
                        stopsound();
                        textView3.setText("正解!!");
                        finish();
                    }
                }
            }
        });
    }

    public void stopsound(){
        stopService(new Intent(PlaySoundActivity.this, PlaySoundService.class));
        PreferenceUtil pref = new PreferenceUtil(PlaySoundActivity.this);
        pref.delete(ararm3.jackn.opengl.com.myalarm4.MainActivity.ALARM_TIME);
    }

    private ShakeGestureManager.GestureListener mListener = new ShakeGestureManager.GestureListener() {
        @Override
        public void onGestureDetected(int gestureType, int gestureCount) {
            // ジェスチャーを認識したらここが呼ばれる
            System.out.println("認識");
            count++;
        }
        public void checkAnswer(View view) {
            // answer?
            Button clickedButton = (Button) view;
            String clickedAnswer = clickedButton.getText().toString();
        }
            @Override
        public void onMessage(String s) {

        }
    };


}
