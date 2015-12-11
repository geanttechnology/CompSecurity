// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.coupons.a;

import com.target.mothership.model.common.a.c;
import com.target.mothership.model.coupons.interfaces.a.b;
import com.target.mothership.services.x;
import com.target.mothership.util.f;

// Referenced classes of package com.target.mothership.model.coupons.a:
//            h

public class g
    implements com.target.mothership.model.common.a.g
{

    public g()
    {
    }

    private b a(c c, x x1)
    {
        b b1 = new b();
        com.target.mothership.model.coupons.interfaces.a.b.a a1 = (com.target.mothership.model.coupons.interfaces.a.b.a)f.a(b1, c);
        c = a1;
        if (a1 == null)
        {
            c = com.target.mothership.model.coupons.interfaces.a.b.a.COUPON_ERR_UNKNOWN;
        }
        b1.a(x1);
        b1.a(c);
        return b1;
    }

    public b a(c c)
    {
        return a(c, null);
    }

    public b a(x x1)
    {
        return a((new h()).a(x1), x1);
    }

    public volatile Object a(Object obj)
    {
        return a((x)obj);
    }
}
