// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.content.dm;

import com.ebay.common.model.followinterest.FollowType;
import com.ebay.common.net.api.followinterest.DeleteFollowLoadTask;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.content.ResultStatus;

// Referenced classes of package com.ebay.common.content.dm:
//            FollowedEntityDataManager

class val.id
    implements com.ebay.common.net.api.followinterest.r
{

    final FollowedEntityDataManager this$0;
    final FollowType val$followType;
    final String val$id;

    public void handleFollowDeleted(DeleteFollowLoadTask deletefollowloadtask, ResultStatus resultstatus)
    {
        NautilusKernel.verifyMain();
        if (deletefollowloadtask == null || deletefollowloadtask.isCancelled() || resultstatus.hasError())
        {
            if (FollowedEntityDataManager.access$200()._fld200)
            {
                FollowedEntityDataManager.access$200()._mth200("deleteFollow/DeleteFollowLoadTask failed: ");
            }
            ((server)FollowedEntityDataManager.access$1800(FollowedEntityDataManager.this)).onFollowDeleted(val$followType, val$id, resultstatus);
            return;
        }
        deletefollowloadtask = FollowedEntityDataManager.access$1200();
        if (deletefollowloadtask != null)
        {
            deletefollowloadtask.removeFollow(val$followType, val$id);
        }
        FollowedEntityDataManager.access$800(FollowedEntityDataManager.this).setDirty();
        ((server)FollowedEntityDataManager.access$1900(FollowedEntityDataManager.this)).onFollowDeleted(val$followType, val$id, resultstatus);
        FollowedEntityDataManager.access$1400(FollowedEntityDataManager.this);
    }

    Task()
    {
        this$0 = final_followedentitydatamanager;
        val$followType = followtype;
        val$id = String.this;
        super();
    }
}
