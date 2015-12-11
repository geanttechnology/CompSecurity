// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.content.dm;


// Referenced classes of package com.ebay.common.content.dm:
//            FollowedEntityDataManager

public static interface 
{

    public abstract boolean enablePersistentCache();

    public abstract long getFollowCacheTtl();

    public abstract long getInterestCacheTtl();

    public abstract int getMaxAggregateOperationTimeoutMs();

    public abstract int getMaxCachedFollowerSummaries();

    public abstract int getMaxInterestsPerRequest();
}
