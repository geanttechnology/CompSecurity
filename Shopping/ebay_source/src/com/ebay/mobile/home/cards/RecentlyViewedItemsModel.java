// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.cards;

import com.ebay.mobile.common.view.ViewModel;
import com.ebay.nautilus.domain.data.UnifiedStream.ContentSourceEnum;
import java.util.ArrayList;
import java.util.List;

public class RecentlyViewedItemsModel extends ViewModel
{

    public final List contentRecords = new ArrayList();

    public RecentlyViewedItemsModel(int i, com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup contentgroup, com.ebay.mobile.common.view.ViewModel.OnClickListener onclicklistener)
    {
        super(i, onclicklistener);
        if (contentgroup.contentSource != ContentSourceEnum.RECENTLY_VIEWED_ITEMS)
        {
            throw new IllegalArgumentException("contentGroup.contentSource doesn't match what this viewModel accepts");
        }
        if (contentgroup.contents != null)
        {
            contentRecords.addAll(contentgroup.contents);
        }
    }
}
