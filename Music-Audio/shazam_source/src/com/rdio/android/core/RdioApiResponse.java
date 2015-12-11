// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core;

import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RdioApiResponse
{

    public static final int NO_STATUS_CODE = -1;
    private final String cacheKey;
    private final String errorMessage;
    private final Map responseHeaders;
    private final Object result;
    private final int statusCode;
    private final boolean success;

    public RdioApiResponse(boolean flag, int i, Object obj, String s, String s1, Map map)
    {
        success = flag;
        errorMessage = s;
        responseHeaders = map;
        result = obj;
        cacheKey = s1;
        statusCode = i;
    }

    public RdioApiResponse(boolean flag, int i, Object obj, String s, Map map)
    {
        success = flag;
        errorMessage = s;
        responseHeaders = map;
        result = obj;
        cacheKey = null;
        statusCode = i;
    }

    public static RdioApiResponse responseFactory(int i, JSONObject jsonobject, String s, Map map)
    {
        Object obj;
        if (!jsonobject.getString("status").equalsIgnoreCase("ok"))
        {
            return new RdioApiResponse(false, i, null, jsonobject.getString("message"), s, map);
        }
        obj = jsonobject.get("result");
        if (!(obj instanceof JSONArray))
        {
            break MISSING_BLOCK_LABEL_76;
        }
        jsonobject = new RdioApiResponse(true, i, (JSONArray)obj, null, s, map);
        return jsonobject;
        try
        {
            if (obj instanceof JSONObject)
            {
                return new RdioApiResponse(true, i, (JSONObject)obj, null, s, map);
            }
            jsonobject = new RdioApiResponse(true, i, jsonobject, null, s, map);
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            jsonobject.printStackTrace();
            return null;
        }
        return jsonobject;
    }

    public static RdioApiResponse responseFactory(int i, JSONObject jsonobject, Map map)
    {
        return responseFactory(i, jsonobject, null, map);
    }

    public String getCacheKey()
    {
        return cacheKey;
    }

    public String getErrorMessage()
    {
        return errorMessage;
    }

    public Map getResponseHeaders()
    {
        return responseHeaders;
    }

    public Object getResult()
    {
        return result;
    }

    public int getStatusCode()
    {
        return statusCode;
    }

    public boolean isSuccess()
    {
        return success;
    }
}
