// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;


// Referenced classes of package android.support.v7:
//            amp, amk, amj, alt, 
//            amc

class nit> extends amp
{

    final amj a;
    final amk b;

    public void onRun()
    {
        amj amj1 = amk.a(b);
        if (!a.equals(amj1))
        {
            alt.h().a("Fabric", "Asychronously getting Advertising Info and storing it to preferences");
            amk.a(b, amj1);
        }
    }

    (amk amk1, amj amj1)
    {
        b = amk1;
        a = amj1;
        super();
    }
}
