// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.search;

import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.AdvSearchResults;
import com.amazon.rio.j2me.client.services.mShop.SortOption;
import java.util.List;

// Referenced classes of package com.amazon.mShop.control.search:
//            AdvSearchResultsBrowser

class 
    implements Runnable
{

    final AdvSearchResultsBrowser this$0;
    final ServiceCall val$serviceCall;
    final AdvSearchResults val$value;

    public void run()
    {
        if (val$serviceCall == getCurrentServiceCall())
        {
            cancelServiceCallForStubs();
            if (!AdvSearchResultsBrowser.access$000(AdvSearchResultsBrowser.this))
            {
                AdvSearchResultsBrowser.access$102(AdvSearchResultsBrowser.this, val$value.getTotalCount().intValue());
            }
            if (val$value.getResultsDesc() != null)
            {
                AdvSearchResultsBrowser.access$202(AdvSearchResultsBrowser.this, val$value.getResultsDesc());
            }
            mTotalCount = val$value.getTotalCount().intValue();
            AdvSearchResultsBrowser.access$302(AdvSearchResultsBrowser.this, val$value);
            if (!Util.isEmpty(val$value.getRefinements()))
            {
                AdvSearchResultsBrowser.access$402(AdvSearchResultsBrowser.this, val$value.getRefinements());
                AdvSearchResultsBrowser.access$502(AdvSearchResultsBrowser.this, val$value.getFilters());
                AdvSearchResultsBrowser.access$602(AdvSearchResultsBrowser.this, null);
                AdvSearchResultsBrowser.access$702(AdvSearchResultsBrowser.this, val$value.getBreadcrumbs());
            }
            if (!Util.isEmpty(val$value.getSortOptions()))
            {
                AdvSearchResultsBrowser.access$802(AdvSearchResultsBrowser.this, val$value.getSortOptions());
                if (AdvSearchResultsBrowser.access$900(AdvSearchResultsBrowser.this) == null && AdvSearchResultsBrowser.access$800(AdvSearchResultsBrowser.this).size() > 1)
                {
                    AdvSearchResultsBrowser.access$902(AdvSearchResultsBrowser.this, (SortOption)AdvSearchResultsBrowser.access$800(AdvSearchResultsBrowser.this).get(0));
                }
            }
        }
    }

    ()
    {
        this$0 = final_advsearchresultsbrowser;
        val$serviceCall = servicecall;
        val$value = AdvSearchResults.this;
        super();
    }
}
