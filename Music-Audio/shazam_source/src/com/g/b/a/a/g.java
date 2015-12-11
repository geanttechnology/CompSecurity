// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.b.a.a;

import c.c;
import c.m;
import c.r;
import c.t;
import com.g.b.a;
import com.g.b.a.d;
import com.g.b.a.e;
import com.g.b.a.j;
import com.g.b.a.k;
import com.g.b.i;
import com.g.b.o;
import com.g.b.q;
import com.g.b.s;
import com.g.b.u;
import com.g.b.v;
import com.g.b.w;
import com.g.b.x;
import com.g.b.y;
import com.g.b.z;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.CookieHandler;
import java.net.InetSocketAddress;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketException;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.cert.CertificateException;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;

// Referenced classes of package com.g.b.a.a:
//            j, p, k, o, 
//            c, h, t, n, 
//            l, b

public final class g
{
    final class a
        implements com.g.b.q.a
    {

        final g a;
        private final int b;
        private final v c;
        private int d;

        public final x a(v v1)
        {
            d = d + 1;
            if (b > 0)
            {
                q q1 = (q)a.a.g.get(b - 1);
                com.g.b.a a2 = com.g.b.a.a.g.a(a).b.a;
                if (!v1.a().getHost().equals(a2.b) || com.g.b.a.k.a(v1.a()) != a2.c)
                {
                    throw new IllegalStateException((new StringBuilder("network interceptor ")).append(q1).append(" must retain the same host and port").toString());
                }
                if (d > 1)
                {
                    throw new IllegalStateException((new StringBuilder("network interceptor ")).append(q1).append(" must call proceed() exactly once").toString());
                }
            }
            if (b >= a.a.g.size()) goto _L2; else goto _L1
_L1:
            a a1 = a. new a(b + 1, v1);
            q q2 = (q)a.a.g.get(b);
            v1 = q2.a();
            if (a1.d != 1)
            {
                throw new IllegalStateException((new StringBuilder("network interceptor ")).append(q2).append(" must call proceed() exactly once").toString());
            }
_L4:
            return v1;
_L2:
            x x1;
            int i1;
            g.b(a).a(v1);
            com.g.b.a.a.g.a(a, v1);
            if (a.c() && v1.d != null)
            {
                c.d d1 = c.m.a(g.b(a).a(v1, v1.d.b()));
                v1.d.a(d1);
                d1.close();
            }
            x1 = com.g.b.a.a.g.c(a);
            i1 = x1.c;
            if (i1 == 204)
            {
                break; /* Loop/switch isn't completed */
            }
            v1 = x1;
            if (i1 != 205) goto _L4; else goto _L3
_L3:
            v1 = x1;
            if (x1.g.a() > 0L)
            {
                throw new ProtocolException((new StringBuilder("HTTP ")).append(i1).append(" had non-zero Content-Length: ").append(x1.g.a()).toString());
            }
            if (true) goto _L4; else goto _L5
_L5:
        }

        a(int i1, v v1)
        {
            a = g.this;
            super();
            b = i1;
            c = v1;
        }
    }


    private static final y j = new y() {

        public final long a()
        {
            return 0L;
        }

        public final c.e b()
        {
            return new c();
        }

    };
    final s a;
    public i b;
    public z c;
    public com.g.b.a.a.t d;
    long e;
    public final boolean f;
    final v g;
    public r h;
    public c.d i;
    private com.g.b.a k;
    private p l;
    private final x m;
    private boolean n;
    private v o;
    private x p;
    private x q;
    private final boolean r;
    private final boolean s;
    private b t;
    private com.g.b.a.a.c u;

    public g(s s1, v v1, boolean flag, boolean flag1, boolean flag2, i i1, p p1, 
            n n1, x x1)
    {
        e = -1L;
        a = s1;
        g = v1;
        f = flag;
        r = flag1;
        s = flag2;
        b = i1;
        l = p1;
        h = n1;
        m = x1;
        if (i1 != null)
        {
            d.b.b(i1, this);
            c = i1.b;
            return;
        } else
        {
            c = null;
            return;
        }
    }

    static i a(g g1)
    {
        return g1.b;
    }

    private static o a(o o1, o o2)
    {
        boolean flag = false;
        com.g.b.o.a a1 = new com.g.b.o.a();
        int k1 = o1.a.length / 2;
        for (int i1 = 0; i1 < k1; i1++)
        {
            String s1 = o1.a(i1);
            String s2 = o1.b(i1);
            if ((!"Warning".equalsIgnoreCase(s1) || !s2.startsWith("1")) && (!com.g.b.a.a.j.a(s1) || o2.a(s1) == null))
            {
                a1.a(s1, s2);
            }
        }

        k1 = o2.a.length / 2;
        for (int j1 = ((flag) ? 1 : 0); j1 < k1; j1++)
        {
            o1 = o2.a(j1);
            if (!"Content-Length".equalsIgnoreCase(o1) && com.g.b.a.a.j.a(o1))
            {
                a1.a(o1, o2.b(j1));
            }
        }

        return a1.a();
    }

    static v a(g g1, v v1)
    {
        g1.o = v1;
        return v1;
    }

    public static String a(URL url)
    {
        if (com.g.b.a.k.a(url) != com.g.b.a.k.a(url.getProtocol()))
        {
            return (new StringBuilder()).append(url.getHost()).append(":").append(url.getPort()).toString();
        } else
        {
            return url.getHost();
        }
    }

    private void a(p p1, IOException ioexception)
    {
        if (d.b.b(b) > 0)
        {
            return;
        }
        z z1 = b.b;
        if (z1.b.type() != java.net.Proxy.Type.DIRECT && p1.a.k != null)
        {
            p1.a.k.connectFailed(p1.b, z1.b.address(), ioexception);
        }
        p1.c.a(z1);
    }

    public static boolean a(x x1)
    {
        if (!x1.a.b.equals("HEAD"))
        {
            int i1 = x1.c;
            if ((i1 < 100 || i1 >= 200) && i1 != 204 && i1 != 304)
            {
                return true;
            }
            if (com.g.b.a.a.j.a(x1) != -1L || "chunked".equalsIgnoreCase(x1.a("Transfer-Encoding")))
            {
                return true;
            }
        }
        return false;
    }

    static com.g.b.a.a.t b(g g1)
    {
        return g1.d;
    }

    private static x b(x x1)
    {
        x x2 = x1;
        if (x1 != null)
        {
            x2 = x1;
            if (x1.g != null)
            {
                x1 = x1.d();
                x1.g = null;
                x2 = x1.a();
            }
        }
        return x2;
    }

    static x c(g g1)
    {
        return g1.m();
    }

    private x c(x x1)
    {
        while (!n || !"gzip".equalsIgnoreCase(q.a("Content-Encoding")) || x1.g == null) 
        {
            return x1;
        }
        c.k k1 = new c.k(x1.g.b());
        o o1 = x1.f.a().b("Content-Encoding").b("Content-Length").a();
        x1 = x1.d().a(o1);
        x1.g = new com.g.b.a.a.k(o1, c.m.a(k1));
        return x1.a();
    }

    private i k()
    {
        com.g.b.j j1;
        j1 = a.p;
        do
        {
            i i1 = j1.a(k);
            if (i1 == null)
            {
                break;
            }
            if (o.b.equals("GET") || d.b.c(i1))
            {
                return i1;
            }
            com.g.b.a.k.a(i1.c);
        } while (true);
        p p1 = l;
_L8:
        if (p1.c()) goto _L2; else goto _L1
_L1:
        if (p1.b()) goto _L4; else goto _L3
_L3:
        if (!p1.d())
        {
            throw new NoSuchElementException();
        }
          goto _L5
        IOException ioexception;
        ioexception;
        throw new com.g.b.a.a.o(ioexception);
_L5:
        Object obj = (z)p1.j.remove(0);
_L7:
        return new i(j1, ((z) (obj)));
_L4:
        if (!p1.b())
        {
            throw new SocketException((new StringBuilder("No route to ")).append(p1.a.b).append("; exhausted proxy configurations: ").append(p1.f).toString());
        }
        obj = p1.f;
        int k1 = p1.g;
        p1.g = k1 + 1;
        obj = (Proxy)((List) (obj)).get(k1);
        p1.a(((Proxy) (obj)));
        p1.d = ((Proxy) (obj));
_L2:
        if (!p1.c())
        {
            throw new SocketException((new StringBuilder("No route to ")).append(p1.a.b).append("; exhausted inet socket addresses: ").append(p1.h).toString());
        }
        obj = p1.h;
        int l1 = p1.i;
        p1.i = l1 + 1;
        p1.e = (InetSocketAddress)((List) (obj)).get(l1);
        obj = new z(p1.a, p1.d, p1.e);
        if (!p1.c.c(((z) (obj)))) goto _L7; else goto _L6
_L6:
        p1.j.add(obj);
          goto _L8
    }

    private void l()
    {
        Object obj = d.b.a(a);
        if (obj != null)
        {
            if (!com.g.b.a.a.c.a(q, o))
            {
                if (com.g.b.a.a.h.a(o.b))
                {
                    try
                    {
                        ((e) (obj)).b(o);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        return;
                    }
                }
            } else
            {
                t = ((e) (obj)).a(b(q));
                return;
            }
        }
    }

    private x m()
    {
        d.a();
        Object obj = d.b();
        obj.a = o;
        obj.e = b.i;
        x x1 = ((com.g.b.x.a) (obj)).a(j.b, Long.toString(e)).a(com.g.b.a.a.j.c, Long.toString(System.currentTimeMillis())).a();
        obj = x1;
        if (!s)
        {
            obj = x1.d();
            obj.g = d.a(x1);
            obj = ((com.g.b.x.a) (obj)).a();
        }
        d.b.a(b, ((x) (obj)).b);
        return ((x) (obj));
    }

    public final g a(com.g.b.a.a.o o1)
    {
        boolean flag1;
        flag1 = false;
        if (l != null && b != null)
        {
            a(l, o1.b);
        }
        if (l == null && b == null || l != null && !l.a()) goto _L2; else goto _L1
_L1:
        if (a.s) goto _L4; else goto _L3
_L3:
        boolean flag = flag1;
_L6:
        if (flag)
        {
            break; /* Loop/switch isn't completed */
        }
_L2:
        return null;
_L4:
        o1 = o1.b;
        flag = flag1;
        if (o1 instanceof ProtocolException)
        {
            continue; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (o1 instanceof InterruptedIOException)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (o1 instanceof SSLHandshakeException)
        {
            flag = flag1;
            if (o1.getCause() instanceof CertificateException)
            {
                continue; /* Loop/switch isn't completed */
            }
        }
        flag = flag1;
        if (!(o1 instanceof SSLPeerUnverifiedException))
        {
            flag = true;
        }
        if (true) goto _L6; else goto _L5
_L5:
        o1 = h();
        return new g(a, g, f, r, s, o1, l, (n)h, m);
    }

    public final g a(IOException ioexception, r r1)
    {
        boolean flag1;
        boolean flag2;
        flag2 = false;
        if (l != null && b != null)
        {
            a(l, ioexception);
        }
        boolean flag;
        if (r1 == null || (r1 instanceof n))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (l == null && b == null || l != null && !l.a()) goto _L2; else goto _L1
_L1:
        if (a.s) goto _L4; else goto _L3
_L3:
        flag1 = flag2;
_L6:
        if (flag1 && flag)
        {
            break; /* Loop/switch isn't completed */
        }
_L2:
        return null;
_L4:
        flag1 = flag2;
        if (!(ioexception instanceof ProtocolException))
        {
            flag1 = flag2;
            if (!(ioexception instanceof InterruptedIOException))
            {
                flag1 = true;
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
        ioexception = h();
        return new g(a, g, f, r, s, ioexception, l, (n)r1, m);
    }

    public final void a()
    {
        if (u == null)
        {
            if (d != null)
            {
                throw new IllegalStateException();
            }
            Object obj = g;
            Object obj2 = ((v) (obj)).c();
            if (((v) (obj)).a("Host") == null)
            {
                ((com.g.b.v.a) (obj2)).a("Host", a(((v) (obj)).a()));
            }
            if ((b == null || b.g != u.a) && ((v) (obj)).a("Connection") == null)
            {
                ((com.g.b.v.a) (obj2)).a("Connection", "Keep-Alive");
            }
            if (((v) (obj)).a("Accept-Encoding") == null)
            {
                n = true;
                ((com.g.b.v.a) (obj2)).a("Accept-Encoding", "gzip");
            }
            CookieHandler cookiehandler = a.i;
            if (cookiehandler != null)
            {
                java.util.Map map = com.g.b.a.a.j.a(((com.g.b.v.a) (obj2)).a().c, null);
                com.g.b.a.a.j.a(((com.g.b.v.a) (obj2)), cookiehandler.get(((v) (obj)).b(), map));
            }
            if (((v) (obj)).a("User-Agent") == null)
            {
                ((com.g.b.v.a) (obj2)).a("User-Agent", "okhttp/2.4.0");
            }
            v v1 = ((com.g.b.v.a) (obj2)).a();
            obj2 = d.b.a(a);
            if (obj2 != null)
            {
                obj = ((e) (obj2)).a(v1);
            } else
            {
                obj = null;
            }
            u = (new c.a(System.currentTimeMillis(), v1, ((x) (obj)))).a();
            o = u.a;
            p = u.b;
            if (obj2 != null)
            {
                ((e) (obj2)).a(u);
            }
            if (obj != null && p == null)
            {
                com.g.b.a.k.a(((x) (obj)).g);
            }
            if (o != null)
            {
                if (b == null)
                {
                    if (b != null)
                    {
                        throw new IllegalStateException();
                    }
                    if (l == null)
                    {
                        s s1 = a;
                        v v2 = o;
                        String s2 = v2.a().getHost();
                        if (s2 == null || s2.length() == 0)
                        {
                            throw new l(new UnknownHostException(v2.a().toString()));
                        }
                        Object obj1;
                        Object obj3;
                        Object obj4;
                        long l1;
                        if (v2.e())
                        {
                            obj1 = s1.l;
                            obj3 = s1.m;
                            obj4 = s1.n;
                        } else
                        {
                            obj4 = null;
                            obj3 = null;
                            obj1 = null;
                        }
                        k = new com.g.b.a(s2, com.g.b.a.k.a(v2.a()), s1.k, ((javax.net.ssl.SSLSocketFactory) (obj1)), ((javax.net.ssl.HostnameVerifier) (obj3)), ((com.g.b.f) (obj4)), s1.o, s1.c, s1.d, s1.e, s1.h);
                        try
                        {
                            obj1 = k;
                            obj3 = o;
                            obj4 = a;
                            l = new p(((com.g.b.a) (obj1)), ((v) (obj3)).b(), ((s) (obj4)));
                        }
                        // Misplaced declaration of an exception variable
                        catch (Object obj1)
                        {
                            throw new l(((IOException) (obj1)));
                        }
                    }
                    obj1 = k();
                    d.b.a(a, ((i) (obj1)), this, o);
                    b = ((i) (obj1));
                    c = b.b;
                }
                d = d.b.a(b, this);
                if (r && c() && h == null)
                {
                    l1 = com.g.b.a.a.j.a(v1);
                    if (f)
                    {
                        if (l1 > 0x7fffffffL)
                        {
                            throw new IllegalStateException("Use setFixedLengthStreamingMode() or setChunkedStreamingMode() for requests larger than 2 GiB.");
                        }
                        if (l1 != -1L)
                        {
                            d.a(o);
                            h = new n((int)l1);
                            return;
                        } else
                        {
                            h = new n();
                            return;
                        }
                    } else
                    {
                        d.a(o);
                        h = d.a(o, l1);
                        return;
                    }
                }
            } else
            {
                if (b != null)
                {
                    d.b.a(a.p, b);
                    b = null;
                }
                if (p != null)
                {
                    obj1 = p.d();
                    obj1.a = g;
                    q = ((com.g.b.x.a) (obj1)).c(b(m)).b(b(p)).a();
                } else
                {
                    obj1 = new com.g.b.x.a();
                    obj1.a = g;
                    obj1 = ((com.g.b.x.a) (obj1)).c(b(m));
                    obj1.b = u.b;
                    obj1.c = 504;
                    obj1.d = "Unsatisfiable Request (only-if-cached)";
                    obj1.g = j;
                    q = ((com.g.b.x.a) (obj1)).a();
                }
                q = c(q);
                return;
            }
        }
    }

    public final void a(o o1)
    {
        CookieHandler cookiehandler = a.i;
        if (cookiehandler != null)
        {
            cookiehandler.put(g.b(), com.g.b.a.a.j.a(o1, null));
        }
    }

    public final void b()
    {
        if (e != -1L)
        {
            throw new IllegalStateException();
        } else
        {
            e = System.currentTimeMillis();
            return;
        }
    }

    public final boolean b(URL url)
    {
        URL url1 = g.a();
        return url1.getHost().equals(url.getHost()) && com.g.b.a.k.a(url1) == com.g.b.a.k.a(url) && url1.getProtocol().equals(url.getProtocol());
    }

    final boolean c()
    {
        return com.g.b.a.a.h.c(g.b);
    }

    public final r d()
    {
        if (u == null)
        {
            throw new IllegalStateException();
        } else
        {
            return h;
        }
    }

    public final boolean e()
    {
        return q != null;
    }

    public final x f()
    {
        if (q == null)
        {
            throw new IllegalStateException();
        } else
        {
            return q;
        }
    }

    public final void g()
    {
        if (d != null && b != null)
        {
            d.c();
        }
        b = null;
    }

    public final i h()
    {
        if (i == null) goto _L2; else goto _L1
_L1:
        com.g.b.a.k.a(i);
_L4:
        if (q == null)
        {
            if (b != null)
            {
                com.g.b.a.k.a(b.c);
            }
            b = null;
            return null;
        }
        break; /* Loop/switch isn't completed */
_L2:
        if (h != null)
        {
            com.g.b.a.k.a(h);
        }
        if (true) goto _L4; else goto _L3
_L3:
        com.g.b.a.k.a(q.g);
        if (d != null && b != null && !d.d())
        {
            com.g.b.a.k.a(b.c);
            b = null;
            return null;
        }
        if (b != null && !d.b.a(b))
        {
            b = null;
        }
        i i1 = b;
        b = null;
        return i1;
    }

    public final void i()
    {
        boolean flag = true;
        if (q == null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (o == null && p == null)
        {
            throw new IllegalStateException("call sendRequest() first!");
        }
        if (o == null) goto _L1; else goto _L3
_L3:
        if (!s) goto _L5; else goto _L4
_L4:
        d.a(o);
_L9:
        Object obj = m();
_L8:
        Object obj1;
        a(((x) (obj)).f);
        if (p == null)
        {
            break MISSING_BLOCK_LABEL_503;
        }
        obj1 = p;
        if (((x) (obj)).c != 304) goto _L7; else goto _L6
_L6:
        if (flag)
        {
            obj1 = p.d();
            obj1.a = g;
            q = ((com.g.b.x.a) (obj1)).c(b(m)).a(a(p.f, ((x) (obj)).f)).b(b(p)).a(b(((x) (obj)))).a();
            ((x) (obj)).g.close();
            g();
            obj = d.b.a(a);
            ((e) (obj)).a();
            ((e) (obj)).a(p, b(q));
            q = c(q);
            return;
        }
        break MISSING_BLOCK_LABEL_493;
_L5:
label0:
        {
            if (r)
            {
                break label0;
            }
            obj = (new a(0, o)).a(o);
        }
          goto _L8
        if (i != null && i.b().b > 0L)
        {
            i.d();
        }
        if (e == -1L)
        {
            if (com.g.b.a.a.j.a(o) == -1L && (h instanceof n))
            {
                long l1 = ((n)h).a.b;
                o = o.c().a("Content-Length", Long.toString(l1)).a();
            }
            d.a(o);
        }
        if (h != null)
        {
            if (i != null)
            {
                i.close();
            } else
            {
                h.close();
            }
            if (h instanceof n)
            {
                d.a((n)h);
            }
        }
          goto _L9
_L7:
        obj1 = ((x) (obj1)).f.b("Last-Modified");
        if (obj1 == null) goto _L11; else goto _L10
_L10:
        Object obj2 = ((x) (obj)).f.b("Last-Modified");
        if (obj2 != null && ((Date) (obj2)).getTime() < ((Date) (obj1)).getTime()) goto _L6; else goto _L11
_L11:
        flag = false;
          goto _L6
        com.g.b.a.k.a(p.g);
        obj1 = ((x) (obj)).d();
        obj1.a = g;
        q = ((com.g.b.x.a) (obj1)).c(b(m)).b(b(p)).a(b(((x) (obj)))).a();
        if (!a(q)) goto _L1; else goto _L12
_L12:
        l();
        obj2 = t;
        obj1 = q;
        if (obj2 != null) goto _L14; else goto _L13
_L13:
        obj = obj1;
_L16:
        q = c(((x) (obj)));
        return;
_L14:
        r r1 = ((b) (obj2)).b();
        obj = obj1;
        if (r1 != null)
        {
            obj = new c.s(((x) (obj1)).g.b(), ((b) (obj2)), c.m.a(r1)) {

                boolean a;
                final c.e b;
                final b c;
                final c.d d;
                final g e;

                public final long a(c c1, long l2)
                {
                    try
                    {
                        l2 = b.a(c1, l2);
                    }
                    // Misplaced declaration of an exception variable
                    catch (c c1)
                    {
                        if (!a)
                        {
                            a = true;
                            c.a();
                        }
                        throw c1;
                    }
                    if (l2 == -1L)
                    {
                        if (!a)
                        {
                            a = true;
                            d.close();
                        }
                        return -1L;
                    } else
                    {
                        c1.a(d.b(), c1.b - l2, l2);
                        d.s();
                        return l2;
                    }
                }

                public final void close()
                {
                    if (!a && !com.g.b.a.k.a(this, TimeUnit.MILLISECONDS))
                    {
                        a = true;
                        c.a();
                    }
                    b.close();
                }

                public final t w_()
                {
                    return b.w_();
                }

            
            {
                e = g.this;
                b = e1;
                c = b1;
                d = d1;
                super();
            }
            };
            obj2 = ((x) (obj1)).d();
            obj2.g = new com.g.b.a.a.k(((x) (obj1)).f, c.m.a(((c.s) (obj))));
            obj = ((com.g.b.x.a) (obj2)).a();
        }
        if (true) goto _L16; else goto _L15
_L15:
    }

    public final v j()
    {
        if (q == null)
        {
            throw new IllegalStateException();
        }
        Object obj;
        if (c != null)
        {
            obj = c.b;
        } else
        {
            obj = a.c;
        }
        switch (q.c)
        {
        default:
            return null;

        case 407: 
            if (((Proxy) (obj)).type() != java.net.Proxy.Type.HTTP)
            {
                throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
            }
            // fall through

        case 401: 
            return com.g.b.a.a.j.a(a.o, q, ((Proxy) (obj)));

        case 307: 
        case 308: 
            if (!g.b.equals("GET") && !g.b.equals("HEAD"))
            {
                return null;
            }
            break;

        case 300: 
        case 301: 
        case 302: 
        case 303: 
            break;
        }
        if (!a.r)
        {
            return null;
        }
        obj = q.a("Location");
        if (obj == null)
        {
            return null;
        }
        obj = new URL(g.a(), ((String) (obj)));
        if (!((URL) (obj)).getProtocol().equals("https") && !((URL) (obj)).getProtocol().equals("http"))
        {
            return null;
        }
        if (!((URL) (obj)).getProtocol().equals(g.a().getProtocol()) && !a.q)
        {
            return null;
        }
        com.g.b.v.a a1 = g.c();
        if (com.g.b.a.a.h.c(g.b))
        {
            a1.a("GET", null);
            a1.b("Transfer-Encoding");
            a1.b("Content-Length");
            a1.b("Content-Type");
        }
        if (!b(((URL) (obj))))
        {
            a1.b("Authorization");
        }
        return a1.a(((URL) (obj))).a();
    }

}
