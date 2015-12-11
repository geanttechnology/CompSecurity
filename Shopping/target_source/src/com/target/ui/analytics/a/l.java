// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.analytics.a;

import android.support.v4.f.a;
import com.target.mothership.model.cart.interfaces.CartProduct;
import com.target.mothership.model.product.interfaces.ProductDetails;
import com.target.ui.fragment.product.common.PageItemHierarchy;
import java.util.Collections;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.target.ui.analytics.a:
//            c, i, s, q

public class l extends c
{

    public static final int Cart = 1;
    private static final int DEFAULT_QUANTITY = 1;
    public static final int Deals = 2;
    public static final int ProductDetails = 3;
    public static final int ProductListing = 4;
    private final CartProduct mCartProduct;
    private int mOrigin;
    private final PageItemHierarchy mPageItemHierarchy;
    private final ProductDetails mProduct;
    private final int mQuantity;

    private l(CartProduct cartproduct, ProductDetails productdetails, int k, PageItemHierarchy pageitemhierarchy, int i1)
    {
        mCartProduct = cartproduct;
        mProduct = productdetails;
        mPageItemHierarchy = pageitemhierarchy;
        mQuantity = k;
        mOrigin = i1;
    }

    public static l a(ProductDetails productdetails, PageItemHierarchy pageitemhierarchy, int k)
    {
        return new l(null, productdetails, 1, pageitemhierarchy, k);
    }

    private String j()
    {
        if (mCartProduct != null)
        {
            return com.target.ui.analytics.a.i.a(mCartProduct, mQuantity);
        }
        if (mProduct != null)
        {
            return com.target.ui.analytics.a.i.a(mProduct, mQuantity);
        } else
        {
            return "";
        }
    }

    protected Map b()
    {
        a a1 = new a();
        com.target.ui.analytics.a.i.a(a1, "events", "addToCart");
        com.target.ui.analytics.a.i.a(a1, "products", j());
        return a1;
    }

    protected s c()
    {
        switch (mOrigin)
        {
        default:
            return s.Unknown;

        case 1: // '\001'
            return s.Cart;

        case 2: // '\002'
            return s.Deals;

        case 3: // '\003'
            return com.target.ui.analytics.a.s.ProductDetails;

        case 4: // '\004'
            return s.ProductListing;
        }
    }

    protected List d()
    {
        if (mOrigin == 3)
        {
            return com.target.ui.analytics.a.i.a(mPageItemHierarchy);
        } else
        {
            return Collections.emptyList();
        }
    }

    protected q i()
    {
        return q.AddToCartSuccess;
    }
}
