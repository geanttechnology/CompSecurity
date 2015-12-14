// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.controllers;

import com.socialin.android.apiv3.SocialinApiV3;
import com.socialin.android.apiv3.model.Response;
import com.socialin.android.apiv3.model.User;
import com.socialin.android.apiv3.request.RequestParams;
import com.socialin.asyncnet.Request;

// Referenced classes of package com.socialin.android.apiv3.controllers:
//            BaseSocialinApiRequestController

public class GetOwnerController extends BaseSocialinApiRequestController
{

    int requestId;
    private boolean useCache;

    public GetOwnerController()
    {
        useCache = true;
        requestId = -1;
    }

    public GetOwnerController(boolean flag)
    {
        useCache = true;
        requestId = -1;
        useCache = flag;
    }

    public void doRequest(String s, RequestParams requestparams)
    {
        if (status == 0)
        {
            return;
        } else
        {
            status = 0;
            requestId = SocialinApiV3.getInstance().getOwnerUser(s, this, useCache);
            return;
        }
    }

    public int getRequestId()
    {
        return requestId;
    }

    public volatile void onSuccess(Response response, Request request)
    {
        onSuccess((User)response, request);
    }

    public void onSuccess(User user, Request request)
    {
        super.onSuccess(user, request);
    }

    public volatile void onSuccess(Object obj, Request request)
    {
        onSuccess((User)obj, request);
    }
}
