// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.arellomobile.android.push.request;

import android.content.Context;
import com.arellomobile.android.push.utils.GeneralUtils;
import com.arellomobile.android.push.utils.PreferenceUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class PushRequest
{

    String response;

    public PushRequest()
    {
        response = "";
    }

    protected void buildParams(Context context, Map map)
        throws JSONException
    {
    }

    public abstract String getMethod();

    public final Map getParams(Context context)
        throws JSONException
    {
        HashMap hashmap = new HashMap();
        hashmap.put("application", PreferenceUtils.getApplicationId(context));
        hashmap.put("hwid", GeneralUtils.getDeviceUUID(context));
        hashmap.put("v", "1.0");
        buildParams(context, hashmap);
        return hashmap;
    }

    public String getRawResponse()
    {
        return response;
    }

    public void parseResponse(JSONObject jsonobject)
        throws JSONException
    {
        if (jsonobject == null)
        {
            return;
        } else
        {
            response = jsonobject.toString();
            return;
        }
    }
}
