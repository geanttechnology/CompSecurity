// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.web.client;

import java.nio.charset.Charset;
import org.springframework.http.HttpStatus;

// Referenced classes of package org.springframework.web.client:
//            HttpStatusCodeException

public class HttpServerErrorException extends HttpStatusCodeException
{

    public HttpServerErrorException(HttpStatus httpstatus, String s, byte abyte0[], Charset charset)
    {
        super(httpstatus, s, abyte0, charset);
    }
}
