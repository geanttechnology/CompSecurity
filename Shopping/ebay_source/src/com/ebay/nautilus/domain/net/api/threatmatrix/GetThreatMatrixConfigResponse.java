// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.threatmatrix;

import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.kernel.util.StreamUtil;
import java.io.InputStream;

public class GetThreatMatrixConfigResponse extends EbayResponse
{

    public byte response[];

    public GetThreatMatrixConfigResponse()
    {
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        response = StreamUtil.streamToBytesForParse(inputstream);
    }
}
