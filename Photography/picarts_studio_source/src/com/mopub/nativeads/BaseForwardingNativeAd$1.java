// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import com.mopub.common.logging.MoPubLog;
import com.mopub.volley.VolleyError;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.mopub.nativeads:
//            BaseForwardingNativeAd, NativeErrorCode

final class val.imageListener
    implements com.mopub.volley.toolbox.
{

    final AtomicBoolean val$anyFailures;
    final AtomicInteger val$imageCounter;
    final stener val$imageListener;

    public final void onErrorResponse(VolleyError volleyerror)
    {
        MoPubLog.d("Failed to download a native ads image:", volleyerror);
        boolean flag = val$anyFailures.getAndSet(true);
        val$imageCounter.decrementAndGet();
        if (!flag)
        {
            val$imageListener.onImagesFailedToCache(NativeErrorCode.IMAGE_DOWNLOAD_FAILURE);
        }
    }

    public final void onResponse(com.mopub.volley.toolbox.r r, boolean flag)
    {
        if (r.getBitmap() != null && val$imageCounter.decrementAndGet() == 0 && !val$anyFailures.get())
        {
            val$imageListener.onImagesCached();
        }
    }

    stener()
    {
        val$imageCounter = atomicinteger;
        val$anyFailures = atomicboolean;
        val$imageListener = stener;
        super();
    }
}
