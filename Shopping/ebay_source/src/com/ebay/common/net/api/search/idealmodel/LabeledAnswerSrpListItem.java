// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search.idealmodel;

import com.ebay.nautilus.domain.data.EbaySearchListItem;
import com.ebay.nautilus.domain.data.ItemCurrency;
import java.util.Date;

// Referenced classes of package com.ebay.common.net.api.search.idealmodel:
//            SrpListItem, SrpListItemViewModel

public class LabeledAnswerSrpListItem extends SrpListItem
{

    public final long answerId;
    public final long id;
    private final EbaySearchListItem item;
    public final String label;
    public boolean trackingSent;
    public final SrpListItemViewModel viewModel;

    public LabeledAnswerSrpListItem(EbaySearchListItem ebaysearchlistitem, String s, String s1, String s2, long l, long l1, String s3)
    {
        super(SrpListItem.SrpListItemType.LABELED_ANSWER, s, s1);
        item = ebaysearchlistitem;
        label = s2;
        id = l;
        answerId = l1;
        viewModel = SrpListItemViewModel.instanceFrom(ebaysearchlistitem);
        viewModel.isPromoted = true;
        viewModel.promotedLabel = s3;
        trackingSent = false;
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
}
