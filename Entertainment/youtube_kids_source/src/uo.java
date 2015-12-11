// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class uo
    implements Runnable
{

    private bum a;
    private uk b;

    uo(uk uk1, bum bum1)
    {
        b = uk1;
        a = bum1;
        super();
    }

    public final void run()
    {
        if (b.a)
        {
            return;
        } else
        {
            b.c.i = a;
            b.c.s();
            b.c.q = new cto(b.c.i.d);
            return;
        }
    }
}
