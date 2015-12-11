// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.followinterest;

import java.io.InputStream;
import java.util.List;

// Referenced classes of package com.ebay.common.net.api.followinterest:
//            BaseFollowInterestResponse, GetFollowersLoadTask

public static class FollowerResponseDTO.this._cls0 extends BaseFollowInterestResponse
{
    public class FollowerResponseDTO
    {

        final GetFollowersLoadTask.GetFollowersResponse this$0;
        public Integer total;
        public List users;

        public FollowerResponseDTO()
        {
            this$0 = GetFollowersLoadTask.GetFollowersResponse.this;
            super();
        }
    }


    FollowerResponseDTO.total followerSummary;

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.sResponse
    {
        followerSummary = new >();
        inputstream = (FollowerResponseDTO)readJsonStream(inputstream, com/ebay/common/net/api/followinterest/GetFollowersLoadTask$GetFollowersResponse$FollowerResponseDTO);
        followerSummary = new >();
        followerSummary.werCount = ((FollowerResponseDTO) (inputstream)).total;
    }

    public FollowerResponseDTO.this._cls0()
    {
        super(true);
    }
}
