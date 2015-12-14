// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.controllers;

import com.socialin.android.apiv3.SocialinApiV3;
import com.socialin.android.apiv3.request.RequestParams;
import com.socialin.android.apiv3.request.UploadParams;

// Referenced classes of package com.socialin.android.apiv3.controllers:
//            BaseSocialinApiRequestController, RequestControllerFactory

final class a extends BaseSocialinApiRequestController
{

    private int a;

    public final void doRequest(String s, RequestParams requestparams)
    {
        requestparams = (UploadParams)requestparams;
        params = requestparams;
        if (status != 0)
        {
            status = 0;
            a = SocialinApiV3.getInstance().uploadPhoto(requestparams, s, this);
        }
    }

    public final int getRequestId()
    {
        return a;
    }

    ller()
    {
        a = -1;
    }
}
