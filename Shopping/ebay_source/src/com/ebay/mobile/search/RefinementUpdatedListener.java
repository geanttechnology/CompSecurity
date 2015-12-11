// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search;

import com.ebay.common.model.search.EbayAspectHistogram;
import com.ebay.common.net.api.search.SearchParameters;

public interface RefinementUpdatedListener
{

    public abstract void onSearchRefinement(SearchParameters searchparameters, EbayAspectHistogram ebayaspecthistogram);
}
