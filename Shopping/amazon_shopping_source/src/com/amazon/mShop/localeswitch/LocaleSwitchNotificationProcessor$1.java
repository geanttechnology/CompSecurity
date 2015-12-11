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
//            LocaleSwitchNotificationProcessor, ToggleMarketNotificationSubScriber

class oller extends NotificationSettingController
{

    final LocaleSwitchNotificationProcessor this$0;
    final boolean val$triggerSwitchLocaleInCA;

    public void completed(final ToggleMarketplaceNotificationsResponse value, final ServiceCall sc)
    {
        com.amazon.mShop.platform.ificationsResponse().invokeLater(new Runnable() {

            final LocaleSwitchNotificationProcessor._cls1 this$1;
            final ServiceCall val$sc;
            final ToggleMarketplaceNotificationsResponse val$value;

            public void run()
            {
label0:
                {
                    if (isRunningServiceCall(sc))
                    {
                        if (triggerSwitchLocaleInCA)
                        {
                            break label0;
                        }
                        ((ToggleMarketNotificationSubScriber)getSubscriber()).onMarketplaceToggled(value.getMarketplaceId(), value.getMarketplaceSupportsNotifications().booleanValue());
                        serviceCallCompleted();
                    }
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
                ((ToggleMarketNotificationSubScriber)getSubscriber()).onMarketplaceToggledReuseProgress(value.getMarketplaceId(), ((com.amazon.mShop.AmazonProgressDialog) (obj)));
                serviceCallCompletedReuseProgDiag();
            }

            
            {
                this$1 = LocaleSwitchNotificationProcessor._cls1.this;
                sc = servicecall;
                value = togglemarketplacenotificationsresponse;
                super();
            }
        });
    }

    protected void handleServiceCallError()
    {
        if (!val$triggerSwitchLocaleInCA)
        {
            super.handleServiceCallError();
            return;
        }
        Object obj = (com.amazon.mShop.kCallback)getTaskCallback();
        if (obj != null)
        {
            obj = ((com.amazon.mShop.kCallback) (obj)).getProgressDialog();
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
            ((com.amazon.mShop.kCallback)super.getTaskCallback()).endTaskWithoutDismissProgDiag();
            super.setTaskCallback(null);
        }
        super.setServiceCall(null);
    }






    _cls1.val.value(boolean flag)
    {
        this$0 = final_localeswitchnotificationprocessor;
        val$triggerSwitchLocaleInCA = flag;
        super(NotificationSubscriber.this);
    }
}
