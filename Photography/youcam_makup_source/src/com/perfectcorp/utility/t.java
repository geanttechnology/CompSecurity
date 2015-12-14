// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.perfectcorp.utility;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Build;
import com.cyberlink.beautycircle.Globals;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.perfectcorp.utility:
//            h, e

public class t
{

    public static StringBuilder a(Context context)
    {
        Object obj = context.getPackageManager().getInstalledApplications(128);
        context = new StringBuilder("[\"");
        obj = ((List) (obj)).iterator();
        if (((Iterator) (obj)).hasNext())
        {
            context.append(((ApplicationInfo)((Iterator) (obj)).next()).packageName);
        }
        ApplicationInfo applicationinfo;
        for (; ((Iterator) (obj)).hasNext(); context.append(applicationinfo.packageName))
        {
            applicationinfo = (ApplicationInfo)((Iterator) (obj)).next();
            context.append("\", \"");
        }

        context.append("\"]");
        return context;
    }

    public static boolean a()
    {
        return f() || g() || h();
    }

    public static void b()
    {
        AsyncTask.execute(new Runnable() {

            public void run()
            {
                t.c();
            }

        });
    }

    public static File[] b(Context context)
    {
        Object obj = null;
        Object obj1 = context.getPackageManager();
        try
        {
            context = ((PackageManager) (obj1)).getPackageInfo(context.getPackageName(), 0).applicationInfo.dataDir;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            com.perfectcorp.utility.e.e(new Object[] {
                context
            });
            return null;
        }
        obj1 = new File((new StringBuilder()).append(context).append("/shared_prefs").toString());
        context = obj;
        if (((File) (obj1)).isDirectory())
        {
            context = ((File) (obj1)).listFiles(com.perfectcorp.utility.h.d(".xml"));
        }
        return context;
    }

    public static void c()
    {
        String s = android.os.Build.VERSION.RELEASE;
        SharedPreferences sharedpreferences = Globals.D();
        String s1 = sharedpreferences.getString("OsUpgradeHistory", "");
        if (s1.isEmpty())
        {
            sharedpreferences.edit().putString("OsUpgradeHistory", s).commit();
        } else
        {
            int i = s1.lastIndexOf(";");
            if (i <= 0)
            {
                i = 0;
            } else
            {
                i++;
            }
            if (!s1.substring(i, s1.length()).equalsIgnoreCase(s))
            {
                s = (new StringBuilder()).append(s1).append(";").append(s).toString();
                sharedpreferences.edit().putString("OsUpgradeHistory", s).commit();
                return;
            }
        }
    }

    public static String d()
    {
        return Globals.D().getString("OsUpgradeHistory", "");
    }

    public static boolean e()
    {
        Matcher matcher;
        int i;
        if (Build.MANUFACTURER.equalsIgnoreCase("motorola"))
        {
            if ((matcher = Pattern.compile("XT(\\d{4})").matcher(Build.MODEL)).find() && ((i = Integer.parseInt(matcher.group(1))) > 1060 && i < 1070))
            {
                return true;
            }
        }
        return false;
    }

    private static boolean f()
    {
        String s = Build.TAGS;
        return s != null && s.contains("test-keys");
    }

    private static boolean g()
    {
        String as[] = new String[9];
        as[0] = "/system/app/Superuser.apk";
        as[1] = "/sbin/su";
        as[2] = "/system/bin/su";
        as[3] = "/system/xbin/su";
        as[4] = "/data/local/xbin/su";
        as[5] = "/data/local/bin/su";
        as[6] = "/system/sd/xbin/su";
        as[7] = "/system/bin/failsafe/su";
        as[8] = "/data/local/su";
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            if ((new File(as[i])).exists())
            {
                return true;
            }
        }

        return false;
    }

    private static boolean h()
    {
        Object obj1 = null;
        Object obj = Runtime.getRuntime().exec(new String[] {
            "/system/xbin/which", "su"
        });
        obj1 = obj;
        String s = (new BufferedReader(new InputStreamReader(((Process) (obj)).getInputStream()))).readLine();
        if (s != null)
        {
            if (obj != null)
            {
                ((Process) (obj)).destroy();
            }
            return true;
        }
        if (obj != null)
        {
            ((Process) (obj)).destroy();
        }
        return false;
        obj;
        obj = null;
_L2:
        if (obj != null)
        {
            ((Process) (obj)).destroy();
        }
        return false;
        Exception exception;
        exception;
        if (obj1 != null)
        {
            ((Process) (obj1)).destroy();
        }
        throw exception;
        Throwable throwable;
        throwable;
        if (true) goto _L2; else goto _L1
_L1:
    }
}
