// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.entity;

import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpMessage;
import cz.msebera.android.httpclient.entity.ContentLengthStrategy;
import cz.msebera.android.httpclient.impl.io.ChunkedOutputStream;
import cz.msebera.android.httpclient.impl.io.ContentLengthOutputStream;
import cz.msebera.android.httpclient.impl.io.IdentityOutputStream;
import cz.msebera.android.httpclient.io.SessionOutputBuffer;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.io.OutputStream;

public class EntitySerializer
{

    private final ContentLengthStrategy lenStrategy;

    public EntitySerializer(ContentLengthStrategy contentlengthstrategy)
    {
        lenStrategy = (ContentLengthStrategy)Args.notNull(contentlengthstrategy, "Content length strategy");
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
        Args.notNull(sessionoutputbuffer, "Session output buffer");
        Args.notNull(httpmessage, "HTTP message");
        Args.notNull(httpentity, "HTTP entity");
        sessionoutputbuffer = doSerialize(sessionoutputbuffer, httpmessage);
        httpentity.writeTo(sessionoutputbuffer);
        sessionoutputbuffer.close();
    }
}
