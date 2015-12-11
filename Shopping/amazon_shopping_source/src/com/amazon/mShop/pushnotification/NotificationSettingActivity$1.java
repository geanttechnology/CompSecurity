// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.pushnotification;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.amazon.mShop.util.Util;

// Referenced classes of package com.amazon.mShop.pushnotification:
//            NotificationSettingActivity, NotificationsSettingView

class nMessageReceiver extends com.amazon.mShop.util.hNotificationMessageReceiver
{

    final NotificationSettingActivity this$0;

    public void onReceive(Context context, Intent intent)
    {
        context = intent.getExtras().getString("registration");
        if ((getCurrentView() instanceof NotificationsSettingView) && isErrorBoxShowing())
        {
            dismissErrorBox();
            if (!Util.isEmpty(context))
            {
                NotificationSettingActivity.access$002(NotificationSettingActivity.this, new NotificationsSettingView(NotificationSettingActivity.this, getIntent().getStringExtra("DefaultExpandedGroupId")));
                setRootView(NotificationSettingActivity.access$000(NotificationSettingActivity.this));
            }
        }
    }

    nMessageReceiver()
    {
        this$0 = NotificationSettingActivity.this;
        super();
    }
}
