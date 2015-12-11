// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.b;

import com.g.b.a.a.a;
import com.g.b.a.a.i;
import com.g.b.a.a.q;
import com.g.b.a.a.r;
import com.g.b.a.a.t;
import com.g.b.a.d;
import com.g.b.a.d.c;
import com.g.b.a.d.m;
import com.g.b.a.d.o;
import com.g.b.a.e;
import com.g.b.a.e.b;
import com.g.b.a.g;
import com.g.b.a.j;
import com.g.b.a.k;
import java.io.IOException;
import java.net.CookieHandler;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownServiceException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

// Referenced classes of package com.g.b:
//            u, k, m, c, 
//            e, f, j, b, 
//            v, i, z, a

public class s
    implements Cloneable
{

    private static final List w;
    private static final List x;
    private static SSLSocketFactory y;
    private g A;
    final j a;
    com.g.b.m b;
    public Proxy c;
    public List d;
    public List e;
    final List f;
    public final List g;
    public ProxySelector h;
    public CookieHandler i;
    e j;
    public SocketFactory k;
    public SSLSocketFactory l;
    public HostnameVerifier m;
    public f n;
    public com.g.b.b o;
    public com.g.b.j p;
    public boolean q;
    public boolean r;
    public boolean s;
    public int t;
    public int u;
    int v;
    private com.g.b.c z;

    public s()
    {
        f = new ArrayList();
        g = new ArrayList();
        q = true;
        r = true;
        s = true;
        a = new j();
        b = new com.g.b.m();
    }

    private s(s s1)
    {
        f = new ArrayList();
        g = new ArrayList();
        q = true;
        r = true;
        s = true;
        a = s1.a;
        b = s1.b;
        c = s1.c;
        d = s1.d;
        e = s1.e;
        f.addAll(s1.f);
        g.addAll(s1.g);
        h = s1.h;
        i = s1.i;
        z = s1.z;
        e e1;
        if (z != null)
        {
            e1 = z.a;
        } else
        {
            e1 = s1.j;
        }
        j = e1;
        k = s1.k;
        l = s1.l;
        m = s1.m;
        n = s1.n;
        o = s1.o;
        p = s1.p;
        A = s1.A;
        q = s1.q;
        r = s1.r;
        s = s1.s;
        t = s1.t;
        u = s1.u;
        v = s1.v;
    }

    static g a(s s1)
    {
        return s1.A;
    }

    private SSLSocketFactory c()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj = y;
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_30;
        }
        obj = SSLContext.getInstance("TLS");
        ((SSLContext) (obj)).init(null, null, null);
        y = ((SSLContext) (obj)).getSocketFactory();
        obj = y;
        this;
        JVM INSTR monitorexit ;
        return ((SSLSocketFactory) (obj));
        Object obj1;
        obj1;
        throw new AssertionError();
        obj1;
        this;
        JVM INSTR monitorexit ;
        throw obj1;
    }

    public final com.g.b.e a(v v1)
    {
        return new com.g.b.e(this, v1);
    }

    final s a()
    {
        s s1 = new s(this);
        if (s1.h == null)
        {
            s1.h = ProxySelector.getDefault();
        }
        if (s1.i == null)
        {
            s1.i = CookieHandler.getDefault();
        }
        if (s1.k == null)
        {
            s1.k = SocketFactory.getDefault();
        }
        if (s1.l == null)
        {
            s1.l = c();
        }
        if (s1.m == null)
        {
            s1.m = b.a;
        }
        if (s1.n == null)
        {
            s1.n = com.g.b.f.a;
        }
        if (s1.o == null)
        {
            s1.o = a.a;
        }
        if (s1.p == null)
        {
            s1.p = com.g.b.j.a();
        }
        if (s1.d == null)
        {
            s1.d = w;
        }
        if (s1.e == null)
        {
            s1.e = x;
        }
        if (s1.A == null)
        {
            s1.A = g.a;
        }
        return s1;
    }

    public final s a(com.g.b.c c1)
    {
        z = c1;
        j = null;
        return this;
    }

    public final void a(long l1, TimeUnit timeunit)
    {
        if (l1 < 0L)
        {
            throw new IllegalArgumentException("timeout < 0");
        }
        if (timeunit == null)
        {
            throw new IllegalArgumentException("unit == null");
        }
        long l2 = timeunit.toMillis(l1);
        if (l2 > 0x7fffffffL)
        {
            throw new IllegalArgumentException("Timeout too large.");
        }
        if (l2 == 0L && l1 > 0L)
        {
            throw new IllegalArgumentException("Timeout too small.");
        } else
        {
            t = (int)l2;
            return;
        }
    }

    public final void a(TimeUnit timeunit)
    {
        if (20000L < 0L)
        {
            throw new IllegalArgumentException("timeout < 0");
        }
        if (timeunit == null)
        {
            throw new IllegalArgumentException("unit == null");
        }
        long l1 = timeunit.toMillis(20000L);
        if (l1 > 0x7fffffffL)
        {
            throw new IllegalArgumentException("Timeout too large.");
        }
        if (l1 == 0L && 20000L > 0L)
        {
            throw new IllegalArgumentException("Timeout too small.");
        } else
        {
            v = (int)l1;
            return;
        }
    }

    public final s b()
    {
        return new s(this);
    }

    public final void b(long l1, TimeUnit timeunit)
    {
        if (l1 < 0L)
        {
            throw new IllegalArgumentException("timeout < 0");
        }
        if (timeunit == null)
        {
            throw new IllegalArgumentException("unit == null");
        }
        long l2 = timeunit.toMillis(l1);
        if (l2 > 0x7fffffffL)
        {
            throw new IllegalArgumentException("Timeout too large.");
        }
        if (l2 == 0L && l1 > 0L)
        {
            throw new IllegalArgumentException("Timeout too small.");
        } else
        {
            u = (int)l2;
            return;
        }
    }

    public Object clone()
    {
        return b();
    }

    static 
    {
        w = com.g.b.a.k.a(new u[] {
            com.g.b.u.d, com.g.b.u.c, com.g.b.u.b
        });
        x = com.g.b.a.k.a(new com.g.b.k[] {
            com.g.b.k.a, com.g.b.k.b, com.g.b.k.c
        });
        d.b = new d() {

            public final t a(com.g.b.i i1, com.g.b.a.a.g g1)
            {
                if (i1.f != null)
                {
                    return new r(g1, i1.f);
                } else
                {
                    return new i(g1, i1.e);
                }
            }

            public final e a(s s1)
            {
                return s1.j;
            }

            public final void a(com.g.b.i i1, u u1)
            {
                if (u1 == null)
                {
                    throw new IllegalArgumentException("protocol == null");
                } else
                {
                    i1.g = u1;
                    return;
                }
            }

            public final void a(com.g.b.i i1, Object obj)
            {
label0:
                {
                    if (i1.e())
                    {
                        throw new IllegalStateException();
                    }
                    synchronized (i1.a)
                    {
                        if (i1.k == obj)
                        {
                            break label0;
                        }
                    }
                    return;
                }
                i1.k = null;
                j1;
                JVM INSTR monitorexit ;
                i1.c.close();
                return;
                i1;
                j1;
                JVM INSTR monitorexit ;
                throw i1;
            }

            public final void a(com.g.b.j j1, com.g.b.i i1)
            {
label0:
                {
                    if (!i1.e() && i1.a())
                    {
                        if (i1.b())
                        {
                            break label0;
                        }
                        com.g.b.a.k.a(i1.c);
                    }
                    return;
                }
                try
                {
                    com.g.b.a.i.a().b(i1.c);
                }
                // Misplaced declaration of an exception variable
                catch (com.g.b.j j1)
                {
                    com.g.b.a.i.a();
                    com.g.b.a.i.a((new StringBuilder("Unable to untagSocket(): ")).append(j1).toString());
                    com.g.b.a.k.a(i1.c);
                    return;
                }
                j1;
                JVM INSTR monitorenter ;
                j1.a(i1);
                i1.j = i1.j + 1;
                if (i1.f != null)
                {
                    throw new IllegalStateException("spdyConnection != null");
                }
                break MISSING_BLOCK_LABEL_110;
                i1;
                j1;
                JVM INSTR monitorexit ;
                throw i1;
                i1.h = System.nanoTime();
                j1;
                JVM INSTR monitorexit ;
            }

            public final void a(com.g.b.k k1, SSLSocket sslsocket, boolean flag)
            {
                String as[] = null;
                if (k1.e != null)
                {
                    as = sslsocket.getEnabledCipherSuites();
                    as = (String[])com.g.b.a.k.a(java/lang/String, k1.e, as);
                }
                if (flag && Arrays.asList(sslsocket.getSupportedCipherSuites()).contains("TLS_FALLBACK_SCSV"))
                {
                    String as1[];
                    if (as == null)
                    {
                        as = sslsocket.getEnabledCipherSuites();
                    }
                    as1 = new String[as.length + 1];
                    System.arraycopy(as, 0, as1, 0, as.length);
                    as1[as1.length - 1] = "TLS_FALLBACK_SCSV";
                    as = as1;
                }
                as1 = sslsocket.getEnabledProtocols();
                as1 = (String[])com.g.b.a.k.a(java/lang/String, k1.f, as1);
                k1 = (new k.a(k1)).a(as).b(as1).b();
                sslsocket.setEnabledProtocols(k1.f);
                k1 = k1.e;
                if (k1 != null)
                {
                    sslsocket.setEnabledCipherSuites(k1);
                }
            }

            public final void a(o.a a1, String s1)
            {
                a1.a(s1);
            }

            public final void a(s s1, com.g.b.i i1, com.g.b.a.a.g g1, v v1)
            {
                i1.a(g1);
                if (i1.d)
                {
                    break MISSING_BLOCK_LABEL_445;
                }
                g1 = i1.b.a.;
                int j1 = s1.t;
                int l1 = s1.u;
                int j2 = s1.v;
                boolean flag = s1.s;
                if (i1.d)
                {
                    throw new IllegalStateException("already connected");
                }
                q q1 = new q(i1, i1.a);
                if (i1.b.a. != null)
                {
                    g1 = q1.a(j1, l1, j2, v1, i1.b, g1, flag);
                } else
                {
                    if (!g1.contains(com.g.b.k.c))
                    {
                        throw new com.g.b.a.a.o(new UnknownServiceException((new StringBuilder("CLEARTEXT communication not supported: ")).append(g1).toString()));
                    }
                    g1 = i1.b;
                    g1 = new com.g.b.a.a.q.a(g1, com.g.b.a.a.q.a(l1, j1, g1));
                }
                i1.c = ((com.g.b.a.a.q.a) (g1)).b;
                i1.i = ((com.g.b.a.a.q.a) (g1)).d;
                if (((com.g.b.a.a.q.a) (g1)).c == null)
                {
                    g1 = com.g.b.u.b;
                } else
                {
                    g1 = ((com.g.b.a.a.q.a) (g1)).c;
                }
                i1.g = g1;
                if (i1.g != com.g.b.u.c && i1.g != com.g.b.u.d) goto _L2; else goto _L1
_L1:
                i1.c.setSoTimeout(0);
                g1 = new com.g.b.a.d.o.a(i1.b.a.b, i1.c);
                g1.d = i1.g;
                i1.f = new o(g1, (byte)0);
                g1 = i1.f;
                ((o) (g1)).i.a();
                ((o) (g1)).i.b(((o) (g1)).e);
                j1 = ((o) (g1)).e.b();
                if (j1 != 0x10000)
                {
                    try
                    {
                        ((o) (g1)).i.a(0, j1 - 0x10000);
                    }
                    // Misplaced declaration of an exception variable
                    catch (s s1)
                    {
                        throw new com.g.b.a.a.o(s1);
                    }
                }
                i1.d = true;
                if (!i1.e()) goto _L4; else goto _L3
_L3:
                g1 = s1.p;
                if (!i1.e())
                {
                    throw new IllegalArgumentException();
                }
                  goto _L5
_L2:
                i1.e = new com.g.b.a.a.e(i1.a, i1, i1.c);
                break MISSING_BLOCK_LABEL_276;
_L5:
                if (!i1.b()) goto _L4; else goto _L6
_L6:
                g1;
                JVM INSTR monitorenter ;
                g1.a(i1);
                g1;
                JVM INSTR monitorexit ;
_L4:
                s1.a.b(i1.b);
                int k1;
                int i2;
                k1 = s1.u;
                i2 = s1.v;
                if (!i1.d)
                {
                    throw new IllegalStateException("setTimeouts - not connected");
                }
                break MISSING_BLOCK_LABEL_480;
                s1;
                g1;
                JVM INSTR monitorexit ;
                throw s1;
                if (i1.e != null)
                {
                    try
                    {
                        i1.c.setSoTimeout(k1);
                    }
                    // Misplaced declaration of an exception variable
                    catch (s s1)
                    {
                        throw new com.g.b.a.a.o(s1);
                    }
                    i1.e.a(k1, i2);
                }
                return;
            }

            public final boolean a(com.g.b.i i1)
            {
                return i1.a();
            }

            public final int b(com.g.b.i i1)
            {
                return i1.j;
            }

            public final j b(s s1)
            {
                return s1.a;
            }

            public final void b(com.g.b.i i1, com.g.b.a.a.g g1)
            {
                i1.a(g1);
            }

            public final g c(s s1)
            {
                return com.g.b.s.a(s1);
            }

            public final boolean c(com.g.b.i i1)
            {
                if (i1.e != null)
                {
                    return i1.e.b();
                } else
                {
                    return true;
                }
            }

        };
    }
}
