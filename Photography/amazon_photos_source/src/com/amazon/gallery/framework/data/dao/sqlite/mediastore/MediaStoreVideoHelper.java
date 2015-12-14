// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite.mediastore;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.data.dao.sqlite.mediaitem.VideoMediaItemDateParser;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.MediaItemUtil;
import com.amazon.gallery.framework.model.media.MediaType;
import com.amazon.gallery.framework.model.media.Video;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite.mediastore:
//            AbstractMediaStoreHelper, MediaStoreHelper, GalleryMetadataRetriever

public class MediaStoreVideoHelper extends AbstractMediaStoreHelper
    implements MediaStoreHelper
{

    private static final String TAG = com/amazon/gallery/framework/data/dao/sqlite/mediastore/MediaStoreVideoHelper.getName();
    static final Uri mediaStoreUri;

    public MediaStoreVideoHelper()
    {
        mediaItemDateParser = new VideoMediaItemDateParser();
    }

    public Uri addEditedImageToMediaStore(Context context, Uri uri, File file)
    {
        return null;
    }

    public Uri addImageToMediaStore(Context context, File file, String s, int i, int j, long l, 
            String s1, int k)
    {
        return null;
    }

    public Uri addVideoToMediaStore(Context context, File file, String s, int i, int j, long l, 
            String s1, long l1)
    {
        Cursor cursor;
        Object obj;
        obj = file.getAbsolutePath();
        cursor = null;
        obj = context.getContentResolver().query(android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI, new String[] {
            "_id", "bucket_display_name", "bucket_id"
        }, "_data = ? ", new String[] {
            obj
        }, null);
        cursor = ((Cursor) (obj));
        long l2 = System.currentTimeMillis();
        cursor = ((Cursor) (obj));
        ContentValues contentvalues = new ContentValues();
        cursor = ((Cursor) (obj));
        contentvalues.put("title", file.getName());
        cursor = ((Cursor) (obj));
        contentvalues.put("_display_name", s);
        cursor = ((Cursor) (obj));
        contentvalues.put("datetaken", Long.valueOf(l));
        cursor = ((Cursor) (obj));
        contentvalues.put("date_modified", Long.valueOf(l));
        cursor = ((Cursor) (obj));
        contentvalues.put("date_added", Long.valueOf(l2));
        cursor = ((Cursor) (obj));
        contentvalues.put("mime_type", s1);
        cursor = ((Cursor) (obj));
        contentvalues.put("duration", Long.valueOf(l1));
        cursor = ((Cursor) (obj));
        contentvalues.put("_data", file.getAbsolutePath());
        cursor = ((Cursor) (obj));
        contentvalues.put("_size", Long.valueOf(file.length()));
        cursor = ((Cursor) (obj));
        contentvalues.put("width", Integer.valueOf(i));
        cursor = ((Cursor) (obj));
        contentvalues.put("height", Integer.valueOf(j));
        cursor = ((Cursor) (obj));
        if (((Cursor) (obj)).getCount() == 0) goto _L2; else goto _L1
_L1:
        cursor = ((Cursor) (obj));
        if (!((Cursor) (obj)).moveToFirst()) goto _L2; else goto _L3
_L3:
        cursor = ((Cursor) (obj));
        l = ((Cursor) (obj)).getLong(((Cursor) (obj)).getColumnIndex("_id"));
        cursor = ((Cursor) (obj));
        context.getContentResolver().update(android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI, contentvalues, (new StringBuilder()).append("_data = '").append(file.getAbsolutePath()).append("'").toString(), null);
        cursor = ((Cursor) (obj));
        context = ContentUris.withAppendedId(android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI, l);
_L5:
        if (obj != null && !((Cursor) (obj)).isClosed())
        {
            ((Cursor) (obj)).close();
        }
        return context;
_L2:
        cursor = ((Cursor) (obj));
        s = context.getContentResolver().insert(android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI, contentvalues);
        cursor = ((Cursor) (obj));
        ((Cursor) (obj)).close();
        cursor = ((Cursor) (obj));
        file = file.getAbsolutePath();
        cursor = ((Cursor) (obj));
        obj = context.getContentResolver().query(android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI, new String[] {
            "bucket_id"
        }, "_data = ? ", new String[] {
            file
        }, null);
        context = s;
        if (true) goto _L5; else goto _L4
_L4:
        context;
        if (cursor != null && !cursor.isClosed())
        {
            cursor.close();
        }
        throw context;
    }

    public MediaItem createMediaItemFromMediaStoreUri(Uri uri)
    {
        if (uri != null && "media".equals(uri.getAuthority())) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        Object obj;
        Cursor cursor;
        obj = null;
        String as[] = getProjectedColumns(new ArrayList(Arrays.asList(new String[] {
            "_id", "_data", "date_added", "date_modified", "duration", "bucket_id", "bucket_display_name", "mime_type"
        })));
        cursor = context.getContentResolver().query(uri, as, null, null, null);
        if (cursor == null) goto _L1; else goto _L3
_L3:
        uri = obj;
        if (cursor.moveToFirst())
        {
            uri = mediaItemFromCursor(cursor);
        }
        cursor.close();
        return uri;
        uri;
        cursor.close();
        throw uri;
    }

    protected Uri getMediaStoreUri()
    {
        return mediaStoreUri;
    }

    protected List getStandardMediaItemColumns()
    {
        return new ArrayList(Arrays.asList(new String[] {
            "_id", "_data", "date_added", "date_modified", "datetaken", "duration"
        }));
    }

    protected MediaItem mediaItemFromCursor(Cursor cursor)
    {
        Object obj;
        Object obj1;
        String s;
        Video video;
        boolean flag;
        int j;
        int k;
        int i1;
        int j1;
        long l2;
        int i = cursor.getColumnIndex("duration");
        j = cursor.getColumnIndexOrThrow("_data");
        j1 = cursor.getColumnIndex("width");
        i1 = cursor.getColumnIndex("height");
        l2 = cursor.getInt(i);
        s = cursor.getString(j);
        i = 0;
        boolean flag1 = false;
        j = ((flag1) ? 1 : 0);
        k = i;
        if (j1 != -1)
        {
            j = ((flag1) ? 1 : 0);
            k = i;
            if (i1 != -1)
            {
                k = cursor.getInt(j1);
                j = cursor.getInt(i1);
            }
        }
        video = (Video)mediaItemDao.create(MediaType.VIDEO);
        i1 = 0;
        j1 = 0;
        flag = false;
        obj = null;
        obj1 = null;
        GalleryMetadataRetriever gallerymetadataretriever = new GalleryMetadataRetriever(s);
        if (k == 0) goto _L2; else goto _L1
_L1:
        int l = j;
        if (j != 0) goto _L3; else goto _L2
_L2:
        i1 = j1;
        obj = gallerymetadataretriever.extractMetadata(18);
        if (obj != null) goto _L5; else goto _L4
_L4:
        j = -1;
_L6:
        i1 = j1;
        obj = gallerymetadataretriever.extractMetadata(19);
        break MISSING_BLOCK_LABEL_199;
_L3:
        i1 = ((flag) ? 1 : 0);
        obj = gallerymetadataretriever.extractMetadata(24);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_239;
        }
        i1 = ((flag) ? 1 : 0);
        video.setOrientation(Integer.parseInt(((String) (obj))));
        l1 = l2;
        if (l2 != 0L)
        {
            break MISSING_BLOCK_LABEL_286;
        }
        i1 = ((flag) ? 1 : 0);
        obj = gallerymetadataretriever.extractMetadata(9);
        l1 = l2;
        i1 = ((flag) ? 1 : 0);
        if (!StringUtils.isNotEmpty(((CharSequence) (obj))))
        {
            break MISSING_BLOCK_LABEL_286;
        }
        i1 = ((flag) ? 1 : 0);
        l1 = Long.parseLong(((String) (obj)));
        if (gallerymetadataretriever != null)
        {
            gallerymetadataretriever.release();
        }
_L7:
        video.setWidth(k);
        video.setHeight(l);
        if (flag)
        {
            MediaItemUtil.adjustDimentionsForOrientation(video);
        }
        video.setDuration(l1);
        setMetadata(cursor, video, s, mediaStoreUri);
        return video;
_L5:
        i1 = j1;
        j = Integer.valueOf(((String) (obj))).intValue();
          goto _L6
        long l1;
        if (obj == null)
        {
            l = -1;
            break MISSING_BLOCK_LABEL_472;
        }
        i1 = j1;
        try
        {
            l = Integer.valueOf(((String) (obj))).intValue();
            break MISSING_BLOCK_LABEL_472;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1) { }
        finally
        {
            obj = gallerymetadataretriever;
        }
        break MISSING_BLOCK_LABEL_385;
        obj;
        gallerymetadataretriever = ((GalleryMetadataRetriever) (obj1));
        obj1 = obj;
_L8:
        obj = gallerymetadataretriever;
        GLogger.wx(TAG, "extract local video information failed", ((Throwable) (obj1)));
        j = -1;
        j1 = -1;
        l1 = l2;
        l = j1;
        flag = i1;
        k = j;
        if (gallerymetadataretriever != null)
        {
            gallerymetadataretriever.release();
            l1 = l2;
            l = j1;
            flag = i1;
            k = j;
        }
          goto _L7
        cursor;
_L9:
        if (obj != null)
        {
            ((GalleryMetadataRetriever) (obj)).release();
        }
        throw cursor;
        if (true) goto _L9; else goto _L8
        flag = true;
        k = j;
          goto _L3
    }

    static 
    {
        mediaStoreUri = android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
    }
}
