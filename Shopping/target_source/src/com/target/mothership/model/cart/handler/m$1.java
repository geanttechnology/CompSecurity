// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import com.target.mothership.model.cart.interfaces.CartProduct;
import java.util.Comparator;

// Referenced classes of package com.target.mothership.model.cart.handler:
//            m

class this._cls0
    implements Comparator
{

    final m this$0;

    public int a(CartProduct cartproduct, CartProduct cartproduct1)
    {
        long l1 = -1L;
        long l;
        long l2;
        try
        {
            l = Long.parseLong(cartproduct.a());
        }
        // Misplaced declaration of an exception variable
        catch (CartProduct cartproduct)
        {
            l = -1L;
        }
        l2 = Long.parseLong(cartproduct1.a());
        l1 = l2;
_L2:
        return l1 >= l ? 1 : -1;
        cartproduct;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public int compare(Object obj, Object obj1)
    {
        return a((CartProduct)obj, (CartProduct)obj1);
    }

    artProduct()
    {
        this$0 = m.this;
        super();
    }
}
