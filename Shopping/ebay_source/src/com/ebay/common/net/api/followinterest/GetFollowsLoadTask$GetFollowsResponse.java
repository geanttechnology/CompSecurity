// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.followinterest;

import com.ebay.common.model.followinterest.FollowDescriptor;
import com.ebay.common.model.followinterest.FollowList;
import com.ebay.common.model.followinterest.FollowType;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.common.net.api.followinterest:
//            BaseFollowInterestResponse, GetFollowsLoadTask

public static class SUCCESS_CODES extends BaseFollowInterestResponse
{

    private static final List SUCCESS_CODES = Arrays.asList(new Integer[] {
        Integer.valueOf(200)
    });
    public FollowList follows;

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.sResponse
    {
        follows = new FollowList();
        setResult((FollowList)readJsonStream(inputstream, com/ebay/common/model/followinterest/FollowList));
    }

    public void setResult(FollowList followlist)
    {
        if (followlist.interests != null)
        {
            for (Iterator iterator = followlist.interests.iterator(); iterator.hasNext();)
            {
                FollowDescriptor followdescriptor = (FollowDescriptor)iterator.next();
                followdescriptor.id = followdescriptor.getInterestId();
                followdescriptor.type = FollowType.INTEREST;
            }

        } else
        {
            followlist.interests = Collections.emptyList();
        }
        if (followlist.collections != null)
        {
            for (Iterator iterator1 = followlist.collections.iterator(); iterator1.hasNext();)
            {
                FollowDescriptor followdescriptor1 = (FollowDescriptor)iterator1.next();
                followdescriptor1.id = followdescriptor1.collectionId;
                followdescriptor1.type = FollowType.COLLECTION;
            }

        } else
        {
            followlist.collections = Collections.emptyList();
        }
        if (followlist.users != null)
        {
            for (Iterator iterator2 = followlist.users.iterator(); iterator2.hasNext();)
            {
                FollowDescriptor followdescriptor2 = (FollowDescriptor)iterator2.next();
                followdescriptor2.id = followdescriptor2.username;
                followdescriptor2.type = FollowType.USER;
            }

        } else
        {
            followlist.users = Collections.emptyList();
        }
        follows = followlist;
    }


    public ()
    {
        super(true);
        setSuccessCodes(SUCCESS_CODES);
    }
}
