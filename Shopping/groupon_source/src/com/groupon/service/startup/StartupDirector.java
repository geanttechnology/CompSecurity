// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service.startup;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import com.groupon.service.core.CoreService;
import com.groupon.service.core.CoreServicesInitializer;
import com.groupon.service.core.listener.CoreServiceInitializerListener;
import com.groupon.service.countryanddivision.CountryAndDivisionInitializer;
import com.groupon.service.countryanddivision.CurrentDivisionDao;
import com.groupon.service.countryanddivision.CurrentDivisionManager;
import com.groupon.service.countryanddivision.listener.CountryAndDivisionInitializerListener;
import com.groupon.service.upgrade.UpgradeManager;
import com.groupon.service.upgrade.listener.UpgradeManagerListener;
import com.groupon.util.Dates;
import com.groupon.util.GrouponSafeAsyncTask;
import java.util.Collection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

// Referenced classes of package com.groupon.service.startup:
//            UpgradeEventSource, CountryAndDivisionEventSource, CoreServicesInitializerEventSource

public class StartupDirector
{
    private class CountryAndDivisionInitializerTask extends GrouponSafeAsyncTask
    {

        final StartupDirector this$0;

        public volatile Object call()
            throws Exception
        {
            return call();
        }

        public Void call()
            throws Exception
        {
            if (upgradeManagerFinishedUpdateCountDownLatch.await(5L, TimeUnit.MINUTES))
            {
                countryAndDivisionInitializer.findCountryAndDivision();
            } else
            {
                countryAndDivisionEventSource.fireOnCountryAndDivisionException(new RuntimeException("The update of country and division failed as upgrade timeout was reached."));
            }
            return null;
        }

        private CountryAndDivisionInitializerTask()
        {
            this$0 = StartupDirector.this;
            super();
        }

    }

    private class StartupCoreServiceInitializerImpl
        implements CoreServiceInitializerListener
    {

        final StartupDirector this$0;

        public void onAllServicesRefreshCompletedSuccessfully()
        {
            onCoreServicesRefreshed();
        }

        public void onAllServicesRefreshCompletedWithError(Collection collection)
        {
            isCoreServiceRunning = false;
            coreServicesInitializer.removeListener(internalCoreServicesInitializerListener);
            coreServicesInitializerEventSource.fireOnCoreServicesRefreshWithError(collection);
        }

        public void onServiceRefreshStarted(CoreService coreservice)
        {
            coreServicesInitializerEventSource.fireOnCoreServicesRefreshStarted(coreservice);
        }

        private StartupCoreServiceInitializerImpl()
        {
            this$0 = StartupDirector.this;
            super();
        }

    }

    private class StartupCountryAndDivisionInitializerListenerImpl
        implements CountryAndDivisionInitializerListener
    {

        final StartupDirector this$0;

        public void onCountryAndDivisionSet()
        {
            StartupDirector.this.onCountryAndDivisionSet();
        }

        public void onException(Exception exception)
        {
            isCountryAndDivisionInitializerRunning = false;
            countryAndDivisionEventSource.fireOnCountryAndDivisionException(exception);
            countryAndDivisionInitializer.removeCountryAndDivisionInitializerListener(internalCountryAndDivisionInitializerListener);
        }

        public void onManualCountrySelectionNeeded()
        {
            countryAndDivisionEventSource.fireOnManualCountrySelectionNeeded();
            countryAndDivisionInitializer.removeCountryAndDivisionInitializerListener(internalCountryAndDivisionInitializerListener);
            isCountryAndDivisionInitializerRunning = false;
        }

        public void onManualDivisionSelectionNeeded()
        {
            countryAndDivisionEventSource.fireOnManualDivisionSelectionNeeded();
            countryAndDivisionInitializer.removeCountryAndDivisionInitializerListener(internalCountryAndDivisionInitializerListener);
            isCountryAndDivisionInitializerRunning = false;
        }

        private StartupCountryAndDivisionInitializerListenerImpl()
        {
            this$0 = StartupDirector.this;
            super();
        }

    }

    private class StartupUpgradeManagerListenerImpl
        implements UpgradeManagerListener
    {

        private boolean isUpgradeManagerOnly;
        final StartupDirector this$0;

        public void onUpgradeSuccess()
        {
            StartupDirector.this.onUpgradeSuccess(isUpgradeManagerOnly);
        }

        public StartupUpgradeManagerListenerImpl(boolean flag)
        {
            this$0 = StartupDirector.this;
            super();
            isUpgradeManagerOnly = flag;
        }
    }

    private class UpgradeManagerTask extends GrouponSafeAsyncTask
    {

        final StartupDirector this$0;

        public volatile Object call()
            throws Exception
        {
            return call();
        }

        public Void call()
            throws Exception
        {
            upgradeManager.execute(application);
            return null;
        }

        private UpgradeManagerTask()
        {
            this$0 = StartupDirector.this;
            super();
        }

    }


    private static final int UPGRADE_TIMEOUT_IN_MN = 5;
    private Application application;
    private CoreServicesInitializer coreServicesInitializer;
    private final CoreServicesInitializerEventSource coreServicesInitializerEventSource = new CoreServicesInitializerEventSource();
    private final CountryAndDivisionEventSource countryAndDivisionEventSource = new CountryAndDivisionEventSource();
    private CountryAndDivisionInitializer countryAndDivisionInitializer;
    private CurrentDivisionManager currentDivisionManager;
    private PackageInfo info;
    private CoreServiceInitializerListener internalCoreServicesInitializerListener;
    private CountryAndDivisionInitializerListener internalCountryAndDivisionInitializerListener;
    private UpgradeManagerListener internalUpgradeManagerListener;
    private boolean isCoreServiceRunning;
    private boolean isCountryAndDivisionInitializerRunning;
    private boolean isUpgradeManagerRunning;
    private SharedPreferences prefs;
    private final UpgradeEventSource upgradeEventSource = new UpgradeEventSource();
    private UpgradeManager upgradeManager;
    private CountDownLatch upgradeManagerFinishedUpdateCountDownLatch;

    public StartupDirector()
    {
        upgradeManagerFinishedUpdateCountDownLatch = new CountDownLatch(1);
    }

    private boolean areCoreServicesUpToDate()
    {
        return Dates.isToday(prefs.getLong("coreServicesTimestamp", 0L));
    }

    private boolean isUpgradeComplete()
    {
        boolean flag = prefs.getBoolean("appLaunched", false);
        int j = info.versionCode;
        SharedPreferences sharedpreferences = prefs;
        int i;
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0x7fffffff;
        }
        return j == sharedpreferences.getInt("lastVersion", i);
    }

    private void onCoreServicesRefreshed()
    {
        this;
        JVM INSTR monitorenter ;
        coreServicesInitializerEventSource.fireOnCoreServicesRefreshSuccessfully();
        if (coreServicesInitializer != null)
        {
            coreServicesInitializer.removeListener(internalCoreServicesInitializerListener);
        }
        isCoreServiceRunning = false;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void onCountryAndDivisionSet()
    {
        this;
        JVM INSTR monitorenter ;
        countryAndDivisionEventSource.fireOnCountryAndDivisionSet();
        startupCoreServices();
        if (countryAndDivisionInitializer != null)
        {
            countryAndDivisionInitializer.removeCountryAndDivisionInitializerListener(internalCountryAndDivisionInitializerListener);
        }
        isCountryAndDivisionInitializerRunning = false;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void onUpgradeSuccess(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        upgradeEventSource.fireOnUpgradeSuccess();
        if (flag)
        {
            break MISSING_BLOCK_LABEL_17;
        }
        startupCountryAndDivisionInitializer();
        if (upgradeManager != null)
        {
            upgradeManager.removeListener(internalUpgradeManagerListener);
        }
        upgradeManagerFinishedUpdateCountDownLatch.countDown();
        isUpgradeManagerRunning = false;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void startup(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag1 = isUpgradeManagerRunning;
        if (!flag1) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        isUpgradeManagerRunning = true;
        if (isUpgradeComplete())
        {
            break MISSING_BLOCK_LABEL_89;
        }
        upgradeManager = (UpgradeManager)RoboGuice.getInjector(application).getInstance(com/groupon/service/upgrade/UpgradeManager);
        internalUpgradeManagerListener = new StartupUpgradeManagerListenerImpl(flag);
        upgradeManager.addListener(internalUpgradeManagerListener);
        (new UpgradeManagerTask()).execute();
          goto _L1
        Exception exception;
        exception;
        throw exception;
        onUpgradeSuccess(flag);
          goto _L1
    }

    public void addCoreServicesInitializerListener(CoreServiceInitializerListener coreserviceinitializerlistener)
    {
        coreServicesInitializerEventSource.addCoreServicesInitializerListener(coreserviceinitializerlistener);
    }

    public void addCountryAndDivisionInitializerListener(CountryAndDivisionInitializerListener countryanddivisioninitializerlistener)
    {
        countryAndDivisionEventSource.addCountryAndDivisionInitializerListener(countryanddivisioninitializerlistener);
    }

    public void addUpgradeManagerListener(UpgradeManagerListener upgrademanagerlistener)
    {
        upgradeEventSource.addUpgradeManagerListener(upgrademanagerlistener);
    }

    public boolean areCountryAndDivisionReady()
    {
        return currentDivisionManager.getCurrentDivision() != CurrentDivisionDao.DEFAULT_DIVISION;
    }

    public boolean isFullyReady()
    {
        return isUpgradeComplete() && areCountryAndDivisionReady() && areCoreServicesUpToDate();
    }

    public void removeCoreServicesInitializerListener(CoreServiceInitializerListener coreserviceinitializerlistener)
    {
        coreServicesInitializerEventSource.removeCoreServicesInitializerListener(coreserviceinitializerlistener);
    }

    public void removeCountryAndDivisionInitializerListener(CountryAndDivisionInitializerListener countryanddivisioninitializerlistener)
    {
        countryAndDivisionEventSource.removeCountryAndDivisionInitializerListener(countryanddivisioninitializerlistener);
    }

    public void removeUpgradeManagerListener(UpgradeManagerListener upgrademanagerlistener)
    {
        upgradeEventSource.removeUpgradeManagerListener(upgrademanagerlistener);
    }

    public void startup()
    {
        startup(false);
    }

    public void startupCoreServices()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = isCoreServiceRunning;
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        isCoreServiceRunning = true;
        if (areCoreServicesUpToDate())
        {
            break MISSING_BLOCK_LABEL_84;
        }
        coreServicesInitializer = (CoreServicesInitializer)RoboGuice.getInjector(application).getInstance(com/groupon/service/core/CoreServicesInitializer);
        internalCoreServicesInitializerListener = new StartupCoreServiceInitializerImpl();
        coreServicesInitializer.addListener(internalCoreServicesInitializerListener);
        coreServicesInitializer.initializeAllServices();
          goto _L1
        Exception exception;
        exception;
        throw exception;
        onCoreServicesRefreshed();
          goto _L1
    }

    public void startupCountryAndDivisionInitializer()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = isCountryAndDivisionInitializerRunning;
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        isCountryAndDivisionInitializerRunning = true;
        if (areCountryAndDivisionReady())
        {
            break MISSING_BLOCK_LABEL_89;
        }
        countryAndDivisionInitializer = (CountryAndDivisionInitializer)RoboGuice.getInjector(application).getInstance(com/groupon/service/countryanddivision/CountryAndDivisionInitializer);
        internalCountryAndDivisionInitializerListener = new StartupCountryAndDivisionInitializerListenerImpl();
        countryAndDivisionInitializer.addCountryAndDivisionInitializerListener(internalCountryAndDivisionInitializerListener);
        (new CountryAndDivisionInitializerTask()).execute();
          goto _L1
        Exception exception;
        exception;
        throw exception;
        onCountryAndDivisionSet();
          goto _L1
    }

    public void startupUpgradeManagerOnly()
    {
        startup(true);
    }




/*
    static boolean access$1202(StartupDirector startupdirector, boolean flag)
    {
        startupdirector.isCoreServiceRunning = flag;
        return flag;
    }

*/











/*
    static boolean access$802(StartupDirector startupdirector, boolean flag)
    {
        startupdirector.isCountryAndDivisionInitializerRunning = flag;
        return flag;
    }

*/

}
