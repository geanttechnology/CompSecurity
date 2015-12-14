// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.http.senna.operations.upload;

import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.media.MediaItem;
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

// Referenced classes of package com.amazon.gallery.framework.network.http.senna.operations.upload:
//            UploadLocationResponse

public class GetUploadLocationWithPartsOperation extends AbstractHttpPostMessage
{

    private static final String TAG = com/amazon/gallery/framework/network/http/senna/operations/upload/GetUploadLocationWithPartsOperation.getSimpleName();
    private ObjectID fileObjectId;
    private MediaItem mediaItem;
    private final int numParts;

    public GetUploadLocationWithPartsOperation(HttpFactory httpfactory, ObjectID objectid, MediaItem mediaitem, int i)
        throws InvalidParameterException
    {
        super(httpfactory, com.amazon.gallery.framework.network.http.rest.RestClient.MetricsEvent.GetMultiUploadLocationOperation);
        fileObjectId = objectid;
        mediaItem = mediaitem;
        numParts = i;
    }

    private long mediaItemFileSize()
        throws TerminalException
    {
        File file = new File(mediaItem.getLocalPath());
        if (!file.exists())
        {
            throw new TerminalException("Attempted to upload file that doesn't exist");
        } else
        {
            return file.length();
        }
    }

    public UploadLocationResponse buildResponse(JSONObject jsonobject)
        throws TerminalException, TransientException
    {
        try
        {
            jsonobject = new UploadLocationResponse(jsonobject);
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            throw new TerminalException(jsonobject);
        }
        return jsonobject;
    }

    public volatile Object buildResponse(JSONObject jsonobject)
        throws TerminalException, TransientException
    {
        return buildResponse(jsonobject);
    }

    protected JSONObject getRequestBody()
        throws TerminalException
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("size", mediaItemFileSize());
            jsonobject.put("noOfParts", numParts);
        }
        catch (JSONException jsonexception)
        {
            throw new TerminalException(jsonexception);
        }
        return jsonobject;
    }

    protected URI getURI(Endpoint endpoint)
    {
        return URI.create((new StringBuilder()).append(endpoint.getHttpPath()).append("media/uploadLocation/CUSTOMER_ID/").append(fileObjectId.toString()).toString());
    }

}
