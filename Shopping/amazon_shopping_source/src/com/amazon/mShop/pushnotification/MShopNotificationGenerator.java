// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.pushnotification;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.util.ConfigUtils;
import com.amazon.mShop.util.MShopSystemNotificationManagerUtil;
import com.amazon.mShop.util.Util;

// Referenced classes of package com.amazon.mShop.pushnotification:
//            NotificationParams, NotificationContentActivity, MShopClearNotificationReceiver

public class MShopNotificationGenerator
{

    public MShopNotificationGenerator()
    {
    }

    private static Notification createSystemNotification(Context context, String s, String s1, PendingIntent pendingintent, PendingIntent pendingintent1, String s2, int i)
    {
        int k = android.os.Build.VERSION.SDK_INT;
        int j = com.amazon.mShop.android.lib.R.drawable.amzn_statsbar_icon;
        s2 = null;
        if (k == 14 || k == 15)
        {
            j = com.amazon.mShop.android.lib.R.drawable.amzn_statsbar_icon_large;
        }
        if (k > 15)
        {
            s2 = new android.support.v4.app.NotificationCompat.BigTextStyle();
            s2.bigText(s1).setBigContentTitle(s);
        }
        context = MShopSystemNotificationManagerUtil.newNotification(context, s, s1, s1, pendingintent, pendingintent1, s2, j, i);
        context.flags = ((Notification) (context)).flags | 0x10;
        return context;
    }

    public static void generateNotification(Context context, NotificationParams notificationparams)
    {
        String s;
        Object obj;
        String s1;
        int i;
        boolean flag;
        s1 = notificationparams.getNotificationType();
        s = ConfigUtils.getString(context, com.amazon.mShop.android.lib.R.string.config_switchableAppName);
        flag = false;
        i = 0;
        obj = new Intent(context, com/amazon/mShop/pushnotification/NotificationContentActivity);
        ((Intent) (obj)).putExtra("NotificationType", s1);
        ((Intent) (obj)).putExtra("NotificationMarketPlace", notificationparams.getMarketPlace());
        ((Intent) (obj)).putExtra("ref", notificationparams.getRefMarker());
        if (!s1.equals("LD")) goto _L2; else goto _L1
_L1:
        updateDealContentIntent(((Intent) (obj)), (NotificationParams.DealNotificationParams)notificationparams);
_L4:
        obj = PendingIntent.getActivity(context, 0, ((Intent) (obj)), 0x8000000);
        Object obj1 = new Intent(context, com/amazon/mShop/pushnotification/MShopClearNotificationReceiver);
        ((Intent) (obj1)).putExtra("NotificationType", s1);
        obj1 = PendingIntent.getBroadcast(context, 0, ((Intent) (obj1)), 0x50000000);
        MShopSystemNotificationManagerUtil.notifyToSystem(createSystemNotification(context, s, notificationparams.getMessage(), ((PendingIntent) (obj)), ((PendingIntent) (obj1)), s1, i), context);
        return;
_L2:
        if (s1.equals("OD"))
        {
            ((Intent) (obj)).setAction("GoToDetailedOrder");
            String s2 = ((NotificationParams.OrderNotificationParams)notificationparams).getOrderId();
            if (!Util.isEmpty(s2))
            {
                ((Intent) (obj)).putExtra("order_id", s2);
                ((Intent) (obj)).setData(Uri.parse((new StringBuilder()).append("?orderId=").append(s2).toString()));
            }
            RefMarkerObserver.logRefMarker("pn_shipped_r");
        } else
        if (s1.equals("DP"))
        {
            ((Intent) (obj)).setAction("GoToUDP");
            ((Intent) (obj)).putExtra("asin", ((NotificationParams.ProductDetailNotificationParams)notificationparams).getAsin());
            ((Intent) (obj)).setData(Uri.parse((new StringBuilder()).append("?asin=").append(((NotificationParams.ProductDetailNotificationParams)notificationparams).getAsin()).toString()));
        } else
        if (s1.equals("AD"))
        {
            ((Intent) (obj)).setAction("GoToDealsLandingPage");
            RefMarkerObserver.logRefMarker("pn_dotd_r");
        } else
        if (s1.equals("SNS"))
        {
            ((Intent) (obj)).putExtra("data", ((NotificationParams.SnsNotificationParams)notificationparams).getToken());
            ((Intent) (obj)).setAction("GoToSNS");
            RefMarkerObserver.logRefMarker("pn_sns_r");
        } else
        if (s1.equals("DL"))
        {
            String s3 = ((NotificationParams.DeepLinkNotificationParams)notificationparams).getUrl();
            ((Intent) (obj)).setAction("GoToDeepLink");
            ((Intent) (obj)).setData(Uri.parse(s3));
        } else
        if (s1.equals("SL"))
        {
            String s4 = ((NotificationParams.SmartLinkNotificationParams)notificationparams).getUrl();
            ((Intent) (obj)).setAction("GoToSmartLink");
            ((Intent) (obj)).setData(Uri.parse(s4));
        } else
        if (s1.equals("COINS"))
        {
            s = ((NotificationParams.CoinsNotificationParams)notificationparams).getUrl();
            obj = new Intent();
            ((Intent) (obj)).setAction("android.intent.action.VIEW");
            ((Intent) (obj)).setData(Uri.parse(s));
            s = ((NotificationParams.CoinsNotificationParams)notificationparams).getTitle();
            i = ((flag) ? 1 : 0);
            if (((NotificationParams.CoinsNotificationParams)notificationparams).useCoinsIcon())
            {
                if (android.os.Build.VERSION.SDK_INT == 14 || android.os.Build.VERSION.SDK_INT == 15)
                {
                    i = com.amazon.mShop.android.lib.R.drawable.coins_icon_large;
                } else
                {
                    i = com.amazon.mShop.android.lib.R.drawable.coins_icon;
                }
            }
            RefMarkerObserver.logRefMarker("pn_coins_r");
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private static void updateDealContentIntent(Intent intent, NotificationParams.DealNotificationParams dealnotificationparams)
    {
        if (!Util.isEmpty(dealnotificationparams.getAsin()))
        {
            intent.setAction("GoToUDP");
            intent.putExtra("asin", dealnotificationparams.getAsin());
            intent.setData(Uri.parse((new StringBuilder()).append("?asin=").append(dealnotificationparams.getAsin()).toString()));
            RefMarkerObserver.logRefMarker("pn_single_ld_r");
            return;
        }
        if (!Util.isEmpty(dealnotificationparams.getCategory()))
        {
            intent.putExtra("refineCategory", dealnotificationparams.getCategory());
            intent.putExtra("refineCategoryDisplayName", dealnotificationparams.getCategoryDisplayName());
            intent.setData(Uri.parse((new StringBuilder()).append("?category=").append(dealnotificationparams.getCategory()).toString()));
            RefMarkerObserver.logRefMarker("pn_group_ld_r");
        } else
        {
            RefMarkerObserver.logRefMarker("pn_all_ld_r");
        }
        intent.setAction("GoToDealListPage");
    }
}
