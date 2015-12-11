// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.cart.a;

import com.target.mothership.model.cart.interfaces.AppliedTenders;
import com.target.mothership.model.cart.interfaces.CartDetails;
import com.target.mothership.model.cart.interfaces.CartProduct;
import com.target.mothership.model.cart.interfaces.ExpressOrderReview;
import com.target.mothership.model.cart.interfaces.FreeShippingPromotion;
import com.target.mothership.model.cart.interfaces.a.w;
import com.target.mothership.model.cart.interfaces.a.y;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.model.product.interfaces.ProductRecommendations;
import com.target.mothership.services.o;

public interface a
{

    public abstract void a(int i);

    public abstract void a(int i, String s1);

    public abstract void a(CartDetails cartdetails, FreeShippingPromotion freeshippingpromotion);

    public abstract void a(ExpressOrderReview expressorderreview, AppliedTenders appliedtenders);

    public abstract void a(w w1);

    public abstract void a(y y1);

    public abstract void a(Guest guest, o o1);

    public abstract void a(ProductRecommendations productrecommendations);

    public abstract void a(boolean flag);

    public abstract void b();

    public abstract void b(int i);

    public abstract void b(CartDetails cartdetails, FreeShippingPromotion freeshippingpromotion);

    public abstract void b(ProductRecommendations productrecommendations);

    public abstract void c(int i);

    public abstract void e();

    public abstract void g();

    public abstract void g(CartProduct cartproduct);

    public abstract void k();

    public abstract void o();

    public abstract void p();

    public abstract void q();

    public abstract void r();

    public abstract void s();

    public abstract void t();

    public abstract void u();

    public abstract void v();

    public abstract void w();

    public abstract void x();

    public abstract void y();
}
