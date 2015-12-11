// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;


// Referenced classes of package jumiomobile:
//            dm, fl, dy

class ds
    implements Runnable
{

    final dm a;

    ds(dm dm1)
    {
        a = dm1;
        super();
    }

    public void run()
    {
        a.A.showBranding(a.o.h());
    }
}
