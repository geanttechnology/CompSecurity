// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.pushnotification;

import android.view.View;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.AmazonBrandedWebView;

// Referenced classes of package com.amazon.mShop.pushnotification:
//            NotificationsSettingView

class val.helpText
    implements android.view.cationsSettingView._cls4
{

    final NotificationsSettingView this$0;
    final String val$helpText;
    final String val$url;

    public void onClick(View view)
    {
        NotificationsSettingView.access$100(NotificationsSettingView.this).pushView(new AmazonBrandedWebView(NotificationsSettingView.access$100(NotificationsSettingView.this), val$url, val$helpText));
    }

    ()
    {
        this$0 = final_notificationssettingview;
        val$url = s;
        val$helpText = String.this;
        super();
    }
}
