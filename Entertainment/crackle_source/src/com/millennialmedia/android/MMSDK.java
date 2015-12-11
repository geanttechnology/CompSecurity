// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.io.File;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.apache.http.conn.util.InetAddressUtils;

// Referenced classes of package com.millennialmedia.android:
//            HandShake, AdCache, MMRequest, MMAdImpl, 
//            MMAdImplController, MMConversionTracker, MMException, HttpGetRequest, 
//            RequestListener, CachedAd

public final class MMSDK
{
    static class Event
    {

        public static final String INTENT_EMAIL = "email";
        public static final String INTENT_EXTERNAL_BROWSER = "browser";
        public static final String INTENT_MAPS = "geo";
        public static final String INTENT_MARKET = "market";
        public static final String INTENT_PHONE_CALL = "tel";
        public static final String INTENT_STREAMING_VIDEO = "streamingVideo";
        public static final String INTENT_TXT_MESSAGE = "sms";
        private static final String KEY_ERROR = "error";
        static final String KEY_INTENT_TYPE = "intentType";
        static final String KEY_INTERNAL_ID = "internalId";
        static final String KEY_PACKAGE_NAME = "packageName";

        static void displayStarted(MMAdImpl mmadimpl)
        {
            if (MMSDK.isBroadcastingEvents)
            {
                sendIntent(mmadimpl.getContext(), new Intent("millennialmedia.action.ACTION_DISPLAY_STARTED"), mmadimpl.internalId);
            }
            overlayOpened(mmadimpl);
        }

        static void fetchStartedCaching(MMAdImpl mmadimpl)
        {
            MMSDK.runOnUiThread(new Runnable(mmadimpl) {

                final MMAdImpl val$adImpl;

                public void run()
                {
                    if (adImpl == null || adImpl.requestListener == null)
                    {
                        break MISSING_BLOCK_LABEL_36;
                    }
                    adImpl.requestListener.MMAdRequestIsCaching(adImpl.getCallingAd());
                    return;
                    Exception exception;
                    exception;
                    Log.w("Exception raised in your MMAdListener: ", new Object[] {
                        exception
                    });
                    return;
                }

            
            {
                adImpl = mmadimpl;
                super();
            }
            });
            if (MMSDK.isBroadcastingEvents)
            {
                sendIntent(mmadimpl.getContext(), new Intent("millennialmedia.action.ACTION_FETCH_STARTED_CACHING"), mmadimpl.internalId);
            }
        }

        static void intentStarted(Context context, String s, long l)
        {
            if (MMSDK.isBroadcastingEvents && s != null)
            {
                sendIntent(context, (new Intent("millennialmedia.action.ACTION_INTENT_STARTED")).putExtra("intentType", s), l);
            }
        }

        protected static void logEvent(String s)
        {
            Log.d("Logging event to: %s", new Object[] {
                s
            });
            Utils.ThreadUtils.execute(new Runnable(s) {

                final String val$logString;

                public void run()
                {
                    HttpGetRequest httpgetrequest = new HttpGetRequest();
                    try
                    {
                        httpgetrequest.get(logString);
                        return;
                    }
                    catch (Exception exception)
                    {
                        exception.printStackTrace();
                    }
                }

            
            {
                logString = s;
                super();
            }
            });
        }

        static void overlayClosed(Context context, long l)
        {
            if (MMSDK.isBroadcastingEvents && context != null)
            {
                sendIntent(context, new Intent("millennialmedia.action.ACTION_OVERLAY_CLOSED"), l);
            }
        }

        static void overlayOpened(MMAdImpl mmadimpl)
        {
            MMSDK.runOnUiThread(new Runnable(mmadimpl) {

                final MMAdImpl val$adImpl;

                public void run()
                {
                    if (adImpl == null || adImpl.requestListener == null)
                    {
                        break MISSING_BLOCK_LABEL_36;
                    }
                    adImpl.requestListener.MMAdOverlayLaunched(adImpl.getCallingAd());
                    return;
                    Exception exception;
                    exception;
                    Log.w("Exception raised in your MMAdListener: ", new Object[] {
                        exception
                    });
                    return;
                }

            
            {
                adImpl = mmadimpl;
                super();
            }
            });
            overlayOpenedBroadCast(mmadimpl.getContext(), mmadimpl.internalId);
        }

        static void overlayOpenedBroadCast(Context context, long l)
        {
            if (MMSDK.isBroadcastingEvents)
            {
                sendIntent(context, new Intent("millennialmedia.action.ACTION_OVERLAY_OPENED"), l);
            }
        }

        static void overlayTap(Context context, long l)
        {
            if (MMSDK.isBroadcastingEvents)
            {
                sendIntent(context, new Intent("millennialmedia.action.ACTION_OVERLAY_TAP"), l);
            }
        }

        static void requestCompleted(MMAdImpl mmadimpl)
        {
            MMSDK.runOnUiThread(new Runnable(mmadimpl) {

                final MMAdImpl val$adImpl;

                public void run()
                {
                    if (adImpl == null || adImpl.requestListener == null)
                    {
                        break MISSING_BLOCK_LABEL_36;
                    }
                    adImpl.requestListener.requestCompleted(adImpl.getCallingAd());
                    return;
                    Exception exception;
                    exception;
                    Log.w("Exception raised in your MMAdListener: ", new Object[] {
                        exception
                    });
                    return;
                }

            
            {
                adImpl = mmadimpl;
                super();
            }
            });
            if (MMSDK.isBroadcastingEvents)
            {
                String s = mmadimpl.getRequestCompletedAction();
                sendIntent(mmadimpl.getContext(), new Intent(s), mmadimpl.internalId);
            }
        }

        static void requestFailed(MMAdImpl mmadimpl, MMException mmexception)
        {
            MMSDK.runOnUiThread(new Runnable(mmadimpl, mmexception) {

                final MMAdImpl val$adImpl;
                final MMException val$error;

                public void run()
                {
                    if (adImpl == null || adImpl.requestListener == null)
                    {
                        break MISSING_BLOCK_LABEL_40;
                    }
                    adImpl.requestListener.requestFailed(adImpl.getCallingAd(), error);
                    return;
                    Exception exception;
                    exception;
                    Log.w("Exception raised in your MMAdListener: ", new Object[] {
                        exception
                    });
                    return;
                }

            
            {
                adImpl = mmadimpl;
                error = mmexception;
                super();
            }
            });
            if (MMSDK.isBroadcastingEvents)
            {
                String s = mmadimpl.getRequestFailedAction();
                sendIntent(mmadimpl.getContext(), (new Intent(s)).putExtra("error", mmexception), mmadimpl.internalId);
            }
        }

        private static final void sendIntent(Context context, Intent intent, long l)
        {
            if (context != null)
            {
                intent.addCategory("millennialmedia.category.CATEGORY_SDK");
                if (l != -4L)
                {
                    intent.putExtra("internalId", l);
                }
                intent.putExtra("packageName", context.getPackageName());
                String s = intent.getStringExtra("intentType");
                if (!TextUtils.isEmpty(s))
                {
                    s = String.format(" Type[%s]", new Object[] {
                        s
                    });
                } else
                {
                    s = "";
                }
                Log.v((new StringBuilder()).append(" @@ Intent: ").append(intent.getAction()).append(" ").append(s).append(" for ").append(l).toString());
                context.sendBroadcast(intent);
            }
        }

        Event()
        {
        }
    }

    static class Log
    {

        static void d(String s)
        {
            if (MMSDK.logLevel >= 1)
            {
                android.util.Log.i("MillennialMediaSDK", (new StringBuilder()).append("Diagnostic - ").append(s).toString());
            }
        }

        static transient void d(String s, Object aobj[])
        {
            if (MMSDK.logLevel >= 1)
            {
                android.util.Log.i("MillennialMediaSDK", (new StringBuilder()).append("Diagnostic - ").append(String.format(s, aobj)).toString());
            }
        }

        static void d(Throwable throwable)
        {
            if (MMSDK.logLevel >= 1)
            {
                d(android.util.Log.getStackTraceString(throwable));
            }
        }

        static void e(String s)
        {
            android.util.Log.e("MillennialMediaSDK", s);
        }

        static transient void e(String s, Object aobj[])
        {
            android.util.Log.e("MillennialMediaSDK", String.format(s, aobj));
        }

        static void e(Throwable throwable)
        {
            e(android.util.Log.getStackTraceString(throwable));
        }

        static void i(String s)
        {
            android.util.Log.i("MillennialMediaSDK", s);
        }

        static transient void i(String s, Object aobj[])
        {
            android.util.Log.i("MillennialMediaSDK", String.format(s, aobj));
        }

        static void i(Throwable throwable)
        {
            i(android.util.Log.getStackTraceString(throwable));
        }

        static void p(String s)
        {
            if (MMSDK.logLevel > 3)
            {
                android.util.Log.i("MillennialMediaSDK", (new StringBuilder()).append("Private - ").append(s).toString());
            }
        }

        static transient void p(String s, Object aobj[])
        {
            if (MMSDK.logLevel > 3)
            {
                android.util.Log.i("MillennialMediaSDK", (new StringBuilder()).append("Private - ").append(String.format(s, aobj)).toString());
            }
        }

        static void p(Throwable throwable)
        {
            if (MMSDK.logLevel > 3)
            {
                p(android.util.Log.getStackTraceString(throwable));
            }
        }

        static void v(String s)
        {
            if (MMSDK.logLevel >= 3)
            {
                android.util.Log.i("MillennialMediaSDK", (new StringBuilder()).append("Verbose - ").append(s).toString());
            }
        }

        static transient void v(String s, Object aobj[])
        {
            if (MMSDK.logLevel >= 3)
            {
                android.util.Log.i("MillennialMediaSDK", (new StringBuilder()).append("Verbose - ").append(String.format(s, aobj)).toString());
            }
        }

        static void v(Throwable throwable)
        {
            if (MMSDK.logLevel >= 3)
            {
                v(android.util.Log.getStackTraceString(throwable));
            }
        }

        static void w(String s)
        {
            android.util.Log.w("MillennialMediaSDK", s);
        }

        static transient void w(String s, Object aobj[])
        {
            android.util.Log.w("MillennialMediaSDK", String.format(s, aobj));
        }

        static void w(Throwable throwable)
        {
            w(android.util.Log.getStackTraceString(throwable));
        }

        Log()
        {
        }
    }


    private static final String BASE_URL_TRACK_EVENT = "http://ads.mp.mydas.mobi/pixel?id=";
    static final int CACHE_REQUEST_TIMEOUT = 30000;
    static final int CLOSE_ACTIVITY_DURATION = 400;
    static String COMMA = ",";
    public static final String DEFAULT_APID = "28911";
    public static final String DEFAULT_BANNER_APID = "28913";
    public static final String DEFAULT_RECT_APID = "28914";
    static final String EMPTY = "";
    static final String JSON_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss ZZZZ";
    public static final int LOG_LEVEL_DEBUG = 1;
    public static final int LOG_LEVEL_ERROR = 0;
    public static final int LOG_LEVEL_INFO = 2;
    public static final int LOG_LEVEL_INTERNAL = 4;
    public static final int LOG_LEVEL_PRIVATE_VERBOSE = 5;
    public static final int LOG_LEVEL_VERBOSE = 3;
    static final int LOG_REQUEST_TIMEOUT = 10000;
    static final int MIN_REFRESH = 15;
    static final int OPEN_ACTIVITY_DURATION = 600;
    static final String PREFS_NAME = "MillennialMediaSettings";
    static final int REQUEST_TIMEOUT = 3000;
    public static final String SDKLOG = "MillennialMediaSDK";
    public static final String VERSION = "5.0.1-13.05.14.a";
    public static boolean debugMode;
    static boolean disableAdMinRefresh = false;
    private static String getMMdidValue = null;
    private static boolean isBroadcastingEvents;
    static int logLevel;
    static String macId;
    static Handler mainHandler = new Handler(Looper.getMainLooper());
    private static int nextDefaultId = 0x711e41a1;

    private MMSDK()
    {
    }

    static String byteArrayToString(byte abyte0[])
    {
        StringBuilder stringbuilder = new StringBuilder(abyte0.length * 2);
        for (int i = 0; i < abyte0.length; i++)
        {
            stringbuilder.append(String.format("%02X", new Object[] {
                Byte.valueOf(abyte0[i])
            }));
        }

        return stringbuilder.toString();
    }

    static void checkActivity(Context context)
    {
        PackageManager packagemanager = context.getPackageManager();
        try
        {
            packagemanager.getActivityInfo(new ComponentName(context, "com.millennialmedia.android.MMActivity"), 128);
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception1)
        {
            Log.e("Activity MMActivity not declared in AndroidManifest.xml");
            namenotfoundexception1.printStackTrace();
            createMissingPermissionDialog(context, "MMActivity class").show();
        }
        try
        {
            packagemanager.getActivityInfo(new ComponentName(context, "com.millennialmedia.android.VideoPlayer"), 128);
            return;
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            Log.e("Activity VideoPlayer not declared in AndroidManifest.xml");
            namenotfoundexception.printStackTrace();
            createMissingPermissionDialog(context, "VideoPlayer class").show();
            return;
        }
    }

    static void checkPermissions(Context context)
    {
        if (context.checkCallingOrSelfPermission("android.permission.INTERNET") == -1)
        {
            createMissingPermissionDialog(context, "INTERNET permission").show();
        }
        if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == -1)
        {
            createMissingPermissionDialog(context, "ACCESS_NETWORK_STATE permission").show();
        }
    }

    private static AlertDialog createMissingPermissionDialog(Context context, String s)
    {
        context = (new android.app.AlertDialog.Builder(context)).create();
        context.setTitle("Whoops!");
        context.setMessage(String.format("The developer has forgot to declare the %s in the manifest file. Please reach out to the developer to remove this error.", new Object[] {
            s
        }));
        context.setButton(-3, "OK", new android.content.DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.cancel();
            }

        });
        context.show();
        return context;
    }

    public static boolean getBroadcastEvents()
    {
        return isBroadcastingEvents;
    }

    static Configuration getConfiguration(Context context)
    {
        return context.getResources().getConfiguration();
    }

    static String getConnectionType(Context context)
    {
        context = (ConnectivityManager)context.getSystemService("connectivity");
        if (context == null)
        {
            return "unknown";
        }
        if (context.getActiveNetworkInfo() != null && context.getActiveNetworkInfo().isConnected())
        {
            int i = context.getActiveNetworkInfo().getType();
            int j = context.getActiveNetworkInfo().getSubtype();
            if (i == 1)
            {
                return "wifi";
            }
            if (i == 0)
            {
                switch (j)
                {
                default:
                    return "unknown";

                case 7: // '\007'
                    return "1xrtt";

                case 4: // '\004'
                    return "cdma";

                case 2: // '\002'
                    return "edge";

                case 14: // '\016'
                    return "ehrpd";

                case 5: // '\005'
                    return "evdo_0";

                case 6: // '\006'
                    return "evdo_a";

                case 12: // '\f'
                    return "evdo_b";

                case 1: // '\001'
                    return "gprs";

                case 8: // '\b'
                    return "hsdpa";

                case 10: // '\n'
                    return "hspa";

                case 15: // '\017'
                    return "hspap";

                case 9: // '\t'
                    return "hsupa";

                case 11: // '\013'
                    return "iden";

                case 13: // '\r'
                    return "lte";

                case 3: // '\003'
                    return "umts";
                }
            } else
            {
                return "unknown";
            }
        } else
        {
            return "offline";
        }
    }

    public static int getDefaultAdId()
    {
        com/millennialmedia/android/MMSDK;
        JVM INSTR monitorenter ;
        int i;
        i = nextDefaultId + 1;
        nextDefaultId = i;
        com/millennialmedia/android/MMSDK;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        com/millennialmedia/android/MMSDK;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static float getDensity(Context context)
    {
        return context.getResources().getDisplayMetrics().density;
    }

    static String getDpiHeight(Context context)
    {
        DisplayMetrics displaymetrics = getMetrics(context);
        if (needsRealDisplayMethod())
        {
            try
            {
                android/view/Display.getMethod("getRealMetrics", new Class[0]).invoke(displaymetrics, new Object[0]);
            }
            catch (Exception exception) { }
        }
        if (needsRawDisplayMethod() && (context instanceof Activity))
        {
            context = ((Activity)context).getWindowManager().getDefaultDisplay();
            int i;
            try
            {
                i = ((Integer)android/view/Display.getMethod("getRawHeight", new Class[0]).invoke(context, new Object[0])).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                return Integer.toString(displaymetrics.heightPixels);
            }
            return String.valueOf(i);
        } else
        {
            return Integer.toString(displaymetrics.heightPixels);
        }
    }

    static String getDpiWidth(Context context)
    {
        DisplayMetrics displaymetrics = getMetrics(context);
        if (needsRealDisplayMethod())
        {
            try
            {
                android/view/Display.getMethod("getRealMetrics", new Class[0]).invoke(displaymetrics, new Object[0]);
            }
            catch (Exception exception) { }
        }
        if (needsRawDisplayMethod() && (context instanceof Activity))
        {
            context = ((Activity)context).getWindowManager().getDefaultDisplay();
            int i;
            try
            {
                i = ((Integer)android/view/Display.getMethod("getRawWidth", new Class[0]).invoke(context, new Object[0])).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                return Integer.toString(displaymetrics.widthPixels);
            }
            return String.valueOf(i);
        } else
        {
            return Integer.toString(displaymetrics.widthPixels);
        }
    }

    static String getIpAddress(Context context)
    {
        StringBuilder stringbuilder;
        Enumeration enumeration;
        stringbuilder = new StringBuilder();
        enumeration = NetworkInterface.getNetworkInterfaces();
_L6:
        Enumeration enumeration1;
        if (!enumeration.hasMoreElements())
        {
            break MISSING_BLOCK_LABEL_139;
        }
        enumeration1 = ((NetworkInterface)enumeration.nextElement()).getInetAddresses();
_L3:
        do
        {
            if (!enumeration1.hasMoreElements())
            {
                continue; /* Loop/switch isn't completed */
            }
            context = (InetAddress)enumeration1.nextElement();
        } while (context.isLoopbackAddress());
        if (stringbuilder.length() > 0)
        {
            stringbuilder.append(',');
        }
        context = context.getHostAddress().toUpperCase();
        if (!InetAddressUtils.isIPv4Address(context)) goto _L2; else goto _L1
_L1:
        stringbuilder.append(context);
          goto _L3
_L2:
        int i;
        try
        {
            i = context.indexOf('%');
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.e(context);
            return "";
        }
        if (i >= 0)
        {
            break MISSING_BLOCK_LABEL_128;
        }
_L4:
        stringbuilder.append(context);
          goto _L3
        continue; /* Loop/switch isn't completed */
        context = context.substring(0, i);
          goto _L4
        context = stringbuilder.toString();
        return context;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public static int getLogLevel()
    {
        return logLevel;
    }

    static String getMMdid(Context context)
    {
        Object obj = null;
        com/millennialmedia/android/MMSDK;
        JVM INSTR monitorenter ;
        if (getMMdidValue == null) goto _L2; else goto _L1
_L1:
        context = getMMdidValue;
_L4:
        com/millennialmedia/android/MMSDK;
        JVM INSTR monitorexit ;
        return context;
_L2:
        String s = android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id");
        context = obj;
        if (s == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        context = new StringBuilder("mmh_");
        context.append(byteArrayToString(MessageDigest.getInstance("MD5").digest(s.getBytes())));
        context.append("_");
        context.append(byteArrayToString(MessageDigest.getInstance("SHA1").digest(s.getBytes())));
        context = context.toString();
        getMMdidValue = context;
        continue; /* Loop/switch isn't completed */
        context;
        throw context;
        context;
        Log.v(context.getMessage());
        context = obj;
        if (true) goto _L4; else goto _L3
_L3:
    }

    static String getMcc(Context context)
    {
        Configuration configuration = getConfiguration(context);
        if (configuration.mcc == 0)
        {
            context = getNetworkOperator(context);
            if (context != null && context.length() >= 6)
            {
                return context.substring(0, 3);
            }
        }
        return String.valueOf(configuration.mcc);
    }

    static DisplayMetrics getMetrics(Context context)
    {
        return context.getResources().getDisplayMetrics();
    }

    static String getMnc(Context context)
    {
        Configuration configuration = getConfiguration(context);
        if (configuration.mnc == 0)
        {
            context = getNetworkOperator(context);
            if (context != null && context.length() >= 6)
            {
                return context.substring(3);
            }
        }
        return String.valueOf(configuration.mnc);
    }

    static String getNetworkOperator(Context context)
    {
        return ((TelephonyManager)context.getSystemService("phone")).getNetworkOperator();
    }

    static String getOrientation(Context context)
    {
        switch (context.getResources().getConfiguration().orientation)
        {
        default:
            return "default";

        case 1: // '\001'
            return "portrait";

        case 2: // '\002'
            return "landscape";

        case 3: // '\003'
            return "square";
        }
    }

    static final String getOrientationLocked(Context context)
    {
        if (android.provider.Settings.System.getString(context.getContentResolver(), "accelerometer_rotation").equals("1"))
        {
            return "false";
        } else
        {
            return "true";
        }
    }

    static String getSupportsSms(Context context)
    {
        return String.valueOf(context.getPackageManager().hasSystemFeature("android.hardware.telephony"));
    }

    static String getSupportsTel(Context context)
    {
        return String.valueOf(context.getPackageManager().hasSystemFeature("android.hardware.telephony"));
    }

    public static String hasAccelerometer(Context context)
    {
        if (context == null)
        {
            return "false";
        }
        context = ((SensorManager)context.getSystemService("sensor")).getSensorList(1);
        boolean flag = false;
        context = context.iterator();
        do
        {
            if (!context.hasNext())
            {
                break;
            }
            if (((Sensor)context.next()).getType() == 1)
            {
                flag = true;
            }
        } while (true);
        if (flag)
        {
            return "true";
        } else
        {
            return "false";
        }
    }

    static boolean hasSetTranslationMethod()
    {
        return Integer.parseInt(android.os.Build.VERSION.SDK) >= 11;
    }

    public static void initialize(Context context)
    {
        context = HandShake.sharedHandShake(context);
        context.sendInitRequest();
        context.startSession();
    }

    static void insertUrlCommonValues(Context context, Map map)
    {
        map.put("accelerometer", hasAccelerometer(context));
        map.put("density", Float.toString(getMetrics(context).density));
        map.put("hpx", getDpiHeight(context));
        map.put("wpx", getDpiWidth(context));
        float f;
        Object obj;
        String s;
        Object obj1;
        String s1;
        String s2;
        if (isCachedVideoSupportedOnDevice(context))
        {
            map.put("cachedvideo", "true");
        } else
        {
            map.put("cachedvideo", "false");
        }
        if (Build.MODEL != null)
        {
            map.put("dm", Build.MODEL);
        }
        if (android.os.Build.VERSION.RELEASE != null)
        {
            map.put("dv", (new StringBuilder()).append("Android").append(android.os.Build.VERSION.RELEASE).toString());
        }
        obj = getMMdid(context);
        if (obj != null)
        {
            map.put("mmdid", obj);
        }
        map.put("sdkversion", "5.0.1-13.05.14.a");
        map.put("mmisdk", "5.0.1-13.05.14.a");
        map.put("mcc", getMcc(context));
        map.put("mnc", getMnc(context));
        obj = Locale.getDefault();
        if (obj != null)
        {
            map.put("language", ((Locale) (obj)).getLanguage());
            map.put("country", ((Locale) (obj)).getCountry());
        }
        try
        {
            obj = context.getPackageName();
            map.put("pkid", obj);
            PackageManager packagemanager = context.getPackageManager();
            map.put("pknm", packagemanager.getApplicationLabel(packagemanager.getApplicationInfo(((String) (obj)), 0)).toString());
        }
        catch (Exception exception) { }
        if (debugMode)
        {
            map.put("debug", "true");
        }
        obj = HandShake.sharedHandShake(context).getSchemesList(context);
        if (obj != null)
        {
            map.put("appsids", obj);
        }
        obj = AdCache.getCachedVideoList(context);
        if (obj != null)
        {
            map.put("vid", obj);
        }
        s1 = getConnectionType(context);
        if (!AdCache.isExternalStorageAvailable(context)) goto _L2; else goto _L1
_L1:
        obj = new StatFs(AdCache.getCacheDirectory(context).getAbsolutePath());
_L3:
        s2 = Long.toString((long)((StatFs) (obj)).getAvailableBlocks() * (long)((StatFs) (obj)).getBlockSize());
        s = null;
        obj = null;
        obj1 = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_484;
        }
        if (((Intent) (obj1)).getIntExtra("plugged", 0) == 0)
        {
            obj = "false";
        } else
        {
            obj = "true";
        }
        f = 100F / (float)((Intent) (obj1)).getIntExtra("scale", 100);
        obj1 = Integer.toString((int)((float)((Intent) (obj1)).getIntExtra("level", 0) * f));
        s = ((String) (obj));
        obj = obj1;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_506;
        }
        if (((String) (obj)).length() > 0)
        {
            map.put("bl", obj);
        }
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_531;
        }
        if (s.length() > 0)
        {
            map.put("plugged", s);
        }
        if (s2.length() > 0)
        {
            map.put("space", s2);
        }
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_568;
        }
        map.put("conn", s1);
        context = URLEncoder.encode(getIpAddress(context), "UTF-8");
        if (!TextUtils.isEmpty(context))
        {
            map.put("pip", context);
        }
_L4:
        MMRequest.insertLocation(map);
        return;
_L2:
        obj = new StatFs(context.getFilesDir().getPath());
          goto _L3
        context;
        Log.v(context);
          goto _L4
    }

    static boolean isCachedVideoSupportedOnDevice(Context context)
    {
        return context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != -1 && (!android.os.Build.VERSION.SDK.equalsIgnoreCase("8") || Environment.getExternalStorageState().equals("mounted") && AdCache.isExternalEnabled);
    }

    static boolean isConnected(Context context)
    {
        boolean flag = true;
        context = (ConnectivityManager)context.getSystemService("connectivity");
        if (context == null)
        {
            return false;
        }
        if (context.getActiveNetworkInfo() == null || !context.getActiveNetworkInfo().isConnected())
        {
            flag = false;
        }
        return flag;
    }

    static boolean isUiThread()
    {
        return mainHandler.getLooper() == Looper.myLooper();
    }

    private static boolean needsRawDisplayMethod()
    {
        return Integer.parseInt(android.os.Build.VERSION.SDK) >= 13 && Integer.parseInt(android.os.Build.VERSION.SDK) <= 16;
    }

    private static boolean needsRealDisplayMethod()
    {
        return Integer.parseInt(android.os.Build.VERSION.SDK) >= 17;
    }

    static void printDiagnostics(MMAdImpl mmadimpl)
    {
        Context context = mmadimpl.getContext();
        Log.i("MMAd Controllers: %s", new Object[] {
            MMAdImplController.controllersToString()
        });
        Log.i("MMAd External ID: %d", new Object[] {
            Integer.valueOf(mmadimpl.getId())
        });
        Log.i("MMAd Internal ID: %d", new Object[] {
            Long.valueOf(mmadimpl.internalId)
        });
        Log.i("APID: %s", new Object[] {
            mmadimpl.apid
        });
        if (AdCache.isExternalStorageAvailable(context))
        {
            mmadimpl = "";
        } else
        {
            mmadimpl = "not ";
        }
        Log.i("SD card is %savailable.", new Object[] {
            mmadimpl
        });
        if (context != null)
        {
            Log.i("Package: %s", new Object[] {
                context.getPackageName()
            });
            Log.i("MMDID: %s", new Object[] {
                getMMdid(context)
            });
            Log.i("Permissions:");
            if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == -1)
            {
                mmadimpl = "not ";
            } else
            {
                mmadimpl = "";
            }
            Log.i("android.permission.ACCESS_NETWORK_STATE is %spresent", new Object[] {
                mmadimpl
            });
            if (context.checkCallingOrSelfPermission("android.permission.INTERNET") == -1)
            {
                mmadimpl = "not ";
            } else
            {
                mmadimpl = "";
            }
            Log.i("android.permission.INTERNET is %spresent", new Object[] {
                mmadimpl
            });
            if (context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == -1)
            {
                mmadimpl = "not ";
            } else
            {
                mmadimpl = "";
            }
            Log.i("android.permission.WRITE_EXTERNAL_STORAGE is %spresent", new Object[] {
                mmadimpl
            });
            if (context.checkCallingOrSelfPermission("android.permission.VIBRATE") == -1)
            {
                mmadimpl = "not ";
            } else
            {
                mmadimpl = "";
            }
            Log.i("android.permission.VIBRATE is %spresent", new Object[] {
                mmadimpl
            });
            if (context.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == -1)
            {
                mmadimpl = "not ";
            } else
            {
                mmadimpl = "";
            }
            Log.i("android.permission.ACCESS_COARSE_LOCATION is %spresent", new Object[] {
                mmadimpl
            });
            if (context.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == -1)
            {
                mmadimpl = "not ";
            } else
            {
                mmadimpl = "";
            }
            Log.i("android.permission.ACCESS_FINE_LOCATION is %spresent", new Object[] {
                mmadimpl
            });
            Log.i("Cached Ads:");
            AdCache.iterateCachedAds(context, 2, new AdCache.Iterator(context) {

                final Context val$context;

                boolean callback(CachedAd cachedad)
                {
                    String s1 = cachedad.getTypeString();
                    String s2 = cachedad.getId();
                    String s;
                    if (cachedad.isOnDisk(context))
                    {
                        s = "";
                    } else
                    {
                        s = "not ";
                    }
                    if (cachedad.isExpired())
                    {
                        cachedad = "";
                    } else
                    {
                        cachedad = "not ";
                    }
                    Log.i("%s %s is %son disk. Is %sexpired.", new Object[] {
                        s1, s2, s, cachedad
                    });
                    return true;
                }

            
            {
                context = context1;
                super();
            }
            });
        }
    }

    static boolean removeAccelForJira1164()
    {
        return Integer.parseInt(android.os.Build.VERSION.SDK) >= 14;
    }

    public static void resetCache(Context context)
    {
        AdCache.resetCache(context);
    }

    static void runOnUiThread(Runnable runnable)
    {
        if (isUiThread())
        {
            runnable.run();
            return;
        } else
        {
            mainHandler.post(runnable);
            return;
        }
    }

    static void runOnUiThreadDelayed(Runnable runnable, long l)
    {
        mainHandler.postDelayed(runnable, l);
    }

    public static void setBroadcastEvents(boolean flag)
    {
        isBroadcastingEvents = flag;
    }

    public static void setLogLevel(int i)
    {
        logLevel = i;
    }

    static void setMMdid(String s)
    {
        com/millennialmedia/android/MMSDK;
        JVM INSTR monitorenter ;
        getMMdidValue = s;
        com/millennialmedia/android/MMSDK;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    static boolean supportsFullScreenInline()
    {
        return Integer.parseInt(android.os.Build.VERSION.SDK) >= 11;
    }

    public static void trackConversion(Context context, String s)
    {
        MMConversionTracker.trackConversion(context, s, null);
    }

    public static void trackConversion(Context context, String s, MMRequest mmrequest)
    {
        MMConversionTracker.trackConversion(context, s, mmrequest);
    }

    public static void trackEvent(Context context, String s)
    {
        if (!TextUtils.isEmpty(s))
        {
            context = getMMdid(context);
            if (!TextUtils.isEmpty(context))
            {
                Utils.HttpUtils.executeUrl((new StringBuilder()).append("http://ads.mp.mydas.mobi/pixel?id=").append(s).append("&mmdid=").append(context).toString());
            }
        }
    }


}
