// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.downloads.comparator;

import com.xfinity.playerlib.model.consumable.SeriesWatchableInfo;
import com.xfinity.playerlib.model.consumable.Watchable;
import com.xfinity.playerlib.model.downloads.PlayerDownloadFile;
import java.util.Comparator;

public class DownloadableFileTitleComparator
    implements Comparator
{

    private final boolean isAscending;

    public DownloadableFileTitleComparator(boolean flag)
    {
        isAscending = flag;
    }

    public int compare(PlayerDownloadFile playerdownloadfile, PlayerDownloadFile playerdownloadfile1)
    {
        playerdownloadfile = playerdownloadfile.getWatchable();
        playerdownloadfile1 = playerdownloadfile1.getWatchable();
        SeriesWatchableInfo serieswatchableinfo = playerdownloadfile.getSeriesInfoIfApplicable();
        SeriesWatchableInfo serieswatchableinfo1 = playerdownloadfile1.getSeriesInfoIfApplicable();
        int i;
        if (serieswatchableinfo != null && serieswatchableinfo1 != null)
        {
            int j = serieswatchableinfo.getSeriesSortTitle().compareToIgnoreCase(serieswatchableinfo1.getSeriesSortTitle());
            i = j;
            if (j == 0)
            {
                if (serieswatchableinfo.getSeasonNumber() != null && serieswatchableinfo1.getSeasonNumber() != null)
                {
                    int k = serieswatchableinfo1.getSeasonNumber().intValue() - serieswatchableinfo.getSeasonNumber().intValue();
                    i = k;
                    if (k == 0)
                    {
                        i = serieswatchableinfo1.getEpisodeNumber().intValue() - serieswatchableinfo.getEpisodeNumber().intValue();
                    }
                } else
                if (serieswatchableinfo.getSeasonNumber() != null)
                {
                    i = -1;
                } else
                if (serieswatchableinfo1.getSeasonNumber() != null)
                {
                    i = 1;
                } else
                {
                    i = playerdownloadfile.getSortTitle().compareToIgnoreCase(playerdownloadfile1.getSortTitle());
                }
            }
        } else
        if (serieswatchableinfo != null)
        {
            i = serieswatchableinfo.getSeriesSortTitle().compareToIgnoreCase(playerdownloadfile1.getSortTitle());
        } else
        if (serieswatchableinfo1 != null)
        {
            i = playerdownloadfile.getSortTitle().compareToIgnoreCase(serieswatchableinfo1.getSeriesSortTitle());
        } else
        {
            i = playerdownloadfile.getSortTitle().compareToIgnoreCase(playerdownloadfile1.getSortTitle());
        }
        if (isAscending)
        {
            return i;
        } else
        {
            return -i;
        }
    }

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((PlayerDownloadFile)obj, (PlayerDownloadFile)obj1);
    }
}
