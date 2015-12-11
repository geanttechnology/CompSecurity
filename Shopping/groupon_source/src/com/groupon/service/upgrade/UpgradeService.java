// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service.upgrade;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;
import com.crittercism.app.Crittercism;
import com.groupon.foundations.service.BaseIntentService;
import com.groupon.service.DailySyncService;
import com.groupon.service.OnBoardingService;
import com.groupon.service.core.CoreServicesInitializer;
import com.groupon.service.startup.StartupDirector;
import com.groupon.service.upgrade.listener.UpgradeManagerListener;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.tracking.mobile.sdk.NoScheduledUploadLogger;
import com.groupon.util.CacheUtils;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import roboguice.util.Ln;

public class UpgradeService extends BaseIntentService
{
    private class UpgradeServiceUpgradeManagerListenerImpl
        implements UpgradeManagerListener
    {

        final UpgradeService this$0;

        public void onUpgradeSuccess()
        {
            upgradeManagerFinishedUpdateCountDownLatch.countDown();
        }

        private UpgradeServiceUpgradeManagerListenerImpl()
        {
            this$0 = UpgradeService.this;
            super();
        }

    }


    public static final int UPGRADE_MANAGER_TIMEOUT_IN_MN = 5;
    private CoreServicesInitializer coreServicesInitializer;
    private NoScheduledUploadLogger logger;
    private OnBoardingService onBoardingService;
    private StartupDirector startupDirector;
    private CountDownLatch upgradeManagerFinishedUpdateCountDownLatch;
    private UpgradeManagerListener upgradeManagerListener;

    public UpgradeService()
    {
        super(com/groupon/service/upgrade/UpgradeService.getSimpleName());
        upgradeManagerFinishedUpdateCountDownLatch = new CountDownLatch(1);
        upgradeManagerListener = new UpgradeServiceUpgradeManagerListenerImpl();
    }

    private void clearCache(Context context)
    {
        coreServicesInitializer.resetAllServicesToNotUpToDate(new Class[0]);
        CacheUtils.clearCacheDir(context);
    }

    protected void onHandleIntent(Intent intent)
    {
        Ln.i("Starting upgrade process", new Object[0]);
        logger.logGeneralEvent("upgrade_service", "service_start", "", 1, Logger.NULL_NST_FIELD);
        Ln.d((new StringBuilder()).append("Upgrade event instantiated. Intent: ").append(intent).toString(), new Object[0]);
        onBoardingService.setShowOnBoarding(false);
        Ln.i("Running UpgradeManager", new Object[0]);
        startupDirector.addUpgradeManagerListener(upgradeManagerListener);
        startupDirector.startupUpgradeManagerOnly();
        if (!upgradeManagerFinishedUpdateCountDownLatch.await(5L, TimeUnit.MINUTES))
        {
            throw new IllegalStateException("Upgrade Manager could not complete before timeout.");
        }
        break MISSING_BLOCK_LABEL_166;
        Object obj;
        obj;
        logger.logGeneralEvent("upgrade_service", "suppress", obj.getClass().getSimpleName(), 1, Logger.NULL_NST_FIELD);
        if (!(obj instanceof IOException))
        {
            Crittercism.logHandledException(((Throwable) (obj)));
        }
        Ln.i("Upgrade process ended", new Object[0]);
        WakefulBroadcastReceiver.completeWakefulIntent(intent);
        return;
        clearCache(this);
        Ln.i("Running DailySyncService", new Object[0]);
        WakefulBroadcastReceiver.startWakefulService(this, (new Intent(this, com/groupon/service/DailySyncService)).putExtras(intent));
        Ln.i("Upgrade process ended", new Object[0]);
        WakefulBroadcastReceiver.completeWakefulIntent(intent);
        return;
        obj;
        Ln.i("Upgrade process ended", new Object[0]);
        WakefulBroadcastReceiver.completeWakefulIntent(intent);
        throw obj;
    }

}
