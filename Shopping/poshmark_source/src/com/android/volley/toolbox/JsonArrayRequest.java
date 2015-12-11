// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.android.volley.toolbox;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.io.UnsupportedEncodingException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.android.volley.toolbox:
//            JsonRequest, HttpHeaderParser

public class JsonArrayRequest extends JsonRequest
{

    public JsonArrayRequest(int i, String s, com.android.volley.Response.Listener listener, com.android.volley.Response.ErrorListener errorlistener)
    {
        super(i, s, null, listener, errorlistener);
    }

    public JsonArrayRequest(int i, String s, String s1, com.android.volley.Response.Listener listener, com.android.volley.Response.ErrorListener errorlistener)
    {
        super(i, s, s1, listener, errorlistener);
    }

    public JsonArrayRequest(int i, String s, JSONArray jsonarray, com.android.volley.Response.Listener listener, com.android.volley.Response.ErrorListener errorlistener)
    {
        if (jsonarray == null)
        {
            jsonarray = null;
        } else
        if (!(jsonarray instanceof JSONArray))
        {
            jsonarray = jsonarray.toString();
        } else
        {
            jsonarray = JSONArrayInstrumentation.toString((JSONArray)jsonarray);
        }
        super(i, s, jsonarray, listener, errorlistener);
    }

    public JsonArrayRequest(int i, String s, JSONObject jsonobject, com.android.volley.Response.Listener listener, com.android.volley.Response.ErrorListener errorlistener)
    {
        if (jsonobject == null)
        {
            jsonobject = null;
        } else
        if (!(jsonobject instanceof JSONObject))
        {
            jsonobject = jsonobject.toString();
        } else
        {
            jsonobject = JSONObjectInstrumentation.toString((JSONObject)jsonobject);
        }
        super(i, s, jsonobject, listener, errorlistener);
    }

    public JsonArrayRequest(String s, com.android.volley.Response.Listener listener, com.android.volley.Response.ErrorListener errorlistener)
    {
        super(0, s, null, listener, errorlistener);
    }

    public JsonArrayRequest(String s, JSONArray jsonarray, com.android.volley.Response.Listener listener, com.android.volley.Response.ErrorListener errorlistener)
    {
        int i;
        if (jsonarray == null)
        {
            i = 0;
        } else
        {
            i = 1;
        }
        this(i, s, jsonarray, listener, errorlistener);
    }

    public JsonArrayRequest(String s, JSONObject jsonobject, com.android.volley.Response.Listener listener, com.android.volley.Response.ErrorListener errorlistener)
    {
        int i;
        if (jsonobject == null)
        {
            i = 0;
        } else
        {
            i = 1;
        }
        this(i, s, jsonobject, listener, errorlistener);
    }

    protected Response parseNetworkResponse(NetworkResponse networkresponse)
    {
        try
        {
            networkresponse = Response.success(JSONArrayInstrumentation.init(new String(networkresponse.data, HttpHeaderParser.parseCharset(networkresponse.headers, "utf-8"))), HttpHeaderParser.parseCacheHeaders(networkresponse));
        }
        // Misplaced declaration of an exception variable
        catch (NetworkResponse networkresponse)
        {
            return Response.error(new ParseError(networkresponse));
        }
        // Misplaced declaration of an exception variable
        catch (NetworkResponse networkresponse)
        {
            return Response.error(new ParseError(networkresponse));
        }
        return networkresponse;
    }
}
