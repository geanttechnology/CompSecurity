// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.sitespeed;

import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.kernel.net.IResponseDataHandler;
import java.io.InputStream;

public class SiteSpeedResponse extends EbayResponse
{

    public SiteSpeedResponse()
    {
    }

    public IResponseDataHandler getDataHandler()
    {
        return null;
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
    }
}
