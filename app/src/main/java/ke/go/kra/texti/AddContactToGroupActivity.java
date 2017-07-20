package ke.go.kra.texti;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SimpleCursorAdapter;

import java.util.ArrayList;


public class AddContactToGroupActivity extends Activity {

    private ArrayList<String> names_list = new ArrayList<>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact_to_group);


    }
}

