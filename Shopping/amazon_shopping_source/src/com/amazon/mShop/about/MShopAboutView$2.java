// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.about;

import android.content.Context;
import android.view.View;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.TaskCallbackFactory;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.upgrade.UpgradeController;
import com.amazon.mShop.upgrade.UpgradeSubscriberAdapter;
import com.amazon.mShop.util.AmazonErrorUtils;
import com.amazon.mShop.util.UpgradeUtil;
import com.amazon.rio.j2me.client.persistence.DataStore;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.UpgradeInfo;

// Referenced classes of package com.amazon.mShop.about:
//            MShopAboutView

class val.c
    implements android.view.ner
{

    final MShopAboutView this$0;
    final Context val$c;

    public void onClick(View view)
    {
        UpgradeUtil.clearNewUpgradeInfo();
        view = new UpgradeController();
        view.setSubscriber(new UpgradeSubscriberAdapter() {

            final MShopAboutView._cls2 this$1;

            public boolean awareUniqueId()
            {
                return false;
            }

            public void onError(Exception exception, ServiceCall servicecall)
            {
                com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(exception. new Runnable() {

                    final _cls1 this$2;
                    final Exception val$e;

                    public void run()
                    {
                        AmazonErrorUtils.reportMShopServerError((AmazonActivity)c, null, this$0, e, c.getString(com.amazon.mShop.android.lib.R.string.ok));
                    }

            
            {
                this$2 = final__pcls1;
                e = Exception.this;
                super();
            }
                });
            }

            public void onNoUpgrade()
            {
                com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

                    final _cls1 this$2;

                    public void run()
                    {
                        showNoUpgradeDialog();
                    }

            
            {
                this$2 = _cls1.this;
                super();
            }
                });
            }

            public void onUpgradeAvailable(UpgradeInfo upgradeinfo)
            {
                com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

                    final _cls1 this$2;

                    public void run()
                    {
                        com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().putBoolean("upgradeShouldShowDialog", false);
                        UpgradeUtil.showUpgradeNotificationDialog(c);
                    }

            
            {
                this$2 = _cls1.this;
                super();
            }
                });
            }

            
            {
                this$1 = MShopAboutView._cls2.this;
                super();
            }
        });
        view.checkForUpgrade((new TaskCallbackFactory(getContext())).getTaskCallback(view, com.amazon.mShop.android.lib._for_upgrade));
    }

    erAdapter()
    {
        this$0 = final_mshopaboutview;
        val$c = Context.this;
        super();
    }
}
