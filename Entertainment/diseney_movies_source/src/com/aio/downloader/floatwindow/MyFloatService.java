// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.floatwindow;

import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import com.aio.downloader.activity.GameActivity1;
import com.aio.downloader.activity.MyMainActivity;
import com.aio.downloader.activity.Noti_Set_Activity;
import com.aio.downloader.cleaner.PhoneBoostActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

// Referenced classes of package com.aio.downloader.floatwindow:
//            MyWindowManager

public class MyFloatService extends Service
{
    class RefreshTask extends TimerTask
    {

        final MyFloatService this$0;

        public void run()
        {
            if (!MyWindowManager.isWindowShowing())
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
                if (MyWindowManager.isWindowShowing())
                {
                    handler.post(new Runnable() {

                        final RefreshTask this$1;

                        public void run()
                        {
                        }

            
            {
                this$1 = RefreshTask.this;
                super();
            }
                    });
                    return;
                }
                if (MyWindowManager.isWindowShowing())
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
            this$0 = MyFloatService.this;
            super();
        }
    }


    private Handler handler;
    AlarmManager mAlarmManager;
    PendingIntent mPendingIntent;
    BroadcastReceiver onClickReceiver;
    private Timer timer;

    public MyFloatService()
    {
        mAlarmManager = null;
        mPendingIntent = null;
        handler = new Handler();
        onClickReceiver = new BroadcastReceiver() {

            final MyFloatService this$0;

            public void onReceive(Context context, Intent intent)
            {
                if (intent.getAction().equals("home"))
                {
                    Log.e("floattag", "floattag++home");
                    MyFloatService.collapseStatusBar(getApplicationContext());
                    context = new Intent(getApplicationContext(), com/aio/downloader/activity/MyMainActivity);
                    context.putExtra("acquire_url_start", "");
                    context.setFlags(0x10000000);
                    startActivity(context);
                } else
                {
                    if (intent.getAction().equals("boost"))
                    {
                        MyFloatService.collapseStatusBar(getApplicationContext());
                        context = new Intent(getApplicationContext(), com/aio/downloader/cleaner/PhoneBoostActivity);
                        context.setFlags(0x10000000);
                        startActivity(context);
                        return;
                    }
                    if (intent.getAction().equals("games"))
                    {
                        MyFloatService.collapseStatusBar(getApplicationContext());
                        context = new Intent(getApplicationContext(), com/aio/downloader/activity/GameActivity1);
                        context.setFlags(0x10000000);
                        startActivity(context);
                        return;
                    }
                    if (intent.getAction().equals("camera"))
                    {
                        context = new Intent();
                        context.setAction("android.media.action.STILL_IMAGE_CAMERA");
                        context.setFlags(0x10000000);
                        startActivity(context);
                        return;
                    }
                    if (intent.getAction().equals("set"))
                    {
                        MyFloatService.collapseStatusBar(getApplicationContext());
                        context = new Intent(getApplicationContext(), com/aio/downloader/activity/Noti_Set_Activity);
                        context.setFlags(0x10000000);
                        startActivity(context);
                        return;
                    }
                    if (intent.getAction().equals("flash"))
                    {
                        MyFloatService.collapseStatusBar(getApplicationContext());
                        context = new Intent("android.intent.action.SET_ALARM");
                        context.setFlags(0x10000000);
                        startActivity(context);
                        return;
                    }
                }
            }

            
            {
                this$0 = MyFloatService.this;
                super();
            }
        };
    }

    public static void collapseStatusBar(Context context)
    {
        Object obj;
        obj = context.getSystemService("statusbar");
        if (android.os.Build.VERSION.SDK_INT > 16)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        context = obj.getClass().getMethod("collapse", new Class[0]);
_L1:
        context.invoke(obj, new Object[0]);
        return;
        try
        {
            context = obj.getClass().getMethod("collapsePanels", new Class[0]);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            return;
        }
          goto _L1
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

    public void onCreate()
    {
        Object obj = new Intent(getApplicationContext(), com/aio/downloader/floatwindow/MyFloatService);
        mAlarmManager = (AlarmManager)getSystemService("alarm");
        mPendingIntent = PendingIntent.getService(this, 0, ((Intent) (obj)), 0x10000000);
        long l = System.currentTimeMillis();
        mAlarmManager.setInexactRepeating(1, l, 10000L, mPendingIntent);
        super.onCreate();
        obj = new IntentFilter();
        ((IntentFilter) (obj)).addAction("home");
        ((IntentFilter) (obj)).addAction("boost");
        ((IntentFilter) (obj)).addAction("games");
        ((IntentFilter) (obj)).addAction("camera");
        ((IntentFilter) (obj)).addAction("set");
        ((IntentFilter) (obj)).addAction("flash");
        registerReceiver(onClickReceiver, ((IntentFilter) (obj)));
    }

    public void onDestroy()
    {
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int j)
    {
        return 1;
    }

}
