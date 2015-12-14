// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.content.Context;
import android.os.PowerManager;

// Referenced classes of package com.parse:
//            Parse

class ParseWakeLock
{

    private static final String TAG = "com.parse.ParseWakeLock";
    private static volatile boolean hasWakeLockPermission = true;
    private final android.os.PowerManager.WakeLock wakeLock;

    private ParseWakeLock(android.os.PowerManager.WakeLock wakelock)
    {
        wakeLock = wakelock;
    }

    public static ParseWakeLock acquireNewWakeLock(Context context, int i, String s, long l)
    {
        Context context1;
        Object obj;
        obj = null;
        context1 = obj;
        if (!hasWakeLockPermission) goto _L2; else goto _L1
_L1:
        context = (PowerManager)context.getApplicationContext().getSystemService("power");
        context1 = obj;
        if (context == null) goto _L2; else goto _L3
_L3:
        context = context.newWakeLock(i, s);
        context1 = context;
        if (context == null) goto _L2; else goto _L4
_L4:
        context.setReferenceCounted(false);
        if (l != 0L) goto _L6; else goto _L5
_L5:
        context.acquire();
        context1 = context;
_L2:
        return new ParseWakeLock(context1);
_L6:
        context.acquire(l);
        context1 = context;
        continue; /* Loop/switch isn't completed */
        context;
        Parse.logE("com.parse.ParseWakeLock", "Failed to acquire a PowerManager.WakeLock. This isnecessary for reliable handling of pushes. Please add this to your Manifest.xml: <uses-permission android:name=\"android.permission.WAKE_LOCK\" /> ");
        hasWakeLockPermission = false;
        context1 = null;
        if (true) goto _L2; else goto _L7
_L7:
    }

    public void release()
    {
        if (wakeLock != null)
        {
            wakeLock.release();
        }
    }

}
