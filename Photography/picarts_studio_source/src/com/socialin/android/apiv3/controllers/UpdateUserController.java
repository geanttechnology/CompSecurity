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
import com.socialin.android.apiv3.request.RequestParams;
import com.socialin.android.apiv3.request.UpdateUserParams;
import com.socialin.asyncnet.Request;

// Referenced classes of package com.socialin.android.apiv3.controllers:
//            BaseSocialinApiRequestController

public class UpdateUserController extends BaseSocialinApiRequestController
{

    int requestId;

    public UpdateUserController()
    {
        requestId = -1;
    }

    public volatile void doRequest(String s, RequestParams requestparams)
    {
        doRequest(s, (UpdateUserParams)requestparams);
    }

    public void doRequest(String s, UpdateUserParams updateuserparams)
    {
        params = updateuserparams;
        if (status == 0)
        {
            return;
        } else
        {
            status = 0;
            requestId = SocialinApiV3.getInstance().update(updateuserparams.email, updateuserparams.name, updateuserparams.username, updateuserparams.password, updateuserparams.passwordConfirm, updateuserparams.photo, updateuserparams.mature, updateuserparams.address, updateuserparams.notificationParams, updateuserparams.cover, updateuserparams.profileStatus, this, s);
            return;
        }
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
        super.onSuccess(statusobj, request);
        if (statusobj != null && statusobj.status.equals("success"))
        {
            SocialinV3.getInstance().getContext().sendBroadcast(new Intent("com.picsart.studio.update.user.action"));
        }
    }

    public volatile void onSuccess(Object obj, Request request)
    {
        onSuccess((StatusObj)obj, request);
    }
}
