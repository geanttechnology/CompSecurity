// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.util.Log;
import com.mobclix.android.sdk.MobclixFullScreenAdView;
import com.mobclix.android.sdk.MobclixFullScreenAdViewListener;
import java.util.Collections;

// Referenced classes of package com.flurry.android:
//            bx

final class aj
    implements MobclixFullScreenAdViewListener
{

    private bx cd;

    aj(bx bx1)
    {
        cd = bx1;
        super();
    }

    public final String keywords()
    {
        Log.d(bx.d(), "Mobclix keyword callback.");
        return null;
    }

    public final void onDismissAd(MobclixFullScreenAdView mobclixfullscreenadview)
    {
        cd.onAdClosed(Collections.emptyMap());
        Log.d(bx.d(), "Mobclix Interstitial ad dismissed.");
    }

    public final void onFailedLoad(MobclixFullScreenAdView mobclixfullscreenadview, int i)
    {
        cd.onRenderFailed(Collections.emptyMap());
        Log.d(bx.d(), "Mobclix Interstitial ad failed to load.");
    }

    public final void onFinishLoad(MobclixFullScreenAdView mobclixfullscreenadview)
    {
        Log.d(bx.d(), "Mobclix Interstitial ad successfully loaded.");
    }

    public final void onPresentAd(MobclixFullScreenAdView mobclixfullscreenadview)
    {
        cd.onAdShown(Collections.emptyMap());
        Log.d(bx.d(), "Mobclix Interstitial ad successfully shown.");
    }

    public final String query()
    {
        Log.d(bx.d(), "Mobclix query callback.");
        return null;
    }
}
