// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.http.client;

import java.io.IOException;
import java.net.URI;
import org.springframework.http.HttpMethod;

// Referenced classes of package org.springframework.http.client:
//            ClientHttpRequest

public interface ClientHttpRequestFactory
{

    public abstract ClientHttpRequest createRequest(URI uri, HttpMethod httpmethod)
        throws IOException;
}
