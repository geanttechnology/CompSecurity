// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite.mediaitem;

import android.database.Cursor;
import com.amazon.gallery.foundation.utils.date.DateUtils;
import com.amazon.gallery.framework.model.media.MediaItem;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite.mediaitem:
//            MediaItemDateParser

public class DefaultMediaItemDateParser
    implements MediaItemDateParser
{

    public DefaultMediaItemDateParser()
    {
    }

    public void setDateCreated(Cursor cursor, MediaItem mediaitem)
    {
        int j = cursor.getColumnIndex("date_modified");
        int i = j;
        if (j == -1)
        {
            i = cursor.getColumnIndexOrThrow("date_added");
        }
        j = cursor.getColumnIndex("datetaken");
        long l1 = 0L;
        long l = 0L;
        if (j != -1)
        {
            l1 = cursor.getLong(j);
            l = l1;
        }
        if (l1 != 0L)
        {
            long l2 = DateUtils.applyCurrentTimeZone(l1);
            l1 = l;
            l = l2;
        } else
        {
            l = cursor.getLong(i) * 1000L;
            l1 = l;
        }
        mediaitem.setDateCreatedMs(l);
        mediaitem.setDateCreatedUTCMs(l1);
    }
}
