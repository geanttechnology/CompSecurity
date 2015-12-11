// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.checkout;

import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase;

// Referenced classes of package com.ebay.mobile.checkout:
//            BaseCheckoutActivity

class bserver extends com.ebay.nautilus.domain.content.dm.Base.SimpleObserver
{

    final BaseCheckoutActivity this$0;

    public void onCheckoutSessionComplete(ShoppingCartDataManagerBase shoppingcartdatamanagerbase, Content content)
    {
        handleCheckoutSessionComplete(shoppingcartdatamanagerbase, content);
    }

    DataManagerBase()
    {
        this$0 = BaseCheckoutActivity.this;
        super();
    }
}
