// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import com.flurry.android.responses.AppCloudCommonOperationResponseHandler;
import com.flurry.android.responses.AppCloudError;

// Referenced classes of package com.flurry.android:
//            AppCloudResponseHandler, AppCloudResponse, cx

final class fv
    implements AppCloudResponseHandler
{

    private AppCloudCommonOperationResponseHandler dK;
    private cx ig;

    fv(cx cx1, AppCloudCommonOperationResponseHandler appcloudcommonoperationresponsehandler)
    {
        ig = cx1;
        dK = appcloudcommonoperationresponsehandler;
        super();
    }

    public final void handleResponse(AppCloudResponse appcloudresponse)
        throws Exception
    {
        if (appcloudresponse != null)
        {
            if (appcloudresponse.isSuccessful())
            {
                ig.getObjectOrUser(null);
                dK.onOperationSucceed();
                return;
            } else
            {
                dK.onError(new AppCloudError(appcloudresponse.getHTTPResponseCode(), appcloudresponse.getResponseMessage()));
                return;
            }
        } else
        {
            dK.onError(new AppCloudError(400, "Bad response"));
            return;
        }
    }
}
