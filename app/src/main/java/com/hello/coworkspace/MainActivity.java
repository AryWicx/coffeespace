package com.hello.coworkspace;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;

import com.hello.coworkspace.Adapter.SpaceAdapter;
import com.hello.coworkspace.Model.GetSpace;
import com.hello.coworkspace.Model.Space;
import com.hello.coworkspace.Rest.ApiClient;
import com.hello.coworkspace.Rest.ApiInterface;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.w3c.dom.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ApiInterface mApiInterface;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static MainActivity ma;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        ma=this;
        refresh();

    }

    private void refresh() {
        Call<GetSpace> kontakCall = mApiInterface.GetSpace();
        kontakCall.enqueue(new Callback<GetSpace>() {
            @Override
            public void onResponse(Call<GetSpace> call, Response<GetSpace>
                    response) {
                List<Space> SpaceList = response.body().getListSpace();
                Log.d("Retrofit Get", "Jumlah data Kontak: " +
                        String.valueOf(SpaceList.size()));
                mAdapter = new SpaceAdapter(SpaceList);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<GetSpace> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }

        });
    }

}
