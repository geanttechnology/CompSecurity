// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import java.util.HashMap;
import java.util.Vector;
import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.flurry.android:
//            AppCloudResponseHandler, AppCloudResponse, fy, AppCloudUser, 
//            cx, FlurryAppCloud, fk, AppCloudObject

final class fh
    implements AppCloudResponseHandler
{

    private fy gO;

    fh(fy fy1)
    {
        gO = fy1;
        super();
    }

    public final void handleResponse(AppCloudResponse appcloudresponse)
        throws Exception
    {
        if (appcloudresponse != null && appcloudresponse.isSuccessful())
        {
            Object obj = appcloudresponse.getResponse().getJSONArray("set").getJSONObject(0);
            if (gO.io)
            {
                obj = new AppCloudUser(((JSONObject) (obj)));
                for (int i = 0; i < ((AppCloudUser) (obj)).getKeyValues().size(); i++)
                {
                    String s = ((NameValuePair)((AppCloudUser) (obj)).getKeyValues().get(i)).getName();
                    String s2 = ((NameValuePair)((AppCloudUser) (obj)).getKeyValues().get(i)).getValue();
                    gO.ig.paramMap.put(s, s2);
                    FlurryAppCloud.E().e(s, s2, gO.ig.mId);
                }

            } else
            {
                obj = new AppCloudObject(((JSONObject) (obj)));
                appcloudresponse.setObject(((AppCloudObject) (obj)));
                ((AppCloudObject) (obj)).saveToCache();
                for (int j = 0; j < ((AppCloudObject) (obj)).getKeyValues().size(); j++)
                {
                    String s1 = ((NameValuePair)((AppCloudObject) (obj)).getKeyValues().get(j)).getName();
                    String s3 = ((NameValuePair)((AppCloudObject) (obj)).getKeyValues().get(j)).getValue();
                    gO.ig.paramMap.put(s1, s3);
                }

            }
        }
        if (gO.in != null)
        {
            gO.in.handleResponse(appcloudresponse);
        }
    }
}
