// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RelativeLayout;

// Referenced classes of package com.amazon.device.ads:
//            IAdActivityAdapter, AdVideoPlayer

class VideoActionHandler
    implements IAdActivityAdapter
{

    private Activity activity;
    private RelativeLayout layout;
    private AdVideoPlayer player;

    VideoActionHandler()
    {
    }

    private void initPlayer(Bundle bundle)
    {
        Controller.PlayerProperties playerproperties = (Controller.PlayerProperties)bundle.getParcelable("player_properties");
        Controller.Dimensions dimensions = (Controller.Dimensions)bundle.getParcelable("player_dimensions");
        player = new AdVideoPlayer(activity);
        player.setPlayData(playerproperties, bundle.getString("url"));
        if (dimensions == null)
        {
            bundle = new android.widget.RelativeLayout.LayoutParams(-1, -1);
            bundle.addRule(13);
        } else
        {
            bundle = new android.widget.RelativeLayout.LayoutParams(dimensions.width, dimensions.height);
            bundle.topMargin = dimensions.y;
            bundle.leftMargin = dimensions.x;
        }
        player.setLayoutParams(bundle);
        player.setViewGroup(layout);
        setPlayerListener(player);
    }

    private void setPlayerListener(AdVideoPlayer advideoplayer)
    {
        advideoplayer.setListener(new AdVideoPlayer.AdVideoPlayerListener() {

            final VideoActionHandler this$0;

            public void onComplete()
            {
                activity.finish();
            }

            public void onError()
            {
                activity.finish();
            }

            
            {
                this$0 = VideoActionHandler.this;
                super();
            }
        });
    }

    public void onCreate()
    {
        Bundle bundle = activity.getIntent().getExtras();
        layout = new RelativeLayout(activity);
        layout.setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, -1));
        activity.setContentView(layout);
        initPlayer(bundle);
        player.playVideo();
    }

    public void onPause()
    {
    }

    public void onResume()
    {
    }

    public void onStop()
    {
        player.releasePlayer();
        player = null;
        activity.finish();
    }

    public void preOnCreate()
    {
    }

    public void setActivity(Activity activity1)
    {
        activity = activity1;
    }

}
