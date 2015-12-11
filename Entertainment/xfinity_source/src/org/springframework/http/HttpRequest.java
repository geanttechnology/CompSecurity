// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.http;

import java.net.URI;

// Referenced classes of package org.springframework.http:
//            HttpMessage, HttpMethod

public interface HttpRequest
    extends HttpMessage
{

    public abstract HttpMethod getMethod();

    public abstract URI getURI();
}
