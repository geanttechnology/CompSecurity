// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite.mediastore;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import com.amazon.gallery.foundation.image.BitmapDecoder;
import com.amazon.gallery.foundation.utils.file.ExifUtils;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.data.dao.sqlite.mediaitem.PhotoMediaItemDateParser;
import com.amazon.gallery.framework.data.store.LenticularHelper;
import com.amazon.gallery.framework.data.store.RewindHelper;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.media.GroupType;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.MediaItemUtil;
import com.amazon.gallery.framework.model.media.MediaType;
import com.amazon.gallery.framework.model.media.OrderedGroupPhoto;
import com.amazon.gallery.framework.model.media.RewindPhoto;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite.mediastore:
//            AbstractMediaStoreHelper, MediaStoreHelper

public class MediaStoreImageHelper extends AbstractMediaStoreHelper
    implements MediaStoreHelper
{

    private static final String TAG = com/amazon/gallery/framework/data/dao/sqlite/mediastore/MediaStoreImageHelper.getName();
    static final Uri mediaStoreUri;
    private boolean lenticularEnabled;
    private LenticularHelper lenticularHelper;
    private boolean rewindPhotosEnabled;

    public MediaStoreImageHelper()
    {
        lenticularEnabled = false;
        rewindPhotosEnabled = false;
        mediaItemDateParser = new PhotoMediaItemDateParser();
    }

    public Uri addEditedImageToMediaStore(Context context, Uri uri, File file)
    {
        Object obj;
        long l;
        l = Calendar.getInstance().getTimeInMillis();
        obj = null;
        uri = context.getContentResolver().query(uri, new String[] {
            "datetaken"
        }, null, null, null);
        obj = uri;
        if (!uri.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_63;
        }
        obj = uri;
        l = uri.getLong(uri.getColumnIndex("datetaken"));
        if (uri != null && !uri.isClosed())
        {
            uri.close();
        }
        String s = file.getName();
        int i;
        int j;
        try
        {
            uri = BitmapDecoder.getBitmapDimensions(file.getAbsolutePath());
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            GLogger.ex(TAG, "File not found while loading bitmap dimensions.", context);
            return null;
        }
        i = ((android.graphics.BitmapFactory.Options) (uri)).outWidth;
        j = ((android.graphics.BitmapFactory.Options) (uri)).outHeight;
        obj = ((android.graphics.BitmapFactory.Options) (uri)).outMimeType;
        uri = ((Uri) (obj));
        if (obj == null)
        {
            uri = "image/jpeg";
        }
        return addImageToMediaStore(context, file, s, i, j, l, uri, 0);
        context;
        if (obj != null && !((Cursor) (obj)).isClosed())
        {
            ((Cursor) (obj)).close();
        }
        throw context;
    }

    public Uri addImageToMediaStore(Context context, File file, String s, int i, int j, long l, 
            String s1, int k)
    {
        Cursor cursor;
        Object obj;
        obj = file.getAbsolutePath();
        cursor = null;
        obj = context.getContentResolver().query(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[] {
            "_id", "bucket_display_name", "bucket_id"
        }, "_data = ? ", new String[] {
            obj
        }, null);
        cursor = ((Cursor) (obj));
        long l1 = System.currentTimeMillis();
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
        contentvalues.put("date_added", Long.valueOf(l1));
        cursor = ((Cursor) (obj));
        contentvalues.put("mime_type", s1);
        cursor = ((Cursor) (obj));
        contentvalues.put("orientation", Integer.valueOf(k));
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
        context.getContentResolver().update(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentvalues, (new StringBuilder()).append("_data = '").append(file.getAbsolutePath()).append("'").toString(), null);
        cursor = ((Cursor) (obj));
        context = ContentUris.withAppendedId(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, l);
_L5:
        if (obj != null && !((Cursor) (obj)).isClosed())
        {
            ((Cursor) (obj)).close();
        }
        return context;
_L2:
        cursor = ((Cursor) (obj));
        s = context.getContentResolver().insert(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentvalues);
        cursor = ((Cursor) (obj));
        ((Cursor) (obj)).close();
        cursor = ((Cursor) (obj));
        file = file.getAbsolutePath();
        cursor = ((Cursor) (obj));
        obj = context.getContentResolver().query(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[] {
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

    public Uri addVideoToMediaStore(Context context, File file, String s, int i, int j, long l, 
            String s1, long l1)
    {
        return null;
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
            "_id", "_data", "date_added", "date_modified", "orientation", "bucket_id", "bucket_display_name", "mime_type"
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

    public MediaStoreImageHelper enableLenticular(LenticularHelper lenticularhelper)
    {
        lenticularEnabled = true;
        lenticularHelper = lenticularhelper;
        return this;
    }

    public MediaStoreImageHelper enableRewindPhotos()
    {
        rewindPhotosEnabled = true;
        return this;
    }

    protected Uri getMediaStoreUri()
    {
        return mediaStoreUri;
    }

    protected List getStandardMediaItemColumns()
    {
        return new ArrayList(Arrays.asList(new String[] {
            "_id", "_data", "date_added", "date_modified", "datetaken", "orientation"
        }));
    }

    protected MediaItem mediaItemFromCursor(Cursor cursor)
    {
        Object obj1;
        String s;
        ObjectID objectid;
        File file;
        int j;
        int k;
        int l;
        long l1;
label0:
        {
            j = cursor.getColumnIndexOrThrow("_id");
            k = cursor.getColumnIndex("orientation");
            int i = cursor.getColumnIndexOrThrow("_data");
            int j1 = cursor.getColumnIndex("width");
            int i1 = cursor.getColumnIndex("height");
            l1 = cursor.getLong(j);
            l = cursor.getInt(k);
            s = cursor.getString(i);
            k = 0;
            boolean flag = false;
            i = ((flag) ? 1 : 0);
            j = k;
            if (j1 != -1)
            {
                i = ((flag) ? 1 : 0);
                j = k;
                if (i1 != -1)
                {
                    j = cursor.getInt(j1);
                    i = cursor.getInt(i1);
                }
            }
            file = new File(s);
            if (j != 0)
            {
                k = i;
                if (i != 0)
                {
                    break label0;
                }
            }
            android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(s, options);
            j = options.outWidth;
            k = options.outHeight;
        }
        obj1 = null;
        objectid = new ObjectID(0L, l1);
        if (!lenticularEnabled || !LenticularHelper.isLenticular(file)) goto _L2; else goto _L1
_L1:
        Object obj;
        obj1 = (OrderedGroupPhoto)mediaItemDao.create(MediaType.PHOTO, GroupType.LENTICULAR);
        List list = lenticularHelper.getFrames(objectid);
        obj = list;
        if (list == null)
        {
            obj = lenticularHelper.splitFrames(file, objectid);
        }
        ((OrderedGroupPhoto) (obj1)).setFrames(((List) (obj)));
        obj = obj1;
_L4:
        obj1 = obj;
        if (obj == null)
        {
            obj1 = mediaItemDao.create(MediaType.PHOTO);
        }
        ((MediaItem) (obj1)).setObjectId(objectid);
        ((MediaItem) (obj1)).setWidth(j);
        ((MediaItem) (obj1)).setHeight(k);
        ((MediaItem) (obj1)).setOrientation(l);
        setMetadata(cursor, ((MediaItem) (obj1)), s, mediaStoreUri);
        MediaItemUtil.adjustDimentionsForOrientation(((MediaItem) (obj1)));
        ExifUtils.pullExifFields(((MediaItem) (obj1)));
        return ((MediaItem) (obj1));
_L2:
        obj = obj1;
        if (rewindPhotosEnabled)
        {
            obj = obj1;
            if (RewindHelper.getInstance().isRewindPhoto(file))
            {
                MediaItem mediaitem = mediaItemDao.create(MediaType.PHOTO, GroupType.REWIND);
                RewindHelper.getInstance().setRewindMetadata((RewindPhoto)mediaitem, file);
                obj = obj1;
                if (((RewindPhoto)mediaitem).getFrames().size() > 1)
                {
                    obj = mediaitem;
                }
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    static 
    {
        mediaStoreUri = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
    }
}
