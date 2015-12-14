// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.http.senna.operations;

import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.network.exceptions.InvalidParameterException;
import com.amazon.gallery.framework.network.exceptions.TerminalException;
import com.amazon.gallery.framework.network.exceptions.TransientException;
import com.amazon.gallery.framework.network.http.rest.account.Endpoint;
import com.amazon.gallery.framework.network.http.rest.http.AbstractHttpPostMessage;
import com.amazon.gallery.framework.network.http.rest.http.HttpFactory;
import java.net.URI;
import org.json.JSONException;
import org.json.JSONObject;

public class GetMediaItemOperation extends AbstractHttpPostMessage
{

    private boolean includeOriginal;
    private final ObjectID mediaItemId;

    public GetMediaItemOperation(HttpFactory httpfactory, ObjectID objectid, boolean flag)
        throws InvalidParameterException
    {
        super(httpfactory, com.amazon.gallery.framework.network.http.rest.RestClient.MetricsEvent.GetMediaItem);
        mediaItemId = objectid;
        includeOriginal = flag;
    }

    public volatile Object buildResponse(JSONObject jsonobject)
        throws TerminalException, TransientException
    {
        return buildResponse(jsonobject);
    }

    public JSONObject buildResponse(JSONObject jsonobject)
        throws TerminalException
    {
        try
        {
            jsonobject = jsonobject.getJSONObject("photoInfo");
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            throw new TerminalException(jsonobject);
        }
        return jsonobject;
    }

    public boolean equals(Object obj)
    {
        return super.equals(obj);
    }

    protected JSONObject getRequestBody()
        throws TerminalException
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("id", mediaItemId.toString());
            jsonobject.put("includeOriginal", includeOriginal);
        }
        catch (JSONException jsonexception)
        {
            GLogger.e("GetAlbumsOperation", "Failed to encode request body for getMediaItem", new Object[0]);
            return null;
        }
        return jsonobject;
    }

    protected URI getURI(Endpoint endpoint)
    {
        return URI.create((new StringBuilder()).append(endpoint.getHttpPath()).append("photo/CUSTOMER_ID/").append(mediaItemId.toString()).toString());
    }

    public int hashCode()
    {
        return super.hashCode();
    }
}
