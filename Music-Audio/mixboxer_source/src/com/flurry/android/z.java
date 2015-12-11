// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.util.Log;
import com.jumptap.adtag.JtAdView;
import com.jumptap.adtag.JtAdViewListener;
import java.util.Collections;

// Referenced classes of package com.flurry.android:
//            fu

final class z
    implements JtAdViewListener
{

    private fu bl;

    z(fu fu1)
    {
        bl = fu1;
        super();
    }

    public final void onAdError(JtAdView jtadview, int i, int j)
    {
        Log.d(fu.d(), "Jumptap Interstitial error.");
        bl.onRenderFailed(Collections.emptyMap());
    }

    public final void onFocusChange(JtAdView jtadview, int i, boolean flag)
    {
        Log.d(fu.d(), "Jumptap Interstitial focus changed.");
    }

    public final void onInterstitialDismissed(JtAdView jtadview, int i)
    {
        bl.onAdClosed(Collections.emptyMap());
        Log.d(fu.d(), "Jumptap Interstitial dismissed.");
    }

    public final void onNewAd(JtAdView jtadview, int i, String s)
    {
        bl.onAdShown(Collections.emptyMap());
        Log.d(fu.d(), "Jumptap Interstitial new ad.");
    }

    public final void onNoAdFound(JtAdView jtadview, int i)
    {
        bl.onRenderFailed(Collections.emptyMap());
        Log.d(fu.d(), "Jumptap Interstitial no ad found.");
    }
}
