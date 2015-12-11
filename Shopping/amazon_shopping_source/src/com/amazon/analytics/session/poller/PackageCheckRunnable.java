// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.analytics.session.poller;

import android.content.Context;
import com.amazon.analytics.TailwindActivityManager;
import com.amazon.analytics.session.PackageSession;
import com.amazon.analytics.session.PackageSessionBuilder;
import com.amazon.analytics.session.PriorityQueue;
import com.amazon.analytics.util.Message;
import com.amazon.device.analytics.log.Logger;
import com.amazon.device.analytics.log.Logging;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PackageCheckRunnable
    implements Runnable
{

    private static Logger logger = Logging.getLogger(com/amazon/analytics/session/poller/PackageCheckRunnable);
    private final TailwindActivityManager activityManager;
    private final Context context;
    private final PriorityQueue queue;
    private final PackageSessionBuilder sessionBuilder;

    public PackageCheckRunnable(Context context1, TailwindActivityManager tailwindactivitymanager, PriorityQueue priorityqueue, PackageSessionBuilder packagesessionbuilder)
    {
        context = context1;
        activityManager = tailwindactivitymanager;
        queue = priorityqueue;
        sessionBuilder = packagesessionbuilder;
    }

    static void runHelper(Context context1, TailwindActivityManager tailwindactivitymanager, PriorityQueue priorityqueue, PackageSessionBuilder packagesessionbuilder)
    {
        context1 = new HashSet();
        for (packagesessionbuilder = packagesessionbuilder.getRunningSessions().iterator(); packagesessionbuilder.hasNext(); context1.add(((PackageSession)packagesessionbuilder.next()).getPackageName())) { }
        tailwindactivitymanager = tailwindactivitymanager.getRunningAppProcesses().iterator();
        do
        {
            if (!tailwindactivitymanager.hasNext())
            {
                break;
            }
            packagesessionbuilder = (android.app.ActivityManager.RunningAppProcessInfo)tailwindactivitymanager.next();
            if (((android.app.ActivityManager.RunningAppProcessInfo) (packagesessionbuilder)).importance == 130 || ((android.app.ActivityManager.RunningAppProcessInfo) (packagesessionbuilder)).importance == 100 || ((android.app.ActivityManager.RunningAppProcessInfo) (packagesessionbuilder)).importance == 200)
            {
                packagesessionbuilder = ((android.app.ActivityManager.RunningAppProcessInfo) (packagesessionbuilder)).pkgList;
                int j = packagesessionbuilder.length;
                int i = 0;
                while (i < j) 
                {
                    context1.remove(packagesessionbuilder[i]);
                    i++;
                }
            }
        } while (true);
        for (context1 = context1.iterator(); context1.hasNext(); logger.d((new StringBuilder()).append("Published session event with FLAG_RUN_STOP for package ").append(tailwindactivitymanager).toString()))
        {
            tailwindactivitymanager = (String)context1.next();
            packagesessionbuilder = new Message();
            packagesessionbuilder.getExtras().put("PackageName", tailwindactivitymanager);
            packagesessionbuilder.getExtras().put("TimeStamp", Long.valueOf(System.currentTimeMillis()));
            packagesessionbuilder.getExtras().put("SessionFlag", Integer.valueOf(1));
            priorityqueue.enqueue(packagesessionbuilder);
        }

    }

    public void run()
    {
        runHelper(context, activityManager, queue, sessionBuilder);
    }

}
