// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.http.senna.operations;

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

public class ImportFacebookOperation extends AbstractHttpPostMessage
{

    private static final String TAG = com/amazon/gallery/framework/network/http/senna/operations/ImportFacebookOperation.getName();

    public ImportFacebookOperation(HttpFactory httpfactory, String s)
        throws InvalidParameterException
    {
        super(httpfactory, com.amazon.gallery.framework.network.http.rest.RestClient.MetricsEvent.FacebookImport, s);
    }

    public Boolean buildResponse(JSONObject jsonobject)
        throws TerminalException, TransientException
    {
        Boolean boolean1 = Boolean.valueOf(true);
        Boolean boolean2 = boolean1;
        if (!jsonobject.has("hasPhotos"))
        {
            break MISSING_BLOCK_LABEL_44;
        }
        try
        {
            boolean2 = (Boolean)jsonobject.get("hasPhotos");
        }
        catch (JSONException jsonexception)
        {
            GLogger.e(TAG, "Operation Completed with error, JSON Response: %s", new Object[] {
                jsonobject
            });
            GLogger.e(TAG, "JSONException:", new Object[] {
                jsonexception
            });
            return boolean1;
        }
        boolean1 = boolean2;
        GLogger.v(TAG, "Operation Completed, JSON Response: %s", new Object[] {
            jsonobject
        });
        return boolean2;
    }

    public volatile Object buildResponse(JSONObject jsonobject)
        throws TerminalException, TransientException
    {
        return buildResponse(jsonobject);
    }

    protected JSONObject getRequestBody()
        throws TerminalException
    {
        return null;
    }

    protected URI getURI(Endpoint endpoint)
    {
        endpoint = URI.create((new StringBuilder()).append(endpoint.getHttpPath()).append("social/Facebook/import/CUSTOMER_ID/").toString());
        GLogger.v(TAG, "Request URI: %s", new Object[] {
            endpoint
        });
        return endpoint;
    }

}
