// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import com.ebay.common.net.AsyncList;

// Referenced classes of package com.ebay.common.net.api.search:
//            SavedSearchesApi

private static class list
{

    public final AsyncList list;
    public final int totalItemsCount;

    public (int i, AsyncList asynclist)
    {
        totalItemsCount = i;
        list = asynclist;
    }
}
