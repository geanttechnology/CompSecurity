// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search;

import com.ebay.common.util.LruHistoryCache;

public final class LruVisitedItemCache
{

    private static LruHistoryCache lruVisitedItemCache = new LruHistoryCache(100);

    private LruVisitedItemCache()
    {
    }

    public static LruHistoryCache get()
    {
        return lruVisitedItemCache;
    }

}
