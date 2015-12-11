// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.NotificationManagerCompat;
import android.text.Html;
import android.widget.RemoteViews;
import com.groupon.activity.IntentFactory;
import com.groupon.db.models.DealSummary;
import com.groupon.receiver.NotificationOpenedReceiver;
import com.groupon.tracking.mobile.sdk.Logger;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.util:
//            PicassoHelper, UriUtil, NotificationBuilderUtil

public class NotificationFactory
{
    public static class NotificationDetail
    {

        public String alertTitle;
        public DealSummary dealSummary;
        public Bitmap image;
        public String imageUrl;
        public boolean isDealNotification;
        public String link;
        public String nid;
        public NotificationType notificationType;
        public String price;
        public String purchaseLink;
        public String value;

        public NotificationDetail(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
                boolean flag, NotificationType notificationtype)
        {
            alertTitle = s;
            nid = s1;
            link = s2;
            purchaseLink = s3;
            imageUrl = s4;
            price = s5;
            value = s6;
            isDealNotification = flag;
            notificationType = notificationtype;
        }

        public NotificationDetail(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
                boolean flag, NotificationType notificationtype, DealSummary dealsummary)
        {
            alertTitle = s;
            nid = s1;
            link = s2;
            purchaseLink = s3;
            imageUrl = s4;
            price = s5;
            value = s6;
            dealSummary = dealsummary;
            isDealNotification = flag;
            notificationType = notificationtype;
        }
    }

    public static final class NotificationDetail.NotificationType extends Enum
    {

        private static final NotificationDetail.NotificationType $VALUES[];
        public static final NotificationDetail.NotificationType CLIENT_PULL;
        public static final NotificationDetail.NotificationType PROXIMITY;
        public static final NotificationDetail.NotificationType SERVER_PUSH;
        private String notificationTypeString;

        public static NotificationDetail.NotificationType valueOf(String s)
        {
            return (NotificationDetail.NotificationType)Enum.valueOf(com/groupon/util/NotificationFactory$NotificationDetail$NotificationType, s);
        }

        public static NotificationDetail.NotificationType[] values()
        {
            return (NotificationDetail.NotificationType[])$VALUES.clone();
        }

        static 
        {
            CLIENT_PULL = new NotificationDetail.NotificationType("CLIENT_PULL", 0, "{\"pushType\" : \"pull\"}");
            SERVER_PUSH = new NotificationDetail.NotificationType("SERVER_PUSH", 1, "{\"pushType\" : \"GCM\"}");
            PROXIMITY = new NotificationDetail.NotificationType("PROXIMITY", 2, "{\"pushType\" : \"proximity\"}");
            $VALUES = (new NotificationDetail.NotificationType[] {
                CLIENT_PULL, SERVER_PUSH, PROXIMITY
            });
        }


        private NotificationDetail.NotificationType(String s, int i, String s1)
        {
            super(s, i);
            notificationTypeString = s1;
        }
    }


    private static final int LIVE_CHAT_NOTIFICATION_REQUEST_CODE = 1;
    private IntentFactory intentFactory;
    private Logger logger;
    private NotificationManager notificationManager;
    private SharedPreferences sharedPreferences;

    public NotificationFactory()
    {
    }

    public Bitmap fetchImageBitmap(Context context, String s)
    {
        if (Strings.isEmpty(s))
        {
            return null;
        }
        try
        {
            context = PicassoHelper.getPicasso(context.getApplicationContext()).load(s).get();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            logger.logGeneralEvent("push_notifications", "http_exception", "image_uri_request", 1, Logger.NULL_NST_FIELD);
            return null;
        }
        return context;
    }

    public Intent getDealDeepLinkIntent(Context context, boolean flag, String s, String s1, String s2)
    {
        Intent intent = new Intent(context, com/groupon/receiver/NotificationOpenedReceiver);
        if (flag)
        {
            context = "com.groupon.PUSH_NOTIFICATION_OPENED";
        } else
        {
            context = "com.groupon.NOTIFICATION_OPENED";
        }
        return intent.setAction(context).putExtra("nid", s).putExtra("notificationType", s2).putExtra("not_null_link", s1);
    }

    public Intent getPurchaseDeepLinkIntent(Context context, String s, String s1)
    {
        return (new Intent(context, com/groupon/receiver/NotificationOpenedReceiver)).setAction("com.groupon.NOTIFICATION_OPENED").putExtra("nid", s).putExtra("not_null_link", s1).putExtra("is_wearable_preview_purchase", true);
    }

    public void sendLiveChatNotification(Context context, String s, int i)
    {
        Object obj = intentFactory.newLiveChatIntent();
        ((Intent) (obj)).setAction(Long.toString(System.currentTimeMillis()));
        obj = PendingIntent.getActivity(context, 1, ((Intent) (obj)), 0x8000000);
        s = (new android.app.Notification.Builder(context)).setContentTitle(context.getResources().getQuantityString(0x7f0c000c, i, new Object[] {
            Integer.valueOf(i)
        })).setContentText(s).setContentIntent(((PendingIntent) (obj))).setSmallIcon(0x7f0202a0).setPriority(1).setVibrate(new long[0]);
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            s.setColor(context.getResources().getColor(0x7f0e0135));
        }
        s = s.build();
        if (!sharedPreferences.getBoolean("silentNotifications", true))
        {
            s.sound = UriUtil.generateSoundUri(context, 0x7f070004);
        }
        s.flags = ((Notification) (s)).flags | 0x10;
        notificationManager.notify(com.groupon.Constants.Notification.NotificationType.NON_DEAL_NOTIFICATION.getId(), s);
    }

    public void sendLocalNotification(Context context, NotificationDetail notificationdetail)
    {
        if (Strings.isEmpty(notificationdetail.alertTitle) && !notificationdetail.isDealNotification)
        {
            logger.logGeneralEvent("push_notifications", "suppress", "missing_msg", 1, Logger.NULL_NST_FIELD);
            return;
        }
        Object obj = context.getResources().getString(0x7f080473);
        String s = Html.fromHtml(notificationdetail.alertTitle).toString();
        Object obj1;
        Object obj2;
        Object obj3;
        android.support.v4.app.NotificationCompat.WearableExtender wearableextender;
        int i;
        boolean flag;
        if (notificationdetail.dealSummary == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj1 = getDealDeepLinkIntent(context, flag, notificationdetail.nid, notificationdetail.link, notificationdetail.notificationType.notificationTypeString);
        obj2 = PendingIntent.getBroadcast(context, ((Intent) (obj1)).getExtras().toString().hashCode(), ((Intent) (obj1)), 0x8000000);
        obj3 = new android.support.v4.app.NotificationCompat.Builder(context);
        ((android.support.v4.app.NotificationCompat.Builder) (obj3)).setContentTitle(((CharSequence) (obj))).setContentText(s).setContentIntent(((PendingIntent) (obj2)));
        NotificationBuilderUtil.setupNotificationIcon(context, ((android.support.v4.app.NotificationCompat.Builder) (obj3)));
        wearableextender = new android.support.v4.app.NotificationCompat.WearableExtender();
        if (notificationdetail.purchaseLink != null)
        {
            obj = PendingIntent.getBroadcast(context, 1, getPurchaseDeepLinkIntent(context, notificationdetail.nid, notificationdetail.purchaseLink), 0x10000000);
            wearableextender.addAction((new android.support.v4.app.NotificationCompat.Action.Builder(0x7f0202ea, context.getResources().getString(0x7f0802e8), ((PendingIntent) (obj)))).build());
        }
        obj = null;
        notificationdetail.image = fetchImageBitmap(context, notificationdetail.imageUrl);
        if (notificationdetail.image != null)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (i != 0)
        {
            wearableextender.setBackground(notificationdetail.image);
            obj1 = new RemoteViews(context.getPackageName(), 0x7f0300b7);
            ((RemoteViews) (obj1)).setTextViewText(0x7f10007a, context.getResources().getString(0x7f080473));
            ((RemoteViews) (obj1)).setTextViewText(0x7f100208, s);
            ((RemoteViews) (obj1)).setImageViewBitmap(0x7f100121, notificationdetail.image);
            if (notificationdetail.isDealNotification)
            {
                ((RemoteViews) (obj1)).setViewVisibility(0x7f100209, 0);
                ((RemoteViews) (obj1)).setViewVisibility(0x7f10020a, 0);
            }
            if (Strings.notEmpty(notificationdetail.value) && !notificationdetail.value.equals(notificationdetail.price))
            {
                ((RemoteViews) (obj1)).setViewVisibility(0x7f10046a, 0);
                ((RemoteViews) (obj1)).setTextViewText(0x7f10046b, notificationdetail.value);
            }
            obj = obj1;
            if (Strings.notEmpty(notificationdetail.price))
            {
                ((RemoteViews) (obj1)).setViewVisibility(0x7f10046c, 0);
                ((RemoteViews) (obj1)).setTextViewText(0x7f10046c, notificationdetail.price);
                obj = obj1;
            }
        }
        ((android.support.v4.app.NotificationCompat.Builder) (obj3)).extend(wearableextender);
        if (i != 0)
        {
            obj1 = (new android.support.v4.app.NotificationCompat.BigPictureStyle(((android.support.v4.app.NotificationCompat.Builder) (obj3)))).build();
        } else
        {
            obj1 = ((android.support.v4.app.NotificationCompat.Builder) (obj3)).build();
        }
        obj3 = new RemoteViews(context.getPackageName(), 0x7f0300b8);
        ((RemoteViews) (obj3)).setTextViewText(0x7f10007a, context.getResources().getString(0x7f080473));
        ((RemoteViews) (obj3)).setTextViewText(0x7f100208, s);
        obj1.contentView = ((RemoteViews) (obj3));
        if (!sharedPreferences.getBoolean("silentNotifications", true))
        {
            obj1.sound = UriUtil.generateSoundUri(context, 0x7f070004);
        }
        if (obj != null)
        {
            obj1.bigContentView = ((RemoteViews) (obj));
        }
        obj1.contentIntent = ((PendingIntent) (obj2));
        if (notificationdetail.isDealNotification)
        {
            i = com.groupon.Constants.Notification.DEAL_NOTIFICATION_ID;
        } else
        {
            i = com.groupon.Constants.Notification.NON_DEAL_NOTIFICATION_ID + (int)Math.floor(Math.random() * 101D);
        }
        NotificationManagerCompat.from(context).notify(i, ((Notification) (obj1)));
        obj = logger;
        obj1 = notificationdetail.notificationType.notificationTypeString;
        s = notificationdetail.alertTitle;
        obj2 = notificationdetail.link;
        if (Strings.isEmpty(notificationdetail.nid))
        {
            context = "";
        } else
        {
            context = notificationdetail.nid;
        }
        ((Logger) (obj)).logPushNotification(((String) (obj1)), s, ((String) (obj2)), context, 0L, Logger.NULL_NST_FIELD);
        obj = logger;
        if (notificationdetail.isDealNotification)
        {
            context = "deal";
        } else
        {
            context = "non_deal";
        }
        ((Logger) (obj)).logGeneralEvent("push_notifications", "deliver", context, i, Logger.NULL_NST_FIELD);
    }
}
