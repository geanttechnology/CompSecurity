// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.floatwindow;

import android.app.ActivityManager;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Handler;
import android.os.IBinder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

// Referenced classes of package com.aio.downloader.floatwindow:
//            MyWindowManager

public class FloatWindowService extends Service
{
    class RefreshTask extends TimerTask
    {

        final FloatWindowService this$0;

        public void run()
        {
            if (isHome() && !MyWindowManager.isWindowShowing())
            {
                handler.post(new Runnable() {

                    final RefreshTask this$1;

                    public void run()
                    {
                        MyWindowManager.createSmallWindow(getApplicationContext());
                    }

            
            {
                this$1 = RefreshTask.this;
                super();
            }
                });
            } else
            {
                if (!isHome() && MyWindowManager.isWindowShowing())
                {
                    handler.post(new Runnable() {

                        final RefreshTask this$1;

                        public void run()
                        {
                            MyWindowManager.removeSmallWindow(getApplicationContext());
                            MyWindowManager.removeBigWindow(getApplicationContext());
                        }

            
            {
                this$1 = RefreshTask.this;
                super();
            }
                    });
                    return;
                }
                if (isHome() && MyWindowManager.isWindowShowing())
                {
                    handler.post(new Runnable() {

                        final RefreshTask this$1;

                        public void run()
                        {
                            MyWindowManager.updateUsedPercent(getApplicationContext());
                        }

            
            {
                this$1 = RefreshTask.this;
                super();
            }
                    });
                    return;
                }
            }
        }


        RefreshTask()
        {
            this$0 = FloatWindowService.this;
            super();
        }
    }


    private Handler handler;
    private Timer timer;

    public FloatWindowService()
    {
        handler = new Handler();
    }

    private List getHomes()
    {
        ArrayList arraylist = new ArrayList();
        Object obj = getPackageManager();
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        obj = ((PackageManager) (obj)).queryIntentActivities(intent, 0x10000).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                return arraylist;
            }
            arraylist.add(((ResolveInfo)((Iterator) (obj)).next()).activityInfo.packageName);
        } while (true);
    }

    private boolean isHome()
    {
        List list = ((ActivityManager)getSystemService("activity")).getRunningTasks(1);
        return getHomes().contains(((android.app.ActivityManager.RunningTaskInfo)list.get(0)).topActivity.getPackageName());
    }

    public IBinder onBind(Intent intent)
    {
        return null;
    }

    public void onDestroy()
    {
        super.onDestroy();
        timer.cancel();
        timer = null;
    }

    public int onStartCommand(Intent intent, int i, int j)
    {
        if (timer == null)
        {
            timer = new Timer();
            timer.scheduleAtFixedRate(new RefreshTask(), 0L, 500L);
        }
        return super.onStartCommand(intent, i, j);
    }


}
