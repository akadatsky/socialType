package us.mahala.client.utils;

import us.mahala.client.R;

public enum SocialType {

    FACEBOOK(R.drawable.icon_facebook, R.string.icon_facebook),
    INSTAGRAM(R.drawable.icon_instagram, R.string.icon_instagram),
    TWITTER(R.drawable.icon_twitter, R.string.icon_twitter),
    VIMEO(R.drawable.icon_vimeo, R.string.icon_vimeo),
    YOUTUBE(R.drawable.icon_youtube, R.string.icon_youtube);

    private int icon;
    private int title;

    SocialType(int icon, int title) {
        this.icon = icon;
        this.title = title;
    }

    public int getIcon() {
        return icon;
    }

    public int getTitle() {
        return title;
    }

}
