// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.controllers;

import android.app.Application;
import android.content.Intent;
import com.socialin.android.apiv3.SocialinApiV3;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.model.AvatarResponse;
import com.socialin.android.apiv3.model.Response;
import com.socialin.android.apiv3.model.User;
import com.socialin.android.apiv3.request.ParamWithImage;
import com.socialin.android.apiv3.request.RequestParams;
import com.socialin.asyncnet.Request;

// Referenced classes of package com.socialin.android.apiv3.controllers:
//            BaseSocialinApiRequestController

public class UpdateUserCoverController extends BaseSocialinApiRequestController
{

    int requestId;

    public UpdateUserCoverController()
    {
        requestId = -1;
    }

    public void doRequest(String s, ParamWithImage paramwithimage)
    {
        params = paramwithimage;
        if (status == 0)
        {
            return;
        } else
        {
            status = 0;
            requestId = SocialinApiV3.getInstance().updateUserCover(paramwithimage.imagePath, s, this);
            return;
        }
    }

    public volatile void doRequest(String s, RequestParams requestparams)
    {
        doRequest(s, (ParamWithImage)requestparams);
    }

    public int getRequestId()
    {
        return requestId;
    }

    public void onSuccess(AvatarResponse avatarresponse, Request request)
    {
        if (avatarresponse != null)
        {
            SocialinV3.getInstance().getUser().cover = avatarresponse.url;
            SocialinV3.getInstance().writeUser();
            SocialinV3.getInstance().getContext().sendBroadcast(new Intent("com.picsart.studio.update.user.action"));
        }
        super.onSuccess(avatarresponse, request);
    }

    public volatile void onSuccess(Response response, Request request)
    {
        onSuccess((AvatarResponse)response, request);
    }

    public volatile void onSuccess(Object obj, Request request)
    {
        onSuccess((AvatarResponse)obj, request);
    }
}
