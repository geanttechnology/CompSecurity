// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.browseprograms;

import android.os.Bundle;
import com.comcast.cim.android.view.flow.FilterRequestObserver;
import com.xfinity.playerlib.alt.speechrecognizers.FavoriteSpeechRecognizer;
import com.xfinity.playerlib.model.consumable.hal.HalLiveStream;
import com.xfinity.playerlib.view.flyinmenu.PlayNowFlyinMenuActivity;
import com.xfinity.playerlib.view.videoplay.VideoPlayerActivity;

public class LiveStreamsActivity extends PlayNowFlyinMenuActivity
    implements FilterRequestObserver, LiveStreamsFragment.LiveStreamOnClickListener
{

    public LiveStreamsActivity()
    {
    }

    protected int getLayoutId()
    {
        return com.xfinity.playerlib.R.layout.flyin_live_streams_browse;
    }

    public int getSearchBackIcon()
    {
        return com.xfinity.playerlib.R.drawable.ico_back_live;
    }

    protected Class getSpeechRecognizerClass()
    {
        return com/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;
    }

    public void onLiveEventClick(HalLiveStream hallivestream, String s)
    {
        startActivity(VideoPlayerActivity.createIntentForPlayer(hallivestream.getStreamId(), s));
    }

    public void onLiveStreamClick(HalLiveStream hallivestream)
    {
        startActivity(VideoPlayerActivity.createIntentForPlayer(hallivestream.getStreamId()));
    }

    public void showFilter(Bundle bundle)
    {
    }
}
