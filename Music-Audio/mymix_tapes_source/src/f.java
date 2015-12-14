// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.nuance.nmdp.speechkit.recognitionresult.b;

public abstract class f extends i
{

    protected final int a;
    private final String c;
    private final String d;
    private final boolean e;

    public f(j j1, int k, String s, String s1, boolean flag)
    {
        super(j1);
        a = k;
        c = s;
        d = s1;
        e = flag;
    }

    static String a(f f1)
    {
        return f1.c;
    }

    static String b(f f1)
    {
        return f1.d;
    }

    public void a()
    {
        com.nuance.nmdp.speechkit.recognitionresult.b.a(this, (new StringBuilder()).append("Transaction error code: ").append(a).toString());
        if (c != null && c.length() > 0)
        {
            com.nuance.nmdp.speechkit.recognitionresult.b.a(this, (new StringBuilder()).append("Transaction error text: ").append(c).toString());
        }
        if (d != null && d.length() > 0)
        {
            com.nuance.nmdp.speechkit.recognitionresult.b.a(this, (new StringBuilder()).append("Transaction suggestion: ").append(d).toString());
        }
        b.e();
        h h1 = b.c();
        if (e)
        {
            h1.a(b, a, c, d);
            h1.a(b);
            return;
        } else
        {
            ax.a(new Runnable(h1) {

                private h a;
                private f b;

                public final void run()
                {
                    a.a(b.b, b.a, f.a(b), f.b(b));
                    a.a(b.b);
                }

            
            {
                b = f.this;
                a = h1;
                super();
            }
            });
            return;
        }
    }
}
