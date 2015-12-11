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

class this._cls2
    implements Runnable
{

    final c this$2;

    public void run()
    {
        com.amazon.mShop.platform.nstance().getDataStore().putBoolean("upgradeShouldShowDialog", false);
        UpgradeUtil.showUpgradeNotificationDialog(c);
    }

    c()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/amazon/mShop/about/MShopAboutView$2

/* anonymous class */
    class MShopAboutView._cls2
        implements android.view.View.OnClickListener
    {

        final MShopAboutView this$0;
        final Context val$c;

        public void onClick(View view)
        {
            UpgradeUtil.clearNewUpgradeInfo();
            view = new UpgradeController();
            view.setSubscriber(new MShopAboutView._cls2._cls1());
            view.checkForUpgrade((new TaskCallbackFactory(getContext())).getTaskCallback(view, com.amazon.mShop.android.lib.R.string.checking_for_upgrade));
        }

            
            {
                this$0 = final_mshopaboutview;
                c = Context.this;
                super();
            }
    }


    // Unreferenced inner class com/amazon/mShop/about/MShopAboutView$2$1

/* anonymous class */
    class MShopAboutView._cls2._cls1 extends UpgradeSubscriberAdapter
    {

        final MShopAboutView._cls2 this$1;

        public boolean awareUniqueId()
        {
            return false;
        }

        public void onError(final Exception e, ServiceCall servicecall)
        {
            com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new MShopAboutView._cls2._cls1._cls1());
        }

        public void onNoUpgrade()
        {
            com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new MShopAboutView._cls2._cls1._cls3());
        }

        public void onUpgradeAvailable(UpgradeInfo upgradeinfo)
        {
            com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new MShopAboutView._cls2._cls1._cls2());
        }

            
            {
                this$1 = MShopAboutView._cls2.this;
                super();
            }

        // Unreferenced inner class com/amazon/mShop/about/MShopAboutView$2$1$1

/* anonymous class */
        class MShopAboutView._cls2._cls1._cls1
            implements Runnable
        {

            final MShopAboutView._cls2._cls1 this$2;
            final Exception val$e;

            public void run()
            {
                AmazonErrorUtils.reportMShopServerError((AmazonActivity)c, null, this$0, e, c.getString(com.amazon.mShop.android.lib.R.string.ok));
            }

                    
                    {
                        this$2 = MShopAboutView._cls2._cls1.this;
                        e = exception;
                        super();
                    }
        }


        // Unreferenced inner class com/amazon/mShop/about/MShopAboutView$2$1$3

/* anonymous class */
        class MShopAboutView._cls2._cls1._cls3
            implements Runnable
        {

            final MShopAboutView._cls2._cls1 this$2;

            public void run()
            {
                showNoUpgradeDialog();
            }

                    
                    {
                        this$2 = MShopAboutView._cls2._cls1.this;
                        super();
                    }
        }

    }

}
