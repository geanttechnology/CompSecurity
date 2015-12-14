// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.nuance.nmdp.speechkit.recognitionresult.b;

public final class au extends j
    implements g
{

    private final String e;
    private final String f;
    private final String g;
    private final az h = new az() {

        final au a;

        public final void a(Object obj)
        {
            com.nuance.nmdp.speechkit.recognitionresult.b.c(a, "Player error");
            ax.a(new Runnable(this) {

                private _cls1 a;

                public final void run()
                {
                    au.a(a.a).g();
                }

            
            {
                a = _pcls1;
                super();
            }
            });
        }

        public final void b(Object obj)
        {
            ax.a(new Runnable(this) {

                private _cls1 a;

                public final void run()
                {
                    au.a(a.a).h();
                }

            
            {
                a = _pcls1;
                super();
            }
            });
        }

        public final void c(Object obj)
        {
            ax.a(new Runnable(this) {

                private _cls1 a;

                public final void run()
                {
                    au.a(a.a).i();
                }

            
            {
                a = _pcls1;
                super();
            }
            });
        }

            
            {
                a = au.this;
                super();
            }
    };
    private bc i;

    public au(df df, k k1, String s, String s1, String s2, boolean flag, aq aq)
    {
        super(df, k1, s2, aq);
        f = s;
        if (flag)
        {
            df = "ssml";
        } else
        {
            df = "text";
        }
        g = df;
        e = s1;
        i = new bc(c, this, k1.a(), h);
        a = new as(this);
    }

    static ar a(au au1)
    {
        return (ar)au1.a;
    }

    protected final void a(cv cv1)
    {
        if (e != null)
        {
            cv1.b("tts_voice", e);
            return;
        } else
        {
            cv1.b("tts_language", b);
            return;
        }
    }

    protected final String i()
    {
        return d.z();
    }

    public final String j()
    {
        return f;
    }

    public final String k()
    {
        return g;
    }

    public final void l()
    {
        i.a();
    }

    public final void m()
    {
        i.b();
    }

    public final cx n()
    {
        return i.c();
    }
}
