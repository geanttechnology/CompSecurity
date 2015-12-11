// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.util.Log;
import com.google.ads.Ad;
import com.google.ads.AdListener;
import com.google.ads.InterstitialAd;
import java.util.Collections;

// Referenced classes of package com.flurry.android:
//            eo

final class gm
    implements AdListener
{

    private eo iH;

    gm(eo eo1)
    {
        this(eo1, (byte)0);
    }

    private gm(eo eo1, byte byte0)
    {
        iH = eo1;
        super();
    }

    public final void onDismissScreen(Ad ad)
    {
        iH.onAdClosed(Collections.emptyMap());
        Log.i(eo.aV(), "Admob Interstitial dismissed from screen.");
    }

    public final void onFailedToReceiveAd(Ad ad, com.google.ads.AdRequest.ErrorCode errorcode)
    {
        iH.onRenderFailed(Collections.emptyMap());
        Log.d(eo.aV(), "Admob Interstitial failed to receive takeover.");
    }

    public final void onLeaveApplication(Ad ad)
    {
        iH.onAdClicked(Collections.emptyMap());
        Log.i(eo.aV(), "Admob Interstitial leave application.");
    }

    public final void onPresentScreen(Ad ad)
    {
        Log.d(eo.aV(), "Admob Interstitial present on screen.");
    }

    public final void onReceiveAd(Ad ad)
    {
        if (ad == eo.a(iH))
        {
            Log.d(eo.aV(), "Admob Interstitial received takeover.");
            iH.onAdShown(Collections.emptyMap());
            eo.a(iH).show();
        }
    }
}
