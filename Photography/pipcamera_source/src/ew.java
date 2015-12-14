// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.util.DisplayMetrics;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class ew
{

    public static long a = 0x40000000L;

    public static int a(Context context)
    {
        return d(context, context.getResources().getDisplayMetrics().widthPixels);
    }

    public static int a(Context context, float f1)
    {
        return (int)(context.getResources().getDisplayMetrics().density * f1 + 0.5F);
    }

    public static String a(HashMap hashmap)
    {
        String s = "";
        try
        {
            for (Iterator iterator = hashmap.keySet().iterator(); iterator.hasNext();)
            {
                String s1 = (String)iterator.next();
                s = (new StringBuilder()).append(s).append("&").append(s1).append("=").append(URLEncoder.encode((String)hashmap.get(s1), "utf-8")).toString();
            }

        }
        // Misplaced declaration of an exception variable
        catch (HashMap hashmap)
        {
            return "";
        }
        return s;
    }

    public static void a(File file)
    {
        if (file != null && file.exists())
        {
            if (file.isFile())
            {
                file.delete();
            }
            if (file.isDirectory())
            {
                File afile[] = file.listFiles();
                if (afile == null || afile.length == 0)
                {
                    file.delete();
                }
                for (int i1 = 0; i1 < afile.length; i1++)
                {
                    a(afile[i1]);
                }

                file.delete();
                return;
            }
        }
    }

    public static boolean a()
    {
        boolean flag = false;
        Locale locale = Locale.getDefault();
        String s = locale.getLanguage();
        locale.getCountry();
        if (s.equalsIgnoreCase("zh"))
        {
            flag = true;
        }
        return flag;
    }

    public static boolean a(Context context, String s)
    {
        if (s != null)
        {
            try
            {
                context = context.getPackageManager().getPackageInfo(s, 0);
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                context = null;
            }
            if (context != null)
            {
                return true;
            }
        }
        return false;
    }

    public static boolean a(String s, String s1)
    {
        int i1;
        ArrayList arraylist;
        ArrayList arraylist1;
        int j1;
        int k1;
        int l1;
        try
        {
            String as[] = new String[20];
            as = new String[20];
            s = s.split("\\.");
            s1 = s1.split("\\.");
            j1 = Math.max(s.length, s1.length);
            arraylist = new ArrayList(Collections.nCopies(j1, Integer.valueOf(0)));
            arraylist1 = new ArrayList(Collections.nCopies(j1, Integer.valueOf(0)));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return false;
        }
        i1 = 0;
        if (i1 >= s.length)
        {
            break; /* Loop/switch isn't completed */
        }
        arraylist.add(i1, Integer.valueOf(s[i1]));
        i1++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_72;
_L5:
        if (i1 >= s1.length)
        {
            break MISSING_BLOCK_LABEL_211;
        }
        arraylist1.add(i1, Integer.valueOf(s1[i1]));
        i1++;
        continue; /* Loop/switch isn't completed */
_L3:
        if (k1 == l1)
        {
            i1++;
        } else
        {
            return k1 > l1;
        }
        for (; i1 >= j1; i1 = 0)
        {
            break MISSING_BLOCK_LABEL_203;
        }

        k1 = ((Integer)arraylist1.get(i1)).intValue();
        l1 = ((Integer)arraylist.get(i1)).intValue();
          goto _L3
        return true;
_L1:
        i1 = 0;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public static int b(Context context)
    {
        return d(context, context.getResources().getDisplayMetrics().heightPixels);
    }

    public static int b(Context context, float f1)
    {
        return (int)(f1 / context.getResources().getDisplayMetrics().scaledDensity + 0.5F);
    }

    public static Bitmap b(Context context, String s)
    {
        Object obj;
        Context context1;
        Object obj1;
        obj1 = null;
        context1 = null;
        obj = context1;
        if (s == null) goto _L2; else goto _L1
_L1:
        if (s.length() != 0) goto _L4; else goto _L3
_L3:
        obj = context1;
_L2:
        return ((Bitmap) (obj));
_L4:
        context = context.getAssets();
        context = context.open(s);
        s = obj1;
        context1 = context;
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_49;
        }
        s = BitmapFactory.decodeStream(context);
        context1 = context;
_L6:
        obj = s;
        if (context1 != null)
        {
            try
            {
                context1.close();
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                context.printStackTrace();
                return s;
            }
            return s;
        }
        if (true) goto _L2; else goto _L5
_L5:
        s;
        context = null;
_L7:
        s.printStackTrace();
        s = obj1;
        context1 = context;
          goto _L6
        s;
          goto _L7
    }

    public static boolean b()
    {
        boolean flag1 = false;
        Object obj = Locale.getDefault();
        String s = ((Locale) (obj)).getLanguage();
        obj = ((Locale) (obj)).getCountry();
        boolean flag = flag1;
        if (s.equalsIgnoreCase("zh"))
        {
            flag = flag1;
            if (((String) (obj)).equalsIgnoreCase("cn"))
            {
                flag = true;
            }
        }
        return flag;
    }

    public static float c(Context context)
    {
        return context.getResources().getDisplayMetrics().density;
    }

    public static int c(Context context, float f1)
    {
        return (int)(context.getResources().getDisplayMetrics().scaledDensity * f1 + 0.5F);
    }

    public static boolean c()
    {
        boolean flag;
label0:
        {
            boolean flag1 = false;
            Object obj = Locale.getDefault();
            String s = ((Locale) (obj)).getLanguage();
            obj = ((Locale) (obj)).getCountry();
            if (!s.equalsIgnoreCase("zh") || !((String) (obj)).equalsIgnoreCase("TW"))
            {
                flag = flag1;
                if (!s.equalsIgnoreCase("zh"))
                {
                    break label0;
                }
                flag = flag1;
                if (!((String) (obj)).equalsIgnoreCase("HK"))
                {
                    break label0;
                }
            }
            flag = true;
        }
        return flag;
    }

    public static int d(Context context)
    {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int d(Context context, float f1)
    {
        return (int)(f1 / context.getResources().getDisplayMetrics().density + 0.5F);
    }

    public static int e(Context context)
    {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static float f(Context context)
    {
        return context.getResources().getDisplayMetrics().scaledDensity;
    }

    public static HashMap g(Context context)
    {
        HashMap hashmap = new HashMap();
        try
        {
            hashmap.put("openuuid", eu.a(((WifiManager)context.getSystemService("wifi")).getConnectionInfo().getMacAddress()));
            hashmap.put("os", "android");
            String s = Locale.getDefault().getLanguage();
            String s1 = Locale.getDefault().getLanguage();
            String s2 = Locale.getDefault().getCountry();
            hashmap.put("langcode", s);
            hashmap.put("countrycode", s2);
            hashmap.put("prelang", s1);
            hashmap.put("devicetype", Build.MODEL);
            hashmap.put("deviceVersion", android.os.Build.VERSION.RELEASE);
            hashmap.put("ver", h(context));
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            return hashmap;
        }
        return hashmap;
    }

    public static String h(Context context)
    {
        String s = null;
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

    public static String i(Context context)
    {
        try
        {
            context = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName.trim();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            return "";
        }
        return context;
    }

    public static String j(Context context)
    {
        try
        {
            context = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            return "";
        }
        return context;
    }

    public static boolean k(Context context)
    {
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_31;
        }
        context = ((ConnectivityManager)context.getSystemService("connectivity")).getNetworkInfo(1);
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_31;
        }
        boolean flag = context.isConnected();
        return flag;
        context;
        return false;
    }

    public static boolean l(Context context)
    {
        context = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        return context != null && context.isConnectedOrConnecting();
    }

    public static long m(Context context)
    {
        if (gb.f())
        {
            long l1;
            try
            {
                context = (ActivityManager)context.getSystemService("activity");
                android.app.ActivityManager.MemoryInfo memoryinfo = new android.app.ActivityManager.MemoryInfo();
                context.getMemoryInfo(memoryinfo);
                l1 = memoryinfo.totalMem;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                return 0L;
            }
            return l1;
        } else
        {
            return 0L;
        }
    }

    public static boolean n(Context context)
    {
        if (context != null)
        {
            int i1;
            int j1;
            try
            {
                new DisplayMetrics();
                context = context.getApplicationContext().getResources().getDisplayMetrics();
                i1 = ((DisplayMetrics) (context)).heightPixels;
                j1 = ((DisplayMetrics) (context)).widthPixels;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                context.printStackTrace();
                return false;
            }
            if (j1 + i1 < 1280)
            {
                return true;
            }
        }
        return false;
    }

}
