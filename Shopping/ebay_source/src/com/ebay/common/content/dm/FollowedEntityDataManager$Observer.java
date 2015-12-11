// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.content.dm;

import com.ebay.common.model.followinterest.FollowType;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.DatedContent;
import com.ebay.nautilus.kernel.content.ResultStatus;

// Referenced classes of package com.ebay.common.content.dm:
//            FollowedEntityDataManager

public static interface 
{

    public abstract void onCollectionFollowed(Content content);

    public abstract void onFollowDeleted(FollowType followtype, String s, ResultStatus resultstatus);

    public abstract void onFollowedCollectionsLoaded(FollowedEntityDataManager followedentitydatamanager, DatedContent datedcontent);

    public abstract void onFollowedSearchesLoaded(FollowedEntityDataManager followedentitydatamanager, DatedContent datedcontent);

    public abstract void onFollowedUsersLoaded(FollowedEntityDataManager followedentitydatamanager, DatedContent datedcontent);

    public abstract void onFollowersLoaded(FollowType followtype, Content content);

    public abstract void onFollowsUpdated(FollowedEntityDataManager followedentitydatamanager, Content content);

    public abstract void onSearchFollowed(Content content);

    public abstract void onUserFollowed(Content content);
}
