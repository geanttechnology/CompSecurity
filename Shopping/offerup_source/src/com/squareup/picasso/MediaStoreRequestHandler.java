// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.picasso;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

// Referenced classes of package com.squareup.picasso:
//            ContentStreamRequestHandler, Request

class MediaStoreRequestHandler extends ContentStreamRequestHandler
{

    private static final String CONTENT_ORIENTATION[] = {
        "orientation"
    };

    MediaStoreRequestHandler(Context context)
    {
        super(context);
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

    public boolean canHandleRequest(Request request)
    {
        request = request.uri;
        return "content".equals(request.getScheme()) && "media".equals(request.getAuthority());
    }

    public RequestHandler.Result load(Request request)
    {
        boolean flag1 = true;
        Object obj = context.getContentResolver();
        int j = getExifOrientation(((ContentResolver) (obj)), request.uri);
        String s = ((ContentResolver) (obj)).getType(request.uri);
        boolean flag;
        if (s != null && s.startsWith("video/"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (request.hasSize())
        {
            PicassoKind picassokind = getPicassoKind(request.targetWidth, request.targetHeight);
            if (!flag && picassokind == PicassoKind.FULL)
            {
                return new RequestHandler.Result(decodeContentStream(request), Picasso.LoadedFrom.DISK, j);
            }
            long l = ContentUris.parseId(request.uri);
            android.graphics.BitmapFactory.Options options = createBitmapOptions(request);
            options.inJustDecodeBounds = true;
            calculateInSampleSize(request.targetWidth, request.targetHeight, picassokind.width, picassokind.height, options, request);
            if (flag)
            {
                int i;
                if (picassokind == PicassoKind.FULL)
                {
                    i = ((flag1) ? 1 : 0);
                } else
                {
                    i = picassokind.androidKind;
                }
                obj = android.provider.MediaStore.Video.Thumbnails.getThumbnail(((ContentResolver) (obj)), l, i, options);
            } else
            {
                obj = android.provider.MediaStore.Images.Thumbnails.getThumbnail(((ContentResolver) (obj)), l, picassokind.androidKind, options);
            }
            if (obj != null)
            {
                return new RequestHandler.Result(((android.graphics.Bitmap) (obj)), Picasso.LoadedFrom.DISK, j);
            }
        }
        return new RequestHandler.Result(decodeContentStream(request), Picasso.LoadedFrom.DISK, j);
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
            return (PicassoKind)Enum.valueOf(com/squareup/picasso/MediaStoreRequestHandler$PicassoKind, s);
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
