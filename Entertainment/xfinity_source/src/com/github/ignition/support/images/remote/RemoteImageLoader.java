// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.github.ignition.support.images.remote;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.widget.ImageView;
import com.github.ignition.support.cache.AbstractImageCache;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

// Referenced classes of package com.github.ignition.support.images.remote:
//            RemoteImageLoaderHandler, RemoteImageLoaderJob

public class RemoteImageLoader
{

    private int defaultBufferSize;
    private Drawable defaultDummyDrawable;
    private Drawable errorDrawable;
    private ThreadPoolExecutor executor;
    private final Object executorLock = new Object();
    private final HashMap handlerMap = new HashMap();
    private AbstractImageCache imageCache;
    private int numRetries;

    public RemoteImageLoader(Context context)
    {
        numRetries = 3;
        defaultBufferSize = 0x10000;
        executor = newExecutor();
        errorDrawable = context.getResources().getDrawable(0x1080027);
    }

    private ThreadPoolExecutor newExecutor()
    {
        return (ThreadPoolExecutor)Executors.newFixedThreadPool(3);
    }

    public void cancelLoad(ImageView imageview)
    {
        imageview.setTag(null);
    }

    public void loadImage(String s, ImageView imageview, Drawable drawable, RemoteImageLoaderHandler remoteimageloaderhandler)
    {
        if (imageview == null)
        {
            break MISSING_BLOCK_LABEL_51;
        }
        if (s != null) goto _L2; else goto _L1
_L1:
        imageview.setTag(null);
        if (drawable != null)
        {
            imageview.setImageDrawable(drawable);
        }
_L4:
        return;
_L2:
        if (s.equals((String)imageview.getTag())) goto _L4; else goto _L3
_L3:
        if (drawable != null)
        {
            imageview.setImageDrawable(drawable);
        }
        imageview.setTag(s);
        if (imageCache != null && imageCache.containsKeyInMemory(s))
        {
            remoteimageloaderhandler.handleImageLoaded(imageCache.getBitmap(s), null);
            return;
        }
        drawable = ((Drawable) (executorLock));
        drawable;
        JVM INSTR monitorenter ;
        boolean flag = true;
        HashMap hashmap = handlerMap;
        hashmap;
        JVM INSTR monitorenter ;
        imageview = (Set)handlerMap.get(s);
        if (imageview == null) goto _L6; else goto _L5
_L5:
        flag = false;
_L8:
        imageview.add(remoteimageloaderhandler);
        hashmap;
        JVM INSTR monitorexit ;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_164;
        }
        executor.execute(new RemoteImageLoaderJob(s, this, imageCache, numRetries));
        drawable;
        JVM INSTR monitorexit ;
        return;
        s;
        drawable;
        JVM INSTR monitorexit ;
        throw s;
_L6:
        imageview = new HashSet();
        handlerMap.put(s, imageview);
        if (true) goto _L8; else goto _L7
_L7:
        s;
        hashmap;
        JVM INSTR monitorexit ;
        throw s;
    }

    public void loadImage(String s, ImageView imageview, RemoteImageLoaderHandler remoteimageloaderhandler)
    {
        loadImage(s, imageview, defaultDummyDrawable, remoteimageloaderhandler);
    }

    void notifyAndCleanupHandlers(String s, Bundle bundle)
    {
        Object obj1;
        synchronized (handlerMap)
        {
            obj1 = (Set)handlerMap.remove(s);
        }
        if (obj1 != null && bundle != null)
        {
            for (s = ((Set) (obj1)).iterator(); s.hasNext(); ((RemoteImageLoaderHandler) (obj)).sendMessage(((Message) (obj1))))
            {
                obj = (RemoteImageLoaderHandler)s.next();
                obj1 = Message.obtain();
                obj1.what = 0;
                ((Message) (obj1)).setData(bundle);
            }

        } else
        {
            Log.w("Ignition/ImageLoader", (new StringBuilder()).append("Handler missing for image ").append(s).toString());
        }
        break MISSING_BLOCK_LABEL_115;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public void purgeJobs()
    {
        synchronized (executorLock)
        {
            executor.shutdownNow();
            executor = newExecutor();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void setDownloadFailedDrawable(Drawable drawable)
    {
        errorDrawable = drawable;
    }

    public void setDownloadInProgressDrawable(Drawable drawable)
    {
        defaultDummyDrawable = drawable;
    }

    public void setImageCache(AbstractImageCache abstractimagecache)
    {
        imageCache = abstractimagecache;
    }

    public void setMaxDownloadAttempts(int i)
    {
        numRetries = i;
    }
}
