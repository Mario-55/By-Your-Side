package com.example.graduationproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import java.util.Vector;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Youtube extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    RecyclerView recyclerView;
    Vector<Phonetics> youtubeVideos = new Vector<Phonetics>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);

        bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager( new LinearLayoutManager(this));

        youtubeVideos.add( new Phonetics("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/FSwZ3Tf_lHY\" frameborder=\"0\" allowfullscreen></iframe>") );
        youtubeVideos.add( new Phonetics("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/Yxy8xPcDJa0\" frameborder=\"0\" allowfullscreen></iframe>") );
        youtubeVideos.add( new Phonetics("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/QpQoutG9hBE\" frameborder=\"0\" allowfullscreen></iframe>") );
        youtubeVideos.add( new Phonetics("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/LqQZ_snHj7Q\" frameborder=\"0\" allowfullscreen></iframe>") );
        youtubeVideos.add( new Phonetics("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/qXGc1aUfPrM\" frameborder=\"0\" allowfullscreen></iframe>") );
        youtubeVideos.add( new Phonetics("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/e69rQzj09fU\" frameborder=\"0\" allowfullscreen></iframe>") );
        youtubeVideos.add( new Phonetics("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/Zyxgd5qz5r8\" frameborder=\"0\" allowfullscreen></iframe>") );
        youtubeVideos.add( new Phonetics("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/gdGWk_neAac\" frameborder=\"0\" allowfullscreen></iframe>") );
        youtubeVideos.add( new Phonetics("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/1Q05C22mmJM\" frameborder=\"0\" allowfullscreen></iframe>") );
        youtubeVideos.add( new Phonetics("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/uPcSe_PEu08\" frameborder=\"0\" allowfullscreen></iframe>") );
        youtubeVideos.add( new Phonetics("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/rWc5-yeOUNU\" frameborder=\"0\" allowfullscreen></iframe>") );
        youtubeVideos.add( new Phonetics("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/mvuZbOufDnc\" frameborder=\"0\" allowfullscreen></iframe>") );
        youtubeVideos.add( new Phonetics("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/SsRnK2aSiYM\" frameborder=\"0\" allowfullscreen></iframe>") );
        youtubeVideos.add( new Phonetics("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/-Ow0h01P4nE\" frameborder=\"0\" allowfullscreen></iframe>") );
        youtubeVideos.add( new Phonetics("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/zv8Zzs5CEAI\" frameborder=\"0\" allowfullscreen></iframe>") );
        youtubeVideos.add( new Phonetics("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/qrjVXerkyGA\" frameborder=\"0\" allowfullscreen></iframe>") );
        youtubeVideos.add( new Phonetics("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/Tn9NG-zxBZ8\" frameborder=\"0\" allowfullscreen></iframe>") );
        youtubeVideos.add( new Phonetics("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/ufCJX461FNE\" frameborder=\"0\" allowfullscreen></iframe>") );
        youtubeVideos.add( new Phonetics("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/Q_A9c92d3P8\" frameborder=\"0\" allowfullscreen></iframe>") );
        youtubeVideos.add( new Phonetics("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/uMaD3itUf74\" frameborder=\"0\" allowfullscreen></iframe>") );
        youtubeVideos.add( new Phonetics("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/FAp1MWk0sUw\" frameborder=\"0\" allowfullscreen></iframe>") );
        youtubeVideos.add( new Phonetics("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/y23YX9AJZo0\" frameborder=\"0\" allowfullscreen></iframe>") );
        youtubeVideos.add( new Phonetics("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/NEhXGNIJ9dE\" frameborder=\"0\" allowfullscreen></iframe>") );
        youtubeVideos.add( new Phonetics("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/5URK7DXdLgU\" frameborder=\"0\" allowfullscreen></iframe>") );
        youtubeVideos.add( new Phonetics("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/rBW-1tn3yeA\" frameborder=\"0\" allowfullscreen></iframe>") );
        youtubeVideos.add( new Phonetics("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/c2qVQQocQj0\" frameborder=\"0\" allowfullscreen></iframe>") );

        VideoAdapter videoAdapter = new VideoAdapter(youtubeVideos);

        recyclerView.setAdapter(videoAdapter);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                    switch (menuItem.getItemId()){
                        case R.id.home:
                            startActivity(new Intent(Youtube.this, MainScreen.class));
                            finish();
                        break;
                    }
                    return false;
                }
            };
}