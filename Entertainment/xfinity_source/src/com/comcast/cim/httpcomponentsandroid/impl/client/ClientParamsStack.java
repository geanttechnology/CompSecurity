// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.impl.client;

import com.comcast.cim.httpcomponentsandroid.params.AbstractHttpParams;
import com.comcast.cim.httpcomponentsandroid.params.HttpParams;

public class ClientParamsStack extends AbstractHttpParams
{

    protected final HttpParams applicationParams;
    protected final HttpParams clientParams;
    protected final HttpParams overrideParams;
    protected final HttpParams requestParams;

    public ClientParamsStack(HttpParams httpparams, HttpParams httpparams1, HttpParams httpparams2, HttpParams httpparams3)
    {
        applicationParams = httpparams;
        clientParams = httpparams1;
        requestParams = httpparams2;
        overrideParams = httpparams3;
    }

    public final HttpParams getApplicationParams()
    {
        return applicationParams;
    }

    public final HttpParams getClientParams()
    {
        return clientParams;
    }

    public final HttpParams getOverrideParams()
    {
        return overrideParams;
    }

    public Object getParameter(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("Parameter name must not be null.");
        }
        Object obj1 = null;
        if (overrideParams != null)
        {
            obj1 = overrideParams.getParameter(s);
        }
        Object obj = obj1;
        if (obj1 == null)
        {
            obj = obj1;
            if (requestParams != null)
            {
                obj = requestParams.getParameter(s);
            }
        }
        obj1 = obj;
        if (obj == null)
        {
            obj1 = obj;
            if (clientParams != null)
            {
                obj1 = clientParams.getParameter(s);
            }
        }
        obj = obj1;
        if (obj1 == null)
        {
            obj = obj1;
            if (applicationParams != null)
            {
                obj = applicationParams.getParameter(s);
            }
        }
        return obj;
    }

    public final HttpParams getRequestParams()
    {
        return requestParams;
    }

    public HttpParams setParameter(String s, Object obj)
        throws UnsupportedOperationException
    {
        throw new UnsupportedOperationException("Setting parameters in a stack is not supported.");
    }
}
