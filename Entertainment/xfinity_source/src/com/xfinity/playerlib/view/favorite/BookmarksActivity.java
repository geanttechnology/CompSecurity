// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.favorite;

import com.xfinity.playerlib.alt.speechrecognizers.FavoriteSpeechRecognizer;
import com.xfinity.playerlib.model.LiveStreamFavorite;
import com.xfinity.playerlib.model.VideoFavorite;
import com.xfinity.playerlib.view.flyinmenu.PlayNowFlyinMenuActivity;
import com.xfinity.playerlib.view.programdetails.DetailIntentHelper;
import com.xfinity.playerlib.view.videoplay.VideoPlayerActivity;

public class BookmarksActivity extends PlayNowFlyinMenuActivity
    implements BookmarksFragment.FavoriteListener
{

    public BookmarksActivity()
    {
    }

    protected int getLayoutId()
    {
        return com.xfinity.playerlib.R.layout.flyin_bookmarks;
    }

    public int getSearchBackIcon()
    {
        return com.xfinity.playerlib.R.drawable.ico_back_bookmarks;
    }

    protected Class getSpeechRecognizerClass()
    {
        return com/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;
    }

    public void playLiveStream(LiveStreamFavorite livestreamfavorite)
    {
        startActivity(VideoPlayerActivity.createIntentForPlayer(livestreamfavorite.getStreamId()));
    }

    public void showDetail(VideoFavorite videofavorite)
    {
        startActivity((new com.xfinity.playerlib.view.programdetails.DetailIntentHelper.Builder(videofavorite)).loadAsActivity(true).build().getIntent(this));
    }
}
