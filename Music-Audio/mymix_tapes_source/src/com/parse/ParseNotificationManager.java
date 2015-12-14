// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.SparseIntArray;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.parse:
//            Parse, ManifestInfo

class ParseNotificationManager
{
    public static class Singleton
    {

        private static final ParseNotificationManager INSTANCE = new ParseNotificationManager();



        public Singleton()
        {
        }
    }


    public static final String TAG = "com.parse.ParseNotificationManager";
    private SparseIntArray iconIds;
    private final Object lock = new Object();
    private final AtomicInteger notificationCount = new AtomicInteger(0);
    private volatile boolean shouldShowNotifications;

    ParseNotificationManager()
    {
        shouldShowNotifications = true;
        iconIds = new SparseIntArray();
    }

    public static ParseNotificationManager getInstance()
    {
        return Singleton.INSTANCE;
    }

    public Notification createNotification(Context context, String s, String s1, Class class1, int i, Bundle bundle)
    {
        int j = i;
        if (!isValidIconId(context, i))
        {
            Parse.logE("com.parse.ParseNotificationManager", (new StringBuilder()).append("Icon id ").append(i).append(" is not a valid drawable. Trying to fall back to default app icon.").toString());
            j = ManifestInfo.getIconId();
        }
        if (j == 0)
        {
            Parse.logE("com.parse.ParseNotificationManager", "Could not find a valid icon id for this app. This is required to create a Notification object to show in the status bar. Make sure that the <application> in in your Manifest.xml has a valid android:icon attribute.");
            return null;
        }
        if (context == null || s == null || s1 == null || class1 == null || j == 0)
        {
            Parse.logE("com.parse.ParseNotificationManager", "Must specify non-null context, title, body, and activity class to show notification.");
            return null;
        }
        long l = System.currentTimeMillis();
        class1 = new ComponentName(context, class1);
        Intent intent = new Intent();
        intent.setComponent(class1);
        intent.setFlags(0x10000000);
        if (bundle != null)
        {
            intent.putExtras(bundle);
        }
        class1 = PendingIntent.getActivity(context, (int)l, intent, 0);
        bundle = new Notification(j, s1, l);
        bundle.flags = ((Notification) (bundle)).flags | 0x10;
        bundle.defaults = ((Notification) (bundle)).defaults | -1;
        bundle.setLatestEventInfo(context, s, s1, class1);
        return bundle;
    }

    public int getNotificationCount()
    {
        return notificationCount.get();
    }

    public boolean getShouldShowNotifications()
    {
        return shouldShowNotifications;
    }

    public boolean isValidIconId(Context context, int i)
    {
        int j;
        int k;
        synchronized (lock)
        {
            k = iconIds.get(i, -1);
        }
        j = k;
        if (k != -1) goto _L2; else goto _L1
_L1:
        obj = context.getResources();
        context = null;
        obj = ((Resources) (obj)).getDrawable(i);
        context = ((Context) (obj));
_L4:
        obj = lock;
        obj;
        JVM INSTR monitorenter ;
        if (context == null)
        {
            j = 0;
        } else
        {
            j = 1;
        }
        iconIds.put(i, j);
        obj;
        JVM INSTR monitorexit ;
_L2:
        return j == 1;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
        android.content.res.Resources.NotFoundException notfoundexception;
        notfoundexception;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void setShouldShowNotifications(boolean flag)
    {
        shouldShowNotifications = flag;
    }

    public void showNotification(Context context, Notification notification)
    {
        int i;
        if (context == null || notification == null)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        notificationCount.incrementAndGet();
        if (!shouldShowNotifications || context == null || notification == null)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        context = (NotificationManager)context.getSystemService("notification");
        i = (int)System.currentTimeMillis();
        context.notify(i, notification);
        return;
        SecurityException securityexception;
        securityexception;
        notification.defaults = 5;
        context.notify(i, notification);
        return;
    }

    public void showNotification(Context context, String s, String s1, Class class1, int i, Bundle bundle)
    {
        showNotification(context, createNotification(context, s, s1, class1, i, bundle));
    }
}
