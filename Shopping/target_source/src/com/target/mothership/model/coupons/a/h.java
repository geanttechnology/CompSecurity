// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.coupons.a;

import com.target.mothership.model.common.a.c;
import com.target.mothership.model.common.a.e;
import com.target.mothership.services.x;
import com.target.mothership.services.z;

// Referenced classes of package com.target.mothership.model.coupons.a:
//            i

public class h
    implements e
{

    public h()
    {
    }

    public c a(x x1)
    {
        x1 = x1.b();
        if (x1.equals(z.FORBIDDEN))
        {
            return i.a(com.target.mothership.model.coupons.handler.e.AUTH_FAILURE);
        }
        if (x1.equals(z.BAD_REQUEST))
        {
            return i.a(com.target.mothership.model.coupons.handler.e.BAD_CREDENTIALS);
        }
        if (x1.equals(z.INTERNAL_SERVER_ERROR))
        {
            return i.a(com.target.mothership.model.coupons.handler.e.SERVER_ERROR);
        }
        if (x1.equals(z.SERVICE_UNAVAILABLE))
        {
            return i.a(com.target.mothership.model.coupons.handler.e.UNSUPPORTED);
        } else
        {
            return i.DEFAULT_ERROR_CODE;
        }
    }

    public volatile Object a(Object obj)
    {
        return a((x)obj);
    }
}
