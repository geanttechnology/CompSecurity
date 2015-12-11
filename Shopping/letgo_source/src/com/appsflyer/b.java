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
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.support.v7.je;
import android.support.v7.jf;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;
import com.newrelic.agent.android.instrumentation.HttpInstrumentation;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.appsflyer:
//            c, g, d, a, 
//            e, j, h, i, 
//            f

public class com.appsflyer.b extends BroadcastReceiver
{
    private static abstract class a
        implements Runnable
    {

        private static AtomicInteger d = new AtomicInteger(0);
        private WeakReference a;
        private String b;
        private ScheduledExecutorService c;

        public abstract String a();

        protected abstract void a(String s);

        protected abstract void a(Map map);

        public void run()
        {
            Object obj4 = null;
            if (b != null && b.length() != 0) goto _L2; else goto _L1
_L1:
            return;
_L2:
            d.incrementAndGet();
            Context context = (Context)a.get();
            if (context != null)
            {
                break MISSING_BLOCK_LABEL_64;
            }
            d.decrementAndGet();
            if (true) goto _L1; else goto _L3
_L3:
            throw new NullPointerException();
            Object obj1 = com.appsflyer.b.b(context, com.appsflyer.b.f(context));
            Object obj;
            obj = "";
            if (obj1 == null)
            {
                break MISSING_BLOCK_LABEL_102;
            }
            obj = (new StringBuilder()).append("-").append(((String) (obj1))).toString();
            Object obj2;
            obj1 = (new StringBuilder()).append(a()).append(context.getPackageName()).append(((String) (obj))).append("?devkey=").append(b).append("&device_id=").append(com.appsflyer.b.d(context));
            if (com.appsflyer.b.g(context))
            {
                com.appsflyer.j.b((new StringBuilder()).append("Calling server for attribution url: ").append(((StringBuilder) (obj1)).toString()).toString());
            }
            obj2 = (HttpURLConnection)HttpInstrumentation.openConnection((new URL(((StringBuilder) (obj1)).toString())).openConnection());
            obj = obj2;
            ((HttpURLConnection) (obj2)).setRequestMethod("GET");
            obj = obj2;
            ((HttpURLConnection) (obj2)).setConnectTimeout(10000);
            obj = obj2;
            ((HttpURLConnection) (obj2)).setRequestProperty("Connection", "close");
            obj = obj2;
            ((HttpURLConnection) (obj2)).connect();
            obj = obj2;
            if (((HttpURLConnection) (obj2)).getResponseCode() != 200) goto _L5; else goto _L4
_L4:
            obj = obj2;
            StringBuilder stringbuilder = new StringBuilder();
            Object obj3 = new InputStreamReader(((HttpURLConnection) (obj2)).getInputStream());
            obj1 = new BufferedReader(((java.io.Reader) (obj3)));
_L8:
            obj = ((BufferedReader) (obj1)).readLine();
            if (obj == null) goto _L7; else goto _L6
_L6:
            stringbuilder.append(((String) (obj))).append('\n');
              goto _L8
            obj;
            obj4 = obj1;
            obj1 = obj;
_L21:
            if (obj4 == null)
            {
                break MISSING_BLOCK_LABEL_329;
            }
            obj = obj2;
            ((BufferedReader) (obj4)).close();
            if (obj3 == null)
            {
                break MISSING_BLOCK_LABEL_341;
            }
            obj = obj2;
            ((InputStreamReader) (obj3)).close();
            obj = obj2;
            String s;
            int i1;
            try
            {
                throw obj1;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                obj1 = obj2;
            }
            finally { }
            obj2 = obj;
_L19:
            obj = obj1;
            if (com.appsflyer.b.b() == null)
            {
                break MISSING_BLOCK_LABEL_368;
            }
            obj = obj1;
            a(((Throwable) (obj2)).getMessage());
            obj = obj1;
            Log.e("AppsFlyer_1.18", ((Throwable) (obj2)).getMessage(), ((Throwable) (obj2)));
            d.decrementAndGet();
            if (obj1 != null)
            {
                ((HttpURLConnection) (obj1)).disconnect();
            }
_L13:
            c.shutdown();
            return;
_L7:
            if (obj1 == null)
            {
                break MISSING_BLOCK_LABEL_416;
            }
            obj = obj2;
            ((BufferedReader) (obj1)).close();
            if (obj3 == null)
            {
                break MISSING_BLOCK_LABEL_428;
            }
            obj = obj2;
            ((InputStreamReader) (obj3)).close();
            obj = obj2;
            if (!com.appsflyer.b.g(context))
            {
                break MISSING_BLOCK_LABEL_466;
            }
            obj = obj2;
            com.appsflyer.j.b((new StringBuilder()).append("Attribution data: ").append(stringbuilder.toString()).toString());
            obj = obj2;
            if (stringbuilder.length() <= 0 || context == null) goto _L10; else goto _L9
_L9:
            obj = obj2;
            obj1 = com.appsflyer.b.d(stringbuilder.toString());
            obj = obj2;
            s = (String)((Map) (obj1)).get("iscache");
            if (s == null)
            {
                break MISSING_BLOCK_LABEL_524;
            }
            obj = obj2;
            if (!"true".equals(s))
            {
                break MISSING_BLOCK_LABEL_611;
            }
            obj = obj2;
            obj3 = context.getSharedPreferences("appsflyer-data", 0).edit();
            obj = obj2;
            ((android.content.SharedPreferences.Editor) (obj3)).putString("attributionId", stringbuilder.toString());
            obj = obj2;
            ((android.content.SharedPreferences.Editor) (obj3)).commit();
            obj = obj2;
            if (!com.appsflyer.b.g(context))
            {
                break MISSING_BLOCK_LABEL_611;
            }
            obj = obj2;
            Log.d("AppsFlyer_1.18", (new StringBuilder()).append("iscache=").append(s).append(" caching conversion data").toString());
            obj = obj2;
            if (com.appsflyer.b.b() == null) goto _L10; else goto _L11
_L11:
            obj = obj2;
            i1 = d.intValue();
            if (i1 > 1) goto _L10; else goto _L12
_L12:
            obj = obj2;
            obj3 = com.appsflyer.b.b(context);
            obj1 = obj3;
_L14:
            obj = obj2;
            a(((Map) (obj1)));
_L10:
            d.decrementAndGet();
            if (obj2 != null)
            {
                ((HttpURLConnection) (obj2)).disconnect();
            }
              goto _L13
            obj;
              goto _L14
_L5:
            obj = obj2;
            if (com.appsflyer.b.b() == null)
            {
                break MISSING_BLOCK_LABEL_713;
            }
            obj = obj2;
            a((new StringBuilder()).append("Error connection to server: ").append(((HttpURLConnection) (obj2)).getResponseCode()).toString());
            obj = obj2;
            if (!com.appsflyer.b.g(context)) goto _L10; else goto _L15
_L15:
            obj = obj2;
            com.appsflyer.j.b((new StringBuilder()).append("AttributionIdFetcher response code: ").append(((HttpURLConnection) (obj2)).getResponseCode()).append("  url: ").append(obj1).toString());
              goto _L10
_L17:
            d.decrementAndGet();
            if (obj != null)
            {
                ((HttpURLConnection) (obj)).disconnect();
            }
            throw obj1;
            obj1;
            obj = null;
            if (true) goto _L17; else goto _L16
_L16:
            obj2;
            obj1 = null;
            if (true) goto _L19; else goto _L18
_L18:
            obj1;
            obj3 = null;
            continue; /* Loop/switch isn't completed */
            obj1;
            if (true) goto _L21; else goto _L20
_L20:
        }


        public a(Context context, String s, ScheduledExecutorService scheduledexecutorservice)
        {
            a = null;
            a = new WeakReference(context);
            b = s;
            c = scheduledexecutorservice;
        }
    }

    private static class b
        implements Runnable
    {

        private WeakReference a;

        public void run()
        {
            if (!com.appsflyer.b.c()) goto _L2; else goto _L1
_L1:
            return;
_L2:
            com.appsflyer.b.a(System.currentTimeMillis());
            if (a == null) goto _L1; else goto _L3
_L3:
            com.appsflyer.b.a(true);
            String s = com.appsflyer.b.a("AppsFlyerKey");
            Object obj = a;
            obj;
            JVM INSTR monitorenter ;
            Iterator iterator = je.a().b((Context)a.get()).iterator();
_L6:
            if (!iterator.hasNext()) goto _L5; else goto _L4
_L4:
            jf jf1;
            jf1 = (jf)iterator.next();
            if (com.appsflyer.b.g((Context)a.get()))
            {
                Log.i("AppsFlyer_1.18", (new StringBuilder()).append("resending request: ").append(jf1.c()).toString());
            }
            com.appsflyer.b.a((new StringBuilder()).append(jf1.c()).append("&isCachedRequest=true").toString(), jf1.b(), s, a, jf1.d(), "AppsFlyer_1.18", false);
              goto _L6
            Exception exception2;
            exception2;
            Log.i("AppsFlyer_1.18", "Failed to resend cached request");
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
                com.appsflyer.b.a(false);
            }
            Log.e("AppsFlyer_1.18", "failed to check cache.");
            com.appsflyer.b.a(false);
_L8:
            com.appsflyer.b.d().shutdown();
            com.appsflyer.b.a(null);
            return;
_L5:
            obj;
            JVM INSTR monitorexit ;
            com.appsflyer.b.a(false);
            if (true) goto _L8; else goto _L7
_L7:
            throw exception;
        }

        public b(Context context)
        {
            a = null;
            a = new WeakReference(context);
        }
    }

    private static class c
        implements Runnable
    {

        private Context a;
        private String b;
        private String c;
        private String d;
        private String e;
        private ExecutorService f;
        private boolean g;

        public void run()
        {
            com.appsflyer.b.a(a, b, c, d, e, g);
            f.shutdown();
        }

        private c(Context context, String s, String s1, String s2, String s3, boolean flag, ExecutorService executorservice)
        {
            a = context;
            b = s;
            c = s1;
            d = s2;
            e = s3;
            g = flag;
            f = executorservice;
        }

    }

    private static class d extends a
    {

        public String a()
        {
            return "https://api.appsflyer.com/install_data/v3/";
        }

        protected void a(String s)
        {
            com.appsflyer.b.b().a(s);
        }

        protected void a(Map map)
        {
            com.appsflyer.b.b().a(map);
        }

        public d(Context context, String s, ScheduledExecutorService scheduledexecutorservice)
        {
            super(context, s, scheduledexecutorservice);
        }
    }

    private static class e
        implements Runnable
    {

        Map a;
        boolean b;
        private String c;
        private WeakReference d;

        public void run()
        {
            String s1 = com.appsflyer.b.a(a);
            Object obj = (Context)d.get();
            if (obj == null) goto _L2; else goto _L1
_L1:
            String s = com.appsflyer.c.a().a(((Context) (obj)));
            if (s == null)
            {
                break MISSING_BLOCK_LABEL_70;
            }
            if (s.length() > 0 && a.get("referrer") == null)
            {
                a.put("referrer", s);
            }
            Map map;
            boolean flag1;
            flag1 = "true".equals(((Context) (obj)).getSharedPreferences("appsflyer-data", 0).getString("sentSuccessfully", ""));
            s = (String)a.get("eventName");
            map = a;
            Object obj1;
            boolean flag;
            if (s == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            map.put("counter", Integer.toString(com.appsflyer.b.a(((Context) (obj)), flag)));
            map = a;
            if (s != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            map.put("iaecounter", Integer.toString(com.appsflyer.b.b(((Context) (obj)), flag)));
            a.put("timepassedsincelastlaunch", Long.toString(com.appsflyer.b.e(((Context) (obj)))));
            flag = flag1;
_L5:
            obj = a;
            if (!flag)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            ((Map) (obj)).put("isFirstCall", Boolean.toString(flag));
            s = (String)a.get("appsflyerKey");
            if (s == null)
            {
                break MISSING_BLOCK_LABEL_244;
            }
            if (s.length() != 0)
            {
                break MISSING_BLOCK_LABEL_253;
            }
            Log.d(s1, "Not sending data yet, waiting for dev key");
            return;
            obj = (new h()).a(a);
            a.put("af_v", obj);
            obj = com.appsflyer.b.b(a);
            try
            {
                com.appsflyer.b.a(c, ((String) (obj)), s, d, null, s1, b);
                return;
            }
            catch (IOException ioexception)
            {
                s = ((String) (obj));
                obj1 = ioexception;
            }
_L3:
            if (s != null && d != null && !c.contains("&isCachedRequest=true"))
            {
                Log.e(s1, ((IOException) (obj1)).getMessage(), ((Throwable) (obj1)));
                je.a().a(new jf(c, s, "1.18"), (Context)d.get());
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

        private e(String s, Map map, Context context, boolean flag)
        {
            d = null;
            c = s;
            a = map;
            d = new WeakReference(context);
            b = flag;
        }

    }


    public static final Uri a = Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider");
    private static final List b = Arrays.asList(new String[] {
        "is_cache"
    });
    private static com.appsflyer.a c = null;
    private static boolean d = false;
    private static long e;
    private static ScheduledExecutorService f = null;
    private static long g = 0L;

    public com.appsflyer.b()
    {
    }

    static int a(Context context, boolean flag)
    {
        return c(context, flag);
    }

    static long a(long l1)
    {
        e = l1;
        return l1;
    }

    public static String a()
    {
        return a("AppUserId");
    }

    public static String a(ContentResolver contentresolver)
    {
        ContentResolver contentresolver1;
        Cursor cursor;
        contentresolver1 = null;
        cursor = contentresolver.query(a, new String[] {
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
        Log.w("AppsFlyer_1.18", "Could not collect cursor attribution", contentresolver);
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

    public static String a(String s)
    {
        return com.appsflyer.c.a().b(s);
    }

    private static String a(SimpleDateFormat simpledateformat, Context context)
    {
        SharedPreferences sharedpreferences = context.getSharedPreferences("appsflyer-data", 0);
        String s = sharedpreferences.getString("appsFlyerFirstInstall", null);
        Object obj = s;
        if (s == null)
        {
            if (i(context))
            {
                if (h(context))
                {
                    Log.d("AppsFlyer_1.18", "AppsFlyer: first launch detected");
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
        if (h(context))
        {
            Log.i("AppsFlyer_1.18", (new StringBuilder()).append("AppsFlyer: first launch date: ").append(((String) (obj))).toString());
        }
        return ((String) (obj));
    }

    static String a(Map map)
    {
        return c(map);
    }

    static ScheduledExecutorService a(ScheduledExecutorService scheduledexecutorservice)
    {
        f = scheduledexecutorservice;
        return scheduledexecutorservice;
    }

    public static void a(Activity activity)
    {
        if (com.appsflyer.c.a.size() == 0)
        {
            com.appsflyer.c.a.add(activity);
            g = (new Date()).getTime();
        } else
        {
            int i1 = 0;
            while (i1 < com.appsflyer.c.a.size()) 
            {
                if (!((Activity)com.appsflyer.c.a.get(i1)).equals(activity))
                {
                    com.appsflyer.c.a.add(activity);
                }
                i1++;
            }
        }
    }

    public static void a(Context context)
    {
        a(context, ((String) (null)));
        if (h(context))
        {
            Log.i("AppsFlyer_1.18", (new StringBuilder()).append("Start tracking package: ").append(context.getPackageName()).toString());
        }
    }

    public static void a(Context context, String s)
    {
        a(context, s, null, null);
    }

    public static void a(Context context, String s, String s1, String s2)
    {
        if (s1 != null && s2 != null && s2.matches("-?\\d+(\\.\\d+)?"))
        {
            Log.i("AppsFlyer_1.18", (new StringBuilder()).append("AppsFLyer: numeric value '").append(s2).append("' for event '").append(s1).append("' will be categorized as a revenue event.").toString());
        }
        String s4 = com.appsflyer.c.a().a(context);
        String s3 = s4;
        if (s4 == null)
        {
            s3 = "";
        }
        b(context, s, s1, s2, s3, false);
    }

    static void a(Context context, String s, String s1, String s2, String s3, boolean flag)
    {
        c(context, s, s1, s2, s3, flag);
    }

    public static void a(Context context, String s, Map map)
    {
        Object obj = map;
        if (map == null)
        {
            obj = new HashMap();
        }
        map = new JSONObject(((Map) (obj)));
        String s1 = com.appsflyer.c.a().a(context);
        if (!(map instanceof JSONObject))
        {
            map = map.toString();
        } else
        {
            map = JSONObjectInstrumentation.toString((JSONObject)map);
        }
        obj = s1;
        if (s1 == null)
        {
            obj = "";
        }
        b(context, null, s, map, ((String) (obj)), true);
    }

    private static void a(Context context, Map map)
    {
        if (!com.appsflyer.c.a().b("deviceTrackingDisabled", false)) goto _L2; else goto _L1
_L1:
        map.put("deviceTrackingDisabled", "true");
_L8:
        return;
_L2:
        String s;
        SharedPreferences sharedpreferences;
        boolean flag;
        sharedpreferences = context.getSharedPreferences("appsflyer-data", 0);
        flag = com.appsflyer.c.a().b("collectIMEI", true);
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
                Log.i("AppsFlyer_1.18", "WARNING:READ_PHONE_STATE is missing");
            }
        }
_L4:
        flag = com.appsflyer.c.a().b("collectAndroidId", true);
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
            break MISSING_BLOCK_LABEL_249;
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

    public static transient void a(c.a a1, String as[])
    {
        com.appsflyer.c.a().a("userEmails", as);
        com.appsflyer.c.a().a("userEmailsCryptType", a1.a());
    }

    private void a(String s, Context context)
    {
        Object obj;
        HttpURLConnection httpurlconnection;
        Object obj2;
        httpurlconnection = null;
        obj2 = null;
        obj = httpurlconnection;
        Object obj1 = (new StringBuilder()).append("https://track.appsflyer.com/api/v2.3/uninsall?buildnumber=1.18").toString();
        obj = httpurlconnection;
        if (!h(context))
        {
            break MISSING_BLOCK_LABEL_67;
        }
        obj = httpurlconnection;
        Log.i("AppsFlyer_1.18", (new StringBuilder()).append("Calling server for uninstall url: ").append(((String) (obj1))).toString());
        obj = httpurlconnection;
        Object obj3 = new HashMap();
        obj = httpurlconnection;
        ((Map) (obj3)).put("packageName", s);
        obj = httpurlconnection;
        b(context, ((Map) (obj3)));
        obj = httpurlconnection;
        a(context, ((Map) (obj3)));
        obj = httpurlconnection;
        obj3 = d(((Map) (obj3)));
        obj = httpurlconnection;
        httpurlconnection = (HttpURLConnection)HttpInstrumentation.openConnection((new URL(((String) (obj1)))).openConnection());
        httpurlconnection.setRequestMethod("POST");
        int i1 = ((String) (obj3)).getBytes().length;
        httpurlconnection.setRequestProperty("Content-Length", (new StringBuilder()).append(i1).append("").toString());
        httpurlconnection.setRequestProperty("Connection", "close");
        httpurlconnection.setConnectTimeout(10000);
        httpurlconnection.setDoOutput(true);
        obj1 = new OutputStreamWriter(httpurlconnection.getOutputStream());
        ((OutputStreamWriter) (obj1)).write(((String) (obj3)));
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_245;
        }
        ((OutputStreamWriter) (obj1)).close();
        if (httpurlconnection.getResponseCode() != 200) goto _L2; else goto _L1
_L1:
        if (h(context))
        {
            Log.i("AppsFlyer_1.18", (new StringBuilder()).append("Uninstall sent successfully: ").append(s).toString());
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
            break MISSING_BLOCK_LABEL_314;
        }
        ((OutputStreamWriter) (obj1)).close();
        throw obj;
        Throwable throwable;
        throwable;
_L9:
        obj = httpurlconnection;
        if (!h(context))
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = httpurlconnection;
        Log.i("AppsFlyer_1.18", (new StringBuilder()).append("Failed to send uninstall: ").append(s).append(" :").append(throwable.getLocalizedMessage()).toString());
        if (httpurlconnection == null) goto _L4; else goto _L3
_L3:
        httpurlconnection.disconnect();
        return;
_L2:
        if (!h(context)) goto _L6; else goto _L5
_L5:
        Log.i("AppsFlyer_1.18", (new StringBuilder()).append("Failed to send uninstall: ").append(s).toString());
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

    protected static void a(String s, String s1)
    {
        com.appsflyer.c.a().a(s, s1);
    }

    private static void a(String s, String s1, Context context)
    {
        if (context != null && "com.appsflyer".equals(context.getPackageName()))
        {
            com.appsflyer.g.a().a((new StringBuilder()).append(s).append(s1).toString());
        }
    }

    static void a(String s, String s1, String s2, WeakReference weakreference, String s3, String s4, boolean flag)
        throws IOException
    {
        b(s, s1, s2, weakreference, s3, s4, flag);
    }

    private static void a(URL url, String s, String s1, WeakReference weakreference, String s2, String s3, boolean flag)
        throws IOException
    {
        Context context = (Context)weakreference.get();
        HttpURLConnection httpurlconnection = (HttpURLConnection)HttpInstrumentation.openConnection(url.openConnection());
        httpurlconnection.setRequestMethod("POST");
        int i1 = s.getBytes().length;
        httpurlconnection.setRequestProperty("Content-Length", (new StringBuilder()).append(i1).append("").toString());
        httpurlconnection.setRequestProperty("Connection", "close");
        httpurlconnection.setConnectTimeout(10000);
        httpurlconnection.setDoOutput(true);
        OutputStreamWriter outputstreamwriter = new OutputStreamWriter(httpurlconnection.getOutputStream());
        outputstreamwriter.write(s);
        if (outputstreamwriter == null)
        {
            break MISSING_BLOCK_LABEL_119;
        }
        outputstreamwriter.close();
        int j1;
        j1 = httpurlconnection.getResponseCode();
        if (h(context))
        {
            Log.i(s3, (new StringBuilder()).append("response code: ").append(j1).toString());
        }
        b(context, s3, "SERVER_RESPONSE_CODE", Integer.toString(j1));
        a("response from server. status=", Integer.toString(j1), context);
        url = context.getSharedPreferences("appsflyer-data", 0);
        if (j1 != 200)
        {
            break MISSING_BLOCK_LABEL_265;
        }
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_221;
        }
        je.a().a(s2, context);
        if (weakreference.get() == null || s2 != null)
        {
            break MISSING_BLOCK_LABEL_265;
        }
        s = url.edit();
        s.putString("sentSuccessfully", "true");
        s.commit();
        m(context);
        if (url.getString("attributionId", null) != null || s1 == null || !flag) goto _L2; else goto _L1
_L1:
        url = Executors.newSingleThreadScheduledExecutor();
        url.schedule(new d(context.getApplicationContext(), s1, url), 10L, TimeUnit.MILLISECONDS);
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
            break MISSING_BLOCK_LABEL_340;
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
        if (c == null || url.getString("attributionId", null) == null) goto _L5; else goto _L7
_L7:
        k1 = c(context, false);
        if (k1 <= 1) goto _L5; else goto _L8
_L8:
        url = b(context);
        if (url != null)
        {
            try
            {
                c.a(url);
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

    static boolean a(boolean flag)
    {
        d = flag;
        return flag;
    }

    static int b(Context context, boolean flag)
    {
        return d(context, flag);
    }

    static com.appsflyer.a b()
    {
        return c;
    }

    static String b(Context context, String s)
        throws android.content.pm.PackageManager.NameNotFoundException
    {
        return c(context, s);
    }

    static String b(Map map)
        throws UnsupportedEncodingException
    {
        return d(map);
    }

    public static Map b(Context context)
        throws com.appsflyer.d
    {
        SharedPreferences sharedpreferences = context.getSharedPreferences("appsflyer-data", 0);
        String s = com.appsflyer.c.a().a(context);
        if (s != null && s.length() > 0 && s.contains("af_tranid"))
        {
            return b(s, context);
        }
        context = sharedpreferences.getString("attributionId", null);
        if (context != null && context.length() > 0)
        {
            return e(context);
        } else
        {
            throw new com.appsflyer.d();
        }
    }

    private static Map b(String s, Context context)
    {
        HashMap hashmap;
        int i1;
        hashmap = new HashMap();
        i1 = s.indexOf('&');
        if (i1 < 0 || s.length() <= i1 + 1) goto _L2; else goto _L1
_L1:
        boolean flag1;
        String as[] = s.split("\\&");
        int k1 = as.length;
        int j1 = 0;
        boolean flag = false;
        while (j1 < k1) 
        {
            s = as[j1].split("=");
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
            j1++;
        }
        try
        {
            if (!hashmap.containsKey("install_time"))
            {
                long l1 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).firstInstallTime;
                hashmap.put("install_time", (new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")).format(new Date(l1)));
            }
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.w("AppsFlyer_1.18", "Could not fetch install time");
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

    public static void b(Activity activity)
    {
        if (com.appsflyer.c.a.size() <= 0) goto _L2; else goto _L1
_L1:
        int i1 = 0;
_L8:
        if (i1 >= com.appsflyer.c.a.size()) goto _L4; else goto _L3
_L3:
        if (!((Activity)com.appsflyer.c.a.get(i1)).equals(activity)) goto _L6; else goto _L5
_L5:
        com.appsflyer.c.a.remove(activity);
_L4:
        String as[];
        if (com.appsflyer.c.a.size() == 0)
        {
            Log.i("AppsFlyer_1.18", "app goes to background");
            long l1 = (new Date()).getTime();
            long l2 = g;
            HashMap hashmap = new HashMap();
            String s = a("AppsFlyerKey");
            hashmap.put("app_id", activity.getApplicationContext().getPackageName());
            hashmap.put("devkey", s);
            hashmap.put("uid", d(activity.getApplicationContext()));
            hashmap.put("time_in_app", String.valueOf((l1 - l2) / 1000L));
            hashmap.put("statType", "user_closed_app");
            hashmap.put("platform", "Android");
            hashmap.put("launch_counter", Integer.toString(c(activity.getApplicationContext(), false)));
            activity = new com.appsflyer.e(activity.getApplicationContext());
            activity.c = hashmap;
            as = new String[1];
            as[0] = "https://stats.appsflyer.com/stats";
            if (activity instanceof AsyncTask)
            {
                break; /* Loop/switch isn't completed */
            }
            activity.execute(as);
        }
_L2:
        return;
_L6:
        i1++;
        if (true) goto _L8; else goto _L7
_L7:
        AsyncTaskInstrumentation.execute((AsyncTask)activity, as);
        return;
    }

    private static void b(Context context, String s, String s1, String s2)
    {
        if (com.appsflyer.c.a().b("shouldMonitor", false))
        {
            Intent intent = new Intent("com.appsflyer.MonitorBroadcast");
            intent.setPackage("com.appsflyer.nightvision");
            intent.putExtra("message", s1);
            intent.putExtra("value", s2);
            intent.putExtra("packageName", "true");
            intent.putExtra("pid", new Integer(Process.myPid()));
            intent.putExtra("eventIdentifier", s);
            intent.putExtra("sdk", "2.3.1.18");
            context.sendBroadcast(intent);
        }
    }

    private static void b(Context context, String s, String s1, String s2, String s3, boolean flag)
    {
        ScheduledExecutorService scheduledexecutorservice = Executors.newSingleThreadScheduledExecutor();
        scheduledexecutorservice.schedule(new c(context, s, s1, s2, s3, flag, scheduledexecutorservice), 5L, TimeUnit.MILLISECONDS);
    }

    private static void b(Context context, Map map)
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
        com.appsflyer.c.a().a("advertiserId", s);
        com.appsflyer.c.a().a("advertiserIdEnabled", ((String) (obj)));
_L1:
        return;
        map;
        if (h(context))
        {
            Log.i("AppsFlyer_1.18", "WARNING:Google Play services SDK jar is missing.");
            return;
        }
          goto _L1
        Exception exception;
        exception;
        String s1 = com.appsflyer.c.a().b("advertiserId");
        if (s1 != null)
        {
            map.put("advertiserId", s1);
        }
        s1 = com.appsflyer.c.a().b("advertiserIdEnabled");
        if (s1 != null)
        {
            map.put("advertiserIdEnabled", s1);
        }
        if (exception.getLocalizedMessage() != null)
        {
            Log.i("AppsFlyer_1.18", exception.getLocalizedMessage());
        } else
        {
            Log.i("AppsFlyer_1.18", exception.toString());
        }
        a("Could not fetch advertiser id: ", exception.getLocalizedMessage(), context);
        return;
    }

    public static void b(String s)
    {
        a("AppUserId", s);
    }

    private static void b(String s, String s1, String s2, WeakReference weakreference, String s3, String s4, boolean flag)
        throws IOException
    {
        URL url = new URL(s);
        if (h((Context)weakreference.get()))
        {
            Log.i(s4, (new StringBuilder()).append("url: ").append(url.toString()).toString());
        }
        a("call server.", (new StringBuilder()).append("\n").append(url.toString()).append("\nPOST:").append(s1).toString(), (Context)weakreference.get());
        if (h((Context)weakreference.get()))
        {
            com.appsflyer.j.b((new StringBuilder()).append("data: ").append(s1).toString());
        }
        b((Context)weakreference.get(), s4, "EVENT_DATA", s1);
        if (flag)
        {
            com.appsflyer.c.a().d();
        }
        try
        {
            a(url, s1, s2, weakreference, s3, s4, flag);
            return;
        }
        catch (IOException ioexception)
        {
            if (com.appsflyer.c.a().b("useHttpFallback", false))
            {
                a((new StringBuilder()).append("https failed: ").append(ioexception.getLocalizedMessage()).toString(), "", (Context)weakreference.get());
                a(new URL(s.replace("https:", "http:")), s1, s2, weakreference, s3, s4, flag);
                return;
            } else
            {
                Log.i(s4, (new StringBuilder()).append("failed to send requeset to server. ").append(ioexception.getLocalizedMessage()).toString());
                b((Context)weakreference.get(), s4, "ERROR", ioexception.getLocalizedMessage());
                return;
            }
        }
    }

    private static int c(Context context, boolean flag)
    {
        context = context.getSharedPreferences("appsflyer-data", 0);
        int j1 = context.getInt("appsFlyerCount", 0);
        int i1 = j1;
        if (flag)
        {
            i1 = j1 + 1;
            context = context.edit();
            context.putInt("appsFlyerCount", i1);
            context.commit();
        }
        return i1;
    }

    private static String c(Context context, String s)
        throws android.content.pm.PackageManager.NameNotFoundException
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

    private static String c(Map map)
    {
        map = (String)map.get("af_timestamp");
        if (map == null || map.length() < 5)
        {
            return "AppsFlyer_1.18";
        } else
        {
            return (new StringBuilder()).append("AppsFlyer_1.18-").append(map.substring(4)).toString();
        }
    }

    private static void c(Context context, String s, String s1, String s2, String s3, boolean flag)
    {
        Object obj;
        String s4;
        HashMap hashmap;
        StringBuilder stringbuilder;
        Object obj1;
        int i1;
        int j1;
        int k1;
        long l1;
        long l2;
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
        s4 = c(((Map) (hashmap)));
        if (!h(context)) goto _L2; else goto _L1
_L1:
        a("collect data for server", "", context);
        stringbuilder = (new StringBuilder()).append("******* sendTrackingWithEvent: ");
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
        a("********* sendTrackingWithEvent: ", ((String) (obj)), context);
          goto _L2
_L29:
        b(context, s4, "EVENT_CREATED_WITH_NAME", ((String) (obj)));
        je.a().a(context);
        try
        {
            obj = Arrays.asList(context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions);
            if (!((List) (obj)).contains("android.permission.INTERNET"))
            {
                Log.w("AppsFlyer_1.18", "Permission android.permission.INTERNET is missing in the AndroidManifest.xml");
                b(context, null, "PERMISSION_INTERNET_MISSING", null);
            }
            if (!((List) (obj)).contains("android.permission.ACCESS_NETWORK_STATE"))
            {
                Log.w("AppsFlyer_1.18", "Permission android.permission.ACCESS_NETWORK_STATE is missing in the AndroidManifest.xml");
            }
            if (!((List) (obj)).contains("android.permission.ACCESS_WIFI_STATE"))
            {
                Log.w("AppsFlyer_1.18", "Permission android.permission.ACCESS_WIFI_STATE is missing in the AndroidManifest.xml");
            }
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        stringbuilder = new StringBuilder();
        if (flag)
        {
            obj = "https://events.appsflyer.com/api/v2.3/androidevent?buildnumber=1.18&app_id=";
        } else
        {
            obj = "https://t.appsflyer.com/api/v2.3/androidevent?buildnumber=1.18&app_id=";
        }
        stringbuilder.append(((String) (obj))).append(context.getPackageName());
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_294;
        }
        hashmap.put("af_events_api", "1");
        hashmap.put("brand", Build.BRAND);
        hashmap.put("device", Build.DEVICE);
        hashmap.put("product", Build.PRODUCT);
        hashmap.put("sdk", Integer.toString(android.os.Build.VERSION.SDK_INT));
        hashmap.put("model", Build.MODEL);
        hashmap.put("deviceType", Build.TYPE);
        obj = a("additionalCustomData");
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_407;
        }
        hashmap.put("customData", obj);
        obj = context.getPackageManager().getInstallerPackageName(context.getPackageName());
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_438;
        }
        try
        {
            hashmap.put("installer_package", obj);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        obj = com.appsflyer.c.a().b("sdkExtension");
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_475;
        }
        if (((String) (obj)).length() > 0)
        {
            hashmap.put("sdkExtension", obj);
        }
        obj = n(context);
        obj1 = c(context, ((String) (obj)));
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_507;
        }
        hashmap.put("channel", obj1);
        if (obj1 == null) goto _L4; else goto _L3
_L3:
        if (!((String) (obj1)).equals(obj)) goto _L5; else goto _L4
_L5:
        hashmap.put("af_latestchannel", obj);
_L30:
        obj = j(context);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_565;
        }
        hashmap.put("af_installstore", ((String) (obj)).toLowerCase());
        obj = l(context);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_592;
        }
        hashmap.put("af_preinstall_name", ((String) (obj)).toLowerCase());
        obj = k(context);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_619;
        }
        hashmap.put("af_currentstore", ((String) (obj)).toLowerCase());
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_633;
        }
        obj = s;
        if (s.length() != 0)
        {
            break MISSING_BLOCK_LABEL_641;
        }
        obj = a("AppsFlyerKey");
        if (obj == null) goto _L7; else goto _L6
_L6:
        if (((String) (obj)).length() <= 0) goto _L7; else goto _L8
_L8:
        hashmap.put("appsflyerKey", obj);
        if (((String) (obj)).length() > 8)
        {
            hashmap.put("dkh", ((String) (obj)).substring(0, 8));
        }
        s = a();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_716;
        }
        hashmap.put("appUserId", s);
        obj = com.appsflyer.c.a().a("userEmails");
        if (obj == null) goto _L10; else goto _L9
_L9:
        obj1 = new StringBuilder();
        j1 = com.appsflyer.c.a().b("userEmailsCryptType", 1);
        s = new String();
        k1 = obj.length;
        i1 = 0;
_L34:
        if (i1 >= k1) goto _L12; else goto _L11
_L11:
        s = obj[i1];
        if (((StringBuilder) (obj1)).length() > 1)
        {
            ((StringBuilder) (obj1)).append(',');
        }
          goto _L13
_L31:
        ((StringBuilder) (obj1)).append(com.appsflyer.h.a(s));
        s = "sha1_el_arr";
          goto _L14
_L33:
        ((StringBuilder) (obj1)).append(com.appsflyer.h.b(s));
        s = "md5_el_arr";
          goto _L14
_L32:
        ((StringBuilder) (obj1)).append(s);
        s = "plain_el_arr";
          goto _L14
_L12:
        hashmap.put(s, ((StringBuilder) (obj1)).toString());
_L24:
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_925;
        }
        hashmap.put("eventName", s1);
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_925;
        }
        hashmap.put("eventValue", s2);
        if (a("appid") != null)
        {
            hashmap.put("appid", a("appid"));
        }
        s = a("currencyCode");
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_1014;
        }
        if (s.length() != 3)
        {
            Log.w("AppsFlyer_1.18", (new StringBuilder()).append("WARNING:currency code should be 3 characters!!! '").append(s).append("' is not a legal value.").toString());
        }
        hashmap.put("currency", s);
        s = a("IS_UPDATE");
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_1037;
        }
        hashmap.put("isUpdate", s);
        hashmap.put("af_preinstalled", Boolean.toString(c(context)));
        s = a(context.getContentResolver());
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_1079;
        }
        hashmap.put("fb", s);
        a(context, hashmap);
        s = com.appsflyer.i.a(context);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_1106;
        }
        hashmap.put("uid", s);
_L25:
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
        hashmap.put("network", p(context));
_L26:
        b(context, hashmap);
        c(context, ((Map) (hashmap)));
        s = new SimpleDateFormat("yyyy-MM-dd_hhmmZ");
        i1 = android.os.Build.VERSION.SDK_INT;
        if (i1 < 9)
        {
            break MISSING_BLOCK_LABEL_1285;
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
            l1 = ((PackageInfo) (s1)).firstInstallTime;
            l2 = ((PackageInfo) (s1)).lastUpdateTime;
            hashmap.put("date1", s.format(new Date(l1)));
            hashmap.put("date2", s.format(new Date(l2)));
            hashmap.put("firstLaunchDate", a(s, context));
        }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        if (s3.length() > 0)
        {
            hashmap.put("referrer", s3);
        }
        s2 = context.getSharedPreferences("appsflyer-data", 0);
        s = s2.getString("attributionId", null);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_1470;
        }
        if (s.length() > 0)
        {
            hashmap.put("installAttribution", s);
        }
        if (!flag1) goto _L16; else goto _L15
_L15:
        if (!(context instanceof Activity)) goto _L16; else goto _L17
_L17:
        s = ((Activity)context).getIntent();
        if (s.getAction() != "android.intent.action.VIEW") goto _L16; else goto _L18
_L18:
        s1 = s.getData();
        hashmap.put("af_deeplink", s1.toString());
        if (s1.getQueryParameter("af_deeplink") == null) goto _L20; else goto _L19
_L19:
        s = b(s1.getQuery().toString(), context);
        if (s1.getPath() != null)
        {
            s.put("path", s1.getPath());
        }
        if (s1.getScheme() != null)
        {
            s.put("scheme", s1.getScheme());
        }
_L27:
        s1 = new JSONObject(s);
        if (s1 instanceof JSONObject) goto _L22; else goto _L21
_L21:
        s1 = s1.toString();
_L28:
        s2 = s2.edit();
        s2.putString("deeplinkAttribution", s1);
        s2.commit();
        if (c != null)
        {
            c.b(s);
        }
_L16:
        System.out.println("AppsFlyerLib.sendTrackingWithEvent");
        (new e(stringbuilder.toString(), hashmap, context.getApplicationContext(), flag1)).run();
        return;
_L7:
        try
        {
            Log.e(s4, "AppsFlyer dev key is missing!!! Please use  AppsFlyerLib.setAppsFlyerKey(...) to set it. ");
            b(context, s4, "DEV_KEY_MISSING", null);
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
        s = a("userEmail");
        if (s == null) goto _L24; else goto _L23
_L23:
        hashmap.put("sha1_el", com.appsflyer.h.a(s));
          goto _L24
        s;
        Log.i("AppsFlyer_1.18", (new StringBuilder()).append("ERROR:").append("ERROR:").append("could not get uid ").append(s.getMessage()).toString());
          goto _L25
        s;
        Log.i("AppsFlyer_1.18", (new StringBuilder()).append("checking network error ").append(s.getMessage()).toString());
          goto _L26
_L20:
        s = new HashMap();
        s.put("link", s1.toString());
          goto _L27
_L22:
        s1 = JSONObjectInstrumentation.toString((JSONObject)s1);
          goto _L28
_L2:
        if (flag1)
        {
            obj = "Launch";
        } else
        {
            obj = s1;
        }
          goto _L29
_L4:
        if (obj1 != null || obj == null) goto _L30; else goto _L5
_L13:
        j1;
        JVM INSTR tableswitch 0 2: default 1932
    //                   0 865
    //                   1 802
    //                   2 848;
           goto _L31 _L32 _L31 _L33
_L14:
        i1++;
          goto _L34
    }

    private static void c(Context context, Map map)
    {
        try
        {
            context = Class.forName("com.unity3d.player.UnityPlayer");
            Log.i("AppsFlyer_1.18", (new StringBuilder()).append("WARNING:checkPlatform Built using Unity 1.").append(context.toString()).toString());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.i("AppsFlyer_1.18", "WARNING:checkPlatform Not Built using Unity 22.");
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
    }

    public static void c(String s)
    {
        a("AppsFlyerKey", s);
        com.appsflyer.j.a(s);
    }

    static boolean c()
    {
        return d;
    }

    public static boolean c(Context context)
    {
        boolean flag = false;
        int i1;
        try
        {
            i1 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).flags;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.e("AppsFlyer_1.18", "Could not check if app is pre installed", context);
            return false;
        }
        if ((i1 & 1) != 0)
        {
            flag = true;
        }
        return flag;
    }

    private static int d(Context context, boolean flag)
    {
        context = context.getSharedPreferences("appsflyer-data", 0);
        int j1 = context.getInt("appsFlyerCount", 0);
        int i1 = j1;
        if (flag)
        {
            i1 = j1 + 1;
            context = context.edit();
            context.putInt("appsFlyerCount", i1);
            context.commit();
        }
        return i1;
    }

    public static String d(Context context)
    {
        return com.appsflyer.i.a(context);
    }

    private static String d(Map map)
        throws UnsupportedEncodingException
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

    static Map d(String s)
    {
        return e(s);
    }

    static ScheduledExecutorService d()
    {
        return f;
    }

    static long e(Context context)
    {
        return o(context);
    }

    private static Map e(String s)
    {
        HashMap hashmap = new HashMap();
        try
        {
            s = JSONObjectInstrumentation.init(s);
            Iterator iterator = s.keys();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                String s1 = (String)iterator.next();
                if (!b.contains(s1))
                {
                    hashmap.put(s1, s.getString(s1));
                }
            } while (true);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.w("AppsFlyer_1.18", s);
            return null;
        }
        return hashmap;
    }

    static String f(Context context)
    {
        return n(context);
    }

    static boolean g(Context context)
    {
        return h(context);
    }

    private static boolean h(Context context)
    {
        return !com.appsflyer.c.a().e();
    }

    private static boolean i(Context context)
    {
        boolean flag = false;
        if (!context.getSharedPreferences("appsflyer-data", 0).contains("appsFlyerCount"))
        {
            flag = true;
        }
        return flag;
    }

    private static String j(Context context)
    {
        String s = null;
        Object obj = context.getSharedPreferences("appsflyer-data", 0);
        if (((SharedPreferences) (obj)).contains("INSTALL_STORE"))
        {
            return ((SharedPreferences) (obj)).getString("INSTALL_STORE", null);
        }
        boolean flag = i(context);
        obj = ((SharedPreferences) (obj)).edit();
        if (flag)
        {
            s = k(context);
        }
        ((android.content.SharedPreferences.Editor) (obj)).putString("INSTALL_STORE", s);
        ((android.content.SharedPreferences.Editor) (obj)).commit();
        return s;
    }

    private static String k(Context context)
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
        if (h(context))
        {
            Log.i("AppsFlyer_1.18", "Could not find AF_STORE value in the manifest", exception);
        }
        return null;
    }

    private static String l(Context context)
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
        flag = i(context);
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
        if (h(context))
        {
            Log.i("AppsFlyer_1.18", "Could not find AF_PRE_INSTALL_NAME value in the manifest", exception);
            obj = obj1;
        }
        if (true) goto _L2; else goto _L4
_L4:
        context = null;
        if (true) goto _L9; else goto _L8
_L8:
    }

    private static void m(Context context)
    {
        while (d || System.currentTimeMillis() - e < 15000L || f != null) 
        {
            return;
        }
        f = Executors.newSingleThreadScheduledExecutor();
        f.schedule(new b(context), 1L, TimeUnit.SECONDS);
    }

    private static String n(Context context)
    {
        String s;
        Object obj;
        s = com.appsflyer.c.a().b("channel");
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
            Log.i("AppsFlyer_1.18", "Could not load CHANNEL value", context);
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

    private static long o(Context context)
    {
        context = context.getSharedPreferences("appsflyer-data", 0);
        long l1 = context.getLong("AppsFlyerTimePassedSincePrevLaunch", 0L);
        context = context.edit();
        if (l1 > 0L)
        {
            l1 = (new Date()).getTime() - l1;
        } else
        {
            l1 = -1L;
        }
        context.putLong("AppsFlyerTimePassedSincePrevLaunch", (new Date()).getTime());
        context.commit();
        return l1 / 1000L;
    }

    private static String p(Context context)
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

    public void onReceive(Context context, Intent intent)
    {
        if ("android.intent.action.PACKAGE_REMOVED".equals(intent.getAction()))
        {
            a(intent.getDataString(), context);
        } else
        {
            String s = intent.getStringExtra("shouldMonitor");
            if (s != null)
            {
                Log.i("AppsFlyer_1.18", "Turning on monitoring.");
                com.appsflyer.c.a().a("shouldMonitor", s.equals("true"));
                b(context, null, "START_TRACKING", context.getPackageName());
                return;
            }
            Log.i("AppsFlyer_1.18", "****** onReceive called *******");
            a("******* onReceive: ", "", context);
            com.appsflyer.c.a().b();
            intent = intent.getStringExtra("referrer");
            if (h(context))
            {
                Log.i("AppsFlyer_1.18", (new StringBuilder()).append("Play store referrer: ").append(intent).toString());
            }
            if (intent != null)
            {
                a("BroadcastReceiver got referrer: ", intent, context);
                a("onRecieve called. refferer=", intent, context);
                android.content.SharedPreferences.Editor editor = context.getSharedPreferences("appsflyer-data", 0).edit();
                editor.putString("referrer", intent);
                editor.commit();
                com.appsflyer.c.a().c(intent);
                if (com.appsflyer.c.a().c())
                {
                    Log.i("AppsFlyer_1.18", "onReceive: isLaunchCalled");
                    b(context, null, null, null, intent, false);
                    return;
                }
            }
        }
    }


    // Unreferenced inner class com/appsflyer/b$1

/* anonymous class */
    static final class _cls1
        implements com.appsflyer.a
    {

        final f a;

        public void a(String s)
        {
            a.a(s);
        }

        public void a(Map map)
        {
            a.a(map);
        }

        public void b(Map map)
        {
        }
    }

}
