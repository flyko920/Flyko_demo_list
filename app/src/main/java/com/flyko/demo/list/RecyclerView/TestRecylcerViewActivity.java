package com.flyko.demo.list.RecyclerView;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import com.flyko.demo.list.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试 recylcerview 的 简单使用的 activity类
 * Created by flykozhang on 16-1-29.
 */
public class TestRecylcerViewActivity  extends AppCompatActivity{
    private RecyclerViewAdapter recyclerViewAdapter;
    private List<String> datas;
    private RecyclerView recyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recylcerview);
        initdate();
        initView();
    }

    private void initdate() {
        datas = new ArrayList<String>();
        for (int i = 'A'; i < 'z'; i++) {
            datas.add((char) i + "");
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id) {
            //Gridview
            case R.id.action_Gridview:
                GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 4, GridLayoutManager.VERTICAL, false);
                recyclerview.setLayoutManager(gridLayoutManager);
                break;
            case R.id.action_Listview:
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
                recyclerview.setLayoutManager(linearLayoutManager);
                break;
            case R.id.action_hor_GridView:
                GridLayoutManager hor_gridLayoutManager = new GridLayoutManager(this, 4, GridLayoutManager.HORIZONTAL, false);
                recyclerview.setLayoutManager(hor_gridLayoutManager);
                break;
            case R.id.action_pubu:
                break;
            case R.id.action_add:
                recyclerViewAdapter.add(1);
                break;
            case R.id.action_delete:
                recyclerViewAdapter.delete(1);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void initView() {
        recyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(TestRecylcerViewActivity.this, LinearLayoutManager.VERTICAL, false);
        recyclerview.setLayoutManager(layoutManager);

        recyclerview.setItemAnimator(new DefaultItemAnimator());
        recyclerViewAdapter = new RecyclerViewAdapter(datas, this);
        recyclerview.setAdapter(recyclerViewAdapter);
        recyclerViewAdapter.setOnItemClickListener(new RecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int Position) {
                Toast.makeText(TestRecylcerViewActivity.this, "itemClick" + Position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int Position) {
                Toast.makeText(TestRecylcerViewActivity.this, "ItemLongClick" + Position, Toast.LENGTH_SHORT).show();
            }
        });
    }



}
