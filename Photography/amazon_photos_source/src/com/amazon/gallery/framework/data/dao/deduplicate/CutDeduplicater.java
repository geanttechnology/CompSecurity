// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.deduplicate;

import com.amazon.gallery.framework.data.dao.AbstractDeduplicater;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.MediaItemCollection;
import com.amazon.gallery.framework.model.media.MediaItemUtil;
import com.amazon.gallery.framework.model.media.MediaType;
import com.amazon.gallery.framework.model.media.SyncState;
import com.amazon.gallery.framework.model.media.Video;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.gallery.framework.data.dao.deduplicate:
//            FilenameIdEmbedUtils

public class CutDeduplicater extends AbstractDeduplicater
{

    public CutDeduplicater(MediaItemDao mediaitemdao)
    {
        super(mediaitemdao);
    }

    public List getCloudDuplicates(MediaItem mediaitem)
    {
        List list = (List)resultArray.get();
        if ("image/jpeg".equals(mediaitem.getMIMEType()) && mediaitem.getFullMd5() != null)
        {
            mediaitem = mediaItemDao.getItemsByFullMd5(mediaitem.getFullMd5()).iterator();
            do
            {
                if (!mediaitem.hasNext())
                {
                    break;
                }
                MediaItem mediaitem1 = (MediaItem)mediaitem.next();
                if (MediaItemUtil.hasNoLocalParts(mediaitem1))
                {
                    list.add(mediaitem1);
                }
            } while (true);
        } else
        if ("video/mp4".equals(mediaitem.getMIMEType()))
        {
            mediaitem = FilenameIdEmbedUtils.extractParentObjectId(mediaitem.getLocalPath());
            if (mediaitem != null)
            {
                mediaitem = mediaItemDao.getItemById(mediaitem);
                if (MediaItemUtil.hasNoLocalParts(mediaitem))
                {
                    list.add(mediaitem);
                }
            }
        }
        return list;
    }

    public List getLocalDuplicates(MediaItem mediaitem)
    {
        List list = (List)resultArray.get();
        if (mediaitem.getType() == MediaType.PHOTO)
        {
            mediaitem = mediaItemDao.getItemsByFullMd5AndSyncState(SyncState.NOT_SYNCED, mediaitem.getFullMd5()).iterator();
            do
            {
                if (!mediaitem.hasNext())
                {
                    break;
                }
                MediaItem mediaitem1 = (MediaItem)mediaitem.next();
                if (!MediaItemUtil.isCloudMediaItem(mediaitem1))
                {
                    list.add(mediaitem1);
                }
            } while (true);
        } else
        {
            long l = ((Video)mediaitem).getDuration();
            Iterator iterator = mediaItemDao.getPossibleDuplicateCutItems(mediaitem).getMediaItems().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                MediaItem mediaitem2 = (MediaItem)iterator.next();
                if (!MediaItemUtil.isCloudMediaItem(mediaitem2) && Math.abs(((Video)mediaitem2).getDuration() - l) < 500L)
                {
                    ObjectID objectid = FilenameIdEmbedUtils.extractParentObjectId(mediaitem2.getLocalPath());
                    if (objectid != null && objectid.equals(mediaitem.getObjectId()))
                    {
                        list.add(mediaitem2);
                    }
                }
            } while (true);
        }
        return list;
    }
}
