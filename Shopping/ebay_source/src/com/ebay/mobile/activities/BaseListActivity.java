// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Toast;
import com.ebay.common.view.EbayErrorHandler;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.search.MainSearchActivity;
import com.ebay.mobile.shoppingcart.ShoppingCartActivity;
import com.ebay.mobile.ui_stuff.MenuHandler;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.InternalDomainError;
import com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.shell.app.TrackingSupport;

// Referenced classes of package com.ebay.mobile.activities:
//            CoreListActivity, OptionsMenuGetter

public class BaseListActivity extends CoreListActivity
    implements OptionsMenuGetter, TrackingSupport
{
    class ShoppingCartBadgeCountUpdater
    {

        private com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase.SimpleObserver cartObserver;
        private ShoppingCartDataManagerBase shoppingCartDm;
        final BaseListActivity this$0;

        void getCartData()
        {
            if (optionsMenu != null && (BaseListActivity.this instanceof OptionsMenuGetter) && optionsMenu.findItem(0x7f1009e6) != null && shoppingCartDm != null && cartObserver != null)
            {
                shoppingCartDm.loadData(false, cartObserver);
            }
        }

        void registerShoppingCartObserver()
        {
            if (cartObserver == null && shoppingCartDm == null)
            {
                cartObserver = new com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase.SimpleObserver() {

                    final ShoppingCartBadgeCountUpdater this$1;

                    public void onShoppingCartChanged(ShoppingCartDataManagerBase shoppingcartdatamanagerbase, com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase.Action action, Content content)
                    {
                        ShoppingCartActivity.updateActionBarCount(_fld0);
                    }

            
            {
                this$1 = ShoppingCartBadgeCountUpdater.this;
                super();
            }
                };
                com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase.ServiceApi serviceapi = ShoppingCartDataManagerBase.getShoppingCartServiceApi();
                shoppingCartDm = (ShoppingCartDataManagerBase)ShoppingCartDataManagerBase.get(getEbayContext(), new com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase.KeyParams(serviceapi));
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

        ShoppingCartBadgeCountUpdater()
        {
            this$0 = BaseListActivity.this;
            super();
        }
    }


    protected Toast networkErrorToast;
    private Menu optionsMenu;
    private ShoppingCartBadgeCountUpdater shoppingCartBadgeCountUpdater;
    protected boolean useMenuHandler;

    public BaseListActivity()
    {
        useMenuHandler = true;
    }

    protected boolean cancelNetworkErrorOnClose()
    {
        return true;
    }

    public Menu getOptionsMenu()
    {
        return optionsMenu;
    }

    public String getTrackingEventName()
    {
        return null;
    }

    public void handleIafTokenExpiration()
    {
        MyApp.signOutForIafTokenFailure(this);
    }

    protected boolean networkAvailable()
    {
        if (Util.hasNetwork())
        {
            return true;
        } else
        {
            showNetworkErrorToast();
            return false;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        shoppingCartBadgeCountUpdater = new ShoppingCartBadgeCountUpdater();
        shoppingCartBadgeCountUpdater.registerShoppingCartObserver();
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        optionsMenu = menu;
        boolean flag = super.onCreateOptionsMenu(menu);
        if (useMenuHandler)
        {
            flag = MenuHandler.create(this, menu);
        }
        if (shoppingCartBadgeCountUpdater != null)
        {
            shoppingCartBadgeCountUpdater.getCartData();
        }
        return flag;
    }

    protected void onDestroy()
    {
        if (shoppingCartBadgeCountUpdater != null)
        {
            shoppingCartBadgeCountUpdater.unregisterShoppingCartObserver();
            shoppingCartBadgeCountUpdater = null;
        }
        super.onDestroy();
    }

    public boolean onPrepareOptionsMenu(Menu menu)
    {
        optionsMenu = menu;
        if (useMenuHandler)
        {
            MenuHandler.prepare(this, menu);
        }
        return super.onPrepareOptionsMenu(menu);
    }

    public boolean onSearchRequested()
    {
        startActivity(new Intent(this, com/ebay/mobile/search/MainSearchActivity));
        return false;
    }

    protected void onStop()
    {
        super.onStop();
        if (networkErrorToast != null && cancelNetworkErrorOnClose())
        {
            networkErrorToast.cancel();
            networkErrorToast = null;
        }
    }

    protected void showErrorToast(String s)
    {
        if (networkErrorToast != null)
        {
            networkErrorToast.cancel();
        }
        networkErrorToast = Toast.makeText(getApplicationContext(), s, 1);
        networkErrorToast.show();
    }

    protected boolean showMessageAsBar(com.ebay.nautilus.kernel.content.ResultStatus.Message message)
    {
        return InternalDomainError.isNoNetworkMessage(message) || super.showMessageAsBar(message);
    }

    public void showNetworkErrorToast()
    {
        EbayErrorHandler.handleResultStatus(this, -1, ResultStatus.create(new com.ebay.nautilus.kernel.content.ResultStatus.Message[] {
            InternalDomainError.getNoNetworkMessage()
        }));
    }

}
