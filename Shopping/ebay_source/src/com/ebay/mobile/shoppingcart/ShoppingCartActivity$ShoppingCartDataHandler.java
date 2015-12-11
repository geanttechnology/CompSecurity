// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.shoppingcart;

import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase;

// Referenced classes of package com.ebay.mobile.shoppingcart:
//            ShoppingCartActivity

private final class <init> extends com.ebay.nautilus.domain.content.dm.nit>
{

    final ShoppingCartActivity this$0;

    public void onShoppingCartChanged(ShoppingCartDataManagerBase shoppingcartdatamanagerbase, com.ebay.nautilus.domain.content.dm.nit> nit>, Content content)
    {
        handleShoppingCartChanged(shoppingcartdatamanagerbase, nit>, content);
    }

    public void onShoppingCartLoading(ShoppingCartDataManagerBase shoppingcartdatamanagerbase, com.ebay.nautilus.domain.content.dm.nit> nit>)
    {
        ShoppingCartActivity.access$200(ShoppingCartActivity.this, true);
        ShoppingCartActivity.access$400(ShoppingCartActivity.this, false, true);
    }

    private rver()
    {
        this$0 = ShoppingCartActivity.this;
        super();
    }

    rver(rver rver)
    {
        this();
    }
}
