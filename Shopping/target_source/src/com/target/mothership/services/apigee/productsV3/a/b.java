// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.productsV3.a;

import com.target.mothership.services.f.a.c;
import com.target.mothership.services.f.b.a;

// Referenced classes of package com.target.mothership.services.apigee.productsV3.a:
//            a

public class b extends com.target.mothership.services.f.a.b
{

    private static c GET_PRODUCTS;
    private static c SALEABLE_QTY;
    private static c SALEABLE_QTY_BY_LOCATION;

    public b(a a1)
    {
        super(a1);
    }

    public com.target.mothership.services.f.a.b a(com.target.mothership.services.apigee.productsV3.a.a a1)
    {
        return a(SALEABLE_QTY_BY_LOCATION, ((com.target.mothership.services.n) (a1)), null, null, null);
    }

    static 
    {
        GET_PRODUCTS = new c(com.target.mothership.services.f.a.d.a.GET, com.target.mothership.services.f.b.a.a.Apigee, "/products/v3/{productIds}?id_type={productIdType}&store_id={storeId}&mode=online&fields=all_fields_group");
        SALEABLE_QTY = new c(com.target.mothership.services.f.a.d.a.GET, com.target.mothership.services.f.b.a.a.Apigee, "/products/v3/saleable_quantity");
        SALEABLE_QTY_BY_LOCATION = new c(com.target.mothership.services.f.a.d.a.POST, com.target.mothership.services.f.b.a.a.Apigee, "/products/v3/saleable_quantity_by_location");
    }
}
