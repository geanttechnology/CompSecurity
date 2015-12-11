// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import com.target.mothership.common.tender.a;
import com.target.mothership.model.guest.handler.TGTAppliedPayPalDetails;
import com.target.mothership.model.guest.interfaces.AppliedPayPalDetails;
import com.target.mothership.services.aa;
import com.target.mothership.services.apigee.c.b.z;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

public class e
    implements aa
{

    public e()
    {
    }

    public AppliedPayPalDetails a(List list)
    {
        if (list == null)
        {
            return null;
        }
        TGTAppliedPayPalDetails tgtappliedpaypaldetails = new TGTAppliedPayPalDetails();
        tgtappliedpaypaldetails.a(null);
        for (list = list.iterator(); list.hasNext();)
        {
            z z1 = (z)list.next();
            if (z1.c() == a.PAYPAL)
            {
                tgtappliedpaypaldetails.a(new BigDecimal(z1.f()));
                return tgtappliedpaypaldetails;
            }
        }

        return null;
    }

    public volatile Object a(Object obj)
    {
        return a((List)obj);
    }
}
