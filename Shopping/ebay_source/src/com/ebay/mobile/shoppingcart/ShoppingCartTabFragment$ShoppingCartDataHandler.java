// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.shoppingcart;

import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase;
import com.ebay.nautilus.domain.data.ShoppingCart;
import com.ebay.nautilus.kernel.content.ResultStatus;

// Referenced classes of package com.ebay.mobile.shoppingcart:
//            ShoppingCartTabFragment

public final class r extends com.ebay.nautilus.domain.content.dm.>
{

    final ShoppingCartTabFragment this$0;

    public void onShoppingCartChanged(ShoppingCartDataManagerBase shoppingcartdatamanagerbase, com.ebay.nautilus.domain.content.dm.> >, Content content)
    {
label0:
        {
            if (!content.getStatus().hasError() && >.alData)
            {
                shoppingcartdatamanagerbase = (ShoppingCart)content.getData();
                if (ShoppingCartTabFragment.access$000(ShoppingCartTabFragment.this) != 0)
                {
                    break label0;
                }
                ShoppingCartTabFragment.access$100(ShoppingCartTabFragment.this, shoppingcartdatamanagerbase);
            }
            return;
        }
        ShoppingCartTabFragment.access$200(ShoppingCartTabFragment.this, shoppingcartdatamanagerbase);
    }

    public r()
    {
        this$0 = ShoppingCartTabFragment.this;
        super();
    }
}
