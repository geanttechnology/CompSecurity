// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.coupons.a;

import com.target.mothership.model.common.a.c;
import com.target.mothership.model.common.a.g;
import com.target.mothership.model.coupons.interfaces.a.a;
import com.target.mothership.services.x;
import com.target.mothership.util.f;

// Referenced classes of package com.target.mothership.model.coupons.a:
//            h

public class b
    implements g
{

    public b()
    {
    }

    private a a(c c, x x1)
    {
        a a2 = new a();
        com.target.mothership.model.coupons.interfaces.a.a.a a1 = (com.target.mothership.model.coupons.interfaces.a.a.a)f.a(a2, c);
        c = a1;
        if (a1 == null)
        {
            c = com.target.mothership.model.coupons.interfaces.a.a.a.COUPON_ERR_UNKNOWN;
        }
        a2.a(x1);
        a2.a(c);
        return a2;
    }

    public a a(c c)
    {
        return a(c, null);
    }

    public a a(x x1)
    {
        return a((new h()).a(x1), x1);
    }

    public volatile Object a(Object obj)
    {
        return a((x)obj);
    }
}
