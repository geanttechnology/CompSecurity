// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.shop.c;

import android.net.Uri;
import com.target.mothership.common.params.ProductSummaryParam;
import com.target.mothership.model.coupons.interfaces.AvailableCouponOffer;
import com.target.mothership.model.product.interfaces.ProductDetails;
import com.target.mothership.model.store.interfaces.StoreSummary;
import com.target.ui.analytics.h;
import com.target.ui.model.refine.ProductRefineModel;
import com.target.ui.model.shop.AggregateDealsData;
import com.target.ui.view.product.PlpListItemView;
import com.target.ui.view.shop.DealsHeaderView;
import com.target.ui.view.shop.WeeklyAdCardView;
import java.util.List;

public interface a
{

    public abstract void a(int k);

    public abstract void a(int k, AvailableCouponOffer availablecouponoffer);

    public abstract void a(ProductRefineModel productrefinemodel, ProductSummaryParam productsummaryparam);

    public abstract void a(AggregateDealsData aggregatedealsdata, int k);

    public abstract void a(com.target.ui.view.common.b.a a1, boolean flag);

    public abstract void a(DealsHeaderView dealsheaderview, WeeklyAdCardView weeklyadcardview, StoreSummary storesummary);

    public abstract void a(List list);

    public abstract void b(int k);

    public abstract void b(Uri uri, String s);

    public abstract void b(AvailableCouponOffer availablecouponoffer);

    public abstract void b(ProductDetails productdetails, PlpListItemView plplistitemview);

    public abstract void b(h h1);

    public abstract void c(boolean flag);

    public abstract void d(boolean flag);

    public abstract void e(boolean flag);

    public abstract void f(boolean flag);

    public abstract void g(boolean flag);

    public abstract void h();

    public abstract void i();

    public abstract void j();
}
