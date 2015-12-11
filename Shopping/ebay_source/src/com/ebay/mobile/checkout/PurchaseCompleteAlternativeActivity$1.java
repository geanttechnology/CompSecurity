// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.checkout;

import com.ebay.mobile.shoppingcart.ShoppingCartActivity;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase;

// Referenced classes of package com.ebay.mobile.checkout:
//            PurchaseCompleteAlternativeActivity

class .SimpleObserver extends com.ebay.nautilus.domain.content.dm.rver
{

    final PurchaseCompleteAlternativeActivity this$0;

    public void onShoppingCartChanged(ShoppingCartDataManagerBase shoppingcartdatamanagerbase, com.ebay.nautilus.domain.content.dm.rver rver, Content content)
    {
        ShoppingCartActivity.updateActionBarCount(PurchaseCompleteAlternativeActivity.this);
    }

    .Action()
    {
        this$0 = PurchaseCompleteAlternativeActivity.this;
        super();
    }
}
