// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.common.content.EbaySimpleNetLoader;
import com.ebay.nautilus.domain.net.EbayRequest;
import com.ebay.nautilus.domain.net.api.trading.EbayTradingApi;
import com.ebay.nautilus.kernel.content.EbayContext;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetFeedbackRequest

public class GetFeedbackNetLoader extends EbaySimpleNetLoader
{

    private final EbayTradingApi api;
    private final GetFeedbackRequest.CommentType commentType;
    private final GetFeedbackRequest.FeedbackType feedbackType;
    private final int page;
    private final String userId;

    public GetFeedbackNetLoader(EbayContext ebaycontext, EbayTradingApi ebaytradingapi, String s, int i)
    {
        this(ebaycontext, ebaytradingapi, s, i, null, null);
    }

    public GetFeedbackNetLoader(EbayContext ebaycontext, EbayTradingApi ebaytradingapi, String s, int i, GetFeedbackRequest.CommentType commenttype, GetFeedbackRequest.FeedbackType feedbacktype)
    {
        super(ebaycontext);
        api = ebaytradingapi;
        userId = s;
        page = i;
        commentType = commenttype;
        feedbackType = feedbacktype;
    }

    protected EbayRequest createRequest()
    {
        return new GetFeedbackRequest(api, userId, page, commentType, feedbackType);
    }
}
