// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.notifications.gcm_service;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.poshmark.application.PMApplication;
import com.poshmark.data_model.models.BadgeCount;
import com.poshmark.notifications.PMNotificationManager;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.PmNotificationRecieverActivity;
import com.poshmark.utils.GCMUtils;
import com.poshmark.utils.NMostRecentPushNotifications;

public class GcmIntentService extends IntentService
{

    int NEWS;
    int PARTY;

    public GcmIntentService()
    {
        super("GcmIntentService");
        PARTY = 0;
        NEWS = 1;
    }

    private void fireNotification(Bundle bundle)
    {
        Object obj2 = bundle.getString("message");
        Object obj1 = bundle.getString("priority");
        String s = bundle.getString("badge");
        String s1 = bundle.getString("type");
        Object obj = obj1;
        if (obj1 == null)
        {
            obj = new String("1");
        }
        if (PMApplication.getApplicationObject().getTopActivity() != null)
        {
            PMNotificationManager.fireNotification("com.poshmark.intents.PUSH_NOTIFICATION", bundle);
            bundle = new Bundle();
            bundle.putInt("TAB_INDEX", 3);
            PMNotificationManager.fireNotification("com.poshmark.intents.SWITCH_TAB", bundle);
        }
        obj1 = (new android.support.v4.app.NotificationCompat.Builder(PMApplication.getContext())).setSmallIcon(0x7f0200b3);
        bundle = new NMostRecentPushNotifications();
        bundle.loadAll();
        bundle.add(new com.poshmark.utils.NMostRecentPushNotifications.PushMessage(((String) (obj2)), ((String) (obj))));
        int j = bundle.getCount();
        new String();
        if (j == 1)
        {
            ((android.support.v4.app.NotificationCompat.Builder) (obj1)).setContentTitle(PMApplication.getContext().getString(0x7f06027f));
            ((android.support.v4.app.NotificationCompat.Builder) (obj1)).setContentText(((CharSequence) (obj2)));
        } else
        {
            ((android.support.v4.app.NotificationCompat.Builder) (obj1)).setContentTitle(String.format(PMApplication.getContext().getString(0x7f0601ab), new Object[] {
                Integer.valueOf(j)
            }));
            ((android.support.v4.app.NotificationCompat.Builder) (obj1)).setContentInfo(Integer.toString(j));
            ((android.support.v4.app.NotificationCompat.Builder) (obj1)).setContentText(bundle.getVIPMessage().getMessage());
        }
        obj = new Bundle();
        ((Bundle) (obj)).putInt("TYPE", 1);
        ((Bundle) (obj)).putString("PUSH_MESSAGE", ((String) (obj2)));
        ((Bundle) (obj)).putString("BADGE", s);
        ((Bundle) (obj)).putString("PUSH_MESSAGE_TYPE", s1);
        obj2 = new android.support.v4.app.NotificationCompat.InboxStyle();
        for (int i = 0; i < j; i++)
        {
            ((android.support.v4.app.NotificationCompat.InboxStyle) (obj2)).addLine(bundle.get(i).getMessage());
        }

        ((android.support.v4.app.NotificationCompat.Builder) (obj1)).setStyle(((android.support.v4.app.NotificationCompat.Style) (obj2)));
        obj2 = new Intent(PMApplication.getContext(), com/poshmark/ui/PmNotificationRecieverActivity);
        ((Intent) (obj2)).putExtra("NOTIFICATION_BUNDLE", ((Bundle) (obj)));
        ((android.support.v4.app.NotificationCompat.Builder) (obj1)).setContentIntent(PendingIntent.getActivity(this, 0, ((Intent) (obj2)), 0x10000000));
        obj = ((android.support.v4.app.NotificationCompat.Builder) (obj1)).build();
        obj1 = (NotificationManager)PMApplication.getContext().getSystemService("notification");
        obj.flags = ((Notification) (obj)).flags | 0x10;
        ((NotificationManager) (obj1)).notify(PMApplication.PM_PUSH_NOTIFICATION_ID, ((Notification) (obj)));
        bundle.flush();
    }

    private void handleNotification(Bundle bundle)
    {
        BadgeCount.incrementCount();
        PMActivity pmactivity = PMApplication.getApplicationObject().getTopActivity();
        bundle.getString("message");
        if (pmactivity == null || !pmactivity.isActivityInForeground())
        {
            fireNotification(bundle);
            return;
        } else
        {
            PMNotificationManager.fireNotification("com.poshmark.intents.PUSH_NOTIFICATION", bundle);
            return;
        }
    }

    protected void onHandleIntent(Intent intent)
    {
        if (!intent.getAction().equals("com.google.android.c2dm.intent.RECEIVE")) goto _L2; else goto _L1
_L1:
        Bundle bundle = intent.getExtras();
        intent = GoogleCloudMessaging.getInstance(this).getMessageType(intent);
        if (!bundle.isEmpty() && "gcm".equals(intent))
        {
            handleNotification(bundle);
        }
_L4:
        return;
_L2:
        if (!intent.getAction().equals("android.intent.action.MY_PACKAGE_REPLACED"))
        {
            break; /* Loop/switch isn't completed */
        }
        Log.d("PM Intent", "updating app");
        intent = new GCMUtils();
        if (intent.checkPlayServices(this))
        {
            Log.d("PM update", "forcing a registration");
            intent.forceRegisterWithGCM(PMApplication.getContext());
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (!intent.getAction().equals("com.poshmark.intents.FETCH_GCM_TOKEN"))
        {
            continue; /* Loop/switch isn't completed */
        }
        intent = new GCMUtils();
        if (intent.checkPlayServices(this))
        {
            Log.d("PM update", "forcing a registration");
            intent.forceRegisterWithGCM(PMApplication.getContext());
            intent.setTimerForFreshGcmTokenFetch();
            return;
        }
        continue; /* Loop/switch isn't completed */
        if (!intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) goto _L4; else goto _L5
_L5:
        intent = new GCMUtils();
        if (intent.checkPlayServices(this))
        {
            Log.d("PM update", "system rebooted");
            intent.forceRegisterWithGCM(PMApplication.getContext());
            return;
        }
        if (true) goto _L4; else goto _L6
_L6:
    }
}
