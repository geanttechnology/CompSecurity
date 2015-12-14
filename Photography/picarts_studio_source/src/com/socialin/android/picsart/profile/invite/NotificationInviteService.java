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
import com.socialin.android.constants.EventParam;
import com.socialin.android.picsart.profile.util.GalleryUtils;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.android.picsart.profile.invite:
//            i, InviteActivity

public class NotificationInviteService extends Service
{

    private static String a;

    public NotificationInviteService()
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
        i.a(context).edit().putBoolean("invite_reminder_worked", true).apply();
    }

    public IBinder onBind(Intent intent)
    {
        return null;
    }

    public int onStartCommand(Intent intent, int j, int k)
    {
        Object obj = i.a(getApplicationContext());
        if (((SharedPreferences) (obj)).getBoolean("invite_reminder_worked", false))
        {
            stopSelf();
            return 1;
        }
        ((SharedPreferences) (obj)).edit().putBoolean("invite_reminder_worked", true).apply();
        if (i.n(getApplicationContext()) || i.o(getApplicationContext()) || i.l(getApplicationContext()))
        {
            stopSelf();
            return 1;
        }
        if (((SharedPreferences) (obj)).getBoolean("is_editor_active", false))
        {
            ((SharedPreferences) (obj)).edit().putBoolean("invite.reminder.notification.snoozed", true).apply();
            return 1;
        }
        if (!((SharedPreferences) (obj)).getBoolean("exit_app", false))
        {
            i.a(com.socialin.android.constants.CommonConstants.InviteMode.AD_REMOVER);
            intent = new Intent(this, com/socialin/android/picsart/profile/invite/InviteActivity);
            intent.putExtra("campaign", "ad_remover");
            intent.putExtra("from", EventParam.NOTIFICATIONS_REMINDER.getName());
            intent.setFlags(0x14000000);
            i.a("ad_remover");
            startActivity(intent);
            return 1;
        } else
        {
            long l = System.currentTimeMillis();
            long l1 = ((SharedPreferences) (obj)).getLong("invite.redeem.start.time", 0L);
            obj = GalleryUtils.a((int)(i.b() - (l - l1)) / 1000, getApplicationContext());
            Object obj1 = new Intent();
            ((Intent) (obj1)).setClassName(getApplicationContext(), "com.socialin.android.photo.deeplinking.UrlDeepLinkingActivity");
            ((Intent) (obj1)).setData(Uri.parse("picsart://appinvite_invite_reminder"));
            a = new String((new StringBuilder("2131755089")).toString());
            intent = PendingIntent.getActivity(this, -a.hashCode(), intent, 0);
            obj1 = a;
            String s = getString(0x7f0808af);
            obj = getString(0x7f0803bf, new Object[] {
                obj
            });
            getString(0x7f0808af);
            m.a(this, ((String) (obj1)), s, ((String) (obj)), 0x7f0204a6, intent);
            return 1;
        }
    }
}
