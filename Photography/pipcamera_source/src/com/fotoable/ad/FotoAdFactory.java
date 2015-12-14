// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.ad;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import com.crashlytics.android.Crashlytics;
import com.flurry.android.FlurryAgent;
import com.fotoable.fotovariant.fotoads.FotoAdBanner;
import es;
import ew;
import gb;
import ix;
import iy;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;

// Referenced classes of package com.fotoable.ad:
//            FotoCustomReport, FotoAdMediationDB

public class FotoAdFactory
{

    static final boolean $assertionsDisabled;
    private static iy interstitialAd = null;
    public static boolean needShowInterstitialAd = true;
    private static FotoAdBanner staticAdView = null;
    private static String tag = "FotoAdFactory";

    public FotoAdFactory()
    {
    }

    public static boolean IsPlaystoreInstalled(Context context)
    {
label0:
        {
label1:
            {
                boolean flag = false;
                boolean flag1;
                try
                {
                    if (isPackageInstalled(context, "com.android.vending"))
                    {
                        break label1;
                    }
                    flag1 = isPackageInstalled(context, "com.google.market");
                }
                // Misplaced declaration of an exception variable
                catch (Context context)
                {
                    Crashlytics.logException(context);
                    return false;
                }
                if (!flag1)
                {
                    break label0;
                }
            }
            flag = true;
        }
        return flag;
    }

    public static void LogClickEvt(String s)
    {
        String s1;
        HashMap hashmap;
        try
        {
            s1 = getCachedBannerViewActivityName();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Crashlytics.logException(s);
            return;
        }
        if (s1 == null || s == null)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        Log.e(tag, (new StringBuilder()).append("adclicked in ").append(s1).toString());
        hashmap = new HashMap();
        hashmap.put(s, s1);
        FlurryAgent.logEvent("adClickedByUser1", hashmap);
        FotoCustomReport.bannerClickedTimes++;
    }

    public static void clearBannerView()
    {
        if (staticAdView != null)
        {
            staticAdView = null;
        }
    }

    public static void createAdBanner(Activity activity, View view)
    {
        if (activity != null) goto _L2; else goto _L1
_L1:
        if (!$assertionsDisabled)
        {
            throw new AssertionError();
        }
          goto _L3
_L2:
        String s = FotoAdMediationDB.getAdBannerID(activity);
        DisplayMetrics displaymetrics;
        int i;
        try
        {
            HashMap hashmap = new HashMap();
            hashmap.put(activity.getPackageName(), s);
            FlurryAgent.logEvent("UsdedAdID", hashmap);
        }
        catch (Exception exception) { }
        if (view != null) goto _L4; else goto _L3
_L3:
        return;
_L4:
        if (isWebViewProbablyCorrupt(activity))
        {
            continue; /* Loop/switch isn't completed */
        }
        displaymetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        i = displaymetrics.heightPixels;
        if (displaymetrics.widthPixels + i < 1280)
        {
            continue; /* Loop/switch isn't completed */
        }
        Log.e("AppBanner", (new StringBuilder()).append("get app banner: ").append(s).toString());
        view = (RelativeLayout)view.findViewWithTag("bannerRelative");
        if (view == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        view.setVisibility(0);
        if (staticAdView != null)
        {
            break; /* Loop/switch isn't completed */
        }
        activity = ix.a(activity);
        activity.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -1));
        staticAdView = activity;
        view.addView(activity);
_L6:
        if (staticAdView != null)
        {
            staticAdView.setVisibility(0);
            staticAdView.bringToFront();
            return;
        }
        if (true) goto _L3; else goto _L5
_L5:
        try
        {
            if (staticAdView.getParent() != null)
            {
                ((ViewGroup)staticAdView.getParent()).removeView(staticAdView);
            }
            staticAdView.refreshBanner();
            view.addView(staticAdView);
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            activity.printStackTrace();
            Crashlytics.logException(activity);
            return;
        }
          goto _L6
        if (true) goto _L3; else goto _L7
_L7:
    }

    public static void createFBInterstial(final Context ctx, final boolean autoDisplay)
    {
        final String fbid;
        boolean flag;
        fbid = getFBId(ctx);
        flag = ew.k(ctx);
        if (fbid == null || !flag)
        {
            break MISSING_BLOCK_LABEL_163;
        }
        if (!gb.e())
        {
            return;
        }
        SharedPreferences sharedpreferences;
        long l;
        long l1;
        long l2;
        sharedpreferences = ctx.getSharedPreferences("FotoAdStrategy", 0);
        l = sharedpreferences.getLong("InterstitialDisplayTime", (new Date(0L)).getTime());
        l1 = sharedpreferences.getLong("InterstitialRequestTime", (new Date(0L)).getTime());
        l2 = (new Date()).getTime();
        if (l2 - l >= 0x1b7740L && l2 - l1 >= 10000L)
        {
            try
            {
                sharedpreferences.edit().putLong("InterstitialRequestTime", l2).apply();
                (new Handler()).postDelayed(new Runnable() {

                    final boolean val$autoDisplay;
                    final Context val$ctx;
                    final String val$fbid;

                    public void run()
                    {
                        Log.d("AbroadInterstitialAd", "onInterstitialRequest");
                        if (FotoAdFactory.interstitialAd == null)
                        {
                            FotoAdFactory.interstitialAd = ix.d(ctx);
                        }
                        if (FotoAdFactory.interstitialAd != null)
                        {
                            FotoAdFactory.interstitialAd.a(ctx, fbid, autoDisplay);
                        }
                    }

            
            {
                ctx = context;
                fbid = s;
                autoDisplay = flag;
                super();
            }
                }, 2000L);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (final Context ctx)
            {
                Crashlytics.logException(ctx);
            }
        }
    }

    public static void destoryInterstitalAd()
    {
        if (interstitialAd != null)
        {
            interstitialAd.a();
            interstitialAd = null;
        }
    }

    public static void displayInterstitial(Context context, boolean flag)
    {
        try
        {
            if (interstitialAd != null)
            {
                interstitialAd.a(context, flag);
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Crashlytics.logException(context);
        }
    }

    private Bitmap getAssetBitmapByPath(Context context, String s)
    {
        Object obj;
        obj = null;
        context = context.getAssets();
        context = context.open(s);
        Context context1;
        s = obj;
        context1 = context;
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_30;
        }
        s = BitmapFactory.decodeStream(context);
        context1 = context;
_L2:
        if (context1 != null)
        {
            try
            {
                context1.close();
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                context.printStackTrace();
                Crashlytics.logException(context);
                return s;
            }
        }
        return s;
        s;
        context = null;
_L3:
        s.printStackTrace();
        Crashlytics.logException(s);
        s = obj;
        context1 = context;
        if (true) goto _L2; else goto _L1
_L1:
        s;
          goto _L3
    }

    private static String getCachedBannerViewActivityName()
    {
        String s;
        if (staticAdView == null || staticAdView.getParent() == null)
        {
            break MISSING_BLOCK_LABEL_44;
        }
        s = ((Activity)((ViewGroup)staticAdView.getParent()).getContext()).getClass().toString();
        return s;
        Exception exception;
        exception;
        Crashlytics.logException(exception);
        return null;
    }

    private static String getFBId(Context context)
    {
        if (context.getPackageName().equals(es.e))
        {
            return "382743411764062_769274653110934";
        }
        if (context.getPackageName().equals(es.a))
        {
            return "344391832332795_541702009268442";
        }
        if (context.getPackageName().equals(es.c))
        {
            return "156379654548669_471510606368904";
        }
        if (context.getPackageName().equalsIgnoreCase(es.b) || context.getPackageName().equalsIgnoreCase(es.j))
        {
            return "116913278412853_754396101331231";
        }
        if (context.getPackageName().equals(es.l))
        {
            return "971620106251483_972060082874152";
        } else
        {
            return null;
        }
    }

    public static void initStaticAdView(Activity activity)
    {
        if (activity == null)
        {
            return;
        } else
        {
            FotoAdMediationDB.getAdBannerID(activity);
            return;
        }
    }

    private static void intializeFotorusAd(Context context)
    {
    }

    private static boolean isInstalled(Context context, String s)
    {
        if (s != null)
        {
            try
            {
                context = context.getPackageManager().getPackageInfo(s, 0);
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                context.printStackTrace();
                Crashlytics.logException(context);
                context = null;
            }
            if (context != null)
            {
                return true;
            }
        }
        return false;
    }

    protected static final boolean isPackageInstalled(Context context, String s)
    {
        try
        {
            context.getPackageManager().getPackageInfo(s, 0);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return false;
        }
        return true;
    }

    public static final boolean isWebViewProbablyCorrupt(Context context)
    {
        SharedPreferences sharedpreferences;
        sharedpreferences = context.getSharedPreferences("sysconfig", 0);
        boolean flag = sharedpreferences.getBoolean("isWebViewProbablyCorrupt", true);
        if (!flag)
        {
            return flag;
        }
        context = context.openOrCreateDatabase("webviewCache.db", 0, null);
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_71;
        }
        context.close();
        sharedpreferences.edit().putBoolean("isWebViewProbablyCorrupt", false).apply();
        return false;
        context;
        Crashlytics.logException(context);
        return true;
    }

    public static void resetStaticAdBanner()
    {
        if (staticAdView != null)
        {
            if (staticAdView.getParent() != null)
            {
                ((ViewGroup)staticAdView.getParent()).removeView(staticAdView);
            }
            staticAdView = null;
        }
    }

    static 
    {
        boolean flag;
        if (!com/fotoable/ad/FotoAdFactory.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
    }



/*
    static iy access$002(iy iy1)
    {
        interstitialAd = iy1;
        return iy1;
    }

*/
}
