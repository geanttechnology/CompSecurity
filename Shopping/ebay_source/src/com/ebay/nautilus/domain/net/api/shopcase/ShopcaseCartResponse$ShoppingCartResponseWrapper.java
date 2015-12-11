// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shopcase;

import com.ebay.nautilus.domain.net.ResponseWrapper;
import com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart;
import com.ebay.nautilus.domain.net.api.shopcase.models.ShopCartRequestResult;
import com.ebay.nautilus.domain.net.dataobject.BaseApiResponse;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.net.api.shopcase:
//            ShopcaseCartResponse

public static final class  extends BaseApiResponse
    implements ResponseWrapper
{

    private String errorCode;
    private String errorDescription;
    private List extensions;
    private ShopCartRequestResult requestResult;
    private ShopCart shopCart;

    public int getAck()
    {
        if (requestResult != null)
        {
            return requestResult.getAck();
        } else
        {
            return -1;
        }
    }

    public requestResult getResponse()
    {
        return this;
    }

    public volatile BaseApiResponse getResponse()
    {
        return getResponse();
    }




    public ()
    {
    }
}
