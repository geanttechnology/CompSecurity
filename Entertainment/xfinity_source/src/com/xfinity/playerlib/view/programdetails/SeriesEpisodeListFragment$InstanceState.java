// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.programdetails;

import android.os.Bundle;
import com.xfinity.playerlib.view.BaseInstanceState;

// Referenced classes of package com.xfinity.playerlib.view.programdetails:
//            SeriesEpisodeListFragment

public static class seriesDetailSelected extends BaseInstanceState
{

    protected static final String EXTRA_BUNDLE_PARAMS = com/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState.getCanonicalName();
    public boolean seriesDetailSelected;

    public static seriesDetailSelected fromBundle(Bundle bundle)
    {
        return (seriesDetailSelected)bundle.getSerializable(EXTRA_BUNDLE_PARAMS);
    }

    public Bundle addToBundle(Bundle bundle)
    {
        bundle.putSerializable(EXTRA_BUNDLE_PARAMS, this);
        return bundle;
    }

    public void resetWatchableInfo()
    {
        episodeId = null;
        nonEpisodeVideoId = null;
        seriesDetailSelected = false;
    }


    public ()
    {
        seriesDetailSelected = false;
    }
}
