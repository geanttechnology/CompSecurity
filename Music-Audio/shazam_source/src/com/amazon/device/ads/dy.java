// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.amazon.device.ads:
//            co, dn, bc, dq, 
//            cl, ea, dz, cn, 
//            ds, as, at, bt, 
//            bu, dc

abstract class dy
{
    public static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        private static final a d[];
        private final String c;

        public static a valueOf(String s1)
        {
            return (a)Enum.valueOf(com/amazon/device/ads/dy$a, s1);
        }

        public static a[] values()
        {
            return (a[])d.clone();
        }

        public final String toString()
        {
            return c;
        }

        static 
        {
            a = new a("GET", 0, "GET");
            b = new a("POST", 1, "POST");
            d = (new a[] {
                a, b
            });
        }

        private a(String s1, int i1, String s2)
        {
            super(s1, i1);
            c = s2;
        }
    }

    static final class b
    {

        final HashMap a = new HashMap();
        String b;

        final void a(String s1, String s2)
        {
            if (dq.b(s1))
            {
                throw new IllegalArgumentException("The name must not be null or empty string.");
            }
            if (s2 == null)
            {
                a.remove(s1);
                return;
            } else
            {
                a.put(s1, s2);
                return;
            }
        }

        final void a(String s1, String s2, boolean flag)
        {
            if (flag)
            {
                a(s1, s2);
            }
        }

        b()
        {
        }
    }

    public final class c extends Exception
    {

        final f a;
        final dy b;

        protected c(f f1, String s1, Throwable throwable)
        {
            b = dy.this;
            super(s1, throwable);
            a = f1;
        }
    }

    public static final class d
    {

        private final as a;

        public final dy a()
        {
            if (at.b(a, 7))
            {
                return new bt();
            } else
            {
                return new bu();
            }
        }

        public d()
        {
            this(new as());
        }

        private d(as as1)
        {
            a = as1;
        }
    }

    final class e extends InputStream
    {

        final dy a;
        private final InputStream b;

        public final void close()
        {
            b.close();
            if (dy.b(a))
            {
                a.a();
            }
        }

        public final int read()
        {
            return b.read();
        }

        public e(InputStream inputstream)
        {
            a = dy.this;
            super();
            b = inputstream;
        }
    }

    public static final class f extends Enum
    {

        public static final f a;
        public static final f b;
        public static final f c;
        public static final f d;
        public static final f e;
        private static final f f[];

        public static f valueOf(String s1)
        {
            return (f)Enum.valueOf(com/amazon/device/ads/dy$f, s1);
        }

        public static f[] values()
        {
            return (f[])f.clone();
        }

        static 
        {
            a = new f("NETWORK_FAILURE", 0);
            b = new f("NETWORK_TIMEOUT", 1);
            c = new f("MALFORMED_URL", 2);
            d = new f("INVALID_CLIENT_PROTOCOL", 3);
            e = new f("UNSUPPORTED_ENCODING", 4);
            f = (new f[] {
                a, b, c, d, e
            });
        }

        private f(String s1, int i1)
        {
            super(s1, i1);
        }
    }

    public final class g
    {

        int a;
        String b;
        final dy c;
        private e d;

        public final dc a()
        {
            dc dc1 = new dc(d);
            dc1.a(c.n);
            dc1.a(dy.a(c));
            return dc1;
        }

        protected final void a(InputStream inputstream)
        {
            d = c. new e(inputstream);
        }

        protected g()
        {
            c = dy.this;
            super();
        }
    }


    private static final String s = com/amazon/device/ads/dy.getSimpleName();
    String a;
    String b;
    String c;
    String d;
    String e;
    a f;
    int g;
    cl h;
    boolean i;
    protected final HashMap j = new HashMap();
    protected b k;
    protected HashMap l;
    boolean m;
    boolean n;
    protected boolean o;
    protected boolean p;
    protected ck.a q;
    final cn r;
    private String t;
    private String u;
    private String v;
    private int w;
    private String x;

    dy()
    {
        a = null;
        b = null;
        c = null;
        d = null;
        t = null;
        u = null;
        v = null;
        e = null;
        w = -1;
        f = a.a;
        g = 20000;
        m = false;
        n = false;
        o = false;
        p = false;
        x = s;
        new co();
        r = co.a(x);
        k = new b();
        l = new HashMap();
        boolean flag = dn.a().a("tlsEnabled", false);
        p = bc.a().a("debug.tlsEnabled", Boolean.valueOf(flag)).booleanValue();
        i = true;
    }

    static String a(dy dy1)
    {
        return dy1.x;
    }

    private void a(StringBuilder stringbuilder)
    {
        b b1 = k;
        if (b1.a.size() != 0 || !dq.a(b1.b))
        {
            stringbuilder.append("?");
            Iterator iterator = b1.a.entrySet().iterator();
            boolean flag = true;
            while (iterator.hasNext()) 
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                if (flag)
                {
                    flag = false;
                } else
                {
                    stringbuilder.append("&");
                }
                stringbuilder.append((String)entry.getKey());
                stringbuilder.append("=");
                stringbuilder.append((String)entry.getValue());
            }
            if (b1.b != null && !b1.b.equals(""))
            {
                if (b1.a.size() != 0)
                {
                    stringbuilder.append("&");
                }
                stringbuilder.append(b1.b);
            }
        }
    }

    private void b(ck.a a1)
    {
        if (a1 != null && h != null)
        {
            h.c(a1);
        }
    }

    static boolean b(dy dy1)
    {
        return dy1.i;
    }

    private String h()
    {
        if (t != null)
        {
            return t;
        }
        String s1;
        StringBuilder stringbuilder;
        if (p)
        {
            s1 = "https";
        } else
        {
            s1 = "http";
        }
        stringbuilder = new StringBuilder(s1);
        stringbuilder.append("://");
        if (p)
        {
            s1 = u;
        } else
        {
            s1 = v;
        }
        stringbuilder.append(s1);
        if (w != -1)
        {
            stringbuilder.append(":");
            stringbuilder.append(w);
        }
        stringbuilder.append(e);
        a(stringbuilder);
        return stringbuilder.toString();
    }

    protected abstract g a(URL url);

    public final String a(String s1, String s2)
    {
        b b1 = k;
        new ea();
        s1 = dz.a(s1);
        b1.a(s1, dz.a(s2));
        return s1;
    }

    protected abstract void a();

    public final void a(ck.a a1)
    {
        q = a1;
    }

    public final void a(a a1)
    {
        if (a1 == null)
        {
            throw new IllegalArgumentException("The httpMethod must not be null.");
        } else
        {
            f = a1;
            return;
        }
    }

    public final void a(b b1)
    {
        k = b1;
    }

    protected final void a(String s1)
    {
        if (o)
        {
            r.b("%s %s", new Object[] {
                f, s1
            });
        }
    }

    public final void a(boolean flag)
    {
        p = flag;
    }

    protected abstract String b();

    public final void b(String s1)
    {
        if (dq.b(s1))
        {
            throw new IllegalArgumentException("The host must not be null.");
        } else
        {
            u = s1;
            v = s1;
            return;
        }
    }

    public final void b(String s1, String s2)
    {
        if (dq.b(s1))
        {
            throw new IllegalArgumentException("The name must not be null or empty string.");
        }
        if (s2 == null)
        {
            l.remove(s1);
            return;
        } else
        {
            l.put(s1, s2);
            return;
        }
    }

    public final g c()
    {
        if (ds.b())
        {
            r.d("The network request should not be performed on the main thread.", null);
        }
        if (b != null)
        {
            c("Accept", c);
        }
        if (c != null)
        {
            String s2 = c;
            String s1 = s2;
            if (d != null)
            {
                s1 = (new StringBuilder()).append(s2).append("; charset=").append(d).toString();
            }
            c("Content-Type", s1);
        }
        Object obj = h();
        URL url;
        try
        {
            url = new URL(((String) (obj)));
        }
        catch (MalformedURLException malformedurlexception)
        {
            r.d("Problem with URI syntax: %s", new Object[] {
                malformedurlexception.getMessage()
            });
            throw new c(f.c, (new StringBuilder("Could not construct URL from String ")).append(((String) (obj))).toString(), malformedurlexception);
        }
        obj = q;
        if (obj != null && h != null)
        {
            h.b(((ck.a) (obj)));
        }
        obj = a(url);
        b(q);
        if (n)
        {
            r.b("Response: %s %s", new Object[] {
                Integer.valueOf(((g) (obj)).a), ((g) (obj)).b
            });
        }
        return ((g) (obj));
        Object obj1;
        obj1;
        throw obj1;
        obj1;
        b(q);
        throw obj1;
    }

    public final void c(String s1)
    {
        String s2 = s1;
        if (s1 != null)
        {
            s2 = s1;
            if (p)
            {
                s2 = s1;
                if (s1.startsWith("http:"))
                {
                    s2 = s1.replaceFirst("http", "https");
                }
            }
        }
        t = s2;
    }

    public final void c(String s1, String s2)
    {
        if (dq.b(s1))
        {
            throw new IllegalArgumentException("The name must not be null or empty string.");
        } else
        {
            j.put(s1, s2);
            return;
        }
    }

    public final void d()
    {
        o = true;
    }

    public final void d(String s1)
    {
        k.b = s1;
    }

    public final void e()
    {
        o = true;
        m = true;
        n = true;
    }

    public final void e(String s1)
    {
        if (s1 == null)
        {
            x = (new StringBuilder()).append(s).append(" ").append(b()).toString();
        } else
        {
            x = (new StringBuilder()).append(s1).append(" ").append(s).append(" ").append(b()).toString();
        }
        r.g(x);
    }

    public final boolean f()
    {
        return p;
    }

    public final String g()
    {
        if (a != null)
        {
            return a;
        }
        if (l.isEmpty())
        {
            return null;
        }
        StringBuilder stringbuilder = new StringBuilder();
        java.util.Map.Entry entry;
        for (Iterator iterator = l.entrySet().iterator(); iterator.hasNext(); stringbuilder.append((String)entry.getKey()).append('=').append((String)entry.getValue()).append(";\n"))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

        return stringbuilder.toString();
    }

    public String toString()
    {
        return h();
    }

}
