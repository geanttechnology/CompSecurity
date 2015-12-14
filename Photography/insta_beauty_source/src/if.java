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

public class if
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

    public static String a(int l)
    {
        if (l == -1)
        {
            return null;
        }
        if (l <= 10)
        {
            return (new StringBuilder()).append("").append(l).toString();
        }
        if (l <= 15 && l > 10)
        {
            return "11~15";
        }
        if (l <= 20 && l > 15)
        {
            return "16~20";
        }
        if (l <= 25 && l > 20)
        {
            return "21~25";
        }
        if (l <= 30 && l > 25)
        {
            return "26~30";
        }
        if (l <= 35 && l > 30)
        {
            return "31~35";
        }
        if (l <= 40 && l > 35)
        {
            return "36~40";
        }
        if (l <= 45 && l > 40)
        {
            return "41~45";
        }
        if (l <= 50 && l > 45)
        {
            return "46~50";
        }
        if (l <= 60 && l > 50)
        {
            return "51~60";
        }
        if (l <= 70 && l > 60)
        {
            return "61~70";
        }
        if (l <= 80 && l > 70)
        {
            return "71~80";
        }
        if (l <= 90 && l > 80)
        {
            return "81~90";
        }
        if (l <= 100 && l > 90)
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
        return d(context);
    }

    public static String c()
    {
        return Locale.getDefault().getLanguage();
    }

    public static String c(Context context)
    {
        try
        {
            context = context.getPackageManager().getInstallerPackageName(context.getPackageName());
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return "";
        }
        return context;
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
            s = ((PackageInfo) (context)).versionName;
        }
        return s;
    }

    public static String f()
    {
        return "android";
    }

    public static String f(Context context)
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

    public static int g(Context context)
    {
        int i1 = -1;
        if (context != null) goto _L2; else goto _L1
_L1:
        return -1;
_L2:
        int l = i1;
        if (!context.getPackageName().equalsIgnoreCase(ie.e))
        {
            break MISSING_BLOCK_LABEL_77;
        }
        l = i1;
        try
        {
            i1 = context.getSharedPreferences("sysconfig", 0).getInt("appOpenedTimes", 0);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return l;
        }
        l = i1;
        Log.e("OpenTimes", (new StringBuilder()).append(context.getPackageName()).append(" opentimes:").append(i1).toString());
        return i1;
        l = i1;
        if (!context.getPackageName().equalsIgnoreCase(ie.b))
        {
            break MISSING_BLOCK_LABEL_146;
        }
        l = i1;
        i1 = context.getSharedPreferences("sysconfig", 0).getInt("APP_OPEN_TIME", 0);
        l = i1;
        Log.e("OpenTimes", (new StringBuilder()).append(context.getPackageName()).append(" opentimes:").append(i1).toString());
        return i1;
        l = i1;
        if (!context.getPackageName().equalsIgnoreCase(ie.c))
        {
            break MISSING_BLOCK_LABEL_215;
        }
        l = i1;
        i1 = context.getSharedPreferences("wantu_shareprefsname", 0).getInt("appOpenedTimes", 0);
        l = i1;
        Log.e("OpenTimes", (new StringBuilder()).append(context.getPackageName()).append(" opentimes:").append(i1).toString());
        return i1;
        l = i1;
        if (!context.getPackageName().equalsIgnoreCase(ie.a))
        {
            break MISSING_BLOCK_LABEL_284;
        }
        l = i1;
        i1 = context.getSharedPreferences("sysconfig", 0).getInt("appOpenedTimes", 0);
        l = i1;
        Log.e("OpenTimes", (new StringBuilder()).append(context.getPackageName()).append(" opentimes:").append(i1).toString());
        return i1;
        l = i1;
        if (!context.getPackageName().equalsIgnoreCase(ie.l))
        {
            break MISSING_BLOCK_LABEL_353;
        }
        l = i1;
        i1 = context.getSharedPreferences("sysconfig", 0).getInt("APP_OPEN_TIME", 0);
        l = i1;
        Log.e("OpenTimes", (new StringBuilder()).append(context.getPackageName()).append(" APP_OPEN_TIME:").append(i1).toString());
        return i1;
        l = i1;
        if (!context.getPackageName().equalsIgnoreCase(ie.j))
        {
            break MISSING_BLOCK_LABEL_422;
        }
        l = i1;
        i1 = context.getSharedPreferences("sysconfig", 0).getInt("APP_OPEN_TIME", 0);
        l = i1;
        Log.e("OpenTimes", (new StringBuilder()).append(context.getPackageName()).append(" opentimes:").append(i1).toString());
        return i1;
        l = i1;
        if (!context.getPackageName().equalsIgnoreCase(ie.k)) goto _L1; else goto _L3
_L3:
        l = i1;
        i1 = context.getSharedPreferences("wantu_shareprefsname", 0).getInt("appOpenedTimes", 0);
        l = i1;
        Log.e("OpenTimes", (new StringBuilder()).append(context.getPackageName()).append(" opentimes:").append(i1).toString());
        return i1;
    }

    public static String h(Context context)
    {
        return FotoCustomReport.getFOTOUUID(context);
    }

    public static String i(Context context)
    {
        String s = h(context);
        if (s != null && s.length() > 0)
        {
            int l = s.lastIndexOf(',');
            if (l > -1 && l < s.length() - 1)
            {
                return s.substring(l + 1);
            }
        }
        return FotoCustomReport.getFOTOUUID(context);
    }

    public static int j(Context context)
    {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int k(Context context)
    {
        return context.getResources().getDisplayMetrics().heightPixels;
    }
}
