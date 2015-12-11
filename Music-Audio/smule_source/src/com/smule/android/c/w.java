// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.c;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.smule.android.f.f;
import com.smule.android.network.core.b;
import com.smule.android.network.core.o;
import com.smule.android.network.core.p;
import com.smule.android.network.core.r;
import com.smule.android.network.managers.UserManager;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.smule.android.c:
//            r, v, x, aa, 
//            z, s, y

public class w
{

    static final String a = com/smule/android/c/w.getName();
    public static boolean b = true;
    private static w c;
    private List d;
    private int e;
    private Context f;
    private SharedPreferences g;
    private boolean h;
    private long i;
    private long j;
    private final Object k = new Object();
    private long l;
    private AtomicBoolean m;
    private List n;
    private com.smule.android.c.r o;

    private w()
    {
        h = false;
        i = 0L;
        j = 0L;
        l = 1L;
        m = new AtomicBoolean(false);
        o = new com.smule.android.c.r();
        d = new ArrayList();
        f = com.smule.android.network.core.b.d().e();
        n = new ArrayList();
        g = f.getSharedPreferences("event-logger", 0);
        e = g.getInt("eventlog_queue_limit", 200);
        int i1 = g.getInt("eventlog_flush_frequency", 30);
        j = SystemClock.elapsedRealtime();
        i = g.getLong("eventlog_server_init_time", System.currentTimeMillis());
        e();
        f();
        com.smule.android.network.core.b.a(new Runnable() {

            final w a;

            public void run()
            {
                com.smule.android.c.w.b(a);
            }

            
            {
                a = w.this;
                super();
            }
        }, i1, i1, TimeUnit.SECONDS);
        if (d.size() > 0)
        {
            Log.d(a, (new StringBuilder()).append("EventLogger2 - queue is not empty (").append(d.size()).append(") so flushing it now").toString());
            d();
        }
    }

    static long a(w w1)
    {
        return w1.g();
    }

    private long a(boolean flag)
    {
        if (flag)
        {
            b();
        }
        if (!h)
        {
            l = g.getLong("session-count", 1L);
            h = true;
        }
        Log.d(a, (new StringBuilder()).append("getSessionCount - returning: ").append(l).toString());
        return l;
    }

    public static w a()
    {
        com/smule/android/c/w;
        JVM INSTR monitorenter ;
        w w1;
        if (c == null)
        {
            Log.d(a, "Creating new EventLogger2 instance");
            c = new w();
        }
        w1 = c;
        com/smule/android/c/w;
        JVM INSTR monitorexit ;
        return w1;
        Exception exception;
        exception;
        throw exception;
    }

    static List a(w w1, List list)
    {
        w1.d = list;
        return list;
    }

    public static void a(Activity activity)
    {
        List list = a().n;
        list;
        JVM INSTR monitorenter ;
        for (Iterator iterator = a().n.iterator(); iterator.hasNext(); ((v)iterator.next()).b(activity)) { }
        break MISSING_BLOCK_LABEL_53;
        activity;
        list;
        JVM INSTR monitorexit ;
        throw activity;
        list;
        JVM INSTR monitorexit ;
        a().b();
        return;
    }

    public static void a(v v1)
    {
        synchronized (a().n)
        {
            a().n.add(v1);
        }
        return;
        v1;
        list;
        JVM INSTR monitorexit ;
        throw v1;
    }

    public static void a(String s1, long l1, int i1, int j1, long l2, long l3)
    {
        a(s1, l1, i1, j1, l2, l3, null);
    }

    public static void a(String s1, long l1, int i1, int j1, long l2, long l3, String s2)
    {
        float f1;
        float f2;
        Object obj;
        Object obj1;
        if (!b)
        {
            return;
        }
        obj1 = "wifi";
        obj = (ConnectivityManager)a().f.getSystemService("connectivity");
        NetworkInfo networkinfo = ((ConnectivityManager) (obj)).getNetworkInfo(1);
        NetworkInfo networkinfo1 = ((ConnectivityManager) (obj)).getNetworkInfo(0);
        obj = obj1;
        if (!networkinfo.isAvailable())
        {
            obj = obj1;
            if (networkinfo1 != null)
            {
                obj = obj1;
                if (networkinfo1.isAvailable())
                {
                    obj = ((TelephonyManager)a().f.getSystemService("phone")).getNetworkOperatorName();
                }
            }
        }
        f2 = 0.0F;
        f1 = 0.0F;
        obj1 = com.smule.android.f.f.a(a().f);
        if (obj1 != null)
        {
            f2 = (float)((Location) (obj1)).getLatitude();
            f1 = (float)((Location) (obj1)).getLongitude();
        }
        obj1 = new JSONObject();
        ((JSONObject) (obj1)).put("ip", h());
        ((JSONObject) (obj1)).put("lat", f2);
        ((JSONObject) (obj1)).put("lon", f1);
        ((JSONObject) (obj1)).put("req_size", l2);
        ((JSONObject) (obj1)).put("resp_size", l3);
        if (s2 != null)
        {
            try
            {
                ((JSONObject) (obj1)).put("err_dom", s2);
                ((JSONObject) (obj1)).put("err_code", 0);
            }
            // Misplaced declaration of an exception variable
            catch (String s2)
            {
                Log.e(a, "Failed to construct JSON object for k3.", s2);
            }
        }
        s2 = ((JSONObject) (obj1)).toString();
        s1 = new x("npt", s1, ((String) (obj)), Long.toString(l1), Integer.toString(i1), Integer.toString(j1), s2, null, null, null, null);
        aa.a(a, s1.toString());
        a().a(((x) (s1)));
        return;
    }

    public static void a(String s1, z z1)
    {
        a(s1, z1, false);
    }

    public static void a(String s1, z z1, boolean flag)
    {
        if (z1 != null)
        {
            a().a(s1, (String)z.a(z1).get("target"), (String)z.a(z1).get("context"), (String)z.a(z1).get("value"), (String)z.a(z1).get("k1"), (String)z.a(z1).get("k2"), (String)z.a(z1).get("k3"), (String)z.a(z1).get("k4"), (String)z.a(z1).get("k5"), (String)z.a(z1).get("k6"), (String)z.a(z1).get("k7"), flag);
            return;
        } else
        {
            a().a(s1, flag);
            return;
        }
    }

    private boolean a(List list)
    {
        o o1 = com.smule.android.network.a.f.a().a(list);
        if (o1.b != 0)
        {
            com.smule.android.network.core.b.a(o1);
        }
        if (o1.a != p.a)
        {
            Log.e(a, (new StringBuilder()).append("Failed to send ").append(list.size()).append(" events.  Not deleting event cache").toString());
            return false;
        } else
        {
            f();
            return true;
        }
    }

    public static void b(Activity activity)
    {
        List list = a().n;
        list;
        JVM INSTR monitorenter ;
        for (Iterator iterator = a().n.iterator(); iterator.hasNext(); ((v)iterator.next()).c(activity)) { }
        break MISSING_BLOCK_LABEL_53;
        activity;
        list;
        JVM INSTR monitorexit ;
        throw activity;
        list;
        JVM INSTR monitorexit ;
    }

    static void b(w w1)
    {
        w1.d();
    }

    public static void b(String s1)
    {
        a().o.a(s1).a();
    }

    static boolean b(w w1, List list)
    {
        return w1.a(list);
    }

    public static long c()
    {
        return a().a(false);
    }

    static Context c(w w1)
    {
        return w1.f;
    }

    public static void c(String s1)
    {
        a().o.a(s1).b();
    }

    static List d(w w1)
    {
        return w1.d;
    }

    private void d()
    {
        com.smule.android.network.core.b.a(new Runnable() {

            final w a;

            public void run()
            {
                while (!r.a(w.c(a)) || UserManager.n().c() == 0L) 
                {
                    return;
                }
                synchronized (a)
                {
                    if (w.d(a).size() > 0)
                    {
                        break MISSING_BLOCK_LABEL_55;
                    }
                }
                return;
                exception;
                w1;
                JVM INSTR monitorexit ;
                throw exception;
                List list;
                list = w.d(a);
                w.a(a, new ArrayList());
                w1;
                JVM INSTR monitorexit ;
                com.smule.android.c.w.b(a, list);
                return;
            }

            
            {
                a = w.this;
                super();
            }
        });
    }

    public static void d(String s1)
    {
        a().o.b(s1);
    }

    public static double e(String s1)
    {
        return a().o.a(s1).d();
    }

    private void e()
    {
        Log.i(a, "Loading analytics events.");
        ObjectInputStream objectinputstream = new ObjectInputStream(f.openFileInput("event-logger"));
        this;
        JVM INSTR monitorenter ;
        d = (List)objectinputstream.readObject();
        Log.d(a, (new StringBuilder()).append("load - following load from file, the event queue size is: ").append(d.size()).toString());
        this;
        JVM INSTR monitorexit ;
        Exception exception;
        try
        {
            objectinputstream.close();
            return;
        }
        catch (ClassNotFoundException classnotfoundexception)
        {
            Log.e(a, "Failed to load existing event queue.", classnotfoundexception);
            return;
        }
        catch (FileNotFoundException filenotfoundexception)
        {
            return;
        }
        catch (IOException ioexception)
        {
            Log.e(a, "Failed to load existing event queue.", ioexception);
        }
        break MISSING_BLOCK_LABEL_112;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static long f(String s1)
    {
        return a().o.a(s1).c();
    }

    private void f()
    {
        f.deleteFile("event-logger");
    }

    private long g()
    {
        Object obj = k;
        obj;
        JVM INSTR monitorenter ;
        long l1 = SystemClock.elapsedRealtime() - j;
        if (l1 >= 0L && l1 <= 0x757b12c00L)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        Log.e(a, (new StringBuilder()).append("Elapsed time is awkward: ").append(l1).toString());
        long l2 = i;
        obj;
        JVM INSTR monitorexit ;
        return l1 + l2;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private static String h()
    {
        Enumeration enumeration = NetworkInterface.getNetworkInterfaces();
_L2:
        Enumeration enumeration1;
        if (!enumeration.hasMoreElements())
        {
            break MISSING_BLOCK_LABEL_83;
        }
        enumeration1 = ((NetworkInterface)enumeration.nextElement()).getInetAddresses();
_L4:
        if (!enumeration1.hasMoreElements()) goto _L2; else goto _L1
_L1:
        Object obj = (InetAddress)enumeration1.nextElement();
        if (((InetAddress) (obj)).isLoopbackAddress()) goto _L4; else goto _L3
_L3:
        boolean flag;
        obj = ((InetAddress) (obj)).getHostAddress();
        flag = ((String) (obj)).contains("%");
        if (flag) goto _L4; else goto _L5
_L5:
        return ((String) (obj));
        SocketException socketexception;
        socketexception;
        Log.e(a, socketexception.toString());
        return null;
    }

    public void a(long l1)
    {
        android.content.SharedPreferences.Editor editor = g.edit();
        synchronized (k)
        {
            j = SystemClock.elapsedRealtime();
            i = l1;
            editor.putLong("eventlog_server_init_time", i);
        }
        com.smule.android.f.p.a(editor);
        Log.i(a, (new StringBuilder()).append("calibrateTimeStamp: ").append(l1).toString());
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void a(x x1)
    {
        Log.i(a, (new StringBuilder()).append("Logged new event: ").append(x1).toString());
        this;
        JVM INSTR monitorenter ;
        d.add(x1);
        if (x1.m)
        {
            d();
        }
        if (d.size() > e)
        {
            if (!r.a(f))
            {
                break MISSING_BLOCK_LABEL_132;
            }
            d();
        }
_L1:
        this;
        JVM INSTR monitorexit ;
        List list = n;
        list;
        JVM INSTR monitorenter ;
        for (Iterator iterator = n.iterator(); iterator.hasNext(); ((v)iterator.next()).b(x1)) { }
        break MISSING_BLOCK_LABEL_151;
        x1;
        list;
        JVM INSTR monitorexit ;
        throw x1;
        d.remove(0);
          goto _L1
        x1;
        this;
        JVM INSTR monitorexit ;
        throw x1;
        list;
        JVM INSTR monitorexit ;
    }

    public void a(y y1)
    {
        a(y1.a());
    }

    public void a(String s1)
    {
        a(new x(s1, null, null, null, null, null, null, null, null, null, null));
    }

    public void a(String s1, String s2)
    {
        a(new x(s1, s2, null, null, null, null, null, null, null, null, null));
    }

    public void a(String s1, String s2, String s3)
    {
        a(new x(s1, s2, s3, null, null, null, null, null, null, null, null));
    }

    public void a(String s1, String s2, String s3, String s4)
    {
        a(new x(s1, s2, s3, s4, null, null, null, null, null, null, null));
    }

    public void a(String s1, String s2, String s3, String s4, String s5)
    {
        a(new x(s1, s2, s3, s4, s5, null, null, null, null, null, null));
    }

    public void a(String s1, String s2, String s3, String s4, String s5, String s6, String s7)
    {
        a(new x(s1, s2, s3, s4, s5, s6, s7, null, null, null, null));
    }

    public void a(String s1, String s2, String s3, String s4, String s5, String s6, String s7, 
            String s8)
    {
        a(new x(s1, s2, s3, s4, s5, s6, s7, s8, null, null, null));
    }

    public void a(String s1, String s2, String s3, String s4, String s5, String s6, String s7, 
            String s8, String s9, String s10, String s11, boolean flag)
    {
        a(new x(s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, flag));
    }

    public void a(String s1, String s2, String s3, boolean flag)
    {
        a(new x(s1, s2, s3, null, null, null, null, null, null, null, null, flag));
    }

    public void a(String s1, String s2, boolean flag)
    {
        a(new x(s1, s2, null, null, null, null, null, null, null, null, null, flag));
    }

    public void a(String s1, boolean flag)
    {
        a(new x(s1, null, null, null, null, null, null, null, null, null, null, flag));
    }

    public void b()
    {
        android.content.SharedPreferences.Editor editor = g.edit();
        long l2 = g.getLong("last-activity", 0L);
        long l1 = System.currentTimeMillis() / 1000L;
        editor.putLong("last-activity", l1);
        if (l2 + 600L < l1)
        {
            long l3 = g.getLong("session-count", 1L);
            if (!com.smule.android.network.core.b.a().f() && com.smule.android.network.core.b.a().a + 600L < l1 && l3 > 1L)
            {
                com.smule.android.network.core.b.a(new Runnable() {

                    final w a;

                    public void run()
                    {
                        com.smule.android.network.core.b.a().a(true);
                    }

            
            {
                a = w.this;
                super();
            }
                });
            }
            l1 = l3 + 1L;
            editor.putLong("session-count", l1);
            l = l1;
        }
        com.smule.android.f.p.a(editor);
    }

}
