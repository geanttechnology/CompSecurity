// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.view.Menu;
import com.ebay.mobile.shoppingcart.ShoppingCartActivity;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase;

// Referenced classes of package com.ebay.mobile.activities:
//            BaseActivity, OptionsMenuGetter

protected class this._cls0
{

    private com.ebay.nautilus.domain.content.dm.ver cartObserver;
    private ShoppingCartDataManagerBase shoppingCartDm;
    final BaseActivity this$0;

    private void getCartData()
    {
        if (BaseActivity.access$200(BaseActivity.this) != null && (BaseActivity.this instanceof OptionsMenuGetter) && BaseActivity.access$200(BaseActivity.this).findItem(0x7f1009e6) != null && shoppingCartDm != null && cartObserver != null)
        {
            shoppingCartDm.loadData(false, cartObserver);
        }
    }

    private void unregisterShoppingCartObserver()
    {
        if (cartObserver != null && shoppingCartDm != null)
        {
            shoppingCartDm.unregisterObserver(cartObserver);
            cartObserver = null;
            shoppingCartDm = null;
        }
    }

    protected void registerShoppingCartObserver()
    {
        if (cartObserver == null && shoppingCartDm == null)
        {
            cartObserver = new com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase.SimpleObserver() {

                final BaseActivity.ShoppingCartBadgeCountUpdater this$1;

                public void onShoppingCartChanged(ShoppingCartDataManagerBase shoppingcartdatamanagerbase, com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase.Action action, Content content)
                {
                    ShoppingCartActivity.updateActionBarCount(this$0);
                }

            
            {
                this$1 = BaseActivity.ShoppingCartBadgeCountUpdater.this;
                super();
            }
            };
            com.ebay.nautilus.domain.content.dm.artDm artdm = ShoppingCartDataManagerBase.getShoppingCartServiceApi();
            shoppingCartDm = (ShoppingCartDataManagerBase)ShoppingCartDataManagerBase.get(getEbayContext(), new com.ebay.nautilus.domain.content.dm.>(artdm));
            shoppingCartDm.registerObserver(cartObserver);
        }
    }



    protected Observer()
    {
        this$0 = BaseActivity.this;
        super();
    }
}
