// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.kahuna.sdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.support.v7.agt;
import android.support.v7.agv;
import android.support.v7.agx;
import android.support.v7.ahc;
import android.support.v7.ahg;
import android.support.v7.ahh;
import android.support.v7.ahj;
import android.util.Log;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.kahuna.sdk:
//            i, s, r, v, 
//            c, l, d, h, 
//            b, j, w, u, 
//            o, t, p, a, 
//            n, e

public abstract class m
    implements i
{
    private class a extends Timer
    {

        final m a;
        private long b;

        public long a()
        {
            return b;
        }

        public void schedule(TimerTask timertask, long l1)
        {
            b = System.currentTimeMillis() + l1;
            super.schedule(timertask, l1);
        }

        private a()
        {
            a = m.this;
            super();
            b = -1L;
        }

    }

    private class b extends TimerTask
    {

        final m a;

        public void run()
        {
            synchronized (m.r(a))
            {
                m.b(a, true);
            }
            obj1 = new agx();
            ((agx) (obj1)).a("key", m.h(a));
            ((agx) (obj1)).a("dev_id", m.i(a));
            ((agx) (obj1)).a("app_name", m.s(a));
            ((agx) (obj1)).a("app_ver", m.t(a));
            ((agx) (obj1)).a("os_version", m.u(a));
            ((agx) (obj1)).a("os_name", m.v(a));
            ((agx) (obj1)).a("dev_name", m.w(a));
            ((agx) (obj1)).a("client_time", (new StringBuilder()).append("").append(System.currentTimeMillis() / 1000L).toString());
            ((agx) (obj1)).a("sdk_version", "2.0.3");
            if (!com.kahuna.sdk.v.a(m.x(a)))
            {
                ((agx) (obj1)).a("push_token", m.x(a));
            }
            if (!com.kahuna.sdk.v.a(m.y(a)) && !com.kahuna.sdk.v.a(m.z(a)))
            {
                ((agx) (obj1)).a("sdk_wrapper", m.y(a));
                ((agx) (obj1)).a("sdk_wrapper_version", m.z(a));
            }
            Object obj2;
            Object obj3;
            int i1;
            int j1;
            if (m.j(a))
            {
                obj = "s";
            } else
            {
                obj = "p";
            }
            ((agx) (obj1)).a("env", ((String) (obj)));
            ((agx) (obj1)).a("c", (new StringBuilder()).append("").append(m.A(a).a()).toString());
            obj2 = new JSONArray();
            if (m.u())
            {
                ((JSONArray) (obj2)).put("iam");
            }
            if (!m.v() || !ahj.a()) goto _L2; else goto _L1
_L1:
            ((JSONArray) (obj2)).put("rm");
            obj3 = ahj.b(a);
            if (((Set) (obj3)).size() <= 0) goto _L2; else goto _L3
_L3:
            obj = new JSONArray();
            for (obj3 = ((Set) (obj3)).iterator(); ((Iterator) (obj3)).hasNext(); ((JSONArray) (obj)).put((String)((Iterator) (obj3)).next())) { }
              goto _L4
            obj;
_L16:
            if (com.kahuna.sdk.v.a(((JSONArray) (obj2)))) goto _L6; else goto _L5
_L5:
            if (obj2 instanceof JSONArray) goto _L8; else goto _L7
_L7:
            obj = ((JSONArray) (obj2)).toString();
_L21:
            ((agx) (obj1)).a("fsupported", ((String) (obj)));
_L6:
            obj2 = new JSONArray();
            m.b(a, new ArrayList());
            obj = m.d(a);
            obj;
            JVM INSTR monitorenter ;
            if (m.B(a).get() <= 0)
            {
                m.B(a).set(m.e(a).size());
            }
            i1 = m.A(a).q();
            if (i1 < m.e(a).size())
            {
                break MISSING_BLOCK_LABEL_1547;
            }
              goto _L9
_L12:
            if (j1 >= i1) goto _L11; else goto _L10
_L10:
            obj3 = (c)m.e(a).get(j1);
            m.C(a).add(obj3);
            obj3 = ((c) (obj3)).l();
            if (obj3 == null)
            {
                break MISSING_BLOCK_LABEL_582;
            }
            ((JSONArray) (obj2)).put(obj3);
            j1++;
              goto _L12
            obj1;
            obj;
            JVM INSTR monitorexit ;
            try
            {
                throw obj1;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
            if (m.a)
            {
                Log.d("Kahuna", (new StringBuilder()).append("Caught exception in Send Events Task handler: ").append(obj).toString());
                ((Exception) (obj)).printStackTrace();
            }
            synchronized (m.n(a))
            {
                if (m.o(a) != null)
                {
                    m.o(a).cancel();
                    m.a(a, null);
                }
            }
_L29:
            return;
_L4:
            if (obj instanceof JSONArray) goto _L14; else goto _L13
_L13:
            obj = ((JSONArray) (obj)).toString();
_L19:
            ((agx) (obj1)).a("rm", ((String) (obj)));
_L2:
            if (android.os.Build.VERSION.SDK_INT < 18 || !m.w() || !ahc.a() || !ahh.a(a)) goto _L16; else goto _L15
_L15:
            ((JSONArray) (obj2)).put("bm");
            obj3 = ahh.b(a);
            if (((Set) (obj3)).size() <= 0) goto _L16; else goto _L17
_L17:
            obj = new JSONArray();
            for (obj3 = ((Set) (obj3)).iterator(); ((Iterator) (obj3)).hasNext(); ((JSONArray) (obj)).put((String)((Iterator) (obj3)).next())) { }
              goto _L18
_L14:
            obj = JSONArrayInstrumentation.toString((JSONArray)obj);
              goto _L19
_L18:
            if (obj instanceof JSONArray)
            {
                break MISSING_BLOCK_LABEL_836;
            }
            obj = ((JSONArray) (obj)).toString();
_L20:
            ((agx) (obj1)).a("bm", ((String) (obj)));
              goto _L16
            obj = JSONArrayInstrumentation.toString((JSONArray)obj);
              goto _L20
_L8:
            obj = JSONArrayInstrumentation.toString((JSONArray)obj2);
              goto _L21
_L9:
            i1 = m.e(a).size();
            break MISSING_BLOCK_LABEL_1547;
_L11:
            obj;
            JVM INSTR monitorexit ;
            com.kahuna.sdk.d.a();
            if (m.C(a).size() != 0)
            {
                break MISSING_BLOCK_LABEL_973;
            }
            synchronized (m.r(a))
            {
                m.b(a, false);
            }
            synchronized (m.n(a))
            {
                if (m.o(a) != null)
                {
                    m.o(a).cancel();
                    m.a(a, null);
                }
            }
            return;
            obj1;
            obj;
            JVM INSTR monitorexit ;
            throw obj1;
            obj1;
            obj;
            JVM INSTR monitorexit ;
            throw obj1;
            obj1;
            obj;
            JVM INSTR monitorexit ;
            throw obj1;
            if (obj2 instanceof JSONArray) goto _L23; else goto _L22
_L22:
            obj = ((JSONArray) (obj2)).toString();
_L35:
            ((agx) (obj1)).a("events_cksum", com.kahuna.sdk.v.a(((String) (obj)), "MD5", false));
            ((agx) (obj1)).a("events", ((String) (obj)));
            if (!com.kahuna.sdk.v.a(m.D(a)))
            {
                ((agx) (obj1)).a("archive_corrupt_raw_data", m.D(a));
            }
            if (com.kahuna.sdk.v.a(m.E(a))) goto _L25; else goto _L24
_L24:
            obj = m.E(a);
            if (obj instanceof JSONArray) goto _L27; else goto _L26
_L26:
            obj = ((JSONArray) (obj)).toString();
_L36:
            ((agx) (obj1)).a("archive_corrupt_event_names", ((String) (obj)));
_L25:
            obj = com.kahuna.sdk.v.a(EntityUtils.toString(((agx) (obj1)).b(), "UTF-8"), "MD5", false);
            if (m.a)
            {
                Log.d("Kahuna", (new StringBuilder()).append("Top Level Checksum was: ").append(((String) (obj))).toString());
            }
            obj = new BasicHeader("top_level_checksum", ((String) (obj)));
            obj2 = m.J(a);
            obj3 = m.F(a);
            agv agv = new agv(this) {

                final b a;

                public void a(String s1)
                {
                    int i1 = 0;
                    boolean flag;
                    s1 = JSONObjectInstrumentation.init(s1);
                    flag = s1.getBoolean("success");
                    if (!flag)
                    {
                        break MISSING_BLOCK_LABEL_324;
                    }
                    synchronized (m.d(a.a))
                    {
                        m.e(a.a).removeAll(m.C(a.a));
                        com.kahuna.sdk.r.a(m.e(a.a), m.a(a.a));
                    }
                    com.kahuna.sdk.r.b(m.f(a.a).get(), m.a(a.a));
                    if (m.a)
                    {
                        Log.d("Kahuna", (new StringBuilder()).append("Number events submitted: ").append(m.C(a.a).size()).toString());
                    }
                    m.B(a.a).addAndGet(0 - m.C(a.a).size());
                    m.C(a.a).clear();
                    m.b(a.a, null);
                    if (m.a)
                    {
                        Log.d("Kahuna", (new StringBuilder()).append("Events let in Queue: ").append(m.e(a.a).size()).toString());
                    }
                    m.a(a.a, System.currentTimeMillis() / 1000L);
                    com.kahuna.sdk.r.a(m.H(a.a), m.a(a.a));
                    m.a(a.a, null);
                    m.a(a.a, null);
                    if (m.a)
                    {
                        Log.d("Kahuna", (new StringBuilder()).append("server reply: ").append(flag).toString());
                    }
                    obj = s1.optJSONArray("s");
                    if (obj == null) goto _L2; else goto _L1
_L1:
                    int j1 = ((JSONArray) (obj)).length();
_L7:
                    if (i1 >= j1)
                    {
                        break; /* Loop/switch isn't completed */
                    }
                    Object obj1 = ((JSONArray) (obj)).optString(i1);
                    if (com.kahuna.sdk.v.a(((String) (obj1)))) goto _L4; else goto _L3
_L3:
                    if (!"a".equals(((String) (obj1)).trim())) goto _L6; else goto _L5
_L5:
                    obj1 = m.q(a.a);
                    c c1 = new c("k_server_request");
                    c1.b(((Map) (obj1)));
                    a.a.a(c1);
_L4:
                    i1++;
                    if (true) goto _L7; else goto _L2
                    s1;
                    obj;
                    JVM INSTR monitorexit ;
                    try
                    {
                        throw s1;
                    }
                    // Misplaced declaration of an exception variable
                    catch (String s1) { }
_L13:
                    boolean flag1;
                    flag1 = flag;
                    if (m.a)
                    {
                        Log.w("Kahuna", (new StringBuilder()).append("Caught exception in http response handler: ").append(s1).toString());
                        Thread.dumpStack();
                        flag1 = flag;
                    }
_L10:
                    synchronized (m.r(a.a))
                    {
                        m.b(a.a, false);
                    }
                    if (m.C(a.a) != null)
                    {
                        m.C(a.a).clear();
                        m.b(a.a, null);
                    }
                    JSONObject jsonobject;
                    c c2;
                    if (flag1)
                    {
                        synchronized (m.n(a.a))
                        {
                            if (m.o(a.a) != null)
                            {
                                m.o(a.a).cancel();
                                m.a(a.a, null);
                            }
                            if (m.B(a.a).get() > 0 || m.I(a.a))
                            {
                                m.a(a.a, a.a. new a());
                                m.o(a.a).schedule(a.a. new b(), 2000L);
                            }
                        }
                        return;
                    } else
                    {
                        m.G(a.a);
                        return;
                    }
_L6:
                    if (!"c".equals(((String) (obj1)).trim())) goto _L4; else goto _L8
_L8:
                    obj1 = com.kahuna.sdk.r.e(m.a(a.a));
                    c2 = new c("k_server_request");
                    c2.a(((Map) (obj1)));
                    a.a.a(c2);
                      goto _L4
_L2:
                    jsonobject = s1.optJSONObject("c");
                    if (jsonobject == null)
                    {
                        break MISSING_BLOCK_LABEL_1146;
                    }
                    m.a(a.a, com.kahuna.sdk.s.a(jsonobject));
                    com.kahuna.sdk.d.a(m.A(a.a).p());
                    com.kahuna.sdk.s.a(m.a(a.a), m.A(a.a));
                    if (m.a)
                    {
                        Log.d("Kahuna", (new StringBuilder()).append("Updated SDK Config Version:").append(m.A(a.a).a()).append(" flushInterval: ").append(m.A(a.a).b()).append(" flushEventCount: ").append(m.A(a.a).d()).append(" events:").append(m.A(a.a).e()).append(" flushWithDelayTime: ").append(m.A(a.a).g()).append(" delayEvents: ").append(m.A(a.a).i()).append(" bucketConfig: ").append(m.A(a.a).p()).append(" eventMapping: ").append(m.A(a.a).j()).append(" include: ").append(m.A(a.a).l()).append(" exclude: ").append(m.A(a.a).k()).append(" eventPropertiesMaxCount: ").append(m.A(a.a).m()).append(" eventPropertiesIncludeMap: ").append(m.A(a.a).n()).append(" eventPropertiesExcludeMap: ").append(m.A(a.a).o()).toString());
                    }
                    jsonobject = s1.optJSONObject("iam");
                    if (jsonobject == null)
                    {
                        break MISSING_BLOCK_LABEL_1162;
                    }
                    com.kahuna.sdk.n.a(jsonobject);
                    s1 = s1.optJSONObject("location");
                    flag1 = flag;
                    if (s1 == null) goto _L10; else goto _L9
_L9:
                    ahj.a(a.a, s1, m.a(a.a));
                    flag1 = flag;
                    if (android.os.Build.VERSION.SDK_INT < 18) goto _L10; else goto _L11
_L11:
                    ahh.a(a.a, s1, m.a(a.a));
                    flag1 = flag;
                      goto _L10
                    s1;
                    flag1 = flag;
                    if (!m.a) goto _L10; else goto _L12
_L12:
                    Log.w("Kahuna", "Caught error when attepmting to to parse server location services command. If you are NOT using location services please ignore this error: ");
                    Log.w("Kahuna", s1);
                    flag1 = flag;
                      goto _L10
                    exception;
                    s1;
                    JVM INSTR monitorexit ;
                    throw exception;
                    exception1;
                    s1;
                    JVM INSTR monitorexit ;
                    throw exception1;
                    s1;
                    flag = false;
                      goto _L13
                }

                public void a(Throwable throwable, String s1)
                {
                    super.a(throwable, s1);
                    if (m.a)
                    {
                        Log.d("Kahuna", (new StringBuilder()).append("Failed to send request: ").append(s1).toString(), throwable);
                    }
                    synchronized (m.r(a.a))
                    {
                        m.b(a.a, false);
                    }
                    m.G(a.a);
                    return;
                    s1;
                    throwable;
                    JVM INSTR monitorexit ;
                    throw s1;
                }

            
            {
                a = b1;
                super();
            }
            };
            ((agt) (obj2)).a(null, ((String) (obj3)), new Header[] {
                obj
            }, ((agx) (obj1)), "application/x-www-form-urlencoded", agv);
            if (!m.a) goto _L29; else goto _L28
_L28:
            if (!com.kahuna.sdk.p.b(m.a(a)))
            {
                break MISSING_BLOCK_LABEL_1515;
            }
            Log.d("Kahuna", "filtering some parameters");
            obj1 = ((agx) (obj1)).a();
            obj2 = new StringBuilder();
            obj3 = ((Map) (obj1)).keySet().iterator();
_L38:
            do
            {
                if (!((Iterator) (obj3)).hasNext())
                {
                    break MISSING_BLOCK_LABEL_1485;
                }
                obj = (String)((Iterator) (obj3)).next();
            } while ("key".equals(obj));
            if (((StringBuilder) (obj2)).length() > 0)
            {
                ((StringBuilder) (obj2)).append("&");
            }
            if (!"events".equals(obj))
            {
                break MISSING_BLOCK_LABEL_1444;
            }
            ((StringBuilder) (obj2)).append((new StringBuilder()).append(((String) (obj))).append("=[").toString());
            j1 = m.C(a).size();
            i1 = 0;
_L34:
            if (i1 >= j1) goto _L31; else goto _L30
_L30:
            obj = ((c)m.C(a).get(i1)).l();
            ((JSONObject) (obj)).remove("credentials");
            if (obj instanceof JSONObject) goto _L33; else goto _L32
_L32:
            obj = ((JSONObject) (obj)).toString();
_L37:
            ((StringBuilder) (obj2)).append(((String) (obj)));
            i1++;
              goto _L34
_L23:
            obj = JSONArrayInstrumentation.toString((JSONArray)obj2);
              goto _L35
_L27:
            obj = JSONArrayInstrumentation.toString((JSONArray)obj);
              goto _L36
_L33:
            obj = JSONObjectInstrumentation.toString((JSONObject)obj);
              goto _L37
_L31:
            ((StringBuilder) (obj2)).append("]");
              goto _L38
            ((StringBuilder) (obj2)).append((new StringBuilder()).append(((String) (obj))).append("=").append((String)((Map) (obj1)).get(obj)).toString());
              goto _L38
            Log.d("Kahuna", (new StringBuilder()).append("Sending request: ").append(((StringBuilder) (obj2)).toString()).toString());
            return;
            Log.d("Kahuna", (new StringBuilder()).append("Sending request: ").append(obj1).toString());
            return;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
            j1 = 0;
              goto _L12
        }

        private b()
        {
            a = m.this;
            super();
        }

    }


    private static o L;
    private static boolean M = false;
    private static int N = -1;
    private static boolean O = false;
    private static boolean P = false;
    private static boolean Q = false;
    private static ExecutorService T = Executors.newSingleThreadExecutor();
    private static boolean U = false;
    private static boolean V = false;
    protected static boolean a = false;
    protected static int b = 5000;
    protected static String c;
    private static boolean e = false;
    private static Object f = new Object();
    private static m g = null;
    private Object A;
    private List B;
    private List C;
    private Object D;
    private boolean E;
    private Object F;
    private a G;
    private int H[][] = {
        {
            5000, 10000
        }, {
            10000, 20000
        }, {
            20000, 40000
        }, {
            40000, 0x13880
        }
    };
    private int I;
    private AtomicInteger J;
    private Timer K;
    private s R;
    private long S;
    private AtomicInteger W;
    private AtomicLong X;
    private String Y;
    private JSONArray Z;
    private boolean d;
    private final String h = "2.0.3";
    private final String i = "Android";
    private String j;
    private String k;
    private final String l = "https://tap-nexus.appspot.com/log";
    private Context m;
    private final agt n = new agt();
    private String o;
    private boolean p;
    private boolean q;
    private String r;
    private String s;
    private String t;
    private String u;
    private String v;
    private String w;
    private String x;
    private final String y = "2.0.3";
    private String z;

    protected m()
    {
        d = false;
        j = null;
        k = null;
        p = false;
        q = true;
        r = "https://tap-nexus.appspot.com/log";
        w = "Android";
        A = new Object();
        D = new Object();
        F = new Object();
        I = 0;
        S = 0L;
        W = new AtomicInteger(0);
        X = new AtomicLong(1L);
        Y = null;
        Z = null;
        n.a(60000);
        g = this;
    }

    private long A()
    {
        this;
        JVM INSTR monitorenter ;
        int j1 = I;
        int i1 = j1;
        double d1;
        if (j1 >= H.length)
        {
            i1 = H.length - 1;
        }
        j1 = H[i1][1];
        i1 = H[i1][0];
        d1 = Math.random();
        long l1;
        double d2 = j1 - i1;
        l1 = (int)((double)i1 + d1 * d2);
        this;
        JVM INSTR monitorexit ;
        return l1;
        Exception exception;
        exception;
        throw exception;
    }

    static s A(m m1)
    {
        return m1.R;
    }

    static AtomicInteger B(m m1)
    {
        return m1.W;
    }

    private void B()
    {
        this;
        JVM INSTR monitorenter ;
        I = 0;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    static List C(m m1)
    {
        return m1.C;
    }

    private void C()
    {
label0:
        {
            synchronized (F)
            {
                if (G != null)
                {
                    G.cancel();
                    G = null;
                }
                if (I < R.f())
                {
                    break label0;
                }
                B();
                W.set(0);
                if (a)
                {
                    Log.d("Kahuna", (new StringBuilder()).append("Reached our max retry limit. Will not retry until the next request to flush events. Max attempts: ").append(R.f()).toString());
                }
            }
            return;
        }
        long l1 = A();
        if (a)
        {
            Log.d("Kahuna", (new StringBuilder()).append("Scheduling next retry in: ").append(l1).append("(ms)").toString());
        }
        G = new a();
        G.schedule(new b(), l1);
        I = I + 1;
        obj;
        JVM INSTR monitorexit ;
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private String D()
    {
        String s2 = com.kahuna.sdk.r.a(m);
        String s1 = s2;
        if (com.kahuna.sdk.v.a(s2))
        {
            s1 = UUID.randomUUID().toString();
            com.kahuna.sdk.r.a(s1, m);
        }
        return s1;
    }

    static String D(m m1)
    {
        return m1.Y;
    }

    static JSONArray E(m m1)
    {
        return m1.Z;
    }

    static String F(m m1)
    {
        return m1.r;
    }

    static void G(m m1)
    {
        m1.C();
    }

    static long H(m m1)
    {
        return m1.S;
    }

    static boolean I(m m1)
    {
        return m1.z();
    }

    static agt J(m m1)
    {
        return m1.n;
    }

    static long a(m m1, long l1)
    {
        m1.S = l1;
        return l1;
    }

    static Context a(m m1)
    {
        return m1.m;
    }

    static a a(m m1, a a1)
    {
        m1.G = a1;
        return a1;
    }

    static s a(m m1, s s1)
    {
        m1.R = s1;
        return s1;
    }

    static String a(m m1, String s1)
    {
        m1.Y = s1;
        return s1;
    }

    static List a(m m1, List list)
    {
        m1.B = list;
        return list;
    }

    static Timer a(m m1, Timer timer)
    {
        m1.K = timer;
        return timer;
    }

    static JSONArray a(m m1, JSONArray jsonarray)
    {
        m1.Z = jsonarray;
        return jsonarray;
    }

    private void a(c c1, int i1)
    {
label0:
        {
            HashMap hashmap;
label1:
            {
                JSONObject jsonobject = c1.h();
                if (jsonobject != null)
                {
                    hashmap = new HashMap();
                    if (i1 <= 0)
                    {
                        break label0;
                    }
                    Iterator iterator = jsonobject.keys();
                    do
                    {
                        if (!iterator.hasNext())
                        {
                            break;
                        }
                        String s1 = (String)iterator.next();
                        String s3 = jsonobject.optString(s1);
                        if (R.a(c1.a(), s1, s3))
                        {
                            hashmap.put(s1, s3);
                        }
                    } while (true);
                    if (hashmap.size() > i1)
                    {
                        HashMap hashmap1 = new HashMap();
                        Iterator iterator1 = hashmap.keySet().iterator();
                        for (int j1 = 0; j1 < i1; j1++)
                        {
                            String s2 = (String)iterator1.next();
                            hashmap1.put(s2, hashmap.get(s2));
                        }

                        hashmap = hashmap1;
                    }
                    if (!com.kahuna.sdk.v.a(hashmap))
                    {
                        break label1;
                    }
                    c1.a(null);
                }
                return;
            }
            c1.a(new JSONObject(hashmap));
            return;
        }
        c1.a(null);
    }

    private void a(c c1, c c2)
    {
        try
        {
            c1 = com.kahuna.sdk.v.b(c1.l().getJSONObject("user_info"));
            Map map = com.kahuna.sdk.v.b(c2.l().getJSONObject("user_info"));
            map.putAll(c1);
            c2.b(map);
            if (a)
            {
                Log.d("Kahuna", (new StringBuilder()).append("Merged adjacent User Attributes to event:").append(c2.l()).toString());
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (c c1)
        {
            Log.d("Kahuna", (new StringBuilder()).append("error merging User Attributes: ").append(c1).toString());
        }
    }

    static void a(m m1, c c1)
    {
        m1.c(c1);
    }

    static void a(m m1, Map map)
    {
        m1.b(map);
    }

    private void a(String s1, int i1, int j1, boolean flag)
    {
        if (com.kahuna.sdk.v.a(s1))
        {
            if (a)
            {
                Log.w("Kahuna", "You cannot track a null or empty String event name. Ignoring event.");
            }
            return;
        } else
        {
            s1 = new String(s1);
            T.execute(new l(new Runnable(s1, flag, i1, j1) {

                final String a;
                final boolean b;
                final int c;
                final int d;
                final m e;

                public void run()
                {
                    try
                    {
                        e e1 = new e(a);
                        if (b)
                        {
                            e1.a(c, d);
                        }
                        m.a(e, e1.a());
                        return;
                    }
                    catch (Exception exception)
                    {
                        Log.d("Kahuna", (new StringBuilder()).append("Handled exception in KahunaCommon.trackEvent(): ").append(exception).toString());
                    }
                }

            
            {
                e = m.this;
                a = s1;
                b = flag;
                c = i1;
                d = j1;
                super();
            }
            }));
            return;
        }
    }

    protected static void a(boolean flag)
    {
        if (flag)
        {
            a = flag;
            return;
        } else
        {
            a = e;
            return;
        }
    }

    static boolean a(m m1, boolean flag)
    {
        m1.q = flag;
        return flag;
    }

    static List b(m m1, List list)
    {
        m1.C = list;
        return list;
    }

    private void b(c c1)
    {
        if (c1 == null)
        {
            if (a)
            {
                Log.w("Kahuna", "Event is null.");
            }
            return;
        } else
        {
            T.execute(new l(new Runnable(c1) {

                final c a;
                final m b;

                public void run()
                {
                    try
                    {
                        m.a(b, a);
                        return;
                    }
                    catch (Exception exception)
                    {
                        Log.d("Kahuna", (new StringBuilder()).append("Handled exception in KahunaCommon.trackEvent(): ").append(exception).toString());
                    }
                }

            
            {
                b = m.this;
                a = c1;
                super();
            }
            }));
            return;
        }
    }

    static void b(m m1, String s1)
    {
        m1.d(s1);
    }

    private void b(Map map)
    {
        if (map == null)
        {
            HashMap hashmap;
            Map map1;
            Iterator iterator;
            String s1;
            boolean flag;
            try
            {
                if (a)
                {
                    Log.d("Kahuna", "You must specify a valid Map for user Attributes. Ignoring this call to setUserAttributes");
                    return;
                }
            }
            // Misplaced declaration of an exception variable
            catch (Map map)
            {
                if (a)
                {
                    Log.d("Kahuna", (new StringBuilder()).append("Exception attempting to set user attributes:").append(map).toString());
                    return;
                }
            }
            break MISSING_BLOCK_LABEL_400;
        }
        map1 = y();
        hashmap = new HashMap();
        flag = false;
        iterator = map.keySet().iterator();
_L3:
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_276;
            }
            s1 = (String)iterator.next();
        } while (com.kahuna.sdk.v.a(s1));
        if (map1.containsKey(s1)) goto _L2; else goto _L1
_L1:
        map1.put(s1, map.get(s1));
        hashmap.put(s1, map.get(s1));
        flag = true;
          goto _L3
_L2:
        if (map1.get(s1) != null && map.get(s1) != null) goto _L5; else goto _L4
_L4:
        if (map1.get(s1) == map.get(s1)) goto _L3; else goto _L6
_L6:
        map1.put(s1, map.get(s1));
        hashmap.put(s1, map.get(s1));
        flag = true;
          goto _L3
_L5:
        if (((String)map1.get(s1)).equals(map.get(s1))) goto _L3; else goto _L7
_L7:
        map1.put(s1, map.get(s1));
        hashmap.put(s1, map.get(s1));
        flag = true;
          goto _L3
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_381;
        }
        com.kahuna.sdk.r.c(map1, m);
        if (hashmap == null)
        {
            break MISSING_BLOCK_LABEL_314;
        }
        map = new c("k_user_attributes");
        map.b(hashmap);
        c(map);
        if (a)
        {
            Log.d("Kahuna", (new StringBuilder()).append("Detected changes for the following user attributes: ").append(hashmap).toString());
            return;
        }
        break MISSING_BLOCK_LABEL_400;
        if (a)
        {
            Log.d("Kahuna", "Did not detect any change in user attributes, not sending request...");
            return;
        }
    }

    static boolean b(m m1)
    {
        return m1.p;
    }

    static boolean b(m m1, boolean flag)
    {
        m1.E = flag;
        return flag;
    }

    private void c(c c1)
    {
        boolean flag = true;
        if (c1 != null) goto _L2; else goto _L1
_L1:
        if (a)
        {
            Log.w("Kahuna", "Ignoring request to track (null) Event object");
        }
_L4:
        return;
_L2:
        if (!com.kahuna.sdk.v.a(c1.a()))
        {
            break; /* Loop/switch isn't completed */
        }
        if (a)
        {
            Log.w("Kahuna", "Cannot track null or empty event name");
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        Object obj1;
        if (!p)
        {
            i();
        }
        obj1 = c1;
        if (s.a.contains(c1.a().toLowerCase())) goto _L6; else goto _L5
_L5:
        c c2;
label0:
        {
            obj1 = R.j();
            c2 = c1;
            if (obj1 == null)
            {
                break label0;
            }
            c2 = c1;
            if (((Map) (obj1)).isEmpty())
            {
                break label0;
            }
            obj1 = ((Map) (obj1)).entrySet().iterator();
            java.util.Map.Entry entry;
            do
            {
                c2 = c1;
                if (!((Iterator) (obj1)).hasNext())
                {
                    break label0;
                }
                entry = (java.util.Map.Entry)((Iterator) (obj1)).next();
            } while (!com.kahuna.sdk.v.a((String)entry.getKey(), c1.a()));
            c2 = new c(c1);
            c2.a((String)entry.getValue());
            if (a)
            {
                Log.w("Kahuna", (new StringBuilder()).append("Mapped event name from: ").append(c1.a()).append(" to:").append(c2.a()).toString());
            }
        }
        obj1 = R.l();
        c1 = R.k();
        if (obj1 == null || ((Set) (obj1)).isEmpty()) goto _L8; else goto _L7
_L7:
        c1 = ((Set) (obj1)).iterator();
        do
        {
            if (!c1.hasNext())
            {
                break MISSING_BLOCK_LABEL_876;
            }
        } while (!com.kahuna.sdk.v.a((String)c1.next(), c2.a()));
_L23:
        obj1 = c2;
        if (flag) goto _L6; else goto _L9
_L9:
        if (a)
        {
            Log.w("Kahuna", (new StringBuilder()).append("Ignoring event: ").append(c2.a()).append(" not in include list.").toString());
            return;
        }
          goto _L4
_L8:
        obj1 = c2;
        if (c1 == null) goto _L6; else goto _L10
_L10:
        obj1 = c2;
        if (c1.isEmpty()) goto _L6; else goto _L11
_L11:
        c1 = c1.iterator();
_L15:
        if (!c1.hasNext()) goto _L13; else goto _L12
_L12:
        if (!com.kahuna.sdk.v.a((String)c1.next(), c2.a())) goto _L15; else goto _L14
_L14:
        flag = true;
_L22:
        obj1 = c2;
        if (!flag) goto _L6; else goto _L16
_L16:
        if (a)
        {
            Log.w("Kahuna", (new StringBuilder()).append("Ignoring event: ").append(c2.a()).append(" in exclude list.").toString());
            return;
        }
          goto _L4
_L6:
        a(((c) (obj1)), R.m());
        if (!com.kahuna.sdk.d.a(((c) (obj1)).a().toLowerCase()) || ((c) (obj1)).e())
        {
            break MISSING_BLOCK_LABEL_717;
        }
        Object obj2 = A;
        obj2;
        JVM INSTR monitorenter ;
        obj = com.kahuna.sdk.d.a(((c) (obj1)).a(), ((c) (obj1)).b());
        if (obj != null) goto _L18; else goto _L17
_L17:
        d(((c) (obj1)));
        if (a)
        {
            Log.d("Kahuna", (new StringBuilder()).append("Queueing event:").append(((c) (obj1)).a()).toString());
        }
        com.kahuna.sdk.d.a(((c) (obj1)));
        c1 = ((c) (obj1));
_L20:
        c1.j();
        if (a)
        {
            Log.d("Kahuna", (new StringBuilder()).append("incrementing bucket count for event:").append(c1.a()).toString());
        }
        if (((c) (obj1)).f() > 0)
        {
            if (c1.f() < 0)
            {
                c1.a(0);
            }
            c1.a(c1.f() + ((c) (obj1)).f());
        }
        if (((c) (obj1)).g() > 0)
        {
            if (c1.g() < 0)
            {
                c1.b(0);
            }
            c1.b(c1.g() + ((c) (obj1)).g());
        }
        obj2;
        JVM INSTR monitorexit ;
_L21:
        if (!p)
        {
            break MISSING_BLOCK_LABEL_860;
        }
        synchronized (D)
        {
            if (!E)
            {
                break MISSING_BLOCK_LABEL_849;
            }
        }
        return;
        obj;
        c1;
        JVM INSTR monitorexit ;
        throw obj;
_L18:
        c1 = ((c) (obj));
        if (!"k_user_attributes".equals(((c) (obj1)).a())) goto _L20; else goto _L19
_L19:
        a(((c) (obj1)), ((c) (obj)));
        c1 = ((c) (obj));
          goto _L20
        c1;
        obj2;
        JVM INSTR monitorexit ;
        throw c1;
        if (!com.kahuna.sdk.v.a(B) && "k_user_attributes".equals(((c) (obj1)).a()) && "k_user_attributes".equals(((c)B.get(B.size() - 1)).a()))
        {
            a(((c) (obj1)), (c)B.get(B.size() - 1));
        } else
        {
            d(((c) (obj1)));
            if (a)
            {
                Log.d("Kahuna", (new StringBuilder()).append("Queueing event:").append(((c) (obj1)).a()).toString());
            }
        }
          goto _L21
        c1;
        JVM INSTR monitorexit ;
        d(((c) (obj1)).a());
        return;
        Log.d("Kahuna", "Please call the method onAppCreate() with your secretKey before trackEvent otherwise events cannot be logged");
        return;
_L13:
        flag = false;
          goto _L22
        flag = false;
          goto _L23
    }

    static void c(m m1)
    {
        m1.i();
    }

    static Object d(m m1)
    {
        return m1.A;
    }

    private void d(c c1)
    {
        synchronized (A)
        {
            c1.a(X.getAndIncrement());
            B.add(c1);
        }
        return;
        c1;
        obj;
        JVM INSTR monitorexit ;
        throw c1;
    }

    private void d(String s1)
    {
        boolean flag1;
        long l1;
label0:
        {
            l1 = 0L;
            flag1 = true;
            synchronized (A)
            {
                if (!com.kahuna.sdk.v.a(B))
                {
                    break label0;
                }
            }
            return;
        }
        int i1 = B.size();
        obj;
        JVM INSTR monitorexit ;
        if (!R.e().contains(s1.toLowerCase())) goto _L2; else goto _L1
_L1:
        boolean flag = flag1;
_L4:
        if (!flag)
        {
            break; /* Loop/switch isn't completed */
        }
        s1 = ((String) (F));
        s1;
        JVM INSTR monitorenter ;
        if (G != null)
        {
            G.cancel();
            G = null;
        }
        G = new a();
        if (S == 0L)
        {
            l1 = 2000L;
        }
        G.schedule(new b(), l1);
        s1;
        JVM INSTR monitorexit ;
        return;
        obj;
        s1;
        JVM INSTR monitorexit ;
        throw obj;
        s1;
        obj;
        JVM INSTR monitorexit ;
        throw s1;
_L2:
        flag = flag1;
        if ((long)i1 < R.d())
        {
            long l3 = System.currentTimeMillis() / 1000L;
            flag = flag1;
            if (R.c() + S >= l3)
            {
                flag = false;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (R.i().contains(s1.toLowerCase()))
        {
            long l2 = R.h() * 1000L;
            synchronized (F)
            {
                if (G != null && G.a() - System.currentTimeMillis() > l2)
                {
                    G.cancel();
                    G = null;
                }
                if (G == null)
                {
                    G = new a();
                    G.schedule(new b(), l2);
                }
            }
            return;
        }
        break MISSING_BLOCK_LABEL_322;
        exception;
        s1;
        JVM INSTR monitorexit ;
        throw exception;
        synchronized (F)
        {
            if (G == null)
            {
                G = new a();
                G.schedule(new b(), R.c() * 1000L);
            }
        }
        return;
        exception1;
        s1;
        JVM INSTR monitorexit ;
        throw exception1;
    }

    static List e(m m1)
    {
        return m1.B;
    }

    static AtomicLong f(m m1)
    {
        return m1.X;
    }

    static AtomicInteger g(m m1)
    {
        return m1.J;
    }

    static String h(m m1)
    {
        return m1.o;
    }

    static String i(m m1)
    {
        return m1.u;
    }

    private void i()
    {
        this;
        JVM INSTR monitorenter ;
        if (m == null)
        {
            throw new IllegalStateException("You did not call onAppCreate() in your MainApplication's onCreate() method.");
        }
        break MISSING_BLOCK_LABEL_25;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        boolean flag = p;
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (a)
        {
            Log.d("Kahuna", "Initializing SDK version: 2.0.3");
        }
        ApplicationInfo applicationinfo = m.getApplicationInfo();
        s = m.getString(applicationinfo.labelRes);
        t = m.getPackageManager().getPackageInfo(m.getPackageName(), 0).versionName;
_L3:
        u = D();
        v = android.os.Build.VERSION.RELEASE;
        x = Build.MODEL;
        q = com.kahuna.sdk.r.b(m);
_L5:
        J = new AtomicInteger();
        synchronized (A)
        {
            if (B == null)
            {
                B = new ArrayList();
            }
        }
        E = false;
        p = true;
        d = com.kahuna.sdk.v.a(m);
        R = com.kahuna.sdk.s.a(m);
        com.kahuna.sdk.d.a(R.p());
        S = com.kahuna.sdk.r.h(m);
        if (a)
        {
            Log.d("Kahuna", (new StringBuilder()).append("Loading SDK Config:").append(R.a()).append(" flushInterval: ").append(R.b()).append(" flushEventCount: ").append(R.d()).append(" events:").append(R.e()).toString());
        }
          goto _L1
        obj;
        if (a)
        {
            Log.d("Kahuna", (new StringBuilder()).append("Exception occured trying to set appName and/or appVersion:").append(obj).toString());
        }
        t = "";
        s = "unknown";
          goto _L3
        obj;
        if (!a) goto _L5; else goto _L4
_L4:
        Log.d("Kahuna", (new StringBuilder()).append("Exception occured trying to retrieve previous push enabled setting:").append(obj).toString());
          goto _L5
        exception1;
        obj;
        JVM INSTR monitorexit ;
        throw exception1;
          goto _L1
    }

    protected static m j()
    {
        return g;
    }

    static boolean j(m m1)
    {
        return m1.d;
    }

    static Timer k(m m1)
    {
        return m1.K;
    }

    static boolean l(m m1)
    {
        return m1.q;
    }

    protected static o m()
    {
        return L;
    }

    static void m(m m1)
    {
        m1.B();
    }

    static Object n(m m1)
    {
        return m1.F;
    }

    static a o(m m1)
    {
        return m1.G;
    }

    static void p(m m1)
    {
        m1.x();
    }

    static Map q(m m1)
    {
        return m1.y();
    }

    protected static boolean q()
    {
        return Q;
    }

    static Object r(m m1)
    {
        return m1.D;
    }

    static String s(m m1)
    {
        return m1.s;
    }

    public static boolean s()
    {
        return a;
    }

    static Object t()
    {
        return f;
    }

    static String t(m m1)
    {
        return m1.t;
    }

    static String u(m m1)
    {
        return m1.v;
    }

    static boolean u()
    {
        return M;
    }

    static String v(m m1)
    {
        return m1.w;
    }

    static boolean v()
    {
        return U;
    }

    static String w(m m1)
    {
        return m1.x;
    }

    static boolean w()
    {
        return V;
    }

    static String x(m m1)
    {
        return m1.z;
    }

    private void x()
    {
        com.kahuna.sdk.r.b(null, m);
        com.kahuna.sdk.r.c(null, m);
    }

    static String y(m m1)
    {
        return m1.j;
    }

    private Map y()
    {
        this;
        JVM INSTR monitorenter ;
        Map map = com.kahuna.sdk.r.f(m);
_L2:
        Object obj1;
        obj1 = map;
        if (map != null)
        {
            break MISSING_BLOCK_LABEL_24;
        }
        obj1 = new HashMap();
        this;
        JVM INSTR monitorexit ;
        return ((Map) (obj1));
        Object obj;
        obj;
        if (a)
        {
            Log.d("Kahuna", (new StringBuilder()).append("Exception attempting to retrieve stored attributes:").append(obj).toString());
        }
        obj = null;
        if (true) goto _L2; else goto _L1
_L1:
        obj;
        throw obj;
    }

    static String z(m m1)
    {
        return m1.k;
    }

    private boolean z()
    {
label0:
        {
            synchronized (A)
            {
                Set set = R.e();
                if (set.size() <= 0 || B.size() <= 0)
                {
                    break label0;
                }
                Iterator iterator = B.iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break label0;
                    }
                } while (!set.contains(((c)iterator.next()).a().toLowerCase()));
            }
            return true;
        }
        obj;
        JVM INSTR monitorexit ;
        return false;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void a()
    {
        try
        {
            T.execute(new l(new Runnable() {

                final m a;

                public void run()
                {
                    if (!m.b(a))
                    {
                        m.c(a);
                    }
                    Object obj = m.t();
                    obj;
                    JVM INSTR monitorenter ;
                    if (m.g(a).incrementAndGet() == 1)
                    {
                        if (com.kahuna.sdk.p.a())
                        {
                            com.kahuna.sdk.p.a(m.h(a), m.i(a), m.j(a));
                        }
                        m.a(com.kahuna.sdk.p.b(m.a(a)));
                        if (m.k(a) == null)
                        {
                            break MISSING_BLOCK_LABEL_112;
                        }
                        m.k(a).cancel();
                        m.a(a, null);
                        return;
                    }
                      goto _L1
                    if (!m.l(a) || com.kahuna.sdk.v.a(m.c)) goto _L3; else goto _L2
_L2:
                    Object obj1 = com.kahuna.sdk.h.b();
                    if (!"".equals(obj1)) goto _L5; else goto _L4
_L4:
                    if (m.a)
                    {
                        Log.d("Kahuna", "Device not registered yet, will now register with GCM");
                    }
                    a.c("");
                    com.kahuna.sdk.h.a(m.c);
_L3:
                    m.a(a, new c("Start"));
                    Object obj3 = m.a(a).getResources().getConfiguration().locale;
                    obj1 = TimeZone.getDefault();
                    obj1 = ((TimeZone) (obj1)).getDisplayName(((TimeZone) (obj1)).inDaylightTime(new Date(System.currentTimeMillis())), 0);
                    obj3 = ((Locale) (obj3)).getLanguage();
                    HashMap hashmap = new HashMap();
                    hashmap.put("kahuna_tz", obj1);
                    hashmap.put("kahuna_lang", obj3);
                    m.a(a, hashmap);
_L7:
                    m.m(a);
_L1:
                    com.kahuna.sdk.n.a();
                    return;
_L5:
                    a.c(((String) (obj1)));
                    if (m.a)
                    {
                        Log.d("Kahuna", "Device already registered");
                    }
                      goto _L3
                    Object obj2;
                    obj2;
                    obj;
                    JVM INSTR monitorexit ;
                    throw obj2;
                    obj2;
                    if (!m.a) goto _L7; else goto _L6
_L6:
                    Log.d("Kahuna", (new StringBuilder()).append("Exception occured trying to retrieve app language or timezone:").append(obj2).toString());
                      goto _L7
                }

            
            {
                a = m.this;
                super();
            }
            }));
            return;
        }
        catch (Exception exception)
        {
            Log.d("Kahuna", (new StringBuilder()).append("Handled exception in KahunaCommon.start(): ").append(exception).toString());
        }
    }

    public void a(Context context, String s1, String s2)
    {
        if (context == null)
        {
            throw new IllegalArgumentException("Must have valid Application context to use Kahuna Analytics.");
        }
        if (com.kahuna.sdk.v.a(s1))
        {
            throw new IllegalArgumentException("Attempted to start Kahuna with invalid key! You must use your api Key with Kahuna");
        }
        m = context;
        o = s1;
        c = s2;
        if (a)
        {
            Log.d("Kahuna", (new StringBuilder()).append("Called onCreate with Key:").append(o).toString());
        }
        com.kahuna.sdk.h.a(m);
        ahj.a(m);
        T.execute(new l(new Runnable(context) {

            final Context a;
            final m b;

            public void run()
            {
                Object obj;
                Object obj1;
                com.kahuna.sdk.t.a(m.j(), m.a(b));
                if (!m.b(b))
                {
                    m.c(b);
                }
                com.kahuna.sdk.p.a(m.a(b));
                com.kahuna.sdk.h.a();
                com.kahuna.sdk.w.a(a);
                com.kahuna.sdk.a a1;
                try
                {
                    ahj.a(m.j());
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    if (m.a)
                    {
                        Log.w("Kahuna", "Caught error when attepmting to initialize location services. If you are NOT using location services please ignore this error: ");
                        Log.w("Kahuna", ((Throwable) (obj)));
                    }
                    continue; /* Loop/switch isn't completed */
                }
_L6:
                a1 = com.kahuna.sdk.r.a(m.a(b), false);
                obj1 = m.d(b);
                obj1;
                JVM INSTR monitorenter ;
                m.a(b, a1.a());
                if (m.e(b).isEmpty()) goto _L2; else goto _L1
_L1:
                obj = (c)m.e(b).get(m.e(b).size() - 1);
_L3:
                if (obj == null)
                {
                    break MISSING_BLOCK_LABEL_231;
                }
                if (((c) (obj)).k() <= 0L)
                {
                    break MISSING_BLOCK_LABEL_231;
                }
                m.f(b).set(((c) (obj)).k() + 1L);
_L4:
                obj1;
                JVM INSTR monitorexit ;
                com.kahuna.sdk.d.a(m.e(b));
                m.a(b, a1.b());
                m.a(b, a1.c());
                return;
_L2:
                obj = null;
                  goto _L3
                m.f(b).set(com.kahuna.sdk.r.m(m.a(b)));
                  goto _L4
                Exception exception;
                exception;
                obj1;
                JVM INSTR monitorexit ;
                throw exception;
                if (true) goto _L6; else goto _L5
_L5:
            }

            
            {
                b = m.this;
                a = context;
                super();
            }
        }));
    }

    public void a(ahg ahg, String s1)
    {
        T.execute(new l(new Runnable(ahg, s1) {

            final ahg a;
            final String b;
            final m c;

            public void run()
            {
                try
                {
                    HashMap hashmap = new HashMap();
                    hashmap.put("id", a.a());
                    hashmap.put("status", b);
                    hashmap.put("type", "beacon");
                    if (a.c() > -1)
                    {
                        hashmap.put("major", Integer.valueOf(a.c()));
                    }
                    if (a.d() > -1)
                    {
                        hashmap.put("minor", Integer.valueOf(a.d()));
                    }
                    c c1 = new c("k_user_location", System.currentTimeMillis() / 1000L);
                    c1.c(hashmap);
                    m.a(c, c1);
                    return;
                }
                catch (Exception exception)
                {
                    Log.d("Kahuna", (new StringBuilder()).append("Handled exception in KahunaCommon.trackRegionMonitoringEvent(): ").append(exception).toString());
                }
            }

            
            {
                c = m.this;
                a = ahg1;
                b = s1;
                super();
            }
        }));
    }

    public void a(c c1)
    {
        b(c1);
    }

    public void a(j j1)
        throws com.kahuna.sdk.b
    {
        T.execute(new l(new Runnable(j1) {

            final j a;
            final m b;

            public void run()
            {
                Object obj;
                Object obj1;
                obj1 = com.kahuna.sdk.r.e(m.a(b));
                if (a != null)
                {
                    obj = a.a();
                } else
                {
                    obj = new HashMap();
                }
                if (!((Map) (obj1)).isEmpty()) goto _L2; else goto _L1
_L1:
                if (!com.kahuna.sdk.v.a(a)) goto _L4; else goto _L3
_L3:
                return;
_L4:
                boolean flag;
                if (m.a)
                {
                    Log.d("Kahuna", (new StringBuilder()).append("login() called and no previous credentials found. Storing new credentials: ").append(obj).toString());
                }
                com.kahuna.sdk.r.b(((Map) (obj)), m.a(b));
                flag = true;
_L7:
                if (flag)
                {
                    obj1 = new c("k_user_login");
                    ((c) (obj1)).a(((Map) (obj)));
                    m.a(b, ((c) (obj1)));
                    return;
                }
                  goto _L5
_L2:
                if (com.kahuna.sdk.v.a(a))
                {
                    if (m.a)
                    {
                        Log.d("Kahuna", "login() called with previous credentials but new credentials are empty. Triggering empty k_user_login.");
                    }
                    m.p(b);
                    flag = true;
                    obj = null;
                } else
                if (!a.a(new u(((Map) (obj1)))))
                {
                    if (com.kahuna.sdk.v.a(((Map) (obj1)), ((Map) (obj))))
                    {
                        for (obj = ((Map) (obj)).entrySet().iterator(); ((Iterator) (obj)).hasNext();)
                        {
                            java.util.Map.Entry entry = (java.util.Map.Entry)((Iterator) (obj)).next();
                            if (((Map) (obj1)).containsKey(entry.getKey()))
                            {
                                ((Set)((Map) (obj1)).get(entry.getKey())).addAll((Collection)entry.getValue());
                            } else
                            {
                                ((Map) (obj1)).put(entry.getKey(), entry.getValue());
                            }
                        }

                        if (m.a)
                        {
                            Log.d("Kahuna", (new StringBuilder()).append("login() called with overlapping credentials. Merging all credentials: ").append(obj1).toString());
                        }
                        com.kahuna.sdk.r.b(((Map) (obj1)), m.a(b));
                        flag = true;
                        obj = obj1;
                    } else
                    {
                        if (m.a)
                        {
                            Log.d("Kahuna", "login() called with no overlapping credentials. Sending up only new credentials.");
                        }
                        m.p(b);
                        com.kahuna.sdk.r.b(((Map) (obj)), m.a(b));
                        flag = true;
                    }
                } else
                {
                    if (m.a)
                    {
                        Log.d("Kahuna", "login() called with no change in credentials.");
                    }
                    flag = false;
                    obj = null;
                }
                if (true) goto _L7; else goto _L6
_L6:
_L5:
                if (true) goto _L3; else goto _L8
_L8:
            }

            
            {
                b = m.this;
                a = j1;
                super();
            }
        }));
        if (j1 == null || j1.b())
        {
            Log.e("Kahuna", "You cannot call login() with null or empty credentials.");
            throw new com.kahuna.sdk.b("You cannot call login without setting any credentials.");
        } else
        {
            return;
        }
    }

    public void a(Class class1)
    {
        com.kahuna.sdk.w.a(class1);
    }

    public void a(String s1)
    {
        a(s1, -1, -1, false);
    }

    protected void a(String s1, String s2)
    {
        T.execute(new l(new Runnable(s1, s2) {

            final String a;
            final String b;
            final m c;

            public void run()
            {
                try
                {
                    HashMap hashmap = new HashMap();
                    hashmap.put("id", a);
                    hashmap.put("status", b);
                    hashmap.put("type", "circle");
                    c c1 = new c("k_user_location");
                    c1.c(hashmap);
                    m.a(c, c1);
                    return;
                }
                catch (Exception exception)
                {
                    Log.d("Kahuna", (new StringBuilder()).append("Handled exception in KahunaCommon.trackRegionMonitoringEvent(): ").append(exception).toString());
                }
            }

            
            {
                c = m.this;
                a = s1;
                b = s2;
                super();
            }
        }));
    }

    public void a(Map map)
    {
        T.execute(new l(new Runnable(map) {

            final Map a;
            final m b;

            public void run()
            {
                m.a(b, a);
            }

            
            {
                b = m.this;
                a = map;
                super();
            }
        }));
    }

    public void b()
    {
        try
        {
            T.execute(new l(new Runnable() {

                final m a;

                public void run()
                {
                    Object obj = m.t();
                    obj;
                    JVM INSTR monitorenter ;
                    int i1;
                    i1 = m.g(a).decrementAndGet();
                    if (m.a)
                    {
                        Log.d("Kahuna", (new StringBuilder()).append("Called stop, remaining activities in foreground is: ").append(i1).toString());
                    }
                    if (i1 != 0)
                    {
                        break MISSING_BLOCK_LABEL_169;
                    }
                    if (m.k(a) != null)
                    {
                        m.k(a).cancel();
                        m.a(a, null);
                    }
                    m.a(a, new Timer());
                    m.k(a).schedule(new TimerTask(this) {

                        final _cls9 a;

                        public void run()
                        {
                            Object obj = m.t();
                            obj;
                            JVM INSTR monitorenter ;
                            int i1;
                            if (m.k(a.a) != null)
                            {
                                m.k(a.a).cancel();
                                m.a(a.a, null);
                            }
                            i1 = m.g(a.a).get();
                            if (i1 <= 0)
                            {
                                break MISSING_BLOCK_LABEL_67;
                            }
                            obj;
                            JVM INSTR monitorexit ;
                            return;
                            synchronized (m.n(a.a))
                            {
                                if (m.o(a.a) != null)
                                {
                                    m.o(a.a).cancel();
                                    m.a(a.a, null);
                                }
                            }
                            m.b(a.a, "k_app_bg");
_L2:
                            obj;
                            JVM INSTR monitorexit ;
                            return;
                            obj1;
                            obj;
                            JVM INSTR monitorexit ;
                            throw obj1;
                            exception1;
                            obj1;
                            JVM INSTR monitorexit ;
                            throw exception1;
                            Exception exception;
                            exception;
                            if (!m.a) goto _L2; else goto _L1
_L1:
                            Log.d("Kahuna", (new StringBuilder()).append("Handled exception in KahunaCommon.stop() timer: ").append(exception).toString());
                              goto _L2
                        }

            
            {
                a = _pcls9;
                super();
            }
                    }, 5000L);
                    synchronized (m.d(a))
                    {
                        com.kahuna.sdk.r.a(m.e(a), m.a(a));
                    }
                    com.kahuna.sdk.r.b(m.f(a).get(), m.a(a));
                    obj;
                    JVM INSTR monitorexit ;
                    return;
                    exception2;
                    obj1;
                    JVM INSTR monitorexit ;
                    throw exception2;
                    Exception exception1;
                    exception1;
                    obj;
                    JVM INSTR monitorexit ;
                    throw exception1;
                }

            
            {
                a = m.this;
                super();
            }
            }));
            return;
        }
        catch (Exception exception)
        {
            Log.d("Kahuna", (new StringBuilder()).append("Handled exception in KahunaCommon.stop(): ").append(exception).toString());
        }
    }

    public void b(String s1)
    {
        try
        {
            c c1 = new c("k_push_clicked", System.currentTimeMillis() / 1000L);
            c1.b(s1);
            if (O)
            {
                c1.c();
            }
            c(c1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            Log.d("Kahuna", (new StringBuilder()).append("Handled exception in KahunaCommon.trackPushClicked(): ").append(s1).toString());
        }
    }

    public j c()
    {
        return new u();
    }

    protected void c(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        if (!com.kahuna.sdk.v.a(s1)) goto _L2; else goto _L1
_L1:
        z = "";
        com.kahuna.sdk.r.b(z, m);
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        z = s1;
        if (com.kahuna.sdk.v.a(com.kahuna.sdk.r.c(m)))
        {
            c(new c("k_push_enabled"));
        }
        com.kahuna.sdk.r.b(z, m);
        if (true) goto _L4; else goto _L3
_L3:
        s1;
        throw s1;
    }

    public j d()
    {
        j j1;
        try
        {
            j1 = (j)T.submit(new Callable() {

                final m a;

                public j a()
                {
                    return new u(com.kahuna.sdk.r.e(m.a(a)));
                }

                public Object call()
                    throws Exception
                {
                    return a();
                }

            
            {
                a = m.this;
                super();
            }
            }).get();
        }
        catch (Exception exception)
        {
            if (a)
            {
                Log.d("Kahuna", (new StringBuilder()).append("Exception attempting to retrieve stored credentials:").append(exception).toString());
            }
            return c();
        }
        return j1;
    }

    public void e()
    {
        T.execute(new l(new Runnable() {

            final m a;

            public void run()
            {
                try
                {
                    m.p(a);
                    m.a(a, new c("k_user_logout"));
                    return;
                }
                catch (Exception exception)
                {
                    Log.d("Kahuna", (new StringBuilder()).append("Handled exception in KahunaCommon.logout(): ").append(exception).toString());
                    exception.printStackTrace();
                    return;
                }
            }

            
            {
                a = m.this;
                super();
            }
        }));
    }

    public void f()
    {
        T.execute(new l(new Runnable() {

            final m a;

            public void run()
            {
                if (!m.b(a))
                {
                    Log.e("Kahuna", "You need to call onAppCreate() before any other call to the SDK. Ignoring enablePush request");
                } else
                if (!m.l(a))
                {
                    m.a(a, true);
                    com.kahuna.sdk.r.a(m.l(a), m.a(a));
                    m.a(a, new c("k_push_enabled"));
                    return;
                }
            }

            
            {
                a = m.this;
                super();
            }
        }));
    }

    public boolean g()
    {
        if (m == null)
        {
            Log.d("Kahuna", "Error, push state unknown. You must call onAppCreate() before getting the current status of push.");
        }
        return q;
    }

    public void h()
    {
        Q = true;
    }

    protected String k()
    {
        return o;
    }

    public void l()
    {
        T.execute(new l(new Runnable() {

            final m a;

            public void run()
            {
                if (!m.b(a))
                {
                    Log.e("Kahuna", "You need to call onAppCreate() before any other call to the SDK. Ignoring disablePush request");
                } else
                if (m.l(a))
                {
                    m.a(a, false);
                    com.kahuna.sdk.r.a(m.l(a), m.a(a));
                    m.a(a, new c("k_push_disabled"));
                    return;
                }
            }

            
            {
                a = m.this;
                super();
            }
        }));
    }

    public int n()
    {
        return N;
    }

    public boolean o()
    {
        return O;
    }

    public boolean p()
    {
        while (!p || !P || J.get() <= 0) 
        {
            return true;
        }
        return false;
    }

    protected String r()
    {
        return "2.0.3";
    }

}
