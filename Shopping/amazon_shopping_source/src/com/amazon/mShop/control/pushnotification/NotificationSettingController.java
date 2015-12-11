// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.pushnotification;

import com.amazon.mShop.control.BaseController;
import com.amazon.mShop.control.GenericSubscriber;
import com.amazon.mShop.control.ServiceController;
import com.amazon.mShop.control.TaskCallback;
import com.amazon.mShop.platform.Platform;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.GetNotificationSubscriptionsRequest;
import com.amazon.rio.j2me.client.services.mShop.GetNotificationSubscriptionsResponse;
import com.amazon.rio.j2me.client.services.mShop.GetNotificationSubscriptionsResponseListener;
import com.amazon.rio.j2me.client.services.mShop.MShopService;
import com.amazon.rio.j2me.client.services.mShop.NotificationTarget;
import com.amazon.rio.j2me.client.services.mShop.PushNotificationSubscription;
import com.amazon.rio.j2me.client.services.mShop.SetNotificationSubscriptionsRequest;
import com.amazon.rio.j2me.client.services.mShop.SetNotificationSubscriptionsResponse;
import com.amazon.rio.j2me.client.services.mShop.SetNotificationSubscriptionsResponseListener;
import com.amazon.rio.j2me.client.services.mShop.ToggleMarketplaceNotificationsRequest;
import com.amazon.rio.j2me.client.services.mShop.ToggleMarketplaceNotificationsResponse;
import com.amazon.rio.j2me.client.services.mShop.ToggleMarketplaceNotificationsResponseListener;
import com.amazon.rio.j2me.client.services.mShop.UpdateNotificationTargetRequest;
import com.amazon.rio.j2me.client.services.mShop.UpdateNotificationTargetResponse;
import com.amazon.rio.j2me.client.services.mShop.UpdateNotificationTargetResponseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

// Referenced classes of package com.amazon.mShop.control.pushnotification:
//            NotificationSubscriber

public class NotificationSettingController extends BaseController
    implements GetNotificationSubscriptionsResponseListener, SetNotificationSubscriptionsResponseListener, ToggleMarketplaceNotificationsResponseListener, UpdateNotificationTargetResponseListener
{

    private NotificationSubscriber mSubscriber;

    public NotificationSettingController(NotificationSubscriber notificationsubscriber)
    {
        mSubscriber = notificationsubscriber;
    }

    public static NotificationTarget constructNotificationTarget(String s, int i, String s1)
    {
        NotificationTarget notificationtarget = new NotificationTarget();
        notificationtarget.setApplicationId(s);
        notificationtarget.setDestination(s1);
        notificationtarget.setType(i);
        return notificationtarget;
    }

    public void completed(final GetNotificationSubscriptionsResponse value, final ServiceCall sc)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final NotificationSettingController this$0;
            final ServiceCall val$sc;
            final GetNotificationSubscriptionsResponse val$value;

            public void run()
            {
                if (isRunningServiceCall(sc))
                {
                    mSubscriber.onSubscriptionsReceived(value);
                    serviceCallCompleted();
                }
            }

            
            {
                this$0 = NotificationSettingController.this;
                sc = servicecall;
                value = getnotificationsubscriptionsresponse;
                super();
            }
        });
    }

    public void completed(SetNotificationSubscriptionsResponse setnotificationsubscriptionsresponse, final ServiceCall sc)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final NotificationSettingController this$0;
            final ServiceCall val$sc;

            public void run()
            {
                if (isRunningServiceCall(sc))
                {
                    mSubscriber.onSubscriptionUpdated();
                    serviceCallCompleted();
                }
            }

            
            {
                this$0 = NotificationSettingController.this;
                sc = servicecall;
                super();
            }
        });
    }

    public void completed(final ToggleMarketplaceNotificationsResponse value, final ServiceCall sc)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final NotificationSettingController this$0;
            final ServiceCall val$sc;
            final ToggleMarketplaceNotificationsResponse val$value;

            public void run()
            {
                if (isRunningServiceCall(sc))
                {
                    mSubscriber.onMarketplaceToggled(value.getMarketplaceId(), value.getMarketplaceSupportsNotifications().booleanValue());
                    serviceCallCompleted();
                }
            }

            
            {
                this$0 = NotificationSettingController.this;
                sc = servicecall;
                value = togglemarketplacenotificationsresponse;
                super();
            }
        });
    }

    public void completed(UpdateNotificationTargetResponse updatenotificationtargetresponse, final ServiceCall sc)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final NotificationSettingController this$0;
            final ServiceCall val$sc;

            public void run()
            {
                if (isRunningServiceCall(sc))
                {
                    mSubscriber.onDeviceTokenUpdated();
                    serviceCallCompleted();
                }
            }

            
            {
                this$0 = NotificationSettingController.this;
                sc = servicecall;
                super();
            }
        });
    }

    public void getNotificationSubscriptions(NotificationTarget notificationtarget, TaskCallback taskcallback)
    {
        cancel();
        GetNotificationSubscriptionsRequest getnotificationsubscriptionsrequest = new GetNotificationSubscriptionsRequest();
        getnotificationsubscriptionsrequest.setNotificationTarget(notificationtarget);
        serviceCallStarted(ServiceController.getMShopService().getNotificationSubscriptions(getnotificationsubscriptionsrequest, this), taskcallback);
    }

    protected volatile GenericSubscriber getSubscriber()
    {
        return getSubscriber();
    }

    protected NotificationSubscriber getSubscriber()
    {
        return mSubscriber;
    }

    public void toggleMarketPlace(NotificationTarget notificationtarget, boolean flag, TaskCallback taskcallback)
    {
        cancel();
        ToggleMarketplaceNotificationsRequest togglemarketplacenotificationsrequest = new ToggleMarketplaceNotificationsRequest();
        togglemarketplacenotificationsrequest.setNotificationTarget(notificationtarget);
        togglemarketplacenotificationsrequest.setEnableNotifications(Boolean.valueOf(flag));
        serviceCallStarted(ServiceController.getMShopService().toggleMarketplaceNotifications(togglemarketplacenotificationsrequest, this), taskcallback);
    }

    public void updateDeviceToken(String s, int i, String s1, String s2)
    {
        cancel();
        UpdateNotificationTargetRequest updatenotificationtargetrequest = new UpdateNotificationTargetRequest();
        updatenotificationtargetrequest.setNewNotificationTarget(constructNotificationTarget(s, i, s2));
        updatenotificationtargetrequest.setOldNotificationTarget(constructNotificationTarget(s, i, s1));
        serviceCallStarted(ServiceController.getMShopService().updateNotificationTarget(updatenotificationtargetrequest, this), null);
    }

    public void updateNotificationSubscriptions(NotificationTarget notificationtarget, PushNotificationSubscription pushnotificationsubscription, TaskCallback taskcallback)
    {
        cancel();
        SetNotificationSubscriptionsRequest setnotificationsubscriptionsrequest = new SetNotificationSubscriptionsRequest();
        ArrayList arraylist = new ArrayList(1);
        arraylist.add(pushnotificationsubscription);
        setnotificationsubscriptionsrequest.setSubscriptions(new Vector(arraylist));
        setnotificationsubscriptionsrequest.setNotificationTarget(notificationtarget);
        serviceCallStarted(ServiceController.getMShopService().setNotificationSubscriptions(setnotificationsubscriptionsrequest, this), taskcallback);
    }









}
