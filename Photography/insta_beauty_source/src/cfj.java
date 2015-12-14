// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


class cfj
    implements Runnable
{

    final cfi a;
    private Runnable b;
    private cfi c;

    public cfj(cfi cfi1, Runnable runnable, cfi cfi2)
    {
        a = cfi1;
        super();
        b = runnable;
        c = cfi2;
    }

    public void run()
    {
        b.run();
        c.b(b);
    }
}
