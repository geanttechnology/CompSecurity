// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.http.client;

import java.io.IOException;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.HttpRequest;

// Referenced classes of package org.springframework.http.client:
//            ClientHttpResponse

public interface ClientHttpRequest
    extends HttpOutputMessage, HttpRequest
{

    public abstract ClientHttpResponse execute()
        throws IOException;
}
