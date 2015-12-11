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

// Referenced classes of package com.squareup.picasso:
//            ContentStreamBitmapHunter, Request, Picasso, Dispatcher, 
//            Cache, Stats, Action

class MediaStoreBitmapHunter extends ContentStreamBitmapHunter
{

    private static final String CONTENT_ORIENTATION[] = {
        "orientation"
    };

    MediaStoreBitmapHunter(Context context, Picasso picasso, Dispatcher dispatcher, Cache cache, Stats stats, Action action)
    {
        super(context, picasso, dispatcher, cache, stats, action);
    }

    static int getExifOrientation(ContentResolver contentresolver, Uri uri)
    {
        contentresolver = contentresolver.query(uri, CONTENT_ORIENTATION, null, null, null);
        if (contentresolver == null) goto _L2; else goto _L1
_L1:
        boolean flag = contentresolver.moveToFirst();
        if (flag) goto _L3; else goto _L2
_L2:
        int i;
        if (contentresolver != null)
        {
            contentresolver.close();
        }
        i = 0;
_L5:
        return i;
_L3:
        int j = contentresolver.getInt(0);
        i = j;
        if (contentresolver == null) goto _L5; else goto _L4
_L4:
        contentresolver.close();
        return j;
        contentresolver;
        contentresolver = null;
_L9:
        if (contentresolver != null)
        {
            contentresolver.close();
        }
        return 0;
        uri;
        contentresolver = null;
_L7:
        if (contentresolver != null)
        {
            contentresolver.close();
        }
        throw uri;
        uri;
        if (true) goto _L7; else goto _L6
_L6:
        uri;
        if (true) goto _L9; else goto _L8
_L8:
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
    {
        Object obj;
        Object obj1;
        boolean flag;
        boolean flag1;
        flag1 = true;
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
                i = ((flag1) ? 1 : 0);
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


    private class PicassoKind extends Enum
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

}
