// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.ConsoleMessage;
import android.webkit.URLUtil;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.zip.Checksum;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            bu, bt, aa, ac, 
//            as, ar, Settings, bo, 
//            au, TremorVideo, br, bp, 
//            n, aq, at

public class ad
{
    class a
    {

        final Window a;

        public void a()
        {
            a.setFlags(0x1000000, 0x1000000);
        }

        a(Window window)
        {
            a = window;
            super();
        }
    }

    class b
    {

        final Activity a;

        public boolean a()
        {
            boolean flag = false;
            int i1;
            try
            {
                i1 = a.getPackageManager().getActivityInfo(a.getComponentName(), 0).flags;
            }
            catch (Exception exception)
            {
                ad.a(exception);
                return false;
            }
            if ((i1 & 0x200) == 512)
            {
                flag = true;
            }
            return flag;
        }

        b(Activity activity)
        {
            a = activity;
            super();
        }
    }

    class c
    {

        public boolean a()
        {
            return true;
        }

        c()
        {
        }
    }

    public static final class d extends Enum
    {

        public static final d a;
        public static final d b;
        public static final d c;
        private static final d d[];

        public static d valueOf(String s1)
        {
            return (d)Enum.valueOf(com/tremorvideo/sdk/android/videoad/ad$d, s1);
        }

        public static d[] values()
        {
            return (d[])d.clone();
        }

        static 
        {
            a = new d("Always", 0);
            b = new d("Debug", 1);
            c = new d("JSON", 2);
            d = (new d[] {
                a, b, c
            });
        }

        private d(String s1, int i1)
        {
            super(s1, i1);
        }
    }

    public static class e
    {

        public String a;
        public String b;

        public e(String s1, String s2)
        {
            a = s1;
            b = s2;
        }
    }

    static class f extends AsyncTask
    {

        String a;

        protected transient String a(String as1[])
        {
            Object obj;
            DefaultHttpClient defaulthttpclient;
            at at1;
            try
            {
                a = null;
                as1 = new BasicHttpParams();
                as1.setParameter("http.protocol.version", HttpVersion.HTTP_1_1);
                HttpConnectionParams.setConnectionTimeout(as1, 8000);
                HttpConnectionParams.setSoTimeout(as1, 8000);
                HttpConnectionParams.setTcpNoDelay(as1, true);
                defaulthttpclient = new DefaultHttpClient(as1);
                at1 = at.a();
                as1 = ad.j();
            }
            // Misplaced declaration of an exception variable
            catch (String as1[])
            {
                ad.d((new StringBuilder()).append("Exception pre config:").append(as1).toString());
                return null;
            }
            if (as1 == null)
            {
                as1 = "";
            }
            if (ad.O() != null) goto _L2; else goto _L1
_L1:
            obj = "http://config.tremorhub.com/config";
_L4:
            obj = new StringBuilder(((String) (obj)));
            ((StringBuilder) (obj)).append("?cch=");
            ((StringBuilder) (obj)).append(ad.o());
            ((StringBuilder) (obj)).append("&v=");
            ((StringBuilder) (obj)).append(at1.a);
            ((StringBuilder) (obj)).append("&a=");
            ((StringBuilder) (obj)).append(ad.i());
            ((StringBuilder) (obj)).append("&av=");
            ((StringBuilder) (obj)).append(URLEncoder.encode(as1, "UTF-8"));
            ((StringBuilder) (obj)).append("&p=android");
            ((StringBuilder) (obj)).append("&di=");
            ((StringBuilder) (obj)).append(at1.f);
            ((StringBuilder) (obj)).append("&lt=");
            ((StringBuilder) (obj)).append(at1.g);
            ((StringBuilder) (obj)).append("&dm=");
            ((StringBuilder) (obj)).append(URLEncoder.encode(at1.c, "UTF-8"));
            ((StringBuilder) (obj)).append("&nt=");
            ((StringBuilder) (obj)).append(at1.i);
            ((StringBuilder) (obj)).append("&nst=");
            ((StringBuilder) (obj)).append(at1.C);
            ((StringBuilder) (obj)).append("&osv=");
            ((StringBuilder) (obj)).append(URLEncoder.encode(at1.e, "UTF-8"));
            ((StringBuilder) (obj)).append("&mnc=");
            ((StringBuilder) (obj)).append(at1.A);
            ((StringBuilder) (obj)).append("&mcc=");
            ((StringBuilder) (obj)).append(at1.z);
            ((StringBuilder) (obj)).append("&ua=");
            ((StringBuilder) (obj)).append(URLEncoder.encode(at1.B, "UTF-8"));
            ad.d((new StringBuilder()).append("Debug: pre config URL: ").append(((StringBuilder) (obj)).toString()).toString());
            as1 = new HttpGet(((StringBuilder) (obj)).toString());
            as1.setHeader("User-Agent", ad.x());
            a = EntityUtils.toString(defaulthttpclient.execute(as1).getEntity());
            return a;
_L2:
            obj = ad.O();
            if (true) goto _L4; else goto _L3
_L3:
        }

        protected void a(String s1)
        {
            try
            {
                ad.e(a);
            }
            // Misplaced declaration of an exception variable
            catch (String s1) { }
            cancel(true);
        }

        protected void b(String s1)
        {
        }

        protected Object doInBackground(Object aobj[])
        {
            return a((String[])aobj);
        }

        protected void onCancelled(Object obj)
        {
            b((String)obj);
        }

        protected void onPostExecute(Object obj)
        {
            a((String)obj);
        }

        f()
        {
        }
    }

    private static final class g extends Enum
    {

        public static final g a;
        public static final g b;
        public static final g c;
        private static final g d[];

        public static g valueOf(String s1)
        {
            return (g)Enum.valueOf(com/tremorvideo/sdk/android/videoad/ad$g, s1);
        }

        public static g[] values()
        {
            return (g[])d.clone();
        }

        static 
        {
            a = new g("CustomEventNoParams", 0);
            b = new g("CustomEventParams", 1);
            c = new g("CustomEventScene", 2);
            d = (new g[] {
                a, b, c
            });
        }

        private g(String s1, int i1)
        {
            super(s1, i1);
        }
    }


    private static boolean A = false;
    private static boolean B;
    private static long C = 0L;
    private static String D;
    private static String E = null;
    private static bu F = new bu();
    private static long G[] = new long[g.values().length];
    private static String H = "http://app.scanscout.com";
    private static String I = null;
    private static String J = null;
    private static String K = null;
    private static ac L;
    private static bt M;
    private static bp N = null;
    private static boolean O = false;
    public static Context a;
    public static boolean b = false;
    public static String c;
    public static boolean d = true;
    public static int e = 0;
    public static int f = 2000;
    public static long g = 10000L;
    public static long h = 8000L;
    public static int i = 100;
    public static boolean j = false;
    public static boolean k = false;
    public static Settings l = null;
    public static ArrayList m = new ArrayList();
    public static String n = null;
    public static n o = null;
    private static String p = "TremoPrefs";
    private static String q = "deviceID";
    private static String r = "__DEX_TAG__";
    private static long s = 0L;
    private static String t[] = new String[0];
    private static au u;
    private static Settings v;
    private static String w = "0";
    private static float x;
    private static float y;
    private static boolean z;

    public static au A()
    {
        return u;
    }

    public static void B()
    {
        D = a(new GregorianCalendar());
        C = D();
    }

    public static void C()
    {
        M.a();
        if (D != null)
        {
            long l1 = D();
            long l2 = C;
            aa.a(D, l1 - l2);
            D = null;
        }
        L.b();
    }

    public static long D()
    {
        return System.nanoTime() / 0xf4240L - s;
    }

    public static int E()
    {
        Display display = ((WindowManager)a.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displaymetrics = new DisplayMetrics();
        display.getMetrics(displaymetrics);
        return (int)TypedValue.applyDimension(2, 15F, displaymetrics);
    }

    public static int F()
    {
        return 25;
    }

    public static int G()
    {
        return 15;
    }

    public static int H()
    {
        Display display = ((WindowManager)a.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displaymetrics = new DisplayMetrics();
        display.getMetrics(displaymetrics);
        return (int)TypedValue.applyDimension(2, 12F, displaymetrics);
    }

    public static int I()
    {
        return 20;
    }

    public static float J()
    {
        if (x == 0.0F)
        {
            x = P();
        }
        return x;
    }

    public static float K()
    {
        if (y == 0.0F)
        {
            y = Q();
        }
        return y;
    }

    public static void L()
    {
        ((Activity)a).runOnUiThread(new Runnable() {

            public void run()
            {
                ad.n = (new WebView(ad.a)).getSettings().getUserAgentString();
            }

        });
    }

    public static void M()
    {
        Object obj;
        obj = a.getSharedPreferences("PreConfig", 0).getString("preConfigJSON", null);
        d((new StringBuilder()).append("Load pre config from cache:").append(((String) (obj))).toString());
        if (obj == null || ((String) (obj)).length() <= 0)
        {
            break MISSING_BLOCK_LABEL_227;
        }
        obj = new JSONObject(((String) (obj)));
        I = ((JSONObject) (obj)).getJSONObject("urls").getString("ads");
        if (((JSONObject) (obj)).has("sdk_flow_type"))
        {
            e = ((JSONObject) (obj)).getInt("sdk_flow_type");
            switch (e)
            {
            default:
                e = 0;
                break;

            case 0: // '\0'
            case 1: // '\001'
                break;
            }
        }
        if (((JSONObject) (obj)).has("adrequest_timeout"))
        {
            f = ((JSONObject) (obj)).getInt("adrequest_timeout");
        }
        if (((JSONObject) (obj)).has("adstart_timeout"))
        {
            g = ((JSONObject) (obj)).getLong("adstart_timeout");
        }
        if (((JSONObject) (obj)).has("max_buffer_time"))
        {
            h = ((JSONObject) (obj)).getLong("max_buffer_time");
        }
        if (((JSONObject) (obj)).has("throttle"))
        {
            i = ((JSONObject) (obj)).getInt("throttle");
            if (i < 0 || i > 100)
            {
                i = 100;
            }
        }
        return;
        Exception exception;
        exception;
        e = 0;
        return;
    }

    static boolean N()
    {
        return O;
    }

    static String O()
    {
        return K;
    }

    private static float P()
    {
        Display display = ((WindowManager)a.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displaymetrics = new DisplayMetrics();
        display.getMetrics(displaymetrics);
        return displaymetrics.density;
    }

    private static float Q()
    {
        Display display = ((WindowManager)a.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displaymetrics = new DisplayMetrics();
        display.getMetrics(displaymetrics);
        return displaymetrics.scaledDensity;
    }

    private static boolean R()
    {
        if (!B) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        boolean flag;
        Object obj = Environment.getExternalStorageState();
        if (!((String) (obj)).equals("mounted") && !((String) (obj)).equals("mounted_ro"))
        {
            break; /* Loop/switch isn't completed */
        }
        obj = Environment.getExternalStorageDirectory();
        flag = (new File((new StringBuilder()).append(((File) (obj)).getAbsolutePath()).append(File.separatorChar).append("d89f24dc727d476db670624a16933ebd.debug").toString())).exists();
        if (flag) goto _L1; else goto _L3
_L3:
        return false;
        Exception exception;
        exception;
        a(exception);
        if (true) goto _L3; else goto _L4
_L4:
    }

    public static int a(int i1)
    {
        Display display = ((WindowManager)a.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displaymetrics = new DisplayMetrics();
        display.getMetrics(displaymetrics);
        return (int)TypedValue.applyDimension(2, i1, displaymetrics);
    }

    public static aq a(Context context)
    {
        if (Integer.parseInt(android.os.Build.VERSION.SDK) >= 7)
        {
            return new as(context);
        } else
        {
            return new ar(context);
        }
    }

    public static String a(File file)
    {
        try
        {
            BufferedReader bufferedreader = new BufferedReader(new FileReader(file));
            file = new char[(int)file.length()];
            bufferedreader.read(file);
            bufferedreader.close();
            file = String.valueOf(file);
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            a(((Throwable) (file)));
            return "";
        }
        return file;
    }

    public static String a(InputStream inputstream)
    {
        StringBuilder stringbuilder;
        byte abyte0[];
        stringbuilder = new StringBuilder();
        abyte0 = new byte[1024];
_L1:
        int i1 = inputstream.read(abyte0);
label0:
        {
            if (i1 <= 0)
            {
                break label0;
            }
            try
            {
                stringbuilder.append(new String(abyte0, 0, i1));
            }
            // Misplaced declaration of an exception variable
            catch (InputStream inputstream)
            {
                a(((Throwable) (inputstream)));
                return "";
            }
        }
          goto _L1
        inputstream = stringbuilder.toString();
        return inputstream;
    }

    public static String a(Calendar calendar)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(calendar.get(1));
        stringbuilder.append("-");
        stringbuilder.append(calendar.get(2) + 1);
        stringbuilder.append("-");
        stringbuilder.append(calendar.get(7));
        stringbuilder.append(" ");
        stringbuilder.append(calendar.get(11));
        stringbuilder.append(":");
        stringbuilder.append(calendar.get(12));
        stringbuilder.append(":");
        stringbuilder.append(calendar.get(13));
        return stringbuilder.toString();
    }

    public static void a()
    {
        Runtime runtime = Runtime.getRuntime();
        long l1 = runtime.freeMemory();
        l1 = ((runtime.maxMemory() - runtime.totalMemory()) + l1) / 1024L / 1024L;
        d((new StringBuilder()).append("Free Memory: ").append(l1).append("MB").toString());
    }

    public static void a(Activity activity, int i1)
    {
        if (i1 == 0 || i1 == 6)
        {
            d(activity);
            return;
        }
        if (i1 == 1 || i1 == 7)
        {
            c(activity);
            return;
        } else
        {
            activity.setRequestedOrientation(-1);
            return;
        }
    }

    public static void a(Activity activity, String s1)
    {
        long l1 = D();
        int i1 = g.a.ordinal();
        if (l1 - G[i1] >= 2000L)
        {
            d((new StringBuilder()).append("Sending Custom Event: ").append(s1).toString());
            G[i1] = l1;
            aa.a(activity, s1, new HashMap());
            return;
        } else
        {
            d((new StringBuilder()).append("Can't send a new event so soon: ").append(s1).toString());
            return;
        }
    }

    public static void a(Activity activity, String s1, Map map)
    {
        long l1 = D();
        int i1 = g.b.ordinal();
        if (l1 - G[i1] >= 2000L)
        {
            d((new StringBuilder()).append("Sending Custom Event with Parameters: ").append(s1).toString());
            G[i1] = l1;
            aa.a(activity, s1, map);
            return;
        } else
        {
            d((new StringBuilder()).append("Can't send a new event so soon: ").append(s1).toString());
            return;
        }
    }

    public static void a(Context context, String as1[])
    {
        s = System.nanoTime() / 0xf4240L;
        a = context;
        v = new Settings();
        x = 0.0F;
        y = 0.0F;
        L = new ac(context);
        aa.b();
        M = new bt(context);
        t = (String[])as1.clone();
        L();
        for (int i1 = 0; i1 < G.length; i1++)
        {
            G[i1] = 0L;
        }

        try
        {
            bo.a(context, true);
        }
        // Misplaced declaration of an exception variable
        catch (String as1[])
        {
            d((new StringBuilder()).append("Core: Unable to get location: ").append(as1.toString()).toString());
        }
        B = R();
        if (d)
        {
            (new f()).execute(new String[0]);
            return;
        } else
        {
            u = new au(context, c());
            TremorVideo._Initialized = true;
            return;
        }
    }

    public static void a(Window window)
    {
        if (Integer.parseInt(android.os.Build.VERSION.SDK) >= 11)
        {
            (new a(window)).a();
        }
    }

    public static void a(Settings settings)
    {
        com/tremorvideo/sdk/android/videoad/ad;
        JVM INSTR monitorenter ;
        v = new Settings(settings);
        com/tremorvideo/sdk/android/videoad/ad;
        JVM INSTR monitorexit ;
        return;
        settings;
        throw settings;
    }

    public static void a(d d1, String s1)
    {
        a(d1, s1, ((Throwable) (null)));
    }

    public static void a(d d1, String s1, Throwable throwable)
    {
        boolean flag = false;
        if (B)
        {
            if (s1 != null)
            {
                d1 = s1.split("\n");
                int k1 = d1.length;
                for (int i1 = 0; i1 < k1; i1++)
                {
                    Log.v("tremor", d1[i1]);
                }

            }
            if (throwable != null)
            {
                d1 = throwable.getMessage();
                if (d1 != null)
                {
                    d1 = d1.split("\n");
                    int l1 = d1.length;
                    for (int j1 = ((flag) ? 1 : 0); j1 < l1; j1++)
                    {
                        Log.v("tremor", d1[j1]);
                    }

                } else
                {
                    Log.v("tremor", throwable.toString());
                }
                a(throwable.getStackTrace());
                return;
            }
        }
    }

    public static void a(String s1, String s2)
    {
        if (u == null)
        {
            m.add(new e(s1, s2));
            return;
        } else
        {
            u.a(s1, s2);
            return;
        }
    }

    public static void a(String s1, Throwable throwable)
    {
        a(d.a, s1, throwable);
    }

    public static void a(Throwable throwable)
    {
        a(d.a, ((String) (null)), throwable);
    }

    public static void a(Checksum checksum, File file)
    {
        checksum.reset();
        byte abyte0[];
        if (!file.exists())
        {
            break MISSING_BLOCK_LABEL_61;
        }
        abyte0 = new byte[1024];
        file = new FileInputStream(file);
_L1:
        int i1 = file.read(abyte0);
        if (i1 <= 0)
        {
            break MISSING_BLOCK_LABEL_62;
        }
        checksum.update(abyte0, 0, i1);
          goto _L1
        file;
        a(((Throwable) (file)));
        checksum.reset();
        return;
        file.close();
        return;
    }

    public static void a(JSONObject jsonobject)
    {
        com/tremorvideo/sdk/android/videoad/ad;
        JVM INSTR monitorenter ;
        c = jsonobject.getJSONObject("parameters").getString("AppID");
_L1:
        ((Activity)a).runOnUiThread(new Runnable(jsonobject) {

            final JSONObject a;

            public void run()
            {
                ad.d("Init BlueKai");
                WebView webview = new WebView(ad.a);
                webview.getSettings().setJavaScriptEnabled(true);
                webview.setWebViewClient(new WebViewClient(this, webview) {

                    final WebView a;
                    final _cls2 b;

                    public void onPageFinished(WebView webview, String s1)
                    {
label0:
                        {
                            ad.d("BlueKai Page Loaded");
                            if (!ad.N() && !ad.b)
                            {
                                webview = (new StringBuilder()).append("init(").append(b.a).append(")").toString();
                                ad.a(true);
                                ad.b = true;
                                if (ad.q() >= 19)
                                {
                                    break label0;
                                }
                                a.loadUrl((new StringBuilder()).append("javascript:").append(webview).toString());
                            }
                            return;
                        }
                        a.evaluateJavascript(webview, null);
                    }

            
            {
                b = _pcls2;
                a = webview;
                super();
            }
                });
                webview.setWebChromeClient(new WebChromeClient(this) {

                    final _cls2 a;

                    public void onConsoleMessage(String s1, int i1, String s2)
                    {
                        ad.d((new StringBuilder()).append("BluKai Console: ").append(s1).toString());
                    }

                    public boolean onConsoleMessage(ConsoleMessage consolemessage)
                    {
                        ad.d((new StringBuilder()).append("BluKai Console: ").append(consolemessage.message()).toString());
                        return false;
                    }

            
            {
                a = _pcls2;
                super();
            }
                });
                try
                {
                    ad.d("Loading URL");
                    webview.loadUrl(a.getString("template-url"));
                    return;
                }
                catch (Exception exception)
                {
                    ad.d((new StringBuilder()).append("enableBlueKaiJS loadurl Exception:").append(exception).toString());
                }
            }

            
            {
                a = jsonobject;
                super();
            }
        });
        com/tremorvideo/sdk/android/videoad/ad;
        JVM INSTR monitorexit ;
        return;
        JSONException jsonexception;
        jsonexception;
        c = "";
          goto _L1
        jsonobject;
        throw jsonobject;
    }

    public static void a(StackTraceElement astacktraceelement[])
    {
        int j1 = astacktraceelement.length;
        for (int i1 = 0; i1 < j1; i1++)
        {
            StackTraceElement stacktraceelement = astacktraceelement[i1];
            d((new StringBuilder()).append("  ").append(stacktraceelement.toString()).toString());
        }

    }

    public static boolean a(Activity activity)
    {
        if (Integer.parseInt(android.os.Build.VERSION.SDK) >= 11)
        {
            return (new b(activity)).a();
        } else
        {
            return false;
        }
    }

    public static boolean a(aw.b b1)
    {
        br br1 = null;
        if (u != null)
        {
            br1 = u.g();
        }
        while (br1 == null || !br1.a(b1)) 
        {
            return true;
        }
        return false;
    }

    public static boolean a(String s1)
    {
        return a.checkCallingOrSelfPermission(s1) == 0;
    }

    public static boolean a(Checksum checksum, File file, long l1)
    {
        if (l1 == 0L)
        {
            d("No CRC to check.");
        } else
        {
            d("Calculating CRC...");
            a(checksum, file);
            long l2 = checksum.getValue();
            if (l2 == l1)
            {
                d((new StringBuilder()).append("CRC is good: ").append(l2).toString());
            } else
            {
                d((new StringBuilder()).append("CRC is invalid. Expected: ").append(l1).append(". Got: ").append(l2).toString());
                return false;
            }
        }
        return true;
    }

    static boolean a(boolean flag)
    {
        O = flag;
        return flag;
    }

    public static void b()
    {
        a(d.b, "Core - Destroy");
        s = 0L;
        v = new Settings();
        a = null;
        if (N != null)
        {
            N.a();
            N = null;
        }
        u.a();
        u = null;
        for (int i1 = 0; i1 < G.length; i1++)
        {
            G[i1] = 0L;
        }

    }

    public static void b(Activity activity, String s1)
    {
        long l1 = D();
        int i1 = g.c.ordinal();
        if (l1 - G[i1] >= 2000L)
        {
            d((new StringBuilder()).append("Sending State Change: ").append(s1).toString());
            G[i1] = l1;
            aa.a(activity, s1);
            return;
        } else
        {
            d((new StringBuilder()).append("Can't send a new event so soon: ").append(s1).toString());
            return;
        }
    }

    public static void b(String s1)
    {
        com/tremorvideo/sdk/android/videoad/ad;
        JVM INSTR monitorenter ;
        w = s1;
        com/tremorvideo/sdk/android/videoad/ad;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public static boolean b(Activity activity)
    {
        if (Integer.parseInt(android.os.Build.VERSION.SDK) >= 12)
        {
            return (new c()).a();
        } else
        {
            return true;
        }
    }

    public static String c()
    {
        if (false)
        {
            return null;
        }
        if (J != null)
        {
            return J;
        }
        if (z)
        {
            if (I != null && I.length() > 0)
            {
                return I;
            } else
            {
                return (new StringBuilder()).append(H).append("/tap/ad/Ad").toString();
            }
        }
        if (I != null && I.length() > 0)
        {
            return I;
        } else
        {
            return (new StringBuilder()).append(H).append("/tap/ad/Ad").toString();
        }
    }

    public static GregorianCalendar c(String s1)
    {
        String as1[] = s1.split(" ");
        s1 = as1[0].split("-");
        as1 = as1[1].split(":");
        return new GregorianCalendar(Integer.parseInt(s1[0]), Integer.parseInt(s1[1]), Integer.parseInt(s1[2]), Integer.parseInt(as1[0]), Integer.parseInt(as1[1]), Integer.parseInt(as1[2]));
    }

    public static void c(Activity activity)
    {
        if (Integer.parseInt(android.os.Build.VERSION.SDK) >= 9)
        {
            activity.setRequestedOrientation(7);
            return;
        } else
        {
            activity.setRequestedOrientation(1);
            return;
        }
    }

    public static void d(Activity activity)
    {
        if (Integer.parseInt(android.os.Build.VERSION.SDK) >= 9)
        {
            activity.setRequestedOrientation(6);
            return;
        } else
        {
            activity.setRequestedOrientation(0);
            return;
        }
    }

    public static void d(String s1)
    {
        a(d.a, s1, ((Throwable) (null)));
    }

    public static boolean d()
    {
        return B;
    }

    public static String e()
    {
        if (z)
        {
            return "http://l0.scanscout.com/ssframework/tap/avail/Avail";
        } else
        {
            return "http://l0.scanscout.com/ssframework/tap/avail/Avail";
        }
    }

    public static void e(String s1)
    {
        Object obj = null;
        com/tremorvideo/sdk/android/videoad/ad;
        JVM INSTR monitorenter ;
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_408;
        }
        int i1 = s1.length();
        if (i1 <= 0)
        {
            break MISSING_BLOCK_LABEL_408;
        }
        JSONObject jsonobject;
        d((new StringBuilder()).append("pre config response new :").append(s1).toString());
        jsonobject = new JSONObject(s1);
        if (!jsonobject.has("urls")) goto _L2; else goto _L1
_L1:
        JSONObject jsonobject1 = jsonobject.getJSONObject("urls");
        if (jsonobject1.has("ads"))
        {
            obj = jsonobject1.getString("ads");
        }
        if (obj == null) goto _L4; else goto _L3
_L3:
        if (((String) (obj)).length() <= 0 || !URLUtil.isValidUrl(((String) (obj)))) goto _L4; else goto _L5
_L5:
        I = ((String) (obj));
        if (jsonobject.has("sdk_flow_type"))
        {
            e = jsonobject.getInt("sdk_flow_type");
            switch (e)
            {
            default:
                e = 0;
                break;

            case 0: // '\0'
            case 1: // '\001'
                break;
            }
        }
        if (jsonobject.has("adrequest_timeout"))
        {
            f = jsonobject.getInt("adrequest_timeout");
        }
        if (jsonobject.has("adstart_timeout"))
        {
            g = jsonobject.getLong("adstart_timeout");
        }
        if (jsonobject.has("max_buffer_time"))
        {
            h = jsonobject.getLong("max_buffer_time");
        }
        if (jsonobject.has("throttle"))
        {
            i = jsonobject.getInt("throttle");
            if (i < 0 || i > 100)
            {
                i = 100;
            }
        }
        obj = a.getSharedPreferences("PreConfig", 0).edit();
        ((android.content.SharedPreferences.Editor) (obj)).putString("preConfigJSON", s1);
        ((android.content.SharedPreferences.Editor) (obj)).commit();
_L2:
        u = new au(a, c());
        j = true;
        TremorVideo._Initialized = true;
        if (m.size() <= 0)
        {
            break MISSING_BLOCK_LABEL_420;
        }
        e e1;
        for (s1 = m.iterator(); s1.hasNext(); a(e1.a, e1.b))
        {
            e1 = (e)s1.next();
        }

        break MISSING_BLOCK_LABEL_414;
        s1;
        throw s1;
_L4:
        M();
          goto _L2
        s1;
        d((new StringBuilder()).append("Exception pre config JSON processing ").append(s1).toString());
        M();
          goto _L2
        M();
          goto _L2
        m.clear();
        if (l != null)
        {
            d("Delayed set Settings");
            a(l);
            l = null;
        }
        if (e == 0 && k)
        {
            k = false;
            A().a(false);
        }
        com/tremorvideo/sdk/android/videoad/ad;
        JVM INSTR monitorexit ;
    }

    public static ac f()
    {
        return L;
    }

    public static bt g()
    {
        return M;
    }

    public static String h()
    {
        if (z)
        {
            return "http://l0.scanscout.com/ssframework/tap/ad/Session";
        } else
        {
            return "http://l0.scanscout.com/ssframework/tap/ad/Session";
        }
    }

    public static String i()
    {
        String s1;
        try
        {
            s1 = a.getPackageName();
        }
        catch (Exception exception)
        {
            return "unknown";
        }
        return s1;
    }

    public static String j()
    {
        String s1;
        try
        {
            s1 = a.getPackageName();
            s1 = a.getPackageManager().getPackageInfo(s1, 0).versionName;
        }
        catch (Exception exception)
        {
            return "unknown";
        }
        return s1;
    }

    public static bu k()
    {
        return F;
    }

    public static int l()
    {
        Display display = ((WindowManager)a.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displaymetrics = new DisplayMetrics();
        display.getMetrics(displaymetrics);
        return displaymetrics.widthPixels;
    }

    public static int m()
    {
        Display display = ((WindowManager)a.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displaymetrics = new DisplayMetrics();
        display.getMetrics(displaymetrics);
        return displaymetrics.heightPixels;
    }

    public static String n()
    {
        Object obj;
        obj = a.getPackageName();
        obj = a.getPackageManager().getPackageInfo(((String) (obj)), 0).applicationInfo;
        Iterator iterator = ((ActivityManager)a.getSystemService("activity")).getRunningAppProcesses().iterator();
        PackageManager packagemanager = a.getPackageManager();
        android.app.ActivityManager.RunningAppProcessInfo runningappprocessinfo;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_109;
            }
            runningappprocessinfo = (android.app.ActivityManager.RunningAppProcessInfo)iterator.next();
        } while (runningappprocessinfo.processName.compareTo(((ApplicationInfo) (obj)).processName) != 0);
        obj = packagemanager.getApplicationLabel(packagemanager.getApplicationInfo(runningappprocessinfo.processName, 128)).toString();
        return ((String) (obj));
        Exception exception;
        exception;
        a(exception);
        return "unknown";
    }

    public static String o()
    {
        return t[0];
    }

    public static String p()
    {
        String s1;
        SharedPreferences sharedpreferences;
label0:
        {
            sharedpreferences = a.getSharedPreferences(p, 0);
            s1 = sharedpreferences.getString(q, null);
            if (s1 != null && s1.length() != 0)
            {
                break MISSING_BLOCK_LABEL_192;
            }
            d("DeviceID: No stored ID found");
            String s2 = android.provider.Settings.Secure.getString(a.getContentResolver(), "android_id");
            d((new StringBuilder()).append("DeviceID: Android ID = ").append(s2).toString());
            if (s2 != null && s2.length() != 0)
            {
                s1 = s2;
                if (!s2.equals("9774d56d682e549c"))
                {
                    break label0;
                }
            }
            d("DeviceID: falling back to randomUUID.");
            s1 = UUID.randomUUID().toString();
            d((new StringBuilder()).append("DeviceID: udid = ").append(s1).toString());
        }
        d((new StringBuilder()).append("DeviceID: Save ID: ").append(s1).toString());
        sharedpreferences.edit().putString(q, s1).commit();
_L1:
        if (s1 == null)
        {
            E = "";
        } else
        {
            E = s1;
        }
        return E;
        d("DeviceID: Stored ID found");
          goto _L1
    }

    public static int q()
    {
        return Integer.parseInt(android.os.Build.VERSION.SDK);
    }

    public static boolean r()
    {
        TelephonyManager telephonymanager = (TelephonyManager)a.getSystemService("phone");
        int i1 = telephonymanager.getPhoneType();
        boolean flag;
        if (v().checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            return false;
        }
        if (i1 == 0)
        {
            return false;
        }
        return telephonymanager.getLine1Number() != null;
    }

    public static String[] s()
    {
        com/tremorvideo/sdk/android/videoad/ad;
        JVM INSTR monitorenter ;
        String as1[] = t;
        com/tremorvideo/sdk/android/videoad/ad;
        JVM INSTR monitorexit ;
        return as1;
        Exception exception;
        exception;
        throw exception;
    }

    public static Settings t()
    {
        com/tremorvideo/sdk/android/videoad/ad;
        JVM INSTR monitorenter ;
        Settings settings = v;
        com/tremorvideo/sdk/android/videoad/ad;
        JVM INSTR monitorexit ;
        return settings;
        Exception exception;
        exception;
        throw exception;
    }

    public static boolean u()
    {
        return A;
    }

    public static Context v()
    {
        return a;
    }

    public static String w()
    {
        return n;
    }

    public static String x()
    {
        String s1 = Build.BRAND;
        String s2 = Build.MODEL;
        return (new StringBuilder()).append("TransperaSDK v").append(y()).append(" : ").append(s1).append(" : ").append(s2).append(" : Android OS : ").append(android.os.Build.VERSION.RELEASE).toString();
    }

    public static String y()
    {
        String s1 = "3.8.1.53-a";
        if (!"3.8.1.53-a".contains("."))
        {
            s1 = "3.8.0.debug";
        }
        return s1;
    }

    public static String z()
    {
        com/tremorvideo/sdk/android/videoad/ad;
        JVM INSTR monitorenter ;
        String s1 = w;
        com/tremorvideo/sdk/android/videoad/ad;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    static 
    {
        z = true;
        boolean flag;
        if (!z)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        B = flag;
    }
}
