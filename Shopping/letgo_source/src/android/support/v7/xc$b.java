// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.google.android.gms.common.api.Status;

// Referenced classes of package android.support.v7:
//            xp, xc, xg, xa, 
//            xj, abo, xf, xd

class b extends xp
{

    final xc a;
    private final b b;

    protected b a(xa xa1)
    {
        return null;
    }

    protected void a(xg xg1)
    {
        b b1 = xg1.b();
        a.a(b1);
        if (b1.a() == Status.a && b1.b() == a.a && b1.c() != null && b1.c().length > 0)
        {
            xc.a(a).a(b1.d().d(), b1.c());
            abo.d("Resource successfully load from Network.");
            b.a(xg1);
            return;
        }
        StringBuilder stringbuilder = (new StringBuilder()).append("Response status: ");
        if (b1.a().f())
        {
            xg1 = "SUCCESS";
        } else
        {
            xg1 = "FAILURE";
        }
        abo.d(stringbuilder.append(xg1).toString());
        if (b1.a().f())
        {
            abo.d((new StringBuilder()).append("Response source: ").append(b1.b().toString()).toString());
            abo.d((new StringBuilder()).append("Response size: ").append(b1.c().length).toString());
        }
        a.a(b1.d(), b);
    }

    a(xc xc1, xf xf, xd xd, a a1)
    {
        a = xc1;
        super(xf, xd);
        b = a1;
    }
}
