package com.missionbit.spring2015introandroid;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.missionbit.spring2015introandroid.models.InstagramLocation;
import com.missionbit.spring2015introandroid.models.InstagramPhoto;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ActionBarActivity {

    List<InstagramPhoto> instagramPhotos;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        populateList();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        InstagramPhotoAdapter adapter = new InstagramPhotoAdapter(this, instagramPhotos);
        recyclerView.setAdapter(adapter);

    }

    void populateList() {

        instagramPhotos = new ArrayList<>();

        InstagramPhoto photo1 = new InstagramPhoto();
        photo1.url = "http://scontent.cdninstagram.com/hphotos-xfa1/t51.2885-15/e15/11055749_907792502606545_329055631_n.jpg";
        photo1.username = "Katniss";
        photo1.isLiked = true;

        photo1.location = new InstagramLocation();
        photo1.location.name = "District 13";

        instagramPhotos.add(photo1);

        InstagramPhoto photo2 = new InstagramPhoto();
        photo2.url = "http://scontent.cdninstagram.com/hphotos-xaf1/t51.2885-15/e15/10946344_900811159970461_793451471_n.jpg";
        photo2.username = "Dora The Explorer";

        photo2.location = new InstagramLocation();
        photo2.location.name = "California";

        instagramPhotos.add(photo2);

        InstagramPhoto photo3 = new InstagramPhoto();
        photo3.url = "http://scontent.cdninstagram.com/hphotos-xaf1/t51.2885-15/e15/11055442_803511649729240_1416050249_n.jpg";
        photo3.username = "mysoulandu";

        photo3.location = new InstagramLocation();
        photo3.location.name = "MoMa";

        instagramPhotos.add(photo3);

    }

}
