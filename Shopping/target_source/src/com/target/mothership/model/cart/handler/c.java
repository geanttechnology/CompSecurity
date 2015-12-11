// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import com.target.mothership.services.aa;
import com.target.mothership.services.apigee.c.b.b;
import com.target.mothership.util.o;
import java.util.Collections;

// Referenced classes of package com.target.mothership.model.cart.handler:
//            TGTCartGuestAddress, TGTCartPersonName, TGTCartPhoneNumber

class c
    implements aa
{

    c()
    {
    }

    public TGTCartGuestAddress a(b b1)
    {
        TGTCartGuestAddress tgtcartguestaddress = new TGTCartGuestAddress();
        Object obj;
        if (o.g(b1.d()))
        {
            tgtcartguestaddress.e(b1.d());
        } else
        {
            tgtcartguestaddress.e(b1.e());
        }
        if (b1.f() != null)
        {
            obj = b1.f();
        } else
        {
            obj = Collections.emptyList();
        }
        tgtcartguestaddress.a(((java.util.List) (obj)));
        tgtcartguestaddress.a(b1.g());
        tgtcartguestaddress.b(b1.h());
        tgtcartguestaddress.d(b1.i());
        tgtcartguestaddress.c(b1.j());
        obj = new TGTCartPersonName();
        ((TGTCartPersonName) (obj)).a(b1.a());
        ((TGTCartPersonName) (obj)).c(b1.b());
        ((TGTCartPersonName) (obj)).b(b1.c());
        tgtcartguestaddress.a(((com.target.mothership.model.common.PersonName) (obj)));
        obj = new TGTCartPhoneNumber();
        ((TGTCartPhoneNumber) (obj)).a(b1.k());
        ((TGTCartPhoneNumber) (obj)).a(com.target.mothership.model.common.c.Other);
        tgtcartguestaddress.a(((com.target.mothership.model.common.PhoneNumber) (obj)));
        return tgtcartguestaddress;
    }

    public volatile Object a(Object obj)
    {
        return a((b)obj);
    }
}
