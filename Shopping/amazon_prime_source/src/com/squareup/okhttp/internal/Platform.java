// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal;

import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.internal.okio.ByteString;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;

// Referenced classes of package com.squareup.okhttp.internal:
//            Util

public class Platform
{
    private static class Android extends Platform
    {

        private final Method getNpnSelectedProtocol;
        protected final Class openSslSocketClass;
        private final Method setHostname;
        private final Method setNpnProtocols;
        private final Method setUseSessionTickets;

        public void connectSocket(Socket socket, InetSocketAddress inetsocketaddress, int i)
            throws IOException
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

        public void enableTlsExtensions(SSLSocket sslsocket, String s)
        {
            enableTlsExtensions(sslsocket, s);
            if (!openSslSocketClass.isInstance(sslsocket))
            {
                return;
            }
            try
            {
                setUseSessionTickets.invoke(sslsocket, new Object[] {
                    Boolean.valueOf(true)
                });
                setHostname.invoke(sslsocket, new Object[] {
                    s
                });
                return;
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
        }

        public ByteString getNpnSelectedProtocol(SSLSocket sslsocket)
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
                throw new RuntimeException(sslsocket);
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
            sslsocket = ByteString.of(sslsocket);
            return sslsocket;
        }

        public void setNpnProtocols(SSLSocket sslsocket, List list)
        {
            while (setNpnProtocols == null || !openSslSocketClass.isInstance(sslsocket)) 
            {
                return;
            }
            try
            {
                list = concatLengthPrefixed(list);
                setNpnProtocols.invoke(sslsocket, new Object[] {
                    list
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

        private Android(Class class1, Method method, Method method1, Method method2, Method method3)
        {
            openSslSocketClass = class1;
            setUseSessionTickets = method;
            setHostname = method1;
            setNpnProtocols = method2;
            getNpnSelectedProtocol = method3;
        }

    }

    private static class JdkWithJettyNpnPlatform extends Platform
    {

        private final Class clientProviderClass;
        private final Method getMethod;
        private final Method putMethod;
        private final Class serverProviderClass;

        public ByteString getNpnSelectedProtocol(SSLSocket sslsocket)
        {
            sslsocket = (JettyNpnProvider)Proxy.getInvocationHandler(getMethod.invoke(null, new Object[] {
                sslsocket
            }));
            if (((JettyNpnProvider) (sslsocket)).unsupported || ((JettyNpnProvider) (sslsocket)).selected != null)
            {
                break MISSING_BLOCK_LABEL_52;
            }
            Logger.getLogger("com.squareup.okhttp.OkHttpClient").log(Level.INFO, "NPN callback dropped so SPDY is disabled. Is npn-boot on the boot class path?");
            return null;
label0:
            {
                try
                {
                    if (((JettyNpnProvider) (sslsocket)).unsupported)
                    {
                        break label0;
                    }
                    sslsocket = ByteString.encodeUtf8(((JettyNpnProvider) (sslsocket)).selected);
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
                return sslsocket;
            }
            return null;
        }

        public void setNpnProtocols(SSLSocket sslsocket, List list)
        {
            Object obj;
            Class class1;
            Class class2;
            int i;
            int j;
            try
            {
                obj = new ArrayList(list.size());
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
            i = 0;
            j = list.size();
_L2:
            if (i >= j)
            {
                break; /* Loop/switch isn't completed */
            }
            ((List) (obj)).add(((Protocol)list.get(i)).name.utf8());
            i++;
            if (true) goto _L2; else goto _L1
_L1:
            list = com/squareup/okhttp/internal/Platform.getClassLoader();
            class1 = clientProviderClass;
            class2 = serverProviderClass;
            obj = new JettyNpnProvider(((List) (obj)));
            list = ((List) (Proxy.newProxyInstance(list, new Class[] {
                class1, class2
            }, ((InvocationHandler) (obj)))));
            putMethod.invoke(null, new Object[] {
                sslsocket, list
            });
            return;
        }

        public JdkWithJettyNpnPlatform(Method method, Method method1, Class class1, Class class2)
        {
            putMethod = method;
            getMethod = method1;
            clientProviderClass = class1;
            serverProviderClass = class2;
        }
    }

    private static class JettyNpnProvider
        implements InvocationHandler
    {

        private final List protocols;
        private String selected;
        private boolean unsupported;

        public Object invoke(Object obj, Method method, Object aobj[])
            throws Throwable
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
            if (s.equals("selectProtocol") && java/lang/String == class1 && obj.length == 1 && (obj[0] == null || (obj[0] instanceof List)))
            {
                obj = (List)obj[0];
                int i = 0;
                for (int j = ((List) (obj)).size(); i < j; i++)
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
            if (s.equals("protocolSelected") && obj.length == 1)
            {
                selected = (String)obj[0];
                return null;
            } else
            {
                return method.invoke(this, ((Object []) (obj)));
            }
        }



        public JettyNpnProvider(List list)
        {
            protocols = list;
        }
    }


    private static final Platform PLATFORM = findPlatform();

    public Platform()
    {
    }

    static byte[] concatLengthPrefixed(List list)
    {
        int i = 0;
        for (Iterator iterator = list.iterator(); iterator.hasNext();)
        {
            i += ((Protocol)iterator.next()).name.size() + 1;
        }

        byte abyte0[] = new byte[i];
        i = 0;
        for (list = list.iterator(); list.hasNext();)
        {
            Protocol protocol = (Protocol)list.next();
            int j = protocol.name.size();
            int k = i + 1;
            abyte0[i] = (byte)j;
            System.arraycopy(protocol.name.toByteArray(), 0, abyte0, k, j);
            i = k + j;
        }

        return abyte0;
    }

    private static Platform findPlatform()
    {
        Class class1 = Class.forName("com.android.org.conscrypt.OpenSSLSocketImpl");
_L1:
        Method method2;
        Method method3;
        method2 = class1.getMethod("setUseSessionTickets", new Class[] {
            Boolean.TYPE
        });
        method3 = class1.getMethod("setHostname", new Class[] {
            java/lang/String
        });
        Object obj;
        Object obj2;
        obj = null;
        obj2 = null;
        Method method = class1.getMethod("setNpnProtocols", new Class[] {
            [B
        });
        obj = method;
        Method method1 = class1.getMethod("getNpnSelectedProtocol", new Class[0]);
        obj2 = method1;
        obj = method;
_L4:
        Object obj1;
        Class class2;
        try
        {
            return new Android(class1, method2, method3, ((Method) (obj)), ((Method) (obj2)));
        }
        catch (ClassNotFoundException classnotfoundexception) { }
        // Misplaced declaration of an exception variable
        catch (Object obj1) { }
        break MISSING_BLOCK_LABEL_107;
        obj1;
        class1 = Class.forName("org.apache.harmony.xnet.provider.jsse.OpenSSLSocketImpl");
          goto _L1
        obj1 = Class.forName("org.eclipse.jetty.npn.NextProtoNego");
        class1 = Class.forName((new StringBuilder()).append("org.eclipse.jetty.npn.NextProtoNego").append("$Provider").toString());
        class2 = Class.forName((new StringBuilder()).append("org.eclipse.jetty.npn.NextProtoNego").append("$ClientProvider").toString());
        obj2 = Class.forName((new StringBuilder()).append("org.eclipse.jetty.npn.NextProtoNego").append("$ServerProvider").toString());
        obj1 = new JdkWithJettyNpnPlatform(((Class) (obj1)).getMethod("put", new Class[] {
            javax/net/ssl/SSLSocket, class1
        }), ((Class) (obj1)).getMethod("get", new Class[] {
            javax/net/ssl/SSLSocket
        }), class2, ((Class) (obj2)));
        return ((Platform) (obj1));
        obj1;
_L3:
        return new Platform();
        obj1;
        if (true) goto _L3; else goto _L2
_L2:
        NoSuchMethodException nosuchmethodexception;
        nosuchmethodexception;
          goto _L4
    }

    public static Platform get()
    {
        return PLATFORM;
    }

    public void connectSocket(Socket socket, InetSocketAddress inetsocketaddress, int i)
        throws IOException
    {
        socket.connect(inetsocketaddress, i);
    }

    public void enableTlsExtensions(SSLSocket sslsocket, String s)
    {
    }

    public ByteString getNpnSelectedProtocol(SSLSocket sslsocket)
    {
        return null;
    }

    public String getPrefix()
    {
        return "OkHttp";
    }

    public void logW(String s)
    {
        System.out.println(s);
    }

    public void setNpnProtocols(SSLSocket sslsocket, List list)
    {
    }

    public void supportTlsIntolerantServer(SSLSocket sslsocket)
    {
        sslsocket.setEnabledProtocols(new String[] {
            "SSLv3"
        });
    }

    public void tagSocket(Socket socket)
        throws SocketException
    {
    }

    public URI toUriLenient(URL url)
        throws URISyntaxException
    {
        return url.toURI();
    }

    public void untagSocket(Socket socket)
        throws SocketException
    {
    }

}
