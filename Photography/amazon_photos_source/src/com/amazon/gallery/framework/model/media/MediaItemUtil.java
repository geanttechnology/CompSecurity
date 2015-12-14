// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.model.media;

import com.amazon.gallery.foundation.utils.date.DateUtils;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.model.tags.TagProperty;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.amazon.gallery.framework.model.media:
//            MediaItem, GroupType, OrderedGroupPhoto, CommonMediaProperty, 
//            SyncState, Video

public class MediaItemUtil
{

    public static void adjustDimentionsForOrientation(MediaItem mediaitem)
    {
        if (mediaitem.getOrientation() == 90 || mediaitem.getOrientation() == 270)
        {
            int i = mediaitem.getWidth();
            mediaitem.setWidth(mediaitem.getHeight());
            mediaitem.setHeight(i);
        }
    }

    public static long createTimestamp(MediaItem mediaitem)
    {
        long l1 = mediaitem.getDateCreatedMs();
        long l = l1;
        if (l1 == 0L)
        {
            l = l1;
            if (isLocalMediaItem(mediaitem))
            {
                l = l1;
                if (!isCloudMediaItem(mediaitem))
                {
                    l = DateUtils.applyCurrentTimeZone(mediaitem.getDateAddedMs());
                }
            }
        }
        return l;
    }

    public static long getFileLength(MediaItem mediaitem)
    {
        if (isLocalMediaItem(mediaitem))
        {
            return (new File(mediaitem.getLocalPath())).length();
        } else
        {
            return 0L;
        }
    }

    public static long getFileLength(Collection collection, Set set)
    {
        long l = 0L;
        collection = collection.iterator();
        do
        {
            if (!collection.hasNext())
            {
                break;
            }
            MediaItem mediaitem = (MediaItem)collection.next();
            if (set.contains(mediaitem.getType()))
            {
                l += getFileLength(mediaitem);
            }
        } while (true);
        return l;
    }

    public static boolean hasLocalLenticularParts(MediaItem mediaitem)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (mediaitem.getGroupType() == GroupType.LENTICULAR)
        {
            flag = flag1;
            if (((OrderedGroupPhoto)mediaitem).getFrames().size() > 0)
            {
                flag = true;
            }
        }
        return flag;
    }

    public static boolean hasNoLocalParts(MediaItem mediaitem)
    {
        return mediaitem != null && !mediaitem.hasProperty(CommonMediaProperty.LOCAL);
    }

    public static boolean isCloudMediaItem(MediaItem mediaitem)
    {
        mediaitem = mediaitem.getSyncState();
        if (mediaitem == null)
        {
            return false;
        } else
        {
            return mediaitem.equals(SyncState.SYNCED);
        }
    }

    public static boolean isFreeTime(MediaItem mediaitem)
    {
        for (mediaitem = mediaitem.getTags().iterator(); mediaitem.hasNext();)
        {
            if (((Tag)mediaitem.next()).hasProperty(TagProperty.FREETIME))
            {
                return true;
            }
        }

        return false;
    }

    public static boolean isLocalMediaItem(MediaItem mediaitem)
    {
        mediaitem = mediaitem.getLocalPath();
        return mediaitem != null && !mediaitem.isEmpty();
    }

    public static boolean isRewindPhoto(MediaItem mediaitem)
    {
        return mediaitem.getGroupType() == GroupType.REWIND;
    }

    public static boolean isVideoCorrupted(Video video)
    {
        return video.getDuration() == 0L && video.getWidth() < 0 && video.getHeight() < 0;
    }

    public static boolean localFileExists(MediaItem mediaitem)
    {
        if (isLocalMediaItem(mediaitem))
        {
            return (new File(mediaitem.getLocalPath())).exists();
        } else
        {
            return false;
        }
    }
}
