package com.example.adminjs.mamm;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.adminjs.mamm.adapter.MyAdapter;
import com.example.adminjs.mamm.bean.Bean;
import com.example.adminjs.mamm.presenter.MainPresenter;
import com.example.adminjs.mamm.view.MaView;

import java.util.List;

public class MainActivity extends Activity implements MaView{
    private RecyclerView xr;
    private MainPresenter presenter;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        xr = findViewById(R.id.xrecyclerview);
        presenter = new MainPresenter(this);
        presenter.get();
        LinearLayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        xr.setLayoutManager(manager);
        adapter = new MyAdapter(MainActivity.this);
        xr.setAdapter(adapter);
    }

    @Override
    public void success(Bean bean) {
        adapter.addData(bean);
       // Toast.makeText(MainActivity.this,bean.toString(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void failure() {

    }
}
