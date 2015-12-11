// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import java.util.HashSet;

// Referenced classes of package com.amazon.device.ads:
//            Utils, AndroidTargetUtils, Log, AdData, 
//            MetricsCollector, InternalAdRegistration, IInternalAdRegistration, DeviceInfo

class AdUtils
{

    public static final String LOG_TAG = com/amazon/device/ads/AdUtils.getSimpleName();
    public static final String REQUIRED_ACTIVITY = "com.amazon.device.ads.AdActivity";
    private static final HashSet requiredActivities;

    private AdUtils()
    {
    }

    public static boolean checkDefinedActivities(Context context)
    {
        HashSet hashset;
        boolean flag;
        flag = true;
        hashset = new HashSet();
        int j;
        if (!Utils.isAtLeastAndroidAPI(8))
        {
            break MISSING_BLOCK_LABEL_76;
        }
        String s = AndroidTargetUtils.getPackageCodePath(context);
        context = context.getPackageManager().getPackageArchiveInfo(s, 1).activities;
        j = context.length;
        int i = 0;
        while (i < j) 
        {
            try
            {
                hashset.add(((ActivityInfo) (context[i])).name);
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                return true;
            }
            i++;
        }
        flag = hashset.containsAll(requiredActivities);
        return flag;
    }

    public static String encloseHtml(String s, boolean flag)
    {
        String s2 = s;
        if (s != null)
        {
            String s1 = s;
            if (s.indexOf("<html>") == -1)
            {
                s1 = (new StringBuilder()).append("<html>").append(s).append("</html>").toString();
            }
            s2 = s1;
            if (flag)
            {
                s2 = s1;
                if (s1.indexOf("<!DOCTYPE html>") == -1)
                {
                    s2 = (new StringBuilder()).append("<!DOCTYPE html>").append(s1).toString();
                }
            }
        }
        return s2;
    }

    public static double getViewportInitialScale(double d)
    {
        if (Utils.isAtLeastAndroidAPI(19))
        {
            d = 1.0D;
        }
        return d;
    }

    public static boolean launchActivityForIntentLink(String s, Context context)
    {
        String s1;
label0:
        {
            if (s != null)
            {
                s1 = s;
                if (!s.equals(""))
                {
                    break label0;
                }
            }
            s1 = "about:blank";
        }
        Log.d(LOG_TAG, "Launch Intent: %s", new Object[] {
            s1
        });
        s = new Intent("android.intent.action.VIEW", Uri.parse(s1));
        s.setFlags(0x10000000);
        try
        {
            context.startActivity(s);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context = s.getAction();
            String s2 = LOG_TAG;
            if (context.startsWith("market://"))
            {
                s = "market";
            } else
            {
                s = "intent";
            }
            Log.w(s2, "Could not handle %s action: %s", new Object[] {
                s, context
            });
            return false;
        }
        return true;
    }

    public static void setConnectionMetrics(AdData addata)
    {
        Object obj = addata.getConnectionType();
        if ("Wifi".equals(obj))
        {
            addata.getMetricsCollector().incrementMetric(Metrics.MetricType.WIFI_PRESENT);
        } else
        {
            addata.getMetricsCollector().setMetricString(Metrics.MetricType.CONNECTION_TYPE, ((String) (obj)));
        }
        obj = InternalAdRegistration.getInstance().getDeviceInfo();
        if (((DeviceInfo) (obj)).getCarrier() != null)
        {
            addata.getMetricsCollector().setMetricString(Metrics.MetricType.CARRIER_NAME, ((DeviceInfo) (obj)).getCarrier());
        }
    }

    static 
    {
        requiredActivities = new HashSet();
        requiredActivities.add("com.amazon.device.ads.AdActivity");
    }
}
