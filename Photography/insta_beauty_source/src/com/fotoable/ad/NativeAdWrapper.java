// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.ad;

import aaj;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import anq;
import anx;
import aqe;
import com.crashlytics.android.Crashlytics;
import com.fotoable.fotovariant.nativeAds.FotoNativeBaseWall;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class NativeAdWrapper
{

    static String TAG = "NativeAdWrapper";
    private static int adState = 0;
    private static NativeAdWrapperListener mListener = null;
    private static FotoNativeBaseWall mNativeWall = null;
    private static long nativeTimeout = 0L;
    private static List nativeViewList = new ArrayList();
    private static boolean needRefreshNativeIconAd = true;
    private static boolean needRefreshNativeWallAd = true;

    public NativeAdWrapper()
    {
    }

    public static void addNativeListArr(FotoNativeBaseWall fotonativebasewall)
    {
        if (fotonativebasewall == null)
        {
            return;
        }
        if (nativeViewList == null)
        {
            nativeViewList.add(fotonativebasewall);
            return;
        } else
        {
            nativeViewList.clear();
            nativeViewList.add(fotonativebasewall);
            return;
        }
    }

    private static void checkTimeout(Context context)
    {
        long l;
        long l1;
        long l2;
        l1 = 0L;
        l2 = (new Date()).getTime();
        l = l1;
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        l = l1;
        context = context.getSharedPreferences("FotoAdStrategy", 0);
        l = l1;
        l1 = context.getLong("nativeTimeout", 0L);
        l = l1;
        context.edit().putLong("nativeTimeout", l2).apply();
        l = l1;
_L2:
        nativeTimeout = l2 - l;
        if (adState == 1 && nativeTimeout >= 20000L)
        {
            adState = 0;
        }
        return;
        context;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private static void createNativeView(Context context)
    {
        if (context != null && aaj.e())
        {
            mNativeWall = anq.a(context, new _cls1());
        }
    }

    public static void createThirdPartNativeView(Context context, NativeAdWrapperListener nativeadwrapperlistener)
    {
        checkTimeout(context);
        if (nativeadwrapperlistener != null)
        {
            mListener = nativeadwrapperlistener;
        }
        if (adState != 1) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (adState != 2)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (nativeViewList == null || nativeViewList.size() <= 0) goto _L1; else goto _L3
_L3:
        handleDataToListener();
        return;
        if (adState != 0) goto _L1; else goto _L4
_L4:
        adState = 1;
        createNativeView(context);
        timeoutStart(context);
        return;
    }

    public static void destroyThirdPartNativeView()
    {
        if (mNativeWall != null)
        {
            mNativeWall.destroyAdWall();
            mNativeWall = null;
        }
    }

    public static boolean getNeedRefreshIconAd()
    {
        return needRefreshNativeIconAd;
    }

    public static boolean getNeedRefreshWallAd()
    {
        return needRefreshNativeWallAd;
    }

    private static void handleDataToListener()
    {
        if (mListener == null)
        {
            return;
        }
        if (nativeViewList == null || adState == 3)
        {
            mListener.onAdFailedToLoad(0);
            return;
        }
        Iterator iterator = nativeViewList.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            FotoNativeBaseWall fotonativebasewall = (FotoNativeBaseWall)iterator.next();
            if (fotonativebasewall != null)
            {
                mListener.onAdLoaded(fotonativebasewall, new aqe(300, 207));
            }
        } while (true);
        adState = 0;
    }

    public static void initNativeSDK(Context context, ArrayList arraylist)
    {
        anx anx1 = anq.c(context);
        if (anx1 != null)
        {
            anx1.a(context, arraylist);
        }
    }

    private static boolean isInMaxNumber(int i)
    {
        int j = (int)Math.random() * 100;
        return j >= 0 && j < i;
    }

    public static boolean nativeAdHandleResult(int i, int j, Intent intent, Activity activity)
    {
        anx anx1;
        if (activity != null)
        {
            if ((anx1 = anq.c(activity)) != null)
            {
                return anx1.a(i, j, intent, activity);
            }
        }
        return false;
    }

    public static boolean needAdmobNative(Context context)
    {
        boolean flag = false;
        try
        {
            if (aaj.e())
            {
                flag = isInMaxNumber(context.getSharedPreferences("FBNativeInfo", 0).getInt("admobWall", 100));
            }
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            Crashlytics.logException(context);
            return true;
        }
        return flag;
    }

    public static boolean needAliMMIconNative(Context context)
    {
        boolean flag = false;
        try
        {
            if (aaj.e())
            {
                flag = isInMaxNumber(context.getSharedPreferences("FBNativeInfo", 0).getInt("taobaoIcon", 100));
            }
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            Crashlytics.logException(context);
            return true;
        }
        return flag;
    }

    public static boolean needAliMMNative(Context context)
    {
        boolean flag = false;
        try
        {
            if (aaj.e())
            {
                flag = isInMaxNumber(context.getSharedPreferences("FBNativeInfo", 0).getInt("taobaoWall", 100));
            }
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            Crashlytics.logException(context);
            return true;
        }
        return flag;
    }

    public static boolean needFBNative(Context context)
    {
        boolean flag = false;
        try
        {
            if (aaj.e())
            {
                flag = isInMaxNumber(context.getSharedPreferences("FBNativeInfo", 0).getInt("facebookWall", 100));
            }
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            Crashlytics.logException(context);
            return true;
        }
        return flag;
    }

    public static boolean needFBNativeIcon(Context context)
    {
        boolean flag = false;
        try
        {
            if (aaj.e())
            {
                flag = isInMaxNumber(context.getSharedPreferences("FBNativeInfo", 0).getInt("facebookIcon", 100));
            }
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            Crashlytics.logException(context);
            return true;
        }
        return flag;
    }

    public static boolean needGDTIconNative(Context context)
    {
        boolean flag = false;
        try
        {
            if (aaj.e())
            {
                flag = isInMaxNumber(context.getSharedPreferences("FBNativeInfo", 0).getInt("gdtadIcon", 100));
            }
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            Crashlytics.logException(context);
            return true;
        }
        return flag;
    }

    public static boolean needGDTNative(Context context)
    {
        boolean flag = false;
        try
        {
            if (aaj.e())
            {
                flag = isInMaxNumber(context.getSharedPreferences("FBNativeInfo", 0).getInt("gdtadWall", 100));
            }
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            Crashlytics.logException(context);
            return true;
        }
        return flag;
    }

    public static void resetAdStateWhenRefresh()
    {
        if (adState != 1 && adState != 2)
        {
            adState = 0;
        }
        mListener = null;
    }

    public static void setAdState(int i)
    {
        adState = i;
    }

    public static void setNativeAdWrapperListenner(NativeAdWrapperListener nativeadwrapperlistener)
    {
        mListener = nativeadwrapperlistener;
    }

    public static void setNeedRefreshIconAd(boolean flag)
    {
        needRefreshNativeIconAd = flag;
    }

    public static void setNeedRefreshWallAd(boolean flag)
    {
        needRefreshNativeWallAd = flag;
    }

    private static void timeoutStart(Context context)
    {
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        context.getSharedPreferences("FotoAdStrategy", 0).edit().putLong("nativeTimeout", (new Date()).getTime()).apply();
        return;
        context;
    }



/*
    static int access$002(int i)
    {
        adState = i;
        return i;
    }

*/


    private class _cls1
        implements anv
    {

        public void adDelayLoad()
        {
            NativeAdWrapper.adState = 0;
            if (NativeAdWrapper.mListener != null)
            {
                NativeAdWrapper.mListener.onAdDelayReload();
            }
        }

        public void adFailed()
        {
            NativeAdWrapper.adState = 3;
            if (NativeAdWrapper.mListener != null)
            {
                NativeAdWrapper.mListener.onAdFailedToLoad(0);
                NativeAdWrapper.adState = 0;
            }
            Log.e("NativeAdWrapper", "load native ad Failed...");
        }

        public void adLoaded(FotoNativeBaseWall fotonativebasewall)
        {
            NativeAdWrapper.addNativeListArr(fotonativebasewall);
            NativeAdWrapper.adState = 2;
            if (NativeAdWrapper.mListener != null)
            {
                NativeAdWrapper.mListener.onAdLoaded(fotonativebasewall, new aqe(300, 207));
                NativeAdWrapper.adState = 0;
            }
            Log.e("NativeAdWrapper", "load native ad succeed!");
        }

        _cls1()
        {
        }
    }


    private class NativeAdWrapperListener
    {

        public abstract void onAdDelayReload();

        public abstract void onAdFailedToLoad(int i);

        public abstract void onAdLoaded(View view, aqe aqe1);
    }

}
