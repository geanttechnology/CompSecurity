// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk.util;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.preference.PreferenceManager;
import pu;

// Referenced classes of package com.exacttarget.etpushsdk.util:
//            d, m, b

public class j
{

    private static boolean a = false;
    private static final Object b = new Object();

    protected static void a(Context context, String s)
    {
        android.support.v4.app.NotificationCompat.Builder builder = new android.support.v4.app.NotificationCompat.Builder(context);
        builder.setSmallIcon(context.getApplicationInfo().icon);
        builder.setAutoCancel(true);
        builder.setContentTitle(context.getString(context.getApplicationInfo().labelRes));
        builder.setTicker(s);
        builder.setContentText(s);
        builder.setSound(android.provider.Settings.System.DEFAULT_NOTIFICATION_URI);
        Object obj = new Intent("android.intent.action.VIEW");
        ((Intent) (obj)).setData(Uri.parse("market://details?id=com.google.android.gms"));
        synchronized (b)
        {
            int i = ((Integer)d.a(context, "et_notification_play_services_error_code_key", Integer.valueOf(0), new Object[] {
                PreferenceManager.getDefaultSharedPreferences(context)
            })).intValue();
            obj = PendingIntent.getActivity(context, i, ((Intent) (obj)), 0);
            d.a(context, "et_notification_play_services_error_code_key", Integer.valueOf(i + 1));
        }
        builder.setContentIntent(((PendingIntent) (obj)));
        s = builder.build();
        ((NotificationManager)context.getSystemService("notification")).notify(0x366d4731, s);
        return;
        context;
        s;
        JVM INSTR monitorexit ;
        throw context;
    }

    protected static void a(Context context, String s, boolean flag)
    {
        try
        {
            m.d("~!uh", s);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            m.c("~!uh", context.getMessage(), context);
            return;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_16;
        }
        a(context, s);
    }

    public static boolean a(Context context)
    {
        if (!com.exacttarget.etpushsdk.util.b.a()) goto _L2; else goto _L1
_L1:
        a = false;
_L4:
        return a;
_L2:
        if (!a)
        {
            int i = pu.a(context);
            if (i == 0)
            {
                a = true;
            } else
            {
                if (pu.c(i))
                {
                    a(context, (new StringBuilder()).append("Google Play Services Error: ").append(pu.a(i)).toString(), true);
                } else
                {
                    a(context, "Google Play Services is not supported on this Device.", false);
                }
                a = false;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

}
