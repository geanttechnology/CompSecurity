// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package android.support.v7:
//            acx, aah, abo, ado, 
//            ace, ack, abw, aar

public class aaf
{
    public static interface a
    {

        public abstract Object a(String s, Map map);
    }

    public static interface b
    {

        public abstract void a(String s, Map map);
    }

    private class c
        implements aei.a
    {

        final aaf a;

        public Object a(String s, Map map)
        {
            a a1 = a.c(s);
            if (a1 == null)
            {
                return null;
            } else
            {
                return a1.a(s, map);
            }
        }

        private c()
        {
            a = aaf.this;
            super();
        }

    }

    private class d
        implements aei.a
    {

        final aaf a;

        public Object a(String s, Map map)
        {
            b b1 = a.d(s);
            if (b1 != null)
            {
                b1.a(s, map);
            }
            return ado.e();
        }

        private d()
        {
            a = aaf.this;
            super();
        }

    }


    private final Context a;
    private final String b;
    private final aah c;
    private acx d;
    private Map e;
    private Map f;
    private volatile long g;
    private volatile String h;

    aaf(Context context, aah aah1, String s, long l, xh.c c1)
    {
        e = new HashMap();
        f = new HashMap();
        h = "";
        a = context;
        c = aah1;
        b = s;
        g = l;
        a(c1);
    }

    private void a(acx acx1)
    {
        this;
        JVM INSTR monitorenter ;
        d = acx1;
        this;
        JVM INSTR monitorexit ;
        return;
        acx1;
        throw acx1;
    }

    private void a(xh.c c1)
    {
        h = c1.c();
        aar aar = f(h);
        a(new acx(a, c1, c, new c(), new d(), aar));
        if (a("_gtm.loadEventEnabled"))
        {
            c.a("gtm.load", aah.a(new Object[] {
                "gtm.id", b
            }));
        }
    }

    private acx d()
    {
        this;
        JVM INSTR monitorenter ;
        acx acx1 = d;
        this;
        JVM INSTR monitorexit ;
        return acx1;
        Exception exception;
        exception;
        throw exception;
    }

    public long a()
    {
        return g;
    }

    public boolean a(String s)
    {
        acx acx1 = d();
        if (acx1 == null)
        {
            abo.a("getBoolean called for closed container.");
            return ado.c().booleanValue();
        }
        boolean flag;
        try
        {
            flag = ado.d((lv.a)acx1.b(s).a()).booleanValue();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            abo.a((new StringBuilder()).append("Calling getBoolean() threw an exception: ").append(s.getMessage()).append(" Returning default value.").toString());
            return ado.c().booleanValue();
        }
        return flag;
    }

    public String b(String s)
    {
        acx acx1 = d();
        if (acx1 == null)
        {
            abo.a("getString called for closed container.");
            return ado.e();
        }
        try
        {
            s = ado.a((lv.a)acx1.b(s).a());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            abo.a((new StringBuilder()).append("Calling getString() threw an exception: ").append(s.getMessage()).append(" Returning default value.").toString());
            return ado.e();
        }
        return s;
    }

    public boolean b()
    {
        return a() == 0L;
    }

    a c(String s)
    {
        synchronized (e)
        {
            s = (a)e.get(s);
        }
        return s;
        s;
        map;
        JVM INSTR monitorexit ;
        throw s;
    }

    void c()
    {
        d = null;
    }

    b d(String s)
    {
        synchronized (f)
        {
            s = (b)f.get(s);
        }
        return s;
        s;
        map;
        JVM INSTR monitorexit ;
        throw s;
    }

    void e(String s)
    {
        d().a(s);
    }

    aar f(String s)
    {
        if (!ack.a().b().equals(ack.a.c));
        return new abw();
    }
}
