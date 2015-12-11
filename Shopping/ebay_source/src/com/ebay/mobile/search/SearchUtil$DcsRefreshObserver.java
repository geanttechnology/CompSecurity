// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search;

import android.database.DataSetObserver;
import com.ebay.nautilus.kernel.content.EbayContext;

// Referenced classes of package com.ebay.mobile.search:
//            SearchUtil

private static class cationContext extends DataSetObserver
{

    private EbayContext ebayContext;

    public void onChanged()
    {
        SearchUtil.validateCacheRelevance(SearchUtil.getFollowedEntityDataManager(ebayContext));
    }

    public (EbayContext ebaycontext)
    {
        ebayContext = ebaycontext.getApplicationContext();
    }
}
