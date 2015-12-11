// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import com.ebay.nautilus.domain.content.DataManager;
import com.ebay.nautilus.kernel.content.EbayContext;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            UserContextObservingDataManager

public static abstract class Q extends com.ebay.nautilus.domain.content.se
{

    protected abstract UserContextObservingDataManager create(EbayContext ebaycontext);

    public volatile DataManager createManager(EbayContext ebaycontext)
    {
        return createManager(ebaycontext);
    }

    public final UserContextObservingDataManager createManager(EbayContext ebaycontext)
    {
        ebaycontext = create(ebaycontext);
        ebaycontext.create();
        return ebaycontext;
    }

    public Q()
    {
    }
}
