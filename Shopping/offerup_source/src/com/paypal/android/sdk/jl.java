// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.paypal.android.sdk:
//            kz, kw, lk, jp, 
//            jo, ha, ks, kr, 
//            gg, kd, jq, fy, 
//            kq, kg, gv, gh, 
//            jz, gp, jn, jr, 
//            fz, lh, ju, lj

public final class jl
{

    private final fz a;
    private final fy b;
    private final Socket c;
    private final ks d;
    private final kr e;
    private int f;
    private int g;

    public jl(fz fz, fy fy1, Socket socket)
    {
        f = 0;
        g = 0;
        a = fz;
        b = fy1;
        c = socket;
        d = kz.a(kz.b(socket));
        e = kz.a(kz.a(socket));
    }

    static int a(jl jl1, int j)
    {
        jl1.f = j;
        return j;
    }

    static kr a(jl jl1)
    {
        return jl1.e;
    }

    static void a(kw kw1)
    {
        lk lk1 = kw1.a();
        kw1.a(lk.a);
        lk1.f();
        lk1.e();
    }

    static ks b(jl jl1)
    {
        return jl1.d;
    }

    static int c(jl jl1)
    {
        return jl1.f;
    }

    static int d(jl jl1)
    {
        return jl1.g;
    }

    static int e(jl jl1)
    {
        jl1.g = 0;
        return 0;
    }

    static fz f(jl jl1)
    {
        return jl1.a;
    }

    static fy g(jl jl1)
    {
        return jl1.b;
    }

    public final lh a(long l)
    {
        if (f != 1)
        {
            throw new IllegalStateException((new StringBuilder("state: ")).append(f).toString());
        } else
        {
            f = 2;
            return new jp(this, l, (byte)0);
        }
    }

    public final lj a(ju ju)
    {
        if (f != 4)
        {
            throw new IllegalStateException((new StringBuilder("state: ")).append(f).toString());
        } else
        {
            f = 5;
            return new jo(this, ju);
        }
    }

    public final void a()
    {
        g = 1;
        if (f == 0)
        {
            g = 0;
            ha.b.a(a, b);
        }
    }

    public final void a(int j, int k)
    {
        if (j != 0)
        {
            d.a().a(j, TimeUnit.MILLISECONDS);
        }
        if (k != 0)
        {
            e.a().a(k, TimeUnit.MILLISECONDS);
        }
    }

    public final void a(gg gg1, String s)
    {
        if (f != 0)
        {
            throw new IllegalStateException((new StringBuilder("state: ")).append(f).toString());
        }
        e.b(s).b("\r\n");
        int j = 0;
        for (int k = gg1.a(); j < k; j++)
        {
            e.b(gg1.a(j)).b(": ").b(gg1.b(j)).b("\r\n");
        }

        e.b("\r\n");
        f = 1;
    }

    public final void a(gh gh1)
    {
        do
        {
            String s = d.l();
            if (s.length() != 0)
            {
                ha.b.a(gh1, s);
            } else
            {
                return;
            }
        } while (true);
    }

    public final void a(kd kd1)
    {
        if (f != 1)
        {
            throw new IllegalStateException((new StringBuilder("state: ")).append(f).toString());
        } else
        {
            f = 3;
            kd1.a(e);
            return;
        }
    }

    public final void a(Object obj)
    {
        ha.b.a(b, obj);
    }

    public final lj b(long l)
    {
        if (f != 4)
        {
            throw new IllegalStateException((new StringBuilder("state: ")).append(f).toString());
        } else
        {
            f = 5;
            return new jq(this, l);
        }
    }

    public final void b()
    {
        g = 2;
        if (f == 0)
        {
            f = 6;
            b.c().close();
        }
    }

    public final boolean c()
    {
        return f == 6;
    }

    public final void d()
    {
        e.flush();
    }

    public final long e()
    {
        return d.b().b;
    }

    public final boolean f()
    {
        Exception exception;
        int j;
        boolean flag;
        try
        {
            j = c.getSoTimeout();
        }
        catch (SocketTimeoutException sockettimeoutexception)
        {
            return true;
        }
        catch (IOException ioexception)
        {
            return false;
        }
        c.setSoTimeout(1);
        flag = d.c();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        c.setSoTimeout(j);
        return false;
        c.setSoTimeout(j);
        return true;
        exception;
        c.setSoTimeout(j);
        throw exception;
    }

    public final gv g()
    {
        if (f != 1 && f != 3)
        {
            throw new IllegalStateException((new StringBuilder("state: ")).append(f).toString());
        }
        gv gv1;
        try
        {
            kg kg1;
            do
            {
                kg1 = kg.a(d.l());
                gv1 = (new gv()).a(kg1.a).a(kg1.b).a(kg1.c);
                gh gh1 = new gh();
                a(gh1);
                gh1.a(jz.c, kg1.a.toString());
                gv1.a(gh1.a());
            } while (kg1.b == 100);
            f = 4;
        }
        catch (EOFException eofexception)
        {
            IOException ioexception = new IOException((new StringBuilder("unexpected end of stream on ")).append(b).append(" (recycle count=").append(ha.b.b(b)).append(")").toString());
            ioexception.initCause(eofexception);
            throw ioexception;
        }
        return gv1;
    }

    public final lh h()
    {
        if (f != 1)
        {
            throw new IllegalStateException((new StringBuilder("state: ")).append(f).toString());
        } else
        {
            f = 2;
            return new jn(this, (byte)0);
        }
    }

    public final lj i()
    {
        if (f != 4)
        {
            throw new IllegalStateException((new StringBuilder("state: ")).append(f).toString());
        } else
        {
            f = 5;
            return new jr(this, (byte)0);
        }
    }
}
