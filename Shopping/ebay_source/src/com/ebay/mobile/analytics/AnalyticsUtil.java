// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.analytics;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import com.ebay.mobile.analytics.mts.AnalyticsProviderModule;
import com.ebay.mobile.analytics.mts.MtsAnalyticsAdapter;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.mobile.dcs.DcsHelper;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.ebay.mobile.analytics:
//            AnalyticsAdapter, AnalyticsProvider

public class AnalyticsUtil
{
    static final class ProviderWrapper
    {

        public final AnalyticsAdapter adapter;
        public final String packageName;
        public final AnalyticsProvider provider;

        public boolean equals(Object obj)
        {
            if (!(obj instanceof ProviderWrapper))
            {
                return false;
            } else
            {
                obj = (ProviderWrapper)obj;
                return packageName.equals(((ProviderWrapper) (obj)).packageName);
            }
        }

        public int hashCode()
        {
            return packageName.hashCode();
        }

        public ProviderWrapper(AnalyticsAdapter analyticsadapter, AnalyticsProvider analyticsprovider)
        {
            packageName = analyticsprovider.getClass().getPackage().getName();
            provider = analyticsprovider;
            adapter = analyticsadapter;
        }
    }


    private static final ProviderWrapper MTS_WRAPPER = new ProviderWrapper(new MtsAnalyticsAdapter(), new AnalyticsProviderModule());
    private static final Set currentProviders = new HashSet();
    public static final com.ebay.nautilus.kernel.util.FwLog.LogInfo debugLogger = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("ebayAnalytics", 3, "Log provider independent tracking info.");

    private AnalyticsUtil()
    {
    }

    public static final String getCommaSeparatedStringFromCollection(Collection collection)
    {
        StringBuilder stringbuilder = new StringBuilder();
        if (collection != null)
        {
            int i = 0;
            for (collection = collection.iterator(); collection.hasNext();)
            {
                String s = (String)collection.next();
                if (i != 0)
                {
                    stringbuilder.append(",");
                }
                stringbuilder.append(s);
                i++;
            }

        }
        return stringbuilder.toString();
    }

    static Set getEnabledProviders()
    {
        com/ebay/mobile/analytics/AnalyticsUtil;
        JVM INSTR monitorenter ;
        HashSet hashset = new HashSet(currentProviders);
        com/ebay/mobile/analytics/AnalyticsUtil;
        JVM INSTR monitorexit ;
        return hashset;
        Exception exception;
        exception;
        throw exception;
    }

    public static final String getInstalledAppsList(DcsHelper dcshelper, Context context)
    {
        dcshelper = dcshelper.getAppsTrackingPrefixes();
        if (dcshelper == null)
        {
            return null;
        }
        Object obj = context.getPackageManager().getInstalledApplications(128);
        context = new ArrayList();
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext();)
        {
            ApplicationInfo applicationinfo = (ApplicationInfo)((Iterator) (obj)).next();
            Iterator iterator = dcshelper.iterator();
            while (iterator.hasNext()) 
            {
                String s = (String)iterator.next();
                if (applicationinfo.packageName.startsWith(s))
                {
                    context.add(applicationinfo.packageName);
                }
            }
        }

        return getCommaSeparatedStringFromCollection(context);
    }

    private static boolean isMtsEnabled(DeviceConfiguration deviceconfiguration)
    {
        return deviceconfiguration.get(DcsBoolean.providerMts) || AnalyticsProviderModule.debugLogger.isLoggable;
    }

    public static void setEnabledProviders()
    {
        com/ebay/mobile/analytics/AnalyticsUtil;
        JVM INSTR monitorenter ;
        if (!isMtsEnabled(DeviceConfiguration.getAsync())) goto _L2; else goto _L1
_L1:
        currentProviders.add(MTS_WRAPPER);
_L4:
        com/ebay/mobile/analytics/AnalyticsUtil;
        JVM INSTR monitorexit ;
        return;
_L2:
        currentProviders.remove(MTS_WRAPPER);
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

}
