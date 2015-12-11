// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class cua
    implements Runnable
{

    private bhv a;
    private Exception b;

    cua(ctx ctx, bhv bhv1, Exception exception)
    {
        a = bhv1;
        b = exception;
        super();
    }

    public final void run()
    {
        a.a(null, b);
    }
}
