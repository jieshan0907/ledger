package com.example.user.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class SumActivity extends AppCompatActivity {
    private UserDao userDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sum);

        userDao = new UserDao(this);
        ListView listView = (ListView) findViewById(R.id.listView);
        List<User> users = userDao.getAll();
    }
    class MyAdapter extends BaseAdapter{
        public MyAdapter(){
            userDao.getAll();
        }
        List<User> users = userDao.getAll();
        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder viewHolder;

            if (convertView == null){
                viewHolder = new ViewHolder();
                LayoutInflater inflater = LayoutInflater.from(parent.getContext());
                convertView = inflater.inflate(R.layout.activity_sum, parent, false);
                viewHolder.name_id = (TextView) convertView.findViewById(R.id.name_id);
                viewHolder.day_id = (TextView) convertView.findViewById(R.id.day_id);
                viewHolder.amout_id = (TextView) convertView.findViewById(R.id.amout_id);
                viewHolder.note_id = (TextView) convertView.findViewById(R.id.note_id);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }



            return convertView;
        }
        class ViewHolder {
            TextView name_id;
            TextView day_id;
            TextView amout_id;
            TextView note_id;
        }
    }

}
