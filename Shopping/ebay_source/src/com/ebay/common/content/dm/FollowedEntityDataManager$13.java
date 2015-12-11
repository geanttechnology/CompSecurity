// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.content.dm;

import com.ebay.common.net.api.followinterest.CreateFollowLoadTask;
import com.ebay.nautilus.domain.content.Content;

// Referenced classes of package com.ebay.common.content.dm:
//            FollowedEntityDataManager

class val.onComplete
    implements com.ebay.common.net.api.followinterest.
{

    final FollowedEntityDataManager this$0;
    final Runnable val$onComplete;

    public void handleFollowCreated(CreateFollowLoadTask createfollowloadtask, Content content)
    {
        if (val$onComplete != null)
        {
            val$onComplete.run();
        }
    }

    ask()
    {
        this$0 = final_followedentitydatamanager;
        val$onComplete = Runnable.this;
        super();
    }
}
