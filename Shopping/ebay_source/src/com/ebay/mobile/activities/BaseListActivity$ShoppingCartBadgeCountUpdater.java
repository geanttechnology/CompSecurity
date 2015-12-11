// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.view.Menu;
import com.ebay.mobile.shoppingcart.ShoppingCartActivity;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase;

// Referenced classes of package com.ebay.mobile.activities:
//            BaseListActivity, OptionsMenuGetter

class this._cls0
{

    private com.ebay.nautilus.domain.content.dm.artDm cartObserver;
    private ShoppingCartDataManagerBase shoppingCartDm;
    final BaseListActivity this$0;

    void getCartData()
    {
        if (BaseListActivity.access$000(BaseListActivity.this) != null && (BaseListActivity.this instanceof OptionsMenuGetter) && BaseListActivity.access$000(BaseListActivity.this).findItem(0x7f1009e6) != null && shoppingCartDm != null && cartObserver != null)
        {
            shoppingCartDm.loadData(false, cartObserver);
        }
    }

    void registerShoppingCartObserver()
    {
        if (cartObserver == null && shoppingCartDm == null)
        {
            cartObserver = new com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase.SimpleObserver() {

                final BaseListActivity.ShoppingCartBadgeCountUpdater this$1;

                public void onShoppingCartChanged(ShoppingCartDataManagerBase shoppingcartdatamanagerbase, com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase.Action action, Content content)
                {
                    ShoppingCartActivity.updateActionBarCount(this$0);
                }

            
            {
                this$1 = BaseListActivity.ShoppingCartBadgeCountUpdater.this;
                super();
            }
            };
            com.ebay.nautilus.domain.content.dm.ver ver = ShoppingCartDataManagerBase.getShoppingCartServiceApi();
            shoppingCartDm = (ShoppingCartDataManagerBase)ShoppingCartDataManagerBase.get(getEbayContext(), new com.ebay.nautilus.domain.content.dm.artDm(ver));
            shoppingCartDm.registerObserver(cartObserver);
        }
    }

    void unregisterShoppingCartObserver()
    {
        if (cartObserver != null && shoppingCartDm != null)
        {
            shoppingCartDm.unregisterObserver(cartObserver);
            cartObserver = null;
            shoppingCartDm = null;
        }
    }

    rver()
    {
        this$0 = BaseListActivity.this;
        super();
    }
}
