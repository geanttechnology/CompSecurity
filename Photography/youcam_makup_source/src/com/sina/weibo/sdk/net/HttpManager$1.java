// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.net;

import com.sina.weibo.sdk.utils.LogUtil;
import java.net.URI;
import org.apache.http.HttpResponse;
import org.apache.http.client.RedirectHandler;
import org.apache.http.protocol.HttpContext;

// Referenced classes of package com.sina.weibo.sdk.net:
//            HttpManager

class r
    implements RedirectHandler
{

    public URI getLocationURI(HttpResponse httpresponse, HttpContext httpcontext)
    {
        LogUtil.d("HttpManager", "openUrl4RdirectURL getLocationURI method");
        return null;
    }

    public boolean isRedirectRequested(HttpResponse httpresponse, HttpContext httpcontext)
    {
        LogUtil.d("HttpManager", "openUrl4RdirectURL isRedirectRequested method");
        return false;
    }

    r()
    {
    }
}
