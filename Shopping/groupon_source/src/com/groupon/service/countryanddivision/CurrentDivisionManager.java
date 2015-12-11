// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service.countryanddivision;

import android.app.Application;
import com.groupon.db.ClearDealsRunnable;
import com.groupon.db.dao.DaoDealSummary;
import com.groupon.models.division.Division;
import com.groupon.service.ConfigurationChangedProvider;
import com.groupon.service.WidgetDealIntentService;
import com.groupon.service.core.CoreServicesInitializer;
import java.io.Serializable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import roboguice.inject.ContextScopedProvider;

// Referenced classes of package com.groupon.service.countryanddivision:
//            CurrentDivisionDao, RecentDivisionsDao, CurrentDivisionService

public class CurrentDivisionManager
    implements ConfigurationChangedProvider
{

    protected static final ThreadPoolExecutor THREAD_POOL_EXECUTOR;
    private Application application;
    public Division currentDivision;
    private CurrentDivisionDao currentDivisionDao;
    private CurrentDivisionService currentDivisionService;
    private DaoDealSummary daoDealSummary;
    private RecentDivisionsDao recentDivisionsDao;
    private CoreServicesInitializer serviceInitializer;
    private ContextScopedProvider serviceInitializerProvider;

    public CurrentDivisionManager()
    {
        currentDivision = CurrentDivisionDao.DEFAULT_DIVISION;
    }

    private CoreServicesInitializer getCoreServicesInitializer()
    {
        if (serviceInitializer == null)
        {
            serviceInitializer = (CoreServicesInitializer)serviceInitializerProvider.get(application);
        }
        return serviceInitializer;
    }

    public static boolean isRunning()
    {
        return THREAD_POOL_EXECUTOR.getActiveCount() > 0;
    }

    public void clearCurrentDivision()
    {
        currentDivision = CurrentDivisionDao.DEFAULT_DIVISION;
        getCoreServicesInitializer().resetAllServicesToNotUpToDate(new Class[0]);
        THREAD_POOL_EXECUTOR.execute(new ClearDealsRunnable(daoDealSummary));
        currentDivisionDao.clearDivision();
    }

    public Serializable getConfigurationState()
    {
        if (currentDivision == null)
        {
            return null;
        } else
        {
            return currentDivision.id;
        }
    }

    public Division getCurrentDivision()
    {
        return currentDivision;
    }

    public void init()
    {
        currentDivision = currentDivisionDao.loadDivision();
    }

    public void setCurrentDivision(Division division)
    {
        currentDivision = division;
        currentDivisionDao.saveDivision(currentDivision);
    }

    public transient void setCurrentDivisionAndClearCaches(Division division, Class aclass[])
    {
        getCoreServicesInitializer().resetAllServicesToNotUpToDate(aclass);
        THREAD_POOL_EXECUTOR.execute(new ClearDealsRunnable(daoDealSummary));
        setCurrentDivision(division);
        application.startService(WidgetDealIntentService.newIntent(application, "android.appwidget.action.APPWIDGET_UPDATE"));
        recentDivisionsDao.addRecentDivision(division);
    }

    public void setCurrentDivisionInfoAndClearCaches(String s)
        throws Exception
    {
        setCurrentDivisionAndClearCaches(currentDivisionService.getDivisionFromServer(s), new Class[0]);
    }

    static 
    {
        THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    }
}
