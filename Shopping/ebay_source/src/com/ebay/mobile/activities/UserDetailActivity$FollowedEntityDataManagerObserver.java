// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import com.ebay.common.content.dm.FollowedEntityDataManager;
import com.ebay.common.model.followinterest.FollowDescriptor;
import com.ebay.common.model.followinterest.FollowType;
import com.ebay.common.view.EbayErrorHandler;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.DatedContent;
import com.ebay.nautilus.kernel.content.ResultStatus;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.mobile.activities:
//            UserDetailActivity

private class <init> extends com.ebay.common.content.dm.<init>
{

    final UserDetailActivity this$0;

    public void onFollowDeleted(FollowType followtype, String s, ResultStatus resultstatus)
    {
        if (resultstatus.hasError())
        {
            EbayErrorHandler.handleResultStatus(getParent(), 0, resultstatus);
        } else
        if (followtype == FollowType.USER && userId.equalsIgnoreCase(s))
        {
            isUserBeingFollowed = false;
            hideAndShowFavoriteButton();
            return;
        }
    }

    public void onFollowedUsersLoaded(FollowedEntityDataManager followedentitydatamanager, DatedContent datedcontent)
    {
        followedentitydatamanager = datedcontent.getStatus();
        if (followedentitydatamanager.hasError())
        {
            EbayErrorHandler.handleResultStatus(getParent(), 0, followedentitydatamanager);
        } else
        {
            followedentitydatamanager = (List)datedcontent.getData();
            if (followedentitydatamanager != null)
            {
                followedentitydatamanager = followedentitydatamanager.iterator();
                do
                {
                    if (!followedentitydatamanager.hasNext())
                    {
                        break;
                    }
                    datedcontent = (FollowDescriptor)followedentitydatamanager.next();
                    if (((FollowDescriptor) (datedcontent)).type != FollowType.USER || !userId.equalsIgnoreCase(((FollowDescriptor) (datedcontent)).username))
                    {
                        continue;
                    }
                    isUserBeingFollowed = true;
                    break;
                } while (true);
                hideAndShowFavoriteButton();
                return;
            }
        }
    }

    public void onUserFollowed(Content content)
    {
        ResultStatus resultstatus = content.getStatus();
        if (resultstatus.hasError())
        {
            EbayErrorHandler.handleResultStatus(getParent(), 0, resultstatus);
        } else
        if (userId.equals(content.getData()))
        {
            isUserBeingFollowed = true;
            hideAndShowFavoriteButton();
            return;
        }
    }

    private ()
    {
        this$0 = UserDetailActivity.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
