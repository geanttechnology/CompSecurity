// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.chat;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.cyberlink.you.database.Group;
import com.cyberlink.you.g;
import com.cyberlink.you.n;
import com.cyberlink.you.utility.LoadImageUtils;
import com.cyberlink.you.utility.ULogUtility;

// Referenced classes of package com.cyberlink.you.chat:
//            NotificationHelper

final class g
    implements Runnable
{

    final String a;
    final String b;
    final String c;
    final String d;
    final Group e;
    final Intent f;
    final String g;

    public void run()
    {
        Object obj;
        Object obj1;
        String s = a;
        obj = com.cyberlink.you.g.a().getApplicationContext();
        if (obj == null)
        {
            Log.d("NotificationHelper", (new StringBuilder()).append("[").append(s).append("] Notify fail. context = null").toString());
            ULogUtility.d(s, "Notify fail. context = null");
            return;
        }
        NotificationManager notificationmanager;
        android.graphics.Bitmap bitmap;
        try
        {
            obj1 = b;
            String s1 = c;
            String s2 = d;
            boolean flag = NotificationHelper.a(((Context) (obj)));
            notificationmanager = (NotificationManager)((Context) (obj)).getSystemService("notification");
            PendingIntent pendingintent = PendingIntent.getActivity(((Context) (obj)), NotificationHelper.a(((Context) (obj)), e), f, 0x10000000);
            bitmap = LoadImageUtils.a(((Context) (obj)), g);
            obj1 = (new android.support.v4.app.ilder(((Context) (obj)))).setContentTitle(((CharSequence) (obj1))).setContentText(s1).setSmallIcon(n.u_ic_bc_launcher).setAutoCancel(true).setTicker(s2).setContentIntent(pendingintent).setDefaults(NotificationHelper.b(flag)).setSound(NotificationHelper.a(flag));
        }
        catch (Exception exception)
        {
            Log.d("NotificationHelper", (new StringBuilder()).append("[").append(s).append("] Notify fail. exception = ").append(Log.getStackTraceString(exception)).toString());
            ULogUtility.d(s, (new StringBuilder()).append("Notify fail. exception = ").append(Log.getStackTraceString(exception)).toString());
            return;
        }
        if (bitmap == null) goto _L2; else goto _L1
_L1:
        ((android.support.v4.app.ilder) (obj1)).setLargeIcon(bitmap);
_L4:
        notificationmanager.cancel(2);
        notificationmanager.notify(e.c, 1, ((android.support.v4.app.ilder) (obj1)).build());
        Log.d("NotificationHelper", (new StringBuilder()).append("[").append(s).append("] Notify success.").toString());
        ULogUtility.d(s, "Notify success.");
        return;
_L2:
        obj = LoadImageUtils.a(((Context) (obj)));
        if (obj == null) goto _L4; else goto _L3
_L3:
        ((android.support.v4.app.ilder) (obj1)).setLargeIcon(((android.graphics.Bitmap) (obj)));
          goto _L4
    }

    ilder(String s, String s1, String s2, String s3, Group group, Intent intent, String s4)
    {
        a = s;
        b = s1;
        c = s2;
        d = s3;
        e = group;
        f = intent;
        g = s4;
        super();
    }
}
