// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.autoupdatesdk.obf;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

// Referenced classes of package com.baidu.autoupdatesdk.obf:
//            ac, aj

public class d
{

    public static a a;
    public static final String b = "com.baidu.autoupdatesdk.ACTION_NEW_AS";
    public static final String c = "com.baidu.autoupdatesdk.ACTION_AS_DOWNLOAD_COMPLETE";
    private static d d;
    private int e;
    private Context f;
    private NotificationManager g;
    private android.support.v4.app.NotificationCompat.Builder h;

    private d(Context context)
    {
        f = context;
        g = (NotificationManager)context.getSystemService("notification");
        h = new android.support.v4.app.NotificationCompat.Builder(context);
        h.setSmallIcon(ac.d(context, "bdp_update_logo"));
        e = (new StringBuilder()).append(context.getPackageName()).append("com.baidu.autoupdatesdk.4as").toString().hashCode();
        aj.a("BDAutoUpdateSDK", (new StringBuilder()).append("notifyId: ").append(e).toString());
    }

    public static d a(Context context)
    {
        if (d == null)
        {
            d = new d(context);
        }
        return d;
    }

    public void a()
    {
        g.cancel(e);
    }

    public void a(a a1)
    {
        a = a1;
        a1 = new Intent();
        a1.setAction("com.baidu.autoupdatesdk.ACTION_NEW_AS");
        a1.setPackage(f.getPackageName());
        String s = f.getString(ac.b(f, "bdp_update_as_notify_title"));
        String s1 = f.getString(ac.b(f, "bdp_update_as_notify_tip"));
        h.setProgress(0, 0, false).setContentTitle(s).setContentText(s1).setContentInfo(null).setTicker(s1).setWhen(0L).setContentIntent(PendingIntent.getBroadcast(f, e, a1, 0x8000000)).setAutoCancel(true).setDefaults(4);
        g.notify(e, h.build());
    }

    public void a(String s, int i)
    {
        String s1 = f.getString(ac.b(f, "bdp_update_as_notify_title"));
        h.setProgress(100, i, false).setContentTitle(s1).setContentText(null).setContentInfo(s).setTicker("").setWhen(0L).setContentIntent(PendingIntent.getBroadcast(f, e, new Intent(), 0x8000000)).setOngoing(false).setDefaults(4);
        g.notify(e, h.build());
    }

    public void b(a a1)
    {
        a = a1;
        a1 = new Intent();
        a1.setAction("com.baidu.autoupdatesdk.ACTION_AS_DOWNLOAD_COMPLETE");
        a1.setPackage(f.getPackageName());
        String s = f.getString(ac.b(f, "bdp_update_as_download_complete"));
        String s1 = f.getString(ac.b(f, "bdp_update_as_notify_title"));
        h.setProgress(0, 0, false).setContentTitle(s1).setContentText(s).setContentInfo(null).setWhen(0L).setTicker(s).setContentIntent(PendingIntent.getBroadcast(f, e, a1, 0x8000000)).setAutoCancel(true).setDefaults(4);
        g.notify(e, h.build());
    }
}
