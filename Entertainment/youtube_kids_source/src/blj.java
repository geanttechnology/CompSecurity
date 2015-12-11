// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class blj
    implements Runnable
{

    private blf a;

    blj(blf blf1)
    {
        a = blf1;
        super();
    }

    public final void run()
    {
        blf.b(a);
    }
}
