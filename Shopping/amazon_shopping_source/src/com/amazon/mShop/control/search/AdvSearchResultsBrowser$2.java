// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.search;

import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.services.mShop.AdvSearchResults;

// Referenced classes of package com.amazon.mShop.control.search:
//            AdvSearchResultsBrowser

class 
    implements Runnable
{

    final AdvSearchResultsBrowser this$0;
    final AdvSearchResults val$value;

    public void run()
    {
        AdvSearchResultsBrowser.access$002(AdvSearchResultsBrowser.this, true);
        AdvSearchResultsBrowser.access$1302(AdvSearchResultsBrowser.this, val$value.getResultsDesc());
        mTotalCount = val$value.getTotalCount().intValue();
        if (!Util.isEmpty(val$value.getQuery()))
        {
            AdvSearchResultsBrowser.access$1402(AdvSearchResultsBrowser.this, val$value.getQuery());
        }
        AdvSearchResultsBrowser.access$502(AdvSearchResultsBrowser.this, val$value.getFilters());
    }

    ()
    {
        this$0 = final_advsearchresultsbrowser;
        val$value = AdvSearchResults.this;
        super();
    }
}
