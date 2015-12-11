// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;


// Referenced classes of package jumiomobile:
//            bt, bq, kj, gm, 
//            kk

class km
    implements bt
{

    final kj a;

    private km(kj kj1)
    {
        a = kj1;
        super();
    }

    km(kj kj1, kk kk)
    {
        this(kj1);
    }

    public void a(bq bq1)
    {
        bq1.setEnabled(false);
        a.b().j();
        if (a.b().i())
        {
            a.b().b(false);
        }
        bq1.setEnabled(true);
    }

    public void b(bq bq1)
    {
    }
}
