// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import com.ebay.common.model.AllBiddersData;
import com.ebay.mobile.Item;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.kernel.content.ResultStatus;

// Referenced classes of package com.ebay.mobile.viewitem:
//            BiddingDataManager

public static final class item extends Content
{

    final Item item;

    public (AllBiddersData allbiddersdata, ResultStatus resultstatus, Item item1)
    {
        super(allbiddersdata, resultstatus);
        item = item1;
    }
}
