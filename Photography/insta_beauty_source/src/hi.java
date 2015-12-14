// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import com.fotoable.ad.NativeAdWrapper;
import com.fotoable.ad.StaticFlurryEvent;
import com.fotoable.ads.FotoNativeAbroadWall;
import java.lang.ref.WeakReference;

class hi
    implements Runnable
{

    final hf a;

    hi(hf hf1)
    {
        a = hf1;
        super();
    }

    public void run()
    {
        StaticFlurryEvent.logADEventWithKV(StaticFlurryEvent.FBNativeAD, StaticFlurryEvent.adLoadedFailed);
        if (!NativeAdWrapper.needAdmobNative(a.b.d.getContext())) goto _L2; else goto _L1
_L1:
        a.b.d.createAdmobNativeView(true, true, a.b.d.getContext(), (anv)FotoNativeAbroadWall.access$100(a.b.d).get());
_L4:
        Log.d("NativeAbroadWall", "load native ad failed!");
        return;
_L2:
        if (a.b.c != null)
        {
            a.b.c.adFailed();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }
}
