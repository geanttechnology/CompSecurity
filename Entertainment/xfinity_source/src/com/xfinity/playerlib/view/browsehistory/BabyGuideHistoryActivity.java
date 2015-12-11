// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.browsehistory;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import com.xfinity.playerlib.bookmarks.VideoBookmark;
import com.xfinity.playerlib.model.MerlinId;
import com.xfinity.playerlib.model.consumable.VideoFacade;
import com.xfinity.playerlib.model.consumable.Watchable;
import com.xfinity.playerlib.view.programdetails.BabyGuideMovieActivity;
import com.xfinity.playerlib.view.programdetails.BabyGuideSeriesEntityActivity;
import com.xfinity.playerlib.view.programdetails.DetailIntentHelper;
import com.xfinity.playerlib.view.videoplay.VideoPlayerActivity;

// Referenced classes of package com.xfinity.playerlib.view.browsehistory:
//            HistoryActivity

public class BabyGuideHistoryActivity extends HistoryActivity
{

    public BabyGuideHistoryActivity()
    {
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

    public void onLiveStreamPlayOrResumePressed(String s)
    {
        s = VideoPlayerActivity.createIntentForPlayer(s);
        s.setAction("reset");
        s.setFlags(0x4000000);
        startActivity(s);
    }

    public void onPlayOrResumePressed(VideoFacade videofacade, Watchable watchable)
    {
        videofacade = VideoPlayerActivity.createIntentForPlayer(videofacade, watchable);
        videofacade.setAction("reset");
        videofacade.setFlags(0x4000000);
        startActivity(videofacade);
    }

    public void onVideoPlayOrResumePressed(VideoBookmark videobookmark)
    {
        videobookmark = VideoPlayerActivity.createIntentForPlayer(videobookmark);
        videobookmark.setAction("reset");
        videobookmark.setFlags(0x4000000);
        startActivity(videobookmark);
    }

    public void showDetail(VideoBookmark videobookmark, Long long1)
    {
        com.xfinity.playerlib.view.programdetails.DetailIntentHelper.Builder builder = (new com.xfinity.playerlib.view.programdetails.DetailIntentHelper.Builder(videobookmark)).shouldHideSeriesTitle(false).showPanelFittedLayout(false).loadAsActivity(true).currentlyPlayingVideo(long1);
        if (videobookmark.getMerlinId().getNamespace().equals(com.xfinity.playerlib.model.MerlinId.Namespace.Movie))
        {
            long1 = com.xfinity.playerlib.model.MerlinId.Namespace.Movie;
        } else
        {
            long1 = com.xfinity.playerlib.model.MerlinId.Namespace.TvSeries;
        }
        long1 = builder.overrideNamespace(long1).build();
        if (videobookmark.getMerlinId().getNamespace() == com.xfinity.playerlib.model.MerlinId.Namespace.Movie)
        {
            videobookmark = new Intent(this, com/xfinity/playerlib/view/programdetails/BabyGuideMovieActivity);
        } else
        {
            videobookmark = new Intent(this, com/xfinity/playerlib/view/programdetails/BabyGuideSeriesEntityActivity);
        }
        videobookmark.putExtras(long1.getBundle());
        startActivity(videobookmark);
    }
}
