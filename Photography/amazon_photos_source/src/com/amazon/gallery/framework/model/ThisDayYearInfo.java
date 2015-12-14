// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.model;

import com.amazon.gallery.framework.model.media.MediaItem;
import java.util.ArrayList;
import java.util.List;

public class ThisDayYearInfo
{

    private final int maxMediaItemsToCollect;
    private final List mediaItems;
    private int numTotalMediaItems;
    private final int year;

    public ThisDayYearInfo(int i, int j)
    {
        year = i;
        maxMediaItemsToCollect = j;
        mediaItems = new ArrayList(j);
    }

    public boolean addMediaItem(MediaItem mediaitem)
    {
        boolean flag = false;
        if (numTotalMediaItems < maxMediaItemsToCollect)
        {
            mediaItems.add(mediaitem);
            flag = true;
        }
        numTotalMediaItems = numTotalMediaItems + 1;
        return flag;
    }

    public List getMediaItems()
    {
        return mediaItems;
    }

    public int getNumTotalMediaItems()
    {
        return numTotalMediaItems;
    }

    public int getYear()
    {
        return year;
    }
}
