// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmdp.speechkit;

import bf;
import com.nuance.nmdp.speechkit.recognitionresult.b;
import g;
import h;
import java.util.List;
import m;

// Referenced classes of package com.nuance.nmdp.speechkit:
//            v, SpeechError

abstract class a
{

    private final m a;
    private final String b;
    private bf c;
    private final List d;
    private boolean e;
    private final h f = new h() {

        private a a;

        public final void a(g g1)
        {
            if (a.a(a) == g1)
            {
                if (com.nuance.nmdp.speechkit.a.b(a) != null)
                {
                    a.a(com.nuance.nmdp.speechkit.a.b(a).b());
                } else
                {
                    a.a(null);
                }
                a.c(a);
            }
        }

        public final void a(g g1, int i, String s1, String s2)
        {
            if (a.a(a) == g1)
            {
                a.a(new v(i, s1, s2));
            }
        }

            
            {
                a = a.this;
                super();
            }
    };
    private g g;

    a(m m1, String s, List list)
    {
        a = m1;
        b = s;
        d = list;
        e = false;
    }

    static g a(a a1)
    {
        return a1.g;
    }

    static bf b(a a1)
    {
        return a1.c;
    }

    static g c(a a1)
    {
        a1.g = null;
        return null;
    }

    protected abstract bf a();

    protected abstract g a(m m1, String s, List list, bf bf, h h);

    protected abstract void a(SpeechError speecherror);

    protected abstract void a(Object obj);

    public final void b()
    {
        if (a.b())
        {
            if (e)
            {
                return;
            }
            c = a();
            g = a(a, b, d, c, f);
            if (g == null)
            {
                com.nuance.nmdp.speechkit.recognitionresult.b.c(this, "Unable to create command transaction");
                a(new v(0, null, null));
                return;
            } else
            {
                e = true;
                g.a();
                return;
            }
        } else
        {
            com.nuance.nmdp.speechkit.recognitionresult.b.c(this, "Unable to create command transaction. Transaction runner is invalid.");
            a(new v(0, null, null));
            return;
        }
    }

    public final void c()
    {
        if (g != null)
        {
            g.b();
            g = null;
        }
    }
}
