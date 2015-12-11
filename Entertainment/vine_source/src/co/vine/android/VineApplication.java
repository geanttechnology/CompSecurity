// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.app.Application;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.CursorWindow;
import android.os.Handler;
import co.vine.android.client.AppController;
import co.vine.android.util.BuildUtil;
import co.vine.android.util.CrashUtil;
import co.vine.android.util.SystemUtil;
import co.vine.android.util.Util;
import com.edisonwang.android.slog.SLog;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Locale;

public class VineApplication extends Application
    implements Thread.UncaughtExceptionHandler
{

    private static VineApplication INSTANCE;
    private Thread.UncaughtExceptionHandler sDefaultHandler;

    public VineApplication()
    {
    }

    public static VineApplication getInstance()
    {
        return INSTANCE;
    }

    public Locale getLocale()
    {
        return getResources().getConfiguration().locale;
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        final Locale locale;
        try
        {
            if (!BuildUtil.isI18nOn())
            {
                break MISSING_BLOCK_LABEL_73;
            }
            locale = Util.getCustomLocale(this);
            if (configuration.locale != null)
            {
                CrashUtil.set("locale", configuration.locale.getDisplayName());
            }
        }
        // Misplaced declaration of an exception variable
        catch (Configuration configuration)
        {
            CrashUtil.logException(configuration);
            return;
        }
        if (locale == null)
        {
            break MISSING_BLOCK_LABEL_73;
        }
        if (!locale.equals(configuration.locale))
        {
            (new Handler()).postDelayed(new Runnable() {

                final VineApplication this$0;
                final Locale val$locale;

                public void run()
                {
                    Util.forceCustomLocale(VineApplication.INSTANCE, locale, true);
                }

            
            {
                this$0 = VineApplication.this;
                locale = locale1;
                super();
            }
            }, 500L);
        }
    }

    public void onCreate()
    {
        super.onCreate();
        if (BuildUtil.isI18nOn())
        {
            if (getResources() == null)
            {
                return;
            }
            Util.forceCustomLocale(this);
        }
        Object obj = Thread.getDefaultUncaughtExceptionHandler();
        if (obj != this)
        {
            sDefaultHandler = ((Thread.UncaughtExceptionHandler) (obj));
            Thread.setDefaultUncaughtExceptionHandler(this);
        }
        CrashUtil.start(this);
        Exception exception1;
        Object obj1;
        int i;
        try
        {
            obj = new ArrayList();
            ((ArrayList) (obj)).add("logcat");
            ((ArrayList) (obj)).add("-c");
            Runtime.getRuntime().exec((String[])((ArrayList) (obj)).toArray(new String[((ArrayList) (obj)).size()]));
        }
        catch (Throwable throwable) { }
        try
        {
            CrashUtil.set("RAM Budget", SystemUtil.getMemoryBudgetForLargeMemoryClass(this));
        }
        catch (Exception exception)
        {
            CrashUtil.log("Failed to get ram budeget.");
        }
        if (BuildUtil.isExplore())
        {
            break MISSING_BLOCK_LABEL_214;
        }
        SLog.d("Start changing value.");
        obj = android/database/CursorWindow.getDeclaredField("sCursorWindowSize");
        ((Field) (obj)).setAccessible(true);
        obj1 = ((Field) (obj)).get(null);
        SLog.d("Original value: {}.", obj1);
        i = 0x989680;
        if (SystemUtil.getMemoryBudgetForLargeMemoryClass(this) == 1)
        {
            i = (int)((double)0x989680 * 0.80000000000000004D);
        }
        try
        {
            SLog.d("Changing using weighted value: {}", Integer.valueOf(i));
            if (((Integer)obj1).intValue() < i)
            {
                ((Field) (obj)).set(null, Integer.valueOf(i));
            }
            SLog.d("Sucessfully updated sCursorWindowSize.");
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception1)
        {
            CrashUtil.logException(exception1, "You are too evil.", new Object[0]);
        }
        try
        {
            obj = android/database/CursorWindow.getDeclaredField("sCursorWindowSize");
            ((Field) (obj)).setAccessible(true);
            SLog.d("Verify value: {}.", ((Field) (obj)).get(null));
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception1)
        {
            CrashUtil.logException(exception1, "You are too evil.", new Object[0]);
        }
        SLog.d("End changing value.");
        INSTANCE = this;
        return;
    }

    public void onLowMemory()
    {
        super.onLowMemory();
        CrashUtil.log("onLowMemory happened.");
        AppController appcontroller = AppController.getInstance(this);
        if (appcontroller != null)
        {
            appcontroller.onLowMemory();
        }
    }

    public void onTrimMemory(int i)
    {
        super.onTrimMemory(i);
        CrashUtil.log("onTrimMemory happened: {}.", new Object[] {
            Integer.valueOf(i)
        });
        AppController appcontroller = AppController.getInstance(this);
        if (appcontroller != null)
        {
            appcontroller.onTrimMemory(i);
        }
    }

    public void uncaughtException(Thread thread, Throwable throwable)
    {
        if (throwable != null)
        {
            String s = throwable.getMessage();
            if (s != null && s.contains("detachFromGLContext"))
            {
                CrashUtil.collectLogs(300, CrashUtil.getDefaultIgnoreCountForLogCollection(throwable));
            }
        }
        if (sDefaultHandler != null)
        {
            sDefaultHandler.uncaughtException(thread, throwable);
        }
    }

}
