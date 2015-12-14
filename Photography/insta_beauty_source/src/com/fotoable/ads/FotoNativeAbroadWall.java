// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.ads;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import anv;
import com.fotoable.ad.FotoAdMediationDB;
import com.fotoable.ad.NativeAdWrapper;
import com.fotoable.ad.StaticFlurryEvent;
import com.fotoable.fotovariant.nativeAds.FotoNativeBaseWall;
import com.google.android.gms.ads.AdLoader;
import hb;
import hc;
import hd;
import he;
import java.lang.ref.WeakReference;

public class FotoNativeAbroadWall extends FotoNativeBaseWall
{

    public static String TAG = "FotoNativeAbroadWall";
    private WeakReference lisenterWeakReference;
    private Handler threadKillerHandler;

    public FotoNativeAbroadWall(Context context)
    {
        super(context);
    }

    private void createFbNative(Context context, String s, anv anv1)
    {
        try
        {
            (new Thread(new he(this, context, s, anv1))).start();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.e(TAG, context.toString());
        }
    }

    public void createAdmobNativeView(boolean flag, boolean flag1, Context context, anv anv1)
    {
        if (flag || flag1) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Log.e(TAG, "ADMOB refresh ads");
        com.google.android.gms.ads.AdLoader.Builder builder = new com.google.android.gms.ads.AdLoader.Builder(context, FotoAdMediationDB.getAdmobUnitID(context));
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_53;
        }
        builder.forAppInstallAd(new hb(this, context, anv1));
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_74;
        }
        builder.forContentAd(new hc(this, context, anv1));
        builder.withAdListener(new hd(this, context, anv1)).build().loadAd((new com.google.android.gms.ads.AdRequest.Builder()).addTestDevice("215B9DDDE2A99BBA1A99320DEF55D9E9").build());
        StaticFlurryEvent.logADEventWithKV(StaticFlurryEvent.AdMobNativeAD, StaticFlurryEvent.adRequest);
        return;
        context;
        context.printStackTrace();
        if (anv1 != null)
        {
            anv1.adFailed();
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void destroyAdWall()
    {
        if (threadKillerHandler != null)
        {
            threadKillerHandler.getLooper().quit();
        }
    }

    public void loadAd(Context context, anv anv1, String s)
    {
        lisenterWeakReference = new WeakReference(anv1);
        if (NativeAdWrapper.needFBNative(context))
        {
            createFbNative(context, FotoAdMediationDB.getFBNativeADID(context), (anv)lisenterWeakReference.get());
        } else
        {
            if (NativeAdWrapper.needAdmobNative(context))
            {
                createAdmobNativeView(true, true, context, (anv)lisenterWeakReference.get());
                return;
            }
            if (anv1 != null)
            {
                anv1.adFailed();
                return;
            }
        }
    }

    public void registerImpression(Context context, View view)
    {
    }



/*
    public static Handler access$002(FotoNativeAbroadWall fotonativeabroadwall, Handler handler)
    {
        fotonativeabroadwall.threadKillerHandler = handler;
        return handler;
    }

*/

}
