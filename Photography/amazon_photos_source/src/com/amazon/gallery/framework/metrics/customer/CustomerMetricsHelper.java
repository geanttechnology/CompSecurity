// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.metrics.customer;

import com.amazon.gallery.foundation.utils.BasicPathProvider;
import com.amazon.gallery.foundation.utils.date.DateUtils;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.Video;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.model.tags.TagProperty;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CustomerMetricsHelper
{
    static final class SourceBucket extends Enum
    {

        private static final SourceBucket $VALUES[];
        public static final SourceBucket Attachments;
        public static final SourceBucket CameraRoll;
        public static final SourceBucket Cloud;
        public static final SourceBucket Downloads;
        public static final SourceBucket FreeTime;
        public static final SourceBucket Personal;
        public static final SourceBucket Screenshots;

        public static SourceBucket valueOf(String s)
        {
            return (SourceBucket)Enum.valueOf(com/amazon/gallery/framework/metrics/customer/CustomerMetricsHelper$SourceBucket, s);
        }

        public static SourceBucket[] values()
        {
            return (SourceBucket[])$VALUES.clone();
        }

        static 
        {
            CameraRoll = new SourceBucket("CameraRoll", 0);
            FreeTime = new SourceBucket("FreeTime", 1);
            Screenshots = new SourceBucket("Screenshots", 2);
            Attachments = new SourceBucket("Attachments", 3);
            Downloads = new SourceBucket("Downloads", 4);
            Personal = new SourceBucket("Personal", 5);
            Cloud = new SourceBucket("Cloud", 6);
            $VALUES = (new SourceBucket[] {
                CameraRoll, FreeTime, Screenshots, Attachments, Downloads, Personal, Cloud
            });
        }

        private SourceBucket(String s, int i)
        {
            super(s, i);
        }
    }


    private static String getExtension(String s)
    {
        int i = s.lastIndexOf('.');
        if (i > 0)
        {
            return s.substring(i);
        } else
        {
            return "";
        }
    }

    public static Map getExtra(MediaItem mediaitem)
    {
        String s = mediaitem.getLocalPath();
        HashMap hashmap = new HashMap(4);
        SourceBucket sourcebucket = getSourceBucket(mediaitem);
        if (sourcebucket != null)
        {
            hashmap.put("tag", sourcebucket.name());
        }
        if (s != null)
        {
            hashmap.put("fileExtension", getExtension(s));
            hashmap.put("fileSize", String.valueOf((new File(s)).length()));
        }
        if (mediaitem instanceof Video)
        {
            hashmap.put("fileDuration", String.valueOf(((Video)mediaitem).getDuration()));
        }
        return hashmap;
    }

    public static Map getExtraDateTime(long l)
    {
        return getExtraEventTag(DateUtils.getDateFormatWithoutTimeZone(l));
    }

    public static Map getExtraEventTag(int i)
    {
        return getExtraEventTag(String.valueOf(i));
    }

    public static Map getExtraEventTag(long l)
    {
        return getExtraEventTag(String.valueOf(l));
    }

    public static Map getExtraEventTag(String s)
    {
        HashMap hashmap = new HashMap(1);
        hashmap.put("tag", s);
        return hashmap;
    }

    private static SourceBucket getSourceBucket(MediaItem mediaitem)
    {
        for (Iterator iterator = mediaitem.getTags().iterator(); iterator.hasNext();)
        {
            if (((Tag)iterator.next()).hasProperty(TagProperty.FREETIME))
            {
                return SourceBucket.FreeTime;
            }
        }

        mediaitem = mediaitem.getLocalPath();
        if (mediaitem == null)
        {
            return SourceBucket.Cloud;
        }
        if (mediaitem.startsWith(BasicPathProvider.getCameraDirPath()))
        {
            return SourceBucket.CameraRoll;
        }
        if (mediaitem.startsWith(BasicPathProvider.getAttachmentsPath()))
        {
            return SourceBucket.Attachments;
        }
        if (mediaitem.startsWith(BasicPathProvider.getDownloadsPath()))
        {
            return SourceBucket.Downloads;
        }
        if (mediaitem.startsWith(BasicPathProvider.getScreenshotsPath()))
        {
            return SourceBucket.Screenshots;
        } else
        {
            return SourceBucket.Personal;
        }
    }
}
