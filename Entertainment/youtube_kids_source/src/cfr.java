// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class cfr
    implements Runnable
{

    private cfm a;

    cfr(cfm cfm1)
    {
        a = cfm1;
        super();
    }

    public final void run()
    {
        cfm.f(a);
    }
}
