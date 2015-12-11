// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.List;

final class cxg
    implements cxm
{

    private cxf a;

    cxg(cxf cxf1)
    {
        a = cxf1;
        super();
    }

    public final void a()
    {
        a.c = true;
        a.a.d(new cta(a.c));
    }

    public final void a(cxu cxu)
    {
        a.d = cxu;
        a.a.c(new csz(a.d));
    }

    public final void a(List list)
    {
        if (a.e != null)
        {
            a.e.a(null, list);
            a.e = null;
        }
    }

    public final void b()
    {
        a.c = false;
        a.a.d(new cta(a.c));
    }

    public final void c()
    {
        if (a.e != null)
        {
            a.e.a(null, null);
            a.e = null;
        }
    }
}
