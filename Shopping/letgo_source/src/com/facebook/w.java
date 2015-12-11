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
//            y, k, o, z, 
//            GraphRequest

class w extends FilterOutputStream
    implements y
{

    private final Map a;
    private final o b;
    private final long c = k.h();
    private long d;
    private long e;
    private long f;
    private z g;

    w(OutputStream outputstream, o o1, Map map, long l)
    {
        super(outputstream);
        b = o1;
        a = map;
        f = l;
    }

    static o a(w w1)
    {
        return w1.b;
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
                Object obj = (o.a)iterator.next();
                if (obj instanceof o.b)
                {
                    Handler handler = b.c();
                    obj = (o.b)obj;
                    if (handler == null)
                    {
                        ((o.b) (obj)).a(b, d, f);
                    } else
                    {
                        handler.post(new Runnable(((o.b) (obj))) {

                            final o.b a;
                            final w b;

                            public void run()
                            {
                                a.a(w.a(b), w.b(b), w.c(b));
                            }

            
            {
                b = w.this;
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

    static long b(w w1)
    {
        return w1.d;
    }

    static long c(w w1)
    {
        return w1.f;
    }

    public void a(GraphRequest graphrequest)
    {
        if (graphrequest != null)
        {
            graphrequest = (z)a.get(graphrequest);
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
        for (Iterator iterator = a.values().iterator(); iterator.hasNext(); ((z)iterator.next()).a()) { }
        a();
    }

    public void write(int i)
        throws IOException
    {
        out.write(i);
        a(1L);
    }

    public void write(byte abyte0[])
        throws IOException
    {
        out.write(abyte0);
        a(abyte0.length);
    }

    public void write(byte abyte0[], int i, int j)
        throws IOException
    {
        out.write(abyte0, i, j);
        a(j);
    }
}
