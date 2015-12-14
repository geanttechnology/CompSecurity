// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.invite;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.IBinder;
import android.text.TextUtils;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.apiv3.util.Inventory;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.android.picsart.profile.invite:
//            i, GetRewardDialogActivity

public class NotificationRedeemService extends Service
{

    private static String a;

    public NotificationRedeemService()
    {
    }

    public static void a(Context context)
    {
        if (context == null)
        {
            return;
        }
        if (!TextUtils.isEmpty(a))
        {
            m.c(context.getApplicationContext(), a);
        }
        i.a(context).edit().putBoolean("redeem_reminder_worked", true).apply();
    }

    public IBinder onBind(Intent intent)
    {
        return null;
    }

    public int onStartCommand(Intent intent, int j, int k)
    {
        intent = i.a(getApplicationContext());
        if (intent.getBoolean("redeem_reminder_worked", false))
        {
            stopSelf();
            return 1;
        }
        intent.edit().putBoolean("redeem_reminder_worked", true).apply();
        if (!Inventory.isAdsEnabled() || !Inventory.isEditorAdsEnabled() || com.socialin.android.picsart.profile.invite.i.m(getApplicationContext()))
        {
            stopSelf();
            return 1;
        }
        if (intent.getBoolean("is_editor_active", false))
        {
            intent.edit().putBoolean("invite.redeem.reminder.notification.snoozed", true).apply();
            return 1;
        }
        if (!intent.getBoolean("exit_app", false))
        {
            AnalyticUtils.getInstance(this).track(new com.socialin.android.apiv3.events.EventsFactory.InviteFlowInfectEvent("push", 2, i.p(this)));
            intent = new Intent(this, com/socialin/android/picsart/profile/invite/GetRewardDialogActivity);
            intent.setFlags(0x10000000);
            startActivity(intent);
            return 1;
        } else
        {
            intent = new Intent();
            intent.setClassName(getApplicationContext(), "com.socialin.android.photo.deeplinking.UrlDeepLinkingActivity");
            intent.setData(Uri.parse("picsart://appinvite_redeem_reminder"));
            a = new String((new StringBuilder("2131755090")).toString());
            intent = PendingIntent.getActivity(this, -a.hashCode(), intent, 0);
            String s = a;
            String s1 = getString(0x7f0808af);
            String s2 = getString(0x7f0803c0);
            getString(0x7f0808af);
            m.a(this, s, s1, s2, 0x7f0204a6, intent);
            return 1;
        }
    }
}
