// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.arellomobile.android.push.request;

import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.arellomobile.android.push.request:
//            PushRequest

public class GetBeaconsRequest extends PushRequest
{

    private JSONObject mResponse;

    public GetBeaconsRequest()
    {
    }

    public String getMethod()
    {
        return "getApplicationBeacons";
    }

    public JSONObject getResponse()
    {
        return mResponse;
    }

    public void parseResponse(JSONObject jsonobject)
        throws JSONException
    {
        mResponse = jsonobject.getJSONObject("response");
    }
}
