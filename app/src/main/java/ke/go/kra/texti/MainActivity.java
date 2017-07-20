package ke.go.kra.texti;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private DBHelper dbHelper = new DBHelper(MainActivity.this);
    private ArrayList<Group> group_list = new ArrayList<Group>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<Group> groups_list = new ArrayList<>();
        ListView lv = (ListView) findViewById(R.id.main_list_view);

        ArrayAdapter<Group> groups_adapter = new ArrayAdapter<Group>(this, android.R.layout.simple_list_item_1, groups_list);
        lv.setAdapter(groups_adapter);


//        Spinner spinner = (Spinner) findViewById(R.id.planet_spinner);
//// Create an ArrayAdapter using the string array and a default spinner layout
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
//                R.array.planets_array, android.R.layout.simple_spinner_item);
//// Specify the layout to use when the list of choices appears
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//// Apply the adapter to the spinner
//        spinner.setAdapter(adapter);
    }
}
