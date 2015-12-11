// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.videoplay;

import com.xfinity.playerlib.bookmarks.VideoBookmark;
import com.xfinity.playerlib.model.VideoFavorite;
import com.xfinity.playerlib.model.consumable.SeriesWatchable;

// Referenced classes of package com.xfinity.playerlib.view.videoplay:
//            VideoPlayerFragment

private class <init> extends <init>
{

    final VideoPlayerFragment this$0;

    public void hideInfoPanel()
    {
        showActionBarMenus();
    }

    public boolean showCurrentVideoInfo(String s)
    {
        hideActionBarMenus();
        s = getCurrentVideoIntent();
        startActivity(s);
        return true;
    }

    public boolean showFavorite(String s)
    {
        hideActionBarMenus();
        startActivity(getFavoriteIntent());
        return true;
    }

    public void showFavoriteDetail(VideoFavorite videofavorite, String s)
    {
    }

    public boolean showHistory(String s)
    {
        hideActionBarMenus();
        startActivity(getHistoryIntent());
        return true;
    }

    public void showHistoryItemDetail(VideoBookmark videobookmark, String s)
    {
    }

    public void showSeriesWatchableDetail(SeriesWatchable serieswatchable, String s)
    {
    }

    private ()
    {
        this$0 = VideoPlayerFragment.this;
        super(VideoPlayerFragment.this);
    }

    >(> >)
    {
        this();
    }
}
