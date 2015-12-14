// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal;

import com.squareup.okhttp.Protocol;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URI;
import java.net.URL;
import java.util.List;
import javax.net.ssl.SSLSocket;
import okio.d;

public class Platform
{

    private static final Platform PLATFORM = findPlatform();

    public Platform()
    {
    }

    static byte[] concatLengthPrefixed(List list)
    {
        d d1 = new d();
        int j = list.size();
        int i = 0;
        while (i < j) 
        {
            Protocol protocol = (Protocol)list.get(i);
            if (protocol != Protocol.HTTP_1_0)
            {
                d1.a(protocol.toString().length());
                d1.a(protocol.toString());
            }
            i++;
        }
        return d1.p();
    }

    private static Platform findPlatform()
    {
        Class class2 = Class.forName("com.android.org.conscrypt.OpenSSLSocketImpl");
_L2:
        Method method2;
        Method method3;
        method2 = class2.getMethod("setUseSessionTickets", new Class[] {
            Boolean.TYPE
        });
        method3 = class2.getMethod("setHostname", new Class[] {
            java/lang/String
        });
        Object obj;
        Object obj2;
        obj2 = Class.forName("android.net.TrafficStats");
        obj = ((Class) (obj2)).getMethod("tagSocket", new Class[] {
            java/net/Socket
        });
        obj2 = ((Class) (obj2)).getMethod("untagSocket", new Class[] {
            java/net/Socket
        });
_L3:
        Method method = class2.getMethod("setNpnProtocols", new Class[] {
            [B
        });
        Method method1 = class2.getMethod("getNpnSelectedProtocol", new Class[0]);
_L4:
        Object obj1;
        NoSuchMethodException nosuchmethodexception;
        try
        {
            return new Android(class2, method2, method3, ((Method) (obj)), ((Method) (obj2)), method, method1);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1) { }
          goto _L1
        obj1;
        class2 = Class.forName("org.apache.harmony.xnet.provider.jsse.OpenSSLSocketImpl");
          goto _L2
        obj1;
        obj1 = null;
_L10:
        obj2 = null;
          goto _L3
        obj1;
        obj1 = null;
_L9:
        obj2 = null;
          goto _L3
        nosuchmethodexception;
        nosuchmethodexception = null;
_L8:
        method1 = null;
          goto _L4
_L1:
        obj2 = "org.eclipse.jetty.alpn.ALPN";
        obj1 = Class.forName("org.eclipse.jetty.alpn.ALPN");
_L5:
        Class class1 = Class.forName((new StringBuilder()).append(((String) (obj2))).append("$Provider").toString());
        Class class3 = Class.forName((new StringBuilder()).append(((String) (obj2))).append("$ClientProvider").toString());
        obj2 = Class.forName((new StringBuilder()).append(((String) (obj2))).append("$ServerProvider").toString());
        obj1 = new JdkWithJettyBootPlatform(((Class) (obj1)).getMethod("put", new Class[] {
            javax/net/ssl/SSLSocket, class1
        }), ((Class) (obj1)).getMethod("get", new Class[] {
            javax/net/ssl/SSLSocket
        }), class3, ((Class) (obj2)));
        return ((Platform) (obj1));
        obj1;
_L6:
        return new Platform();
        obj1;
        obj2 = "org.eclipse.jetty.npn.NextProtoNego";
        obj1 = Class.forName("org.eclipse.jetty.npn.NextProtoNego");
          goto _L5
        obj1;
          goto _L6
        obj1;
        if (true) goto _L1; else goto _L7
_L7:
        NoSuchMethodException nosuchmethodexception1;
        nosuchmethodexception1;
          goto _L8
        Object obj3;
        obj3;
          goto _L9
        obj3;
          goto _L10
    }

    public static Platform get()
    {
        return PLATFORM;
    }

    public void configureTlsExtensions(SSLSocket sslsocket, String s, List list)
    {
    }

    public void connectSocket(Socket socket, InetSocketAddress inetsocketaddress, int i)
    {
        socket.connect(inetsocketaddress, i);
    }

    public String getPrefix()
    {
        return "OkHttp";
    }

    public String getSelectedProtocol(SSLSocket sslsocket)
    {
        return null;
    }

    public void logW(String s)
    {
        System.out.println(s);
    }

    public void tagSocket(Socket socket)
    {
    }

    public URI toUriLenient(URL url)
    {
        return url.toURI();
    }

    public void untagSocket(Socket socket)
    {
    }


    private class Android extends Platform
    {

        private final Method getNpnSelectedProtocol;
        protected final Class openSslSocketClass;
        private final Method setHostname;
        private final Method setNpnProtocols;
        private final Method setUseSessionTickets;
        private final Method trafficStatsTagSocket;
        private final Method trafficStatsUntagSocket;

        public void configureTlsExtensions(SSLSocket sslsocket, String s, List list)
        {
            if (openSslSocketClass.isInstance(sslsocket))
            {
                if (s != null)
                {
                    try
                    {
                        setUseSessionTickets.invoke(sslsocket, new Object[] {
                            Boolean.valueOf(true)
                        });
                        setHostname.invoke(sslsocket, new Object[] {
                            s
                        });
                    }
                    // Misplaced declaration of an exception variable
                    catch (SSLSocket sslsocket)
                    {
                        throw new RuntimeException(sslsocket.getCause());
                    }
                    // Misplaced declaration of an exception variable
                    catch (SSLSocket sslsocket)
                    {
                        throw new AssertionError(sslsocket);
                    }
                }
                if (setNpnProtocols != null)
                {
                    try
                    {
                        s = concatLengthPrefixed(list);
                        setNpnProtocols.invoke(sslsocket, new Object[] {
                            s
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
                        throw new RuntimeException(sslsocket.getCause());
                    }
                }
            }
        }

        public void connectSocket(Socket socket, InetSocketAddress inetsocketaddress, int i)
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

        public String getSelectedProtocol(SSLSocket sslsocket)
        {
            if (getNpnSelectedProtocol == null)
            {
                return null;
            }
            if (!openSslSocketClass.isInstance(sslsocket))
            {
                return null;
            }
            try
            {
                sslsocket = (byte[])(byte[])getNpnSelectedProtocol.invoke(sslsocket, new Object[0]);
            }
            // Misplaced declaration of an exception variable
            catch (SSLSocket sslsocket)
            {
                throw new RuntimeException(sslsocket.getCause());
            }
            // Misplaced declaration of an exception variable
            catch (SSLSocket sslsocket)
            {
                throw new AssertionError(sslsocket);
            }
            if (sslsocket == null)
            {
                return null;
            }
            sslsocket = new String(sslsocket, Util.UTF_8);
            return sslsocket;
        }

        public void tagSocket(Socket socket)
        {
            if (trafficStatsTagSocket == null)
            {
                return;
            }
            try
            {
                trafficStatsTagSocket.invoke(null, new Object[] {
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

        public void untagSocket(Socket socket)
        {
            if (trafficStatsUntagSocket == null)
            {
                return;
            }
            try
            {
                trafficStatsUntagSocket.invoke(null, new Object[] {
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

        private Android(Class class1, Method method, Method method1, Method method2, Method method3, Method method4, Method method5)
        {
            openSslSocketClass = class1;
            setUseSessionTickets = method;
            setHostname = method1;
            trafficStatsTagSocket = method2;
            trafficStatsUntagSocket = method3;
            setNpnProtocols = method4;
            getNpnSelectedProtocol = method5;
        }

    }


    private class JdkWithJettyBootPlatform extends Platform
    {

        private final Class clientProviderClass;
        private final Method getMethod;
        private final Method putMethod;
        private final Class serverProviderClass;

        public void configureTlsExtensions(SSLSocket sslsocket, String s, List list)
        {
            s = new ArrayList(list.size());
            int j = list.size();
            int i = 0;
            while (i < j) 
            {
                Protocol protocol = (Protocol)list.get(i);
                if (protocol != Protocol.HTTP_1_0)
                {
                    s.add(protocol.toString());
                }
                i++;
            }
            try
            {
                list = com/squareup/okhttp/internal/Platform.getClassLoader();
                Class class1 = clientProviderClass;
                Class class2 = serverProviderClass;
                s = new JettyNegoProvider(s);
                s = ((String) (Proxy.newProxyInstance(list, new Class[] {
                    class1, class2
                }, s)));
                putMethod.invoke(null, new Object[] {
                    sslsocket, s
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
                throw new AssertionError(sslsocket);
            }
        }

        public String getSelectedProtocol(SSLSocket sslsocket)
        {
            sslsocket = (JettyNegoProvider)Proxy.getInvocationHandler(getMethod.invoke(null, new Object[] {
                sslsocket
            }));
            if (((JettyNegoProvider) (sslsocket)).unsupported || ((JettyNegoProvider) (sslsocket)).selected != null)
            {
                break MISSING_BLOCK_LABEL_50;
            }
            Internal.logger.log(Level.INFO, "NPN/ALPN callback dropped: SPDY and HTTP/2 are disabled. Is npn-boot or alpn-boot on the boot class path?");
            return null;
            if (((JettyNegoProvider) (sslsocket)).unsupported)
            {
                sslsocket = null;
            } else
            {
                try
                {
                    sslsocket = ((JettyNegoProvider) (sslsocket)).selected;
                }
                // Misplaced declaration of an exception variable
                catch (SSLSocket sslsocket)
                {
                    throw new AssertionError();
                }
                // Misplaced declaration of an exception variable
                catch (SSLSocket sslsocket)
                {
                    throw new AssertionError();
                }
            }
            return sslsocket;
        }

        public JdkWithJettyBootPlatform(Method method, Method method1, Class class1, Class class2)
        {
            putMethod = method;
            getMethod = method1;
            clientProviderClass = class1;
            serverProviderClass = class2;
        }

        private class JettyNegoProvider
            implements InvocationHandler
        {

            private final List protocols;
            private String selected;
            private boolean unsupported;

            public Object invoke(Object obj, Method method, Object aobj[])
            {
                String s = method.getName();
                Class class1 = method.getReturnType();
                obj = ((Object) (aobj));
                if (aobj == null)
                {
                    obj = Util.EMPTY_STRING_ARRAY;
                }
                if (s.equals("supports") && Boolean.TYPE == class1)
                {
                    return Boolean.valueOf(true);
                }
                if (s.equals("unsupported") && Void.TYPE == class1)
                {
                    unsupported = true;
                    return null;
                }
                if (s.equals("protocols") && obj.length == 0)
                {
                    return protocols;
                }
                if ((s.equals("selectProtocol") || s.equals("select")) && java/lang/String == class1 && obj.length == 1 && (obj[0] instanceof List))
                {
                    obj = (List)obj[0];
                    int j = ((List) (obj)).size();
                    for (int i = 0; i < j; i++)
                    {
                        if (protocols.contains(((List) (obj)).get(i)))
                        {
                            obj = (String)((List) (obj)).get(i);
                            selected = ((String) (obj));
                            return obj;
                        }
                    }

                    obj = (String)protocols.get(0);
                    selected = ((String) (obj));
                    return obj;
                }
                if ((s.equals("protocolSelected") || s.equals("selected")) && obj.length == 1)
                {
                    selected = (String)obj[0];
                    return null;
                } else
                {
                    return method.invoke(this, ((Object []) (obj)));
                }
            }



            public JettyNegoProvider(List list)
            {
                protocols = list;
            }
        }

    }

}
