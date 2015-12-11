// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.b;

import c.d;
import c.e;
import c.f;
import c.i;
import c.m;
import c.r;
import c.s;
import com.g.b.a.a.h;
import com.g.b.a.a.j;
import com.g.b.a.b;
import com.g.b.a.c.a;
import com.g.b.a.k;
import java.io.File;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.g.b:
//            v, p, x, o, 
//            y, n, u

public final class com.g.b.c
{
    private final class a
        implements com.g.b.a.a.b
    {

        boolean a;
        final com.g.b.c b;
        private final com.g.b.a.b.a c;
        private r d;
        private r e;

        public final void a()
        {
label0:
            {
                synchronized (b)
                {
                    if (!a)
                    {
                        break label0;
                    }
                }
                return;
            }
            a = true;
            com.g.b.c c1 = b;
            c1.d = c1.d + 1;
            obj;
            JVM INSTR monitorexit ;
            k.a(d);
            try
            {
                c.b();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                return;
            }
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public final r b()
        {
            return e;
        }

        public a(com.g.b.a.b.a a1)
        {
            b = com.g.b.c.this;
            super();
            c = a1;
            d = a1.a(1);
            e = new _cls1(this, d, com.g.b.c.this, a1);
        }
    }

    private static final class b extends y
    {

        private final com.g.b.a.b.c a;
        private final e b;
        private final String c;
        private final String d;

        static com.g.b.a.b.c a(b b1)
        {
            return b1.a;
        }

        public final long a()
        {
            long l = -1L;
            try
            {
                if (d != null)
                {
                    l = Long.parseLong(d);
                }
            }
            catch (NumberFormatException numberformatexception)
            {
                return -1L;
            }
            return l;
        }

        public final e b()
        {
            return b;
        }

        public b(com.g.b.a.b.c c1, String s, String s1)
        {
            a = c1;
            c = s;
            d = s1;
            b = m.a(new _cls1(this, c1.c[1], c1));
        }
    }

    private static final class c
    {

        final String a;
        final o b;
        final String c;
        final u d;
        final int e;
        final String f;
        final o g;
        final n h;

        private static List a(e e1)
        {
            int l = com.g.b.c.a(e1);
            if (l != -1) goto _L2; else goto _L1
_L1:
            Object obj = Collections.emptyList();
_L4:
            return ((List) (obj));
_L2:
            ArrayList arraylist;
            CertificateFactory certificatefactory;
            c.c c1;
            int i;
            try
            {
                certificatefactory = CertificateFactory.getInstance("X.509");
                arraylist = new ArrayList(l);
            }
            // Misplaced declaration of an exception variable
            catch (e e1)
            {
                throw new IOException(e1.getMessage());
            }
            i = 0;
            obj = arraylist;
            if (i >= l) goto _L4; else goto _L3
_L3:
            obj = e1.p();
            c1 = new c.c();
            c1.a(c.f.b(((String) (obj))));
            arraylist.add(certificatefactory.generateCertificate(c1.f()));
            i++;
            break MISSING_BLOCK_LABEL_37;
        }

        private static void a(d d1, List list)
        {
            int i;
            int l;
            try
            {
                d1.j(list.size());
                d1.h(10);
                l = list.size();
            }
            // Misplaced declaration of an exception variable
            catch (d d1)
            {
                throw new IOException(d1.getMessage());
            }
            i = 0;
            if (i >= l)
            {
                break; /* Loop/switch isn't completed */
            }
            d1.b(c.b.a(c.f.a(((Certificate)list.get(i)).getEncoded()).c));
            d1.h(10);
            i++;
            if (true) goto _L2; else goto _L1
_L2:
            break MISSING_BLOCK_LABEL_32;
_L1:
        }

        private boolean a()
        {
            return a.startsWith("https://");
        }

        public final void a(com.g.b.a.b.a a1)
        {
            boolean flag = false;
            a1 = m.a(a1.a(0));
            a1.b(a);
            a1.h(10);
            a1.b(c);
            a1.h(10);
            a1.j(b.a.length / 2);
            a1.h(10);
            int i1 = b.a.length / 2;
            for (int i = 0; i < i1; i++)
            {
                a1.b(b.a(i));
                a1.b(": ");
                a1.b(b.b(i));
                a1.h(10);
            }

            a1.b((new com.g.b.a.a.s(d, e, f)).toString());
            a1.h(10);
            a1.j(g.a.length / 2);
            a1.h(10);
            i1 = g.a.length / 2;
            for (int l = ((flag) ? 1 : 0); l < i1; l++)
            {
                a1.b(g.a(l));
                a1.b(": ");
                a1.b(g.b(l));
                a1.h(10);
            }

            if (a())
            {
                a1.h(10);
                a1.b(h.a);
                a1.h(10);
                a(((d) (a1)), h.b);
                a(((d) (a1)), h.c);
            }
            a1.close();
        }

        public c(s s1)
        {
            boolean flag;
            flag = false;
            super();
            Object obj;
            Object obj1;
            int l;
            obj = m.a(s1);
            a = ((e) (obj)).p();
            c = ((e) (obj)).p();
            obj1 = new o.a();
            l = com.g.b.c.a(((e) (obj)));
            int i = 0;
_L2:
            if (i >= l)
            {
                break; /* Loop/switch isn't completed */
            }
            ((o.a) (obj1)).a(((e) (obj)).p());
            i++;
            if (true) goto _L2; else goto _L1
_L1:
            b = ((o.a) (obj1)).a();
            obj1 = com.g.b.a.a.s.a(((e) (obj)).p());
            d = ((com.g.b.a.a.s) (obj1)).a;
            e = ((com.g.b.a.a.s) (obj1)).b;
            f = ((com.g.b.a.a.s) (obj1)).c;
            obj1 = new o.a();
            l = com.g.b.c.a(((e) (obj)));
            i = ((flag) ? 1 : 0);
_L4:
            if (i >= l)
            {
                break; /* Loop/switch isn't completed */
            }
            ((o.a) (obj1)).a(((e) (obj)).p());
            i++;
            if (true) goto _L4; else goto _L3
_L3:
            g = ((o.a) (obj1)).a();
            if (!a())
            {
                break MISSING_BLOCK_LABEL_290;
            }
            obj1 = ((e) (obj)).p();
            if (((String) (obj1)).length() > 0)
            {
                throw new IOException((new StringBuilder("expected \"\" but was \"")).append(((String) (obj1))).append("\"").toString());
            }
            break MISSING_BLOCK_LABEL_230;
            obj;
            s1.close();
            throw obj;
            List list;
            obj1 = ((e) (obj)).p();
            list = a(((e) (obj)));
            obj = a(((e) (obj)));
            if (obj1 != null)
            {
                break MISSING_BLOCK_LABEL_262;
            }
            throw new IllegalArgumentException("cipherSuite == null");
            h = new n(((String) (obj1)), k.a(list), k.a(((List) (obj))));
_L5:
            s1.close();
            return;
            h = null;
              goto _L5
        }

        public c(x x1)
        {
            a = x1.a.a.toString();
            b = j.c(x1);
            c = x1.a.b;
            d = x1.b;
            e = x1.c;
            f = x1.d;
            g = x1.f;
            h = x1.e;
        }
    }


    final com.g.b.a.e a = new com.g.b.a.e() {

        final com.g.b.c a;

        public final com.g.b.a.a.b a(x x1)
        {
            return a.a(x1);
        }

        public final x a(v v1)
        {
            return a.a(v1);
        }

        public final void a()
        {
            a.a();
        }

        public final void a(com.g.b.a.a.c c1)
        {
            a.a(c1);
        }

        public final void a(x x1, x x2)
        {
            c c1 = new c(x2);
            x2 = com.g.b.b.a((b)x1.g);
            x1 = null;
            try
            {
                x2 = com.g.b.a.b.a(((com.g.b.a.b.c) (x2)).d, ((com.g.b.a.b.c) (x2)).a, ((com.g.b.a.b.c) (x2)).b);
            }
            // Misplaced declaration of an exception variable
            catch (x x2)
            {
                com.g.b.c.a(x1);
                return;
            }
            if (x2 == null)
            {
                break MISSING_BLOCK_LABEL_55;
            }
            x1 = x2;
            c1.a(x2);
            x1 = x2;
            x2.a();
        }

        public final void b(v v1)
        {
            a.b(v1);
        }

            
            {
                a = com.g.b.c.this;
                super();
            }
    };
    public final com.g.b.a.b b;
    int c;
    int d;
    private int e;
    private int f;
    private int g;

    public com.g.b.c(File file, long l)
    {
        b = com.g.b.a.b.a(com.g.b.a.c.a.a, file, l);
    }

    static int a(e e1)
    {
        long l;
        try
        {
            l = e1.l();
            e1 = e1.p();
        }
        // Misplaced declaration of an exception variable
        catch (e e1)
        {
            throw new IOException(e1.getMessage());
        }
        if (l < 0L || l > 0x7fffffffL)
        {
            break MISSING_BLOCK_LABEL_35;
        }
        if (e1.isEmpty())
        {
            break MISSING_BLOCK_LABEL_81;
        }
        throw new IOException((new StringBuilder("expected an int but was \"")).append(l).append(e1).append("\"").toString());
        return (int)l;
    }

    static void a(com.g.b.a.b.a a1)
    {
        if (a1 == null)
        {
            break MISSING_BLOCK_LABEL_8;
        }
        a1.b();
        return;
        a1;
    }

    private static String c(v v1)
    {
        return k.b(v1.a.toString());
    }

    final com.g.b.a.a.b a(x x1)
    {
label0:
        {
            {
                Object obj = x1.a.b;
                if (!h.a(x1.a.b))
                {
                    break label0;
                }
                IOException ioexception;
                try
                {
                    b(x1.a);
                }
                // Misplaced declaration of an exception variable
                catch (x x1)
                {
                    return null;
                }
            }
            return null;
        }
        if (!((String) (obj)).equals("GET") || j.b(x1))
        {
            break MISSING_BLOCK_LABEL_29;
        }
        obj = new c(x1);
        x1 = b.a(c(x1.a), -1L);
        if (x1 == null)
        {
            break MISSING_BLOCK_LABEL_29;
        }
        ((c) (obj)).a(x1);
        obj = new a(x1);
        return ((com.g.b.a.a.b) (obj));
        x1;
        x1 = null;
_L2:
        a(((com.g.b.a.b.a) (x1)));
        return null;
        ioexception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    final x a(v v1)
    {
        boolean flag1 = false;
        Object obj = c(v1);
        c c1;
        String s;
        String s1;
        Object obj1;
        x.a a1;
        boolean flag;
        try
        {
            obj = b.a(((String) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (v v1)
        {
            return null;
        }
        if (obj == null)
        {
            return null;
        }
        try
        {
            c1 = new c(((com.g.b.a.b.c) (obj)).c[0]);
        }
        // Misplaced declaration of an exception variable
        catch (v v1)
        {
            k.a(((java.io.Closeable) (obj)));
            return null;
        }
        s = c1.g.a("Content-Type");
        s1 = c1.g.a("Content-Length");
        obj1 = (new v.a()).a(c1.a).a(c1.c, null);
        obj1.c = c1.b.a();
        obj1 = ((v.a) (obj1)).a();
        a1 = new x.a();
        a1.a = ((v) (obj1));
        a1.b = c1.d;
        a1.c = c1.e;
        a1.d = c1.f;
        obj1 = a1.a(c1.g);
        obj1.g = new b(((com.g.b.a.b.c) (obj)), s, s1);
        obj1.e = c1.h;
        obj = ((x.a) (obj1)).a();
        flag = flag1;
        if (c1.a.equals(v1.a.toString()))
        {
            flag = flag1;
            if (c1.c.equals(v1.b))
            {
                flag = flag1;
                if (j.a(((x) (obj)), c1.b, v1))
                {
                    flag = true;
                }
            }
        }
        if (!flag)
        {
            k.a(((x) (obj)).g);
            return null;
        } else
        {
            return ((x) (obj));
        }
    }

    final void a()
    {
        this;
        JVM INSTR monitorenter ;
        f = f + 1;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    final void a(com.g.b.a.a.c c1)
    {
        this;
        JVM INSTR monitorenter ;
        g = g + 1;
        if (c1.a == null) goto _L2; else goto _L1
_L1:
        e = e + 1;
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (c1.b != null)
        {
            f = f + 1;
        }
        if (true) goto _L4; else goto _L3
_L3:
        c1;
        throw c1;
    }

    final void b(v v1)
    {
        b.b(c(v1));
    }

    // Unreferenced inner class com/g/b/c$a$1

/* anonymous class */
    final class a._cls1 extends c.h
    {

        final com.g.b.c a;
        final com.g.b.a.b.a b;
        final a c;

        public final void close()
        {
label0:
            {
                synchronized (c.b)
                {
                    if (!c.a)
                    {
                        break label0;
                    }
                }
                return;
            }
            c.a = true;
            com.g.b.c c2 = c.b;
            c2.c = c2.c + 1;
            c1;
            JVM INSTR monitorexit ;
            super.close();
            b.a();
            return;
            exception;
            c1;
            JVM INSTR monitorexit ;
            throw exception;
        }

            
            {
                c = a1;
                a = c1;
                b = a2;
                super(r);
            }
    }


    // Unreferenced inner class com/g/b/c$b$1

/* anonymous class */
    final class b._cls1 extends i
    {

        final com.g.b.a.b.c a;
        final b b;

        public final void close()
        {
            a.close();
            super.close();
        }

            
            {
                b = b1;
                a = c1;
                super(s);
            }
    }

}
