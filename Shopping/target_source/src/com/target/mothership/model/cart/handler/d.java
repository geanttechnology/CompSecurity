// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import com.target.mothership.services.aa;
import com.target.mothership.services.apigee.c.b.z;
import com.target.mothership.util.c;
import com.target.mothership.util.l;
import java.math.BigDecimal;
import java.util.Currency;

// Referenced classes of package com.target.mothership.model.cart.handler:
//            TGTAppliedGiftCardTender

class d
    implements aa
{

    d()
    {
    }

    public TGTAppliedGiftCardTender a(z z1)
    {
        TGTAppliedGiftCardTender tgtappliedgiftcardtender = new TGTAppliedGiftCardTender();
        tgtappliedgiftcardtender.c(z1.a());
        tgtappliedgiftcardtender.b(z1.h());
        Object obj;
        if (z1.f() != null)
        {
            obj = new BigDecimal(z1.f());
        } else
        {
            obj = c.ZERO;
        }
        tgtappliedgiftcardtender.b(((BigDecimal) (obj)));
        if (z1.g() != null)
        {
            obj = Currency.getInstance(z1.g());
        } else
        {
            obj = c.USD;
        }
        tgtappliedgiftcardtender.a(((Currency) (obj)));
        z1 = z1.i();
        tgtappliedgiftcardtender.a(l.c(z1.a()));
        tgtappliedgiftcardtender.a(z1.f());
        return tgtappliedgiftcardtender;
    }

    public volatile Object a(Object obj)
    {
        return a((z)obj);
    }
}
