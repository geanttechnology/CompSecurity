// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.content.Context;
import android.content.Intent;
import android.util.SparseArray;

// Referenced classes of package com.parse:
//            ParseWakeLock, Parse

class ServiceUtils
{

    private static final String TAG = "com.parse.ServiceUtils";
    private static final String WAKE_LOCK_EXTRA = "parseWakeLockId";
    private static int wakeLockId = 0;
    private static final SparseArray wakeLocks = new SparseArray();

    ServiceUtils()
    {
    }

    public static void completeWakefulIntent(Intent intent)
    {
        if (intent != null && intent.hasExtra("parseWakeLockId"))
        {
            int i = intent.getIntExtra("parseWakeLockId", -1);
            synchronized (wakeLocks)
            {
                obj = (ParseWakeLock)wakeLocks.get(i);
                wakeLocks.remove(i);
            }
            if (obj != null)
            {
                break MISSING_BLOCK_LABEL_91;
            }
            Parse.logE("com.parse.ServiceUtils", (new StringBuilder()).append("Got wake lock id of ").append(i).append(" in intent, but no such lock found in ").append("global map. Was completeWakefulIntent called twice for the same intent?").toString());
        }
        return;
        obj;
        intent;
        JVM INSTR monitorexit ;
        throw obj;
        ((ParseWakeLock) (obj)).release();
        return;
    }

    public static boolean runIntentInService(Context context, Intent intent, Class class1)
    {
        boolean flag1 = false;
        if (intent != null)
        {
            if (class1 != null)
            {
                intent.setClass(context, class1);
            }
            boolean flag;
            if (context.startService(intent) != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 = flag;
            if (!flag)
            {
                Parse.logE("com.parse.ServiceUtils", (new StringBuilder()).append("Could not start the service. Make sure that the XML tag <service android:name=\"").append(class1.toString()).append("\" /> is in your ").append("AndroidManifest.xml as a child of the <application> element.").toString());
                flag1 = flag;
            }
        }
        return flag1;
    }

    public static boolean runWakefulIntentInService(Context context, Intent intent, Class class1, long l)
    {
        boolean flag = false;
        if (intent != null)
        {
            ParseWakeLock parsewakelock = ParseWakeLock.acquireNewWakeLock(context, 1, intent.toString(), 0L);
            synchronized (wakeLocks)
            {
                intent.putExtra("parseWakeLockId", wakeLockId);
                wakeLocks.append(wakeLockId, parsewakelock);
                wakeLockId++;
            }
            boolean flag1 = runIntentInService(context, intent, class1);
            flag = flag1;
            if (!flag1)
            {
                completeWakefulIntent(intent);
                flag = flag1;
            }
        }
        return flag;
        context;
        sparsearray;
        JVM INSTR monitorexit ;
        throw context;
    }

}
