package ke.go.kra.texti;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class NewGroupActivity extends Activity {

    private DBHelper dbHelper = new DBHelper(NewGroupActivity.this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_group);
        final Button btn_create_group = (Button) findViewById(R.id.btnCreateGroup);
        final EditText new_group_name = (EditText) findViewById(R.id.editGroupName);

        btn_create_group.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String name = new_group_name.getText().toString().trim();
                if (name.length() != 0) {
                    dbHelper.insertContact(name);
                    Toast.makeText(NewGroupActivity.this, "Group Created", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(NewGroupActivity.this, MainActivity.class));
                    dbHelper.close();
                } else {
                    Toast.makeText(NewGroupActivity.this, "Name is empty", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
