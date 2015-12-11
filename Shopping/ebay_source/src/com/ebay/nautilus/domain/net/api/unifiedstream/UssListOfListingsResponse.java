// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.unifiedstream;

import com.ebay.nautilus.domain.net.EbayCosResponse;
import java.io.InputStream;
import java.util.List;

public class UssListOfListingsResponse extends EbayCosResponse
{
    public static final class ListOfListingsContent
    {

        public List listings;

        public ListOfListingsContent()
        {
        }
    }


    public ListOfListingsContent streamContents;

    protected UssListOfListingsResponse()
    {
        super(true);
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        streamContents = (ListOfListingsContent)readJsonStream(inputstream, com/ebay/nautilus/domain/net/api/unifiedstream/UssListOfListingsResponse$ListOfListingsContent);
    }
}
