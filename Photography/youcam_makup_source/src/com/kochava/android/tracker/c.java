// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.kochava.android.tracker;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Application;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.kochava.android.a.b;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Timer;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicHeader;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.kochava.android.tracker:
//            a, g, e, f, 
//            d, ReferralCapture, h

public class c
{

    private static String C;
    private static int D = 60;
    private static boolean F = false;
    private static boolean G = false;
    private static long H = 0L;
    private static long I = 0L;
    private static String J;
    private static String K = "";
    private static Map L;
    private static a M;
    private static boolean R = false;
    private static boolean S = true;
    private static boolean T = false;
    private static boolean U = false;
    private static SharedPreferences X;
    private static SharedPreferences Y;
    private static final ExecutorService Z = Executors.newFixedThreadPool(1);
    protected static String a = "";
    private static Handler aa;
    private static final ScheduledExecutorService ab = Executors.newSingleThreadScheduledExecutor();
    private static final Uri ac = Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider");
    private static HashMap ad = new Feature._cls1();
    private static ArrayList ae = new ArrayList();
    private static Runnable af = new _cls3();
    protected static boolean b = false;
    protected static Context c;
    private static Map g;
    private static JSONObject h;
    private static String i = "";
    private static String j = "";
    private static int k = 60000;
    private static String u;
    private static String v;
    private static String x;
    private static String y;
    private int A;
    private int B;
    private boolean E;
    private boolean N;
    private Timer O;
    private Timer P;
    private Timer Q;
    private JSONObject V;
    private JSONObject W;
    private Handler ag;
    protected JSONObject d;
    protected JSONObject e;
    protected JSONObject f;
    private Context l;
    private String m;
    private String n;
    private String o;
    private String p;
    private String q;
    private String r;
    private String s;
    private String t;
    private String w;
    private String z;

    public c(Context context, HashMap hashmap)
    {
        E = false;
        N = true;
        ag = null;
        a(context, true, hashmap);
    }

    private static boolean A()
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (Y != null)
        {
            flag = flag1;
            if (!Y.getAll().isEmpty())
            {
                flag = true;
            }
        }
        return flag;
    }

    private String B()
    {
        if (r != null)
        {
            return r;
        } else
        {
            return "Unknown";
        }
    }

    private String C()
    {
        return (new StringBuilder()).append(o).append(" ").append(p).toString();
    }

    private String D()
    {
        return v;
    }

    private static String E()
    {
        if (X.contains("kochava_app_id_generated") && !X.getString("kochava_app_id_generated", "").equals(""))
        {
            return X.getString("kochava_app_id_generated", "");
        } else
        {
            String s1 = UUID.randomUUID().toString().replaceAll("-", "");
            s1 = (new StringBuilder()).append("KA").append(s1).toString();
            X.edit().putString("kochava_app_id_generated", s1).commit();
            return s1;
        }
    }

    private String F()
    {
        if (J == null || "".equals(J)) goto _L2; else goto _L1
_L1:
        byte abyte0[];
        StringBuffer stringbuffer;
        int i1;
        MessageDigest messagedigest = MessageDigest.getInstance("SHA-1");
        byte abyte1[] = new byte[40];
        messagedigest.update(J.getBytes("iso-8859-1"), 0, J.length());
        abyte0 = messagedigest.digest();
        stringbuffer = new StringBuffer();
        i1 = 0;
_L4:
        int j1;
        int k1;
        if (i1 >= abyte0.length)
        {
            break; /* Loop/switch isn't completed */
        }
        k1 = abyte0[i1] >>> 4 & 0xf;
        j1 = 0;
_L5:
        if (k1 >= 0 && k1 <= 9)
        {
            stringbuffer.append((char)(k1 + 48));
        } else
        {
            stringbuffer.append((char)((k1 - 10) + 97));
        }
        k1 = abyte0[i1];
        if (j1 < 1)
        {
            break MISSING_BLOCK_LABEL_149;
        }
        i1++;
        if (true) goto _L4; else goto _L3
_L3:
        return stringbuffer.toString();
_L2:
        return "";
        j1++;
        k1 &= 0xf;
          goto _L5
    }

    private void G()
    {
        if (ag == null)
        {
            ag = new _cls6(Looper.getMainLooper());
        }
    }

    private void H()
    {
        if (ag == null)
        {
            ag = new _cls7();
        }
    }

    private void I()
    {
        y = K();
        m = x();
        n = y();
        o = "Default";
        p = "N/A";
        q = "";
        PackageManager packagemanager = l.getApplicationContext().getPackageManager();
        Object obj = packagemanager.getApplicationInfo(l.getPackageName(), 0);
_L3:
        if (obj == null) goto _L2; else goto _L1
_L1:
        obj = packagemanager.getApplicationLabel(((android.content.pm.ApplicationInfo) (obj)));
_L4:
        o = (String)(String)obj;
        com.kochava.android.a.b.a((new StringBuilder()).append("mAppName now: ").append(o).toString());
_L5:
        try
        {
            p = (new StringBuilder()).append(l.getPackageManager().getPackageInfo(l.getPackageName(), 0).versionCode).append("").toString();
            com.kochava.android.a.b.a((new StringBuilder()).append("mAppVersionCode now: ").append(p).toString());
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            com.kochava.android.a.b.b((new StringBuilder()).append("Error gathering app version code ").append(((Exception) (obj)).toString()).toString());
        }
        try
        {
            q = l.getPackageManager().getPackageInfo(l.getPackageName(), 0).versionName;
            com.kochava.android.a.b.a((new StringBuilder()).append("mAppVersionName now: ").append(q).toString());
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            com.kochava.android.a.b.b((new StringBuilder()).append("Error gathering app version name ").append(((Exception) (obj)).toString()).toString());
        }
        try
        {
            obj = (WindowManager)l.getSystemService("window");
            A = ((WindowManager) (obj)).getDefaultDisplay().getHeight();
            B = ((WindowManager) (obj)).getDefaultDisplay().getWidth();
            com.kochava.android.a.b.a((new StringBuilder()).append("Height: ").append(A).append(" | Width: ").append(B).toString());
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            com.kochava.android.a.b.b((new StringBuilder()).append("Error ").append(((Exception) (obj)).toString()).toString());
        }
        w = android.provider.Settings.Secure.getString(l.getContentResolver(), "android_id");
        s = E();
        X = l.getSharedPreferences("initPrefs", 0);
        if (X.getString("initBool", "").equals(""))
        {
            X.edit().putString("initBool", "false").commit();
        }
        if (X.getString("kochavaappdata", null) != null)
        {
            obj = M.a(X.getString("kochavaappdata", null));
            String s1 = u();
            com.kochava.android.a.b.a((new StringBuilder()).append("Stored Data: ").append(((String) (obj))).toString());
            com.kochava.android.a.b.a((new StringBuilder()).append("Created Data: ").append(s1).toString());
            if (obj == null)
            {
                M.b(X.getString("kochavaappdata", null), s1);
            } else
            if (!((String) (obj)).equals(s1))
            {
                M.a(X.getString("kochavaappdata", null), s1);
            } else
            {
                com.kochava.android.a.b.a("Set start of life to false");
                N = false;
            }
        } else
        {
            N = false;
        }
        if (N || !X.getString("initBool", "").equals("") && X.getString("initBool", "").equals("false"))
        {
            com.kochava.android.a.b.a("Initial event has not yet been qued in the database, making initial call");
            a("initial", ((Map) (null)));
        }
        O = new Timer();
        O.schedule(new _cls8(), 0L, k);
        Q = new Timer();
        return;
        obj;
        com.kochava.android.a.b.b((new StringBuilder()).append("Error gathering app name ").append(((android.content.pm.PackageManager.NameNotFoundException) (obj)).toString()).toString());
        obj = null;
          goto _L3
_L2:
        obj = "(unknown)";
          goto _L4
        obj;
        com.kochava.android.a.b.b((new StringBuilder()).append("Error gathering app name ").append(((Exception) (obj)).toString()).toString());
          goto _L5
    }

    private static String J()
    {
        boolean flag = true;
        if (X.getString("initBool", "").equals("true")) goto _L2; else goto _L1
_L1:
        Object obj;
        com.kochava.android.a.b.a("PREF_INIT not true, waiting for initial to be queued");
        obj = "";
_L4:
        return ((String) (obj));
_L2:
        obj = M.a();
        if (obj == null)
        {
            return "";
        }
        obj = new StringTokenizer(((String) (obj)), "=");
        long l1 = Long.parseLong(((StringTokenizer) (obj)).nextToken());
        Object obj2 = ((StringTokenizer) (obj)).nextToken();
        obj = obj2;
        if (((String) (obj2)).startsWith("["))
        {
            obj = ((String) (obj2)).substring(1);
        }
        obj2 = obj;
        if (((String) (obj)).endsWith("]"))
        {
            obj2 = ((String) (obj)).substring(0, ((String) (obj)).length() - 1);
        }
        com.kochava.android.a.b.a((new StringBuilder()).append("Post The Data 3>>>>>>").append(((String) (obj2))).toString());
        Object obj1;
        HttpPost httppost;
        if (((String) (obj2)).contains("\"action\":\"initial\""))
        {
            com.kochava.android.a.b.b("Post Data: Event is initial, look at response");
        } else
        {
            flag = false;
        }
        obj = h(false);
        HttpProtocolParams.setUserAgent(((HttpClient) (obj)).getParams(), y);
        if (i == null || i.trim().isEmpty())
        {
            com.kochava.android.a.b.a("postEvent - hostControl was empty, using default");
            i = "control.kochava.com";
        }
        com.kochava.android.a.b.a((new StringBuilder()).append("postEvent - posting to ").append("https://").append(i).append("/track/kvTracker.php").toString());
        httppost = new HttpPost((new StringBuilder()).append("https://").append(i).append("/track/kvTracker.php").toString());
        try
        {
            obj2 = new StringEntity((new StringBuilder()).append("[").append(((String) (obj2))).append("]").toString(), "UTF-8");
            BasicHeader basicheader = new BasicHeader("Content-Type", "application/xml");
            httppost.getParams().setBooleanParameter("http.protocol.expect-continue", false);
            ((StringEntity) (obj2)).setContentType(basicheader);
            httppost.setEntity(((HttpEntity) (obj2)));
            com.kochava.android.a.b.a("Trying to post an event.");
            obj = ((HttpClient) (obj)).execute(httppost).getEntity();
        }
        catch (ClientProtocolException clientprotocolexception)
        {
            com.kochava.android.a.b.b((new StringBuilder()).append("TrackTask ").append(clientprotocolexception).toString());
            return "";
        }
        catch (IOException ioexception)
        {
            com.kochava.android.a.b.b((new StringBuilder()).append("TrackTask ").append(ioexception).toString());
            return "";
        }
        if (obj == null)
        {
            return "";
        }
        com.kochava.android.a.b.a("Grabbing Result...");
        obj2 = com.kochava.android.a.c.a(((HttpEntity) (obj)).getContent());
        com.kochava.android.a.b.a((new StringBuilder()).append("Result: ").append(((String) (obj2))).toString());
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_502;
        }
        if (((String) (obj2)).contains("\"success\":\"1\""))
        {
            com.kochava.android.a.b.a("Got success response, cleaning database.");
            M.a(l1);
        }
        obj = obj2;
        if (A()) goto _L4; else goto _L3
_L3:
        obj = obj2;
        if (!U) goto _L4; else goto _L5
_L5:
        com.kochava.android.a.b.a("Requesting attribution data...");
        a(7);
        return ((String) (obj2));
        obj1;
        com.kochava.android.a.b.b((new StringBuilder()).append("TrackTask ").append(obj1).toString());
        return "";
        M.a(l1);
        return ((String) (obj2));
        obj1;
        com.kochava.android.a.b.b((new StringBuilder()).append("TrackTask ").append(obj1).toString());
        return "";
    }

    private String K()
    {
        Object obj1;
        Object obj2;
        obj2 = "";
        obj1 = "";
        Object obj3 = (new StringBuilder()).append("").append("\nTrying user agent method 1").toString();
        obj1 = System.getProperty("http.agent");
_L1:
        Object obj;
        Exception exception;
        Object obj4;
        Object obj5;
        boolean flag;
        if (((String) (obj1)).trim().isEmpty())
        {
            flag = false;
        } else
        {
            flag = true;
        }
        obj2 = obj3;
        obj = obj1;
        if (flag)
        {
            break MISSING_BLOCK_LABEL_130;
        }
        obj2 = (new StringBuilder()).append(((String) (obj3))).append("\nTrying user agent method 2").toString();
        obj = obj1;
        obj1 = (new WebView(l)).getSettings().getUserAgentString();
        obj = obj1;
        obj3 = (new StringBuilder()).append(((String) (obj2))).append("\nMethod 2 successful").toString();
        obj2 = obj3;
        obj = obj1;
_L2:
        if (((String) (obj)).trim().isEmpty())
        {
            flag = false;
        } else
        {
            flag = true;
        }
        obj3 = obj2;
        obj4 = obj;
        if (flag)
        {
            break MISSING_BLOCK_LABEL_292;
        }
        obj3 = (new StringBuilder()).append(((String) (obj2))).append("\nTrying user agent method 3").toString();
        obj1 = android/webkit/WebSettings.getDeclaredConstructor(new Class[] {
            android/content/Context, android/webkit/WebView
        });
        obj2 = obj1;
        obj4 = obj;
        ((Constructor) (obj1)).setAccessible(true);
        obj2 = obj1;
        obj4 = obj;
        obj = ((WebSettings)((Constructor) (obj1)).newInstance(new Object[] {
            l, null
        })).getUserAgentString();
        obj2 = obj1;
        obj4 = obj;
        obj5 = (new StringBuilder()).append(((String) (obj3))).append("\nMethod 3 successful.").toString();
        obj2 = obj5;
        obj3 = obj2;
        obj4 = obj;
        if (obj1 != null)
        {
            ((Constructor) (obj1)).setAccessible(false);
            obj4 = obj;
            obj3 = obj2;
        }
_L3:
        com.kochava.android.a.b.a((new StringBuilder()).append("user agent result: ").append(((String) (obj3))).toString());
        return ((String) (obj4));
        obj;
_L8:
        obj3 = new StringWriter();
        ((Exception) (obj)).printStackTrace(new PrintWriter(((java.io.Writer) (obj3))));
        com.kochava.android.a.b.b(((StringWriter) (obj3)).toString());
        obj3 = (new StringBuilder()).append(((String) (obj1))).append("\nError with user agent first method: ").append(((Exception) (obj)).toString()).append("\n").append(((StringWriter) (obj3)).toString()).toString();
        obj1 = obj2;
          goto _L1
        obj;
        obj2 = obj3;
        obj3 = obj;
        obj = obj1;
        obj1 = obj3;
_L7:
        obj3 = new StringWriter();
        ((Exception) (obj1)).printStackTrace(new PrintWriter(((java.io.Writer) (obj3))));
        com.kochava.android.a.b.b(((StringWriter) (obj3)).toString());
        obj2 = (new StringBuilder()).append(((String) (obj2))).append("\nError with user agent second method: ").append(((Exception) (obj1)).toString()).append("\n").append(((StringWriter) (obj3)).toString()).append("\n userAgent = error.").toString();
          goto _L2
        obj3;
        obj1 = null;
        obj4 = obj2;
_L6:
        obj2 = obj1;
        obj5 = new StringWriter();
        obj2 = obj1;
        ((Exception) (obj3)).printStackTrace(new PrintWriter(((java.io.Writer) (obj5))));
        obj2 = obj1;
        com.kochava.android.a.b.b(((StringWriter) (obj5)).toString());
        obj2 = obj1;
        obj3 = (new StringBuilder()).append(((String) (obj4))).append("\nError with user agent third method: ").append(((Exception) (obj3)).toString()).append("\n").append(((StringWriter) (obj5)).toString()).append("\n userAgent = error.").toString();
        obj2 = obj3;
        obj3 = obj2;
        obj4 = obj;
        if (obj1 != null)
        {
            ((Constructor) (obj1)).setAccessible(false);
            obj3 = obj2;
            obj4 = obj;
        }
          goto _L3
        obj;
        obj2 = null;
_L5:
        if (obj2 != null)
        {
            ((Constructor) (obj2)).setAccessible(false);
        }
        throw obj;
        obj;
        if (true) goto _L5; else goto _L4
_L4:
        exception;
        obj1 = null;
        obj4 = obj3;
        obj3 = exception;
          goto _L6
        obj;
        exception = ((Exception) (obj3));
        obj3 = obj;
        obj = obj4;
        obj4 = exception;
          goto _L6
        obj1;
          goto _L7
        obj;
        obj1 = obj3;
          goto _L8
    }

    private String L()
    {
        String s1;
        int i1;
        try
        {
            i1 = GooglePlayServicesUtil.isGooglePlayServicesAvailable(l);
        }
        catch (Exception exception)
        {
            com.kochava.android.a.b.b((new StringBuilder()).append("Problem getting Advertising ID (catch): ").append(exception.toString()).toString());
            return "";
        }
        if (i1 == 0) goto _L2; else goto _L1
_L1:
        i1;
        JVM INSTR tableswitch 0 9: default 335
    //                   0 145
    //                   1 207
    //                   2 239
    //                   3 271
    //                   4 68
    //                   5 68
    //                   6 68
    //                   7 68
    //                   8 68
    //                   9 303;
           goto _L3 _L4 _L5 _L6 _L7 _L3 _L3 _L3 _L3 _L3 _L8
_L8:
        break MISSING_BLOCK_LABEL_303;
_L3:
        com.kochava.android.a.b.a((new StringBuilder()).append("Google Play Services check returned unknown error code (").append(i1).append(").").toString());
_L9:
        com.kochava.android.a.b.b((new StringBuilder()).append("Problem getting Advertising ID ").append(GooglePlayServicesUtil.getErrorString(i1)).toString());
_L2:
        com.google.android.gms.ads.identifier.AdvertisingIdClient.Info info = AdvertisingIdClient.getAdvertisingIdInfo(l);
        s1 = info.getId();
        F = info.isLimitAdTrackingEnabled();
        return s1;
_L4:
        com.kochava.android.a.b.a((new StringBuilder()).append("Google Play Services check returned ConnectionResult.SUCCESS (").append(i1).append(").").toString());
          goto _L9
_L5:
        com.kochava.android.a.b.a((new StringBuilder()).append("Google Play Services check returned ConnectionResult.SERVICE_MISSING (").append(i1).append(").").toString());
          goto _L9
_L6:
        com.kochava.android.a.b.a((new StringBuilder()).append("Google Play Services check returned ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED (").append(i1).append(").").toString());
          goto _L9
_L7:
        com.kochava.android.a.b.a((new StringBuilder()).append("Google Play Services check returned ConnectionResult.SERVICE_DISABLED (").append(i1).append(").").toString());
          goto _L9
        com.kochava.android.a.b.a((new StringBuilder()).append("Google Play Services check returned ConnectionResult.SERVICE_INVALID (").append(i1).append(").").toString());
          goto _L9
    }

    private String M()
    {
        String s1 = "";
        if (l.checkCallingOrSelfPermission("android.permission.GET_ACCOUNTS") == 0)
        {
            Account aaccount[] = AccountManager.get(l).getAccounts();
            int j1 = aaccount.length;
            for (int i1 = 0; i1 < j1;)
            {
                Account account = aaccount[i1];
                String s2 = s1;
                if (g(account.name))
                {
                    s2 = account.name.toLowerCase();
                    s2 = (new StringBuilder()).append(s1).append(s2).append(",").toString();
                }
                i1++;
                s1 = s2;
            }

            if (s1.length() > 0)
            {
                s1 = s1.substring(0, s1.length() - 1);
            } else
            {
                s1 = "";
            }
        } else
        {
            s1 = "";
            com.kochava.android.a.b.a("****NOTICE**** Gathering of emails was whitelisted, but android.permission.GET_ACCOUNTS declaration was missing from manifest.");
        }
        return (new StringBuilder()).append("[").append(s1).append("]").toString();
    }

    static SharedPreferences a(SharedPreferences sharedpreferences)
    {
        X = sharedpreferences;
        return sharedpreferences;
    }

    protected static String a(ContentResolver contentresolver)
    {
        contentresolver = contentresolver.query(ac, new String[] {
            "aid"
        }, null, null, null);
        Object obj;
        if (contentresolver == null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        obj = contentresolver;
        boolean flag = contentresolver.moveToFirst();
        if (flag)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        Object obj1;
        if (contentresolver != null)
        {
            try
            {
                if (!contentresolver.isClosed())
                {
                    contentresolver.close();
                }
            }
            // Misplaced declaration of an exception variable
            catch (ContentResolver contentresolver)
            {
                return null;
            }
        }
        return null;
        obj = contentresolver;
        obj1 = contentresolver.getString(contentresolver.getColumnIndex("aid"));
        obj = obj1;
        if (contentresolver == null)
        {
            break MISSING_BLOCK_LABEL_102;
        }
        obj = obj1;
        if (contentresolver.isClosed())
        {
            break MISSING_BLOCK_LABEL_102;
        }
        contentresolver.close();
        obj = obj1;
_L6:
        return ((String) (obj));
        obj1;
        contentresolver = null;
_L4:
        obj = contentresolver;
        com.kochava.android.a.b.a((new StringBuilder()).append("Problem getting FB attribution ID ").append(((Exception) (obj1)).toString()).toString());
        if (contentresolver != null)
        {
            try
            {
                if (!contentresolver.isClosed())
                {
                    contentresolver.close();
                }
            }
            // Misplaced declaration of an exception variable
            catch (ContentResolver contentresolver)
            {
                obj = null;
                continue; /* Loop/switch isn't completed */
            }
        }
        obj = null;
        continue; /* Loop/switch isn't completed */
        contentresolver;
        obj = null;
_L2:
        if (obj != null)
        {
            try
            {
                if (!((Cursor) (obj)).isClosed())
                {
                    ((Cursor) (obj)).close();
                }
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
        }
        throw contentresolver;
        contentresolver;
        if (true) goto _L2; else goto _L1
_L1:
        obj1;
        if (true) goto _L4; else goto _L3
_L3:
        contentresolver;
        obj = obj1;
        if (true) goto _L6; else goto _L5
_L5:
    }

    static String a(c c1)
    {
        return c1.L();
    }

    static Timer a(c c1, Timer timer)
    {
        c1.P = timer;
        return timer;
    }

    static JSONObject a(JSONObject jsonobject)
    {
        return b(jsonobject);
    }

    public static void a()
    {
        if (R)
        {
            com.kochava.android.a.b.b("The library was not initialized properly. Until it is, this method cannot be used.");
            return;
        } else
        {
            com.kochava.android.a.b.a("flush");
            Z.submit(new g(null));
            return;
        }
    }

    protected static void a(int i1)
    {
        ab.schedule(af, i1, TimeUnit.SECONDS);
    }

    private void a(Context context, boolean flag, HashMap hashmap)
    {
        boolean flag1 = true;
        if (context == null) goto _L2; else goto _L1
_L1:
        l = context;
        com.kochava.android.a.b.a((new StringBuilder()).append("Feature initialization. Library version: Android20150312").append(a).toString());
        if (c == null)
        {
            c = context.getApplicationContext();
        }
        X = l.getSharedPreferences("initPrefs", 0);
        M = new a(l);
        if (hashmap == null) goto _L4; else goto _L3
_L3:
        if (hashmap.get("debug") != null && hashmap.get("debug").getClass().equals(java/lang/Boolean))
        {
            boolean flag2 = ((Boolean)hashmap.get("debug")).booleanValue();
            a(flag2);
            b(flag2);
        }
        if (hashmap.get("version_extension") != null && hashmap.get("version_extension").getClass().equals(java/lang/String))
        {
            a = (String)hashmap.get("version_extension");
        }
        if (hashmap.get("override_automatic_sessions") != null && hashmap.get("override_automatic_sessions").getClass().equals(java/lang/Boolean))
        {
            b = ((Boolean)hashmap.get("override_automatic_sessions")).booleanValue();
        }
        if (hashmap.get("suppress_adid_gather") != null && hashmap.get("suppress_adid_gather").getClass().equals(java/lang/Boolean))
        {
            G = ((Boolean)hashmap.get("suppress_adid_gather")).booleanValue();
        }
        if (hashmap.get("init_with_looper") == null || !hashmap.get("init_with_looper").getClass().equals(java/lang/Boolean)) goto _L4; else goto _L5
_L5:
        boolean flag3 = ((Boolean)hashmap.get("init_with_looper")).booleanValue();
_L22:
        Object obj;
        Object obj1;
        String s6;
        Context context1;
        String s7;
        String s8;
        Exception exception;
        int i1;
        if (flag3)
        {
            com.kochava.android.a.b.a("initializing init handler with looper");
            G();
        } else
        {
            com.kochava.android.a.b.a("initializing init handler without looper");
            H();
        }
        if (android.os.Build.VERSION.SDK_INT >= 14 && !b)
        {
            Log.i("KochavaTracker", (new StringBuilder()).append("using automatic sessions, overrideAutomaticSessions= ").append(b).toString());
            ((Application)c).registerActivityLifecycleCallbacks(new e(this));
            c.registerComponentCallbacks(new f(this));
            d.a = true;
        } else
        {
            Log.i("KochavaTracker", (new StringBuilder()).append("not using automatic sessions, overrideAutomaticSessions= ").append(b).toString());
        }
        try
        {
            z = a(l.getContentResolver());
        }
        // Misplaced declaration of an exception variable
        catch (Context context) { }
        if (!G)
        {
            (new _cls1()).execute(new Void[0]);
        }
        try
        {
            r = l.getPackageManager().getPackageInfo(l.getPackageName(), 0).packageName;
        }
        // Misplaced declaration of an exception variable
        catch (Context context) { }
        d = new JSONObject();
        e = new JSONObject();
        f = new JSONObject();
        if (hashmap == null) goto _L7; else goto _L6
_L6:
        String s1;
        String s2;
        String s3;
        String s4;
        String s5;
        if (hashmap.get("partner_name") != null && hashmap.get("partner_name").getClass().equals(java/lang/String))
        {
            s1 = (String)hashmap.get("partner_name");
        } else
        {
            s1 = null;
        }
        if (hashmap.get("kochava_app_id") != null && hashmap.get("kochava_app_id").getClass().equals(java/lang/String))
        {
            s2 = (String)hashmap.get("kochava_app_id");
        } else
        {
            s2 = null;
        }
        if (hashmap.get("currency") != null && hashmap.get("currency").getClass().equals(java/lang/String))
        {
            s3 = (String)hashmap.get("currency");
        } else
        {
            s3 = null;
        }
        if (hashmap.get("request_attribution") == null) goto _L9; else goto _L8
_L8:
        if (!hashmap.get("request_attribution").getClass().equals(java/lang/String)) goto _L11; else goto _L10
_L10:
        context = (String)hashmap.get("request_attribution");
_L16:
        if (hashmap.get("bidder_host") != null && hashmap.get("bidder_host").getClass().equals(java/lang/String))
        {
            s4 = (String)hashmap.get("bidder_host");
        } else
        {
            s4 = null;
        }
        if (hashmap.get("control_host") != null && hashmap.get("control_host").getClass().equals(java/lang/String))
        {
            s5 = (String)hashmap.get("control_host");
        } else
        {
            s5 = null;
        }
        if (hashmap.get("app_limit_tracking") != null && hashmap.get("app_limit_tracking").getClass().equals(java/lang/Boolean))
        {
            E = ((Boolean)hashmap.get("app_limit_tracking")).booleanValue();
        }
        if (hashmap.get("identity_link") != null && (hashmap.get("identity_link") instanceof HashMap))
        {
            try
            {
                g = (HashMap)hashmap.get("identity_link");
                h = new JSONObject();
                for (obj = g.entrySet().iterator(); ((Iterator) (obj)).hasNext(); ((Iterator) (obj)).remove())
                {
                    obj1 = (java.util.Map.Entry)((Iterator) (obj)).next();
                    h.put((String)((java.util.Map.Entry) (obj1)).getKey(), (String)((java.util.Map.Entry) (obj1)).getValue());
                }

            }
            // Misplaced declaration of an exception variable
            catch (Exception exception) { }
        }
        if (hashmap.get("clickData") != null && hashmap.get("clickData").getClass().equals(java/lang/String))
        {
            t = (String)hashmap.get("clickData");
        }
        exception = s1;
        obj1 = s2;
        s6 = s3;
        context1 = context;
        s7 = s4;
        s8 = s5;
        if (hashmap.get("flush_rate") != null)
        {
            exception = s1;
            obj1 = s2;
            s6 = s3;
            context1 = context;
            s7 = s4;
            s8 = s5;
            if (hashmap.get("flush_rate").getClass().equals(java/lang/Integer))
            {
                i1 = ((Integer)hashmap.get("flush_rate")).intValue();
                if (i1 < 1)
                {
                    com.kochava.android.a.b.a((new StringBuilder()).append("Trying to set flush rate to: ").append(i1).append(". Flush rate can only be set to between 1 minute and 6 hours (360 minutes). Setting flush rate to 1 minute.").toString());
                    s8 = s5;
                    s7 = s4;
                    context1 = context;
                    s6 = s3;
                    obj1 = s2;
                    exception = s1;
                } else
                if (i1 > 360)
                {
                    com.kochava.android.a.b.a((new StringBuilder()).append("Trying to set flush rate to: ").append(i1).append(". Flush rate can only be set to between 1 minute and 6 hours (360 minutes). Setting flush rate to 6 hours.").toString());
                    k = 0x1499700;
                    exception = s1;
                    obj1 = s2;
                    s6 = s3;
                    context1 = context;
                    s7 = s4;
                    s8 = s5;
                } else
                {
                    k = i1 * 60 * 1000;
                    com.kochava.android.a.b.a((new StringBuilder()).append("Flush rate set to ").append(i1).append(" minutes.").toString());
                    exception = s1;
                    obj1 = s2;
                    s6 = s3;
                    context1 = context;
                    s7 = s4;
                    s8 = s5;
                }
            }
        }
_L20:
        if (s8 != null && s8.trim().length() != 0)
        {
            i = s8;
        }
        if (s7 != null && s7.trim().length() != 0)
        {
            j = s7;
        }
        if (s6 != null && s6.length() != 0)
        {
            e(s6);
        }
        if (context1 != null && context1.equalsIgnoreCase("true"))
        {
            U = true;
        }
        Y = l.getSharedPreferences("attributionPref", 0);
        if (obj1 == null) goto _L13; else goto _L12
_L12:
        if (((String) (obj1)).trim().length() == 0) goto _L13; else goto _L14
_L14:
        u = ((String) (obj1));
        e.put("kochava_app_id", obj1);
        f.put("kochava_app_id", obj1);
        if (X.getString("kochavaappdata", "").equals(""))
        {
            X.edit().putString("kochavaappdata", ((String) (obj1))).commit();
        }
_L17:
        d.put("package", B());
        d.put("platform", "android");
        d.put("session_tracking", "full");
        d.put("currency", X.getString("currency", "USD"));
        f.put("currency", X.getString("currency", "USD"));
        f.put("session_tracking", "full");
        f.put("currency", X.getString("currency", "USD"));
        e.put("sdk_version", (new StringBuilder()).append("Android20150312").append(a).toString());
        e.put("sdk_protocol", "3");
        e.put("data", d);
        e.put("data_orig", f);
_L18:
        I = System.currentTimeMillis() / 1000L;
        hashmap = "";
        context = new ComponentName(l, com/kochava/android/tracker/ReferralCapture);
        l.getPackageManager().getReceiverInfo(context, 0);
        com.kochava.android.a.b.a("Receiver registered.");
        i1 = 0;
_L19:
        context = hashmap;
        if (l.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", l.getPackageName()) < 0)
        {
            context = (new StringBuilder()).append(hashmap).append("\n    PERMMISION MISSING: android.permission.ACCESS_NETWORK_STATE").toString();
            i1 = 1;
        }
        hashmap = context;
        if (l.getPackageManager().checkPermission("android.permission.INTERNET", l.getPackageName()) < 0)
        {
            hashmap = (new StringBuilder()).append(context).append("\n    PERMMISION MISSING: android.permission.INTERNET").toString();
            i1 = 1;
        }
        if (l.getPackageManager().checkPermission("android.permission.ACCESS_WIFI_STATE", l.getPackageName()) < 0)
        {
            hashmap = (new StringBuilder()).append(hashmap).append("\n    PERMMISION MISSING: android.permission.ACCESS_WIFI_STATE").toString();
            i1 = ((flag1) ? 1 : 0);
        }
        if (i1 != 0)
        {
            com.kochava.android.a.b.c("**NOTICE** The following items may not have been implemented correctly. Please refer to the SDK documentation to resolve these issues:");
            com.kochava.android.a.b.c(hashmap);
        }
        try
        {
            v = ((TelephonyManager)l.getSystemService("phone")).getDeviceId();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            com.kochava.android.a.b.b((new StringBuilder()).append("Couldn't gather IMEI: ").append(context.toString()).toString());
        }
        try
        {
            J = ((WifiManager)l.getSystemService("wifi")).getConnectionInfo().getMacAddress();
        }
        // Misplaced declaration of an exception variable
        catch (Context context) { }
        try
        {
            e.put("kochava_device_id", E());
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
        }
        context = new _cls2(flag);
        ab.schedule(context, 5L, TimeUnit.SECONDS);
        a("init");
        return;
_L2:
        com.kochava.android.a.b.b("Context you passed was null, cannot initialize.");
        R = true;
        return;
_L11:
        if (!hashmap.get("request_attribution").getClass().equals(java/lang/Boolean) || !((Boolean)hashmap.get("request_attribution")).booleanValue()) goto _L9; else goto _L15
_L15:
        context = "true";
          goto _L16
_L13:
        if (exception == null)
        {
            break MISSING_BLOCK_LABEL_2213;
        }
        if (exception.trim().length() == 0)
        {
            break MISSING_BLOCK_LABEL_2213;
        }
        d.put("partner_name", exception);
        if (X.getString("kochavaappdata", "").equals(""))
        {
            X.edit().putString("kochavaappdata", exception).commit();
        }
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_2186;
        }
        if (((String) (obj1)).trim().length() == 0)
        {
            break MISSING_BLOCK_LABEL_2186;
        }
        u = ((String) (obj1));
        e.put("kochava_app_id", obj1);
        f.put("kochava_app_id", obj1);
          goto _L17
        u = (new StringBuilder()).append("_p:").append(exception).toString();
          goto _L17
        try
        {
            com.kochava.android.a.b.b("You must pass either an app id, or a partner name into the datamap during initialization.");
            R = true;
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            com.kochava.android.a.b.b((new StringBuilder()).append("Error building KVinit json object: ").append(context.toString()).toString());
        }
          goto _L18
        context;
        hashmap = (new StringBuilder()).append("").append("\n    BROADCAST RECEIVER REGISTRATION MISSING: com.kochava.android.tracker.ReferralCapture").toString();
        i1 = 1;
          goto _L19
_L9:
        context = null;
          goto _L16
_L7:
        s8 = null;
        s7 = null;
        context1 = null;
        s6 = null;
        obj1 = null;
        exception = null;
          goto _L20
_L4:
        flag3 = false;
        if (true) goto _L22; else goto _L21
_L21:
    }

    public static void a(Handler handler)
    {
        aa = handler;
    }

    static void a(c c1, String s1)
    {
        c1.e(s1);
    }

    static void a(c c1, boolean flag)
    {
        c1.g(flag);
    }

    private void a(String s1, Map map)
    {
        JSONObject jsonobject;
        com.kochava.android.a.b.a((new StringBuilder()).append("FIRE EVENT*** action:").append(s1).toString());
        com.kochava.android.a.b.a((new StringBuilder()).append("FIRE EVENT*** properties:").append(map).toString());
        jsonobject = new JSONObject();
        JSONObject jsonobject1;
        jsonobject.put("kochava_app_id", u);
        jsonobject.put("kochava_device_id", E());
        jsonobject.put("action", s1);
        jsonobject.put("dev_id_strategy", x);
        jsonobject.put("last_post_time", 0);
        X = l.getSharedPreferences("initPrefs", 0);
        jsonobject.put("currency", X.getString("currency", "USD"));
        jsonobject1 = b(new JSONObject());
        if (!s1.equals("initial"))
        {
            break MISSING_BLOCK_LABEL_798;
        }
        com.kochava.android.a.b.a("Event is initial, or initial did not get que'd on first load");
        jsonobject.put("sdk_version", (new StringBuilder()).append("Android20150312").append(a).toString());
        if (((Boolean)ad.get("adid")).booleanValue())
        {
            jsonobject1.put("adid", C);
        }
        jsonobject1.put("device", (new StringBuilder()).append(y()).append("-").append(x()).toString());
        if (((Boolean)ad.get("imei")).booleanValue())
        {
            jsonobject1.put("imei", D());
        }
        jsonobject1.put("disp_h", A);
        jsonobject1.put("disp_w", B);
        jsonobject1.put("package_name", B());
        jsonobject1.put("app_version", C());
        if (!q.equals(""))
        {
            jsonobject1.put("app_short_string", q);
        }
        if (((Boolean)ad.get("android_id")).booleanValue())
        {
            jsonobject1.put("android_id", w);
        }
        jsonobject1.put("os_version", z());
        jsonobject1.put("app_limit_tracking", E);
        jsonobject1.put("device_limit_tracking", F);
        s1 = new JSONObject();
        if (T)
        {
            String s2 = M();
            if (!s2.equals("[]"))
            {
                s1.put("email", s2);
            }
        }
        if (s1.length() > 0)
        {
            jsonobject1.put("ids", s1);
        }
        if (h != null)
        {
            jsonobject1.put("identity_link", h);
        }
        if (((Boolean)ad.get("odin")).booleanValue())
        {
            jsonobject1.put("odin", F());
        }
        if (((Boolean)ad.get("mac")).booleanValue())
        {
            jsonobject1.put("mac", J);
        }
        if (t != null && !t.isEmpty())
        {
            jsonobject1.put("clickData", t);
        }
        if (((Boolean)ad.get("fb_attribution_id")).booleanValue())
        {
            z = a(l.getContentResolver());
            if (z != null)
            {
                break MISSING_BLOCK_LABEL_713;
            }
            jsonobject1.put("fb_attribution_id", "");
        }
_L2:
        s1 = (WindowManager)l.getSystemService("window");
        DisplayMetrics displaymetrics = new DisplayMetrics();
        s1.getDefaultDisplay().getMetrics(displaymetrics);
        W = jsonobject1;
        V = jsonobject;
        com.kochava.android.a.b.a("Initial Event, saving until next event. ");
        return;
        jsonobject1.put("fb_attribution_id", z);
        if (true) goto _L2; else goto _L1
_L1:
        s1;
        try
        {
            s1.printStackTrace();
            com.kochava.android.a.b.b((new StringBuilder()).append("event ").append(s1).toString());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            s1.printStackTrace();
        }
        com.kochava.android.a.b.b((new StringBuilder()).append("event ").append(s1).toString());
        return;
        s1;
        com.kochava.android.a.b.b("Error during fireEvent - Please review stack trace");
        s1.printStackTrace();
_L4:
        if (L != null)
        {
            java.util.Map.Entry entry;
            for (s1 = L.entrySet().iterator(); s1.hasNext(); jsonobject1.put((String)entry.getKey(), entry.getValue()))
            {
                entry = (java.util.Map.Entry)s1.next();
            }

        }
        if (map == null)
        {
            break MISSING_BLOCK_LABEL_923;
        }
        for (s1 = map.entrySet().iterator(); s1.hasNext(); jsonobject1.put((String)map.getKey(), map.getValue()))
        {
            map = (java.util.Map.Entry)s1.next();
        }

        jsonobject.put("data", jsonobject1);
        com.kochava.android.a.b.a((new StringBuilder()).append("fireEvent with properties: ").append(jsonobject).toString());
        g(true);
        if (M.a(jsonobject, false) >= 50)
        {
            a();
            return;
        } else
        {
            return;
        }
        s1;
        continue; /* Loop/switch isn't completed */
        s1;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static void a(boolean flag)
    {
        Log.i("KochavaTracker", (new StringBuilder()).append("enableDebug to ").append(flag).toString());
        h.a = flag;
    }

    static int b(int i1)
    {
        D = i1;
        return i1;
    }

    static Context b(c c1)
    {
        return c1.l;
    }

    static String b()
    {
        return y;
    }

    static String b(String s1)
    {
        C = s1;
        return s1;
    }

    private static JSONObject b(JSONObject jsonobject)
    {
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_245;
        }
        jsonobject.put("usertime", (new StringBuilder()).append(System.currentTimeMillis() / 1000L).append("").toString());
        jsonobject.put("uptime", (new StringBuilder()).append(System.currentTimeMillis() / 1000L - I).append("").toString());
        if (H == 0L)
        {
            break MISSING_BLOCK_LABEL_207;
        }
        jsonobject.put("updelta", (new StringBuilder()).append(System.currentTimeMillis() / 1000L - H).append("").toString());
_L1:
        H = System.currentTimeMillis() / 1000L;
        X = c.getSharedPreferences("initPrefs", 0);
        if (X.getString("mylat", "").equals(""))
        {
            break MISSING_BLOCK_LABEL_245;
        }
        jsonobject.put("geo_lat", X.getString("mylat", ""));
        jsonobject.put("geo_lon", X.getString("mylong", ""));
        return jsonobject;
        jsonobject.put("updelta", "0");
          goto _L1
        Exception exception;
        exception;
        com.kochava.android.a.b.b((new StringBuilder()).append("Error adding time properties to a JSON object ").append(exception).toString());
        return jsonobject;
    }

    public static void b(boolean flag)
    {
        Log.i("KochavaTracker", (new StringBuilder()).append("setErrorDebug to ").append(flag).toString());
        com.kochava.android.tracker.h.b = flag;
    }

    static Handler c(c c1)
    {
        return c1.ag;
    }

    static String c()
    {
        return i;
    }

    static String c(String s1)
    {
        i = s1;
        return s1;
    }

    static HttpClient c(boolean flag)
    {
        return h(flag);
    }

    static SharedPreferences d()
    {
        return X;
    }

    static String d(c c1)
    {
        return c1.q;
    }

    static String d(String s1)
    {
        u = s1;
        return s1;
    }

    static boolean d(boolean flag)
    {
        S = flag;
        return flag;
    }

    static int e()
    {
        return D;
    }

    private void e(String s1)
    {
        if (s1 != null && h.c.contains(s1))
        {
            X = l.getSharedPreferences("initPrefs", 0);
            X.edit().putString("currency", s1).commit();
            return;
        } else
        {
            com.kochava.android.a.b.b((new StringBuilder()).append("Trying to set currency, but ").append(s1).append(" is not a valid currency.").toString());
            return;
        }
    }

    static boolean e(c c1)
    {
        return c1.E;
    }

    static boolean e(boolean flag)
    {
        T = flag;
        return flag;
    }

    static String f(c c1)
    {
        return c1.C();
    }

    static HashMap f()
    {
        return ad;
    }

    private static void f(String s1)
    {
        (new _cls5(s1)).start();
    }

    static boolean f(boolean flag)
    {
        R = flag;
        return flag;
    }

    static String g(c c1)
    {
        return c1.z();
    }

    static ArrayList g()
    {
        return ae;
    }

    private void g(boolean flag)
    {
        if (!X.getString("initBool", "").equals("false") || W == null || V == null)
        {
            break MISSING_BLOCK_LABEL_291;
        }
        com.kochava.android.a.b.a((new StringBuilder()).append("Initial properties: ").append(W).toString());
        com.kochava.android.a.b.a((new StringBuilder()).append("Initital Oject: ").append(V).toString());
        if (X.getString("initData", "noData").equals("noData"))
        {
            break MISSING_BLOCK_LABEL_254;
        }
        W.put("conversion_type", "gplay");
        W.put("conversion_data", X.getString("initData", ""));
        com.kochava.android.a.b.a((new StringBuilder()).append("Got referral, attaching: ").append(X.getString("initData", "")).toString());
_L1:
        V.put("data", W);
        M.a(V, true);
        com.kochava.android.a.b.a("Sending Initial");
        X.edit().putString("initBool", "true").commit();
        if (flag)
        {
            try
            {
                Q.cancel();
                return;
            }
            catch (JSONException jsonexception)
            {
                com.kochava.android.a.b.a((new StringBuilder()).append("An error occured during que initial. ").append(jsonexception).toString());
                jsonexception.printStackTrace();
            }
        }
        break MISSING_BLOCK_LABEL_291;
        com.kochava.android.a.b.b("Did not get referral data.");
          goto _L1
    }

    private static boolean g(String s1)
    {
        boolean flag = false;
        if (Pattern.compile("^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$", 2).matcher(s1).matches())
        {
            flag = true;
        }
        return flag;
    }

    private static HttpClient h(boolean flag)
    {
        com.kochava.android.a.b.a("Creating https client.");
        X509HostnameVerifier x509hostnameverifier = SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER;
        BasicHttpParams basichttpparams = new BasicHttpParams();
        HttpProtocolParams.setVersion(basichttpparams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(basichttpparams, "ISO-8859-1");
        HttpProtocolParams.setUseExpectContinue(basichttpparams, true);
        if (flag)
        {
            HttpConnectionParams.setConnectionTimeout(basichttpparams, 10000);
        }
        Object obj = SSLSocketFactory.getSocketFactory();
        ((SSLSocketFactory) (obj)).setHostnameVerifier((X509HostnameVerifier)x509hostnameverifier);
        SchemeRegistry schemeregistry = new SchemeRegistry();
        schemeregistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schemeregistry.register(new Scheme("https", ((org.apache.http.conn.scheme.SocketFactory) (obj)), 443));
        obj = new ThreadSafeClientConnManager(basichttpparams, schemeregistry);
        HttpsURLConnection.setDefaultHostnameVerifier(x509hostnameverifier);
        return new DefaultHttpClient(((org.apache.http.conn.ClientConnectionManager) (obj)), basichttpparams);
    }

    static void h(c c1)
    {
        c1.I();
    }

    static boolean h()
    {
        return G;
    }

    static String i()
    {
        return C;
    }

    static Timer i(c c1)
    {
        return c1.Q;
    }

    static String j()
    {
        return u;
    }

    static Timer j(c c1)
    {
        return c1.P;
    }

    static String k()
    {
        return E();
    }

    static SharedPreferences l()
    {
        return Y;
    }

    static Handler m()
    {
        return aa;
    }

    static boolean n()
    {
        return F;
    }

    static String o()
    {
        return x;
    }

    static Map p()
    {
        return L;
    }

    static a q()
    {
        return M;
    }

    static String r()
    {
        return J();
    }

    static void s()
    {
        v();
    }

    static void t()
    {
        w();
    }

    private String u()
    {
        String s1 = (new StringBuilder()).append("").append(E()).append(":::").toString();
        s1 = (new StringBuilder()).append(s1).append(y()).append(":::").toString();
        s1 = (new StringBuilder()).append(s1).append(x()).append(":::").toString();
        s1 = (new StringBuilder()).append(s1).append(D()).append(":::").toString();
        s1 = (new StringBuilder()).append(s1).append(C()).append(":::").toString();
        return (new StringBuilder()).append(s1).append(z()).toString();
    }

    private static void v()
    {
label0:
        {
            if (android.os.Build.VERSION.SDK_INT >= 14 && !b)
            {
                if (!R)
                {
                    break label0;
                }
                com.kochava.android.a.b.b("The library was not initialized properly. Until it is, this method cannot be used.");
            }
            return;
        }
        com.kochava.android.a.b.a("Automatic Session start");
        I = System.currentTimeMillis() / 1000L;
        if (S)
        {
            f("launch");
            return;
        } else
        {
            com.kochava.android.a.b.a("Session events disabled by server.");
            return;
        }
    }

    private static void w()
    {
label0:
        {
            if (android.os.Build.VERSION.SDK_INT >= 14 && !b)
            {
                if (!R)
                {
                    break label0;
                }
                com.kochava.android.a.b.b("The library was not initialized properly. Until it is, this method cannot be used.");
            }
            return;
        }
        com.kochava.android.a.b.a("Automatic Session End");
        if (S)
        {
            f("exit");
            return;
        } else
        {
            com.kochava.android.a.b.a("Session events disabled by server.");
            return;
        }
    }

    private String x()
    {
        return Build.BRAND;
    }

    private String y()
    {
        return Build.MODEL;
    }

    private String z()
    {
        return (new StringBuilder()).append("Android ").append(android.os.Build.VERSION.RELEASE).toString();
    }

    protected void a(String s1)
    {
        s1 = new _cls4(s1);
        ab.schedule(s1, 10L, TimeUnit.SECONDS);
    }


    /* member class not found */
    class _cls6 {}


    /* member class not found */
    class _cls7 {}


    /* member class not found */
    class _cls8 {}


    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls5 {}


    /* member class not found */
    class _cls4 {}


    /* member class not found */
    class _cls3 {}

}
