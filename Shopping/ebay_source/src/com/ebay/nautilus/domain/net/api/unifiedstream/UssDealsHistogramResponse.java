// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.unifiedstream;

import com.ebay.nautilus.domain.data.UnifiedStream.SearchRefinement;
import com.ebay.nautilus.domain.net.EbayCosResponse;
import java.io.InputStream;
import java.util.List;

public class UssDealsHistogramResponse extends EbayCosResponse
{
    public static final class Container
    {

        public boolean keywordSearchAvailable;
        public List listings;
        public String next;
        public String prev;
        public SearchRefinement searchRefinement;
        public int total;

        public Container()
        {
        }
    }


    public Container container;

    protected UssDealsHistogramResponse()
    {
        super(true);
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        container = (Container)readJsonStream(inputstream, com/ebay/nautilus/domain/net/api/unifiedstream/UssDealsHistogramResponse$Container);
    }
}
