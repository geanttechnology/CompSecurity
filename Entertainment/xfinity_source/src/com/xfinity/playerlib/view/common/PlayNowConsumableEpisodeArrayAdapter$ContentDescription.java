// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.common;

import android.content.Context;
import android.view.View;
import com.auditude.ads.util.StringUtil;
import com.xfinity.playerlib.model.consumable.SeriesWatchable;
import org.apache.commons.lang3.time.FastDateFormat;

// Referenced classes of package com.xfinity.playerlib.view.common:
//            PlayNowConsumableEpisodeArrayAdapter

private class <init>
{

    protected String episodeNumber;
    protected String episodeTitle;
    protected boolean isAvailableForDownload;
    protected boolean isNew;
    protected boolean isWatching;
    protected String seasonNumber;
    protected String seriesTitle;
    final PlayNowConsumableEpisodeArrayAdapter this$0;
    protected String timeRemaining;

    public String getContentDescription(Context context)
    {
        String s;
        String s1;
        String s2;
        String s3;
        if (isNew)
        {
            s = context.getString(com.xfinity.playerlib.Description.isNew);
        } else
        {
            s = "";
        }
        if (isWatching)
        {
            s1 = context.getString(com.xfinity.playerlib.Description.isWatching);
        } else
        {
            s1 = "";
        }
        if (isAvailableForDownload)
        {
            s2 = context.getString(com.xfinity.playerlib.Description.isAvailableForDownload);
        } else
        {
            s2 = "";
        }
        if (StringUtil.isNullOrEmpty(episodeNumber))
        {
            s3 = "";
        } else
        {
            s3 = context.getString(com.xfinity.playerlib.Description.episodeNumber, new Object[] {
                episodeNumber
            });
        }
        episodeNumber = s3;
        if (StringUtil.isNullOrEmpty(seasonNumber))
        {
            s3 = "";
        } else
        {
            s3 = context.getString(com.xfinity.playerlib.Description.seasonNumber, new Object[] {
                seasonNumber
            });
        }
        seasonNumber = s3;
        return context.getString(com.xfinity.playerlib.Description.seasonNumber, new Object[] {
            episodeNumber, s, episodeTitle, seriesTitle, seasonNumber, s1, timeRemaining, s2
        });
    }

    public void setContentDescription(View view)
    {
        view.setContentDescription(getContentDescription(view.getContext()));
    }

    public void setupTitleText(SeriesWatchable serieswatchable)
    {
        String s = serieswatchable.getDisplayTitle();
        if (s == null || s.length() <= 0) goto _L2; else goto _L1
_L1:
        episodeTitle = s;
_L4:
        if (serieswatchable.getSeriesTitle() != null)
        {
            seriesTitle = serieswatchable.getSeriesTitle();
        }
        return;
_L2:
        if (serieswatchable.getOriginalAirdate() != null)
        {
            episodeTitle = FastDateFormat.getInstance("MMM d, yyyy").format(serieswatchable.getOriginalAirdate());
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private ()
    {
        this$0 = PlayNowConsumableEpisodeArrayAdapter.this;
        super();
        episodeTitle = "";
        seriesTitle = "";
        seasonNumber = "";
        episodeNumber = "";
        timeRemaining = "";
    }

    timeRemaining(timeRemaining timeremaining)
    {
        this();
    }
}
