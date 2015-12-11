// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.flyinmenu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.xfinity.playerlib.view.browsehistory.HistoryActivity;
import com.xfinity.playerlib.view.browsenetworks.NetworksActivity;
import com.xfinity.playerlib.view.browseprograms.KidsActivity;
import com.xfinity.playerlib.view.browseprograms.LiveStreamsActivity;
import com.xfinity.playerlib.view.browseprograms.MoviesActivity;
import com.xfinity.playerlib.view.browseprograms.SeriesActivity;
import com.xfinity.playerlib.view.downloads.DownloadsActivity;
import com.xfinity.playerlib.view.favorite.BookmarksActivity;
import com.xfinity.playerlib.view.featured.FeaturedActivity;
import com.xfinity.playerlib.view.settings.PlayNowSettingsFragmentActivity;

public final class FlyinMenuOptions extends Enum
{

    private static final FlyinMenuOptions $VALUES[];
    public static final FlyinMenuOptions DOWNLOADS;
    public static final FlyinMenuOptions FAVORITE;
    public static final FlyinMenuOptions FEATURED;
    public static final FlyinMenuOptions HISTORY;
    public static final FlyinMenuOptions KIDS;
    public static final FlyinMenuOptions LIVE;
    public static final FlyinMenuOptions MOVIES;
    public static final FlyinMenuOptions NETWORKS;
    public static final FlyinMenuOptions SETTINGS;
    public static final FlyinMenuOptions TV_SERIES;
    private final Class activity;
    private final int captionResId;
    private final int iconResId;

    private FlyinMenuOptions(String s, int i, int j, int k, Class class1)
    {
        super(s, i);
        captionResId = j;
        iconResId = k;
        activity = class1;
    }

    public static FlyinMenuOptions valueOf(String s)
    {
        return (FlyinMenuOptions)Enum.valueOf(com/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions, s);
    }

    public static FlyinMenuOptions[] values()
    {
        return (FlyinMenuOptions[])$VALUES.clone();
    }

    public Class getActivity()
    {
        return activity;
    }

    public String getCaption(Context context)
    {
        return context.getResources().getString(captionResId);
    }

    public Drawable getDrawable(Context context)
    {
        return context.getResources().getDrawable(iconResId);
    }

    static 
    {
        FEATURED = new FlyinMenuOptions("FEATURED", 0, com.xfinity.playerlib.R.string.flyin_menu_featured, com.xfinity.playerlib.R.drawable.flyin_menu_featured, com/xfinity/playerlib/view/featured/FeaturedActivity);
        TV_SERIES = new FlyinMenuOptions("TV_SERIES", 1, com.xfinity.playerlib.R.string.flyin_menu_tv_series, com.xfinity.playerlib.R.drawable.flyin_menu_tv, com/xfinity/playerlib/view/browseprograms/SeriesActivity);
        MOVIES = new FlyinMenuOptions("MOVIES", 2, com.xfinity.playerlib.R.string.flyin_menu_movies, com.xfinity.playerlib.R.drawable.flyin_menu_movies, com/xfinity/playerlib/view/browseprograms/MoviesActivity);
        NETWORKS = new FlyinMenuOptions("NETWORKS", 3, com.xfinity.playerlib.R.string.flyin_menu_networks, com.xfinity.playerlib.R.drawable.flyin_menu_networks, com/xfinity/playerlib/view/browsenetworks/NetworksActivity);
        HISTORY = new FlyinMenuOptions("HISTORY", 4, com.xfinity.playerlib.R.string.flyin_menu_history, com.xfinity.playerlib.R.drawable.flyin_menu_history, com/xfinity/playerlib/view/browsehistory/HistoryActivity);
        DOWNLOADS = new FlyinMenuOptions("DOWNLOADS", 5, com.xfinity.playerlib.R.string.flyin_menu_downloads, com.xfinity.playerlib.R.drawable.flyin_menu_downloads, com/xfinity/playerlib/view/downloads/DownloadsActivity);
        SETTINGS = new FlyinMenuOptions("SETTINGS", 6, com.xfinity.playerlib.R.string.flyin_menu_settings, com.xfinity.playerlib.R.drawable.flyin_menu_settings, com/xfinity/playerlib/view/settings/PlayNowSettingsFragmentActivity);
        FAVORITE = new FlyinMenuOptions("FAVORITE", 7, com.xfinity.playerlib.R.string.flyin_menu_favorite, com.xfinity.playerlib.R.drawable.flyin_menu_bookmarks, com/xfinity/playerlib/view/favorite/BookmarksActivity);
        KIDS = new FlyinMenuOptions("KIDS", 8, com.xfinity.playerlib.R.string.flyin_menu_kids, com.xfinity.playerlib.R.drawable.flyin_menu_kids, com/xfinity/playerlib/view/browseprograms/KidsActivity);
        LIVE = new FlyinMenuOptions("LIVE", 9, com.xfinity.playerlib.R.string.flyin_menu_live, com.xfinity.playerlib.R.drawable.flyin_menu_live, com/xfinity/playerlib/view/browseprograms/LiveStreamsActivity);
        $VALUES = (new FlyinMenuOptions[] {
            FEATURED, TV_SERIES, MOVIES, NETWORKS, HISTORY, DOWNLOADS, SETTINGS, FAVORITE, KIDS, LIVE
        });
    }
}
