// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid;

import com.comcast.cim.httpcomponentsandroid.protocol.HttpContext;
import java.io.IOException;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid:
//            HttpException, HttpRequest

public interface HttpRequestInterceptor
{

    public abstract void process(HttpRequest httprequest, HttpContext httpcontext)
        throws HttpException, IOException;
}
