// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.followinterest;

import com.ebay.nautilus.domain.net.EbayCosResponse;
import java.util.Arrays;
import java.util.List;

public abstract class BaseFollowInterestResponse extends EbayCosResponse
{

    private static final List DEFAULT_SUCCESS_CODES = Arrays.asList(new Integer[] {
        Integer.valueOf(200), Integer.valueOf(201), Integer.valueOf(204)
    });
    private List successCodes;

    public BaseFollowInterestResponse(boolean flag)
    {
        super(flag);
        successCodes = DEFAULT_SUCCESS_CODES;
    }

    protected List getSuccessCodes()
    {
        return successCodes;
    }

    public boolean hasSuccessResponseCode()
    {
        return getSuccessCodes().contains(Integer.valueOf(responseCode));
    }

    public void setSuccessCodes(List list)
    {
        if (list == null)
        {
            successCodes = DEFAULT_SUCCESS_CODES;
            return;
        } else
        {
            successCodes = list;
            return;
        }
    }

}
