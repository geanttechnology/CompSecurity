// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.coupons.handler;

import com.target.mothership.model.b;
import com.target.mothership.model.common.a.c;
import com.target.mothership.model.coupons.a.j;
import com.target.mothership.model.coupons.a.l;
import com.target.mothership.model.coupons.interfaces.RegisteredPhone;
import com.target.mothership.model.d;
import com.target.mothership.services.x;

// Referenced classes of package com.target.mothership.model.coupons.handler:
//            TGTRegisteredPhone

public class h extends b
{

    private c mErrorCode;
    private String mPhoneNumber;

    public h(String s, d d)
    {
        super(d);
        mPhoneNumber = s;
    }

    protected RegisteredPhone a(com.target.mothership.services.b.a.b.h h1)
    {
        h1 = new TGTRegisteredPhone();
        h1.a(mPhoneNumber);
        return h1;
    }

    protected Object a(x x)
    {
        return b(x);
    }

    protected volatile Object a(Object obj)
    {
        return a((com.target.mothership.services.b.a.b.h)obj);
    }

    protected com.target.mothership.model.coupons.interfaces.a.d b(x x)
    {
        return (new j()).a(x);
    }

    protected boolean b(com.target.mothership.services.b.a.b.h h1)
    {
        String s1 = "";
        String s = s1;
        if (h1 != null)
        {
            s = s1;
            if (h1.a())
            {
                s = h1.b();
            }
        }
        h1 = new l(s);
        if (h1.a())
        {
            mErrorCode = h1.b();
            return false;
        } else
        {
            return true;
        }
    }

    protected com.target.mothership.model.coupons.interfaces.a.d c(com.target.mothership.services.b.a.b.h h1)
    {
        return (new j()).a(mErrorCode);
    }

    protected volatile Object c(Object obj)
    {
        return c((com.target.mothership.services.b.a.b.h)obj);
    }

    protected boolean e(Object obj)
    {
        return b((com.target.mothership.services.b.a.b.h)obj);
    }
}
