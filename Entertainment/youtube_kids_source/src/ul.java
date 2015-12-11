// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class ul
    implements Runnable
{

    private bxb a;
    private uk b;

    ul(uk uk1, bxb bxb)
    {
        b = uk1;
        a = bxb;
        super();
    }

    public final void run()
    {
        if (b.a)
        {
            return;
        } else
        {
            b.c.a(a);
            return;
        }
    }
}
