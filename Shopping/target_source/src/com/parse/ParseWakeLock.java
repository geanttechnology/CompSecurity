// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.content.Context;
import android.os.PowerManager;

// Referenced classes of package com.parse:
//            PLog

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
        if (context == null) goto _L4; else goto _L3
_L3:
        s = context.newWakeLock(i, s);
        context = s;
        if (s == null) goto _L6; else goto _L5
_L5:
        s.setReferenceCounted(false);
        if (l != 0L) goto _L8; else goto _L7
_L7:
        s.acquire();
        context = s;
_L6:
        context1 = context;
_L2:
        return new ParseWakeLock(context1);
_L8:
        s.acquire(l);
        context = s;
        continue; /* Loop/switch isn't completed */
        context;
        PLog.e("com.parse.ParseWakeLock", "Failed to acquire a PowerManager.WakeLock. This isnecessary for reliable handling of pushes. Please add this to your Manifest.xml: <uses-permission android:name=\"android.permission.WAKE_LOCK\" /> ");
        hasWakeLockPermission = false;
        context1 = obj;
        if (true) goto _L2; else goto _L4
_L4:
        context = null;
        if (true) goto _L6; else goto _L9
_L9:
    }

    public void release()
    {
        if (wakeLock != null)
        {
            wakeLock.release();
        }
    }

}
