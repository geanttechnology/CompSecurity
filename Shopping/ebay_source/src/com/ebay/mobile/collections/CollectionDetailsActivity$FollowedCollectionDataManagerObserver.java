// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.collections;

import android.widget.TextView;
import com.ebay.common.content.dm.FollowedEntityDataManager;
import com.ebay.common.model.followinterest.FollowDescriptor;
import com.ebay.common.model.followinterest.FollowType;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.DatedContent;
import com.ebay.nautilus.domain.content.dm.UserContextDataManager;
import com.ebay.nautilus.kernel.content.ResultStatus;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.mobile.collections:
//            CollectionDetailsActivity, CollectionDetailsAdapter

private class <init> extends com.ebay.common.content.dm.
{

    private boolean isFollowed;
    final CollectionDetailsActivity this$0;

    public void onCollectionFollowed(Content content)
    {
        if (CollectionDetailsActivity.access$1400(CollectionDetailsActivity.this) != null)
        {
            CollectionDetailsActivity.access$1400(CollectionDetailsActivity.this).setEnabled(true);
        }
        isFollowed = true;
        content = CollectionDetailsActivity.access$1100(CollectionDetailsActivity.this).getCurrentCountry().getSiteGlobalId();
        CollectionDetailsActivity.access$1300(CollectionDetailsActivity.this).getFollowers(FollowType.COLLECTION, CollectionDetailsActivity.access$1000(), content, CollectionDetailsActivity.access$1200(CollectionDetailsActivity.this), true);
    }

    public void onFollowDeleted(FollowType followtype, String s, ResultStatus resultstatus)
    {
        if (CollectionDetailsActivity.access$1400(CollectionDetailsActivity.this) != null)
        {
            CollectionDetailsActivity.access$1400(CollectionDetailsActivity.this).setEnabled(true);
        }
        if (followtype == FollowType.COLLECTION && s == CollectionDetailsActivity.access$1000())
        {
            isFollowed = false;
            followtype = CollectionDetailsActivity.access$1100(CollectionDetailsActivity.this).getCurrentCountry().getSiteGlobalId();
            CollectionDetailsActivity.access$1300(CollectionDetailsActivity.this).getFollowers(FollowType.COLLECTION, CollectionDetailsActivity.access$1000(), followtype, CollectionDetailsActivity.access$1200(CollectionDetailsActivity.this), true);
        }
    }

    public void onFollowedCollectionsLoaded(FollowedEntityDataManager followedentitydatamanager, DatedContent datedcontent)
    {
        followedentitydatamanager = ((List)datedcontent.getData()).iterator();
        do
        {
            if (!followedentitydatamanager.hasNext())
            {
                break;
            }
            if (!((FollowDescriptor)followedentitydatamanager.next()).collectionId.equals(CollectionDetailsActivity.access$1000()))
            {
                continue;
            }
            isFollowed = true;
            break;
        } while (true);
        followedentitydatamanager = CollectionDetailsActivity.access$1100(CollectionDetailsActivity.this).getCurrentCountry().getSiteGlobalId();
        CollectionDetailsActivity.access$1300(CollectionDetailsActivity.this).getFollowers(FollowType.COLLECTION, CollectionDetailsActivity.access$1000(), followedentitydatamanager, CollectionDetailsActivity.access$1200(CollectionDetailsActivity.this), true);
    }

    public void onFollowersLoaded(FollowType followtype, Content content)
    {
        followtype = (com.ebay.common.net.api.followinterest.)content.getData();
        if (followtype != null)
        {
            CollectionDetailsActivity.access$702(CollectionDetailsActivity.this, ((com.ebay.common.net.api.followinterest.) (followtype))..intValue());
            CollectionDetailsActivity.access$100(CollectionDetailsActivity.this).updateHeaderFollowedInfo(isFollowed, CollectionDetailsActivity.access$700(CollectionDetailsActivity.this));
            if (CollectionDetailsActivity.access$800(CollectionDetailsActivity.this))
            {
                CollectionDetailsActivity.access$802(CollectionDetailsActivity.this, false);
                CollectionDetailsActivity.access$900(CollectionDetailsActivity.this, TrackingType.PAGE_IMPRESSION);
                return;
            }
        }
    }

    private a()
    {
        this$0 = CollectionDetailsActivity.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
