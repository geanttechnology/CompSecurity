// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search;

import android.content.Intent;
import android.view.View;
import com.ebay.common.net.api.search.SearchParameters;
import com.ebay.mobile.analytics.model.SourceIdentification;

// Referenced classes of package com.ebay.mobile.search:
//            SearchResultFragmentActivity, MainSearchActivity

class this._cls0
    implements android.view.ctivity._cls4
{

    final SearchResultFragmentActivity this$0;

    public void onClick(View view)
    {
        view = new SourceIdentification("SearchResultsViewed");
        Intent intent = new Intent(SearchResultFragmentActivity.this, com/ebay/mobile/search/MainSearchActivity);
        intent.putExtra("com.ebay.mobile.analytics.sid", view);
        intent.putExtra("sellerId", searchParameters.sellerId);
        intent.putExtra("sellerOffer", searchParameters.sellerOffer);
        startActivityForResult(intent, -1);
    }

    ()
    {
        this$0 = SearchResultFragmentActivity.this;
        super();
    }
}
