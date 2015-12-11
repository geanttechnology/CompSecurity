// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a.a;

import com.a.a.a.a;
import com.a.a.a.u;
import com.a.a.b;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.CacheRequest;
import java.net.Socket;

// Referenced classes of package com.a.a.a.a:
//            ae, h, m, z, 
//            k, af, x, u, 
//            v, l, n, ab

public final class j
    implements ae
{

    final h a;
    final InputStream b;
    private final OutputStream c;
    private OutputStream d;

    public j(h h1, OutputStream outputstream, InputStream inputstream)
    {
        a = h1;
        c = outputstream;
        d = outputstream;
        b = inputstream;
    }

    static boolean a(h h1, InputStream inputstream)
    {
        h1 = h1.d;
        if (h1 != null) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        if ((h1 = ((b) (h1)).e) == null) goto _L1; else goto _L3
_L3:
        int i;
        try
        {
            i = h1.getSoTimeout();
            h1.setSoTimeout(100);
        }
        // Misplaced declaration of an exception variable
        catch (h h1)
        {
            return false;
        }
        u.b(inputstream);
        h1.setSoTimeout(i);
        return true;
        inputstream;
        h1.setSoTimeout(i);
        throw inputstream;
    }

    public final InputStream a(CacheRequest cacherequest)
    {
        if (!a.k())
        {
            return new m(b, cacherequest, a, 0);
        }
        if (a.j.a())
        {
            return new k(b, cacherequest, this);
        }
        if (a.j.s != -1)
        {
            return new m(b, cacherequest, a, a.j.s);
        } else
        {
            return new af(b, cacherequest, a);
        }
    }

    public final OutputStream a()
    {
        boolean flag1 = "chunked".equalsIgnoreCase(a.i.i);
        boolean flag = flag1;
        if (!flag1)
        {
            flag = flag1;
            if (a.a.d() > 0)
            {
                flag = flag1;
                if (a.d.j != 0)
                {
                    x x1 = a.i;
                    if (x1.i != null)
                    {
                        x1.a.d("Transfer-Encoding");
                    }
                    x1.a.a("Transfer-Encoding", "chunked");
                    x1.i = "chunked";
                    flag = true;
                }
            }
        }
        if (flag)
        {
            int i1 = a.a.d();
            int i = i1;
            if (i1 == -1)
            {
                i = 1024;
            }
            c();
            return new l(d, i, (byte)0);
        }
        long l1 = a.a.c();
        if (l1 != -1L)
        {
            a.i.a(l1);
            c();
            return new n(d, l1, (byte)0);
        }
        l1 = a.i.h;
        if (l1 > 0x7fffffffL)
        {
            throw new IllegalArgumentException("Use setFixedLengthStreamingMode() or setChunkedStreamingMode() for requests larger than 2 GiB.");
        }
        if (l1 != -1L)
        {
            c();
            return new ab((int)l1);
        } else
        {
            return new ab();
        }
    }

    public final void a(ab ab1)
    {
        OutputStream outputstream = d;
        ab1.b.writeTo(outputstream);
    }

    public final boolean a(boolean flag, OutputStream outputstream, InputStream inputstream)
    {
        while (flag || outputstream != null && !((a)outputstream).a || "close".equalsIgnoreCase(a.i.l) || a.j != null && "close".equalsIgnoreCase(a.j.t) || (inputstream instanceof af)) 
        {
            return false;
        }
        if (inputstream != null)
        {
            return a(a, inputstream);
        } else
        {
            return true;
        }
    }

    public final void b()
    {
        d.flush();
        d = c;
    }

    public final void c()
    {
        a.b();
        byte abyte0[] = a.i.a.b();
        d.write(abyte0);
    }

    public final z d()
    {
        Object obj = com.a.a.a.a.v.a(b);
        b b1 = a.d;
        int i;
        if (((v) (obj)).c != -1)
        {
            i = ((v) (obj)).c;
        } else
        {
            i = 1;
        }
        b1.j = i;
        a.a(((v) (obj)));
        obj = new z(a.h, ((v) (obj)));
        ((z) (obj)).a("http/1.1");
        return ((z) (obj));
    }
}
