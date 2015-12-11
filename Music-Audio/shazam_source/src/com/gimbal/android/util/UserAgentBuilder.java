// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.android.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.gimbal.a.b;
import com.gimbal.internal.c.c;
import com.gimbal.proguard.Keep;
import java.net.URL;
import java.util.Properties;

public class UserAgentBuilder
    implements Keep
{

    public static final String CLOSE_BRACKETS = ")";
    public static final String COMMA = ",";
    public static final String GIMBAL_SDK_VERSION_KEY = "com.gimbal";
    public static final String OPEN_BRACKETS = "(";
    public static final String PLATFORM = "Android";
    public static final String SEPARATOR = "/";
    public static final String SPACE = " ";
    public static final String UNKNOWN = "UNKNOWN";
    private static final b publicLogger = c.f(com/gimbal/android/util/UserAgentBuilder.getName());
    private final Context context;

    public UserAgentBuilder(Context context1)
    {
        context = context1;
    }

    private String getApplicationVersionCode()
    {
        int i;
        try
        {
            i = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        }
        catch (Exception exception)
        {
            return "UNKNOWN";
        }
        return String.valueOf(i);
    }

    private String getBuildProperty(String s)
    {
        String s1 = s;
        if (s == null)
        {
            s1 = "UNKNOWN";
        }
        return s1;
    }

    private String getGimbalSDKReleaseVersion()
    {
        Object obj = new Properties();
        URL url = com/gimbal/android/util/UserAgentBuilder.getResource("maven.properties");
        try
        {
            ((Properties) (obj)).load(url.openStream());
            obj = ((Properties) (obj)).getProperty("gimbal.sdk.version");
        }
        catch (Exception exception)
        {
            publicLogger.d("Unable to load SDK version. Make sure maven.properties is in the same directory structure as UserAgentBuilder", new Object[0]);
            return "UNKNOWN";
        }
        return ((String) (obj));
    }

    public String getUserAgent(String s)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(context.getPackageName());
        stringbuilder.append("/");
        stringbuilder.append(getApplicationVersionCode());
        stringbuilder.append(" ");
        stringbuilder.append("com.gimbal");
        stringbuilder.append("/");
        stringbuilder.append(getGimbalSDKReleaseVersion());
        stringbuilder.append(" ");
        stringbuilder.append("(");
        stringbuilder.append("Android");
        stringbuilder.append(" ");
        stringbuilder.append(android.os.Build.VERSION.RELEASE);
        stringbuilder.append(",");
        stringbuilder.append(getBuildProperty(Build.MODEL));
        stringbuilder.append(",");
        stringbuilder.append(getBuildProperty(Build.MANUFACTURER));
        stringbuilder.append(")");
        if (s != null)
        {
            stringbuilder.append(" ");
            stringbuilder.append("(");
            stringbuilder.append(s);
            stringbuilder.append(")");
        }
        return stringbuilder.toString();
    }

}
