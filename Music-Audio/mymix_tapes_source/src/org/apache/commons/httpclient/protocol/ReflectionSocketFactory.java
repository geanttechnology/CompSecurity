// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient.protocol;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import org.apache.commons.httpclient.ConnectTimeoutException;

public final class ReflectionSocketFactory
{

    private static Constructor INETSOCKETADDRESS_CONSTRUCTOR = null;
    private static boolean REFLECTION_FAILED = false;
    private static Method SOCKETBIND_METHOD = null;
    private static Method SOCKETCONNECT_METHOD = null;
    private static Class SOCKETTIMEOUTEXCEPTION_CLASS = null;
    static Class class$java$net$InetAddress;
    static Class class$java$net$Socket;

    private ReflectionSocketFactory()
    {
    }

    static Class _mthclass$(String s)
    {
        try
        {
            s = Class.forName(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new NoClassDefFoundError(s.getMessage());
        }
        return s;
    }

    public static Socket createSocket(String s, String s1, int i, InetAddress inetaddress, int j, int k)
        throws IOException, UnknownHostException, ConnectTimeoutException
    {
        if (REFLECTION_FAILED)
        {
            return null;
        }
        Object obj;
        s = Class.forName(s);
        obj = s.getMethod("getDefault", new Class[0]).invoke(null, new Object[0]);
        obj = (Socket)s.getMethod("createSocket", new Class[0]).invoke(obj, new Object[0]);
        if (INETSOCKETADDRESS_CONSTRUCTOR != null) goto _L2; else goto _L1
_L1:
        Class class1 = Class.forName("java.net.InetSocketAddress");
        if (class$java$net$InetAddress != null) goto _L4; else goto _L3
_L3:
        s = _mthclass$("java.net.InetAddress");
        class$java$net$InetAddress = s;
_L11:
        INETSOCKETADDRESS_CONSTRUCTOR = class1.getConstructor(new Class[] {
            s, Integer.TYPE
        });
_L2:
        s1 = ((String) (INETSOCKETADDRESS_CONSTRUCTOR.newInstance(new Object[] {
            InetAddress.getByName(s1), new Integer(i)
        })));
        inetaddress = ((InetAddress) (INETSOCKETADDRESS_CONSTRUCTOR.newInstance(new Object[] {
            inetaddress, new Integer(j)
        })));
        if (SOCKETCONNECT_METHOD != null) goto _L6; else goto _L5
_L5:
        if (class$java$net$Socket != null) goto _L8; else goto _L7
_L7:
        s = _mthclass$("java.net.Socket");
        class$java$net$Socket = s;
_L12:
        SOCKETCONNECT_METHOD = s.getMethod("connect", new Class[] {
            Class.forName("java.net.SocketAddress"), Integer.TYPE
        });
_L6:
        if (SOCKETBIND_METHOD != null) goto _L10; else goto _L9
_L9:
        if (class$java$net$Socket != null)
        {
            break MISSING_BLOCK_LABEL_383;
        }
        s = _mthclass$("java.net.Socket");
        class$java$net$Socket = s;
_L13:
        SOCKETBIND_METHOD = s.getMethod("bind", new Class[] {
            Class.forName("java.net.SocketAddress")
        });
_L10:
        SOCKETBIND_METHOD.invoke(obj, new Object[] {
            inetaddress
        });
        SOCKETCONNECT_METHOD.invoke(obj, new Object[] {
            s1, new Integer(k)
        });
        return ((Socket) (obj));
_L4:
        try
        {
            s = class$java$net$InetAddress;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s = s.getTargetException();
            if (SOCKETTIMEOUTEXCEPTION_CLASS == null)
            {
                try
                {
                    SOCKETTIMEOUTEXCEPTION_CLASS = Class.forName("java.net.SocketTimeoutException");
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    REFLECTION_FAILED = true;
                    return null;
                }
            }
            if (SOCKETTIMEOUTEXCEPTION_CLASS.isInstance(s))
            {
                throw new ConnectTimeoutException("The host did not accept the connection within timeout of " + k + " ms", s);
            }
            if (s instanceof IOException)
            {
                throw (IOException)s;
            } else
            {
                return null;
            }
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            REFLECTION_FAILED = true;
            return null;
        }
          goto _L11
_L8:
        s = class$java$net$Socket;
          goto _L12
        s = class$java$net$Socket;
          goto _L13
    }

}
