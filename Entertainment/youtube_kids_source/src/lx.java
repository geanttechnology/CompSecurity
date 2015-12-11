// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class lx
    implements Runnable
{

    private final me a;
    private final mi b;
    private final Runnable c;

    public lx(ml ml, me me1, mi mi1, Runnable runnable)
    {
        a = me1;
        b = mi1;
        c = runnable;
    }

    public final void run()
    {
        if (a.f)
        {
            a.b("canceled-at-delivery");
        } else
        {
            boolean flag;
            if (b.c == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                a.a(b.a);
            } else
            {
                a.b(b.c);
            }
            if (b.d)
            {
                a.a("intermediate-response");
            } else
            {
                a.b("done");
            }
            if (c != null)
            {
                c.run();
                return;
            }
        }
    }
}
