// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class bmm
    implements Runnable
{

    private Runnable a;
    private bml b;

    bmm(bml bml1, Runnable runnable)
    {
        b = bml1;
        a = runnable;
        super();
    }

    public final void run()
    {
        try
        {
            b.a();
            if (bml.b() && a != null)
            {
                a.run();
            }
            return;
        }
        catch (IllegalStateException illegalstateexception)
        {
            bmo.a("GooglePlayProviderInstaller failed.", illegalstateexception);
        }
    }
}
