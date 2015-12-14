// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jivesoftware.smack.tcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.lang.reflect.Constructor;
import java.net.InetAddress;
import java.net.Socket;
import java.security.KeyStore;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.Security;
import java.security.cert.CertificateException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import org.apache.harmony.javax.security.auth.callback.Callback;
import org.apache.harmony.javax.security.auth.callback.CallbackHandler;
import org.apache.harmony.javax.security.auth.callback.PasswordCallback;
import org.apache.harmony.javax.security.sasl.SaslException;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.a.b;
import org.jivesoftware.smack.compression.XMPPInputOutputStream;
import org.jivesoftware.smack.d;
import org.jivesoftware.smack.i;
import org.jivesoftware.smack.j;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.packet.e;
import org.jivesoftware.smack.util.p;

// Referenced classes of package org.jivesoftware.smack.tcp:
//            b, a

public class c extends XMPPConnection
{

    private static final Logger t = Logger.getLogger(org/jivesoftware/smack/tcp/c.getName());
    private org.jivesoftware.smack.c.b A;
    private Collection B;
    private boolean C;
    private final Object D = new Object();
    Socket o;
    String p;
    String q;
    org.jivesoftware.smack.tcp.b r;
    a s;
    private String u;
    private boolean v;
    private volatile boolean w;
    private boolean x;
    private boolean y;
    private boolean z;

    public c(ConnectionConfiguration connectionconfiguration)
    {
        super(connectionconfiguration);
        p = null;
        q = null;
        u = null;
        v = false;
        w = false;
        x = false;
        y = false;
        z = false;
        A = org.jivesoftware.smack.j.d();
        C = false;
    }

    private void P()
    {
        boolean flag1 = true;
        boolean flag = flag1;
        Iterator iterator;
        SmackException smackexception;
        if (s != null)
        {
            if (r == null)
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
        }
        l = null;
        C = false;
        Q();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_183;
        }
        r = new org.jivesoftware.smack.tcp.b(this);
        s = new a(this);
        if (k.i())
        {
            a(f.getReaderListener(), null);
            if (f.getWriterListener() != null)
            {
                b(f.getWriterListener(), null);
            }
        }
_L1:
        r.b();
        s.b();
        v = true;
        if (flag)
        {
            try
            {
                for (iterator = t().iterator(); iterator.hasNext(); ((org.jivesoftware.smack.c)iterator.next()).a(this)) { }
            }
            // Misplaced declaration of an exception variable
            catch (SmackException smackexception)
            {
                s();
                throw smackexception;
            }
        }
        break MISSING_BLOCK_LABEL_200;
        r.a();
        s.a();
          goto _L1
    }

    private void Q()
    {
        if (l != null) goto _L2; else goto _L1
_L1:
        g = new BufferedReader(new InputStreamReader(o.getInputStream(), "UTF-8"));
        h = new BufferedWriter(new OutputStreamWriter(o.getOutputStream(), "UTF-8"));
_L4:
        w();
        return;
_L2:
        h = new BufferedWriter(new OutputStreamWriter(l.a(o.getOutputStream()), "UTF-8"));
        g = new BufferedReader(new InputStreamReader(l.a(o.getInputStream()), "UTF-8"));
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        try
        {
            t.log(Level.WARNING, "initReaderAndWriter()", exception);
            l = null;
            g = new BufferedReader(new InputStreamReader(o.getInputStream(), "UTF-8"));
            h = new BufferedWriter(new OutputStreamWriter(o.getOutputStream(), "UTF-8"));
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            throw new IllegalStateException(unsupportedencodingexception);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private XMPPInputOutputStream R()
    {
label0:
        {
            if (B == null)
            {
                break label0;
            }
            Iterator iterator = org.jivesoftware.smack.j.e().iterator();
            XMPPInputOutputStream xmppinputoutputstream;
            String s1;
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                xmppinputoutputstream = (XMPPInputOutputStream)iterator.next();
                s1 = xmppinputoutputstream.d();
            } while (!B.contains(s1));
            return xmppinputoutputstream;
        }
        return null;
    }

    private boolean S()
    {
        if (m)
        {
            throw new IllegalStateException("Compression should be negotiated before authentication.");
        }
        XMPPInputOutputStream xmppinputoutputstream = R();
        l = xmppinputoutputstream;
        if (xmppinputoutputstream == null)
        {
            break MISSING_BLOCK_LABEL_73;
        }
        Object obj = D;
        obj;
        JVM INSTR monitorenter ;
        e(l.d());
        Exception exception;
        try
        {
            D.wait(y());
        }
        catch (InterruptedException interruptedexception) { }
        return M();
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        return false;
    }

    private void T()
    {
        for (Iterator iterator = u().iterator(); iterator.hasNext();)
        {
            d d1 = (d)iterator.next();
            try
            {
                d1.reconnectionSuccessful();
            }
            catch (Exception exception)
            {
                t.log(Level.WARNING, "notifyReconnection()", exception);
            }
        }

    }

    private void a(ConnectionConfiguration connectionconfiguration)
    {
        Object obj;
        Iterator iterator;
        LinkedList linkedlist;
        org.jivesoftware.smack.util.a.b b1;
        int i1;
        Object obj1;
        try
        {
            p();
        }
        // Misplaced declaration of an exception variable
        catch (ConnectionConfiguration connectionconfiguration)
        {
            throw new SmackException(connectionconfiguration);
        }
        iterator = connectionconfiguration.n().iterator();
        linkedlist = new LinkedList();
_L8:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        obj1 = null;
        b1 = (org.jivesoftware.smack.util.a.b)iterator.next();
        obj = b1.a();
        i1 = b1.b();
        if (connectionconfiguration.m() != null) goto _L4; else goto _L3
_L3:
        o = new Socket(((String) (obj)), i1);
_L5:
        obj = obj1;
        if (org.jivesoftware.smack.ConnectionConfiguration.SecurityMode.d != connectionconfiguration.b())
        {
            break MISSING_BLOCK_LABEL_106;
        }
        d(false);
        z = true;
        obj = obj1;
_L6:
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_163;
        }
        b1.a();
        b1.b();
_L2:
        w = false;
        P();
        return;
_L4:
        o = connectionconfiguration.m().createSocket(((String) (obj)), i1);
          goto _L5
        obj;
          goto _L6
        b1.a(((Exception) (obj)));
        linkedlist.add(b1);
        if (!iterator.hasNext())
        {
            throw new org.jivesoftware.smack.SmackException.ConnectionException(linkedlist);
        }
        if (true) goto _L8; else goto _L7
_L7:
    }

    private void d(boolean flag)
    {
        SSLContext sslcontext = k.f();
        if (k.l() != null) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L11:
        Exception exception;
        if (sslcontext == null)
        {
            Object obj1;
            Object obj2;
            KeyStore keystore;
            Object obj3;
            if (flag)
            {
                obj1 = "TLS";
            } else
            {
                obj1 = "SSL";
            }
            obj1 = SSLContext.getInstance(((String) (obj1)));
            ((SSLContext) (obj1)).init(((javax.net.ssl.KeyManager []) (obj)), null, new SecureRandom());
            obj = obj1;
        } else
        {
            obj = sslcontext;
        }
        obj1 = o;
        o = ((SSLContext) (obj)).getSocketFactory().createSocket(((Socket) (obj1)), ((Socket) (obj1)).getInetAddress().getHostAddress(), ((Socket) (obj1)).getPort(), true);
        return;
_L2:
        if (sslcontext != null)
        {
            break MISSING_BLOCK_LABEL_489;
        }
        if (k.d().equals("NONE"))
        {
            obj = null;
            obj1 = null;
        } else
        if (k.d().equals("PKCS11"))
        {
            try
            {
                obj = (Provider)Class.forName("sun.security.pkcs11.SunPKCS11").getConstructor(new Class[] {
                    java/io/InputStream
                }).newInstance(new Object[] {
                    new ByteArrayInputStream((new StringBuilder()).append("name = SmartCard\nlibrary = ").append(k.e()).toString().getBytes())
                });
                Security.addProvider(((Provider) (obj)));
                obj1 = KeyStore.getInstance("PKCS11", ((Provider) (obj)));
                obj = new PasswordCallback("PKCS11 Password: ", false);
                k.l().handle(new Callback[] {
                    obj
                });
                ((KeyStore) (obj1)).load(null, ((PasswordCallback) (obj)).getPassword());
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                obj = null;
                obj1 = null;
            }
        } else
        {
label0:
            {
                if (!k.d().equals("Apple"))
                {
                    break label0;
                }
                obj1 = KeyStore.getInstance("KeychainStore", "Apple");
                ((KeyStore) (obj1)).load(null, null);
                obj = null;
            }
        }
_L6:
        obj2 = KeyManagerFactory.getInstance("SunX509");
        if (obj != null) goto _L4; else goto _L3
_L3:
        ((KeyManagerFactory) (obj2)).init(((KeyStore) (obj1)), null);
_L8:
        obj = ((KeyManagerFactory) (obj2)).getKeyManagers();
        continue; /* Loop/switch isn't completed */
        keystore = KeyStore.getInstance(k.d());
        obj2 = new PasswordCallback("Keystore Password: ", false);
        k.l().handle(new Callback[] {
            obj2
        });
        obj = new FileInputStream(k.c());
        keystore.load(((InputStream) (obj)), ((PasswordCallback) (obj2)).getPassword());
        obj3 = obj;
_L7:
        obj = obj2;
        obj1 = keystore;
        if (obj3 == null) goto _L6; else goto _L5
_L5:
        ((FileInputStream) (obj3)).close();
        obj = obj2;
        obj1 = keystore;
          goto _L6
        obj;
        obj = obj2;
        obj1 = keystore;
          goto _L6
        obj;
        obj = null;
_L9:
        keystore = null;
        obj2 = null;
        obj3 = obj;
          goto _L7
_L4:
        try
        {
            ((KeyManagerFactory) (obj2)).init(((KeyStore) (obj1)), ((PasswordCallback) (obj)).getPassword());
            ((PasswordCallback) (obj)).clearPassword();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            obj = null;
            continue; /* Loop/switch isn't completed */
        }
          goto _L8
        exception;
          goto _L9
        obj = null;
        if (true) goto _L11; else goto _L10
_L10:
    }

    private void e(String s1)
    {
        h.write("<compress xmlns='http://jabber.org/protocol/compress'>");
        h.write((new StringBuilder()).append("<method>").append(s1).append("</method></compress>").toString());
        h.flush();
    }

    public org.jivesoftware.smack.c.b E()
    {
        return A;
    }

    public void F()
    {
        this;
        JVM INSTR monitorenter ;
        if (!f())
        {
            throw new org.jivesoftware.smack.SmackException.NotConnectedException();
        }
        break MISSING_BLOCK_LABEL_22;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        if (m)
        {
            throw new org.jivesoftware.smack.SmackException.AlreadyLoggedInException();
        }
        if (!i.a())
        {
            break MISSING_BLOCK_LABEL_149;
        }
        i.c();
        String s1 = a(((String) (null)));
        u = s1;
        b(org.jivesoftware.smack.util.p.b(s1));
        if (k.h())
        {
            S();
        }
        b(new Presence(org.jivesoftware.smack.packet.Presence.Type.a));
        m = true;
        x = true;
        if (k.i() && f != null)
        {
            f.userHasLogged(u);
        }
        A();
        this;
        JVM INSTR monitorexit ;
        return;
        throw new SaslException("No anonymous SASL authentication mechanism available");
    }

    public boolean G()
    {
        return J() || K();
    }

    public boolean H()
    {
        return w;
    }

    public boolean I()
    {
        return x;
    }

    public boolean J()
    {
        return y;
    }

    public boolean K()
    {
        return z;
    }

    void L()
    {
        d(true);
        Q();
        SSLSocket sslsocket = (SSLSocket)o;
        HostnameVerifier hostnameverifier;
        try
        {
            sslsocket.startHandshake();
        }
        catch (IOException ioexception)
        {
            a(ioexception);
            throw ioexception;
        }
        hostnameverifier = a().g();
        if (hostnameverifier != null && !hostnameverifier.verify(b(), sslsocket.getSession()))
        {
            throw new CertificateException((new StringBuilder()).append("Hostname verification of certificate failed. Certificate does not authenticate ").append(b()).toString());
        } else
        {
            y = true;
            r.a(h);
            r.d();
            return;
        }
    }

    public boolean M()
    {
        return l != null && C;
    }

    void N()
    {
        C = true;
        Q();
        r.a(h);
        r.d();
        O();
    }

    void O()
    {
        synchronized (D)
        {
            D.notify();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected ConnectionConfiguration a()
    {
        return super.a();
    }

    public void a(String s1, String s2, String s3)
    {
        this;
        JVM INSTR monitorenter ;
        if (!f())
        {
            throw new org.jivesoftware.smack.SmackException.NotConnectedException();
        }
        break MISSING_BLOCK_LABEL_22;
        s1;
        this;
        JVM INSTR monitorexit ;
        throw s1;
        if (m)
        {
            throw new org.jivesoftware.smack.SmackException.AlreadyLoggedInException();
        }
        s1 = s1.toLowerCase(Locale.US).trim();
        if (!i.b()) goto _L2; else goto _L1
_L1:
        if (s2 == null) goto _L4; else goto _L3
_L3:
        i.a(s1, s2, s3);
_L7:
        String s4;
        if (k.h())
        {
            S();
        }
        s4 = a(s3);
        if (s4 == null) goto _L6; else goto _L5
_L5:
        u = s4;
        b(org.jivesoftware.smack.util.p.b(s4));
_L9:
        m = true;
        x = false;
        if (k.r())
        {
            b(new Presence(org.jivesoftware.smack.packet.Presence.Type.a));
        }
        b(s1, s2, s3);
        if (k.i() && f != null)
        {
            f.userHasLogged(u);
        }
        A();
        this;
        JVM INSTR monitorexit ;
        return;
_L4:
        i.a(s3, k.l());
          goto _L7
_L2:
        throw new SaslException("No non-anonymous SASL authentication mechanism available");
_L6:
        u = (new StringBuilder()).append(s1).append("@").append(b()).toString();
        if (s3 == null) goto _L9; else goto _L8
_L8:
        u = (new StringBuilder()).append(u).append("/").append(s3).toString();
          goto _L9
    }

    void a(Collection collection)
    {
        B = collection;
    }

    protected void a(e e1)
    {
        r.a(e1);
    }

    void b(Exception exception)
    {
        this;
        JVM INSTR monitorenter ;
        if (s != null && !s.a) goto _L2; else goto _L1
_L1:
        if (r == null) goto _L4; else goto _L3
_L3:
        boolean flag = r.a;
        if (!flag) goto _L2; else goto _L4
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        s();
        a(exception);
        if (true) goto _L4; else goto _L5
_L5:
        exception;
        throw exception;
    }

    protected void b(String s1)
    {
        super.b(s1);
    }

    void b(boolean flag)
    {
        if (flag && k.b() == org.jivesoftware.smack.ConnectionConfiguration.SecurityMode.c)
        {
            b(((Exception) (new IllegalStateException("TLS required by server but not allowed by connection configuration"))));
        } else
        {
            if (flag && z)
            {
                b(((Exception) (new IllegalStateException("TLS required by server but legacy SSL already enabled"))));
                return;
            }
            if (k.b() != org.jivesoftware.smack.ConnectionConfiguration.SecurityMode.c && k.b() != org.jivesoftware.smack.ConnectionConfiguration.SecurityMode.d)
            {
                h.write("<starttls xmlns=\"urn:ietf:params:xml:ns:xmpp-tls\"/>");
                h.flush();
                return;
            }
        }
    }

    protected void c(String s1)
    {
        super.c(s1);
    }

    public void c(String s1, String s2, String s3)
    {
        this;
        JVM INSTR monitorenter ;
        if (!f())
        {
            throw new org.jivesoftware.smack.SmackException.NotConnectedException();
        }
        break MISSING_BLOCK_LABEL_22;
        s1;
        this;
        JVM INSTR monitorexit ;
        throw s1;
        if (m)
        {
            throw new org.jivesoftware.smack.SmackException.AlreadyLoggedInException();
        }
        b(new XMPPTCPConnection._cls1(this));
        u = s1;
        if (s3 == null)
        {
            break MISSING_BLOCK_LABEL_89;
        }
        u = (new StringBuilder()).append(u).append("/").append(s3).toString();
        m = true;
        x = false;
        if (k.r())
        {
            b(new Presence(org.jivesoftware.smack.packet.Presence.Type.a));
        }
        b(s1, s2, s3);
        if (k.i() && f != null)
        {
            f.userHasLogged(u);
        }
        A();
        this;
        JVM INSTR monitorexit ;
    }

    protected void c(e e1)
    {
        super.c(e1);
    }

    public void c(boolean flag)
    {
        m = flag;
    }

    public void d(String s1)
    {
        p = s1;
    }

    public String e()
    {
        if (!g())
        {
            return null;
        } else
        {
            return u;
        }
    }

    public boolean f()
    {
        return v;
    }

    public boolean g()
    {
        return m;
    }

    protected void i()
    {
        a(k);
        if (v)
        {
            z();
        }
        if (v && n)
        {
            if (I())
            {
                F();
            } else
            if (p == null)
            {
                a(k.o(), k.p(), k.q());
            } else
            {
                c(k.o(), k.p(), k.q());
            }
            T();
        }
    }

    protected void j()
    {
        super.j();
    }

    protected void k()
    {
        super.k();
    }

    protected void l()
    {
        super.l();
    }

    protected Reader m()
    {
        return super.m();
    }

    protected Writer n()
    {
        return super.n();
    }

    protected void o()
    {
        super.o();
    }

    protected i q()
    {
        return super.q();
    }

    protected void s()
    {
        if (s != null)
        {
            s.c();
        }
        if (r != null)
        {
            r.c();
        }
        w = true;
        try
        {
            o.close();
        }
        catch (Exception exception)
        {
            t.log(Level.WARNING, "shutdown", exception);
        }
        a(m);
        m = false;
        v = false;
        y = false;
        g = null;
        h = null;
    }

    protected void x()
    {
        super.x();
    }

}
