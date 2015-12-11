// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.nautilus.domain.net.api.trading.EbayTradingApi;

public final class SearchDetails
{

    public final EbayTradingApi api;
    public final int countPerPage;
    public final int type;

    public SearchDetails(EbayTradingApi ebaytradingapi, int i, int j)
    {
        api = ebaytradingapi;
        countPerPage = i;
        type = j;
    }
}
