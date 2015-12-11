// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class anx
    implements Runnable
{

    private anz a;
    private anw b;

    anx(anw anw1, anz anz)
    {
        b = anw1;
        a = anz;
        super();
    }

    public final void run()
    {
        b.c.a(a);
    }
}
