// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.client;

import com.comcast.cim.httpcomponentsandroid.HttpHost;
import com.comcast.cim.httpcomponentsandroid.HttpRequest;
import com.comcast.cim.httpcomponentsandroid.HttpResponse;
import com.comcast.cim.httpcomponentsandroid.client.methods.HttpUriRequest;
import com.comcast.cim.httpcomponentsandroid.conn.ClientConnectionManager;
import com.comcast.cim.httpcomponentsandroid.params.HttpParams;
import com.comcast.cim.httpcomponentsandroid.protocol.HttpContext;
import java.io.IOException;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.client:
//            ClientProtocolException

public interface HttpClient
{

    public abstract HttpResponse execute(HttpHost httphost, HttpRequest httprequest, HttpContext httpcontext)
        throws IOException, ClientProtocolException;

    public abstract HttpResponse execute(HttpUriRequest httpurirequest)
        throws IOException, ClientProtocolException;

    public abstract HttpResponse execute(HttpUriRequest httpurirequest, HttpContext httpcontext)
        throws IOException, ClientProtocolException;

    public abstract ClientConnectionManager getConnectionManager();

    public abstract HttpParams getParams();
}
