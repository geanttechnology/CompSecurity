// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.b;

import com.g.b.a.a.g;
import com.g.b.a.a.l;
import com.g.b.a.a.o;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.List;

// Referenced classes of package com.g.b:
//            s, m, v, w, 
//            r, x, q

public final class e
{
    final class a
        implements q.a
    {

        final e a;
        private final int b;
        private final v c;
        private final boolean d;

        public final x a(v v1)
        {
            if (b < a.a.f.size())
            {
                a. new a(b + 1, v1, d);
                return ((q)a.a.f.get(b)).a();
            } else
            {
                return a.a(v1, d);
            }
        }

        a(int i, v v1, boolean flag)
        {
            a = e.this;
            super();
            b = i;
            c = v1;
            d = flag;
        }
    }


    final s a;
    volatile boolean b;
    v c;
    g d;
    private boolean e;

    e(s s1, v v1)
    {
        a = s1.a();
        c = v1;
    }

    public final x a()
    {
        this;
        JVM INSTR monitorenter ;
        if (e)
        {
            throw new IllegalStateException("Already Executed");
        }
        break MISSING_BLOCK_LABEL_24;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        e = true;
        this;
        JVM INSTR monitorexit ;
        Object obj;
        a.b.a(this);
        obj = (new a(0, c, false)).a(c);
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_94;
        }
        throw new IOException("Canceled");
        obj;
        a.b.b(this);
        throw obj;
        a.b.b(this);
        return ((x) (obj));
    }

    final x a(v v1, boolean flag)
    {
        w w1 = v1.d;
        int j;
        if (w1 != null)
        {
            v1 = v1.c();
            r r1 = w1.a();
            if (r1 != null)
            {
                v1.a("Content-Type", r1.toString());
            }
            long l1 = w1.b();
            if (l1 != -1L)
            {
                v1.a("Content-Length", Long.toString(l1));
                v1.b("Transfer-Encoding");
            } else
            {
                v1.a("Transfer-Encoding", "chunked");
                v1.b("Content-Length");
            }
            v1 = v1.a();
        }
        d = new g(a, v1, false, false, flag, null, null, null, null);
        j = 0;
        do
        {
            if (b)
            {
                d.g();
                throw new IOException("Canceled");
            }
            Object obj;
            try
            {
                d.a();
                d.i();
            }
            // Misplaced declaration of an exception variable
            catch (v v1)
            {
                throw v1.a();
            }
            // Misplaced declaration of an exception variable
            catch (v v1)
            {
                obj = d.a(v1);
                if (obj != null)
                {
                    d = ((g) (obj));
                } else
                {
                    throw ((o) (v1)).b;
                }
                continue;
            }
            // Misplaced declaration of an exception variable
            catch (v v1)
            {
                obj = d.a(v1, null);
                if (obj != null)
                {
                    d = ((g) (obj));
                } else
                {
                    throw v1;
                }
                continue;
            }
            v1 = d.f();
            obj = d.j();
            if (obj == null)
            {
                if (!flag)
                {
                    d.g();
                }
                return v1;
            }
            j++;
            if (j > 20)
            {
                throw new ProtocolException((new StringBuilder("Too many follow-up requests: ")).append(j).toString());
            }
            if (!d.b(((v) (obj)).a()))
            {
                d.g();
            }
            i i = d.h();
            d = new g(a, ((v) (obj)), false, false, flag, i, null, null, v1);
        } while (true);
    }
}
