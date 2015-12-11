// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.b.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import com.b.b.e;
import com.b.c.c;
import com.b.e.a.a;
import com.b.e.d;
import com.b.e.f;
import com.b.e.g;
import com.b.e.h;
import com.b.e.i;
import com.b.e.k;
import com.b.e.n;
import com.b.e.o;
import com.b.e.p;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.b.a:
//            a, d, n, p, 
//            l, o, c, m, 
//            e, f

public final class b
{

    protected AtomicInteger A;
    protected AtomicInteger B;
    protected long C;
    protected long D;
    protected long E;
    protected long F;
    protected long G;
    protected long H;
    protected long I;
    protected long J;
    protected long K;
    protected com.b.a.d L;
    protected long M;
    protected long N;
    protected long O;
    protected int P;
    protected int Q;
    protected int R;
    protected long S;
    protected long T;
    protected long U;
    protected int V;
    protected long W;
    protected long X;
    protected Timer Y;
    protected String Z;
    public k a;
    String aa;
    public Context ab;
    protected final HashMap ac = new HashMap();
    protected final HashMap ad = new HashMap();
    public boolean ae;
    protected long af;
    protected boolean ag;
    protected Thread.UncaughtExceptionHandler ah;
    public boolean ai;
    public o aj;
    public o ak;
    public String al[];
    public a am;
    public n b;
    public e c;
    d d;
    i e;
    public com.b.e.b.b f;
    public c g;
    f h;
    protected Timer i;
    protected Timer j;
    protected TimerTask k;
    protected long l;
    protected boolean m;
    protected boolean n;
    boolean o;
    public AtomicInteger p;
    long q;
    AtomicInteger r;
    long s;
    long t;
    String u;
    String v;
    boolean w;
    public String x;
    protected com.b.a.a y;
    protected AtomicInteger z;

    public b()
    {
        m = true;
        n = true;
        o = false;
        w = true;
        y = com.b.a.a.a;
        L = com.b.a.d.a;
        af = 0L;
        ag = false;
        r = new AtomicInteger(0);
        p = new AtomicInteger();
        B = new AtomicInteger(0);
        z = new AtomicInteger(0);
        A = new AtomicInteger(0);
        ah = Thread.getDefaultUncaughtExceptionHandler();
        ae = true;
        E();
    }

    private void E()
    {
        this;
        JVM INSTR monitorenter ;
        aj = o.a;
        ak = o.a;
        ai = false;
        al = g.c;
        y = com.b.a.a.a;
        L = com.b.a.d.a;
        o = false;
        p.set(0);
        q = -1L;
        r.set(0);
        t = -1L;
        s = -1L;
        u = null;
        v = null;
        z.set(0);
        A.set(0);
        C = 0L;
        D = 0L;
        E = 0L;
        F = 0L;
        G = 0L;
        H = 0L;
        M = 0L;
        O = 0L;
        N = 0L;
        I = -1L;
        J = 0L;
        R = -1;
        Q = -1;
        V = 0;
        W = -1L;
        K = -1L;
        X = -1L;
        S = -1L;
        T = -1L;
        U = -1L;
        s = -1L;
        t = -1L;
        H();
        if (j != null)
        {
            j.cancel();
            k = null;
            j = null;
        }
        if (Y != null)
        {
            Y.cancel();
            Y = null;
        }
        if (c != null)
        {
            c.b();
        }
        if (d != null)
        {
            d.c();
        }
        if (f != null)
        {
            f.b.clear();
        }
        if (b != null)
        {
            b.c();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private String F()
    {
        String s1 = ab.getPackageName();
        try
        {
            s1 = ab.getPackageManager().getPackageInfo(s1, 0).versionName;
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            return "0";
        }
        return s1;
    }

    private boolean G()
    {
        long l1 = System.currentTimeMillis();
        boolean flag = false;
        if (l1 - S > 0x124f80L)
        {
            J = I;
            I = l1;
            P = P + 1;
            flag = true;
        }
        S = l1;
        return flag;
    }

    private void H()
    {
        this;
        JVM INSTR monitorenter ;
        C();
        m = true;
        l = -1L;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void I()
    {
        this;
        JVM INSTR monitorenter ;
        C();
        if (l >= 60000L)
        {
            i = new Timer("AutoUpdateTimer");
            i.scheduleAtFixedRate(new com.b.a.n(this), new Date(System.currentTimeMillis() + l), l);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private String a(String s1, Properties properties, boolean flag)
    {
        properties = properties.getProperty(s1);
        if (properties != null)
        {
            b.a(s1, properties);
            return properties;
        }
        if (flag && b.a(s1).booleanValue())
        {
            return b.b(s1);
        } else
        {
            return null;
        }
    }

    private void a(int i1, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        C();
        int j1;
        j1 = i1;
        if (i1 < 60)
        {
            j1 = 60;
        }
        m = flag;
        l = j1 * 1000;
        if (y != com.b.a.a.c) goto _L2; else goto _L1
_L1:
        I();
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (y == a.b && !m)
        {
            I();
        }
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    static void a(b b1, String s1)
    {
        b1.d(s1);
    }

    private void a(String s1, String s2)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(s2);
        a(s1, arraylist);
    }

    private void a(String s1, ArrayList arraylist)
    {
        arraylist = arraylist.iterator();
        do
        {
            if (!arraylist.hasNext())
            {
                break;
            }
            String s2 = (String)arraylist.next();
            String s3 = b.b(s1);
            String s4 = b.b(s2);
            if (com.b.e.p.f(s3) && com.b.e.p.g(s4))
            {
                b.a(s2, s3);
            }
        } while (true);
        b.c(s1);
    }

    private void b(String s1)
    {
        int j1 = s1.indexOf('?');
        if (j1 < 0) goto _L2; else goto _L1
_L1:
        Object obj;
        obj = s1;
        if (j1 < s1.length() - 1)
        {
            obj = s1.substring(j1 + 1).split("&");
            int k1 = obj.length;
            int i1 = 0;
            while (i1 < k1) 
            {
                String as[] = obj[i1].split("=");
                if (as.length == 2)
                {
                    b(as[0], as[1]);
                } else
                if (as.length == 1)
                {
                    b("name", as[0]);
                }
                i1++;
            }
            obj = s1.substring(0, j1 + 1);
        }
_L4:
        Z = ((String) (obj));
        return;
_L2:
        obj = (new StringBuilder()).append(s1).append('?').toString();
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void b(String s1, String s2)
    {
        this;
        JVM INSTR monitorenter ;
        ac.put(s1, s2);
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    private void c(String s1)
    {
        aa = s1;
        if (b != null)
        {
            b.a("appName", aa);
        }
    }

    private void d(String s1)
    {
        String s2;
        if (ai)
        {
            s2 = "https://sb.scorecardresearch.com/p2?";
        } else
        {
            s2 = "http://b.scorecardresearch.com/p2?";
        }
        b(s2);
        b("c2", s1);
    }

    private void p(boolean flag)
    {
        long l1;
        long l2;
        l1 = System.currentTimeMillis();
        l2 = l1 - K;
        com.b.a.p.a[y.ordinal()];
        JVM INSTR tableswitch 1 3: default 48
    //                   1 248
    //                   2 223
    //                   3 198;
           goto _L1 _L2 _L3 _L4
_L1:
        K = l1;
        if (flag)
        {
            b.a("lastApplicationAccumulationTimestamp", Long.toString(K));
            b.a("foregroundTransitionsCount", Long.toString(B.get()));
            b.a("accumulatedForegroundTime", Long.toString(G));
            b.a("accumulatedBackgroundTime", Long.toString(F));
            b.a("accumulatedInactiveTime", Long.toString(H));
            b.a("totalForegroundTime", Long.toString(C));
            b.a("totalBackgroundTime", Long.toString(D));
            b.a("totalInactiveTime", Long.toString(E));
        }
        return;
_L4:
        G = G + l2;
        C = l2 + C;
        continue; /* Loop/switch isn't completed */
_L3:
        F = F + l2;
        D = l2 + D;
        continue; /* Loop/switch isn't completed */
_L2:
        H = H + l2;
        E = l2 + E;
        if (true) goto _L1; else goto _L5
_L5:
    }

    private void q(boolean flag)
    {
        long l1;
        long l2;
        l1 = System.currentTimeMillis();
        l2 = l1 - X;
        p.b[L.ordinal()];
        JVM INSTR tableswitch 1 3: default 48
    //                   1 298
    //                   2 314
    //                   3 330;
           goto _L1 _L2 _L3 _L4
_L1:
        X = l1;
        if (flag)
        {
            b.a("lastSessionAccumulationTimestamp", Long.toString(X));
            b.a("lastApplicationSessionTimestamp", Long.toString(S));
            b.a("lastUserSessionTimestamp", Long.toString(T));
            b.a("lastActiveUserSessionTimestamp", Long.toString(U));
            b.a("accumulatedApplicationSessionTime", Long.toString(M));
            b.a("accumulatedActiveUserSessionTime", Long.toString(O));
            b.a("accumulatedUserSessionTime", Long.toString(N));
            b.a("activeUserSessionCount", Long.toString(R));
            b.a("userSessionCount", Long.toString(Q));
            b.a("lastUserInteractionTimestamp", Long.toString(W));
            b.a("userInteractionCount", Integer.toString(V));
            b.a("previousGenesis", Long.toString(J));
            b.a("genesis", Long.toString(I));
            b.a("applicationSessionCountKey", Integer.toString(P));
        }
        return;
_L2:
        O = O + l2;
        U = l1;
_L3:
        N = N + l2;
        T = l1;
_L4:
        M = l2 + M;
        S = l1;
        if (true) goto _L1; else goto _L5
_L5:
    }

    public final void A()
    {
        if (f == null)
        {
            return;
        } else
        {
            f.a(new l(this), false);
            return;
        }
    }

    public final void B()
    {
        this;
        JVM INSTR monitorenter ;
        o(true);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    final void C()
    {
        this;
        JVM INSTR monitorenter ;
        if (i != null)
        {
            i.cancel();
            i = null;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    final boolean D()
    {
        return ab == null || am.b() || Z == null || Z.length() == 0;
    }

    public final int a(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        int i1 = B.get();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_43;
        }
        B.set(0);
        b.a("foregroundTransitionsCount", Long.toString(B.get()));
        this;
        JVM INSTR monitorexit ;
        return i1;
        Exception exception;
        exception;
        throw exception;
    }

    protected final void a()
    {
        b = new n(ab);
        g = new c(this);
        ArrayList arraylist = new ArrayList();
        arraylist.add("lastApplicationAccumulationTimestamp");
        arraylist.add("lastSessionAccumulationTimestamp");
        a("lastActivityTime", arraylist);
        a("ns_ap_fg", "foregroundTransitionsCount");
        a("installTime", "installId");
        a("ns_ap_ver", "previousVersion");
        g.a();
        e = new i(this);
        c = new e(this);
        a = new k(this);
        d = new d(this);
        h = new f(this);
        K = com.b.e.p.a(b.b("lastApplicationAccumulationTimestamp"), -1L);
        X = com.b.e.p.a(b.b("lastSessionAccumulationTimestamp"), -1L);
        S = com.b.e.p.a(b.b("lastApplicationSessionTimestamp"), -1L);
        T = com.b.e.p.a(b.b("lastUserSessionTimestamp"), -1L);
        U = com.b.e.p.a(b.b("lastActiveUserSessionTimestamp"), -1L);
        B.set(com.b.e.p.d(b.b("foregroundTransitionsCount")));
        G = com.b.e.p.c(b.b("accumulatedForegroundTime"));
        F = com.b.e.p.c(b.b("accumulatedBackgroundTime"));
        H = com.b.e.p.c(b.b("accumulatedInactiveTime"));
        C = com.b.e.p.c(b.b("totalForegroundTime"));
        D = com.b.e.p.c(b.b("totalBackgroundTime"));
        E = com.b.e.p.c(b.b("totalInactiveTime"));
        M = com.b.e.p.c(b.b("accumulatedApplicationSessionTime"));
        O = com.b.e.p.c(b.b("accumulatedActiveUserSessionTime"));
        N = com.b.e.p.c(b.b("accumulatedUserSessionTime"));
        R = com.b.e.p.a(b.b("activeUserSessionCount"), -1);
        Q = com.b.e.p.a(b.b("userSessionCount"), -1);
        W = com.b.e.p.a(b.b("lastUserInteractionTimestamp"), -1L);
        V = com.b.e.p.a(b.b("userInteractionCount"), 0);
        P = com.b.e.p.a(b.b("applicationSessionCountKey"), 0);
        u = F();
        J = com.b.e.p.a(b.b("previousGenesis"), 0L);
        I = com.b.e.p.a(b.b("genesis"), -1L);
        long l1;
        if (I < 0L)
        {
            I = System.currentTimeMillis();
            J = 0L;
            S = I;
            P = P + 1;
        } else
        {
            if (!G())
            {
                M = M + (System.currentTimeMillis() - X);
                b.a("accumulatedApplicationSessionTime", Long.toString(M));
            }
            S = I;
        }
        t = com.b.e.p.a(b.b("firstInstallId"), -1L);
        if (t < 0L)
        {
            t = I;
            s = I;
            b.a("currentVersion", u);
            b.a("firstInstallId", String.valueOf(t));
            b.a("installId", String.valueOf(s));
        } else
        {
            if (b.a("previousVersion").booleanValue())
            {
                v = b.b("previousVersion");
            }
            String s1 = b.b("currentVersion");
            if (!s1.equals(u))
            {
                v = s1;
                b.a("previousVersion", v);
                s = I;
                b.a("installId", String.valueOf(s));
            } else
            {
                s = com.b.e.p.a(b.b("installId"), -1L);
            }
            b.a("currentVersion", u);
        }
        b.a("genesis", Long.toString(I));
        b.a("previousGenesis", Long.toString(J));
        l1 = System.currentTimeMillis();
        if (K >= 0L)
        {
            long l2 = l1 - K;
            H = H + l2;
            b.a("accumulatedInactiveTime", Long.toString(H));
            E = l2 + E;
            b.a("totalInactiveTime", Long.toString(E));
        }
        K = l1;
        X = l1;
        b.a("lastApplicationAccumulationTimestamp", Long.toString(K));
        b.a("lastSessionAccumulationTimestamp", Long.toString(X));
        b.a("lastApplicationSessionTimestamp", Long.toString(S));
        if (!b.a("runs").booleanValue())
        {
            b.a("runs", "0");
        }
        p.set(com.b.e.p.d(b.b("runs")));
        r.set(com.b.e.p.d(b.b("coldStartCount")));
        am = new a(ab, b);
    }

    protected final void a(com.b.a.a a1)
    {
        if (a1 != com.b.a.a.a && w && !o)
        {
            a(com.b.b.d.a, ad, false);
        }
    }

    protected final void a(com.b.a.d d1)
    {
        long l1;
        (new StringBuilder("Leaving session state: ")).append(d1);
        com.b.e.c.a(this);
        l1 = System.currentTimeMillis();
        p.b[d1.ordinal()];
        JVM INSTR tableswitch 1 4: default 60
    //                   1 61
    //                   2 85
    //                   3 90
    //                   4 96;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        return;
_L2:
        if (Y != null)
        {
            Y.cancel();
            Y = null;
        }
        U = l1;
_L3:
        T = l1;
_L4:
        S = l1;
        return;
_L5:
        if (!G())
        {
            long l2 = M;
            M = (l1 - X) + l2;
            return;
        }
        if (true) goto _L1; else goto _L6
_L6:
    }

    final void a(com.b.b.d d1, HashMap hashmap)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = D();
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (!o && d1 != com.b.b.d.a)
        {
            g.a(com.b.b.c.a(this, com.b.b.d.a, new HashMap(), Z));
        }
        if (d1 != com.b.b.d.c)
        {
            g.a(com.b.b.c.a(this, d1, hashmap, Z));
        }
        if (true) goto _L1; else goto _L3
_L3:
        d1;
        throw d1;
    }

    public final void a(com.b.b.d d1, HashMap hashmap, boolean flag)
    {
        if (!flag)
        {
            a(d1, hashmap);
        } else
        if (f != null)
        {
            f.a(new com.b.a.o(this, d1, hashmap), flag);
            return;
        }
    }

    final void a(String s1)
    {
        if (am != null)
        {
            am.e = s1;
            a a1 = am;
            if (!a1.b())
            {
                boolean flag;
                if (a1.c.a("vid").booleanValue())
                {
                    a1.b = a1.c.b("vid");
                } else
                {
                    String s2 = com.b.e.a.a.e();
                    if (s2 != null && s2.length() > 0 && !s2.equals("unknown") && s2.length() > 3 && !s2.substring(0, 3).equals("***") && !s2.substring(0, 3).equals("000"))
                    {
                        s1 = new String[2];
                        s1[0] = s2;
                        s1[1] = "-cs31";
                    } else
                    {
                        String s3 = com.b.e.a.a.b(a1.d);
                        if (s3 != null && s3.length() > 0)
                        {
                            s1 = new String[2];
                            s1[0] = s3;
                            s1[1] = "-cs32";
                        } else
                        if (s3 == null || s3.length() == 0)
                        {
                            String s4 = UUID.randomUUID().toString();
                            s1 = new String[2];
                            s1[0] = s4;
                            s1[1] = "-cs72";
                        } else
                        {
                            s1 = null;
                        }
                    }
                    s2 = s1[0];
                    s1 = s1[1];
                    a1.b = (new StringBuilder()).append(com.b.e.p.a((new StringBuilder()).append(s2).append(a1.a()).toString())).append(s1).toString();
                    a1.c.a("vid", a1.b);
                }
                if (android.os.Build.VERSION.SDK_INT > 4)
                {
                    flag = a(a1.d);
                } else
                {
                    flag = false;
                }
                if (flag)
                {
                    if (a1.c())
                    {
                        if (a1.d().booleanValue())
                        {
                            a1.a = com.b.e.a.a.a(com.b.e.a.a.a(a1.d));
                            a1.c.a("crossPublisherId", a1.a);
                            return;
                        } else
                        {
                            a1.a = "none";
                            a1.c.a("crossPublisherId", a1.a);
                            return;
                        }
                    } else
                    {
                        a1.a = null;
                        return;
                    }
                }
                s1 = com.b.e.a.a.e();
                if (s1 != null && s1.length() > 0 && !s1.equals("unknown") && s1.length() > 3 && !s1.substring(0, 3).equals("***") && !s1.substring(0, 3).equals("000"))
                {
                    a1.a = com.b.e.a.a.a(s1);
                    a1.c.a("crossPublisherId", a1.a);
                    return;
                }
                s1 = com.b.e.a.a.b(a1.d);
                if (s1 != null && s1.length() > 0)
                {
                    a1.a = com.b.e.a.a.a(s1);
                    a1.c.a("crossPublisherId", a1.a);
                    return;
                } else
                {
                    a1.a = null;
                    return;
                }
            }
        }
    }

    public final long b(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        long l1 = C;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_33;
        }
        C = 0L;
        b.a("totalForegroundTime", Long.toString(C));
        this;
        JVM INSTR monitorexit ;
        return l1;
        Exception exception;
        exception;
        throw exception;
    }

    protected final void b(com.b.a.a a1)
    {
        (new StringBuilder("Entering application state: ")).append(a1);
        com.b.e.c.a(this);
        com.b.a.p.a[a1.ordinal()];
        JVM INSTR tableswitch 1 3: default 52
    //                   1 53
    //                   2 102
    //                   3 114;
           goto _L1 _L2 _L3 _L4
_L1:
        return;
_L2:
        h.b();
        a1 = c;
        a1.e = false;
        a1.b();
        a1.a(true);
        d.c();
        ab.unregisterReceiver(h);
        C();
        return;
_L3:
        if (!m)
        {
            I();
            return;
        }
          goto _L1
_L4:
        I();
        B.getAndIncrement();
        return;
    }

    protected final void b(com.b.a.d d1)
    {
        (new StringBuilder("Entering session state: ")).append(d1);
        com.b.e.c.a(this);
        switch (p.b[d1.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            long l1 = System.currentTimeMillis();
            if (l1 - U >= 0x493e0L)
            {
                R = R + 1;
            }
            U = l1;
            if (Y != null)
            {
                Y.cancel();
                Y = null;
            }
            Y = new Timer();
            Y.schedule(new com.b.a.c(this), 0x493e0L);
            // fall through

        case 2: // '\002'
            long l2 = System.currentTimeMillis();
            if (l2 - T >= 0x493e0L)
            {
                Q = Q + 1;
            }
            T = l2;
            // fall through

        case 3: // '\003'
            G();
            return;
        }
    }

    public final boolean b()
    {
        boolean flag = true;
        this;
        JVM INSTR monitorenter ;
        if (o) goto _L2; else goto _L1
_L1:
        o = true;
        r.getAndIncrement();
        b.a("coldStartCount", String.valueOf(r));
        q = System.currentTimeMillis();
_L4:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        flag = false;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public final long c(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        long l1 = G;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_33;
        }
        G = 0L;
        b.a("accumulatedForegroundTime", Long.toString(G));
        this;
        JVM INSTR monitorexit ;
        return l1;
        Exception exception;
        exception;
        throw exception;
    }

    protected final void c()
    {
        if (ab == null) goto _L2; else goto _L1
_L1:
        Object obj = ab.getResources().getAssets();
        Object obj1;
        obj1 = ((AssetManager) (obj)).open("comScore.properties");
        obj = new Properties();
        ((Properties) (obj)).load(((java.io.InputStream) (obj1)));
        g.a = com.b.e.p.e(a("Debug", ((Properties) (obj)), false));
        ai = com.b.e.p.e(a("Secure", ((Properties) (obj)), false));
        obj1 = a("PublisherSecret", ((Properties) (obj)), true);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_89;
        }
        a(((String) (obj1)));
        obj1 = a("AppName", ((Properties) (obj)), true);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_108;
        }
        c(((String) (obj1)));
        obj1 = a("CustomerC2", ((Properties) (obj)), false);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_127;
        }
        d(((String) (obj1)));
        obj1 = a("PixelURL", ((Properties) (obj)), false);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_146;
        }
        b(((String) (obj1)));
        obj1 = a("OfflineURL", ((Properties) (obj)), false);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_168;
        }
        a.e = ((String) (obj1));
        obj1 = a("LiveTransmissionMode", ((Properties) (obj)), false);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_196;
        }
        aj = com.b.e.o.valueOf(((String) (obj1)).toUpperCase(Locale.getDefault()));
_L9:
        obj1 = a("OfflineTransmissionMode", ((Properties) (obj)), false);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_224;
        }
        ak = com.b.e.o.valueOf(((String) (obj1)).toUpperCase(Locale.getDefault()));
_L5:
        int i1;
        ae = com.b.e.p.a(a("KeepAliveEnabled", ((Properties) (obj)), false), true);
        i1 = com.b.e.p.a(a("CacheMaxSize", ((Properties) (obj)), false), -1);
        if (i1 < 0)
        {
            break MISSING_BLOCK_LABEL_267;
        }
        a.a = i1;
        i1 = com.b.e.p.a(a("CacheMaxBatchSize", ((Properties) (obj)), false), -1);
        if (i1 < 0)
        {
            break MISSING_BLOCK_LABEL_293;
        }
        a.a(i1);
        i1 = com.b.e.p.a(a("CacheMaxFlushesInARow", ((Properties) (obj)), false), -1);
        if (i1 < 0)
        {
            break MISSING_BLOCK_LABEL_319;
        }
        a.b = i1;
        i1 = com.b.e.p.a(a("CacheMinutesToRetry", ((Properties) (obj)), false), -1);
        if (i1 < 0)
        {
            break MISSING_BLOCK_LABEL_346;
        }
        a.c = i1;
        i1 = com.b.e.p.a(a("CacheExpiryInDays", ((Properties) (obj)), false), -1);
        if (i1 < 0)
        {
            break MISSING_BLOCK_LABEL_373;
        }
        a.d = i1;
        long l1 = com.b.e.p.a(a("CacheFlushingInterval", ((Properties) (obj)), false), -1L);
        if (l1 < 0L)
        {
            break MISSING_BLOCK_LABEL_417;
        }
        af = l1;
        if (d != null)
        {
            d.b();
        }
        ag = com.b.e.p.e(a("ErrorHandlingEnabled", ((Properties) (obj)), false));
        if (!ag) goto _L4; else goto _L3
_L3:
        Thread.setDefaultUncaughtExceptionHandler(new h(this));
_L7:
        boolean flag;
        w = com.b.e.p.a(a("AutoStartEnabled", ((Properties) (obj)), false), true);
        flag = com.b.e.p.a(a("AutoUpdateInForegroundOnly", ((Properties) (obj)), false), true);
        i1 = com.b.e.p.a(a("AutoUpdateInterval", ((Properties) (obj)), false), -1);
        IllegalArgumentException illegalargumentexception;
        if (i1 >= 60)
        {
            try
            {
                a(i1, flag);
                return;
            }
            catch (IOException ioexception)
            {
                if (g.a)
                {
                    com.b.e.c.a(ioexception);
                    return;
                }
            }
        }
          goto _L2
        illegalargumentexception;
        aj = o.a;
        continue; /* Loop/switch isn't completed */
        illegalargumentexception;
        ak = o.a;
          goto _L5
_L4:
        if (Thread.getDefaultUncaughtExceptionHandler() == ah) goto _L7; else goto _L6
_L6:
        Thread.setDefaultUncaughtExceptionHandler(ah);
          goto _L7
_L2:
        return;
        if (true) goto _L9; else goto _L8
_L8:
    }

    public final long d(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        long l1 = D;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_33;
        }
        D = 0L;
        b.a("totalBackgroundTime", Long.toString(D));
        this;
        JVM INSTR monitorexit ;
        return l1;
        Exception exception;
        exception;
        throw exception;
    }

    public final void d()
    {
        this;
        JVM INSTR monitorenter ;
        com.b.e.b.b b1 = f;
        if (b1 != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        f.a(new m(this), true);
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public final long e(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        long l1 = F;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_33;
        }
        F = 0L;
        b.a("accumulatedBackgroundTime", Long.toString(F));
        this;
        JVM INSTR monitorexit ;
        return l1;
        Exception exception;
        exception;
        throw exception;
    }

    public final void e()
    {
        this;
        JVM INSTR monitorenter ;
        com.b.e.b.b b1 = f;
        if (b1 != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        f.a(new com.b.a.e(this), true);
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public final long f(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        long l1 = E;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_33;
        }
        E = 0L;
        b.a("totalInactiveTime", Long.toString(E));
        this;
        JVM INSTR monitorexit ;
        return l1;
        Exception exception;
        exception;
        throw exception;
    }

    protected final void f()
    {
        this;
        JVM INSTR monitorenter ;
        long l1;
        if (j != null)
        {
            j.cancel();
            k = null;
            j = null;
        }
        l1 = System.currentTimeMillis();
        if (z.get() <= 0) goto _L2; else goto _L1
_L1:
        com.b.a.a a1 = com.b.a.a.c;
_L9:
        if (l1 - W >= 0x493e0L) goto _L4; else goto _L3
_L3:
        com.b.a.d d1 = com.b.a.d.d;
_L10:
        com.b.a.a a2;
        com.b.a.d d2;
        a2 = y;
        d2 = L;
        if (a1 == a2 && d1 == d2) goto _L6; else goto _L5
_L5:
        k = new com.b.a.f(this, a2, a1, d2, d1);
        if (!n || a1 == com.b.a.a.c) goto _L8; else goto _L7
_L7:
        j = new Timer();
        j.schedule(k, 300L);
_L6:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
label0:
        {
            if (A.get() <= 0)
            {
                break label0;
            }
            a1 = a.b;
        }
          goto _L9
        a1 = com.b.a.a.a;
          goto _L9
_L4:
label1:
        {
            if (A.get() <= 0)
            {
                break label1;
            }
            d1 = com.b.a.d.c;
        }
          goto _L10
label2:
        {
            if (z.get() <= 0)
            {
                break label2;
            }
            d1 = d.b;
        }
          goto _L10
        d1 = com.b.a.d.a;
          goto _L10
_L8:
        k.run();
        k = null;
          goto _L6
        Exception exception;
        exception;
        throw exception;
          goto _L9
    }

    public final long g(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        long l1 = H;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_33;
        }
        H = 0L;
        b.a("accumulatedInactiveTime", Long.toString(H));
        this;
        JVM INSTR monitorexit ;
        return l1;
        Exception exception;
        exception;
        throw exception;
    }

    protected final void g()
    {
        p(true);
    }

    public final long h(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        long l1 = M;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_33;
        }
        M = 0L;
        b.a("accumulatedApplicationSessionTime", Long.toString(M));
        this;
        JVM INSTR monitorexit ;
        return l1;
        Exception exception;
        exception;
        throw exception;
    }

    protected final void h()
    {
        q(true);
    }

    public final long i(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        long l1 = O;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_33;
        }
        O = 0L;
        b.a("accumulatedActiveUserSessionTime", Long.toString(O));
        this;
        JVM INSTR monitorexit ;
        return l1;
        Exception exception;
        exception;
        throw exception;
    }

    public final com.b.a.a i()
    {
        return y;
    }

    public final int j()
    {
        this;
        JVM INSTR monitorenter ;
        int i1 = p.get();
        this;
        JVM INSTR monitorexit ;
        return i1;
        Exception exception;
        exception;
        throw exception;
    }

    public final long j(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        long l1 = N;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_33;
        }
        N = 0L;
        b.a("accumulatedUserSessionTime", Long.toString(N));
        this;
        JVM INSTR monitorexit ;
        return l1;
        Exception exception;
        exception;
        throw exception;
    }

    public final int k(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        int i1 = P;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_33;
        }
        P = 0;
        b.a("applicationSessionCountKey", Integer.toString(P));
        this;
        JVM INSTR monitorexit ;
        return i1;
        Exception exception;
        exception;
        throw exception;
    }

    public final long k()
    {
        this;
        JVM INSTR monitorenter ;
        long l1 = s;
        this;
        JVM INSTR monitorexit ;
        return l1;
        Exception exception;
        exception;
        throw exception;
    }

    public final int l(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        int i1 = -1;
        int j1;
        if (R < 0)
        {
            break MISSING_BLOCK_LABEL_49;
        }
        j1 = R;
        i1 = j1;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_49;
        }
        R = 0;
        b.a("activeUserSessionCount", Integer.toString(R));
        i1 = j1;
        this;
        JVM INSTR monitorexit ;
        return i1;
        Exception exception;
        exception;
        throw exception;
    }

    public final long l()
    {
        this;
        JVM INSTR monitorenter ;
        long l1 = t;
        this;
        JVM INSTR monitorexit ;
        return l1;
        Exception exception;
        exception;
        throw exception;
    }

    public final int m(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        int i1 = -1;
        int j1;
        if (Q < 0)
        {
            break MISSING_BLOCK_LABEL_49;
        }
        j1 = Q;
        i1 = j1;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_49;
        }
        Q = 0;
        b.a("userSessionCount", Integer.toString(Q));
        i1 = j1;
        this;
        JVM INSTR monitorexit ;
        return i1;
        Exception exception;
        exception;
        throw exception;
    }

    public final long m()
    {
        this;
        JVM INSTR monitorenter ;
        long l1 = q;
        this;
        JVM INSTR monitorexit ;
        return l1;
        Exception exception;
        exception;
        throw exception;
    }

    public final int n()
    {
        this;
        JVM INSTR monitorenter ;
        int i1 = r.get();
        this;
        JVM INSTR monitorexit ;
        return i1;
        Exception exception;
        exception;
        throw exception;
    }

    public final int n(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        int i1 = V;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_33;
        }
        V = 0;
        b.a("userInteractionCount", Integer.toString(V));
        this;
        JVM INSTR monitorexit ;
        return i1;
        Exception exception;
        exception;
        throw exception;
    }

    public final String o()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = u;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public final void o(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        if (j != null)
        {
            j.cancel();
            j = null;
            k.run();
            k = null;
        }
        p(flag);
        q(flag);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final String p()
    {
        this;
        JVM INSTR monitorenter ;
        String s1;
        s1 = v;
        if (v != null && v.length() > 0)
        {
            b.c("previousVersion");
            v = null;
        }
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public final long q()
    {
        this;
        JVM INSTR monitorenter ;
        long l1 = l;
        this;
        JVM INSTR monitorexit ;
        return l1;
        Exception exception;
        exception;
        throw exception;
    }

    public final String r()
    {
        return Z;
    }

    public final String s()
    {
        if (am == null)
        {
            return null;
        } else
        {
            return am.a;
        }
    }

    public final String t()
    {
        if (am == null)
        {
            return null;
        } else
        {
            return am.b;
        }
    }

    public final String u()
    {
        Object obj;
        PackageManager packagemanager;
        if (aa != null && aa.length() != 0 || ab == null)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        obj = ab.getPackageName();
        packagemanager = ab.getPackageManager();
        obj = packagemanager.getApplicationLabel(packagemanager.getApplicationInfo(((String) (obj)), 0));
        if (obj != null)
        {
            try
            {
                c(obj.toString());
            }
            catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
            {
                aa = b.b("appName");
            }
        }
        return aa;
    }

    public final long v()
    {
        return I;
    }

    public final long w()
    {
        return J;
    }

    public final HashMap x()
    {
        return ac;
    }

    public final String y()
    {
        return (String)ac.get("c2");
    }

    public final long z()
    {
        return af;
    }
}
