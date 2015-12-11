// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import com.target.mothership.common.a.b;
import com.target.mothership.model.common.TGTOrderProductImage;
import com.target.mothership.services.aa;
import com.target.mothership.services.apigee.c.b.s;
import com.target.mothership.services.apigee.c.b.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.mothership.model.cart.handler:
//            TGTGiftProduct, aa

class ab
    implements aa
{

    ab()
    {
    }

    public TGTGiftProduct a(s s1)
    {
        TGTGiftProduct tgtgiftproduct = new TGTGiftProduct();
        tgtgiftproduct.l(s1.b());
        tgtgiftproduct.a(s1.d());
        tgtgiftproduct.a(s1.c());
        tgtgiftproduct.a(s1.a());
        tgtgiftproduct.a(s1.l());
        tgtgiftproduct.d(s1.h());
        tgtgiftproduct.c(s1.g());
        tgtgiftproduct.a(s1.j());
        Object obj = (new com.target.mothership.model.cart.handler.aa()).a(s1.i());
        tgtgiftproduct.a(((b) (obj)));
        tgtgiftproduct.a(((b) (obj)).a());
        tgtgiftproduct.b(s1.f());
        tgtgiftproduct.b(s1.f());
        tgtgiftproduct.b(s1.k());
        obj = new ArrayList();
        if (s1.e() != null)
        {
            TGTOrderProductImage tgtorderproductimage;
            for (s1 = s1.e().iterator(); s1.hasNext(); ((List) (obj)).add(tgtorderproductimage))
            {
                t t1 = (t)s1.next();
                tgtorderproductimage = new TGTOrderProductImage();
                tgtorderproductimage.a(t1.a());
                tgtorderproductimage.b(t1.b());
            }

        }
        tgtgiftproduct.a(((List) (obj)));
        return tgtgiftproduct;
    }

    public volatile Object a(Object obj)
    {
        return a((s)obj);
    }
}
