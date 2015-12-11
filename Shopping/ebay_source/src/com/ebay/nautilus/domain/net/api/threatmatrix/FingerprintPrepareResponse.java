// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.threatmatrix;

import com.ebay.nautilus.domain.net.EbayCosResponse;
import com.ebay.nautilus.domain.net.dataobject.BaseApiResponse;
import java.io.InputStream;

public class FingerprintPrepareResponse extends EbayCosResponse
{
    private static class ApiResponse extends BaseApiResponse
    {

        private ApiResponse()
        {
        }
    }


    protected FingerprintPrepareResponse()
    {
        super(true);
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        readJsonStream(inputstream, com/ebay/nautilus/domain/net/api/threatmatrix/FingerprintPrepareResponse$ApiResponse);
    }
}
