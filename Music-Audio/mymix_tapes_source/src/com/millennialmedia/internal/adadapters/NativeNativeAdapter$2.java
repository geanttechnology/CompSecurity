// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.adadapters;

import java.util.List;
import java.util.concurrent.CountDownLatch;

// Referenced classes of package com.millennialmedia.internal.adadapters:
//            NativeNativeAdapter

class val.loadingLatch
    implements ageLoadedCallback
{

    final NativeNativeAdapter this$0;
    final com.millennialmedia.internal.adcontrollers. val$asset;
    final CountDownLatch val$loadingLatch;

    public void imageLoaded(ponentInfo ponentinfo)
    {
        if (ponentinfo != null)
        {
            NativeNativeAdapter.access$200(NativeNativeAdapter.this, ponentinfo, val$asset);
            NativeNativeAdapter.access$300(NativeNativeAdapter.this).add(ponentinfo);
        }
        val$loadingLatch.countDown();
    }

    set()
    {
        this$0 = final_nativenativeadapter;
        val$asset = ;
        val$loadingLatch = CountDownLatch.this;
        super();
    }
}
