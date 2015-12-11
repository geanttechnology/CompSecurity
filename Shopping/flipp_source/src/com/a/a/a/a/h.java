// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a.a;

import com.a.a.a;
import com.a.a.a.b.d;
import com.a.a.a.b.q;
import com.a.a.a.j;
import com.a.a.a.m;
import com.a.a.a.u;
import com.a.a.b;
import com.a.a.c;
import com.a.a.r;
import com.a.a.t;
import com.a.a.v;
import com.a.a.w;
import com.a.a.x;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.CacheRequest;
import java.net.CacheResponse;
import java.net.CookieHandler;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

// Referenced classes of package com.a.a.a.a:
//            i, u, x, v, 
//            z, ac, ad, ae, 
//            j, ab

public class h
{

    private static final CacheResponse k = new i();
    protected final com.a.a.a.a.u a;
    protected final r b;
    protected final String c;
    protected b d;
    protected ac e;
    CacheResponse f;
    long g;
    public final URI h;
    public final com.a.a.a.a.x i;
    z j;
    private com.a.a.u l;
    private OutputStream m;
    private ae n;
    private InputStream o;
    private InputStream p;
    private CacheRequest q;
    private boolean r;
    private z s;
    private InputStream t;
    private boolean u;
    private boolean v;

    public h(r r1, com.a.a.a.a.u u1, String s1, com.a.a.a.a.v v1, b b1, ab ab1)
    {
        g = -1L;
        b = r1;
        a = u1;
        c = s1;
        d = b1;
        m = ab1;
        try
        {
            com.a.a.a.m.a();
            h = com.a.a.a.m.a(u1.getURL());
        }
        // Misplaced declaration of an exception variable
        catch (r r1)
        {
            throw new IOException(r1.getMessage());
        }
        i = new com.a.a.a.a.x(h, new com.a.a.a.a.v(v1));
    }

    public static String a(URL url)
    {
        String s1 = url.getFile();
        if (s1 == null)
        {
            url = "/";
        } else
        {
            url = s1;
            if (!s1.startsWith("/"))
            {
                return (new StringBuilder("/")).append(s1).toString();
            }
        }
        return url;
    }

    private void a(z z1, InputStream inputstream)
    {
        if (p != null)
        {
            throw new IllegalStateException();
        }
        j = z1;
        if (inputstream != null)
        {
            a(inputstream);
        }
    }

    private void a(InputStream inputstream)
    {
        o = inputstream;
        if (r && "gzip".equalsIgnoreCase(j.r))
        {
            z z1 = j;
            z1.r = null;
            z1.f.d("Content-Encoding");
            z1 = j;
            z1.s = -1;
            z1.f.d("Content-Length");
            p = new GZIPInputStream(inputstream);
            return;
        } else
        {
            p = inputstream;
            return;
        }
    }

    public static String b(URL url)
    {
        int i1 = url.getPort();
        String s2 = url.getHost();
        String s1 = s2;
        if (i1 > 0)
        {
            s1 = s2;
            if (i1 != com.a.a.a.u.a(url.getProtocol()))
            {
                s1 = (new StringBuilder()).append(s2).append(":").append(i1).toString();
            }
        }
        return s1;
    }

    public static String m()
    {
        String s1 = System.getProperty("http.agent");
        if (s1 != null)
        {
            return s1;
        } else
        {
            return (new StringBuilder("Java")).append(System.getProperty("java.version")).toString();
        }
    }

    private String p()
    {
        String s1;
        Object obj;
        StringBuilder stringbuilder;
        if (d == null || d.j != 0)
        {
            s1 = "HTTP/1.1";
        } else
        {
            s1 = "HTTP/1.0";
        }
        stringbuilder = (new StringBuilder()).append(c).append(" ");
        obj = a.getURL();
        if (l())
        {
            obj = ((URL) (obj)).toString();
        } else
        {
            obj = a(((URL) (obj)));
        }
        return stringbuilder.append(((String) (obj))).append(" ").append(s1).toString();
    }

    public final void a()
    {
        if (l == null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        i.a.a(p());
        if (i.j == null)
        {
            com.a.a.a.a.x x1 = i;
            String s1 = m();
            if (x1.j != null)
            {
                x1.a.d("User-Agent");
            }
            x1.a.a("User-Agent", s1);
            x1.j = s1;
        }
        if (i.k == null)
        {
            com.a.a.a.a.x x2 = i;
            String s2 = b(a.getURL());
            if (x2.k != null)
            {
                x2.a.d("Host");
            }
            x2.a.a("Host", s2);
            x2.k = s2;
        }
        if ((d == null || d.j != 0) && i.l == null)
        {
            com.a.a.a.a.x x3 = i;
            if (x3.l != null)
            {
                x3.a.d("Connection");
            }
            x3.a.a("Connection", "Keep-Alive");
            x3.l = "Keep-Alive";
        }
        if (i.m == null)
        {
            r = true;
            com.a.a.a.a.x x4 = i;
            if (x4.m != null)
            {
                x4.a.d("Accept-Encoding");
            }
            x4.a.a("Accept-Encoding", "gzip");
            x4.m = "gzip";
        }
        if (c() && i.n == null)
        {
            com.a.a.a.a.x x5 = i;
            if (x5.n != null)
            {
                x5.a.d("Content-Type");
            }
            x5.a.a("Content-Type", "application/x-www-form-urlencoded");
            x5.n = "application/x-www-form-urlencoded";
        }
        long l2 = a.getIfModifiedSince();
        if (l2 != 0L)
        {
            i.a(new Date(l2));
        }
        CookieHandler cookiehandler = b.e;
        if (cookiehandler != null)
        {
            i.a(cookiehandler.get(h, i.a.a(false)));
        }
        l = com.a.a.u.c;
        if (!a.getUseCaches()) goto _L4; else goto _L3
_L3:
        Object obj = b.a();
        if (obj == null) goto _L4; else goto _L5
_L5:
        Object obj2 = ((t) (obj)).a(h, c, i.a.a(false));
        if (obj2 == null) goto _L4; else goto _L6
_L6:
        obj = ((CacheResponse) (obj2)).getHeaders();
        t = ((CacheResponse) (obj2)).getBody();
        if (a(((CacheResponse) (obj2))) && obj != null && t != null) goto _L8; else goto _L7
_L7:
        com.a.a.a.u.a(t);
          goto _L4
_L8:
        obj = com.a.a.a.a.v.a(((java.util.Map) (obj)));
        s = new z(h, ((com.a.a.a.a.v) (obj)));
        long l6 = System.currentTimeMillis();
        obj3 = s;
        obj = i;
        if (!((z) (obj3)).a(((com.a.a.a.a.x) (obj))))
        {
            break MISSING_BLOCK_LABEL_1279;
        }
        if (((com.a.a.a.a.x) (obj)).b || ((com.a.a.a.a.x) (obj)).a())
        {
            obj = com.a.a.u.c;
        } else
        {
            long l3;
            long l4;
            long l7;
            long l8;
            if (((z) (obj3)).g != null)
            {
                l3 = Math.max(0L, ((z) (obj3)).k - ((z) (obj3)).g.getTime());
            } else
            {
                l3 = 0L;
            }
            l4 = l3;
            if (((z) (obj3)).p != -1)
            {
                l4 = Math.max(l3, TimeUnit.SECONDS.toMillis(((z) (obj3)).p));
            }
            l8 = l4 + (((z) (obj3)).k - ((z) (obj3)).j) + (l6 - ((z) (obj3)).k);
            if (((z) (obj3)).m != -1)
            {
                l3 = TimeUnit.SECONDS.toMillis(((z) (obj3)).m);
            } else
            if (((z) (obj3)).i != null)
            {
                long l5;
                if (((z) (obj3)).g != null)
                {
                    l3 = ((z) (obj3)).g.getTime();
                } else
                {
                    l3 = ((z) (obj3)).k;
                }
                l5 = ((z) (obj3)).i.getTime() - l3;
                l3 = l5;
                if (l5 <= 0L)
                {
                    l3 = 0L;
                }
            } else
            if (((z) (obj3)).h != null && ((z) (obj3)).e.getRawQuery() == null)
            {
                if (((z) (obj3)).g != null)
                {
                    l3 = ((z) (obj3)).g.getTime();
                } else
                {
                    l3 = ((z) (obj3)).j;
                }
                l3 -= ((z) (obj3)).h.getTime();
                if (l3 > 0L)
                {
                    l3 /= 10L;
                } else
                {
                    l3 = 0L;
                }
            } else
            {
                l3 = 0L;
            }
            l4 = l3;
            if (((com.a.a.a.a.x) (obj)).c != -1)
            {
                l4 = Math.min(l3, TimeUnit.SECONDS.toMillis(((com.a.a.a.a.x) (obj)).c));
            }
            l3 = 0L;
            if (((com.a.a.a.a.x) (obj)).e != -1)
            {
                l3 = TimeUnit.SECONDS.toMillis(((com.a.a.a.a.x) (obj)).e);
            }
            l7 = 0L;
            l6 = l7;
            if (!((z) (obj3)).n)
            {
                l6 = l7;
                if (((com.a.a.a.a.x) (obj)).d != -1)
                {
                    l6 = TimeUnit.SECONDS.toMillis(((com.a.a.a.a.x) (obj)).d);
                }
            }
            if (!((z) (obj3)).l && l8 + l3 < l6 + l4)
            {
                if (l3 + l8 >= l4)
                {
                    ((z) (obj3)).f.a("Warning", "110 HttpURLConnection \"Response is stale\"");
                }
                if (l8 > 0x5265c00L)
                {
                    boolean flag;
                    if (((z) (obj3)).m == -1 && ((z) (obj3)).i == null)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    if (flag)
                    {
                        ((z) (obj3)).f.a("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                    }
                }
                obj = com.a.a.u.a;
            } else
            {
                if (((z) (obj3)).h != null)
                {
                    ((com.a.a.a.a.x) (obj)).a(((z) (obj3)).h);
                } else
                if (((z) (obj3)).g != null)
                {
                    ((com.a.a.a.a.x) (obj)).a(((z) (obj3)).g);
                }
                if (((z) (obj3)).o != null)
                {
                    obj3 = ((z) (obj3)).o;
                    if (((com.a.a.a.a.x) (obj)).o != null)
                    {
                        ((com.a.a.a.a.x) (obj)).a.d("If-None-Match");
                    }
                    ((com.a.a.a.a.x) (obj)).a.a("If-None-Match", ((String) (obj3)));
                    obj.o = ((String) (obj3));
                }
                if (!((com.a.a.a.a.x) (obj)).a())
                {
                    break MISSING_BLOCK_LABEL_1279;
                }
                obj = com.a.a.u.b;
            }
        }
_L10:
        l = ((com.a.a.u) (obj));
        if (l == com.a.a.u.a)
        {
            f = ((CacheResponse) (obj2));
            a(s, t);
        } else
        if (l == com.a.a.u.b)
        {
            f = ((CacheResponse) (obj2));
        } else
        if (l == com.a.a.u.c)
        {
            com.a.a.a.u.a(t);
        } else
        {
            throw new AssertionError();
        }
        if (true) goto _L4; else goto _L9
        obj = com.a.a.u.c;
          goto _L10
_L4:
        obj = b.a();
        if (obj != null)
        {
            ((t) (obj)).a(l);
        }
        if (i.f && l.a())
        {
            if (l == com.a.a.u.b)
            {
                com.a.a.a.u.a(t);
            }
            l = com.a.a.u.a;
            f = k;
            obj = com.a.a.a.a.v.a(f.getHeaders());
            a(new z(h, ((com.a.a.a.a.v) (obj))), f.getBody());
        }
        if (!l.a())
        {
            continue; /* Loop/switch isn't completed */
        }
        if (d != null || d != null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (e == null)
        {
            Object obj3 = h.getHost();
            if (obj3 == null)
            {
                throw new UnknownHostException(h.toString());
            }
            obj = null;
            obj2 = null;
            if (h.getScheme().equalsIgnoreCase("https"))
            {
                obj = b.g;
                obj2 = b.h;
            }
            e = new ac(new a(((String) (obj3)), com.a.a.a.u.a(h), ((SSLSocketFactory) (obj)), ((HostnameVerifier) (obj2)), b.i, b.b, b.c), h, b.d, b.j, j.a, b.a);
        }
        d = e.a(c);
        if (d.h) goto _L12; else goto _L11
_L11:
        Object obj4;
        boolean flag1;
        obj2 = d;
        int i1 = b.l;
        int k1 = b.m;
        obj4 = o();
        if (((b) (obj2)).h)
        {
            throw new IllegalStateException("already connected");
        }
        obj2.h = true;
        if (((b) (obj2)).d.b.type() != java.net.Proxy.Type.HTTP)
        {
            obj = new Socket(((b) (obj2)).d.b);
        } else
        {
            obj = new Socket();
        }
        obj2.e = ((Socket) (obj));
        com.a.a.a.m.a().a(((b) (obj2)).e, ((b) (obj2)).d.c, i1);
        ((b) (obj2)).e.setSoTimeout(k1);
        obj2.f = ((b) (obj2)).e.getInputStream();
        obj2.g = ((b) (obj2)).e.getOutputStream();
        if (((b) (obj2)).d.a.d == null) goto _L14; else goto _L13
_L13:
        obj = com.a.a.a.m.a();
        if (((b) (obj2)).d.a.d != null && ((b) (obj2)).d.b.type() == java.net.Proxy.Type.HTTP)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag1)
        {
            ((b) (obj2)).a(((x) (obj4)));
        }
        obj2.e = ((b) (obj2)).d.a.d.createSocket(((b) (obj2)).e, ((b) (obj2)).d.a.b, ((b) (obj2)).d.a.c, true);
        obj4 = (SSLSocket)((b) (obj2)).e;
        if (((b) (obj2)).d.d)
        {
            ((m) (obj)).a(((SSLSocket) (obj4)), ((b) (obj2)).d.a.b);
        } else
        {
            com.a.a.a.m.a(((SSLSocket) (obj4)));
        }
        if (((b) (obj2)).d.d && ((b) (obj2)).d.a.g.contains("spdy/3"))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag1)
        {
            ((m) (obj)).a(((SSLSocket) (obj4)), b.a);
        }
        ((SSLSocket) (obj4)).startHandshake();
        if (!((b) (obj2)).d.a.e.verify(((b) (obj2)).d.a.b, ((SSLSocket) (obj4)).getSession()))
        {
            throw new IOException((new StringBuilder("Hostname '")).append(((b) (obj2)).d.a.b).append("' was not verified").toString());
        }
        obj2.g = ((SSLSocket) (obj4)).getOutputStream();
        obj2.f = ((SSLSocket) (obj4)).getInputStream();
        if (!flag1) goto _L14; else goto _L15
_L15:
        byte abyte0[] = ((m) (obj)).b(((SSLSocket) (obj4)));
        if (abyte0 == null) goto _L14; else goto _L16
_L16:
        if (!Arrays.equals(abyte0, b.b)) goto _L18; else goto _L17
_L17:
        ((SSLSocket) (obj4)).setSoTimeout(0);
        obj2.i = new q(new com.a.a.a.b.u(((b) (obj2)).d.a.b, ((b) (obj2)).f, ((b) (obj2)).g), (byte)0);
        ((b) (obj2)).i.d.a();
_L14:
        int l1 = com.a.a.a.m.a().a(((b) (obj2)).e);
        int j1 = l1;
        if (l1 < 1024)
        {
            j1 = 1024;
        }
        l1 = j1;
        if (j1 > 8192)
        {
            l1 = 8192;
        }
        obj2.f = new BufferedInputStream(((b) (obj2)).f, l1);
        obj2.g = new BufferedOutputStream(((b) (obj2)).g, l1);
        abyte0 = b.j;
        obj2 = d;
        ((c) (abyte0)).b.submit(((c) (abyte0)).c);
        if (!((b) (obj2)).e() || !((b) (obj2)).a()) goto _L20; else goto _L19
_L19:
        abyte0;
        JVM INSTR monitorenter ;
        ((c) (abyte0)).a.addFirst(obj2);
        abyte0;
        JVM INSTR monitorexit ;
_L20:
        b.a.a(d.d);
_L12:
        a(d);
        if (d.d.b != b.b)
        {
            i.a.a(p());
        }
_L9:
        if (n != null)
        {
            throw new IllegalStateException();
        }
        break MISSING_BLOCK_LABEL_2246;
_L18:
        if (Arrays.equals(abyte0, b.c)) goto _L14; else goto _L21
_L21:
        throw new IOException((new StringBuilder("Unexpected NPN transport ")).append(new String(abyte0, "ISO-8859-1")).toString());
        Exception exception;
        exception;
        abyte0;
        JVM INSTR monitorexit ;
        throw exception;
        Object obj1 = d;
        if (((b) (obj1)).i != null)
        {
            obj1 = new ad(this, ((b) (obj1)).i);
        } else
        {
            obj1 = new com.a.a.a.a.j(this, ((b) (obj1)).g, ((b) (obj1)).f);
        }
        n = (ae)obj1;
        if (!c() || m != null) goto _L1; else goto _L22
_L22:
        m = n.a();
        return;
        if (d == null) goto _L1; else goto _L23
_L23:
        b.j.a(d);
        d = null;
        return;
    }

    public final void a(com.a.a.a.a.v v1)
    {
        CookieHandler cookiehandler = b.e;
        if (cookiehandler != null)
        {
            cookiehandler.put(h, v1.a(true));
        }
    }

    protected void a(b b1)
    {
    }

    public final void a(boolean flag)
    {
        if (p == t)
        {
            com.a.a.a.u.a(p);
        }
        if (!v && d != null)
        {
            v = true;
            if (n == null || !n.a(flag, m, o))
            {
                com.a.a.a.u.a(d);
                d = null;
            } else
            if (u)
            {
                b.j.a(d);
                d = null;
                return;
            }
        }
    }

    protected boolean a(CacheResponse cacheresponse)
    {
        return true;
    }

    public final void b()
    {
        if (g != -1L)
        {
            throw new IllegalStateException();
        } else
        {
            g = System.currentTimeMillis();
            return;
        }
    }

    final boolean c()
    {
        return c.equals("POST") || c.equals("PUT");
    }

    public final OutputStream d()
    {
        if (l == null)
        {
            throw new IllegalStateException();
        } else
        {
            return m;
        }
    }

    public final boolean e()
    {
        return j != null;
    }

    public final z f()
    {
        if (j == null)
        {
            throw new IllegalStateException();
        } else
        {
            return j;
        }
    }

    public final int g()
    {
        if (j == null)
        {
            throw new IllegalStateException();
        } else
        {
            return j.f.d;
        }
    }

    public final InputStream h()
    {
        if (j == null)
        {
            throw new IllegalStateException();
        } else
        {
            return p;
        }
    }

    public final b i()
    {
        return d;
    }

    public final void j()
    {
        u = true;
        if (d != null && v)
        {
            b.j.a(d);
            d = null;
        }
    }

    public final boolean k()
    {
        int i1 = j.f.d;
        if (!c.equals("HEAD"))
        {
            if ((i1 < 100 || i1 >= 200) && i1 != 204 && i1 != 304)
            {
                return true;
            }
            if (j.s != -1 || j.a())
            {
                return true;
            }
        }
        return false;
    }

    protected boolean l()
    {
        if (d == null)
        {
            return a.usingProxy();
        }
        return d.d.b.type() == java.net.Proxy.Type.HTTP;
    }

    public final void n()
    {
        if (e())
        {
            j.a(l);
        } else
        {
            if (l == null)
            {
                throw new IllegalStateException("readResponse() without sendRequest()");
            }
            if (l.a())
            {
                if (g == -1L)
                {
                    if (m instanceof ab)
                    {
                        int i1 = ((ab)m).b();
                        i.a(i1);
                    }
                    n.c();
                }
                if (m != null)
                {
                    m.close();
                    if (m instanceof ab)
                    {
                        n.a((ab)m);
                    }
                }
                n.b();
                j = n.d();
                z z1 = j;
                long l1 = g;
                long l2 = System.currentTimeMillis();
                z1.j = l1;
                z1.f.a(com.a.a.a.a.z.a, Long.toString(l1));
                z1.k = l2;
                z1.f.a(com.a.a.a.a.z.b, Long.toString(l2));
                j.a(l);
                if (l == com.a.a.u.b)
                {
                    Object obj = s;
                    z z2 = j;
                    boolean flag;
                    if (z2.f.d == 304)
                    {
                        flag = true;
                    } else
                    if (((z) (obj)).h != null && z2.h != null && z2.h.getTime() < ((z) (obj)).h.getTime())
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    if (flag)
                    {
                        a(false);
                        a(s.a(j), t);
                        obj = b.a();
                        ((t) (obj)).a();
                        ((t) (obj)).a(f, a.a());
                        return;
                    }
                    com.a.a.a.u.a(t);
                }
                if (k() && a.getUseCaches())
                {
                    t t1 = b.a();
                    if (t1 != null)
                    {
                        HttpURLConnection httpurlconnection = a.a();
                        if (!j.a(i))
                        {
                            t1.a(httpurlconnection.getRequestMethod(), h);
                        } else
                        {
                            q = t1.a(h, httpurlconnection);
                        }
                    }
                }
                a(n.a(q));
                return;
            }
        }
    }

    protected x o()
    {
        return null;
    }

}
