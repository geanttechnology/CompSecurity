// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.List;
import javax.net.ssl.SSLSocket;

// Referenced classes of package com.paypal.android.sdk:
//            he, hh, hi

public class hg
{

    private static final hg a = c();

    public hg()
    {
    }

    public static hg a()
    {
        return a;
    }

    public static void a(String s)
    {
        System.out.println(s);
    }

    public static String b()
    {
        return "OkHttp";
    }

    private static hg c()
    {
        Class.forName("com.android.org.conscrypt.OpenSSLSocketImpl");
_L1:
        he he1;
        he he2;
        he1 = new he(null, "setUseSessionTickets", new Class[] {
            Boolean.TYPE
        });
        he2 = new he(null, "setHostname", new Class[] {
            java/lang/String
        });
        Object obj;
        Object obj1;
        obj = Class.forName("android.net.TrafficStats");
        obj1 = ((Class) (obj)).getMethod("tagSocket", new Class[] {
            java/net/Socket
        });
        Object obj2 = ((Class) (obj)).getMethod("untagSocket", new Class[] {
            java/net/Socket
        });
        Class.forName("android.net.Network");
        obj = new he([B, "getAlpnSelectedProtocol", new Class[0]);
        Object obj3 = new he(null, "setAlpnProtocols", new Class[] {
            [B
        });
        Object obj5 = obj1;
        obj1 = obj;
        obj = obj5;
_L2:
        try
        {
            return new hh(he1, he2, ((java.lang.reflect.Method) (obj)), ((java.lang.reflect.Method) (obj2)), ((he) (obj1)), ((he) (obj3)));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        break MISSING_BLOCK_LABEL_164;
        obj;
        Class.forName("org.apache.harmony.xnet.provider.jsse.OpenSSLSocketImpl");
          goto _L1
        obj = Class.forName("org.eclipse.jetty.alpn.ALPN");
        obj1 = Class.forName((new StringBuilder()).append("org.eclipse.jetty.alpn.ALPN").append("$Provider").toString());
        obj2 = Class.forName((new StringBuilder()).append("org.eclipse.jetty.alpn.ALPN").append("$ClientProvider").toString());
        obj3 = Class.forName((new StringBuilder()).append("org.eclipse.jetty.alpn.ALPN").append("$ServerProvider").toString());
        obj = new hi(((Class) (obj)).getMethod("put", new Class[] {
            javax/net/ssl/SSLSocket, obj1
        }), ((Class) (obj)).getMethod("get", new Class[] {
            javax/net/ssl/SSLSocket
        }), ((Class) (obj)).getMethod("remove", new Class[] {
            javax/net/ssl/SSLSocket
        }), ((Class) (obj2)), ((Class) (obj3)));
        return ((hg) (obj));
        obj;
_L3:
        return new hg();
        obj;
        obj = null;
_L6:
        Object obj6 = null;
        obj3 = obj1;
        obj1 = obj;
        obj = obj3;
        obj3 = obj6;
          goto _L2
        obj;
        obj = null;
_L4:
        obj2 = null;
        obj3 = null;
        obj1 = obj;
        obj = obj3;
_L5:
        Object obj7 = null;
        obj3 = obj1;
        obj1 = obj;
        obj = obj3;
        obj3 = obj7;
          goto _L2
        obj;
          goto _L3
        obj;
        obj = obj1;
          goto _L4
        NoSuchMethodException nosuchmethodexception;
        nosuchmethodexception;
        nosuchmethodexception = null;
        obj2 = null;
        obj1 = null;
          goto _L5
        nosuchmethodexception;
        nosuchmethodexception = null;
        obj2 = null;
          goto _L5
        nosuchmethodexception;
        nosuchmethodexception = null;
          goto _L5
        Object obj4;
        obj4;
          goto _L5
        obj4;
          goto _L6
    }

    public void a(Socket socket)
    {
    }

    public void a(Socket socket, InetSocketAddress inetsocketaddress, int i)
    {
        socket.connect(inetsocketaddress, i);
    }

    public void a(SSLSocket sslsocket)
    {
    }

    public void a(SSLSocket sslsocket, String s, List list)
    {
    }

    public String b(SSLSocket sslsocket)
    {
        return null;
    }

    public void b(Socket socket)
    {
    }

}
