// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia;

import java.lang.ref.WeakReference;

// Referenced classes of package com.millennialmedia:
//            NativeAd, MMLog

private static class requestStateRef
    implements Runnable
{

    WeakReference nativeAdRef;
    WeakReference requestStateRef;

    public void run()
    {
        NativeAd nativead = (NativeAd)nativeAdRef.get();
        if (nativead == null)
        {
            MMLog.e(NativeAd.access$100(), "NativeAd instance has been destroyed, aborting expiration state change");
            return;
        }
        NativeAd.access$202(nativead, null);
        com.millennialmedia.internal.unnable unnable = (com.millennialmedia.internal.unnable)requestStateRef.get();
        if (unnable == null)
        {
            MMLog.e(NativeAd.access$100(), "No valid RequestStateComponents is available, unable to trigger expired state change");
            return;
        } else
        {
            NativeAd.access$300(nativead, unnable);
            return;
        }
    }

    State(NativeAd nativead, com.millennialmedia.internal. )
    {
        nativeAdRef = new WeakReference(nativead);
        requestStateRef = new WeakReference();
    }
}
