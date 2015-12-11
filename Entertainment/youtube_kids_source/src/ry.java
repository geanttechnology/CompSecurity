// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class ry
    implements Runnable
{

    private rx a;

    ry(rx rx1)
    {
        a = rx1;
        super();
    }

    public final void run()
    {
        a.f.a();
        a.c.a();
        if (a.g != null)
        {
            a.g.j();
        }
    }
}
