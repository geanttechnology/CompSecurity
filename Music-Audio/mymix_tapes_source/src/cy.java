// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.nuance.nmsp.client.sdk.oem.f;

public abstract class cy
{

    private static final bm b = d.a(cy);
    protected String a;
    private String c;
    private short d;
    private bn e;
    private bi f;
    private bi g;

    protected cy(String s, short word0, String s1, bi bi, bi bi1)
    {
        if (b.b())
        {
            b.b((new StringBuilder("in NMSPManager() gateway IP [")).append(s).append("] Port [").append(word0).append("]").toString());
        }
        String s2 = null;
        if (s == null)
        {
            s2 = " gatewayIP is null";
        } else
        if (s.length() == 0)
        {
            s2 = " gatewayIP is empty";
        }
        if (word0 <= 0)
        {
            s2 = " gatewayPort should be greater than 0";
        }
        if (s2 != null)
        {
            b.e((new StringBuilder("NMSPManager ")).append(java/lang/IllegalArgumentException.getName()).append(s2).toString());
            throw new IllegalArgumentException(s2);
        } else
        {
            c = s;
            d = word0;
            a = s1;
            f = bi;
            g = bi1;
            e = new f();
            return;
        }
    }

    public static String g()
        throws RuntimeException
    {
        throw new RuntimeException("Unsupported");
    }

    public final void a(bi bi)
    {
        f = bi;
    }

    public final String b()
    {
        return c;
    }

    public final void b(bi bi)
    {
        g = bi;
    }

    public final short c()
    {
        return d;
    }

    public final bn c_()
    {
        return e;
    }

    public final String d()
    {
        return a;
    }

    public final bi e()
    {
        return f;
    }

    public final bi f()
    {
        return g;
    }

}
