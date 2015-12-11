// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.http;

import java.io.InputStream;
import java.io.PrintStream;

// Referenced classes of package org.cybergarage.http:
//            HTTPPacket, HTTPServer, HTTPSocket, HTTPStatus

public class HTTPResponse extends HTTPPacket
{

    private int statusCode;

    public HTTPResponse()
    {
        statusCode = 0;
        setVersion("1.1");
        setContentType("text/html; charset=\"utf-8\"");
        setServer(HTTPServer.getName());
        setContent("");
    }

    public HTTPResponse(InputStream inputstream)
    {
        super(inputstream);
        statusCode = 0;
    }

    public HTTPResponse(HTTPResponse httpresponse)
    {
        statusCode = 0;
        set(httpresponse);
    }

    public HTTPResponse(HTTPSocket httpsocket)
    {
        this(httpsocket.getInputStream());
    }

    public String getHeader()
    {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append(getStatusLineString());
        stringbuffer.append(getHeaderString());
        return stringbuffer.toString();
    }

    public int getStatusCode()
    {
        if (statusCode != 0)
        {
            return statusCode;
        } else
        {
            return (new HTTPStatus(getFirstLine())).getStatusCode();
        }
    }

    public String getStatusLineString()
    {
        return (new StringBuilder("HTTP/")).append(getVersion()).append(" ").append(getStatusCode()).append(" ").append(HTTPStatus.code2String(statusCode)).append("\r\n").toString();
    }

    public boolean isSuccessful()
    {
        return HTTPStatus.isSuccessful(getStatusCode());
    }

    public void print()
    {
        System.out.println(toString());
    }

    public void setStatusCode(int i)
    {
        statusCode = i;
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append(getStatusLineString());
        stringbuffer.append(getHeaderString());
        stringbuffer.append("\r\n");
        stringbuffer.append(getContentString());
        return stringbuffer.toString();
    }
}
