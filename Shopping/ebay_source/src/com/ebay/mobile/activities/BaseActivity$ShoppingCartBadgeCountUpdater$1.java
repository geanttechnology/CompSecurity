// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import com.ebay.mobile.shoppingcart.ShoppingCartActivity;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase;

// Referenced classes of package com.ebay.mobile.activities:
//            BaseActivity

class server extends com.ebay.nautilus.domain.content.dm.nit>
{

    final is._cls0 this$1;

    public void onShoppingCartChanged(ShoppingCartDataManagerBase shoppingcartdatamanagerbase, com.ebay.nautilus.domain.content.dm.nit> nit>, Content content)
    {
        ShoppingCartActivity.updateActionBarCount(_fld0);
    }

    server()
    {
        this$1 = this._cls1.this;
        super();
    }
}
