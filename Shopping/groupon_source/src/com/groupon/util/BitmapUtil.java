// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.URI;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.util:
//            IOUtils, RuntimeIOException

public class BitmapUtil
{

    protected static final int BITMAP_BOUNDS_READAHEAD_BUFFER_SIZE = 32768;

    private BitmapUtil()
    {
    }

    public Bitmap createBitmapFromStream(InputStream inputstream, URI uri, boolean flag, DisplayMetrics displaymetrics)
    {
        inputstream = new BufferedInputStream(inputstream, 32768);
        android.graphics.BitmapFactory.Options options;
        options = new android.graphics.BitmapFactory.Options();
        options.inPreferredConfig = android.graphics.Bitmap.Config.RGB_565;
        if (flag)
        {
            break MISSING_BLOCK_LABEL_154;
        }
        android.graphics.BitmapFactory.Options options1 = new android.graphics.BitmapFactory.Options();
        options1.inJustDecodeBounds = true;
        inputstream.mark(32768);
        BitmapFactory.decodeStream(inputstream, null, options1);
        inputstream.reset();
        int i = options1.outWidth;
        int j = options1.outHeight;
        options.inSampleSize = Math.max(1, Math.max(i / displaymetrics.widthPixels, j / displaymetrics.heightPixels));
        options1.inJustDecodeBounds = false;
        Ln.d("Bitmap %s original size: %sx%s, sample size (decodeBitmapOptions.inSampleSize): %s", new Object[] {
            uri, Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(options.inSampleSize)
        });
        uri = decodeBitmapStream(inputstream, options, uri);
        IOUtils.close(inputstream);
        return uri;
        uri;
        throw new RuntimeIOException(uri);
        uri;
        IOUtils.close(inputstream);
        throw uri;
        uri;
        throw new RuntimeException(uri);
    }

    public Bitmap createScaledBitmap(Bitmap bitmap, int i, int j)
    {
        BigDecimal bigdecimal = new BigDecimal(bitmap.getWidth());
        BigDecimal bigdecimal1 = new BigDecimal(bitmap.getHeight());
        float f = Math.max(bigdecimal.divide(bigdecimal1, 5, 3).floatValue(), bigdecimal1.divide(bigdecimal1, 5, 3).floatValue());
        bigdecimal1 = new BigDecimal(i);
        BigDecimal bigdecimal2 = new BigDecimal(j);
        if (bitmap.getWidth() > bitmap.getHeight() || bitmap.getWidth() == bitmap.getHeight())
        {
            bigdecimal = bigdecimal1;
        } else
        {
            bigdecimal = bigdecimal2.multiply(new BigDecimal(f));
        }
        if (bitmap.getWidth() > bitmap.getHeight() || bitmap.getWidth() == bitmap.getHeight())
        {
            bigdecimal1 = bigdecimal1.divide(new BigDecimal(f), 5, 3);
        } else
        {
            bigdecimal1 = bigdecimal2;
        }
        return Bitmap.createScaledBitmap(bitmap, bigdecimal.intValue(), bigdecimal1.intValue(), true);
    }

    public Bitmap decodeBitmapStream(InputStream inputstream, android.graphics.BitmapFactory.Options options, Object obj)
        throws IOException
    {
        Bitmap bitmap;
        try
        {
            bitmap = BitmapFactory.decodeStream(inputstream, null, options);
        }
        catch (OutOfMemoryError outofmemoryerror)
        {
            Ln.i(outofmemoryerror, "Out of memory decoding bitmap for %s [%sx%s px], will retry...", new Object[] {
                obj, Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight)
            });
            return BitmapFactory.decodeStream(inputstream, null, options);
        }
        return bitmap;
    }
}
