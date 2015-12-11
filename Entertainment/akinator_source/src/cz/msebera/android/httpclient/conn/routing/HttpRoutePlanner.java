// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.conn.routing;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.protocol.HttpContext;

// Referenced classes of package cz.msebera.android.httpclient.conn.routing:
//            HttpRoute

public interface HttpRoutePlanner
{

    public abstract HttpRoute determineRoute(HttpHost httphost, HttpRequest httprequest, HttpContext httpcontext)
        throws HttpException;
}
