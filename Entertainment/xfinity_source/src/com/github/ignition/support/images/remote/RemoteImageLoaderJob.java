// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.github.ignition.support.images.remote;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import com.github.ignition.support.cache.AbstractImageCache;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import java.io.IOException;

// Referenced classes of package com.github.ignition.support.images.remote:
//            RemoteImageLoader

public class RemoteImageLoaderJob
    implements Runnable
{

    private final AbstractImageCache imageCache;
    private final Request imageRequest;
    private final String imageUrl;
    private final int numRetries;
    private final OkHttpClient ohHttpClient = new OkHttpClient();
    private final RemoteImageLoader remoteImageLoader;

    public RemoteImageLoaderJob(String s, RemoteImageLoader remoteimageloader, AbstractImageCache abstractimagecache, int i)
    {
        imageUrl = s;
        remoteImageLoader = remoteimageloader;
        imageCache = abstractimagecache;
        numRetries = i;
        imageRequest = (new com.squareup.okhttp.Request.Builder()).url(s).build();
    }

    protected Bitmap downloadImage()
    {
        int i = 1;
_L2:
        if (i > numRetries)
        {
            break; /* Loop/switch isn't completed */
        }
        byte abyte0[] = retrieveImageData();
        if (abyte0 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        Object obj;
        if (imageCache == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        imageCache.put(imageUrl, abyte0);
        obj = imageCache.get(imageUrl);
        obj = imageCache.decodeToBitmap(obj);
        return ((Bitmap) (obj));
        Throwable throwable;
        throwable;
        Log.w("Ignition/ImageLoader", (new StringBuilder()).append("download for ").append(imageUrl).append(" failed (attempt ").append(i).append(")").toString(), throwable);
        SystemClock.sleep(1000L);
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        return null;
    }

    protected void notifyImageLoaded(String s, Bitmap bitmap)
    {
        Bundle bundle = new Bundle();
        bundle.putString("ign:extra_image_url", s);
        bundle.putParcelable("ign:extra_bitmap", bitmap);
        remoteImageLoader.notifyAndCleanupHandlers(s, bundle);
    }

    protected byte[] retrieveImageData()
        throws IOException
    {
        Response response = ohHttpClient.newCall(imageRequest).execute();
        int i = response.code();
        if (i >= 300)
        {
            response.body().close();
            throw new IOException((new StringBuilder()).append("Ignition IOException on: ").append(imageUrl).append("\nGot: ").append(i).append(" ").append(response.message()).toString());
        } else
        {
            return response.body().bytes();
        }
    }

    public void run()
    {
        Bitmap bitmap;
        Bitmap bitmap1;
        Object obj;
        obj = null;
        bitmap = null;
        bitmap1 = obj;
        if (imageCache == null)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        bitmap1 = obj;
        bitmap = imageCache.getBitmap(imageUrl);
        bitmap1 = bitmap;
        if (bitmap != null)
        {
            break MISSING_BLOCK_LABEL_42;
        }
        bitmap1 = bitmap;
        bitmap = downloadImage();
        bitmap1 = bitmap;
        notifyImageLoaded(imageUrl, bitmap1);
        return;
        Exception exception;
        exception;
        notifyImageLoaded(imageUrl, bitmap1);
        throw exception;
    }
}
