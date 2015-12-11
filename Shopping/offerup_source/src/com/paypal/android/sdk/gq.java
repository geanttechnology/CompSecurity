// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.io.IOException;
import java.net.URI;

// Referenced classes of package com.paypal.android.sdk:
//            gr, gh, gg, gi, 
//            fo, gs

public final class gq
{

    private final gi a;
    private final String b;
    private final gg c;
    private final gs d;
    private final Object e;
    private volatile URI f;
    private volatile fo g;

    private gq(gr gr1)
    {
        a = gr.a(gr1);
        b = gr.b(gr1);
        c = gr.c(gr1).a();
        d = gr.d(gr1);
        if (gr.e(gr1) != null)
        {
            gr1 = ((gr) (gr.e(gr1)));
        } else
        {
            gr1 = this;
        }
        e = gr1;
    }

    gq(gr gr1, byte byte0)
    {
        this(gr1);
    }

    static gi a(gq gq1)
    {
        return gq1.a;
    }

    static String b(gq gq1)
    {
        return gq1.b;
    }

    static gs c(gq gq1)
    {
        return gq1.d;
    }

    static Object d(gq gq1)
    {
        return gq1.e;
    }

    static gg e(gq gq1)
    {
        return gq1.c;
    }

    public final gi a()
    {
        return a;
    }

    public final String a(String s)
    {
        return c.a(s);
    }

    public final URI b()
    {
        URI uri;
        try
        {
            uri = f;
        }
        catch (IllegalStateException illegalstateexception)
        {
            throw new IOException(illegalstateexception.getMessage());
        }
        if (uri != null)
        {
            return uri;
        }
        uri = a.b();
        f = uri;
        return uri;
    }

    public final String c()
    {
        return a.toString();
    }

    public final String d()
    {
        return b;
    }

    public final gg e()
    {
        return c;
    }

    public final gs f()
    {
        return d;
    }

    public final Object g()
    {
        return e;
    }

    public final gr h()
    {
        return new gr(this, (byte)0);
    }

    public final fo i()
    {
        fo fo1 = g;
        if (fo1 != null)
        {
            return fo1;
        } else
        {
            fo fo2 = fo.a(c);
            g = fo2;
            return fo2;
        }
    }

    public final boolean j()
    {
        return a.d();
    }

    public final String toString()
    {
        StringBuilder stringbuilder = (new StringBuilder("Request{method=")).append(b).append(", url=").append(a).append(", tag=");
        Object obj;
        if (e != this)
        {
            obj = e;
        } else
        {
            obj = null;
        }
        return stringbuilder.append(obj).append('}').toString();
    }
}
