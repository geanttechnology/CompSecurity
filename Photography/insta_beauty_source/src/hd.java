// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.util.Log;
import com.fotoable.ad.StaticFlurryEvent;
import com.fotoable.ads.FotoNativeAbroadWall;
import com.google.android.gms.ads.AdListener;

public class hd extends AdListener
{

    final Context a;
    final anv b;
    final FotoNativeAbroadWall c;

    public hd(FotoNativeAbroadWall fotonativeabroadwall, Context context, anv anv1)
    {
        c = fotonativeabroadwall;
        a = context;
        b = anv1;
        super();
    }

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
}
