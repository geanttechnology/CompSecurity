// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.followinterest;

import com.ebay.nautilus.kernel.net.IResponseDataHandler;
import java.io.InputStream;

// Referenced classes of package com.ebay.common.net.api.followinterest:
//            BaseFollowInterestResponse

public class EmptyResponse extends BaseFollowInterestResponse
{

    public EmptyResponse()
    {
        super(false);
    }

    public IResponseDataHandler getDataHandler()
    {
        return null;
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        throw new UnsupportedOperationException("EmptyResponse does not expect any response body");
    }
}
