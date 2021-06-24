package com.zerokaraapp.sampleactivity3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //画面間のキーワードとなるリクエストコードを定義
    static final int REQUEST_CODE =1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //レイアウトからボタンを取得
        Button button1 = findViewById(R.id.bt1);

        //ボタンクリックのリスナインスタンスを取得
        ButtonClickListener1 listener1 = new ButtonClickListener1();

        //ボタンにリスナを設定
        button1.setOnClickListener(listener1);
    }

    //ボタンクリック時のリスナクラスを設定
    private class ButtonClickListener1 implements View.OnClickListener{

        //クリックされたときの動作を定義するメソッドを定義
        @Override
        public void onClick(View view){

            //画面移動のためのインテントを取得
            Intent intent1 = new Intent(MainActivity.this,MainActivity2.class);

            //画面移動を指示
            startActivityForResult(intent1,REQUEST_CODE);
        }
    }

    //MainActivity2が終了と同時に呼び出されるonActivityResultをオーバーライドし、テキストビューの更新を指示を追加する。
    //呼び出したときのリクエストコード、返送時のリザルトコード、返送されたインテントを取得
    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent intent){
        //親クラスのコンストラクタの呼び出し
        super.onActivityResult(requestCode,resultCode,intent);

        //インテントからテキストを取得
        String text2 = intent.getStringExtra("input");

        //レイアウトからテキストビューを取得
        TextView textView = findViewById(R.id.tv);

        //テキストビューにテキストを設定
        textView.setText(text2);
    }
}