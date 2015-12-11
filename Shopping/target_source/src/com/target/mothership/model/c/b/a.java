// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.c.b;

import com.google.a.a.e;
import com.target.mothership.model.b;
import com.target.mothership.model.d;
import com.target.mothership.services.x;

// Referenced classes of package com.target.mothership.model.c.b:
//            b

public class a extends b
{

    public static final String DEFAULT_COUNTRY = "United States";

    public a(d d1)
    {
        super(d1);
    }

    protected com.target.mothership.model.c.c.a a(com.target.mothership.services.apigee.h.b.a a1)
    {
        Object obj = null;
        com.target.mothership.model.c.b.b b1 = obj;
        if (a1.a() != null)
        {
            b1 = obj;
            if (a1.a().a() != null)
            {
                b1 = obj;
                if (a1.a().a().a() != null)
                {
                    b1 = new com.target.mothership.model.c.b.b();
                    b1.a(a1.a().a().a().a());
                    b1.b(a1.a().a().a().b());
                    b1.c(a1.a().a().a().c());
                    b1.a(a1.a().a().a().d());
                    b1.b(a1.a().a().a().e());
                }
            }
        }
        return b1;
    }

    protected Object a(x x)
    {
        return b(x);
    }

    protected volatile Object a(Object obj)
    {
        return a((com.target.mothership.services.apigee.h.b.a)obj);
    }

    protected boolean a(com.target.mothership.model.c.c.a a1)
    {
        return a1 != null && a1.c().b() && ((String)a1.c().c()).equals("United States");
    }

    protected com.target.mothership.model.c.c.a.a b(com.target.mothership.model.c.c.a a1)
    {
        return (new com.target.mothership.model.c.a.a()).a(a1);
    }

    protected com.target.mothership.model.c.c.a.a b(x x)
    {
        return (new com.target.mothership.model.c.a.a()).a(x);
    }

    protected volatile Object b(Object obj)
    {
        return b((com.target.mothership.model.c.c.a)obj);
    }

    protected boolean d(Object obj)
    {
        return a((com.target.mothership.model.c.c.a)obj);
    }
}
