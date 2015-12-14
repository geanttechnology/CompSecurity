// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.notifications;

import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import com.amazon.gallery.foundation.utils.di.BeanFactory;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.auth.AuthenticationManager;
import com.amazon.gallery.thor.syncframework.NewPromotionSyncSchedulerWrapper;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.amazon.gallery.framework.kindle.notifications:
//            NewPromotionNotification

public class NewPromotionNotificationHandler
{

    public static final TimeUnit NEW_PROMOTION_SYNC_INTERVAL_UNIT;
    private static final String TAG = com/amazon/gallery/framework/kindle/notifications/NewPromotionNotificationHandler.getName();

    public NewPromotionNotificationHandler()
    {
    }

    public static void dismissNotification(Context context)
    {
        ((NotificationManager)context.getSystemService("notification")).cancel(com/amazon/gallery/framework/kindle/notifications/NewPromotionNotification.getName().hashCode());
    }

    public static String getLastShownPromotionId(Context context)
    {
        return context.getSharedPreferences("galleryKindleSharedPrefs", 0).getString("new_promotion_notification_last_shown_promotion_id", "");
    }

    public static void scheduleNewPromotionCheck(Context context, BeanFactory beanfactory)
    {
        beanfactory = (AuthenticationManager)beanfactory.getBean(Keys.AUTHENTICATING_MANAGER);
        if (beanfactory == null)
        {
            GLogger.i(TAG, "Cannot schedule new promotion check. No user manager.", new Object[0]);
            return;
        }
        beanfactory = beanfactory.getAccountId();
        if (beanfactory == null)
        {
            GLogger.i(TAG, "Cannot schedule new promotion check. No account.", new Object[0]);
            return;
        } else
        {
            (new NewPromotionSyncSchedulerWrapper(context, beanfactory)).scheduleBackgroundSync(context, context.getSharedPreferences("galleryKindleSharedPrefs", 0).getLong("NEW_PROMOTION_CHECK_BACKGROUND_WIFI_WAKE_INTERVAL", 60L), NEW_PROMOTION_SYNC_INTERVAL_UNIT);
            return;
        }
    }

    public static void setPromotionShown(Context context, String s)
    {
        context.getSharedPreferences("galleryKindleSharedPrefs", 0).edit().putString("new_promotion_notification_last_shown_promotion_id", s).apply();
    }

    static 
    {
        NEW_PROMOTION_SYNC_INTERVAL_UNIT = TimeUnit.MINUTES;
    }
}
