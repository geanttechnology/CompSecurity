// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.util.Log;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.data.UnifiedStream.SearchRefinement;
import com.ebay.nautilus.domain.datamapping.BaseDataMapped;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            UssDealsHistogramDataManager

private static final class ttl extends BaseDataMapped
{

    public final SearchRefinement searchRefinement;
    public long ttl;

    public boolean isStale()
    {
        return System.currentTimeMillis() > ttl;
    }

    public (Content content)
    {
        searchRefinement = (SearchRefinement)content.getData();
        ttl = System.currentTimeMillis() + 0x5265c00L;
        if (Log.isLoggable("UssDealsHistogramDmTtl", 3))
        {
            ttl = System.currentTimeMillis() + 0x927c0L;
            UssDealsHistogramDataManager.logger.ttl("overriding TTL to ten minutes");
        }
    }
}
