package jp.suntech.s21002.myhellocustomer;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Buttonオブジェクト取得
        Button btClick = findViewById(R.id.btClick);
        // リスナクラスのインスタンス生成
        HelloListener listener = new HelloListener();
        // 表示ボタンにリスナを設定
        btClick.setOnClickListener(listener);

        // 名前クリアボタンのButtonオブジェクト取得
        Button btNameClear = findViewById(R.id.btNameClear);
        // リスナ設定
        btNameClear.setOnClickListener(listener);

        // 住所クリアボタンのButtonオブジェクト取得
        Button btAddressClear = findViewById(R.id.btAddressClear);
        // リスナ設定
        btAddressClear.setOnClickListener(listener);
    }

    // リスナクラス<-イベントの監視
    private class HelloListener implements View.OnClickListener{

        // イベントハンドラ<-イベント発生時の処理
        @Override
        public void onClick(View view) {
            EditText inputName = findViewById(R.id.etName);
            EditText inputAddress = findViewById(R.id.etAddress);
            TextView output = findViewById(R.id.tvOutput);

            int id = view.getId();
            switch (id){
                case R.id.btClick:
                    String inputStrName = inputName.getText().toString();
                    String inputStrAddress = inputAddress.getText().toString();
                    output.setText(inputStrAddress + "にお住まいの" + inputStrName + "さん、こんにちは！");
                    break;
                case R.id.btNameClear:
                    inputName.setText("");
                    output.setText("");
                    break;
                case R.id.btAddressClear:
                    inputAddress.setText("");
                    output.setText("");
                    break;
            }
        }
    }
}