// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.content.dm;

import com.ebay.nautilus.domain.content.Content;

// Referenced classes of package com.ebay.common.content.dm:
//            FollowedEntityDataManager

class mpleObserver extends mpleObserver
{

    final FollowedEntityDataManager this$0;
    final server val$onCompleteObserver;

    public void onSearchFollowed(Content content)
    {
        ((server)FollowedEntityDataManager.access$900(FollowedEntityDataManager.this)).onSearchFollowed(content);
        if (val$onCompleteObserver != null)
        {
            val$onCompleteObserver.onSearchFollowed(content);
        }
    }

    server()
    {
        this$0 = final_followedentitydatamanager;
        val$onCompleteObserver = server.this;
        super();
    }
}
