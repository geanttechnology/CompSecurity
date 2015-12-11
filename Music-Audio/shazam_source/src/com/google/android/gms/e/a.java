// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.e;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.google.android.gms.e:
//            bf, ar, bs, c, 
//            aj, cj, az

public final class com.google.android.gms.e.a
{
    public static interface a
    {

        public abstract Object a();
    }

    public static interface b
    {
    }

    private final class c
        implements dd.a
    {

        final com.google.android.gms.e.a a;

        public final Object a(String s)
        {
            s = a.c(s);
            if (s == null)
            {
                return null;
            } else
            {
                return s.a();
            }
        }

        private c()
        {
            a = com.google.android.gms.e.a.this;
            super();
        }

        c(byte byte0)
        {
            this();
        }
    }

    private final class d
        implements dd.a
    {

        final com.google.android.gms.e.a a;

        public final Object a(String s)
        {
            a.d(s);
            return cj.e();
        }

        private d()
        {
            a = com.google.android.gms.e.a.this;
            super();
        }

        d(byte byte0)
        {
            this();
        }
    }


    bs a;
    public volatile long b;
    private final Context c;
    private final String d;
    private final com.google.android.gms.e.c e;
    private Map f;
    private Map g;
    private volatile String h;

    com.google.android.gms.e.a(Context context, com.google.android.gms.e.c c1, String s, long l, com.google.android.gms.d.kf.c c2)
    {
        f = new HashMap();
        g = new HashMap();
        h = "";
        c = context;
        e = c1;
        d = s;
        b = l;
        h = c2.c;
        context = h;
        bf.a().a.equals(bf.a.c);
        context = new ar();
        a(new bs(c, c2, e, new c((byte)0), new d((byte)0), context));
        if (a("_gtm.loadEventEnabled"))
        {
            context = e;
            c1 = new HashMap(com.google.android.gms.e.c.a(new Object[] {
                "gtm.id", d
            }));
            c1.put("event", "gtm.load");
            context.a(c1);
        }
    }

    private void a(bs bs1)
    {
        this;
        JVM INSTR monitorenter ;
        a = bs1;
        this;
        JVM INSTR monitorexit ;
        return;
        bs1;
        throw bs1;
    }

    final bs a()
    {
        this;
        JVM INSTR monitorenter ;
        bs bs1 = a;
        this;
        JVM INSTR monitorexit ;
        return bs1;
        Exception exception;
        exception;
        throw exception;
    }

    public final boolean a(String s)
    {
        bs bs1 = a();
        if (bs1 == null)
        {
            aj.a("getBoolean called for closed container.");
            return cj.c().booleanValue();
        }
        boolean flag;
        try
        {
            flag = cj.d((com.google.android.gms.d.h.a)bs1.b(s).a).booleanValue();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            aj.a((new StringBuilder("Calling getBoolean() threw an exception: ")).append(s.getMessage()).append(" Returning default value.").toString());
            return cj.c().booleanValue();
        }
        return flag;
    }

    public final String b(String s)
    {
        bs bs1 = a();
        if (bs1 == null)
        {
            aj.a("getString called for closed container.");
            return cj.e();
        }
        try
        {
            s = cj.a((com.google.android.gms.d.h.a)bs1.b(s).a);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            aj.a((new StringBuilder("Calling getString() threw an exception: ")).append(s.getMessage()).append(" Returning default value.").toString());
            return cj.e();
        }
        return s;
    }

    final a c(String s)
    {
        synchronized (f)
        {
            s = (a)f.get(s);
        }
        return s;
        s;
        map;
        JVM INSTR monitorexit ;
        throw s;
    }

    final b d(String s)
    {
        synchronized (g)
        {
            s = (b)g.get(s);
        }
        return s;
        s;
        map;
        JVM INSTR monitorexit ;
        throw s;
    }
}
