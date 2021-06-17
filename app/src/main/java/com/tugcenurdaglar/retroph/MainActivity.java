package com.tugcenurdaglar.retroph;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;

import com.tugcenurdaglar.retroph.adapter.Adapter;
import com.tugcenurdaglar.retroph.client.ApiClient;
import com.tugcenurdaglar.retroph.client.RestInterface;
import com.tugcenurdaglar.retroph.models.Info;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv;
    private Adapter adapter;

    RestInterface restInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.rv);

        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));

        restInterface = ApiClient.getClient().create(RestInterface.class);

        Call<List<Info>> call = restInterface.getInfo();

        call.enqueue(new Callback<List<Info>>() {
            @Override
            public void onResponse(Call<List<Info>> call, Response<List<Info>> response) {
                List<Info> infoList = response.body();

                for (int i = 0; i < infoList.size(); i++) {

                    System.out.println("" + infoList.get(i).postId + "\n");
                    System.out.println("" + infoList.get(i).id + "\n");
                    System.out.println("" + infoList.get(i).name + "\n");
                    System.out.println("" + infoList.get(i).email + "\n");
                    System.out.println("" + infoList.get(i).body + "\n");

                }
                adapter = new Adapter(MainActivity.this, infoList);
                rv.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Info>> call, Throwable t) {

            }
        });


    }
}