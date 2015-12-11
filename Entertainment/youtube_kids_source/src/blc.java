// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public class blc extends bla
{

    public static final String b = blc.getCanonicalName();
    private final bkn c;

    public blc(bje bje1, bkn bkn1)
    {
        super(bje1);
        c = (bkn)b.a(bkn1);
        bje1.a(this);
    }

    public final boolean a()
    {
        b.b(true);
        return c.a();
    }

    public final String c()
    {
        return b;
    }

    public void handleConnectivityChangedEvent(bjv bjv1)
    {
        if (bjv1.a)
        {
            b();
        }
    }

}
