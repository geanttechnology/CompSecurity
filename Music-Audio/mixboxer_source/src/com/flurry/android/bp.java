// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.util.Log;
import com.inmobi.androidsdk.IMAdInterstitial;
import com.inmobi.androidsdk.IMAdInterstitialListener;
import java.util.Collections;

// Referenced classes of package com.flurry.android:
//            dy

final class bp
    implements IMAdInterstitialListener
{

    private dy dJ;

    bp(dy dy1)
    {
        dJ = dy1;
        super();
    }

    public final void onAdRequestFailed(IMAdInterstitial imadinterstitial, com.inmobi.androidsdk.IMAdRequest.ErrorCode errorcode)
    {
        dJ.onRenderFailed(Collections.emptyMap());
        Log.d(dy.d(), "InMobi imAdView ad request failed.");
    }

    public final void onAdRequestLoaded(IMAdInterstitial imadinterstitial)
    {
        Log.d(dy.d(), "InMobi Interstitial ad request completed.");
        if (com.inmobi.androidsdk.IMAdInterstitial.State.READY.equals(imadinterstitial.getState()))
        {
            dJ.onAdShown(Collections.emptyMap());
            imadinterstitial.show();
        }
    }

    public final void onDismissAdScreen(IMAdInterstitial imadinterstitial)
    {
        dJ.onAdClosed(Collections.emptyMap());
        Log.d(dy.d(), "InMobi Interstitial ad dismissed.");
    }

    public final void onLeaveApplication(IMAdInterstitial imadinterstitial)
    {
        Log.d(dy.d(), "InMobi onLeaveApplication");
    }

    public final void onShowAdScreen(IMAdInterstitial imadinterstitial)
    {
        Log.d(dy.d(), "InMobi Interstitial ad shown.");
    }
}
