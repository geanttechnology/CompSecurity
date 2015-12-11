// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.product;

import com.target.mothership.common.params.ProductRecommendationsParam;
import com.target.mothership.common.params.ProductSummaryParam;
import com.target.mothership.common.product.Dpci;
import com.target.mothership.common.product.ProductIdentifier;
import com.target.mothership.common.product.o;
import com.target.mothership.model.c;
import com.target.mothership.model.product.interfaces.Product;
import com.target.mothership.model.store.interfaces.Store;
import com.target.mothership.util.h;
import java.util.List;

// Referenced classes of package com.target.mothership.model.product:
//            a, b

class d extends c
    implements a
{

    private b mProductLiveDataSource;

    public d()
    {
        mProductLiveDataSource = new b();
    }

    public void a(ProductRecommendationsParam productrecommendationsparam, com.target.mothership.model.h h1)
    {
        if (a())
        {
            h1.a(h.NETWORK_ERROR);
            return;
        } else
        {
            a("product_recommendations.json");
            mProductLiveDataSource.a(productrecommendationsparam, h1);
            return;
        }
    }

    public void a(ProductSummaryParam productsummaryparam, com.target.mothership.model.h h1)
    {
        if (a())
        {
            h1.a(h.NETWORK_ERROR);
            return;
        } else
        {
            a("product_summary.json");
            mProductLiveDataSource.b(productsummaryparam, h1);
            return;
        }
    }

    public void a(Dpci dpci, int i, String s, int j, com.target.mothership.model.h h1)
    {
        if (a())
        {
            h1.a(h.NETWORK_ERROR);
            return;
        } else
        {
            a("atp_get_product_store_availability.json");
            mProductLiveDataSource.a(dpci, i, s, j, h1);
            return;
        }
    }

    public void a(Dpci dpci, int i, List list, com.target.mothership.model.h h1)
    {
        if (a())
        {
            h1.a(h.NETWORK_ERROR);
            return;
        } else
        {
            a("atp_get_product_store_availability.json");
            mProductLiveDataSource.a(dpci, i, list, h1);
            return;
        }
    }

    public void a(Dpci dpci, String s, o o, com.target.mothership.model.h h1)
    {
        if (a())
        {
            h1.a(h.NETWORK_ERROR);
            return;
        } else
        {
            a("get_saleable_quantity_by_location.json");
            mProductLiveDataSource.a(dpci, s, o, h1);
            return;
        }
    }

    public void a(Dpci dpci, List list, o o, com.target.mothership.model.h h1)
    {
        if (a())
        {
            h1.a(h.NETWORK_ERROR);
            return;
        } else
        {
            a("get_saleable_quantity_by_location.json");
            mProductLiveDataSource.a(dpci, list, o, h1);
            return;
        }
    }

    public void a(Store store, ProductIdentifier productidentifier, boolean flag, com.target.mothership.model.h h1)
    {
        if (a())
        {
            h1.a(h.NETWORK_ERROR);
            return;
        } else
        {
            a("product_details.json");
            mProductLiveDataSource.a(store, productidentifier, flag, h1);
            return;
        }
    }

    public void a(Store store, com.target.mothership.model.h h1)
    {
        if (a())
        {
            h1.a(h.NETWORK_ERROR);
            return;
        } else
        {
            a("black_friday_prices.json");
            mProductLiveDataSource.a(store, h1);
            return;
        }
    }

    public void a(Store store, Product product, boolean flag, com.target.mothership.model.h h1)
    {
        a("product_details.json");
        mProductLiveDataSource.a(store, product, flag, h1);
    }

    public void a(Store store, List list, boolean flag, com.target.mothership.model.h h1)
    {
        if (a())
        {
            h1.a(h.NETWORK_ERROR);
            return;
        } else
        {
            a("product_summary.json");
            mProductLiveDataSource.a(store, list, flag, h1);
            return;
        }
    }

    public void b(ProductSummaryParam productsummaryparam, com.target.mothership.model.h h1)
    {
        if (a())
        {
            h1.a(h.NETWORK_ERROR);
            return;
        } else
        {
            a("product_summary.json");
            mProductLiveDataSource.b(productsummaryparam, h1);
            return;
        }
    }

    public void b(Store store, List list, boolean flag, com.target.mothership.model.h h1)
    {
        if (a())
        {
            h1.a(h.NETWORK_ERROR);
            return;
        } else
        {
            a("product_details.json");
            mProductLiveDataSource.b(store, list, flag, h1);
            return;
        }
    }
}
