// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics;

import android.content.Context;
import android.content.Intent;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

// Referenced classes of package com.google.android.gms.analytics:
//            ag, GoogleAnalytics, b, f, 
//            aa, d, i, r, 
//            c

class s
    implements ag, c.b, c.c
{
    private static final class a extends Enum
    {

        public static final a rN;
        public static final a rO;
        public static final a rP;
        public static final a rQ;
        public static final a rR;
        public static final a rS;
        public static final a rT;
        private static final a rU[];

        public static a valueOf(String s1)
        {
            return (a)Enum.valueOf(com/google/android/gms/analytics/s$a, s1);
        }

        public static a[] values()
        {
            return (a[])rU.clone();
        }

        static 
        {
            rN = new a("CONNECTING", 0);
            rO = new a("CONNECTED_SERVICE", 1);
            rP = new a("CONNECTED_LOCAL", 2);
            rQ = new a("BLOCKED", 3);
            rR = new a("PENDING_CONNECTION", 4);
            rS = new a("PENDING_DISCONNECT", 5);
            rT = new a("DISCONNECTED", 6);
            rU = (new a[] {
                rN, rO, rP, rQ, rR, rS, rT
            });
        }

        private a(String s1, int k)
        {
            super(s1, k);
        }
    }

    private class b extends TimerTask
    {

        final s rL;

        public void run()
        {
            if (s.b(rL) == a.rO && s.e(rL).isEmpty() && s.f(rL) + s.g(rL) < s.h(rL).currentTimeMillis())
            {
                aa.v("Disconnecting due to inactivity");
                s.i(rL);
                return;
            } else
            {
                s.j(rL).schedule(rL. new b(), s.g(rL));
                return;
            }
        }

        private b()
        {
            rL = s.this;
            super();
        }

    }

    private class c extends TimerTask
    {

        final s rL;

        public void run()
        {
            if (s.b(rL) == a.rN)
            {
                s.c(rL);
            }
        }

        private c()
        {
            rL = s.this;
            super();
        }

    }

    private static class d
    {

        private final Map rV;
        private final long rW;
        private final String rX;
        private final List rY;

        public Map bO()
        {
            return rV;
        }

        public long bP()
        {
            return rW;
        }

        public List bQ()
        {
            return rY;
        }

        public String getPath()
        {
            return rX;
        }

        public String toString()
        {
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append("PATH: ");
            stringbuilder.append(rX);
            if (rV != null)
            {
                stringbuilder.append("  PARAMS: ");
                for (Iterator iterator = rV.entrySet().iterator(); iterator.hasNext(); stringbuilder.append(",  "))
                {
                    java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                    stringbuilder.append((String)entry.getKey());
                    stringbuilder.append("=");
                    stringbuilder.append((String)entry.getValue());
                }

            }
            return stringbuilder.toString();
        }

        public d(Map map, long l, String s1, List list)
        {
            rV = map;
            rW = l;
            rX = s1;
            rY = list;
        }
    }

    private class e extends TimerTask
    {

        final s rL;

        public void run()
        {
            s.d(rL);
        }

        private e()
        {
            rL = s.this;
            super();
        }

    }


    private final Context mContext;
    private final GoogleAnalytics rA;
    private final Queue rB;
    private volatile int rC;
    private volatile Timer rD;
    private volatile Timer rE;
    private volatile Timer rF;
    private boolean rG;
    private boolean rH;
    private boolean rI;
    private i rJ = new i() {

        final s rL;

        public long currentTimeMillis()
        {
            return System.currentTimeMillis();
        }

            
            {
                rL = s.this;
                super();
            }
    };
    private long rK;
    private com.google.android.gms.analytics.d rj;
    private final f rk;
    private boolean rm;
    private volatile long rw;
    private volatile a rx;
    private volatile com.google.android.gms.analytics.b ry;
    private com.google.android.gms.analytics.d rz;

    s(Context context, f f1)
    {
        this(context, f1, null, GoogleAnalytics.getInstance(context));
    }

    s(Context context, f f1, com.google.android.gms.analytics.d d1, GoogleAnalytics googleanalytics)
    {
        rB = new ConcurrentLinkedQueue();
        rK = 0x493e0L;
        rz = d1;
        mContext = context;
        rk = f1;
        rA = googleanalytics;
        rC = 0;
        rx = a.rT;
    }

    private Timer a(Timer timer)
    {
        if (timer != null)
        {
            timer.cancel();
        }
        return null;
    }

    static void a(s s1)
    {
        s1.bJ();
    }

    private void aD()
    {
        this;
        JVM INSTR monitorenter ;
        if (ry != null && rx == a.rO)
        {
            rx = a.rS;
            ry.disconnect();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    static a b(s s1)
    {
        return s1.rx;
    }

    private void bH()
    {
        rD = a(rD);
        rE = a(rE);
        rF = a(rF);
    }

    private void bJ()
    {
        this;
        JVM INSTR monitorenter ;
        if (Thread.currentThread().equals(rk.getThread())) goto _L2; else goto _L1
_L1:
        rk.bs().add(new Runnable() {

            final s rL;

            public void run()
            {
                s.a(rL);
            }

            
            {
                rL = s.this;
                super();
            }
        });
_L3:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (rG)
        {
            bk();
        }
        static class _cls3
        {

            static final int rM[];

            static 
            {
                rM = new int[a.values().length];
                try
                {
                    rM[a.rP.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    rM[a.rO.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    rM[a.rN.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    rM[a.rR.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    rM[a.rS.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    rM[a.rT.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls3.rM[rx.ordinal()];
        JVM INSTR tableswitch 1 6: default 342
    //                   1 104
    //                   2 198
    //                   3 342
    //                   4 342
    //                   5 342
    //                   6 317;
           goto _L3 _L4 _L5 _L3 _L3 _L3 _L6
_L4:
        d d1;
        for (; !rB.isEmpty(); rj.a(d1.bO(), d1.bP(), d1.getPath(), d1.bQ()))
        {
            d1 = (d)rB.poll();
            aa.v((new StringBuilder()).append("Sending hit to store  ").append(d1).toString());
        }

          goto _L7
        Exception exception;
        exception;
        throw exception;
_L7:
        if (!rm) goto _L3; else goto _L8
_L8:
        bK();
          goto _L3
_L5:
        if (rB.isEmpty()) goto _L10; else goto _L9
_L9:
        d d2;
        d2 = (d)rB.peek();
        aa.v((new StringBuilder()).append("Sending hit to service   ").append(d2).toString());
        if (rA.isDryRunEnabled()) goto _L12; else goto _L11
_L11:
        ry.a(d2.bO(), d2.bP(), d2.getPath(), d2.bQ());
_L13:
        rB.poll();
          goto _L5
_L12:
        aa.v("Dry run enabled. Hit not actually sent to service.");
          goto _L13
_L10:
        rw = rJ.currentTimeMillis();
          goto _L3
_L6:
        aa.v("Need to reconnect");
        if (!rB.isEmpty())
        {
            bM();
        }
          goto _L3
    }

    private void bK()
    {
        rj.bp();
        rm = false;
    }

    private void bL()
    {
        this;
        JVM INSTR monitorenter ;
        a a1;
        a a2;
        a1 = rx;
        a2 = a.rP;
        if (a1 != a2) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        bH();
        aa.v("falling back to local store");
        if (rz == null)
        {
            break; /* Loop/switch isn't completed */
        }
        rj = rz;
_L4:
        rx = a.rP;
        bJ();
        if (true) goto _L1; else goto _L3
        Exception exception;
        exception;
        throw exception;
_L3:
        r r1 = r.bB();
        r1.a(mContext, rk);
        rj = r1.bE();
          goto _L4
    }

    private void bM()
    {
        this;
        JVM INSTR monitorenter ;
        a a1;
        a a2;
        if (rI || ry == null)
        {
            break MISSING_BLOCK_LABEL_126;
        }
        a1 = rx;
        a2 = a.rP;
        if (a1 == a2)
        {
            break MISSING_BLOCK_LABEL_126;
        }
        rC = rC + 1;
        a(rE);
        rx = a.rN;
        rE = new Timer("Failed Connect");
        rE.schedule(new c(), 3000L);
        aa.v("connecting to Analytics service");
        ry.connect();
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
        Object obj;
        obj;
        aa.w("security exception on connectToService");
        bL();
          goto _L1
        obj;
        throw obj;
        aa.w("client not initialized.");
        bL();
          goto _L1
    }

    private void bN()
    {
        rD = a(rD);
        rD = new Timer("Service Reconnect");
        rD.schedule(new e(), 5000L);
    }

    static void c(s s1)
    {
        s1.bL();
    }

    static void d(s s1)
    {
        s1.bM();
    }

    static Queue e(s s1)
    {
        return s1.rB;
    }

    static long f(s s1)
    {
        return s1.rw;
    }

    static long g(s s1)
    {
        return s1.rK;
    }

    static i h(s s1)
    {
        return s1.rJ;
    }

    static void i(s s1)
    {
        s1.aD();
    }

    static Timer j(s s1)
    {
        return s1.rF;
    }

    public void a(int k, Intent intent)
    {
        this;
        JVM INSTR monitorenter ;
        rx = a.rR;
        if (rC >= 2) goto _L2; else goto _L1
_L1:
        aa.w((new StringBuilder()).append("Service unavailable (code=").append(k).append("), will retry.").toString());
        bN();
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        aa.w((new StringBuilder()).append("Service unavailable (code=").append(k).append("), using local store.").toString());
        bL();
        if (true) goto _L4; else goto _L3
_L3:
        intent;
        throw intent;
    }

    public void b(Map map, long l, String s1, List list)
    {
        aa.v("putHit called");
        rB.add(new d(map, l, s1, list));
        bJ();
    }

    public void bI()
    {
        if (ry != null)
        {
            return;
        } else
        {
            ry = new com.google.android.gms.analytics.c(mContext, this, this);
            bM();
            return;
        }
    }

    public void bk()
    {
        aa.v("clearHits called");
        rB.clear();
        switch (_cls3.rM[rx.ordinal()])
        {
        default:
            rG = true;
            return;

        case 1: // '\001'
            rj.i(0L);
            rG = false;
            return;

        case 2: // '\002'
            ry.bk();
            break;
        }
        rG = false;
    }

    public void bp()
    {
        switch (_cls3.rM[rx.ordinal()])
        {
        default:
            rm = true;
            // fall through

        case 2: // '\002'
            return;

        case 1: // '\001'
            bK();
            break;
        }
    }

    public void br()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = rI;
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        aa.v("setForceLocalDispatch called.");
        rI = true;
        _cls3.rM[rx.ordinal()];
        JVM INSTR tableswitch 1 6: default 96
    //                   1 11
    //                   2 76
    //                   3 88
    //                   4 11
    //                   5 11
    //                   6 11;
           goto _L3 _L3 _L4 _L5 _L3 _L3 _L3
_L3:
        if (true) goto _L1; else goto _L6
_L6:
_L4:
        aD();
          goto _L1
        Exception exception;
        exception;
        throw exception;
_L5:
        rH = true;
          goto _L1
    }

    public void onConnected()
    {
        this;
        JVM INSTR monitorenter ;
        rE = a(rE);
        rC = 0;
        aa.v("Connected to service");
        rx = a.rO;
        if (!rH) goto _L2; else goto _L1
_L1:
        aD();
        rH = false;
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        bJ();
        rF = a(rF);
        rF = new Timer("disconnect check");
        rF.schedule(new b(), rK);
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public void onDisconnected()
    {
        this;
        JVM INSTR monitorenter ;
        if (rx != a.rS) goto _L2; else goto _L1
_L1:
        aa.v("Disconnected from service");
        bH();
        rx = a.rT;
_L3:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        aa.v("Unexpected disconnect.");
        rx = a.rR;
        if (rC >= 2)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        bN();
          goto _L3
        Exception exception;
        exception;
        throw exception;
        bL();
          goto _L3
    }
}
