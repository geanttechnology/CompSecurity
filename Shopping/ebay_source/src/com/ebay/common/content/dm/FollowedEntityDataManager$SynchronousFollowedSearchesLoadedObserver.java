// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.content.dm;

import com.ebay.nautilus.domain.content.DatedContent;
import java.util.concurrent.CountDownLatch;

// Referenced classes of package com.ebay.common.content.dm:
//            FollowedEntityDataManager

private static class <init> extends <init>
{

    public DatedContent collectionResultContent;
    public FollowedEntityDataManager dm;
    public DatedContent interestResultContent;
    public CountDownLatch sync;
    public DatedContent userResultContent;

    public void onFollowedCollectionsLoaded(FollowedEntityDataManager followedentitydatamanager, DatedContent datedcontent)
    {
        boolean flag;
        if (collectionResultContent == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        collectionResultContent = datedcontent;
        if (flag)
        {
            sync.countDown();
        }
    }

    public void onFollowedSearchesLoaded(FollowedEntityDataManager followedentitydatamanager, DatedContent datedcontent)
    {
        boolean flag;
        if (interestResultContent == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        interestResultContent = datedcontent;
        if (flag)
        {
            sync.countDown();
        }
    }

    public void onFollowedUsersLoaded(FollowedEntityDataManager followedentitydatamanager, DatedContent datedcontent)
    {
        boolean flag;
        if (userResultContent == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        userResultContent = datedcontent;
        if (flag)
        {
            sync.countDown();
        }
    }

    private ()
    {
        sync = new CountDownLatch(3);
    }

    sync(sync sync1)
    {
        this();
    }
}
