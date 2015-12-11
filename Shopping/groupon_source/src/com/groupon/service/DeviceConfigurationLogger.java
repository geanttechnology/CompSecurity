// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.DeviceInfoUtil;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import roboguice.util.Strings;

public class DeviceConfigurationLogger
{

    private DeviceInfoUtil deviceInfoUtil;
    private Logger logger;
    private WindowManager windowManager;

    public DeviceConfigurationLogger()
    {
    }

    private static String encode(String s)
    {
        try
        {
            s = URLEncoder.encode(Strings.toString(s), "UTF-8");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException(s);
        }
        return s;
    }

    public static String getBuildConfigurationString()
    {
        return String.format("%s,%s,%s,%s", new Object[] {
            encode(Build.MANUFACTURER), encode(Build.MODEL), encode(Build.PRODUCT), encode(Build.BRAND)
        });
    }

    private void logBuildConfiguration()
    {
        logger.logGeneralEvent("devcfg_bld", "", getBuildConfigurationString(), 1, Logger.NULL_NST_FIELD);
    }

    private void logDisplayConfiguration()
    {
label0:
        {
            DisplayMetrics displaymetrics;
            int j;
            int l;
label1:
            {
                Display display = windowManager.getDefaultDisplay();
                if (display == null)
                {
                    break label0;
                }
                displaymetrics = new DisplayMetrics();
                display.getMetrics(displaymetrics);
                int i1 = display.getRotation();
                int i = displaymetrics.widthPixels;
                int k = displaymetrics.heightPixels;
                if (i1 != 1)
                {
                    l = k;
                    j = i;
                    if (i1 != 3)
                    {
                        break label1;
                    }
                }
                j = k;
                l = i;
            }
            double d2 = displaymetrics.xdpi;
            double d3 = displaymetrics.ydpi;
            double d1 = 0.0D;
            double d = d1;
            if (d2 != 0.0D)
            {
                d = d1;
                if (d3 != 0.0D)
                {
                    d = Math.sqrt(Math.pow((double)j / d2, 2D) + Math.pow((double)l / d3, 2D));
                }
            }
            logger.logGeneralEvent("devcfg_disp", "", String.format("%d,%d,%f,%f,%f", new Object[] {
                Integer.valueOf(j), Integer.valueOf(l), Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d)
            }), 1, Logger.NULL_NST_FIELD);
        }
    }

    private void logExtraDeviceConfiguration()
    {
        int i = deviceInfoUtil.getDensityDpi();
        int j = deviceInfoUtil.getDeviceMemoryProfile();
        int k = android.os.Build.VERSION.SDK_INT;
        logger.logGeneralEvent("devcfg_extra", "", String.format("%d,%d,%d", new Object[] {
            Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k)
        }), 1, Logger.NULL_NST_FIELD);
    }

    public void logDeviceConfiguration()
    {
        logDisplayConfiguration();
        logBuildConfiguration();
        logExtraDeviceConfiguration();
    }
}
