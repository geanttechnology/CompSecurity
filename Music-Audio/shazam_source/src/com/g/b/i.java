// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.b;

import com.g.b.a.a.e;
import com.g.b.a.d.o;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

// Referenced classes of package com.g.b:
//            u, z, a, n, 
//            j

public final class i
{

    final j a;
    public final z b;
    public Socket c;
    boolean d;
    e e;
    o f;
    public u g;
    long h;
    public n i;
    int j;
    Object k;

    public i(j j1, z z1)
    {
        d = false;
        g = u.b;
        a = j1;
        b = z1;
    }

    final void a(Object obj)
    {
        if (e())
        {
            return;
        }
        j j1 = a;
        j1;
        JVM INSTR monitorenter ;
        if (k != null)
        {
            throw new IllegalStateException("Connection already has an owner!");
        }
        break MISSING_BLOCK_LABEL_37;
        obj;
        j1;
        JVM INSTR monitorexit ;
        throw obj;
        k = obj;
        j1;
        JVM INSTR monitorexit ;
    }

    final boolean a()
    {
label0:
        {
            synchronized (a)
            {
                if (k != null)
                {
                    break label0;
                }
            }
            return false;
        }
        k = null;
        j1;
        JVM INSTR monitorexit ;
        return true;
        exception;
        j1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    final boolean b()
    {
        return !c.isClosed() && !c.isInputShutdown() && !c.isOutputShutdown();
    }

    final boolean c()
    {
        return f == null || f.a();
    }

    final long d()
    {
        if (f == null)
        {
            return h;
        } else
        {
            return f.b();
        }
    }

    final boolean e()
    {
        return f != null;
    }

    public final String toString()
    {
        StringBuilder stringbuilder = (new StringBuilder("Connection{")).append(b.a.b).append(":").append(b.a.c).append(", proxy=").append(b.b).append(" hostAddress=").append(b.c.getAddress().getHostAddress()).append(" cipherSuite=");
        String s;
        if (i != null)
        {
            s = i.a;
        } else
        {
            s = "none";
        }
        return stringbuilder.append(s).append(" protocol=").append(g).append('}').toString();
    }
}
