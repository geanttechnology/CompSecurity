// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.downloads;

import com.xfinity.playerlib.model.downloads.comparator.DownloadableFileDateComparator;
import com.xfinity.playerlib.model.downloads.comparator.DownloadableFileExpirationComparator;
import com.xfinity.playerlib.model.downloads.comparator.DownloadableFileTitleComparator;
import com.xfinity.playerlib.model.user.PlayNowUserManager;
import com.xfinity.playerlib.model.user.PlayerUserSettings;
import com.xfinity.playerlib.view.browseprograms.SortPolicy;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DownloadsSortPolicy extends SortPolicy
{

    protected final DownloadableFileExpirationComparator expiringComparator = new DownloadableFileExpirationComparator();
    protected final DownloadableFileDateComparator recentComparator = new DownloadableFileDateComparator();
    protected final List sortTypes;
    protected final DownloadableFileTitleComparator titleComparator = new DownloadableFileTitleComparator(true);
    protected final PlayNowUserManager userManager;

    public DownloadsSortPolicy(PlayNowUserManager playnowusermanager)
    {
        sortTypes = Collections.unmodifiableList(Arrays.asList(new com.xfinity.playerlib.view.browseprograms.SortPolicy.SortType[] {
            com.xfinity.playerlib.view.browseprograms.SortPolicy.SortType.RECENT, com.xfinity.playerlib.view.browseprograms.SortPolicy.SortType.ALPHA, com.xfinity.playerlib.view.browseprograms.SortPolicy.SortType.EXPIRING
        }));
        userManager = playnowusermanager;
    }

    public Comparator getComparator(com.xfinity.playerlib.view.browseprograms.SortPolicy.SortType sorttype)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$xfinity$playerlib$view$browseprograms$SortPolicy$SortType[];

            static 
            {
                $SwitchMap$com$xfinity$playerlib$view$browseprograms$SortPolicy$SortType = new int[com.xfinity.playerlib.view.browseprograms.SortPolicy.SortType.values().length];
                try
                {
                    $SwitchMap$com$xfinity$playerlib$view$browseprograms$SortPolicy$SortType[com.xfinity.playerlib.view.browseprograms.SortPolicy.SortType.RECENT.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$xfinity$playerlib$view$browseprograms$SortPolicy$SortType[com.xfinity.playerlib.view.browseprograms.SortPolicy.SortType.EXPIRING.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$xfinity$playerlib$view$browseprograms$SortPolicy$SortType[com.xfinity.playerlib.view.browseprograms.SortPolicy.SortType.ALPHA.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.xfinity.playerlib.view.browseprograms.SortPolicy.SortType[sorttype.ordinal()])
        {
        default:
            throw new IllegalArgumentException((new StringBuilder()).append("Unexpected sort type: ").append(sorttype).toString());

        case 1: // '\001'
            return recentComparator;

        case 2: // '\002'
            return expiringComparator;

        case 3: // '\003'
            return titleComparator;
        }
    }

    public com.xfinity.playerlib.view.browseprograms.SortPolicy.SortType getCurrentSortType()
    {
        return ((PlayerUserSettings)userManager.getUserSettings()).getDownloadsSort();
    }

    public List getSortTypes()
    {
        return sortTypes;
    }

    public void setCurrentSortType(com.xfinity.playerlib.view.browseprograms.SortPolicy.SortType sorttype)
    {
        ((PlayerUserSettings)userManager.getUserSettings()).setDownloadsSort(sorttype);
    }
}
