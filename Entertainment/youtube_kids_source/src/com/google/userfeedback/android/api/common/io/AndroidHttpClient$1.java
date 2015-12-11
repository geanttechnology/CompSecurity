// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.userfeedback.android.api.common.io;

import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.protocol.HttpContext;

// Referenced classes of package com.google.userfeedback.android.api.common.io:
//            AndroidHttpClient

final class 
    implements HttpRequestInterceptor
{

    public final void process(HttpRequest httprequest, HttpContext httpcontext)
    {
        if (AndroidHttpClient.access$000().get() != null && ((Boolean)AndroidHttpClient.access$000().get()).booleanValue())
        {
            throw new RuntimeException("This thread forbids HTTP requests");
        } else
        {
            return;
        }
    }

    ()
    {
    }
}
