// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.client.utils.URIUtils;
import cz.msebera.android.httpclient.conn.routing.RouteInfo;
import java.net.URI;
import java.net.URISyntaxException;

class InternalURIUtils
{

    private InternalURIUtils()
    {
    }

    public static URI rewriteURIForRoute(URI uri, RouteInfo routeinfo)
        throws URISyntaxException
    {
        if (uri == null)
        {
            return null;
        }
        if (routeinfo.getProxyHost() != null && !routeinfo.isTunnelled())
        {
            if (!uri.isAbsolute())
            {
                return URIUtils.rewriteURI(uri, routeinfo.getTargetHost(), true);
            } else
            {
                return URIUtils.rewriteURI(uri);
            }
        }
        if (uri.isAbsolute())
        {
            return URIUtils.rewriteURI(uri, null, true);
        } else
        {
            return URIUtils.rewriteURI(uri);
        }
    }
}
