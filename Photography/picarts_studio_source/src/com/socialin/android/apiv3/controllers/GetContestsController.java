// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.controllers;

import com.socialin.android.apiv3.SocialinApiV3;
import com.socialin.android.apiv3.model.Contest2;
import com.socialin.android.apiv3.model.ContestResponseItem;
import com.socialin.android.apiv3.model.ContestsResponse;
import com.socialin.android.apiv3.model.Response;
import com.socialin.android.apiv3.request.ContestParams;
import com.socialin.android.apiv3.request.RequestParams;
import com.socialin.asyncnet.Request;
import com.socialin.asyncnet.cache.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.socialin.android.apiv3.controllers:
//            BaseSocialinApiRequestController

public class GetContestsController extends BaseSocialinApiRequestController
{

    private static long validPeriod = 60000L;
    private int requestId;

    public GetContestsController()
    {
        requestId = -1;
    }

    public void doRequest(String s, ContestParams contestparams)
    {
        params = contestparams;
        if (status == 0)
        {
            return;
        }
        status = 0;
        if (contestparams.offset != 0)
        {
            cacheConfig = 5;
        }
        requestId = SocialinApiV3.getInstance().getContests(s, this, cacheConfig, contestparams.type, contestparams.offset, contestparams.limit, validPeriod);
    }

    public volatile void doRequest(String s, RequestParams requestparams)
    {
        doRequest(s, (ContestParams)requestparams);
    }

    public int getRequestId()
    {
        return requestId;
    }

    public boolean isUpdateCache(ContestsResponse contestsresponse, Request request)
    {
        return request.g.a == 2 && !request.g.e && "success".equals(contestsresponse.status);
    }

    public void onFailure(Exception exception, Request request)
    {
        if (request.g.a == 2)
        {
            status = -1;
            cacheConfig = 3;
            ((ContestParams)params).offset = 0;
            doRequest();
            cacheConfig = 2;
            return;
        } else
        {
            super.onFailure(exception, request);
            return;
        }
    }

    public void onSuccess(ContestsResponse contestsresponse, Request request)
    {
        if (!contestsresponse.items.isEmpty())
        {
            Iterator iterator = contestsresponse.items.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                ContestResponseItem contestresponseitem = (ContestResponseItem)iterator.next();
                if (contestresponseitem.contestItems != null)
                {
                    Collections.sort(contestresponseitem.contestItems, Collections.reverseOrder(new Comparator() {

                        public final int compare(Object obj, Object obj1)
                        {
                            obj = (Contest2)obj;
                            obj1 = (Contest2)obj1;
                            return ((Contest2) (obj)).endDate.compareTo(((Contest2) (obj1)).endDate);
                        }

                    }));
                }
            } while (true);
            iterator = contestsresponse.items.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                ContestResponseItem contestresponseitem1 = (ContestResponseItem)iterator.next();
                if (contestresponseitem1.contestItems != null)
                {
                    Iterator iterator1 = contestresponseitem1.contestItems.iterator();
                    int i = 0;
                    while (iterator1.hasNext()) 
                    {
                        Contest2 contest2 = (Contest2)iterator1.next();
                        contest2.category = contestresponseitem1.type;
                        contest2.fullName = contestresponseitem1.description;
                        if (contest2.tillEnd > 0)
                        {
                            contest2.type = 0;
                        } else
                        {
                            int j = i + 1;
                            if (i < 2)
                            {
                                contest2.type = 1;
                                i = j;
                            } else
                            {
                                contest2.type = 2;
                                i = j;
                            }
                        }
                    }
                }
            } while (true);
        }
        super.onSuccess(contestsresponse, request);
    }

    public volatile void onSuccess(Response response, Request request)
    {
        onSuccess((ContestsResponse)response, request);
    }

    public volatile void onSuccess(Object obj, Request request)
    {
        onSuccess((ContestsResponse)obj, request);
    }

}
