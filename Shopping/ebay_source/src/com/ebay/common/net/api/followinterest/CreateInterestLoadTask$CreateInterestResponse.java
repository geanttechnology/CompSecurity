// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.followinterest;

import java.io.InputStream;

// Referenced classes of package com.ebay.common.net.api.followinterest:
//            BaseFollowInterestResponse, CreateInterestLoadTask, InterestDescriptor

public static class interestDescriptor extends BaseFollowInterestResponse
{

    public InterestDescriptor interestDescriptor;

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.tResponse
    {
        interestDescriptor = (InterestDescriptor)readJsonStream(inputstream, com/ebay/common/net/api/followinterest/InterestDescriptor);
    }

    public ()
    {
        super(true);
        interestDescriptor = new InterestDescriptor();
    }
}
