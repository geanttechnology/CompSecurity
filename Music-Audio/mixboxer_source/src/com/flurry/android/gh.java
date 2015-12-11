// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.util.Log;
import com.millennialmedia.android.MMAd;
import com.millennialmedia.android.MMException;
import com.millennialmedia.android.MMInterstitial;
import com.millennialmedia.android.RequestListener;
import java.util.Collections;

// Referenced classes of package com.flurry.android:
//            ah

final class gh
    implements RequestListener
{

    private ah iy;

    gh(ah ah1)
    {
        iy = ah1;
        super();
    }

    public final void MMAdOverlayLaunched(MMAd mmad)
    {
        iy.onAdShown(Collections.emptyMap());
        iy.onAdClosed(Collections.emptyMap());
        Log.d(ah.d(), (new StringBuilder()).append("Millennial MMAdView Interstitial overlay launched.").append(System.currentTimeMillis()).toString());
    }

    public final void MMAdRequestIsCaching(MMAd mmad)
    {
        Log.d(ah.d(), "Millennial MMAdView Interstitial request is caching.");
    }

    public final void requestCompleted(MMAd mmad)
    {
        Log.d(ah.d(), (new StringBuilder()).append("Millennial MMAdView returned interstitial ad: ").append(System.currentTimeMillis()).toString());
        if (!ah.a(iy))
        {
            iy.ca.display();
        }
    }

    public final void requestFailed(MMAd mmad, MMException mmexception)
    {
        iy.onRenderFailed(Collections.emptyMap());
        Log.d(ah.d(), "Millennial MMAdView Interstitial failed to load ad.");
    }
}
