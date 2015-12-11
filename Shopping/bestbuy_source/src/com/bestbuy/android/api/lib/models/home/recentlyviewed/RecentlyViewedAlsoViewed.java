// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.home.recentlyviewed;

import gu;
import java.io.Serializable;

// Referenced classes of package com.bestbuy.android.api.lib.models.home.recentlyviewed:
//            RecentlyViewedAlsoViewedRecommendations

public class RecentlyViewedAlsoViewed
    implements gu, Serializable
{

    private static final long serialVersionUID = 0xc5d2e468f521691aL;
    private RecentlyViewedAlsoViewedRecommendations recommendations;

    public RecentlyViewedAlsoViewed()
    {
    }

    public RecentlyViewedAlsoViewedRecommendations getRecommendations()
    {
        return recommendations;
    }

    public void setRecommendations(RecentlyViewedAlsoViewedRecommendations recentlyviewedalsoviewedrecommendations)
    {
        recommendations = recentlyviewedalsoviewedrecommendations;
    }
}
