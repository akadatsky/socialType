package us.mahala.client.activities;

import android.os.Bundle;

import us.mahala.client.ActivityBase;
import us.mahala.client.R;
import us.mahala.client.utils.SocialType;

public class SocialItemActivity extends ActivityBase {

    private SocialType socialType;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setCurrentActivity(this);

        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.social_item_activity);

        socialType = (SocialType) getIntent().getSerializableExtra("type");
        setTitleText(socialType.getTitle());

        showSocial();
    }

    private void showSocial() {
        switch (socialType) {
            case FACEBOOK:
                break;
            case INSTAGRAM:
                break;
            case TWITTER:
                break;
            case VIMEO:
                break;
            case YOUTUBE:
                showYoutube();
                break;
        }
    }

    private void showYoutube() {
    }

}
