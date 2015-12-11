// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.client;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import cz.msebera.android.httpclient.conn.ClientConnectionManager;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.io.IOException;

// Referenced classes of package cz.msebera.android.httpclient.client:
//            ClientProtocolException, ResponseHandler

public interface HttpClient
{

    public abstract HttpResponse execute(HttpHost httphost, HttpRequest httprequest)
        throws IOException, ClientProtocolException;

    public abstract HttpResponse execute(HttpHost httphost, HttpRequest httprequest, HttpContext httpcontext)
        throws IOException, ClientProtocolException;

    public abstract HttpResponse execute(HttpUriRequest httpurirequest)
        throws IOException, ClientProtocolException;

    public abstract HttpResponse execute(HttpUriRequest httpurirequest, HttpContext httpcontext)
        throws IOException, ClientProtocolException;

    public abstract Object execute(HttpHost httphost, HttpRequest httprequest, ResponseHandler responsehandler)
        throws IOException, ClientProtocolException;

    public abstract Object execute(HttpHost httphost, HttpRequest httprequest, ResponseHandler responsehandler, HttpContext httpcontext)
        throws IOException, ClientProtocolException;

    public abstract Object execute(HttpUriRequest httpurirequest, ResponseHandler responsehandler)
        throws IOException, ClientProtocolException;

    public abstract Object execute(HttpUriRequest httpurirequest, ResponseHandler responsehandler, HttpContext httpcontext)
        throws IOException, ClientProtocolException;

    public abstract ClientConnectionManager getConnectionManager();

    public abstract HttpParams getParams();
}
