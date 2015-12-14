// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.http.senna.operations;

import com.amazon.gallery.framework.network.exceptions.InvalidParameterException;
import com.amazon.gallery.framework.network.exceptions.TerminalException;
import com.amazon.gallery.framework.network.exceptions.TransientException;
import com.amazon.gallery.framework.network.http.rest.account.Endpoint;
import com.amazon.gallery.framework.network.http.rest.http.AbstractHttpGetMessage;
import com.amazon.gallery.framework.network.http.rest.http.HttpFactory;
import java.net.URI;
import org.json.JSONException;
import org.json.JSONObject;

public class GetEndpointOperation extends AbstractHttpGetMessage
{

    public GetEndpointOperation(HttpFactory httpfactory)
        throws InvalidParameterException
    {
        super(httpfactory, com.amazon.gallery.framework.network.http.rest.RestClient.MetricsEvent.GetEndpoint);
    }

    public Endpoint buildResponse(JSONObject jsonobject)
        throws TerminalException
    {
        String s;
        boolean flag;
        try
        {
            String s1 = jsonobject.getString("customerExists");
            s = jsonobject.getString("restUrl");
            flag = "YES".equalsIgnoreCase(s1);
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            throw new TerminalException(jsonobject);
        }
        jsonobject = s;
        if (!s.contains("http://"))
        {
            jsonobject = (new StringBuilder()).append("http://").append(s).toString();
        }
        jsonobject = new Endpoint(jsonobject, flag);
        return jsonobject;
    }

    public volatile Object buildResponse(JSONObject jsonobject)
        throws TerminalException, TransientException
    {
        return buildResponse(jsonobject);
    }

    public boolean equals(Object obj)
    {
        return super.equals(obj);
    }

    protected URI getURI(String s)
    {
        return URI.create((new StringBuilder()).append(s).append("endpoint/CUSTOMER_ID/").toString());
    }

    public int hashCode()
    {
        return super.hashCode();
    }

    public String toString()
    {
        return "GetEndpointOperation []";
    }
}
