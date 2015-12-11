// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.medialets.advertising;

import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.protocol.HttpContext;

// Referenced classes of package com.medialets.advertising:
//            d

final class m
    implements HttpRequestInterceptor
{

    m()
    {
    }

    public final void process(HttpRequest httprequest, HttpContext httpcontext)
    {
        if (Boolean.TRUE.equals(d.b().get()))
        {
            throw new RuntimeException("This thread forbids HTTP requests");
        } else
        {
            return;
        }
    }
}
