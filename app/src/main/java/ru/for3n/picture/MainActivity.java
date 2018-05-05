package ru.for3n.picture;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GalleryAdapter mAdapter;
    RecyclerView mRecyclerView;

    ArrayList<ImageModel> data = new ArrayList<>();

    public static String IMG[] = {

            "https://wmpics.pics/di-61SQ.jpg",
            "https://wmpics.pics/di-U73X25Y0.jpg",
            "https://wmpics.pics/di-YY24.jpg",
            "https://wmpics.pics/di-9V62.jpg",
            "https://wmpics.pics/di-T89Z.jpg",
            "https://wmpics.pics/di-SO5O.png",
            "https://wmpics.pics/di-VL9D.jpg",
            "https://wmpics.pics/di-WFFB.jpg",
            "https://wmpics.pics/di-6BBY.jpg",
            "https://wmpics.pics/di-B4AY.jpg",
            "https://wmpics.pics/di-5IS4.jpg",
            "https://wmpics.pics/di-LOD6.jpg",
            "https://wmpics.pics/di-QKW6.jpg",
            "https://wmpics.pics/di-IIH1.jpg",
            "https://wmpics.pics/di-STRQ.jpg",
            "https://wmpics.pics/di-FWT5.jpg",
            "https://wmpics.pics/di-94TX.jpg",
            "https://wmpics.pics/di-CYT6.jpg",
            "https://wmpics.pics/di-Z0YJ.jpg",
            "https://wmpics.pics/di-P8ZK.jpg",
            "https://wmpics.pics/di-C0RO.jpg"

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 1; i < IMG.length; i++) {

            ImageModel imageModel = new ImageModel();
            imageModel.setName(i + " из " + "20");
            imageModel.setUrl(IMG[i]);
            data.add(imageModel);

        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mRecyclerView = (RecyclerView) findViewById(R.id.list);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        mRecyclerView.setHasFixedSize(true);


        mAdapter = new GalleryAdapter(MainActivity.this, data);
        mRecyclerView.setAdapter(mAdapter);

        // Заголовок нового изображения должен быть обновлён
        mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this,
                new RecyclerItemClickListener.OnItemClickListener() {

                    @Override
                    public void onItemClick(View view, int position) {

                        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                        intent.putParcelableArrayListExtra("data", data);
                        intent.putExtra("pos", position);
                        startActivity(intent);

                    }
                }));

    }

}