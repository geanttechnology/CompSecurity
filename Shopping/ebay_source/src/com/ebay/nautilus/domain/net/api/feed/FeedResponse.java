// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.feed;

import com.ebay.nautilus.domain.data.Feed;
import com.ebay.nautilus.domain.net.EbayCosResponse;
import java.io.InputStream;

public class FeedResponse extends EbayCosResponse
{

    public Feed feed;

    protected FeedResponse()
    {
        super(true);
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        feed = (Feed)readJsonStream(inputstream, com/ebay/nautilus/domain/data/Feed);
    }
}
