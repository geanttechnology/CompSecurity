// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.analytics;


// Referenced classes of package com.ebay.mobile.analytics:
//            AnalyticsUtil, AnalyticsAdapter, AnalyticsProvider

static final class adapter
{

    public final AnalyticsAdapter adapter;
    public final String packageName;
    public final AnalyticsProvider provider;

    public boolean equals(Object obj)
    {
        if (!(obj instanceof adapter))
        {
            return false;
        } else
        {
            obj = (adapter)obj;
            return packageName.equals(((packageName) (obj)).packageName);
        }
    }

    public int hashCode()
    {
        return packageName.hashCode();
    }

    public (AnalyticsAdapter analyticsadapter, AnalyticsProvider analyticsprovider)
    {
        packageName = analyticsprovider.getClass().getPackage().getName();
        provider = analyticsprovider;
        adapter = analyticsadapter;
    }
}
