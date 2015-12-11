// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.net.ssl.SSLSocket;

// Referenced classes of package com.a.a.a:
//            n

final class o extends n
{

    private final Method b;
    private final Method c;

    private o(Method method, Class class1, Method method1, Method method2, Method method3, Method method4)
    {
        super(method, class1, method1, method2, (byte)0);
        b = method3;
        c = method4;
    }

    o(Method method, Class class1, Method method1, Method method2, Method method3, Method method4, byte byte0)
    {
        this(method, class1, method1, method2, method3, method4);
    }

    public final void a(SSLSocket sslsocket, byte abyte0[])
    {
        if (!a.isInstance(sslsocket))
        {
            return;
        }
        try
        {
            b.invoke(sslsocket, new Object[] {
                abyte0
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (SSLSocket sslsocket)
        {
            throw new AssertionError(sslsocket);
        }
        // Misplaced declaration of an exception variable
        catch (SSLSocket sslsocket)
        {
            throw new RuntimeException(sslsocket);
        }
    }

    public final byte[] b(SSLSocket sslsocket)
    {
        if (!a.isInstance(sslsocket))
        {
            return null;
        }
        try
        {
            sslsocket = (byte[])(byte[])c.invoke(sslsocket, new Object[0]);
        }
        // Misplaced declaration of an exception variable
        catch (SSLSocket sslsocket)
        {
            throw new RuntimeException(sslsocket);
        }
        // Misplaced declaration of an exception variable
        catch (SSLSocket sslsocket)
        {
            throw new AssertionError(sslsocket);
        }
        return sslsocket;
    }
}
