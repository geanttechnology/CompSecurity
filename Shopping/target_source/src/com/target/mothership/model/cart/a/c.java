// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.a;

import com.google.a.a.e;
import com.target.mothership.model.cart.b.a;
import com.target.mothership.model.cart.interfaces.a.b;
import com.target.mothership.model.common.a.j;
import com.target.mothership.model.product.interfaces.ProductAgeRestriction;
import com.target.mothership.model.product.interfaces.ProductDetails;
import java.util.ArrayList;
import java.util.List;

public class c
{

    private static final int MIN_CART_QUANTITY = 1;
    private b mError;

    public c(a a1)
    {
        mError = null;
        ArrayList arraylist = new ArrayList();
        ProductDetails productdetails = a1.a();
        if (productdetails.G())
        {
            arraylist.add(com.target.mothership.model.cart.interfaces.a.b.a.ERR_CART_PRODUCT_DETAILS_PASSED_WITH_VARIATION);
        }
        if (!productdetails.f().b())
        {
            arraylist.add(com.target.mothership.model.cart.interfaces.a.b.a.ERR_CART_PRODUCTID_MISSING);
        }
        if (a1.b() < 1)
        {
            arraylist.add(com.target.mothership.model.cart.interfaces.a.b.a.ERR_CART_QUANTITY_PATTERN_INVALID);
        }
        if (productdetails.t().a() && !a1.d())
        {
            arraylist.add(com.target.mothership.model.cart.interfaces.a.b.a.ERR_CART_AGE_CHECK_FAILURE);
        }
        if (!arraylist.isEmpty())
        {
            a1 = new b();
            a1.a(arraylist);
            a1.a((j)arraylist.get(0));
            a1.a(null);
            mError = a1;
        }
    }

    public boolean a()
    {
        return mError != null;
    }

    public b b()
    {
        return mError;
    }
}
