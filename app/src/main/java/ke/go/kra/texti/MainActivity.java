package ke.go.kra.texti;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private DBHelper dbHelper = new DBHelper(MainActivity.this);
    private ArrayList<Group> groups_list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final ListView lv = (ListView) findViewById(R.id.main_list_view);
        groups_list = dbHelper.getAllContacts();

        final ArrayAdapter<Group> groups_adapter = new ArrayAdapter<Group>(this, android.R.layout.simple_list_item_1, groups_list);
        lv.setAdapter(groups_adapter);




        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_add_group);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, NewGroupActivity.class));
            }
        });

//        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//
//                startActivity(new Intent(MainActivity.this,AddContactToGroupActivity.class));
////                //Delete the Item Long pressed
////                dbHelper.deleteContact(groups_list.get(position).getId());
////                //Toast.makeText(MainActivity.this, "" + groups_list.get(position).getId(), Toast.LENGTH_LONG).show();
////                groups_adapter.notifyDataSetChanged();
////
////                //Refresh the array list
////                groups_list = dbHelper.getAllContacts();
////                ArrayAdapter<Group> planet_adapter = new ArrayAdapter<Group>(MainActivity.this, android.R.layout.simple_list_item_1, groups_list);
////                lv.setAdapter(planet_adapter);
//                return false;
//            }
//        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //Intent intent_new_message =
                //intent_new_message.putExtra("name",name);


                startActivity(new Intent(MainActivity.this, SendSmsActivity.class));
            }
        });


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
