// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import com.ebay.nautilus.domain.content.dm.UserContextObservingDataManager;
import com.ebay.nautilus.kernel.content.EbayContext;

// Referenced classes of package com.ebay.mobile.viewitem:
//            ItemDataManager

public static final class rvingDataManager extends com.ebay.nautilus.domain.content.dm.nager.KeyBase
{

    protected ItemDataManager create(EbayContext ebaycontext)
    {
        return new ItemDataManager(ebaycontext, this);
    }

    protected volatile UserContextObservingDataManager create(EbayContext ebaycontext)
    {
        return create(ebaycontext);
    }

    public boolean equals(Object obj)
    {
        return obj != null && obj.getClass() == getClass();
    }

    public rvingDataManager()
    {
    }
}
