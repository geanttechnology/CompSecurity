// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.IOException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

public final class bko
    implements HttpClient
{

    public bko()
    {
    }

    public final Object execute(HttpHost httphost, HttpRequest httprequest, ResponseHandler responsehandler)
    {
        throw new IOException();
    }

    public final Object execute(HttpHost httphost, HttpRequest httprequest, ResponseHandler responsehandler, HttpContext httpcontext)
    {
        throw new IOException();
    }

    public final Object execute(HttpUriRequest httpurirequest, ResponseHandler responsehandler)
    {
        throw new IOException();
    }

    public final Object execute(HttpUriRequest httpurirequest, ResponseHandler responsehandler, HttpContext httpcontext)
    {
        throw new IOException();
    }

    public final HttpResponse execute(HttpHost httphost, HttpRequest httprequest)
    {
        throw new IOException();
    }

    public final HttpResponse execute(HttpHost httphost, HttpRequest httprequest, HttpContext httpcontext)
    {
        throw new IOException();
    }

    public final HttpResponse execute(HttpUriRequest httpurirequest)
    {
        throw new IOException();
    }

    public final HttpResponse execute(HttpUriRequest httpurirequest, HttpContext httpcontext)
    {
        throw new IOException();
    }

    public final ClientConnectionManager getConnectionManager()
    {
        return null;
    }

    public final HttpParams getParams()
    {
        return null;
    }
}
