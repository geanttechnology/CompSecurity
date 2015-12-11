// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.android.pdk;

import com.android.volley.VolleyError;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

// Referenced classes of package com.pinterest.android.pdk:
//            PDKException, PDKResponse

public class PDKCallback
    implements com.android.volley.Response.Listener, com.android.volley.Response.ErrorListener
{

    private HashMap _params;
    private String _path;
    private Map _responseHeaders;
    private int _statusCode;

    public PDKCallback()
    {
    }

    public void onErrorResponse(VolleyError volleyerror)
    {
        onFailure(new PDKException(volleyerror));
    }

    public void onFailure(PDKException pdkexception)
    {
    }

    public volatile void onResponse(Object obj)
    {
        onResponse((JSONObject)obj);
    }

    public void onResponse(JSONObject jsonobject)
    {
        try
        {
            onSuccess(jsonobject);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            return;
        }
    }

    public void onSuccess(PDKResponse pdkresponse)
    {
    }

    public void onSuccess(JSONObject jsonobject)
    {
        jsonobject = new PDKResponse(jsonobject);
        jsonobject.setStatusCode(_statusCode);
        jsonobject.setPath(_path);
        jsonobject.setParams(_params);
        onSuccess(((PDKResponse) (jsonobject)));
    }

    public void setParams(HashMap hashmap)
    {
        _params = hashmap;
    }

    public void setPath(String s)
    {
        _path = s;
    }

    public void setResponseHeaders(Map map)
    {
        _responseHeaders = map;
    }

    public void setStatusCode(int i)
    {
        _statusCode = i;
    }
}
