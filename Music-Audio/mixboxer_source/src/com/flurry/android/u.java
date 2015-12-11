// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.util.Log;
import com.jumptap.adtag.JtAdView;
import com.jumptap.adtag.JtAdViewListener;
import java.util.Collections;

// Referenced classes of package com.flurry.android:
//            e

final class u
    implements JtAdViewListener
{

    private e aa;

    u(e e1)
    {
        aa = e1;
        super();
    }

    public final void onAdError(JtAdView jtadview, int i, int j)
    {
        Log.d(e.d(), "Jumptap AdView error.");
        aa.onRenderFailed(Collections.emptyMap());
    }

    public final void onFocusChange(JtAdView jtadview, int i, boolean flag)
    {
        Log.d(e.d(), "Jumptap AdView focus changed.");
    }

    public final void onInterstitialDismissed(JtAdView jtadview, int i)
    {
        aa.onAdClosed(Collections.emptyMap());
        Log.d(e.d(), "Jumptap AdView dismissed.");
    }

    public final void onNewAd(JtAdView jtadview, int i, String s)
    {
        aa.onAdShown(Collections.emptyMap());
        Log.d(e.d(), "Jumptap AdView new ad.");
    }

    public final void onNoAdFound(JtAdView jtadview, int i)
    {
        aa.onRenderFailed(Collections.emptyMap());
        Log.d(e.d(), "Jumptap AdView no ad found.");
    }
}
