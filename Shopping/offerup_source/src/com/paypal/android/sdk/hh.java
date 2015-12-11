// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.List;
import javax.net.ssl.SSLSocket;

// Referenced classes of package com.paypal.android.sdk:
//            hg, he, kq, gp, 
//            hl

final class hh extends hg
{

    private final he a;
    private final he b;
    private final Method c;
    private final Method d;
    private final he e;
    private final he f;

    public hh(he he1, he he2, Method method, Method method1, he he3, he he4)
    {
        a = he1;
        b = he2;
        c = method;
        d = method1;
        e = he3;
        f = he4;
    }

    public final void a(Socket socket)
    {
        if (c == null)
        {
            return;
        }
        try
        {
            c.invoke(null, new Object[] {
                socket
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Socket socket)
        {
            throw new RuntimeException(socket);
        }
        // Misplaced declaration of an exception variable
        catch (Socket socket)
        {
            throw new RuntimeException(socket.getCause());
        }
    }

    public final void a(Socket socket, InetSocketAddress inetsocketaddress, int i)
    {
        try
        {
            socket.connect(inetsocketaddress, i);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Socket socket)
        {
            inetsocketaddress = new IOException("Exception in connect");
        }
        inetsocketaddress.initCause(socket);
        throw inetsocketaddress;
    }

    public final void a(SSLSocket sslsocket, String s, List list)
    {
        if (s != null)
        {
            a.a(sslsocket, new Object[] {
                Boolean.valueOf(true)
            });
            b.a(sslsocket, new Object[] {
                s
            });
        }
        if (f != null && f.a(sslsocket))
        {
            s = new kq();
            int j = list.size();
            for (int i = 0; i < j; i++)
            {
                gp gp1 = (gp)list.get(i);
                if (gp1 != gp.a)
                {
                    s.b(gp1.toString().length());
                    s.a(gp1.toString());
                }
            }

            s = s.m();
            f.b(sslsocket, new Object[] {
                s
            });
        }
    }

    public final String b(SSLSocket sslsocket)
    {
        if (e == null)
        {
            return null;
        }
        if (!e.a(sslsocket))
        {
            return null;
        }
        sslsocket = (byte[])e.b(sslsocket, new Object[0]);
        if (sslsocket != null)
        {
            return new String(sslsocket, hl.c);
        } else
        {
            return null;
        }
    }

    public final void b(Socket socket)
    {
        if (d == null)
        {
            return;
        }
        try
        {
            d.invoke(null, new Object[] {
                socket
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Socket socket)
        {
            throw new RuntimeException(socket);
        }
        // Misplaced declaration of an exception variable
        catch (Socket socket)
        {
            throw new RuntimeException(socket.getCause());
        }
    }
}
