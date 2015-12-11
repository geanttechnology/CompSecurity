// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.liverail.library.c;

import com.a.a.a.k;
import com.liverail.library.a.b;
import com.liverail.library.a.c;
import com.liverail.library.g.d;
import com.liverail.library.g.f;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.DeflaterOutputStream;
import org.apache.http.HttpEntity;
import org.apache.http.client.CookieStore;
import org.apache.http.entity.ByteArrayEntity;

// Referenced classes of package com.liverail.library.c:
//            k, e, g, f, 
//            c, d, b

public final class a
{

    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    private final String e = "http://";
    private final String f = "ad4.liverail.com";
    private final com.liverail.library.a.d g;
    private e h;
    private long i;
    private long j;
    private long k;
    private long l;
    private boolean m;
    private com.a.a.a.a n;
    private String o;
    private com.liverail.library.c.k p;
    private d q;
    private int r;
    private int s;
    private ArrayList t;
    private int u;

    public a(com.liverail.library.a.d d1)
    {
        o = "http://ad4.liverail.com";
        u = 0;
        g = d1;
        q = new d();
        p = new com.liverail.library.c.k();
    }

    static long a(a a1)
    {
        return a1.j;
    }

    private void a(b b1)
    {
        com.liverail.library.b.a.e((new StringBuilder("AdProvider failed in ")).append((new Date()).getTime() - i).append("ms").toString());
        u = 3;
        i();
        j();
        if (h != null)
        {
            h.a(b1);
        }
    }

    static void a(a a1, long l1)
    {
        a1.j = l1;
    }

    static void a(a a1, com.a.a.a.a a2)
    {
        a1.n = a2;
    }

    static void a(a a1, b b1)
    {
        a1.a(b1);
    }

    static void a(a a1, String s1)
    {
        a1.a(s1);
    }

    private void a(String s1)
    {
        if (p.a(s1, q))
        {
            if (m && q.e == 2)
            {
                com.liverail.library.b.a.e("Fatal: second XML response content='sources'");
                a(new b(c.p));
                return;
            }
            if (q.e == 2)
            {
                e();
                return;
            }
            if (q.e == 3)
            {
                h();
                return;
            }
            if (q.e == 1)
            {
                com.liverail.library.b.a.e((new StringBuilder("LiveRail XML error message. ")).append(q.h).toString());
                c c1 = c.o;
                if (q.h != null)
                {
                    s1 = q.h;
                }
                a(new b(c1, s1));
                return;
            } else
            {
                com.liverail.library.b.a.e("LiveRail unknown XML response.");
                com.liverail.library.b.a.a(s1);
                a(new b(c.n, s1));
                return;
            }
        } else
        {
            com.liverail.library.b.a.e("Failed to parse LiveRail XML");
            a(new b(c.m, s1));
            return;
        }
    }

    static void b(a a1)
    {
        a1.f();
    }

    static void b(a a1, long l1)
    {
        a1.l = l1;
    }

    static long c(a a1)
    {
        return a1.l;
    }

    private void e()
    {
        boolean flag = false;
        if (q.i == null || q.i.size() <= 0) goto _L2; else goto _L1
_L1:
        ArrayList arraylist;
        int i1;
        int j1;
        r = 0;
        s = 0;
        j1 = q.i.size();
        t = new ArrayList(j1);
        arraylist = new ArrayList();
        i1 = 0;
_L9:
        if (i1 < j1) goto _L4; else goto _L3
_L3:
        com.liverail.library.b.a.c((new StringBuilder("Received ")).append(j1).append(" ad-sources, ").append(r).append(" have URL defined. ").toString());
        if (r <= 0) goto _L6; else goto _L5
_L5:
        com.liverail.library.b.a.b((new StringBuilder("Begin ")).append(r).append(" parallel calls.").toString());
        k = (new Date()).getTime();
        j1 = arraylist.size();
        i1 = ((flag) ? 1 : 0);
_L7:
        Object obj;
        if (i1 >= j1)
        {
            return;
        }
        obj = (g)arraylist.get(i1);
        ((g) (obj)).a(new com.liverail.library.c.c(this));
        ((g) (obj)).a(((g) (obj)).b().e);
        i1++;
        continue; /* Loop/switch isn't completed */
_L4:
        obj = (f)q.i.get(i1);
        if (((f) (obj)).a())
        {
            r = r + 1;
            obj = new g(i1, ((f) (obj)), g, g.e);
            arraylist.add(obj);
            t.add(obj);
        } else
        {
            obj = new com.liverail.library.c.f(i1, ((f) (obj)));
            t.add(obj);
        }
        i1++;
        continue; /* Loop/switch isn't completed */
        if (true) goto _L7; else goto _L6
_L6:
        g();
        return;
_L2:
        com.liverail.library.b.a.e("LiveRail did not return any ad sources.");
        a(new b(c.q));
        return;
        if (true) goto _L9; else goto _L8
_L8:
    }

    private void f()
    {
        s = s + 1;
        if (s >= r)
        {
            com.liverail.library.b.a.c((new StringBuilder("Parallel calls completed in ")).append((new Date()).getTime() - k).append("ms.").toString());
            g();
        }
    }

    private void g()
    {
        Object obj1;
        Object obj2;
        int i1;
        int j1;
        m = true;
        n = new com.a.a.a.a();
        obj2 = new k(g.d);
        ((k) (obj2)).a("LR_POSTXML", "true");
        obj1 = new StringBuilder();
        j1 = t.size();
        i1 = 0;
_L9:
        if (i1 < j1) goto _L2; else goto _L1
_L1:
        byte abyte0[];
        com.liverail.library.b.a.a((new StringBuilder("Ad source connection results")).append(obj1).toString());
        j();
        obj1 = ((k) (obj2)).c();
        i1 = ((String) (obj1)).length();
        abyte0 = (byte[])null;
        ByteArrayOutputStream bytearrayoutputstream;
        bytearrayoutputstream = new ByteArrayOutputStream(i1);
        DeflaterOutputStream deflateroutputstream = new DeflaterOutputStream(bytearrayoutputstream);
        deflateroutputstream.write(((String) (obj1)).getBytes());
        deflateroutputstream.close();
        obj1 = bytearrayoutputstream.toByteArray();
        abyte0 = ((byte []) (obj1));
        bytearrayoutputstream.close();
_L14:
        Object obj;
        f f1;
        Object obj3;
        Object obj4;
        java.util.Map.Entry entry;
        int k1;
        int l1;
        if (abyte0 != null && abyte0.length > 0)
        {
            obj2 = (new StringBuilder(String.valueOf(o))).append("/?compressed").toString();
            obj1 = new ByteArrayEntity(abyte0);
            com.liverail.library.b.a.b((new StringBuilder("Compressed POST data to len=")).append(((HttpEntity) (obj1)).getContentLength()).append(" from original ").append(i1).append(", url=").append(((String) (obj2))).toString());
            obj = obj2;
        } else
        {
            obj = o;
            obj1 = ((k) (obj2)).a();
            com.liverail.library.b.a.b((new StringBuilder("Failed to compress POST data. Sending original len=")).append(((HttpEntity) (obj1)).getContentLength()).append(" url=").append(((String) (obj))).toString());
        }
        l = (new Date()).getTime();
        obj2 = n;
        g.getClass();
        ((com.a.a.a.a) (obj2)).a("Mozilla/5.0 (Linux; Android; Device) LiveRailSDK/2.1.0");
        n.a(g.f);
        n.a(g.b());
        n.a(g.c, ((String) (obj)), ((HttpEntity) (obj1)), null, new com.liverail.library.c.d(this));
        return;
_L2:
        obj3 = (com.liverail.library.c.f)t.get(i1);
        f1 = ((com.liverail.library.c.f) (obj3)).b();
        k1 = ((com.liverail.library.c.f) (obj3)).c;
        obj = f1.b();
        if (k1 > 0)
        {
            f1.a(String.valueOf(k1));
        }
        ((StringBuilder) (obj1)).append("\n (").append(i1).append(")");
        obj4 = f1.d.entrySet().iterator();
_L10:
        if (((Iterator) (obj4)).hasNext()) goto _L4; else goto _L3
_L3:
        if (!(obj3 instanceof g))
        {
            break MISSING_BLOCK_LABEL_736;
        }
        obj3 = (g)obj3;
        if (!((g) (obj3)).f()) goto _L6; else goto _L5
_L5:
        ((k) (obj2)).a((new StringBuilder("response")).append(i1).toString(), ((g) (obj3)).e());
        obj4 = new ArrayList();
        obj = ((g) (obj3)).g();
_L11:
        if (obj != null && ((g) (obj)).f()) goto _L8; else goto _L7
_L7:
        l1 = ((ArrayList) (obj4)).size();
        if (l1 > 0)
        {
            ((k) (obj2)).a((new StringBuilder("subresponse")).append(i1).append("[]").toString(), ((ArrayList) (obj4)));
        }
        if (l1 > 0)
        {
            ((StringBuilder) (obj1)).append("(").append(l1).append("-wrappers)");
        }
        ((StringBuilder) (obj1)).append("(OK)");
_L12:
        if (((g) (obj3)).h())
        {
            ((StringBuilder) (obj1)).append("(empty)");
        }
_L13:
        ((StringBuilder) (obj1)).append("(").append(k1).append("ms)-").append(f1);
        i1++;
          goto _L9
_L4:
        entry = (java.util.Map.Entry)((Iterator) (obj4)).next();
        ((k) (obj2)).a((new StringBuilder(String.valueOf((String)entry.getKey()))).append(i1).toString(), (String)entry.getValue());
          goto _L10
_L8:
        ((ArrayList) (obj4)).add(((g) (obj)).e());
        obj = ((g) (obj)).g();
          goto _L11
_L6:
        if (((String) (obj)).equals("1"))
        {
            ((StringBuilder) (obj1)).append("(empty)");
        } else
        {
            ((StringBuilder) (obj1)).append("(FAIL)");
        }
          goto _L12
        ((StringBuilder) (obj1)).append("(OK-o)");
          goto _L13
        obj1;
_L15:
        com.liverail.library.b.a.e((new StringBuilder("Failed to compress POST data ")).append(obj1).toString());
          goto _L14
        obj1;
          goto _L15
    }

    private void h()
    {
        com.liverail.library.b.a.c((new StringBuilder("AdProvider completed in ")).append((new Date()).getTime() - i).append("ms").toString());
        u = 2;
        i();
        if (h != null)
        {
            h.a();
        }
    }

    private void i()
    {
        if (n != null)
        {
            com.liverail.library.b.a.a("AdProvider clean up LiveRail client");
            n.a(g.c, true);
            n = null;
        }
    }

    private void j()
    {
        if (t == null) goto _L2; else goto _L1
_L1:
        int i1;
        int j1;
        j1 = t.size();
        i1 = 0;
_L6:
        if (i1 < j1) goto _L4; else goto _L3
_L3:
        t = null;
_L2:
        return;
_L4:
        com.liverail.library.c.f f1 = (com.liverail.library.c.f)t.get(i1);
        if (f1 != null)
        {
            f1.d();
        }
        i1++;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void a()
    {
        d();
        if (com.liverail.library.b.a.a)
        {
            com.liverail.library.b.a.b(g.toString());
        }
        i = (new Date()).getTime();
        u = 1;
        com.liverail.library.b.a.a((new StringBuilder("Delivery URL ")).append(o).toString());
        q.a();
        CookieStore cookiestore = g.b();
        cookiestore.clearExpired(new Date());
        com.liverail.library.b.a.a((new StringBuilder("CookieStore contains ")).append(cookiestore.getCookies().size()).append(" saved cookies.").toString());
        j = (new Date()).getTime();
        n = new com.a.a.a.a();
        Object obj = (new StringBuilder("Delivery timeout=")).append(g.f).append(" user-agent: ");
        g.getClass();
        com.liverail.library.b.a.a(((StringBuilder) (obj)).append("Mozilla/5.0 (Linux; Android; Device) LiveRailSDK/2.1.0").toString());
        obj = n;
        g.getClass();
        ((com.a.a.a.a) (obj)).a("Mozilla/5.0 (Linux; Android; Device) LiveRailSDK/2.1.0");
        n.a(g.f);
        n.a(cookiestore);
        n.b(g.c, o, new k(g.d), new com.liverail.library.c.b(this));
    }

    public void a(e e1)
    {
        h = e1;
    }

    public d b()
    {
        return q;
    }

    public int c()
    {
        return u;
    }

    public void d()
    {
        if (u == 1)
        {
            i();
            j();
        }
        u = 0;
    }
}
