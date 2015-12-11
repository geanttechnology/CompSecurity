// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.http.client;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethodBase;
import org.apache.commons.httpclient.URI;
import org.apache.commons.httpclient.URIException;
import org.apache.commons.httpclient.methods.ByteArrayRequestEntity;
import org.apache.commons.httpclient.methods.EntityEnclosingMethod;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

// Referenced classes of package org.springframework.http.client:
//            a, e, ClientHttpResponse

final class d extends a
{

    private final HttpClient a;
    private final HttpMethodBase b;

    d(HttpClient httpclient, HttpMethodBase httpmethodbase)
    {
        a = httpclient;
        b = httpmethodbase;
    }

    public final ClientHttpResponse a(HttpHeaders httpheaders, byte abyte0[])
    {
        for (httpheaders = httpheaders.entrySet().iterator(); httpheaders.hasNext();)
        {
            Object obj = (java.util.Map.Entry)httpheaders.next();
            String s = (String)((java.util.Map.Entry) (obj)).getKey();
            obj = ((List)((java.util.Map.Entry) (obj)).getValue()).iterator();
            while (((Iterator) (obj)).hasNext()) 
            {
                String s1 = (String)((Iterator) (obj)).next();
                b.addRequestHeader(s, s1);
            }
        }

        if (b instanceof EntityEnclosingMethod)
        {
            ((EntityEnclosingMethod)b).setRequestEntity(new ByteArrayRequestEntity(abyte0));
        }
        a.executeMethod(b);
        return new e(b);
    }

    public final HttpMethod getMethod()
    {
        return HttpMethod.valueOf(b.getName());
    }

    public final java.net.URI getURI()
    {
        java.net.URI uri;
        try
        {
            uri = java.net.URI.create(b.getURI().getEscapedURI());
        }
        catch (URIException uriexception)
        {
            throw new IllegalStateException((new StringBuilder("Could not get HttpMethod URI: ")).append(uriexception.getMessage()).toString(), uriexception);
        }
        return uri;
    }
}
