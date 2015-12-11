// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search;

import com.ebay.common.content.dm.FollowedEntityDataManager;
import com.ebay.common.model.followinterest.FollowDescriptor;
import com.ebay.nautilus.kernel.content.EbayContext;
import java.util.concurrent.Callable;

// Referenced classes of package com.ebay.mobile.search:
//            SearchUtil

static final class val.searchId
    implements Callable
{

    final EbayContext val$ebayContext;
    final String val$searchId;

    public FollowDescriptor call()
        throws Exception
    {
        return SearchUtil.getFollowedEntityDataManager(val$ebayContext).getFollowByInterestId(val$searchId);
    }

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    yContext(EbayContext ebaycontext, String s)
    {
        val$ebayContext = ebaycontext;
        val$searchId = s;
        super();
    }
}
