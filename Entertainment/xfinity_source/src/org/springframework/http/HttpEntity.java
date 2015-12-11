// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.http;

import org.springframework.util.MultiValueMap;

// Referenced classes of package org.springframework.http:
//            HttpHeaders

public class HttpEntity
{

    public static final HttpEntity EMPTY = new HttpEntity();
    private final Object body;
    private final HttpHeaders headers;

    protected HttpEntity()
    {
        this(null, null);
    }

    public HttpEntity(Object obj)
    {
        this(obj, null);
    }

    public HttpEntity(Object obj, MultiValueMap multivaluemap)
    {
        body = obj;
        obj = new HttpHeaders();
        if (multivaluemap != null)
        {
            ((HttpHeaders) (obj)).putAll(multivaluemap);
        }
        headers = HttpHeaders.readOnlyHttpHeaders(((HttpHeaders) (obj)));
    }

    public HttpEntity(MultiValueMap multivaluemap)
    {
        this(null, multivaluemap);
    }

    public Object getBody()
    {
        return body;
    }

    public HttpHeaders getHeaders()
    {
        return headers;
    }

    public boolean hasBody()
    {
        return body != null;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("<");
        if (body != null)
        {
            stringbuilder.append(body);
            if (headers != null)
            {
                stringbuilder.append(',');
            }
        }
        if (headers != null)
        {
            stringbuilder.append(headers);
        }
        stringbuilder.append('>');
        return stringbuilder.toString();
    }

}
