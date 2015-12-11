// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.impl.entity;

import com.comcast.cim.httpcomponentsandroid.Header;
import com.comcast.cim.httpcomponentsandroid.HeaderElement;
import com.comcast.cim.httpcomponentsandroid.HttpException;
import com.comcast.cim.httpcomponentsandroid.HttpMessage;
import com.comcast.cim.httpcomponentsandroid.ParseException;
import com.comcast.cim.httpcomponentsandroid.ProtocolException;
import com.comcast.cim.httpcomponentsandroid.entity.ContentLengthStrategy;
import com.comcast.cim.httpcomponentsandroid.params.HttpParams;

public class LaxContentLengthStrategy
    implements ContentLengthStrategy
{

    public LaxContentLengthStrategy()
    {
    }

    public long determineLength(HttpMessage httpmessage)
        throws HttpException
    {
        Header header;
        Object obj;
        boolean flag;
        if (httpmessage == null)
        {
            throw new IllegalArgumentException("HTTP message may not be null");
        }
        flag = httpmessage.getParams().isParameterTrue("http.protocol.strict-transfer-encoding");
        header = httpmessage.getFirstHeader("Transfer-Encoding");
        obj = httpmessage.getFirstHeader("Content-Length");
        if (header == null) goto _L2; else goto _L1
_L1:
        int j;
        try
        {
            httpmessage = header.getElements();
        }
        // Misplaced declaration of an exception variable
        catch (HttpMessage httpmessage)
        {
            throw new ProtocolException("Invalid Transfer-Encoding header value: " + header, httpmessage);
        }
        if (flag)
        {
            for (int i = 0; i < httpmessage.length; i++)
            {
                obj = httpmessage[i].getName();
                if (obj != null && ((String) (obj)).length() > 0 && !((String) (obj)).equalsIgnoreCase("chunked") && !((String) (obj)).equalsIgnoreCase("identity"))
                {
                    throw new ProtocolException("Unsupported transfer encoding: " + obj);
                }
            }

        }
        j = httpmessage.length;
        if (!"identity".equalsIgnoreCase(header.getValue())) goto _L4; else goto _L3
_L3:
        long l1 = -1L;
_L9:
        return l1;
_L4:
        if (j > 0 && "chunked".equalsIgnoreCase(httpmessage[j - 1].getName()))
        {
            return -2L;
        }
        if (flag)
        {
            throw new ProtocolException("Chunk-encoding must be the last one applied");
        } else
        {
            return -1L;
        }
_L2:
        if (obj == null) goto _L6; else goto _L5
_L5:
        l1 = -1L;
        httpmessage = httpmessage.getHeaders("Content-Length");
        if (flag && httpmessage.length > 1)
        {
            throw new ProtocolException("Multiple content length headers");
        }
        j = httpmessage.length - 1;
_L7:
        long l;
        l = l1;
        if (j < 0)
        {
            break MISSING_BLOCK_LABEL_320;
        }
        header = httpmessage[j];
        l = Long.parseLong(header.getValue());
        l1 = l;
        if (l < 0L)
        {
            return -1L;
        }
        continue; /* Loop/switch isn't completed */
        NumberFormatException numberformatexception;
        numberformatexception;
        if (flag)
        {
            throw new ProtocolException("Invalid content length: " + header.getValue());
        }
        j--;
        if (true) goto _L7; else goto _L6
_L6:
        return -1L;
        if (true) goto _L9; else goto _L8
_L8:
    }
}
