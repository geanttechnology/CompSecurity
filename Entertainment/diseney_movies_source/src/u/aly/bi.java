// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Environment;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import javax.microedition.khronos.opengles.GL10;

// Referenced classes of package u.aly:
//            bj, bv

public class bi
{

    protected static final String a = u/aly/bi.getName();
    public static final String b = "";
    public static final String c = "2G/3G";
    public static final String d = "Wi-Fi";
    public static final int e = 8;

    public bi()
    {
    }

    private static int a(Object obj, String s1)
    {
        int i1;
        try
        {
            s1 = android/util/DisplayMetrics.getDeclaredField(s1);
            s1.setAccessible(true);
            i1 = s1.getInt(obj);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((Exception) (obj)).printStackTrace();
            return -1;
        }
        return i1;
    }

    public static int a(Date date, Date date1)
    {
        Date date2;
        long l1;
        if (date.after(date1))
        {
            date2 = date1;
            date1 = date;
        } else
        {
            date2 = date;
        }
        l1 = date2.getTime();
        return (int)((date1.getTime() - l1) / 1000L);
    }

    public static String a()
    {
        String s1;
        String s2;
        String s3;
        Object obj;
        s3 = null;
        obj = null;
        s2 = null;
        s1 = obj;
        FileReader filereader = new FileReader("/proc/cpuinfo");
        s1 = s2;
        if (filereader == null)
        {
            break MISSING_BLOCK_LABEL_74;
        }
        s2 = s3;
        s1 = obj;
        BufferedReader bufferedreader = new BufferedReader(filereader, 1024);
        s2 = s3;
        s1 = obj;
        s3 = bufferedreader.readLine();
        s2 = s3;
        s1 = s3;
        bufferedreader.close();
        s2 = s3;
        s1 = s3;
        filereader.close();
        s1 = s3;
_L1:
        FileNotFoundException filenotfoundexception;
        IOException ioexception;
        if (s1 != null)
        {
            return s1.substring(s1.indexOf(':') + 1).trim();
        } else
        {
            return "";
        }
        ioexception;
        s1 = s2;
        bj.b(a, "Could not read from file /proc/cpuinfo", ioexception);
        s1 = s2;
          goto _L1
        filenotfoundexception;
        bj.b(a, "Could not open file /proc/cpuinfo", filenotfoundexception);
          goto _L1
    }

    public static String a(Date date)
    {
        return (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US)).format(date);
    }

    public static Date a(String s1)
    {
        try
        {
            s1 = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US)).parse(s1);
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            return null;
        }
        return s1;
    }

    public static boolean a(Context context)
    {
        return context.getResources().getConfiguration().locale.toString().equals(Locale.CHINA.toString());
    }

    public static boolean a(Context context, String s1)
    {
        return context.getPackageManager().checkPermission(s1, context.getPackageName()) == 0;
    }

    public static boolean a(String s1, Context context)
    {
        context = context.getPackageManager();
        try
        {
            context.getPackageInfo(s1, 1);
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            return false;
        }
        return true;
    }

    public static String[] a(GL10 gl10)
    {
        String s1;
        try
        {
            s1 = gl10.glGetString(7936);
            gl10 = gl10.glGetString(7937);
        }
        // Misplaced declaration of an exception variable
        catch (GL10 gl10)
        {
            bj.b(a, "Could not read gpu infor:", gl10);
            return new String[0];
        }
        return (new String[] {
            s1, gl10
        });
    }

    public static boolean b()
    {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static boolean b(Context context)
    {
        return context.getResources().getConfiguration().orientation == 1;
    }

    public static String c()
    {
        Date date = new Date();
        return (new SimpleDateFormat("yyyy-MM-dd", Locale.US)).format(date);
    }

    public static String c(Context context)
    {
        int i1;
        try
        {
            i1 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return "";
        }
        return String.valueOf(i1);
    }

    public static String d(Context context)
    {
        try
        {
            context = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return "";
        }
        return context;
    }

    public static String e(Context context)
    {
        PackageManager packagemanager = context.getPackageManager();
        try
        {
            context = packagemanager.getApplicationInfo(context.getPackageName(), 0);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context = null;
        }
        if (context != null)
        {
            context = packagemanager.getApplicationLabel(context);
        } else
        {
            context = "";
        }
        return (String)context;
    }

    public static String f(Context context)
    {
        TelephonyManager telephonymanager;
        telephonymanager = (TelephonyManager)context.getSystemService("phone");
        if (telephonymanager == null)
        {
            bj.e(a, "No IMEI.");
        }
        if (!a(context, "android.permission.READ_PHONE_STATE")) goto _L2; else goto _L1
_L1:
        String s2 = telephonymanager.getDeviceId();
_L4:
        String s1 = s2;
        if (TextUtils.isEmpty(s2))
        {
            bj.e(a, "No IMEI.");
            s2 = p(context);
            s1 = s2;
            if (TextUtils.isEmpty(s2))
            {
                bj.e(a, "Failed to take mac as IMEI. Try to use Secure.ANDROID_ID instead.");
                s1 = android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id");
                bj.a(a, (new StringBuilder("getDeviceId: Secure.ANDROID_ID: ")).append(s1).toString());
            }
        }
        return s1;
        Exception exception;
        exception;
        bj.e(a, "No IMEI.", exception);
_L2:
        s2 = "";
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static String g(Context context)
    {
        return bv.b(f(context));
    }

    public static String h(Context context)
    {
        try
        {
            context = (TelephonyManager)context.getSystemService("phone");
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            return "";
        }
        if (context == null)
        {
            return "";
        }
        context = context.getNetworkOperatorName();
        return context;
    }

    public static String i(Context context)
    {
        try
        {
            DisplayMetrics displaymetrics = new DisplayMetrics();
            ((WindowManager)context.getSystemService("window")).getDefaultDisplay().getMetrics(displaymetrics);
            int i1 = displaymetrics.widthPixels;
            context = (new StringBuilder(String.valueOf(String.valueOf(displaymetrics.heightPixels)))).append("*").append(String.valueOf(i1)).toString();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            return "";
        }
        return context;
    }

    public static String[] j(Context context)
    {
        String as[];
        as = new String[2];
        as[0] = "";
        as[1] = "";
        if (context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) != 0)
        {
            as[0] = "";
            return as;
        }
        context = (ConnectivityManager)context.getSystemService("connectivity");
        if (context == null)
        {
            as[0] = "";
            return as;
        }
        if (context.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.CONNECTED)
        {
            as[0] = "Wi-Fi";
            return as;
        }
        context = context.getNetworkInfo(0);
        if (context.getState() != android.net.NetworkInfo.State.CONNECTED)
        {
            break MISSING_BLOCK_LABEL_117;
        }
        as[0] = "2G/3G";
        as[1] = context.getSubtypeName();
        return as;
        context;
        context.printStackTrace();
        return as;
    }

    public static boolean k(Context context)
    {
        return "Wi-Fi".equals(j(context)[0]);
    }

    public static boolean l(Context context)
    {
        boolean flag;
        try
        {
            context = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return true;
        }
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_25;
        }
        flag = context.isConnectedOrConnecting();
        return flag;
        return false;
    }

    public static int m(Context context)
    {
        context = Calendar.getInstance(x(context));
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_37;
        }
        int i1 = context.getTimeZone().getRawOffset() / 0x36ee80;
        return i1;
        context;
        bj.a(a, "error in getTimeZone", context);
        return 8;
    }

    public static String[] n(Context context)
    {
        String as[] = new String[2];
        try
        {
            context = x(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            bj.b(a, "error in getLocaleInfo", context);
            return as;
        }
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_28;
        }
        as[0] = context.getCountry();
        as[1] = context.getLanguage();
        if (TextUtils.isEmpty(as[0]))
        {
            as[0] = "Unknown";
        }
        if (TextUtils.isEmpty(as[1]))
        {
            as[1] = "Unknown";
        }
        return as;
    }

    public static String o(Context context)
    {
        context = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        context = ((ApplicationInfo) (context)).metaData.getString("UMENG_APPKEY");
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_39;
        }
        return context.trim();
        bj.b(a, "Could not read UMENG_APPKEY meta-data from AndroidManifest.xml.");
_L2:
        return null;
        context;
        bj.b(a, "Could not read UMENG_APPKEY meta-data from AndroidManifest.xml.", context);
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static String p(Context context)
    {
        try
        {
            WifiManager wifimanager = (WifiManager)context.getSystemService("wifi");
            if (a(context, "android.permission.ACCESS_WIFI_STATE"))
            {
                return wifimanager.getConnectionInfo().getMacAddress();
            }
            bj.e(a, "Could not get mac address.[no permission android.permission.ACCESS_WIFI_STATE");
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            bj.e(a, (new StringBuilder("Could not get mac address.")).append(context.toString()).toString());
        }
        return "";
    }

    public static String q(Context context)
    {
        context = r(context);
        if (context != null)
        {
            StringBuffer stringbuffer = new StringBuffer();
            stringbuffer.append(context[0]);
            stringbuffer.append("*");
            stringbuffer.append(context[1]);
            return stringbuffer.toString();
        } else
        {
            return "Unknown";
        }
    }

    public static int[] r(Context context)
    {
        DisplayMetrics displaymetrics;
        displaymetrics = new DisplayMetrics();
        ((WindowManager)context.getSystemService("window")).getDefaultDisplay().getMetrics(displaymetrics);
        if ((context.getApplicationInfo().flags & 0x2000) != 0) goto _L2; else goto _L1
_L1:
        int i1;
        int j1;
        j1 = a(displaymetrics, "noncompatWidthPixels");
        i1 = a(displaymetrics, "noncompatHeightPixels");
          goto _L3
_L5:
        int k1;
        try
        {
            i1 = displaymetrics.widthPixels;
            j1 = displaymetrics.heightPixels;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            bj.b(a, "read resolution fail", context);
            return null;
        }
        k1 = i1;
        i1 = j1;
_L4:
        context = new int[2];
        if (k1 > i1)
        {
            context[0] = i1;
            context[1] = k1;
            return context;
        } else
        {
            context[0] = k1;
            context[1] = i1;
            return context;
        }
_L6:
        k1 = j1;
        if (true) goto _L4; else goto _L2
_L2:
        i1 = -1;
        j1 = -1;
_L3:
        if (j1 != -1 && i1 != -1) goto _L6; else goto _L5
    }

    public static String s(Context context)
    {
        try
        {
            context = ((TelephonyManager)context.getSystemService("phone")).getNetworkOperatorName();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            bj.a(a, "read carrier fail", context);
            return "Unknown";
        }
        return context;
    }

    public static String t(Context context)
    {
        context = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_79;
        }
        if (((ApplicationInfo) (context)).metaData == null)
        {
            break MISSING_BLOCK_LABEL_79;
        }
        context = ((Context) (((ApplicationInfo) (context)).metaData.get("UMENG_CHANNEL")));
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_79;
        }
        context = context.toString();
        if (context != null)
        {
            return context;
        }
        bj.a(a, "Could not read UMENG_CHANNEL meta-data from AndroidManifest.xml.");
        return "Unknown";
        context;
        bj.a(a, "Could not read UMENG_CHANNEL meta-data from AndroidManifest.xml.");
        context.printStackTrace();
        return "Unknown";
    }

    public static String u(Context context)
    {
        return context.getPackageName();
    }

    public static String v(Context context)
    {
        return context.getPackageManager().getApplicationLabel(context.getApplicationInfo()).toString();
    }

    public static boolean w(Context context)
    {
        boolean flag = false;
        int i1;
        try
        {
            i1 = context.getApplicationInfo().flags;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return false;
        }
        if ((i1 & 2) != 0)
        {
            flag = true;
        }
        return flag;
    }

    private static Locale x(Context context)
    {
        Object obj = null;
        Configuration configuration;
        configuration = new Configuration();
        configuration.setToDefaults();
        android.provider.Settings.System.getConfiguration(context.getContentResolver(), configuration);
        context = ((Context) (obj));
        if (configuration != null)
        {
            try
            {
                context = configuration.locale;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                bj.b(a, "fail to read user config locale");
                context = ((Context) (obj));
            }
        }
        obj = context;
        if (context == null)
        {
            obj = Locale.getDefault();
        }
        return ((Locale) (obj));
    }

}
