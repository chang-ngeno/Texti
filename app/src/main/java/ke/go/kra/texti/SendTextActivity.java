package ke.go.kra.texti;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.Manifest;

import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

public class SendTextActivity extends Activity {
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_text);


        Button btn_send_text = (Button) findViewById(R.id.btnSendText);
        final EditText text_message = (EditText) findViewById(R.id.editMessageText);

        btn_send_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = text_message.getText().toString();

                if (ContextCompat.checkSelfPermission(SendTextActivity.this,
                        Manifest.permission.SEND_SMS)
                        != PackageManager.PERMISSION_GRANTED) {
                    if (ActivityCompat.shouldShowRequestPermissionRationale(SendTextActivity.this,
                            Manifest.permission.SEND_SMS)) {
                        SmsManager.getDefault().sendTextMessage("0724880775", null, message, null, null);
                    } else {
                        ActivityCompat.requestPermissions(SendTextActivity.this,
                                new String[]{Manifest.permission.SEND_SMS},
                                MY_PERMISSIONS_REQUEST_SEND_SMS);
                    }
                }

            }

        });


    }
}
