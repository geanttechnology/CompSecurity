// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.downloads.comparator;

import com.xfinity.playerlib.model.downloads.PlayerDownloadFile;
import java.util.Comparator;
import java.util.Date;

public class DownloadableFileDateComparator
    implements Comparator
{

    public DownloadableFileDateComparator()
    {
    }

    public int compare(PlayerDownloadFile playerdownloadfile, PlayerDownloadFile playerdownloadfile1)
    {
        playerdownloadfile = playerdownloadfile.getDownloadDate();
        return playerdownloadfile1.getDownloadDate().compareTo(playerdownloadfile);
    }

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((PlayerDownloadFile)obj, (PlayerDownloadFile)obj1);
    }
}
