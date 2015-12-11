// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.util.Log;
import com.flurry.android.responses.AppCloudCommonOperationResponseHandler;
import com.flurry.android.responses.AppCloudError;

// Referenced classes of package com.flurry.android:
//            AppCloudResponseHandler, AppCloudResponse, AppCloudUser, et

final class dl
    implements AppCloudResponseHandler
{

    private AppCloudCommonOperationResponseHandler dK;
    private AppCloudUser fj;

    dl(AppCloudUser appclouduser, AppCloudCommonOperationResponseHandler appcloudcommonoperationresponsehandler)
    {
        fj = appclouduser;
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
                Log.d("Trestle", "Deleted user");
                if (AppCloudUser.getCurrentUser() != null && fj.mId != null && AppCloudUser.getCurrentUser().getId().equals(fj.mId))
                {
                    AppCloudUser.V();
                    et.z("");
                }
                dK.onOperationSucceed();
                return;
            } else
            {
                Log.d("Trestle", (new StringBuilder()).append("Deleted Fail: ").append(appcloudresponse.getResponseMessage().toString()).toString());
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
