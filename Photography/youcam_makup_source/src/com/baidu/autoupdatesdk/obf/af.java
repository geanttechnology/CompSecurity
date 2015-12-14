// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.autoupdatesdk.obf;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.graphics.drawable.Drawable;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.List;

// Referenced classes of package com.baidu.autoupdatesdk.obf:
//            v

public class af
{

    public af()
    {
    }

    private static byte a(char c1)
    {
        return (byte)"0123456789ABCDEF".indexOf(c1);
    }

    public static String a(long l)
    {
        return String.format("%.2fMB", new Object[] {
            Float.valueOf((float)l / 1048576F)
        });
    }

    public static String a(Context context)
    {
        PackageManager packagemanager = context.getPackageManager();
        try
        {
            context = packagemanager.getPackageInfo(context.getPackageName(), 0).versionName;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            return null;
        }
        return context;
    }

    public static byte[] a(String s)
    {
        if (s != null && !s.equals("")) goto _L2; else goto _L1
_L1:
        s = null;
_L4:
        return s;
_L2:
        s = s.toUpperCase(v.b);
        int j = s.length() / 2;
        char ac[] = s.toCharArray();
        byte abyte0[] = new byte[j];
        int i = 0;
        do
        {
            s = abyte0;
            if (i >= j)
            {
                continue;
            }
            int k = i * 2;
            byte byte0 = a(ac[k]);
            abyte0[i] = (byte)(a(ac[k + 1]) | byte0 << 4);
            i++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static int b(Context context)
    {
        PackageManager packagemanager = context.getPackageManager();
        int i;
        try
        {
            i = packagemanager.getPackageInfo(context.getPackageName(), 0).versionCode;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            return -1;
        }
        return i;
    }

    public static Drawable c(Context context)
    {
        PackageManager packagemanager = context.getPackageManager();
        try
        {
            context = packagemanager.getApplicationIcon(context.getPackageName());
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            return null;
        }
        return context;
    }

    public static String d(Context context)
    {
        try
        {
            context = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0];
            context = ((X509Certificate)CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(context.toByteArray()))).getSerialNumber().toString();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            return null;
        }
        return context;
    }

    public static boolean e(Context context)
    {
        Object obj = ((ActivityManager)context.getSystemService("activity")).getRunningTasks(1);
        if (obj != null && !((List) (obj)).isEmpty())
        {
            obj = (android.app.ActivityManager.RunningTaskInfo)((List) (obj)).get(0);
            if (context.getPackageName().equals(((android.app.ActivityManager.RunningTaskInfo) (obj)).topActivity.getPackageName()))
            {
                return true;
            }
        }
        return false;
    }
}
