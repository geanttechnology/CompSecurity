// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia;

import java.lang.ref.WeakReference;

// Referenced classes of package com.millennialmedia:
//            InterstitialAd, MMLog

private static class requestStateRef
    implements Runnable
{

    WeakReference interstitialAdRef;
    WeakReference requestStateRef;

    public void run()
    {
        InterstitialAd interstitialad = (InterstitialAd)interstitialAdRef.get();
        if (interstitialad == null)
        {
            MMLog.e(InterstitialAd.access$000(), "InterstitialAd instance has been destroyed, aborting expiration state change");
            return;
        }
        InterstitialAd.access$102(interstitialad, null);
        com.millennialmedia.internal.e e = (com.millennialmedia.internal.e)requestStateRef.get();
        if (e == null)
        {
            MMLog.e(InterstitialAd.access$000(), "No valid RequestState is available, unable to trigger expired state change");
            return;
        } else
        {
            InterstitialAd.access$200(interstitialad, e);
            return;
        }
    }

    (InterstitialAd interstitialad, com.millennialmedia.internal. )
    {
        interstitialAdRef = new WeakReference(interstitialad);
        requestStateRef = new WeakReference();
    }
}
