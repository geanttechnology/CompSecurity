// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.exceptions;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class APIRequestException extends Exception
{

    private HttpResponse response;
    private String responseBody;

    public APIRequestException(HttpResponse httpresponse)
    {
        response = httpresponse;
    }

    public String getReasonPhrase()
    {
        return response.getStatusLine().getReasonPhrase();
    }

    public HttpResponse getResponse()
    {
        return response;
    }

    public String getResponseBody()
    {
        String s;
        try
        {
            if (responseBody == null)
            {
                responseBody = EntityUtils.toString(response.getEntity());
            }
            s = responseBody;
        }
        catch (Exception exception)
        {
            return exception.getMessage();
        }
        return s;
    }

    public int getStatusCode()
    {
        return response.getStatusLine().getStatusCode();
    }

    public JSONObject responseJSON()
    {
        if (responseBody == null)
        {
            getResponseBody();
        }
        JSONObject jsonobject;
        try
        {
            jsonobject = new JSONObject(responseBody);
        }
        catch (Exception exception)
        {
            return null;
        }
        return jsonobject;
    }
}
