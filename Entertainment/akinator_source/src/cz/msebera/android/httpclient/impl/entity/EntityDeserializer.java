// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.entity;

import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpMessage;
import cz.msebera.android.httpclient.entity.BasicHttpEntity;
import cz.msebera.android.httpclient.entity.ContentLengthStrategy;
import cz.msebera.android.httpclient.impl.io.ChunkedInputStream;
import cz.msebera.android.httpclient.impl.io.ContentLengthInputStream;
import cz.msebera.android.httpclient.impl.io.IdentityInputStream;
import cz.msebera.android.httpclient.io.SessionInputBuffer;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;

public class EntityDeserializer
{

    private final ContentLengthStrategy lenStrategy;

    public EntityDeserializer(ContentLengthStrategy contentlengthstrategy)
    {
        lenStrategy = (ContentLengthStrategy)Args.notNull(contentlengthstrategy, "Content length strategy");
    }

    public HttpEntity deserialize(SessionInputBuffer sessioninputbuffer, HttpMessage httpmessage)
        throws HttpException, IOException
    {
        Args.notNull(sessioninputbuffer, "Session input buffer");
        Args.notNull(httpmessage, "HTTP message");
        return doDeserialize(sessioninputbuffer, httpmessage);
    }

    protected BasicHttpEntity doDeserialize(SessionInputBuffer sessioninputbuffer, HttpMessage httpmessage)
        throws HttpException, IOException
    {
        BasicHttpEntity basichttpentity = new BasicHttpEntity();
        long l = lenStrategy.determineLength(httpmessage);
        if (l == -2L)
        {
            basichttpentity.setChunked(true);
            basichttpentity.setContentLength(-1L);
            basichttpentity.setContent(new ChunkedInputStream(sessioninputbuffer));
        } else
        if (l == -1L)
        {
            basichttpentity.setChunked(false);
            basichttpentity.setContentLength(-1L);
            basichttpentity.setContent(new IdentityInputStream(sessioninputbuffer));
        } else
        {
            basichttpentity.setChunked(false);
            basichttpentity.setContentLength(l);
            basichttpentity.setContent(new ContentLengthInputStream(sessioninputbuffer, l));
        }
        sessioninputbuffer = httpmessage.getFirstHeader("Content-Type");
        if (sessioninputbuffer != null)
        {
            basichttpentity.setContentType(sessioninputbuffer);
        }
        sessioninputbuffer = httpmessage.getFirstHeader("Content-Encoding");
        if (sessioninputbuffer != null)
        {
            basichttpentity.setContentEncoding(sessioninputbuffer);
        }
        return basichttpentity;
    }
}
