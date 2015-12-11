// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.localeswitch;

import android.content.Context;
import com.amazon.mShop.TaskCallbackFactory;
import com.amazon.mShop.control.Cancellable;
import com.amazon.mShop.control.TaskCallback;
import com.amazon.mShop.control.pushnotification.NotificationSettingController;
import com.amazon.mShop.control.pushnotification.NotificationSubscriber;
import com.amazon.mShop.platform.AppLocale;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.pushnotification.PushNotificationManager;
import com.amazon.mShop.util.ConfigUtils;
import com.amazon.mShop.util.MShopPushNotificationUtils;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.ToggleMarketplaceNotificationsResponse;
import java.util.Locale;

// Referenced classes of package com.amazon.mShop.localeswitch:
//            LocaleSwitchProcessor, ToggleMarketNotificationSubScriber, LocaleSwitchChain

public class LocaleSwitchNotificationProcessor
    implements LocaleSwitchProcessor
{

    public LocaleSwitchNotificationProcessor()
    {
    }

    public void doProcess(String s, Context context, final LocaleSwitchChain settingController)
    {
        int i;
        boolean flag;
        if (AppLocale.isLocaleOfCA(AppLocale.getInstance().getCurrentLocale().toString()) && AppLocale.isLocaleOfCA(s))
        {
            i = 1;
        } else
        {
            i = 0;
        }
        flag = AppLocale.isLocaleOfCA(s);
        if (MShopPushNotificationUtils.isPushNotificationAvailable())
        {
            settingController = new NotificationSettingController(flag) {

                final LocaleSwitchNotificationProcessor this$0;
                final boolean val$triggerSwitchLocaleInCA;

                public void completed(ToggleMarketplaceNotificationsResponse togglemarketplacenotificationsresponse, final ServiceCall sc)
                {
                    com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(togglemarketplacenotificationsresponse. new Runnable() {

                        final _cls1 this$1;
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
                this$1 = final__pcls1;
                sc = servicecall;
                value = ToggleMarketplaceNotificationsResponse.this;
                super();
            }
                    });
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
                this$0 = LocaleSwitchNotificationProcessor.this;
                triggerSwitchLocaleInCA = flag;
                super(final_notificationsubscriber);
            }
            };
            Cancellable cancellable;
            if (i != 0)
            {
                i = com.amazon.mShop.android.lib.R.string.config_notifications_changing_language;
            } else
            {
                i = com.amazon.mShop.android.lib.R.string.config_notifications_changing_country;
            }
            cancellable = new Cancellable() {

                final LocaleSwitchNotificationProcessor this$0;
                final NotificationSettingController val$settingController;

                public void cancel()
                {
                    settingController.cancel();
                }

            
            {
                this$0 = LocaleSwitchNotificationProcessor.this;
                settingController = notificationsettingcontroller;
                super();
            }
            };
            if (flag)
            {
                s = (new TaskCallbackFactory(context)).getLocaleSwitchFinishTaskCallback(cancellable, null, ConfigUtils.getStringForSpecificLocale(context, i, s), null);
            } else
            {
                s = (new TaskCallbackFactory(context)).getTaskCallback(cancellable, ConfigUtils.getStringForSpecificLocale(context, i, s));
            }
            settingController.toggleMarketPlace(PushNotificationManager.getInstance().getNewNotificationTarget(null), false, s);
            return;
        } else
        {
            settingController.process();
            return;
        }
    }
}
