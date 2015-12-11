// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class bic
    implements Runnable
{

    bhv a;
    Object b;
    Object c;
    Exception d;
    boolean e;

    bic()
    {
    }

    public final void run()
    {
        if (e)
        {
            a.a(b, c);
        } else
        {
            a.a(b, d);
        }
        a = null;
        b = null;
        c = null;
        d = null;
        e = false;
        bib.a(this);
    }
}
