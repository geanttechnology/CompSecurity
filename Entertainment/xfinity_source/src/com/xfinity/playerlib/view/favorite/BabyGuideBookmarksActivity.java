// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.favorite;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.xfinity.playerlib.model.LiveStreamFavorite;
import com.xfinity.playerlib.model.MerlinId;
import com.xfinity.playerlib.model.VideoFavorite;
import com.xfinity.playerlib.view.programdetails.BabyGuideMovieActivity;
import com.xfinity.playerlib.view.programdetails.BabyGuideSeriesEntityActivity;
import com.xfinity.playerlib.view.programdetails.DetailIntentHelper;
import com.xfinity.playerlib.view.videoplay.VideoPlayerActivity;

// Referenced classes of package com.xfinity.playerlib.view.favorite:
//            BookmarksActivity

public class BabyGuideBookmarksActivity extends BookmarksActivity
{

    private Long currentlyPlayingVideoId;

    public BabyGuideBookmarksActivity()
    {
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        Bundle bundle1 = new Bundle();
        if (bundle != null)
        {
            bundle1.putAll(bundle);
        }
        if (getIntent().getExtras() != null)
        {
            bundle1.putAll(getIntent().getExtras());
        }
        currentlyPlayingVideoId = Long.valueOf(bundle1.getLong("EXTRA_CURRENT_WATCH_VIDEO_ID"));
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        super.onCreateOptionsMenu(menu);
        if (searchMenuItem != null)
        {
            searchMenuItem.setVisible(false);
        }
        return false;
    }

    public void playLiveStream(LiveStreamFavorite livestreamfavorite)
    {
        livestreamfavorite = VideoPlayerActivity.createIntentForPlayer(livestreamfavorite.getStreamId());
        livestreamfavorite.setAction("reset");
        livestreamfavorite.setFlags(0x4000000);
        startActivity(livestreamfavorite);
    }

    public void showDetail(VideoFavorite videofavorite)
    {
        DetailIntentHelper detailintenthelper = (new com.xfinity.playerlib.view.programdetails.DetailIntentHelper.Builder(videofavorite)).shouldHideSeriesTitle(false).showPanelFittedLayout(false).loadAsActivity(true).currentlyPlayingVideo(currentlyPlayingVideoId).overrideNamespace(videofavorite.getMerlinId().getNamespace()).build();
        if (videofavorite.getMerlinId().getNamespace() == com.xfinity.playerlib.model.MerlinId.Namespace.Movie)
        {
            videofavorite = new Intent(this, com/xfinity/playerlib/view/programdetails/BabyGuideMovieActivity);
        } else
        {
            videofavorite = new Intent(this, com/xfinity/playerlib/view/programdetails/BabyGuideSeriesEntityActivity);
        }
        videofavorite.putExtras(detailintenthelper.getBundle());
        startActivity(videofavorite);
    }
}
