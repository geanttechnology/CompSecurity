// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search.idealmodel;

import com.ebay.nautilus.domain.data.EbaySearchListItem;
import com.ebay.nautilus.domain.data.ItemCurrency;
import java.util.Date;

// Referenced classes of package com.ebay.common.net.api.search.idealmodel:
//            SrpListItem, SrpListItemViewModel

public class RegularSrpListItem extends SrpListItem
{

    private final EbaySearchListItem item;
    public final SrpListItemViewModel viewModel;

    public RegularSrpListItem(EbaySearchListItem ebaysearchlistitem)
    {
        super(SrpListItem.SrpListItemType.REGULAR, null, null);
        item = ebaysearchlistitem;
        viewModel = SrpListItemViewModel.instanceFrom(ebaysearchlistitem);
    }

    public Date getEndDate()
    {
        return item.endDate;
    }

    public long getId()
    {
        return item.id;
    }

    public ItemCurrency getOriginalRetailPrice()
    {
        return item.originalRetailPrice;
    }

    public boolean isLocalItem()
    {
        return item.isEbn || item.isInStorePickup || "LocalDelivery".equals(item.shippingType) || item.isPickupAndDropOff;
    }
}
