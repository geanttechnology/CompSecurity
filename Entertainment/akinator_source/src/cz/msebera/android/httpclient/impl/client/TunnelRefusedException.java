// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpResponse;

public class TunnelRefusedException extends HttpException
{

    private static final long serialVersionUID = 0x8800ab6306e44455L;
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
