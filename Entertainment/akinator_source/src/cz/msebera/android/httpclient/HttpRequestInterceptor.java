// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient;

import cz.msebera.android.httpclient.protocol.HttpContext;
import java.io.IOException;

// Referenced classes of package cz.msebera.android.httpclient:
//            HttpException, HttpRequest

public interface HttpRequestInterceptor
{

    public abstract void process(HttpRequest httprequest, HttpContext httpcontext)
        throws HttpException, IOException;
}
