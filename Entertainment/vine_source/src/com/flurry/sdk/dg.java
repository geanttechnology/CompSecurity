// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.os.SystemClock;
import com.flurry.android.impl.analytics.FlurryAnalyticsModule;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.flurry.sdk:
//            cv, el, cz, cu, 
//            fa, dh, fb, cy, 
//            dk, da, dm, dn, 
//            do, dj, dy, em, 
//            dl, cx, dw, df, 
//            de, fc, dt, dv, 
//            dx, di

public class dg
    implements dj.b, dn.a
{

    static int a = 100;
    static int b = 10;
    static int c = 1000;
    static int d = 0x27100;
    static int e = 50;
    static int f = 20;
    private static final String g = com/flurry/sdk/dg.getSimpleName();
    private String A;
    private String B;
    private byte C;
    private Location D;
    private boolean E;
    private String F;
    private byte G;
    private long H;
    private long I;
    private final Map J = new HashMap();
    private final List K = new ArrayList();
    private boolean L;
    private int M;
    private final List N = new ArrayList();
    private int O;
    private int P;
    private final cv Q = new cv();
    private Map R;
    private dj S;
    private int T;
    private boolean U;
    private final AtomicInteger h = new AtomicInteger(0);
    private final AtomicInteger i = new AtomicInteger(0);
    private final AtomicInteger j = new AtomicInteger(0);
    private final String k;
    private String l;
    private WeakReference m;
    private File n;
    private List o;
    private final Map p = new HashMap();
    private boolean q;
    private long r;
    private List s;
    private com.google.android.gms.ads.identifier.AdvertisingIdClient.Info t;
    private byte u[];
    private String v;
    private long w;
    private long x;
    private long y;
    private long z;

    public dg(String s1)
    {
        n = null;
        s = new ArrayList();
        A = "";
        B = "";
        C = -1;
        U = false;
        el.a(4, g, "Creating new Flurry session");
        k = s1;
        m = new WeakReference(null);
    }

    private void A()
    {
        cz cz1;
        el.a(3, g, "generating agent report");
        cz1 = new cz(k, l, q, o(), r, w, s, p(), Q.a(false), a(), cu.a().b(), System.currentTimeMillis());
        o = new ArrayList(s);
        if (cz1 == null)
        {
            break MISSING_BLOCK_LABEL_180;
        }
        if (cz1.a() != null)
        {
            el.a(3, g, (new StringBuilder()).append("generated report of size ").append(cz1.a().length).append(" with ").append(s.size()).append(" reports.").toString());
            a(cz1.a());
            s.removeAll(o);
            o = null;
            B();
            return;
        }
        try
        {
            el.d(g, "Error generating report");
            return;
        }
        catch (Throwable throwable)
        {
            el.a(6, g, "", throwable);
        }
        return;
    }

    private void B()
    {
        this;
        JVM INSTR monitorenter ;
        if (fa.a(n)) goto _L2; else goto _L1
_L1:
        el.d(g, "Error persisting report: could not create directory");
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        DataOutputStream dataoutputstream = new DataOutputStream(new FileOutputStream(n));
        dh dh1 = new dh();
        dh1.a(q);
        dh1.a(r);
        dh1.a(s);
        dh1.a(dataoutputstream, k, i());
        continue; /* Loop/switch isn't completed */
        Object obj;
        obj;
        el.b(g, "Error saving persistent data", ((Throwable) (obj)));
        if (true) goto _L4; else goto _L3
_L3:
        obj;
        throw obj;
    }

    private void C()
    {
        Object obj = null;
        this;
        JVM INSTR monitorenter ;
        boolean flag2;
        el.a(4, g, (new StringBuilder()).append("Loading persistent data: ").append(n.getAbsolutePath()).toString());
        flag2 = n.exists();
        if (!flag2) goto _L2; else goto _L1
_L1:
        Object obj1 = new FileInputStream(n);
        DataInputStream datainputstream = new DataInputStream(((java.io.InputStream) (obj1)));
        obj = new dh();
        ((dh) (obj)).a(datainputstream, k);
        q = ((dh) (obj)).a();
        r = ((dh) (obj)).c();
        s = ((dh) (obj)).b();
        boolean flag = true;
        fb.a(datainputstream);
        fb.a(((java.io.Closeable) (obj1)));
_L3:
        boolean flag1;
        flag1 = flag;
        if (flag)
        {
            break MISSING_BLOCK_LABEL_156;
        }
        el.a(3, g, "Deleting agent cache file");
        n.delete();
        flag1 = flag;
_L4:
        if (flag1)
        {
            break MISSING_BLOCK_LABEL_174;
        }
        q = false;
        r = w;
        this;
        JVM INSTR monitorexit ;
        return;
        obj1;
        datainputstream = null;
_L6:
        el.b(g, "Error loading persistent data", ((Throwable) (obj1)));
        fb.a(datainputstream);
        fb.a(((java.io.Closeable) (obj)));
        flag = false;
          goto _L3
_L5:
        fb.a(datainputstream);
        fb.a(((java.io.Closeable) (obj1)));
        throw obj;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
_L2:
        el.a(4, g, "Agent cache file doesn't exist.");
        flag1 = false;
          goto _L4
        obj;
        datainputstream = null;
          goto _L5
        obj;
          goto _L5
        Object obj2;
        obj2;
        obj1 = obj;
        obj = obj2;
          goto _L5
        obj2;
        datainputstream = null;
        obj = obj1;
        obj1 = obj2;
          goto _L6
        obj2;
        obj = obj1;
        obj1 = obj2;
          goto _L6
        obj;
        datainputstream = null;
        obj1 = null;
          goto _L5
    }

    private void D()
    {
        T = T + 1;
    }

    private void E()
    {
        if (T > 0)
        {
            T = T - 1;
        }
    }

    private String F()
    {
        return (new StringBuilder()).append(".flurryagent.").append(Integer.toString(k.hashCode(), 16)).toString();
    }

    private int G()
    {
        return h.incrementAndGet();
    }

    private int H()
    {
        return i.incrementAndGet();
    }

    static com.google.android.gms.ads.identifier.AdvertisingIdClient.Info a(dg dg1, com.google.android.gms.ads.identifier.AdvertisingIdClient.Info info)
    {
        dg1.t = info;
        return info;
    }

    static String a(dg dg1, String s1)
    {
        dg1.v = s1;
        return s1;
    }

    private void a(long l1)
    {
        this;
        JVM INSTR monitorenter ;
        Iterator iterator = K.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            cy cy1 = (cy)iterator.next();
            if (cy1.a() && !cy1.b())
            {
                cy1.a(l1);
            }
        } while (true);
        break MISSING_BLOCK_LABEL_62;
        Exception exception;
        exception;
        throw exception;
        this;
        JVM INSTR monitorexit ;
    }

    static void a(dg dg1)
    {
        dg1.C();
    }

    private void a(do do1, ByteBuffer bytebuffer)
    {
        synchronized (p)
        {
            p.put(do1, bytebuffer);
        }
        return;
        do1;
        map;
        JVM INSTR monitorexit ;
        throw do1;
    }

    private void a(byte abyte0[])
    {
        da da1 = FlurryAnalyticsModule.getInstance().a();
        String s1 = (new StringBuilder()).append("").append(dk.a().b()).toString();
        da1.b(abyte0, k, s1);
    }

    static byte[] a(dg dg1, byte abyte0[])
    {
        dg1.u = abyte0;
        return abyte0;
    }

    static void b(dg dg1)
    {
        dg1.v();
    }

    static List c(dg dg1)
    {
        return dg1.s;
    }

    private Map d(Context context)
    {
        Object obj = null;
        HashMap hashmap = obj;
        if (context instanceof Activity)
        {
            Bundle bundle = ((Activity)context).getIntent().getExtras();
            hashmap = obj;
            if (bundle != null)
            {
                el.a(3, g, (new StringBuilder()).append("Launch Options Bundle is present ").append(bundle.toString()).toString());
                hashmap = new HashMap();
                Iterator iterator = bundle.keySet().iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    String s1 = (String)iterator.next();
                    if (s1 != null)
                    {
                        context = ((Context) (bundle.get(s1)));
                        if (context != null)
                        {
                            context = context.toString();
                        } else
                        {
                            context = "null";
                        }
                        hashmap.put(s1, new ArrayList(Arrays.asList(new String[] {
                            context
                        })));
                        el.a(3, g, (new StringBuilder()).append("Launch options Key: ").append(s1).append(". Its value: ").append(context).toString());
                    }
                } while (true);
            }
        }
        return hashmap;
    }

    static void d(dg dg1)
    {
        dg1.B();
    }

    static void e(dg dg1)
    {
        dg1.y();
    }

    private void u()
    {
        dn dn1 = dm.a();
        G = ((Byte)dn1.a("Gender")).byteValue();
        dn1.a("Gender", this);
        el.a(4, g, (new StringBuilder()).append("initSettings, Gender = ").append(G).toString());
        F = (String)dn1.a("UserId");
        dn1.a("UserId", this);
        el.a(4, g, (new StringBuilder()).append("initSettings, UserId = ").append(F).toString());
        E = ((Boolean)dn1.a("LogEvents")).booleanValue();
        dn1.a("LogEvents", this);
        el.a(4, g, (new StringBuilder()).append("initSettings, LogEvents = ").append(E).toString());
        H = ((Long)dn1.a("Age")).longValue();
        dn1.a("Age", this);
        el.a(4, g, (new StringBuilder()).append("initSettings, BirthDate = ").append(H).toString());
        I = ((Long)dn1.a("ContinueSessionMillis")).longValue();
        dn1.a("ContinueSessionMillis", this);
        el.a(4, g, (new StringBuilder()).append("initSettings, ContinueSessionMillis = ").append(I).toString());
    }

    private void v()
    {
        try
        {
            if (v != null)
            {
                el.a(3, g, "Fetched phone id");
                a(do.a, ByteBuffer.wrap(v.getBytes()));
            }
            if (u != null)
            {
                el.a(3, g, "Fetched hashed IMEI");
                a(do.b, ByteBuffer.wrap(u));
            }
            if (t != null)
            {
                el.a(3, g, "Fetched advertising id");
                a(do.c, ByteBuffer.wrap(t.getId().getBytes()));
            }
            A();
            return;
        }
        catch (Throwable throwable)
        {
            el.a(6, g, "", throwable);
        }
    }

    private void w()
    {
        a(new fc() {

            final dg a;

            public void a()
            {
                de de1 = a.d();
                dg.c(a).clear();
                dg.c(a).add(de1);
                dg.d(a);
            }

            
            {
                a = dg.this;
                super();
            }
        });
    }

    private void x()
    {
        a(new fc() {

            final dg a;

            public void a()
            {
                dg.e(a);
            }

            
            {
                a = dg.this;
                super();
            }
        });
    }

    private void y()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag;
        if (s.size() > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        this;
        JVM INSTR monitorexit ;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_26;
        }
        A();
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        try
        {
            throw exception;
        }
        catch (Throwable throwable)
        {
            el.a(6, g, "", throwable);
        }
        return;
    }

    private void z()
    {
        a(new fc() {

            final dg a;

            public void a()
            {
                dw.a().d();
            }

            
            {
                a = dg.this;
                super();
            }
        });
    }

    Map a()
    {
        return R;
    }

    public void a(Context context)
    {
        this;
        JVM INSTR monitorenter ;
        el.a(4, g, (new StringBuilder()).append("Initializing new Flurry session with context:").append(context).toString());
        m = new WeakReference(context);
        S = new dj(this);
        n = context.getFileStreamPath(F());
        l = dy.a();
        y = -1L;
        O = 0;
        B = TimeZone.getDefault().getID();
        A = (new StringBuilder()).append(Locale.getDefault().getLanguage()).append("_").append(Locale.getDefault().getCountry()).toString();
        L = true;
        M = 0;
        P = 0;
        R = d(context);
        u();
        long l1 = SystemClock.elapsedRealtime();
        w = System.currentTimeMillis();
        x = l1;
        a(((fc) (new fc() {

            final dg a;

            public void a()
            {
                dg.a(a, dt.a());
            }

            
            {
                a = dg.this;
                super();
            }
        })));
        a(((fc) (new fc() {

            final dg a;

            public void a()
            {
                dg.a(a, dv.a());
            }

            
            {
                a = dg.this;
                super();
            }
        })));
        a(((fc) (new fc() {

            final dg a;

            public void a()
            {
                dg.a(a, dx.a());
            }

            
            {
                a = dg.this;
                super();
            }
        })));
        a(((fc) (new fc() {

            final dg a;

            public void a()
            {
                dg.a(a);
            }

            
            {
                a = dg.this;
                super();
            }
        })));
        a(((fc) (new fc() {

            final dg a;

            public void a()
            {
                dg.b(a);
            }

            
            {
                a = dg.this;
                super();
            }
        })));
        em.a().a(this, context);
        U = true;
        this;
        JVM INSTR monitorexit ;
        return;
        context;
        throw context;
    }

    public void a(fc fc)
    {
        dl.a().c(fc);
    }

    public void a(String s1, Object obj)
    {
        if (s1.equals("Gender"))
        {
            G = ((Byte)obj).byteValue();
            el.a(4, g, (new StringBuilder()).append("onSettingUpdate, Gender = ").append(G).toString());
            return;
        }
        if (s1.equals("UserId"))
        {
            F = (String)obj;
            el.a(4, g, (new StringBuilder()).append("onSettingUpdate, UserId = ").append(F).toString());
            return;
        }
        if (s1.equals("LogEvents"))
        {
            E = ((Boolean)obj).booleanValue();
            el.a(4, g, (new StringBuilder()).append("onSettingUpdate, LogEvents = ").append(E).toString());
            return;
        }
        if (s1.equals("Age"))
        {
            H = ((Long)obj).longValue();
            el.a(4, g, (new StringBuilder()).append("onSettingUpdate, Birthdate = ").append(H).toString());
            return;
        }
        if (s1.equals("ContinueSessionMillis"))
        {
            I = ((Long)obj).longValue();
            el.a(4, g, (new StringBuilder()).append("onSettingUpdate, ContinueSessionMillis = ").append(I).toString());
            return;
        } else
        {
            el.a(6, g, "onSettingUpdate internal error!");
            return;
        }
    }

    public void a(String s1, String s2, String s3, Throwable throwable)
    {
        this;
        JVM INSTR monitorenter ;
        if (s1 == null) goto _L2; else goto _L1
_L1:
        if (!"uncaught".equals(s1)) goto _L2; else goto _L3
_L3:
        int i1 = 1;
_L6:
        O = O + 1;
        if (N.size() >= e) goto _L5; else goto _L4
_L4:
        long l1 = System.currentTimeMillis();
        s1 = new cx(H(), Long.valueOf(l1).longValue(), s1, s2, s3, throwable);
        N.add(s1);
        el.d(g, (new StringBuilder()).append("Error logged: ").append(s1.c()).toString());
_L8:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        i1 = 0;
          goto _L6
_L5:
        if (!i1)
        {
            break MISSING_BLOCK_LABEL_243;
        }
        i1 = 0;
_L9:
        if (i1 >= N.size()) goto _L8; else goto _L7
_L7:
        cx cx1 = (cx)N.get(i1);
        if (cx1.c() == null || "uncaught".equals(cx1.c()))
        {
            break MISSING_BLOCK_LABEL_234;
        }
        long l2 = System.currentTimeMillis();
        s1 = new cx(H(), Long.valueOf(l2).longValue(), s1, s2, s3, throwable);
        N.set(i1, s1);
          goto _L8
        s1;
        throw s1;
        i1++;
          goto _L9
        el.d(g, "Max errors logged. No more errors logged.");
          goto _L8
    }

    public void a(String s1, Map map)
    {
        this;
        JVM INSTR monitorenter ;
        Iterator iterator = K.iterator();
_L4:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        cy cy1 = (cy)iterator.next();
        if (!cy1.a(s1)) goto _L4; else goto _L3
_L3:
        long l1;
        long l2;
        l1 = SystemClock.elapsedRealtime();
        l2 = x;
        if (map == null) goto _L6; else goto _L5
_L5:
        if (map.size() <= 0 || M >= d) goto _L6; else goto _L7
_L7:
        int i1;
        i1 = M - cy1.d();
        s1 = new HashMap(cy1.c());
        cy1.a(map);
        if (cy1.d() + i1 > d)
        {
            break MISSING_BLOCK_LABEL_202;
        }
        if (cy1.c().size() <= b) goto _L9; else goto _L8
_L8:
        el.d(g, (new StringBuilder()).append("MaxEventParams exceeded on endEvent: ").append(cy1.c().size()).toString());
        cy1.b(s1);
_L6:
        cy1.a(l1 - l2);
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
_L9:
        M = i1 + cy1.d();
          goto _L6
        s1;
        throw s1;
        cy1.b(s1);
        L = false;
        M = d;
        el.d(g, "Event Log size exceeded. No more event details logged.");
          goto _L6
    }

    public void a(String s1, Map map, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        String s2;
        int i1;
        long l1;
        long l2;
        l1 = SystemClock.elapsedRealtime();
        l2 = x;
        s2 = fb.a(s1);
        i1 = s2.length();
        if (i1 != 0) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        s1 = (cu.a)J.get(s2);
        if (s1 != null) goto _L4; else goto _L3
_L3:
        if (J.size() >= a) goto _L6; else goto _L5
_L5:
        s1 = new cu.a();
        s1.a = 1;
        J.put(s2, s1);
        el.d(g, (new StringBuilder()).append("Event count started: ").append(s2).toString());
_L11:
        if (!E || K.size() >= c || M >= d) goto _L8; else goto _L7
_L7:
        if (map != null)
        {
            break MISSING_BLOCK_LABEL_381;
        }
        s1 = Collections.emptyMap();
_L12:
        if (s1.size() <= b) goto _L10; else goto _L9
_L9:
        el.d(g, (new StringBuilder()).append("MaxEventParams exceeded: ").append(s1.size()).toString());
          goto _L1
        s1;
        throw s1;
_L6:
        el.d(g, (new StringBuilder()).append("Too many different events. Event not counted: ").append(s2).toString());
          goto _L11
_L4:
        s1.a = ((cu.a) (s1)).a + 1;
        el.d(g, (new StringBuilder()).append("Event count incremented: ").append(s2).toString());
          goto _L11
_L10:
label0:
        {
            s1 = new cy(G(), s2, s1, l1 - l2, flag);
            if (s1.d() + M > d)
            {
                break label0;
            }
            K.add(s1);
            int j1 = M;
            M = s1.d() + j1;
        }
          goto _L1
        M = d;
        L = false;
        el.d(g, "Event Log size exceeded. No more event details logged.");
          goto _L1
_L8:
        L = false;
          goto _L1
        s1 = map;
          goto _L12
    }

    public void b()
    {
        q = true;
    }

    public void b(Context context)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = U;
        if (flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        el.d(g, (new StringBuilder()).append("Start session with context: ").append(context).append(" count:").append(g()).toString());
        m = new WeakReference(context);
        if (S.b())
        {
            S.a();
        }
        D();
        dw.a().c();
        D = dw.a().f();
        em.a().b(this, context);
        if (true) goto _L1; else goto _L3
_L3:
        context;
        throw context;
    }

    public void c()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = U;
        if (flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        el.d(g, "Finalize session");
        if (S.b())
        {
            S.a();
        }
        if (g() != 0)
        {
            el.a(6, g, (new StringBuilder()).append("Session with apiKey = ").append(j()).append(" was ended while getSessionCount() is not 0").toString());
        }
        T = 0;
        x();
        em.a().a(this);
        a(new fc() {

            final dg a;

            public void a()
            {
                di.a().a(a.j());
            }

            
            {
                a = dg.this;
                super();
            }
        });
        dm.a().b("Gender", this);
        dm.a().b("UserId", this);
        dm.a().b("Age", this);
        dm.a().b("LogEvents", this);
        dm.a().b("ContinueSessionMillis", this);
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public void c(Context context)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = U;
        if (flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        em.a().c(this, context);
        D = dw.a().f();
        z();
        E();
        el.d(g, (new StringBuilder()).append("End session with context: ").append(context).append(" count:").append(g()).toString());
        y = SystemClock.elapsedRealtime() - x;
        a(y);
        w();
        if (g() == 0)
        {
            S.a(I);
        }
        if (true) goto _L1; else goto _L3
_L3:
        context;
        throw context;
    }

    de d()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        obj = new df();
        ((df) (obj)).a(l);
        ((df) (obj)).a(w);
        ((df) (obj)).b(y);
        ((df) (obj)).c(z);
        ((df) (obj)).b(k());
        ((df) (obj)).c(l());
        ((df) (obj)).a(C);
        ((df) (obj)).d(h());
        ((df) (obj)).a(D);
        ((df) (obj)).b(f());
        ((df) (obj)).a(G);
        ((df) (obj)).a(Long.valueOf(H));
        ((df) (obj)).a(t());
        ((df) (obj)).a(r());
        ((df) (obj)).a(L);
        ((df) (obj)).b(s());
        ((df) (obj)).c(O);
        obj = new de(((df) (obj)));
_L2:
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_171;
        }
        el.d(g, "New session report wasn't created");
        this;
        JVM INSTR monitorexit ;
        return ((de) (obj));
        Object obj1;
        obj1;
        ((IOException) (obj1)).printStackTrace();
        obj1 = null;
        if (true) goto _L2; else goto _L1
_L1:
        obj1;
        throw obj1;
    }

    public void e()
    {
        this;
        JVM INSTR monitorenter ;
        P = P + 1;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    int f()
    {
        return P;
    }

    int g()
    {
        return T;
    }

    String h()
    {
        if (F == null)
        {
            return "";
        } else
        {
            return F;
        }
    }

    public String i()
    {
        return v;
    }

    public String j()
    {
        return k;
    }

    public String k()
    {
        return A;
    }

    public String l()
    {
        return B;
    }

    public long m()
    {
        return w;
    }

    public long n()
    {
        return x;
    }

    public boolean o()
    {
        return t == null || !t.isLimitAdTrackingEnabled();
    }

    public Map p()
    {
        return new HashMap(p);
    }

    public void q()
    {
        c();
    }

    List r()
    {
        return K;
    }

    List s()
    {
        return N;
    }

    Map t()
    {
        return J;
    }

}
