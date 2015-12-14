// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.nuance.nmdp.speechkit.recognitionresult.b;

public abstract class af extends j
    implements z
{

    private final ac e;
    private final bb f = new bb() {

        final af a;

        public final void a()
        {
            ax.a(new Runnable(this) {

                private _cls1 a;

                public final void run()
                {
                    af.b(a.a).h();
                }

            
            {
                a = _pcls1;
                super();
            }
            });
        }

        public final void a(float f1)
        {
            af.a(a).a(f1);
        }

        public final void a(int i1)
        {
            ax.a(new Runnable(this, i1) {

                private int a;
                private _cls1 b;

                public final void run()
                {
                    if (a == 4)
                    {
                        com.nuance.nmdp.speechkit.recognitionresult.b.c(b.a, "Recorder error");
                        af.b(b.a).g();
                        return;
                    } else
                    {
                        af.b(b.a).i();
                        return;
                    }
                }

            
            {
                b = _pcls1;
                a = i1;
                super();
            }
            });
        }

            
            {
                a = af.this;
                super();
            }
    };
    private be g;
    private final bd h;
    private final bd i;
    private final bd j;
    private final bd k;
    private final boolean l;
    private final boolean m;
    private final bf n;
    private final az o = new az() {

        final af a;

        public final void a(Object obj)
        {
            com.nuance.nmdp.speechkit.recognitionresult.b.c(a, "Prompt error");
            ax.a(new Runnable(this) {

                private _cls2 a;

                public final void run()
                {
                    af.b(a.a).k();
                }

            
            {
                a = _pcls2;
                super();
            }
            });
        }

        public final void b(Object obj)
        {
        }

        public final void c(Object obj)
        {
            ax.a(new Runnable(this) {

                private _cls2 a;

                public final void run()
                {
                    af.b(a.a).l();
                }

            
            {
                a = _pcls2;
                super();
            }
            });
        }

            
            {
                a = af.this;
                super();
            }
    };

    public af(df df, k k1, boolean flag, boolean flag1, String s1, ba ba, ba ba1, 
            ba ba2, ba ba3, bf bf, ac ac, aa aa)
    {
        super(df, k1, s1, aa);
        n = bf;
        e = ac;
        g = null;
        l = flag;
        m = flag1;
        if (ba == null)
        {
            df = null;
        } else
        {
            df = new bd(ba, k1.a(), this, o);
        }
        h = df;
        if (ba1 == null)
        {
            df = null;
        } else
        {
            df = new bd(ba1, k1.a(), this, o);
        }
        i = df;
        if (ba2 == null)
        {
            df = null;
        } else
        {
            df = new bd(ba2, k1.a(), this, o);
        }
        j = df;
        if (ba3 == null)
        {
            df = null;
        } else
        {
            df = new bd(ba3, k1.a(), this, o);
        }
        k = df;
        a = new ad(this);
    }

    static ac a(af af1)
    {
        return af1.e;
    }

    static ab b(af af1)
    {
        return (ab)af1.a;
    }

    public final void a_()
    {
        ((ab)a).j();
    }

    final bf i()
    {
        return n;
    }

    protected abstract void j()
        throws l;

    protected abstract String k();

    protected abstract String l();

    protected abstract boolean m();

    final boolean n()
    {
        if (h == null)
        {
            return false;
        } else
        {
            h.a();
            return true;
        }
    }

    final void o()
    {
        if (h != null)
        {
            h.b();
        }
    }

    final void p()
    {
        if (i != null)
        {
            i.a();
        }
    }

    final void q()
    {
        if (j != null)
        {
            j.a();
        }
    }

    final void r()
    {
        if (k != null)
        {
            k.a();
        }
    }

    public final void s()
    {
        g = new be(c, l, m, this, d.a(), f);
    }

    public final void t()
    {
        g.a();
    }

    public final void u()
        throws l
    {
        cx cx = b(l());
        g.a(cx);
    }

    public final void v()
    {
        if (g != null)
        {
            g.b();
            g = null;
        }
    }
}
