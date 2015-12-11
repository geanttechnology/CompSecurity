// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service.core;

import com.groupon.service.countryanddivision.CurrentDivisionDao;
import com.groupon.service.countryanddivision.DivisionsService;
import com.groupon.util.Dates;

// Referenced classes of package com.groupon.service.core:
//            CoreService

public class CurrentDivisionUpdaterService extends CoreService
{

    private CurrentDivisionDao currentDivisionDao;
    private DivisionsService divisionsService;

    public CurrentDivisionUpdaterService()
    {
    }

    public boolean isDownloadingDataFromNetwork()
    {
        return true;
    }

    protected boolean isUpToDate()
    {
        return Dates.isToday(currentDivisionDao.getLastTimeStamp()) && divisionsService.isUpToDate();
    }

    protected void refresh()
        throws Exception
    {
        divisionsService.refresh();
    }

    public void resetToNotUpToDate()
    {
        currentDivisionDao.clearTimeStamp();
        divisionsService.clearTimeStamp();
    }
}
