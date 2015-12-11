// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.recentlyviewed;

import android.view.View;
import android.widget.AdapterView;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.BBYProduct;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Summary;
import java.util.ArrayList;

// Referenced classes of package com.bestbuy.android.activities.recentlyviewed:
//            RecentlyViewedHomeCard

class a
    implements android.widget.stener
{

    final RecentlyViewedHomeCard a;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = (BBYProduct)RecentlyViewedHomeCard.a(a).get(i);
        ((HomeActivity)a.d).openPDP(adapterview.getSkuId(), false, (new StringBuilder()).append("").append(adapterview.getSummary().getProductId()).toString(), true, adapterview, "GHP", "");
        ((HomeActivity)a.d).sendRecommendations("homeclickcustomeralsoviewed", "GHP", adapterview);
    }

    (RecentlyViewedHomeCard recentlyviewedhomecard)
    {
        a = recentlyviewedhomecard;
        super();
    }
}
