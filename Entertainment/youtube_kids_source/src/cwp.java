// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class cwp
    implements Runnable
{

    private cse a;
    private cwo b;

    cwp(cwo cwo1, cse cse)
    {
        b = cwo1;
        a = cse;
        super();
    }

    public final void run()
    {
        b.d.b(a);
    }
}
