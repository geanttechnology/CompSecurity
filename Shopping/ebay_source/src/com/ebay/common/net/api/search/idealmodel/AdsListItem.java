// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search.idealmodel;

import android.view.View;

// Referenced classes of package com.ebay.common.net.api.search.idealmodel:
//            SrpListItem

public class AdsListItem extends SrpListItem
{

    public final View googleTextAdView;
    public final com.ebay.common.net.api.search.SearchResultState.SearchAds searchAds;

    public AdsListItem(View view)
    {
        super(SrpListItem.SrpListItemType.ADS, null, null);
        googleTextAdView = view;
        searchAds = null;
    }

    public AdsListItem(com.ebay.common.net.api.search.SearchResultState.SearchAds searchads)
    {
        super(SrpListItem.SrpListItemType.ADS, null, null);
        searchAds = searchads;
        googleTextAdView = null;
    }
}
