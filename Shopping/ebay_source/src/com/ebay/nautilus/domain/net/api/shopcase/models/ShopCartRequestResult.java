// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shopcase.models;

import android.text.TextUtils;
import com.ebay.nautilus.domain.net.dataobject.BaseApiResponse;

public class ShopCartRequestResult extends BaseApiResponse
{

    private final String ACK_FAILED_LITERAL = "Failed";
    private final String ACK_PARTIALLY_SUCCEED_LITERAL = "PartiallySucceed";
    private final String ACK_SUCCEED_LITERAL = "Succeed";

    public ShopCartRequestResult()
    {
    }

    public int getAck()
    {
        if (!TextUtils.isEmpty(ack))
        {
            if ("Succeed".equals(ack))
            {
                return 1;
            }
            if (!"Failed".equals(ack) && "PartiallySucceed".equals(ack))
            {
                return -2;
            }
        }
        return -1;
    }
}
