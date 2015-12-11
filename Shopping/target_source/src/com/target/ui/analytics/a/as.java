// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.analytics.a;

import com.target.mothership.model.cart.interfaces.CartDetails;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.target.ui.analytics.a:
//            f, i, s

public class as extends f
{

    final BigDecimal mCartTotal;
    final String mError;
    final Long mLoadTimeMS;
    final List mProducts;

    private as()
    {
        mError = null;
        mLoadTimeMS = null;
        mCartTotal = null;
        mProducts = null;
    }

    private as(CartDetails cartdetails, long l, String s1)
    {
        Object obj = null;
        super();
        List list;
        if (cartdetails == null)
        {
            list = null;
        } else
        {
            list = cartdetails.a();
        }
        mProducts = list;
        if (cartdetails == null)
        {
            cartdetails = obj;
        } else
        {
            cartdetails = cartdetails.d();
        }
        mCartTotal = cartdetails;
        mError = s1;
        mLoadTimeMS = Long.valueOf(l);
    }

    public static as a(CartDetails cartdetails, long l)
    {
        return new as(cartdetails, l, null);
    }

    protected Map b()
    {
        Map map = super.b();
        if (mProducts != null && !mProducts.isEmpty())
        {
            com.target.ui.analytics.a.i.a(map, "products", com.target.ui.analytics.a.i.a(mProducts));
        }
        com.target.ui.analytics.a.i.a(map, "events", "cartView");
        if (mCartTotal != null)
        {
            com.target.ui.analytics.a.i.a(map, "cartSubtotal", mCartTotal.toPlainString());
        }
        return map;
    }

    protected s c()
    {
        return s.Cart;
    }

    protected List d()
    {
        return Collections.emptyList();
    }

    protected Long i()
    {
        return mLoadTimeMS;
    }
}
