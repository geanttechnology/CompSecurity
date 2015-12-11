// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.util.Log;
import com.flurry.android.responses.AppCloudError;
import com.flurry.android.responses.AppCloudGetObjectByIDResponseHandler;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.flurry.android:
//            AppCloudResponseHandler, AppCloudResponse, AppCloudObject

final class bn
    implements AppCloudResponseHandler
{

    private AppCloudGetObjectByIDResponseHandler dH;

    bn(AppCloudGetObjectByIDResponseHandler appcloudgetobjectbyidresponsehandler)
    {
        dH = appcloudgetobjectbyidresponsehandler;
        super();
    }

    public final void handleResponse(AppCloudResponse appcloudresponse)
        throws Exception
    {
        if (appcloudresponse != null && dH != null)
        {
            if (appcloudresponse.isSuccessful())
            {
                appcloudresponse = new AppCloudObject(appcloudresponse.getResponse().getJSONArray("set").getJSONObject(0));
                dH.onOperationSucceed(appcloudresponse);
                return;
            } else
            {
                dH.onError(new AppCloudError(appcloudresponse.getHTTPResponseCode(), appcloudresponse.getResponseMessage()));
                return;
            }
        } else
        {
            dH.onError(new AppCloudError(400, "Bad response"));
            Log.e("AppCloudObject", "getObjectById: response = null");
            return;
        }
    }
}
