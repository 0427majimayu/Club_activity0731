package android.lifeistech.com.club_activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Main_listAdapter extends ArrayAdapter<Practice> {
    List<Practice> items;

    public Main_listAdapter(@NonNull Context context, int resource, @NonNull List<Practice> objects) {
        super(context, resource, objects);
        this.items = objects;
    }

   @Override
   public int getCount(){
        return items.size();
   }


    @Override
    public Practice getItem(int position) {
        return items.get(position);
    }

    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        Practice item = getItem(position);
        ViewHolder viewHolder;

        if (convertView !=null){
            viewHolder=(ViewHolder) convertView.getTag();
        }else {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_layout,parent,false);

            viewHolder = new ViewHolder();
            viewHolder.dateView = (TextView)convertView.findViewById(R.id.dateView);
            viewHolder.timeView = (TextView)convertView.findViewById(R.id.timeView);
            viewHolder.licationView = (TextView)convertView.findViewById(R.id.licationView);

            convertView.setTag(viewHolder);

        }

        viewHolder.dateView.setText(item.getDate());
        viewHolder.timeView.setText(item.getTime());
        viewHolder.licationView.setText(item.getLocation());

        return convertView;

    }
    static class ViewHolder{
        TextView dateView;
        TextView timeView;
        TextView licationView;
    }

}
