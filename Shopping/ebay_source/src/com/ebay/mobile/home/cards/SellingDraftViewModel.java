// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.cards;

import com.ebay.mobile.common.view.ViewModel;
import java.text.DateFormat;
import java.util.Locale;

public class SellingDraftViewModel extends ViewModel
{

    public final String categoryIdPath;
    private final DateFormat dateFormatter = DateFormat.getDateInstance(2, Locale.getDefault());
    public final String draftId;
    public final String draftListingMode;
    public final String draftModifiedDate;
    public final int draftSiteId;
    public String draftTitle;
    public final String imageUrl;

    public SellingDraftViewModel(int i, com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.SellingDraft sellingdraft, com.ebay.mobile.common.view.ViewModel.OnClickListener onclicklistener)
    {
        Object obj = null;
        super(i, onclicklistener);
        imageUrl = sellingdraft.imageUrl;
        draftId = sellingdraft.draftId;
        draftListingMode = sellingdraft.listingMode;
        categoryIdPath = sellingdraft.categoryIdPath;
        draftSiteId = sellingdraft.siteId;
        if (sellingdraft.title != null)
        {
            onclicklistener = sellingdraft.title.getSourceContent();
        } else
        {
            onclicklistener = null;
        }
        draftTitle = onclicklistener;
        onclicklistener = obj;
        if (sellingdraft.lastModified != null)
        {
            onclicklistener = dateFormatter.format(sellingdraft.lastModified.value);
        }
        draftModifiedDate = onclicklistener;
    }
}
