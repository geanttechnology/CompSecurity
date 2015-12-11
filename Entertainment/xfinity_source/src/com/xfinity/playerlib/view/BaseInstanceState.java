// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view;

import android.os.Bundle;
import com.xfinity.playerlib.model.MerlinId;
import com.xfinity.playerlib.model.consumable.WatchableKey;
import java.io.Serializable;

public class BaseInstanceState
    implements Serializable
{

    public static final String EXTRA_BUNDLE_PARAMS = com/xfinity/playerlib/view/BaseInstanceState.getCanonicalName();
    public Long companyId;
    public Long currentlyPlayingVideoId;
    public MerlinId episodeId;
    public Boolean loadAsActivity;
    public MerlinId merlinId;
    public Long nonEpisodeVideoId;
    public MerlinId seriesId;
    public boolean shouldHideSeriesTitle;
    public boolean showPanelFittedLayout;
    public Boolean showSeriesArt;
    public Long videoId;
    public boolean wantsSubscriptionOnly;
    public WatchableKey watchableKey;

    public BaseInstanceState()
    {
        videoId = null;
        loadAsActivity = Boolean.valueOf(true);
        showSeriesArt = Boolean.valueOf(false);
        showPanelFittedLayout = false;
    }

    public Bundle addToBundle(Bundle bundle)
    {
        bundle.putSerializable(EXTRA_BUNDLE_PARAMS, this);
        return bundle;
    }

    public boolean hasNonEpisodeID()
    {
        return nonEpisodeVideoId != null;
    }

    public boolean hasOnlySeriesInfo()
    {
        return watchableKey == null && episodeId == null && nonEpisodeVideoId == null;
    }

    public boolean hasValidVideoId()
    {
        return videoId != null;
    }

    public void setCompanyId(Long long1)
    {
        companyId = long1;
    }

    public void setCurrentlyPlayingVideoId(Long long1)
    {
        currentlyPlayingVideoId = long1;
    }

    public void setEpisodeId(MerlinId merlinid)
    {
        episodeId = merlinid;
    }

    public void setLoadAsActivity(Boolean boolean1)
    {
        loadAsActivity = boolean1;
    }

    public void setMerlinId(MerlinId merlinid)
    {
        merlinId = merlinid;
    }

    public void setNonEpisodeVideoId(Long long1)
    {
        nonEpisodeVideoId = long1;
    }

    public void setSeriesId(MerlinId merlinid)
    {
        seriesId = merlinid;
    }

    public void setShouldHideSeriesTitle(boolean flag)
    {
        shouldHideSeriesTitle = flag;
    }

    public void setShowPanelFittedLayout(boolean flag)
    {
        showPanelFittedLayout = flag;
    }

    public void setVideoId(Long long1)
    {
        videoId = long1;
    }

    public void setWantsSubscriptionOnly(boolean flag)
    {
        wantsSubscriptionOnly = flag;
    }

    public void setWatchableKey(WatchableKey watchablekey)
    {
        watchableKey = watchablekey;
    }

    public void showSeriesArt(Boolean boolean1)
    {
        showSeriesArt = boolean1;
    }

    public boolean useDownloadAsSource()
    {
        return watchableKey != null;
    }

    public boolean useEpisodeId()
    {
        return episodeId != null && seriesId != null && !episodeId.equals(seriesId);
    }

}
