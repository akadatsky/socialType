package us.mahala.client.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import us.mahala.client.ActivityBase;
import us.mahala.client.R;
import us.mahala.client.models.Merchant;
import us.mahala.client.utils.App;
import us.mahala.client.utils.SocialType;

public class SocialActivity extends ActivityBase {

    private LinearLayout socialContainer;
    private Merchant merchant;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setCurrentActivity(this);

        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.social_activity);

        setTitleText(R.string.menu_social);

        merchant = App.getAppState().getCurrentMerchant();

        socialContainer = (LinearLayout) findViewById(R.id.socialContainer);
        initSocialContainer();
    }

    private void initSocialContainer() {
        for (SocialType socialType : SocialType.values()) {
            switch (socialType) {
                case FACEBOOK:
                    if (TextUtils.isEmpty(merchant.facebookUrl)) {
                        continue;
                    }
                    break;
                case INSTAGRAM:
                    if (TextUtils.isEmpty(merchant.PinterestUrl)) {
                        continue;
                    }
                    break;
                case TWITTER:
                    if (TextUtils.isEmpty(merchant.TwitterUrl)) {
                        continue;
                    }
                    break;
                case VIMEO:
                    if (TextUtils.isEmpty(merchant.VimeoUrl)) {
                        continue;
                    }
                    break;
                case YOUTUBE:
                    if (TextUtils.isEmpty(merchant.YoutubeUrl)) {
                        continue;
                    }
                    break;
            }
            addSocialIcon(socialContainer, socialType);
        }
    }

    private void addSocialIcon(LinearLayout socialContainer, final SocialType socialType) {
        LayoutInflater inflater = LayoutInflater.from(getApplicationContext());
        View itemView = inflater.inflate(R.layout.item_social, socialContainer, false);

        ImageView socialIcon = (ImageView) itemView.findViewById(R.id.socialIcon);
        socialIcon.setImageResource(socialType.getIcon());

        TextView socialIconTitle = (TextView) itemView.findViewById(R.id.socialIconTitle);
        socialIconTitle.setText(socialType.getTitle());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SocialActivity.this, SocialItemActivity.class);
                intent.putExtra("type", socialType);
                startActivityWithOverriding(intent);
            }
        });

        socialContainer.addView(itemView);
    }

}
