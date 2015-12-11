// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.util.Log;
import com.flurry.android.responses.AppCloudError;
import com.flurry.android.responses.AppCloudLoginResponseHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.flurry.android:
//            AppCloudResponseHandler, AppCloudResponse, AppCloudUser, et

final class dg
    implements AppCloudResponseHandler
{

    private AppCloudLoginResponseHandler fe;
    private String fh;

    dg(String s, AppCloudLoginResponseHandler appcloudloginresponsehandler)
    {
        fh = s;
        fe = appcloudloginresponsehandler;
        super();
    }

    public final void handleResponse(AppCloudResponse appcloudresponse)
        throws Exception
    {
        if (appcloudresponse == null)
        {
            break MISSING_BLOCK_LABEL_201;
        }
        if (appcloudresponse.isSuccessful())
        {
            Object obj = appcloudresponse.bY.getJSONArray("set").getJSONObject(0);
            AppCloudUser appclouduser = new AppCloudUser(((JSONObject) (obj)));
            appcloudresponse.bX = appclouduser;
            Log.d("Trestle", (new StringBuilder()).append("Login user").append(appcloudresponse.toString()).toString());
            AppCloudUser.setCurrentUser(appclouduser);
            String s = ((JSONObject) (obj)).getString("_id");
            String s1 = ((JSONObject) (obj)).getString("username");
            obj = ((JSONObject) (obj)).getString("email");
            appcloudresponse = appcloudresponse.bY.getString("APPCLOUD_USER_SESSION");
            et.z(s);
            et.d(s1, ((String) (obj)), appcloudresponse);
            et.A(fh);
            fe.onOperationSucceed(appclouduser);
            return;
        }
        try
        {
            fe.onError(new AppCloudError(appcloudresponse.getHTTPResponseCode(), appcloudresponse.getResponseMessage()));
            Log.d("Trestle", (new StringBuilder()).append("Login Fail: ").append(appcloudresponse.getResponseMessage().toString()).toString());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (AppCloudResponse appcloudresponse)
        {
            appcloudresponse.printStackTrace();
        }
        return;
        fe.onError(new AppCloudError(400, "Bad response"));
        return;
    }
}
