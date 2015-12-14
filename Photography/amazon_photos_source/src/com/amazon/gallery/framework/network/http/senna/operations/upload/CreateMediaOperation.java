// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.http.senna.operations.upload;

import com.amazon.gallery.foundation.utils.log.GLogger;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

public class CreateMediaOperation extends AbstractHttpPostMessage
{

    private static final String TAG = com/amazon/gallery/framework/network/http/senna/operations/upload/CreateMediaOperation.getName();
    private final long date;
    private final DeviceAttributeStore deviceAttributeStore;
    private final boolean isCamera;
    private final String name;
    private final String path;
    private final String urlArguments;

    public CreateMediaOperation(HttpFactory httpfactory, String s, String s1, long l, DeviceAttributeStore deviceattributestore, boolean flag)
        throws InvalidParameterException
    {
        super(httpfactory, com.amazon.gallery.framework.network.http.rest.RestClient.MetricsEvent.CreateMediaItem);
        path = s;
        name = s1;
        date = l;
        deviceAttributeStore = deviceattributestore;
        isCamera = flag;
        httpfactory = s;
        try
        {
            if (!s.startsWith("/"))
            {
                break MISSING_BLOCK_LABEL_64;
            }
        }
        // Misplaced declaration of an exception variable
        catch (HttpFactory httpfactory)
        {
            throw new InvalidParameterException("URLEncoder.encode(newName, charsetName) failed", httpfactory);
        }
        httpfactory = s;
        if (!s.equals("/"))
        {
            httpfactory = s.substring(1);
        }
        urlArguments = (new StringBuilder()).append(URLEncoder.encode(httpfactory, "UTF-8")).append("?name=").append(URLEncoder.encode(s1, "UTF-8")).append("&isCamera=").append(URLEncoder.encode(Boolean.toString(flag), "UTF-8")).toString().replace("%2F", "/");
        return;
    }

    private static String creationDate(long l)
    {
        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        simpledateformat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpledateformat.format(new Date(l));
    }

    private JSONObject deviceId()
        throws JSONException
    {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("deviceType", deviceAttributeStore.getDeviceTypeId());
        jsonobject.put("deviceSerialNumber", deviceAttributeStore.getDeviceSerialNumber());
        return jsonobject;
    }

    private JSONObject origin()
        throws JSONException
    {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("deviceRegistrationId", deviceAttributeStore.getCachedDeviceId());
        jsonobject.put("localId", (new StringBuilder()).append(path).append(name).toString());
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
            jsonobject.put("conflictResolution", "NONE");
            jsonobject.put("origin", origin());
            jsonobject.put("deviceId", deviceId());
            if (date != 0L)
            {
                jsonobject.put("creationDate", creationDate(date));
            }
            GLogger.v(TAG, (new StringBuilder()).append("Senna create media item, request body:").append(jsonobject.toString(2)).toString(), new Object[0]);
        }
        catch (JSONException jsonexception)
        {
            throw new TerminalException(jsonexception);
        }
        return jsonobject;
    }

    protected URI getURI(Endpoint endpoint)
    {
        return URI.create((new StringBuilder()).append(endpoint.getHttpPath()).append("media/create/CUSTOMER_ID/").append(urlArguments).toString());
    }

    public String toString()
    {
        return (new StringBuilder()).append("CreateMediaOperation [path= ").append(path).append(" , name= ").append(name).append(", isCamera=").append(isCamera).append(" ]").toString();
    }

}
