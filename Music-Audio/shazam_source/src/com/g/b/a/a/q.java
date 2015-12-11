// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.b.a.a;

import c.c;
import c.e;
import c.s;
import com.g.b.a;
import com.g.b.a.e.b;
import com.g.b.a.i;
import com.g.b.a.k;
import com.g.b.f;
import com.g.b.j;
import com.g.b.n;
import com.g.b.u;
import com.g.b.v;
import com.g.b.x;
import com.g.b.z;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.URL;
import java.security.Principal;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

// Referenced classes of package com.g.b.a.a:
//            o, e, j

public final class q
{
    public static final class a
    {

        public final z a;
        public final Socket b;
        public final u c;
        public final n d;

        public a(z z1, Socket socket)
        {
            a = z1;
            b = socket;
            c = null;
            d = null;
        }

        public a(z z1, SSLSocket sslsocket, u u1, n n1)
        {
            a = z1;
            b = sslsocket;
            c = u1;
            d = n1;
        }
    }


    private final com.g.b.i a;
    private final j b;

    public q(com.g.b.i l, j j1)
    {
        a = l;
        b = j1;
    }

    public static Socket a(int l, int i1, z z1)
    {
        i j1 = i.a();
        Object obj;
        obj = z1.b;
        com.g.b.a a1 = z1.a;
        if (((Proxy) (obj)).type() != java.net.Proxy.Type.DIRECT && ((Proxy) (obj)).type() != java.net.Proxy.Type.HTTP)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        obj = a1.d.createSocket();
_L1:
        ((Socket) (obj)).setSoTimeout(l);
        j1.a(((Socket) (obj)), z1.c, i1);
        return ((Socket) (obj));
        try
        {
            obj = new Socket(((Proxy) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (z z1)
        {
            throw new o(z1);
        }
          goto _L1
    }

    public final a a(int l, int i1, int j1, v v1, z z1, List list, boolean flag)
    {
        com.g.b.a a1;
        com.g.b.a.a a2;
        a1 = z1.a;
        a2 = new com.g.b.a.a(list);
        list = null;
_L14:
        Object obj;
        Object obj1;
        com.g.b.a.a.e e1;
        Socket socket;
        int l1;
        socket = a(i1, l, z1);
        String s1;
        long l2;
        long l3;
        if (z1.a.e != null && z1.b.type() == java.net.Proxy.Type.HTTP)
        {
            l1 = 1;
        } else
        {
            l1 = 0;
        }
        if (l1 == 0)
        {
            break MISSING_BLOCK_LABEL_528;
        }
        obj1 = v1.a().getHost();
        l1 = k.a(v1.a());
        if (l1 != k.a("https")) goto _L2; else goto _L1
_L1:
        obj = obj1;
_L6:
        try
        {
            obj = (new com.g.b.v.a()).a(new URL("https", ((String) (obj1)), l1, "/")).a("Host", ((String) (obj))).a("Proxy-Connection", "Keep-Alive");
            obj1 = v1.a("User-Agent");
        }
        // Misplaced declaration of an exception variable
        catch (v v1)
        {
            throw new o(v1);
        }
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_162;
        }
        ((com.g.b.v.a) (obj)).a("User-Agent", ((String) (obj1)));
        obj1 = v1.a("Proxy-Authorization");
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_186;
        }
        ((com.g.b.v.a) (obj)).a("Proxy-Authorization", ((String) (obj1)));
        obj = ((com.g.b.v.a) (obj)).a();
        e1 = new com.g.b.a.a.e(b, a, socket);
        e1.a(i1, j1);
        obj1 = ((v) (obj)).a();
        s1 = (new StringBuilder("CONNECT ")).append(((URL) (obj1)).getHost()).append(":").append(k.a(((URL) (obj1)))).append(" HTTP/1.1").toString();
_L8:
        e1.a(((v) (obj)).c, s1);
        e1.a();
        obj1 = e1.c();
        obj1.a = ((v) (obj));
        obj = ((com.g.b.x.a) (obj1)).a();
        l3 = com.g.b.a.a.j.a(((x) (obj)));
        l2 = l3;
        if (l3 == -1L)
        {
            l2 = 0L;
        }
        obj1 = e1.a(l2);
        k.a(((s) (obj1)), 0x7fffffff, TimeUnit.MILLISECONDS);
        ((s) (obj1)).close();
        ((x) (obj)).c;
        JVM INSTR lookupswitch 2: default 1020
    //                   200: 460
    //                   407: 488;
           goto _L3 _L4 _L5
_L3:
        throw new IOException((new StringBuilder("Unexpected response code for CONNECT: ")).append(((x) (obj)).c).toString());
_L2:
        obj = (new StringBuilder()).append(((String) (obj1))).append(":").append(l1).toString();
          goto _L6
_L4:
        if (e1.c.b().b > 0L)
        {
            throw new IOException("TLS tunnel buffered too many bytes!");
        }
        break MISSING_BLOCK_LABEL_528;
_L5:
        obj1 = com.g.b.a.a.j.a(z1.a.h, ((x) (obj)), z1.b);
        obj = obj1;
        if (obj1 != null) goto _L8; else goto _L7
_L7:
        throw new IOException("Failed to authenticate with proxy");
        obj1 = (SSLSocket)a1.e.createSocket(socket, a1.b, a1.c, true);
        i k1;
        Object obj2;
        obj2 = a2.a(((SSLSocket) (obj1)));
        k1 = i.a();
        e1 = null;
        n n1;
        if (((com.g.b.k) (obj2)).g)
        {
            k1.a(((SSLSocket) (obj1)), a1.b, a1.i);
        }
        ((SSLSocket) (obj1)).startHandshake();
        n1 = n.a(((SSLSocket) (obj1)).getSession());
        obj = e1;
        if (!((com.g.b.k) (obj2)).g)
        {
            break MISSING_BLOCK_LABEL_648;
        }
        obj2 = k1.b(((SSLSocket) (obj1)));
        obj = e1;
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_648;
        }
        obj = u.a(((String) (obj2)));
        k1.a(((SSLSocket) (obj1)));
        if (!a1.f.verify(a1.b, ((SSLSocket) (obj1)).getSession()))
        {
            obj = (X509Certificate)((SSLSocket) (obj1)).getSession().getPeerCertificates()[0];
            throw new SSLPeerUnverifiedException((new StringBuilder("Hostname ")).append(a1.b).append(" not verified:\n    certificate: ").append(f.a(((java.security.cert.Certificate) (obj)))).append("\n    DN: ").append(((X509Certificate) (obj)).getSubjectDN().getName()).append("\n    subjectAltNames: ").append(com.g.b.a.e.b.a(((X509Certificate) (obj)))).toString());
        }
          goto _L9
        obj;
_L16:
        if (!flag) goto _L11; else goto _L10
_L10:
        boolean flag1;
        a2.b = true;
        if (!(obj instanceof ProtocolException) && !(obj instanceof InterruptedIOException) && (!(obj instanceof SSLHandshakeException) || !(((IOException) (obj)).getCause() instanceof CertificateException)) && !(obj instanceof SSLPeerUnverifiedException) && ((obj instanceof SSLHandshakeException) || (obj instanceof SSLProtocolException)) && a2.a)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (!flag1) goto _L11; else goto _L12
_L12:
        flag1 = true;
_L15:
        k.a(((Socket) (obj1)));
        k.a(socket);
        if (list == null)
        {
            list = new o(((IOException) (obj)));
        } else
        {
            obj1 = ((o) (list)).b;
            if (com.g.b.a.a.o.a != null)
            {
                try
                {
                    com.g.b.a.a.o.a.invoke(obj, new Object[] {
                        obj1
                    });
                }
                // Misplaced declaration of an exception variable
                catch (Object obj1) { }
                // Misplaced declaration of an exception variable
                catch (Object obj1) { }
            }
            list.b = ((IOException) (obj));
        }
        if (flag1) goto _L14; else goto _L13
_L13:
        throw list;
        obj;
        k1.a(((SSLSocket) (obj1)));
        throw obj;
_L9:
        a1.g.a(a1.b, n1.b);
        obj = new a(z1, ((SSLSocket) (obj1)), ((u) (obj)), n1);
        return ((a) (obj));
_L11:
        flag1 = false;
          goto _L15
        obj;
        obj1 = null;
          goto _L16
    }
}
