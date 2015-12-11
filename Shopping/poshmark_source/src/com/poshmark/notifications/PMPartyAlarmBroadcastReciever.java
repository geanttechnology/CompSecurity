// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.notifications;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.poshmark.application.PMApplication;
import com.poshmark.controllers.GlobalPartiesController;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.PmNotificationRecieverActivity;
import com.poshmark.ui.fragments.PartyFragment;

public class PMPartyAlarmBroadcastReciever extends BroadcastReceiver
{

    public PMPartyAlarmBroadcastReciever()
    {
    }

    private void fireNotification(Bundle bundle, String s, String s1)
    {
        s = (new android.app.Notification.Builder(PMApplication.getContext())).setSmallIcon(0x7f0200b3).setContentTitle("Poshmark").setContentText((new StringBuilder()).append(s1).append(" party is starting!").toString());
        s1 = new Intent(PMApplication.getContext(), com/poshmark/ui/PmNotificationRecieverActivity);
        s1.putExtra("NOTIFICATION_BUNDLE", bundle);
        s.setContentIntent(PendingIntent.getActivity(PMApplication.getContext(), 0, s1, 0x10000000));
        bundle = s.getNotification();
        s = (NotificationManager)PMApplication.getContext().getSystemService("notification");
        bundle.flags = ((Notification) (bundle)).flags | 0x10;
        s.notify(PMApplication.PARTY_START_NOTIFICATION_ID, bundle);
    }

    private Bundle preparePartyBundle(Intent intent)
    {
        Bundle bundle = new Bundle();
        bundle.putBundle("FRAGMENT_DATA", intent.getBundleExtra("FRAGMENT_DATA"));
        if (intent.getAction().equals("com.poshmark.intents.PARTY_ALARM"))
        {
            bundle.putSerializable("FRAGMENT", com/poshmark/ui/fragments/PartyFragment);
        }
        bundle.putInt("TYPE", 0);
        return bundle;
    }

    public void onReceive(Context context, Intent intent)
    {
        context = intent.getBundleExtra("FRAGMENT_DATA");
        String s = context.getString("PARTY_TITLE");
        Bundle bundle = preparePartyBundle(intent);
        PMActivity pmactivity = PMApplication.getApplicationObject().getTopActivity();
        if (pmactivity == null || !pmactivity.isActivityInForeground())
        {
            fireNotification(bundle, intent.getAction(), s);
            return;
        } else
        {
            GlobalPartiesController.getGlobalPartiesController().firePartyAlert(context);
            return;
        }
    }
}
