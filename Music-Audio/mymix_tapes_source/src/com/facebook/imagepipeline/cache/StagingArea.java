// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.cache;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.EncodedImage;
import java.util.HashMap;
import java.util.Map;

public class StagingArea
{

    private static final Class TAG = com/facebook/imagepipeline/cache/StagingArea;
    private Map mMap;

    private StagingArea()
    {
        mMap = new HashMap();
    }

    public static StagingArea getInstance()
    {
        return new StagingArea();
    }

    private void logStats()
    {
        this;
        JVM INSTR monitorenter ;
        FLog.v(TAG, "Count = %d", Integer.valueOf(mMap.size()));
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public EncodedImage get(CacheKey cachekey)
    {
        this;
        JVM INSTR monitorenter ;
        EncodedImage encodedimage1;
        Preconditions.checkNotNull(cachekey);
        encodedimage1 = (EncodedImage)mMap.get(cachekey);
        EncodedImage encodedimage = encodedimage1;
        if (encodedimage1 == null) goto _L2; else goto _L1
_L1:
        encodedimage1;
        JVM INSTR monitorenter ;
        if (EncodedImage.isValid(encodedimage1)) goto _L4; else goto _L3
_L3:
        mMap.remove(cachekey);
        FLog.w(TAG, "Found closed reference %d for key %s (%d)", new Object[] {
            Integer.valueOf(System.identityHashCode(encodedimage1)), cachekey.toString(), Integer.valueOf(System.identityHashCode(cachekey))
        });
        cachekey = null;
        encodedimage1;
        JVM INSTR monitorexit ;
_L6:
        this;
        JVM INSTR monitorexit ;
        return cachekey;
_L4:
        encodedimage = EncodedImage.cloneOrNull(encodedimage1);
        encodedimage1;
        JVM INSTR monitorexit ;
          goto _L2
_L5:
        encodedimage1;
        JVM INSTR monitorexit ;
        throw cachekey;
        cachekey;
        this;
        JVM INSTR monitorexit ;
        throw cachekey;
        cachekey;
          goto _L5
_L2:
        cachekey = encodedimage;
          goto _L6
        cachekey;
          goto _L5
    }

    public void put(CacheKey cachekey, EncodedImage encodedimage)
    {
        this;
        JVM INSTR monitorenter ;
        Preconditions.checkNotNull(cachekey);
        Preconditions.checkArgument(EncodedImage.isValid(encodedimage));
        EncodedImage.closeSafely((EncodedImage)mMap.put(cachekey, EncodedImage.cloneOrNull(encodedimage)));
        logStats();
        this;
        JVM INSTR monitorexit ;
        return;
        cachekey;
        throw cachekey;
    }

    public boolean remove(CacheKey cachekey, EncodedImage encodedimage)
    {
        boolean flag = false;
        this;
        JVM INSTR monitorenter ;
        EncodedImage encodedimage1;
        Preconditions.checkNotNull(cachekey);
        Preconditions.checkNotNull(encodedimage);
        Preconditions.checkArgument(EncodedImage.isValid(encodedimage));
        encodedimage1 = (EncodedImage)mMap.get(cachekey);
        if (encodedimage1 != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        CloseableReference closeablereference;
        closeablereference = encodedimage1.getByteBufferRef();
        encodedimage = encodedimage.getByteBufferRef();
        if (closeablereference == null || encodedimage == null)
        {
            break MISSING_BLOCK_LABEL_85;
        }
        Object obj;
        Object obj1;
        obj = closeablereference.get();
        obj1 = encodedimage.get();
        if (obj == obj1)
        {
            break MISSING_BLOCK_LABEL_106;
        }
        CloseableReference.closeSafely(encodedimage);
        CloseableReference.closeSafely(closeablereference);
        EncodedImage.closeSafely(encodedimage1);
        continue; /* Loop/switch isn't completed */
        cachekey;
        throw cachekey;
        mMap.remove(cachekey);
        CloseableReference.closeSafely(encodedimage);
        CloseableReference.closeSafely(closeablereference);
        EncodedImage.closeSafely(encodedimage1);
        logStats();
        flag = true;
        if (true) goto _L1; else goto _L3
_L3:
        cachekey;
        CloseableReference.closeSafely(encodedimage);
        CloseableReference.closeSafely(closeablereference);
        EncodedImage.closeSafely(encodedimage1);
        throw cachekey;
    }

}
