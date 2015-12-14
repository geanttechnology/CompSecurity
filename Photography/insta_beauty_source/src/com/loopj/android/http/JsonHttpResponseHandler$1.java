// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import org.apache.http.Header;
import org.json.JSONException;

// Referenced classes of package com.loopj.android.http:
//            JsonHttpResponseHandler

class val.headers
    implements Runnable
{

    final JsonHttpResponseHandler this$0;
    final Header val$headers[];
    final byte val$responseBytes[];
    final int val$statusCode;

    public void run()
    {
        class _cls2
            implements Runnable
        {

            final JsonHttpResponseHandler._cls1 this$1;
            final JSONException val$ex;

            public void run()
            {
                onFailure(statusCode, headers, ex, (JSONObject)null);
            }

            _cls2()
            {
                this$1 = JsonHttpResponseHandler._cls1.this;
                ex = jsonexception;
                super();
            }
        }

        try
        {
            final Object jsonResponse = parseResponse(val$responseBytes);
            class _cls1
                implements Runnable
            {

                final JsonHttpResponseHandler._cls1 this$1;
                final Object val$jsonResponse;

                public void run()
                {
                    if (jsonResponse instanceof JSONObject)
                    {
                        onSuccess(statusCode, headers, (JSONObject)jsonResponse);
                        return;
                    }
                    if (jsonResponse instanceof JSONArray)
                    {
                        onSuccess(statusCode, headers, (JSONArray)jsonResponse);
                        return;
                    }
                    if (jsonResponse instanceof String)
                    {
                        onFailure(statusCode, headers, (String)jsonResponse, new JSONException("Response cannot be parsed as JSON data"));
                        return;
                    } else
                    {
                        onFailure(statusCode, headers, new JSONException((new StringBuilder()).append("Unexpected response type ").append(jsonResponse.getClass().getName()).toString()), (JSONObject)null);
                        return;
                    }
                }

            _cls1()
            {
                this$1 = JsonHttpResponseHandler._cls1.this;
                jsonResponse = obj;
                super();
            }
            }

            postRunnable(new _cls1());
            return;
        }
        catch (final JSONException ex)
        {
            postRunnable(new _cls2());
        }
    }

    _cls2()
    {
        this$0 = final_jsonhttpresponsehandler;
        val$responseBytes = abyte0;
        val$statusCode = i;
        val$headers = _5B_Lorg.apache.http.Header_3B_.this;
        super();
    }
}
