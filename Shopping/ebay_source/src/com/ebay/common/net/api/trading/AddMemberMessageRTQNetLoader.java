// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.common.content.EbaySimpleNetLoader;
import com.ebay.nautilus.domain.net.EbayRequest;
import com.ebay.nautilus.domain.net.api.trading.AddMemberMessageRTQRequest;
import com.ebay.nautilus.domain.net.api.trading.EbayTradingApi;
import com.ebay.nautilus.kernel.content.EbayContext;
import java.util.ArrayList;

public class AddMemberMessageRTQNetLoader extends EbaySimpleNetLoader
{

    private final EbayTradingApi api;
    private final String body;
    private final Long itemId;
    private final String parentMessageId;
    private final ArrayList pictureUrls;
    private final String recipient;

    public AddMemberMessageRTQNetLoader(EbayContext ebaycontext, EbayTradingApi ebaytradingapi, String s, Long long1, String s1, String s2)
    {
        this(ebaycontext, ebaytradingapi, s, long1, s1, s2, null);
    }

    public AddMemberMessageRTQNetLoader(EbayContext ebaycontext, EbayTradingApi ebaytradingapi, String s, Long long1, String s1, String s2, ArrayList arraylist)
    {
        super(ebaycontext);
        api = ebaytradingapi;
        parentMessageId = s;
        itemId = long1;
        recipient = s1;
        body = s2;
        pictureUrls = arraylist;
    }

    protected EbayRequest createRequest()
    {
        return new AddMemberMessageRTQRequest(api, parentMessageId, itemId, recipient, body, pictureUrls);
    }
}
