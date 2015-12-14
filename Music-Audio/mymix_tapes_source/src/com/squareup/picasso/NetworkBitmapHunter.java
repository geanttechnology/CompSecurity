// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.NetworkInfo;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.squareup.picasso:
//            BitmapHunter, MarkableInputStream, Utils, Request, 
//            Downloader, Stats, Picasso, Dispatcher, 
//            Cache, Action

class NetworkBitmapHunter extends BitmapHunter
{

    static final int DEFAULT_RETRY_COUNT = 2;
    private static final int MARKER = 0x10000;
    private final Downloader downloader;
    int retryCount;

    public NetworkBitmapHunter(Picasso picasso, Dispatcher dispatcher, Cache cache, Stats stats, Action action, Downloader downloader1)
    {
        super(picasso, dispatcher, cache, stats, action);
        downloader = downloader1;
        retryCount = 2;
    }

    private Bitmap decodeStream(InputStream inputstream, Request request)
        throws IOException
    {
        InputStream inputstream1 = new MarkableInputStream(inputstream);
        long l = inputstream1.savePosition(0x10000);
        inputstream = createBitmapOptions(request);
        boolean flag = requiresInSampleSize(inputstream);
        boolean flag1 = Utils.isWebPFile(inputstream1);
        inputstream1.reset(l);
        if (flag1)
        {
            inputstream1 = Utils.toByteArray(inputstream1);
            if (flag)
            {
                BitmapFactory.decodeByteArray(inputstream1, 0, inputstream1.length, inputstream);
                calculateInSampleSize(request.targetWidth, request.targetHeight, inputstream);
            }
            inputstream = BitmapFactory.decodeByteArray(inputstream1, 0, inputstream1.length, inputstream);
        } else
        {
            if (flag)
            {
                BitmapFactory.decodeStream(inputstream1, null, inputstream);
                calculateInSampleSize(request.targetWidth, request.targetHeight, inputstream);
                inputstream1.reset(l);
            }
            request = BitmapFactory.decodeStream(inputstream1, null, inputstream);
            inputstream = request;
            if (request == null)
            {
                throw new IOException("Failed to decode stream.");
            }
        }
        return inputstream;
    }

    Bitmap decode(Request request)
        throws IOException
    {
        Object obj;
        Downloader.Response response;
        boolean flag;
        if (retryCount == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        response = downloader.load(request.uri, flag);
        if (response != null) goto _L2; else goto _L1
_L1:
        obj = null;
_L4:
        return ((Bitmap) (obj));
_L2:
        Bitmap bitmap;
        if (response.cached)
        {
            obj = Picasso.LoadedFrom.DISK;
        } else
        {
            obj = Picasso.LoadedFrom.NETWORK;
        }
        loadedFrom = ((Picasso.LoadedFrom) (obj));
        bitmap = response.getBitmap();
        obj = bitmap;
        if (bitmap != null) goto _L4; else goto _L3
_L3:
        obj = response.getInputStream();
        if (obj == null)
        {
            return null;
        }
        if (response.getContentLength() == 0L)
        {
            Utils.closeQuietly(((InputStream) (obj)));
            throw new IOException("Received response with 0 content-length header.");
        }
        if (loadedFrom == Picasso.LoadedFrom.NETWORK && response.getContentLength() > 0L)
        {
            stats.dispatchDownloadFinished(response.getContentLength());
        }
        request = decodeStream(((InputStream) (obj)), request);
        Utils.closeQuietly(((InputStream) (obj)));
        return request;
        request;
        Utils.closeQuietly(((InputStream) (obj)));
        throw request;
    }

    boolean shouldRetry(boolean flag, NetworkInfo networkinfo)
    {
        boolean flag1;
        if (retryCount > 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag1)
        {
            retryCount = retryCount - 1;
            if (networkinfo == null || networkinfo.isConnected())
            {
                return true;
            }
        }
        return false;
    }

    boolean supportsReplay()
    {
        return true;
    }
}
