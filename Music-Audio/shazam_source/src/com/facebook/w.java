// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook;

import android.os.Handler;
import java.io.FilterOutputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.facebook:
//            y, k, o, z, 
//            GraphRequest

final class w extends FilterOutputStream
    implements y
{

    private final Map a;
    private final o b;
    private final long c = k.i();
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

    private void a()
    {
        if (d > e)
        {
            Iterator iterator = b.e.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                Object obj = (o.a)iterator.next();
                if (obj instanceof o.b)
                {
                    Handler handler = b.a;
                    obj = (o.b)obj;
                    if (handler != null)
                    {
                        handler.post(new Runnable(((o.b) (obj))) {

                            final o.b a;
                            final w b;

                            public final void run()
                            {
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
            z z1 = g;
            z1.b = z1.b + l;
            if (z1.b >= z1.c + z1.a || z1.b >= z1.d)
            {
                z1.a();
            }
        }
        d = d + l;
        if (d >= e + c || d >= f)
        {
            a();
        }
    }

    public final void a(GraphRequest graphrequest)
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

    public final void close()
    {
        super.close();
        for (Iterator iterator = a.values().iterator(); iterator.hasNext(); ((z)iterator.next()).a()) { }
        a();
    }

    public final void write(int i)
    {
        out.write(i);
        a(1L);
    }

    public final void write(byte abyte0[])
    {
        out.write(abyte0);
        a(abyte0.length);
    }

    public final void write(byte abyte0[], int i, int j)
    {
        out.write(abyte0, i, j);
        a(j);
    }
}
