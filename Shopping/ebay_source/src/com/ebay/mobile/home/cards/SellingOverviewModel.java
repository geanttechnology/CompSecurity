// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.cards;

import com.ebay.mobile.common.view.ViewModel;

public class SellingOverviewModel extends ViewModel
{

    public final com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord record;
    public final boolean sellContentEnabled;
    public final com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.SellingImageList sellingImageList;

    public SellingOverviewModel(int i, com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.SellingImageList sellingimagelist, com.ebay.mobile.common.view.ViewModel.OnClickListener onclicklistener)
    {
        super(i, onclicklistener);
        sellingImageList = sellingimagelist;
        record = null;
        sellContentEnabled = true;
    }

    public SellingOverviewModel(int i, com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord contentrecord, com.ebay.mobile.common.view.ViewModel.OnClickListener onclicklistener)
    {
        this(i, contentrecord, true, onclicklistener);
    }

    public SellingOverviewModel(int i, com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord contentrecord, boolean flag, com.ebay.mobile.common.view.ViewModel.OnClickListener onclicklistener)
    {
        super(i, onclicklistener);
        record = contentrecord;
        sellContentEnabled = flag;
        sellingImageList = null;
    }
}
