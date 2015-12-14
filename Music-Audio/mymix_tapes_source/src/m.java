// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.nuance.nmdp.speechkit.recognitionresult.b;
import java.util.List;

public final class m
{

    private g a;
    private df b;
    private cd c;
    private ce d;
    private ce e;
    private bi f;
    private bi g;
    private final dh h = new dh() {

        private m a;

        public final void a()
        {
            com.nuance.nmdp.speechkit.recognitionresult.b.a(a, "Shutdown Complte");
        }

        public final void a(String s)
        {
            synchronized (m.b(a))
            {
                com.nuance.nmdp.speechkit.recognitionresult.b.a(a, (new StringBuilder()).append("Connected with session ID ").append(s).toString());
                m.a(a, s);
            }
        }

        public final void a(short word0)
        {
            com.nuance.nmdp.speechkit.recognitionresult.b.b(a, (new StringBuilder()).append("Connection failed reasonCode [").append(word0).append("]").toString());
        }

        public final void b(short word0)
        {
            com.nuance.nmdp.speechkit.recognitionresult.b.a(a, (new StringBuilder()).append("Disconnected reasoncode [").append(word0).append("]").toString());
        }

            
            {
                a = m.this;
                super();
            }
    };
    private k i;
    private String j;
    private boolean k;
    private final Object l = new Object();

    public m(k k1)
    {
        c = null;
        d = null;
        e = null;
        i = k1;
        a = null;
        j = null;
        k = true;
        f = i.r();
        g = i.s();
        b = e();
        if (b == null)
        {
            k = false;
            i = null;
        } else
        {
            c = b.a();
            if (c != null)
            {
                try
                {
                    k1 = c.c("SpeechKit");
                    k1.a("Version", "1.6.0.0B06");
                    k1.a("DnsAddress", i.d());
                    d = k1.a();
                    k1 = d.a("SpeechKit App");
                    k1.a("Version", i.e());
                    e = k1.a();
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (k k1)
                {
                    com.nuance.nmdp.speechkit.recognitionresult.b.b(this, "Application Session is already open");
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (k k1)
                {
                    com.nuance.nmdp.speechkit.recognitionresult.b.b(this, "Session event already committed");
                }
                return;
            }
        }
    }

    static String a(m m1, String s)
    {
        m1.j = s;
        return s;
    }

    static void a(m m1)
    {
        com.nuance.nmdp.speechkit.recognitionresult.b.b(m1, "Restarting NMSP manager");
        m1.f = m1.i.r();
        m1.g = m1.i.s();
        m1.a = null;
        m1.b.b_();
        m1.b = m1.e();
        if (m1.b == null)
        {
            m1.i = null;
            m1.k = false;
        }
    }

    static void a(m m1, g g1)
    {
        if (g1 == m1.a)
        {
            m1.a = null;
        }
    }

    static Object b(m m1)
    {
        return m1.l;
    }

    private df e()
    {
        short word0;
        Object obj;
        String s;
        ay ay1;
        boolean flag;
        try
        {
            word0 = (short)i.f();
            obj = i.d();
            s = i.t();
            flag = i.h();
            ay1 = new ay();
            ay1.a(new cz("Android_Context", i.a(), cz.a.a));
        }
        catch (Throwable throwable)
        {
            com.nuance.nmdp.speechkit.recognitionresult.b.a(this, "Unable to create NMSP manager", throwable);
            return null;
        }
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_92;
        }
        ay1.a(new cz("SocketConnectionSetting", s.getBytes(), cz.a.a));
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_119;
        }
        ay1.a(new cz("SSL_Socket_Enable", "TRUE".getBytes(), cz.a.a));
        ay1.a(new cz("Calllog_Disable", "TRUE".getBytes(), cz.a.a));
        obj = dg.a(((String) (obj)), word0, i.b(), i.c(), i.p(), g, f, "calllog.data", ay1.f(), h);
        return ((df) (obj));
    }

    private void f()
    {
        bi bi = i.r();
        bi bi1 = i.s();
        if (f != bi || g != bi1)
        {
            com.nuance.nmdp.speechkit.recognitionresult.b.b(this, "Supported codecs changed, restarting NMSP manager");
            a = null;
            f = bi;
            g = bi1;
            b.b_();
            b = e();
            if (b == null)
            {
                i = null;
                k = false;
            }
        }
    }

    public final g a(h h1)
    {
        while (!k || a != null) 
        {
            return null;
        }
        f();
        h1 = new h(h1) {

            private h a;
            private m b;

            public final void a(g g1)
            {
                m.a(b, g1);
                a.a(g1);
            }

            public final void a(g g1, int i1, String s, String s1)
            {
                a.a(g1, i1, s, s1);
                if (i1 == 1)
                {
                    m.a(b);
                }
            }

            
            {
                b = m.this;
                a = h1;
                super();
            }
        };
        h1 = new v(b, i, h1);
        a = h1;
        return h1;
    }

    public final g a(String s, String s1, String s2, boolean flag, aq aq)
    {
        if (!k)
        {
            return null;
        }
        if (a != null)
        {
            a.b();
        }
        f();
        df df1 = b;
        k k1 = i;
        bi bi = f;
        s = new au(df1, k1, s, s1, s2, flag, new aq(aq) {

            private aq a;
            private m b;

            public final void a(g g1)
            {
                m.a(b, g1);
                a.a(g1);
            }

            public final void a(g g1, int i1, String s3, String s4)
            {
                a.a(g1, i1, s3, s4);
                if (i1 == 1)
                {
                    m.a(b);
                }
            }

            public final void b(g g1)
            {
                a.b(g1);
            }

            
            {
                b = m.this;
                a = aq1;
                super();
            }
        });
        a = s;
        return s;
    }

    public final g a(String s, List list, bf bf, h h1)
    {
        if (!k)
        {
            return null;
        }
        if (a != null)
        {
            a.b();
        }
        f();
        s = new p(b, i, s, list, bf, new h(h1) {

            private h a;
            private m b;

            public final void a(g g1)
            {
                m.a(b, g1);
                a.a(g1);
            }

            public final void a(g g1, int i1, String s1, String s2)
            {
                a.a(g1, i1, s1, s2);
                if (i1 == 1)
                {
                    m.a(b);
                }
            }

            
            {
                b = m.this;
                a = h1;
                super();
            }
        });
        a = s;
        return s;
    }

    public final g a(List list, String s, bf bf, h h1)
    {
        if (!k)
        {
            return null;
        }
        if (a != null)
        {
            a.b();
        }
        f();
        list = new u(b, i, list, s, bf, new h(h1) {

            private h a;
            private m b;

            public final void a(g g1)
            {
                m.a(b, g1);
                a.a(g1);
            }

            public final void a(g g1, int i1, String s1, String s2)
            {
                a.a(g1, i1, s1, s2);
                if (i1 == 1)
                {
                    m.a(b);
                }
            }

            
            {
                b = m.this;
                a = h1;
                super();
            }
        });
        a = list;
        return list;
    }

    public final z a(String s, String s1, com.nuance.nmdp.speechkit.util.pdx.PdxValue.Dictionary dictionary, bf bf, ac ac, aa aa)
    {
        if (!k)
        {
            return null;
        }
        if (a != null)
        {
            a.b();
        }
        f();
        s = new an(b, i, s, s1, dictionary, bf, ac, new aa(aa) {

            private aa a;
            private m b;

            public final void a(g g1)
            {
                m.a(b, g1);
                a.a(g1);
            }

            public final void a(g g1, int i1, String s2, String s3)
            {
                a.a(g1, i1, s2, s3);
                if (i1 == 1)
                {
                    m.a(b);
                }
            }

            public final void b(g g1)
            {
                a.b(g1);
            }

            public final void c(g g1)
            {
                a.c(g1);
            }

            public final void d(g g1)
            {
                a.d(g1);
            }

            
            {
                b = m.this;
                a = aa1;
                super();
            }
        });
        a = s;
        return s;
    }

    public final z a(String s, boolean flag, boolean flag1, String s1, ba ba, ba ba1, ba ba2, 
            ba ba3, bf bf, ac ac, aa aa)
    {
        if (!k)
        {
            return null;
        }
        if (a != null)
        {
            a.b();
        }
        f();
        s = new am(b, i, s, flag, flag1, s1, null, ba, ba1, ba2, ba3, bf, ac, new aa(aa) {

            private aa a;
            private m b;

            public final void a(g g1)
            {
                m.a(b, g1);
                a.a(g1);
            }

            public final void a(g g1, int i1, String s2, String s3)
            {
                a.a(g1, i1, s2, s3);
                if (i1 == 1)
                {
                    m.a(b);
                }
            }

            public final void b(g g1)
            {
                a.b(g1);
            }

            public final void c(g g1)
            {
                a.c(g1);
            }

            public final void d(g g1)
            {
                a.d(g1);
            }

            
            {
                b = m.this;
                a = aa1;
                super();
            }
        });
        a = s;
        return s;
    }

    public final z a(String s, boolean flag, boolean flag1, String s1, com.nuance.nmdp.speechkit.util.pdx.PdxValue.Sequence sequence, ba ba, ba ba1, 
            ba ba2, ba ba3, bf bf, ac ac, aa aa)
    {
        if (!k)
        {
            return null;
        }
        if (a != null)
        {
            a.b();
        }
        f();
        s = new am(b, i, s, flag, flag1, s1, sequence, ba, ba1, ba2, ba3, bf, ac, new aa(aa) {

            private aa a;
            private m b;

            public final void a(g g1)
            {
                m.a(b, g1);
                a.a(g1);
            }

            public final void a(g g1, int i1, String s2, String s3)
            {
                a.a(g1, i1, s2, s3);
                if (i1 == 1)
                {
                    m.a(b);
                }
            }

            public final void b(g g1)
            {
                a.b(g1);
            }

            public final void c(g g1)
            {
                a.c(g1);
            }

            public final void d(g g1)
            {
                a.d(g1);
            }

            
            {
                b = m.this;
                a = aa1;
                super();
            }
        });
        a = s;
        return s;
    }

    public final z a(String s, boolean flag, boolean flag1, String s1, String s2, com.nuance.nmdp.speechkit.util.pdx.PdxValue.Dictionary dictionary, ba ba, 
            ba ba1, ba ba2, ba ba3, bf bf, ac ac, aa aa)
    {
        if (!k)
        {
            return null;
        }
        if (a != null)
        {
            a.b();
        }
        f();
        s = new al(b, i, s, flag, flag1, s1, s2, dictionary, ba, ba1, ba2, ba3, bf, ac, new aa(aa) {

            private aa a;
            private m b;

            public final void a(g g1)
            {
                m.a(b, g1);
                a.a(g1);
            }

            public final void a(g g1, int i1, String s3, String s4)
            {
                a.a(g1, i1, s3, s4);
                if (i1 == 1)
                {
                    m.a(b);
                }
            }

            public final void b(g g1)
            {
                a.b(g1);
            }

            public final void c(g g1)
            {
                a.c(g1);
            }

            public final void d(g g1)
            {
                a.d(g1);
            }

            
            {
                b = m.this;
                a = aa1;
                super();
            }
        });
        a = s;
        return s;
    }

    public final void a()
    {
        k = false;
        if (a != null)
        {
            a.b();
            a = null;
        }
        if (b != null)
        {
            b.b_();
            b = null;
        }
        i = null;
    }

    public final void a(String s, String s1)
    {
        cg cg1;
        if (e == null)
        {
            break MISSING_BLOCK_LABEL_81;
        }
        cg1 = e.a("SK App Log");
        cg1.a(s, s1);
        synchronized (l)
        {
            if (j != null)
            {
                cg1.a("SessionId", j);
            }
        }
        try
        {
            cg1.a();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            com.nuance.nmdp.speechkit.recognitionresult.b.b(this, "Application Session is already committed");
        }
        break MISSING_BLOCK_LABEL_80;
        s1;
        s;
        JVM INSTR monitorexit ;
        throw s1;
        return;
        com.nuance.nmdp.speechkit.recognitionresult.b.b(this, "Application log attempt is ignored. Call logging is not active.");
        return;
    }

    public final boolean b()
    {
        return k;
    }

    public final String c()
    {
        String s;
        synchronized (l)
        {
            s = j;
        }
        return s;
    }

    public final void d()
    {
        if (a != null)
        {
            a.b();
            a = null;
        }
    }
}
