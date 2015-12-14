// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.http.senna.operations;

import com.amazon.gallery.framework.data.senna.SennaMediaType;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.network.exceptions.InvalidParameterException;
import com.amazon.gallery.framework.network.exceptions.TerminalException;
import com.amazon.gallery.framework.network.exceptions.TransientException;
import com.amazon.gallery.framework.network.http.rest.account.Endpoint;
import com.amazon.gallery.framework.network.http.rest.http.AbstractHttpPostMessage;
import com.amazon.gallery.framework.network.http.rest.http.HttpFactory;
import java.net.URI;
import java.util.Collection;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ShareOperation extends AbstractHttpPostMessage
{

    private final Collection mediaItems;
    private final Collection tags;

    public ShareOperation(HttpFactory httpfactory, Collection collection, Collection collection1)
        throws InvalidParameterException
    {
        super(httpfactory, com.amazon.gallery.framework.network.http.rest.RestClient.MetricsEvent.Share);
        mediaItems = collection;
        tags = collection1;
        allowGZIP = false;
    }

    private JSONArray constructDestinations()
        throws JSONException
    {
        JSONArray jsonarray = new JSONArray();
        jsonarray.put("noop:facebook");
        return jsonarray;
    }

    private JSONArray constructResources()
        throws JSONException
    {
        JSONArray jsonarray = new JSONArray();
        if (mediaItems != null)
        {
            JSONObject jsonobject;
            for (Iterator iterator = mediaItems.iterator(); iterator.hasNext(); jsonarray.put(jsonobject))
            {
                MediaItem mediaitem = (MediaItem)iterator.next();
                jsonobject = new JSONObject();
                jsonobject.put("id", mediaitem.getObjectId().toString());
                jsonobject.put("type", SennaMediaType.valueOf(mediaitem.getType()));
            }

        }
        if (tags != null)
        {
            JSONObject jsonobject1;
            for (Iterator iterator1 = tags.iterator(); iterator1.hasNext(); jsonarray.put(jsonobject1))
            {
                Tag tag = (Tag)iterator1.next();
                jsonobject1 = new JSONObject();
                jsonobject1.put("id", tag.getObjectId().toString());
                jsonobject1.put("type", "ALBUM");
            }

        }
        return jsonarray;
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

    protected JSONObject getRequestBody()
        throws TerminalException
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("resources", constructResources());
            jsonobject.put("destinations", constructDestinations());
            jsonobject.put("shareMessage", "Awesome Share");
        }
        catch (JSONException jsonexception)
        {
            throw new TerminalException(jsonexception);
        }
        return jsonobject;
    }

    protected URI getURI(Endpoint endpoint)
    {
        return URI.create((new StringBuilder()).append(endpoint.getHttpPath()).append("v1/share").toString());
    }
}
