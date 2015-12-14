// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.nuance.nmdp.speechkit.recognitionresult.b;

public final class bd
{

    private final ba a;
    private final Object b;
    private final Object c;
    private final az d;
    private final Object e = new Object();
    private boolean f;
    private boolean g;

    public bd(ba ba1, Object obj, Object obj1, az az)
    {
        a = ba1;
        b = obj1;
        f = false;
        g = false;
        c = obj;
        d = new az(az) {

            private az a;
            private bd b;

            public final void a(Object obj2)
            {
                synchronized (bd.a(b))
                {
                    bd.b(b);
                }
                a.a(obj2);
            }

            public final void b(Object obj2)
            {
                a.b(obj2);
            }

            public final void c(Object obj2)
            {
                synchronized (bd.a(b))
                {
                    bd.b(b);
                }
                a.c(obj2);
            }

            
            {
                b = bd.this;
                a = az1;
                super();
            }
        };
    }

    static Object a(bd bd1)
    {
        return bd1.e;
    }

    static boolean b(bd bd1)
    {
        bd1.g = true;
        return true;
    }

    public final void a()
    {
        if (!f)
        {
            f = true;
            a.a(c, d, b);
            return;
        } else
        {
            com.nuance.nmdp.speechkit.recognitionresult.b.c(this, "Prompt already started");
            return;
        }
    }

    public final void b()
    {
        if (f)
        {
            synchronized (e)
            {
                if (!g)
                {
                    com.nuance.nmdp.speechkit.recognitionresult.b.a(this, "Stopping prompt");
                    g = true;
                    a.a();
                }
            }
        }
    }
}
