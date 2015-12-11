// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class bho extends bmr
{

    private bgv a;

    bho(bgv bgv1)
    {
        a = bgv1;
        super();
    }

    public final Object a()
    {
        bgv bgv1 = a;
        return bgv.a(Math.max(1, Runtime.getRuntime().availableProcessors() - 1), 60, 10);
    }
}
