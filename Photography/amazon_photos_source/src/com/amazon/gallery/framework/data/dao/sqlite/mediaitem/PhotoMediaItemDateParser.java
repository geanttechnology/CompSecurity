// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite.mediaitem;

import android.database.Cursor;
import com.amazon.gallery.foundation.utils.date.DateUtils;
import com.amazon.gallery.framework.model.media.MediaItem;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite.mediaitem:
//            MediaItemDateParser

public class PhotoMediaItemDateParser
    implements MediaItemDateParser
{

    public PhotoMediaItemDateParser()
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
        long l = 0L;
        if (j != -1)
        {
            l = cursor.getLong(j);
        }
        if (l != 0L)
        {
            l = DateUtils.applyCurrentTimeZone(l);
        } else
        {
            l = cursor.getLong(i) * 1000L;
        }
        mediaitem.setDateCreatedMs(l);
        mediaitem.setDateCreatedUTCMs(l);
    }
}
