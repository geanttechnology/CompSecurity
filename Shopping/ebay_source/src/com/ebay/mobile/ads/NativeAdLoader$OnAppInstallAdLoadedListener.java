// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.ads;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import java.lang.ref.WeakReference;

// Referenced classes of package com.ebay.mobile.ads:
//            NativeAdLoader

static final class listener
    implements com.google.android.gms.ads.formats.ner
{

    private final AdListener listener;
    private final WeakReference loaderReference;

    public void onAppInstallAdLoaded(NativeAppInstallAd nativeappinstallad)
    {
        NativeAdLoader nativeadloader = (NativeAdLoader)loaderReference.get();
        if (nativeadloader != null)
        {
            NativeAdLoader.access$002(nativeadloader, nativeappinstallad);
            if (listener != null)
            {
                listener.onAdLoaded();
                return;
            }
        }
    }

    llAdLoadedListener(NativeAdLoader nativeadloader, AdListener adlistener)
    {
        loaderReference = new WeakReference(nativeadloader);
        listener = adlistener;
    }
}
