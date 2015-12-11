// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.c.d;

import com.google.api.a.d.aa;
import com.google.api.a.d.e;
import com.google.api.a.d.f;
import com.google.api.a.d.g;
import com.google.api.a.d.h;
import com.google.api.a.d.i;
import com.google.api.a.d.m;
import com.google.api.a.d.p;
import com.google.api.a.d.q;
import com.google.api.a.d.r;
import com.google.api.a.d.s;
import com.google.api.a.d.v;
import com.google.api.a.f.a.a.a.a.c;
import com.google.api.a.g.d;
import com.google.api.a.g.w;
import com.google.api.a.g.x;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

// Referenced classes of package com.google.api.a.c.d:
//            c

public final class b
{
    public static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        public static final a c;
        public static final a d;
        public static final a e;
        private static final a f[];

        public static a valueOf(String s1)
        {
            return (a)Enum.valueOf(com/google/api/a/c/d/b$a, s1);
        }

        public static a[] values()
        {
            return (a[])f.clone();
        }

        static 
        {
            a = new a("NOT_STARTED", 0);
            b = new a("INITIATION_STARTED", 1);
            c = new a("INITIATION_COMPLETE", 2);
            d = new a("MEDIA_IN_PROGRESS", 3);
            e = new a("MEDIA_COMPLETE", 4);
            f = (new a[] {
                a, b, c, d, e
            });
        }

        private a(String s1, int i1)
        {
            super(s1, i1);
        }
    }


    public a a;
    public i b;
    public String c;
    public m d;
    public boolean e;
    String f;
    public boolean g;
    x h;
    private final com.google.api.a.d.b i;
    private final q j;
    private final v k;
    private long l;
    private boolean m;
    private p n;
    private InputStream o;
    private long p;
    private int q;
    private Byte r;
    private long s;
    private int t;
    private byte u[];

    public b(com.google.api.a.d.b b1, v v1, r r1)
    {
        a = a.a;
        c = "POST";
        d = new m();
        f = "*";
        q = 0xa00000;
        h = x.a;
        i = (com.google.api.a.d.b)com.google.api.a.f.a.a.a.a.c.a(b1);
        k = (v)com.google.api.a.f.a.a.a.a.c.a(v1);
        if (r1 == null)
        {
            b1 = v1.a(null);
        } else
        {
            b1 = v1.a(r1);
        }
        j = b1;
    }

    private static s a(p p1)
    {
        (new com.google.api.a.c.b()).b(p1);
        p1.o = false;
        return p1.a();
    }

    private s b(p p1)
    {
        if (!g && !(p1.f instanceof f))
        {
            p1.n = new g();
        }
        return a(p1);
    }

    private boolean b()
    {
        return c() >= 0L;
    }

    private long c()
    {
        if (!m)
        {
            l = i.a();
            m = true;
        }
        return l;
    }

    private s c(h h1)
    {
        a = a.b;
        h1.put("uploadType", "resumable");
        Object obj;
        if (b == null)
        {
            obj = new f();
        } else
        {
            obj = b;
        }
        h1 = j.a(c, h1, ((i) (obj)));
        d.a("X-Upload-Content-Type", i.a);
        if (b())
        {
            d.a("X-Upload-Content-Length", Long.valueOf(c()));
        }
        ((p) (h1)).b.putAll(d);
        h1 = b(h1);
        a = com.google.api.a.c.d.a.c;
        return h1;
        Exception exception;
        exception;
        h1.d();
        throw exception;
    }

    public final s a(h h1)
    {
        a = com.google.api.a.c.d.a.d;
        Object obj = i;
        if (b != null)
        {
            obj = new aa();
            Object obj1 = Arrays.asList(new i[] {
                b, i
            });
            obj.b = new ArrayList(((Collection) (obj1)).size());
            com.google.api.a.d.aa.a a1;
            for (obj1 = ((Collection) (obj1)).iterator(); ((Iterator) (obj1)).hasNext(); ((aa) (obj)).b.add(com.google.api.a.f.a.a.a.a.c.a(a1)))
            {
                a1 = new com.google.api.a.d.aa.a((i)((Iterator) (obj1)).next());
            }

            h1.put("uploadType", "multipart");
        } else
        {
            h1.put("uploadType", "media");
        }
        h1 = j.a(c, h1, ((i) (obj)));
        ((p) (h1)).b.putAll(d);
        h1 = b(h1);
        if (b())
        {
            p = c();
        }
        a = com.google.api.a.c.d.a.e;
        return h1;
        Exception exception;
        exception;
        h1.d();
        throw exception;
    }

    final void a()
    {
        w.a(n, "The current request should not be null");
        n.f = new f();
        m m1 = n.b;
        Object obj;
        if (b())
        {
            obj = Long.valueOf(c());
        } else
        {
            obj = "*";
        }
        obj = String.valueOf(String.valueOf(obj));
        m1.c((new StringBuilder(((String) (obj)).length() + 8)).append("bytes */").append(((String) (obj))).toString());
    }

    public final s b(h h1)
    {
        Object obj1 = c(h1);
        if (((s) (obj1)).a()) goto _L2; else goto _L1
_L1:
        return ((s) (obj1));
_L2:
        h1 = new h(((s) (obj1)).e.c.a());
        ((s) (obj1)).d();
        o = i.b();
        if (!o.markSupported() && b())
        {
            o = new BufferedInputStream(o);
        }
_L8:
        boolean flag1;
        n = j.a("PUT", h1, null);
        Object obj;
        int i1;
        if (b())
        {
            i1 = (int)Math.min(q, c() - p);
        } else
        {
            i1 = q;
        }
        if (b())
        {
            o.mark(i1);
            obj = new com.google.api.a.g.d.a(o, i1);
            obj = new com.google.api.a.d.x(i.c(), ((InputStream) (obj)));
            obj.d = true;
            obj.c = i1;
            obj = ((com.google.api.a.d.x) (obj)).b(false);
            f = String.valueOf(c());
        } else
        {
            if (u == null)
            {
                int j1;
                int k1;
                int l1;
                if (r == null)
                {
                    j1 = i1 + 1;
                } else
                {
                    j1 = i1;
                }
                u = new byte[i1 + 1];
                long l2;
                long l3;
                long l4;
                if (r != null)
                {
                    u[0] = r.byteValue();
                    boolean flag = false;
                    k1 = j1;
                    j1 = ((flag) ? 1 : 0);
                } else
                {
                    k1 = j1;
                    j1 = 0;
                }
            } else
            {
                j1 = (int)(s - p);
                System.arraycopy(u, t - j1, u, 0, j1);
                if (r != null)
                {
                    u[j1] = r.byteValue();
                }
                k1 = i1 - j1;
            }
            l1 = com.google.api.a.g.d.a(o, u, (i1 + 1) - k1, k1);
            if (l1 < k1)
            {
                j1 = Math.max(0, l1) + j1;
                i1 = j1;
                if (r != null)
                {
                    i1 = j1 + 1;
                    r = null;
                }
                j1 = i1;
                if (f.equals("*"))
                {
                    f = String.valueOf(p + (long)i1);
                    j1 = i1;
                }
            } else
            {
                r = Byte.valueOf(u[i1]);
                j1 = i1;
            }
            obj = new e(i.c(), u, j1);
            s = p + (long)j1;
            i1 = j1;
        }
        t = i1;
        n.f = ((i) (obj));
        if (i1 == 0)
        {
            n.b.c("bytes */0");
        } else
        {
            obj = n.b;
            l2 = p;
            l3 = p;
            l4 = i1;
            obj1 = String.valueOf(String.valueOf(f));
            ((m) (obj)).c((new StringBuilder(((String) (obj1)).length() + 48)).append("bytes ").append(l2).append("-").append((l3 + l4) - 1L).append("/").append(((String) (obj1))).toString());
        }
        new com.google.api.a.c.d.c(this, n);
        if (b())
        {
            obj = a(n);
        } else
        {
            obj = b(n);
        }
        if (!((s) (obj)).a())
        {
            break MISSING_BLOCK_LABEL_724;
        }
        p = c();
        if (i.b)
        {
            o.close();
        }
        a = com.google.api.a.c.d.a.e;
        return ((s) (obj));
        h1;
        ((s) (obj)).d();
        throw h1;
        h1;
        ((s) (obj1)).d();
        throw h1;
        obj1 = obj;
        if (((s) (obj)).c != 308) goto _L1; else goto _L3
_L3:
        obj1 = ((s) (obj)).e.c.a();
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_760;
        }
        h1 = new h(((String) (obj1)));
        obj1 = (String)com.google.api.a.d.m.a(((s) (obj)).e.c.range);
        if (obj1 != null) goto _L5; else goto _L4
_L4:
        l2 = 0L;
_L9:
        l3 = l2 - p;
        if (l3 < 0L)
        {
            break MISSING_BLOCK_LABEL_943;
        }
        if (l3 > (long)t)
        {
            break MISSING_BLOCK_LABEL_943;
        }
        flag1 = true;
_L12:
        w.b(flag1);
        l4 = (long)t - l3;
        if (!b()) goto _L7; else goto _L6
_L6:
        if (l4 <= 0L)
        {
            break MISSING_BLOCK_LABEL_873;
        }
        o.reset();
        if (l3 == o.skip(l3))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        w.b(flag1);
_L11:
        p = l2;
        a = com.google.api.a.c.d.a.d;
        ((s) (obj)).d();
          goto _L8
_L5:
        l2 = Long.parseLong(((String) (obj1)).substring(((String) (obj1)).indexOf('-') + 1)) + 1L;
          goto _L9
_L7:
        if (l4 != 0L) goto _L11; else goto _L10
_L10:
        u = null;
          goto _L11
        flag1 = false;
          goto _L12
    }
}
