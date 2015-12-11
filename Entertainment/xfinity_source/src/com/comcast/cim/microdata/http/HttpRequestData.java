// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.microdata.http;

import com.comcast.cim.microdata.util.SimpleToStringBuilder;
import java.net.URI;

// Referenced classes of package com.comcast.cim.microdata.http:
//            HttpMethod

public class HttpRequestData
{

    private String acceptContentType;
    private String body;
    private HttpMethod method;
    private URI uri;

    public String getAcceptContentType()
    {
        return acceptContentType;
    }

    public String getBody()
    {
        return body;
    }

    public HttpMethod getMethod()
    {
        return method;
    }

    public URI getUri()
    {
        return uri;
    }

    public String toString()
    {
        SimpleToStringBuilder simpletostringbuilder = new SimpleToStringBuilder(this);
        simpletostringbuilder.append("uri", uri);
        simpletostringbuilder.append("method", method);
        simpletostringbuilder.append("body", body);
        simpletostringbuilder.append("acceptContentType", acceptContentType);
        return simpletostringbuilder.toString();
    }
}
