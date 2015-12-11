// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.SocketException;

// Referenced classes of package com.a.a.a:
//            m

class p extends m
{

    private final Method a;

    private p(Method method)
    {
        a = method;
    }

    p(Method method, byte byte0)
    {
        this(method);
    }

    public final int a(Socket socket)
    {
        NetworkInterface networkinterface;
        int i;
        try
        {
            networkinterface = NetworkInterface.getByInetAddress(socket.getLocalAddress());
        }
        catch (NullPointerException nullpointerexception)
        {
            return super.a(socket);
        }
        catch (SocketException socketexception)
        {
            return super.a(socket);
        }
        // Misplaced declaration of an exception variable
        catch (Socket socket)
        {
            throw new AssertionError(socket);
        }
        // Misplaced declaration of an exception variable
        catch (Socket socket)
        {
            if (socket.getCause() instanceof IOException)
            {
                throw (IOException)socket.getCause();
            } else
            {
                throw new RuntimeException(socket.getCause());
            }
        }
        if (networkinterface != null)
        {
            break MISSING_BLOCK_LABEL_18;
        }
        return super.a(socket);
        i = ((Integer)a.invoke(networkinterface, new Object[0])).intValue();
        return i;
    }
}
