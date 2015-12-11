// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.service;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.text.format.Time;
import android.util.Log;
import android.widget.RemoteViews;
import com.aio.downloader.utils.MD5;
import com.aio.downloader.utils.MyAppInfo;
import com.aio.downloader.utils.Myutils;
import com.umeng.analytics.MobclickAgent;
import java.io.File;

// Referenced classes of package com.aio.downloader.service:
//            ServiceUpdate

class this._cls0 extends BroadcastReceiver
{

    final ServiceUpdate this$0;

    public void onReceive(Context context, Intent intent)
    {
        int i;
        int j;
        context = intent.getAction();
        Time time = new Time();
        time.setToNow();
        i = time.year;
        i = time.month;
        i = time.monthDay;
        i = time.hour;
        j = time.minute;
        int k = time.second;
        Log.e("caobi", (new StringBuilder("hour=")).append(i).append("minute=").append(j).append("second=").append(k).toString());
        if (!context.equals("\u53D1\u9001\u5347\u7EA7\u5E7F\u64AD")) goto _L2; else goto _L1
_L1:
        int l = getSharedPreferences("app_update", 0).getInt("wycupdate", 0);
        if (i == 14 && j == 0 && l == 0)
        {
            appid = intent.getStringExtra("appid");
            ServiceUpdate.access$26(ServiceUpdate.this, intent.getStringExtra("appurl"));
            ServiceUpdate.access$27(ServiceUpdate.this, intent.getStringExtra("appvirsion"));
            context = new MyAppInfo(getApplicationContext());
            try
            {
                appName = context.getAppName(appid);
                appIcon = context.getAppIcon(appid);
                appVersion = context.getAppVersion(appid);
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                context.printStackTrace();
            }
            MobclickAgent.onEvent(getApplicationContext(), "update_not");
            ServiceUpdate.access$28(ServiceUpdate.this, (NotificationManager)getSystemService("notification"));
            ServiceUpdate.access$29(ServiceUpdate.this, new Notification());
            ServiceUpdate.access$30(ServiceUpdate.this).flags = 16;
            ServiceUpdate.access$30(ServiceUpdate.this).icon = 0x7f0201ab;
            context = new Intent("update");
            context = PendingIntent.getBroadcast(getApplicationContext(), 0, context, 0);
            ServiceUpdate.access$30(ServiceUpdate.this).contentIntent = context;
            context = new RemoteViews(getApplicationContext().getPackageName(), 0x7f030086);
            context.setImageViewBitmap(0x7f07031d, ServiceUpdate.drawableToBitmap(appIcon));
            context.setTextViewText(0x7f07031e, appName);
            context.setTextViewText(0x7f070320, (new StringBuilder("v")).append(ServiceUpdate.access$23(ServiceUpdate.this)).toString());
            context.setTextViewText(0x7f07031f, (new StringBuilder("v")).append(appVersion).toString());
            ServiceUpdate.access$30(ServiceUpdate.this).contentView = context;
            ServiceUpdate.access$31(ServiceUpdate.this).notify(657, ServiceUpdate.access$30(ServiceUpdate.this));
        }
_L4:
        return;
_L2:
        if (context.equals("setbroadUpdate"))
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!context.equals("meiri"))
        {
            break; /* Loop/switch isn't completed */
        }
        context = intent.getStringExtra("icon_pick1");
        String s = intent.getStringExtra("title_pick1");
        String s2 = intent.getStringExtra("short_desc1");
        ServiceUpdate.access$9(ServiceUpdate.this, intent.getStringExtra("id_meiri"));
        if (i == 10 && j == 0)
        {
            try
            {
                ServiceUpdate.access$32(ServiceUpdate.this, (NotificationManager)getSystemService("notification"));
                intent = new Notification();
                intent.flags = 16;
                intent.icon = 0x7f0201aa;
                Object obj1 = new Intent("pick");
                intent.contentIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, ((Intent) (obj1)), 0);
                obj1 = new RemoteViews(getApplicationContext().getPackageName(), 0x7f030098);
                ((RemoteViews) (obj1)).setImageViewBitmap(0x7f070351, Myutils.getImage((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append(MD5.enlode(context)).toString()));
                ((RemoteViews) (obj1)).setTextViewText(0x7f070352, s);
                ((RemoteViews) (obj1)).setTextViewText(0x7f070353, s2);
                intent.contentView = ((RemoteViews) (obj1));
                ServiceUpdate.access$33(ServiceUpdate.this).notify(19, intent);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                return;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
        String s1;
        String s3;
        String s4;
        if (!context.equals("meiribig"))
        {
            break MISSING_BLOCK_LABEL_1284;
        }
        context = intent.getStringExtra("short_desc");
        s1 = intent.getStringExtra("title_pick");
        s4 = intent.getStringExtra("img_pick");
        s3 = intent.getStringExtra("icon_pick");
        ServiceUpdate.access$5(ServiceUpdate.this, intent.getStringExtra("id_meiribig"));
        if (i != 22 || j != 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        Object obj2;
        MobclickAgent.onEvent(getApplicationContext(), "pick_big");
        ServiceUpdate.access$34(ServiceUpdate.this, (NotificationManager)getSystemService("notification"));
        intent = new Intent("pick_big");
        obj2 = PendingIntent.getBroadcast(getApplicationContext(), 0, intent, 0);
        intent = (new android.support.v4.app.at.Builder(getApplicationContext())).setAutoCancel(true).setContentText(context).setContentTitle(s1).setDefaults(4).setLargeIcon(BitmapFactory.decodeResource(getResources(), 0x7f0200eb)).setOngoing(false).setTicker(s1).setPriority(2).setSmallIcon(0x7f0200eb, 0);
        intent.setStyle(new android.support.v4.app.at.BigPictureStyle());
        intent = intent.build();
        intent.flags = 16;
        intent.icon = 0x7f0201aa;
        intent.contentIntent = ((PendingIntent) (obj2));
        obj2 = new RemoteViews(getApplication().getPackageName(), 0x7f030099);
        s4 = (new StringBuilder()).append(Environment.getExternalStorageDirectory()).append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append(MD5.enlode(s4)).toString();
        s3 = (new StringBuilder()).append(Environment.getExternalStorageDirectory()).append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append(MD5.enlode(s3)).toString();
        ((RemoteViews) (obj2)).setImageViewBitmap(0x7f070358, Myutils.getImage(s4));
        ((RemoteViews) (obj2)).setImageViewBitmap(0x7f070354, Myutils.getImage(s3));
        ((RemoteViews) (obj2)).setTextViewText(0x7f070355, s1);
        ((RemoteViews) (obj2)).setTextViewText(0x7f070357, context);
        if (android.os.K_INT < 16)
        {
            break MISSING_BLOCK_LABEL_1275;
        }
        intent.bigContentView = ((RemoteViews) (obj2));
_L5:
        ServiceUpdate.access$35(ServiceUpdate.this).notify(1999, intent);
        return;
        try
        {
            intent.contentView = ((RemoteViews) (obj2));
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
          goto _L5
        if (!context.equals("paidppp"))
        {
            break; /* Loop/switch isn't completed */
        }
        context = intent.getStringExtra("icon0");
        s1 = intent.getStringExtra("icon1");
        s3 = intent.getStringExtra("icon2");
        s4 = intent.getStringExtra("icon3");
        obj2 = intent.getStringExtra("icon4");
        intent = intent.getStringExtra("icon5");
        if (i == 18 && j == 0)
        {
            try
            {
                ServiceUpdate.access$36(ServiceUpdate.this, (NotificationManager)getSystemService("notification"));
                MobclickAgent.onEvent(getApplicationContext(), "paid");
                Notification notification = new Notification();
                notification.flags = 16;
                notification.icon = 0x7f0200ec;
                Object obj3 = new Intent("paid");
                notification.contentIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, ((Intent) (obj3)), 0);
                obj3 = new RemoteViews(getApplicationContext().getPackageName(), 0x7f030093);
                ((RemoteViews) (obj3)).setImageViewBitmap(0x7f070337, Myutils.getImage((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append(MD5.enlode(context)).toString()));
                ((RemoteViews) (obj3)).setImageViewBitmap(0x7f070339, Myutils.getImage((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append(MD5.enlode(s1)).toString()));
                ((RemoteViews) (obj3)).setImageViewBitmap(0x7f07033b, Myutils.getImage((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append(MD5.enlode(s3)).toString()));
                ((RemoteViews) (obj3)).setImageViewBitmap(0x7f07033d, Myutils.getImage((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append(MD5.enlode(s4)).toString()));
                ((RemoteViews) (obj3)).setImageViewBitmap(0x7f07033f, Myutils.getImage((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append(MD5.enlode(((String) (obj2)))).toString()));
                ((RemoteViews) (obj3)).setImageViewBitmap(0x7f070341, Myutils.getImage((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append(MD5.enlode(intent)).toString()));
                notification.contentView = ((RemoteViews) (obj3));
                ServiceUpdate.access$37(ServiceUpdate.this).notify(54, notification);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                return;
            }
        }
        if (true) goto _L4; else goto _L6
_L6:
        if (context.equals("downloadsuccess"))
        {
            context = intent.getStringExtra("appname");
            Object obj = intent.getStringExtra("headimage");
            ServiceUpdate.access$38(ServiceUpdate.this, intent.getStringExtra("baoming"));
            ServiceUpdate.access$39(ServiceUpdate.this, intent.getIntExtra("serial", 1));
            ServiceUpdate.access$40(ServiceUpdate.this, intent.getStringExtra("filepathdown"));
            if (ServiceUpdate.access$41(ServiceUpdate.this) == 110)
            {
                ServiceUpdate.access$42(ServiceUpdate.this, intent.getStringExtra("iddown"));
            }
            ServiceUpdate.mNotificationManager3 = (NotificationManager)getSystemService("notification");
            ServiceUpdate.access$43(ServiceUpdate.this, new Notification());
            ServiceUpdate.access$44(ServiceUpdate.this).flags = 16;
            ServiceUpdate.access$44(ServiceUpdate.this).icon = 0x7f0201a8;
            intent = new Intent("status_bar_download_success");
            intent = PendingIntent.getBroadcast(getApplicationContext(), 0, intent, 0);
            ServiceUpdate.access$44(ServiceUpdate.this).contentIntent = intent;
            intent = new RemoteViews(getApplicationContext().getPackageName(), 0x7f03008b);
            if (ServiceUpdate.access$41(ServiceUpdate.this) == 110)
            {
                obj = new MyAppInfo(getApplicationContext());
                try
                {
                    appNamedown = ((MyAppInfo) (obj)).getAppName(ServiceUpdate.access$45(ServiceUpdate.this));
                    appIcondown = ((MyAppInfo) (obj)).getAppIcon(ServiceUpdate.access$45(ServiceUpdate.this));
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    ((android.content.pm.ameNotFoundException) (obj)).printStackTrace();
                }
                intent.setImageViewBitmap(0x7f070325, ServiceUpdate.drawableToBitmap(appIcondown));
            } else
            {
                intent.setImageViewBitmap(0x7f070325, Myutils.getImage((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append(MD5.enlode(((String) (obj)))).toString()));
            }
            intent.setTextViewText(0x7f070326, context);
            intent.setTextViewText(0x7f070327, "Click to install");
            ServiceUpdate.access$44(ServiceUpdate.this).contentView = intent;
            ServiceUpdate.mNotificationManager3.notify(13131, ServiceUpdate.access$44(ServiceUpdate.this));
            return;
        }
        if (!context.equals("downloadinstall")) goto _L4; else goto _L7
_L7:
        ServiceUpdate.access$46(ServiceUpdate.this, intent.getStringExtra("appidinstall"));
        context = new MyAppInfo(getApplicationContext());
        try
        {
            appNameinstall = context.getAppName(ServiceUpdate.access$25(ServiceUpdate.this));
            appIconinstall = context.getAppIcon(ServiceUpdate.access$25(ServiceUpdate.this));
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            try
            {
                context.printStackTrace();
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                return;
            }
        }
        ServiceUpdate.access$47(ServiceUpdate.this, (NotificationManager)getSystemService("notification"));
        ServiceUpdate.access$48(ServiceUpdate.this, new Notification());
        ServiceUpdate.access$49(ServiceUpdate.this).flags = 16;
        ServiceUpdate.access$49(ServiceUpdate.this).icon = 0x7f0201a9;
        context = new Intent("status_bar_download_install");
        context = PendingIntent.getBroadcast(getApplicationContext(), 0, context, 0);
        ServiceUpdate.access$49(ServiceUpdate.this).contentIntent = context;
        context = new RemoteViews(getApplicationContext().getPackageName(), 0x7f03008b);
        context.setImageViewBitmap(0x7f070325, ServiceUpdate.drawableToBitmap(appIconinstall));
        context.setTextViewText(0x7f070326, appNameinstall);
        context.setTextViewText(0x7f070327, "Click to launch");
        ServiceUpdate.access$49(ServiceUpdate.this).contentView = context;
        ServiceUpdate.access$50(ServiceUpdate.this).notify(14141, ServiceUpdate.access$49(ServiceUpdate.this));
        return;
    }

    undException()
    {
        this$0 = ServiceUpdate.this;
        super();
    }
}
