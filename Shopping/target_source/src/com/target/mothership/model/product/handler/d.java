// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.product.handler;

import com.target.mothership.model.h;
import com.target.mothership.model.product.interfaces.ProductDetailsWrapper;
import com.target.mothership.services.aa;
import com.target.mothership.services.e.e.b.b;
import com.target.mothership.services.e.e.b.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.mothership.model.product.handler:
//            e, TGTProductDetails, TGTProductDetailsWrapper

public class d extends e
{

    private final aa mTransformer = new aa() {

        final d this$0;

        public ProductDetailsWrapper a(c c1)
        {
            TGTProductDetailsWrapper tgtproductdetailswrapper = new TGTProductDetailsWrapper();
            tgtproductdetailswrapper.a(c1.a());
            tgtproductdetailswrapper.a(d.a(d.this, c1.b()));
            return tgtproductdetailswrapper;
        }

        public volatile Object a(Object obj)
        {
            return a((c)obj);
        }

            
            {
                this$0 = d.this;
                super();
            }
    };

    public d(h h)
    {
        super(h);
    }

    static List a(d d1, List list)
    {
        return d1.a(list);
    }

    private List a(List list)
    {
        if (list == null)
        {
            return Collections.emptyList();
        }
        ArrayList arraylist = new ArrayList();
        TGTProductDetails tgtproductdetails;
        for (list = list.iterator(); list.hasNext(); arraylist.add(tgtproductdetails))
        {
            b b1 = (b)list.next();
            tgtproductdetails = new TGTProductDetails();
            a(tgtproductdetails, b1);
        }

        return arraylist;
    }

    protected ProductDetailsWrapper a(c c1)
    {
        return (ProductDetailsWrapper)mTransformer.a(c1);
    }

    protected volatile Object a(Object obj)
    {
        return a((c)obj);
    }
}
