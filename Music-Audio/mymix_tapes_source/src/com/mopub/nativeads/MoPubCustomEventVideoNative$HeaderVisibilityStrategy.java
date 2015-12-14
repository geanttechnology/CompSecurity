// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import java.lang.ref.WeakReference;

// Referenced classes of package com.mopub.nativeads:
//            MoPubCustomEventVideoNative

static class mMoPubVideoNativeAd
    implements edStrategy
{

    private final WeakReference mMoPubVideoNativeAd;

    public void execute()
    {
        edStrategy edstrategy = (edStrategy)mMoPubVideoNativeAd.get();
        if (edstrategy != null)
        {
            edstrategy.AdImpressed();
        }
    }

    edStrategy(edStrategy edstrategy)
    {
        mMoPubVideoNativeAd = new WeakReference(edstrategy);
    }
}
