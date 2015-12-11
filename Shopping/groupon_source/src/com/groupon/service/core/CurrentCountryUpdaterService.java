// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service.core;

import android.app.Application;
import android.content.Context;
import com.groupon.service.countryanddivision.CurrentCountryDao;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.service.countryanddivision.CurrentCountryService;
import com.groupon.util.Dates;
import roboguice.inject.Lazy;

// Referenced classes of package com.groupon.service.core:
//            CoreService

public class CurrentCountryUpdaterService extends CoreService
{

    private Application application;
    private CurrentCountryDao currentCountryDao;
    private Lazy currentCountryManager;
    private Lazy currentCountryService;

    public CurrentCountryUpdaterService()
    {
    }

    private void init()
    {
        currentCountryManager = new Lazy(application) {

            final CurrentCountryUpdaterService this$0;

            
            {
                this$0 = CurrentCountryUpdaterService.this;
                super(context);
            }
        };
        currentCountryService = new Lazy(application) {

            final CurrentCountryUpdaterService this$0;

            
            {
                this$0 = CurrentCountryUpdaterService.this;
                super(context);
            }
        };
    }

    public boolean isDownloadingDataFromNetwork()
    {
        return true;
    }

    protected boolean isUpToDate()
    {
        return Dates.isToday(currentCountryDao.getLastTimeStamp());
    }

    protected void refresh()
        throws Exception
    {
        com.groupon.models.country.Country country = ((CurrentCountryManager)currentCountryManager.get()).getCurrentCountry();
        country = ((CurrentCountryService)currentCountryService.get()).getCountryFromServer(country);
        ((CurrentCountryManager)currentCountryManager.get()).setCurrentCountry(country);
    }

    public void resetToNotUpToDate()
    {
        currentCountryDao.clearTimeStamp();
    }
}
