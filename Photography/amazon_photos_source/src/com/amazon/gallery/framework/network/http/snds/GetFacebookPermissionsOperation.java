// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.http.snds;

import android.util.Log;
import com.amazon.gallery.framework.network.exceptions.InvalidParameterException;
import com.amazon.gallery.framework.network.exceptions.TerminalException;
import com.amazon.gallery.framework.network.exceptions.TransientException;
import com.amazon.gallery.framework.network.http.rest.account.Endpoint;
import com.amazon.gallery.framework.network.http.rest.http.AbstractHttpPostMessage;
import com.amazon.gallery.framework.network.http.rest.http.HttpFactory;
import java.net.URI;
import java.util.LinkedList;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.ByteArrayEntity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GetFacebookPermissionsOperation extends AbstractHttpPostMessage
{

    private static final String TAG = com/amazon/gallery/framework/network/http/snds/GetFacebookPermissionsOperation.getName();

    public GetFacebookPermissionsOperation(HttpFactory httpfactory)
        throws InvalidParameterException
    {
        super(httpfactory, com.amazon.gallery.framework.network.http.rest.RestClient.MetricsEvent.GetFacebookPermissionsOperation);
        endpoint = new Endpoint("https://identity-snds.amazon.com:443/snds/", true);
    }

    private JSONObject buildSNDSRequestBody()
    {
        JSONObject jsonobject = new JSONObject();
        Object obj;
        jsonobject.put("__type", "com.amazon.identity.socialnetworkdataimportservice#FBGraphGetRequest");
        jsonobject.put("path", "/me/permissions");
        obj = new LinkedList();
        ((LinkedList) (obj)).add("permissions");
        jsonobject.put("fields", new JSONArray(((java.util.Collection) (obj))));
        obj = new JSONObject();
        JSONObject jsonobject1 = new JSONObject();
        jsonobject1.put("__type", "com.amazon.identity.socialnetwork.common#FacebookFederationContext");
        JSONObject jsonobject2 = new JSONObject();
        jsonobject1.put("appScope", jsonobject2);
        jsonobject2.put("domain", "amazon.com");
        jsonobject2.put("app", "Amazon");
        ((JSONObject) (obj)).put("context", jsonobject1);
        ((JSONObject) (obj)).put("snRequest", jsonobject);
        return ((JSONObject) (obj));
        JSONException jsonexception;
        jsonexception;
_L2:
        Log.e(TAG, (new StringBuilder()).append("JSONException while constructing parameters for createGetPermissionsRequest: ").append(jsonexception.getMessage()).toString());
        return null;
        jsonexception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public volatile Object buildResponse(JSONObject jsonobject)
        throws TerminalException, TransientException
    {
        return buildResponse(jsonobject);
    }

    public JSONObject buildResponse(JSONObject jsonobject)
        throws TerminalException, TransientException
    {
        return jsonobject;
    }

    public Endpoint getEndpoint()
    {
        return endpoint;
    }

    protected JSONObject getRequestBody()
        throws TerminalException
    {
        Object obj = buildSNDSRequestBody();
        try
        {
            obj = new ByteArrayEntity(((JSONObject) (obj)).toString().getBytes());
            ((HttpEntityEnclosingRequestBase)request).setEntity(((org.apache.http.HttpEntity) (obj)));
            request.addHeader("Content-Type", "application/json; charset=UTF-8");
            request.addHeader("connection", "keep-alive");
            request.addHeader("x-requested-with", "XMLHttpRequest");
            request.addHeader("x-amz-target", (new StringBuilder()).append("com.amazon.identity.socialnetworkdataimportserviceexternal.SocialNetworkDataImportServiceExternal.").append("getSocialNetworkData").toString());
            request.addHeader("accept", "application/json, text/javascript, */*");
            request.addHeader("content-encoding", "amz-1.0");
        }
        catch (Exception exception)
        {
            Log.e(TAG, (new StringBuilder()).append("JSONException while constructing parameters for createGetPermissionsRequest: ").append(exception.getMessage()).toString());
        }
        return null;
    }

    protected URI getURI(Endpoint endpoint)
    {
        return URI.create("https://identity-snds.amazon.com:443/snds/");
    }

    public void setEndpoint(Endpoint endpoint)
    {
    }

}
