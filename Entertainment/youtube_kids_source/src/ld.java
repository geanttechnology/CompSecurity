// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class ld
    implements Runnable
{

    private lb a;

    ld(lb lb1)
    {
        a = lb1;
        super();
    }

    public final void run()
    {
        lb.b(a);
    }
}
