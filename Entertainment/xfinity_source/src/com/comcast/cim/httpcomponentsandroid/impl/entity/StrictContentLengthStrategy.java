// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.impl.entity;

import com.comcast.cim.httpcomponentsandroid.Header;
import com.comcast.cim.httpcomponentsandroid.HttpException;
import com.comcast.cim.httpcomponentsandroid.HttpMessage;
import com.comcast.cim.httpcomponentsandroid.HttpVersion;
import com.comcast.cim.httpcomponentsandroid.ProtocolException;
import com.comcast.cim.httpcomponentsandroid.ProtocolVersion;
import com.comcast.cim.httpcomponentsandroid.entity.ContentLengthStrategy;

public class StrictContentLengthStrategy
    implements ContentLengthStrategy
{

    public StrictContentLengthStrategy()
    {
    }

    public long determineLength(HttpMessage httpmessage)
        throws HttpException
    {
        Object obj;
        Header header;
        long l;
        l = -1L;
        if (httpmessage == null)
        {
            throw new IllegalArgumentException("HTTP message may not be null");
        }
        obj = httpmessage.getFirstHeader("Transfer-Encoding");
        header = httpmessage.getFirstHeader("Content-Length");
        if (obj == null) goto _L2; else goto _L1
_L1:
        obj = ((Header) (obj)).getValue();
        if (!"chunked".equalsIgnoreCase(((String) (obj)))) goto _L4; else goto _L3
_L3:
        if (httpmessage.getProtocolVersion().lessEquals(HttpVersion.HTTP_1_0))
        {
            throw new ProtocolException("Chunked transfer encoding not allowed for " + httpmessage.getProtocolVersion());
        }
        l = -2L;
_L6:
        return l;
_L4:
        if ("identity".equalsIgnoreCase(((String) (obj)))) goto _L6; else goto _L5
_L5:
        throw new ProtocolException("Unsupported transfer encoding: " + obj);
_L2:
        if (header == null) goto _L6; else goto _L7
_L7:
        httpmessage = header.getValue();
        long l1;
        try
        {
            l1 = Long.parseLong(httpmessage);
        }
        catch (NumberFormatException numberformatexception)
        {
            throw new ProtocolException("Invalid content length: " + httpmessage);
        }
        l = l1;
        if (l1 >= 0L) goto _L6; else goto _L8
_L8:
        throw new ProtocolException("Negative content length: " + httpmessage);
    }
}
