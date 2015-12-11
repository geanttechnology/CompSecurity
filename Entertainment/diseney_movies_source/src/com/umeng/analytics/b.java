// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.analytics;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;

public class b
{

    public b()
    {
    }

    public static boolean a(Context context)
    {
        Iterator iterator;
        int i;
        i = Process.myPid();
        iterator = ((ActivityManager)context.getSystemService("activity")).getRunningAppProcesses().iterator();
        Object obj = null;
_L3:
        boolean flag = iterator.hasNext();
        if (flag) goto _L2; else goto _L1
_L1:
        Exception exception;
        android.app.ActivityManager.RunningAppProcessInfo runningappprocessinfo;
        return TextUtils.isEmpty(((CharSequence) (obj))) || context.getPackageName().equals(obj);
_L2:
        runningappprocessinfo = (android.app.ActivityManager.RunningAppProcessInfo)iterator.next();
        if (runningappprocessinfo.pid == i)
        {
            obj = runningappprocessinfo.processName.trim();
        }
          goto _L3
        exception;
        exception = null;
          goto _L1
    }
}
