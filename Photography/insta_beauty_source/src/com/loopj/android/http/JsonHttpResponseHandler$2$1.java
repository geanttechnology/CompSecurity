// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.loopj.android.http:
//            JsonHttpResponseHandler

class val.jsonResponse
    implements Runnable
{

    final val.jsonResponse this$1;
    final Object val$jsonResponse;

    public void run()
    {
        if (val$jsonResponse instanceof JSONObject)
        {
            onFailure(statusCode, headers, throwable, (JSONObject)val$jsonResponse);
            return;
        }
        if (val$jsonResponse instanceof JSONArray)
        {
            onFailure(statusCode, headers, throwable, (JSONArray)val$jsonResponse);
            return;
        }
        if (val$jsonResponse instanceof String)
        {
            onFailure(statusCode, headers, (String)val$jsonResponse, throwable);
            return;
        } else
        {
            onFailure(statusCode, headers, new JSONException((new StringBuilder()).append("Unexpected response type ").append(val$jsonResponse.getClass().getName()).toString()), (JSONObject)null);
            return;
        }
    }

    ()
    {
        this$1 = final_;
        val$jsonResponse = Object.this;
        super();
    }
}
