// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.model;

import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.gallery.utils.TimelineMonthResources;
import com.amazon.gallery.framework.model.TimelineEntry;
import com.amazon.gallery.framework.model.media.MediaItem;
import java.util.Calendar;
import java.util.TimeZone;

// Referenced classes of package com.amazon.gallery.framework.data.model:
//            TimelineEntryImpl

public class TimelineUtils
{

    private static ThreadLocal CALENDAR_LOCAL = new ThreadLocal() {

        protected volatile Object initialValue()
        {
            return initialValue();
        }

        protected Calendar initialValue()
        {
            return Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        }

    };
    private static final String TAG = com/amazon/gallery/framework/data/model/TimelineUtils.getName();

    public TimelineUtils()
    {
    }

    private static int getFormattedTimeFromMs(long l)
    {
        if (l != 0L)
        {
            Calendar calendar = (Calendar)CALENDAR_LOCAL.get();
            calendar.setTimeInMillis(l);
            return calendar.get(1) * 100 + calendar.get(2) + 1;
        } else
        {
            return 0;
        }
    }

    public static int getTimelineDateCreated(MediaItem mediaitem)
    {
        return getFormattedTimeFromMs(mediaitem.getDateCreatedMs());
    }

    public static TimelineEntry getTimelineEntry(int i, int j)
    {
        if (i <= 0)
        {
            return new TimelineEntryImpl(j);
        }
        int k = i / 100;
        int l = i % 100 - 1;
        if (k > 0 && l >= 0 && l < TimelineMonthResources.MONTHS_ABBR.length)
        {
            return new TimelineEntryImpl(k, l, j);
        } else
        {
            GLogger.errorStackTrace(TAG, "Can't parse date %s", new Object[] {
                Integer.valueOf(i)
            });
            return new TimelineEntryImpl(j);
        }
    }

    public static int getTimelineTimestamp(MediaItem mediaitem)
    {
        return getFormattedTimeFromMs(mediaitem.getTimestampMs());
    }

}
