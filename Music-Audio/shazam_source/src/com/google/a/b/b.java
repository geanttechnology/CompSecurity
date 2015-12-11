// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.b;

import com.google.a.a.a;
import com.google.a.a.e;
import com.google.a.a.g;
import com.google.a.a.k;
import com.google.a.a.n;
import java.util.logging.Level;
import java.util.logging.Logger;

// Referenced classes of package com.google.a.b:
//            d, n, k, c, 
//            e

public final class com.google.a.b.b
{
    static final class a extends Enum
        implements com.google.a.b.k
    {

        public static final a a;
        private static final a b[];

        public static a valueOf(String s1)
        {
            return (a)Enum.valueOf(com/google/a/b/b$a, s1);
        }

        public static a[] values()
        {
            return (a[])b.clone();
        }

        static 
        {
            a = new a("INSTANCE");
            b = (new a[] {
                a
            });
        }

        private a(String s1)
        {
            super(s1, 0);
        }
    }

    static final class b extends Enum
        implements com.google.a.b.n
    {

        public static final b a;
        private static final b b[];

        public static b valueOf(String s1)
        {
            return (b)Enum.valueOf(com/google/a/b/b$b, s1);
        }

        public static b[] values()
        {
            return (b[])b.clone();
        }

        static 
        {
            a = new b("INSTANCE");
            b = (new b[] {
                a
            });
        }

        private b(String s1)
        {
            super(s1, 0);
        }
    }


    static final k a = new com.google.a.a.l.a(new a.b() {

        public final void a()
        {
        }

        public final void a(long l1)
        {
        }

        public final void b()
        {
        }

        public final void b(long l1)
        {
        }

        public final void c()
        {
        }

    });
    static final d b = new d();
    static final k c = new k() {

        public final Object a()
        {
            return new a.a();
        }

    };
    static final n d = new n() {

        public final long a()
        {
            return 0L;
        }

    };
    private static final Logger u = Logger.getLogger(com/google/a/b/b.getName());
    boolean e;
    int f;
    int g;
    long h;
    long i;
    com.google.a.b.n j;
    f.q k;
    f.q l;
    long m;
    long n;
    long o;
    com.google.a.a.b p;
    com.google.a.a.b q;
    com.google.a.b.k r;
    n s;
    k t;

    com.google.a.b.b()
    {
        e = true;
        f = -1;
        g = -1;
        h = -1L;
        i = -1L;
        m = -1L;
        n = -1L;
        o = -1L;
        t = a;
    }

    public static com.google.a.b.b a()
    {
        return new com.google.a.b.b();
    }

    public final com.google.a.b.e a(c c1)
    {
        boolean flag;
        boolean flag2;
        flag2 = true;
        flag = true;
        if (j != null) goto _L2; else goto _L1
_L1:
        if (i != -1L)
        {
            flag = false;
        }
        com.google.a.a.g.b(flag, "maximumWeight requires weigher");
_L4:
        return new f.k(this, c1);
_L2:
        if (e)
        {
            boolean flag1;
            if (i != -1L)
            {
                flag1 = flag2;
            } else
            {
                flag1 = false;
            }
            com.google.a.a.g.b(flag1, "weigher requires maximumWeight");
        } else
        if (i == -1L)
        {
            u.log(Level.WARNING, "ignoring weigher specified without maximumWeight");
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final com.google.a.b.b b()
    {
        f.q q1 = f.q.c;
        boolean flag;
        if (k == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        com.google.a.a.g.b(flag, "Key strength was already set to %s", new Object[] {
            k
        });
        k = (f.q)com.google.a.a.g.a(q1);
        return this;
    }

    final f.q c()
    {
        return (f.q)com.google.a.a.e.a(k, com.google.a.b.f.q.a);
    }

    final f.q d()
    {
        return (f.q)com.google.a.a.e.a(l, com.google.a.b.f.q.a);
    }

    public final String toString()
    {
        com.google.a.a.e.a a1 = com.google.a.a.e.a(this);
        if (f != -1)
        {
            a1.a("initialCapacity", f);
        }
        if (g != -1)
        {
            a1.a("concurrencyLevel", g);
        }
        if (h != -1L)
        {
            a1.a("maximumSize", h);
        }
        if (i != -1L)
        {
            a1.a("maximumWeight", i);
        }
        if (m != -1L)
        {
            long l1 = m;
            a1.a("expireAfterWrite", (new StringBuilder(22)).append(l1).append("ns").toString());
        }
        if (n != -1L)
        {
            long l2 = n;
            a1.a("expireAfterAccess", (new StringBuilder(22)).append(l2).append("ns").toString());
        }
        if (k != null)
        {
            a1.a("keyStrength", com.google.a.a.a.a(k.toString()));
        }
        if (l != null)
        {
            a1.a("valueStrength", com.google.a.a.a.a(l.toString()));
        }
        if (p != null)
        {
            a1.a("keyEquivalence");
        }
        if (q != null)
        {
            a1.a("valueEquivalence");
        }
        if (r != null)
        {
            a1.a("removalListener");
        }
        return a1.toString();
    }

}
