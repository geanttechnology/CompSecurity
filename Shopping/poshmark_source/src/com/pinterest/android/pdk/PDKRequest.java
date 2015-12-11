// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.android.pdk;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

// Referenced classes of package com.pinterest.android.pdk:
//            PDKCallback

public class PDKRequest extends JsonObjectRequest
{

    private PDKCallback _callback;
    private Map _headers;

    public PDKRequest(int i, String s, JSONObject jsonobject, com.android.volley.Response.Listener listener, com.android.volley.Response.ErrorListener errorlistener)
    {
        super(i, s, jsonobject, listener, errorlistener);
        _headers = null;
    }

    public PDKRequest(int i, String s, JSONObject jsonobject, PDKCallback pdkcallback, Map map)
    {
        super(i, s, jsonobject, pdkcallback, pdkcallback);
        _headers = null;
        _callback = pdkcallback;
        _headers = map;
    }

    public Map getHeaders()
        throws AuthFailureError
    {
        if (_headers == null || _headers.equals(Collections.emptyMap()))
        {
            _headers = new HashMap();
        }
        return _headers;
    }

    protected Response parseNetworkResponse(NetworkResponse networkresponse)
    {
        _callback.setResponseHeaders(networkresponse.headers);
        _callback.setStatusCode(networkresponse.statusCode);
        return super.parseNetworkResponse(networkresponse);
    }
}
