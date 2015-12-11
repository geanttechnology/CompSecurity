// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.d;

import com.google.api.a.f.a.a.a.a.c;
import com.google.api.a.g.m;
import com.google.api.a.g.s;
import com.google.api.a.g.u;
import com.google.api.a.g.w;
import com.google.api.a.g.x;
import com.google.api.a.g.z;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

// Referenced classes of package com.google.api.a.d:
//            m, h, o, s, 
//            l, v, i, y, 
//            w, j, k, z, 
//            n, c, u, t

public final class p
{

    public l a;
    public com.google.api.a.d.m b;
    public com.google.api.a.d.m c;
    int d;
    boolean e;
    public i f;
    public final v g;
    public String h;
    public h i;
    public com.google.api.a.d.w j;
    public n k;
    public com.google.api.a.d.u l;
    public u m;
    public j n;
    public boolean o;
    private int p;
    private boolean q;
    private int r;
    private int s;
    private com.google.api.a.d.c t;
    private boolean u;
    private boolean v;
    private boolean w;
    private x x;

    p(v v1)
    {
        b = new com.google.api.a.d.m();
        c = new com.google.api.a.d.m();
        p = 10;
        d = 16384;
        e = true;
        q = true;
        r = 20000;
        s = 20000;
        u = true;
        o = true;
        v = false;
        x = x.a;
        g = v1;
        a(((String) (null)));
    }

    public final p a(h h1)
    {
        i = (h)com.google.api.a.f.a.a.a.a.c.a(h1);
        return this;
    }

    public final p a(String s1)
    {
        boolean flag;
        if (s1 == null || com.google.api.a.d.o.b(s1))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        com.google.api.a.g.w.a(flag);
        h = s1;
        return this;
    }

    public final com.google.api.a.d.s a()
    {
        Object obj;
        Object obj1;
        Object obj2;
        Logger logger;
        int i1;
        int j1;
        boolean flag;
        boolean flag1;
        String s1;
        Object obj4;
        String s3;
        y y1;
        String s4;
        if (p >= 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        com.google.api.a.g.w.a(flag);
        i1 = p;
        obj = null;
        com.google.api.a.f.a.a.a.a.c.a(h);
        com.google.api.a.f.a.a.a.a.c.a(i);
_L27:
        if (obj != null)
        {
            ((com.google.api.a.d.s) (obj)).c();
        }
        obj4 = null;
        if (a != null)
        {
            a.b(this);
        }
        s3 = i.d();
        y1 = g.a(h, s3);
        logger = v.a;
        if (e && logger.isLoggable(Level.CONFIG))
        {
            j1 = 1;
        } else
        {
            j1 = 0;
        }
        if (j1 != 0)
        {
            obj2 = new StringBuilder();
            ((StringBuilder) (obj2)).append("-------------- REQUEST  --------------").append(z.a);
            ((StringBuilder) (obj2)).append(h).append(' ').append(s3).append(z.a);
            Object obj3;
            String s2;
            String s5;
            int k1;
            long l1;
            boolean flag2;
            if (q)
            {
                obj1 = new StringBuilder("curl -v --compressed");
                if (!h.equals("GET"))
                {
                    ((StringBuilder) (obj1)).append(" -X ").append(h);
                }
            } else
            {
                obj1 = null;
            }
        } else
        {
            obj2 = null;
            obj1 = null;
        }
        obj = (String)com.google.api.a.d.m.a(b.userAgent);
        if (!w)
        {
            if (obj == null)
            {
                b.e("Google-HTTP-Java-Client/1.20.0 (gzip)");
            } else
            {
                obj3 = b;
                s2 = String.valueOf(String.valueOf(obj));
                s5 = String.valueOf(String.valueOf("Google-HTTP-Java-Client/1.20.0 (gzip)"));
                ((com.google.api.a.d.m) (obj3)).e((new StringBuilder(s2.length() + 1 + s5.length())).append(s2).append(" ").append(s5).toString());
            }
        }
        com.google.api.a.d.m.a(b, ((StringBuilder) (obj2)), ((StringBuilder) (obj1)), logger, y1);
        if (!w)
        {
            b.e(((String) (obj)));
        }
        obj = f;
        if (obj == null || f.d())
        {
            k1 = 1;
        } else
        {
            k1 = 0;
        }
        obj3 = obj;
        if (obj != null)
        {
            s4 = f.c();
            if (j1 != 0)
            {
                obj = new s(((com.google.api.a.g.y) (obj)), v.a, Level.CONFIG, d);
            }
            if (n == null)
            {
                l1 = f.a();
                obj3 = null;
            } else
            {
                obj3 = n.a();
                obj = new k(((com.google.api.a.g.y) (obj)), n);
                if (k1 != 0)
                {
                    l1 = com.google.api.a.g.m.a(((com.google.api.a.g.y) (obj)));
                } else
                {
                    l1 = -1L;
                }
            }
            if (j1 != 0)
            {
                if (s4 != null)
                {
                    s1 = String.valueOf(s4);
                    if (s1.length() != 0)
                    {
                        s2 = "Content-Type: ".concat(s1);
                    } else
                    {
                        s2 = new String("Content-Type: ");
                    }
                    ((StringBuilder) (obj2)).append(s2).append(z.a);
                    if (obj1 != null)
                    {
                        s2 = String.valueOf(String.valueOf(s2));
                        ((StringBuilder) (obj1)).append((new StringBuilder(s2.length() + 6)).append(" -H '").append(s2).append("'").toString());
                    }
                }
                if (obj3 != null)
                {
                    s2 = String.valueOf(obj3);
                    if (s2.length() != 0)
                    {
                        s2 = "Content-Encoding: ".concat(s2);
                    } else
                    {
                        s2 = new String("Content-Encoding: ");
                    }
                    ((StringBuilder) (obj2)).append(s2).append(z.a);
                    if (obj1 != null)
                    {
                        s2 = String.valueOf(String.valueOf(s2));
                        ((StringBuilder) (obj1)).append((new StringBuilder(s2.length() + 6)).append(" -H '").append(s2).append("'").toString());
                    }
                }
                if (l1 >= 0L)
                {
                    ((StringBuilder) (obj2)).append((new StringBuilder(36)).append("Content-Length: ").append(l1).toString()).append(z.a);
                }
            }
            if (obj1 != null)
            {
                ((StringBuilder) (obj1)).append(" -d '@-'");
            }
            y1.c = s4;
            y1.b = ((String) (obj3));
            y1.a = l1;
            y1.d = ((com.google.api.a.g.y) (obj));
            obj3 = obj;
        }
        if (j1 != 0)
        {
            logger.config(((StringBuilder) (obj2)).toString());
            if (obj1 != null)
            {
                ((StringBuilder) (obj1)).append(" -- '");
                ((StringBuilder) (obj1)).append(s3.replaceAll("'", "'\"'\"'"));
                ((StringBuilder) (obj1)).append("'");
                if (obj3 != null)
                {
                    ((StringBuilder) (obj1)).append(" << $$$");
                }
                logger.config(((StringBuilder) (obj1)).toString());
            }
        }
        if (k1 != 0 && i1 > 0)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        y1.a(r, s);
        obj1 = y1.a();
        obj = new com.google.api.a.d.s(this, ((com.google.api.a.d.z) (obj1)));
        obj1 = obj4;
_L19:
        if (obj == null) goto _L2; else goto _L1
_L1:
        if (((com.google.api.a.d.s) (obj)).a()) goto _L2; else goto _L3
_L3:
        flag = false;
        if (j != null)
        {
            flag = j.a(this, ((com.google.api.a.d.s) (obj)), flag2);
        }
        flag1 = flag;
        if (flag) goto _L5; else goto _L4
_L4:
        k1 = ((com.google.api.a.d.s) (obj)).c;
        obj2 = ((com.google.api.a.d.s) (obj)).e.c.a();
        if (!u) goto _L7; else goto _L6
_L6:
        k1;
        JVM INSTR tableswitch 301 307: default 1458
    //                   301 1258
    //                   302 1258
    //                   303 1258
    //                   304 1458
    //                   305 1458
    //                   306 1458
    //                   307 1258;
           goto _L8 _L9 _L9 _L9 _L8 _L8 _L8 _L9
_L20:
        if (j1 == 0 || obj2 == null) goto _L7; else goto _L10
_L10:
        a(new h(i.g(((String) (obj2)))));
        if (k1 != 303) goto _L12; else goto _L11
_L11:
        a("GET");
        f = null;
_L12:
        b.a(null);
        b.ifMatch = com.google.api.a.d.m.a(null);
        b.ifNoneMatch = com.google.api.a.d.m.a(null);
        b.ifModifiedSince = com.google.api.a.d.m.a(null);
        b.ifUnmodifiedSince = com.google.api.a.d.m.a(null);
        b.ifRange = com.google.api.a.d.m.a(null);
        j1 = 1;
          goto _L13
_L5:
        k1 = flag2 & flag1;
        j1 = k1;
        if (k1 == 0)
        {
            break MISSING_BLOCK_LABEL_1007;
        }
        ((com.google.api.a.d.s) (obj)).c();
        j1 = k1;
_L24:
        if (obj == null);
        if (j1 != 0) goto _L15; else goto _L14
_L14:
        if (obj == null)
        {
            throw obj1;
        }
        if (l != null)
        {
            l.a(((com.google.api.a.d.s) (obj)));
        }
          goto _L16
        obj;
        obj1 = ((com.google.api.a.d.z) (obj1)).a();
        if (obj1 == null) goto _L18; else goto _L17
_L17:
        ((InputStream) (obj1)).close();
_L18:
        throw obj;
        obj1;
        if (!v && (k == null || !k.a(this, flag2)))
        {
            throw obj1;
        }
        logger.log(Level.WARNING, "exception thrown while executing request", ((Throwable) (obj1)));
        obj = null;
          goto _L19
_L9:
        j1 = 1;
          goto _L20
_L7:
        j1 = 0;
          goto _L13
_L29:
        flag1 = flag;
        if (!flag2) goto _L5; else goto _L21
_L21:
        flag1 = flag;
        if (t == null) goto _L5; else goto _L22
_L22:
        flag1 = flag;
        if (!t.a()) goto _L5; else goto _L23
_L23:
        l1 = t.b();
        flag1 = flag;
        if (l1 != -1L)
        {
            try
            {
                x.a(l1);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj2) { }
            finally
            {
                if (obj == null) goto _L0; else goto _L0
            }
            flag1 = true;
        }
          goto _L5
_L2:
        if (obj == null)
        {
            j1 = 1;
        } else
        {
            j1 = 0;
        }
        j1 = flag2 & j1;
          goto _L24
        ((com.google.api.a.d.s) (obj)).d();
        throw obj1;
_L16:
        if (!o || ((com.google.api.a.d.s) (obj)).a()) goto _L26; else goto _L25
_L25:
        throw new t(((com.google.api.a.d.s) (obj)));
        obj1;
        ((com.google.api.a.d.s) (obj)).d();
        throw obj1;
_L26:
        return ((com.google.api.a.d.s) (obj));
_L15:
        i1--;
          goto _L27
_L8:
        j1 = 0;
          goto _L20
_L13:
        if (j1 == 0) goto _L29; else goto _L28
_L28:
        flag1 = true;
          goto _L5
    }
}
