// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.pushnotification;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.amazon.mShop.control.pushnotification.MShopNotificationSubScriber;
import com.amazon.mShop.control.pushnotification.NotificationSettingController;
import com.amazon.mShop.debug.DebugSettings;
import com.amazon.mShop.gno.GNODrawer;
import com.amazon.mShop.gno.GNOItemAdapter;
import com.amazon.mShop.kiang.KiangController;
import com.amazon.mShop.platform.AppLocale;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.util.MShopPushNotificationUtils;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.persistence.DataStore;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.NotificationTarget;

// Referenced classes of package com.amazon.mShop.pushnotification:
//            NotificationProviderFactory, NotificationProvider, NotificationParams, MShopNotificationGenerator

public class PushNotificationManager
{

    private static final boolean DEBUG = DebugSettings.isDebugEnabled();
    public static final String TAG = com/amazon/mShop/pushnotification/PushNotificationManager.getSimpleName();
    private static boolean sInstanceAvailable = true;
    private static PushNotificationManager sPushNotificationManager;
    private NotificationProvider mNotificationProvider;

    private PushNotificationManager()
    {
    }

    public static void clearInstance()
    {
        com/amazon/mShop/pushnotification/PushNotificationManager;
        JVM INSTR monitorenter ;
        sPushNotificationManager = null;
        sInstanceAvailable = true;
        com/amazon/mShop/pushnotification/PushNotificationManager;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public static PushNotificationManager getInstance()
    {
        com/amazon/mShop/pushnotification/PushNotificationManager;
        JVM INSTR monitorenter ;
        if (sPushNotificationManager != null || !sInstanceAvailable) goto _L2; else goto _L1
_L1:
        Object obj;
        NotificationProvider notificationprovider;
        obj = (Context)com.amazon.mShop.platform.Platform.Factory.getInstance().getApplicationContext();
        notificationprovider = NotificationProviderFactory.getInstance().newNotificationProvider();
        if (notificationprovider.isAvailable(((Context) (obj)))) goto _L4; else goto _L3
_L3:
        if (DEBUG)
        {
            Log.d(TAG, "device can't support push notification feature");
        }
        sInstanceAvailable = false;
        obj = null;
_L6:
        com/amazon/mShop/pushnotification/PushNotificationManager;
        JVM INSTR monitorexit ;
        return ((PushNotificationManager) (obj));
_L4:
        sPushNotificationManager = new PushNotificationManager();
        sPushNotificationManager.initializePushNotification(((Context) (obj)), notificationprovider);
_L2:
        obj = sPushNotificationManager;
        if (true) goto _L6; else goto _L5
_L5:
        Exception exception;
        exception;
        throw exception;
    }

    private boolean initializePushNotification(final Context notificationTarget, NotificationProvider notificationprovider)
    {
        if (!notificationprovider.isAvailable(notificationTarget))
        {
            if (DEBUG)
            {
                Log.d(TAG, "device can't support push notification feature");
            }
            return false;
        }
        mNotificationProvider = notificationprovider;
        startRegistration(notificationTarget);
        notificationTarget = getNewNotificationTarget(null);
        if (notificationTarget != null)
        {
            (new Thread(new Runnable() {

                final PushNotificationManager this$0;
                final NotificationTarget val$notificationTarget;

                public void run()
                {
                    if (PushNotificationManager.DEBUG)
                    {
                        Log.d(PushNotificationManager.TAG, (new StringBuilder()).append("curent registration id::").append(notificationTarget.getDestination()).toString());
                    }
                    updateDeviceToken(notificationTarget.getDestination());
                }

            
            {
                this$0 = PushNotificationManager.this;
                notificationTarget = notificationtarget;
                super();
            }
            })).start();
        }
        return true;
    }

    private void startRegistration(Context context)
    {
        mNotificationProvider.startRegister(context);
    }

    public void enableNotificationsForNewMarketplace(String s)
    {
        (new NotificationSettingController(new MShopNotificationSubScriber() {

            final PushNotificationManager this$0;

            public void onError(Exception exception, ServiceCall servicecall)
            {
                if (PushNotificationManager.DEBUG && !Util.isEmpty(exception.getMessage()))
                {
                    Log.e(PushNotificationManager.TAG, exception.getMessage());
                }
                MShopPushNotificationUtils.setLastMarketPlace(null);
            }

            public void onMarketplaceToggled(String s1, boolean flag)
            {
                if (s1.equals(AppLocale.getInstance().getMarketPlaceIdByLocale(AppLocale.getInstance().getCurrentLocaleName())))
                {
                    com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().putBoolean("isSupportNotifications", flag);
                    MShopPushNotificationUtils.setLastMarketPlace(AppLocale.getInstance().getCurrentLocaleName());
                    GNODrawer.getGNOItemAdapter().updateVisibleItems();
                }
            }

            
            {
                this$0 = PushNotificationManager.this;
                super();
            }
        })).toggleMarketPlace(getNewNotificationTarget(s), true, null);
    }

    public void enbleNotificationForAnonymousCustomer()
    {
        (new NotificationSettingController(new MShopNotificationSubScriber() {

            final PushNotificationManager this$0;

            
            {
                this$0 = PushNotificationManager.this;
                super();
            }
        })).toggleMarketPlace(getNewNotificationTarget(null), true, null);
    }

    public String getCurrentMShopDeviceToken()
    {
        return mNotificationProvider.getCurrentMShopRegistrationToken();
    }

    public String getCurrentPushNotificationErrorId()
    {
        return mNotificationProvider.getCurrentPushNotificationErrorId();
    }

    public String getErrorMessage(Context context, String s)
    {
        return mNotificationProvider.getErrorMessage(context, s);
    }

    public NotificationTarget getNewNotificationTarget(String s)
    {
        return mNotificationProvider.getNewNotificationTarget(s);
    }

    public NotificationProvider getNotificationProvider()
    {
        return mNotificationProvider;
    }

    public void handleClickActionOnErrorButton(Activity activity, String s)
    {
        mNotificationProvider.handleClickActionOnErrorButton(activity, s);
    }

    public void handlePushMessage(Context context, Intent intent)
    {
        intent = mNotificationProvider.constructNotificationParams(intent);
        String s = AppLocale.getInstance().getMarketPlaceIdByLocale(AppLocale.getInstance().getCurrentLocaleName());
        if (intent != null && intent.getMarketPlace() != null && intent.getMarketPlace().equals(s))
        {
            MShopNotificationGenerator.generateNotification(context, intent);
        }
    }

    public boolean matchNotificationProvider(Class class1)
    {
        if (class1 == null || mNotificationProvider == null)
        {
            return false;
        } else
        {
            return mNotificationProvider.getClass().equals(class1);
        }
    }

    public void onMainActivityDestroyed(Context context)
    {
        mNotificationProvider.onMainActivityDestroyed(context);
    }

    public void setCurrentPushNotificationErrorId(String s)
    {
        mNotificationProvider.setCurrentPushNotificationErrorId(s);
    }

    public void updateDataStore(String s)
    {
        mNotificationProvider.setCurrentMShopRegistrationToken(s);
        mNotificationProvider.setCurrentPushNotificationErrorId(null);
    }

    public void updateDeviceToken(final String registrationId)
    {
        if (!Util.isEmpty(registrationId))
        {
            String s = mNotificationProvider.getCurrentMShopRegistrationToken();
            if (!Util.isEmpty(s) && !s.equals(registrationId))
            {
                NotificationSettingController notificationsettingcontroller = new NotificationSettingController(new MShopNotificationSubScriber() {

                    final PushNotificationManager this$0;
                    final String val$registrationId;

                    public void onDeviceTokenUpdated()
                    {
                        updateDataStore(registrationId);
                        Context context = (Context)com.amazon.mShop.platform.Platform.Factory.getInstance().getApplicationContext();
                        KiangController.getInstance().kiangUpdate(context);
                    }

                    public void onError(Exception exception, ServiceCall servicecall)
                    {
                        if (PushNotificationManager.DEBUG && !Util.isEmpty(exception.getMessage()))
                        {
                            Log.e(PushNotificationManager.TAG, exception.getMessage());
                        }
                    }

            
            {
                this$0 = PushNotificationManager.this;
                registrationId = s;
                super();
            }
                });
                NotificationTarget notificationtarget = getNewNotificationTarget(registrationId);
                notificationsettingcontroller.updateDeviceToken(notificationtarget.getApplicationId(), notificationtarget.getType(), s, registrationId);
                return;
            }
            if (Util.isEmpty(s))
            {
                updateDataStore(registrationId);
                registrationId = (Context)com.amazon.mShop.platform.Platform.Factory.getInstance().getApplicationContext();
                KiangController.getInstance().kiangUpdate(registrationId);
                return;
            }
        }
    }


}
