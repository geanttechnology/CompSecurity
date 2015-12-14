// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class cm
    implements ce
{

    private cm a;
    ck b;
    ch c;
    int d;
    private String e;
    private Long f;
    private Hashtable g;

    cm(String s, cm cm1, ck ck1, ch ch1)
    {
        e = s;
        a = cm1;
        b = ck1;
        c = ch1;
    }

    protected static boolean a(cw cw1, String s, Object obj)
    {
        cq cq1 = new cq();
        String s1;
        if (obj instanceof byte[])
        {
            s1 = "bin";
        } else
        if (obj instanceof Boolean)
        {
            s1 = "bool";
        } else
        if (obj instanceof Double)
        {
            s1 = "float";
        } else
        if (obj instanceof Integer)
        {
            s1 = "int";
        } else
        if (obj instanceof Long)
        {
            s1 = "long";
        } else
        if (obj instanceof String)
        {
            s1 = "str";
        } else
        if (obj instanceof ce)
        {
            s1 = "str";
        } else
        {
            s1 = "unknown";
        }
        if (s1.compareTo("unknown") == 0)
        {
            return false;
        }
        cq1.a("t", s1);
        cq1.a("k", s);
        if (obj instanceof byte[])
        {
            cq1.a("v", (byte[])obj);
        } else
        if (obj instanceof Boolean)
        {
            cq1.a("v", ((Boolean)obj).toString());
        } else
        if (obj instanceof Double)
        {
            cq1.a("v", ((Double)obj).toString());
        } else
        if (obj instanceof Integer)
        {
            cq1.b("v", ((Integer)obj).intValue());
        } else
        if (obj instanceof Long)
        {
            cq1.a("v", ((Long)obj).toString());
        } else
        if (obj instanceof String)
        {
            cq1.b("v", (String)obj);
        } else
        if (obj instanceof ce)
        {
            cq1.a("v", (new StringBuilder()).append(((cm)obj).b.b()).append(".").append(((cm)obj).d).toString());
        } else
        {
            return false;
        }
        cw1.a(cq1);
        return true;
    }

    public final cg a(String s)
    {
        return cl.a(this, s);
    }

    protected cw a()
    {
        ct ct1 = new ct();
        a(((cw) (ct1)), "RootParentId", b.b());
        if (a != null)
        {
            a(((cw) (ct1)), "ParentSeqId", new Integer(a.d));
        }
        a(((cw) (ct1)), "SeqId", new Integer(d));
        a(((cw) (ct1)), "Name", e);
        a(((cw) (ct1)), "Timestamp", f);
        return ct1;
    }

    public final void a(Hashtable hashtable, cl.b b1)
    {
        g = hashtable;
        f = Long.valueOf(System.currentTimeMillis());
        c.a(this, b1);
    }

    protected void c()
    {
        d = b.d();
    }

    public final cd e()
    {
        return c;
    }

    public final ce f()
    {
        return a;
    }

    public final byte[] g()
    {
        cq cq1 = new cq();
        cw cw1 = a();
        ct ct1 = new ct();
        String s;
        for (Iterator iterator = g.keySet().iterator(); iterator.hasNext(); a(ct1, s, g.get(s)))
        {
            s = (String)iterator.next();
        }

        cq1.a("meta", cw1);
        if (ct1.a() > 0)
        {
            cq1.a("attr", ct1);
        }
        return ((cq)cq1).d();
    }
}
