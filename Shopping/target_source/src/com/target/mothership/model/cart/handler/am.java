// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import com.target.mothership.model.cart.interfaces.DigitalDownloadDeliveryProfile;
import com.target.mothership.model.cart.interfaces.GiftCardDeliveryProfile;
import com.target.mothership.model.common.a;
import com.target.mothership.model.common.b;
import com.target.mothership.model.common.c;
import com.target.mothership.services.aa;
import com.target.mothership.services.apigee.c.b.w;
import com.target.mothership.util.o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.mothership.model.cart.handler:
//            TGTGiftCardDeliveryProfile, TGTDigitalDownloadDeliveryProfile, o, TGTCartProduct, 
//            TGTShipment, c, TGTCartGuestAddress, TGTCartPhoneNumber

class am
    implements aa
{

    am()
    {
    }

    private GiftCardDeliveryProfile b(w w1)
    {
        if (w1.k() == null)
        {
            return null;
        } else
        {
            TGTGiftCardDeliveryProfile tgtgiftcarddeliveryprofile = new TGTGiftCardDeliveryProfile();
            tgtgiftcarddeliveryprofile.b(w1.k());
            tgtgiftcarddeliveryprofile.c(w1.l());
            tgtgiftcarddeliveryprofile.d(w1.m());
            tgtgiftcarddeliveryprofile.e(w1.n());
            return tgtgiftcarddeliveryprofile;
        }
    }

    private DigitalDownloadDeliveryProfile c(w w1)
    {
        if (w1.o() == null)
        {
            return null;
        } else
        {
            TGTDigitalDownloadDeliveryProfile tgtdigitaldownloaddeliveryprofile = new TGTDigitalDownloadDeliveryProfile();
            tgtdigitaldownloaddeliveryprofile.b(w1.o());
            tgtdigitaldownloaddeliveryprofile.a(w1.p());
            return tgtdigitaldownloaddeliveryprofile;
        }
    }

    private List d(w w1)
    {
        List list = w1.a();
        if (list == null)
        {
            return Collections.emptyList();
        }
        b b3 = new b();
        com.target.mothership.model.cart.handler.o o1 = new com.target.mothership.model.cart.handler.o();
        ArrayList arraylist = new ArrayList();
        TGTCartProduct tgtcartproduct;
        for (Iterator iterator = list.iterator(); iterator.hasNext(); arraylist.add(tgtcartproduct))
        {
            tgtcartproduct = o1.a((com.target.mothership.services.apigee.d.b)iterator.next());
            tgtcartproduct.k(w1.e());
            if (tgtcartproduct.c() != com.target.mothership.common.a.b.None)
            {
                continue;
            }
            com.target.mothership.common.a.b b2 = b3.a(w1.c());
            com.target.mothership.common.a.b b1 = b2;
            if (b2 == com.target.mothership.common.a.b.None)
            {
                b1 = com.target.mothership.common.a.b.Email;
            }
            tgtcartproduct.a(b1);
            tgtcartproduct.a(b1.a());
        }

        return arraylist;
    }

    public TGTShipment a(w w1)
    {
        TGTShipment tgtshipment = new TGTShipment();
        Object obj = new b();
        tgtshipment.e(w1.h());
        tgtshipment.d(w1.f());
        tgtshipment.a(w1.g());
        tgtshipment.a(((b) (obj)).a(w1.c()));
        tgtshipment.c(w1.e());
        tgtshipment.b(w1.d());
        tgtshipment.a(w1.b());
        tgtshipment.a(b(w1));
        tgtshipment.a(c(w1));
        tgtshipment.a(d(w1));
        obj = (new com.target.mothership.model.cart.handler.c()).a(w1.j());
        ((TGTCartGuestAddress) (obj)).a(a.Shipping);
        if (o.e(((TGTCartGuestAddress) (obj)).a()))
        {
            tgtshipment.a(null);
            return tgtshipment;
        } else
        {
            TGTCartPhoneNumber tgtcartphonenumber = new TGTCartPhoneNumber();
            tgtcartphonenumber.a(w1.i());
            tgtcartphonenumber.a(c.Other);
            ((TGTCartGuestAddress) (obj)).a(tgtcartphonenumber);
            tgtshipment.a(((com.target.mothership.model.common.GuestAddress) (obj)));
            return tgtshipment;
        }
    }

    public volatile Object a(Object obj)
    {
        return a((w)obj);
    }
}
