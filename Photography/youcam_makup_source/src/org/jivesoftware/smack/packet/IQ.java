// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jivesoftware.smack.packet;

import org.jivesoftware.smack.util.r;

// Referenced classes of package org.jivesoftware.smack.packet:
//            e, b, XMPPError

public abstract class IQ extends e
{

    private b a;
    private String b;
    private String d;

    public IQ()
    {
        a = b.a;
        b = null;
        d = null;
    }

    public IQ(IQ iq)
    {
        super(iq);
        a = b.a;
        b = null;
        d = null;
        a = iq.c();
    }

    public static IQ a(IQ iq)
    {
        if (iq.c() != b.a && iq.c() != b.b)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("IQ must be of type 'set' or 'get'. Original IQ: ").append(iq.g()).toString());
        } else
        {
            _cls1 _lcls1 = new _cls1();
            _lcls1.a(b.c);
            _lcls1.k(iq.q());
            _lcls1.m(iq.r());
            _lcls1.l(iq.s());
            return _lcls1;
        }
    }

    public static IQ a(IQ iq, XMPPError xmpperror)
    {
        if (iq.c() != b.a && iq.c() != b.b)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("IQ must be of type 'set' or 'get'. Original IQ: ").append(iq.g()).toString());
        } else
        {
            _cls2 _lcls2 = new _cls2(iq);
            _lcls2.a(b.d);
            _lcls2.k(iq.q());
            _lcls2.m(iq.r());
            _lcls2.l(iq.s());
            _lcls2.a(xmpperror);
            return _lcls2;
        }
    }

    public void a(b b1)
    {
        if (b1 == null)
        {
            a = b.a;
            return;
        } else
        {
            a = b1;
            return;
        }
    }

    public abstract CharSequence b();

    public b c()
    {
        return a;
    }

    public void c(String s)
    {
        d = s;
    }

    public String d()
    {
        return d;
    }

    public void d(String s)
    {
        b = s;
    }

    public String e()
    {
        return b;
    }

    public CharSequence g()
    {
        r r1 = new r();
        r1.a("iq");
        a(r1);
        XMPPError xmpperror;
        if (a == null)
        {
            r1.c("type", "get");
        } else
        {
            r1.c("type", a.toString());
        }
        r1.b();
        r1.a(b());
        xmpperror = t();
        if (xmpperror != null)
        {
            r1.b(xmpperror.c());
        }
        r1.c("iq");
        return r1;
    }

    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls2 {}

}
