package com.missionbit.spring2015introandroid;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.missionbit.spring2015introandroid.models.InstagramLocation;
import com.missionbit.spring2015introandroid.models.InstagramPhoto;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ActionBarActivity {


    ImageView ivPhoto;
    TextView tvName;
    TextView tvLocation;
    ImageView ivLike;

    List<InstagramPhoto> instagramPhotos;
    int ctr = 0;

    int lastIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivPhoto = (ImageView) findViewById(R.id.photo);
        tvName = (TextView) findViewById(R.id.username);
        tvLocation = (TextView) findViewById(R.id.location);
        ivLike = (ImageView) findViewById(R.id.like);

        populateList();

        displayInstagramPhoto();

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

        lastIndex = instagramPhotos.size() - 1;

    }

    void displayInstagramPhoto() {

        InstagramPhoto photo = instagramPhotos.get(ctr);
        Picasso.with(this).load(photo.url).into(ivPhoto);

        tvName.setText(photo.username);
        tvLocation.setText(photo.location.name);

        setLiked();

    }

    void setLiked() {

        InstagramPhoto photo = instagramPhotos.get(ctr);

        if (photo.isLiked) {
            ivLike.setImageResource(R.mipmap.liked);
        }
        else {
            ivLike.setImageResource(R.mipmap.not_liked);
        }
    }

    public void onPrevClick(View view) {

        if (ctr == 0) {
            ctr = lastIndex;
        }
        else {
            ctr--;
        }

        displayInstagramPhoto();
    }

    public void onNextClick(View view) {

        if (ctr == lastIndex) {
            ctr = 0;
        }
        else {
            ctr++;
        }

        displayInstagramPhoto();
    }

    public void onLikeClick(View view) {

        InstagramPhoto photo = instagramPhotos.get(ctr);
        photo.isLiked = !photo.isLiked;

        setLiked();


    }
}
