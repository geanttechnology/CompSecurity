// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.controllers;

import com.socialin.android.apiv3.SocialinApiV3;
import com.socialin.android.apiv3.request.RequestParams;

// Referenced classes of package com.socialin.android.apiv3.controllers:
//            BaseSocialinApiRequestController

public class ResetPasswordController extends BaseSocialinApiRequestController
{

    private int requestId;

    public ResetPasswordController()
    {
        requestId = -1;
    }

    public void doRequest(String s, ResetPasswordParams resetpasswordparams)
    {
        if (status == 0)
        {
            return;
        } else
        {
            status = 0;
            requestId = SocialinApiV3.getInstance().resetPassword(resetpasswordparams.email, resetpasswordparams.username, this);
            return;
        }
    }

    public volatile void doRequest(String s, RequestParams requestparams)
    {
        doRequest(s, (ResetPasswordParams)requestparams);
    }

    public int getRequestId()
    {
        return requestId;
    }

    private class ResetPasswordParams extends RequestParams
    {

        public String email;
        public String username;

        public ResetPasswordParams()
        {
        }
    }

}
