// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.http.senna.operations;

import android.util.Log;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.network.exceptions.InvalidParameterException;
import com.amazon.gallery.framework.network.exceptions.TerminalException;
import com.amazon.gallery.framework.network.exceptions.TransientException;
import com.amazon.gallery.framework.network.http.rest.account.Endpoint;
import com.amazon.gallery.framework.network.http.rest.http.AbstractHttpPostMessage;
import com.amazon.gallery.framework.network.http.rest.http.HttpFactory;
import java.net.URI;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DeleteMediaItemsOperation extends AbstractHttpPostMessage
{

    private static final String TAG = com/amazon/gallery/framework/network/http/senna/operations/DeleteMediaItemsOperation.getName();
    private final List mediaItems;

    public DeleteMediaItemsOperation(HttpFactory httpfactory, List list)
        throws InvalidParameterException
    {
        super(httpfactory, com.amazon.gallery.framework.network.http.rest.RestClient.MetricsEvent.DeleteMediaItem);
        mediaItems = list;
    }

    public volatile Object buildResponse(JSONObject jsonobject)
        throws TerminalException, TransientException
    {
        return buildResponse(jsonobject);
    }

    public Void buildResponse(JSONObject jsonobject)
    {
        Log.v(TAG, "Senna Delete Photos Succeeded");
        return null;
    }

    public boolean equals(Object obj)
    {
        if (this != obj) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        obj = (DeleteMediaItemsOperation)obj;
        if (mediaItems != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((DeleteMediaItemsOperation) (obj)).mediaItems == null) goto _L1; else goto _L3
_L3:
        return false;
        if (mediaItems.equals(((DeleteMediaItemsOperation) (obj)).mediaItems)) goto _L1; else goto _L4
_L4:
        return false;
    }

    protected JSONObject getRequestBody()
        throws TerminalException
    {
        JSONObject jsonobject = new JSONObject();
        JSONArray jsonarray = new JSONArray();
        for (Iterator iterator = mediaItems.iterator(); iterator.hasNext(); jsonarray.put(((MediaItem)iterator.next()).getObjectId().toString())) { }
        try
        {
            jsonobject.put("ids", jsonarray);
        }
        catch (JSONException jsonexception)
        {
            throw new TerminalException(jsonexception);
        }
        return jsonobject;
    }

    protected URI getURI(Endpoint endpoint)
    {
        return URI.create((new StringBuilder()).append(endpoint.getHttpPath()).append("photo/CUSTOMER_ID?delete").toString());
    }

    public int hashCode()
    {
        int i;
        if (mediaItems == null)
        {
            i = 0;
        } else
        {
            i = mediaItems.hashCode();
        }
        return i + 31;
    }

    public String toString()
    {
        return (new StringBuilder()).append("DeleteMediaItemsOperation [mediaItems=").append(mediaItems).append("]").toString();
    }

}
