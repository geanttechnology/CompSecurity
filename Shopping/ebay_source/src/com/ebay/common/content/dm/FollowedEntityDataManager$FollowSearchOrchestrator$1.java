// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.content.dm;

import com.ebay.nautilus.domain.content.Content;
import java.util.concurrent.CountDownLatch;

// Referenced classes of package com.ebay.common.content.dm:
//            FollowedEntityDataManager

class val.syncState extends val.syncState
{

    final val.syncState this$1;
    final val.syncState val$syncState;

    public void onSearchFollowed(Content content)
    {
        ((val.syncState)FollowedEntityDataManager.access$3600(_fld0))._mth0(content);
        val$syncState.syncState = content;
        val$syncState.syncState.countDown();
    }

    ()
    {
        this$1 = final_;
        val$syncState = val.syncState.this;
        super();
    }
}
