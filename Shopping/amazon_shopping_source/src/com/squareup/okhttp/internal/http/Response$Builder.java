// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Handshake;
import com.squareup.okhttp.ResponseSource;
import java.io.IOException;

// Referenced classes of package com.squareup.okhttp.internal.http:
//            Response, Headers, OkHeaders, StatusLine, 
//            Request

public static class <init>
{

    private  body;
    private Handshake handshake;
    private  headers;
    private Response redirectedBy;
    private Request request;
    private StatusLine statusLine;

    public <init> addHeader(String s, String s1)
    {
        headers.dd(s, s1);
        return this;
    }

    public dd body(dd dd)
    {
        body = dd;
        return this;
    }

    public Response build()
    {
        if (request == null)
        {
            throw new IllegalStateException("request == null");
        }
        if (statusLine == null)
        {
            throw new IllegalStateException("statusLine == null");
        } else
        {
            return new Response(this, null);
        }
    }

    public statusLine handshake(Handshake handshake1)
    {
        handshake = handshake1;
        return this;
    }

    public handshake header(String s, String s1)
    {
        headers.et(s, s1);
        return this;
    }

    public et headers(Headers headers1)
    {
        headers = headers1.newBuilder();
        return this;
    }

    public r redirectedBy(Response response)
    {
        redirectedBy = response;
        return this;
    }

    public redirectedBy removeHeader(String s)
    {
        headers.emoveAll(s);
        return this;
    }

    public emoveAll request(Request request1)
    {
        request = request1;
        return this;
    }

    public request setResponseSource(ResponseSource responsesource)
    {
        return header(OkHeaders.RESPONSE_SOURCE, (new StringBuilder()).append(responsesource).append(" ").append(statusLine.code()).toString());
    }

    public statusLine statusLine(StatusLine statusline)
    {
        if (statusline == null)
        {
            throw new IllegalArgumentException("statusLine == null");
        } else
        {
            statusLine = statusline;
            return this;
        }
    }

    public statusLine statusLine(String s)
    {
        try
        {
            s = statusLine(new StatusLine(s));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new IllegalArgumentException(s);
        }
        return s;
    }







    public ()
    {
        headers = new init>();
    }

    private init>(Response response)
    {
        request = Response.access$900(response);
        statusLine = Response.access$1000(response);
        handshake = Response.access$1100(response);
        headers = Response.access$1200(response).newBuilder();
        body = Response.access$1300(response);
        redirectedBy = Response.access$1400(response);
    }

    _cls400(Response response, _cls400 _pcls400)
    {
        this(response);
    }
}
