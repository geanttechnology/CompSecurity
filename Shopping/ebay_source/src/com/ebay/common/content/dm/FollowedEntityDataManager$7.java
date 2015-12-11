// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.content.dm;

import com.ebay.common.model.followinterest.FollowDescriptor;
import com.ebay.common.model.followinterest.FollowType;
import com.ebay.common.net.api.followinterest.CreateFollowLoadTask;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.content.ResultStatus;

// Referenced classes of package com.ebay.common.content.dm:
//            FollowedEntityDataManager

class val.collectionId
    implements com.ebay.common.net.api.followinterest.r
{

    final FollowedEntityDataManager this$0;
    final String val$collectionId;

    public void handleFollowCreated(CreateFollowLoadTask createfollowloadtask, Content content)
    {
        NautilusKernel.verifyMain();
        ResultStatus resultstatus;
        if (content == null)
        {
            resultstatus = null;
        } else
        {
            resultstatus = content.getStatus();
        }
        if (createfollowloadtask == null || createfollowloadtask.isCancelled() || content == null || content.getStatus().hasError())
        {
            ((server)FollowedEntityDataManager.access$1500(FollowedEntityDataManager.this)).onCollectionFollowed(new Content(resultstatus));
            return;
        }
        createfollowloadtask = FollowedEntityDataManager.access$1200();
        if (createfollowloadtask != null)
        {
            createfollowloadtask.addFollow(FollowType.COLLECTION, (FollowDescriptor)content.getData());
        }
        FollowedEntityDataManager.access$800(FollowedEntityDataManager.this).setDirty();
        ((server)FollowedEntityDataManager.access$1600(FollowedEntityDataManager.this)).onCollectionFollowed(new Content(val$collectionId, resultstatus));
        FollowedEntityDataManager.access$1400(FollowedEntityDataManager.this);
    }

    Task()
    {
        this$0 = final_followedentitydatamanager;
        val$collectionId = String.this;
        super();
    }
}
