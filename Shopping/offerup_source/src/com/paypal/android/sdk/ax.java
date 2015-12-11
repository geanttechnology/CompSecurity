// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Looper;
import android.os.StatFs;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

// Referenced classes of package com.paypal.android.sdk:
//            z, u, ay, w, 
//            y

public final class ax
{

    private static final boolean a;
    private static final boolean b;
    private static final String c = (new StringBuilder()).append(com/paypal/android/sdk/z.getSimpleName()).append(".").append(com/paypal/android/sdk/ax.getSimpleName()).toString();
    private static final Uri d;

    private ax()
    {
    }

    public static Location a(LocationManager locationmanager)
    {
        Location location = null;
        List list;
        int i;
        list = locationmanager.getProviders(true);
        i = list.size();
        i--;
        do
        {
            if (i < 0)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            Location location1;
            try
            {
                location1 = locationmanager.getLastKnownLocation((String)list.get(i));
            }
            // Misplaced declaration of an exception variable
            catch (LocationManager locationmanager)
            {
                return location;
            }
            location = location1;
            location1 = location;
            if (location != null)
            {
                break MISSING_BLOCK_LABEL_63;
            }
            i--;
        } while (true);
        locationmanager;
        location1 = null;
        return location1;
        return location;
    }

    public static u a(Context context)
    {
        u u1 = new u();
        u1.a(context.getPackageName());
        try
        {
            u1.b(context.getPackageManager().getPackageInfo(u1.a(), 0).versionName);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return u1;
        }
        return u1;
    }

    public static Object a(Object obj, Class class1)
    {
        if (obj != null && class1.isAssignableFrom(obj.getClass()))
        {
            return class1.cast(obj);
        } else
        {
            return null;
        }
    }

    public static Object a(Map map, Class class1, String s, Object obj)
    {
        if (map != null)
        {
            if ((map = ((Map) (map.get(s)))) != null)
            {
                if (class1.isAssignableFrom(map.getClass()))
                {
                    return class1.cast(map);
                } else
                {
                    a("PRD", (new StringBuilder("cannot parse data for ")).append(s).toString(), ((Throwable) (new Exception((new StringBuilder("cannot parse data for ")).append(s).toString()))));
                    return obj;
                }
            }
        }
        return obj;
    }

    public static String a(Context context, y y)
    {
        try
        {
            if (android.os.Build.VERSION.SDK_INT >= 9 && GooglePlayServicesUtil.isGooglePlayServicesAvailable(context) == 0)
            {
                if (Looper.myLooper() != Looper.getMainLooper())
                {
                    return AdvertisingIdClient.getAdvertisingIdInfo(context).getId();
                }
                (new Thread(new ay(context, y))).start();
            }
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.getLocalizedMessage();
        }
        return null;
    }

    public static String a(Map map, String s)
    {
        return (String)a(map, java/lang/String, s, null);
    }

    public static List a(boolean flag)
    {
        ArrayList arraylist = new ArrayList();
        Enumeration enumeration = NetworkInterface.getNetworkInterfaces();
_L4:
        Enumeration enumeration1;
        if (!enumeration.hasMoreElements())
        {
            break MISSING_BLOCK_LABEL_106;
        }
        enumeration1 = ((NetworkInterface)enumeration.nextElement()).getInetAddresses();
_L2:
        InetAddress inetaddress;
        String s;
        if (!enumeration1.hasMoreElements())
        {
            break; /* Loop/switch isn't completed */
        }
        inetaddress = (InetAddress)enumeration1.nextElement();
        if (inetaddress.isLoopbackAddress())
        {
            continue; /* Loop/switch isn't completed */
        }
        s = inetaddress.getHostAddress();
        if (inetaddress instanceof Inet6Address)
        {
            if (!flag)
            {
                continue; /* Loop/switch isn't completed */
            }
            try
            {
                arraylist.add(s);
                continue; /* Loop/switch isn't completed */
            }
            catch (Exception exception) { }
            break MISSING_BLOCK_LABEL_106;
        }
        arraylist.add(s);
        if (true) goto _L2; else goto _L1
_L1:
        if (true) goto _L4; else goto _L3
_L3:
        return arraylist;
    }

    public static void a()
    {
    }

    public static void a(int i, String s, String s1)
    {
        if (b)
        {
            Log.println(i, s, s1);
        }
    }

    public static void a(String s, String s1, Throwable throwable)
    {
        if (b)
        {
            Log.println(6, s, (new StringBuilder()).append(s1).append('\n').append(Log.getStackTraceString(throwable)).toString());
        }
    }

    public static void a(JSONObject jsonobject)
    {
        if (a && jsonobject != null)
        {
            jsonobject.toString();
        }
    }

    public static boolean a(Context context, String s)
    {
        boolean flag = false;
        int i;
        try
        {
            i = context.getApplicationContext().checkCallingOrSelfPermission(s);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return false;
        }
        if (i == 0)
        {
            flag = true;
        }
        return flag;
    }

    public static boolean a(PackageManager packagemanager, Intent intent)
    {
        packagemanager = packagemanager.queryIntentActivities(intent, 0x10000);
        return packagemanager != null && packagemanager.size() > 0;
    }

    public static boolean a(String s, String s1)
    {
        boolean flag = false;
        s = s.split("\\.");
        s1 = s1.split("\\.");
        int i;
        for (i = 0; i < s.length && i < s1.length && s[i].equals(s1[i]); i++) { }
        if (i < s.length && i < s1.length)
        {
            s = Integer.valueOf(Integer.signum(Integer.valueOf(s[i]).compareTo(Integer.valueOf(s1[i]))));
        } else
        {
            s = Integer.valueOf(Integer.signum(s.length - s1.length));
        }
        if (s.intValue() >= 0)
        {
            flag = true;
        }
        return flag;
    }

    public static boolean a(Map map, String s, Boolean boolean1)
    {
        return ((Boolean)a(map, java/lang/Boolean, s, boolean1)).booleanValue();
    }

    public static String b(Context context)
    {
label0:
        {
            if (d != null && a(context, "com.google.android.providers.gsf.permission.READ_GSERVICES"))
            {
                context = context.getContentResolver().query(d, null, null, new String[] {
                    "android_id"
                }, null);
                if (context != null)
                {
                    break label0;
                }
            }
            return null;
        }
        int i;
        if (!context.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_67;
        }
        i = context.getColumnCount();
        if (i >= 2)
        {
            break MISSING_BLOCK_LABEL_75;
        }
        context.close();
        return null;
        Exception exception;
        String s;
        try
        {
            s = Long.toHexString(Long.parseLong(context.getString(1)));
        }
        catch (NumberFormatException numberformatexception)
        {
            context.close();
            return null;
        }
        finally
        {
            context.close();
        }
        context.close();
        return s;
        throw exception;
    }

    public static String b(Context context, String s)
    {
        context = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        if (((ApplicationInfo) (context)).metaData == null)
        {
            break MISSING_BLOCK_LABEL_34;
        }
        context = ((ApplicationInfo) (context)).metaData.getString(s);
        return context;
        context;
        return null;
    }

    public static void b()
    {
    }

    public static String c()
    {
        String s1 = "";
        String s = s1;
        String s2;
        w w1;
        try
        {
            w1 = new w();
        }
        catch (Exception exception)
        {
            return s;
        }
        s = s1;
        w1.a((new StringBuilder()).append(Environment.getExternalStorageDirectory().getAbsolutePath()).append("/Android/data/com.ebay.lid/").toString());
        s = s1;
        s1 = w1.b("fb.bin");
        s2 = s1;
        s = s1;
        if (!"".equals(s1.trim()))
        {
            break MISSING_BLOCK_LABEL_97;
        }
        s = s1;
        s2 = UUID.randomUUID().toString();
        s = s2;
        w1.a("fb.bin", s2.getBytes("UTF-8"));
        return s2;
    }

    public static String c(Context context, String s)
    {
        context = new BufferedReader(new InputStreamReader(context.getAssets().open(s)));
        s = new StringBuilder();
        do
        {
            String s1 = context.readLine();
            if (s1 != null)
            {
                s.append(s1);
            } else
            {
                context.close();
                return new String(Base64.decode(s.toString(), 0), "UTF-8");
            }
        } while (true);
    }

    public static String d()
    {
        List list = a(false);
        if (list.isEmpty())
        {
            return "";
        } else
        {
            return (String)list.get(0);
        }
    }

    public static long e()
    {
        int i;
        long l;
        try
        {
            StatFs statfs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            l = statfs.getBlockSize();
            i = statfs.getBlockCount();
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            illegalargumentexception.getLocalizedMessage();
            return 0L;
        }
        return (long)i * l;
    }

    public static String f()
    {
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            String s = System.getProperty("http.proxyHost");
            if (s != null)
            {
                String s1 = System.getProperty("http.proxyPort");
                if (s1 != null)
                {
                    return (new StringBuilder("host=")).append(s).append(",port=").append(s1).toString();
                }
            }
        }
        return null;
    }

    public static String g()
    {
        BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("ls /sys/class/net").getInputStream()));
_L2:
        String s = bufferedreader.readLine();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_71;
        }
        boolean flag;
        if (s.startsWith("ppp") || s.startsWith("tun"))
        {
            break; /* Loop/switch isn't completed */
        }
        flag = s.startsWith("tap");
        if (!flag) goto _L2; else goto _L1
_L1:
        return s;
        Exception exception;
        exception;
        return null;
    }

    static String h()
    {
        return c;
    }

    static 
    {
        a = Boolean.valueOf(System.getProperty("dyson.debug.mode", Boolean.FALSE.toString())).booleanValue();
        b = Boolean.valueOf(System.getProperty("prd.debug.mode", Boolean.FALSE.toString())).booleanValue();
        Uri uri;
        try
        {
            uri = Uri.parse("content://com.google.android.gsf.gservices");
        }
        catch (Exception exception)
        {
            exception = null;
        }
        d = uri;
    }
}
