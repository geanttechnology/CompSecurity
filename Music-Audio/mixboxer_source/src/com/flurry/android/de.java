// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.util.Log;
import com.flurry.android.responses.AppCloudCommonOperationResponseHandler;
import com.flurry.android.responses.AppCloudError;

// Referenced classes of package com.flurry.android:
//            AppCloudResponseHandler, AppCloudResponse, AppCloudUser, FlurryAppCloudRequestManager, 
//            et

final class de
    implements AppCloudResponseHandler
{

    private AppCloudCommonOperationResponseHandler dK;

    de(AppCloudCommonOperationResponseHandler appcloudcommonoperationresponsehandler)
    {
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
                Log.d("Trestle", "Logout succeeded");
                AppCloudUser.setCurrentUser(null);
                FlurryAppCloudRequestManager.UserSession = "";
                et.be();
                dK.onOperationSucceed();
                return;
            } else
            {
                dK.onError(new AppCloudError(appcloudresponse.getHTTPResponseCode(), appcloudresponse.getResponseMessage()));
                Log.d("Trestle", (new StringBuilder()).append("Logout Failed: ").append(appcloudresponse.getResponseMessage().toString()).toString());
                return;
            }
        } else
        {
            dK.onError(new AppCloudError(400, "Bad response"));
            return;
        }
    }
}
