// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;
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
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.shell.app.TrackingSupport;

// Referenced classes of package com.ebay.mobile.activities:
//            CoreActivity, OptionsMenuGetter

public class BaseActivity extends CoreActivity
    implements OptionsMenuGetter, TrackingSupport
{
    protected class ShoppingCartBadgeCountUpdater
    {

        private com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase.SimpleObserver cartObserver;
        private ShoppingCartDataManagerBase shoppingCartDm;
        final BaseActivity this$0;

        private void getCartData()
        {
            if (optionsMenu != null && (BaseActivity.this instanceof OptionsMenuGetter) && optionsMenu.findItem(0x7f1009e6) != null && shoppingCartDm != null && cartObserver != null)
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



        protected ShoppingCartBadgeCountUpdater()
        {
            this$0 = BaseActivity.this;
            super();
        }
    }

    protected class ShoppingCartDcsUpdater
    {

        private DcsRefreshObserver dcsRefreshObserver;
        final BaseActivity this$0;

        protected void registerDcsObserver()
        {
            if (dcsRefreshObserver == null && optionsMenu != null && (BaseActivity.this instanceof OptionsMenuGetter))
            {
                dcsRefreshObserver = new DcsRefreshObserver(BaseActivity.this, optionsMenu);
                DeviceConfiguration.registerObserver(dcsRefreshObserver);
            }
        }

        protected void unregisterDcsObserver()
        {
            if (dcsRefreshObserver != null)
            {
                DeviceConfiguration.unregisterObserver(dcsRefreshObserver);
                dcsRefreshObserver = null;
            }
        }

        protected ShoppingCartDcsUpdater()
        {
            this$0 = BaseActivity.this;
            super();
        }
    }

    private class ShoppingCartDcsUpdater.DcsRefreshObserver extends DataSetObserver
    {

        private Menu optionsMenu;
        private BaseActivity parent;
        final ShoppingCartDcsUpdater this$1;

        public void onChanged()
        {
            MenuHandler.prepare(parent, optionsMenu);
            shoppingCartBadgeCountUpdater.getCartData();
        }

        public ShoppingCartDcsUpdater.DcsRefreshObserver(BaseActivity baseactivity, Menu menu)
        {
            this$1 = ShoppingCartDcsUpdater.this;
            super();
            parent = baseactivity;
            optionsMenu = menu;
        }
    }


    private static boolean cartVisibilityDcsCheckCompleted;
    protected Toast networkErrorToast;
    private Menu optionsMenu;
    private ShoppingCartBadgeCountUpdater shoppingCartBadgeCountUpdater;
    private ShoppingCartDcsUpdater shoppingCartDcsUpdater;
    protected boolean useMenuHandler;

    public BaseActivity()
    {
        useMenuHandler = true;
    }

    protected boolean cancelNetworkErrorOnClose()
    {
        return true;
    }

    public String getNetworkErrorToastString()
    {
        if (!Util.hasNetwork())
        {
            return getString(0x7f07024c);
        } else
        {
            return getString(0x7f07024a);
        }
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
        if (!cartVisibilityDcsCheckCompleted)
        {
            shoppingCartDcsUpdater = new ShoppingCartDcsUpdater();
            cartVisibilityDcsCheckCompleted = true;
        }
        shoppingCartBadgeCountUpdater = new ShoppingCartBadgeCountUpdater();
        shoppingCartBadgeCountUpdater.registerShoppingCartObserver();
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        optionsMenu = menu;
        boolean flag = super.onCreateOptionsMenu(menu);
        if (useMenuHandler)
        {
            boolean flag1 = MenuHandler.create(this, menu);
            if (shoppingCartDcsUpdater != null)
            {
                shoppingCartDcsUpdater.registerDcsObserver();
            }
            flag = flag1;
            if (shoppingCartBadgeCountUpdater != null)
            {
                shoppingCartBadgeCountUpdater.getCartData();
                flag = flag1;
            }
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
        if (shoppingCartDcsUpdater != null)
        {
            shoppingCartDcsUpdater.unregisterDcsObserver();
            shoppingCartDcsUpdater = null;
        }
        super.onDestroy();
    }

    public boolean onPrepareOptionsMenu(Menu menu)
    {
        optionsMenu = menu;
        boolean flag = super.onPrepareOptionsMenu(menu);
        if (useMenuHandler)
        {
            MenuHandler.prepare(this, menu);
        }
        return flag;
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

    protected void refresh()
    {
    }

    protected void set_view_text(int i, String s)
    {
        TextView textview = (TextView)findViewById(i);
        if (textview != null && s != null)
        {
            textview.setText(s);
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
