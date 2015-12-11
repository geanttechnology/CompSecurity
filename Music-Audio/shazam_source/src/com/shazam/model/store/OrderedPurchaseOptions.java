// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.store;

import java.util.Map;

// Referenced classes of package com.shazam.model.store:
//            Stores, StoreAnalyticsInfo

public interface OrderedPurchaseOptions
{

    public abstract Stores a(Stores stores, StoreAnalyticsInfo storeanalyticsinfo, Map map);

    public abstract Stores a(Map map, StoreAnalyticsInfo storeanalyticsinfo, Map map1);
}
