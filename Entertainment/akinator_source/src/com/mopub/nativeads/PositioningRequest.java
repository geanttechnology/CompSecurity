// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import com.mopub.network.MoPubNetworkError;
import com.mopub.volley.NetworkResponse;
import com.mopub.volley.Response;
import com.mopub.volley.VolleyError;
import com.mopub.volley.toolbox.HttpHeaderParser;
import com.mopub.volley.toolbox.JsonRequest;
import java.io.UnsupportedEncodingException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PositioningRequest extends JsonRequest
{

    private static final String FIXED_KEY = "fixed";
    private static final String INTERVAL_KEY = "interval";
    private static final int MAX_VALUE = 0x10000;
    private static final String POSITION_KEY = "position";
    private static final String REPEATING_KEY = "repeating";
    private static final String SECTION_KEY = "section";

    public PositioningRequest(String s, com.mopub.volley.Response.Listener listener, com.mopub.volley.Response.ErrorListener errorlistener)
    {
        super(0, s, null, listener, errorlistener);
    }

    private void parseFixedJson(JSONArray jsonarray, MoPubNativeAdPositioning.MoPubClientPositioning mopubclientpositioning)
        throws JSONException
    {
        int i = 0;
        while (i < jsonarray.length()) 
        {
            JSONObject jsonobject = jsonarray.getJSONObject(i);
            int j = jsonobject.optInt("section", 0);
            if (j < 0)
            {
                throw new JSONException((new StringBuilder()).append("Invalid section ").append(j).append(" in JSON response").toString());
            }
            if (j <= 0)
            {
                int k = jsonobject.getInt("position");
                if (k < 0 || k > 0x10000)
                {
                    throw new JSONException((new StringBuilder()).append("Invalid position ").append(k).append(" in JSON response").toString());
                }
                mopubclientpositioning.addFixedPosition(k);
            }
            i++;
        }
    }

    private void parseRepeatingJson(JSONObject jsonobject, MoPubNativeAdPositioning.MoPubClientPositioning mopubclientpositioning)
        throws JSONException
    {
        int i = jsonobject.getInt("interval");
        if (i < 2 || i > 0x10000)
        {
            throw new JSONException((new StringBuilder()).append("Invalid interval ").append(i).append(" in JSON response").toString());
        } else
        {
            mopubclientpositioning.enableRepeatingPositions(i);
            return;
        }
    }

    protected void deliverResponse(MoPubNativeAdPositioning.MoPubClientPositioning mopubclientpositioning)
    {
        super.deliverResponse(mopubclientpositioning);
    }

    protected volatile void deliverResponse(Object obj)
    {
        deliverResponse((MoPubNativeAdPositioning.MoPubClientPositioning)obj);
    }

    MoPubNativeAdPositioning.MoPubClientPositioning parseJson(String s)
        throws JSONException, MoPubNetworkError
    {
        JSONObject jsonobject = new JSONObject(s);
        s = jsonobject.optString("error", null);
        if (s != null)
        {
            if (s.equalsIgnoreCase("WARMING_UP"))
            {
                throw new MoPubNetworkError(com.mopub.network.MoPubNetworkError.Reason.WARMING_UP);
            } else
            {
                throw new JSONException(s);
            }
        }
        s = jsonobject.optJSONArray("fixed");
        jsonobject = jsonobject.optJSONObject("repeating");
        if (s == null && jsonobject == null)
        {
            throw new JSONException("Must contain fixed or repeating positions");
        }
        MoPubNativeAdPositioning.MoPubClientPositioning mopubclientpositioning = new MoPubNativeAdPositioning.MoPubClientPositioning();
        if (s != null)
        {
            parseFixedJson(s, mopubclientpositioning);
        }
        if (jsonobject != null)
        {
            parseRepeatingJson(jsonobject, mopubclientpositioning);
        }
        return mopubclientpositioning;
    }

    protected Response parseNetworkResponse(NetworkResponse networkresponse)
    {
        if (networkresponse.statusCode != 200)
        {
            return Response.error(new VolleyError(networkresponse));
        }
        if (networkresponse.data.length == 0)
        {
            return Response.error(new VolleyError("Empty positioning response", new JSONException("Empty response")));
        }
        try
        {
            networkresponse = Response.success(parseJson(new String(networkresponse.data, HttpHeaderParser.parseCharset(networkresponse.headers))), HttpHeaderParser.parseCacheHeaders(networkresponse));
        }
        // Misplaced declaration of an exception variable
        catch (NetworkResponse networkresponse)
        {
            return Response.error(new VolleyError("Couldn't parse JSON from Charset", networkresponse));
        }
        // Misplaced declaration of an exception variable
        catch (NetworkResponse networkresponse)
        {
            return Response.error(new VolleyError("JSON Parsing Error", networkresponse));
        }
        // Misplaced declaration of an exception variable
        catch (NetworkResponse networkresponse)
        {
            return Response.error(networkresponse);
        }
        return networkresponse;
    }
}
