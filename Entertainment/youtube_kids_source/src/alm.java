// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


abstract class alm
    implements bhv
{

    private final Object a;
    private final bhv b;

    alm(ali ali, Object obj, bhv bhv1)
    {
        a = obj;
        b = bhv1;
    }

    public final void a(Object obj, Exception exception)
    {
        if (b != null)
        {
            b.a(a, exception);
        }
    }
}
