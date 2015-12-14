// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instabeauty.application;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import apa;
import apc;
import bso;
import bsy;
import com.crashlytics.android.Crashlytics;
import com.crashlytics.android.ndk.CrashlyticsNdk;
import com.flurry.android.FlurryAgent;
import com.fotoable.ad.ApplicationState;
import com.fotoable.ad.FotoCustomReport;
import com.fotoable.ad.NativeAdWrapper;
import com.fotoable.fotobeauty.NewPhotoShareActivity;
import com.fotoable.fotobeauty.WantuActivity;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;
import java.io.PrintStream;
import java.util.ArrayList;

public class InstaBeautyApplication extends Application
{

    public static Context a;
    public static boolean b = false;
    public static boolean c = false;
    public static apa d = new apa();
    public static TPhotoComposeInfo e = new TPhotoComposeInfo();
    public static boolean f = false;
    public static boolean g = false;
    public static int h = 0;
    public static apc i;
    private static InstaBeautyApplication j;

    public InstaBeautyApplication()
    {
    }

    public static InstaBeautyApplication a()
    {
        return j;
    }

    public static boolean a(Context context)
    {
        return (context.getResources().getConfiguration().screenLayout & 0xf) == 1;
    }

    public static boolean c()
    {
        return b;
    }

    public static boolean d()
    {
        return (a.getResources().getConfiguration().screenLayout & 0xf) == 1;
    }

    public boolean a(Activity activity)
    {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int k = displaymetrics.heightPixels;
        return displaymetrics.widthPixels + k < 1280;
    }

    protected void attachBaseContext(Context context)
    {
        super.attachBaseContext(context);
    }

    public Context b()
    {
        return a;
    }

    public void onCreate()
    {
        super.onCreate();
        if (android.os.Build.VERSION.SDK_INT < 15) goto _L2; else goto _L1
_L1:
        bso.a(this, new bsy[] {
            new Crashlytics(), new CrashlyticsNdk()
        });
_L4:
        ActivityManager activitymanager;
        FlurryAgent.init(this, "J3DP5Q6Y48C3GPJXV4X3");
        FlurryAgent.setReportLocation(false);
        FotoCustomReport.CheckIfNewUserAtVeryStart(getApplicationContext());
        System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
        j = this;
        a = getApplicationContext();
        activitymanager = (ActivityManager)getApplicationContext().getSystemService("activity");
        h = activitymanager.getMemoryClass();
        boolean flag;
        if (activitymanager.getMemoryClass() <= 32)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b = flag;
        break MISSING_BLOCK_LABEL_112;
_L2:
        bso.a(this, new bsy[] {
            new Crashlytics()
        });
        continue; /* Loop/switch isn't completed */
        obj;
        continue; /* Loop/switch isn't completed */
        obj;
        bso.a(this, new bsy[] {
            new Crashlytics()
        });
        continue; /* Loop/switch isn't completed */
        Object obj;
        if (activitymanager.getMemoryClass() >= 64)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        try
        {
            c = flag;
            ApplicationState.init(a);
            ArrayList arraylist = new ArrayList();
            arraylist.add(com/fotoable/fotobeauty/WantuActivity);
            arraylist.add(com/fotoable/fotobeauty/NewPhotoShareActivity);
            NativeAdWrapper.initNativeSDK(a, arraylist);
            Class.forName("android.os.AsyncTask");
            i = apc.a(a);
            return;
        }
        catch (Exception exception)
        {
            Crashlytics.logException(exception);
        }
        return;
        Error error;
        error;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onLowMemory()
    {
        super.onLowMemory();
        System.out.println("onlowMemory");
    }

    public void onTerminate()
    {
        super.onTerminate();
    }

}
