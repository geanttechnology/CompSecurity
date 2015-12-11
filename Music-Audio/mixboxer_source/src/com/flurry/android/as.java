// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.util.Log;
import com.mobclix.android.sdk.MobclixAdView;
import com.mobclix.android.sdk.MobclixAdViewListener;
import java.util.Collections;

// Referenced classes of package com.flurry.android:
//            fc

final class as
    implements MobclixAdViewListener
{

    private fc cT;

    as(fc fc1)
    {
        cT = fc1;
        super();
    }

    public final String keywords()
    {
        Log.d(fc.d(), "Mobclix keyword callback.");
        return null;
    }

    public final void onAdClick(MobclixAdView mobclixadview)
    {
        cT.onAdClicked(Collections.emptyMap());
        Log.d(fc.d(), "Mobclix AdView ad clicked.");
    }

    public final void onCustomAdTouchThrough(MobclixAdView mobclixadview, String s)
    {
        cT.onAdClicked(Collections.emptyMap());
        Log.d(fc.d(), "Mobclix AdView custom ad clicked.");
    }

    public final void onFailedLoad(MobclixAdView mobclixadview, int i)
    {
        cT.onRenderFailed(Collections.emptyMap());
        Log.d(fc.d(), "Mobclix AdView ad failed to load.");
    }

    public final boolean onOpenAllocationLoad(MobclixAdView mobclixadview, int i)
    {
        Log.d(fc.d(), "Mobclix AdView loaded an open allocation ad.");
        return true;
    }

    public final void onSuccessfulLoad(MobclixAdView mobclixadview)
    {
        cT.onAdShown(Collections.emptyMap());
        Log.d(fc.d(), "Mobclix AdView ad successfully loaded.");
    }

    public final String query()
    {
        Log.d(fc.d(), "Mobclix query callback.");
        return null;
    }
}
