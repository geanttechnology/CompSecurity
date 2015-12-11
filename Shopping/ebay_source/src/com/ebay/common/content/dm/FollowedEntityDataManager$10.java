// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.content.dm;

import com.ebay.common.model.followinterest.FollowDescriptor;
import com.ebay.common.net.api.followinterest.UpdateFollowLoadTask;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.content.ResultStatus;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.ebay.common.content.dm:
//            FollowedEntityDataManager

class val.pendingUpdates
    implements com.ebay.common.net.api.followinterest.
{

    final FollowedEntityDataManager this$0;
    final Semaphore val$maxThreads;
    final AtomicInteger val$pendingUpdates;

    public void handleFollowUpdated(UpdateFollowLoadTask updatefollowloadtask, Content content)
    {
        NautilusKernel.verifyMain();
        val$maxThreads.release();
        int i = val$pendingUpdates.decrementAndGet();
        ResultStatus resultstatus;
        if (content == null)
        {
            resultstatus = null;
        } else
        {
            resultstatus = content.getStatus();
        }
        if (updatefollowloadtask != null && !updatefollowloadtask.isCancelled() && resultstatus != null && !resultstatus.hasError()) goto _L2; else goto _L1
_L1:
        if (FollowedEntityDataManager.access$200()._fld200)
        {
            FollowedEntityDataManager.access$200()._mth200("TEST_updateFollow/UpdateFollowLoadTask failed...");
        }
_L4:
        if (i == 0)
        {
            ((erver)FollowedEntityDataManager.access$2000(FollowedEntityDataManager.this)).onFollowsUpdated(FollowedEntityDataManager.this, new Content(ResultStatus.SUCCESS));
        }
        return;
_L2:
        FollowedEntityDataManager.access$800(FollowedEntityDataManager.this).setDirty();
        updatefollowloadtask = (FollowDescriptor)content.getData();
        content = FollowedEntityDataManager.access$1200();
        if (content != null)
        {
            content = content.getFollowByInterestId(updatefollowloadtask.getInterestId());
            if (content != null)
            {
                content.notifications = ((FollowDescriptor) (updatefollowloadtask)).notifications;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    ask()
    {
        this$0 = final_followedentitydatamanager;
        val$maxThreads = semaphore;
        val$pendingUpdates = AtomicInteger.this;
        super();
    }
}
