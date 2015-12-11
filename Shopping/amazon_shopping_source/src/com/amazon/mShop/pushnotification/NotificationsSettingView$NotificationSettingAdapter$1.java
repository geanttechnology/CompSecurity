// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.pushnotification;

import android.view.View;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.TaskCallbackFactory;
import com.amazon.mShop.control.pushnotification.NotificationSettingController;
import com.amazon.rio.j2me.client.services.mShop.PushNotificationSubscription;

// Referenced classes of package com.amazon.mShop.pushnotification:
//            NotificationsSettingView, PushNotificationManager

class val.subscription
    implements android.view.tionSettingAdapter._cls1
{

    final val.subscription this$1;
    final PushNotificationSubscription val$subscription;

    public void onClick(final View request)
    {
        NotificationsSettingView.access$402(_fld0, val$subscription);
        NotificationsSettingView.access$502(_fld0, true);
        request = new PushNotificationSubscription();
        request.setGroupId(val$subscription.getGroupId());
        request.setSubscriptionId(val$subscription.getSubscriptionId());
        request.setSubscribed(true);
        NotificationsSettingView.access$100(_fld0).authenticateUser(new com.amazon.mShop.model.auth.UserSubscriber.Callback() {

            final NotificationsSettingView.NotificationSettingAdapter._cls1 this$2;
            final PushNotificationSubscription val$request;

            public void userCancelledSignIn()
            {
                NotificationsSettingView.access$600(this$0, null);
            }

            public void userSuccessfullySignedIn()
            {
                PushNotificationManager pushnotificationmanager = PushNotificationManager.getInstance();
                NotificationsSettingView.access$700(this$0).updateNotificationSubscriptions(pushnotificationmanager.getNewNotificationTarget(null), request, (new TaskCallbackFactory(NotificationsSettingView.access$100(this$0))).getTaskCallback(this$0));
                NotificationsSettingView.access$800(this$0, true, subscription);
            }

            
            {
                this$2 = NotificationsSettingView.NotificationSettingAdapter._cls1.this;
                request = pushnotificationsubscription;
                super();
            }
        }, null);
    }

    _cls1.val.request()
    {
        this$1 = final_request;
        val$subscription = PushNotificationSubscription.this;
        super();
    }
}
