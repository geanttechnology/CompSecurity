// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.controllers;

import com.socialin.android.apiv3.SocialinApiV3;
import com.socialin.android.apiv3.request.ContestParams;
import com.socialin.android.apiv3.request.RequestParams;

// Referenced classes of package com.socialin.android.apiv3.controllers:
//            BaseSocialinApiRequestController

public class GetContestItemsController extends BaseSocialinApiRequestController
{

    private static long validPeriod = 60000L;
    private int requestId;

    public GetContestItemsController()
    {
        requestId = -1;
        params = new ContestParams();
    }

    public void doRequest(String s, ContestParams contestparams)
    {
        params = contestparams;
        if (status == 0)
        {
            return;
        } else
        {
            status = 0;
            requestId = SocialinApiV3.getInstance().getContestItems(s, this, cacheConfig, contestparams.contestName, contestparams.order, contestparams.offset, contestparams.limit, validPeriod);
            return;
        }
    }

    public volatile void doRequest(String s, RequestParams requestparams)
    {
        doRequest(s, (ContestParams)requestparams);
    }

    public int getRequestId()
    {
        return requestId;
    }

}
