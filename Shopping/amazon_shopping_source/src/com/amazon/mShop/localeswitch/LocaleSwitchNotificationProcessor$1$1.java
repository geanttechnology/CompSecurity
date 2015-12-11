// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.localeswitch;

import com.amazon.mShop.control.TaskCallback;
import com.amazon.mShop.control.pushnotification.NotificationSettingController;
import com.amazon.mShop.control.pushnotification.NotificationSubscriber;
import com.amazon.mShop.platform.Platform;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.ToggleMarketplaceNotificationsResponse;

// Referenced classes of package com.amazon.mShop.localeswitch:
//            ToggleMarketNotificationSubScriber, LocaleSwitchNotificationProcessor

class ionsResponse
    implements Runnable
{

    final rviceCallCompletedReuseProgDiag this$1;
    final ServiceCall val$sc;
    final ToggleMarketplaceNotificationsResponse val$value;

    public void run()
    {
label0:
        {
            if (RunningServiceCall(val$sc))
            {
                if (triggerSwitchLocaleInCA)
                {
                    break label0;
                }
                ((ToggleMarketNotificationSubScriber)tSubscriber()).onMarketplaceToggled(val$value.getMarketplaceId(), val$value.getMarketplaceSupportsNotifications().booleanValue());
                rviceCallCompleted();
            }
            return;
        }
        Object obj = (com.amazon.mShop.allback)tTaskCallback();
        if (obj != null)
        {
            obj = ((com.amazon.mShop.allback) (obj)).getProgressDialog();
        } else
        {
            obj = null;
        }
        ((ToggleMarketNotificationSubScriber)tSubscriber()).onMarketplaceToggledReuseProgress(val$value.getMarketplaceId(), ((com.amazon.mShop.AmazonProgressDialog) (obj)));
        rviceCallCompletedReuseProgDiag();
    }

    ionsResponse()
    {
        this$1 = final_ionsresponse;
        val$sc = servicecall;
        val$value = ToggleMarketplaceNotificationsResponse.this;
        super();
    }

    // Unreferenced inner class com/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor$1

/* anonymous class */
    class LocaleSwitchNotificationProcessor._cls1 extends NotificationSettingController
    {

        final LocaleSwitchNotificationProcessor this$0;
        final boolean val$triggerSwitchLocaleInCA;

        public void completed(ToggleMarketplaceNotificationsResponse togglemarketplacenotificationsresponse, final ServiceCall sc)
        {
            com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(togglemarketplacenotificationsresponse. new LocaleSwitchNotificationProcessor._cls1._cls1());
        }

        protected void handleServiceCallError()
        {
            if (!triggerSwitchLocaleInCA)
            {
                super.handleServiceCallError();
                return;
            }
            Object obj = (com.amazon.mShop.TaskCallbackFactory.LocaleSwithchTaskCallback)getTaskCallback();
            if (obj != null)
            {
                obj = ((com.amazon.mShop.TaskCallbackFactory.LocaleSwithchTaskCallback) (obj)).getProgressDialog();
            } else
            {
                obj = null;
            }
            ((ToggleMarketNotificationSubScriber)getSubscriber()).setProgDiag(((com.amazon.mShop.AmazonProgressDialog) (obj)));
            serviceCallCompletedReuseProgDiag();
        }

        protected void serviceCallCompletedReuseProgDiag()
        {
            if (super.getTaskCallback() != null)
            {
                ((com.amazon.mShop.TaskCallbackFactory.LocaleSwithchTaskCallback)super.getTaskCallback()).endTaskWithoutDismissProgDiag();
                super.setTaskCallback(null);
            }
            super.setServiceCall(null);
        }






            
            {
                this$0 = final_localeswitchnotificationprocessor;
                triggerSwitchLocaleInCA = flag;
                super(NotificationSubscriber.this);
            }
    }

}
