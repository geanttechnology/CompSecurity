// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;


// Referenced classes of package com.flurry.android:
//            AppCloudSearchPredicatePaginationOrLimit

public class AppCloudSearchPaginatingOrLimitPredicateCreator
{

    private AppCloudSearchPaginatingOrLimitPredicateCreator()
    {
    }

    public static AppCloudSearchPredicatePaginationOrLimit limitResult(int i)
    {
        return new AppCloudSearchPredicatePaginationOrLimit((new StringBuilder()).append("").append("/limit=").append(i).toString());
    }

    public static AppCloudSearchPredicatePaginationOrLimit preginateResult(int i, int j)
    {
        return new AppCloudSearchPredicatePaginationOrLimit((new StringBuilder()).append("").append("/pagebreak=").append(i).append("/page=").append(j).toString());
    }
}
