// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.http.senna.operations.upload;

import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.media.CommonMediaProperty;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.MediaItemUtil;
import com.amazon.gallery.framework.model.media.MediaType;
import com.amazon.gallery.framework.model.media.Video;
import com.amazon.gallery.framework.network.exceptions.InvalidParameterException;
import com.amazon.gallery.framework.network.exceptions.TerminalException;
import com.amazon.gallery.framework.network.exceptions.TransientException;
import com.amazon.gallery.framework.network.http.rest.account.Endpoint;
import com.amazon.gallery.framework.network.http.rest.http.AbstractHttpPostMessage;
import com.amazon.gallery.framework.network.http.rest.http.HttpFactory;
import java.io.File;
import java.net.URI;
import org.json.JSONException;
import org.json.JSONObject;

public class GetUploadLocationOperation extends AbstractHttpPostMessage
{

    private static final String TAG = com/amazon/gallery/framework/network/http/senna/operations/upload/GetUploadLocationOperation.getName();
    private final long fileDuration;
    private final long fileLength;
    private final String fileType;
    private final boolean isSideloaded;
    private final String objectId;

    public GetUploadLocationOperation(HttpFactory httpfactory, ObjectID objectid, MediaItem mediaitem)
        throws InvalidParameterException
    {
        super(httpfactory, com.amazon.gallery.framework.network.http.rest.RestClient.MetricsEvent.GetMediaItemUploadLocation);
        fileLength = (new File(mediaitem.getLocalPath())).length();
        objectId = objectid.toString();
        boolean flag;
        if (!mediaitem.hasProperty(CommonMediaProperty.CAMERA) && !MediaItemUtil.isFreeTime(mediaitem))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isSideloaded = flag;
        fileType = mediaitem.getType().toString();
        if (mediaitem instanceof Video)
        {
            fileDuration = ((Video)mediaitem).getDuration();
            return;
        } else
        {
            fileDuration = 0L;
            return;
        }
    }

    public volatile Object buildResponse(JSONObject jsonobject)
        throws TerminalException, TransientException
    {
        return buildResponse(jsonobject);
    }

    public JSONObject buildResponse(JSONObject jsonobject)
        throws TerminalException, TransientException
    {
        JSONObject jsonobject1 = new JSONObject();
        try
        {
            jsonobject1.put("storageKey", jsonobject.get("storageKey"));
            jsonobject1.put("params", jsonobject.get("params"));
            jsonobject1.put("host", jsonobject.get("host"));
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            GLogger.e(com/amazon/gallery/framework/network/http/senna/operations/upload/GetUploadLocationOperation.getName(), "Error parsing GetUploadLocationOperation json response", new Object[0]);
            return jsonobject1;
        }
        return jsonobject1;
    }

    protected JSONObject getRequestBody()
        throws TerminalException
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("size", fileLength);
            jsonobject.put("sideLoaded", isSideloaded);
            jsonobject.put("mediaType", fileType);
            if (fileType.equals(MediaType.VIDEO.name()))
            {
                jsonobject.put("durationInMs", fileDuration);
            }
        }
        catch (Exception exception)
        {
            GLogger.e(TAG, "Error creating GetUploadLocationOperation json body", new Object[0]);
            return jsonobject;
        }
        return jsonobject;
    }

    protected URI getURI(Endpoint endpoint)
    {
        return URI.create((new StringBuilder()).append(endpoint.getHttpPath()).append("media/uploadLocation/CUSTOMER_ID/").append(objectId).toString());
    }

}
