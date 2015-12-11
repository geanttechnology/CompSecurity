// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocket;

// Referenced classes of package com.a.a.a:
//            p

class n extends p
{

    protected final Class a;
    private final Method b;
    private final Method c;

    private n(Method method, Class class1, Method method1, Method method2)
    {
        super(method, (byte)0);
        a = class1;
        b = method1;
        c = method2;
    }

    n(Method method, Class class1, Method method1, Method method2, byte byte0)
    {
        this(method, class1, method1, method2);
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

    public final void a(SSLSocket sslsocket, String s)
    {
        super.a(sslsocket, s);
        if (!a.isInstance(sslsocket))
        {
            break MISSING_BLOCK_LABEL_54;
        }
        b.invoke(sslsocket, new Object[] {
            Boolean.valueOf(true)
        });
        c.invoke(sslsocket, new Object[] {
            s
        });
        return;
        sslsocket;
        throw new RuntimeException(sslsocket);
        sslsocket;
        throw new AssertionError(sslsocket);
    }
}
