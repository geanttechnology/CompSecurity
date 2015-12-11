// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.analytics.b;

import com.target.mothership.model.cart.interfaces.CartProduct;
import com.target.mothership.model.product.interfaces.ProductDetails;
import com.target.ui.fragment.product.common.PageItemHierarchy;

// Referenced classes of package com.target.ui.analytics.b:
//            a

public class e extends a
{

    public static final int Cart = 1;
    private static final int DEFAULT_QUANTITY = 1;
    public static final int Deals = 2;
    public static final int ProductDetails = 3;
    public final CartProduct cartProduct;
    public int origin;
    public final PageItemHierarchy pageItemHierarchy;
    public final ProductDetails product;
    public final int quantity;

    private e(CartProduct cartproduct, ProductDetails productdetails, int i, PageItemHierarchy pageitemhierarchy, int j)
    {
        cartProduct = cartproduct;
        product = productdetails;
        pageItemHierarchy = pageitemhierarchy;
        quantity = i;
        origin = j;
    }

    public static e a(CartProduct cartproduct, int i)
    {
        return new e(cartproduct, null, i, null, 1);
    }
}
