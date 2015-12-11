// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.UnknownServiceException;
import java.security.Principal;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

// Referenced classes of package com.paypal.android.sdk:
//            gp, gx, fl, gj, 
//            gq, gi, gr, hl, 
//            jl, gv, jz, lj, 
//            gu, gz, gb, hg, 
//            ge, fu, kk, jk, 
//            jy, gn, ke, hr, 
//            hz, hq, jb, fz, 
//            hk, ju, ki

public final class fy
{

    private final fz a;
    private final gx b;
    private Socket c;
    private boolean d;
    private jl e;
    private hr f;
    private gp g;
    private long h;
    private ge i;
    private int j;
    private Object k;

    public fy(fz fz1, gx gx1)
    {
        d = false;
        g = gp.b;
        a = fz1;
        b = gx1;
    }

    private void a(int i1, int j1, gq gq1, gz gz1)
    {
        Object obj;
        Object obj1;
        int k1;
        obj1 = null;
        obj = null;
        k1 = 1;
        gx gx1 = b;
        if (gx1.a.d == null || gx1.b.type() != java.net.Proxy.Type.HTTP)
        {
            k1 = 0;
        }
        if (k1 == 0) goto _L2; else goto _L1
_L1:
        Object obj4;
        String s;
        Object obj2 = new gj();
        if ("https".equalsIgnoreCase("http"))
        {
            obj2.a = "http";
        } else
        if ("https".equalsIgnoreCase("https"))
        {
            obj2.a = "https";
        } else
        {
            throw new IllegalArgumentException((new StringBuilder("unexpected scheme: ")).append("https").toString());
        }
        obj2 = ((gj) (obj2)).a(gq1.a().g());
        k1 = gq1.a().h();
        if (k1 <= 0 || k1 > 65535)
        {
            throw new IllegalArgumentException((new StringBuilder("unexpected port: ")).append(k1).toString());
        }
        obj2.e = k1;
        obj2 = ((gj) (obj2)).b();
        obj2 = (new gr()).a(((gi) (obj2))).a("Host", hl.a(((gi) (obj2)))).a("Proxy-Connection", "Keep-Alive");
        obj4 = gq1.a("User-Agent");
        if (obj4 != null)
        {
            ((gr) (obj2)).a("User-Agent", ((String) (obj4)));
        }
        gq1 = gq1.a("Proxy-Authorization");
        if (gq1 != null)
        {
            ((gr) (obj2)).a("Proxy-Authorization", gq1);
        }
        gq1 = ((gr) (obj2)).a();
        obj4 = new jl(a, this, c);
        ((jl) (obj4)).a(i1, j1);
        obj2 = gq1.a();
        s = (new StringBuilder("CONNECT ")).append(((gi) (obj2)).g()).append(":").append(((gi) (obj2)).h()).append(" HTTP/1.1").toString();
_L7:
        ((jl) (obj4)).a(gq1.e(), s);
        ((jl) (obj4)).d();
        gq1 = ((jl) (obj4)).g().a(gq1).a();
        long l2 = jz.a(gq1);
        long l1 = l2;
        if (l2 == -1L)
        {
            l1 = 0L;
        }
        lj lj1 = ((jl) (obj4)).b(l1);
        hl.a(lj1, 0x7fffffff, TimeUnit.MILLISECONDS);
        lj1.close();
        gq1.c();
        JVM INSTR lookupswitch 2: default 456
    //                   200: 483
    //                   407: 503;
           goto _L3 _L4 _L5
_L3:
        throw new IOException((new StringBuilder("Unexpected response code for CONNECT: ")).append(gq1.c()).toString());
_L4:
        if (((jl) (obj4)).e() > 0L)
        {
            throw new IOException("TLS tunnel buffered too many bytes!");
        }
          goto _L2
_L5:
        Object obj3;
        obj3 = jz.a(b.a.g, gq1, b.b);
        gq1 = ((gq) (obj3));
        if (obj3 != null) goto _L7; else goto _L6
_L6:
        throw new IOException("Failed to authenticate with proxy");
_L2:
        obj3 = b.a;
        gq1 = ((fl) (obj3)).d;
        gq1 = (SSLSocket)gq1.createSocket(c, ((fl) (obj3)).a, ((fl) (obj3)).b, true);
        obj4 = gz1.a(gq1);
        if (((gb) (obj4)).e)
        {
            hg.a().a(gq1, ((fl) (obj3)).a, ((fl) (obj3)).h);
        }
        gq1.startHandshake();
        obj = ge.a(gq1.getSession());
        if (!((fl) (obj3)).e.verify(((fl) (obj3)).a, gq1.getSession()))
        {
            gz1 = (X509Certificate)((ge) (obj)).b().get(0);
            throw new SSLPeerUnverifiedException((new StringBuilder("Hostname ")).append(((fl) (obj3)).a).append(" not verified:\n    certificate: ").append(fu.a(gz1)).append("\n    DN: ").append(gz1.getSubjectDN().getName()).append("\n    subjectAltNames: ").append(kk.a(gz1)).toString());
        }
          goto _L8
        gz1;
_L16:
        if (hl.a(gz1))
        {
            throw new IOException(gz1);
        }
          goto _L9
        obj;
        gz1 = gq1;
        gq1 = ((gq) (obj));
_L14:
        if (gz1 != null)
        {
            hg.a().a(gz1);
        }
        hl.a(gz1);
        throw gq1;
_L8:
        ((fl) (obj3)).f.a(((fl) (obj3)).a, ((ge) (obj)).b());
        gz1 = obj1;
        if (((gb) (obj4)).e)
        {
            gz1 = hg.a().b(gq1);
        }
        if (gz1 == null) goto _L11; else goto _L10
_L10:
        gz1 = gp.a(gz1);
_L12:
        g = gz1;
        i = ((ge) (obj));
        c = gq1;
        if (gq1 != null)
        {
            hg.a().a(gq1);
        }
        return;
_L11:
        gz1 = gp.b;
          goto _L12
_L9:
        throw gz1;
        gq1;
        gz1 = ((gz) (obj));
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        gz1 = gq1;
        gq1 = exception;
        if (true) goto _L14; else goto _L13
_L13:
        gz1;
        gq1 = null;
        if (true) goto _L16; else goto _L15
_L15:
    }

    final ki a(ju ju)
    {
        if (f != null)
        {
            return new jk(ju, f);
        } else
        {
            return new jy(ju, e);
        }
    }

    final void a(gn gn1, Object obj, gq gq1)
    {
        a(obj);
        if (d) goto _L2; else goto _L1
_L1:
        gz gz1;
        Proxy proxy;
        fl fl1;
        int i1;
        int j1;
        int k1;
        boolean flag;
        List list = b.a.i;
        i1 = gn1.a();
        j1 = gn1.b();
        k1 = gn1.c();
        flag = gn1.p();
        if (d)
        {
            throw new IllegalStateException("already connected");
        }
        Object obj1 = null;
        gz1 = new gz(list);
        proxy = b.b;
        fl1 = b.a;
        obj = obj1;
        if (b.a.d == null)
        {
            obj = obj1;
            if (!list.contains(gb.c))
            {
                throw new ke(new UnknownServiceException((new StringBuilder("CLEARTEXT communication not supported: ")).append(list).toString()));
            }
        }
          goto _L3
_L9:
        Object obj2 = new Socket(proxy);
_L10:
        c = ((Socket) (obj2));
        c.setSoTimeout(j1);
        hg.a().a(c, b.c, i1);
        if (b.a.d != null)
        {
            a(j1, k1, gq1, gz1);
        }
        if (g != gp.c && g != gp.d) goto _L5; else goto _L4
_L4:
        int l1;
        c.setSoTimeout(0);
        f = new hr((new hz(b.a.a, c)).a(g), (byte)0);
        obj2 = f;
        ((hr) (obj2)).i.a();
        ((hr) (obj2)).i.b(((hr) (obj2)).e);
        l1 = ((hr) (obj2)).e.d();
        if (l1 == 0x10000)
        {
            break MISSING_BLOCK_LABEL_367;
        }
        ((hr) (obj2)).i.a(0, l1 - 0x10000);
_L11:
        d = true;
_L3:
        if (d) goto _L7; else goto _L6
_L6:
        if (proxy.type() != java.net.Proxy.Type.DIRECT && proxy.type() != java.net.Proxy.Type.HTTP) goto _L9; else goto _L8
_L8:
        obj2 = fl1.c.createSocket();
          goto _L10
_L5:
        e = new jl(a, this, c);
          goto _L11
        IOException ioexception;
        ioexception;
        hl.a(c);
        c = null;
        Object obj3;
        if (obj == null)
        {
            obj3 = new ke(ioexception);
        } else
        {
            ((ke) (obj)).a(ioexception);
            obj3 = obj;
        }
        if (!flag)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = obj3;
        if (gz1.a(ioexception)) goto _L3; else goto _L12
_L12:
        throw obj3;
_L7:
        if (j())
        {
            gn1.m().b(this);
        }
        gn1.q().b(b);
_L2:
        i1 = gn1.b();
        j1 = gn1.c();
        if (!d)
        {
            throw new IllegalStateException("setTimeouts - not connected");
        }
        if (e == null)
        {
            break MISSING_BLOCK_LABEL_582;
        }
        c.setSoTimeout(i1);
        e.a(i1, j1);
        return;
        gn1;
        throw new ke(gn1);
          goto _L10
    }

    final void a(gp gp1)
    {
        if (gp1 == null)
        {
            throw new IllegalArgumentException("protocol == null");
        } else
        {
            g = gp1;
            return;
        }
    }

    final void a(Object obj)
    {
        if (j())
        {
            return;
        }
        fz fz1 = a;
        fz1;
        JVM INSTR monitorenter ;
        if (k != null)
        {
            throw new IllegalStateException("Connection already has an owner!");
        }
        break MISSING_BLOCK_LABEL_38;
        obj;
        fz1;
        JVM INSTR monitorexit ;
        throw obj;
        k = obj;
        fz1;
        JVM INSTR monitorexit ;
    }

    final boolean a()
    {
label0:
        {
            synchronized (a)
            {
                if (k != null)
                {
                    break label0;
                }
            }
            return false;
        }
        k = null;
        fz1;
        JVM INSTR monitorexit ;
        return true;
        exception;
        fz1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final gx b()
    {
        return b;
    }

    final void b(Object obj)
    {
label0:
        {
            if (j())
            {
                throw new IllegalStateException();
            }
            synchronized (a)
            {
                if (k == obj)
                {
                    break label0;
                }
            }
            return;
        }
        k = null;
        fz1;
        JVM INSTR monitorexit ;
        if (c != null)
        {
            c.close();
            return;
        } else
        {
            return;
        }
        obj;
        fz1;
        JVM INSTR monitorexit ;
        throw obj;
    }

    public final Socket c()
    {
        return c;
    }

    final boolean d()
    {
        return !c.isClosed() && !c.isInputShutdown() && !c.isOutputShutdown();
    }

    final boolean e()
    {
        if (e != null)
        {
            return e.f();
        } else
        {
            return true;
        }
    }

    final void f()
    {
        if (f != null)
        {
            throw new IllegalStateException("framedConnection != null");
        } else
        {
            h = System.nanoTime();
            return;
        }
    }

    final boolean g()
    {
        return f == null || f.a();
    }

    final long h()
    {
        if (f == null)
        {
            return h;
        } else
        {
            return f.b();
        }
    }

    public final ge i()
    {
        return i;
    }

    final boolean j()
    {
        return f != null;
    }

    public final gp k()
    {
        return g;
    }

    final void l()
    {
        j = j + 1;
    }

    final int m()
    {
        return j;
    }

    public final String toString()
    {
        StringBuilder stringbuilder = (new StringBuilder("Connection{")).append(b.a.a).append(":").append(b.a.b).append(", proxy=").append(b.b).append(" hostAddress=").append(b.c.getAddress().getHostAddress()).append(" cipherSuite=");
        String s;
        if (i != null)
        {
            s = i.a();
        } else
        {
            s = "none";
        }
        return stringbuilder.append(s).append(" protocol=").append(g).append('}').toString();
    }
}
