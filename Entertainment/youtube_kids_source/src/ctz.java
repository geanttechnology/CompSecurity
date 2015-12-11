// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class ctz
    implements Runnable
{

    private bhv a;
    private bxb b;

    ctz(ctx ctx, bhv bhv1, bxb bxb)
    {
        a = bhv1;
        b = bxb;
        super();
    }

    public final void run()
    {
        a.a(null, b);
    }
}
