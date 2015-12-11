// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

// Referenced classes of package com.localytics.android:
//            ReflectionUtils, Constants

final class DatapointHelper
{

    private static final Object HARDWARE_TELEPHONY[] = {
        "android.hardware.telephony"
    };
    private static final String INVALID_ANDROID_ID = "9774d56d682e549c";
    private static final String LEGACY_DEVICE_ID_FILE = "/localytics/device_id";
    private static final Class STRING_CLASS_ARRAY[] = {
        java/lang/String
    };

    private DatapointHelper()
    {
        throw new UnsupportedOperationException("This class is non-instantiable");
    }

    static AdvertisingInfo getAdvertisingInfo(Context context)
    {
        context = ((Context) (ReflectionUtils.tryInvokeStatic("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", new Class[] {
            android/content/Context
        }, new Object[] {
            context
        })));
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_86;
        }
        String s;
        boolean flag;
        s = (String)ReflectionUtils.tryInvokeInstance(context, "getId", null, null);
        flag = ((Boolean)ReflectionUtils.tryInvokeInstance(context, "isLimitAdTrackingEnabled", null, null)).booleanValue();
        context = s;
        if (TextUtils.isEmpty(s))
        {
            context = null;
        }
        context = new AdvertisingInfo(context, flag);
        return context;
        context;
        Localytics.Log.w("Device doesn't have Google Play Services installed");
        return null;
    }

    static String getAndroidIdHashOrNull(Context context)
    {
        context = getAndroidIdOrNull(context);
        if (context == null)
        {
            return null;
        } else
        {
            return getSha256_buggy(context);
        }
    }

    static String getAndroidIdOrNull(Context context)
    {
        Object obj = new File((new StringBuilder()).append(context.getFilesDir()).append("/localytics/device_id").toString());
        if (!((File) (obj)).exists() || ((File) (obj)).length() <= 0L) goto _L2; else goto _L1
_L1:
        BufferedReader bufferedreader;
        char ac[];
        ac = new char[100];
        bufferedreader = new BufferedReader(new FileReader(((File) (obj))), 128);
        obj = bufferedreader;
        String s = String.copyValueOf(ac, 0, bufferedreader.read(ac));
        obj = bufferedreader;
        bufferedreader.close();
        bufferedreader.close();
        context = s;
_L4:
        return context;
        FileNotFoundException filenotfoundexception;
        filenotfoundexception;
        bufferedreader = null;
_L7:
        obj = bufferedreader;
        Localytics.Log.w("Caught exception", filenotfoundexception);
        Exception exception;
        if (bufferedreader != null)
        {
            try
            {
                bufferedreader.close();
            }
            catch (IOException ioexception)
            {
                Localytics.Log.w("Caught exception", ioexception);
            }
        }
_L2:
        obj = android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id");
        if (obj == null)
        {
            break; /* Loop/switch isn't completed */
        }
        context = ((Context) (obj));
        if (!((String) (obj)).toLowerCase().equals("9774d56d682e549c")) goto _L4; else goto _L3
_L3:
        return null;
        exception;
        obj = null;
_L6:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_158;
        }
        ((BufferedReader) (obj)).close();
        throw exception;
        exception;
        if (true) goto _L6; else goto _L5
_L5:
        filenotfoundexception;
          goto _L7
    }

    static int getApiLevel()
    {
        int i;
        try
        {
            i = Integer.parseInt((String)android/os/Build$VERSION.getField("SDK").get(null));
        }
        catch (Exception exception)
        {
            Localytics.Log.w("Caught exception", exception);
            int j;
            try
            {
                j = android/os/Build$VERSION.getField("SDK_INT").getInt(null);
            }
            catch (Exception exception1)
            {
                Localytics.Log.w("Caught exception", exception1);
                return 3;
            }
            return j;
        }
        return i;
    }

    static String getAppVersion(Context context)
    {
        Object obj = context.getPackageManager();
        try
        {
            obj = ((PackageManager) (obj)).getPackageInfo(context.getPackageName(), 0).versionName;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new RuntimeException(context);
        }
        context = ((Context) (obj));
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_33;
        }
        Localytics.Log.w("versionName was null--is a versionName attribute set in the Android Manifest?");
        context = "unknown";
        return context;
    }

    static String getFBAttribution(Context context)
    {
        Object obj;
        context = context.getContentResolver();
        obj = Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider");
        context = context.query(((Uri) (obj)), new String[] {
            "aid"
        }, null, null, null);
        if (context == null) goto _L2; else goto _L1
_L1:
        obj = context;
        if (!context.moveToFirst()) goto _L2; else goto _L3
_L3:
        obj = context;
        String s = context.getString(context.getColumnIndex("aid"));
        obj = s;
_L8:
        if (context != null)
        {
            context.close();
        }
        return ((String) (obj));
        Exception exception;
        exception;
        context = null;
_L6:
        obj = context;
        Localytics.Log.w("Error reading FB attribution", exception);
        if (context != null)
        {
            context.close();
            return null;
        } else
        {
            return null;
        }
        context;
        obj = null;
_L5:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw context;
        context;
        if (true) goto _L5; else goto _L4
_L4:
        exception;
        if (true) goto _L6; else goto _L2
_L2:
        obj = null;
        if (true) goto _L8; else goto _L7
_L7:
    }

    static String getLocalyticsAppKeyOrNull(Context context)
    {
label0:
        {
            if (context == null)
            {
                Localytics.Log.w("Context passed to getLocalyticsAppKeyOrNull() is NULL. Please pass a valid context.");
                return null;
            }
            try
            {
                context = context.getApplicationContext();
                context = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                if (((ApplicationInfo) (context)).metaData == null)
                {
                    break label0;
                }
                context = ((Context) (((ApplicationInfo) (context)).metaData.get("LOCALYTICS_APP_KEY")));
                if (!(context instanceof String))
                {
                    break label0;
                }
                context = (String)context;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                throw new RuntimeException(context);
            }
            return context;
        }
        return null;
    }

    static int getLocalyticsNotificationIcon(Context context)
    {
        Object obj;
        obj = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        if (((ApplicationInfo) (obj)).metaData == null)
        {
            break MISSING_BLOCK_LABEL_85;
        }
        obj = (String)((ApplicationInfo) (obj)).metaData.get("LOCALYTICS_NOTIFICATION_ICON");
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_85;
        }
        int i;
        obj = ((String) (obj)).substring(((String) (obj)).lastIndexOf('/') + 1, ((String) (obj)).lastIndexOf('.'));
        i = context.getResources().getIdentifier(((String) (obj)), "drawable", context.getPackageName());
        if (isValidResourceId(context, i))
        {
            return i;
        }
        boolean flag;
        ApplicationInfo applicationinfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
        if (applicationinfo.icon == 0)
        {
            break MISSING_BLOCK_LABEL_120;
        }
        i = applicationinfo.icon;
        flag = isValidResourceId(context, i);
        if (flag)
        {
            break MISSING_BLOCK_LABEL_128;
        }
_L2:
        return 0x1080093;
        context;
        if (true) goto _L2; else goto _L1
_L1:
        return i;
    }

    static String getLocalyticsRollupKeyOrNull(Context context)
    {
label0:
        {
            try
            {
                context = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                if (((ApplicationInfo) (context)).metaData == null)
                {
                    break label0;
                }
                context = ((Context) (((ApplicationInfo) (context)).metaData.get("LOCALYTICS_ROLLUP_KEY")));
                if (!(context instanceof String))
                {
                    break label0;
                }
                context = (String)context;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                throw new RuntimeException(context);
            }
            return context;
        }
        return null;
    }

    static String getManufacturer()
    {
        if (Constants.CURRENT_API_LEVEL <= 3)
        {
            break MISSING_BLOCK_LABEL_34;
        }
        String s = (String)android/os/Build.getField("MANUFACTURER").get(null);
        return s;
        Exception exception;
        exception;
        Localytics.Log.w("Caught exception", exception);
        return "unknown";
    }

    static String getNetworkType(TelephonyManager telephonymanager, Context context)
    {
        if (context.getPackageManager().checkPermission("android.permission.ACCESS_WIFI_STATE", context.getPackageName()) != 0)
        {
            break MISSING_BLOCK_LABEL_47;
        }
        context = ((ConnectivityManager)context.getSystemService("connectivity")).getNetworkInfo(1);
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        if (context.isConnectedOrConnecting())
        {
            return "wifi";
        }
        break MISSING_BLOCK_LABEL_54;
        try
        {
            Localytics.Log.w("Application does not have one more more of the following permissions: ACCESS_WIFI_STATE. Determining Wi-Fi connectivity is unavailable");
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Localytics.Log.w("Application does not have the permission ACCESS_NETWORK_STATE. Determining Wi-Fi connectivity is unavailable", context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Localytics.Log.w("NullPointerException in getNetworkType()", context);
        }
        return (new StringBuilder("android_network_type_")).append(telephonymanager.getNetworkType()).toString();
    }

    static String getSerialNumberHashOrNull()
    {
        Object obj;
        if (Constants.CURRENT_API_LEVEL >= 9)
        {
            try
            {
                obj = (String)android/os/Build.getField("SERIAL").get(null);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new RuntimeException(((Throwable) (obj)));
            }
        } else
        {
            obj = null;
        }
        if (obj == null)
        {
            return null;
        } else
        {
            return getSha256_buggy(((String) (obj)));
        }
    }

    static String getSha256_buggy(String s)
    {
        try
        {
            s = (new BigInteger(1, MessageDigest.getInstance("SHA-256").digest(s.getBytes("UTF-8")))).toString(16);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException(s);
        }
        return s;
    }

    static String getTelephonyDeviceIdOrNull(Context context)
    {
        if (Constants.CURRENT_API_LEVEL >= 7 && !((Boolean)ReflectionUtils.tryInvokeInstance(context.getPackageManager(), "hasSystemFeature", STRING_CLASS_ARRAY, HARDWARE_TELEPHONY)).booleanValue())
        {
            Localytics.Log.i("Device does not have telephony; cannot read telephony id");
            return null;
        }
        if (context.getPackageManager().checkPermission("android.permission.READ_PHONE_STATE", context.getPackageName()) == 0)
        {
            context = ((TelephonyManager)context.getSystemService("phone")).getDeviceId();
        } else
        {
            Localytics.Log.w("Application does not have permission READ_PHONE_STATE; determining device id is not possible.  Please consider requesting READ_PHONE_STATE in the AndroidManifest");
            context = null;
        }
        return context;
    }

    static boolean isValidResourceId(Context context, int i)
    {
        try
        {
            context.getResources().getResourceName(i);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return false;
        }
        return true;
    }


    private class AdvertisingInfo
    {

        public String id;
        public boolean limitAdTracking;

        public AdvertisingInfo(String s, boolean flag)
        {
            id = s;
            limitAdTracking = flag;
        }
    }

}
