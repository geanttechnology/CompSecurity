// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.picasso;

import android.graphics.Bitmap;
import android.net.NetworkInfo;
import java.io.IOException;

// Referenced classes of package it.sephiroth.android.library.picasso:
//            Request

public abstract class RequestHandler
{
    public static final class Result
    {

        private final Bitmap bitmap;
        private final int exifOrientation;
        private final Picasso.LoadedFrom loadedFrom;

        public Bitmap getBitmap()
        {
            return bitmap;
        }

        int getExifOrientation()
        {
            return exifOrientation;
        }

        public Picasso.LoadedFrom getLoadedFrom()
        {
            return loadedFrom;
        }

        public Result(Bitmap bitmap1, Picasso.LoadedFrom loadedfrom)
        {
            this(bitmap1, loadedfrom, 0);
        }

        Result(Bitmap bitmap1, Picasso.LoadedFrom loadedfrom, int i)
        {
            bitmap = bitmap1;
            loadedFrom = loadedfrom;
            exifOrientation = i;
        }
    }


    public RequestHandler()
    {
    }

    static void calculateInSampleSize(int i, int j, int k, int l, android.graphics.BitmapFactory.Options options, Request request)
    {
label0:
        {
            boolean flag = true;
            int i1 = i;
            int j1 = j;
            if (request.resizeByMaxSide)
            {
                if (k >= l)
                {
                    j1 = i;
                    i1 = i;
                } else
                {
                    i1 = j;
                    j1 = j;
                }
            }
            if (l <= j1)
            {
                i = ((flag) ? 1 : 0);
                if (k <= i1)
                {
                    break label0;
                }
            }
            i = (int)Math.floor((float)l / (float)j1);
            j = (int)Math.floor((float)k / (float)i1);
            if (request.centerInside)
            {
                i = Math.max(i, j);
            } else
            {
                i = Math.min(i, j);
            }
        }
        options.inSampleSize = i;
        options.inJustDecodeBounds = false;
    }

    static void calculateInSampleSize(int i, int j, android.graphics.BitmapFactory.Options options, Request request)
    {
        calculateInSampleSize(i, j, options.outWidth, options.outHeight, options, request);
    }

    static android.graphics.BitmapFactory.Options createBitmapOptions(Request request)
    {
        boolean flag1 = request.hasSize();
        android.graphics.BitmapFactory.Options options;
        boolean flag;
        if (request.config != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        options = null;
        if (flag1 || flag)
        {
            android.graphics.BitmapFactory.Options options1 = new android.graphics.BitmapFactory.Options();
            options1.inJustDecodeBounds = flag1;
            options = options1;
            if (flag)
            {
                options1.inPreferredConfig = request.config;
                options = options1;
            }
        }
        return options;
    }

    static boolean requiresInSampleSize(android.graphics.BitmapFactory.Options options)
    {
        return options != null && options.inJustDecodeBounds;
    }

    public abstract boolean canHandleRequest(Request request);

    int getRetryCount()
    {
        return 0;
    }

    public abstract Result load(Request request)
        throws IOException;

    boolean shouldRetry(boolean flag, NetworkInfo networkinfo)
    {
        return false;
    }

    boolean supportsReplay()
    {
        return false;
    }
}
