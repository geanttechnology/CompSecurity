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
//            TGTFreeProduct, aa

class u
    implements aa
{

    u()
    {
    }

    public TGTFreeProduct a(s s1)
    {
        TGTFreeProduct tgtfreeproduct = new TGTFreeProduct();
        tgtfreeproduct.l(s1.b());
        tgtfreeproduct.a(s1.d());
        tgtfreeproduct.a(s1.c());
        tgtfreeproduct.a(s1.a());
        tgtfreeproduct.a(s1.l());
        tgtfreeproduct.d(s1.h());
        tgtfreeproduct.c(s1.g());
        tgtfreeproduct.a(s1.j());
        Object obj;
        if (s1.j())
        {
            obj = (new com.target.mothership.model.cart.handler.aa()).a(s1.i());
        } else
        {
            obj = (new com.target.mothership.model.common.b()).a(s1.i());
        }
        tgtfreeproduct.a(((b) (obj)));
        tgtfreeproduct.a(((b) (obj)).a());
        tgtfreeproduct.b(s1.f());
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
        tgtfreeproduct.a(((List) (obj)));
        return tgtfreeproduct;
    }

    public volatile Object a(Object obj)
    {
        return a((s)obj);
    }
}
