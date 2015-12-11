// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.network;

import com.mopub.common.event.EventSerializer;
import com.mopub.volley.DefaultRetryPolicy;
import com.mopub.volley.NetworkResponse;
import com.mopub.volley.Request;
import com.mopub.volley.Response;
import com.mopub.volley.toolbox.HttpHeaderParser;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

public class ScribeRequest extends Request
{
    public static interface Listener
        extends com.mopub.volley.Response.ErrorListener
    {

        public abstract void onResponse();
    }

    public static interface ScribeRequestFactory
        extends RequestManager.RequestFactory
    {

        public abstract ScribeRequest createRequest(Listener listener);
    }


    private final EventSerializer mEventSerializer;
    private final List mEvents;
    private final Listener mListener;

    public ScribeRequest(String s, List list, EventSerializer eventserializer, Listener listener)
    {
        super(1, s, listener);
        mEvents = list;
        mEventSerializer = eventserializer;
        mListener = listener;
        setShouldCache(false);
        setRetryPolicy(new DefaultRetryPolicy());
    }

    protected volatile void deliverResponse(Object obj)
    {
        deliverResponse((Void)obj);
    }

    protected void deliverResponse(Void void1)
    {
        mListener.onResponse();
    }

    public List getEvents()
    {
        return mEvents;
    }

    protected Map getParams()
    {
        JSONArray jsonarray = mEventSerializer.serializeAsJson(mEvents);
        HashMap hashmap = new HashMap();
        hashmap.put("log", jsonarray.toString());
        return hashmap;
    }

    protected Response parseNetworkResponse(NetworkResponse networkresponse)
    {
        return Response.success(null, HttpHeaderParser.parseCacheHeaders(networkresponse));
    }
}
