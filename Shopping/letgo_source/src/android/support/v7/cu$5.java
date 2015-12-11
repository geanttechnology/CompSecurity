// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;


// Referenced classes of package android.support.v7:
//            ct, cu, cp

class b
    implements ct
{

    final cp a;
    final ct b;
    final cu c;

    public cu a(cu cu1)
    {
        if (a != null && a.a())
        {
            return cu.h();
        }
        if (cu1.d())
        {
            return cu.a(cu1.f());
        }
        if (cu1.c())
        {
            return cu.h();
        } else
        {
            return cu1.b(b);
        }
    }

    public Object then(cu cu1)
        throws Exception
    {
        return a(cu1);
    }

    (cu cu1, cp cp1, ct ct1)
    {
        c = cu1;
        a = cp1;
        b = ct1;
        super();
    }
}
