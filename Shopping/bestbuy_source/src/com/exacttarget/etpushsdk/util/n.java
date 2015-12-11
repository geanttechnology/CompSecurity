// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.exacttarget.etpushsdk.ETPush;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

// Referenced classes of package com.exacttarget.etpushsdk.util:
//            m

public class n
{

    public static int a()
    {
        return c(ETPush.a());
    }

    public static String a(Date date)
    {
        if (date == null)
        {
            return null;
        } else
        {
            SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
            simpledateformat.setTimeZone(TimeZone.getTimeZone("UTC"));
            return simpledateformat.format(date);
        }
    }

    public static Date a(String s)
    {
        if (s == null)
        {
            return null;
        } else
        {
            SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
            simpledateformat.setTimeZone(TimeZone.getTimeZone("UTC"));
            return simpledateformat.parse(s);
        }
    }

    public static boolean a(Context context)
    {
        boolean flag = false;
        int i;
        try
        {
            i = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.flags;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            m.c("~!uk", context.getMessage());
            return false;
        }
        if ((i & 2) != 0)
        {
            flag = true;
        }
        return flag;
    }

    public static String b()
    {
        return d(ETPush.a());
    }

    public static String b(String s)
    {
        try
        {
            MessageDigest messagedigest = MessageDigest.getInstance("MD5");
            s = s.getBytes();
            messagedigest.update(s, 0, s.length);
            s = (new BigInteger(1, messagedigest.digest())).toString(16);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            m.c("~!uk", s.getMessage(), s);
            return "";
        }
        return s;
    }

    public static boolean b(Context context)
    {
        context = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        return context != null && context.isConnected();
    }

    public static int c(Context context)
    {
        if (context != null)
        {
            int i;
            try
            {
                i = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                throw new RuntimeException((new StringBuilder()).append("Could not get package name: ").append(context).toString());
            }
            return i;
        } else
        {
            return -1;
        }
    }

    public static String d(Context context)
    {
        if (context != null)
        {
            try
            {
                context = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                throw new RuntimeException((new StringBuilder()).append("Could not get package name: ").append(context).toString());
            }
            return context;
        } else
        {
            return "";
        }
    }
}
