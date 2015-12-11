// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.util.Log;
import com.flurry.android.responses.AppCloudError;
import com.flurry.android.responses.AppCloudGetUserByIDResponseHandler;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.flurry.android:
//            AppCloudResponseHandler, AppCloudResponse, AppCloudUser

final class dj
    implements AppCloudResponseHandler
{

    private AppCloudGetUserByIDResponseHandler fk;

    dj(AppCloudGetUserByIDResponseHandler appcloudgetuserbyidresponsehandler)
    {
        fk = appcloudgetuserbyidresponsehandler;
        super();
    }

    public final void handleResponse(AppCloudResponse appcloudresponse)
        throws Exception
    {
        if (appcloudresponse != null && fk != null)
        {
            if (appcloudresponse.isSuccessful())
            {
                appcloudresponse = new AppCloudUser(appcloudresponse.getResponse().getJSONArray("set").getJSONObject(0));
                fk.onOperationSucceed(appcloudresponse);
                return;
            } else
            {
                fk.onError(new AppCloudError(appcloudresponse.getHTTPResponseCode(), appcloudresponse.getResponseMessage()));
                return;
            }
        } else
        {
            fk.onError(new AppCloudError(400, "Bad response"));
            Log.e("AppCloudUser", "getUserById: response = null");
            return;
        }
    }
}
