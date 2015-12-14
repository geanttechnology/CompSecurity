// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.controllers;

import android.app.Application;
import android.content.Intent;
import com.socialin.android.apiv3.SocialinApiV3;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.model.Response;
import com.socialin.android.apiv3.model.Stream;
import com.socialin.android.apiv3.model.User;
import com.socialin.android.apiv3.request.RequestParams;
import com.socialin.android.apiv3.request.StreamParams;
import com.socialin.asyncnet.Request;

// Referenced classes of package com.socialin.android.apiv3.controllers:
//            BaseSocialinApiRequestController

public class AddStreamController extends BaseSocialinApiRequestController
{

    int requestId;

    public AddStreamController()
    {
        requestId = -1;
    }

    public volatile void doRequest(String s, RequestParams requestparams)
    {
        doRequest(s, (StreamParams)requestparams);
    }

    public void doRequest(String s, StreamParams streamparams)
    {
        params = streamparams;
        if (status == 0)
        {
            return;
        } else
        {
            status = 0;
            requestId = SocialinApiV3.getInstance().addStream(streamparams.title, streamparams.desc, s, this);
            return;
        }
    }

    public int getRequestId()
    {
        return requestId;
    }

    public volatile void onSuccess(Response response, Request request)
    {
        onSuccess((Stream)response, request);
    }

    public void onSuccess(Stream stream, Request request)
    {
        if (stream != null && SocialinV3.getInstance().isRegistered())
        {
            User user = SocialinV3.getInstance().getUser();
            user.streamsCount = user.streamsCount + 1;
            SocialinV3.getInstance().getContext().sendBroadcast(new Intent("com.picsart.studio.update.user.action"));
        }
        super.onSuccess(stream, request);
    }

    public volatile void onSuccess(Object obj, Request request)
    {
        onSuccess((Stream)obj, request);
    }
}
