// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.http.rest.http;

import com.amazon.clouddrive.internal.BasicSourceInfo;
import com.amazon.gallery.framework.network.exceptions.TerminalException;
import com.amazon.gallery.framework.network.exceptions.TransientException;
import com.amazon.gallery.framework.network.http.rest.account.Endpoint;
import org.apache.http.client.methods.HttpRequestBase;
import org.json.JSONObject;

public abstract class AbstractHttpMessage
{

    protected Endpoint endpoint;
    public final com.amazon.gallery.framework.network.http.rest.RestClient.MetricsEvent metricsEvent;
    public final String metricsEventTag;
    public HttpRequestBase request;
    protected final BasicSourceInfo sourceInfo;

    public AbstractHttpMessage(HttpRequestBase httprequestbase, com.amazon.gallery.framework.network.http.rest.RestClient.MetricsEvent metricsevent, BasicSourceInfo basicsourceinfo)
    {
        this(httprequestbase, metricsevent, null, basicsourceinfo);
    }

    public AbstractHttpMessage(HttpRequestBase httprequestbase, com.amazon.gallery.framework.network.http.rest.RestClient.MetricsEvent metricsevent, String s, BasicSourceInfo basicsourceinfo)
    {
        metricsEvent = metricsevent;
        metricsEventTag = s;
        request = httprequestbase;
        endpoint = null;
        sourceInfo = basicsourceinfo;
    }

    public HttpRequestBase buildRequest()
        throws TerminalException
    {
        populateRequest(endpoint);
        return request;
    }

    public abstract Object buildResponse(JSONObject jsonobject)
        throws TerminalException, TransientException;

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
        obj = (AbstractHttpMessage)obj;
        if (metricsEvent != ((AbstractHttpMessage) (obj)).metricsEvent)
        {
            return false;
        }
        if (request != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((AbstractHttpMessage) (obj)).request == null) goto _L1; else goto _L3
_L3:
        return false;
        if (request.equals(((AbstractHttpMessage) (obj)).request)) goto _L1; else goto _L4
_L4:
        return false;
    }

    public Endpoint getEndpoint()
    {
        return endpoint;
    }

    public int hashCode()
    {
        return 1;
    }

    public void populateRequest(Endpoint endpoint1)
        throws TerminalException
    {
        if (sourceInfo != null && sourceInfo.getSourceId() != null)
        {
            request.addHeader("x-amzn-clouddrive-source", sourceInfo.getSourceId());
        }
    }

    public void setEndpoint(Endpoint endpoint1)
    {
        endpoint = endpoint1;
    }
}
