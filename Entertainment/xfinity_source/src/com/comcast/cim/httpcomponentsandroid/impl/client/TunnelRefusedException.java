// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.impl.client;

import com.comcast.cim.httpcomponentsandroid.HttpException;
import com.comcast.cim.httpcomponentsandroid.HttpResponse;

public class TunnelRefusedException extends HttpException
{

    private final HttpResponse response;

    public TunnelRefusedException(String s, HttpResponse httpresponse)
    {
        super(s);
        response = httpresponse;
    }

    public HttpResponse getResponse()
    {
        return response;
    }
}
