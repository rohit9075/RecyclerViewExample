package rohit.com.recyclerviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class UserDetailActivity extends AppCompatActivity {

    TextView textViewName;
    TextView textViewCity;
    TextView textViewState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);

        textViewName = (TextView)findViewById(R.id.textViewName);
        textViewCity = (TextView)findViewById(R.id.textViewCity);
        textViewState = (TextView)findViewById(R.id.textViewState);

        String name = getIntent().getStringExtra("Name");
        String city = getIntent().getStringExtra("City");
        String state = getIntent().getStringExtra("State");

        textViewName.setText(name);
        textViewCity.setText(city);
        textViewState.setText(state);


    }
}
