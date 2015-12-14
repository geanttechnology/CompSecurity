// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.autoupdatesdk.obf;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import com.baidu.autoupdatesdk.AppUpdateInfo;

// Referenced classes of package com.baidu.autoupdatesdk.obf:
//            ac, aj, af

public class g
{

    public static a a;
    public static final String b = "com.baidu.autoupdatesdk.ACTION_NEW_UPDATE";
    public static final String c = "com.baidu.autoupdatesdk.ACTION_DOWNLOAD_COMPLETE";
    private static g d;
    private int e;
    private Context f;
    private NotificationManager g;
    private android.support.v4.app.NotificationCompat.Builder h;

    private g(Context context)
    {
        f = context;
        g = (NotificationManager)context.getSystemService("notification");
        h = new android.support.v4.app.NotificationCompat.Builder(context);
        h.setSmallIcon(ac.d(context, "bdp_update_logo"));
        e = (new StringBuilder()).append(context.getPackageName()).append("com.baidu.autoupdatesdk").toString().hashCode();
        aj.a("BDAutoUpdateSDK", (new StringBuilder()).append("notifyId: ").append(e).toString());
    }

    public static g a(Context context)
    {
        if (d == null)
        {
            d = new g(context);
        }
        return d;
    }

    public void a()
    {
        g.cancel(e);
    }

    public void a(AppUpdateInfo appupdateinfo, a a1)
    {
        a = a1;
        a1 = new Intent();
        a1.setAction("com.baidu.autoupdatesdk.ACTION_NEW_UPDATE");
        a1.setPackage(f.getPackageName());
        appupdateinfo = appupdateinfo.getAppSname();
        String s = f.getString(ac.b(f, "bdp_update_new_download"));
        h.setProgress(0, 0, false).setContentTitle(appupdateinfo).setContentText(s).setContentInfo(null).setTicker(s).setLargeIcon(((BitmapDrawable)af.c(f)).getBitmap()).setWhen(0L).setContentIntent(PendingIntent.getBroadcast(f, e, a1, 0x8000000)).setAutoCancel(true).setDefaults(4);
        g.notify(e, h.build());
    }

    public void a(String s, a a1)
    {
        a = a1;
        a1 = new Intent();
        a1.setAction("com.baidu.autoupdatesdk.ACTION_DOWNLOAD_COMPLETE");
        a1.setPackage(f.getPackageName());
        String s1 = f.getString(ac.b(f, "bdp_update_download_complete"));
        h.setProgress(0, 0, false).setContentTitle(s).setContentText(s1).setContentInfo(null).setLargeIcon(((BitmapDrawable)af.c(f)).getBitmap()).setWhen(0L).setTicker(s1).setContentIntent(PendingIntent.getBroadcast(f, e, a1, 0x8000000)).setAutoCancel(true).setDefaults(4);
        g.notify(e, h.build());
    }

    public void a(String s, String s1, int i)
    {
        h.setProgress(100, i, false).setLargeIcon(((BitmapDrawable)af.c(f)).getBitmap()).setContentTitle(s).setContentText(null).setContentInfo(s1).setTicker("").setWhen(0L).setContentIntent(PendingIntent.getBroadcast(f, e, new Intent(), 0x8000000)).setOngoing(false).setDefaults(4);
        g.notify(e, h.build());
    }
}
