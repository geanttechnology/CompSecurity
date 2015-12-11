// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.viewlisting;

import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.net.api.viewlisting:
//            Listing

public static final class n
    implements Comparable
{

    public e deliveryEstimate;
    public e handlingPolicyOverride;
    public ce insurance;
    public boolean promotionalShipping;
    public List properties;
    public int rank;
    public RankScopeEnum rankScope;
    public n shippingCostPlan;
    public n shippingMethod;
    public com.ebay.nautilus.domain.data.t supportedShipToRegions;
    public com.ebay.nautilus.domain.data.t totalCostToBuyer;

    public int compareTo(n n)
    {
        return rank - n.rank;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((compareTo)obj);
    }

    public n()
    {
    }
}
