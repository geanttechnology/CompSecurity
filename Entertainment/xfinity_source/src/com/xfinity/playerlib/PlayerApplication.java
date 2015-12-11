// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import com.comcast.cim.analytics.CrashReportEventData;
import com.comcast.cim.cmasl.analytics.AnalyticsLogger;
import com.comcast.cim.cmasl.utils.CommonUtils;
import com.comcast.cim.cmasl.utils.logging.Log4JConfigurator;
import com.comcast.cim.container.PlayerContainer;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.apache.commons.lang3.time.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.xfinity.playerlib:
//            PlayNowLog4JConfigurator, PlayNowLog4JConfiguratorProduction

public abstract class PlayerApplication extends Application
{
    private class PlayerExceptionHandler
        implements Thread.UncaughtExceptionHandler
    {

        private Thread.UncaughtExceptionHandler defaultHandler;
        final PlayerApplication this$0;

        public void uncaughtException(Thread thread, Throwable throwable)
        {
            try
            {
                CrashReportEventData crashreporteventdata = new CrashReportEventData(thread, throwable, getVersionNumber());
                PlayerContainer.getInstance().getSplunkLogger().logData(crashreporteventdata);
            }
            catch (Exception exception) { }
            defaultHandler.uncaughtException(thread, throwable);
        }

        public PlayerExceptionHandler()
        {
            this$0 = PlayerApplication.this;
            super();
            defaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        }
    }


    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/PlayerApplication);
    private static PlayerApplication instance;
    private String installId;

    public PlayerApplication()
    {
    }

    private String createInstallId(SharedPreferences sharedpreferences)
    {
        String s = UUID.randomUUID().toString();
        sharedpreferences.edit().putString("AppInstallId", s).commit();
        return s;
    }

    public static PlayerApplication getInstance()
    {
        return instance;
    }

    private String readInstallId(SharedPreferences sharedpreferences)
    {
        return sharedpreferences.getString("AppInstallId", null);
    }

    public void configureLogging()
    {
        Object obj = getApplicationInfo();
        int i = ((ApplicationInfo) (obj)).flags & 2;
        obj.flags = i;
        boolean flag;
        if (i != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            obj = (Log4JConfigurator)CommonUtils.getNewInstanceOfOverrideableClass(com/xfinity/playerlib/PlayNowLog4JConfigurator);
        } else
        {
            obj = (Log4JConfigurator)CommonUtils.getNewInstanceOfOverrideableClass(com/xfinity/playerlib/PlayNowLog4JConfiguratorProduction);
        }
        ((Log4JConfigurator) (obj)).configureLogging();
    }

    public String getCurrentlyRunningProcessName(Context context)
    {
        int i = Process.myPid();
        for (context = ((ActivityManager)context.getSystemService("activity")).getRunningAppProcesses().iterator(); context.hasNext();)
        {
            android.app.ActivityManager.RunningAppProcessInfo runningappprocessinfo = (android.app.ActivityManager.RunningAppProcessInfo)context.next();
            if (runningappprocessinfo.pid == i)
            {
                return runningappprocessinfo.processName;
            }
        }

        return null;
    }

    public String getInstallId()
    {
        return installId;
    }

    public int getVersionCode()
    {
        int i;
        try
        {
            i = getPackageManager().getPackageInfo(getPackageName(), 0).versionCode;
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            LOG.warn("failed retrieving package info", namenotfoundexception);
            return 0;
        }
        return i;
    }

    public String getVersionNumber()
    {
        String s;
        try
        {
            s = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            LOG.warn("failed retrieving package info", namenotfoundexception);
            return "";
        }
        return s;
    }

    public abstract void initializeContainer(PlayerApplication playerapplication);

    public boolean isMainProcess()
    {
        return getCurrentlyRunningProcessName(this).equals(getPackageName());
    }

    public void onCreate()
    {
        super.onCreate();
        instance = this;
        Thread.setDefaultUncaughtExceptionHandler(new PlayerExceptionHandler());
        reset();
    }

    public void reset()
    {
        if (isMainProcess())
        {
            StopWatch stopwatch = new StopWatch();
            stopwatch.start();
            initializeContainer(this);
            PlayerContainer playercontainer = PlayerContainer.getInstance();
            playercontainer.getSplunkLogger().startService();
            stopwatch.stop();
            String s = (new StringBuilder()).append("PlayerContainer initialized in ").append(stopwatch).toString();
            stopwatch.reset();
            stopwatch.start();
            configureLogging();
            stopwatch.stop();
            LOG.debug(s);
            LOG.debug((new StringBuilder()).append("Logging initialized in ").append(stopwatch).toString());
            if (installId == null)
            {
                installId = readInstallId(playercontainer.getSharedPreferences());
                if (installId == null)
                {
                    installId = createInstallId(playercontainer.getSharedPreferences());
                }
            }
        }
    }

}
