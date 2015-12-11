// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.arellomobile.android.push.request;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.arellomobile.android.push.utils.GeneralUtils;
import java.util.Calendar;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

// Referenced classes of package com.arellomobile.android.push.request:
//            PushRequest

public class RegisterDeviceRequest extends PushRequest
{

    private static final String AMAZON = "9";
    private static final String GOOGLE = "3";
    private String pushToken;

    public RegisterDeviceRequest(String s)
    {
        pushToken = s;
    }

    private String capitalize(String s)
    {
        String s1;
        if (s == null || s.length() == 0)
        {
            s1 = "";
        } else
        {
            char c = s.charAt(0);
            s1 = s;
            if (!Character.isUpperCase(c))
            {
                return (new StringBuilder()).append(Character.toUpperCase(c)).append(s.substring(1)).toString();
            }
        }
        return s1;
    }

    protected void buildParams(Context context, Map map)
    {
        String s;
        if (GeneralUtils.isTablet(context))
        {
            s = "Tablet";
        } else
        {
            s = "Phone";
        }
        map.put("device_name", s);
        if (GeneralUtils.isAmazonDevice())
        {
            map.put("device_type", "9");
        } else
        {
            map.put("device_type", "3");
        }
        map.put("v", "2.2");
        map.put("language", Locale.getDefault().getLanguage());
        map.put("timezone", Integer.valueOf(Calendar.getInstance().getTimeZone().getRawOffset() / 1000));
        s = context.getPackageName();
        map.put("android_package", s);
        map.put("push_token", pushToken);
        map.put("sounds", GeneralUtils.getRawResourses(context));
        if (context.getPackageManager().getInstallerPackageName(s) == null)
        {
            map.put("jailbroken", Integer.valueOf(1));
        } else
        {
            map.put("jailbroken", Integer.valueOf(0));
        }
        map.put("device_model", getDeviceName());
        map.put("os_version", android.os.Build.VERSION.RELEASE);
        try
        {
            map.put("app_version", context.getPackageManager().getPackageInfo(s, 0).versionName);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
    }

    public String getDeviceName()
    {
        String s = Build.MANUFACTURER;
        String s1 = Build.MODEL;
        if (s1.startsWith(s))
        {
            return capitalize(s1);
        } else
        {
            return (new StringBuilder()).append(capitalize(s)).append(" ").append(s1).toString();
        }
    }

    public String getMethod()
    {
        return "registerDevice";
    }
}
