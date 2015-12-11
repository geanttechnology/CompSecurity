// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.downloads;

import android.app.NotificationManager;
import android.content.Context;
import com.comcast.cim.cmasl.utils.container.Tuple;
import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;

public class NotificationQueueManager
{

    private final List adultNotificationQueue = Lists.newArrayList();
    private final Context context;

    public NotificationQueueManager(Context context1)
    {
        context = context1;
    }

    public void cancelAdultDownloadNotifications()
    {
        NotificationManager notificationmanager = (NotificationManager)context.getSystemService("notification");
        List list = adultNotificationQueue;
        list;
        JVM INSTR monitorenter ;
        for (Iterator iterator = adultNotificationQueue.iterator(); iterator.hasNext(); iterator.remove())
        {
            Tuple tuple = (Tuple)iterator.next();
            notificationmanager.cancel((String)tuple.e1, ((Integer)tuple.e2).intValue());
        }

        break MISSING_BLOCK_LABEL_87;
        Exception exception;
        exception;
        list;
        JVM INSTR monitorexit ;
        throw exception;
        list;
        JVM INSTR monitorexit ;
    }

    public boolean registerAdultDownloadNotification(String s, int i)
    {
        boolean flag;
        synchronized (adultNotificationQueue)
        {
            flag = adultNotificationQueue.add(new Tuple(s, Integer.valueOf(i)));
        }
        return flag;
        s;
        list;
        JVM INSTR monitorexit ;
        throw s;
    }
}
