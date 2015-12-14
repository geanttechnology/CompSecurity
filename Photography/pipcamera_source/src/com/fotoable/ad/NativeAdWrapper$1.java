// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.ad;

import android.util.Log;
import com.fotoable.fotovariant.nativeAds.FotoNativeBaseWall;
import iz;
import kp;

// Referenced classes of package com.fotoable.ad:
//            NativeAdWrapper

final class .FotoNativeBaseWall
    implements iz
{

    public void adDelayLoad()
    {
        int _tmp = NativeAdWrapper.access$002(0);
        if (NativeAdWrapper.access$100() != null)
        {
            NativeAdWrapper.access$100().onAdDelayReload();
        }
    }

    public void adFailed()
    {
        int _tmp = NativeAdWrapper.access$002(3);
        if (NativeAdWrapper.access$100() != null)
        {
            NativeAdWrapper.access$100().onAdFailedToLoad(0);
            int _tmp1 = NativeAdWrapper.access$002(0);
        }
        Log.e("NativeAdWrapper", "load native ad Failed...");
    }

    public void adLoaded(FotoNativeBaseWall fotonativebasewall)
    {
        NativeAdWrapper.addNativeListArr(fotonativebasewall);
        int _tmp = NativeAdWrapper.access$002(2);
        if (NativeAdWrapper.access$100() != null)
        {
            NativeAdWrapper.access$100().onAdLoaded(fotonativebasewall, new kp(300, 207));
            int _tmp1 = NativeAdWrapper.access$002(0);
        }
        Log.e("NativeAdWrapper", "load native ad succeed!");
    }

    .FotoNativeBaseWall()
    {
    }
}
