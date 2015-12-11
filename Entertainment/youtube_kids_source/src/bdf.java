// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class bdf
    implements Runnable
{

    private bde a;

    bdf(bde bde1)
    {
        a = bde1;
        super();
    }

    public final void run()
    {
        try
        {
            a.b = att.a(a.a).a;
            return;
        }
        catch (Exception exception)
        {
            bmo.a("Failed to get advertising id", exception);
        }
    }
}
