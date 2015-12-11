// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class chp
    implements Runnable
{

    private bhv a;
    private cho b;

    chp(cho cho1, bhv bhv1)
    {
        b = cho1;
        a = bhv1;
        super();
    }

    public final void run()
    {
        a.a(null, b.a());
    }
}
