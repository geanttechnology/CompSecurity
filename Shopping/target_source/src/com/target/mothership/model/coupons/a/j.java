// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.coupons.a;

import com.target.mothership.model.common.a.c;
import com.target.mothership.model.common.a.g;
import com.target.mothership.model.coupons.interfaces.a.d;
import com.target.mothership.services.x;
import com.target.mothership.util.f;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.target.mothership.model.coupons.a:
//            h

public class j
    implements g
{

    public j()
    {
    }

    private d a(c c, x x1)
    {
        d d1 = new d();
        com.target.mothership.model.coupons.interfaces.a.d.a a1 = (com.target.mothership.model.coupons.interfaces.a.d.a)f.a(d1, c);
        c = a1;
        if (a1 == null)
        {
            c = com.target.mothership.model.coupons.interfaces.a.d.a.COUPON_ERR_UNKNOWN;
        }
        d1.a(x1);
        d1.a(c);
        x1 = new ArrayList(1);
        x1.add(c);
        d1.a(x1);
        return d1;
    }

    public d a(c c)
    {
        return a(c, null);
    }

    public d a(x x1)
    {
        return a((new h()).a(x1), x1);
    }

    public volatile Object a(Object obj)
    {
        return a((x)obj);
    }
}
