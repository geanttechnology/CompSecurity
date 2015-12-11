// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.application;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.poshmark.application:
//            PMApplication

public class AppInfo
{
    private static class SingletonHolder
    {

        public static final AppInfo INSTANCE = new AppInfo();


        private SingletonHolder()
        {
        }
    }


    public static final String apiVersion = "0.2";
    public static final String appType = "android";
    public final String deviceID;
    public final Map deviceInfo;
    public final String deviceModel;
    public final String packageName;
    public final String userAgent;
    public final int versionCode;
    public final String versionCodeString;
    public final String versionName;

    private AppInfo()
    {
        Object obj;
        Object obj1;
        obj1 = PMApplication.getContext();
        packageName = ((Context) (obj1)).getPackageName();
        obj = null;
        obj1 = ((Context) (obj1)).getPackageManager().getPackageInfo(packageName, 0);
        obj = obj1;
_L5:
        String s;
        int i;
        if (obj != null && ((PackageInfo) (obj)).versionName != null)
        {
            obj1 = ((PackageInfo) (obj)).versionName;
        } else
        {
            obj1 = "";
        }
        versionName = ((String) (obj1));
        if (obj != null)
        {
            i = ((PackageInfo) (obj)).versionCode;
        } else
        {
            i = 0;
        }
        versionCode = i;
        versionCodeString = Integer.toString(versionCode);
        obj = null;
        obj1 = android.provider.Settings.Secure.getString(PMApplication.getContext().getContentResolver(), "android_id");
        obj = obj1;
_L6:
        if (obj != null)
        {
            obj = (new StringBuilder()).append("and1:").append(((String) (obj))).toString();
        } else
        {
            obj = "";
        }
        deviceID = ((String) (obj));
        s = "";
        if (Build.BRAND == null) goto _L2; else goto _L1
_L1:
        obj = Build.BRAND;
_L7:
        if (Build.MODEL == null) goto _L4; else goto _L3
_L3:
        obj1 = Build.MODEL;
_L8:
        obj = String.format("%s/%s", new Object[] {
            obj, obj1
        });
_L10:
        deviceModel = ((String) (obj));
        deviceInfo = new HashMap();
        deviceInfo.put("device_id", deviceID);
        deviceInfo.put("device_model", deviceModel);
        deviceInfo.put("os", (new StringBuilder()).append("Android: ").append(android.os.Build.VERSION.RELEASE).toString());
        obj = "";
        obj1 = System.getProperty("http.agent");
        obj = obj1;
_L9:
        userAgent = String.format("%s PoshmarkAndroidApp/%s (%s)", new Object[] {
            obj, versionName, versionCodeString
        });
        return;
        obj1;
        ((android.content.pm.PackageManager.NameNotFoundException) (obj1)).printStackTrace();
          goto _L5
        obj1;
        obj1 = android.provider.Settings.Secure.getString(PMApplication.getContext().getContentResolver(), "android_id");
        obj = obj1;
          goto _L6
_L2:
        obj = "";
          goto _L7
_L4:
        obj1 = "";
          goto _L8
        Exception exception1;
        exception1;
          goto _L9
        Exception exception;
        exception;
        exception = s;
          goto _L10
        exception1;
          goto _L6
    }


    public static AppInfo getInstance()
    {
        return SingletonHolder.INSTANCE;
    }
}
