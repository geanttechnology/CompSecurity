// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite.mediaitem;

import android.database.Cursor;
import com.amazon.gallery.foundation.utils.date.DateUtils;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.dao.sqlite.mediastore.GalleryMetadataRetriever;
import com.amazon.gallery.framework.model.media.MediaItem;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite.mediaitem:
//            DefaultMediaItemDateParser

public class VideoMediaItemDateParser extends DefaultMediaItemDateParser
{

    private static final String TAG = com/amazon/gallery/framework/data/dao/sqlite/mediaitem/VideoMediaItemDateParser.getName();
    private static SimpleDateFormat defaultDateFormat;
    private static SimpleDateFormat samsungDateFormat;

    public VideoMediaItemDateParser()
    {
    }

    public static void setDateCreated(String s, MediaItem mediaitem)
    {
        long l;
        long l1;
        l = 0L;
        l1 = 0L;
        GLogger.i(TAG, "Parsing date: %s", new Object[] {
            s
        });
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_123;
        }
        if (s.equals("19040101T000000.000Z"))
        {
            break MISSING_BLOCK_LABEL_123;
        }
        if (s.length() != "yyyy MM dd".length()) goto _L2; else goto _L1
_L1:
        long l2 = samsungDateFormat.parse(s).getTime();
        l = l2;
_L3:
        l1 = l;
_L4:
        l2 = l;
        if (l != 0L)
        {
            l2 = DateUtils.applyCurrentTimeZone(l);
        }
        mediaitem.setDateCreatedMs(l2);
        mediaitem.setDateCreatedUTCMs(l1);
        return;
_L2:
        s = s.replace("Z", "+0000");
        l2 = defaultDateFormat.parse(s).getTime();
        l = l2;
          goto _L3
        try
        {
            GLogger.w(TAG, "No date metadata found.", new Object[0]);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            GLogger.wx(TAG, "Could not parse date", s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            GLogger.wx(TAG, "Could not set dateCreated for a video", s);
        }
          goto _L4
    }

    public void setDateCreated(Cursor cursor, MediaItem mediaitem)
    {
        Object obj;
        Object obj1;
        obj = null;
        obj1 = null;
        GalleryMetadataRetriever gallerymetadataretriever = new GalleryMetadataRetriever(mediaitem.getLocalPath());
        setDateCreated(gallerymetadataretriever.extractMetadata(5), mediaitem);
        if (gallerymetadataretriever == null)
        {
            break MISSING_BLOCK_LABEL_119;
        }
        gallerymetadataretriever.release();
_L2:
        return;
        obj;
        gallerymetadataretriever = ((GalleryMetadataRetriever) (obj1));
        obj1 = obj;
_L5:
        obj = gallerymetadataretriever;
        GLogger.wx(TAG, "extract local video information failed", ((Throwable) (obj1)));
        obj = gallerymetadataretriever;
        if (mediaitem.getDateCreatedMs() != 0L)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = gallerymetadataretriever;
        super.setDateCreated(cursor, mediaitem);
        if (gallerymetadataretriever == null) goto _L2; else goto _L1
_L1:
        gallerymetadataretriever.release();
        return;
        cursor;
_L4:
        if (obj != null)
        {
            ((GalleryMetadataRetriever) (obj)).release();
        }
        throw cursor;
        cursor;
        obj = gallerymetadataretriever;
        if (true) goto _L4; else goto _L3
_L3:
        obj1;
          goto _L5
    }

    static 
    {
        defaultDateFormat = new SimpleDateFormat("yyyyMMdd'T'HHmmss.SSSZ");
        samsungDateFormat = new SimpleDateFormat("yyyy MM dd");
        defaultDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        samsungDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    }
}
