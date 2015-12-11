// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.downloads.comparator;

import com.xfinity.playerlib.model.consumable.Watchable;
import com.xfinity.playerlib.model.downloads.PlayerDownloadFile;
import java.util.Comparator;
import java.util.Date;

public class DownloadableFileExpirationComparator
    implements Comparator
{

    public DownloadableFileExpirationComparator()
    {
    }

    public int compare(PlayerDownloadFile playerdownloadfile, PlayerDownloadFile playerdownloadfile1)
    {
        playerdownloadfile = playerdownloadfile.getWatchable();
        playerdownloadfile1 = playerdownloadfile1.getWatchable();
        return playerdownloadfile.getExpiresDate().compareTo(playerdownloadfile1.getExpiresDate());
    }

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((PlayerDownloadFile)obj, (PlayerDownloadFile)obj1);
    }
}
