// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.collections;

import com.ebay.mobile.common.view.ViewModel;
import java.util.ArrayList;
import java.util.List;

public class CollectionViewModel extends ViewModel
{

    public final String body;
    public final String collectionId;
    public final String coverImage;
    public final int entryCount;
    public final List images = new ArrayList();
    public boolean isCollectionOwnerShown;
    public final com.ebay.nautilus.domain.data.BaseCommonType.Amount lowestAmount;
    public final String title;
    public final String userImage;
    public final String username;

    public CollectionViewModel(int i, com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Collection collection, com.ebay.mobile.common.view.ViewModel.OnClickListener onclicklistener)
    {
        super(i, onclicklistener);
        isCollectionOwnerShown = false;
        String s2 = null;
        onclicklistener = null;
        String s1 = null;
        String s = null;
        Object obj = null;
        Object obj1 = null;
        com.ebay.nautilus.domain.data.BaseCommonType.Amount amount = null;
        i = 0;
        com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Collection collection1 = obj1;
        String s3 = obj;
        if (collection != null)
        {
            String s4 = collection.name;
            String s5 = collection.description;
            String s6 = collection.imageUrl;
            String s7 = collection.collectionId;
            com.ebay.nautilus.domain.data.BaseCommonType.Amount amount1 = collection.lowestAmount;
            int j = collection.entryCount;
            if (collection.images != null)
            {
                images.addAll(collection.images);
            }
            com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Collection.User user = collection.creator;
            onclicklistener = s5;
            s = s7;
            s1 = s6;
            i = j;
            amount = amount1;
            s2 = s4;
            collection1 = obj1;
            s3 = obj;
            if (user != null)
            {
                collection = user.profileImageURL;
                com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Collection.User.UserId userid = user.userIdentifier;
                onclicklistener = s5;
                s = s7;
                s1 = s6;
                i = j;
                amount = amount1;
                s2 = s4;
                collection1 = collection;
                s3 = obj;
                if (userid != null)
                {
                    s3 = userid.username;
                    collection1 = collection;
                    s2 = s4;
                    amount = amount1;
                    i = j;
                    s1 = s6;
                    s = s7;
                    onclicklistener = s5;
                }
            }
        }
        title = s2;
        body = onclicklistener;
        coverImage = s1;
        collectionId = s;
        username = s3;
        userImage = collection1;
        lowestAmount = amount;
        entryCount = i;
    }
}
