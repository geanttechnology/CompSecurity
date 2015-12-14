// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.upload;

import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.network.exceptions.InvalidParameterException;
import com.amazon.gallery.framework.network.exceptions.TerminalException;
import com.amazon.gallery.framework.network.exceptions.TransientException;
import com.amazon.gallery.framework.network.http.rest.account.Endpoint;
import com.amazon.gallery.framework.network.http.rest.http.AbstractHttpPostMessage;
import com.amazon.gallery.framework.network.http.rest.http.HttpFactory;
import java.net.URI;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.gallery.framework.network.upload:
//            DeviceAttributeStore

public class RegisterDeviceOperation extends AbstractHttpPostMessage
{

    private static final String TAG = com/amazon/gallery/framework/network/upload/RegisterDeviceOperation.getName();
    private String defaultDeviceName;
    private DeviceAttributeStore deviceAttributeStore;

    public RegisterDeviceOperation(HttpFactory httpfactory, DeviceAttributeStore deviceattributestore)
        throws InvalidParameterException
    {
        super(httpfactory, com.amazon.gallery.framework.network.http.rest.RestClient.MetricsEvent.RegisterDeviceOperation);
        deviceAttributeStore = deviceattributestore;
        if (deviceattributestore != null)
        {
            defaultDeviceName = deviceattributestore.getDefaultDeviceName();
            return;
        } else
        {
            defaultDeviceName = "";
            return;
        }
    }

    public volatile Object buildResponse(JSONObject jsonobject)
        throws TerminalException, TransientException
    {
        return buildResponse(jsonobject);
    }

    public String buildResponse(JSONObject jsonobject)
        throws TerminalException, TransientException
    {
        Object obj = null;
        JSONObject jsonobject1 = obj;
        try
        {
            GLogger.v(TAG, (new StringBuilder()).append("Received response:").append(jsonobject.toString(2)).toString(), new Object[0]);
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            GLogger.d(TAG, "Failed to extract id from response", new Object[0]);
            return jsonobject1;
        }
        jsonobject1 = obj;
        jsonobject = jsonobject.getString("id");
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_71;
        }
        jsonobject1 = jsonobject;
        if (deviceAttributeStore == null)
        {
            break MISSING_BLOCK_LABEL_71;
        }
        jsonobject1 = jsonobject;
        deviceAttributeStore.storeDeviceId(jsonobject);
        return jsonobject;
    }

    protected JSONObject getRequestBody()
        throws TerminalException
    {
        JSONObject jsonobject = new JSONObject();
        String s = null;
        if (deviceAttributeStore != null)
        {
            s = deviceAttributeStore.getDeviceName();
        }
        String s1 = s;
        if (s == null)
        {
            s1 = defaultDeviceName;
        }
        try
        {
            jsonobject.put("name", s1);
            jsonobject.put("type", deviceAttributeStore.getDeviceType());
            jsonobject.put("uniqueIdentifier", deviceAttributeStore.getDeviceSerialNumber());
            GLogger.v(TAG, (new StringBuilder()).append("Register Device Operation, sending:").append(jsonobject.toString(2)).toString(), new Object[0]);
        }
        catch (Exception exception)
        {
            GLogger.e(TAG, "Error creating RegisterDeivce json body", new Object[] {
                exception
            });
            return jsonobject;
        }
        return jsonobject;
    }

    protected URI getURI(Endpoint endpoint)
    {
        return URI.create((new StringBuilder()).append(endpoint.getHttpPath()).append("device/register/CUSTOMER_ID/").toString());
    }

}
