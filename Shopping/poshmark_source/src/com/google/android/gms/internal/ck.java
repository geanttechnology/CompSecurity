// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            da, dd, ar, cs

public final class ck
{

    private final Object mg = new Object();
    private int nX;
    private dd ng;
    public final ar oA = new ar() {

        final ck oB;

        public void a(dd dd1, Map map)
        {
            Object obj = ck.a(oB);
            obj;
            JVM INSTR monitorenter ;
            String s2 = (String)map.get("url");
            if (s2 != null)
            {
                break MISSING_BLOCK_LABEL_39;
            }
            da.w("URL missing in loadAdUrl GMSG.");
            obj;
            JVM INSTR monitorexit ;
            return;
            String s1 = s2;
            if (s2.contains("%40mediation_adapters%40"))
            {
                s1 = s2.replaceAll("%40mediation_adapters%40", cs.b(dd1.getContext(), (String)map.get("check_adapters"), ck.b(oB)));
                da.v((new StringBuilder()).append("Ad request URL modified to ").append(s1).toString());
            }
            ck.a(oB, s1);
            ck.a(oB).notify();
            obj;
            JVM INSTR monitorexit ;
            return;
            dd1;
            obj;
            JVM INSTR monitorexit ;
            throw dd1;
        }

            
            {
                oB = ck.this;
                super();
            }
    };
    private String ox;
    private String oy;
    public final ar oz = new ar() {

        final ck oB;

        public void a(dd dd, Map map)
        {
            synchronized (ck.a(oB))
            {
                String s1 = (String)map.get("type");
                map = (String)map.get("errors");
                da.w((new StringBuilder()).append("Invalid ").append(s1).append(" request error: ").append(map).toString());
                ck.a(oB, 1);
                ck.a(oB).notify();
            }
            return;
            map;
            dd;
            JVM INSTR monitorexit ;
            throw map;
        }

            
            {
                oB = ck.this;
                super();
            }
    };

    public ck(String s)
    {
        nX = -2;
        ox = s;
    }

    static int a(ck ck1, int i)
    {
        ck1.nX = i;
        return i;
    }

    static Object a(ck ck1)
    {
        return ck1.mg;
    }

    static String a(ck ck1, String s)
    {
        ck1.oy = s;
        return s;
    }

    static String b(ck ck1)
    {
        return ck1.ox;
    }

    public String aI()
    {
        Object obj = mg;
        obj;
        JVM INSTR monitorenter ;
_L1:
        int i;
        if (oy != null)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        i = nX;
        if (i != -2)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        mg.wait();
          goto _L1
        Object obj1;
        obj1;
        da.w("Ad request service was interrupted.");
        obj;
        JVM INSTR monitorexit ;
        return null;
        String s = oy;
        obj;
        JVM INSTR monitorexit ;
        return s;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public void b(dd dd)
    {
        synchronized (mg)
        {
            ng = dd;
        }
        return;
        dd;
        obj;
        JVM INSTR monitorexit ;
        throw dd;
    }

    public int getErrorCode()
    {
        int i;
        synchronized (mg)
        {
            i = nX;
        }
        return i;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
