// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search;

import android.view.View;
import com.ebay.common.net.api.search.SearchParameters;

// Referenced classes of package com.ebay.mobile.search:
//            SearchResultFragment

public class params
    implements android.view.hListener
{

    public final SearchParameters params;
    final SearchResultFragment this$0;

    public void onClick(View view)
    {
        restartSearch(params, false, false);
    }

    public (SearchParameters searchparameters)
    {
        this$0 = SearchResultFragment.this;
        super();
        params = searchparameters;
    }
}
