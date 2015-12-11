// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.pushnotification;

import android.widget.CompoundButton;
import com.amazon.rio.j2me.client.services.mShop.PushNotificationSubscription;

// Referenced classes of package com.amazon.mShop.pushnotification:
//            NotificationsSettingView

class val.registrationId
    implements android.widget.onSettingAdapter._cls2
{

    final val.registrationId this$1;
    final String val$registrationId;
    final PushNotificationSubscription val$subscription;

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        NotificationsSettingView.access$900(_fld0, val$subscription, val$registrationId);
    }

    ()
    {
        this$1 = final_;
        val$subscription = pushnotificationsubscription;
        val$registrationId = String.this;
        super();
    }
}
