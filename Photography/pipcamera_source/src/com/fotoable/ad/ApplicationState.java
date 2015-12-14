// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.ad;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.fotoable.adbuttonlib.TAdButtonGroup;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;

// Referenced classes of package com.fotoable.ad:
//            StaticFlurryEvent, NativeAdWrapper, FotoAdFactory, HeartBeatAsyncTask, 
//            HomeWallFactory

public class ApplicationState
{

    private static ApplicationState instance;
    private static boolean isActive = false;
    private static long lastExistTime = 0L;
    private static Context mContext;
    Handler handler;
    AdTimerTask mAdTimerTask;
    Timer mTimer;

    public ApplicationState()
    {
        handler = new Handler() {

            final ApplicationState this$0;

            public void handleMessage(Message message)
            {
                switch (message.what)
                {
                default:
                    return;

                case 1: // '\001'
                    requestAd();
                    break;
                }
            }

            
            {
                this$0 = ApplicationState.this;
                super();
            }
        };
    }

    protected static void applicationDidEnterBackground()
    {
        Log.e("Application", "applicationDidEnterBackground");
        StaticFlurryEvent.logNativeAdRequestTimes(mContext, "enter background ");
        lastExistTime = System.currentTimeMillis();
        NativeAdWrapper.setNeedRefreshIconAd(true);
        FotoAdFactory.needShowInterstitialAd = false;
    }

    protected static void applicationDidEnterForeground()
    {
        Log.e("Application", "applicationDidEnterForeground");
        StaticFlurryEvent.logNativeAdRequestTimes(mContext, "enter foreground ");
        if (isFromUnActive())
        {
            HeartBeatAsyncTask.beat(mContext, false);
        }
        instance.requestAd();
        FotoAdFactory.needShowInterstitialAd = true;
        if (!mContext.getSharedPreferences("isNeedGotoGuideView", 0).getBoolean("guideViewShown", true))
        {
            FotoAdFactory.createFBInterstial(mContext, true);
        }
    }

    public static void checkAppStateAfterOnStart()
    {
        if (mContext == null)
        {
            Log.e("ApplicationState", "Context is null");
        } else
        if (!isActive)
        {
            isActive = true;
            applicationDidEnterForeground();
            return;
        }
    }

    public static void checkAppStateAfterOnStop()
    {
        if (mContext == null)
        {
            Log.e("ApplicationState", "Context is null");
        } else
        if (!isAppOnForeground(mContext))
        {
            isActive = false;
            applicationDidEnterBackground();
            return;
        }
    }

    public static void clearExistTime()
    {
        lastExistTime = 0L;
    }

    private void endTimer()
    {
        if (mAdTimerTask != null)
        {
            mAdTimerTask.cancel();
            mAdTimerTask = null;
        }
        if (mTimer != null)
        {
            mTimer.cancel();
            mTimer.purge();
            mTimer = null;
        }
    }

    public static void init(Context context)
    {
        if (instance == null)
        {
            instance = new ApplicationState();
        }
        mContext = context;
    }

    public static boolean isAppOnForeground(Context context)
    {
        Object obj;
        obj = (ActivityManager)context.getApplicationContext().getSystemService("activity");
        context = context.getApplicationContext().getPackageName();
        obj = ((ActivityManager) (obj)).getRunningAppProcesses();
        if (obj == null)
        {
            return false;
        }
        obj = ((List) (obj)).iterator();
        int i;
        do
        {
            android.app.ActivityManager.RunningAppProcessInfo runningappprocessinfo;
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break MISSING_BLOCK_LABEL_87;
                }
                runningappprocessinfo = (android.app.ActivityManager.RunningAppProcessInfo)((Iterator) (obj)).next();
            } while (!runningappprocessinfo.processName.equals(context));
            i = runningappprocessinfo.importance;
        } while (i != 100);
        return true;
        context;
        context.printStackTrace();
        return false;
    }

    public static boolean isFromUnActive()
    {
        boolean flag = false;
        if (System.currentTimeMillis() - lastExistTime >= 0x1b7740L)
        {
            flag = true;
        }
        return flag;
    }

    private void requestAd()
    {
        Log.e("ApplicationState", "ApplicationState requestAd");
        TAdButtonGroup.instance(mContext).requestNativeAdForiegn();
        HomeWallFactory.requestFBAdView(mContext);
    }

    private void startTimer()
    {
        try
        {
            endTimer();
            mAdTimerTask = new AdTimerTask();
            mTimer = new Timer();
            mTimer.schedule(mAdTimerTask, 0L, 40000L);
            return;
        }
        catch (Exception exception)
        {
            return;
        }
        catch (Error error)
        {
            return;
        }
    }



    private class AdTimerTask extends TimerTask
    {

        final ApplicationState this$0;

        public void run()
        {
            Message message = new Message();
            message.what = 1;
            handler.sendMessage(message);
        }

        AdTimerTask()
        {
            this$0 = ApplicationState.this;
            super();
        }
    }

}
