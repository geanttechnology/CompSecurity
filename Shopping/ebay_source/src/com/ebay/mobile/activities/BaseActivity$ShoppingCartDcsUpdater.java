// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.database.DataSetObserver;
import android.view.Menu;
import com.ebay.mobile.ui_stuff.MenuHandler;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;

// Referenced classes of package com.ebay.mobile.activities:
//            BaseActivity, OptionsMenuGetter

protected class this._cls0
{
    private class DcsRefreshObserver extends DataSetObserver
    {

        private Menu optionsMenu;
        private BaseActivity parent;
        final BaseActivity.ShoppingCartDcsUpdater this$1;

        public void onChanged()
        {
            MenuHandler.prepare(parent, optionsMenu);
            BaseActivity.ShoppingCartBadgeCountUpdater.access$100(BaseActivity.access$300(this$0));
        }

        public DcsRefreshObserver(BaseActivity baseactivity, Menu menu)
        {
            this$1 = BaseActivity.ShoppingCartDcsUpdater.this;
            super();
            parent = baseactivity;
            optionsMenu = menu;
        }
    }


    private DcsRefreshObserver dcsRefreshObserver;
    final BaseActivity this$0;

    protected void registerDcsObserver()
    {
        if (dcsRefreshObserver == null && BaseActivity.access$200(BaseActivity.this) != null && (BaseActivity.this instanceof OptionsMenuGetter))
        {
            dcsRefreshObserver = new DcsRefreshObserver(BaseActivity.this, BaseActivity.access$200(BaseActivity.this));
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

    protected DcsRefreshObserver.optionsMenu()
    {
        this$0 = BaseActivity.this;
        super();
    }
}
