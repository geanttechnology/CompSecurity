// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a;

import com.a.a.a.a.d;
import com.a.a.a.a.v;
import com.a.a.a.b.q;
import com.a.a.a.u;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.URL;

// Referenced classes of package com.a.a:
//            x, v, a

public final class b
    implements Closeable
{

    public static final byte a[] = {
        6, 115, 112, 100, 121, 47, 51, 8, 104, 116, 
        116, 112, 47, 49, 46, 49
    };
    public static final byte b[] = {
        115, 112, 100, 121, 47, 51
    };
    public static final byte c[] = {
        104, 116, 116, 112, 47, 49, 46, 49
    };
    public final com.a.a.v d;
    public Socket e;
    public InputStream f;
    public OutputStream g;
    public boolean h;
    public q i;
    public int j;
    long k;

    public b(com.a.a.v v1)
    {
        h = false;
        j = 1;
        d = v1;
    }

    public final void a(x x1)
    {
        v v1 = new v();
        v1.a((new StringBuilder("CONNECT ")).append(x1.a).append(":").append(x1.b).append(" HTTP/1.1").toString());
        Object obj;
        if (x1.b == u.a("https"))
        {
            obj = x1.a;
        } else
        {
            obj = (new StringBuilder()).append(x1.a).append(":").append(x1.b).toString();
        }
        v1.b("Host", ((String) (obj)));
        v1.b("User-Agent", x1.c);
        if (x1.d != null)
        {
            v1.b("Proxy-Authorization", x1.d);
        }
        v1.b("Proxy-Connection", "Keep-Alive");
        obj = v1;
label0:
        do
        {
            g.write(((v) (obj)).b());
            v v2 = v.a(f);
            switch (v2.d)
            {
            default:
                throw new IOException((new StringBuilder("Unexpected response code for CONNECT: ")).append(v2.d).toString());

            case 200: 
                break label0;

            case 407: 
                obj = new v(((v) (obj)));
                URL url = new URL("https", x1.a, x1.b, "/");
                if (!com.a.a.a.a.d.a(d.a.f, 407, v2, ((v) (obj)), d.b, url))
                {
                    throw new IOException("Failed to authenticate with proxy");
                }
                break;
            }
        } while (true);
    }

    public final boolean a()
    {
        return !e.isClosed() && !e.isInputShutdown() && !e.isOutputShutdown();
    }

    public final boolean b()
    {
        if (!(f instanceof BufferedInputStream))
        {
            return true;
        }
        if (e())
        {
            return true;
        }
        BufferedInputStream bufferedinputstream = (BufferedInputStream)f;
        Exception exception;
        int l;
        int i1;
        try
        {
            l = e.getSoTimeout();
        }
        catch (SocketTimeoutException sockettimeoutexception)
        {
            return true;
        }
        catch (IOException ioexception)
        {
            return false;
        }
        e.setSoTimeout(1);
        bufferedinputstream.mark(1);
        i1 = bufferedinputstream.read();
        if (i1 != -1)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        e.setSoTimeout(l);
        return false;
        bufferedinputstream.reset();
        e.setSoTimeout(l);
        return true;
        exception;
        e.setSoTimeout(l);
        throw exception;
    }

    public final boolean c()
    {
        return i == null || i.a();
    }

    public final void close()
    {
        e.close();
    }

    public final long d()
    {
        if (i == null)
        {
            return k;
        } else
        {
            return i.b();
        }
    }

    public final boolean e()
    {
        return i != null;
    }

}
