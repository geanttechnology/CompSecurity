// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a;

import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.URI;
import java.net.URL;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import javax.net.ssl.SSLSocket;

// Referenced classes of package com.a.a.a:
//            o, n, q, p

public class m
{

    private static final m a = e();
    private Constructor b;

    public m()
    {
    }

    public static m a()
    {
        return a;
    }

    public static URI a(URL url)
    {
        return url.toURI();
    }

    public static void a(String s)
    {
        System.out.println(s);
    }

    public static void a(SSLSocket sslsocket)
    {
        sslsocket.setEnabledProtocols(new String[] {
            "SSLv3"
        });
    }

    public static String b()
    {
        return "OkHttp";
    }

    public static void c()
    {
    }

    public static void d()
    {
    }

    private static m e()
    {
        Object obj;
        java.lang.reflect.Method method;
        java.lang.reflect.Method method1;
        java.lang.reflect.Method method2;
        o o1;
        try
        {
            method = java/net/NetworkInterface.getMethod("getMTU", new Class[0]);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return new m();
        }
        obj = Class.forName("com.android.org.conscrypt.OpenSSLSocketImpl");
_L1:
        method1 = ((Class) (obj)).getMethod("setUseSessionTickets", new Class[] {
            Boolean.TYPE
        });
        method2 = ((Class) (obj)).getMethod("setHostname", new Class[] {
            java/lang/String
        });
        o1 = new o(method, ((Class) (obj)), method1, method2, ((Class) (obj)).getMethod("setNpnProtocols", new Class[] {
            [B
        }), ((Class) (obj)).getMethod("getNpnSelectedProtocol", new Class[0]), (byte)0);
        return o1;
        obj;
        obj = Class.forName("org.apache.harmony.xnet.provider.jsse.OpenSSLSocketImpl");
          goto _L1
        NoSuchMethodException nosuchmethodexception;
        nosuchmethodexception;
        obj = new n(method, ((Class) (obj)), method1, method2, (byte)0);
        return ((m) (obj));
        Object obj1;
        obj1;
_L5:
        obj1 = Class.forName("org.eclipse.jetty.npn.NextProtoNego");
        Class class1 = Class.forName((new StringBuilder()).append("org.eclipse.jetty.npn.NextProtoNego").append("$Provider").toString());
        Class class2 = Class.forName((new StringBuilder()).append("org.eclipse.jetty.npn.NextProtoNego").append("$ClientProvider").toString());
        Class class3 = Class.forName((new StringBuilder()).append("org.eclipse.jetty.npn.NextProtoNego").append("$ServerProvider").toString());
        obj1 = new q(method, ((Class) (obj1)).getMethod("put", new Class[] {
            javax/net/ssl/SSLSocket, class1
        }), ((Class) (obj1)).getMethod("get", new Class[] {
            javax/net/ssl/SSLSocket
        }), class2, class3);
        return ((m) (obj1));
        obj1;
_L3:
        return new p(method, (byte)0);
        obj1;
        if (true) goto _L3; else goto _L2
_L2:
        obj1;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public int a(Socket socket)
    {
        return 1400;
    }

    public final OutputStream a(OutputStream outputstream, Deflater deflater)
    {
        Constructor constructor;
        Constructor constructor1;
        try
        {
            constructor1 = b;
        }
        // Misplaced declaration of an exception variable
        catch (OutputStream outputstream)
        {
            throw new UnsupportedOperationException("Cannot SPDY; no SYNC_FLUSH available");
        }
        // Misplaced declaration of an exception variable
        catch (OutputStream outputstream)
        {
            if (outputstream.getCause() instanceof RuntimeException)
            {
                outputstream = (RuntimeException)outputstream.getCause();
            } else
            {
                outputstream = new RuntimeException(outputstream.getCause());
            }
            throw outputstream;
        }
        // Misplaced declaration of an exception variable
        catch (OutputStream outputstream)
        {
            throw new RuntimeException(outputstream);
        }
        // Misplaced declaration of an exception variable
        catch (OutputStream outputstream)
        {
            throw new AssertionError();
        }
        constructor = constructor1;
        if (constructor1 != null)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        constructor = java/util/zip/DeflaterOutputStream.getConstructor(new Class[] {
            java/io/OutputStream, java/util/zip/Deflater, Boolean.TYPE
        });
        b = constructor;
        outputstream = (OutputStream)constructor.newInstance(new Object[] {
            outputstream, deflater, Boolean.valueOf(true)
        });
        return outputstream;
    }

    public void a(Socket socket, InetSocketAddress inetsocketaddress, int i)
    {
        socket.connect(inetsocketaddress, i);
    }

    public void a(SSLSocket sslsocket, String s)
    {
    }

    public void a(SSLSocket sslsocket, byte abyte0[])
    {
    }

    public byte[] b(SSLSocket sslsocket)
    {
        return null;
    }

}
