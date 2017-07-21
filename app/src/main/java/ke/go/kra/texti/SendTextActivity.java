package ke.go.kra.texti;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by ROOM3 on 7/20/2017.
 */

public class SendTextActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_text);

        Button btn_send_text = (Button) findViewById(R.id.btnSendText);
        final EditText text_message = (EditText) findViewById(R.id.editMessageText);

        btn_send_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SmsManager.getDefault().sendTextMessage("0724880775", null, text_message.getText().toString(), null, null);
            }
        });


    }
}
