// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class all
    implements Runnable
{

    private bhv a;
    private ali b;

    all(ali ali1, bhv bhv1)
    {
        b = ali1;
        a = bhv1;
        super();
    }

    public final void run()
    {
        java.util.List list = b.d.a();
        if (a != null)
        {
            a.a(null, list);
        }
    }
}
