// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.collections;

import com.ebay.nautilus.domain.data.CollectionDetail;
import com.ebay.nautilus.domain.net.EbayCosResponse;
import java.io.InputStream;

public class CollectionDetailsResponse extends EbayCosResponse
{

    public CollectionDetail collectionDetail;

    protected CollectionDetailsResponse()
    {
        super(true);
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        collectionDetail = (CollectionDetail)readJsonStream(inputstream, com/ebay/nautilus/domain/data/CollectionDetail);
    }
}
