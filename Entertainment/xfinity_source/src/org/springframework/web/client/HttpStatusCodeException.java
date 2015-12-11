// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.web.client;

import java.nio.charset.Charset;
import org.springframework.http.HttpStatus;

// Referenced classes of package org.springframework.web.client:
//            RestClientException

public abstract class HttpStatusCodeException extends RestClientException
{

    private static final Charset DEFAULT_CHARSET = Charset.forName("ISO-8859-1");
    private final byte responseBody[];
    private final Charset responseCharset;
    private final HttpStatus statusCode;
    private final String statusText;

    protected HttpStatusCodeException(HttpStatus httpstatus, String s, byte abyte0[], Charset charset)
    {
        super((new StringBuilder()).append(httpstatus.value()).append(" ").append(s).toString());
        statusCode = httpstatus;
        statusText = s;
        if (abyte0 == null)
        {
            abyte0 = new byte[0];
        }
        responseBody = abyte0;
        if (charset == null)
        {
            charset = DEFAULT_CHARSET;
        }
        responseCharset = charset;
    }

}
