// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.google.android.gms.internal.av;
import java.lang.ref.WeakReference;

public class sk
{

    private final sl a;
    private final Runnable b;
    private av c;
    private boolean d;
    private boolean e;
    private long f;

    public sk(ahi ahi)
    {
        this(ahi, new sl(aca.a));
    }

    sk(ahi ahi, sl sl1)
    {
        d = false;
        e = false;
        f = 0L;
        a = sl1;
        b = new Runnable(ahi) {

            final ahi a;
            final sk b;
            private final WeakReference c;

            public void run()
            {
                sk.a(b, false);
                ahi ahi1 = (ahi)c.get();
                if (ahi1 != null)
                {
                    ahi1.b(sk.a(b));
                }
            }

            
            {
                b = sk.this;
                a = ahi1;
                super();
                c = new WeakReference(a);
            }
        };
    }

    static av a(sk sk1)
    {
        return sk1.c;
    }

    static boolean a(sk sk1, boolean flag)
    {
        sk1.d = flag;
        return flag;
    }

    public void a()
    {
        d = false;
        a.a(b);
    }

    public void a(av av)
    {
        a(av, 60000L);
    }

    public void a(av av, long l)
    {
        if (d)
        {
            acb.e("An ad refresh is already scheduled.");
        } else
        {
            c = av;
            d = true;
            f = l;
            if (!e)
            {
                acb.c((new StringBuilder()).append("Scheduling ad refresh ").append(l).append(" milliseconds from now.").toString());
                a.a(b, l);
                return;
            }
        }
    }

    public void b()
    {
        e = true;
        if (d)
        {
            a.a(b);
        }
    }

    public void c()
    {
        e = false;
        if (d)
        {
            d = false;
            a(c, f);
        }
    }

    public boolean d()
    {
        return d;
    }
}
