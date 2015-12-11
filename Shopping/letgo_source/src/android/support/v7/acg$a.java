// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;


// Referenced classes of package android.support.v7:
//            acg, aaz, abo, vn

class a
    implements a
{

    final acg a;

    public void a(aaz aaz1)
    {
        acg.a(a, aaz1.a());
    }

    public void b(aaz aaz1)
    {
        acg.a(a, aaz1.a());
        abo.d((new StringBuilder()).append("Permanent failure dispatching hitId: ").append(aaz1.a()).toString());
    }

    public void c(aaz aaz1)
    {
        long l = aaz1.b();
        if (l == 0L)
        {
            acg.a(a, aaz1.a(), acg.a(a).a());
        } else
        if (l + 0xdbba00L < acg.a(a).a())
        {
            acg.a(a, aaz1.a());
            abo.d((new StringBuilder()).append("Giving up on failed hitId: ").append(aaz1.a()).toString());
            return;
        }
    }

    (acg acg1)
    {
        a = acg1;
        super();
    }
}
