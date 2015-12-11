// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.following;

import com.ebay.mobile.common.view.ViewModel;
import java.util.List;

public class FollowedCollectionViewModel extends ViewModel
{

    public final String id;
    public final String imageUrl1;
    public final String imageUrl2;
    public final String imageUrl3;
    public final String title;

    public FollowedCollectionViewModel(int i, com.ebay.nautilus.domain.data.FollowingContent.FollowedCollection followedcollection, com.ebay.mobile.common.view.ViewModel.OnClickListener onclicklistener)
    {
        super(i, onclicklistener);
        id = followedcollection.collectionId;
        title = followedcollection.name;
        if (followedcollection.imageUrls != null)
        {
            i = followedcollection.imageUrls.size();
        } else
        {
            i = 0;
        }
        if (i > 0)
        {
            onclicklistener = (String)followedcollection.imageUrls.get(0);
        } else
        {
            onclicklistener = null;
        }
        imageUrl1 = onclicklistener;
        if (i > 1)
        {
            onclicklistener = (String)followedcollection.imageUrls.get(1);
        } else
        {
            onclicklistener = null;
        }
        imageUrl2 = onclicklistener;
        if (i > 2)
        {
            followedcollection = (String)followedcollection.imageUrls.get(2);
        } else
        {
            followedcollection = null;
        }
        imageUrl3 = followedcollection;
    }
}
