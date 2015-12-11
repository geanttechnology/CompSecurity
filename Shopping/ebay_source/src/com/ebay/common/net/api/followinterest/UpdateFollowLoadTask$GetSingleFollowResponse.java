// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.followinterest;

import com.ebay.common.model.followinterest.FollowDescriptor;
import java.io.InputStream;

// Referenced classes of package com.ebay.common.net.api.followinterest:
//            BaseFollowInterestResponse, UpdateFollowLoadTask

private static class Y extends BaseFollowInterestResponse
{

    FollowDescriptor follow;

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.wResponse
    {
        follow = new FollowDescriptor();
        follow = (FollowDescriptor)readJsonStream(inputstream, com/ebay/common/model/followinterest/FollowDescriptor);
    }

    public Y()
    {
        super(true);
    }
}
