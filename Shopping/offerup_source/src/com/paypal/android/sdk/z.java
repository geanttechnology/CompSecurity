// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.Timer;
import java.util.UUID;
import org.json.JSONObject;

// Referenced classes of package com.paypal.android.sdk:
//            x, ax, v, ae, 
//            aa, y, al, ap, 
//            af, ah, aw, av, 
//            u, ag, aj, am, 
//            ad

public class z
    implements LocationListener
{

    public static aj a = null;
    private static final String b = com/paypal/android/sdk/z.getSimpleName();
    private static final Object x = new Object();
    private static z y;
    private Context c;
    private String d;
    private long e;
    private long f;
    private int g;
    private int h;
    private long i;
    private String j;
    private v k;
    private y l;
    private y m;
    private String n;
    private Map o;
    private Location p;
    private Timer q;
    private Handler r;
    private af s;
    private String t;
    private String u;
    private boolean v;
    private String w;

    private z()
    {
    }

    static int a(z z1)
    {
        int i1 = z1.g;
        z1.g = i1 + 1;
        return i1;
    }

    private static long a(Context context)
    {
        if (context != null) goto _L2; else goto _L1
_L1:
        return 0L;
_L2:
        long l1;
        try
        {
            if (android.os.Build.VERSION.SDK_INT > 8)
            {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).firstInstallTime;
            }
            context = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).sourceDir;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return 0L;
        }
        if (context == null) goto _L1; else goto _L3
_L3:
        l1 = (new File(context)).lastModified();
        return l1;
    }

    public static z a()
    {
        z z1;
        synchronized (x)
        {
            if (y == null)
            {
                y = new z();
            }
            z1 = y;
        }
        return z1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private static String a(TelephonyManager telephonymanager)
    {
        try
        {
            telephonymanager = telephonymanager.getSimOperatorName();
        }
        // Misplaced declaration of an exception variable
        catch (TelephonyManager telephonymanager)
        {
            ax.a();
            return null;
        }
        return telephonymanager;
    }

    private void a(v v1)
    {
        k = v1;
        ax.b();
        (new StringBuilder("URL:     ")).append(k.a());
        ax.b();
        (new StringBuilder("Version: ")).append(k.b());
        ax.b();
        j();
        q = new Timer();
        long l1 = k.c();
        long l2 = k.d();
        long l3 = k.e();
        (new StringBuilder("Sending logRiskMetadata every ")).append(l1).append(" seconds.");
        ax.b();
        (new StringBuilder("sessionTimeout set to ")).append(l2).append(" seconds.");
        ax.b();
        (new StringBuilder("compTimeout set to    ")).append(l3).append(" seconds.");
        ax.b();
        e = l1 * 1000L;
        f = l3 * 1000L;
        ae.a(l2 * 1000L);
        if (k != null && v)
        {
            j();
            q = new Timer();
            ax.b();
            q.scheduleAtFixedRate(new aa(this), 0L, e);
        }
    }

    private void a(y y1, y y2)
    {
        boolean flag1 = true;
        if (y1 != null)
        {
            y1.ae = new HashMap(o);
            if (y2 != null)
            {
                y1 = y1.a(y2);
            } else
            {
                y1 = y1.a();
            }
            y2 = new HashMap();
            y2.put("appGuid", d);
            y2.put("libraryVersion", c());
            y2.put("additionalData", y1.toString());
            (new StringBuilder("Dyson Risk Data ")).append(y1.toString());
            ax.b();
            if (k != null)
            {
                y1 = k.g();
                boolean flag2 = k.h();
                (new StringBuilder("new LogRiskMetadataRequest to: ")).append(y1);
                ax.b();
                Object obj = (new StringBuilder("endpointIsStage: ")).append(flag2).append(" (using SSL: ");
                boolean flag;
                if (!flag2)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                ((StringBuilder) (obj)).append(flag).append(")");
                ax.b();
                obj = r;
                if (!flag2)
                {
                    flag = flag1;
                } else
                {
                    flag = false;
                }
                y1 = new al(y1, y2, ((Handler) (obj)), flag);
                ap.a().a(y1);
                return;
            }
        }
    }

    static int b(z z1)
    {
        return z1.g;
    }

    private static long b(Context context)
    {
        if (context != null) goto _L2; else goto _L1
_L1:
        return 0L;
_L2:
        long l1;
        try
        {
            if (android.os.Build.VERSION.SDK_INT > 8)
            {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).lastUpdateTime;
            }
            context = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).sourceDir;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return 0L;
        }
        if (context == null) goto _L1; else goto _L3
_L3:
        l1 = (new File(context)).lastModified();
        return l1;
    }

    public static String c()
    {
        return String.format(Locale.US, "Dyson/%S (%S %S)", new Object[] {
            "3.4.4.release", "Android", android.os.Build.VERSION.RELEASE
        });
    }

    static boolean c(z z1)
    {
        return System.currentTimeMillis() - z1.i > z1.f;
    }

    static long d(z z1)
    {
        return z1.f;
    }

    static Timer e(z z1)
    {
        return z1.q;
    }

    static void f(z z1)
    {
        if (z1.m != null)
        {
            (new StringBuilder()).append(z1.n).append(" update not sent correctly, retrying...");
            ax.b();
            if ("full".equals(z1.n))
            {
                z1.a(z1.m, null);
                return;
            } else
            {
                y y1 = z1.k();
                z1.a(z1.m, y1);
                return;
            }
        }
        if (!ae.c() || z1.l == null)
        {
            ae.a();
            z1.n = "full";
            y y2 = z1.k();
            z1.a(y2, null);
            z1.m = y2;
            return;
        } else
        {
            z1.n = "incremental";
            y y3 = z1.k();
            z1.a(z1.l, y3);
            z1.m = y3;
            return;
        }
    }

    static int g(z z1)
    {
        int i1 = z1.h;
        z1.h = i1 + 1;
        return i1;
    }

    static String g()
    {
        return b;
    }

    static int h(z z1)
    {
        return z1.h;
    }

    private static String h()
    {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    static Context i(z z1)
    {
        return z1.c;
    }

    private String i()
    {
        StringBuilder stringbuilder = new StringBuilder("https://b.stats.paypal.com/counter.cgi?p=");
        if (s == null || s == af.a)
        {
            return "Beacon not recognize host app";
        }
        int i1 = s.a();
        if (u == null)
        {
            return "Beacon pairing id empty";
        }
        stringbuilder.append(u).append("&i=");
        Object obj = ax.d();
        if (((String) (obj)).equals(""))
        {
            try
            {
                stringbuilder.append(com.paypal.android.sdk.x.a("emptyIp")).append("&t=");
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ax.a();
            }
        } else
        {
            stringbuilder.append(((String) (obj))).append("&t=");
        }
        stringbuilder.append(String.valueOf(System.currentTimeMillis() / 1000L)).append("&a=").append(i1);
        (new StringBuilder("Beacon Request URL ")).append(stringbuilder.toString());
        ax.b();
        obj = new ah(stringbuilder.toString(), d, t, ax.a(c), r);
        ap.a().a(((ao) (obj)));
        return stringbuilder.toString();
    }

    static String j(z z1)
    {
        return z1.j;
    }

    private void j()
    {
        if (q != null)
        {
            q.cancel();
        }
    }

    static Handler k(z z1)
    {
        return z1.r;
    }

    private y k()
    {
        y y1;
        if (c == null)
        {
            return null;
        }
        y1 = new y();
        Object obj;
        Object obj1;
        av av1;
        TelephonyManager telephonymanager;
        av1 = k.i();
        telephonymanager = (TelephonyManager)c.getSystemService("phone");
        obj1 = (WifiManager)c.getSystemService("wifi");
        obj = (ConnectivityManager)c.getSystemService("connectivity");
        if (!ax.a(c, "android.permission.ACCESS_WIFI_STATE")) goto _L2; else goto _L1
_L1:
        Object obj2 = ((WifiManager) (obj1)).getConnectionInfo();
_L97:
        if (!ax.a(c, "android.permission.ACCESS_NETWORK_STATE")) goto _L4; else goto _L3
_L3:
        NetworkInfo networkinfo = ((ConnectivityManager) (obj)).getActiveNetworkInfo();
_L98:
        Date date;
        int i1;
        boolean flag;
        if (ax.a(c, "android.permission.ACCESS_COARSE_LOCATION") || ax.a(c, "android.permission.ACCESS_FINE_LOCATION"))
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        flag = ax.a(c, "android.permission.READ_PHONE_STATE");
        date = new Date();
        telephonymanager.getPhoneType();
        JVM INSTR tableswitch 0 2: default 1886
    //                   0 1660
    //                   1 1675
    //                   2 1706;
           goto _L5 _L6 _L7 _L8
_L5:
        y1.A = (new StringBuilder("unknown (")).append(telephonymanager.getPhoneType()).append(")").toString();
        obj1 = null;
        obj = null;
_L78:
        if (!av1.a(aw.w))
        {
            y1.A = null;
        }
        if (av1.a(aw.a))
        {
            y1.a = d;
        }
        if (av1.a(aw.O))
        {
            y1.U = u;
        }
        if (!av1.a(aw.M)) goto _L10; else goto _L9
_L9:
        if (s != null) goto _L12; else goto _L11
_L11:
        y1.Q = af.a.a();
_L10:
        if (av1.a(aw.N))
        {
            y1.R = t;
        }
        if (av1.a(aw.u))
        {
            y1.Z = w;
        }
        if (av1.a(aw.S))
        {
            y1.X = android.provider.Settings.Secure.getString(c.getContentResolver(), "android_id");
        }
        u u1 = ax.a(c);
        if (av1.a(aw.b))
        {
            y1.b = u1.a();
        }
        if (av1.a(aw.c))
        {
            y1.c = u1.b();
        }
        if (!av1.a(aw.d)) goto _L14; else goto _L13
_L13:
        if (obj1 != null) goto _L16; else goto _L15
_L15:
        i1 = -1;
_L85:
        y1.d = i1;
_L14:
        if (!av1.a(aw.I)) goto _L18; else goto _L17
_L17:
        if (obj1 != null) goto _L20; else goto _L19
_L19:
        i1 = -1;
_L86:
        y1.O = i1;
_L18:
        if (!av1.a(aw.J)) goto _L22; else goto _L21
_L21:
        if (obj1 != null) goto _L24; else goto _L23
_L23:
        i1 = -1;
_L87:
        y1.N = i1;
_L22:
        if (!av1.a(aw.e)) goto _L26; else goto _L25
_L25:
        if (obj2 != null) goto _L28; else goto _L27
_L27:
        obj1 = null;
_L88:
        y1.e = ((String) (obj1));
_L26:
        if (!av1.a(aw.f)) goto _L30; else goto _L29
_L29:
        if (obj != null) goto _L32; else goto _L31
_L31:
        i1 = -1;
_L89:
        y1.f = i1;
_L30:
        if (av1.a(aw.H))
        {
            y1.P = telephonymanager.getNetworkOperator();
        }
        y1.g = "3.4.4.release";
        y1.h = j;
        if (k != null) goto _L34; else goto _L33
_L33:
        obj1 = null;
_L90:
        y1.i = ((String) (obj1));
        if (!av1.a(aw.g)) goto _L36; else goto _L35
_L35:
        if (networkinfo != null) goto _L38; else goto _L37
_L37:
        obj1 = null;
_L91:
        y1.j = ((String) (obj1));
_L36:
        if (!av1.a(aw.h)) goto _L40; else goto _L39
_L39:
        if (!flag) goto _L42; else goto _L41
_L41:
        obj1 = telephonymanager.getDeviceId();
_L99:
        y1.k = ((String) (obj1));
_L40:
        if (av1.a(aw.i))
        {
            y1.l = Build.MODEL;
        }
        if (av1.a(aw.j))
        {
            y1.m = Build.DEVICE;
        }
        if (av1.a(aw.k))
        {
            y1.n = SystemClock.uptimeMillis();
        }
        if (av1.a(aw.l))
        {
            y1.o = ax.d();
        }
        if (av1.a(aw.l))
        {
            y1.p = ax.a(true);
        }
        if (!av1.a(aw.n)) goto _L44; else goto _L43
_L43:
        if (!flag) goto _L46; else goto _L45
_L45:
        obj1 = telephonymanager.getLine1Number();
_L100:
        y1.r = ((String) (obj1));
_L44:
        if (av1.a(aw.o))
        {
            y1.s = ax.c();
        }
        if (av1.a(aw.p))
        {
            y1.t = Locale.getDefault().getCountry();
        }
        if (av1.a(aw.q))
        {
            y1.u = Locale.getDefault().getLanguage();
        }
        if (!av1.a(aw.r)) goto _L48; else goto _L47
_L47:
        if (p != null) goto _L50; else goto _L49
_L49:
        obj1 = null;
_L92:
        y1.v = ((Location) (obj1));
_L48:
        if (!av1.a(aw.s)) goto _L52; else goto _L51
_L51:
        if (obj != null) goto _L54; else goto _L53
_L53:
        i1 = -1;
_L93:
        y1.w = i1;
_L52:
        if (!av1.a(aw.t)) goto _L56; else goto _L55
_L55:
        if (obj2 != null) goto _L58; else goto _L57
_L57:
        obj = null;
_L94:
        y1.x = ((String) (obj));
_L56:
        if (av1.a(aw.v))
        {
            y1.z = android.os.Build.VERSION.RELEASE;
        }
        if (av1.a(aw.x))
        {
            y1.B = ae.b();
        }
        if (av1.a(aw.y))
        {
            y1.C = Boolean.valueOf((new ServiceState()).getRoaming());
        }
        if (av1.a(aw.z))
        {
            y1.D = a(telephonymanager);
        }
        if (!av1.a(aw.R)) goto _L60; else goto _L59
_L59:
        if (!flag) goto _L62; else goto _L61
_L61:
        obj = telephonymanager.getSimSerialNumber();
_L101:
        y1.E = ((String) (obj));
_L60:
        if (android.os.Build.VERSION.SDK_INT >= 9)
        {
            y1.aa = Build.SERIAL;
        }
        if (av1.a(aw.A))
        {
            y1.F = Boolean.valueOf(c.getPackageManager().hasSystemFeature("android.hardware.telephony"));
        }
        if (!av1.a(aw.B)) goto _L64; else goto _L63
_L63:
        if (obj2 != null) goto _L66; else goto _L65
_L65:
        obj = null;
_L95:
        y1.G = ((String) (obj));
_L64:
        if (!av1.a(aw.C)) goto _L68; else goto _L67
_L67:
        if (!flag) goto _L70; else goto _L69
_L69:
        obj = telephonymanager.getSubscriberId();
_L96:
        y1.H = ((String) (obj));
_L68:
        if (av1.a(aw.D))
        {
            y1.I = System.currentTimeMillis();
        }
        if (av1.a(aw.E))
        {
            y1.J = ax.e();
        }
        if (av1.a(aw.F))
        {
            y1.K = TimeZone.getDefault().getDisplayName(TimeZone.getDefault().inDaylightTime(date), 1, Locale.ENGLISH);
        }
        if (av1.a(aw.W))
        {
            y1.L = Boolean.valueOf(TimeZone.getDefault().inDaylightTime(date));
        }
        if (av1.a(aw.X))
        {
            y1.M = Integer.valueOf(TimeZone.getDefault().getOffset(date.getTime()));
        }
        if (!av1.a(aw.K)) goto _L72; else goto _L71
_L71:
        if (!Build.BRAND.equalsIgnoreCase("generic") && !Build.PRODUCT.equals("sdk") && !Build.HARDWARE.equals("goldfish") && !Build.FINGERPRINT.startsWith("generic") && !Build.MANUFACTURER.equals("unknown") && !Build.PRODUCT.matches(".*_?sdk_?.*"))
        {
            flag = false;
        } else
        {
            flag = true;
        }
        y1.S = Boolean.valueOf(flag);
_L72:
        if (av1.a(aw.L))
        {
            y1.T = Boolean.valueOf(ag.a());
        }
        if (!av1.a(aw.m)) goto _L74; else goto _L73
_L73:
        obj = new ArrayList();
        if (k == null) goto _L76; else goto _L75
_L75:
        obj1 = k.f();
        obj1 = ((List) (obj1)).iterator();
        do
        {
            if (!((Iterator) (obj1)).hasNext())
            {
                break;
            }
            obj2 = (String)((Iterator) (obj1)).next();
            if (ax.a(c.getPackageManager(), (new Intent()).setComponent(ComponentName.unflattenFromString(((String) (obj2))))))
            {
                ((List) (obj)).add(obj2);
            }
        } while (true);
          goto _L76
        obj1;
        ax.a();
_L76:
        if (((List) (obj)).size() == 0)
        {
            obj = null;
        }
        y1.q = ((List) (obj));
_L74:
        if (av1.a(aw.P))
        {
            y1.V = a(c);
        }
        if (av1.a(aw.Q))
        {
            y1.W = b(c);
        }
        y1.ae = o;
        if (av1.a(aw.T))
        {
            y1.ab = ax.b(c);
        }
        if (av1.a(aw.U))
        {
            y1.ad = ax.g();
        }
        if (av1.a(aw.V))
        {
            y1.ac = ax.f();
        }
        if (av1.a(aw.G))
        {
            y1.Y = ax.a(c, y1);
        }
        if (!av1.a(aw.v))
        {
            y1.y = null;
        }
          goto _L77
_L6:
        y1.A = "none";
        obj1 = null;
        obj = null;
          goto _L78
_L7:
        y1.A = "gsm";
        if (i1 == 0) goto _L80; else goto _L79
_L79:
        obj = (GsmCellLocation)ax.a(telephonymanager.getCellLocation(), android/telephony/gsm/GsmCellLocation);
          goto _L81
_L8:
        y1.A = "cdma";
        if (i1 == 0) goto _L83; else goto _L82
_L82:
        obj = (CdmaCellLocation)ax.a(telephonymanager.getCellLocation(), android/telephony/cdma/CdmaCellLocation);
          goto _L84
_L12:
        y1.Q = s.a();
          goto _L10
        obj;
        throw obj;
_L16:
        i1 = ((CdmaCellLocation) (obj1)).getBaseStationId();
          goto _L85
_L20:
        i1 = ((CdmaCellLocation) (obj1)).getNetworkId();
          goto _L86
_L24:
        i1 = ((CdmaCellLocation) (obj1)).getSystemId();
          goto _L87
_L28:
        obj1 = ((WifiInfo) (obj2)).getBSSID();
          goto _L88
_L32:
        i1 = ((GsmCellLocation) (obj)).getCid();
          goto _L89
_L34:
        obj1 = k.b();
          goto _L90
_L38:
        obj1 = networkinfo.getTypeName();
          goto _L91
_L50:
        obj1 = new Location(p);
          goto _L92
        obj;
        ax.a();
          goto _L77
_L54:
        i1 = ((GsmCellLocation) (obj)).getLac();
          goto _L93
_L58:
        obj = ((WifiInfo) (obj2)).getMacAddress();
          goto _L94
_L66:
        obj = ((WifiInfo) (obj2)).getSSID();
          goto _L95
_L70:
        obj = null;
          goto _L96
_L77:
        return y1;
_L2:
        obj2 = null;
          goto _L97
_L4:
        networkinfo = null;
          goto _L98
_L81:
        obj1 = null;
          goto _L78
_L80:
        obj = null;
          goto _L81
_L84:
        Object obj3 = null;
        obj1 = obj;
        obj = obj3;
          goto _L78
_L83:
        obj = null;
          goto _L84
_L42:
        obj1 = null;
          goto _L99
_L46:
        obj1 = null;
          goto _L100
_L62:
        obj = null;
          goto _L101
    }

    public final String a(Context context, String s1, af af1, String s2, Map map)
    {
        String s3 = ax.a(map, "RISK_MANAGER_CONF_URL");
        v = ax.a(map, "RISK_MANAGER_IS_START_ASYNC_SERVICE", Boolean.FALSE);
        String s4 = ax.a(map, "RISK_MANAGER_PAIRING_ID");
        w = ax.a(map, "RISK_MANAGER_NOTIF_TOKEN");
        a = (aj)ax.a(map, com/paypal/android/sdk/aj, "RISK_MANAGER_NETWORK_ADAPTER", new am());
        boolean flag1 = ax.a(map, "RISK_MANAGER_IS_DISABLE_REMOTE_CONFIG", Boolean.valueOf(false));
        c = context;
        d = s1;
        boolean flag;
        if (af1 == null)
        {
            s = af.a;
        } else
        {
            s = af1;
        }
        t = s2;
        l = null;
        m = null;
        o = new HashMap();
        h = 0;
        g = 0;
        if (s4 == null || s4.trim().length() == 0)
        {
            u = h();
            flag = true;
        } else
        {
            ax.a(3, "PRD", "Using custom pairing id");
            u = s4.trim();
            context = u;
            if (context != null && context.trim().length() >= 10 && context.trim().length() <= 32)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag)
            {
                u = h();
                flag = false;
            } else
            {
                flag = true;
            }
        }
        if (s3 == null)
        {
            context = "https://www.paypalobjects.com/webstatic/risk/dyson_config_android_v3.json";
        } else
        {
            context = s3;
        }
        j = context;
        e();
        if (r != null)
        {
            break MISSING_BLOCK_LABEL_256;
        }
        r = new ad(this);
        context = (LocationManager)c.getSystemService("location");
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_256;
        }
        onLocationChanged(ax.a(context));
        if (context.isProviderEnabled("network"))
        {
            context.requestLocationUpdates("network", 0x36ee80L, 10F, this);
        }
        j();
_L1:
        i();
        if (!flag)
        {
            ax.a(6, "PRD", "Provided pairingID is invalid. Please provide a 10-32 char length string if needed.");
        }
        context = c;
        if (!flag1)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        a(new v(context, flag1));
        return u;
        context;
        ax.a();
          goto _L1
    }

    public final void a(Message message)
    {
        message.what;
        JVM INSTR lookupswitch 9: default 328
    //                   0: 115
    //                   1: 272
    //                   2: 177
    //                   10: 88
    //                   11: 268
    //                   12: 159
    //                   20: 137
    //                   21: 300
    //                   22: 246;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L1:
        break MISSING_BLOCK_LABEL_328;
_L5:
        (new StringBuilder("Load Configuration URL: ")).append(message.obj);
        ax.b();
        return;
_L2:
        try
        {
            (new StringBuilder("Dyson Async URL: ")).append(message.obj);
            ax.b();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Message message)
        {
            ax.a();
            return;
        }
_L8:
        (new StringBuilder("Beacon URL: ")).append(message.obj);
        ax.b();
        return;
_L7:
        message = (v)message.obj;
        if (message == null)
        {
            break MISSING_BLOCK_LABEL_328;
        }
        a(((v) (message)));
        return;
_L4:
        message = (String)message.obj;
        (new StringBuilder("LogRiskMetadataRequest Server returned: ")).append(message);
        ax.b();
        message = Uri.parse((new StringBuilder("?")).append(message).toString());
        try
        {
            message = message.getQueryParameter("responseEnvelope.ack");
        }
        // Misplaced declaration of an exception variable
        catch (Message message)
        {
            message = null;
        }
        if ("Success".equals(message))
        {
            ax.b();
            return;
        }
        break MISSING_BLOCK_LABEL_328;
_L10:
        (new StringBuilder("Beacon returned: ")).append(message.obj);
        ax.b();
        return;
_L6:
        ax.b();
        return;
_L3:
        (new StringBuilder("LogRiskMetadataRequest failed.")).append(((Exception)message.obj).getMessage());
        ax.b();
        return;
_L9:
        (new StringBuilder("BeaconRequest failed ")).append(((Exception)message.obj).getMessage());
        ax.b();
        return;
    }

    public final JSONObject b()
    {
        ae.a();
        l = k();
        if (l == null)
        {
            return null;
        } else
        {
            return l.a();
        }
    }

    public final void d()
    {
        ae.a();
        l = k();
        a(l, null);
    }

    public final void e()
    {
        ax.b();
        i = System.currentTimeMillis();
    }

    public final String f()
    {
        String s1 = h();
        u = s1;
        d();
        i();
        return s1;
    }

    public void onLocationChanged(Location location)
    {
        if (location != null)
        {
            p = new Location(location);
            (new StringBuilder("Location Update: ")).append(location.toString());
            ax.b();
        }
    }

    public void onProviderDisabled(String s1)
    {
    }

    public void onProviderEnabled(String s1)
    {
    }

    public void onStatusChanged(String s1, int i1, Bundle bundle)
    {
    }

    static 
    {
        new x();
    }
}
