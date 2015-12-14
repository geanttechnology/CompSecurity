// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.mediation;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.mediation.MediationNativeListener;

// Referenced classes of package com.google.ads.mediation:
//            a, b, AbstractAdViewAdapter

final class e extends AdListener
    implements com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener, com.google.android.gms.ads.formats.NativeContentAd.OnContentAdLoadedListener, zza
{

    final AbstractAdViewAdapter zzaP;
    final MediationNativeListener zzaS;

    public e(AbstractAdViewAdapter abstractadviewadapter, MediationNativeListener mediationnativelistener)
    {
        zzaP = abstractadviewadapter;
        zzaS = mediationnativelistener;
    }

    public final void onAdClicked()
    {
        zzaS.onAdClicked(zzaP);
    }

    public final void onAdClosed()
    {
        zzaS.onAdClosed(zzaP);
    }

    public final void onAdFailedToLoad(int i)
    {
        zzaS.onAdFailedToLoad(zzaP, i);
    }

    public final void onAdLeftApplication()
    {
        zzaS.onAdLeftApplication(zzaP);
    }

    public final void onAdLoaded()
    {
    }

    public final void onAdOpened()
    {
        zzaS.onAdOpened(zzaP);
    }

    public final void onAppInstallAdLoaded(NativeAppInstallAd nativeappinstallad)
    {
        zzaS.onAdLoaded(zzaP, new a(nativeappinstallad));
    }

    public final void onContentAdLoaded(NativeContentAd nativecontentad)
    {
        zzaS.onAdLoaded(zzaP, new b(nativecontentad));
    }
}
