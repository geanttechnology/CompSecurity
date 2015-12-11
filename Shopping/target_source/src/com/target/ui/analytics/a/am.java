// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.analytics.a;

import com.target.mothership.model.cart.interfaces.CartProduct;
import java.util.Collections;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.target.ui.analytics.a:
//            e, i, s, y

public class am extends e
{

    private final CartProduct mCartProduct;
    private final int mQuantity;

    private am(CartProduct cartproduct, int j)
    {
        mCartProduct = cartproduct;
        mQuantity = j;
    }

    public static am a(CartProduct cartproduct, int j)
    {
        return new am(cartproduct, j);
    }

    protected Map b()
    {
        Map map = super.b();
        com.target.ui.analytics.a.i.a(map, "events", "removeFromCart");
        com.target.ui.analytics.a.i.a(map, "products", com.target.ui.analytics.a.i.a(mCartProduct, mQuantity));
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

    protected y i()
    {
        return y.RemoveFromCart;
    }
}
