// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.impl.entity;

import com.comcast.cim.httpcomponentsandroid.HttpEntity;
import com.comcast.cim.httpcomponentsandroid.HttpException;
import com.comcast.cim.httpcomponentsandroid.HttpMessage;
import com.comcast.cim.httpcomponentsandroid.entity.ContentLengthStrategy;
import com.comcast.cim.httpcomponentsandroid.impl.io.ChunkedOutputStream;
import com.comcast.cim.httpcomponentsandroid.impl.io.ContentLengthOutputStream;
import com.comcast.cim.httpcomponentsandroid.impl.io.IdentityOutputStream;
import com.comcast.cim.httpcomponentsandroid.io.SessionOutputBuffer;
import java.io.IOException;
import java.io.OutputStream;

public class EntitySerializer
{

    private final ContentLengthStrategy lenStrategy;

    public EntitySerializer(ContentLengthStrategy contentlengthstrategy)
    {
        if (contentlengthstrategy == null)
        {
            throw new IllegalArgumentException("Content length strategy may not be null");
        } else
        {
            lenStrategy = contentlengthstrategy;
            return;
        }
    }

    protected OutputStream doSerialize(SessionOutputBuffer sessionoutputbuffer, HttpMessage httpmessage)
        throws HttpException, IOException
    {
        long l = lenStrategy.determineLength(httpmessage);
        if (l == -2L)
        {
            return new ChunkedOutputStream(sessionoutputbuffer);
        }
        if (l == -1L)
        {
            return new IdentityOutputStream(sessionoutputbuffer);
        } else
        {
            return new ContentLengthOutputStream(sessionoutputbuffer, l);
        }
    }

    public void serialize(SessionOutputBuffer sessionoutputbuffer, HttpMessage httpmessage, HttpEntity httpentity)
        throws HttpException, IOException
    {
        if (sessionoutputbuffer == null)
        {
            throw new IllegalArgumentException("Session output buffer may not be null");
        }
        if (httpmessage == null)
        {
            throw new IllegalArgumentException("HTTP message may not be null");
        }
        if (httpentity == null)
        {
            throw new IllegalArgumentException("HTTP entity may not be null");
        } else
        {
            sessionoutputbuffer = doSerialize(sessionoutputbuffer, httpmessage);
            httpentity.writeTo(sessionoutputbuffer);
            sessionoutputbuffer.close();
            return;
        }
    }
}
