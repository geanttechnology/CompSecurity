// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.fotoable.ad.StaticFlurryEvent;
import com.fotoable.ads.FotoNativeAbroadWall;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.NativeContentAdView;

public class hc
    implements com.google.android.gms.ads.formats.NativeContentAd.OnContentAdLoadedListener
{

    final Context a;
    final anv b;
    final FotoNativeAbroadWall c;

    public hc(FotoNativeAbroadWall fotonativeabroadwall, Context context, anv anv1)
    {
        c = fotonativeabroadwall;
        a = context;
        b = anv1;
        super();
    }

    public void onContentAdLoaded(NativeContentAd nativecontentad)
    {
        NativeContentAdView nativecontentadview = (NativeContentAdView)LayoutInflater.from(a).inflate(ayx.admob_content, null);
        gs.a(nativecontentad, nativecontentadview);
        gs.a(a, nativecontentadview);
        if (b != null)
        {
            Log.e(FotoNativeAbroadWall.TAG, "Content ADMOB Request Success");
            float f = a.getResources().getDisplayMetrics().widthPixels;
            f -= f / 8F;
            float f1 = (207F * f) / 300F;
            nativecontentadview.setLayoutParams(new android.view.ViewGroup.LayoutParams((int)f, (int)f1));
            if (nativecontentadview.getParent() != null)
            {
                ((ViewGroup)nativecontentadview.getParent()).removeView(nativecontentadview);
            }
            c.addView(nativecontentadview, -2, -2);
            b.adLoaded(c);
            StaticFlurryEvent.logADEventWithKV(StaticFlurryEvent.AdMobNativeAD, StaticFlurryEvent.adLoaded);
        }
_L1:
        return;
        nativecontentad;
        nativecontentad.printStackTrace();
        if (b != null)
        {
            b.adFailed();
            StaticFlurryEvent.logADEventWithKV(StaticFlurryEvent.AdMobNativeAD, StaticFlurryEvent.adLoadedFailed);
            Log.e(FotoNativeAbroadWall.TAG, "Content ADMOB Set Failed");
            return;
        }
          goto _L1
    }
}
