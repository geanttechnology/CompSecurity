// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.android.pushservice;

import android.app.ActivityManager;
import android.app.Application;
import android.os.Process;
import com.baidu.android.silentupdate.SilentManager;
import java.util.Iterator;
import java.util.List;

public class PushApplication extends Application
{

    public PushApplication()
    {
    }

    public void onCreate()
    {
        super.onCreate();
        SilentManager.enableDebugMode(true);
        Object obj = (ActivityManager)getSystemService("activity");
        int i = Process.myPid();
        obj = ((ActivityManager) (obj)).getRunningAppProcesses().iterator();
        do
        {
            android.app.ActivityManager.RunningAppProcessInfo runningappprocessinfo;
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    return;
                }
                runningappprocessinfo = (android.app.ActivityManager.RunningAppProcessInfo)((Iterator) (obj)).next();
            } while (runningappprocessinfo.pid != i || runningappprocessinfo.processName.endsWith(getPackageName()));
            SilentManager.setKey("key");
            SilentManager.loadLib(getApplicationContext(), "plugin", "pushservice.jar");
        } while (true);
    }
}
