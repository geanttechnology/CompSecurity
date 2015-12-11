// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.content.dm;

import android.text.TextUtils;
import com.ebay.common.model.followinterest.FollowDescriptor;
import com.ebay.common.net.api.followinterest.UpdateFollowLoadTask;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.content.ResultStatus;
import java.util.Collections;

// Referenced classes of package com.ebay.common.content.dm:
//            FollowedEntityDataManager

class val.interestId
    implements com.ebay.common.net.api.followinterest.
{

    final FollowedEntityDataManager this$0;
    final String val$interestId;

    public void handleFollowUpdated(UpdateFollowLoadTask updatefollowloadtask, Content content)
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
        if (updatefollowloadtask == null || updatefollowloadtask.isCancelled() || resultstatus == null || resultstatus.hasError())
        {
            if (FollowedEntityDataManager.access$200()._fld200)
            {
                FollowedEntityDataManager.access$200()._mth200("TEST_updateFollow/UpdateFollowLoadTask failed: ");
            }
            ((erver)FollowedEntityDataManager.access$2100(FollowedEntityDataManager.this)).onFollowsUpdated(FollowedEntityDataManager.this, new Content(resultstatus));
            return;
        }
        FollowedEntityDataManager.access$800(FollowedEntityDataManager.this).setDirty();
        updatefollowloadtask = FollowedEntityDataManager.access$1200().getFollowByInterestId(val$interestId);
        if (updatefollowloadtask != null)
        {
            content = (FollowDescriptor)content.getData();
            if (!TextUtils.isEmpty(((FollowDescriptor) (content)).customTitle))
            {
                updatefollowloadtask.customTitle = ((FollowDescriptor) (content)).customTitle;
            }
            if (((FollowDescriptor) (content)).notifications != null)
            {
                updatefollowloadtask.notifications = ((FollowDescriptor) (content)).notifications;
            }
        }
        ((erver)FollowedEntityDataManager.access$2200(FollowedEntityDataManager.this)).onFollowsUpdated(FollowedEntityDataManager.this, new Content(Collections.singletonList(updatefollowloadtask), ResultStatus.SUCCESS));
    }

    ask()
    {
        this$0 = final_followedentitydatamanager;
        val$interestId = String.this;
        super();
    }
}
