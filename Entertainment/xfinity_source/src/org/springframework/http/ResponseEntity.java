// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.http;

import org.springframework.util.MultiValueMap;

// Referenced classes of package org.springframework.http:
//            HttpEntity, HttpStatus

public class ResponseEntity extends HttpEntity
{

    private final HttpStatus statusCode;

    public ResponseEntity(Object obj, HttpStatus httpstatus)
    {
        super(obj);
        statusCode = httpstatus;
    }

    public ResponseEntity(Object obj, MultiValueMap multivaluemap, HttpStatus httpstatus)
    {
        super(obj, multivaluemap);
        statusCode = httpstatus;
    }

    public ResponseEntity(MultiValueMap multivaluemap, HttpStatus httpstatus)
    {
        super(multivaluemap);
        statusCode = httpstatus;
    }

    public HttpStatus getStatusCode()
    {
        return statusCode;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("<");
        stringbuilder.append(statusCode.toString());
        stringbuilder.append(' ');
        stringbuilder.append(statusCode.getReasonPhrase());
        stringbuilder.append(',');
        Object obj = getBody();
        HttpHeaders httpheaders = getHeaders();
        if (obj != null)
        {
            stringbuilder.append(obj);
            if (httpheaders != null)
            {
                stringbuilder.append(',');
            }
        }
        if (httpheaders != null)
        {
            stringbuilder.append(httpheaders);
        }
        stringbuilder.append('>');
        return stringbuilder.toString();
    }
}
