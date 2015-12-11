// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.content.dm;

import com.ebay.common.model.followinterest.FollowDescriptor;
import com.ebay.common.model.followinterest.FollowType;
import com.ebay.common.net.api.followinterest.CreateFollowLoadTask;
import com.ebay.common.net.api.followinterest.InterestDescriptor;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.content.ResultStatus;

// Referenced classes of package com.ebay.common.content.dm:
//            FollowedEntityDataManager

class val.interestDescriptor
    implements com.ebay.common.net.api.followinterest.Descriptor
{

    final is._cls0 this$1;
    final is._cls0 val$completionObserver;
    final InterestDescriptor val$interestDescriptor;

    public void handleFollowCreated(CreateFollowLoadTask createfollowloadtask, Content content)
    {
        NautilusKernel.verifyMain();
        if (createfollowloadtask == null || createfollowloadtask.isCancelled() || content == null || content.getStatus().hasError())
        {
            if (FollowedEntityDataManager.access$200().interestDescriptor)
            {
                FollowedEntityDataManager.access$200().interestDescriptor("FollowSearchOrchestrator: createFollowForInterest failed");
            }
            val$completionObserver.completionObserver(content);
            return;
        }
        createfollowloadtask = FollowedEntityDataManager.access$1200();
        if (createfollowloadtask != null)
        {
            createfollowloadtask.completionObserver(FollowType.INTEREST, Long.toString(val$interestDescriptor.interestId));
            createfollowloadtask.interestDescriptor(FollowType.INTEREST, (FollowDescriptor)content.getData());
        }
        FollowedEntityDataManager.access$800(_fld0).setDirty();
        val$completionObserver.completionObserver(content);
        FollowedEntityDataManager.access$1400(_fld0);
    }

    rchestrator()
    {
        this$1 = final_rchestrator;
        val$completionObserver = rchestrator1;
        val$interestDescriptor = InterestDescriptor.this;
        super();
    }
}
