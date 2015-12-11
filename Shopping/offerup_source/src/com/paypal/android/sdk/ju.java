// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import android.support.design.widget.al;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.CookieHandler;
import java.net.ProtocolException;
import java.net.Proxy;
import java.security.cert.CertificateException;
import java.util.Date;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;

// Referenced classes of package com.paypal.android.sdk:
//            jv, ha, fy, gh, 
//            gg, jz, kf, gu, 
//            gq, gv, kx, gw, 
//            kb, kz, gn, fz, 
//            hl, ke, ki, kd, 
//            gr, gp, jj, ji, 
//            fl, gi, kc, dd, 
//            jx, lh, jw, gx

public final class ju
{

    private static final gw b = new jv();
    final gn a;
    private fy c;
    private fl d;
    private kf e;
    private gx f;
    private final gu g;
    private ki h;
    private long i;
    private boolean j;
    private boolean k;
    private final gq l;
    private gq m;
    private gu n;
    private gu o;
    private lh p;
    private final boolean q;
    private final boolean r;
    private al s;
    private ji t;

    public ju(gn gn1, gq gq1, boolean flag, boolean flag1, boolean flag2, fy fy1, kf kf1, 
            kd kd1, gu gu1)
    {
        i = -1L;
        a = gn1;
        l = gq1;
        k = flag;
        q = flag1;
        r = flag2;
        c = fy1;
        e = kf1;
        p = kd1;
        g = gu1;
        if (fy1 != null)
        {
            ha.b.b(fy1, this);
            f = fy1.b();
            return;
        } else
        {
            f = null;
            return;
        }
    }

    static fy a(ju ju1)
    {
        return ju1.c;
    }

    private static gg a(gg gg1, gg gg2)
    {
        boolean flag = false;
        gh gh1 = new gh();
        int k1 = gg1.a();
        for (int i1 = 0; i1 < k1; i1++)
        {
            String s1 = gg1.a(i1);
            String s2 = gg1.b(i1);
            if ((!"Warning".equalsIgnoreCase(s1) || !s2.startsWith("1")) && (!jz.a(s1) || gg2.a(s1) == null))
            {
                gh1.a(s1, s2);
            }
        }

        k1 = gg2.a();
        for (int j1 = ((flag) ? 1 : 0); j1 < k1; j1++)
        {
            gg1 = gg2.a(j1);
            if (!"Content-Length".equalsIgnoreCase(gg1) && jz.a(gg1))
            {
                gh1.a(gg1, gg2.b(j1));
            }
        }

        return gh1.a();
    }

    static gq a(ju ju1, gq gq1)
    {
        ju1.m = gq1;
        return gq1;
    }

    private void a(kf kf1, IOException ioexception)
    {
        if (ha.b.b(c) > 0)
        {
            return;
        } else
        {
            kf1.a(c.b(), ioexception);
            return;
        }
    }

    public static boolean a(gu gu1)
    {
        if (!gu1.a().d().equals("HEAD"))
        {
            int i1 = gu1.c();
            if ((i1 < 100 || i1 >= 200) && i1 != 204 && i1 != 304)
            {
                return true;
            }
            if (jz.a(gu1) != -1L || "chunked".equalsIgnoreCase(gu1.a("Transfer-Encoding")))
            {
                return true;
            }
        }
        return false;
    }

    private static gu b(gu gu1)
    {
        gu gu2 = gu1;
        if (gu1 != null)
        {
            gu2 = gu1;
            if (gu1.h() != null)
            {
                gu2 = gu1.i().a(null).a();
            }
        }
        return gu2;
    }

    static ki b(ju ju1)
    {
        return ju1.h;
    }

    private gu c(gu gu1)
    {
        while (!j || !"gzip".equalsIgnoreCase(o.a("Content-Encoding")) || gu1.h() == null) 
        {
            return gu1;
        }
        kx kx1 = new kx(gu1.h().c());
        gg gg1 = gu1.g().b().b("Content-Encoding").b("Content-Length").a();
        return gu1.i().a(gg1).a(new kb(gg1, kz.a(kx1))).a();
    }

    static gu c(ju ju1)
    {
        return ju1.m();
    }

    private fy l()
    {
        Object obj = a.m();
        do
        {
            fy fy1 = ((fz) (obj)).a(d);
            if (fy1 == null)
            {
                break;
            }
            if (m.d().equals("GET") || ha.b.c(fy1))
            {
                return fy1;
            }
            hl.a(fy1.c());
        } while (true);
        try
        {
            obj = new fy(((fz) (obj)), e.b());
        }
        catch (IOException ioexception)
        {
            throw new ke(ioexception);
        }
        return ((fy) (obj));
    }

    private gu m()
    {
        h.a();
        gu gu2 = h.b().a(m).a(c.i()).a(jz.a, Long.toString(i)).a(jz.b, Long.toString(System.currentTimeMillis())).a();
        gu gu1 = gu2;
        if (!r)
        {
            gu1 = gu2.i().a(h.a(gu2)).a();
        }
        ha.b.a(c, gu1.b());
        return gu1;
    }

    public final ju a(ke ke1)
    {
        boolean flag1;
        flag1 = false;
        if (e != null && c != null)
        {
            a(e, ke1.a());
        }
        if (e == null && c == null || e != null && !e.a()) goto _L2; else goto _L1
_L1:
        if (a.p()) goto _L4; else goto _L3
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
        ke1 = ke1.a();
        flag = flag1;
        if (ke1 instanceof ProtocolException)
        {
            continue; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (ke1 instanceof InterruptedIOException)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (ke1 instanceof SSLHandshakeException)
        {
            flag = flag1;
            if (ke1.getCause() instanceof CertificateException)
            {
                continue; /* Loop/switch isn't completed */
            }
        }
        flag = flag1;
        if (!(ke1 instanceof SSLPeerUnverifiedException))
        {
            flag = true;
        }
        if (true) goto _L6; else goto _L5
_L5:
        ke1 = i();
        return new ju(a, l, k, q, r, ke1, e, (kd)p, g);
    }

    public final ju a(IOException ioexception)
    {
        boolean flag1;
        flag1 = false;
        if (e != null && c != null)
        {
            a(e, ioexception);
        }
        if (e == null && c == null || e != null && !e.a()) goto _L2; else goto _L1
_L1:
        if (a.p()) goto _L4; else goto _L3
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
        flag = flag1;
        if (!(ioexception instanceof ProtocolException))
        {
            flag = flag1;
            if (!(ioexception instanceof InterruptedIOException))
            {
                flag = true;
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
        ioexception = i();
        return new ju(a, l, k, q, r, ioexception, e, null, g);
    }

    public final void a()
    {
        if (t == null)
        {
            if (h != null)
            {
                throw new IllegalStateException();
            }
            Object obj = l;
            gr gr1 = ((gq) (obj)).h();
            if (((gq) (obj)).a("Host") == null)
            {
                gr1.a("Host", hl.a(((gq) (obj)).a()));
            }
            if ((c == null || c.k() != gp.a) && ((gq) (obj)).a("Connection") == null)
            {
                gr1.a("Connection", "Keep-Alive");
            }
            if (((gq) (obj)).a("Accept-Encoding") == null)
            {
                j = true;
                gr1.a("Accept-Encoding", "gzip");
            }
            CookieHandler cookiehandler = a.f();
            if (cookiehandler != null)
            {
                java.util.Map map = jz.b(gr1.a().e());
                jz.a(gr1, cookiehandler.get(((gq) (obj)).b(), map));
            }
            if (((gq) (obj)).a("User-Agent") == null)
            {
                gr1.a("User-Agent", "okhttp/2.5.0");
            }
            gq gq1 = gr1.a();
            obj = ha.b.a(a);
            if (obj != null)
            {
                obj = ((al) (obj)).b();
            } else
            {
                obj = null;
            }
            t = (new jj(System.currentTimeMillis(), gq1, ((gu) (obj)))).a();
            m = t.a;
            n = t.b;
            if (obj != null && n == null)
            {
                hl.a(((gu) (obj)).h());
            }
            if (m != null)
            {
                if (c == null)
                {
                    if (c != null)
                    {
                        throw new IllegalStateException();
                    }
                    if (e == null)
                    {
                        gn gn1 = a;
                        gq gq2 = m;
                        Object obj1;
                        javax.net.ssl.HostnameVerifier hostnameverifier;
                        fu fu;
                        long l1;
                        if (gq2.j())
                        {
                            obj1 = gn1.i();
                            hostnameverifier = gn1.j();
                            fu = gn1.k();
                        } else
                        {
                            fu = null;
                            hostnameverifier = null;
                            obj1 = null;
                        }
                        d = new fl(gq2.a().g(), gq2.a().h(), gn1.h(), ((javax.net.ssl.SSLSocketFactory) (obj1)), hostnameverifier, fu, gn1.l(), gn1.d(), gn1.s(), gn1.t(), gn1.e());
                        try
                        {
                            e = kf.a(d, m, a);
                        }
                        // Misplaced declaration of an exception variable
                        catch (Object obj1)
                        {
                            throw new kc(((IOException) (obj1)));
                        }
                    }
                    c = l();
                    ha.b.a(a, c, this, m);
                    f = c.b();
                }
                h = ha.b.a(c, this);
                if (q && c() && p == null)
                {
                    l1 = jz.a(gq1);
                    if (k)
                    {
                        if (l1 > 0x7fffffffL)
                        {
                            throw new IllegalStateException("Use setFixedLengthStreamingMode() or setChunkedStreamingMode() for requests larger than 2 GiB.");
                        }
                        if (l1 != -1L)
                        {
                            h.a(m);
                            p = new kd((int)l1);
                            return;
                        } else
                        {
                            p = new kd();
                            return;
                        }
                    } else
                    {
                        h.a(m);
                        p = h.a(m, l1);
                        return;
                    }
                }
            } else
            {
                if (c != null)
                {
                    ha.b.a(a.m(), c);
                    c = null;
                }
                if (n != null)
                {
                    o = n.i().a(l).c(b(g)).b(b(n)).a();
                } else
                {
                    o = (new gv()).a(l).c(b(g)).a(gp.b).a(504).a("Unsatisfiable Request (only-if-cached)").a(b).a();
                }
                o = c(o);
                return;
            }
        }
    }

    public final void a(gg gg1)
    {
        CookieHandler cookiehandler = a.f();
        if (cookiehandler != null)
        {
            cookiehandler.put(l.b(), jz.b(gg1));
        }
    }

    public final boolean a(gi gi1)
    {
        gi gi2 = l.a();
        return gi2.g().equals(gi1.g()) && gi2.h() == gi1.h() && gi2.c().equals(gi1.c());
    }

    public final void b()
    {
        if (i != -1L)
        {
            throw new IllegalStateException();
        } else
        {
            i = System.currentTimeMillis();
            return;
        }
    }

    final boolean c()
    {
        return dd.d(l.d());
    }

    public final gq d()
    {
        return l;
    }

    public final gu e()
    {
        if (o == null)
        {
            throw new IllegalStateException();
        } else
        {
            return o;
        }
    }

    public final fy f()
    {
        return c;
    }

    public final void g()
    {
        if (h != null && c != null)
        {
            h.c();
        }
        c = null;
    }

    public final void h()
    {
        if (h != null)
        {
            h.a(this);
            return;
        }
        fy fy1 = c;
        if (fy1 != null)
        {
            try
            {
                ha.b.a(fy1, this);
                return;
            }
            catch (IOException ioexception) { }
        }
        return;
    }

    public final fy i()
    {
        if (p != null)
        {
            hl.a(p);
        }
        if (o == null)
        {
            if (c != null)
            {
                hl.a(c.c());
            }
            c = null;
            return null;
        }
        hl.a(o.h());
        if (h != null && c != null && !h.d())
        {
            hl.a(c.c());
            c = null;
            return null;
        }
        if (c != null && !ha.b.a(c))
        {
            c = null;
        }
        fy fy1 = c;
        c = null;
        return fy1;
    }

    public final void j()
    {
        boolean flag = true;
        if (o == null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (m == null && n == null)
        {
            throw new IllegalStateException("call sendRequest() first!");
        }
        if (m == null) goto _L1; else goto _L3
_L3:
        if (!r) goto _L5; else goto _L4
_L4:
        h.a(m);
_L9:
        Object obj = m();
_L8:
        Object obj1;
        a(((gu) (obj)).g());
        if (n == null)
        {
            break MISSING_BLOCK_LABEL_429;
        }
        obj1 = n;
        if (((gu) (obj)).c() != 304) goto _L7; else goto _L6
_L6:
        if (flag)
        {
            o = n.i().a(l).c(b(g)).a(a(n.g(), ((gu) (obj)).g())).b(b(n)).a(b(((gu) (obj)))).a();
            ((gu) (obj)).h().close();
            g();
            ha.b.a(a);
            b(o);
            o = c(o);
            return;
        }
        break MISSING_BLOCK_LABEL_419;
_L5:
label0:
        {
            if (q)
            {
                break label0;
            }
            obj = (new jx(this, 0, m)).a(m);
        }
          goto _L8
        if (i == -1L)
        {
            if (jz.a(m) == -1L && (p instanceof kd))
            {
                long l1 = ((kd)p).b();
                m = m.h().a("Content-Length", Long.toString(l1)).a();
            }
            h.a(m);
        }
        if (p != null)
        {
            p.close();
            if (p instanceof kd)
            {
                h.a((kd)p);
            }
        }
          goto _L9
_L7:
        obj1 = ((gu) (obj1)).g().b("Last-Modified");
        if (obj1 == null) goto _L11; else goto _L10
_L10:
        Object obj2 = ((gu) (obj)).g().b("Last-Modified");
        if (obj2 != null && ((Date) (obj2)).getTime() < ((Date) (obj1)).getTime()) goto _L6; else goto _L11
_L11:
        flag = false;
          goto _L6
        hl.a(n.h());
        o = ((gu) (obj)).i().a(l).c(b(g)).b(b(n)).a(b(((gu) (obj)))).a();
        if (!a(o)) goto _L1; else goto _L12
_L12:
        obj = ha.b.a(a);
        if (obj != null)
        {
            if (!ji.a(o, m))
            {
                obj = m.d();
                if (!((String) (obj)).equals("POST") && !((String) (obj)).equals("PATCH") && !((String) (obj)).equals("PUT"))
                {
                    ((String) (obj)).equals("DELETE");
                }
            } else
            {
                b(o);
                s = ((al) (obj)).c();
            }
        }
        obj2 = s;
        obj1 = o;
        if (obj2 != null) goto _L14; else goto _L13
_L13:
        obj = obj1;
_L16:
        o = c(((gu) (obj)));
        return;
_L14:
        lh lh1 = ((al) (obj2)).d();
        obj = obj1;
        if (lh1 != null)
        {
            obj = new jw(((gu) (obj1)).h().c(), ((al) (obj2)), kz.a(lh1));
            obj = ((gu) (obj1)).i().a(new kb(((gu) (obj1)).g(), kz.a(((lj) (obj))))).a();
        }
        if (true) goto _L16; else goto _L15
_L15:
    }

    public final gq k()
    {
        if (o == null)
        {
            throw new IllegalStateException();
        }
        Object obj;
        if (f != null)
        {
            obj = f.b;
        } else
        {
            obj = a.d();
        }
        switch (o.c())
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
            return jz.a(a.l(), o, ((Proxy) (obj)));

        case 307: 
        case 308: 
            if (!l.d().equals("GET") && !l.d().equals("HEAD"))
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
        if (!a.o())
        {
            return null;
        }
        obj = o.a("Location");
        if (obj == null)
        {
            return null;
        }
        obj = l.a().c(((String) (obj)));
        if (obj == null)
        {
            return null;
        }
        if (!((gi) (obj)).c().equals(l.a().c()) && !a.n())
        {
            return null;
        }
        gr gr1 = l.h();
        if (dd.d(l.d()))
        {
            gr1.a("GET", null);
            gr1.b("Transfer-Encoding");
            gr1.b("Content-Length");
            gr1.b("Content-Type");
        }
        if (!a(((gi) (obj))))
        {
            gr1.b("Authorization");
        }
        return gr1.a(((gi) (obj))).a();
    }

}
