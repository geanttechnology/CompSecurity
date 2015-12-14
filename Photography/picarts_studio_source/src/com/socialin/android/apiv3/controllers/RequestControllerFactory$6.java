// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.controllers;

import com.socialin.android.apiv3.SocialinApiV3;
import com.socialin.android.apiv3.request.GetFollowParams;
import com.socialin.android.apiv3.request.RequestParams;

// Referenced classes of package com.socialin.android.apiv3.controllers:
//            BaseSocialinApiRequestController, RequestControllerFactory

final class oller extends BaseSocialinApiRequestController
{

    public final void doRequest(String s, RequestParams requestparams)
    {
        requestparams = (GetFollowParams)requestparams;
        params = requestparams;
        if (status != 0)
        {
            status = 0;
            SocialinApiV3.getInstance().getViewerFollowers(((GetFollowParams) (requestparams)).userId, ((GetFollowParams) (requestparams)).offset, ((GetFollowParams) (requestparams)).limit, ((GetFollowParams) (requestparams)).searchUser, s, this, 5);
        }
    }

    oller()
    {
    }
}
