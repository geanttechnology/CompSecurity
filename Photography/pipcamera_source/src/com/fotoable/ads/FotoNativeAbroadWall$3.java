// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.ads;

import android.content.Context;
import android.util.Log;
import com.fotoable.ad.StaticFlurryEvent;
import com.google.android.gms.ads.AdListener;
import iz;

// Referenced classes of package com.fotoable.ads:
//            FotoNativeAbroadWall

class nit> extends AdListener
{

    final Context a;
    final iz b;
    final FotoNativeAbroadWall c;

    public void onAdFailedToLoad(int i)
    {
        Log.e(FotoNativeAbroadWall.TAG, (new StringBuilder()).append("ADMOB Request Failed ").append(i).toString());
        if (b != null)
        {
            b.adFailed();
        }
    }

    public void onAdOpened()
    {
        super.onAdOpened();
        Log.e(FotoNativeAbroadWall.TAG, "ADMOB Clicked");
        StaticFlurryEvent.logADClickedEvent(a, StaticFlurryEvent.AdMobNativeAD_Click);
    }

    (FotoNativeAbroadWall fotonativeabroadwall, Context context, iz iz1)
    {
        c = fotonativeabroadwall;
        a = context;
        b = iz1;
        super();
    }
}
