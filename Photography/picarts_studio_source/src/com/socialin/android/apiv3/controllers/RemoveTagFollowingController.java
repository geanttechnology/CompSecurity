// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.controllers;

import android.app.Application;
import android.content.Intent;
import com.socialin.android.apiv3.SocialinApiV3;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.model.Response;
import com.socialin.android.apiv3.model.StatusObj;
import com.socialin.android.apiv3.model.User;
import com.socialin.android.apiv3.request.ParamWithTagName;
import com.socialin.android.apiv3.request.RequestParams;
import com.socialin.asyncnet.Request;

// Referenced classes of package com.socialin.android.apiv3.controllers:
//            BaseSocialinApiRequestController

public class RemoveTagFollowingController extends BaseSocialinApiRequestController
{

    int requestId;

    public RemoveTagFollowingController()
    {
        requestId = -1;
        params = new ParamWithTagName();
    }

    public void doRequest(String s, ParamWithTagName paramwithtagname)
    {
        params = paramwithtagname;
        if (status == 0)
        {
            return;
        } else
        {
            status = 0;
            requestId = SocialinApiV3.getInstance().removeTagFollowing(paramwithtagname.userId, paramwithtagname.tagName, s, this);
            return;
        }
    }

    public volatile void doRequest(String s, RequestParams requestparams)
    {
        doRequest(s, (ParamWithTagName)requestparams);
    }

    public int getRequestId()
    {
        return requestId;
    }

    public volatile void onSuccess(Response response, Request request)
    {
        onSuccess((StatusObj)response, request);
    }

    public void onSuccess(StatusObj statusobj, Request request)
    {
        if (statusobj != null && statusobj.status.equals("success") && SocialinV3.getInstance().isRegistered())
        {
            User user = SocialinV3.getInstance().getUser();
            user.tagsCount = user.tagsCount - 1;
            SocialinV3.getInstance().getContext().sendBroadcast(new Intent("com.picsart.studio.update.user.action"));
        }
        super.onSuccess(statusobj, request);
    }

    public volatile void onSuccess(Object obj, Request request)
    {
        onSuccess((StatusObj)obj, request);
    }
}
