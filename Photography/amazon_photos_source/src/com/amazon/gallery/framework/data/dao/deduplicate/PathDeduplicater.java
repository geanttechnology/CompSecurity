// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.deduplicate;

import com.amazon.gallery.foundation.utils.apilevel.BuildFlavors;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.dao.AbstractDeduplicater;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.MediaItemCollection;
import java.util.Collections;
import java.util.List;

public class PathDeduplicater extends AbstractDeduplicater
{

    private static final String TAG = com/amazon/gallery/framework/data/dao/deduplicate/PathDeduplicater.getName();

    public PathDeduplicater(MediaItemDao mediaitemdao)
    {
        super(mediaitemdao);
    }

    public List getCloudDuplicates(MediaItem mediaitem)
    {
        mediaitem = mediaItemDao.getItemsByLocalPath(mediaitem.getLocalPath()).getMediaItems();
        if (mediaitem.size() > 1)
        {
            Throwable throwable = new Throwable();
            GLogger.exf(TAG, throwable, "Found %d items with the same local path!", new Object[] {
                Integer.valueOf(mediaitem.size())
            });
            if (BuildFlavors.isDebug())
            {
                throw new RuntimeException(throwable);
            }
        }
        return mediaitem;
    }

    public List getLocalDuplicates(MediaItem mediaitem)
    {
        return Collections.EMPTY_LIST;
    }

}
