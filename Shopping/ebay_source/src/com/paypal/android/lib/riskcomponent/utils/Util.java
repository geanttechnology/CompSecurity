// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.lib.riskcomponent.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.location.Location;
import android.net.Uri;
import android.os.Environment;
import android.os.Looper;
import android.os.StatFs;
import android.util.Log;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.paypal.android.lib.riskcomponent.AppInfo;
import com.paypal.android.lib.riskcomponent.ExternalStorage;
import com.paypal.android.lib.riskcomponent.RiskBlob;
import com.paypal.android.lib.riskcomponent.RiskComponent;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public final class Util
{

    private static final boolean DEBUG_MODE = Log.isLoggable("dyson.debug.mode", 3);
    private static final boolean EXTERNAL_DEBUG_MODE = Log.isLoggable("prd.debug.mode", 3);
    private static final String TAG = (new StringBuilder()).append(com/paypal/android/lib/riskcomponent/RiskComponent.getSimpleName()).append(".").append(com/paypal/android/lib/riskcomponent/utils/Util.getSimpleName()).toString();
    private static final Uri URI;

    private Util()
    {
    }

    public static Object castOrNull(Object obj, Class class1)
    {
        if (obj != null && class1.isAssignableFrom(obj.getClass()))
        {
            return class1.cast(obj);
        } else
        {
            return null;
        }
    }

    public static String getAdvertisingId(Context context, RiskBlob riskblob)
    {
        if (android.os.Build.VERSION.SDK_INT < 9 || GooglePlayServicesUtil.isGooglePlayServicesAvailable(context) != 0 || Looper.myLooper() == Looper.getMainLooper())
        {
            break MISSING_BLOCK_LABEL_46;
        }
        context = AdvertisingIdClient.getAdvertisingIdInfo(context).getId();
        return context;
        context;
        logExceptionSliently(TAG, context.getLocalizedMessage(), context);
        return null;
    }

    public static AppInfo getAppInfo(Context context)
    {
        AppInfo appinfo = new AppInfo();
        appinfo.id = context.getPackageName();
        try
        {
            appinfo.version = context.getPackageManager().getPackageInfo(appinfo.id, 0).versionName;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            logExceptionSliently(TAG, "Package not found", context);
            return appinfo;
        }
        return appinfo;
    }

    public static String getGsfAndroidId(Context context)
    {
        if (URI == null || !hasPermission(context, "com.google.android.providers.gsf.permission.READ_GSERVICES"))
        {
            break MISSING_BLOCK_LABEL_115;
        }
        Object obj = null;
        int i;
        try
        {
            context = context.getContentResolver().query(URI, null, null, new String[] {
                "android_id"
            }, null);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context = ((Context) (obj));
        }
        if (context == null)
        {
            return null;
        }
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
        try
        {
            obj = Long.toHexString(Long.parseLong(context.getString(1)));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            context.close();
            return null;
        }
        finally
        {
            context.close();
        }
        context.close();
        return ((String) (obj));
        throw obj;
        return null;
    }

    public static String getLinkerId()
        throws IOException
    {
        String s1 = "";
        String s = s1;
        String s2;
        ExternalStorage externalstorage;
        try
        {
            externalstorage = new ExternalStorage();
        }
        catch (Exception exception)
        {
            logExceptionSliently(TAG, "cannot get linker id", exception);
            return s;
        }
        s = s1;
        externalstorage.setDirectory((new StringBuilder()).append(Environment.getExternalStorageDirectory().getAbsolutePath()).append("/Android/data/com.ebay.lid/").toString());
        s = s1;
        s1 = externalstorage.read("fb.bin");
        s2 = s1;
        s = s1;
        if (!"".equals(s1.trim()))
        {
            break MISSING_BLOCK_LABEL_92;
        }
        s = s1;
        s2 = UUID.randomUUID().toString();
        s = s2;
        externalstorage.write("fb.bin", s2.getBytes("UTF-8"));
        return s2;
    }

    public static String getLocalIpAddress()
    {
        List list = getLocalIpAddresses(false);
        if (list.isEmpty())
        {
            return "";
        } else
        {
            return (String)list.get(0);
        }
    }

    public static List getLocalIpAddresses(boolean flag)
    {
        ArrayList arraylist = new ArrayList();
        Enumeration enumeration = NetworkInterface.getNetworkInterfaces();
_L8:
        if (!enumeration.hasMoreElements()) goto _L2; else goto _L1
_L1:
        Enumeration enumeration1 = ((NetworkInterface)enumeration.nextElement()).getInetAddresses();
_L6:
        InetAddress inetaddress;
        String s;
        do
        {
            if (!enumeration1.hasMoreElements())
            {
                continue; /* Loop/switch isn't completed */
            }
            inetaddress = (InetAddress)enumeration1.nextElement();
        } while (inetaddress.isLoopbackAddress());
        s = inetaddress.getHostAddress();
        if (!(inetaddress instanceof Inet6Address)) goto _L4; else goto _L3
_L3:
        if (!flag) goto _L6; else goto _L5
_L5:
        arraylist.add(s);
          goto _L6
        Exception exception;
        exception;
        logExceptionSliently(TAG, "caught exception", exception);
_L2:
        return arraylist;
_L4:
        arraylist.add(s);
          goto _L6
        if (true) goto _L8; else goto _L7
_L7:
    }

    public static String getProxySetting()
    {
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            String s = System.getProperty("http.proxyHost");
            if (s != null)
            {
                String s1 = System.getProperty("http.proxyPort");
                if (s1 != null)
                {
                    return (new StringBuilder()).append("host=").append(s).append(",port=").append(s1).toString();
                }
            }
        }
        return null;
    }

    public static long getTotalStorageSpace()
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
            logExceptionSliently(TAG, illegalargumentexception.getLocalizedMessage(), illegalargumentexception);
            return 0L;
        }
        return l * (long)i;
    }

    public static String getVPNSetting()
    {
        BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("ls /sys/class/net").getInputStream()));
_L2:
        String s = bufferedreader.readLine();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_81;
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
        logExceptionSliently(TAG, "caught exception", exception);
        return null;
    }

    public static boolean hasPermission(Context context, String s)
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
            logExceptionSliently(TAG, "caught exception", context);
            return false;
        }
        if (i == 0)
        {
            flag = true;
        }
        return flag;
    }

    public static boolean isCallable(PackageManager packagemanager, Intent intent)
    {
        packagemanager = packagemanager.queryIntentActivities(intent, 0x10000);
        return packagemanager != null && packagemanager.size() > 0;
    }

    public static void logExceptionSliently(String s, String s1, Throwable throwable)
    {
        if (DEBUG_MODE)
        {
            Log.d(s, s1, throwable);
        }
    }

    public static void logExternal(int i, String s, String s1)
    {
        if (EXTERNAL_DEBUG_MODE)
        {
            Log.println(i, s, s1);
        }
    }

    public static void logExternal(int i, String s, String s1, Throwable throwable)
    {
        if (EXTERNAL_DEBUG_MODE)
        {
            Log.println(i, s, (new StringBuilder()).append(s1).append('\n').append(Log.getStackTraceString(throwable)).toString());
        }
    }

    public static Location optLocationFromMap(Map map, String s, Location location)
    {
        return (Location)optValueFromMap(map, android/location/Location, s, location);
    }

    public static String optStringFromMap(Map map, String s, String s1)
    {
        return (String)optValueFromMap(map, java/lang/String, s, s1);
    }

    public static Object optValueFromMap(Map map, Class class1, String s, Object obj)
    {
        map = ((Map) (map.get(s)));
        if (map == null)
        {
            return obj;
        }
        if (class1.isAssignableFrom(map.getClass()))
        {
            return class1.cast(map);
        } else
        {
            logExternal(6, "PRD", (new StringBuilder()).append("cannot parse data for ").append(s).toString(), new Exception((new StringBuilder()).append("cannot parse data for ").append(s).toString()));
            return obj;
        }
    }

    static 
    {
        Uri uri;
        try
        {
            uri = Uri.parse("content://com.google.android.gsf.gservices");
        }
        catch (Exception exception)
        {
            exception = null;
        }
        URI = uri;
    }
}
