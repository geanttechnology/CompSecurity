// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import com.facebook.internal.BoltsMeasurementEventListener;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import java.io.File;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashSet;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

// Referenced classes of package com.facebook:
//            LoggingBehavior, FacebookException, AccessTokenManager, ProfileManager, 
//            AccessToken, Profile

public final class FacebookSdk
{

    private static final ThreadFactory DEFAULT_THREAD_FACTORY = new ThreadFactory() {

        private final AtomicInteger counter = new AtomicInteger(0);

        public Thread newThread(Runnable runnable)
        {
            return new Thread(runnable, (new StringBuilder()).append("FacebookSdk #").append(counter.incrementAndGet()).toString());
        }

    };
    private static final BlockingQueue DEFAULT_WORK_QUEUE = new LinkedBlockingQueue(10);
    private static final Object LOCK = new Object();
    private static final String TAG = com/facebook/FacebookSdk.getCanonicalName();
    private static volatile String appClientToken;
    private static Context applicationContext;
    private static volatile String applicationId;
    private static volatile String applicationName;
    private static File cacheDir;
    private static int callbackRequestCodeOffset = 64206;
    private static volatile Executor executor;
    private static volatile String facebookDomain = "facebook.com";
    private static volatile boolean isDebugEnabled = false;
    private static boolean isLegacyTokenUpgradeSupported = false;
    private static final HashSet loggingBehaviors;
    private static AtomicLong onProgressThreshold = new AtomicLong(0x10000L);
    private static Boolean sdkInitialized = Boolean.valueOf(false);
    private static volatile int webDialogTheme;

    public FacebookSdk()
    {
    }

    public static Context getApplicationContext()
    {
        Validate.sdkInitialized();
        return applicationContext;
    }

    public static String getApplicationId()
    {
        Validate.sdkInitialized();
        return applicationId;
    }

    private static Executor getAsyncTaskExecutor()
    {
        Object obj;
        try
        {
            obj = android/os/AsyncTask.getField("THREAD_POOL_EXECUTOR");
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return null;
        }
        try
        {
            obj = ((Field) (obj)).get(null);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return null;
        }
        if (obj == null)
        {
            return null;
        }
        if (!(obj instanceof Executor))
        {
            return null;
        } else
        {
            return (Executor)obj;
        }
    }

    public static int getCallbackRequestCodeOffset()
    {
        Validate.sdkInitialized();
        return callbackRequestCodeOffset;
    }

    public static String getClientToken()
    {
        Validate.sdkInitialized();
        return appClientToken;
    }

    public static Executor getExecutor()
    {
        Object obj1 = LOCK;
        obj1;
        JVM INSTR monitorenter ;
        Executor executor1;
        if (executor != null)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        executor1 = getAsyncTaskExecutor();
        Object obj;
        obj = executor1;
        if (executor1 != null)
        {
            break MISSING_BLOCK_LABEL_44;
        }
        obj = new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, DEFAULT_WORK_QUEUE, DEFAULT_THREAD_FACTORY);
        executor = ((Executor) (obj));
        obj1;
        JVM INSTR monitorexit ;
        return executor;
        Exception exception;
        exception;
        obj1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static String getFacebookDomain()
    {
        return facebookDomain;
    }

    public static boolean getLimitEventAndDataUsage(Context context)
    {
        Validate.sdkInitialized();
        return context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).getBoolean("limitEventUsage", false);
    }

    public static long getOnProgressThreshold()
    {
        Validate.sdkInitialized();
        return onProgressThreshold.get();
    }

    public static int getWebDialogTheme()
    {
        Validate.sdkInitialized();
        return webDialogTheme;
    }

    public static boolean isDebugEnabled()
    {
        return isDebugEnabled;
    }

    public static boolean isInitialized()
    {
        com/facebook/FacebookSdk;
        JVM INSTR monitorenter ;
        boolean flag = sdkInitialized.booleanValue();
        com/facebook/FacebookSdk;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public static boolean isLegacyTokenUpgradeSupported()
    {
        return isLegacyTokenUpgradeSupported;
    }

    public static boolean isLoggingBehaviorEnabled(LoggingBehavior loggingbehavior)
    {
        HashSet hashset = loggingBehaviors;
        hashset;
        JVM INSTR monitorenter ;
        boolean flag;
        if (isDebugEnabled() && loggingBehaviors.contains(loggingbehavior))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        hashset;
        JVM INSTR monitorexit ;
        return flag;
        loggingbehavior;
        hashset;
        JVM INSTR monitorexit ;
        throw loggingbehavior;
    }

    static void loadDefaultsFromMetadata(Context context)
    {
        if (context != null)
        {
            try
            {
                context = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                return;
            }
            if (context != null && ((ApplicationInfo) (context)).metaData != null)
            {
                if (applicationId == null)
                {
                    Object obj = ((ApplicationInfo) (context)).metaData.get("com.facebook.sdk.ApplicationId");
                    if (obj instanceof String)
                    {
                        applicationId = (String)obj;
                    } else
                    if (obj instanceof Integer)
                    {
                        applicationId = obj.toString();
                    }
                }
                if (applicationName == null)
                {
                    applicationName = ((ApplicationInfo) (context)).metaData.getString("com.facebook.sdk.ApplicationName");
                }
                if (appClientToken == null)
                {
                    appClientToken = ((ApplicationInfo) (context)).metaData.getString("com.facebook.sdk.ClientToken");
                }
                if (webDialogTheme == 0)
                {
                    setWebDialogTheme(((ApplicationInfo) (context)).metaData.getInt("com.facebook.sdk.WebDialogTheme"));
                    return;
                }
            }
        }
    }

    public static void sdkInitialize(Context context)
    {
        com/facebook/FacebookSdk;
        JVM INSTR monitorenter ;
        boolean flag = sdkInitialized.booleanValue();
        if (!flag) goto _L2; else goto _L1
_L1:
        com/facebook/FacebookSdk;
        JVM INSTR monitorexit ;
        return;
_L2:
        Validate.notNull(context, "applicationContext");
        Validate.hasFacebookActivity(context, false);
        Validate.hasInternetPermissions(context, false);
        applicationContext = context.getApplicationContext();
        loadDefaultsFromMetadata(applicationContext);
        Utility.loadAppSettingsAsync(applicationContext, applicationId);
        NativeProtocol.updateAllAvailableProtocolVersionsAsync();
        BoltsMeasurementEventListener.getInstance(applicationContext);
        cacheDir = applicationContext.getCacheDir();
        context = new FutureTask(new Callable() {

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            public Void call()
                throws Exception
            {
                AccessTokenManager.getInstance().loadCurrentAccessToken();
                ProfileManager.getInstance().loadCurrentProfile();
                if (AccessToken.getCurrentAccessToken() != null && Profile.getCurrentProfile() == null)
                {
                    Profile.fetchProfileForCurrentAccessToken();
                }
                return null;
            }

        });
        getExecutor().execute(context);
        sdkInitialized = Boolean.valueOf(true);
        if (true) goto _L1; else goto _L3
_L3:
        context;
        throw context;
    }

    public static void sdkInitialize(Context context, int i)
    {
        com/facebook/FacebookSdk;
        JVM INSTR monitorenter ;
        if (sdkInitialized.booleanValue() && i != callbackRequestCodeOffset)
        {
            throw new FacebookException("The callback request code offset can't be updated once the SDK is initialized.");
        }
        break MISSING_BLOCK_LABEL_36;
        context;
        com/facebook/FacebookSdk;
        JVM INSTR monitorexit ;
        throw context;
        if (i >= 0)
        {
            break MISSING_BLOCK_LABEL_51;
        }
        throw new FacebookException("The callback request code offset can't be negative.");
        callbackRequestCodeOffset = i;
        sdkInitialize(context);
        com/facebook/FacebookSdk;
        JVM INSTR monitorexit ;
    }

    public static void setApplicationId(String s)
    {
        applicationId = s;
    }

    public static void setLegacyTokenUpgradeSupported(boolean flag)
    {
        isLegacyTokenUpgradeSupported = flag;
    }

    public static void setWebDialogTheme(int i)
    {
        webDialogTheme = i;
    }

    static 
    {
        loggingBehaviors = new HashSet(Arrays.asList(new LoggingBehavior[] {
            LoggingBehavior.DEVELOPER_ERRORS
        }));
    }
}
