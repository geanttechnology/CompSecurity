// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.controllers;

import com.socialin.android.apiv3.SocialinApiV3;
import com.socialin.android.apiv3.request.ReportParams;
import com.socialin.android.apiv3.request.RequestParams;

// Referenced classes of package com.socialin.android.apiv3.controllers:
//            BaseSocialinApiRequestController, RequestControllerFactory

final class oller extends BaseSocialinApiRequestController
{

    public final void doRequest(String s, RequestParams requestparams)
    {
        requestparams = (ReportParams)requestparams;
        params = requestparams;
        if (status != 0)
        {
            status = 0;
            SocialinApiV3.getInstance().reportPhoto(((ReportParams) (requestparams)).itemId, ((ReportParams) (requestparams)).type, ((ReportParams) (requestparams)).materialUrl, ((ReportParams) (requestparams)).description, ((ReportParams) (requestparams)).firstName, ((ReportParams) (requestparams)).lastName, ((ReportParams) (requestparams)).address, ((ReportParams) (requestparams)).phone, ((ReportParams) (requestparams)).email, ((ReportParams) (requestparams)).isOwner, ((ReportParams) (requestparams)).isAccurate, ((ReportParams) (requestparams)).signature, ((ReportParams) (requestparams)).isDesignItem, s, this);
        }
    }

    oller()
    {
    }
}
