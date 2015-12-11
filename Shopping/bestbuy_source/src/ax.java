// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;

public final class ax
{

    private final ag a;
    private final ao b;
    private final ab c;

    public ax(ag ag, ao ao, ab ab)
    {
        a = ag;
        b = ao;
        c = ab;
    }

    static ab a(ax ax1)
    {
        return ax1.c;
    }

    static ag b(ax ax1)
    {
        return ax1.a;
    }

    static ao c(ax ax1)
    {
        return ax1.b;
    }

    // Unreferenced inner class ax$1

/* anonymous class */
    final class _cls1 extends ay
    {

        private HttpUriRequest c;

        protected final Object a()
        {
            b = a.execute(c);
            return b;
        }

            
            {
                c = httpurirequest1;
                super(ax.this, httpclient, httpurirequest);
            }
    }


    // Unreferenced inner class ax$2

/* anonymous class */
    final class _cls2 extends ay
    {

        private HttpUriRequest c;
        private HttpContext d;

        protected final Object a()
        {
            b = a.execute(c, d);
            return b;
        }

            
            {
                c = httpurirequest1;
                d = httpcontext;
                super(ax.this, httpclient, httpurirequest);
            }
    }

}
