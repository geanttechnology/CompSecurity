// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.io;

import cz.msebera.android.httpclient.HttpResponseFactory;
import cz.msebera.android.httpclient.config.MessageConstraints;
import cz.msebera.android.httpclient.impl.DefaultHttpResponseFactory;
import cz.msebera.android.httpclient.io.HttpMessageParser;
import cz.msebera.android.httpclient.io.HttpMessageParserFactory;
import cz.msebera.android.httpclient.io.SessionInputBuffer;
import cz.msebera.android.httpclient.message.BasicLineParser;
import cz.msebera.android.httpclient.message.LineParser;

// Referenced classes of package cz.msebera.android.httpclient.impl.io:
//            DefaultHttpResponseParser

public class DefaultHttpResponseParserFactory
    implements HttpMessageParserFactory
{

    public static final DefaultHttpResponseParserFactory INSTANCE = new DefaultHttpResponseParserFactory();
    private final LineParser lineParser;
    private final HttpResponseFactory responseFactory;

    public DefaultHttpResponseParserFactory()
    {
        this(null, null);
    }

    public DefaultHttpResponseParserFactory(LineParser lineparser, HttpResponseFactory httpresponsefactory)
    {
        if (lineparser == null)
        {
            lineparser = BasicLineParser.INSTANCE;
        }
        lineParser = lineparser;
        if (httpresponsefactory == null)
        {
            httpresponsefactory = DefaultHttpResponseFactory.INSTANCE;
        }
        responseFactory = httpresponsefactory;
    }

    public HttpMessageParser create(SessionInputBuffer sessioninputbuffer, MessageConstraints messageconstraints)
    {
        return new DefaultHttpResponseParser(sessioninputbuffer, lineParser, responseFactory, messageconstraints);
    }

}
