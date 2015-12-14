// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.controllers;

import android.content.Context;
import android.content.Intent;
import com.socialin.android.apiv3.SocialinApiV3;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.model.Response;
import com.socialin.android.apiv3.model.Settings;
import com.socialin.android.apiv3.model.User;
import com.socialin.android.apiv3.request.RequestParams;
import com.socialin.android.apiv3.request.SigninParams;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.util.Utils;
import com.socialin.android.util.b;
import com.socialin.asyncnet.Request;

// Referenced classes of package com.socialin.android.apiv3.controllers:
//            BaseSocialinApiRequestController

public class SigninController extends BaseSocialinApiRequestController
{

    private int requestId;

    public SigninController()
    {
        requestId = -1;
    }

    public volatile void doRequest(String s, RequestParams requestparams)
    {
        doRequest(s, (SigninParams)requestparams);
    }

    public void doRequest(String s, SigninParams signinparams)
    {
        params = signinparams;
        if (status == 0)
        {
            return;
        } else
        {
            status = 0;
            requestId = SocialinApiV3.getInstance().signin(signinparams.provider, signinparams.usernameOrToken, signinparams.passwordOrFbJson, this, s);
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
        if (user != null && "success".equals(user.status))
        {
            SocialinV3.getInstance().setUser(user, true);
            SocialinV3.checkGcm();
            android.app.Application application = SocialinV3.getInstance().getContext();
            application.sendBroadcast(new Intent("com.picsart.studio.update.user.action"));
            application.sendBroadcast(new Intent("picsart.clipart.sync.action"));
            AnalyticUtils.getInstance(application).track(new com.socialin.android.apiv3.events.EventsFactory.UserAttributeEvent(application));
            if (SocialinV3.getInstance().getSettings().isAppboyEnabled())
            {
                b b1 = b.a(application);
                User user1 = SocialinV3.getInstance().getUser();
                if (user1 != null)
                {
                    b1.a(user1.id);
                    b1.a(user1.email);
                    Utils.l(application);
                }
                b1.a("# of Photos on Picsart", user.photosCount);
                b1.a("# of Friends Followed", user.followingsCount);
                b1.a("# of Friends Following User", user.followersCount);
            }
        }
        super.onSuccess(user, request);
    }

    public volatile void onSuccess(Object obj, Request request)
    {
        onSuccess((User)obj, request);
    }
}
