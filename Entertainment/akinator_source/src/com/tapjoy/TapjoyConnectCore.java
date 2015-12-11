// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.FeatureInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.tapjoy.internal.ApiKeyDecoded;
import com.tapjoy.internal.bu;
import com.tapjoy.internal.cw;
import com.tapjoy.internal.de;
import com.tapjoy.internal.ey;
import com.tapjoy.internal.fk;
import com.tapjoy.internal.gd;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeMap;
import java.util.UUID;
import java.util.Vector;
import org.w3c.dom.Document;

// Referenced classes of package com.tapjoy:
//            TapjoyConstants, TapjoyConnectFlag, TapjoyIntegrationException, TapjoyException, 
//            TapjoyURLConnection, TapjoyGpsHelper, TapjoyLog, TapjoyDisplayMetricsUtil, 
//            TapjoyUtil, TJConnectListener, TapjoyCache, TJViewListener, 
//            TapjoyHttpURLResponse

public class TapjoyConnectCore
{
    public class PPAThread
        implements Runnable
    {

        final TapjoyConnectCore a;
        private Map b;

        public void run()
        {
            TapjoyHttpURLResponse tapjoyhttpurlresponse = TapjoyConnectCore.d().getResponseFromURL((new StringBuilder()).append(TapjoyConnectCore.getHostURL()).append("api/connect/v3.json?").toString(), null, null, b);
            if (tapjoyhttpurlresponse.response != null)
            {
                TapjoyConnectCore tapjoyconnectcore = a;
                TapjoyConnectCore.c(tapjoyhttpurlresponse.response);
            }
        }

        public PPAThread(Map map)
        {
            a = TapjoyConnectCore.this;
            super();
            b = map;
        }
    }

    final class a extends TimerTask
    {

        final TapjoyConnectCore a;

        public final void run()
        {
            TapjoyConnectCore.c(a);
            TapjoyLog.i("TapjoyConnect", (new StringBuilder("elapsed_time: ")).append(TapjoyConnectCore.d(a)).append(" (").append(TapjoyConnectCore.d(a) / 1000L / 60L).append("m ").append((TapjoyConnectCore.d(a) / 1000L) % 60L).append("s)").toString());
            android.content.SharedPreferences.Editor editor = TapjoyConnectCore.b().getSharedPreferences("tjcPrefrences", 0).edit();
            editor.putLong("tapjoy_elapsed_time", TapjoyConnectCore.d(a));
            editor.commit();
            if (TapjoyConnectCore.d(a) >= 0xdbba0L)
            {
                TapjoyLog.i("TapjoyConnect", "timer done...");
                if (TapjoyConnectCore.c() != null && TapjoyConnectCore.c().length() > 0)
                {
                    TapjoyLog.i("TapjoyConnect", "Calling PPA actionComplete...");
                    a.actionComplete(TapjoyConnectCore.c());
                }
                cancel();
            }
        }

        private a()
        {
            a = TapjoyConnectCore.this;
            super();
        }

        a(byte byte0)
        {
            this();
        }
    }


    private static String A = "";
    private static int B = 0;
    private static float C = 0F;
    private static int D = 0;
    public static final float DEFAULT_CURRENCY_MULTIPLIER = 1F;
    private static String E = "";
    private static boolean F = false;
    private static String G = "";
    private static String H = "";
    private static String I = "";
    private static String J = "";
    private static String K = "";
    private static String L = "";
    private static String M = "";
    public static final int MAX_NUMBER_OF_OFFLINE_LOGS = 50;
    private static String N = "";
    private static String O = "";
    private static String P = "";
    private static String Q = "native";
    private static String R = "";
    private static String S = "";
    private static float T = 1.0F;
    private static boolean U = false;
    private static boolean V = false;
    private static boolean W = false;
    private static boolean X = false;
    private static boolean Y = false;
    private static String Z = "";
    protected static int a = 0;
    private static int aA;
    private static String aB;
    private static String aC;
    private static String aD;
    private static String aE;
    private static String aF;
    private static int aG;
    private static int aH;
    private static int aI;
    private static long aJ;
    private static long aK;
    private static long aL;
    private static String aM;
    private static int aN;
    private static double aO;
    private static double aP;
    private static long aQ;
    private static int aR;
    private static int aS;
    private static int aT;
    private static String aU;
    private static String aV;
    private static String aW;
    private static boolean aX = false;
    private static boolean aY = true;
    private static String aa = "";
    private static String ab = "";
    private static String ac = "";
    private static String ad = null;
    private static long ah = 0L;
    private static boolean aj;
    private static PackageManager ak;
    private static Hashtable an;
    private static String ao = "";
    private static boolean ap = false;
    private static String aq;
    private static String ar;
    private static String as;
    private static String at;
    private static int au;
    private static String av;
    private static String aw;
    private static long ax;
    private static String ay;
    private static int az;
    protected static int b = 0;
    protected static String c = "";
    protected static boolean d;
    protected static String e = "";
    protected static String f = "";
    private static Context g = null;
    private static String h = null;
    private static TapjoyConnectCore i = null;
    private static TapjoyURLConnection j = null;
    private static TJConnectListener k = null;
    private static TJViewListener l = null;
    private static Vector m;
    private static String n = "";
    private static String o = "";
    private static String p;
    private static String q = "";
    private static String r = "";
    private static String s = "";
    private static String t = "";
    private static String u = "";
    private static String v = "";
    private static String w = "";
    private static String x = "";
    private static String y = "";
    private static String z = "";
    private long ae;
    private Timer af;
    private boolean ag;
    private boolean ai;
    private fk al;
    private TapjoyGpsHelper am;

    public TapjoyConnectCore(Context context)
    {
        ae = 0L;
        af = null;
        ag = false;
        ai = false;
        g = context;
        j = new TapjoyURLConnection();
        ak = g.getPackageManager();
        am = new TapjoyGpsHelper(g);
        int i1;
        if (an == null)
        {
            an = new Hashtable();
        }
        if (getConnectFlagValue("TJC_OPTION_ENABLE_LOGGING") != null && getConnectFlagValue("TJC_OPTION_ENABLE_LOGGING").equals("true"))
        {
            TapjoyLog.setDebugEnabled(true);
        }
        i();
        i1 = g.getResources().getIdentifier("raw/tapjoy_config", null, g.getPackageName());
        context = new Properties();
        Object obj;
        boolean flag;
        try
        {
            context.load(g.getResources().openRawResource(i1));
            a(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context) { }
        if (getConnectFlagValue("unit_test_mode") == "")
        {
            j();
        }
        context = android.provider.Settings.Secure.getString(g.getContentResolver(), "android_id");
        n = context;
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_199;
        }
        n = n.toLowerCase();
        y = ak.getPackageInfo(g.getPackageName(), 0).versionName;
        v = "android";
        G = "android";
        t = Build.MODEL;
        u = Build.MANUFACTURER;
        w = android.os.Build.VERSION.RELEASE;
        z = "11.2.2";
        A = "1.0.7";
        if (android.os.Build.VERSION.SDK_INT > 3)
        {
            context = new TapjoyDisplayMetricsUtil(g);
            B = context.getScreenDensityDPI();
            C = context.getScreenDensityScale();
            D = context.getScreenLayoutSize();
        }
_L16:
        flag = h("android.permission.ACCESS_WIFI_STATE");
        if (!flag) goto _L2; else goto _L1
_L1:
        context = (WifiManager)g.getSystemService("wifi");
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_368;
        }
        context = context.getConnectionInfo();
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_368;
        }
        context = context.getMacAddress();
        r = context;
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_368;
        }
        r = r.replace(":", "").toLowerCase();
_L17:
        context = (TelephonyManager)g.getSystemService("phone");
        if (context == null) goto _L4; else goto _L3
_L3:
        H = context.getNetworkOperatorName();
        I = context.getNetworkCountryIso();
        if (context.getNetworkOperator() != null && (context.getNetworkOperator().length() == 5 || context.getNetworkOperator().length() == 6))
        {
            J = context.getNetworkOperator().substring(0, 3);
            K = context.getNetworkOperator().substring(3);
        }
        flag = h("android.permission.READ_PHONE_STATE");
        if (!flag) goto _L6; else goto _L5
_L5:
        if (getConnectFlagValue("TJC_OPTION_DEBUG_DEVICE_ID") == null || getConnectFlagValue("TJC_OPTION_DEBUG_DEVICE_ID").length() <= 0) goto _L8; else goto _L7
_L7:
        q = getConnectFlagValue("TJC_OPTION_DEBUG_DEVICE_ID");
_L18:
        TapjoyLog.i("TapjoyConnect", (new StringBuilder("deviceID: ")).append(q).toString());
        if (q != null) goto _L10; else goto _L9
_L9:
        TapjoyLog.e("TapjoyConnect", "Device id is null.");
        i1 = 0;
_L19:
        TapjoyLog.i("TapjoyConnect", (new StringBuilder("ANDROID SDK VERSION: ")).append(android.os.Build.VERSION.SDK_INT).toString());
        if (android.os.Build.VERSION.SDK_INT < 9) goto _L4; else goto _L11
_L11:
        TapjoyLog.i("TapjoyConnect", "TRYING TO GET SERIAL OF 2.3+ DEVICE...");
        context = getSerial();
        if (i1 != 0)
        {
            break MISSING_BLOCK_LABEL_592;
        }
        q = context;
        if (q != null) goto _L13; else goto _L12
_L12:
        TapjoyLog.e("TapjoyConnect", "SERIAL: Device id is null.");
_L4:
        context = g.getSharedPreferences("tjcPrefrences", 0);
        obj = context.getString("tapjoyInstallId", "");
        s = ((String) (obj));
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_649;
        }
        i1 = s.length();
        if (i1 != 0)
        {
            break MISSING_BLOCK_LABEL_707;
        }
        s = TapjoyUtil.SHA256((new StringBuilder()).append(UUID.randomUUID().toString()).append(System.currentTimeMillis()).toString());
        context = context.edit();
        context.putString("tapjoyInstallId", s);
        context.commit();
_L20:
        F = a("android.hardware.location", "android.permission.ACCESS_FINE_LOCATION");
_L21:
        U = g("com.facebook.");
        V = g("com.twitter.");
        W = g("com.google.android.apps.plus");
        X = g("com.linkedin.");
_L22:
        if (getConnectFlagValue("TJC_OPTION_STORE_NAME") != null && getConnectFlagValue("TJC_OPTION_STORE_NAME").length() > 0)
        {
            N = getConnectFlagValue("TJC_OPTION_STORE_NAME");
            if (!(new ArrayList(Arrays.asList(TapjoyConnectFlag.STORE_ARRAY))).contains(N))
            {
                TapjoyLog.w("TapjoyConnect", (new StringBuilder("Warning -- undefined STORE_NAME: ")).append(N).toString());
            }
        }
        context = N;
        obj = new Intent("android.intent.action.VIEW");
        if (context.length() > 0) goto _L15; else goto _L14
_L14:
        ((Intent) (obj)).setData(Uri.parse("market://details"));
        if (ak.queryIntentActivities(((Intent) (obj)), 0).size() <= 0)
        {
            break MISSING_BLOCK_LABEL_1610;
        }
        flag = true;
_L23:
        Y = flag;
_L24:
        g();
        if (getConnectFlagValue("TJC_OPTION_DISABLE_PERSISTENT_IDS") != null && getConnectFlagValue("TJC_OPTION_DISABLE_PERSISTENT_IDS").length() > 0)
        {
            f = getConnectFlagValue("TJC_OPTION_DISABLE_PERSISTENT_IDS");
        }
        if (getConnectFlagValue("TJC_OPTION_DISABLE_ADVERTISING_ID_CHECK") != null && getConnectFlagValue("TJC_OPTION_DISABLE_ADVERTISING_ID_CHECK").length() > 0)
        {
            e = getConnectFlagValue("TJC_OPTION_DISABLE_ADVERTISING_ID_CHECK");
        }
        if (getConnectFlagValue("TJC_OPTION_USER_ID") != null && getConnectFlagValue("TJC_OPTION_USER_ID").length() > 0)
        {
            TapjoyLog.i("TapjoyConnect", (new StringBuilder("Setting userID to: ")).append(getConnectFlagValue("TJC_OPTION_USER_ID")).toString());
            setUserID(getConnectFlagValue("TJC_OPTION_USER_ID"));
        }
        S = TapjoyUtil.getRedirectDomain(getConnectFlagValue("TJC_OPTION_SERVICE_URL"));
        obj = (new StringBuilder("deviceID: ")).append(q);
        if (getConnectFlagValue("TJC_OPTION_DEBUG_DEVICE_ID") != null && getConnectFlagValue("TJC_OPTION_DEBUG_DEVICE_ID").length() > 0)
        {
            context = " *debug_device_id*";
        } else
        {
            context = "";
        }
        try
        {
            TapjoyLog.i("TapjoyConnect", ((StringBuilder) (obj)).append(context).toString());
            if (an != null)
            {
                h();
            }
            callConnect();
            ai = true;
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.e("TapjoyConnect", (new StringBuilder("IntegrationException: ")).append(context.getMessage()).toString());
            e();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.e("TapjoyConnect", (new StringBuilder("TapjoyException: ")).append(context.getMessage()).toString());
        }
        break MISSING_BLOCK_LABEL_1200;
        context;
        throw new TapjoyException(context.getMessage());
        context;
        TapjoyLog.e("TapjoyConnect", (new StringBuilder("Error getting screen density/dimensions/layout: ")).append(context.toString()).toString());
          goto _L16
        e();
        return;
        context;
        TapjoyLog.e("TapjoyConnect", (new StringBuilder("Error getting device mac address: ")).append(context.toString()).toString());
          goto _L17
_L2:
        TapjoyLog.i("TapjoyConnect", "*** ignore macAddress");
          goto _L17
_L8:
        q = context.getDeviceId();
          goto _L18
        context;
        TapjoyLog.e("TapjoyConnect", (new StringBuilder("Cannot get deviceID. e: ")).append(context.toString()).toString());
        q = null;
          goto _L4
_L10:
        if (q.length() != 0 && !q.equals("000000000000000") && !q.equals("0"))
        {
            break MISSING_BLOCK_LABEL_1337;
        }
        TapjoyLog.e("TapjoyConnect", "Device id is empty or an emulator.");
        i1 = 0;
          goto _L19
        q = q.toLowerCase(Locale.getDefault());
        i1 = 1;
          goto _L19
_L13:
label0:
        {
            if (q.length() != 0 && !q.equals("000000000000000") && !q.equals("0") && !q.equals("unknown"))
            {
                break label0;
            }
            TapjoyLog.e("TapjoyConnect", "SERIAL: Device id is empty or an emulator.");
        }
          goto _L4
        q = q.toLowerCase(Locale.getDefault());
          goto _L4
_L6:
        TapjoyLog.i("TapjoyConnect", "*** ignore deviceID");
          goto _L4
        context;
        TapjoyLog.e("TapjoyConnect", (new StringBuilder("Error generating install id: ")).append(context.toString()).toString());
          goto _L20
        context;
        TapjoyLog.e("TapjoyConnect", (new StringBuilder("Error trying to detect capabilities on devicee: ")).append(context.toString()).toString());
          goto _L21
        context;
        TapjoyLog.e("TapjoyConnect", (new StringBuilder("Error trying to detect sharing applications installed on devicee: ")).append(context.toString()).toString());
          goto _L22
_L15:
label1:
        {
            if (!context.equals("gfan"))
            {
                break label1;
            }
            flag = f("com.mappn.gfan");
        }
          goto _L23
        if (!context.equals("skt"))
        {
            break MISSING_BLOCK_LABEL_1610;
        }
        flag = f("com.skt.skaf.TSCINSTALL");
          goto _L23
        context;
        TapjoyLog.e("TapjoyConnect", (new StringBuilder("Error trying to detect store intent on devicee: ")).append(context.toString()).toString());
          goto _L24
        flag = false;
          goto _L23
    }

    static fk a(TapjoyConnectCore tapjoyconnectcore)
    {
        return tapjoyconnectcore.al;
    }

    private static String a(long l1)
    {
        String s1;
        try
        {
            s1 = TapjoyUtil.SHA256((new StringBuilder()).append(x).append(":").append(o()).append(":").append(l1).append(":").append(O).toString());
        }
        catch (Exception exception)
        {
            TapjoyLog.e("TapjoyConnect", (new StringBuilder("getVerifier ERROR: ")).append(exception.toString()).toString());
            return "";
        }
        return s1;
    }

    private static String a(long l1, String s1)
    {
        try
        {
            s1 = TapjoyUtil.SHA256((new StringBuilder()).append(x).append(":").append(o()).append(":").append(l1).append(":").append(O).append(":").append(s1).toString());
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            TapjoyLog.e("TapjoyConnect", (new StringBuilder("getVerifier ERROR: ")).append(s1.toString()).toString());
            return "";
        }
        return s1;
    }

    static String a(String s1)
    {
        p = s1;
        return s1;
    }

    private static void a(List list)
    {
        com/tapjoy/TapjoyConnectCore;
        JVM INSTR monitorenter ;
        ao = "";
        Iterator iterator = ak.getInstalledApplications(0).iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            ApplicationInfo applicationinfo = (ApplicationInfo)iterator.next();
            if ((applicationinfo.flags & 1) != 1 && list.contains(applicationinfo.packageName))
            {
                TapjoyLog.i("TapjoyConnect", (new StringBuilder("MATCH: installed packageName: ")).append(applicationinfo.packageName).toString());
                if (ao.length() > 0)
                {
                    ao = (new StringBuilder()).append(ao).append(",").toString();
                }
                ao = (new StringBuilder()).append(ao).append(applicationinfo.packageName).toString();
            }
        } while (true);
        break MISSING_BLOCK_LABEL_158;
        list;
        throw list;
        com/tapjoy/TapjoyConnectCore;
        JVM INSTR monitorexit ;
    }

    private static void a(Properties properties)
    {
        for (Enumeration enumeration = properties.keys(); enumeration.hasMoreElements();)
        {
            try
            {
                String s1 = (String)enumeration.nextElement();
                b(s1, (String)properties.get(s1));
            }
            catch (ClassCastException classcastexception)
            {
                TapjoyLog.e("TapjoyConnect", "Error parsing configuration properties in tapjoy_config.txt");
            }
        }

    }

    static boolean a()
    {
        return m();
    }

    private static boolean a(String s1, String s2)
    {
        FeatureInfo afeatureinfo[] = ak.getSystemAvailableFeatures();
        int j1 = afeatureinfo.length;
        for (int i1 = 0; i1 < j1; i1++)
        {
            if (afeatureinfo[i1].name.matches(s1))
            {
                while (s2 == null || ak.checkPermission(s2, g.getPackageName()) == 0) 
                {
                    return true;
                }
                return false;
            }
        }

        return false;
    }

    static Context b()
    {
        return g;
    }

    static TapjoyGpsHelper b(TapjoyConnectCore tapjoyconnectcore)
    {
        return tapjoyconnectcore.am;
    }

    private static void b(String s1, String s2)
    {
        String s3;
label0:
        {
            if (!s1.equals("TJC_OPTION_SERVICE_URL"))
            {
                s3 = s2;
                if (!s1.equals("TJC_OPTION_PLACEMENT_SERVICE_URL"))
                {
                    break label0;
                }
            }
            s3 = s2;
            if (!s2.endsWith("/"))
            {
                s3 = (new StringBuilder()).append(s2).append("/").toString();
            }
        }
        an.put(s1, s3);
    }

    static boolean b(String s1)
    {
        s1 = TapjoyUtil.buildDocument(s1);
        if (s1 == null) goto _L2; else goto _L1
_L1:
        String s2 = TapjoyUtil.getNodeTrimValue(s1.getElementsByTagName("PackageNames"));
        if (s2 == null || s2.length() <= 0) goto _L4; else goto _L3
_L3:
        Vector vector;
        int i1;
        vector = new Vector();
        i1 = 0;
_L7:
        int j1 = s2.indexOf(',', i1);
        if (j1 != -1) goto _L6; else goto _L5
_L5:
        TapjoyLog.i("TapjoyConnect", (new StringBuilder("parse: ")).append(s2.substring(i1).trim()).toString());
        vector.add(s2.substring(i1).trim());
        a(vector);
_L4:
        s1 = TapjoyUtil.getNodeTrimValue(s1.getElementsByTagName("Success"));
        if (s1 == null || !s1.equals("true"))
        {
            return false;
        }
        break; /* Loop/switch isn't completed */
_L6:
        TapjoyLog.i("TapjoyConnect", (new StringBuilder("parse: ")).append(s2.substring(i1, j1).trim()).toString());
        vector.add(s2.substring(i1, j1).trim());
        i1 = j1 + 1;
        if (true) goto _L7; else goto _L2
_L2:
        return true;
    }

    static long c(TapjoyConnectCore tapjoyconnectcore)
    {
        long l1 = tapjoyconnectcore.ae + 10000L;
        tapjoyconnectcore.ae = l1;
        return l1;
    }

    static String c()
    {
        return ad;
    }

    static boolean c(String s1)
    {
        return e(s1);
    }

    static long d(TapjoyConnectCore tapjoyconnectcore)
    {
        return tapjoyconnectcore.ae;
    }

    static TapjoyURLConnection d()
    {
        return j;
    }

    private static boolean d(String s1)
    {
        s1 = bu.b(s1);
        Object obj = s1;
        Object obj3 = s1.e();
        obj = s1;
        Object obj1 = cw.a((String)((Map) (obj3)).get("app_group_id"));
        obj = s1;
        String s3 = cw.a((String)((Map) (obj3)).get("store"));
        obj = s1;
        String s4 = cw.a((String)((Map) (obj3)).get("analytics_api_key"));
        obj = s1;
        String s5 = cw.a((String)((Map) (obj3)).get("managed_device_id"));
        obj = s1;
        String s2 = cw.a((String)((Map) (obj3)).get("package_names"));
        obj = s1;
        obj3 = (Boolean)((Map) (obj3)).get("initialize_tm");
        if (obj3 == null)
        {
            break MISSING_BLOCK_LABEL_134;
        }
        obj = s1;
        aY = ((Boolean) (obj3)).booleanValue();
        obj = s1;
        Object obj4 = new ApiKeyDecoded(s4);
        obj = s1;
        if (((ApiKeyDecoded) (obj4)).getKeyUsage() == com.tapjoy.internal.ApiKeyDecoded.KeyUsage.RPC_ANALYTICS) goto _L2; else goto _L1
_L1:
        obj = s1;
        throw new IOException("Invalid analytics_api_key");
        obj;
_L10:
        TapjoyLog.v("TapjoyConnect", ((IOException) (obj)).getMessage());
        de.a(s1);
_L6:
        return false;
_L2:
        obj = s1;
        obj3 = ApiKeyDecoded.get5RocksAppId(((ApiKeyDecoded) (obj4)).getAppId());
        obj = s1;
        obj4 = ((ApiKeyDecoded) (obj4)).getSecretKey();
        if (obj1 == null)
        {
            obj1 = obj3;
        }
        obj = s1;
        gd.a().a(g, s4, "11.2.2", "https://rpc.tapjoy.com/", ((String) (obj3)), ((String) (obj4)));
        obj = s1;
        Z = ((String) (obj1));
        obj = s1;
        aa = s3;
        obj = s1;
        ab = s4;
        obj = s1;
        ac = s5;
        obj = s1;
        obj1 = new ArrayList();
        if (s2 == null) goto _L4; else goto _L3
_L3:
        obj = s1;
        String as1[] = s2.split(",");
        obj = s1;
        int j1 = as1.length;
        int i1 = 0;
_L11:
        if (i1 >= j1) goto _L4; else goto _L5
_L5:
        obj = s1;
        s2 = as1[i1].trim();
        obj = s1;
        if (s2.length() <= 0)
        {
            break MISSING_BLOCK_LABEL_427;
        }
        obj = s1;
        ((List) (obj1)).add(s2);
        break MISSING_BLOCK_LABEL_427;
_L4:
        obj = s1;
        if (((List) (obj1)).isEmpty())
        {
            break MISSING_BLOCK_LABEL_359;
        }
        obj = s1;
        a(((List) (obj1)));
        obj = s1;
        s1.close();
        de.a(null);
        return true;
        Object obj2;
        obj2;
        s1 = null;
_L9:
        obj = s1;
        TapjoyLog.v("TapjoyConnect", ((RuntimeException) (obj2)).getMessage());
        de.a(s1);
          goto _L6
        s1;
        obj = null;
_L8:
        de.a(((java.io.Closeable) (obj)));
        throw s1;
        s1;
        continue; /* Loop/switch isn't completed */
        obj2;
        obj = s1;
        s1 = ((String) (obj2));
        if (true) goto _L8; else goto _L7
_L7:
        obj2;
          goto _L9
        obj;
        s1 = null;
          goto _L10
        i1++;
          goto _L11
    }

    private static void e()
    {
        if (!cw.c(P))
        {
            gd.a().a(g, h, "11.2.2", "https://rpc.tapjoy.com/", P, O);
        }
        if (k != null)
        {
            k.onConnectFailure();
        }
    }

    private static boolean e(String s1)
    {
        bu bu1 = bu.b(s1);
        s1 = bu1;
        if (!bu1.a())
        {
            break MISSING_BLOCK_LABEL_43;
        }
        s1 = bu1;
        bu1.t();
        s1 = bu1;
        TapjoyLog.i("TapjoyConnect", "Successfully sent completed Pay-Per-Action to Tapjoy server.");
        s1 = bu1;
        bu1.close();
        de.a(null);
        return true;
        s1 = bu1;
        bu1.close();
        de.a(null);
_L1:
        TapjoyLog.e("TapjoyConnect", "Completed Pay-Per-Action call failed.");
        return false;
        Object obj;
        obj;
        bu1 = null;
_L5:
        s1 = bu1;
        TapjoyLog.v("TapjoyConnect", ((IOException) (obj)).getMessage());
        de.a(bu1);
          goto _L1
        obj;
        bu1 = null;
_L4:
        s1 = bu1;
        TapjoyLog.v("TapjoyConnect", ((RuntimeException) (obj)).getMessage());
        de.a(bu1);
          goto _L1
        Exception exception;
        exception;
        s1 = null;
_L3:
        de.a(s1);
        throw exception;
        exception;
        if (true) goto _L3; else goto _L2
_L2:
        obj;
          goto _L4
        obj;
          goto _L5
    }

    private static Map f()
    {
        HashMap hashmap = new HashMap();
        HashMap hashmap1 = new HashMap();
        HashMap hashmap2 = new HashMap();
        TapjoyUtil.safePut(hashmap2, "plugin", Q, true);
        TapjoyUtil.safePut(hashmap2, "sdk_type", R, true);
        TapjoyUtil.safePut(hashmap2, "app_id", x, true);
        TapjoyUtil.safePut(hashmap2, "library_version", z, true);
        TapjoyUtil.safePut(hashmap2, "library_revision", "ab58402", true);
        TapjoyUtil.safePut(hashmap2, "bridge_version", A, true);
        TapjoyUtil.safePut(hashmap2, "app_version", y, true);
        hashmap1.putAll(hashmap2);
        hashmap2 = new HashMap();
        TapjoyUtil.safePut(hashmap2, "device_name", t, true);
        TapjoyUtil.safePut(hashmap2, "platform", G, true);
        TapjoyUtil.safePut(hashmap2, "os_version", w, true);
        TapjoyUtil.safePut(hashmap2, "device_manufacturer", u, true);
        TapjoyUtil.safePut(hashmap2, "device_type", v, true);
        TapjoyUtil.safePut(hashmap2, "screen_layout_size", (new StringBuilder()).append(D).toString(), true);
        TapjoyUtil.safePut(hashmap2, "device_location", String.valueOf(F), true);
        TapjoyUtil.safePut(hashmap2, "store_name", N, true);
        TapjoyUtil.safePut(hashmap2, "store_view", String.valueOf(Y), true);
        TapjoyUtil.safePut(hashmap2, "carrier_name", H, true);
        TapjoyUtil.safePut(hashmap2, "carrier_country_code", I, true);
        TapjoyUtil.safePut(hashmap2, "mobile_network_code", K, true);
        TapjoyUtil.safePut(hashmap2, "mobile_country_code", J, true);
        TapjoyUtil.safePut(hashmap2, "country_code", Locale.getDefault().getCountry(), true);
        TapjoyUtil.safePut(hashmap2, "language_code", Locale.getDefault().getLanguage(), true);
        L = getConnectionType();
        TapjoyUtil.safePut(hashmap2, "connection_type", L, true);
        M = getConnectionSubType();
        TapjoyUtil.safePut(hashmap2, "connection_subtype", M, true);
        TapjoyUtil.safePut(hashmap2, "screen_density", (new StringBuilder()).append(B).toString(), true);
        hashmap1.putAll(hashmap2);
        hashmap2 = new HashMap();
        if (l())
        {
            TapjoyUtil.safePut(hashmap2, "advertising_id", c, true);
            TapjoyUtil.safePut(hashmap2, "ad_tracking_enabled", String.valueOf(d), true);
        }
        if (!m())
        {
            TapjoyUtil.safePut(hashmap2, "android_id", n, true);
            TapjoyUtil.safePut(hashmap2, "udid", q, true);
            TapjoyUtil.safePut(hashmap2, "mac_address", r, true);
        }
        TapjoyUtil.safePut(hashmap2, "threatmetrix_session_id", p, true);
        TapjoyUtil.safePut(hashmap2, "install_id", s, true);
        TapjoyUtil.safePut(hashmap2, "publisher_user_id", E, true);
        TapjoyUtil.safePut(hashmap2, "ad_id_check_disabled", e, true);
        TapjoyUtil.safePut(hashmap2, "persistent_ids_disabled", f, true);
        if (a != 0)
        {
            TapjoyUtil.safePut(hashmap2, "packaged_gps_version", Integer.toString(a), true);
        }
        if (b != 0)
        {
            TapjoyUtil.safePut(hashmap2, "device_gps_version", Integer.toString(b), true);
        }
        if (o == null || o.length() == 0 || System.currentTimeMillis() - ah > 0x1b7740L)
        {
            o = n();
        } else
        {
            ah = System.currentTimeMillis();
        }
        TapjoyUtil.safePut(hashmap2, "session_id", o, true);
        hashmap1.putAll(hashmap2);
        hashmap2 = new HashMap();
        TapjoyUtil.safePut(hashmap2, "app_group_id", Z, true);
        TapjoyUtil.safePut(hashmap2, "store", aa, true);
        TapjoyUtil.safePut(hashmap2, "analytics_api_key", ab, true);
        TapjoyUtil.safePut(hashmap2, "managed_device_id", ac, true);
        hashmap1.putAll(hashmap2);
        if (TapjoyCache.getInstance() != null && TapjoyCache.getInstance().getCachedOfferIDs() != null && TapjoyCache.getInstance().getCachedOfferIDs().length() > 0)
        {
            TapjoyUtil.safePut(hashmap1, "cached_ids", TapjoyCache.getInstance().getCachedOfferIDs(), true);
        }
        TapjoyUtil.safePut(hashmap1, "display_multiplier", Float.toString(T), true);
        hashmap.putAll(hashmap1);
        hashmap1 = new HashMap();
        g();
        hashmap2 = new HashMap();
        TapjoyUtil.safePut(hashmap2, "analytics_id", aq, true);
        TapjoyUtil.safePut(hashmap2, "pkg_id", ar, true);
        TapjoyUtil.safePut(hashmap2, "pkg_sign", as, true);
        TapjoyUtil.safePut(hashmap2, "display_d", (new StringBuilder()).append(aR).toString(), true);
        TapjoyUtil.safePut(hashmap2, "display_w", (new StringBuilder()).append(aS).toString(), true);
        TapjoyUtil.safePut(hashmap2, "display_h", (new StringBuilder()).append(aT).toString(), true);
        TapjoyUtil.safePut(hashmap2, "country_sim", aU, true);
        TapjoyUtil.safePut(hashmap2, "timezone", aV, true);
        hashmap1.putAll(hashmap2);
        hashmap2 = new HashMap();
        TapjoyUtil.safePut(hashmap2, "pkg_ver", at, true);
        TapjoyUtil.safePut(hashmap2, "pkg_rev", (new StringBuilder()).append(au).toString(), true);
        TapjoyUtil.safePut(hashmap2, "pkg_data_ver", av, true);
        TapjoyUtil.safePut(hashmap2, "installer", aw, true);
        if (cw.c(N))
        {
            TapjoyUtil.safePut(hashmap2, "store_name", aW, true);
        }
        hashmap1.putAll(hashmap2);
        hashmap2 = new HashMap();
        TapjoyUtil.safePut(hashmap2, "installed", (new StringBuilder()).append(ax).toString(), true);
        TapjoyUtil.safePut(hashmap2, "referrer", ay, true);
        TapjoyUtil.safePut(hashmap2, "user_level", (new StringBuilder()).append(az).toString(), true);
        TapjoyUtil.safePut(hashmap2, "friend_count", (new StringBuilder()).append(aA).toString(), true);
        TapjoyUtil.safePut(hashmap2, "uv1", aB, true);
        TapjoyUtil.safePut(hashmap2, "uv2", aC, true);
        TapjoyUtil.safePut(hashmap2, "uv3", aD, true);
        TapjoyUtil.safePut(hashmap2, "uv4", aE, true);
        TapjoyUtil.safePut(hashmap2, "uv5", aF, true);
        TapjoyUtil.safePut(hashmap2, "fq7", (new StringBuilder()).append(aG).toString(), true);
        TapjoyUtil.safePut(hashmap2, "fq30", (new StringBuilder()).append(aH).toString(), true);
        TapjoyUtil.safePut(hashmap2, "session_total_count", (new StringBuilder()).append(aI).toString(), true);
        TapjoyUtil.safePut(hashmap2, "session_total_length", (new StringBuilder()).append(aJ).toString(), true);
        TapjoyUtil.safePut(hashmap2, "session_last_at", (new StringBuilder()).append(aK).toString(), true);
        TapjoyUtil.safePut(hashmap2, "session_last_length", (new StringBuilder()).append(aL).toString(), true);
        TapjoyUtil.safePut(hashmap2, "purchase_currency", (new StringBuilder()).append(aM).toString(), true);
        TapjoyUtil.safePut(hashmap2, "purchase_total_count", (new StringBuilder()).append(aN).toString(), true);
        TapjoyUtil.safePut(hashmap2, "purchase_total_price", (new StringBuilder()).append(aO).toString(), true);
        TapjoyUtil.safePut(hashmap2, "purchase_last_price", (new StringBuilder()).append(aP).toString(), true);
        TapjoyUtil.safePut(hashmap2, "purchase_last_at", (new StringBuilder()).append(aQ).toString(), true);
        hashmap1.putAll(hashmap2);
        hashmap.putAll(hashmap1);
        return hashmap;
    }

    private static boolean f(String s1)
    {
        for (Iterator iterator = ak.getInstalledApplications(0).iterator(); iterator.hasNext();)
        {
            if (((ApplicationInfo)iterator.next()).packageName.startsWith(s1))
            {
                return true;
            }
        }

        return false;
    }

    private static void g()
    {
        com.tapjoy.internal.gt.n n1 = gd.a(g).b(true);
        aq = n1.f().h();
        ar = n1.f().B();
        as = n1.f().D();
        aR = n1.f().r();
        aS = n1.f().t();
        aT = n1.f().v();
        aU = n1.f().H();
        aV = n1.f().z();
        at = n1.h().f();
        au = n1.h().h();
        av = n1.h().j();
        aw = n1.h().l();
        aW = n1.h().n();
        ax = n1.j().f();
        ay = n1.j().h();
        az = n1.j().N();
        aA = n1.j().P();
        aB = n1.j().R();
        aC = n1.j().T();
        aD = n1.j().V();
        aE = n1.j().X();
        aF = n1.j().Z();
        aG = n1.j().j();
        aH = n1.j().l();
        aI = n1.j().p();
        aJ = n1.j().r();
        aK = n1.j().t();
        aL = n1.j().v();
        aM = n1.j().x();
        aN = n1.j().z();
        aO = n1.j().B();
        aP = n1.j().F();
        aQ = n1.j().D();
    }

    private static boolean g(String s1)
    {
        Object obj = new Intent("android.intent.action.SEND");
        ((Intent) (obj)).setType("text/plain");
        for (obj = ak.queryIntentActivities(((Intent) (obj)), 0).iterator(); ((Iterator) (obj)).hasNext();)
        {
            if (((ResolveInfo)((Iterator) (obj)).next()).activityInfo.packageName.startsWith(s1))
            {
                return true;
            }
        }

        return false;
    }

    public static String getAndroidID()
    {
        return n;
    }

    public static String getAppID()
    {
        return x;
    }

    public static String getAwardCurrencyVerifier(long l1, int i1, String s1)
    {
        try
        {
            s1 = TapjoyUtil.SHA256((new StringBuilder()).append(x).append(":").append(o()).append(":").append(l1).append(":").append(O).append(":").append(i1).append(":").append(s1).toString());
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            TapjoyLog.e("TapjoyConnect", (new StringBuilder("getAwardCurrencyVerifier ERROR: ")).append(s1.toString()).toString());
            return "";
        }
        return s1;
    }

    public static String getCarrierName()
    {
        return H;
    }

    public static String getConnectFlagValue(String s1)
    {
        String s3 = "";
        String s2 = s3;
        if (an != null)
        {
            s2 = s3;
            if (an.get(s1) != null)
            {
                s2 = an.get(s1).toString();
            }
        }
        return s2;
    }

    public static String getConnectURL()
    {
        return "https://connect.tapjoy.com/";
    }

    public static String getConnectionSubType()
    {
        Object obj = (ConnectivityManager)g.getSystemService("connectivity");
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_86;
        }
        obj = ((ConnectivityManager) (obj)).getActiveNetworkInfo().getSubtypeName();
        TapjoyLog.i("TapjoyConnect", (new StringBuilder("connection_sub_type: ")).append(((String) (obj))).toString());
        return ((String) (obj));
        Exception exception;
        exception;
        obj = "";
_L2:
        TapjoyLog.e("TapjoyConnect", (new StringBuilder("getConnectionSubType error: ")).append(exception.toString()).toString());
        return ((String) (obj));
        exception;
        if (true) goto _L2; else goto _L1
_L1:
        return "";
    }

    public static String getConnectionType()
    {
        Object obj;
        Object obj2;
        obj = "";
        Object obj1 = obj;
        ConnectivityManager connectivitymanager;
        try
        {
            connectivitymanager = (ConnectivityManager)g.getSystemService("connectivity");
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            TapjoyLog.e("TapjoyConnect", (new StringBuilder("getConnectionType error: ")).append(((Exception) (obj)).toString()).toString());
            return ((String) (obj1));
        }
        obj2 = obj;
        if (connectivitymanager == null) goto _L2; else goto _L1
_L1:
        obj1 = obj;
        obj2 = obj;
        if (connectivitymanager.getActiveNetworkInfo() == null) goto _L2; else goto _L3
_L3:
        obj1 = obj;
        connectivitymanager.getActiveNetworkInfo().getType();
        JVM INSTR lookupswitch 2: default 169
    //                   1: 133
    //                   6: 133;
           goto _L4 _L5 _L5
_L6:
        obj1 = obj;
        TapjoyLog.i("TapjoyConnect", (new StringBuilder("connectivity: ")).append(connectivitymanager.getActiveNetworkInfo().getType()).toString());
        obj1 = obj;
        TapjoyLog.i("TapjoyConnect", (new StringBuilder("connection_type: ")).append(((String) (obj))).toString());
        obj2 = obj;
        break; /* Loop/switch isn't completed */
_L5:
        obj = "wifi";
        continue; /* Loop/switch isn't completed */
_L4:
        obj = "mobile";
        if (true) goto _L6; else goto _L2
_L2:
        return ((String) (obj2));
    }

    public static Context getContext()
    {
        return g;
    }

    public static String getDeviceID()
    {
        return q;
    }

    public static float getDeviceScreenDensityScale()
    {
        return C;
    }

    public static Map getGenericURLParams()
    {
        Map map = f();
        TapjoyUtil.safePut(map, "app_id", x, true);
        return map;
    }

    public static String getHostURL()
    {
        return getConnectFlagValue("TJC_OPTION_SERVICE_URL");
    }

    public static TapjoyConnectCore getInstance()
    {
        return i;
    }

    public static String getMacAddress()
    {
        return r;
    }

    public static Map getOfflineLogs()
    {
        return g.getSharedPreferences("tapjoyOfflineLog", 0).getAll();
    }

    public static String getPlacementURL()
    {
        return getConnectFlagValue("TJC_OPTION_PLACEMENT_SERVICE_URL");
    }

    public static String getRedirectDomain()
    {
        return S;
    }

    public static String getSecretKey()
    {
        return O;
    }

    public static String getSha1MacAddress()
    {
        String s1;
        try
        {
            s1 = TapjoyUtil.SHA1(r);
        }
        catch (Exception exception)
        {
            TapjoyLog.e("TapjoyConnect", (new StringBuilder("Error generating sha1 of macAddress: ")).append(exception.toString()).toString());
            return null;
        }
        return s1;
    }

    public static Map getTimeStampAndVerifierParams()
    {
        long l1 = System.currentTimeMillis() / 1000L;
        String s1 = a(l1);
        HashMap hashmap = new HashMap();
        TapjoyUtil.safePut(hashmap, "timestamp", String.valueOf(l1), true);
        TapjoyUtil.safePut(hashmap, "verifier", s1, true);
        return hashmap;
    }

    public static Map getURLParams()
    {
        Map map = getGenericURLParams();
        map.putAll(getTimeStampAndVerifierParams());
        return map;
    }

    public static String getUserID()
    {
        return E;
    }

    private static void h()
    {
        TapjoyLog.i("TapjoyConnect", "Connect Flags:");
        TapjoyLog.i("TapjoyConnect", "--------------------");
        java.util.Map.Entry entry;
        for (Iterator iterator = an.entrySet().iterator(); iterator.hasNext(); TapjoyLog.i("TapjoyConnect", (new StringBuilder("key: ")).append((String)entry.getKey()).append(", value: ").append(Uri.encode(entry.getValue().toString())).toString()))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

        TapjoyLog.i("TapjoyConnect", (new StringBuilder("hostURL: [")).append(getConnectFlagValue("TJC_OPTION_SERVICE_URL")).append("]").toString());
        TapjoyLog.i("TapjoyConnect", (new StringBuilder("redirectDomain: [")).append(S).append("]").toString());
        TapjoyLog.i("TapjoyConnect", "--------------------");
    }

    private static boolean h(String s1)
    {
        return ak.checkPermission(s1, g.getPackageName()) == 0;
    }

    private static void i()
    {
        if (ak == null) goto _L2; else goto _L1
_L1:
        ApplicationInfo applicationinfo = ak.getApplicationInfo(g.getPackageName(), 128);
        if (applicationinfo == null) goto _L4; else goto _L3
_L3:
        if (applicationinfo.metaData == null) goto _L4; else goto _L5
_L5:
        String as1[];
        int j1;
        as1 = TapjoyConnectFlag.FLAG_ARRAY;
        j1 = as1.length;
        int i1 = 0;
_L10:
        if (i1 >= j1) goto _L7; else goto _L6
_L6:
        String s1 = as1[i1];
        String s2 = applicationinfo.metaData.getString((new StringBuilder("tapjoy.")).append(s1).toString());
        if (s2 == null) goto _L9; else goto _L8
_L8:
        TapjoyLog.i("TapjoyConnect", (new StringBuilder("Found manifest flag: ")).append(s1).append(", ").append(s2).toString());
        b(s1, s2);
          goto _L9
_L4:
        TapjoyLog.i("TapjoyConnect", "No metadata present.");
        return;
_L7:
        try
        {
            TapjoyLog.i("TapjoyConnect", "Metadata successfully loaded");
            return;
        }
        catch (Exception exception)
        {
            TapjoyLog.e("TapjoyConnect", (new StringBuilder("Error reading manifest meta-data: ")).append(exception.toString()).toString());
        }
        return;
_L9:
        i1++;
        if (true) goto _L10; else goto _L2
_L2:
    }

    public static boolean isAutoSessionTrackingStarted()
    {
        return aX;
    }

    public static boolean isConnected()
    {
        return aj;
    }

    public static boolean isUnitTestMode()
    {
        return getConnectFlagValue("unit_test_mode") == "true";
    }

    public static boolean isViewOpen()
    {
        return ap;
    }

    private void j()
    {
        ActivityInfo activityinfo;
        Vector vector;
        int i1;
        Object obj;
        ClassNotFoundException classnotfoundexception;
        try
        {
            obj = Arrays.asList(ak.getPackageInfo(g.getPackageName(), 1).activities);
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            throw new TapjoyIntegrationException("NameNotFoundException: Could not find package.");
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_430;
        }
        obj = ((List) (obj)).iterator();
_L2:
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break MISSING_BLOCK_LABEL_430;
            }
            activityinfo = (ActivityInfo)((Iterator) (obj)).next();
        } while (!m.contains(activityinfo.name));
        i1 = m.indexOf(activityinfo.name);
        Class.forName((String)m.get(i1));
        vector = new Vector();
        if ((activityinfo.configChanges & 0x80) != 128)
        {
            vector.add("orientation");
        }
        if ((activityinfo.configChanges & 0x20) != 32)
        {
            vector.add("keyboardHidden");
        }
        if (vector.size() == 0)
        {
            break MISSING_BLOCK_LABEL_293;
        }
        if (vector.size() == 1)
        {
            throw new TapjoyIntegrationException((new StringBuilder()).append(vector.toString()).append(" property is not specified in manifest configChanges for ").append((String)m.get(i1)).toString());
        }
          goto _L1
        classnotfoundexception;
        throw new TapjoyIntegrationException((new StringBuilder("[ClassNotFoundException] Could not find dependency class ")).append((String)m.get(i1)).toString());
_L1:
        throw new TapjoyIntegrationException((new StringBuilder()).append(vector.toString()).append(" properties are not specified in manifest configChanges for ").append((String)m.get(i1)).toString());
        if (android.os.Build.VERSION.SDK_INT >= 13 && (activityinfo.configChanges & 0x400) != 1024)
        {
            TapjoyLog.w("TapjoyConnect", (new StringBuilder("WARNING -- screenSize property is not specified in manifest configChanges for ")).append((String)m.get(i1)).toString());
        }
        if (android.os.Build.VERSION.SDK_INT >= 11 && activityinfo.name.equals("com.tapjoy.TJAdUnitView") && (activityinfo.flags & 0x200) != 512)
        {
            throw new TapjoyIntegrationException((new StringBuilder("'hardwareAccelerated' property not specified in manifest for ")).append((String)m.get(i1)).toString());
        }
        m.remove(i1);
          goto _L2
        if (m.size() != 0)
        {
            if (m.size() == 1)
            {
                throw new TapjoyIntegrationException((new StringBuilder("Missing ")).append(m.size()).append(" dependency class in manifest: ").append(m.toString()).toString());
            } else
            {
                throw new TapjoyIntegrationException((new StringBuilder("Missing ")).append(m.size()).append(" dependency classes in manifest: ").append(m.toString()).toString());
            }
        }
        k();
        Object obj1;
        String s1;
        try
        {
            obj1 = Class.forName("com.tapjoy.TJAdUnitJSBridge");
        }
        catch (ClassNotFoundException classnotfoundexception1)
        {
            throw new TapjoyIntegrationException("ClassNotFoundException: com.tapjoy.TJAdUnitJSBridge was not found.");
        }
        try
        {
            ((Class) (obj1)).getMethod("closeRequested", new Class[0]);
        }
        catch (NoSuchMethodException nosuchmethodexception)
        {
            throw new TapjoyIntegrationException("Try configuring Proguard or other code obfuscators to ignore com.tapjoy classes. Visit http://dev.tapjoy.comfor more information.");
        }
        s1 = (String)TapjoyUtil.getResource("mraid.js");
        obj1 = s1;
        if (s1 == null)
        {
            obj1 = TapjoyUtil.copyTextFromJarIntoString("js/mraid.js", g);
        }
        if (obj1 == null)
        {
            throw new TapjoyIntegrationException("ClassNotFoundException: mraid.js was not found.");
        }
        if (getConnectFlagValue("TJC_OPTION_DISABLE_ADVERTISING_ID_CHECK") != null && getConnectFlagValue("TJC_OPTION_DISABLE_ADVERTISING_ID_CHECK").equals("true"))
        {
            TapjoyLog.i("TapjoyConnect", "Skipping integration check for Google Play Services and Advertising ID. Do this only if you do not have access to Google Play Services.");
            return;
        } else
        {
            am.checkGooglePlayIntegration();
            return;
        }
    }

    private static void k()
    {
        Vector vector;
label0:
        {
            boolean flag = false;
            vector = new Vector();
            String as1[] = TapjoyConstants.dependencyPermissions;
            int k1 = as1.length;
            for (int i1 = 0; i1 < k1; i1++)
            {
                String s1 = as1[i1];
                if (!h(s1))
                {
                    vector.add(s1);
                }
            }

            if (vector.size() != 0)
            {
                if (vector.size() == 1)
                {
                    throw new TapjoyIntegrationException((new StringBuilder("Missing 1 permission in manifest: ")).append(vector.toString()).toString());
                } else
                {
                    throw new TapjoyIntegrationException((new StringBuilder("Missing ")).append(vector.size()).append(" permissions in manifest: ").append(vector.toString()).toString());
                }
            }
            vector = new Vector();
            as1 = TapjoyConstants.optionalPermissions;
            k1 = as1.length;
            for (int j1 = ((flag) ? 1 : 0); j1 < k1; j1++)
            {
                String s2 = as1[j1];
                if (!h(s2))
                {
                    vector.add(s2);
                }
            }

            if (vector.size() != 0)
            {
                if (vector.size() != 1)
                {
                    break label0;
                }
                TapjoyLog.w("TapjoyConnect", (new StringBuilder("WARNING -- ")).append(vector.toString()).append(" permission was not found in manifest. The exclusion of this permission could cause problems.").toString());
            }
            return;
        }
        TapjoyLog.w("TapjoyConnect", (new StringBuilder("WARNING -- ")).append(vector.toString()).append(" permissions were not found in manifest. The exclusion of these permissions could cause problems.").toString());
    }

    private static boolean l()
    {
        return c != null && c.length() > 0;
    }

    private static boolean m()
    {
        return l() && getConnectFlagValue("TJC_OPTION_DISABLE_PERSISTENT_IDS") != null && getConnectFlagValue("TJC_OPTION_DISABLE_PERSISTENT_IDS").equals("true");
    }

    private static String n()
    {
        TapjoyLog.i("TapjoyConnect", "generating sessionID...");
        String s1 = TapjoyUtil.SHA256((new StringBuilder()).append(System.currentTimeMillis() / 1000L).append(x).append(q).toString());
        ah = System.currentTimeMillis();
        return s1;
        Exception exception;
        exception;
        s1 = null;
_L2:
        TapjoyLog.e("TapjoyConnect", (new StringBuilder("unable to generate session id: ")).append(exception.toString()).toString());
        return s1;
        exception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private static String o()
    {
        boolean flag1 = true;
        if (m())
        {
            return c;
        }
        boolean flag;
        if (q != null && q.length() > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            return q;
        }
        if (r != null && r.length() > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            return r;
        }
        if (l())
        {
            return c;
        }
        if (n != null && n.length() > 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            return n;
        } else
        {
            Log.e("TapjoyConnect", "Error -- no valid device identifier");
            return null;
        }
    }

    public static void removeOfflineLog(String s1)
    {
        android.content.SharedPreferences.Editor editor = g.getSharedPreferences("tapjoyOfflineLog", 0).edit();
        editor.remove(s1);
        editor.commit();
    }

    public static void requestTapjoyConnect(Context context, String s1)
    {
        requestTapjoyConnect(context, s1, null, null);
    }

    public static void requestTapjoyConnect(Context context, String s1, Hashtable hashtable)
    {
        requestTapjoyConnect(context, s1, hashtable, null);
    }

    public static void requestTapjoyConnect(Context context, String s1, Hashtable hashtable, TJConnectListener tjconnectlistener)
    {
        ApiKeyDecoded apikeydecoded;
        try
        {
            apikeydecoded = new ApiKeyDecoded(s1);
            if (apikeydecoded.getKeyUsage() != com.tapjoy.internal.ApiKeyDecoded.KeyUsage.SDK_ANDROID)
            {
                throw new IllegalArgumentException("The given API key was not for Android.");
            }
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new TapjoyIntegrationException(context.getMessage());
        }
        h = s1;
        x = apikeydecoded.getAppId();
        O = apikeydecoded.getSecretKey();
        P = apikeydecoded.getAnalyticsId();
        gd.a(context).a(s1);
        if (hashtable != null)
        {
            an.putAll(hashtable);
        }
        k = tjconnectlistener;
        i = new TapjoyConnectCore(context);
    }

    public static void saveOfflineLog(String s1)
    {
        SharedPreferences sharedpreferences = g.getSharedPreferences("tapjoyOfflineLog", 0);
        android.content.SharedPreferences.Editor editor = sharedpreferences.edit();
        if (getOfflineLogs().size() >= 50)
        {
            editor.remove((String)(new TreeMap(sharedpreferences.getAll())).firstKey());
            editor.commit();
        }
        s1 = (new StringBuilder()).append(s1).append("&original_timestamp=").append(System.currentTimeMillis() / 1000L).toString();
        s1 = (new StringBuilder()).append(s1).append("&offline=true").toString();
        editor.putString(Long.toString(System.currentTimeMillis()), s1);
        editor.commit();
    }

    public static void sendOfflineLogs()
    {
        (new Thread(new Runnable() {

            public final void run()
            {
                TapjoyURLConnection tapjoyurlconnection = new TapjoyURLConnection();
                Iterator iterator = TapjoyConnectCore.getOfflineLogs().entrySet().iterator();
                while (iterator.hasNext()) 
                {
                    java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                    try
                    {
                        TapjoyLog.i("TapjoyConnect", (new StringBuilder("sending offline log: ")).append(entry.getValue()).toString());
                        tapjoyurlconnection.getResponseFromURL((new StringBuilder()).append((String)entry.getValue()).append("&").append(TapjoyUtil.convertURLParams(TapjoyConnectCore.getTimeStampAndVerifierParams(), false)).toString(), "");
                    }
                    catch (Exception exception)
                    {
                        TapjoyLog.i("TapjoyConnect", "error sending offline log");
                    }
                    TapjoyConnectCore.removeOfflineLog((String)entry.getKey());
                }
            }

        })).start();
    }

    public static void setAutoSessionTrackingStarted(boolean flag)
    {
        aX = flag;
    }

    public static void setPlugin(String s1)
    {
        Q = s1;
    }

    public static void setSDKType(String s1)
    {
        R = s1;
    }

    public static void setUserID(String s1)
    {
        E = s1;
        TapjoyLog.i("TapjoyConnect", (new StringBuilder("URL parameters: ")).append(getURLParams()).toString());
        (new Thread(new Runnable() {

            public final void run()
            {
                TapjoyLog.i("TapjoyConnect", "setUserID...");
                TapjoyHttpURLResponse tapjoyhttpurlresponse = TapjoyConnectCore.d().getResponseFromURL((new StringBuilder()).append(TapjoyConnectCore.getHostURL()).append("set_publisher_user_id?").toString(), TapjoyConnectCore.getURLParams());
                if (tapjoyhttpurlresponse.response != null)
                {
                    TapjoyConnectCore.b(tapjoyhttpurlresponse.response);
                    TapjoyLog.i("TapjoyConnect", "setUserID successful...");
                }
            }

        })).start();
    }

    public static void setViewShowing(boolean flag)
    {
        ap = flag;
    }

    public static void viewDidClose(int i1)
    {
        ap = false;
        if (l != null)
        {
            l.onViewDidClose(i1);
        }
    }

    public static void viewDidOpen(int i1)
    {
        if (l != null)
        {
            l.onViewDidOpen(i1);
        }
    }

    public static void viewWillClose(int i1)
    {
        if (l != null)
        {
            l.onViewWillClose(i1);
        }
    }

    public static void viewWillOpen(int i1)
    {
        ap = true;
        if (l != null)
        {
            l.onViewWillOpen(i1);
        }
    }

    public void actionComplete(String s1)
    {
        TapjoyLog.i("TapjoyConnect", (new StringBuilder("actionComplete: ")).append(s1).toString());
        Map map = f();
        TapjoyUtil.safePut(map, "app_id", s1, true);
        map.putAll(getTimeStampAndVerifierParams());
        TapjoyLog.i("TapjoyConnect", (new StringBuilder("PPA URL parameters: ")).append(map).toString());
        (new Thread(new PPAThread(map))).start();
    }

    public void appPause()
    {
        ag = true;
    }

    public void appResume()
    {
        if (ag)
        {
            n();
            ag = false;
        }
    }

    public void callConnect()
    {
        fetchAdvertisingID();
    }

    public void completeConnectCall()
    {
        TapjoyLog.i("TapjoyConnect", "starting connect call...");
        Object obj = "https://connect.tapjoy.com/";
        if (getHostURL() != "https://ws.tapjoyads.com/")
        {
            obj = getHostURL();
        }
        obj = j.getResponseFromURL((new StringBuilder()).append(((String) (obj))).append("api/connect/v3.json?").toString(), null, null, getURLParams());
        if (obj != null && ((TapjoyHttpURLResponse) (obj)).statusCode == 200)
        {
            if (d(((TapjoyHttpURLResponse) (obj)).response))
            {
                TapjoyLog.i("TapjoyConnect", "Successfully connected to Tapjoy");
                Iterator iterator;
                java.util.Map.Entry entry;
                if (aY)
                {
                    if (android.os.Build.VERSION.SDK_INT > 8)
                    {
                        try
                        {
                            doProfileAsync();
                        }
                        catch (Exception exception)
                        {
                            TapjoyLog.w("TapjoyConnect", (new StringBuilder("Error building Threatmetrix profile: ")).append(exception.toString()).toString());
                        }
                    }
                } else
                {
                    TapjoyLog.i("TapjoyConnect", "TM disabled");
                }
                for (iterator = getGenericURLParams().entrySet().iterator(); iterator.hasNext(); TapjoyLog.i("TapjoyConnect", (new StringBuilder()).append((String)entry.getKey()).append(": ").append((String)entry.getValue()).toString()))
                {
                    entry = (java.util.Map.Entry)iterator.next();
                }

                sendOfflineLogs();
                aj = true;
                if (k != null)
                {
                    k.onConnectSuccess();
                }
            } else
            {
                e();
            }
            if (ao.length() > 0)
            {
                Object obj1 = getGenericURLParams();
                TapjoyUtil.safePut(((Map) (obj1)), "package_names", ao, true);
                long l1 = System.currentTimeMillis() / 1000L;
                String s1 = a(l1, ao);
                TapjoyUtil.safePut(((Map) (obj1)), "timestamp", String.valueOf(l1), true);
                TapjoyUtil.safePut(((Map) (obj1)), "verifier", s1, true);
                obj1 = (new TapjoyURLConnection()).getResponseFromURL((new StringBuilder()).append(getHostURL()).append("apps_installed?").toString(), ((Map) (obj1)));
                if (obj1 != null && ((TapjoyHttpURLResponse) (obj1)).statusCode == 200)
                {
                    TapjoyLog.i("TapjoyConnect", "Successfully pinged sdkless api.");
                }
            }
            return;
        } else
        {
            e();
            return;
        }
    }

    public void doProfileAsync()
    {
        TapjoyLog.i("TapjoyConnect", "Initializing Threatmetrix: 2.5-16");
        al = new fk();
        try
        {
            al.a(new ey() {

                final TapjoyConnectCore a;

                public final void a()
                {
                    if (TapjoyConnectCore.a(a).c() != com.tapjoy.internal.fk.c.b) goto _L2; else goto _L1
_L1:
                    TapjoyConnectCore.a(TapjoyConnectCore.a(a).b());
_L4:
                    TapjoyConnectCore.a(a).d();
                    return;
_L2:
                    TapjoyLog.w("TapjoyConnect", "No Threatmetrix session ID");
                    if (true) goto _L4; else goto _L3
_L3:
                    Object obj;
                    obj;
                    TapjoyLog.w("TapjoyConnect", (new StringBuilder("Error retrieving Threatmetrix session ID: ")).append(((Exception) (obj)).toString()).toString());
                    TapjoyConnectCore.a(a).d();
                    return;
                    obj;
                    TapjoyConnectCore.a(a).d();
                    throw obj;
                }

            
            {
                a = TapjoyConnectCore.this;
                super();
            }
            });
        }
        catch (InterruptedException interruptedexception)
        {
            interruptedexception.printStackTrace();
        }
        al.a();
        al.a(g, "rrx68giz", "h.online-metrix.net", "http://content-js.tapjoy.com");
    }

    public void enablePaidAppWithActionID(String s1)
    {
        TapjoyLog.i("TapjoyConnect", (new StringBuilder("enablePaidAppWithActionID: ")).append(s1).toString());
        ad = s1;
        ae = g.getSharedPreferences("tjcPrefrences", 0).getLong("tapjoy_elapsed_time", 0L);
        TapjoyLog.i("TapjoyConnect", (new StringBuilder("paidApp elapsed: ")).append(ae).toString());
        if (ae >= 0xdbba0L)
        {
            if (ad != null && ad.length() > 0)
            {
                TapjoyLog.i("TapjoyConnect", "Calling PPA actionComplete...");
                actionComplete(ad);
            }
        } else
        if (af == null)
        {
            af = new Timer();
            af.schedule(new a((byte)0), 10000L, 10000L);
            return;
        }
    }

    public void fetchAdvertisingID()
    {
        (new Thread(new Runnable() {

            final TapjoyConnectCore a;

            public final void run()
            {
                TapjoyConnectCore.b(a).loadAdvertisingId();
                if (TapjoyConnectCore.b(a).isGooglePlayServicesAvailable() && TapjoyConnectCore.b(a).isGooglePlayManifestConfigured())
                {
                    TapjoyConnectCore.b = TapjoyConnectCore.b(a).getDeviceGooglePlayServicesVersion();
                    TapjoyConnectCore.a = TapjoyConnectCore.b(a).getPackagedGooglePlayServicesVersion();
                }
                if (TapjoyConnectCore.b(a).isAdIdAvailable())
                {
                    TapjoyConnectCore.d = TapjoyConnectCore.b(a).isAdTrackingEnabled();
                    TapjoyConnectCore.c = TapjoyConnectCore.b(a).getAdvertisingId();
                }
                if (TapjoyConnectCore.a())
                {
                    TapjoyLog.i("TapjoyConnect", "Disabling persistent IDs. Do this only if you are not using Tapjoy to manage currency.");
                }
                a.completeConnectCall();
            }

            
            {
                a = TapjoyConnectCore.this;
                super();
            }
        })).start();
    }

    public float getCurrencyMultiplier()
    {
        return T;
    }

    public String getSerial()
    {
        Object obj;
        obj = Class.forName("android.os.Build").getDeclaredField("SERIAL");
        if (!((Field) (obj)).isAccessible())
        {
            ((Field) (obj)).setAccessible(true);
        }
        obj = ((Field) (obj)).get(android/os/Build).toString();
        TapjoyLog.i("TapjoyConnect", (new StringBuilder("serial: ")).append(((String) (obj))).toString());
        return ((String) (obj));
        Exception exception;
        exception;
        obj = null;
_L2:
        TapjoyLog.e("TapjoyConnect", exception.toString());
        return ((String) (obj));
        exception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public boolean isInitialized()
    {
        return ai;
    }

    public void release()
    {
        i = null;
        j = null;
        TapjoyLog.i("TapjoyConnect", "Releasing core static instance.");
    }

    public void setCurrencyMultiplier(float f1)
    {
        TapjoyLog.i("TapjoyConnect", (new StringBuilder("setVirtualCurrencyMultiplier: ")).append(f1).toString());
        T = f1;
    }

    public void setTapjoyViewListener(TJViewListener tjviewlistener)
    {
        l = tjviewlistener;
    }

    static 
    {
        m = new Vector(Arrays.asList(TapjoyConstants.dependencyClassNames));
        B = 1;
        C = 1.0F;
        D = 1;
        F = false;
        an = TapjoyConnectFlag.CONNECT_FLAG_DEFAULTS;
    }
}
