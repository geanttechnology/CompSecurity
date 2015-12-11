// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.guest.handler;

import com.target.mothership.common.tender.b;
import com.target.mothership.model.common.GuestAddress;
import com.target.mothership.model.common.TGTPaymentCardTender;
import com.target.mothership.model.common.a;
import com.target.mothership.services.aa;
import com.target.mothership.services.apigee.f.b.f;
import com.target.mothership.services.apigee.f.b.k;
import com.target.mothership.services.apigee.f.b.m;
import com.target.mothership.util.l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.mothership.model.guest.handler:
//            j, TGTGuestAddress, TGTPersonName, TGTPhoneNumber, 
//            l, TGTGuestPaymentCardExpiration

class this._cls0
    implements aa
{

    final j this$0;

    private GuestAddress a(f f1)
    {
        TGTGuestAddress tgtguestaddress = new TGTGuestAddress();
        tgtguestaddress.a(a.Billing);
        tgtguestaddress.e(f1.d());
        Object obj;
        if (f1.e() != null)
        {
            obj = f1.e();
        } else
        {
            obj = Collections.emptyList();
        }
        tgtguestaddress.a(((List) (obj)));
        tgtguestaddress.a(f1.f());
        tgtguestaddress.b(f1.g());
        tgtguestaddress.d(f1.h());
        tgtguestaddress.c(f1.i());
        obj = new TGTPersonName();
        ((TGTPersonName) (obj)).a(f1.a());
        ((TGTPersonName) (obj)).c(f1.b());
        ((TGTPersonName) (obj)).b(f1.c());
        tgtguestaddress.a(((com.target.mothership.model.common.PersonName) (obj)));
        obj = new TGTPhoneNumber();
        ((TGTPhoneNumber) (obj)).a(f1.j());
        ((TGTPhoneNumber) (obj)).a((new com.target.mothership.model.guest.handler.l()).a(f1.k()));
        tgtguestaddress.a(((com.target.mothership.model.common.PhoneNumber) (obj)));
        return tgtguestaddress;
    }

    public volatile Object a(Object obj)
    {
        return a((k)obj);
    }

    public List a(k k1)
    {
        if (k1 == null || k1.a() == null || k1.a().isEmpty())
        {
            return Collections.emptyList();
        }
        ArrayList arraylist = new ArrayList();
        k1 = k1.a().iterator();
        while (k1.hasNext()) 
        {
            m m1 = (m)k1.next();
            TGTPaymentCardTender tgtpaymentcardtender = new TGTPaymentCardTender();
            tgtpaymentcardtender.b(m1.b());
            tgtpaymentcardtender.c(l.c(m1.c()));
            tgtpaymentcardtender.d(m1.g());
            tgtpaymentcardtender.e(m1.h());
            tgtpaymentcardtender.a(m1.f());
            tgtpaymentcardtender.b(m1.d());
            tgtpaymentcardtender.a(m1.e());
            if (m1.i() != -1)
            {
                tgtpaymentcardtender.a(new TGTGuestPaymentCardExpiration(b.a(String.valueOf(m1.i())), m1.j()));
            } else
            {
                tgtpaymentcardtender.a(null);
            }
            tgtpaymentcardtender.a(a(m1.a()));
            arraylist.add(tgtpaymentcardtender);
        }
        return arraylist;
    }

    s()
    {
        this$0 = j.this;
        super();
    }
}
