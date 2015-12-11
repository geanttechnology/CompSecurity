// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.collections;

import com.ebay.mobile.common.view.ViewModel;

public class CollectionDetailsPageHeaderViewModel extends ViewModel
{

    public final com.ebay.nautilus.domain.data.CollectionDetail.Collection collection;
    public final String description;
    public int followerCount;
    public final String headline;
    public final String imageUrl;
    public boolean isCollectionFollowed;
    public final String subTitle;
    public final String title;

    public CollectionDetailsPageHeaderViewModel(int i, com.ebay.mobile.common.view.ViewModel.OnClickListener onclicklistener, com.ebay.nautilus.domain.data.CollectionDetail.Collection collection1)
    {
        super(i, onclicklistener);
        title = collection1.name;
        subTitle = collection1.subtitle;
        collection = collection1;
        headline = collection1.headline;
        description = collection1.description;
        if (collection1.mediaAttributes != null && collection1.mediaAttributes.photo != null && collection1.mediaAttributes.photo.imageURL != null)
        {
            imageUrl = collection1.mediaAttributes.photo.imageURL;
            return;
        } else
        {
            imageUrl = null;
            return;
        }
    }
}
