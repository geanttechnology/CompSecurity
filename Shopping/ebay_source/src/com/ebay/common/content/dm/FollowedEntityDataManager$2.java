// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.content.dm;

import android.util.LruCache;
import com.ebay.common.model.followinterest.FollowType;
import com.ebay.common.net.api.followinterest.GetFollowersLoadTask;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.content.ResultStatus;
import java.util.Map;

// Referenced classes of package com.ebay.common.content.dm:
//            FollowedEntityDataManager

class val.id
    implements com.ebay.common.net.api.followinterest.r
{

    final FollowedEntityDataManager this$0;
    final FollowType val$followType;
    final String val$id;

    public void handleFollowersLoaded(GetFollowersLoadTask getfollowersloadtask, Content content)
    {
        NautilusKernel.verifyMain();
        ResultStatus resultstatus;
        if (content != null)
        {
            resultstatus = content.getStatus();
        } else
        {
            resultstatus = null;
        }
        if (getfollowersloadtask == null || getfollowersloadtask.isCancelled() || resultstatus == null || resultstatus.hasError())
        {
            if (FollowedEntityDataManager.access$200()._fld200)
            {
                FollowedEntityDataManager.access$200()._mth200("getFollowers - loaded -> onFollowersLoaded");
            }
            ((server)FollowedEntityDataManager.access$300(FollowedEntityDataManager.this)).onFollowersLoaded(val$followType, content);
            return;
        }
        if (!FollowedEntityDataManager.access$400(FollowedEntityDataManager.this).containsKey(val$followType))
        {
            FollowedEntityDataManager.access$400(FollowedEntityDataManager.this).put(val$followType, new LruCache(FollowedEntityDataManager.access$500(FollowedEntityDataManager.this).getMaxCachedFollowerSummaries()));
        }
        ((LruCache)FollowedEntityDataManager.access$400(FollowedEntityDataManager.this).get(val$followType)).put(val$id, content.getData());
        ((server)FollowedEntityDataManager.access$600(FollowedEntityDataManager.this)).onFollowersLoaded(val$followType, content);
    }

    Task()
    {
        this$0 = final_followedentitydatamanager;
        val$followType = followtype;
        val$id = String.this;
        super();
    }
}
