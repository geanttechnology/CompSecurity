// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            ct, cw, an, cl

public final class cg
{

    private final Object fx = new Object();
    private cw gv;
    private String hK;
    private String hL;
    public final an hM = new an() {

        final cg hO;

        public void a(cw cw, Map map)
        {
            synchronized (cg.a(hO))
            {
                String s1 = (String)map.get("type");
                map = (String)map.get("errors");
                ct.v((new StringBuilder()).append("Invalid ").append(s1).append(" request error: ").append(map).toString());
                cg.a(hO, 1);
                cg.a(hO).notify();
            }
            return;
            map;
            cw;
            JVM INSTR monitorexit ;
            throw map;
        }

            
            {
                hO = cg.this;
                super();
            }
    };
    public final an hN = new an() {

        final cg hO;

        public void a(cw cw1, Map map)
        {
            Object obj = cg.a(hO);
            obj;
            JVM INSTR monitorenter ;
            String s2 = (String)map.get("url");
            if (s2 != null)
            {
                break MISSING_BLOCK_LABEL_39;
            }
            ct.v("URL missing in loadAdUrl GMSG.");
            obj;
            JVM INSTR monitorexit ;
            return;
            String s1 = s2;
            if (s2.contains("%40mediation_adapters%40"))
            {
                s1 = s2.replaceAll("%40mediation_adapters%40", cl.b(cw1.getContext(), (String)map.get("check_adapters"), cg.b(hO)));
                ct.u((new StringBuilder()).append("Ad request URL modified to ").append(s1).toString());
            }
            cg.a(hO, s1);
            cg.a(hO).notify();
            obj;
            JVM INSTR monitorexit ;
            return;
            cw1;
            obj;
            JVM INSTR monitorexit ;
            throw cw1;
        }

            
            {
                hO = cg.this;
                super();
            }
    };
    private int hm;

    public cg(String s)
    {
        hm = -2;
        hK = s;
    }

    static int a(cg cg1, int i)
    {
        cg1.hm = i;
        return i;
    }

    static Object a(cg cg1)
    {
        return cg1.fx;
    }

    static String a(cg cg1, String s)
    {
        cg1.hL = s;
        return s;
    }

    static String b(cg cg1)
    {
        return cg1.hK;
    }

    public String ap()
    {
        Object obj = fx;
        obj;
        JVM INSTR monitorenter ;
_L1:
        int i;
        if (hL != null)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        i = hm;
        if (i != -2)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        fx.wait();
          goto _L1
        Object obj1;
        obj1;
        ct.v("Ad request service was interrupted.");
        obj;
        JVM INSTR monitorexit ;
        return null;
        String s = hL;
        obj;
        JVM INSTR monitorexit ;
        return s;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public void b(cw cw)
    {
        synchronized (fx)
        {
            gv = cw;
        }
        return;
        cw;
        obj;
        JVM INSTR monitorexit ;
        throw cw;
    }

    public int getErrorCode()
    {
        int i;
        synchronized (fx)
        {
            i = hm;
        }
        return i;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
