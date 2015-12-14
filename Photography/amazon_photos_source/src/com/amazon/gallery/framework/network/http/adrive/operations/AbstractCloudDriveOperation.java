// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.http.adrive.operations;

import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.network.exceptions.InvalidParameterException;
import com.amazon.gallery.framework.network.exceptions.TerminalException;
import com.amazon.gallery.framework.network.http.rest.account.Endpoint;
import com.amazon.gallery.framework.network.http.rest.http.AbstractHttpPostMessage;
import com.amazon.gallery.framework.network.http.rest.http.HttpFactory;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.http.HttpHost;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.json.JSONObject;

public abstract class AbstractCloudDriveOperation extends AbstractHttpPostMessage
{

    private static final String TAG = com/amazon/gallery/framework/network/http/adrive/operations/AbstractCloudDriveOperation.getName();

    public AbstractCloudDriveOperation(HttpFactory httpfactory, com.amazon.gallery.framework.network.http.rest.RestClient.MetricsEvent metricsevent)
        throws InvalidParameterException
    {
        super(httpfactory, metricsevent);
    }

    public static String mapToQueryArguments(Map map)
    {
        StringBuilder stringbuilder;
        Iterator iterator;
        boolean flag;
        flag = true;
        stringbuilder = new StringBuilder();
        iterator = map.entrySet().iterator();
_L2:
        java.util.Map.Entry entry;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_125;
        }
        entry = (java.util.Map.Entry)iterator.next();
        String s = URLEncoder.encode((String)entry.getValue(), "UTF-8");
        if (flag)
        {
            map = "";
        } else
        {
            map = "&";
        }
        try
        {
            stringbuilder.append(map).append((String)entry.getKey()).append("=").append(s);
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            GLogger.e("Error encoding UTF-8 value for key {}", (String)entry.getKey(), new Object[0]);
        }
        break MISSING_BLOCK_LABEL_130;
        return stringbuilder.toString();
        flag = false;
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected abstract Map buildCloudDriveRequestBody();

    protected abstract String getOperationName();

    protected JSONObject getRequestBody()
        throws TerminalException
    {
        Object obj = buildCloudDriveRequestBody();
        try
        {
            obj = new StringEntity(mapToQueryArguments(((Map) (obj))), "UTF-8");
            ((HttpEntityEnclosingRequestBase)request).setEntity(((org.apache.http.HttpEntity) (obj)));
            request.setHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF8");
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            GLogger.e(TAG, (new StringBuilder()).append("Failed to get request body for ").append(getOperationName()).append(" from ADrive").toString(), new Object[0]);
        }
        return null;
    }

    protected URI getURI(Endpoint endpoint)
    {
        return URI.create((new StringBuilder()).append(endpoint.getHttpHost().toString()).append("/").append("clouddrive/device2/").toString());
    }

}
