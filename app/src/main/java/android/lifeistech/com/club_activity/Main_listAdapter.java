package android.lifeistech.com.club_activity;

import android.content.Context;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

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
            viewHolder.imageView  = (ImageView)convertView.findViewById(R.id.imageView);

            convertView.setTag(viewHolder);

        }

        String date = item.getDate();
        if (date.length() > 1) {
          date = date.substring(7);
        }
//        if (date.length() > 1) {
//            if (date.substring(6, 8).equals("0")){
//                date = date.substring(7);
//            } else if (date.substring(6, 8).equals("1")){
//                date = date.substring(6);
//            }
//        }

        viewHolder.dateView.setText(date);
        viewHolder.timeView.setText(item.getTime());
        viewHolder.licationView.setText(item.getLocation());

        Log.d("tag", item.getLocation());
        if (item.getLocation().equals("小学校体育館")) {
            viewHolder.imageView.setImageResource(R.drawable.school);
        } else {
            viewHolder.imageView.setImageResource(R.drawable.high_school);
        }

        return convertView;

    }
    static class ViewHolder{
        TextView dateView;
        TextView timeView;
        TextView licationView;
        ImageView imageView;
    }

}
