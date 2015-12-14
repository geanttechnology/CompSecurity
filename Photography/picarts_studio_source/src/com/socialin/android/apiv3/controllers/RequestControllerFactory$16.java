// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.controllers;

import com.socialin.android.apiv3.SocialinApiV3;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.model.User;
import com.socialin.android.apiv3.request.ParamWithPageLimit;
import com.socialin.android.apiv3.request.RequestParams;

// Referenced classes of package com.socialin.android.apiv3.controllers:
//            BaseSocialinApiRequestController, RequestControllerFactory

final class ller extends BaseSocialinApiRequestController
{

    public final void doRequest(String s, RequestParams requestparams)
    {
        boolean flag = false;
        requestparams = (ParamWithPageLimit)requestparams;
        if (status != 0)
        {
            status = 0;
            if (SocialinV3.getInstance().getUser().id == ((ParamWithPageLimit) (requestparams)).userId)
            {
                flag = true;
            }
            SocialinApiV3.getInstance().getPhotosLocGrouped(((ParamWithPageLimit) (requestparams)).userId, flag, ((ParamWithPageLimit) (requestparams)).offset, ((ParamWithPageLimit) (requestparams)).limit, ((ParamWithPageLimit) (requestparams)).contentRating, s, this);
        }
    }

    ller()
    {
    }
}
