// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.hardware.Camera;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import com.facebook.device.yearclass.YearClass;
import java.util.Locale;
import roboguice.util.Strings;

public class DeviceInfoUtil
{

    private static final int KEYBOARD_OPEN_HEIGHT_DIFF = 200;
    private Application application;
    private int deviceMemoryProfile;
    private boolean isDeviceAtOrBelow2012;

    public DeviceInfoUtil(Application application1)
    {
        application = application1;
        deviceMemoryProfile = ((ActivityManager)application1.getSystemService("activity")).getMemoryClass();
        int i = YearClass.get(application1);
        boolean flag;
        if (i != -1 && i <= 2012)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isDeviceAtOrBelow2012 = flag;
    }

    public static float getScreenHeightDpi(Context context)
    {
        context = context.getResources().getDisplayMetrics();
        return (float)((DisplayMetrics) (context)).heightPixels / ((DisplayMetrics) (context)).density;
    }

    public static int getScreenOrientation(Context context)
    {
        return context.getResources().getConfiguration().orientation;
    }

    public static float getScreenWidthDpi(Context context)
    {
        context = context.getResources().getDisplayMetrics();
        return (float)((DisplayMetrics) (context)).widthPixels / ((DisplayMetrics) (context)).density;
    }

    public int convertDpToPixels(int i)
    {
        return (int)TypedValue.applyDimension(1, i, application.getResources().getDisplayMetrics());
    }

    public float convertPixelsToDp(float f)
    {
        return f / ((float)getDisplayMetrics().densityDpi / 160F);
    }

    public String getBuildType()
    {
        return application.getResources().getString(0x7f0804ca);
    }

    public float getDensity()
    {
        return application.getResources().getDisplayMetrics().density;
    }

    public int getDensityDpi()
    {
        return application.getResources().getDisplayMetrics().densityDpi;
    }

    public Locale getDeviceLocale()
    {
        return application.getResources().getConfiguration().locale;
    }

    public int getDeviceMemoryProfile()
    {
        return deviceMemoryProfile;
    }

    public DisplayMetrics getDisplayMetrics()
    {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        ((WindowManager)application.getSystemService("window")).getDefaultDisplay().getMetrics(displaymetrics);
        return displaymetrics;
    }

    public String getLanguageFromLocale()
    {
        String s1 = application.getResources().getConfiguration().locale.getLanguage();
        String s = s1;
        if (Strings.equalsIgnoreCase(s1, "he"))
        {
            s = "iw";
        }
        return s;
    }

    public int getStatusBarHeight()
    {
        int i = 0;
        int j = application.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (j > 0)
        {
            i = application.getResources().getDimensionPixelSize(j);
        }
        return i;
    }

    public boolean hasCameraFeature()
    {
        return Camera.getNumberOfCameras() > 0;
    }

    public boolean isDeviceAtOrBelow2012()
    {
        return isDeviceAtOrBelow2012;
    }

    public boolean isKeyboardShown(View view)
    {
        return view.getRootView().getHeight() - view.getHeight() > 200;
    }

    public boolean isRTLLanguage()
    {
        String s = getLanguageFromLocale();
        return Strings.equals(s, "iw") || Strings.equals(s, "ar") || Strings.equals(s, "fa");
    }

    public boolean isTablet()
    {
        return application.getResources().getBoolean(0x7f090009);
    }
}
