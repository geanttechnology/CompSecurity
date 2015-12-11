// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.http;

import android.app.Application;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.facebook.device.yearclass.YearClass;
import com.google.inject.Provider;
import com.groupon.service.AttributionService;
import com.groupon.util.DeviceInfoUtil;
import com.groupon.util.PlayServicesUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Locale;
import roboguice.util.Ln;
import roboguice.util.Strings;

public class UserAgentProvider
    implements Provider
{

    private Application app;
    private AttributionService attributionService;
    private DeviceInfoUtil deviceInfoUtil;
    private PackageInfo info;
    private TelephonyManager telephonyManager;

    public UserAgentProvider()
    {
    }

    public static String sanitizeHttpHeaderValue(String s)
    {
        return s.replaceAll("\\s+", " ").replaceAll("[^ -~]", "");
    }

    public volatile Object get()
    {
        return get();
    }

    public String get()
    {
        boolean flag = false;
        String s1 = String.format("Groupon/%s/%s/%d (Android %s / Play %s; %s %s / %s %s; %s)", new Object[] {
            deviceInfoUtil.getBuildType(), info.versionName, Integer.valueOf(YearClass.get(app)), android.os.Build.VERSION.RELEASE, Integer.valueOf(PlayServicesUtils.getGooglePlayServicesVersion(app)), Strings.capitalize(Build.MANUFACTURER), Strings.capitalize(Build.DEVICE), Strings.capitalize(Build.BRAND), Strings.capitalize(Build.MODEL), Strings.capitalize(telephonyManager.getSimOperatorName())
        });
        if ((app.getApplicationInfo().flags & 1) == 1 || Strings.notEmpty(attributionService.getAttributionDownloadId()))
        {
            flag = true;
        }
        ArrayList arraylist = new ArrayList();
        arraylist.add((new StringBuilder()).append("preload=").append(flag).toString());
        arraylist.add((new StringBuilder()).append("locale=").append(Locale.getDefault()).toString());
        String s;
        try
        {
            Class class1 = app.getClassLoader().loadClass("android.os.SystemProperties");
            Method method = class1.getMethod("get", new Class[] {
                java/lang/String
            });
            arraylist.add((new StringBuilder()).append("clientidbase=").append(method.invoke(class1, new Object[] {
                "ro.com.google.clientidbase"
            })).toString());
        }
        catch (Exception exception)
        {
            Ln.d(exception);
        }
        s = s1;
        if (arraylist.size() > 0)
        {
            s = (new StringBuilder()).append(s1).append("[").append(Strings.join(";", arraylist)).append("]").toString();
        }
        return sanitizeHttpHeaderValue(s);
    }
}
