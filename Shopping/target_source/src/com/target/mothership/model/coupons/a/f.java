// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.coupons.a;

import com.target.mothership.model.common.a.g;
import com.target.mothership.model.coupons.interfaces.a.c;
import com.target.mothership.services.x;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.target.mothership.model.coupons.a:
//            h

public class f
    implements g
{

    private static final int NUM_POSSIBLE_ERROR_REASONS = 1;

    public f()
    {
    }

    private c a(com.target.mothership.model.common.a.c c1, x x1)
    {
        c c2 = new c();
        com.target.mothership.model.coupons.interfaces.a.c.a a1 = (com.target.mothership.model.coupons.interfaces.a.c.a)com.target.mothership.util.f.a(c2, c1);
        c1 = a1;
        if (a1 == null)
        {
            c1 = com.target.mothership.model.coupons.interfaces.a.c.a.COUPON_ERR_UNKNOWN;
        }
        c2.a(x1);
        x1 = new ArrayList(1);
        x1.add(c1);
        c2.a(x1);
        c2.a(c1);
        return c2;
    }

    public c a(com.target.mothership.model.common.a.c c1)
    {
        return a(c1, null);
    }

    public c a(x x1)
    {
        return a((new h()).a(x1), x1);
    }

    public volatile Object a(Object obj)
    {
        return a((x)obj);
    }
}
