// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.util.Log;
import com.inmobi.androidsdk.IMAdListener;
import com.inmobi.androidsdk.IMAdView;
import java.util.Collections;

// Referenced classes of package com.flurry.android:
//            ad

final class ew
    implements IMAdListener
{

    private ad gB;

    ew(ad ad1)
    {
        gB = ad1;
        super();
    }

    public final void onAdRequestCompleted(IMAdView imadview)
    {
        gB.onAdShown(Collections.emptyMap());
        Log.d(ad.d(), "InMobi imAdView ad request completed.");
    }

    public final void onAdRequestFailed(IMAdView imadview, com.inmobi.androidsdk.IMAdRequest.ErrorCode errorcode)
    {
        gB.onRenderFailed(Collections.emptyMap());
        Log.d(ad.d(), (new StringBuilder()).append("InMobi imAdView ad request failed. ").append(errorcode.toString()).toString());
    }

    public final void onDismissAdScreen(IMAdView imadview)
    {
        gB.onAdClosed(Collections.emptyMap());
        Log.d(ad.d(), "InMobi imAdView dismiss ad.");
    }

    public final void onLeaveApplication(IMAdView imadview)
    {
        Log.d(ad.d(), "InMobi onLeaveApplication");
    }

    public final void onShowAdScreen(IMAdView imadview)
    {
        gB.onAdClicked(Collections.emptyMap());
        Log.d(ad.d(), "InMobi imAdView ad shown.");
    }
}
