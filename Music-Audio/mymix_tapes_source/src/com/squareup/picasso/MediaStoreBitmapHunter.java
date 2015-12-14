// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.picasso;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import java.io.IOException;

// Referenced classes of package com.squareup.picasso:
//            ContentStreamBitmapHunter, Request, Picasso, Dispatcher, 
//            Cache, Stats, Action

class MediaStoreBitmapHunter extends ContentStreamBitmapHunter
{
    static final class PicassoKind extends Enum
    {

        private static final PicassoKind $VALUES[];
        public static final PicassoKind FULL;
        public static final PicassoKind MICRO;
        public static final PicassoKind MINI;
        final int androidKind;
        final int height;
        final int width;

        public static PicassoKind valueOf(String s)
        {
            return (PicassoKind)Enum.valueOf(com/squareup/picasso/MediaStoreBitmapHunter$PicassoKind, s);
        }

        public static PicassoKind[] values()
        {
            return (PicassoKind[])$VALUES.clone();
        }

        static 
        {
            MICRO = new PicassoKind("MICRO", 0, 3, 96, 96);
            MINI = new PicassoKind("MINI", 1, 1, 512, 384);
            FULL = new PicassoKind("FULL", 2, 2, -1, -1);
            $VALUES = (new PicassoKind[] {
                MICRO, MINI, FULL
            });
        }

        private PicassoKind(String s, int i, int j, int k, int l)
        {
            super(s, i);
            androidKind = j;
            width = k;
            height = l;
        }
    }


    private static final String CONTENT_ORIENTATION[] = {
        "orientation"
    };

    MediaStoreBitmapHunter(Context context, Picasso picasso, Dispatcher dispatcher, Cache cache, Stats stats, Action action)
    {
        super(context, picasso, dispatcher, cache, stats, action);
    }

    static int getExifOrientation(ContentResolver contentresolver, Uri uri)
    {
        ContentResolver contentresolver2;
        contentresolver2 = null;
        ContentResolver contentresolver1 = null;
        int i;
        int j;
        boolean flag;
        try
        {
            contentresolver = contentresolver.query(uri, CONTENT_ORIENTATION, null, null, null);
        }
        // Misplaced declaration of an exception variable
        catch (ContentResolver contentresolver)
        {
            if (contentresolver1 != null)
            {
                contentresolver1.close();
            }
            return 0;
        }
        finally
        {
            if (contentresolver2 == null) goto _L0; else goto _L0
        }
        if (contentresolver == null) goto _L2; else goto _L1
_L1:
        contentresolver1 = contentresolver;
        contentresolver2 = contentresolver;
        flag = contentresolver.moveToFirst();
        if (flag) goto _L3; else goto _L2
_L2:
        if (contentresolver != null)
        {
            contentresolver.close();
        }
        i = 0;
_L5:
        return i;
_L3:
        contentresolver1 = contentresolver;
        contentresolver2 = contentresolver;
        j = contentresolver.getInt(0);
        i = j;
        if (contentresolver == null) goto _L5; else goto _L4
_L4:
        contentresolver.close();
        return j;
        contentresolver2.close();
        throw contentresolver;
    }

    static PicassoKind getPicassoKind(int i, int j)
    {
        if (i <= PicassoKind.MICRO.width && j <= PicassoKind.MICRO.height)
        {
            return PicassoKind.MICRO;
        }
        if (i <= PicassoKind.MINI.width && j <= PicassoKind.MINI.height)
        {
            return PicassoKind.MINI;
        } else
        {
            return PicassoKind.FULL;
        }
    }

    Bitmap decode(Request request)
        throws IOException
    {
        Object obj;
        Object obj1;
        boolean flag;
        obj = context.getContentResolver();
        setExifRotation(getExifOrientation(((ContentResolver) (obj)), request.uri));
        obj1 = ((ContentResolver) (obj)).getType(request.uri);
        if (obj1 != null && ((String) (obj1)).startsWith("video/"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!request.hasSize()) goto _L2; else goto _L1
_L1:
        obj1 = getPicassoKind(request.targetWidth, request.targetHeight);
        if (flag || obj1 != PicassoKind.FULL) goto _L4; else goto _L3
_L3:
        obj1 = super.decode(request);
_L5:
        return ((Bitmap) (obj1));
_L4:
        long l = ContentUris.parseId(request.uri);
        android.graphics.BitmapFactory.Options options = createBitmapOptions(request);
        options.inJustDecodeBounds = true;
        calculateInSampleSize(request.targetWidth, request.targetHeight, ((PicassoKind) (obj1)).width, ((PicassoKind) (obj1)).height, options);
        if (flag)
        {
            int i;
            if (obj1 == PicassoKind.FULL)
            {
                i = 1;
            } else
            {
                i = ((PicassoKind) (obj1)).androidKind;
            }
            obj = android.provider.MediaStore.Video.Thumbnails.getThumbnail(((ContentResolver) (obj)), l, i, options);
        } else
        {
            obj = android.provider.MediaStore.Images.Thumbnails.getThumbnail(((ContentResolver) (obj)), l, ((PicassoKind) (obj1)).androidKind, options);
        }
        obj1 = obj;
        if (obj != null) goto _L5; else goto _L2
_L2:
        return super.decode(request);
    }

}
