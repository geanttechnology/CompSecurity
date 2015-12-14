// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.model;

import com.amazon.gallery.framework.model.TimelineQuery;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.MediaItemCollection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MediaItemCollectionBeanImpl
    implements MediaItemCollection
{

    private MediaItem coverMediaItem;
    private Iterable iterator;
    private List mediaItems;
    private TimelineQuery timelineQuery;

    public MediaItemCollectionBeanImpl()
    {
        mediaItems = new ArrayList();
    }

    public MediaItem getCoverMediaItem()
    {
        return coverMediaItem;
    }

    public List getMediaItems()
    {
        return mediaItems;
    }

    public Iterator iterator()
    {
        if (iterator == null)
        {
            return mediaItems.iterator();
        } else
        {
            return iterator.iterator();
        }
    }

    public void setCoverMediaItem(MediaItem mediaitem)
    {
        coverMediaItem = mediaitem;
    }

    public void setDefaultCoverMediaItem()
    {
        if (getMediaItems().size() > 0)
        {
            setCoverMediaItem((MediaItem)getMediaItems().get(0));
        }
    }

    public void setIterator(Iterable iterable)
    {
        iterator = iterable;
    }

    public void setMediaItems(List list)
    {
        mediaItems = list;
    }

    public void setTimelineQuery(TimelineQuery timelinequery)
    {
        timelineQuery = timelinequery;
    }
}
