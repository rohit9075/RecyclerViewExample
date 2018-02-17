package rohit.com.recyclerviewexample;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by VIVEK on 10/15/2017.
 */

public class ItemArrayAdapter extends RecyclerView.Adapter<ItemArrayAdapter.ViewHolder> {

    private int listItemLayout;
    private ArrayList<Item> itemList;

    public ItemArrayAdapter(int listItemLayout, ArrayList<Item> itemList) {
        this.listItemLayout = listItemLayout;
        this.itemList = itemList;
    }

    @Override
    public ItemArrayAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(listItemLayout, parent, false);
//        ViewHolder myViewHolder = new ViewHolder(view);
//        return myViewHolder;

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemArrayAdapter.ViewHolder holder, int position) {

        TextView name = holder.name;
        name.setText(itemList.get(position).getName());
        TextView city = holder.city;
        city.setText(itemList.get(position).getCity());
        TextView state = holder.state;
        state.setText(itemList.get(position).getState());

    }

    @Override
    public int getItemCount() {
       return itemList == null ? 0 : itemList.size();

    }

    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView name;
        public TextView city;
        public TextView state;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            name = (TextView) itemView.findViewById(R.id.textView_name);
            city =(TextView)itemView.findViewById(R.id.textView_city);
            state = (TextView)itemView.findViewById(R.id.textView_state);
        }

        @Override
        public void onClick(View view) {
           // Log.d("onclick", "onClick " + getLayoutPosition() + " " + name.getText());

            TextView textViewName;
            TextView textViewCity;
            TextView textViewState;

            textViewName = (TextView)view.findViewById(R.id.textView_name);
            textViewCity = (TextView)view.findViewById(R.id.textView_city);
            textViewState = (TextView)view.findViewById(R.id.textView_state);

            Intent intent = new Intent (view.getContext(), UserDetailActivity.class);
            intent.putExtra("Name",textViewName.getText().toString());
            intent.putExtra("City",textViewCity.getText().toString());
            intent.putExtra("State",textViewState.getText().toString());

            view.getContext().startActivity(intent);
        }
    }
}





























