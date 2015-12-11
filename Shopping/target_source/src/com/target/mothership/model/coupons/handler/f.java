// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.coupons.handler;

import com.target.mothership.model.coupons.a.l;
import com.target.mothership.model.d;
import com.target.mothership.services.b.a.b.c;
import com.target.mothership.services.b.a.b.e;
import com.target.mothership.services.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.mothership.model.coupons.handler:
//            d, TGTCouponOffer

public class f extends com.target.mothership.model.coupons.handler.d
{

    private com.target.mothership.model.common.a.c mErrorCode;

    public f(d d1)
    {
        super(d1);
    }

    protected Object a(x x)
    {
        return b(x);
    }

    protected volatile Object a(Object obj)
    {
        return a((e)obj);
    }

    protected List a(e e1)
    {
        ArrayList arraylist = new ArrayList();
        if (e1.c() == null || e1.c().isEmpty())
        {
            return arraylist;
        }
        TGTCouponOffer tgtcouponoffer;
        for (e1 = e1.c().iterator(); e1.hasNext(); arraylist.add(tgtcouponoffer))
        {
            c c1 = (c)e1.next();
            tgtcouponoffer = new TGTCouponOffer();
            a(((TGTBaseCouponOffer) (tgtcouponoffer)), ((com.target.mothership.services.b.a.b.g) (c1)));
            tgtcouponoffer.a(c1.a());
            tgtcouponoffer.c(c1.b());
        }

        return arraylist;
    }

    protected com.target.mothership.model.coupons.interfaces.a.c b(x x)
    {
        return (new com.target.mothership.model.coupons.a.f()).a(x);
    }

    protected boolean b(e e1)
    {
        String s1 = "";
        String s = s1;
        if (e1 != null)
        {
            s = s1;
            if (e1.a())
            {
                s = e1.b();
            }
        }
        e1 = new l(s);
        if (e1.a())
        {
            mErrorCode = e1.b();
            return false;
        } else
        {
            return true;
        }
    }

    protected com.target.mothership.model.coupons.interfaces.a.c c(e e1)
    {
        return (new com.target.mothership.model.coupons.a.f()).a(mErrorCode);
    }

    protected volatile Object c(Object obj)
    {
        return c((e)obj);
    }

    protected boolean e(Object obj)
    {
        return b((e)obj);
    }
}
