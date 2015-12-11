// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search;

import com.ebay.common.content.dm.FollowedEntityDataManager;
import com.ebay.nautilus.domain.content.DataManager;
import com.ebay.nautilus.kernel.content.EbayContext;
import java.util.concurrent.Callable;

// Referenced classes of package com.ebay.mobile.search:
//            SearchUtil

static final class val.ebayContext
    implements Callable
{

    final EbayContext val$ebayContext;

    public FollowedEntityDataManager call()
        throws Exception
    {
        return (FollowedEntityDataManager)DataManager.get(val$ebayContext, FollowedEntityDataManager.KEY);
    }

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    yContext(EbayContext ebaycontext)
    {
        val$ebayContext = ebaycontext;
        super();
    }
}
