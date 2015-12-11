// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;


// Referenced classes of package com.flurry.android:
//            AppCloudSearchPredicateReturnOrder

public class AppCloudSearchOrderPredicateCreator
{

    private AppCloudSearchOrderPredicateCreator()
    {
    }

    public static AppCloudSearchPredicateReturnOrder ascending()
    {
        return new AppCloudSearchPredicateReturnOrder((new StringBuilder()).append("").append("/order_dir=ASC").toString());
    }

    public static AppCloudSearchPredicateReturnOrder ascending(String s)
    {
        return new AppCloudSearchPredicateReturnOrder((new StringBuilder()).append("").append("/order_by=").append(s).append("/order_dir=ASC").toString());
    }

    public static AppCloudSearchPredicateReturnOrder descending()
    {
        return new AppCloudSearchPredicateReturnOrder((new StringBuilder()).append("").append("/order_dir=DESC").toString());
    }

    public static AppCloudSearchPredicateReturnOrder descending(String s)
    {
        return new AppCloudSearchPredicateReturnOrder((new StringBuilder()).append("").append("/order_by=").append(s).append("/order_dir=DESC").toString());
    }
}
