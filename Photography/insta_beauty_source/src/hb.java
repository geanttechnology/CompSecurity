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
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeAppInstallAdView;

public class hb
    implements com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener
{

    final Context a;
    final anv b;
    final FotoNativeAbroadWall c;

    public hb(FotoNativeAbroadWall fotonativeabroadwall, Context context, anv anv1)
    {
        c = fotonativeabroadwall;
        a = context;
        b = anv1;
        super();
    }

    public void onAppInstallAdLoaded(NativeAppInstallAd nativeappinstallad)
    {
        NativeAppInstallAdView nativeappinstalladview = (NativeAppInstallAdView)LayoutInflater.from(a).inflate(ayx.admob_app_install, null);
        gs.a(nativeappinstallad, nativeappinstalladview);
        gs.a(a, nativeappinstalladview);
        if (b != null)
        {
            float f = a.getResources().getDisplayMetrics().widthPixels;
            f -= f / 8F;
            float f1 = (207F * f) / 300F;
            nativeappinstalladview.setLayoutParams(new android.view.ViewGroup.LayoutParams((int)f, (int)f1));
            if (nativeappinstalladview.getParent() != null)
            {
                ((ViewGroup)nativeappinstalladview.getParent()).removeView(nativeappinstalladview);
            }
            c.addView(nativeappinstalladview, -2, -2);
            b.adLoaded(c);
            StaticFlurryEvent.logADEventWithKV(StaticFlurryEvent.AdMobNativeAD, StaticFlurryEvent.adLoaded);
            Log.e(FotoNativeAbroadWall.TAG, "APPinstalled ADMOB Request Success");
        }
_L1:
        return;
        nativeappinstallad;
        nativeappinstallad.printStackTrace();
        if (b != null)
        {
            b.adFailed();
            StaticFlurryEvent.logADEventWithKV(StaticFlurryEvent.AdMobNativeAD, StaticFlurryEvent.adLoadedFailed);
            Log.e(FotoNativeAbroadWall.TAG, "APPinstalled ADMOB Set Failed");
            return;
        }
          goto _L1
    }
}
