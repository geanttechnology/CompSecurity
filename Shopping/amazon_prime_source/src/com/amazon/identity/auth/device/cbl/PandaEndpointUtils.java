// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.cbl;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public final class PandaEndpointUtils
{
    public static class PandaErrorResponse
    {

        public final String mErrorCode;
        public final String mErrorMessage;

        PandaErrorResponse(String s, String s1)
        {
            if (TextUtils.isEmpty(s))
            {
                s = "Unrecognized";
            }
            mErrorCode = s;
            if (TextUtils.isEmpty(s1))
            {
                s1 = "Unrecognized";
            }
            mErrorMessage = s1;
        }
    }


    public static PandaErrorResponse parseErrorAndLogMetrics(JSONObject jsonobject)
    {
        String s = null;
        Object obj = null;
        JSONObject jsonobject1 = obj;
        String s1;
        try
        {
            s1 = jsonobject.getString("error");
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            return new PandaErrorResponse(s, jsonobject1);
        }
        s = s1;
        jsonobject1 = obj;
        jsonobject = jsonobject.getString("error_description");
        s = s1;
        jsonobject1 = jsonobject;
        jsonobject = new PandaErrorResponse(s1, jsonobject);
        return jsonobject;
    }
}
