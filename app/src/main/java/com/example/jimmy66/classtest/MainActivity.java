package com.example.jimmy66.classtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {





    private int i = 0;
    private TestAdapter adapter;
    private List<DataUnion> mList;
    private int cnt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ListView list_view = (ListView) findViewById(R.id.list_view);
        mList = new ArrayList<>();  //很重要
        for (i=0;i<5;i++){
            DataUnion itemone = new DataUnion();
            itemone.itag = "Test" + i;
            itemone.row1 = "A" + i;
            mList.add(itemone);
        }


        adapter = new TestAdapter(this,mList);
        list_view.setAdapter(adapter);

        //新

//        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                //又忘记秀了
//                Toast.makeText(MainActivity.this,"Test",Toast.LENGTH_SHORT).show();
//            }
//        });



        //这种也不行,尤其是设置监听器
//        Button buttonitem = (Button) findViewById(R.id.button1);
//        buttonitem.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                Toast.makeText(MainActivity.this,"Test",Toast.LENGTH_SHORT).show();
//                System.out.println( cnt++ + "!!!");
//                return false;
//            }
//        });




        //好像这个对修改后的item无用了

//        list_view.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                Toast.makeText(MainActivity.this,"Test",Toast.LENGTH_SHORT).show();
//                System.out.println( cnt++ + "!!!");
//                return false;
//            }
//        });


    }



}




