// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.urbanairship.Logger;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

// Referenced classes of package com.urbanairship.util:
//            UAHttpStatusUtil

public class BitmapUtils
{

    private static final int BUFFER_SIZE = 1024;
    private static final int NETWORK_TIMEOUT_MS = 2000;

    public BitmapUtils()
    {
    }

    public static int calculateInSampleSize(int i, int j, int k, int l)
    {
        int i1 = 1;
        boolean flag = true;
        if (j > l || i > k)
        {
            j /= 2;
            int j1 = i / 2;
            i = ((flag) ? 1 : 0);
            do
            {
                i1 = i;
                if (j / i <= l)
                {
                    break;
                }
                i1 = i;
                if (j1 / i <= k)
                {
                    break;
                }
                i <<= 1;
            } while (true);
        }
        return i1;
    }

    private static boolean downloadFile(URL url, File file)
    {
        Object obj;
        obj = null;
        Logger.verbose((new StringBuilder("Downloading file from: ")).append(url).append(" to: ").append(file.getAbsolutePath()).toString());
        URLConnection urlconnection;
        urlconnection = url.openConnection();
        urlconnection.setConnectTimeout(2000);
        urlconnection.setUseCaches(true);
        url = urlconnection.getInputStream();
        if (!(urlconnection instanceof HttpURLConnection) || UAHttpStatusUtil.inSuccessRange(((HttpURLConnection)urlconnection).getResponseCode()))
        {
            break MISSING_BLOCK_LABEL_110;
        }
        Logger.warn((new StringBuilder("Unable to download file from URL. Received response code: ")).append(((HttpURLConnection)urlconnection).getResponseCode()).toString());
        if (url != null)
        {
            url.close();
        }
        return false;
        if (url == null) goto _L2; else goto _L1
_L1:
        file = new FileOutputStream(file);
        obj = new byte[1024];
_L5:
        int i = url.read(((byte []) (obj)));
        if (i == -1) goto _L4; else goto _L3
_L3:
        file.write(((byte []) (obj)), 0, i);
          goto _L5
        Exception exception;
        exception;
        obj = url;
        url = exception;
_L7:
        if (file != null)
        {
            file.close();
        }
        if (obj != null)
        {
            ((InputStream) (obj)).close();
        }
        throw url;
_L4:
        file.close();
        url.close();
        file.close();
        if (url != null)
        {
            url.close();
        }
        return true;
_L2:
        if (url != null)
        {
            url.close();
        }
        return false;
        url;
        file = null;
        continue; /* Loop/switch isn't completed */
        exception;
        file = null;
        obj = url;
        url = exception;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public static Bitmap fetchScaledBitmap(Context context, URL url, int i, int j)
    {
        Logger.verbose((new StringBuilder("BitmapUtils - Fetching image from: ")).append(url).toString());
        context = File.createTempFile("ua_", ".temp", context.getCacheDir());
        Logger.verbose((new StringBuilder("BitmapUtils - Created temp file: ")).append(context).toString());
        if (!downloadFile(url, context))
        {
            Logger.verbose((new StringBuilder("BitmapUtils - Failed to fetch image from: ")).append(url).toString());
            return null;
        }
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(context.getAbsolutePath(), options);
        int k = options.outWidth;
        int l = options.outHeight;
        options.inSampleSize = calculateInSampleSize(k, l, i, j);
        options.inJustDecodeBounds = false;
        Bitmap bitmap = BitmapFactory.decodeFile(context.getAbsolutePath(), options);
        if (context.delete())
        {
            Logger.verbose((new StringBuilder("BitmapUtils - Deleted temp file: ")).append(context).toString());
        } else
        {
            Logger.verbose((new StringBuilder("BitmapUtils - Failed to delete temp file: ")).append(context).toString());
        }
        Logger.debug(String.format("BitmapUtils - Fetched image from: %s. Original image size: %dx%d. Requested image size: %dx%d. Bitmap size: %dx%d. SampleSize: %d", new Object[] {
            url, Integer.valueOf(k), Integer.valueOf(l), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), Integer.valueOf(options.inSampleSize)
        }));
        return bitmap;
    }
}
