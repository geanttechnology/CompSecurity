// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.cache;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.EncodedImage;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.facebook.imagepipeline.cache:
//            BufferedDiskCache, StagingArea, ImageCacheStatsTracker

class val.key
    implements Callable
{

    final BufferedDiskCache this$0;
    final AtomicBoolean val$isCancelled;
    final CacheKey val$key;

    public EncodedImage call()
        throws Exception
    {
        Object obj;
        if (val$isCancelled.get())
        {
            throw new CancellationException();
        }
        obj = BufferedDiskCache.access$000(BufferedDiskCache.this).get(val$key);
        if (obj == null) goto _L2; else goto _L1
_L1:
        FLog.v(BufferedDiskCache.access$100(), "Found image for %s in staging area", val$key.toString());
        BufferedDiskCache.access$200(BufferedDiskCache.this).onStagingAreaHit();
_L3:
        CloseableReference closeablereference;
        if (Thread.interrupted())
        {
            FLog.v(BufferedDiskCache.access$100(), "Host thread was interrupted, decreasing reference count");
            if (obj != null)
            {
                ((EncodedImage) (obj)).close();
            }
            throw new InterruptedException();
        } else
        {
            return ((EncodedImage) (obj));
        }
_L2:
        FLog.v(BufferedDiskCache.access$100(), "Did not find image for %s in staging area", val$key.toString());
        BufferedDiskCache.access$200(BufferedDiskCache.this).onStagingAreaMiss();
        closeablereference = CloseableReference.of(BufferedDiskCache.access$300(BufferedDiskCache.this, val$key));
        obj = new EncodedImage(closeablereference);
        CloseableReference.closeSafely(closeablereference);
          goto _L3
        obj;
        try
        {
            CloseableReference.closeSafely(closeablereference);
            throw obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
_L5:
        return null;
        Exception exception;
        exception;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    er()
    {
        this$0 = final_buffereddiskcache;
        val$isCancelled = atomicboolean;
        val$key = CacheKey.this;
        super();
    }
}
