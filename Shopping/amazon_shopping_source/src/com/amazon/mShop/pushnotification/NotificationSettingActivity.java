// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.pushnotification;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.util.Util;

// Referenced classes of package com.amazon.mShop.pushnotification:
//            NotificationsSettingView

public class NotificationSettingActivity extends AmazonActivity
{

    private NotificationsSettingView mNotificationsSettingView;
    private com.amazon.mShop.util.MShopPushNotificationUtils.PushNotificationMessageReceiver mPushNotificationMessageReceiver;

    public NotificationSettingActivity()
    {
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        if (i == 0)
        {
            getIntent().putExtra("onResumeNeedRefresh", false);
        }
        super.onActivityResult(i, j, intent);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mPushNotificationMessageReceiver = new com.amazon.mShop.util.MShopPushNotificationUtils.PushNotificationMessageReceiver() {

            final NotificationSettingActivity this$0;

            public void onReceive(Context context, Intent intent)
            {
                context = intent.getExtras().getString("registration");
                if ((getCurrentView() instanceof NotificationsSettingView) && isErrorBoxShowing())
                {
                    dismissErrorBox();
                    if (!Util.isEmpty(context))
                    {
                        mNotificationsSettingView = new NotificationsSettingView(NotificationSettingActivity.this, getIntent().getStringExtra("DefaultExpandedGroupId"));
                        setRootView(mNotificationsSettingView);
                    }
                }
            }

            
            {
                this$0 = NotificationSettingActivity.this;
                super();
            }
        };
        registerReceiver(mPushNotificationMessageReceiver, new IntentFilter("com.amazon.mShop.android.PUSH_NOTIFICATION_RESPONSE"));
    }

    protected void onDestroy()
    {
        unregisterReceiver(mPushNotificationMessageReceiver);
        mPushNotificationMessageReceiver = null;
        super.onDestroy();
    }

    public void onStart()
    {
        super.onStart();
        if (getIntent().getBooleanExtra("onResumeNeedRefresh", true))
        {
            mNotificationsSettingView = new NotificationsSettingView(this, getIntent().getStringExtra("DefaultExpandedGroupId"));
            setRootView(mNotificationsSettingView);
        }
        getIntent().removeExtra("onResumeNeedRefresh");
    }



/*
    static NotificationsSettingView access$002(NotificationSettingActivity notificationsettingactivity, NotificationsSettingView notificationssettingview)
    {
        notificationsettingactivity.mNotificationsSettingView = notificationssettingview;
        return notificationssettingview;
    }

*/
}
