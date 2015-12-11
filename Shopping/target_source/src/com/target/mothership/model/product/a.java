// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.product;

import com.target.mothership.common.params.ProductRecommendationsParam;
import com.target.mothership.common.params.ProductSummaryParam;
import com.target.mothership.common.product.Dpci;
import com.target.mothership.common.product.ProductIdentifier;
import com.target.mothership.common.product.o;
import com.target.mothership.model.h;
import com.target.mothership.model.product.interfaces.Product;
import com.target.mothership.model.store.interfaces.Store;
import java.util.List;

interface a
{

    public abstract void a(ProductRecommendationsParam productrecommendationsparam, h h);

    public abstract void a(ProductSummaryParam productsummaryparam, h h);

    public abstract void a(Dpci dpci, int i, String s, int j, h h);

    public abstract void a(Dpci dpci, int i, List list, h h);

    public abstract void a(Dpci dpci, String s, o o, h h);

    public abstract void a(Dpci dpci, List list, o o, h h);

    public abstract void a(Store store, ProductIdentifier productidentifier, boolean flag, h h);

    public abstract void a(Store store, h h);

    public abstract void a(Store store, Product product, boolean flag, h h);

    public abstract void a(Store store, List list, boolean flag, h h);

    public abstract void b(ProductSummaryParam productsummaryparam, h h);

    public abstract void b(Store store, List list, boolean flag, h h);
}
