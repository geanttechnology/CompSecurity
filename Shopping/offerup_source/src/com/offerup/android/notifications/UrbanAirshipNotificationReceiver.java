// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.notifications;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.e.a;
import com.b.a.a.g;
import com.b.a.a.j;
import com.offerup.android.b.b;
import com.offerup.android.service.PaymentLocationService;
import com.squareup.otto.Bus;
import com.urbanairship.push.BaseIntentReceiver;
import com.urbanairship.push.PushMessage;
import org.apache.commons.lang3.math.NumberUtils;

public class UrbanAirshipNotificationReceiver extends BaseIntentReceiver
{

    private com.offerup.android.activities.g a;

    public UrbanAirshipNotificationReceiver()
    {
    }

    protected void onBackgroundPushReceived(Context context, PushMessage pushmessage)
    {
        g.a("UrbanAirshipNotificationReceiver", (new StringBuilder("onBackgroundPushReceived:")).append(pushmessage.getPushBundle()).toString());
    }

    protected void onChannelRegistrationFailed(Context context)
    {
        g.a("UrbanAirshipNotificationReceiver", "onChannelRegistrationFailed");
    }

    protected void onChannelRegistrationSucceeded(Context context, String s)
    {
        g.a("UrbanAirshipNotificationReceiver", (new StringBuilder("onChannelRegistrationSucceeded: channelId=")).append(s).toString());
    }

    protected boolean onNotificationActionOpened(Context context, PushMessage pushmessage, int i, String s, boolean flag)
    {
        g.a("UrbanAirshipNotificationReceiver", String.format("onNotificationActionOpened: notificationId=%d, buttonId=%s, isForeground=%s, bundle=%s", new Object[] {
            Integer.valueOf(i), s, Boolean.valueOf(flag), pushmessage.getPushBundle()
        }));
        return false;
    }

    protected boolean onNotificationOpened(Context context, PushMessage pushmessage, int i)
    {
        g.a("UrbanAirshipNotificationReceiver", (new StringBuilder("onNotificationOpened: notificationId=")).append(i).append(", bundle=").append(pushmessage.getPushBundle()).toString());
        pushmessage.getPushBundle();
        context = (NotificationManager)context.getSystemService("notification");
        if (i > 0)
        {
            context.cancel(i);
        } else
        {
            context.cancelAll();
        }
        switch (android.support.v4.e.a.a(pushmessage))
        {
        case 4: // '\004'
        case 5: // '\005'
        default:
            g.a("UrbanAirshipNotificationReceiver", "handleHomeScreenNotification");
            a.a();
            return true;

        case 7: // '\007'
            context = pushmessage.getPushBundle();
            g.a("UrbanAirshipNotificationReceiver", "handleActionPathNotification");
            context = context.getString("action_path");
            a.a(context, true);
            return true;

        case 1: // '\001'
            context = pushmessage.getPushBundle();
            g.a("UrbanAirshipNotificationReceiver", "handlePaymentNotification");
            pushmessage = j.a();
            i = pushmessage.T();
            if (i > 0)
            {
                pushmessage.k(i - 1);
            }
            pushmessage = context.getString("thread_id");
            context = context.getString("order_id");
            if (NumberUtils.isDigits(pushmessage) && NumberUtils.isDigits(context))
            {
                a.a(Long.valueOf(pushmessage).longValue(), Long.valueOf(context).longValue());
                return true;
            } else
            {
                a.a();
                return true;
            }

        case 0: // '\0'
            context = pushmessage.getPushBundle();
            g.a("UrbanAirshipNotificationReceiver", "handleAlertNotification");
            pushmessage = j.a();
            String s = context.getString("thread_id");
            long l;
            if (NumberUtils.isDigits(s))
            {
                l = Long.valueOf(s).longValue();
            } else
            {
                l = 0L;
            }
            if (l > 0L && pushmessage.T() > 1)
            {
                pushmessage.k(0);
                a.c(l);
                return true;
            }
            if (l > 0L)
            {
                if (context != null && context.containsKey("thread_id"))
                {
                    i = 1;
                } else
                {
                    i = 0;
                }
                if (i != 0)
                {
                    pushmessage.k(0);
                    a.a(l);
                    return true;
                }
            }
            a.a();
            return true;

        case 2: // '\002'
            context = pushmessage.getPushBundle();
            g.a("UrbanAirshipNotificationReceiver", "handleFollowerNotification");
            context = context.getString("follower_id");
            if (NumberUtils.isDigits(context))
            {
                a.b(Long.valueOf(context).longValue());
                return true;
            } else
            {
                a.a();
                return true;
            }

        case 3: // '\003'
            context = pushmessage.getPushBundle();
            if (context.containsKey("goto_url"))
            {
                try
                {
                    context = context.getString("goto_url");
                    g.a(getClass().getSimpleName(), (new StringBuilder("handleDeeplinkPushNotification: ")).append(context).toString());
                    context = Uri.parse(context);
                    a.a(context);
                }
                // Misplaced declaration of an exception variable
                catch (Context context)
                {
                    g.a(this, context);
                    a.a();
                    return true;
                }
                return true;
            } else
            {
                g.a(getClass().getSimpleName(), "handleDeeplinkPushNotification: malformed payload, no deeplink url");
                a.a();
                return true;
            }

        case 6: // '\006'
            context = pushmessage.getPushBundle();
            g.a("UrbanAirshipNotificationReceiver", "handleRatingNotification");
            context = context.getString("item_rating_id");
            break;
        }
        if (NumberUtils.isDigits(context))
        {
            a.d(Long.valueOf(context).longValue());
            return true;
        } else
        {
            a.a();
            return true;
        }
    }

    protected void onPushReceived(Context context, PushMessage pushmessage, int i)
    {
        context = pushmessage.getPushBundle();
        g.a("UrbanAirshipNotificationReceiver", (new StringBuilder("onPushReceived:notificationId: ")).append(context).toString());
        switch (android.support.v4.e.a.a(pushmessage))
        {
        default:
            return;

        case 1: // '\001'
            String s = context.getString("order_id", "0");
            if (NumberUtils.isDigits(s))
            {
                pushmessage = a;
                long l = Long.parseLong(s);
                try
                {
                    Intent intent = new Intent(((com.offerup.android.activities.g) (pushmessage)).a, com/offerup/android/service/PaymentLocationService);
                    intent.putExtra("paymentId", l);
                    intent.putExtra("isSeller", true);
                    ((com.offerup.android.activities.g) (pushmessage)).a.startService(intent);
                }
                catch (Exception exception)
                {
                    g.a(pushmessage.getClass().getSimpleName(), exception);
                }
            }
            // fall through

        case 0: // '\0'
            context = context.getString("thread_id");
            break;
        }
        try
        {
            l = Long.valueOf(context).longValue();
            com.offerup.android.b.a.getInstance().post(new b(l, i));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            g.a("UrbanAirshipNotificationReceiver", context);
        }
    }

    public void onReceive(Context context, Intent intent)
    {
        a = new com.offerup.android.activities.g(context);
        super.onReceive(context, intent);
    }
}
