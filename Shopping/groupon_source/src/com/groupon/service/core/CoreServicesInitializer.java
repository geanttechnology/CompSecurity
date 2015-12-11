// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service.core;

import android.app.Application;
import android.content.SharedPreferences;
import android.os.SystemClock;
import com.groupon.GrouponApplication;
import com.groupon.models.StartupContext;
import com.groupon.service.core.listener.CoreServiceInitializerListener;
import com.groupon.service.core.listener.CoreServiceListener;
import com.groupon.tracking.mobile.sdk.Logger;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.service.core:
//            AppStartupService, CurrentCountryUpdaterService, CurrentDivisionUpdaterService, SupportInfoService, 
//            StatusService, CollectionsService, UserManager, CoreService, 
//            CoreServiceException

public class CoreServicesInitializer
{
    private class CoreServiceListenerImpl
        implements CoreServiceListener
    {

        final CoreServicesInitializer this$0;

        public void onRefreshError(CoreService coreservice, Exception exception)
        {
            Ln.d(exception, "StartupService %s refreshed with error", new Object[] {
                coreservice.getClass().getName()
            });
            setOfFailedRefreshedServices.add(new CoreServiceException(coreservice, exception));
            checkIfStillRunningAndFireEvent();
        }

        public void onRefreshStarted(CoreService coreservice)
        {
            fireOnServiceRefreshStarted(coreservice);
        }

        public void onRefreshSuccess(CoreService coreservice)
        {
            Ln.d("StartupService %s refreshed successfully", new Object[] {
                coreservice.getClass().getName()
            });
            setOfSuccessfullyRefreshedServices.add(coreservice);
            checkIfStillRunningAndFireEvent();
        }

        private CoreServiceListenerImpl()
        {
            this$0 = CoreServicesInitializer.this;
            super();
        }

    }

    private static class StartupServiceRefreshTask
        implements Callable
    {

        private Application application;
        private CoreServiceListener coreServiceListener;
        private Logger logger;
        private boolean shouldLogStartupTime;
        private Class startupServiceClass;

        public volatile Object call()
            throws Exception
        {
            return call();
        }

        public Void call()
            throws Exception
        {
            Ln.d("Starting %s", new Object[] {
                startupServiceClass.getName()
            });
            long l = SystemClock.currentThreadTimeMillis();
            Ln.d("Starting Startup Service %s", new Object[] {
                startupServiceClass.getName()
            });
            CoreService coreservice = (CoreService)RoboGuice.getInjector(application).getInstance(startupServiceClass);
            long l1 = SystemClock.currentThreadTimeMillis();
            Ln.d("Startup Service %s created in %d", new Object[] {
                startupServiceClass.getName(), Integer.valueOf((int)(l1 - l))
            });
            coreservice.addListener(coreServiceListener);
            coreservice.doRefresh();
            coreservice.removeListener(coreServiceListener);
            l1 = SystemClock.currentThreadTimeMillis();
            if (shouldLogStartupTime)
            {
                logger.logGeneralEvent("startup", "splash", (new StringBuilder()).append("startupServices:").append(startupServiceClass.getSimpleName()).toString(), (int)(l1 - l), Logger.NULL_NST_FIELD);
            }
            Ln.d("Startup Service %s started in %d", new Object[] {
                startupServiceClass.getName(), Integer.valueOf((int)(l1 - l))
            });
            return null;
        }

        private StartupServiceRefreshTask(Application application1, CoreServiceListener coreservicelistener, Class class1, boolean flag, Logger logger1)
        {
            application = application1;
            coreServiceListener = coreservicelistener;
            startupServiceClass = class1;
            shouldLogStartupTime = flag;
            logger = logger1;
        }

    }


    private Application application;
    private CoreServiceListener coreServiceListener;
    private boolean isRunning;
    private List listenerList;
    private Logger logger;
    private SharedPreferences prefs;
    private Set setOfFailedRefreshedServices;
    private Set setOfSuccessfullyRefreshedServices;
    private boolean shouldLogStartupTime;
    private long startTime;
    protected final Class startupServiceClasses[] = {
        com/groupon/service/core/AppStartupService, com/groupon/service/core/CurrentCountryUpdaterService, com/groupon/service/core/CurrentDivisionUpdaterService, com/groupon/service/core/SupportInfoService, com/groupon/service/core/StatusService, com/groupon/service/core/CollectionsService, com/groupon/service/core/UserManager
    };

    public CoreServicesInitializer()
    {
        coreServiceListener = new CoreServiceListenerImpl();
        listenerList = new Vector();
    }

    private void checkIfStillRunningAndFireEvent()
    {
        Set set = setOfFailedRefreshedServices;
        set;
        JVM INSTR monitorenter ;
        Set set1 = setOfSuccessfullyRefreshedServices;
        set1;
        JVM INSTR monitorenter ;
        boolean flag;
        if (setOfFailedRefreshedServices.size() + setOfSuccessfullyRefreshedServices.size() != startupServiceClasses.length)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isRunning = flag;
        if (!isRunning)
        {
            if (setOfSuccessfullyRefreshedServices.size() != startupServiceClasses.length)
            {
                break MISSING_BLOCK_LABEL_89;
            }
            fireOnAllServicesRefreshCompletedSuccessfully();
        }
_L1:
        set1;
        JVM INSTR monitorexit ;
        set;
        JVM INSTR monitorexit ;
        return;
        fireOnAllServicesRefreshCompletedWithError();
          goto _L1
        Exception exception1;
        exception1;
        set1;
        JVM INSTR monitorexit ;
        throw exception1;
        Exception exception;
        exception;
        set;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void fireOnAllServicesRefreshCompletedWithError()
    {
        List list = listenerList;
        list;
        JVM INSTR monitorenter ;
        for (Iterator iterator = listenerList.iterator(); iterator.hasNext(); ((CoreServiceInitializerListener)iterator.next()).onAllServicesRefreshCompletedWithError(setOfFailedRefreshedServices)) { }
        break MISSING_BLOCK_LABEL_52;
        Exception exception;
        exception;
        list;
        JVM INSTR monitorexit ;
        throw exception;
        list;
        JVM INSTR monitorexit ;
    }

    private void fireOnServiceRefreshStarted(CoreService coreservice)
    {
        List list = listenerList;
        list;
        JVM INSTR monitorenter ;
        for (Iterator iterator = listenerList.iterator(); iterator.hasNext(); ((CoreServiceInitializerListener)iterator.next()).onServiceRefreshStarted(coreservice)) { }
        break MISSING_BLOCK_LABEL_49;
        coreservice;
        list;
        JVM INSTR monitorexit ;
        throw coreservice;
        list;
        JVM INSTR monitorexit ;
    }

    private boolean isException(Class class1, Class aclass[])
    {
        boolean flag1 = false;
        int j = aclass.length;
        int i = 0;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (i < j)
                {
                    if (class1 != aclass[i])
                    {
                        break label0;
                    }
                    flag = true;
                }
                return flag;
            }
            i++;
        } while (true);
    }

    public void addListener(CoreServiceInitializerListener coreserviceinitializerlistener)
    {
        listenerList.add(coreserviceinitializerlistener);
    }

    void fireOnAllServicesRefreshCompletedSuccessfully()
    {
        Ln.d((new StringBuilder()).append("All StartupServices refreshed successfully ").append(listenerList.size()).toString(), new Object[0]);
        prefs.edit().putLong("coreServicesTimestamp", System.currentTimeMillis()).apply();
        List list = listenerList;
        list;
        JVM INSTR monitorenter ;
        for (Iterator iterator = listenerList.iterator(); iterator.hasNext(); ((CoreServiceInitializerListener)iterator.next()).onAllServicesRefreshCompletedSuccessfully()) { }
        break MISSING_BLOCK_LABEL_107;
        Exception exception;
        exception;
        list;
        JVM INSTR monitorexit ;
        throw exception;
        list;
        JVM INSTR monitorexit ;
        if (shouldLogStartupTime)
        {
            logger.logGeneralEvent("startup", "splash", "startupServices", (int)(SystemClock.elapsedRealtime() - startTime), Logger.NULL_NST_FIELD);
        }
        return;
    }

    public void initializeAllServices()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = isRunning;
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        ExecutorService executorservice;
        Class aclass[];
        int j;
        isRunning = true;
        startTime = SystemClock.elapsedRealtime();
        shouldLogStartupTime = GrouponApplication.startupContext.shouldLogGrp24;
        setOfFailedRefreshedServices = Collections.synchronizedSet(new HashSet());
        setOfSuccessfullyRefreshedServices = Collections.synchronizedSet(new HashSet());
        executorservice = Executors.newFixedThreadPool(startupServiceClasses.length);
        aclass = startupServiceClasses;
        j = aclass.length;
        int i = 0;
_L4:
        Class class1;
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        class1 = aclass[i];
        executorservice.submit(new StartupServiceRefreshTask(application, coreServiceListener, class1, shouldLogStartupTime, logger));
        i++;
        if (true) goto _L4; else goto _L3
_L3:
        if (true) goto _L1; else goto _L5
_L5:
        Exception exception;
        exception;
        throw exception;
    }

    public void removeListener(CoreServiceInitializerListener coreserviceinitializerlistener)
    {
        listenerList.remove(coreserviceinitializerlistener);
    }

    public transient void resetAllServicesToNotUpToDate(Class aclass[])
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = isRunning;
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        Class aclass1[];
        int j;
        aclass1 = startupServiceClasses;
        j = aclass1.length;
        Class class1;
        for (int i = 0; i >= j; i++)
        {
            break MISSING_BLOCK_LABEL_69;
        }

        class1 = aclass1[i];
        if (!isException(class1, aclass))
        {
            ((CoreService)RoboGuice.getInjector(application).getInstance(class1)).resetToNotUpToDate();
        }
        break MISSING_BLOCK_LABEL_98;
        prefs.edit().remove("coreServicesTimestamp").apply();
        if (true) goto _L1; else goto _L3
_L3:
        aclass;
        throw aclass;
    }




}
