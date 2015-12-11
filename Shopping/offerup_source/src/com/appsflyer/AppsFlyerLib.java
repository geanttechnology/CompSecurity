// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appsflyer;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.appsflyer.cache.CacheManager;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.appsflyer:
//            AppsFlyerProperties, AttributionIDNotReady, AppsFlyerConversionListener, DebugLogQueue, 
//            Installation, LogMessages, HashUtils, ConversionDataListener

public class AppsFlyerLib extends BroadcastReceiver
{

    static final String AF_COUNTER_PREF = "appsFlyerCount";
    static final String AF_EVENT_COUNTER_PREF = "appsFlyerCount";
    protected static final String AF_SHARED_PREF = "appsflyer-data";
    private static final String ANDROID_ID_CACHED_PREF = "androidIdCached";
    public static final String APPS_TRACKING_URL = "https://track.appsflyer.com/api/v2.3/androidevent?buildnumber=1.17&app_id=";
    public static final String ATTRIBUTION_ID_COLUMN_NAME = "aid";
    public static final Uri ATTRIBUTION_ID_CONTENT_URI = Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider");
    static final String ATTRIBUTION_ID_PREF = "attributionId";
    private static final String CACHED_CHANNEL_PREF = "CACHED_CHANNEL";
    private static final String CACHED_URL_PARAMTER = "&isCachedRequest=true";
    private static final String CALL_SERVER_ACTION = "call server.";
    private static final String DEEPLINK_ATTR_PREF = "deeplinkAttribution";
    private static final String ERROR_PREFIX = "ERROR:";
    public static final String EVENTS_TRACKING_URL = "https://events.appsflyer.com/api/v2.3/androidevent?buildnumber=1.17&app_id=";
    static final String FIRST_INSTALL_PREF = "appsFlyerFirstInstall";
    private static final List IGNORABLE_KEYS = Arrays.asList(new String[] {
        "is_cache"
    });
    private static final String IMEI_CACHED_PREF = "imeiCached";
    private static final String INSTALL_STORE_PREF = "INSTALL_STORE";
    private static final String INSTALL_UPDATE_DATE_FORMAT = "yyyy-MM-dd_hhmmZ";
    private static final String IN_APP_EVENTS_API = "1";
    public static final String LOG_TAG = "AppsFlyer_1.17";
    private static final String ON_RECIEVE_CALLED = "onRecieve called. refferer=";
    private static final String PREPARE_DATA_ACTION = "collect data for server";
    private static final String PRE_INSTALL_PREF = "preInstallName";
    protected static final String REFERRER_PREF = "referrer";
    public static final String SDK_BUILD_NUMBER = "1.17";
    static final String SENT_SUCCESSFULLY_PREF = "sentSuccessfully";
    public static final String SERVER_BUILD_NUMBER = "2.3";
    private static final String SERVER_RESPONDED_ACTION = "response from server. status=";
    private static final String UNINSTALL_URL = "https://track.appsflyer.com/api/v2.3/uninsall?buildnumber=1.17";
    private static final String WARNING_PREFIX = "WARNING:";
    private static ScheduledExecutorService cacheScheduler = null;
    private static AppsFlyerConversionListener conversionDataListener = null;
    private static boolean isDuringCheckCache = false;
    private static long lastCacheCheck;

    public AppsFlyerLib()
    {
    }

    private static void addAdvertiserIDData(Context context, Map map)
    {
        String s;
        Object obj;
        Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");
        obj = AdvertisingIdClient.getAdvertisingIdInfo(context);
        s = ((com.google.android.gms.ads.identifier.AdvertisingIdClient.Info) (obj)).getId();
        map.put("advertiserId", s);
        boolean flag;
        if (!((com.google.android.gms.ads.identifier.AdvertisingIdClient.Info) (obj)).isLimitAdTrackingEnabled())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj = Boolean.toString(flag);
        map.put("advertiserIdEnabled", obj);
        AppsFlyerProperties.getInstance().set("advertiserId", s);
        AppsFlyerProperties.getInstance().set("advertiserIdEnabled", ((String) (obj)));
_L1:
        return;
        map;
        if (shouldLog(context))
        {
            Log.i("AppsFlyer_1.17", "WARNING:Google Play services SDK jar is missing.");
            return;
        }
          goto _L1
        Exception exception;
        exception;
        String s1 = AppsFlyerProperties.getInstance().getString("advertiserId");
        if (s1 != null)
        {
            map.put("advertiserId", s1);
        }
        s1 = AppsFlyerProperties.getInstance().getString("advertiserIdEnabled");
        if (s1 != null)
        {
            map.put("advertiserIdEnabled", s1);
        }
        if (exception.getLocalizedMessage() != null)
        {
            Log.i("AppsFlyer_1.17", exception.getLocalizedMessage());
        } else
        {
            Log.i("AppsFlyer_1.17", exception.toString());
        }
        debugAction("Could not fetch advertiser id: ", exception.getLocalizedMessage(), context);
        return;
    }

    private static void addDeviceTracking(Context context, Map map)
    {
        if (!AppsFlyerProperties.getInstance().getBoolean("deviceTrackingDisabled", false)) goto _L2; else goto _L1
_L1:
        map.put("deviceTrackingDisabled", "true");
_L8:
        return;
_L2:
        String s;
        SharedPreferences sharedpreferences;
        boolean flag;
        sharedpreferences = context.getSharedPreferences("appsflyer-data", 0);
        flag = AppsFlyerProperties.getInstance().getBoolean("collectIMEI", true);
        s = sharedpreferences.getString("imeiCached", null);
        if (!flag) goto _L4; else goto _L3
_L3:
        String s1;
        TelephonyManager telephonymanager = (TelephonyManager)context.getSystemService("phone");
        s1 = (String)telephonymanager.getClass().getMethod("getDeviceId", new Class[0]).invoke(telephonymanager, new Object[0]);
        if (s1 != null) goto _L6; else goto _L5
_L5:
        Object obj = s;
_L13:
        if (obj != null)
        {
            try
            {
                map.put("imei", obj);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                Log.i("AppsFlyer_1.17", "WARNING:READ_PHONE_STATE is missing");
            }
        }
_L4:
        flag = AppsFlyerProperties.getInstance().getBoolean("collectAndroidId", true);
        obj = sharedpreferences.getString("androidIdCached", null);
        if (!flag) goto _L8; else goto _L7
_L7:
        try
        {
            context = android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id");
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
        if (context != null) goto _L10; else goto _L9
_L9:
        context = ((Context) (obj));
_L14:
        if (context == null) goto _L8; else goto _L11
_L11:
        map.put("android_id", context);
        return;
_L6:
        obj = s1;
        if (s != null) goto _L13; else goto _L12
_L12:
        obj = sharedpreferences.edit();
        ((android.content.SharedPreferences.Editor) (obj)).putString("imeiCached", s1);
        if (android.os.Build.VERSION.SDK_INT < 9)
        {
            break MISSING_BLOCK_LABEL_246;
        }
        ((android.content.SharedPreferences.Editor) (obj)).apply();
        obj = s1;
          goto _L13
        ((android.content.SharedPreferences.Editor) (obj)).commit();
        obj = s1;
          goto _L13
_L10:
label0:
        {
            obj = sharedpreferences.edit();
            ((android.content.SharedPreferences.Editor) (obj)).putString("androidIdCached", context);
            if (android.os.Build.VERSION.SDK_INT < 9)
            {
                break label0;
            }
            ((android.content.SharedPreferences.Editor) (obj)).apply();
        }
          goto _L14
        ((android.content.SharedPreferences.Editor) (obj)).commit();
          goto _L14
    }

    private static Map attributionStringToMap(String s)
    {
        HashMap hashmap = new HashMap();
        try
        {
            s = new JSONObject(s);
            Iterator iterator = s.keys();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                String s1 = (String)iterator.next();
                if (!IGNORABLE_KEYS.contains(s1))
                {
                    hashmap.put(s1, s.getString(s1));
                }
            } while (true);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.w("AppsFlyer_1.17", s);
            return null;
        }
        return hashmap;
    }

    private static void callServer(URL url, String s, String s1, WeakReference weakreference, String s2, String s3, boolean flag)
    {
        Context context = (Context)weakreference.get();
        HttpURLConnection httpurlconnection = (HttpURLConnection)url.openConnection();
        httpurlconnection.setRequestMethod("POST");
        int i = s.getBytes().length;
        httpurlconnection.setRequestProperty("Content-Length", (new StringBuilder()).append(i).toString());
        httpurlconnection.setRequestProperty("Connection", "close");
        httpurlconnection.setConnectTimeout(10000);
        httpurlconnection.setDoOutput(true);
        OutputStreamWriter outputstreamwriter = new OutputStreamWriter(httpurlconnection.getOutputStream());
        outputstreamwriter.write(s);
        int j;
        outputstreamwriter.close();
        j = httpurlconnection.getResponseCode();
        if (shouldLog(context))
        {
            Log.i(s3, (new StringBuilder("response code: ")).append(j).toString());
        }
        monitor(context, s3, "SERVER_RESPONSE_CODE", Integer.toString(j));
        debugAction("response from server. status=", Integer.toString(j), context);
        url = context.getSharedPreferences("appsflyer-data", 0);
        if (j != 200)
        {
            break MISSING_BLOCK_LABEL_247;
        }
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_204;
        }
        CacheManager.getInstance().deleteRequest(s2, context);
        if (weakreference.get() == null || s2 != null)
        {
            break MISSING_BLOCK_LABEL_247;
        }
        s = url.edit();
        s.putString("sentSuccessfully", "true");
        s.commit();
        checkCache(context);
        if (url.getString("attributionId", null) != null || s1 == null || !flag) goto _L2; else goto _L1
_L1:
        url = Executors.newSingleThreadScheduledExecutor();
        url.schedule(new InstallAttributionIdFetcher(context.getApplicationContext(), s1, url), 10L, TimeUnit.MILLISECONDS);
_L5:
        if (httpurlconnection != null)
        {
            httpurlconnection.disconnect();
        }
        return;
        url;
        s = null;
_L10:
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_321;
        }
        s.close();
        throw url;
_L9:
        s = null;
        if (s != null)
        {
            s.disconnect();
        }
        throw url;
_L2:
        if (s1 != null) goto _L4; else goto _L3
_L3:
        Log.w(s3, "AppsFlyer dev key is missing.");
          goto _L5
_L4:
        if (!flag) goto _L5; else goto _L6
_L6:
        if (conversionDataListener == null || url.getString("attributionId", null) == null) goto _L5; else goto _L7
_L7:
        k = getCounter(context, false);
        if (k <= 1) goto _L5; else goto _L8
_L8:
        url = getConversionData(context);
        if (url != null)
        {
            try
            {
                conversionDataListener.onInstallConversionDataLoaded(url);
            }
            // Misplaced declaration of an exception variable
            catch (URL url) { }
            finally
            {
                s = httpurlconnection;
            }
        }
          goto _L5
        url;
          goto _L9
        url;
        s = outputstreamwriter;
          goto _L10
    }

    private static void checkCache(Context context)
    {
        while (isDuringCheckCache || System.currentTimeMillis() - lastCacheCheck < 15000L || cacheScheduler != null) 
        {
            return;
        }
        ScheduledExecutorService scheduledexecutorservice = Executors.newSingleThreadScheduledExecutor();
        cacheScheduler = scheduledexecutorservice;
        scheduledexecutorservice.schedule(new CachedRequestSender(context), 1L, TimeUnit.SECONDS);
    }

    private static void debugAction(String s, String s1, Context context)
    {
        if (context != null && "com.appsflyer".equals(context.getPackageName()))
        {
            DebugLogQueue.getInstance().push((new StringBuilder()).append(s).append(s1).toString());
        }
    }

    public static String getAppId()
    {
        return getProperty("appid");
    }

    public static String getAppUserId()
    {
        return getProperty("AppUserId");
    }

    public static String getAppsFlyerUID(Context context)
    {
        return Installation.id(context);
    }

    public static String getAttributionId(ContentResolver contentresolver)
    {
        ContentResolver contentresolver1;
        Cursor cursor;
        contentresolver1 = null;
        cursor = contentresolver.query(ATTRIBUTION_ID_CONTENT_URI, new String[] {
            "aid"
        }, null, null, null);
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_37;
        }
        boolean flag = cursor.moveToFirst();
        if (flag)
        {
            break MISSING_BLOCK_LABEL_53;
        }
        contentresolver = contentresolver1;
        if (cursor != null)
        {
            try
            {
                cursor.close();
            }
            // Misplaced declaration of an exception variable
            catch (ContentResolver contentresolver)
            {
                return null;
            }
            contentresolver = contentresolver1;
        }
        return contentresolver;
        contentresolver = cursor.getString(cursor.getColumnIndex("aid"));
        contentresolver1 = contentresolver;
        contentresolver = contentresolver1;
        if (cursor != null)
        {
            try
            {
                cursor.close();
            }
            // Misplaced declaration of an exception variable
            catch (ContentResolver contentresolver)
            {
                return contentresolver1;
            }
            return contentresolver1;
        }
        break MISSING_BLOCK_LABEL_51;
        contentresolver;
        Log.w("AppsFlyer_1.17", "Could not collect cursor attribution", contentresolver);
        contentresolver = contentresolver1;
        if (cursor != null)
        {
            try
            {
                cursor.close();
            }
            // Misplaced declaration of an exception variable
            catch (ContentResolver contentresolver)
            {
                return null;
            }
            return null;
        } else
        {
            break MISSING_BLOCK_LABEL_51;
        }
        contentresolver;
        if (cursor != null)
        {
            try
            {
                cursor.close();
            }
            catch (Exception exception) { }
        }
        throw contentresolver;
    }

    private static String getCachedChannel(Context context, String s)
    {
        context = context.getSharedPreferences("appsflyer-data", 0);
        if (context.contains("CACHED_CHANNEL"))
        {
            return context.getString("CACHED_CHANNEL", null);
        } else
        {
            context = context.edit();
            context.putString("CACHED_CHANNEL", s);
            context.commit();
            return s;
        }
    }

    private static String getCachedStore(Context context)
    {
        String s = null;
        Object obj = context.getSharedPreferences("appsflyer-data", 0);
        if (((SharedPreferences) (obj)).contains("INSTALL_STORE"))
        {
            return ((SharedPreferences) (obj)).getString("INSTALL_STORE", null);
        }
        boolean flag = isAppsFlyerFirstLaunch(context);
        obj = ((SharedPreferences) (obj)).edit();
        if (flag)
        {
            s = getCurrentStore(context);
        }
        ((android.content.SharedPreferences.Editor) (obj)).putString("INSTALL_STORE", s);
        ((android.content.SharedPreferences.Editor) (obj)).commit();
        return s;
    }

    private static String getConfiguredChannel(Context context)
    {
        String s;
        Object obj;
        s = AppsFlyerProperties.getInstance().getString("channel");
        obj = s;
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_90;
        }
        try
        {
            context = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.i("AppsFlyer_1.17", "Could not load CHANNEL value", context);
            return s;
        }
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_86;
        }
        context = ((Context) (context.get("CHANNEL")));
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_86;
        }
        if (context instanceof String)
        {
            context = (String)context;
            break MISSING_BLOCK_LABEL_88;
        }
        context = context.toString();
        break MISSING_BLOCK_LABEL_88;
        context = s;
        obj = context;
        return ((String) (obj));
    }

    public static Map getConversionData(Context context)
    {
        SharedPreferences sharedpreferences = context.getSharedPreferences("appsflyer-data", 0);
        String s = AppsFlyerProperties.getInstance().getReferrer(context);
        if (s != null && s.length() > 0 && s.contains("af_tranid"))
        {
            return referrerStringToMap(s, context);
        }
        context = sharedpreferences.getString("attributionId", null);
        if (context != null && context.length() > 0)
        {
            return attributionStringToMap(context);
        } else
        {
            throw new AttributionIDNotReady();
        }
    }

    public static void getConversionData(Context context, final ConversionDataListener conversionDataListener)
    {
        registerConversionListener(context, new _cls1());
    }

    private static int getCounter(Context context, boolean flag)
    {
        context = context.getSharedPreferences("appsflyer-data", 0);
        int j = context.getInt("appsFlyerCount", 0);
        int i = j;
        if (flag)
        {
            i = j + 1;
            context = context.edit();
            context.putInt("appsFlyerCount", i);
            context.commit();
        }
        return i;
    }

    private static String getCurrentStore(Context context)
    {
        Object obj = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_71;
        }
        obj = ((Bundle) (obj)).get("AF_STORE");
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_71;
        }
        if (obj instanceof String)
        {
            return (String)obj;
        }
        obj = obj.toString();
        return ((String) (obj));
        Exception exception;
        exception;
        if (shouldLog(context))
        {
            Log.i("AppsFlyer_1.17", "Could not find AF_STORE value in the manifest", exception);
        }
        return null;
    }

    private static String getEventTag(Map map)
    {
        map = (String)map.get("af_timestamp");
        if (map == null || map.length() < 5)
        {
            return "AppsFlyer_1.17";
        } else
        {
            return (new StringBuilder("AppsFlyer_1.17-")).append(map.substring(4)).toString();
        }
    }

    private static String getFirstInstallDate(SimpleDateFormat simpledateformat, Context context)
    {
        SharedPreferences sharedpreferences = context.getSharedPreferences("appsflyer-data", 0);
        String s = sharedpreferences.getString("appsFlyerFirstInstall", null);
        Object obj = s;
        if (s == null)
        {
            if (isAppsFlyerFirstLaunch(context))
            {
                if (shouldLog(context))
                {
                    Log.d("AppsFlyer_1.17", "AppsFlyer: first launch detected");
                }
                simpledateformat = simpledateformat.format(new Date());
            } else
            {
                simpledateformat = "";
            }
            obj = sharedpreferences.edit();
            ((android.content.SharedPreferences.Editor) (obj)).putString("appsFlyerFirstInstall", simpledateformat);
            ((android.content.SharedPreferences.Editor) (obj)).commit();
            obj = simpledateformat;
        }
        if (shouldLog(context))
        {
            Log.i("AppsFlyer_1.17", (new StringBuilder("AppsFlyer: first launch date: ")).append(((String) (obj))).toString());
        }
        return ((String) (obj));
    }

    private static int getIAECounter(Context context, boolean flag)
    {
        context = context.getSharedPreferences("appsflyer-data", 0);
        int j = context.getInt("appsFlyerCount", 0);
        int i = j;
        if (flag)
        {
            i = j + 1;
            context = context.edit();
            context.putInt("appsFlyerCount", i);
            context.commit();
        }
        return i;
    }

    private static String getNetwork(Context context)
    {
        context = (ConnectivityManager)context.getSystemService("connectivity");
        if (context.getNetworkInfo(1).isConnectedOrConnecting())
        {
            return "WIFI";
        }
        context = context.getNetworkInfo(0);
        if (context != null && context.isConnectedOrConnecting())
        {
            return "MOBILE";
        } else
        {
            return "unkown";
        }
    }

    private static String getPreInstallName(Context context)
    {
        Object obj;
        Object obj1;
        android.content.SharedPreferences.Editor editor;
        boolean flag;
        obj1 = null;
        obj = context.getSharedPreferences("appsflyer-data", 0);
        if (((SharedPreferences) (obj)).contains("preInstallName"))
        {
            return ((SharedPreferences) (obj)).getString("preInstallName", null);
        }
        flag = isAppsFlyerFirstLaunch(context);
        editor = ((SharedPreferences) (obj)).edit();
        obj = obj1;
        if (!flag) goto _L2; else goto _L1
_L1:
        obj = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
        if (obj == null) goto _L4; else goto _L3
_L3:
        obj = ((Bundle) (obj)).get("AF_PRE_INSTALL_NAME");
        if (obj == null) goto _L4; else goto _L5
_L5:
        if (!(obj instanceof String)) goto _L7; else goto _L6
_L6:
        obj = (String)obj;
        context = ((Context) (obj));
_L9:
        obj = context;
_L2:
        editor.putString("preInstallName", ((String) (obj)));
        editor.commit();
        return ((String) (obj));
_L7:
        obj = obj.toString();
        context = ((Context) (obj));
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        obj = obj1;
        if (shouldLog(context))
        {
            Log.i("AppsFlyer_1.17", "Could not find AF_PRE_INSTALL_NAME value in the manifest", exception);
            obj = obj1;
        }
        if (true) goto _L2; else goto _L4
_L4:
        context = null;
        if (true) goto _L9; else goto _L8
_L8:
    }

    public static String getProperty(String s)
    {
        return AppsFlyerProperties.getInstance().getString(s);
    }

    private static boolean isAppsFlyerFirstLaunch(Context context)
    {
        boolean flag = false;
        if (!context.getSharedPreferences("appsflyer-data", 0).contains("appsFlyerCount"))
        {
            flag = true;
        }
        return flag;
    }

    public static boolean isPreInstalledApp(Context context)
    {
        boolean flag = false;
        int i;
        try
        {
            i = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).flags;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.e("AppsFlyer_1.17", "Could not check if app is pre installed", context);
            return false;
        }
        if ((i & 1) != 0)
        {
            flag = true;
        }
        return flag;
    }

    private static String mapToString(Map map)
    {
        StringBuilder stringbuilder = new StringBuilder();
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()) 
        {
            String s1 = (String)iterator.next();
            String s = (String)map.get(s1);
            if (s == null)
            {
                s = "";
            } else
            {
                s = URLEncoder.encode(s, "UTF-8");
            }
            if (stringbuilder.length() > 0)
            {
                stringbuilder.append('&');
            }
            stringbuilder.append(s1).append('=').append(s);
        }
        return stringbuilder.toString();
    }

    private static void monitor(Context context, String s, String s1, String s2)
    {
        if (AppsFlyerProperties.getInstance().getBoolean("shouldMonitor", false))
        {
            Intent intent = new Intent("com.appsflyer.MonitorBroadcast");
            intent.setPackage("com.appsflyer.nightvision");
            intent.putExtra("message", s1);
            intent.putExtra("value", s2);
            intent.putExtra("packageName", "true");
            intent.putExtra("pid", new Integer(Process.myPid()));
            intent.putExtra("eventIdentifier", s);
            intent.putExtra("sdk", "2.3.1.17");
            context.sendBroadcast(intent);
        }
    }

    private static Map referrerStringToMap(String s, Context context)
    {
        HashMap hashmap;
        int i;
        hashmap = new HashMap();
        i = s.indexOf('&');
        if (i < 0 || s.length() <= i + 1) goto _L2; else goto _L1
_L1:
        boolean flag1;
        String as[] = s.split("\\&");
        int k = as.length;
        int j = 0;
        boolean flag = false;
        while (j < k) 
        {
            s = as[j].split("=");
            String s1;
            String s2;
            if (s.length > 1)
            {
                s1 = s[1];
            } else
            {
                s1 = "";
            }
            s2 = s[0];
            if (s2.equals("c"))
            {
                s = "campaign";
            } else
            if (s2.equals("pid"))
            {
                s = "media_source";
            } else
            {
                s = s2;
                if (s2.equals("af_prt"))
                {
                    hashmap.put(s2, s1);
                    s = "agency";
                    flag = true;
                }
            }
            hashmap.put(s, s1);
            j++;
        }
        try
        {
            if (!hashmap.containsKey("install_time"))
            {
                long l = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).firstInstallTime;
                hashmap.put("install_time", (new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")).format(new Date(l)));
            }
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.w("AppsFlyer_1.17", "Could not fetch install time");
        }
        flag1 = flag;
        if (!hashmap.containsKey("af_status"))
        {
            hashmap.put("af_status", "Non-organic");
            flag1 = flag;
        }
_L4:
        if (flag1)
        {
            hashmap.remove("media_source");
        }
        return hashmap;
_L2:
        flag1 = false;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static void registerConversionListener(Context context, AppsFlyerConversionListener appsflyerconversionlistener)
    {
        if (appsflyerconversionlistener == null)
        {
            return;
        } else
        {
            conversionDataListener = appsflyerconversionlistener;
            return;
        }
    }

    private static void runInBackground(Context context, String s, String s1, String s2, String s3, boolean flag)
    {
        ScheduledExecutorService scheduledexecutorservice = Executors.newSingleThreadScheduledExecutor();
        scheduledexecutorservice.schedule(new DataCollector(context, s, s1, s2, s3, flag, scheduledexecutorservice, null), 5L, TimeUnit.MILLISECONDS);
    }

    private static void sendRequestToServer(String s, String s1, String s2, WeakReference weakreference, String s3, String s4, boolean flag)
    {
        URL url = new URL(s);
        if (shouldLog((Context)weakreference.get()))
        {
            Log.i(s4, (new StringBuilder("url: ")).append(url.toString()).toString());
        }
        debugAction("call server.", (new StringBuilder("\n")).append(url.toString()).append("\nPOST:").append(s1).toString(), (Context)weakreference.get());
        if (shouldLog((Context)weakreference.get()))
        {
            LogMessages.logMessageMaskKey((new StringBuilder("data: ")).append(s1).toString());
        }
        monitor((Context)weakreference.get(), s4, "EVENT_DATA", s1);
        if (flag)
        {
            AppsFlyerProperties.getInstance().setLaunchCollectedReferrer();
        }
        try
        {
            callServer(url, s1, s2, weakreference, s3, s4, flag);
            return;
        }
        catch (IOException ioexception)
        {
            if (AppsFlyerProperties.getInstance().getBoolean("useHttpFallback", false))
            {
                debugAction((new StringBuilder("https failed: ")).append(ioexception.getLocalizedMessage()).toString(), "", (Context)weakreference.get());
                callServer(new URL(s.replace("https:", "http:")), s1, s2, weakreference, s3, s4, flag);
                return;
            } else
            {
                Log.i(s4, (new StringBuilder("failed to send requeset to server. ")).append(ioexception.getLocalizedMessage()).toString());
                monitor((Context)weakreference.get(), s4, "ERROR", ioexception.getLocalizedMessage());
                return;
            }
        }
    }

    public static void sendTracking(Context context)
    {
        sendTracking(context, null);
        if (shouldLog(context))
        {
            Log.i("AppsFlyer_1.17", (new StringBuilder("Start tracking package: ")).append(context.getPackageName()).toString());
        }
    }

    public static void sendTracking(Context context, String s)
    {
        sendTrackingWithEvent(context, s, null, null);
    }

    public static void sendTrackingWithEvent(Context context, String s, String s1)
    {
        sendTrackingWithEvent(context, null, s, s1);
    }

    public static void sendTrackingWithEvent(Context context, String s, String s1, String s2)
    {
        if (s1 != null && s2 != null && s2.matches("-?\\d+(\\.\\d+)?"))
        {
            Log.i("AppsFlyer_1.17", (new StringBuilder("AppsFLyer: numeric value '")).append(s2).append("' for event '").append(s1).append("' will be categorized as a revenue event.").toString());
        }
        String s4 = AppsFlyerProperties.getInstance().getReferrer(context);
        String s3 = s4;
        if (s4 == null)
        {
            s3 = "";
        }
        runInBackground(context, s, s1, s2, s3, false);
    }

    private static void sendTrackingWithEvent(Context context, String s, String s1, String s2, String s3, boolean flag)
    {
        Object obj;
        String s4;
        HashMap hashmap;
        StringBuilder stringbuilder;
        String s5;
        int i;
        int j;
        long l;
        long l1;
        boolean flag1;
        if (s1 == null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        hashmap = new HashMap();
        hashmap.put("af_timestamp", Long.toString((new Date()).getTime()));
        s4 = getEventTag(hashmap);
        if (!shouldLog(context)) goto _L2; else goto _L1
_L1:
        debugAction("collect data for server", "", context);
        stringbuilder = new StringBuilder("******* sendTrackingWithEvent: ");
        if (flag1)
        {
            obj = "Launch";
        } else
        {
            obj = s1;
        }
        Log.i(s4, stringbuilder.append(((String) (obj))).toString());
        if (flag1)
        {
            obj = "Launch";
        } else
        {
            obj = s1;
        }
        debugAction("********* sendTrackingWithEvent: ", ((String) (obj)), context);
          goto _L2
_L27:
        monitor(context, s4, "EVENT_CREATED_WITH_NAME", ((String) (obj)));
        CacheManager.getInstance().init(context);
        try
        {
            obj = Arrays.asList(context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions);
            if (!((List) (obj)).contains("android.permission.INTERNET"))
            {
                Log.w("AppsFlyer_1.17", "Permission android.permission.INTERNET is missing in the AndroidManifest.xml");
                monitor(context, null, "PERMISSION_INTERNET_MISSING", null);
            }
            if (!((List) (obj)).contains("android.permission.ACCESS_NETWORK_STATE"))
            {
                Log.w("AppsFlyer_1.17", "Permission android.permission.ACCESS_NETWORK_STATE is missing in the AndroidManifest.xml");
            }
            if (!((List) (obj)).contains("android.permission.ACCESS_WIFI_STATE"))
            {
                Log.w("AppsFlyer_1.17", "Permission android.permission.ACCESS_WIFI_STATE is missing in the AndroidManifest.xml");
            }
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        stringbuilder = new StringBuilder();
        if (flag)
        {
            obj = "https://events.appsflyer.com/api/v2.3/androidevent?buildnumber=1.17&app_id=";
        } else
        {
            obj = "https://track.appsflyer.com/api/v2.3/androidevent?buildnumber=1.17&app_id=";
        }
        stringbuilder.append(((String) (obj))).append(context.getPackageName());
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_289;
        }
        hashmap.put("af_events_api", "1");
        hashmap.put("brand", Build.BRAND);
        hashmap.put("device", Build.DEVICE);
        hashmap.put("product", Build.PRODUCT);
        hashmap.put("sdk", Integer.toString(android.os.Build.VERSION.SDK_INT));
        hashmap.put("model", Build.MODEL);
        hashmap.put("deviceType", Build.TYPE);
        obj = AppsFlyerProperties.getInstance().getString("sdkExtension");
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_413;
        }
        if (((String) (obj)).length() > 0)
        {
            hashmap.put("sdkExtension", obj);
        }
        obj = getConfiguredChannel(context);
        s5 = getCachedChannel(context, ((String) (obj)));
        if (s5 == null)
        {
            break MISSING_BLOCK_LABEL_445;
        }
        hashmap.put("channel", s5);
        if (s5 == null) goto _L4; else goto _L3
_L3:
        if (!s5.equals(obj)) goto _L5; else goto _L4
_L5:
        hashmap.put("af_latestchannel", obj);
_L28:
        obj = getCachedStore(context);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_503;
        }
        hashmap.put("af_installstore", ((String) (obj)).toLowerCase());
        obj = getPreInstallName(context);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_530;
        }
        hashmap.put("af_preinstall_name", ((String) (obj)).toLowerCase());
        obj = getCurrentStore(context);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_557;
        }
        hashmap.put("af_currentstore", ((String) (obj)).toLowerCase());
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_571;
        }
        obj = s;
        if (s.length() != 0)
        {
            break MISSING_BLOCK_LABEL_579;
        }
        obj = getProperty("AppsFlyerKey");
        if (obj == null) goto _L7; else goto _L6
_L6:
        if (((String) (obj)).length() <= 0) goto _L7; else goto _L8
_L8:
        hashmap.put("appsflyerKey", obj);
        if (((String) (obj)).length() > 8)
        {
            hashmap.put("dkh", ((String) (obj)).substring(0, 8));
        }
        s = getAppUserId();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_654;
        }
        hashmap.put("appUserId", s);
        s = AppsFlyerProperties.getInstance().getStringArray("userEmails");
        if (s == null) goto _L10; else goto _L9
_L9:
        obj = new StringBuilder();
        j = s.length;
        i = 0;
_L12:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        s5 = s[i];
        if (((StringBuilder) (obj)).length() > 1)
        {
            ((StringBuilder) (obj)).append(',');
        }
        ((StringBuilder) (obj)).append(HashUtils.toSHA1(s5));
        i++;
        if (true) goto _L12; else goto _L11
_L11:
        hashmap.put("sha1_el_arr", ((StringBuilder) (obj)).toString());
_L21:
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_811;
        }
        hashmap.put("eventName", s1);
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_811;
        }
        hashmap.put("eventValue", s2);
        if (getProperty("appid") != null)
        {
            hashmap.put("appid", getProperty("appid"));
        }
        s = getProperty("currencyCode");
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_897;
        }
        if (s.length() != 3)
        {
            Log.w("AppsFlyer_1.17", (new StringBuilder("WARNING:currency code should be 3 characters!!! '")).append(s).append("' is not a legal value.").toString());
        }
        hashmap.put("currency", s);
        s = getProperty("IS_UPDATE");
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_920;
        }
        hashmap.put("isUpdate", s);
        hashmap.put("af_preinstalled", Boolean.toString(isPreInstalledApp(context)));
        s = getAttributionId(context.getContentResolver());
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_962;
        }
        hashmap.put("fb", s);
        addDeviceTracking(context, hashmap);
        s = Installation.id(context);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_989;
        }
        hashmap.put("uid", s);
_L22:
        try
        {
            hashmap.put("lang", Locale.getDefault().getDisplayLanguage());
        }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        try
        {
            hashmap.put("lang_code", Locale.getDefault().getLanguage());
        }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        try
        {
            hashmap.put("country", Locale.getDefault().getCountry());
        }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        try
        {
            s = (TelephonyManager)context.getSystemService("phone");
            hashmap.put("operator", s.getSimOperatorName());
            hashmap.put("carrier", s.getNetworkOperatorName());
        }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        hashmap.put("network", getNetwork(context));
_L23:
        addAdvertiserIDData(context, hashmap);
        s = new SimpleDateFormat("yyyy-MM-dd_hhmmZ");
        i = android.os.Build.VERSION.SDK_INT;
        if (i < 9)
        {
            break MISSING_BLOCK_LABEL_1161;
        }
        try
        {
            hashmap.put("installDate", s.format(new Date(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).firstInstallTime)));
        }
        // Misplaced declaration of an exception variable
        catch (String s1) { }
        try
        {
            s1 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            hashmap.put("app_version_code", Integer.toString(((PackageInfo) (s1)).versionCode));
            hashmap.put("app_version_name", ((PackageInfo) (s1)).versionName);
            l = ((PackageInfo) (s1)).firstInstallTime;
            l1 = ((PackageInfo) (s1)).lastUpdateTime;
            hashmap.put("date1", s.format(new Date(l)));
            hashmap.put("date2", s.format(new Date(l1)));
            hashmap.put("firstLaunchDate", getFirstInstallDate(s, context));
        }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        if (s3.length() > 0)
        {
            hashmap.put("referrer", s3);
        }
        s = context.getSharedPreferences("appsflyer-data", 0);
        s1 = s.getString("attributionId", null);
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_1344;
        }
        if (s1.length() > 0)
        {
            hashmap.put("installAttribution", s1);
        }
        if (!flag1) goto _L14; else goto _L13
_L13:
        if (!(context instanceof Activity)) goto _L14; else goto _L15
_L15:
        s1 = ((Activity)context).getIntent();
        if (s1.getAction() != "android.intent.action.VIEW") goto _L17; else goto _L16
_L16:
        s2 = s1.getData();
        if (s2.getQueryParameter("af_deeplink") == null) goto _L19; else goto _L18
_L18:
        hashmap.put("af_deeplink_launch", "true");
        s1 = referrerStringToMap(s2.getQuery().toString(), context);
        if (s2.getPath() != null)
        {
            s1.put("path", s2.getPath());
        }
        if (s2.getScheme() != null)
        {
            s1.put("scheme", s2.getScheme());
        }
        s2 = (new JSONObject(s1)).toString();
        hashmap.put("af_deeplink_attr", s2);
        s = s.edit();
        s.putString("deeplinkAttribution", s2);
        s.commit();
        if (conversionDataListener != null)
        {
            conversionDataListener.onAppOpenAttribution(s1);
        }
_L24:
        System.out.println("AppsFlyerLib.sendTrackingWithEvent");
_L17:
        (new SendToServerRunnable(stringbuilder.toString(), hashmap, context.getApplicationContext(), flag1, null)).run();
        return;
_L7:
        try
        {
            Log.e(s4, "AppsFlyer dev key is missing!!! Please use  AppsFlyerLib.setAppsFlyerKey(...) to set it. ");
            monitor(context, s4, "DEV_KEY_MISSING", null);
            Log.e(s4, "AppsFlyer will not track this event.");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.e(s4, context.getLocalizedMessage(), context);
        }
        return;
_L10:
        s = getProperty("userEmail");
        if (s == null) goto _L21; else goto _L20
_L20:
        hashmap.put("sha1_el", HashUtils.toSHA1(s));
          goto _L21
        s;
        Log.i("AppsFlyer_1.17", (new StringBuilder("ERROR:")).append("ERROR:could not get uid ").append(s.getMessage()).toString());
          goto _L22
        s;
        Log.i("AppsFlyer_1.17", (new StringBuilder("checking network error ")).append(s.getMessage()).toString());
          goto _L23
_L19:
        s = Executors.newSingleThreadScheduledExecutor();
        s1 = getProperty("AppsFlyerKey");
        s.schedule(new ReAttributionIdFetcher(context.getApplicationContext(), s1, s), 100L, TimeUnit.MILLISECONDS);
          goto _L24
_L14:
        if (flag1) goto _L17; else goto _L25
_L25:
        s = s.getString("deeplinkAttribution", null);
        if (s == null) goto _L17; else goto _L26
_L26:
        hashmap.put("af_deeplink_attr", s);
          goto _L17
_L2:
        if (flag1)
        {
            obj = "Launch";
        } else
        {
            obj = s1;
        }
          goto _L27
_L4:
        if (s5 != null || obj == null) goto _L28; else goto _L5
    }

    private void sendUninstall(String s, Context context)
    {
        Object obj;
        HttpURLConnection httpurlconnection;
        Object obj2;
        httpurlconnection = null;
        obj2 = null;
        obj = httpurlconnection;
        Object obj1 = (new StringBuilder("https://track.appsflyer.com/api/v2.3/uninsall?buildnumber=1.17")).toString();
        obj = httpurlconnection;
        if (!shouldLog(context))
        {
            break MISSING_BLOCK_LABEL_60;
        }
        obj = httpurlconnection;
        Log.i("AppsFlyer_1.17", (new StringBuilder("Calling server for uninstall url: ")).append(((String) (obj1))).toString());
        obj = httpurlconnection;
        Object obj3 = new HashMap();
        obj = httpurlconnection;
        ((Map) (obj3)).put("packageName", s);
        obj = httpurlconnection;
        addAdvertiserIDData(context, ((Map) (obj3)));
        obj = httpurlconnection;
        addDeviceTracking(context, ((Map) (obj3)));
        obj = httpurlconnection;
        obj3 = mapToString(((Map) (obj3)));
        obj = httpurlconnection;
        httpurlconnection = (HttpURLConnection)(new URL(((String) (obj1)))).openConnection();
        httpurlconnection.setRequestMethod("POST");
        int i = ((String) (obj3)).getBytes().length;
        httpurlconnection.setRequestProperty("Content-Length", (new StringBuilder()).append(i).toString());
        httpurlconnection.setRequestProperty("Connection", "close");
        httpurlconnection.setConnectTimeout(10000);
        httpurlconnection.setDoOutput(true);
        obj1 = new OutputStreamWriter(httpurlconnection.getOutputStream());
        ((OutputStreamWriter) (obj1)).write(((String) (obj3)));
        ((OutputStreamWriter) (obj1)).close();
        if (httpurlconnection.getResponseCode() != 200) goto _L2; else goto _L1
_L1:
        if (shouldLog(context))
        {
            Log.i("AppsFlyer_1.17", (new StringBuilder("Uninstall sent successfully: ")).append(s).toString());
        }
_L6:
        if (httpurlconnection != null)
        {
            httpurlconnection.disconnect();
        }
_L4:
        return;
        obj;
        obj1 = null;
_L10:
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_291;
        }
        ((OutputStreamWriter) (obj1)).close();
        throw obj;
        Throwable throwable;
        throwable;
_L9:
        obj = httpurlconnection;
        if (!shouldLog(context))
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = httpurlconnection;
        Log.i("AppsFlyer_1.17", (new StringBuilder("Failed to send uninstall: ")).append(s).append(" :").append(throwable.getLocalizedMessage()).toString());
        if (httpurlconnection == null) goto _L4; else goto _L3
_L3:
        httpurlconnection.disconnect();
        return;
_L2:
        if (!shouldLog(context)) goto _L6; else goto _L5
_L5:
        Log.i("AppsFlyer_1.17", (new StringBuilder("Failed to send uninstall: ")).append(s).toString());
          goto _L6
        s;
        obj = httpurlconnection;
_L8:
        if (obj != null)
        {
            ((HttpURLConnection) (obj)).disconnect();
        }
        throw s;
        s;
        if (true) goto _L8; else goto _L7
_L7:
        throwable;
        httpurlconnection = obj2;
          goto _L9
        obj;
          goto _L10
    }

    public static void setAppId(String s)
    {
        setProperty("appid", s);
    }

    public static void setAppUserId(String s)
    {
        setProperty("AppUserId", s);
    }

    public static void setAppsFlyerKey(String s)
    {
        setProperty("AppsFlyerKey", s);
        LogMessages.setDevKey(s);
    }

    public static void setCollectAndroidID(boolean flag)
    {
        setProperty("collectAndroidId", Boolean.toString(flag));
    }

    public static void setCollectIMEI(boolean flag)
    {
        setProperty("collectIMEI", Boolean.toString(flag));
    }

    public static void setCollectMACAddress(boolean flag)
    {
        setProperty("collectMAC", Boolean.toString(flag));
    }

    public static void setCurrencyCode(String s)
    {
        AppsFlyerProperties.getInstance().set("currencyCode", s);
    }

    public static void setDeviceTrackingDisabled(boolean flag)
    {
        AppsFlyerProperties.getInstance().set("deviceTrackingDisabled", flag);
    }

    public static void setExtension(String s)
    {
        AppsFlyerProperties.getInstance().set("sdkExtension", s);
    }

    public static void setIsUpdate(boolean flag)
    {
        AppsFlyerProperties.getInstance().set("IS_UPDATE", flag);
    }

    protected static void setProperty(String s, String s1)
    {
        AppsFlyerProperties.getInstance().set(s, s1);
    }

    public static void setUseHTTPFalback(boolean flag)
    {
        setProperty("useHttpFallback", Boolean.toString(flag));
    }

    public static void setUserEmail(String s)
    {
        setProperty("userEmail", s);
    }

    public static transient void setUserEmails(String as[])
    {
        AppsFlyerProperties.getInstance().set("userEmails", as);
    }

    private static boolean shouldLog(Context context)
    {
        return !AppsFlyerProperties.getInstance().isDisableLog();
    }

    public static void trackEvent(Context context, String s, Map map)
    {
        Object obj = map;
        if (map == null)
        {
            obj = new HashMap();
        }
        map = new JSONObject(((Map) (obj)));
        obj = AppsFlyerProperties.getInstance().getReferrer(context);
        String s1 = map.toString();
        map = ((Map) (obj));
        if (obj == null)
        {
            map = "";
        }
        runInBackground(context, null, s, s1, map, true);
    }

    public void onReceive(Context context, Intent intent)
    {
        if ("android.intent.action.PACKAGE_REMOVED".equals(intent.getAction()))
        {
            sendUninstall(intent.getDataString(), context);
        } else
        {
            String s = intent.getStringExtra("shouldMonitor");
            if (s != null)
            {
                Log.i("AppsFlyer_1.17", "Turning on monitoring.");
                AppsFlyerProperties.getInstance().set("shouldMonitor", s.equals("true"));
                monitor(context, null, "START_TRACKING", context.getPackageName());
                return;
            }
            Log.i("AppsFlyer_1.17", "****** onReceive called *******");
            debugAction("******* onReceive: ", "", context);
            AppsFlyerProperties.getInstance().setOnReceiveCalled();
            intent = intent.getStringExtra("referrer");
            if (shouldLog(context))
            {
                Log.i("AppsFlyer_1.17", (new StringBuilder("Play store referrer: ")).append(intent).toString());
            }
            if (intent != null)
            {
                debugAction("BroadcastReceiver got referrer: ", intent, context);
                debugAction("onRecieve called. refferer=", intent, context);
                android.content.SharedPreferences.Editor editor = context.getSharedPreferences("appsflyer-data", 0).edit();
                editor.putString("referrer", intent);
                editor.commit();
                AppsFlyerProperties.getInstance().setReferrer(intent);
                if (AppsFlyerProperties.getInstance().isLaunchCollectedReferrerd())
                {
                    Log.i("AppsFlyer_1.17", "onReceive: isLaunchCalled");
                    runInBackground(context, null, null, null, intent, false);
                    return;
                }
            }
        }
    }







/*
    static boolean access$1302(boolean flag)
    {
        isDuringCheckCache = flag;
        return flag;
    }

*/


/*
    static long access$1402(long l)
    {
        lastCacheCheck = l;
        return l;
    }

*/



/*
    static ScheduledExecutorService access$1502(ScheduledExecutorService scheduledexecutorservice)
    {
        cacheScheduler = scheduledexecutorservice;
        return scheduledexecutorservice;
    }

*/









    private class InstallAttributionIdFetcher extends AttributionIdFetcher
    {
        private class AttributionIdFetcher
            implements Runnable
        {

            private static AtomicInteger currentRequestsCounter = new AtomicInteger(0);
            private String appsFlyerDevKey;
            private WeakReference ctxReference;
            private ScheduledExecutorService executorService;

            protected abstract void callback(Map map);

            protected abstract void callbackFailure(String s);

            public abstract String getUrl();

            public void run()
            {
                Object obj5;
                obj5 = null;
                if (appsFlyerDevKey == null || appsFlyerDevKey.length() == 0)
                {
                    return;
                }
                currentRequestsCounter.incrementAndGet();
                Context context = (Context)ctxReference.get();
                if (context == null)
                {
                    currentRequestsCounter.decrementAndGet();
                    return;
                }
                Object obj2 = AppsFlyerLib.getCachedChannel(context, AppsFlyerLib.getConfiguredChannel(context));
                Object obj;
                obj = "";
                if (obj2 == null)
                {
                    break MISSING_BLOCK_LABEL_88;
                }
                obj = (new StringBuilder("-")).append(((String) (obj2))).toString();
                Object obj3;
                obj2 = (new StringBuilder()).append(getUrl()).append(context.getPackageName()).append(((String) (obj))).append("?devkey=").append(appsFlyerDevKey).append("&device_id=").append(AppsFlyerLib.getAppsFlyerUID(context));
                if (AppsFlyerLib.shouldLog(context))
                {
                    LogMessages.logMessageMaskKey((new StringBuilder("Calling server for attribution url: ")).append(((StringBuilder) (obj2)).toString()).toString());
                }
                obj3 = (HttpURLConnection)(new URL(((StringBuilder) (obj2)).toString())).openConnection();
                obj = obj3;
                ((HttpURLConnection) (obj3)).setRequestMethod("GET");
                obj = obj3;
                ((HttpURLConnection) (obj3)).setConnectTimeout(10000);
                obj = obj3;
                ((HttpURLConnection) (obj3)).setRequestProperty("Connection", "close");
                obj = obj3;
                ((HttpURLConnection) (obj3)).connect();
                obj = obj3;
                if (((HttpURLConnection) (obj3)).getResponseCode() != 200) goto _L2; else goto _L1
_L1:
                obj = obj3;
                StringBuilder stringbuilder = new StringBuilder();
                Object obj4 = new InputStreamReader(((HttpURLConnection) (obj3)).getInputStream());
                obj2 = new BufferedReader(((java.io.Reader) (obj4)));
_L5:
                obj = ((BufferedReader) (obj2)).readLine();
                if (obj == null) goto _L4; else goto _L3
_L3:
                stringbuilder.append(((String) (obj))).append('\n');
                  goto _L5
                obj;
                obj5 = obj2;
                obj2 = obj;
_L18:
                if (obj5 == null)
                {
                    break MISSING_BLOCK_LABEL_309;
                }
                obj = obj3;
                ((BufferedReader) (obj5)).close();
                if (obj4 == null)
                {
                    break MISSING_BLOCK_LABEL_321;
                }
                obj = obj3;
                ((InputStreamReader) (obj4)).close();
                obj = obj3;
                android.content.SharedPreferences.Editor editor;
                int i;
                try
                {
                    throw obj2;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    obj2 = obj3;
                }
                finally
                {
                    obj2 = obj;
                }
                obj3 = obj;
_L16:
                obj = obj2;
                if (AppsFlyerLib.conversionDataListener == null)
                {
                    break MISSING_BLOCK_LABEL_348;
                }
                obj = obj2;
                callbackFailure(((Throwable) (obj3)).getMessage());
                obj = obj2;
                Log.e("AppsFlyer_1.17", ((Throwable) (obj3)).getMessage(), ((Throwable) (obj3)));
                currentRequestsCounter.decrementAndGet();
                if (obj2 != null)
                {
                    ((HttpURLConnection) (obj2)).disconnect();
                }
_L10:
                executorService.shutdown();
                return;
_L4:
                obj = obj3;
                ((BufferedReader) (obj2)).close();
                obj = obj3;
                ((InputStreamReader) (obj4)).close();
                obj = obj3;
                if (!AppsFlyerLib.shouldLog(context))
                {
                    break MISSING_BLOCK_LABEL_434;
                }
                obj = obj3;
                LogMessages.logMessageMaskKey((new StringBuilder("Attribution data: ")).append(stringbuilder.toString()).toString());
                obj = obj3;
                if (stringbuilder.length() <= 0 || context == null) goto _L7; else goto _L6
_L6:
                obj = obj3;
                obj2 = AppsFlyerLib.attributionStringToMap(stringbuilder.toString());
                obj = obj3;
                obj4 = (String)((Map) (obj2)).get("iscache");
                if (obj4 == null)
                {
                    break MISSING_BLOCK_LABEL_492;
                }
                obj = obj3;
                if (!"true".equals(obj4))
                {
                    break MISSING_BLOCK_LABEL_576;
                }
                obj = obj3;
                editor = context.getSharedPreferences("appsflyer-data", 0).edit();
                obj = obj3;
                editor.putString("attributionId", stringbuilder.toString());
                obj = obj3;
                editor.commit();
                obj = obj3;
                if (!AppsFlyerLib.shouldLog(context))
                {
                    break MISSING_BLOCK_LABEL_576;
                }
                obj = obj3;
                Log.d("AppsFlyer_1.17", (new StringBuilder("iscache=")).append(((String) (obj4))).append(" caching conversion data").toString());
                obj = obj3;
                if (AppsFlyerLib.conversionDataListener == null) goto _L7; else goto _L8
_L8:
                obj = obj3;
                i = currentRequestsCounter.intValue();
                if (i > 1) goto _L7; else goto _L9
_L9:
                obj = obj3;
                obj4 = AppsFlyerLib.getConversionData(context);
                obj2 = obj4;
_L11:
                obj = obj3;
                callback(((Map) (obj2)));
_L7:
                currentRequestsCounter.decrementAndGet();
                if (obj3 != null)
                {
                    ((HttpURLConnection) (obj3)).disconnect();
                }
                  goto _L10
                obj;
                  goto _L11
_L2:
                obj = obj3;
                if (AppsFlyerLib.conversionDataListener == null)
                {
                    break MISSING_BLOCK_LABEL_675;
                }
                obj = obj3;
                callbackFailure((new StringBuilder("Error connection to server: ")).append(((HttpURLConnection) (obj3)).getResponseCode()).toString());
                obj = obj3;
                if (!AppsFlyerLib.shouldLog(context)) goto _L7; else goto _L12
_L12:
                obj = obj3;
                LogMessages.logMessageMaskKey((new StringBuilder("AttributionIdFetcher response code: ")).append(((HttpURLConnection) (obj3)).getResponseCode()).append("  url: ").append(obj2).toString());
                  goto _L7
                Object obj1 = obj3;
_L14:
                currentRequestsCounter.decrementAndGet();
                if (obj2 != null)
                {
                    ((HttpURLConnection) (obj2)).disconnect();
                }
                throw obj1;
                obj1;
                obj2 = null;
                if (true) goto _L14; else goto _L13
_L13:
                obj3;
                obj2 = null;
                if (true) goto _L16; else goto _L15
_L15:
                obj2;
                obj4 = null;
                continue; /* Loop/switch isn't completed */
                obj2;
                if (true) goto _L18; else goto _L17
_L17:
            }


            public AttributionIdFetcher(Context context, String s, ScheduledExecutorService scheduledexecutorservice)
            {
                ctxReference = null;
                ctxReference = new WeakReference(context);
                appsFlyerDevKey = s;
                executorService = scheduledexecutorservice;
            }
        }


        protected void callback(Map map)
        {
            AppsFlyerLib.conversionDataListener.onInstallConversionDataLoaded(map);
        }

        protected void callbackFailure(String s)
        {
            AppsFlyerLib.conversionDataListener.onInstallConversionFailure(s);
        }

        public String getUrl()
        {
            return "https://api.appsflyer.com/install_data/v3/";
        }

        public InstallAttributionIdFetcher(Context context, String s, ScheduledExecutorService scheduledexecutorservice)
        {
            super(context, s, scheduledexecutorservice);
        }
    }


    private class CachedRequestSender
        implements Runnable
    {

        private WeakReference ctxReference;

        public void run()
        {
            if (!AppsFlyerLib.isDuringCheckCache) goto _L2; else goto _L1
_L1:
            return;
_L2:
            AppsFlyerLib.lastCacheCheck = System.currentTimeMillis();
            if (ctxReference == null) goto _L1; else goto _L3
_L3:
            AppsFlyerLib.isDuringCheckCache = true;
            String s = AppsFlyerLib.getProperty("AppsFlyerKey");
            Object obj = ctxReference;
            obj;
            JVM INSTR monitorenter ;
            Iterator iterator = CacheManager.getInstance().getCachedRequests((Context)ctxReference.get()).iterator();
_L6:
            if (!iterator.hasNext()) goto _L5; else goto _L4
_L4:
            RequestCacheData requestcachedata;
            requestcachedata = (RequestCacheData)iterator.next();
            if (AppsFlyerLib.shouldLog((Context)ctxReference.get()))
            {
                Log.i("AppsFlyer_1.17", (new StringBuilder("resending request: ")).append(requestcachedata.getRequestURL()).toString());
            }
            AppsFlyerLib.sendRequestToServer((new StringBuilder()).append(requestcachedata.getRequestURL()).append("&isCachedRequest=true").toString(), requestcachedata.getPostData(), s, ctxReference, requestcachedata.getCacheKey(), "AppsFlyer_1.17", false);
              goto _L6
            Exception exception2;
            exception2;
            Log.i("AppsFlyer_1.17", "Failed to resend cached request");
              goto _L6
            Exception exception1;
            exception1;
            obj;
            JVM INSTR monitorexit ;
            Exception exception;
            try
            {
                throw exception1;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
            finally
            {
                AppsFlyerLib.isDuringCheckCache = false;
            }
            Log.e("AppsFlyer_1.17", "failed to check cache.");
            AppsFlyerLib.isDuringCheckCache = false;
_L8:
            AppsFlyerLib.cacheScheduler.shutdown();
            AppsFlyerLib.cacheScheduler = null;
            return;
_L5:
            obj;
            JVM INSTR monitorexit ;
            AppsFlyerLib.isDuringCheckCache = false;
            if (true) goto _L8; else goto _L7
_L7:
            throw exception;
        }

        public CachedRequestSender(Context context)
        {
            ctxReference = null;
            ctxReference = new WeakReference(context);
        }
    }


    private class _cls1
        implements AppsFlyerConversionListener
    {

        final ConversionDataListener val$conversionDataListener;

        public final void onAppOpenAttribution(Map map)
        {
        }

        public final void onAttributionFailure(String s)
        {
        }

        public final void onInstallConversionDataLoaded(Map map)
        {
            conversionDataListener.onConversionDataLoaded(map);
        }

        public final void onInstallConversionFailure(String s)
        {
            conversionDataListener.onConversionFailure(s);
        }

        _cls1()
        {
            conversionDataListener = conversiondatalistener;
            super();
        }
    }


    private class DataCollector
        implements Runnable
    {

        private String appsFlyerKey;
        private Context context;
        private String eventName;
        private String eventValue;
        private ExecutorService executor;
        private boolean isNewAPI;
        private String referrer;

        public void run()
        {
            AppsFlyerLib.sendTrackingWithEvent(context, appsFlyerKey, eventName, eventValue, referrer, isNewAPI);
            executor.shutdown();
        }

        private DataCollector(Context context1, String s, String s1, String s2, String s3, boolean flag, ExecutorService executorservice)
        {
            context = context1;
            appsFlyerKey = s;
            eventName = s1;
            eventValue = s2;
            referrer = s3;
            isNewAPI = flag;
            executor = executorservice;
        }

        DataCollector(Context context1, String s, String s1, String s2, String s3, boolean flag, ExecutorService executorservice, 
                _cls1 _pcls1)
        {
            this(context1, s, s1, s2, s3, flag, executorservice);
        }
    }


    private class SendToServerRunnable
        implements Runnable
    {

        private WeakReference ctxReference;
        boolean isLaunch;
        Map params;
        private String urlString;

        public void run()
        {
            String s1 = AppsFlyerLib.getEventTag(params);
            Object obj = (Context)ctxReference.get();
            if (obj == null) goto _L2; else goto _L1
_L1:
            String s = AppsFlyerProperties.getInstance().getReferrer(((Context) (obj)));
            if (s == null)
            {
                break MISSING_BLOCK_LABEL_70;
            }
            if (s.length() > 0 && params.get("referrer") == null)
            {
                params.put("referrer", s);
            }
            Map map;
            boolean flag1;
            flag1 = "true".equals(((Context) (obj)).getSharedPreferences("appsflyer-data", 0).getString("sentSuccessfully", ""));
            s = (String)params.get("eventName");
            map = params;
            Object obj1;
            boolean flag;
            if (s == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            map.put("counter", Integer.toString(AppsFlyerLib.getCounter(((Context) (obj)), flag)));
            map = params;
            if (s != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            map.put("iaecounter", Integer.toString(AppsFlyerLib.getIAECounter(((Context) (obj)), flag)));
            flag = flag1;
_L5:
            obj = params;
            if (!flag)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            ((Map) (obj)).put("isFirstCall", Boolean.toString(flag));
            s = (String)params.get("appsflyerKey");
            if (s == null)
            {
                break MISSING_BLOCK_LABEL_225;
            }
            if (s.length() != 0)
            {
                break MISSING_BLOCK_LABEL_234;
            }
            Log.d(s1, "Not sending data yet, waiting for dev key");
            return;
            obj = (new HashUtils()).getHashCode(params);
            params.put("af_v", obj);
            obj = AppsFlyerLib.mapToString(params);
            try
            {
                AppsFlyerLib.sendRequestToServer(urlString, ((String) (obj)), s, ctxReference, null, s1, isLaunch);
                return;
            }
            catch (IOException ioexception)
            {
                s = ((String) (obj));
                obj1 = ioexception;
            }
_L3:
            if (s != null && ctxReference != null && !urlString.contains("&isCachedRequest=true"))
            {
                Log.e(s1, ((IOException) (obj1)).getMessage(), ((Throwable) (obj1)));
                CacheManager.getInstance().cacheRequest(new RequestCacheData(urlString, s, "1.17"), (Context)ctxReference.get());
                return;
            } else
            {
                return;
            }
            obj1;
            Log.e(s1, ((Throwable) (obj1)).getMessage(), ((Throwable) (obj1)));
            return;
            obj1;
            s = null;
              goto _L3
_L2:
            flag = false;
            if (true) goto _L5; else goto _L4
_L4:
        }

        private SendToServerRunnable(String s, Map map, Context context, boolean flag)
        {
            ctxReference = null;
            urlString = s;
            params = map;
            ctxReference = new WeakReference(context);
            isLaunch = flag;
        }

        SendToServerRunnable(String s, Map map, Context context, boolean flag, _cls1 _pcls1)
        {
            this(s, map, context, flag);
        }
    }


    private class ReAttributionIdFetcher extends AttributionIdFetcher
    {

        protected void callback(Map map)
        {
            AppsFlyerLib.conversionDataListener.onAppOpenAttribution(map);
        }

        protected void callbackFailure(String s)
        {
            AppsFlyerLib.conversionDataListener.onAttributionFailure(s);
        }

        public String getUrl()
        {
            return "https://sdk.appsflyer.com/reattr_data/";
        }

        public ReAttributionIdFetcher(Context context, String s, ScheduledExecutorService scheduledexecutorservice)
        {
            super(context, s, scheduledexecutorservice);
        }
    }

}
