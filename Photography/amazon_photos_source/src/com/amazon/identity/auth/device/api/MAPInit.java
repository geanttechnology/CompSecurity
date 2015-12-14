// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;

import android.content.Context;
import com.amazon.identity.auth.device.CommonInfoGetter;
import com.amazon.identity.auth.device.framework.MAPInitTasks;
import com.amazon.identity.auth.device.metrics.SSOMetrics;
import com.amazon.identity.auth.device.metrics.WebserviceCallMetrics;
import com.amazon.identity.auth.device.utils.AdsIdentityHelper;
import com.amazon.identity.auth.device.utils.BuildInfo;
import com.amazon.identity.auth.device.utils.DebugHelpers;
import com.amazon.identity.auth.device.utils.MAPArgContracts;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.ThreadUtils;
import com.amazon.identity.platform.metric.MetricsHelper;
import com.amazon.identity.platform.setting.PlatformSettings;

public final class MAPInit
{
    private class _cls2
        implements com.amazon.identity.platform.setting.PlatformSettings.Listener
    {

        final MAPInit this$0;

        public void onCacheUpdated()
        {
            MAPLog.i(MAPInit.TAG, "DCP settings updated");
            toggleSettings();
        }

        _cls2()
        {
            this$0 = MAPInit.this;
            super();
        }
    }

    private class _cls3
        implements Runnable
    {

        final MAPInit this$0;

        public void run()
        {
            (new MAPInitTasks(mApplicationContext)).performInitOperations();
            MAPInit.access$600(mApplicationContext);
        }

        _cls3()
        {
            this$0 = MAPInit.this;
            super();
        }
    }


    private static final String TAG = com/amazon/identity/auth/device/api/MAPInit.getName();
    private static boolean sIsRunningInFunctionalTest = false;
    private static MAPInit sTheOneAndOnly;
    private final Context mApplicationContext;
    private boolean mInitialized;

    private MAPInit(Context context)
    {
        mApplicationContext = context;
    }

    public static MAPInit getInstance(Context context)
    {
        com/amazon/identity/auth/device/api/MAPInit;
        JVM INSTR monitorenter ;
        MAPArgContracts.throwIfNull(context, "context");
        if (sTheOneAndOnly == null) goto _L2; else goto _L1
_L1:
        context = sTheOneAndOnly;
_L3:
        com/amazon/identity/auth/device/api/MAPInit;
        JVM INSTR monitorexit ;
        return context;
_L2:
        context = context.getApplicationContext();
        if (context != null)
        {
            break MISSING_BLOCK_LABEL_51;
        }
        context = new MAPInit(null);
          goto _L3
        context;
        throw context;
        context = new MAPInit(context);
        sTheOneAndOnly = context;
          goto _L3
    }

    public static boolean isRunningInFunctionalTest()
    {
        return sIsRunningInFunctionalTest;
    }

    public static void setIsRunningInFunctionalTest(boolean flag)
    {
        sIsRunningInFunctionalTest = flag;
    }

    private void toggleSettings()
    {
        Context context = mApplicationContext;
        DebugHelpers.toggleDebugLogsEnabled(mApplicationContext);
    }

    public void initialize()
    {
        this;
        JVM INSTR monitorenter ;
        Context context = mApplicationContext;
        if (context != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (!mInitialized)
        {
            mInitialized = true;
            ThreadUtils.runOffMainThread(new Runnable() {

                final MAPInit this$0;

                public void run()
                {
                    MAPLog.setPackageName(MAPInit.this);
                    PlatformSettings.getInstance(mApplicationContext);
                    if (CommonInfoGetter.needToGenerateCommonInfoOnThisPlatform(mApplicationContext))
                    {
                        CommonInfoGetter.getInstance(mApplicationContext).init();
                    }
                    WebserviceCallMetrics.init(mApplicationContext);
                    SSOMetrics.init(mApplicationContext);
                    MetricsHelper.init(mApplicationContext);
                    addListener();
                    ThreadUtils.submitToBackgroundThread(MAPInit.this);
                }

            
            {
                this$0 = MAPInit.this;
                super();
            }
            });
        }
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }



/*
    static void access$000(MAPInit mapinit)
    {
        MAPLog.setPackageName(mapinit.mApplicationContext.getPackageName());
        MAPLog.i(TAG, (new StringBuilder("Initializing MAP (")).append(BuildInfo.getBuildInfo()).append(") for app ").append(mapinit.mApplicationContext.getPackageName()).toString());
        return;
    }

*/



/*
    static void access$200(MAPInit mapinit)
    {
        PlatformSettings.getInstance(mapinit.mApplicationContext).addListener(mapinit. new _cls2());
        mapinit.toggleSettings();
        return;
    }

*/





/*
    static void access$600(Context context)
    {
        try
        {
            Class.forName("com.amazon.device.ads.identity.AdsIdentity");
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            MAPLog.w(TAG, "AdsIdentity class not found.");
            return;
        }
        (new AdsIdentityHelper()).initializeMobileAds(context);
        return;
    }

*/
}
