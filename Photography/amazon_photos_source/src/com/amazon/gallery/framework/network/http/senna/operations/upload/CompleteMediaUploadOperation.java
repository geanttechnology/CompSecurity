// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.http.senna.operations.upload;

import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.media.UploadChunk;
import com.amazon.gallery.framework.network.exceptions.InvalidParameterException;
import com.amazon.gallery.framework.network.exceptions.TerminalException;
import com.amazon.gallery.framework.network.exceptions.TransientException;
import com.amazon.gallery.framework.network.http.rest.account.Endpoint;
import com.amazon.gallery.framework.network.http.rest.http.AbstractHttpPostMessage;
import com.amazon.gallery.framework.network.http.rest.http.HttpFactory;
import com.amazon.gallery.framework.network.upload.DeviceAttributeStore;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CompleteMediaUploadOperation extends AbstractHttpPostMessage
{

    private static final String TAG = com/amazon/gallery/framework/network/http/senna/operations/upload/CompleteMediaUploadOperation.getName();
    private final DeviceAttributeStore deviceAttributeStore;
    private final ObjectID mediaItemId;
    private final String storageKey;
    private final String uploadId;
    private final List uploadParts;
    private final String urlArguments;

    public CompleteMediaUploadOperation(HttpFactory httpfactory, ObjectID objectid, String s, DeviceAttributeStore deviceattributestore)
        throws InvalidParameterException
    {
        this(httpfactory, objectid, s, deviceattributestore, null, null);
    }

    public CompleteMediaUploadOperation(HttpFactory httpfactory, ObjectID objectid, String s, DeviceAttributeStore deviceattributestore, String s1, List list)
        throws InvalidParameterException
    {
        super(httpfactory, com.amazon.gallery.framework.network.http.rest.RestClient.MetricsEvent.CompleteMediaItemUpload);
        mediaItemId = objectid;
        storageKey = s;
        deviceAttributeStore = deviceattributestore;
        uploadId = s1;
        uploadParts = list;
        try
        {
            urlArguments = (new StringBuilder()).append(objectid).append("/?storageKey=").append(URLEncoder.encode(s, "UTF-8")).toString();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (HttpFactory httpfactory)
        {
            throw new InvalidParameterException("URLEncoder.encode(newName, charsetName) failed", httpfactory);
        }
    }

    private JSONArray buildETagList()
        throws JSONException
    {
        JSONArray jsonarray = new JSONArray();
        JSONObject jsonobject;
        for (Iterator iterator = uploadParts.iterator(); iterator.hasNext(); jsonarray.put(jsonobject))
        {
            UploadChunk uploadchunk = (UploadChunk)iterator.next();
            jsonobject = new JSONObject();
            jsonobject.put("partNumber", uploadchunk.getChunkNumber());
            jsonobject.put("partETag", uploadchunk.getETag());
            GLogger.d(TAG, (new StringBuilder()).append("completeUploadTag ").append(uploadchunk.getChunkNumber()).append(" ").append(uploadchunk.getETag()).toString(), new Object[0]);
        }

        return jsonarray;
    }

    private JSONObject deviceId()
        throws JSONException
    {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("deviceType", deviceAttributeStore.getDeviceTypeId());
        jsonobject.put("deviceSerialNumber", deviceAttributeStore.getDeviceSerialNumber());
        return jsonobject;
    }

    public volatile Object buildResponse(JSONObject jsonobject)
        throws TerminalException, TransientException
    {
        return buildResponse(jsonobject);
    }

    public JSONObject buildResponse(JSONObject jsonobject)
        throws TerminalException
    {
        return jsonobject;
    }

    protected JSONObject getRequestBody()
        throws TerminalException
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("storageKey", storageKey);
            jsonobject.put("noPostProcess", true);
            jsonobject.put("deviceId", deviceId());
            if (uploadId != null)
            {
                jsonobject.put("uploadId", uploadId);
                jsonobject.put("eTags", buildETagList());
            }
            GLogger.v(TAG, (new StringBuilder()).append("Completing Media Item with the following metadata:").append(jsonobject.toString(2)).toString(), new Object[0]);
        }
        catch (JSONException jsonexception)
        {
            GLogger.w(TAG, "Exception while building request body", new Object[] {
                jsonexception
            });
            throw new TerminalException(jsonexception);
        }
        return jsonobject;
    }

    protected URI getURI(Endpoint endpoint)
    {
        if (uploadId == null)
        {
            return URI.create((new StringBuilder()).append(endpoint.getHttpPath()).append("media/completeUpload/CUSTOMER_ID/").append(urlArguments).toString());
        } else
        {
            return URI.create((new StringBuilder()).append(endpoint.getHttpPath()).append("media/completeUpload/CUSTOMER_ID/").append(mediaItemId).toString());
        }
    }

    public String toString()
    {
        return (new StringBuilder()).append("CompleteMediaUploadOperation [id= ").append(mediaItemId.toString()).append(" , storageKey = ").append(storageKey).append(", uploadId= ").append(uploadId).append("]").toString();
    }

}
