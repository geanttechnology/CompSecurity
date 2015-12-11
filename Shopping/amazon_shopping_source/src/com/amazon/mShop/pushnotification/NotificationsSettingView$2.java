// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.pushnotification;


// Referenced classes of package com.amazon.mShop.pushnotification:
//            NotificationsSettingView, PushNotificationManager

class val.errorId
    implements com.amazon.mShop.error.oxActionListener
{

    final NotificationsSettingView this$0;
    final String val$errorId;

    public void onActionButtonClick(int i)
    {
        PushNotificationManager.getInstance().handleClickActionOnErrorButton(NotificationsSettingView.access$100(NotificationsSettingView.this), val$errorId);
    }

    tener()
    {
        this$0 = final_notificationssettingview;
        val$errorId = String.this;
        super();
    }
}
