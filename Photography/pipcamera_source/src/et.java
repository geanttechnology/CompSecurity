// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import com.fotoable.ad.FotoCustomReport;
import java.util.Locale;

public class et
{

    public static String a()
    {
        String s;
        try
        {
            s = String.format("%d", new Object[] {
                Integer.valueOf(android.os.Build.VERSION.SDK_INT)
            });
        }
        catch (Exception exception)
        {
            return "";
        }
        return s;
    }

    public static String a(int k)
    {
        if (k == -1)
        {
            return null;
        }
        if (k <= 10)
        {
            return (new StringBuilder()).append("").append(k).toString();
        }
        if (k <= 15 && k > 10)
        {
            return "11~15";
        }
        if (k <= 20 && k > 15)
        {
            return "16~20";
        }
        if (k <= 25 && k > 20)
        {
            return "21~25";
        }
        if (k <= 30 && k > 25)
        {
            return "26~30";
        }
        if (k <= 35 && k > 30)
        {
            return "31~35";
        }
        if (k <= 40 && k > 35)
        {
            return "36~40";
        }
        if (k <= 45 && k > 40)
        {
            return "41~45";
        }
        if (k <= 50 && k > 45)
        {
            return "46~50";
        }
        if (k <= 60 && k > 50)
        {
            return "51~60";
        }
        if (k <= 70 && k > 60)
        {
            return "61~70";
        }
        if (k <= 80 && k > 70)
        {
            return "71~80";
        }
        if (k <= 90 && k > 80)
        {
            return "81~90";
        }
        if (k <= 100 && k > 90)
        {
            return "91~100";
        } else
        {
            return ">100";
        }
    }

    public static boolean a(Context context)
    {
        return context.getSharedPreferences("DeviceTestSharedPreferences", 0).getBoolean("DeviceTestSharedPreferencesTag", false);
    }

    public static String b()
    {
        return Locale.getDefault().getCountry();
    }

    public static String b(Context context)
    {
        return c(context);
    }

    public static String c()
    {
        return Locale.getDefault().getLanguage();
    }

    public static String c(Context context)
    {
        String s = "";
        PackageInfo packageinfo;
        try
        {
            packageinfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            namenotfoundexception.printStackTrace();
            namenotfoundexception = null;
        }
        if (packageinfo != null)
        {
            s = context.getPackageName();
        }
        return s;
    }

    public static String d()
    {
label0:
        {
            Object obj = Locale.getDefault();
            String s1 = ((Locale) (obj)).getCountry();
            String s = ((Locale) (obj)).getLanguage();
            obj = s;
            if (s.equalsIgnoreCase("zh"))
            {
                if (!s1.equalsIgnoreCase("CN"))
                {
                    break label0;
                }
                obj = "zh-Hans";
            }
            return ((String) (obj));
        }
        return "zh-Hant";
    }

    public static String d(Context context)
    {
        String s = "";
        try
        {
            context = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            context = null;
        }
        if (context != null)
        {
            s = ((PackageInfo) (context)).versionName;
        }
        return s;
    }

    public static String e()
    {
        String s;
        try
        {
            s = Build.MODEL;
        }
        catch (Exception exception)
        {
            return "";
        }
        return s;
    }

    public static String e(Context context)
    {
        String s = "";
        try
        {
            context = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            context = null;
        }
        if (context != null)
        {
            s = (new StringBuilder()).append("").append(((PackageInfo) (context)).versionCode).toString();
        }
        return s;
    }

    public static int f(Context context)
    {
        int l = -1;
        if (context != null) goto _L2; else goto _L1
_L1:
        return -1;
_L2:
        int k = l;
        if (!context.getPackageName().equalsIgnoreCase(es.e))
        {
            break MISSING_BLOCK_LABEL_77;
        }
        k = l;
        try
        {
            l = context.getSharedPreferences("sysconfig", 0).getInt("appOpenedTimes", 0);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return k;
        }
        k = l;
        Log.e("OpenTimes", (new StringBuilder()).append(context.getPackageName()).append(" opentimes:").append(l).toString());
        return l;
        k = l;
        if (!context.getPackageName().equalsIgnoreCase(es.b))
        {
            break MISSING_BLOCK_LABEL_146;
        }
        k = l;
        l = context.getSharedPreferences("sysconfig", 0).getInt("APP_OPEN_TIME", 0);
        k = l;
        Log.e("OpenTimes", (new StringBuilder()).append(context.getPackageName()).append(" opentimes:").append(l).toString());
        return l;
        k = l;
        if (!context.getPackageName().equalsIgnoreCase(es.c))
        {
            break MISSING_BLOCK_LABEL_215;
        }
        k = l;
        l = context.getSharedPreferences("wantu_shareprefsname", 0).getInt("appOpenedTimes", 0);
        k = l;
        Log.e("OpenTimes", (new StringBuilder()).append(context.getPackageName()).append(" opentimes:").append(l).toString());
        return l;
        k = l;
        if (!context.getPackageName().equalsIgnoreCase(es.a))
        {
            break MISSING_BLOCK_LABEL_284;
        }
        k = l;
        l = context.getSharedPreferences("sysconfig", 0).getInt("appOpenedTimes", 0);
        k = l;
        Log.e("OpenTimes", (new StringBuilder()).append(context.getPackageName()).append(" opentimes:").append(l).toString());
        return l;
        k = l;
        if (!context.getPackageName().equalsIgnoreCase(es.l))
        {
            break MISSING_BLOCK_LABEL_353;
        }
        k = l;
        l = context.getSharedPreferences("sysconfig", 0).getInt("APP_OPEN_TIME", 0);
        k = l;
        Log.e("OpenTimes", (new StringBuilder()).append(context.getPackageName()).append(" APP_OPEN_TIME:").append(l).toString());
        return l;
        k = l;
        if (!context.getPackageName().equalsIgnoreCase(es.j))
        {
            break MISSING_BLOCK_LABEL_422;
        }
        k = l;
        l = context.getSharedPreferences("sysconfig", 0).getInt("APP_OPEN_TIME", 0);
        k = l;
        Log.e("OpenTimes", (new StringBuilder()).append(context.getPackageName()).append(" opentimes:").append(l).toString());
        return l;
        k = l;
        if (!context.getPackageName().equalsIgnoreCase(es.k)) goto _L1; else goto _L3
_L3:
        k = l;
        l = context.getSharedPreferences("wantu_shareprefsname", 0).getInt("appOpenedTimes", 0);
        k = l;
        Log.e("OpenTimes", (new StringBuilder()).append(context.getPackageName()).append(" opentimes:").append(l).toString());
        return l;
    }

    public static String f()
    {
        return "android";
    }

    public static String g(Context context)
    {
        return FotoCustomReport.getFOTOUUID(context);
    }

    public static String h(Context context)
    {
        String s = g(context);
        if (s != null && s.length() > 0)
        {
            int k = s.lastIndexOf(',');
            if (k > -1 && k < s.length() - 1)
            {
                return s.substring(k + 1);
            }
        }
        return FotoCustomReport.getFOTOUUID(context);
    }

    public static int i(Context context)
    {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int j(Context context)
    {
        return context.getResources().getDisplayMetrics().heightPixels;
    }
}
