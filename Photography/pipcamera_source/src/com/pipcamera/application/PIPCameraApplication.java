// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.application;

import aad;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.crashlytics.android.Crashlytics;
import com.flurry.android.FlurryAgent;
import com.fotoable.ad.ApplicationState;
import com.fotoable.ad.FotoCustomReport;
import com.fotoable.ad.NativeAdWrapper;
import com.fotoable.adbuttonlib.TAdButtonGroup;
import com.pipcamera.activity.NewPhotoShareActivity;
import com.pipcamera.activity.PIPCameraActivity;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;
import java.util.ArrayList;
import ju;
import jw;
import zw;

public class PIPCameraApplication extends Application
{

    public static Context a;
    public static boolean b = false;
    public static int c = 0;
    public static ju d = new ju();
    public static TPhotoComposeInfo e = new TPhotoComposeInfo();
    public static boolean f = false;
    public static boolean g = false;
    public static String h = "G84G8N74Y3NSM4V76N89";
    public static jw i;
    private static PIPCameraApplication j;

    public PIPCameraApplication()
    {
    }

    public static boolean a()
    {
        return b;
    }

    public static boolean a(Context context)
    {
        return (context.getResources().getConfiguration().screenLayout & 0xf) == 1;
    }

    public static boolean a(FragmentActivity fragmentactivity)
    {
        boolean flag = true;
        new DisplayMetrics();
        fragmentactivity = b().getApplicationContext().getResources().getDisplayMetrics();
        int k = ((DisplayMetrics) (fragmentactivity)).heightPixels;
        if (((DisplayMetrics) (fragmentactivity)).widthPixels + k < 1280)
        {
            flag = false;
        }
        return flag;
    }

    public static PIPCameraApplication b()
    {
        return j;
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

    public Context c()
    {
        return a;
    }

    public void onCreate()
    {
        super.onCreate();
        j = this;
        a = getApplicationContext();
        ActivityManager activitymanager;
        boolean flag;
        try
        {
            TAdButtonGroup.isGoogleApk = true;
            ApplicationState.init(a);
            zw.a(getApplicationContext(), new aad[] {
                new Crashlytics()
            });
            FotoCustomReport.CheckIfNewUserAtVeryStart(getApplicationContext());
            FlurryAgent.init(this, h);
            FlurryAgent.setLogEnabled(false);
            FlurryAgent.setCaptureUncaughtExceptions(false);
            FlurryAgent.setReportLocation(false);
            ArrayList arraylist = new ArrayList();
            arraylist.add(com/pipcamera/activity/PIPCameraActivity);
            arraylist.add(com/pipcamera/activity/NewPhotoShareActivity);
            NativeAdWrapper.initNativeSDK(a, arraylist);
        }
        catch (Exception exception)
        {
            Crashlytics.logException(exception);
        }
        try
        {
            Class.forName("android.os.AsyncTask");
        }
        catch (Throwable throwable) { }
        activitymanager = (ActivityManager)getApplicationContext().getSystemService("activity");
        c = activitymanager.getMemoryClass();
        if (activitymanager.getMemoryClass() <= 32)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b = flag;
        try
        {
            System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
            i = jw.a(a);
            return;
        }
        catch (Exception exception1)
        {
            exception1.printStackTrace();
            Crashlytics.logException(exception1);
            return;
        }
    }

}
