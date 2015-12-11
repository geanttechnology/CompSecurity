// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.browsehistory;

import com.xfinity.playerlib.alt.speechrecognizers.HistorySpeechRecognizer;
import com.xfinity.playerlib.bookmarks.VideoBookmark;
import com.xfinity.playerlib.model.consumable.VideoFacade;
import com.xfinity.playerlib.model.consumable.Watchable;
import com.xfinity.playerlib.view.flyinmenu.PlayNowFlyinMenuActivity;
import com.xfinity.playerlib.view.programdetails.DetailIntentHelper;
import com.xfinity.playerlib.view.videoplay.VideoPlayerActivity;

public class HistoryActivity extends PlayNowFlyinMenuActivity
    implements HistoryFragment.HistoryListener, HistoryFragment.LiveStreamPlayOrResumePressedListener, HistoryFragment.VideoPlayOrResumePressedListener, com.xfinity.playerlib.view.programdetails.DetailFragment.PlayPressedListener
{

    public HistoryActivity()
    {
    }

    protected int getLayoutId()
    {
        return com.xfinity.playerlib.R.layout.flyin_history_browse;
    }

    public int getSearchBackIcon()
    {
        return com.xfinity.playerlib.R.drawable.ico_back_history;
    }

    protected Class getSpeechRecognizerClass()
    {
        return com/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer;
    }

    public void onLiveStreamPlayOrResumePressed(String s)
    {
        startActivity(VideoPlayerActivity.createIntentForPlayer(s));
    }

    public void onPlayOrResumePressed(VideoFacade videofacade, Watchable watchable)
    {
        startActivity(VideoPlayerActivity.createIntentForPlayer(videofacade, watchable));
    }

    public void onVideoPlayOrResumePressed(VideoBookmark videobookmark)
    {
        startActivity(VideoPlayerActivity.createIntentForPlayer(videobookmark));
    }

    public void showDetail(VideoBookmark videobookmark, Long long1)
    {
        startActivity((new com.xfinity.playerlib.view.programdetails.DetailIntentHelper.Builder(videobookmark)).currentlyPlayingVideo(long1).loadAsActivity(true).showDetail(true).build().getIntent(this));
    }
}
