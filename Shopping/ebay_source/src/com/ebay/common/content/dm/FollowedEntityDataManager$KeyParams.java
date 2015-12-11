// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.content.dm;

import com.ebay.nautilus.domain.content.dm.UserContextObservingDataManager;
import com.ebay.nautilus.kernel.content.EbayContext;

// Referenced classes of package com.ebay.common.content.dm:
//            FollowedEntityDataManager

public static final class ager extends com.ebay.nautilus.domain.content.dm.ase
{

    static final create KEY = new <init>();

    protected FollowedEntityDataManager create(EbayContext ebaycontext)
    {
        return new FollowedEntityDataManager(ebaycontext, com/ebay/common/content/dm/FollowedEntityDataManager$Observer, this, null);
    }

    protected volatile UserContextObservingDataManager create(EbayContext ebaycontext)
    {
        return create(ebaycontext);
    }


    ager()
    {
    }
}
