// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.http.client;

import java.io.IOException;
import org.springframework.http.HttpRequest;

// Referenced classes of package org.springframework.http.client:
//            ClientHttpRequestExecution, ClientHttpResponse

public interface ClientHttpRequestInterceptor
{

    public abstract ClientHttpResponse intercept(HttpRequest httprequest, byte abyte0[], ClientHttpRequestExecution clienthttprequestexecution)
        throws IOException;
}
