// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.utils;

import com.comcast.cim.cmasl.android.util.system.InternetConnection;
import com.comcast.cim.httpcomponentsandroid.HttpException;
import com.comcast.cim.httpcomponentsandroid.HttpRequest;
import com.comcast.cim.httpcomponentsandroid.HttpRequestInterceptor;
import com.comcast.cim.httpcomponentsandroid.message.BasicHeader;
import com.comcast.cim.httpcomponentsandroid.protocol.HttpContext;
import java.io.IOException;

public class AddNetworkTypeHeaderInterceptor
    implements HttpRequestInterceptor
{

    private final InternetConnection internetConnection;

    public AddNetworkTypeHeaderInterceptor(InternetConnection internetconnection)
    {
        internetConnection = internetconnection;
    }

    public void process(HttpRequest httprequest, HttpContext httpcontext)
        throws HttpException, IOException
    {
        if (internetConnection.isConnectedOnWiFi())
        {
            httpcontext = "Wifi";
        } else
        {
            httpcontext = "Cellular";
        }
        httprequest.addHeader(new BasicHeader("X-FINITY-NETWORK", httpcontext));
    }
}
