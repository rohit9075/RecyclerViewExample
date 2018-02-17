package rohit.com.recyclerviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import rohit.com.recyclerviewexample.Listner.*;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Item> itemList = new ArrayList<Item>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Object of the ItemArrayAdapter class
        ItemArrayAdapter itemArrayAdapter = new ItemArrayAdapter(R.layout.list_item, itemList);

        recyclerView = (RecyclerView) findViewById(R.id.item_list);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(itemArrayAdapter);
        recyclerView.addOnItemTouchListener(new RecyclerViewTouchListener(getApplicationContext(), recyclerView, new RecyclerOnClickListner() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(getApplicationContext(), itemList.get(position).getName() + " is clicked!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

                Toast.makeText(getApplicationContext(), itemList.get(position).getName() + " is clicked!", Toast.LENGTH_SHORT).show();

            }
        }));

      AddItem();





    }



    public void AddItem(){

        itemList.add(new Item("Rohit kumar","saran","bihar"));
        itemList.add(new Item("Saurabh","Mumbai","Mahrashtra"));
        itemList.add(new Item("Amit","Patna","Bihar"));
        itemList.add(new Item("Vishnu","Gopalgang","Bihar"));
        itemList.add(new Item("Shyam","Saran","Bihar"));
        itemList.add(new Item("Sumit ","Gaya","Biahr"));
        itemList.add(new Item("Shekhar ","Bhopal","M.p"));

    }

}
