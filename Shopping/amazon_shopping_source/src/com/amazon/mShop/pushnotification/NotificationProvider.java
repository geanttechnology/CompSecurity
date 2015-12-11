// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.pushnotification;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.amazon.rio.j2me.client.services.mShop.NotificationTarget;

// Referenced classes of package com.amazon.mShop.pushnotification:
//            NotificationParams

public interface NotificationProvider
{

    public abstract NotificationParams constructNotificationParams(Intent intent);

    public abstract String getCurrentMShopRegistrationToken();

    public abstract String getCurrentPushNotificationErrorId();

    public abstract String getErrorMessage(Context context, String s);

    public abstract NotificationTarget getNewNotificationTarget(String s);

    public abstract String getProviderName();

    public abstract void handleClickActionOnErrorButton(Activity activity, String s);

    public abstract boolean isAvailable(Context context);

    public abstract void onMainActivityDestroyed(Context context);

    public abstract void setCurrentMShopRegistrationToken(String s);

    public abstract void setCurrentPushNotificationErrorId(String s);

    public abstract void startRegister(Context context);
}
