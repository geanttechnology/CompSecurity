// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.os.Process;
import android.os.SystemClock;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.content.dm.SiteSpeedDataManager;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.content.EbayContext;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SiteSpeedData
{

    private static SiteSpeedDataManager dataManager;
    private long allLoaded;
    public EbayCountry country;
    public String eventName;
    private ConcurrentHashMap extendedData;
    private long primaryLoaded;
    private boolean reported;
    public final boolean signedIn;
    public long startClockTime;
    private long startRealTime;
    public String subEventName;
    private long viewAppeared;

    public SiteSpeedData(String s, boolean flag)
    {
        this(s, flag, null);
    }

    public SiteSpeedData(String s, boolean flag, EbayCountry ebaycountry)
    {
        extendedData = null;
        NautilusKernel.verifyMain();
        if (s == null)
        {
            throw new IllegalArgumentException("SiteSpeedData eventName must not be null");
        } else
        {
            eventName = s;
            country = ebaycountry;
            signedIn = flag;
            startClockTime = System.currentTimeMillis();
            startRealTime = SystemClock.elapsedRealtime();
            return;
        }
    }

    public static void TEST_setManager(SiteSpeedDataManager sitespeeddatamanager)
    {
        dataManager = sitespeeddatamanager;
    }

    private static SiteSpeedDataManager getManager(EbayContext ebaycontext)
    {
        if (dataManager == null)
        {
            dataManager = (SiteSpeedDataManager)SiteSpeedDataManager.get(ebaycontext, SiteSpeedDataManager.KEY);
        }
        return dataManager;
    }

    public void addExtendedData(String s, String s1)
    {
        if (extendedData == null)
        {
            extendedData = new ConcurrentHashMap();
        }
        extendedData.put(s, s1);
    }

    public void adjustTimeBase(long l)
    {
        startClockTime = startClockTime - l;
        startRealTime = startRealTime - l;
    }

    public void adjustTimeBaseToElapsedCpu()
    {
        adjustTimeBase(Process.getElapsedCpuTime());
    }

    public void allLoaded()
    {
        NautilusKernel.verifyMain();
        if (allLoaded == 0L)
        {
            allLoaded = SystemClock.elapsedRealtime();
        }
    }

    public long getAllLoadedDelta()
    {
        return allLoaded - primaryLoaded;
    }

    public Map getExtendedDataMap()
    {
        Map map = null;
        if (extendedData != null)
        {
            map = Collections.unmodifiableMap(extendedData);
        }
        return map;
    }

    public long getPrimaryLoadedDelta()
    {
        return primaryLoaded - viewAppeared;
    }

    public long getStartRealTime()
    {
        return startRealTime;
    }

    public long getViewAppearedDelta()
    {
        return viewAppeared - startRealTime;
    }

    public boolean isComplete()
    {
        return viewAppeared != 0L && primaryLoaded != 0L && allLoaded != 0L;
    }

    public boolean isReportable()
    {
        return isComplete() && !reported;
    }

    public void markReported()
    {
        reported = true;
    }

    public void primaryLoaded()
    {
        NautilusKernel.verifyMain();
        if (primaryLoaded == 0L)
        {
            primaryLoaded = SystemClock.elapsedRealtime();
            if (allLoaded != 0L)
            {
                allLoaded = primaryLoaded;
            }
        }
    }

    public void setCountry(EbayCountry ebaycountry)
    {
        country = ebaycountry;
    }

    public void setEventName(String s)
    {
        eventName = s;
    }

    public void setSubEventName(String s)
    {
        subEventName = s;
    }

    public String toString()
    {
        return (new StringBuilder()).append("SiteSpeedData [eventName=").append(eventName).append(", startClockTime=").append(startClockTime).append(", startRealTime=").append(startRealTime).append(", viewAppeared=").append(viewAppeared).append(", primaryLoaded=").append(primaryLoaded).append(", allLoaded=").append(allLoaded).append(", country=").append(country).append(", extendedData=").append(extendedData).append("]").toString();
    }

    public boolean upload(EbayContext ebaycontext)
    {
        NautilusKernel.verifyMain();
        if (!isReportable())
        {
            return false;
        } else
        {
            getManager(ebaycontext).upload(null, this);
            return true;
        }
    }

    public void viewAppeared()
    {
        NautilusKernel.verifyMain();
        if (viewAppeared == 0L)
        {
            viewAppeared = SystemClock.elapsedRealtime();
            if (primaryLoaded != 0L)
            {
                primaryLoaded = viewAppeared;
            }
            if (allLoaded != 0L)
            {
                allLoaded = viewAppeared;
            }
        }
    }
}
