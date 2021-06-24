package com.zerokaraapp.sampleactivity3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        //レイアウトからボタンを取得
        Button button2 = findViewById(R.id.bt2);

        //ボタンクリックのリスナインスタンスを取得
        ButtonClickListener2 listener2 = new ButtonClickListener2();

        //ボタンにリスナを設定
        button2.setOnClickListener(listener2);
    }

    //ボタンクリック時のリスナクラスを設定
    private class ButtonClickListener2 implements View.OnClickListener{

        //クリックされたときの動作を定義するメソッドを定義
        @Override
        public void onClick(View view){

            //画面1からインテントを取得
            Intent intent2 = getIntent();

            //レイアウトからEditTextのビューを取得
            EditText editText = findViewById(R.id.et);

            //EditTextのビューのテキストを取得
            String text = editText.getText().toString();

            //インテントにテキストを代入
            intent2.putExtra("input",text);

            //画面1にインテントを返送 RESULT_OKは返送の際、データが入っていることを示す定数
            setResult(RESULT_OK,intent2);

            //画面移動
            finish();
        }
    }
}