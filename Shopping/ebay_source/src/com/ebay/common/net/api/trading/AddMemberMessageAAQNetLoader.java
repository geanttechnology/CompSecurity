// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.common.content.EbaySimpleNetLoader;
import com.ebay.nautilus.domain.net.EbayRequest;
import com.ebay.nautilus.domain.net.api.trading.AddMemberMessageAAQRequest;
import com.ebay.nautilus.domain.net.api.trading.EbayTradingApi;
import com.ebay.nautilus.kernel.content.EbayContext;
import java.util.ArrayList;

public class AddMemberMessageAAQNetLoader extends EbaySimpleNetLoader
{

    private final EbayTradingApi api;
    private final String body;
    private final Long itemId;
    private final String parentMessageId;
    private final ArrayList pictureUrls;
    private final com.ebay.nautilus.domain.net.api.trading.AddMemberMessageAAQRequest.QuestionType questionType;
    private final String recipient;
    private final String subject;
    private final boolean toPartner;

    public AddMemberMessageAAQNetLoader(EbayContext ebaycontext, EbayTradingApi ebaytradingapi, com.ebay.nautilus.domain.net.api.trading.AddMemberMessageAAQRequest.QuestionType questiontype, boolean flag, Long long1, String s, String s1, 
            String s2, String s3)
    {
        this(ebaycontext, ebaytradingapi, questiontype, flag, long1, s, s1, s2, null, s3);
    }

    public AddMemberMessageAAQNetLoader(EbayContext ebaycontext, EbayTradingApi ebaytradingapi, com.ebay.nautilus.domain.net.api.trading.AddMemberMessageAAQRequest.QuestionType questiontype, boolean flag, Long long1, String s, String s1, 
            String s2, ArrayList arraylist, String s3)
    {
        super(ebaycontext);
        api = ebaytradingapi;
        questionType = questiontype;
        toPartner = flag;
        itemId = long1;
        recipient = s;
        subject = s1;
        body = s2;
        pictureUrls = arraylist;
        parentMessageId = s3;
    }

    protected EbayRequest createRequest()
    {
        return new AddMemberMessageAAQRequest(api, questionType, toPartner, itemId, recipient, subject, body, pictureUrls, parentMessageId);
    }

    public String getBody()
    {
        return body;
    }

    public ArrayList getPictureUrls()
    {
        return pictureUrls;
    }
}
