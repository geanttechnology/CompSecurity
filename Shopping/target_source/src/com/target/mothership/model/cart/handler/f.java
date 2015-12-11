// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import com.target.mothership.common.tender.b;
import com.target.mothership.model.common.a;
import com.target.mothership.services.aa;
import com.target.mothership.services.apigee.c.b.z;
import com.target.mothership.util.c;
import com.target.mothership.util.l;
import java.math.BigDecimal;
import java.util.Currency;

// Referenced classes of package com.target.mothership.model.cart.handler:
//            TGTAppliedPaymentCardTender, TGTPaymentCardExpiration, c, TGTCartGuestAddress, 
//            TGTCartPhoneNumber

class f
    implements aa
{

    private static final int NULL_INT = -1;

    f()
    {
    }

    public TGTAppliedPaymentCardTender a(z z1)
    {
        if (z1 == null)
        {
            return null;
        }
        TGTAppliedPaymentCardTender tgtappliedpaymentcardtender = new TGTAppliedPaymentCardTender();
        tgtappliedpaymentcardtender.b(z1.a());
        tgtappliedpaymentcardtender.a(z1.h());
        Object obj;
        TGTCartPhoneNumber tgtcartphonenumber;
        if (z1.f() != null)
        {
            obj = new BigDecimal(z1.f());
        } else
        {
            obj = c.ZERO;
        }
        tgtappliedpaymentcardtender.a(((BigDecimal) (obj)));
        if (z1.g() != null)
        {
            obj = Currency.getInstance(z1.g());
        } else
        {
            obj = c.USD;
        }
        tgtappliedpaymentcardtender.a(((Currency) (obj)));
        obj = z1.i();
        tgtappliedpaymentcardtender.c(l.c(((com.target.mothership.services.apigee.c.b.z.a) (obj)).a()));
        tgtappliedpaymentcardtender.a(((com.target.mothership.services.apigee.c.b.z.a) (obj)).c());
        tgtappliedpaymentcardtender.d(((com.target.mothership.services.apigee.c.b.z.a) (obj)).b());
        tgtappliedpaymentcardtender.e(z1.b());
        if (((com.target.mothership.services.apigee.c.b.z.a) (obj)).d() != -1)
        {
            tgtappliedpaymentcardtender.a(new TGTPaymentCardExpiration(b.a(String.valueOf(((com.target.mothership.services.apigee.c.b.z.a) (obj)).d())), ((com.target.mothership.services.apigee.c.b.z.a) (obj)).e()));
        } else
        {
            tgtappliedpaymentcardtender.a(null);
        }
        obj = (new com.target.mothership.model.cart.handler.c()).a(z1.j());
        ((TGTCartGuestAddress) (obj)).a(a.Billing);
        tgtcartphonenumber = new TGTCartPhoneNumber();
        tgtcartphonenumber.a(z1.d());
        tgtcartphonenumber.a(z1.e());
        ((TGTCartGuestAddress) (obj)).a(tgtcartphonenumber);
        tgtappliedpaymentcardtender.a(((com.target.mothership.model.common.GuestAddress) (obj)));
        return tgtappliedpaymentcardtender;
    }

    public volatile Object a(Object obj)
    {
        return a((z)obj);
    }
}
