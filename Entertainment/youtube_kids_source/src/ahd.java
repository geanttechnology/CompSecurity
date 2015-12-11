// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class ahd
    implements dah
{

    private dah a;
    private agw b;

    public ahd(agw agw1, dah dah1)
    {
        b = agw1;
        super();
        a = dah1;
    }

    public final void close()
    {
        a.close();
    }

    public final exe next()
    {
        exe exe1 = a.next();
        if (exe1 != null)
        {
            exe1.a(agw.b(b));
            exe1.b(agw.b(b));
        }
        if (exe1 != null && exe1.c)
        {
            exn exn1 = exe1.d;
            exn1.a("unicorn");
            exe1.a(exn1);
        }
        return exe1;
    }
}
