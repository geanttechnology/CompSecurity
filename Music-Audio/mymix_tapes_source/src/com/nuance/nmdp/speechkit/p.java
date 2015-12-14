// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmdp.speechkit;

import aa;
import ac;
import ba;
import bf;
import com.nuance.nmdp.speechkit.recognitionresult.b;
import g;
import m;
import z;

// Referenced classes of package com.nuance.nmdp.speechkit:
//            v, Prompt, SpeechError

abstract class p
{

    private final m a;
    private final boolean b;
    private final boolean c;
    private final String d;
    private final ac e;
    private final aa f = new aa() {

        private p a;

        public final void a(g g1)
        {
            if (p.a(a) == g1)
            {
                com.nuance.nmdp.speechkit.p.b(a);
            }
        }

        public final void a(g g1, int i1, String s2, String s3)
        {
            if (p.a(a) == g1)
            {
                a.a(new v(i1, s2, s3));
            }
        }

        public final void b(g g1)
        {
            if (p.a(a) == g1)
            {
                a.b();
            }
        }

        public final void c(g g1)
        {
            if (p.a(a) == g1)
            {
                a.c();
            }
        }

        public final void d(g g1)
        {
            if (p.a(a) == g1)
            {
                a.a(p.c(a).b());
            }
        }

            
            {
                a = p.this;
                super();
            }
    };
    private z g;
    private bf h;
    private boolean i;
    private Prompt j;
    private Prompt k;
    private Prompt l;
    private Prompt m;
    private String n;

    p(m m1, boolean flag, boolean flag1, String s, String s1, ac ac)
    {
        a = m1;
        b = flag;
        c = flag1;
        d = s;
        e = ac;
        i = false;
        n = s1;
    }

    static z a(p p1)
    {
        return p1.g;
    }

    static z b(p p1)
    {
        p1.g = null;
        return null;
    }

    static bf c(p p1)
    {
        return p1.h;
    }

    protected abstract bf a();

    protected abstract z a(m m1, boolean flag, boolean flag1, String s, String s1, ac ac, ba ba, 
            ba ba1, ba ba2, ba ba3, bf bf, aa aa);

    public final void a(int i1, Prompt prompt)
    {
        switch (i1)
        {
        default:
            return;

        case 0: // '\0'
            j = prompt;
            return;

        case 1: // '\001'
            k = prompt;
            return;

        case 2: // '\002'
            l = prompt;
            return;

        case 3: // '\003'
            m = prompt;
            break;
        }
    }

    protected abstract void a(SpeechError speecherror);

    protected abstract void a(Object obj);

    protected abstract void b();

    protected abstract void c();

    public final void d()
    {
        if (a.b())
        {
            if (i)
            {
                return;
            }
            ba ba;
            ba ba1;
            ba ba2;
            ba ba3;
            if (j == null)
            {
                ba = null;
            } else
            {
                ba = j.a();
            }
            if (k == null)
            {
                ba1 = null;
            } else
            {
                ba1 = k.a();
            }
            if (l == null)
            {
                ba2 = null;
            } else
            {
                ba2 = l.a();
            }
            if (m == null)
            {
                ba3 = null;
            } else
            {
                ba3 = m.a();
            }
            h = a();
            g = a(a, b, c, d, n, e, ba, ba1, ba2, ba3, h, f);
            if (g == null)
            {
                com.nuance.nmdp.speechkit.recognitionresult.b.c(this, "Unable to create recognition transaction");
                a(new v(0, null, null));
                return;
            } else
            {
                i = true;
                g.a();
                return;
            }
        } else
        {
            com.nuance.nmdp.speechkit.recognitionresult.b.c(this, "Unable to create recognition transaction. Transaction runner is invalid.");
            a(new v(0, null, null));
            return;
        }
    }

    public final void e()
    {
        if (g != null)
        {
            g.a_();
        }
    }

    public final void f()
    {
        if (g != null)
        {
            g.b();
            g = null;
        }
    }
}
