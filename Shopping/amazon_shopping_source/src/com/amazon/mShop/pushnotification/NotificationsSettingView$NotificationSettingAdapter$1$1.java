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

class val.request
    implements com.amazon.mShop.model.auth.r._cls1._cls1
{

    final l.subscription this$2;
    final PushNotificationSubscription val$request;

    public void userCancelledSignIn()
    {
        NotificationsSettingView.access$600(_fld0, null);
    }

    public void userSuccessfullySignedIn()
    {
        PushNotificationManager pushnotificationmanager = PushNotificationManager.getInstance();
        NotificationsSettingView.access$700(_fld0).updateNotificationSubscriptions(pushnotificationmanager.getNewNotificationTarget(null), val$request, (new TaskCallbackFactory(NotificationsSettingView.access$100(_fld0))).getTaskCallback(_fld0));
        NotificationsSettingView.access$800(_fld0, true, subscription);
    }

    l.subscription()
    {
        this$2 = final_subscription;
        val$request = PushNotificationSubscription.this;
        super();
    }

    // Unreferenced inner class com/amazon/mShop/pushnotification/NotificationsSettingView$NotificationSettingAdapter$1

/* anonymous class */
    class NotificationsSettingView.NotificationSettingAdapter._cls1
        implements android.view.View.OnClickListener
    {

        final NotificationsSettingView.NotificationSettingAdapter this$1;
        final PushNotificationSubscription val$subscription;

        public void onClick(View view)
        {
            NotificationsSettingView.access$402(this$0, subscription);
            NotificationsSettingView.access$502(this$0, true);
            view = new PushNotificationSubscription();
            view.setGroupId(subscription.getGroupId());
            view.setSubscriptionId(subscription.getSubscriptionId());
            view.setSubscribed(true);
            NotificationsSettingView.access$100(this$0).authenticateUser(view. new NotificationsSettingView.NotificationSettingAdapter._cls1._cls1(), null);
        }

            
            {
                this$1 = final_notificationsettingadapter;
                subscription = PushNotificationSubscription.this;
                super();
            }
    }

}
