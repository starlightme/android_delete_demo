package com.example.jimmy66.classtest;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Jimmy66 on 2016/12/8.
 */

public class TestAdapter extends BaseAdapter {

    private Context mContext;
    private List<DataUnion> mdata;



    private TestAdapter mAdapter = this;  //居然有用!激动


    public TestAdapter(Context mContext, List<DataUnion> mdata) {
        this.mContext = mContext;
        this.mdata = mdata;
    }


    @Override
    public int getCount() {
        return mdata.size();
    }

    @Override
    public DataUnion getItem(int position) {
        return mdata.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    class ViewHolder {
        TextView textTitle;

        Button buttonDelete;

        public ViewHolder(View view) {
            textTitle = (TextView) view.findViewById(R.id.textview);

            buttonDelete = (Button) view.findViewById(R.id.button1);
            view.setTag(this);
        }
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.list_template, null);
            new ViewHolder(convertView);
        }
        final ViewHolder holder = (ViewHolder) convertView.getTag();  //这两句不是很懂
        DataUnion small_union = mdata.get(position);
        holder.textTitle.setText(small_union.row1);
        holder.buttonDelete.setText(small_union.itag);


        //回到这里做文章
        holder.buttonDelete.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() ==  MotionEvent.ACTION_DOWN) {
                    System.out.println("位置是" + position);
                    Toast.makeText(mContext, "位置是" + position, Toast.LENGTH_SHORT).show();
                    mdata.remove(position);
                    mAdapter.notifyDataSetChanged();
//                holder.textTitle.setText("CHanged!!!!");
                }
                return false;
            }
        });


        return  convertView;

    }

}
