// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pf.common.restart;

import android.app.ActivityManager;
import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Process;
import android.util.Log;
import com.cyberlink.youcammakeup.activity.SplashActivity;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

public final class RestartService extends IntentService
{

    public RestartService()
    {
        super("RestartService");
    }

    private Intent a()
    {
        return new Intent(getApplicationContext(), com/cyberlink/youcammakeup/activity/SplashActivity);
    }

    public static CharSequence a(Intent intent)
    {
        CharSequence charsequence = b(intent);
        intent.removeExtra("RestartService.reason");
        return charsequence;
    }

    public static void a(Context context, int i)
    {
        a(context, ((CharSequence) (context.getString(i))));
    }

    public static void a(Context context, CharSequence charsequence)
    {
        Intent intent = new Intent(context, com/pf/common/restart/RestartService);
        intent.setAction("com.pf.common.restart.RESTART");
        intent.putExtra("RestartService.reason", charsequence);
        context.startService(intent);
        Process.killProcess(Process.myPid());
        try
        {
            Thread.sleep(30000L);
        }
        // Misplaced declaration of an exception variable
        catch (Context context) { }
        throw new AssertionError("Must not be here because the above should kill this process!");
    }

    public static CharSequence b(Intent intent)
    {
        return intent.getCharSequenceExtra("RestartService.reason");
    }

    private void b()
    {
        Object obj = getApplicationInfo().processName;
        obj = new Callable((ActivityManager)getSystemService("activity"), ((String) (obj))) {

            final ActivityManager a;
            final String b;
            final RestartService c;

            public Boolean a()
            {
                for (Iterator iterator = a.getRunningAppProcesses().iterator(); iterator.hasNext();)
                {
                    android.app.ActivityManager.RunningAppProcessInfo runningappprocessinfo = (android.app.ActivityManager.RunningAppProcessInfo)iterator.next();
                    if (b.equals(runningappprocessinfo.processName))
                    {
                        return Boolean.valueOf(true);
                    }
                }

                return Boolean.valueOf(false);
            }

            public Object call()
            {
                return a();
            }

            
            {
                c = RestartService.this;
                a = activitymanager;
                b = s;
                super();
            }
        };
        try
        {
            while (((Boolean)((Callable) (obj)).call()).booleanValue()) 
            {
                Thread.sleep(500L);
            }
        }
        catch (Throwable throwable) { }
    }

    protected void onHandleIntent(Intent intent)
    {
        if (intent != null && "com.pf.common.restart.RESTART".equals(intent.getAction()))
        {
            Log.d("RestartService", "ACTION_RESTART");
            b();
            Intent intent1 = a();
            intent1.putExtra("RestartService.reason", b(intent));
            intent1.setFlags(0x10000000);
            startActivity(intent1);
        }
    }
}
