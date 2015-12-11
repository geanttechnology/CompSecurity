// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.product;

import com.target.mothership.b;
import com.target.mothership.common.params.ProductRecommendationsParam;
import com.target.mothership.common.params.ProductSummaryParam;
import com.target.mothership.common.product.Dpci;
import com.target.mothership.common.product.ProductIdentifier;
import com.target.mothership.common.product.o;
import com.target.mothership.model.a;
import com.target.mothership.model.h;
import com.target.mothership.model.product.interfaces.Product;
import com.target.mothership.model.store.interfaces.Store;
import java.util.List;

// Referenced classes of package com.target.mothership.model.product:
//            a, d, b

public class c extends a
    implements com.target.mothership.model.product.a
{

    private com.target.mothership.model.product.a mProductDataSource;

    public c()
    {
        if (com.target.mothership.b.a().m())
        {
            mProductDataSource = new d();
            return;
        } else
        {
            mProductDataSource = new com.target.mothership.model.product.b();
            return;
        }
    }

    public void a(ProductRecommendationsParam productrecommendationsparam, h h)
    {
        mProductDataSource.a(productrecommendationsparam, h);
    }

    public void a(ProductSummaryParam productsummaryparam, h h)
    {
        mProductDataSource.a(productsummaryparam, h);
    }

    public void a(Dpci dpci, int i, String s, int j, h h)
    {
        mProductDataSource.a(dpci, i, s, j, h);
    }

    public void a(Dpci dpci, int i, List list, h h)
    {
        mProductDataSource.a(dpci, i, list, h);
    }

    public void a(Dpci dpci, String s, o o, h h)
    {
        mProductDataSource.a(dpci, s, o, h);
    }

    public void a(Dpci dpci, List list, o o, h h)
    {
        mProductDataSource.a(dpci, list, o, h);
    }

    public void a(Store store, ProductIdentifier productidentifier, boolean flag, h h)
    {
        mProductDataSource.a(store, productidentifier, flag, h);
    }

    public void a(Store store, h h)
    {
        mProductDataSource.a(store, h);
    }

    public void a(Store store, Product product, boolean flag, h h)
    {
        mProductDataSource.a(store, product, true, h);
    }

    public void a(Store store, List list, boolean flag, h h)
    {
        mProductDataSource.a(store, list, flag, h);
    }

    public void b(ProductSummaryParam productsummaryparam, h h)
    {
        mProductDataSource.b(productsummaryparam, h);
    }

    public void b(Store store, List list, boolean flag, h h)
    {
        mProductDataSource.b(store, list, flag, h);
    }
}
