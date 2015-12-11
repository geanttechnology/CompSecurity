// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.volley.toolbox;

import com.mopub.volley.NetworkResponse;
import com.mopub.volley.Request;
import com.mopub.volley.Response;
import java.io.UnsupportedEncodingException;

// Referenced classes of package com.mopub.volley.toolbox:
//            HttpHeaderParser

public class StringRequest extends Request
{

    private final com.mopub.volley.Response.Listener mListener;

    public StringRequest(int i, String s, com.mopub.volley.Response.Listener listener, com.mopub.volley.Response.ErrorListener errorlistener)
    {
        super(i, s, errorlistener);
        mListener = listener;
    }

    public StringRequest(String s, com.mopub.volley.Response.Listener listener, com.mopub.volley.Response.ErrorListener errorlistener)
    {
        this(0, s, listener, errorlistener);
    }

    protected volatile void deliverResponse(Object obj)
    {
        deliverResponse((String)obj);
    }

    protected void deliverResponse(String s)
    {
        mListener.onResponse(s);
    }

    protected Response parseNetworkResponse(NetworkResponse networkresponse)
    {
        String s;
        try
        {
            s = new String(networkresponse.data, HttpHeaderParser.parseCharset(networkresponse.headers));
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            unsupportedencodingexception = new String(networkresponse.data);
        }
        return Response.success(s, HttpHeaderParser.parseCacheHeaders(networkresponse));
    }
}
