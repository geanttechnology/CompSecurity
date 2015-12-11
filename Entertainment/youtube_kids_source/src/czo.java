// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class czo
    implements Runnable
{

    private czn a;

    czo(czn czn1)
    {
        a = czn1;
        super();
    }

    public final void run()
    {
        czn czn1 = a;
        czn1.a(czn1.i);
        boolean flag;
        if (czn1.g <= czn1.e && (czn1.f > czn1.c || czn1.h > czn1.d))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            bmo.b("VideoQualityPromo triggered when criteria not met.");
            return;
        } else
        {
            czn1.a();
            czk.a(czn1.j);
            czn1.j.notifyObservers(czn1.a);
            return;
        }
    }
}
