// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook;

import android.os.Handler;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.facebook:
//            w, i, m, x, 
//            GraphRequest

class u extends FilterOutputStream
    implements w
{

    private final Map a;
    private final m b;
    private final long c = i.h();
    private long d;
    private long e;
    private long f;
    private x g;

    u(OutputStream outputstream, m m1, Map map, long l)
    {
        super(outputstream);
        b = m1;
        a = map;
        f = l;
    }

    static m a(u u1)
    {
        return u1.b;
    }

    private void a()
    {
        if (d > e)
        {
            Iterator iterator = b.e().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                Object obj = (m.a)iterator.next();
                if (obj instanceof m.b)
                {
                    Handler handler = b.c();
                    obj = (m.b)obj;
                    if (handler == null)
                    {
                        ((m.b) (obj)).a(b, d, f);
                    } else
                    {
                        handler.post(new Runnable(((m.b) (obj))) {

                            final m.b a;
                            final u b;

                            public void run()
                            {
                                a.a(u.a(b), u.b(b), u.c(b));
                            }

            
            {
                b = u.this;
                a = b1;
                super();
            }
                        });
                    }
                }
            } while (true);
            e = d;
        }
    }

    private void a(long l)
    {
        if (g != null)
        {
            g.a(l);
        }
        d = d + l;
        if (d >= e + c || d >= f)
        {
            a();
        }
    }

    static long b(u u1)
    {
        return u1.d;
    }

    static long c(u u1)
    {
        return u1.f;
    }

    public void a(GraphRequest graphrequest)
    {
        if (graphrequest != null)
        {
            graphrequest = (x)a.get(graphrequest);
        } else
        {
            graphrequest = null;
        }
        g = graphrequest;
    }

    public void close()
        throws IOException
    {
        super.close();
        for (Iterator iterator = a.values().iterator(); iterator.hasNext(); ((x)iterator.next()).a()) { }
        a();
    }

    public void write(int j)
        throws IOException
    {
        out.write(j);
        a(1L);
    }

    public void write(byte abyte0[])
        throws IOException
    {
        out.write(abyte0);
        a(abyte0.length);
    }

    public void write(byte abyte0[], int j, int k)
        throws IOException
    {
        out.write(abyte0, j, k);
        a(k);
    }
}
